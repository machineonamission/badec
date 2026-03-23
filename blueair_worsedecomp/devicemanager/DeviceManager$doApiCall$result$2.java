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
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$doApiCall$result$2", f = "DeviceManager.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$doApiCall$result$2 extends SuspendLambda implements Function1<Continuation<? super ApiResult<SimpleResponse>>, Object> {
    final /* synthetic */ Function2<ConnectionManager, Continuation<? super ApiResult<SimpleResponse>>, Object> $action;
    final /* synthetic */ ConnectionManager $connection;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$doApiCall$result$2(Function2<? super ConnectionManager, ? super Continuation<? super ApiResult<SimpleResponse>>, ? extends Object> function2, ConnectionManager connectionManager, Continuation<? super DeviceManager$doApiCall$result$2> continuation) {
        super(1, continuation);
        this.$action = function2;
        this.$connection = connectionManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DeviceManager$doApiCall$result$2(this.$action, this.$connection, continuation);
    }

    public final Object invoke(Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return ((DeviceManager$doApiCall$result$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ConnectionManager, Continuation<? super ApiResult<SimpleResponse>>, Object> function2 = this.$action;
            ConnectionManager connectionManager = this.$connection;
            this.label = 1;
            Object invoke = function2.invoke(connectionManager, this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
