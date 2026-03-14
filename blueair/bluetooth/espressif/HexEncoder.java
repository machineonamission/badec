package com.blueair.bluetooth.espressif;

public class HexEncoder {
   public static String byteArrayToHexString(byte[] var0) {
      StringBuilder var2 = new StringBuilder();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.append(Character.forDigit(var0[var1] >> 4 & 15, 16));
         var2.append(Character.forDigit(var0[var1] & 15, 16));
      }

      return var2.toString();
   }

   public static byte[] hexStringToByteArray(String var0) {
      int var2 = var0.length();
      byte[] var3 = new byte[var2 / 2];

      for(int var1 = 0; var1 < var2; var1 += 2) {
         var3[var1 / 2] = (byte)((Character.digit(var0.charAt(var1), 16) << 4) + Character.digit(var0.charAt(var1 + 1), 16));
      }

      return var3;
   }

   public static byte[] xor(byte[] var0, byte[] var1) {
      int var3 = Math.max(var0.length, var1.length);
      byte[] var4 = new byte[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         var4[var2] = (byte)(var0[var2 % var0.length] ^ var1[var2 % var1.length]);
      }

      return var4;
   }
}
