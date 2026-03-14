package com.blueair.bluetooth.espressif;

public interface Security {
   byte[] decrypt(byte[] var1);

   byte[] encrypt(byte[] var1);

   byte[] getNextRequestInSession(byte[] var1);
}
