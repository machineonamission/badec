package com.blueair.devicemanager;

import com.blueair.api.ConnectionManager;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.core.model.DeviceAlarm;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "it", "Lcom/blueair/api/ConnectionManager;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$setAlarm$3", f = "DeviceManager.kt", i = {0}, l = {1425}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setAlarm$3 extends SuspendLambda implements Function2<ConnectionManager, Continuation<? super ApiResult<SimpleResponse>>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ DeviceAlarm $value;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setAlarm$3(int i, DeviceAlarm deviceAlarm, Continuation<? super DeviceManager$setAlarm$3> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$value = deviceAlarm;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$setAlarm$3 deviceManager$setAlarm$3 = new DeviceManager$setAlarm$3(this.$index, this.$value, continuation);
        deviceManager$setAlarm$3.L$0 = obj;
        return deviceManager$setAlarm$3;
    }

    public final Object invoke(ConnectionManager connectionManager, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return ((DeviceManager$setAlarm$3) create(connectionManager, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConnectionManager connectionManager = (ConnectionManager) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(connectionManager);
            this.label = 1;
            Object alarm = connectionManager.setAlarm(this.$index, this.$value, this);
            return alarm == coroutine_suspended ? coroutine_suspended : alarm;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
