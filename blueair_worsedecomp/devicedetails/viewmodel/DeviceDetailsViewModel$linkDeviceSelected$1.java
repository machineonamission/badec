package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$linkDeviceSelected$1", f = "DeviceDetailsViewModel.kt", i = {0}, l = {390}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$linkDeviceSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceAware $linkedDevice;
    final /* synthetic */ HasLinkingCapability $parentDevice;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$linkDeviceSelected$1(HasLinkingCapability hasLinkingCapability, DeviceAware deviceAware, DeviceDetailsViewModel deviceDetailsViewModel, Continuation<? super DeviceDetailsViewModel$linkDeviceSelected$1> continuation) {
        super(2, continuation);
        this.$parentDevice = hasLinkingCapability;
        this.$linkedDevice = deviceAware;
        this.this$0 = deviceDetailsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceDetailsViewModel$linkDeviceSelected$1 deviceDetailsViewModel$linkDeviceSelected$1 = new DeviceDetailsViewModel$linkDeviceSelected$1(this.$parentDevice, this.$linkedDevice, this.this$0, continuation);
        deviceDetailsViewModel$linkDeviceSelected$1.L$0 = obj;
        return deviceDetailsViewModel$linkDeviceSelected$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$linkDeviceSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String linkedToUid = this.$parentDevice.getLinkedToUid();
            DeviceAware deviceAware = this.$linkedDevice;
            if (Intrinsics.areEqual((Object) linkedToUid, (Object) deviceAware != null ? deviceAware.getUid() : null)) {
                CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
            if (this.this$0.getDeviceManager().updateDeviceSelectedLink(this.$parentDevice, this.$linkedDevice, this) == coroutine_suspended) {
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
