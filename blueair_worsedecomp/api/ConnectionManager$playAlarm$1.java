package com.blueair.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.ConnectionManager", f = "ConnectionManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {540}, m = "playAlarm", n = {"this_$iv", "result$iv", "$this$forEach$iv$iv", "element$iv$iv", "client$iv", "it", "sound", "volume", "$i$f$doApiCall", "$i$f$forEach", "$i$a$-forEach-ConnectionManager$doApiCall$6$iv", "$i$a$-doApiCall-ConnectionManager$playAlarm$2"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"})
/* compiled from: ConnectionManager.kt */
final class ConnectionManager$playAlarm$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
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
    ConnectionManager$playAlarm$1(ConnectionManager connectionManager, Continuation<? super ConnectionManager$playAlarm$1> continuation) {
        super(continuation);
        this.this$0 = connectionManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.playAlarm(0, 0, this);
    }
}
