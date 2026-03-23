package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicemanager.DeviceManager;
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
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setApSubMode$$inlined$setActuator$1", f = "DeviceDetailsViewModel.kt", i = {0, 0, 0}, l = {616}, m = "invokeSuspend", n = {"$completion", "it", "$i$a$-setActuator-DeviceDetailsViewModel$setApSubMode$1"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsViewModel$setApSubMode$$inlined$setActuator$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ boolean $overwriteMainMode$inlined;
    final /* synthetic */ int $value$inlined;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel$setApSubMode$$inlined$setActuator$1(Device device, Continuation continuation, DeviceDetailsViewModel deviceDetailsViewModel, int i, boolean z) {
        super(2, continuation);
        this.$device = device;
        this.this$0 = deviceDetailsViewModel;
        this.$value$inlined = i;
        this.$overwriteMainMode$inlined = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$setApSubMode$$inlined$setActuator$1(this.$device, continuation, this.this$0, this.$value$inlined, this.$overwriteMainMode$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$setApSubMode$$inlined$setActuator$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.$device;
            if (device instanceof HasMainMode) {
                Continuation continuation = this;
                HasMainMode hasMainMode = (HasMainMode) device;
                DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
                int i2 = this.$value$inlined;
                boolean z = this.$overwriteMainMode$inlined && !hasMainMode.isInMainMode(MainMode.AirPurify);
                this.L$0 = SpillingKt.nullOutSpilledVariable(continuation);
                this.L$1 = SpillingKt.nullOutSpilledVariable(hasMainMode);
                this.I$0 = 0;
                this.label = 1;
                if (DeviceManager.setApSubMode$default(access$getDeviceManager, hasMainMode, i2, false, z, this, 4, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            HasMainMode hasMainMode2 = (HasMainMode) this.L$1;
            Continuation continuation2 = (Continuation) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
