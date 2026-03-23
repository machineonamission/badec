package com.blueair.livestream;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$setAllListeners$1", f = "StreamService.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StreamService.kt */
final class StreamService$setAllListeners$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StreamService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$setAllListeners$1(StreamService streamService, Continuation<? super StreamService$setAllListeners$1> continuation) {
        super(2, continuation);
        this.this$0 = streamService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamService$setAllListeners$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamService$setAllListeners$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(this.this$0.mqttService.getEventObservable());
            final StreamService streamService = this.this$0;
            this.label = 1;
            if (distinctUntilChanged.collect(new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
                /* JADX WARNING: Removed duplicated region for block: B:15:0x0080  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(io.flatcircle.mqtt.MqttEvent r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof com.blueair.livestream.StreamService$setAllListeners$1$1$emit$1
                        if (r0 == 0) goto L_0x0014
                        r0 = r13
                        com.blueair.livestream.StreamService$setAllListeners$1$1$emit$1 r0 = (com.blueair.livestream.StreamService$setAllListeners$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L_0x0014
                        int r13 = r0.label
                        int r13 = r13 - r2
                        r0.label = r13
                        goto L_0x0019
                    L_0x0014:
                        com.blueair.livestream.StreamService$setAllListeners$1$1$emit$1 r0 = new com.blueair.livestream.StreamService$setAllListeners$1$1$emit$1
                        r0.<init>(r11, r13)
                    L_0x0019:
                        java.lang.Object r13 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        r4 = 0
                        if (r2 == 0) goto L_0x004f
                        if (r2 != r3) goto L_0x0047
                        int r12 = r0.I$1
                        int r12 = r0.I$0
                        java.lang.Object r2 = r0.L$5
                        com.blueair.livestream.StreamEvent r2 = (com.blueair.livestream.StreamEvent) r2
                        java.lang.Object r2 = r0.L$4
                        java.lang.Object r2 = r0.L$3
                        java.util.Iterator r2 = (java.util.Iterator) r2
                        java.lang.Object r5 = r0.L$2
                        com.blueair.livestream.StreamService r5 = (com.blueair.livestream.StreamService) r5
                        java.lang.Object r6 = r0.L$1
                        java.lang.Iterable r6 = (java.lang.Iterable) r6
                        java.lang.Object r7 = r0.L$0
                        io.flatcircle.mqtt.MqttEvent r7 = (io.flatcircle.mqtt.MqttEvent) r7
                        kotlin.ResultKt.throwOnFailure(r13)
                        r13 = r12
                        r12 = r7
                        goto L_0x007a
                    L_0x0047:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L_0x004f:
                        kotlin.ResultKt.throwOnFailure(r13)
                        timber.log.Timber$Forest r13 = timber.log.Timber.Forest
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r5 = "MQTT Payload received with details, "
                        r2.<init>(r5)
                        r2.append(r12)
                        java.lang.String r2 = r2.toString()
                        java.lang.Object[] r5 = new java.lang.Object[r4]
                        r13.d(r2, r5)
                        com.blueair.livestream.StreamEvent$Companion r13 = com.blueair.livestream.StreamEvent.Companion
                        java.util.List r13 = r13.fromMqtt(r12)
                        java.lang.Iterable r13 = (java.lang.Iterable) r13
                        com.blueair.livestream.StreamService r2 = r3
                        java.util.Iterator r5 = r13.iterator()
                        r6 = r5
                        r5 = r2
                        r2 = r6
                        r6 = r13
                        r13 = r4
                    L_0x007a:
                        boolean r7 = r2.hasNext()
                        if (r7 == 0) goto L_0x00b4
                        java.lang.Object r7 = r2.next()
                        r8 = r7
                        com.blueair.livestream.StreamEvent r8 = (com.blueair.livestream.StreamEvent) r8
                        kotlinx.coroutines.flow.MutableSharedFlow r9 = r5._mainObservable
                        java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                        r0.L$0 = r10
                        java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                        r0.L$1 = r10
                        r0.L$2 = r5
                        r0.L$3 = r2
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                        r0.L$4 = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                        r0.L$5 = r7
                        r0.I$0 = r13
                        r0.I$1 = r4
                        r0.label = r3
                        java.lang.Object r7 = r9.emit(r8, r0)
                        if (r7 != r1) goto L_0x007a
                        return r1
                    L_0x00b4:
                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blueair.livestream.StreamService$setAllListeners$1.AnonymousClass1.emit(io.flatcircle.mqtt.MqttEvent, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
