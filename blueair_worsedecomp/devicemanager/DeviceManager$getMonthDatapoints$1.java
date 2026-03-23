package com.blueair.devicemanager;

import com.blueair.core.model.HasSensorData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {1825, 1827, 1827}, m = "getMonthDatapoints", n = {"device", "connection", "calendar", "latestPointsFetchedTime", "monthAgoTime", "latestTime", "device", "connection", "calendar", "latestPointsFetchedTime", "monthAgoTime", "latestTime", "device", "connection", "calendar", "latestPointsFetchedTime", "monthAgoTime", "latestTime"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getMonthDatapoints$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getMonthDatapoints$1(DeviceManager deviceManager, Continuation<? super DeviceManager$getMonthDatapoints$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMonthDatapoints((HasSensorData) null, this);
    }
}
