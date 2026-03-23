package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.database.DeviceField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getDeviceLocation$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getDeviceLocation$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getDeviceLocation$2(DeviceManager deviceManager, String str, Continuation<? super DeviceManager$getDeviceLocation$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$deviceId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getDeviceLocation$2 deviceManager$getDeviceLocation$2 = new DeviceManager$getDeviceLocation$2(this.this$0, this.$deviceId, continuation);
        deviceManager$getDeviceLocation$2.L$0 = obj;
        return deviceManager$getDeviceLocation$2;
    }

    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getDeviceLocation$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager.updateDeviceFieldAsync$default(this.this$0, this.$deviceId, DeviceField.LocationId.INSTANCE, str, (DataTrend) null, 8, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
