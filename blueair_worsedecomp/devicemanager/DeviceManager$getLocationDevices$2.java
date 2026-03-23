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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getLocationDevices$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getLocationDevices$2 extends SuspendLambda implements Function2<List<? extends String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $locationId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getLocationDevices$2(DeviceManager deviceManager, String str, Continuation<? super DeviceManager$getLocationDevices$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$locationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getLocationDevices$2 deviceManager$getLocationDevices$2 = new DeviceManager$getLocationDevices$2(this.this$0, this.$locationId, continuation);
        deviceManager$getLocationDevices$2.L$0 = obj;
        return deviceManager$getLocationDevices$2;
    }

    public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getLocationDevices$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<String> list = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager deviceManager = this.this$0;
            String str = this.$locationId;
            for (String updateDeviceFieldAsync$default : list) {
                DeviceManager.updateDeviceFieldAsync$default(deviceManager, updateDeviceFieldAsync$default, DeviceField.LocationId.INSTANCE, str, (DataTrend) null, 8, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
