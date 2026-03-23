package com.blueair.livestream;

import com.blueair.livestream.StreamService$setAllListeners$1;
import io.flatcircle.mqtt.MqttEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$setAllListeners$1$1", f = "StreamService.kt", i = {0, 0, 0, 0, 0, 0}, l = {74}, m = "emit", n = {"mqttEvent", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-StreamService$setAllListeners$1$1$1"}, s = {"L$0", "L$1", "L$4", "L$5", "I$0", "I$1"})
/* compiled from: StreamService.kt */
final class StreamService$setAllListeners$1$1$emit$1 extends ContinuationImpl {
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
    final /* synthetic */ StreamService$setAllListeners$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$setAllListeners$1$1$emit$1(StreamService$setAllListeners$1.AnonymousClass1<? super T> r1, Continuation<? super StreamService$setAllListeners$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((MqttEvent) null, (Continuation<? super Unit>) this);
    }
}
