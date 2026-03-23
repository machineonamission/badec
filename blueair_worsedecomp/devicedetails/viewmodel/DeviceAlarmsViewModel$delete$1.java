package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel", f = "DeviceAlarmsViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {74, 79}, m = "delete", n = {"hasAlarm", "alarmToDelete", "targetDevice", "alarmIndex", "hasAlarm", "alarmToDelete", "targetDevice", "latestDevice", "alarmIndex"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* compiled from: DeviceAlarmsViewModel.kt */
final class DeviceAlarmsViewModel$delete$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceAlarmsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceAlarmsViewModel$delete$1(DeviceAlarmsViewModel deviceAlarmsViewModel, Continuation<? super DeviceAlarmsViewModel$delete$1> continuation) {
        super(continuation);
        this.this$0 = deviceAlarmsViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.delete((HasAlarm) null, (DeviceAlarm) null, this);
    }
}
