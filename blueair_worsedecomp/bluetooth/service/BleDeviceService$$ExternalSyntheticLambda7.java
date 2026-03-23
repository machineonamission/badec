package com.blueair.bluetooth.service;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleDeviceService$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ BleDeviceService f$0;

    public /* synthetic */ BleDeviceService$$ExternalSyntheticLambda7(BleDeviceService bleDeviceService) {
        this.f$0 = bleDeviceService;
    }

    public final Object invoke(Object obj) {
        return BleDeviceService.pollDeviceBounded$lambda$20(this.f$0, (Throwable) obj);
    }
}
