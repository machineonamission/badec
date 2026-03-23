package com.blueair.livestream;

import com.blueair.livestream.StreamService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$1$1", f = "StreamService.kt", i = {0, 1, 1, 1, 1, 2}, l = {52, 56, 59}, m = "emit", n = {"connected", "devices", "stompDevices", "connected", "$i$a$-let-StreamService$1$1$1", "connected"}, s = {"Z$0", "L$0", "L$1", "Z$0", "I$0", "Z$0"})
/* compiled from: StreamService.kt */
final class StreamService$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamService.AnonymousClass1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$1$1$emit$1(StreamService.AnonymousClass1.AnonymousClass1<? super T> r1, Continuation<? super StreamService$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, (Continuation<? super Unit>) this);
    }
}
