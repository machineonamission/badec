package io.flatcircle.stomp;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.stomp.StompService", f = "StompService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1}, l = {141, 146}, m = "registerDevicesInternal", n = {"newDevices", "newDevices", "notRegisteredDevices", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-StompService$registerDevicesInternal$2"}, s = {"L$0", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"})
/* compiled from: StompService.kt */
final class StompService$registerDevicesInternal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StompService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StompService$registerDevicesInternal$1(StompService stompService, Continuation<? super StompService$registerDevicesInternal$1> continuation) {
        super(continuation);
        this.this$0 = stompService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerDevicesInternal((List<String>) null, this);
    }
}
