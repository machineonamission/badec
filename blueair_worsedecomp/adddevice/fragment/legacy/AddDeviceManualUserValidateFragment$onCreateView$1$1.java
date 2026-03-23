package com.blueair.adddevice.fragment.legacy;

import com.blueair.adddevice.DeviceInformationLegacy;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onCreateView$1$1", f = "AddDeviceManualUserValidateFragment.kt", i = {0, 0}, l = {68}, m = "invokeSuspend", n = {"it", "$i$a$-also-AddDeviceManualUserValidateFragment$onCreateView$1$1$1"}, s = {"L$1", "I$0"})
/* compiled from: AddDeviceManualUserValidateFragment.kt */
final class AddDeviceManualUserValidateFragment$onCreateView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AddDeviceManualUserValidateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceManualUserValidateFragment$onCreateView$1$1(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, Continuation<? super AddDeviceManualUserValidateFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceManualUserValidateFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceManualUserValidateFragment$onCreateView$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceManualUserValidateFragment$onCreateView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceInformationLegacy deviceInfo = this.this$0.getAddService().getState().getDeviceInfo();
            if (deviceInfo != null) {
                DeviceManager deviceManager = this.this$0.getDeviceManager();
                String id = deviceInfo.getId();
                this.L$0 = deviceInfo;
                this.L$1 = SpillingKt.nullOutSpilledVariable(deviceInfo);
                this.I$0 = 0;
                this.label = 1;
                if (deviceManager.removeAblDeviceRemote(id, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            DeviceInformationLegacy deviceInformationLegacy = (DeviceInformationLegacy) this.L$1;
            DeviceInformationLegacy deviceInformationLegacy2 = (DeviceInformationLegacy) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
