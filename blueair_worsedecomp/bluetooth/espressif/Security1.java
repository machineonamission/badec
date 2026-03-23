package com.blueair.bluetooth.espressif;

import android.util.Log;
import com.google.crypto.tink.subtle.X25519;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import espressif.Sec1;
import espressif.Session;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import timber.log.Timber;

public class Security1 implements Security {
    private static final int SESSION_STATE_FINISHED = 3;
    private static final int SESSION_STATE_REQUEST1 = 0;
    private static final int SESSION_STATE_RESPONSE1_REQUEST2 = 1;
    private static final int SESSION_STATE_RESPONSE2 = 2;
    private static final String TAG = "Espressif::Security1";
    private Cipher cipher;
    private byte[] clientVerify = null;
    private byte[] privateKey = null;
    private byte[] proofOfPossession = null;
    private byte[] publicKey = null;
    private int sessionState = 0;

    public Security1(String str) {
        if (str != null) {
            this.proofOfPossession = str.getBytes();
        }
    }

    public byte[] getNextRequestInSession(byte[] bArr) {
        Timber.d("getNextRequestInSession: sessionState = " + this.sessionState + ", hexData = " + bArr, new Object[0]);
        int i = this.sessionState;
        if (i == 0) {
            this.sessionState = 1;
            return getStep0Request();
        } else if (i == 1) {
            this.sessionState = 2;
            processStep0Response(bArr);
            return getStep1Request();
        } else if (i != 2) {
            return null;
        } else {
            this.sessionState = 3;
            processStep1Response(bArr);
            return null;
        }
    }

    private byte[] getStep0Request() {
        Timber.d("getStep0Request", new Object[0]);
        try {
            generateKeyPair();
            Sec1.Sec1Payload.Builder newBuilder = Sec1.Sec1Payload.newBuilder();
            return ((Session.SessionData) Session.SessionData.newBuilder().setSecVer(Session.SecSchemeVersion.SecScheme1).setSec1((Sec1.Sec1Payload) newBuilder.setSc0((Sec1.SessionCmd0) Sec1.SessionCmd0.newBuilder().setClientPubkey(ByteString.copyFrom(this.publicKey)).build()).build()).build()).toByteArray();
        } catch (InvalidKeyException e) {
            Timber.e("getStep0Request: InvalidKeyException", new Object[0]);
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    private byte[] getStep1Request() {
        Timber.d("getStep1Request: sessionState = " + this.sessionState + ", clientVerify = " + this.clientVerify, new Object[0]);
        Sec1.Sec1Payload.Builder newBuilder = Sec1.Sec1Payload.newBuilder();
        return ((Session.SessionData) Session.SessionData.newBuilder().setSecVer(Session.SecSchemeVersion.SecScheme1).setSec1((Sec1.Sec1Payload) newBuilder.setSc1((Sec1.SessionCmd1) Sec1.SessionCmd1.newBuilder().setClientVerifyData(ByteString.copyFrom(this.clientVerify)).build()).setMsg(Sec1.Sec1MsgType.Session_Command1).build()).build()).toByteArray();
    }

    private void processStep0Response(byte[] bArr) throws RuntimeException {
        Timber.d("processStep0Response: hexData = " + bArr, new Object[0]);
        if (bArr != null) {
            try {
                Session.SessionData parseFrom = Session.SessionData.parseFrom(bArr);
                Timber.d("processStep0Response: responseData = " + parseFrom, new Object[0]);
                if (parseFrom.getSecVer() == Session.SecSchemeVersion.SecScheme1) {
                    byte[] byteArray = parseFrom.getSec1().getSr0().getDevicePubkey().toByteArray();
                    byte[] byteArray2 = parseFrom.getSec1().getSr0().getDeviceRandom().toByteArray();
                    byte[] computeSharedSecret = X25519.computeSharedSecret(this.privateKey, byteArray);
                    Timber.d("processStep0Response: proofOfPossession.length = " + this.proofOfPossession.length + ", proofOfPossession = " + this.proofOfPossession, new Object[0]);
                    if (this.proofOfPossession.length > 0) {
                        MessageDigest instance = MessageDigest.getInstance("SHA256");
                        instance.update(this.proofOfPossession);
                        computeSharedSecret = HexEncoder.xor(computeSharedSecret, instance.digest());
                    }
                    Timber.d("processStep0Response: sharedKey = " + computeSharedSecret, new Object[0]);
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(byteArray2);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(computeSharedSecret, 0, computeSharedSecret.length, "AES");
                    Cipher instance2 = Cipher.getInstance("AES/CTR/NoPadding");
                    this.cipher = instance2;
                    instance2.init(1, secretKeySpec, ivParameterSpec);
                    this.clientVerify = encrypt(byteArray);
                    Timber.d("processStep0Response: clientVerify = " + this.clientVerify, new Object[0]);
                    return;
                }
                throw new RuntimeException("Security version mismatch");
            } catch (InvalidProtocolBufferException e) {
                Timber.e(e, "processStep0Response: InvalidProtocolBufferException", new Object[0]);
                Log.e(TAG, e.getMessage());
            } catch (InvalidKeyException e2) {
                Timber.e("processStep0Response: InvalidKeyException", new Object[0]);
                Log.e(TAG, e2.getMessage());
            } catch (NoSuchAlgorithmException e3) {
                Timber.e("processStep0Response: NoSuchAlgorithmException", new Object[0]);
                Log.e(TAG, e3.getMessage());
            } catch (NoSuchPaddingException e4) {
                Timber.e("processStep0Response: NoSuchPaddingException", new Object[0]);
                e4.printStackTrace();
            } catch (InvalidAlgorithmParameterException e5) {
                Timber.e("processStep0Response: InvalidAlgorithmParameterException", new Object[0]);
                e5.printStackTrace();
            }
        } else {
            throw new RuntimeException("No response from device");
        }
    }

    private void processStep1Response(byte[] bArr) throws RuntimeException {
        if (bArr != null) {
            try {
                Session.SessionData parseFrom = Session.SessionData.parseFrom(bArr);
                if (parseFrom.getSecVer() == Session.SecSchemeVersion.SecScheme1) {
                    if (!Arrays.equals(this.publicKey, decrypt(parseFrom.getSec1().getSr1().getDeviceVerifyData().toByteArray()))) {
                        throw new RuntimeException("Session establishment failed !");
                    }
                    return;
                }
                throw new RuntimeException("Security version mismatch");
            } catch (InvalidProtocolBufferException e) {
                Log.e(TAG, e.getMessage());
            }
        } else {
            throw new RuntimeException("No response from device");
        }
    }

    private void generateKeyPair() throws InvalidKeyException {
        byte[] generatePrivateKey = X25519.generatePrivateKey();
        this.privateKey = generatePrivateKey;
        this.publicKey = X25519.publicFromPrivate(generatePrivateKey);
    }

    public byte[] encrypt(byte[] bArr) {
        return this.cipher.update(bArr);
    }

    public byte[] decrypt(byte[] bArr) {
        return this.cipher.update(bArr);
    }
}
