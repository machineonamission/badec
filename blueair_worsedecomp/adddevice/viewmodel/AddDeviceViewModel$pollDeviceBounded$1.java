package com.blueair.adddevice.viewmodel;

import com.blueair.bluetooth.service.BleDeviceService;
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
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.AddDeviceViewModel$pollDeviceBounded$1", f = "AddDeviceViewModel.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceViewModel.kt */
final class AddDeviceViewModel$pollDeviceBounded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceViewModel$pollDeviceBounded$1(AddDeviceViewModel addDeviceViewModel, Continuation<? super AddDeviceViewModel$pollDeviceBounded$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceViewModel$pollDeviceBounded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceViewModel$pollDeviceBounded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AddDeviceViewModel addDeviceViewModel;
        boolean z;
        AddDeviceViewModel addDeviceViewModel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            addDeviceViewModel = this.this$0;
            BleDeviceService access$getSelectedBleDeviceService$p = addDeviceViewModel.selectedBleDeviceService;
            if (access$getSelectedBleDeviceService$p != null) {
                this.L$0 = addDeviceViewModel;
                this.label = 1;
                Object pollDeviceBounded = access$getSelectedBleDeviceService$p.pollDeviceBounded(this);
                if (pollDeviceBounded == coroutine_suspended) {
                    return coroutine_suspended;
                }
                addDeviceViewModel2 = addDeviceViewModel;
                obj = pollDeviceBounded;
            } else {
                z = false;
                addDeviceViewModel.setPolling(z);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            addDeviceViewModel2 = (AddDeviceViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AddDeviceViewModel addDeviceViewModel3 = addDeviceViewModel2;
        z = ((Boolean) obj).booleanValue();
        addDeviceViewModel = addDeviceViewModel3;
        addDeviceViewModel.setPolling(z);
        return Unit.INSTANCE;
    }
}
