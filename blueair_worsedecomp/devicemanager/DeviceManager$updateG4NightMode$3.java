package com.blueair.devicemanager;

import com.blueair.api.ConnectionManager;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$updateG4NightMode$3", f = "DeviceManager.kt", i = {}, l = {1553}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateG4NightMode$3 extends SuspendLambda implements Function1<Continuation<? super ApiResult<SimpleResponse>>, Object> {
    final /* synthetic */ ConnectionManager $connection;
    final /* synthetic */ boolean $nightMode;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$updateG4NightMode$3(ConnectionManager connectionManager, boolean z, Continuation<? super DeviceManager$updateG4NightMode$3> continuation) {
        super(1, continuation);
        this.$connection = connectionManager;
        this.$nightMode = z;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DeviceManager$updateG4NightMode$3(this.$connection, this.$nightMode, continuation);
    }

    public final Object invoke(Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return ((DeviceManager$updateG4NightMode$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConnectionManager connectionManager = this.$connection;
            boolean z = this.$nightMode;
            this.label = 1;
            Object g4NightMode = connectionManager.setG4NightMode(z ? 1 : 0, this);
            return g4NightMode == coroutine_suspended ? coroutine_suspended : g4NightMode;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
