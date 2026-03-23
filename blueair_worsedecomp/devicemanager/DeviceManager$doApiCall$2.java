package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasAblCloudFunctions;
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
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$doApiCall$2", f = "DeviceManager.kt", i = {0}, l = {419}, m = "invokeSuspend", n = {"error"}, s = {"L$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$doApiCall$2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$doApiCall$2(Device device, DeviceManager deviceManager, Continuation<? super DeviceManager$doApiCall$2> continuation) {
        super(2, continuation);
        this.$device = device;
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$doApiCall$2 deviceManager$doApiCall$2 = new DeviceManager$doApiCall$2(this.$device, this.this$0, continuation);
        deviceManager$doApiCall$2.L$0 = obj;
        return deviceManager$doApiCall$2;
    }

    public final Object invoke(Throwable th, Continuation<? super Unit> continuation) {
        return ((DeviceManager$doApiCall$2) create(th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th = (Throwable) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.$device;
            if ((device instanceof HasAblCloudFunctions) && !(th instanceof CancellationException)) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (this.this$0.getAttributes((HasAblCloudFunctions) device, this) == coroutine_suspended) {
                    return coroutine_suspended;
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
