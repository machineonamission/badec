package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.GigyaService", f = "GigyaService.kt", i = {0, 0, 0, 0, 0}, l = {329}, m = "refreshGigyaUid", n = {"this_$iv", "api$iv", "failure$iv", "$i$f$runWithErrorReport", "$i$a$-runWithErrorReport-GigyaService$refreshGigyaUid$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"})
/* compiled from: GigyaService.kt */
final class GigyaService$refreshGigyaUid$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GigyaService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GigyaService$refreshGigyaUid$1(GigyaService gigyaService, Continuation<? super GigyaService$refreshGigyaUid$1> continuation) {
        super(continuation);
        this.this$0 = gigyaService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshGigyaUid(this);
    }
}
