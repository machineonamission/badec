package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.GigyaService", f = "GigyaService.kt", i = {}, l = {258}, m = "refreshTokens", n = {}, s = {})
/* compiled from: GigyaService.kt */
final class GigyaService$refreshTokens$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GigyaService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GigyaService$refreshTokens$1(GigyaService gigyaService, Continuation<? super GigyaService$refreshTokens$1> continuation) {
        super(continuation);
        this.this$0 = gigyaService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshTokens(this);
    }
}
