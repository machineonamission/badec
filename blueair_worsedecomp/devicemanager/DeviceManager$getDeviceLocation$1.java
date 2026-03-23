package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 1}, l = {2387, 2387}, m = "getDeviceLocation", n = {"deviceId", "deviceId"}, s = {"L$0", "L$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getDeviceLocation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getDeviceLocation$1(DeviceManager deviceManager, Continuation<? super DeviceManager$getDeviceLocation$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDeviceLocation((String) null, this);
    }
}
