package com.blueair.devicedetails.activity;

import com.blueair.core.model.DeviceScheduleMerged;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.activity.ScheduleListActivity$configure$5$1", f = "ScheduleListActivity.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ScheduleListActivity.kt */
final class ScheduleListActivity$configure$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $checked;
    final /* synthetic */ DeviceScheduleMerged $tappedSchedule;
    int label;
    final /* synthetic */ ScheduleListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScheduleListActivity$configure$5$1(ScheduleListActivity scheduleListActivity, DeviceScheduleMerged deviceScheduleMerged, boolean z, Continuation<? super ScheduleListActivity$configure$5$1> continuation) {
        super(2, continuation);
        this.this$0 = scheduleListActivity;
        this.$tappedSchedule = deviceScheduleMerged;
        this.$checked = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScheduleListActivity$configure$5$1(this.this$0, this.$tappedSchedule, this.$checked, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScheduleListActivity$configure$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getViewModel().updateScheduleSwitch(this.$tappedSchedule, !this.$checked, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
