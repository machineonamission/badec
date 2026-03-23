package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "datapoints", "", "Lcom/blueair/core/model/IndoorDatapoint;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getMonthDatapoints$2", f = "DeviceManager.kt", i = {0}, l = {1830}, m = "invokeSuspend", n = {"datapoints"}, s = {"L$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getMonthDatapoints$2 extends SuspendLambda implements Function2<List<? extends IndoorDatapoint>, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasSensorData $device;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getMonthDatapoints$2(HasSensorData hasSensorData, DeviceManager deviceManager, Continuation<? super DeviceManager$getMonthDatapoints$2> continuation) {
        super(2, continuation);
        this.$device = hasSensorData;
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getMonthDatapoints$2 deviceManager$getMonthDatapoints$2 = new DeviceManager$getMonthDatapoints$2(this.$device, this.this$0, continuation);
        deviceManager$getMonthDatapoints$2.L$0 = obj;
        return deviceManager$getMonthDatapoints$2;
    }

    public final Object invoke(List<IndoorDatapoint> list, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getMonthDatapoints$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.d("getMonthDatapoints: uid = " + this.$device.getUid() + ", success, size = " + list.size(), new Object[0]);
            if (!list.isEmpty()) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 1;
                if (this.this$0.deviceRepository.insertAndReplaceDeviceData(new DeviceData(this.$device.getUid(), list, this.this$0.prefs.isTempCelsius()), DataTrend.HistoricalTrend.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
