package com.blueair.devicemanager;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DataTrend;
import com.blueair.database.DeviceField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "online", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getBlueDeviceStatus$2", f = "DeviceManager.kt", i = {0, 0}, l = {533}, m = "invokeSuspend", n = {"status", "online"}, s = {"L$0", "Z$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getBlueDeviceStatus$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getBlueDeviceStatus$2(DeviceManager deviceManager, String str, Continuation<? super DeviceManager$getBlueDeviceStatus$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$deviceId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getBlueDeviceStatus$2 deviceManager$getBlueDeviceStatus$2 = new DeviceManager$getBlueDeviceStatus$2(this.this$0, this.$deviceId, continuation);
        deviceManager$getBlueDeviceStatus$2.Z$0 = ((Boolean) obj).booleanValue();
        return deviceManager$getBlueDeviceStatus$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getBlueDeviceStatus$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConnectivityStatus connectivityStatus = z ? ConnectivityStatus.ONLINE : ConnectivityStatus.OFFLINE;
            this.L$0 = SpillingKt.nullOutSpilledVariable(connectivityStatus);
            this.Z$0 = z;
            this.label = 1;
            if (this.this$0.updateDeviceField(this.$deviceId, DeviceField.ConnectivityStatus.INSTANCE, Boxing.boxInt(connectivityStatus.ordinal()), DataTrend.RealTimeTrend.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ConnectivityStatus connectivityStatus2 = (ConnectivityStatus) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
