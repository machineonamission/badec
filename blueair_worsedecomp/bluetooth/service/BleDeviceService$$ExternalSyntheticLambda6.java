package com.blueair.bluetooth.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleDeviceService$$ExternalSyntheticLambda6 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BleDeviceService$$ExternalSyntheticLambda6(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        BleDeviceService.pollDeviceBounded$lambda$19(this.f$0, obj);
    }
}
