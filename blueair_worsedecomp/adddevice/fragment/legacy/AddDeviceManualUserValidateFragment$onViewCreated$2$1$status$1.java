package com.blueair.adddevice.fragment.legacy;

import com.blueair.adddevice.DeviceInformationLegacy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1", f = "AddDeviceManualUserValidateFragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceManualUserValidateFragment.kt */
final class AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ DeviceInformationLegacy $it;
    int label;
    final /* synthetic */ AddDeviceManualUserValidateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, DeviceInformationLegacy deviceInformationLegacy, Continuation<? super AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1> continuation) {
        super(1, continuation);
        this.this$0 = addDeviceManualUserValidateFragment;
        this.$it = deviceInformationLegacy;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(Continuation<? super Boolean> continuation) {
        return ((AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object fetchDeviceStatus = this.this$0.getAddService().fetchDeviceStatus(this.$it.getId(), this);
            return fetchDeviceStatus == coroutine_suspended ? coroutine_suspended : fetchDeviceStatus;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
