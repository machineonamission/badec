package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceScheduleService", f = "DeviceScheduleService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {34, 36, 51, 52}, m = "updateSchedule", n = {"device", "schedule", "editingSchedule", "schedule", "mergedSchedule", "$i$a$-let-DeviceScheduleService$updateSchedule$2", "device", "schedule", "editingSchedule", "schedule", "mergedSchedule", "$i$a$-let-DeviceScheduleService$updateSchedule$2", "device", "schedule", "editingSchedule", "schedule", "modifiedSchedule", "device", "schedule", "editingSchedule", "schedule", "modifiedSchedule"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: DeviceScheduleService.kt */
final class DeviceScheduleService$updateSchedule$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceScheduleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceScheduleService$updateSchedule$1(DeviceScheduleService deviceScheduleService, Continuation<? super DeviceScheduleService$updateSchedule$1> continuation) {
        super(continuation);
        this.this$0 = deviceScheduleService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSchedule((Device) null, (DeviceSchedule) null, (DeviceScheduleMerged) null, this);
    }
}
