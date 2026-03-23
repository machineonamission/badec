package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {2090, 2093}, m = "getSchedules", n = {"device", "connection", "device", "connection", "deviceSchedules", "it", "$i$a$-runCatching-DeviceManager$getSchedules$2", "$i$a$-also-DeviceManager$getSchedules$2$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getSchedules$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getSchedules$1(DeviceManager deviceManager, Continuation<? super DeviceManager$getSchedules$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSchedules((Device) null, this);
    }
}
