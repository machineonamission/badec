package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.FilterTrigger;
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
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$autoModeFilterTriggerChanged$2", f = "DeviceDetailsViewModel.kt", i = {0, 0}, l = {488}, m = "invokeSuspend", n = {"it", "$i$a$-let-DeviceDetailsViewModel$autoModeFilterTriggerChanged$2$1"}, s = {"L$0", "I$0"})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$autoModeFilterTriggerChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilterTrigger $nuAutoModeFilterTrigger;
    final /* synthetic */ FilterTrigger $nuG4NightModeFilterTrigger;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$autoModeFilterTriggerChanged$2(DeviceDetailsViewModel deviceDetailsViewModel, FilterTrigger filterTrigger, FilterTrigger filterTrigger2, Continuation<? super DeviceDetailsViewModel$autoModeFilterTriggerChanged$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceDetailsViewModel;
        this.$nuAutoModeFilterTrigger = filterTrigger;
        this.$nuG4NightModeFilterTrigger = filterTrigger2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$autoModeFilterTriggerChanged$2(this.this$0, this.$nuAutoModeFilterTrigger, this.$nuG4NightModeFilterTrigger, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$autoModeFilterTriggerChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Device device = this.this$0.getDevice();
            if (device != null) {
                DeviceDetailsViewModel deviceDetailsViewModel = this.this$0;
                FilterTrigger filterTrigger = this.$nuAutoModeFilterTrigger;
                FilterTrigger filterTrigger2 = this.$nuG4NightModeFilterTrigger;
                DeviceManager access$getDeviceManager = deviceDetailsViewModel.getDeviceManager();
                this.L$0 = SpillingKt.nullOutSpilledVariable(device);
                this.I$0 = 0;
                this.label = 1;
                if (access$getDeviceManager.updateAutoModeFilterTrigger(device, filterTrigger, filterTrigger2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            Device device2 = (Device) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
