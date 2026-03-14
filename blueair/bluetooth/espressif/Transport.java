package com.blueair.bluetooth.espressif;

public interface Transport {
   void sendConfigData(String var1, byte[] var2, ResponseListener var3);

   void sendSessionData(byte[] var1, ResponseListener var2);
}
