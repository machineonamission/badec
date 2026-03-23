package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasSensorData;
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
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$updateDevice$1", f = "DeviceSensorsViewModel.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSensorsViewModel.kt */
final class DeviceSensorsViewModel$updateDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasSensorData $device;
    int label;
    final /* synthetic */ DeviceSensorsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSensorsViewModel$updateDevice$1(DeviceSensorsViewModel deviceSensorsViewModel, HasSensorData hasSensorData, Continuation<? super DeviceSensorsViewModel$updateDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceSensorsViewModel;
        this.$device = hasSensorData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSensorsViewModel$updateDevice$1(this.this$0, this.$device, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSensorsViewModel$updateDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OutdoorService access$getOutdoorService = this.this$0.getOutdoorService();
            String locationId = ((HasLocation) this.$device).getLocationId();
            if (locationId == null) {
                locationId = "";
            }
            this.label = 1;
            obj = access$getOutdoorService.getTrackedLocation(locationId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0._liveLocation.postValue((TrackedLocation) obj);
        return Unit.INSTANCE;
    }
}
