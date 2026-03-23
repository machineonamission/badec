package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.GigyaService", f = "GigyaService.kt", i = {0, 0, 1, 1, 1}, l = {797, 656}, m = "checkGigyaTokenExpiry", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-GigyaService$checkGigyaTokenExpiry$2"}, s = {"L$0", "I$0", "L$0", "I$0", "I$1"})
/* compiled from: GigyaService.kt */
final class GigyaService$checkGigyaTokenExpiry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GigyaService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GigyaService$checkGigyaTokenExpiry$1(GigyaService gigyaService, Continuation<? super GigyaService$checkGigyaTokenExpiry$1> continuation) {
        super(continuation);
        this.this$0 = gigyaService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkGigyaTokenExpiry(this);
    }
}
