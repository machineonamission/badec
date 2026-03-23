package com.blueair.bluetooth.service;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleDeviceService$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ BleDeviceService f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ BleDeviceService$$ExternalSyntheticLambda10(int i, BleDeviceService bleDeviceService, int i2, Function1 function1) {
        this.f$0 = i;
        this.f$1 = bleDeviceService;
        this.f$2 = i2;
        this.f$3 = function1;
    }

    public final Object invoke(Object obj) {
        return BleDeviceService.getFullWiFiList$lambda$26(this.f$0, this.f$1, this.f$2, this.f$3, (List) obj);
    }
}
