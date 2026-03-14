package com.blueair.bluetooth.espressif;

public interface ResponseListener {
   void onFailure(Exception var1);

   void onSuccess(byte[] var1);
}
