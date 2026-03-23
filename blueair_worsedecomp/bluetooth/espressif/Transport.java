package com.blueair.bluetooth.espressif;

public interface Transport {
    void sendConfigData(String str, byte[] bArr, ResponseListener responseListener);

    void sendSessionData(byte[] bArr, ResponseListener responseListener);
}
