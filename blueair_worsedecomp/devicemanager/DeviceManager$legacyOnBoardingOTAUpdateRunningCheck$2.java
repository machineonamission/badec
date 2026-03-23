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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceUUID;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2(DeviceManager deviceManager, String str, Continuation<? super DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$deviceUUID = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2 deviceManager$legacyOnBoardingOTAUpdateRunningCheck$2 = new DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2(this.this$0, this.$deviceUUID, continuation);
        deviceManager$legacyOnBoardingOTAUpdateRunningCheck$2.Z$0 = ((Boolean) obj).booleanValue();
        return deviceManager$legacyOnBoardingOTAUpdateRunningCheck$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((DeviceManager$legacyOnBoardingOTAUpdateRunningCheck$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
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
            String str = this.$deviceUUID;
            DeviceField deviceField = DeviceField.ConnectivityStatus.INSTANCE;
            if (z) {
                i = ConnectivityStatus.UPDATING.ordinal();
            } else {
                i = ConnectivityStatus.CONNECTING.ordinal();
            }
            DeviceManager.updateDeviceFieldAsync$default(deviceManager, str, deviceField, Boxing.boxInt(i), (DataTrend) null, 8, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
