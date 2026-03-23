package com.blueair.auth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Output", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$3", f = "AuthService.kt", i = {}, l = {870}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthService.kt */
final class AuthServiceKt$doSuspendedApiCall$response$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<Output>>, Object> {
    final /* synthetic */ Function3<Input1, Input2, Continuation<? super Response<Output>>, Object> $apiCall;
    final /* synthetic */ Input1 $input1;
    final /* synthetic */ Input2 $input2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthServiceKt$doSuspendedApiCall$response$3(Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super AuthServiceKt$doSuspendedApiCall$response$3> continuation) {
        super(2, continuation);
        this.$apiCall = function3;
        this.$input1 = input1;
        this.$input2 = input2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthServiceKt$doSuspendedApiCall$response$3(this.$apiCall, this.$input1, this.$input2, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<Output>> continuation) {
        return ((AuthServiceKt$doSuspendedApiCall$response$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<Input1, Input2, Continuation<? super Response<Output>>, Object> function3 = this.$apiCall;
            Input1 input1 = this.$input1;
            Input2 input2 = this.$input2;
            this.label = 1;
            Object invoke = function3.invoke(input1, input2, this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
