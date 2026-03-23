package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.database.DeviceField;
import java.util.List;
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
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$setupDeviceLocation$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setupDeviceLocation$2 extends SuspendLambda implements Function2<ResponseBody, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $deviceIdList;
    final /* synthetic */ String $locationId;
    final /* synthetic */ List<String> $resetDeviceIdList;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setupDeviceLocation$2(List<String> list, List<String> list2, DeviceManager deviceManager, String str, Continuation<? super DeviceManager$setupDeviceLocation$2> continuation) {
        super(2, continuation);
        this.$deviceIdList = list;
        this.$resetDeviceIdList = list2;
        this.this$0 = deviceManager;
        this.$locationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$setupDeviceLocation$2(this.$deviceIdList, this.$resetDeviceIdList, this.this$0, this.$locationId, continuation);
    }

    public final Object invoke(ResponseBody responseBody, Continuation<? super Unit> continuation) {
        return ((DeviceManager$setupDeviceLocation$2) create(responseBody, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager deviceManager = this.this$0;
            String str = this.$locationId;
            for (String updateDeviceFieldAsync$default : this.$deviceIdList) {
                DeviceManager.updateDeviceFieldAsync$default(deviceManager, updateDeviceFieldAsync$default, DeviceField.LocationId.INSTANCE, str, (DataTrend) null, 8, (Object) null);
            }
            DeviceManager deviceManager2 = this.this$0;
            for (String updateDeviceFieldAsync$default2 : this.$resetDeviceIdList) {
                DeviceManager.updateDeviceFieldAsync$default(deviceManager2, updateDeviceFieldAsync$default2, DeviceField.LocationId.INSTANCE, "", (DataTrend) null, 8, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
