package com.blueair.bluetooth.espressif;

public interface Security {
    byte[] decrypt(byte[] bArr);

    byte[] encrypt(byte[] bArr);

    byte[] getNextRequestInSession(byte[] bArr);
}
