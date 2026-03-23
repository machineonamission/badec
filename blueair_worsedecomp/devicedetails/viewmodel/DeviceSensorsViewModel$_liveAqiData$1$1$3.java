package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
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
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$_liveAqiData$1$1$3", f = "DeviceSensorsViewModel.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSensorsViewModel.kt */
final class DeviceSensorsViewModel$_liveAqiData$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrackedLocation $newLocation;
    int label;
    final /* synthetic */ DeviceSensorsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSensorsViewModel$_liveAqiData$1$1$3(DeviceSensorsViewModel deviceSensorsViewModel, TrackedLocation trackedLocation, Continuation<? super DeviceSensorsViewModel$_liveAqiData$1$1$3> continuation) {
        super(2, continuation);
        this.this$0 = deviceSensorsViewModel;
        this.$newLocation = trackedLocation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSensorsViewModel$_liveAqiData$1$1$3(this.this$0, this.$newLocation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSensorsViewModel$_liveAqiData$1$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (OutdoorService.fetchAqiData$default(this.this$0.getOutdoorService(), this.$newLocation, false, this, 2, (Object) null) == coroutine_suspended) {
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
