package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.DeviceScheduleMerged;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel", f = "DeviceSchedulesViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {52, 53}, m = "updateScheduleSwitch", n = {"scheduleMerged", "deviceSchedule", "paused", "scheduleMerged", "deviceSchedule", "latestDevice", "paused"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
/* compiled from: DeviceSchedulesViewModel.kt */
final class DeviceSchedulesViewModel$updateScheduleSwitch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceSchedulesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSchedulesViewModel$updateScheduleSwitch$1(DeviceSchedulesViewModel deviceSchedulesViewModel, Continuation<? super DeviceSchedulesViewModel$updateScheduleSwitch$1> continuation) {
        super(continuation);
        this.this$0 = deviceSchedulesViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateScheduleSwitch((DeviceScheduleMerged) null, false, this);
    }
}
