package com.blueair.bluetooth.espressif;

import android.util.Log;
import com.google.crypto.tink.subtle.X25519;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import espressif.Sec1;
import espressif.Sec1.Sec1MsgType;
import espressif.Sec1.Sec1Payload;
import espressif.Sec1.SessionCmd0;
import espressif.Sec1.SessionCmd1;
import espressif.Session.SecSchemeVersion;
import espressif.Session.SessionData;
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

   public Security1(String var1) {
      if (var1 != null) {
         this.proofOfPossession = var1.getBytes();
      }

   }

   private void generateKeyPair() throws InvalidKeyException {
      byte[] var1 = X25519.generatePrivateKey();
      this.privateKey = var1;
      this.publicKey = X25519.publicFromPrivate(var1);
   }

   private byte[] getStep0Request() {
      Timber.d("getStep0Request", new Object[0]);

      try {
         this.generateKeyPair();
         Sec1.SessionCmd0 var1 = (Sec1.SessionCmd0)SessionCmd0.newBuilder().setClientPubkey(ByteString.copyFrom(this.publicKey)).build();
         Sec1.Sec1Payload var3 = (Sec1.Sec1Payload)Sec1Payload.newBuilder().setSc0(var1).build();
         byte[] var4 = ((espressif.Session.SessionData)SessionData.newBuilder().setSecVer(SecSchemeVersion.SecScheme1).setSec1(var3).build()).toByteArray();
         return var4;
      } catch (InvalidKeyException var2) {
         Timber.e("getStep0Request: InvalidKeyException", new Object[0]);
         Log.e(TAG, var2.getMessage());
         return null;
      }
   }

   private byte[] getStep1Request() {
      StringBuilder var1 = new StringBuilder("getStep1Request: sessionState = ");
      var1.append(this.sessionState);
      var1.append(", clientVerify = ");
      var1.append(this.clientVerify);
      Timber.d(var1.toString(), new Object[0]);
      Sec1.SessionCmd1 var2 = (Sec1.SessionCmd1)SessionCmd1.newBuilder().setClientVerifyData(ByteString.copyFrom(this.clientVerify)).build();
      Sec1.Sec1Payload var3 = (Sec1.Sec1Payload)Sec1Payload.newBuilder().setSc1(var2).setMsg(Sec1MsgType.Session_Command1).build();
      return ((espressif.Session.SessionData)SessionData.newBuilder().setSecVer(SecSchemeVersion.SecScheme1).setSec1(var3).build()).toByteArray();
   }

   private void processStep0Response(byte[] var1) throws RuntimeException {
      InvalidProtocolBufferException var51;
      label123: {
         label124: {
            label125: {
               label126: {
                  StringBuilder var2 = new StringBuilder("processStep0Response: hexData = ");
                  var2.append(var1);
                  Timber.d(var2.toString(), new Object[0]);
                  InvalidAlgorithmParameterException var10000;
                  if (var1 != null) {
                     label109: {
                        byte[] var3;
                        byte[] var4;
                        label98: {
                           try {
                              espressif.Session.SessionData var30 = SessionData.parseFrom(var1);
                              var2 = new StringBuilder("processStep0Response: responseData = ");
                              var2.append(var30);
                              Timber.d(var2.toString(), new Object[0]);
                              if (var30.getSecVer() == SecSchemeVersion.SecScheme1) {
                                 var3 = var30.getSec1().getSr0().getDevicePubkey().toByteArray();
                                 var4 = var30.getSec1().getSr0().getDeviceRandom().toByteArray();
                                 var44 = X25519.computeSharedSecret(this.privateKey, var3);
                                 StringBuilder var32 = new StringBuilder("processStep0Response: proofOfPossession.length = ");
                                 var32.append(this.proofOfPossession.length);
                                 var32.append(", proofOfPossession = ");
                                 var32.append(this.proofOfPossession);
                                 Timber.d(var32.toString(), new Object[0]);
                                 break label98;
                              }
                           } catch (InvalidProtocolBufferException var20) {
                              var51 = var20;
                              boolean var55 = false;
                              break label123;
                           } catch (InvalidKeyException var21) {
                              var50 = var21;
                              boolean var54 = false;
                              break label124;
                           } catch (NoSuchAlgorithmException var22) {
                              var49 = var22;
                              boolean var53 = false;
                              break label125;
                           } catch (NoSuchPaddingException var23) {
                              var48 = var23;
                              boolean var52 = false;
                              break label126;
                           } catch (InvalidAlgorithmParameterException var24) {
                              var10000 = var24;
                              boolean var10001 = false;
                              break label109;
                           }

                           try {
                              RuntimeException var31 = new RuntimeException("Security version mismatch");
                              throw var31;
                           } catch (InvalidProtocolBufferException var15) {
                              var51 = var15;
                              boolean var60 = false;
                              break label123;
                           } catch (InvalidKeyException var16) {
                              var50 = var16;
                              boolean var59 = false;
                              break label124;
                           } catch (NoSuchAlgorithmException var17) {
                              var49 = var17;
                              boolean var58 = false;
                              break label125;
                           } catch (NoSuchPaddingException var18) {
                              var48 = var18;
                              boolean var57 = false;
                              break label126;
                           } catch (InvalidAlgorithmParameterException var19) {
                              var10000 = var19;
                              boolean var56 = false;
                              break label109;
                           }
                        }

                        var1 = var44;

                        try {
                           if (this.proofOfPossession.length > 0) {
                              MessageDigest var34 = MessageDigest.getInstance("SHA256");
                              var34.update(this.proofOfPossession);
                              var1 = HexEncoder.xor(var44, var34.digest());
                           }
                        } catch (InvalidProtocolBufferException var10) {
                           var51 = var10;
                           boolean var65 = false;
                           break label123;
                        } catch (InvalidKeyException var11) {
                           var50 = var11;
                           boolean var64 = false;
                           break label124;
                        } catch (NoSuchAlgorithmException var12) {
                           var49 = var12;
                           boolean var63 = false;
                           break label125;
                        } catch (NoSuchPaddingException var13) {
                           var48 = var13;
                           boolean var62 = false;
                           break label126;
                        } catch (InvalidAlgorithmParameterException var14) {
                           var10000 = var14;
                           boolean var61 = false;
                           break label109;
                        }

                        try {
                           var2 = new StringBuilder("processStep0Response: sharedKey = ");
                           var2.append(var1);
                           Timber.d(var2.toString(), new Object[0]);
                           IvParameterSpec var46 = new IvParameterSpec(var4);
                           SecretKeySpec var47 = new SecretKeySpec(var1, 0, var1.length, "AES");
                           Cipher var35 = Cipher.getInstance("AES/CTR/NoPadding");
                           this.cipher = var35;
                           var35.init(1, var47, var46);
                           this.clientVerify = this.encrypt(var3);
                           StringBuilder var36 = new StringBuilder("processStep0Response: clientVerify = ");
                           var36.append(this.clientVerify);
                           Timber.d(var36.toString(), new Object[0]);
                           return;
                        } catch (InvalidProtocolBufferException var5) {
                           var51 = var5;
                           boolean var70 = false;
                           break label123;
                        } catch (InvalidKeyException var6) {
                           var50 = var6;
                           boolean var69 = false;
                           break label124;
                        } catch (NoSuchAlgorithmException var7) {
                           var49 = var7;
                           boolean var68 = false;
                           break label125;
                        } catch (NoSuchPaddingException var8) {
                           var48 = var8;
                           boolean var67 = false;
                           break label126;
                        } catch (InvalidAlgorithmParameterException var9) {
                           var10000 = var9;
                           boolean var66 = false;
                        }
                     }
                  } else {
                     try {
                        RuntimeException var42 = new RuntimeException("No response from device");
                        throw var42;
                     } catch (InvalidProtocolBufferException var25) {
                        var51 = var25;
                        boolean var75 = false;
                        break label123;
                     } catch (InvalidKeyException var26) {
                        var50 = var26;
                        boolean var74 = false;
                        break label124;
                     } catch (NoSuchAlgorithmException var27) {
                        var49 = var27;
                        boolean var73 = false;
                        break label125;
                     } catch (NoSuchPaddingException var28) {
                        var48 = var28;
                        boolean var72 = false;
                        break label126;
                     } catch (InvalidAlgorithmParameterException var29) {
                        var10000 = var29;
                        boolean var71 = false;
                     }
                  }

                  InvalidAlgorithmParameterException var37 = var10000;
                  Timber.e("processStep0Response: InvalidAlgorithmParameterException", new Object[0]);
                  var37.printStackTrace();
                  return;
               }

               NoSuchPaddingException var38 = var48;
               Timber.e("processStep0Response: NoSuchPaddingException", new Object[0]);
               var38.printStackTrace();
               return;
            }

            NoSuchAlgorithmException var39 = var49;
            Timber.e("processStep0Response: NoSuchAlgorithmException", new Object[0]);
            Log.e(TAG, var39.getMessage());
            return;
         }

         InvalidKeyException var40 = var50;
         Timber.e("processStep0Response: InvalidKeyException", new Object[0]);
         Log.e(TAG, var40.getMessage());
         return;
      }

      InvalidProtocolBufferException var41 = var51;
      Timber.e(var41, "processStep0Response: InvalidProtocolBufferException", new Object[0]);
      Log.e(TAG, var41.getMessage());
   }

   private void processStep1Response(byte[] var1) throws RuntimeException {
      InvalidProtocolBufferException var10000;
      if (var1 == null) {
         try {
            RuntimeException var11 = new RuntimeException("No response from device");
            throw var11;
         } catch (InvalidProtocolBufferException var4) {
            var10000 = var4;
            boolean var14 = false;
         }
      } else {
         label44: {
            label38: {
               try {
                  espressif.Session.SessionData var6 = SessionData.parseFrom(var1);
                  if (var6.getSecVer() == SecSchemeVersion.SecScheme1) {
                     byte[] var8 = this.decrypt(var6.getSec1().getSr1().getDeviceVerifyData().toByteArray());
                     if (!Arrays.equals(this.publicKey, var8)) {
                        break label38;
                     }

                     return;
                  }
               } catch (InvalidProtocolBufferException var5) {
                  var10000 = var5;
                  boolean var10001 = false;
                  break label44;
               }

               try {
                  RuntimeException var7 = new RuntimeException("Security version mismatch");
                  throw var7;
               } catch (InvalidProtocolBufferException var3) {
                  var10000 = var3;
                  boolean var12 = false;
                  break label44;
               }
            }

            try {
               RuntimeException var9 = new RuntimeException("Session establishment failed !");
               throw var9;
            } catch (InvalidProtocolBufferException var2) {
               var10000 = var2;
               boolean var13 = false;
            }
         }
      }

      InvalidProtocolBufferException var10 = var10000;
      Log.e(TAG, var10.getMessage());
   }

   public byte[] decrypt(byte[] var1) {
      return this.cipher.update(var1);
   }

   public byte[] encrypt(byte[] var1) {
      return this.cipher.update(var1);
   }

   public byte[] getNextRequestInSession(byte[] var1) {
      StringBuilder var3 = new StringBuilder("getNextRequestInSession: sessionState = ");
      var3.append(this.sessionState);
      var3.append(", hexData = ");
      var3.append(var1);
      Timber.d(var3.toString(), new Object[0]);
      int var2 = this.sessionState;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 != 2) {
               return null;
            } else {
               this.sessionState = 3;
               this.processStep1Response(var1);
               return null;
            }
         } else {
            this.sessionState = 2;
            this.processStep0Response(var1);
            return this.getStep1Request();
         }
      } else {
         this.sessionState = 1;
         return this.getStep0Request();
      }
   }
}
