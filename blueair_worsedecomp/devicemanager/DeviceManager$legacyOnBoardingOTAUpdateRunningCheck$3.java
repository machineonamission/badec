package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3(Continuation<? super DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3 deviceManager$legacyOnBoardingOTAUpdateRunningCheck$3 = new DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3(continuation);
        deviceManager$legacyOnBoardingOTAUpdateRunningCheck$3.L$0 = obj;
        return deviceManager$legacyOnBoardingOTAUpdateRunningCheck$3;
    }

    public final Object invoke(Throwable th, Continuation<? super Unit> continuation) {
        return ((DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$3) create(th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th = (Throwable) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.e(th, "getIsUpdating fail", new Object[0]);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
