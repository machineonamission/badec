package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasLocation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1", f = "DeviceDetailsViewModel.kt", i = {0}, l = {314}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$updateEverything$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$updateEverything$1(DeviceDetailsViewModel deviceDetailsViewModel, Continuation<? super DeviceDetailsViewModel$updateEverything$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceDetailsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceDetailsViewModel$updateEverything$1 deviceDetailsViewModel$updateEverything$1 = new DeviceDetailsViewModel$updateEverything$1(this.this$0, continuation);
        deviceDetailsViewModel$updateEverything$1.L$0 = obj;
        return deviceDetailsViewModel$updateEverything$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$updateEverything$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DeviceDetailsViewModel deviceDetailsViewModel;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceDetailsViewModel deviceDetailsViewModel2 = this.this$0;
            this.L$0 = coroutineScope;
            this.L$1 = deviceDetailsViewModel2;
            this.label = 1;
            Object databaseDevice = deviceDetailsViewModel2.getDeviceManager().getDatabaseDevice(this.this$0.getDeviceId(), this);
            if (databaseDevice == coroutine_suspended) {
                return coroutine_suspended;
            }
            deviceDetailsViewModel = deviceDetailsViewModel2;
            obj = databaseDevice;
        } else if (i == 1) {
            deviceDetailsViewModel = (DeviceDetailsViewModel) this.L$1;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        deviceDetailsViewModel.setDevice((Device) obj);
        Device device = this.this$0.getDevice();
        if (device != null) {
            DeviceDetailsViewModel deviceDetailsViewModel3 = this.this$0;
            if (device instanceof HasLinkingCapability) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceDetailsViewModel$updateEverything$1$1$1(deviceDetailsViewModel3, device, (Continuation<? super DeviceDetailsViewModel$updateEverything$1$1$1>) null), 3, (Object) null);
            }
            if ((device instanceof HasBlueCloudFunctions) && deviceDetailsViewModel3.isAttachedToDeviceDetailsDialogFragment()) {
                if (device instanceof HasLocation) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceDetailsViewModel$updateEverything$1$1$2(deviceDetailsViewModel3, device, (Continuation<? super DeviceDetailsViewModel$updateEverything$1$1$2>) null), 3, (Object) null);
                }
                Job unused3 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceDetailsViewModel$updateEverything$1$1$3(device, deviceDetailsViewModel3, (Continuation<? super DeviceDetailsViewModel$updateEverything$1$1$3>) null), 3, (Object) null);
                Job unused4 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceDetailsViewModel$updateEverything$1$1$4(device, deviceDetailsViewModel3, (Continuation<? super DeviceDetailsViewModel$updateEverything$1$1$4>) null), 3, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }
}
