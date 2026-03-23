package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6}, l = {754, 757, 758, 761, 764, 768, 769}, m = "setAutoMode", n = {"deviceId", "connection", "auto", "deviceId", "connection", "device", "auto", "deviceId", "connection", "device", "auto", "deviceId", "connection", "device", "auto", "deviceId", "connection", "device", "auto", "deviceId", "connection", "device", "mode", "auto", "deviceId", "connection", "device", "mode", "auto"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setAutoMode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setAutoMode$1(DeviceManager deviceManager, Continuation<? super DeviceManager$setAutoMode$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setAutoMode((String) null, false, this);
    }
}
