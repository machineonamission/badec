package com.blueair.bluetooth.service;

import custom.CustomCommands;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleDeviceService$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ BleDeviceService f$0;
    public final /* synthetic */ BleDeviceState f$1;
    public final /* synthetic */ ProvisionConfig f$2;
    public final /* synthetic */ Continuation f$3;

    public /* synthetic */ BleDeviceService$$ExternalSyntheticLambda13(BleDeviceService bleDeviceService, BleDeviceState bleDeviceState, ProvisionConfig provisionConfig, Continuation continuation) {
        this.f$0 = bleDeviceService;
        this.f$1 = bleDeviceState;
        this.f$2 = provisionConfig;
        this.f$3 = continuation;
    }

    public final Object invoke(Object obj) {
        return BleDeviceService.configureProvisionStep$lambda$11(this.f$0, this.f$1, this.f$2, this.f$3, (CustomCommands.CommandWrapper) obj);
    }
}
