package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.bluetooth.service.BleDeviceService", f = "BleDeviceService.kt", i = {}, l = {409, 412, 413}, m = "connectAndEstablishSessionAndStartProvisioningSync", n = {}, s = {})
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BleDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1(BleDeviceService bleDeviceService, Continuation<? super BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1> continuation) {
        super(continuation);
        this.this$0 = bleDeviceService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.connectAndEstablishSessionAndStartProvisioningSync(this);
    }
}
