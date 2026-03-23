package com.blueair.devicemanager;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {2376, 2376}, m = "setupDeviceLocation", n = {"locationId", "deviceIdList", "resetDeviceIdList", "locationId", "deviceIdList", "resetDeviceIdList"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setupDeviceLocation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setupDeviceLocation$1(DeviceManager deviceManager, Continuation<? super DeviceManager$setupDeviceLocation$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setupDeviceLocation((String) null, (List<String>) null, (List<String>) null, this);
    }
}
