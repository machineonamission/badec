package io.flatcircle.stomp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.stomp.StompService", f = "StompService.kt", i = {0, 1, 2}, l = {293, 294, 295}, m = "restart", n = {"deviceIds", "deviceIds", "deviceIds"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: StompService.kt */
final class StompService$restart$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StompService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StompService$restart$1(StompService stompService, Continuation<? super StompService$restart$1> continuation) {
        super(continuation);
        this.this$0 = stompService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.restart(this);
    }
}
