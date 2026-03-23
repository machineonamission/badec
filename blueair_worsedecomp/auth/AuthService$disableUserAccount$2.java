package com.blueair.auth;

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
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lokhttp3/ResponseBody;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService$disableUserAccount$2", f = "AuthService.kt", i = {0}, l = {398}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* compiled from: AuthService.kt */
final class AuthService$disableUserAccount$2 extends SuspendLambda implements Function2<String, Continuation<? super ApiResult<ResponseBody>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$disableUserAccount$2(AuthService authService, Continuation<? super AuthService$disableUserAccount$2> continuation) {
        super(2, continuation);
        this.this$0 = authService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuthService$disableUserAccount$2 authService$disableUserAccount$2 = new AuthService$disableUserAccount$2(this.this$0, continuation);
        authService$disableUserAccount$2.L$0 = obj;
        return authService$disableUserAccount$2;
    }

    public final Object invoke(String str, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return ((AuthService$disableUserAccount$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 1;
            Object awaitCall = AuthServiceKt.awaitCall(this.this$0.getCloudAuthApi().disableUserAccount(str), this);
            return awaitCall == coroutine_suspended ? coroutine_suspended : awaitCall;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
