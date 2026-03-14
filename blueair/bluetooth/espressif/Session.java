package com.blueair.bluetooth.espressif;

import timber.log.Timber;

public class Session {
   private static final String TAG = "Espressif::Session";
   private boolean isSessionEstablished;
   private Security security;
   public SessionListener sessionListener;
   private Transport transport;

   public Session(Transport var1, Security var2) {
      this.transport = var1;
      this.security = var2;
   }

   public Security getSecurity() {
      return this.security;
   }

   public Transport getTransport() {
      return this.transport;
   }

   public void init(byte[] var1) throws RuntimeException {
      RuntimeException var10000;
      label40: {
         byte[] var10;
         try {
            StringBuilder var2 = new StringBuilder("init: response = ");
            var2.append(var1);
            Timber.d(var2.toString(), new Object[0]);
            var10 = this.security.getNextRequestInSession(var1);
            StringBuilder var3 = new StringBuilder("init: request = ");
            var3.append(var10);
            var3.append(", isSessionEstablished = ");
            var3.append(this.isSessionEstablished);
            var3.append(", sessionListener = ");
            var3.append(this.sessionListener);
            Timber.d(var3.toString(), new Object[0]);
         } catch (RuntimeException var8) {
            var10000 = var8;
            boolean var10001 = false;
            break label40;
         }

         if (var10 == null) {
            label43: {
               try {
                  this.isSessionEstablished = true;
                  var11 = this.sessionListener;
               } catch (RuntimeException var7) {
                  var10000 = var7;
                  boolean var15 = false;
                  break label43;
               }

               if (var11 == null) {
                  return;
               }

               try {
                  var11.OnSessionEstablished();
                  return;
               } catch (RuntimeException var5) {
                  var10000 = var5;
                  boolean var16 = false;
               }
            }
         } else {
            try {
               StringBuilder var13 = new StringBuilder("init: BLETransport.sendSessionData:  request = ");
               var13.append(var10);
               var13.append(", isSessionEstablished = ");
               var13.append(this.isSessionEstablished);
               var13.append(", sessionListener = ");
               var13.append(this.sessionListener);
               Timber.d(var13.toString(), new Object[0]);
               Transport var14 = this.transport;
               ResponseListener var4 = new ResponseListener(this) {
                  final Session this$0;

                  {
                     this.this$0 = var1;
                  }

                  public void onFailure(Exception var1) {
                     Timber.e(var1, "init: BLETransport.onFailure", new Object[0]);
                     if (this.this$0.sessionListener != null) {
                        this.this$0.sessionListener.OnSessionEstablishFailed(var1);
                     }

                  }

                  public void onSuccess(byte[] var1) {
                     StringBuilder var2 = new StringBuilder("init: BLETransport.onSuccess : returnData = ");
                     var2.append(var1);
                     Timber.d(var2.toString(), new Object[0]);
                     if (var1 == null) {
                        if (this.this$0.sessionListener != null) {
                           this.this$0.sessionListener.OnSessionEstablishFailed(new Exception("Session could not be established"));
                        }

                     } else {
                        this.this$0.init(var1);
                     }
                  }
               };
               var14.sendSessionData(var10, var4);
               return;
            } catch (RuntimeException var6) {
               var10000 = var6;
               boolean var17 = false;
            }
         }
      }

      RuntimeException var12 = var10000;
      Timber.e(var12, "init: failed", new Object[0]);
      if (var1 == null) {
         SessionListener var9 = this.sessionListener;
         if (var9 != null) {
            var9.OnSessionEstablishFailed(new RuntimeException("Session could not be established"));
         }
      }

   }

   public boolean isEstablished() {
      return this.isSessionEstablished;
   }

   public interface SessionListener {
      void OnSessionEstablishFailed(Exception var1);

      void OnSessionEstablished();
   }
}
