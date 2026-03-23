package com.blueair.bluetooth.espressif;

public interface ResponseListener {
    void onFailure(Exception exc);

    void onSuccess(byte[] bArr);
}
