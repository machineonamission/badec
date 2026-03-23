package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService", f = "AuthService.kt", i = {0, 1, 1, 1}, l = {394, 394}, m = "getBearerToken", n = {"onSuccess", "onSuccess", "it", "$i$a$-let-AuthService$getBearerToken$3"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* compiled from: AuthService.kt */
final class AuthService$getBearerToken$1<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$getBearerToken$1(AuthService authService, Continuation<? super AuthService$getBearerToken$1> continuation) {
        super(continuation);
        this.this$0 = authService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getBearerToken((Function2) null, this);
    }
}
