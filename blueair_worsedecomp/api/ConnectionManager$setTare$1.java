package com.blueair.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.ConnectionManager", f = "ConnectionManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {620}, m = "setTare", n = {"this_$iv", "call$iv", "result$iv", "$this$forEach$iv$iv", "element$iv$iv", "client$iv", "$i$f$doApiCall", "$i$f$forEach", "$i$a$-forEach-ConnectionManager$doApiCall$2$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"})
/* compiled from: ConnectionManager.kt */
final class ConnectionManager$setTare$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionManager$setTare$1(ConnectionManager connectionManager, Continuation<? super ConnectionManager$setTare$1> continuation) {
        super(continuation);
        this.this$0 = connectionManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setTare(this);
    }
}
