package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Deferred;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthServiceKt", f = "AuthService.kt", i = {0}, l = {806}, m = "awaitCall", n = {"job"}, s = {"L$0"})
/* compiled from: AuthService.kt */
final class AuthServiceKt$awaitCall$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AuthServiceKt$awaitCall$1(Continuation<? super AuthServiceKt$awaitCall$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AuthServiceKt.awaitCall((Deferred) null, this);
    }
}
