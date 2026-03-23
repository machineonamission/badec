package com.blueair.devicedetails.viewmodel;

import com.blueair.core.PrefKeys;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicemanager.DeviceManager;
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
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$autoModeChanged$$inlined$setActuator$1", f = "DeviceDetailsViewModel.kt", i = {0, 0, 0}, l = {622}, m = "invokeSuspend", n = {"$completion", "it", "$i$a$-setActuator-DeviceDetailsViewModel$autoModeChanged$1"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsViewModel$autoModeChanged$$inlined$setActuator$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ Device $device$inlined;
    final /* synthetic */ boolean $nuMode$inlined;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel$autoModeChanged$$inlined$setActuator$1(Device device, Continuation continuation, Device device2, boolean z, DeviceDetailsViewModel deviceDetailsViewModel) {
        super(2, continuation);
        this.$device = device;
        this.$device$inlined = device2;
        this.$nuMode$inlined = z;
        this.this$0 = deviceDetailsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$autoModeChanged$$inlined$setActuator$1(this.$device, continuation, this.$device$inlined, this.$nuMode$inlined, this.this$0);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$autoModeChanged$$inlined$setActuator$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.$device;
            if (device instanceof HasFanSpeed) {
                Continuation continuation = this;
                HasFanSpeed hasFanSpeed = (HasFanSpeed) device;
                if ((this.$device$inlined instanceof HasAutoRh) && this.$nuMode$inlined && !this.this$0.autoModeClickedBefore) {
                    this.this$0._autoModeFirstClicked.postValue(Boxing.boxBoolean(true));
                    this.this$0.autoModeClickedBefore = true;
                    String format = String.format(PrefKeys.KEY_AUTO_MODE_CLICKED_BEFORE, Arrays.copyOf(new Object[]{this.$device$inlined.getUid()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    PreferencesHelper.INSTANCE.set(this.this$0.getPrefs().getBackend(), format, Boxing.boxBoolean(true), Reflection.getOrCreateKotlinClass(Boolean.class));
                }
                DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
                Device device2 = hasFanSpeed;
                AutoMode autoMode = this.$nuMode$inlined ? AutoMode.ON : AutoMode.OFF;
                this.L$0 = SpillingKt.nullOutSpilledVariable(continuation);
                this.L$1 = SpillingKt.nullOutSpilledVariable(hasFanSpeed);
                this.I$0 = 0;
                this.label = 1;
                if (DeviceManager.setAutoMode$default(access$getDeviceManager, device2, autoMode, false, this, 4, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            HasFanSpeed hasFanSpeed2 = (HasFanSpeed) this.L$1;
            Continuation continuation2 = (Continuation) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
