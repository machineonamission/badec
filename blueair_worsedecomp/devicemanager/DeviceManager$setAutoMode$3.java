package com.blueair.devicemanager;

import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6}, l = {794, 798, 799, 810, 817, 837, 838}, m = "setAutoMode", n = {"device", "nuAutoMode", "connection", "triggeredByEco", "device", "nuAutoMode", "connection", "triggeredByEco", "device", "nuAutoMode", "connection", "triggeredByEco", "device", "nuAutoMode", "connection", "triggeredByEco", "previousFanSpeed", "device", "nuAutoMode", "connection", "triggeredByEco", "device", "nuAutoMode", "connection", "triggeredByEco", "device", "nuAutoMode", "connection", "triggeredByEco"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setAutoMode$3 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setAutoMode$3(DeviceManager deviceManager, Continuation<? super DeviceManager$setAutoMode$3> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setAutoMode((Device) null, (AutoMode) null, false, this);
    }
}
