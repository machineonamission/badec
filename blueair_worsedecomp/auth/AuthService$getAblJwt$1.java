package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService", f = "AuthService.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {476, 891, 481}, m = "getAblJwt", n = {"toReturn", "checkGigyaJwtExpiry", "toReturn", "$this$withLock_u24default$iv", "checkGigyaJwtExpiry", "$i$f$withLock", "toReturn", "$this$withLock_u24default$iv", "checkGigyaJwtExpiry", "$i$f$withLock", "$i$a$-withLock$default-AuthService$getAblJwt$2"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "I$1"})
/* compiled from: AuthService.kt */
final class AuthService$getAblJwt$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$getAblJwt$1(AuthService authService, Continuation<? super AuthService$getAblJwt$1> continuation) {
        super(continuation);
        this.this$0 = authService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAblJwt(false, this);
    }
}
