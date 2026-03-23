package io.flatcircle.mqtt;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$2$1", f = "MqttService.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MqttService.kt */
final class MqttService$subscribeWithExponentialBackoff$2$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ MqttService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MqttService$subscribeWithExponentialBackoff$2$1(MqttService mqttService, Continuation<? super MqttService$subscribeWithExponentialBackoff$2$1> continuation) {
        super(1, continuation);
        this.this$0 = mqttService;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MqttService$subscribeWithExponentialBackoff$2$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Boolean> continuation) {
        return ((MqttService$subscribeWithExponentialBackoff$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.connectAndSubscribe(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.hasLost) {
            this.this$0.hasLost = false;
            this.this$0._mqttReconnected.tryEmit(Boxing.boxBoolean(true));
        }
        return Boxing.boxBoolean(true);
    }
}
