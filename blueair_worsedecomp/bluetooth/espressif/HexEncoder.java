package com.blueair.bluetooth.espressif;

import com.google.common.base.Ascii;

public class HexEncoder {
    public static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i] & Ascii.SI, 16));
        }
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        int max = Math.max(bArr.length, bArr2.length);
        byte[] bArr3 = new byte[max];
        for (int i = 0; i < max; i++) {
            bArr3[i] = (byte) (bArr[i % bArr.length] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }
}
