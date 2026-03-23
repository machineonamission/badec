package com.blueair.livestream;

import io.flatcircle.stomp.StompEvent;
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
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$setAllListeners$2", f = "StreamService.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StreamService.kt */
final class StreamService$setAllListeners$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StreamService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$setAllListeners$2(StreamService streamService, Continuation<? super StreamService$setAllListeners$2> continuation) {
        super(2, continuation);
        this.this$0 = streamService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamService$setAllListeners$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamService$setAllListeners$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(this.this$0.stompService.getEventObservable());
            final StreamService streamService = this.this$0;
            this.label = 1;
            if (distinctUntilChanged.collect(new FlowCollector() {
                public final Object emit(StompEvent<?> stompEvent, Continuation<? super Unit> continuation) {
                    Timber.Forest forest = Timber.Forest;
                    forest.d("STOMP Payload received with details, " + stompEvent, new Object[0]);
                    Object emit = streamService._mainObservable.emit(StreamEvent.Companion.fromStomp(stompEvent), continuation);
                    return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
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
