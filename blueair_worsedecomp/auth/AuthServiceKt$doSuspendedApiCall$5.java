package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthServiceKt", f = "AuthService.kt", i = {0, 0, 0}, l = {869}, m = "doSuspendedApiCall", n = {"apiCall", "input1", "input2"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: AuthService.kt */
final class AuthServiceKt$doSuspendedApiCall$5<Input1, Input2, Output> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    AuthServiceKt$doSuspendedApiCall$5(Continuation<? super AuthServiceKt$doSuspendedApiCall$5> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AuthServiceKt.doSuspendedApiCall((Function3) null, null, null, this);
    }
}
