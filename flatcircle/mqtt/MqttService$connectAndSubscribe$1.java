package io.flatcircle.mqtt;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.mqtt.MqttService", f = "MqttService.kt", i = {0, 0, 0, 0}, l = {133}, m = "connectAndSubscribe", n = {"clientId", "serverURI", "options", "properties"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: MqttService.kt */
final class MqttService$connectAndSubscribe$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MqttService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MqttService$connectAndSubscribe$1(MqttService mqttService, Continuation<? super MqttService$connectAndSubscribe$1> continuation) {
        super(continuation);
        this.this$0 = mqttService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.connectAndSubscribe(this);
    }
}
