package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$getDevices$1", f = "DeviceDetailsViewModel.kt", i = {0, 0}, l = {307}, m = "invokeSuspend", n = {"it", "$i$a$-let-DeviceDetailsViewModel$getDevices$1$1"}, s = {"L$0", "I$0"})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$getDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<? extends Device>, Unit> $onResult;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$getDevices$1(DeviceDetailsViewModel deviceDetailsViewModel, Function1<? super List<? extends Device>, Unit> function1, Continuation<? super DeviceDetailsViewModel$getDevices$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceDetailsViewModel;
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$getDevices$1(this.this$0, this.$onResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$getDevices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<Device> devices = this.this$0.getDeviceManager().getDevices();
            Function1<List<? extends Device>, Unit> function1 = this.$onResult;
            this.L$0 = SpillingKt.nullOutSpilledVariable(devices);
            this.I$0 = 0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new DeviceDetailsViewModel$getDevices$1$1$1(function1, devices, (Continuation<? super DeviceDetailsViewModel$getDevices$1$1$1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            List list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
