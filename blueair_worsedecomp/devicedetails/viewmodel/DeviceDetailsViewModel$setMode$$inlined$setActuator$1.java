package com.blueair.devicedetails.viewmodel;

import com.blueair.core.PrefKeys;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.Mode;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/blueair/devicedetails/viewmodel/DeviceDetailsViewModel$setActuator$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setMode$$inlined$setActuator$1", f = "DeviceDetailsViewModel.kt", i = {0, 0, 0}, l = {622}, m = "invokeSuspend", n = {"$completion", "it", "$i$a$-setActuator-DeviceDetailsViewModel$setMode$1"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsViewModel$setMode$$inlined$setActuator$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ Device $device$inlined;
    final /* synthetic */ int $value$inlined;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel$setMode$$inlined$setActuator$1(Device device, Continuation continuation, Device device2, int i, DeviceDetailsViewModel deviceDetailsViewModel) {
        super(2, continuation);
        this.$device = device;
        this.$device$inlined = device2;
        this.$value$inlined = i;
        this.this$0 = deviceDetailsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$setMode$$inlined$setActuator$1(this.$device, continuation, this.$device$inlined, this.$value$inlined, this.this$0);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$setMode$$inlined$setActuator$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.$device;
            if (device instanceof HasMode) {
                Continuation continuation = this;
                HasMode hasMode = (HasMode) device;
                Device device2 = this.$device$inlined;
                if ((device2 instanceof HasAutoRh) && ((!(device2 instanceof HasHumMode) || ((HasHumMode) device2).getHumMode()) && this.$value$inlined == Mode.AUTO.getValue() && !this.this$0.autoModeClickedBefore)) {
                    this.this$0._autoModeFirstClicked.postValue(Boxing.boxBoolean(true));
                    this.this$0.autoModeClickedBefore = true;
                    String format = String.format(PrefKeys.KEY_AUTO_MODE_CLICKED_BEFORE, Arrays.copyOf(new Object[]{this.$device$inlined.getUid()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    PreferencesHelper.INSTANCE.set(this.this$0.getPrefs().getBackend(), format, Boxing.boxBoolean(true), Reflection.getOrCreateKotlinClass(Boolean.class));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(continuation);
                this.L$1 = SpillingKt.nullOutSpilledVariable(hasMode);
                this.I$0 = 0;
                this.label = 1;
                if (this.this$0.getDeviceManager().setMode(hasMode, this.$value$inlined, !DeviceKt.isCancellable(this.$device$inlined), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            HasMode hasMode2 = (HasMode) this.L$1;
            Continuation continuation2 = (Continuation) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
