package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$delete$1", f = "DeviceCreateEditScheduleViewModel.kt", i = {}, l = {1012}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceCreateEditScheduleViewModel.kt */
final class DeviceCreateEditScheduleViewModel$delete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ Function1<Boolean, Unit> $onComplete;
    final /* synthetic */ DeviceScheduleMerged $scheduleToDelete;
    int label;
    final /* synthetic */ DeviceCreateEditScheduleViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceCreateEditScheduleViewModel$delete$1(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, Device device, DeviceScheduleMerged deviceScheduleMerged, Function1<? super Boolean, Unit> function1, Continuation<? super DeviceCreateEditScheduleViewModel$delete$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceCreateEditScheduleViewModel;
        this.$device = device;
        this.$scheduleToDelete = deviceScheduleMerged;
        this.$onComplete = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceCreateEditScheduleViewModel$delete$1(this.this$0, this.$device, this.$scheduleToDelete, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceCreateEditScheduleViewModel$delete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getDeviceScheduleService().deleteMergedSchedule(this.$device, this.$scheduleToDelete, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$onComplete.invoke(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
