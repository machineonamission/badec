package com.blueair.devicemanager;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DataTrend;
import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.database.DeviceField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getIsUpdating$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getIsUpdating$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasAblCloudFunctions $device;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getIsUpdating$2(DeviceManager deviceManager, HasAblCloudFunctions hasAblCloudFunctions, Continuation<? super DeviceManager$getIsUpdating$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = hasAblCloudFunctions;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getIsUpdating$2 deviceManager$getIsUpdating$2 = new DeviceManager$getIsUpdating$2(this.this$0, this.$device, continuation);
        deviceManager$getIsUpdating$2.Z$0 = ((Boolean) obj).booleanValue();
        return deviceManager$getIsUpdating$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getIsUpdating$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.d("getIsUpdating success = " + z, new Object[0]);
            DeviceManager deviceManager = this.this$0;
            String uid = this.$device.getUid();
            DeviceField deviceField = DeviceField.ConnectivityStatus.INSTANCE;
            if (z) {
                i = ConnectivityStatus.UPDATING.ordinal();
            } else {
                i = this.$device.getConnectivityStatusIndex();
            }
            DeviceManager.updateDeviceFieldAsync$default(deviceManager, uid, deviceField, Boxing.boxInt(i), (DataTrend) null, 8, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
