package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.database.DeviceField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/blueair/core/model/IndoorDatapoint;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getLatestDatapoint$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getLatestDatapoint$2 extends SuspendLambda implements Function2<IndoorDatapoint, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasAblCloudFunctions $device;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getLatestDatapoint$2(DeviceManager deviceManager, HasAblCloudFunctions hasAblCloudFunctions, Continuation<? super DeviceManager$getLatestDatapoint$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = hasAblCloudFunctions;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getLatestDatapoint$2 deviceManager$getLatestDatapoint$2 = new DeviceManager$getLatestDatapoint$2(this.this$0, this.$device, continuation);
        deviceManager$getLatestDatapoint$2.L$0 = obj;
        return deviceManager$getLatestDatapoint$2;
    }

    public final Object invoke(IndoorDatapoint indoorDatapoint, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getLatestDatapoint$2) create(indoorDatapoint, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IndoorDatapoint indoorDatapoint = (IndoorDatapoint) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateDeviceFieldAsync(this.$device.getUid(), DeviceField.LatestSensorDataPoint.INSTANCE, indoorDatapoint, DataTrend.LatestTrend.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
