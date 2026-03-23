package com.blueair.auth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Output", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$1", f = "AuthService.kt", i = {}, l = {822}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthService.kt */
final class AuthServiceKt$doSuspendedApiCall$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<Output>>, Object> {
    final /* synthetic */ Function1<Continuation<? super Response<Output>>, Object> $apiCall;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthServiceKt$doSuspendedApiCall$response$1(Function1<? super Continuation<? super Response<Output>>, ? extends Object> function1, Continuation<? super AuthServiceKt$doSuspendedApiCall$response$1> continuation) {
        super(2, continuation);
        this.$apiCall = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthServiceKt$doSuspendedApiCall$response$1(this.$apiCall, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<Output>> continuation) {
        return ((AuthServiceKt$doSuspendedApiCall$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Response<Output>>, Object> function1 = this.$apiCall;
            this.label = 1;
            Object invoke = function1.invoke(this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
