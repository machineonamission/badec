package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService", f = "AuthService.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {361, 891, 371, 371, 371}, m = "getCloudJwt", n = {"toReturn", "toReturn", "$this$withLock_u24default$iv", "$i$f$withLock", "toReturn", "$this$withLock_u24default$iv", "headers", "params", "$i$f$withLock", "$i$a$-withLock$default-AuthService$getCloudJwt$2", "toReturn", "$this$withLock_u24default$iv", "headers", "params", "$i$f$withLock", "$i$a$-withLock$default-AuthService$getCloudJwt$2", "toReturn", "$this$withLock_u24default$iv", "headers", "params", "$i$f$withLock", "$i$a$-withLock$default-AuthService$getCloudJwt$2"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
/* compiled from: AuthService.kt */
final class AuthService$getCloudJwt$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$getCloudJwt$1(AuthService authService, Continuation<? super AuthService$getCloudJwt$1> continuation) {
        super(continuation);
        this.this$0 = authService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCloudJwt(this);
    }
}
