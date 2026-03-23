package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.database.DeviceField;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$setDeviceTimezone$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setDeviceTimezone$2 extends SuspendLambda implements Function2<ResponseBody, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $deviceIdList;
    final /* synthetic */ TimeZone $validTimezone;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setDeviceTimezone$2(List<String> list, DeviceManager deviceManager, TimeZone timeZone, Continuation<? super DeviceManager$setDeviceTimezone$2> continuation) {
        super(2, continuation);
        this.$deviceIdList = list;
        this.this$0 = deviceManager;
        this.$validTimezone = timeZone;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$setDeviceTimezone$2(this.$deviceIdList, this.this$0, this.$validTimezone, continuation);
    }

    public final Object invoke(ResponseBody responseBody, Continuation<? super Unit> continuation) {
        return ((DeviceManager$setDeviceTimezone$2) create(responseBody, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager deviceManager = this.this$0;
            TimeZone timeZone = this.$validTimezone;
            for (String updateDeviceFieldAsync$default : this.$deviceIdList) {
                DeviceManager.updateDeviceFieldAsync$default(deviceManager, updateDeviceFieldAsync$default, DeviceField.DeviceTimezone.INSTANCE, timeZone.getID(), (DataTrend) null, 8, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
