package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.WelcomeHomeLocation;
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
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$addWelcomeHomeLocation$2$1", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$addWelcomeHomeLocation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ WelcomeHomeLocation $location;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$addWelcomeHomeLocation$2$1(DeviceManager deviceManager, Device device, WelcomeHomeLocation welcomeHomeLocation, Continuation<? super DeviceManager$addWelcomeHomeLocation$2$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = device;
        this.$location = welcomeHomeLocation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$addWelcomeHomeLocation$2$1(this.this$0, this.$device, this.$location, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$addWelcomeHomeLocation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.welcomeHomeService.addWelcomeHomeLocation(this.$device.getUid(), this.$location);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
