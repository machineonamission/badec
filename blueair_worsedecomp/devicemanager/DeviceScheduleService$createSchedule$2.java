package com.blueair.devicemanager;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.HasBlueCloudFunctions;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceScheduleService$createSchedule$2", f = "DeviceScheduleService.kt", i = {0}, l = {22}, m = "invokeSuspend", n = {"modifiedSchedule"}, s = {"L$0"})
/* compiled from: DeviceScheduleService.kt */
final class DeviceScheduleService$createSchedule$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ DeviceSchedule $schedule;
    Object L$0;
    int label;
    final /* synthetic */ DeviceScheduleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceScheduleService$createSchedule$2(Device device, DeviceSchedule deviceSchedule, DeviceScheduleService deviceScheduleService, Continuation<? super DeviceScheduleService$createSchedule$2> continuation) {
        super(2, continuation);
        this.$device = device;
        this.$schedule = deviceSchedule;
        this.this$0 = deviceScheduleService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceScheduleService$createSchedule$2(this.$device, this.$schedule, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceScheduleService$createSchedule$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DeviceSchedule deviceSchedule;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.$device;
            if (device instanceof HasBlueCloudFunctions) {
                DeviceSchedule deviceSchedule2 = this.$schedule;
                String id = Device.CC.getTimezone$default(device, (Context) null, 1, (Object) null).getID();
                Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
                deviceSchedule = DeviceSchedule.copy$default(deviceSchedule2, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, false, (Set) null, id, (List) null, (String) null, 1791, (Object) null);
            } else {
                deviceSchedule = this.$schedule;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(deviceSchedule);
            this.label = 1;
            if (this.this$0.deviceManager.createSchedule(this.$device, deviceSchedule, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            DeviceSchedule deviceSchedule3 = (DeviceSchedule) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
