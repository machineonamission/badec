package io.flatcircle.preferenceshelper2;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import android.util.Log;
import com.foobot.liblabclient.core.WsDefinition;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0011"}, d2 = {"Lio/flatcircle/preferenceshelper2/KeyStoreHelper;", "", "()V", "createNewKeyIfNecessary", "", "context", "Landroid/content/Context;", "keyStore", "Ljava/security/KeyStore;", "keyStoreProvider", "", "keyStoreAlias", "decryptString", "encryptedText", "encryptString", "inputValue", "getKeyStore", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: KeyStoreHelper.kt */
public final class KeyStoreHelper {
    public static final KeyStoreHelper INSTANCE = new KeyStoreHelper();

    private KeyStoreHelper() {
    }

    public final String encryptString(KeyStore keyStore, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(keyStore, "keyStore");
        Intrinsics.checkParameterIsNotNull(str, "keyStoreAlias");
        Intrinsics.checkParameterIsNotNull(str2, "inputValue");
        if (str2.length() > 0) {
            try {
                keyStore.load((KeyStore.LoadStoreParameter) null);
                Certificate certificate = keyStore.getCertificate(str);
                Intrinsics.checkExpressionValueIsNotNull(certificate, "keyStore.getCertificate(keyStoreAlias)");
                PublicKey publicKey = certificate.getPublicKey();
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
                instance.init(1, publicKey);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
                byte[] bytes = str2.getBytes(forName);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                cipherOutputStream.write(bytes);
                cipherOutputStream.close();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(vals, Base64.DEFAULT)");
                return encodeToString;
            } catch (Exception e) {
                Log.e("KeyStoreHelper", String.valueOf(e));
                return "";
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final String decryptString(KeyStore keyStore, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(keyStore, "keyStore");
        Intrinsics.checkParameterIsNotNull(str, "keyStoreAlias");
        Intrinsics.checkParameterIsNotNull(str2, "encryptedText");
        CharSequence charSequence = str2;
        if (charSequence.length() == 0) {
            return "";
        }
        if (charSequence.length() > 0) {
            try {
                Key key = keyStore.getKey(str, (char[]) null);
                if (key != null) {
                    Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance.init(2, (PrivateKey) key);
                    byte[] readBytes = ByteStreamsKt.readBytes(new CipherInputStream(new ByteArrayInputStream(Base64.decode(str2, 0)), instance));
                    return new String(readBytes, 0, readBytes.length, Charsets.UTF_8);
                }
                throw new TypeCastException("null cannot be cast to non-null type java.security.PrivateKey");
            } catch (Exception e) {
                Log.e("KeyStoreHelper", String.valueOf(e));
            }
        } else {
            Log.w("KeyStoreHelper", "decryptString() : encryptedText is null or empty.");
            return "";
        }
    }

    public final KeyStore getKeyStore(Context context, String str, String str2) throws IllegalStateException {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "keyStoreProvider");
        Intrinsics.checkParameterIsNotNull(str2, "keyStoreAlias");
        KeyStore instance = KeyStore.getInstance(str);
        instance.load((KeyStore.LoadStoreParameter) null);
        Intrinsics.checkExpressionValueIsNotNull(instance, "keyStore");
        createNewKeyIfNecessary(context, instance, str, str2);
        return instance;
    }

    private final void createNewKeyIfNecessary(Context context, KeyStore keyStore, String str, String str2) {
        if (str2.length() != 0) {
            try {
                if (!keyStore.containsAlias(str2)) {
                    Calendar instance = Calendar.getInstance();
                    Calendar instance2 = Calendar.getInstance();
                    instance2.add(1, 1);
                    KeyPairGeneratorSpec.Builder serialNumber = new KeyPairGeneratorSpec.Builder(context).setAlias(str2).setSubject(new X500Principal("CN=Sample Name, O=Android Authority")).setSerialNumber(BigInteger.ONE);
                    Intrinsics.checkExpressionValueIsNotNull(instance, WsDefinition.START);
                    KeyPairGeneratorSpec.Builder startDate = serialNumber.setStartDate(instance.getTime());
                    Intrinsics.checkExpressionValueIsNotNull(instance2, WsDefinition.END);
                    KeyPairGeneratorSpec build = startDate.setEndDate(instance2.getTime()).build();
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", str);
                    instance3.initialize(build);
                    instance3.generateKeyPair();
                }
            } catch (Exception e) {
                Log.e("KeyStoreHelper", String.valueOf(e));
            }
        } else {
            throw new IllegalStateException("You need to set the keyStoreAlias when using encryption");
        }
    }
}
