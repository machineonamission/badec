package com.blueair.devicemanager;

import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.core.model.HasFanSpeed;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "error", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$updateFanSpeed$5", f = "DeviceManager.kt", i = {0}, l = {1057}, m = "invokeSuspend", n = {"error"}, s = {"L$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateFanSpeed$5 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasFanSpeed $device;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$updateFanSpeed$5(HasFanSpeed hasFanSpeed, DeviceManager deviceManager, Continuation<? super DeviceManager$updateFanSpeed$5> continuation) {
        super(2, continuation);
        this.$device = hasFanSpeed;
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$updateFanSpeed$5 deviceManager$updateFanSpeed$5 = new DeviceManager$updateFanSpeed$5(this.$device, this.this$0, continuation);
        deviceManager$updateFanSpeed$5.L$0 = obj;
        return deviceManager$updateFanSpeed$5;
    }

    public final Object invoke(Throwable th, Continuation<? super Unit> continuation) {
        return ((DeviceManager$updateFanSpeed$5) create(th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th = (Throwable) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(th instanceof CancellationException)) {
                HasFanSpeed hasFanSpeed = this.$device;
                if (hasFanSpeed instanceof HasAblCloudFunctions) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                    this.label = 1;
                    if (this.this$0.getAttributes((HasAblCloudFunctions) hasFanSpeed, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
