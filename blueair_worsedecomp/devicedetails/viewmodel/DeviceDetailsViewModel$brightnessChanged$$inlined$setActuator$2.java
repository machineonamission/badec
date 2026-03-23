package com.blueair.devicedetails.viewmodel;

import com.blueair.api.restapi.SimpleResponse;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.devicemanager.DeviceManager;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/blueair/devicedetails/viewmodel/DeviceDetailsViewModel$setActuator$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$2", f = "DeviceDetailsViewModel.kt", i = {0, 0, 0}, l = {616}, m = "invokeSuspend", n = {"$completion", "it", "$i$a$-setActuator-DeviceDetailsViewModel$brightnessChanged$2"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $brightness$inlined;
    final /* synthetic */ Device $device;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$2(Device device, Continuation continuation, DeviceDetailsViewModel deviceDetailsViewModel, int i) {
        super(2, continuation);
        this.$device = device;
        this.this$0 = deviceDetailsViewModel;
        this.$brightness$inlined = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$2(this.$device, continuation, this.this$0, this.$brightness$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.$device;
            if (device instanceof HasBrightness) {
                HasBrightness hasBrightness = (HasBrightness) device;
                DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
                int i2 = this.$brightness$inlined;
                this.L$0 = SpillingKt.nullOutSpilledVariable(this);
                this.L$1 = SpillingKt.nullOutSpilledVariable(hasBrightness);
                this.I$0 = 0;
                this.label = 1;
                if (access$getDeviceManager.updateBrightness(hasBrightness, i2, (Continuation<? super ApiResult<SimpleResponse>>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            HasBrightness hasBrightness2 = (HasBrightness) this.L$1;
            Continuation continuation = (Continuation) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
