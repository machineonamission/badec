package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1", f = "NetworkClient.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkClient.kt */
final class BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<T>>, Object> {
    final /* synthetic */ BaseNetworkClient.CallWithInput<T> $callWithInput;
    int label;
    final /* synthetic */ BaseNetworkClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1(BaseNetworkClient baseNetworkClient, BaseNetworkClient.CallWithInput<T> callWithInput, Continuation<? super BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1> continuation) {
        super(2, continuation);
        this.this$0 = baseNetworkClient;
        this.$callWithInput = callWithInput;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1(this.this$0, this.$callWithInput, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<T>> continuation) {
        return ((BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object doSuspendedApiCall = this.this$0.doSuspendedApiCall(this.$callWithInput.getCall(), this.$callWithInput.getInput(), this);
            return doSuspendedApiCall == coroutine_suspended ? coroutine_suspended : doSuspendedApiCall;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
