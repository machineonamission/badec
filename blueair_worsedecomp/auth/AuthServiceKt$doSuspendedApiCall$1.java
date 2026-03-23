package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthServiceKt", f = "AuthService.kt", i = {0}, l = {821}, m = "doSuspendedApiCall", n = {"apiCall"}, s = {"L$0"})
/* compiled from: AuthService.kt */
final class AuthServiceKt$doSuspendedApiCall$1<Output> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AuthServiceKt$doSuspendedApiCall$1(Continuation<? super AuthServiceKt$doSuspendedApiCall$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AuthServiceKt.doSuspendedApiCall((Function1) null, this);
    }
}
