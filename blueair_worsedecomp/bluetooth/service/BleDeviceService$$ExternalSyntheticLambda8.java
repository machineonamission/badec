package com.blueair.bluetooth.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleDeviceService$$ExternalSyntheticLambda8 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BleDeviceService$$ExternalSyntheticLambda8(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        BleDeviceService.pollDeviceBounded$lambda$21(this.f$0, obj);
    }
}
