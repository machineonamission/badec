package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Output", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$response$1", f = "NetworkClient.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkClient.kt */
final class BaseNetworkClient$doSuspendedApiCall$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<Output>>, Object> {
    final /* synthetic */ Function2<Input, Continuation<? super Response<Output>>, Object> $apiCall;
    final /* synthetic */ Input $input;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseNetworkClient$doSuspendedApiCall$response$1(Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super BaseNetworkClient$doSuspendedApiCall$response$1> continuation) {
        super(2, continuation);
        this.$apiCall = function2;
        this.$input = input;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseNetworkClient$doSuspendedApiCall$response$1(this.$apiCall, this.$input, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<Output>> continuation) {
        return ((BaseNetworkClient$doSuspendedApiCall$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<Input, Continuation<? super Response<Output>>, Object> function2 = this.$apiCall;
            Input input = this.$input;
            this.label = 1;
            Object invoke = function2.invoke(input, this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
