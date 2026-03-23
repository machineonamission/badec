package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceSchedule;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/blueair/core/model/DeviceSchedule;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$Companion$getDeviceSchedules$scheduleJobs$1$1", f = "DeviceManager.kt", i = {}, l = {2610}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$Companion$getDeviceSchedules$scheduleJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DeviceSchedule>>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ DeviceManager $deviceManager;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$Companion$getDeviceSchedules$scheduleJobs$1$1(DeviceManager deviceManager, Device device, Continuation<? super DeviceManager$Companion$getDeviceSchedules$scheduleJobs$1$1> continuation) {
        super(2, continuation);
        this.$deviceManager = deviceManager;
        this.$device = device;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$Companion$getDeviceSchedules$scheduleJobs$1$1(this.$deviceManager, this.$device, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<DeviceSchedule>> continuation) {
        return ((DeviceManager$Companion$getDeviceSchedules$scheduleJobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object schedules = this.$deviceManager.getSchedules(this.$device, this);
            return schedules == coroutine_suspended ? coroutine_suspended : schedules;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
