package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.devicemanager.DeviceManager;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$4", f = "DeviceDetailsViewModel.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$updateEverything$1$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$updateEverything$1$1$4(Device device, DeviceDetailsViewModel deviceDetailsViewModel, Continuation<? super DeviceDetailsViewModel$updateEverything$1$1$4> continuation) {
        super(2, continuation);
        this.$device = device;
        this.this$0 = deviceDetailsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$updateEverything$1$1$4(this.$device, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$updateEverything$1$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.d("get device timezone: " + this.$device.getUid(), new Object[0]);
            DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
            String uid = this.$device.getUid();
            TimeZone timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
            this.label = 1;
            if (access$getDeviceManager.getDeviceTimezone(uid, timeZone, this.this$0.getApplication(), this) == coroutine_suspended) {
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
