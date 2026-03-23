package com.blueair.android.viewmodel;

import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicemanager.DeviceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.IndoorViewModel$autoModeChanged$1", f = "IndoorViewModel.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IndoorViewModel.kt */
final class IndoorViewModel$autoModeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AutoMode $currentMode;
    final /* synthetic */ HasFanSpeed $device;
    int label;
    final /* synthetic */ IndoorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IndoorViewModel$autoModeChanged$1(IndoorViewModel indoorViewModel, HasFanSpeed hasFanSpeed, AutoMode autoMode, Continuation<? super IndoorViewModel$autoModeChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = indoorViewModel;
        this.$device = hasFanSpeed;
        this.$currentMode = autoMode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IndoorViewModel$autoModeChanged$1(this.this$0, this.$device, this.$currentMode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IndoorViewModel$autoModeChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
            Device device = this.$device;
            AutoMode autoMode = this.$currentMode == AutoMode.ON ? AutoMode.OFF : AutoMode.ON;
            this.label = 1;
            if (DeviceManager.setAutoMode$default(access$getDeviceManager, device, autoMode, false, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
