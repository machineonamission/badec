package com.blueair.devicemanager;

import com.blueair.core.model.DeviceScheduleMerged;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceScheduleService", f = "DeviceScheduleService.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {74}, m = "deleteMergedScheduleLocally", n = {"merged", "scheduleIds", "$this$forEach$iv", "element$iv", "scheduleId", "$i$f$forEach", "$i$a$-forEach-DeviceScheduleService$deleteMergedScheduleLocally$2"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"})
/* compiled from: DeviceScheduleService.kt */
final class DeviceScheduleService$deleteMergedScheduleLocally$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceScheduleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceScheduleService$deleteMergedScheduleLocally$1(DeviceScheduleService deviceScheduleService, Continuation<? super DeviceScheduleService$deleteMergedScheduleLocally$1> continuation) {
        super(continuation);
        this.this$0 = deviceScheduleService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteMergedScheduleLocally((DeviceScheduleMerged) null, this);
    }
}
