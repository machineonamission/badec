package com.blueair.devicemanager;

import com.blueair.api.ConnectionManager;
import com.blueair.api.model.DeviceInfoData;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$setAblDeviceName$2", f = "DeviceManager.kt", i = {0}, l = {1772}, m = "invokeSuspend", n = {"connection"}, s = {"L$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setAblDeviceName$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $name;
    Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setAblDeviceName$2(DeviceManager deviceManager, String str, String str2, Continuation<? super DeviceManager$setAblDeviceName$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$deviceId = str;
        this.$name = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$setAblDeviceName$2(this.this$0, this.$deviceId, this.$name, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$setAblDeviceName$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConnectionManager access$connection = this.this$0.connection(this.$deviceId);
            if (access$connection == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(access$connection);
            this.label = 1;
            obj2 = access$connection.setDeviceName(this.$name, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ConnectionManager connectionManager = (ConnectionManager) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.model.DeviceInfoData>");
        ApiResult apiResult = (ApiResult) obj2;
        Timber.Forest forest = Timber.Forest;
        forest.d("setAblDeviceName: nuDeviceResult = " + apiResult, new Object[0]);
        DeviceInfoData deviceInfoData = (DeviceInfoData) apiResult.getOrNull();
        if (apiResult.isSuccess() && deviceInfoData != null) {
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("setAblDeviceName: addAbleDeviceToDb name = " + deviceInfoData.getName(), new Object[0]);
            this.this$0.addAblDeviceToDb(DeviceInfoData.copy$default(deviceInfoData, (String) null, this.$name, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, (Long) null, 131069, (Object) null).toDeviceDetailsOnServer());
        }
        return Unit.INSTANCE;
    }
}
