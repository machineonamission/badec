package com.blueair.devicemanager;

import com.blueair.core.model.HasFanSpeed;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {1043, 1046, 1054, 1033}, m = "updateFanSpeed", n = {"device", "connection", "currentFanSpeed", "nuFanSpeed", "nuAutoMode", "shouldSetAutoInstead", "device", "connection", "currentFanSpeed", "nuFanSpeed", "nuAutoMode", "shouldSetAutoInstead", "device", "connection", "currentFanSpeed", "nuFanSpeed", "shouldSetAutoInstead", "device", "connection", "currentFanSpeed", "nuFanSpeed", "shouldSetAutoInstead"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateFanSpeed$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$updateFanSpeed$1(DeviceManager deviceManager, Continuation<? super DeviceManager$updateFanSpeed$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateFanSpeed((HasFanSpeed) null, this);
    }
}
