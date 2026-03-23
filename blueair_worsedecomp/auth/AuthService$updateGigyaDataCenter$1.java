package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService", f = "AuthService.kt", i = {}, l = {646, 646}, m = "updateGigyaDataCenter", n = {}, s = {})
/* compiled from: AuthService.kt */
final class AuthService$updateGigyaDataCenter$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$updateGigyaDataCenter$1(AuthService authService, Continuation<? super AuthService$updateGigyaDataCenter$1> continuation) {
        super(continuation);
        this.this$0 = authService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateGigyaDataCenter(this);
    }
}
