package io.flatcircle.connectivityhelper;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "io.flatcircle.connectivityhelper.PingLooper$doPings$1", f = "PingLooper.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PingLooper.kt */
final class PingLooper$doPings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ PingLooper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PingLooper$doPings$1(PingLooper pingLooper, Continuation continuation) {
        super(2, continuation);
        this.this$0 = pingLooper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        PingLooper$doPings$1 pingLooper$doPings$1 = new PingLooper$doPings$1(this.this$0, continuation);
        pingLooper$doPings$1.p$ = (CoroutineScope) obj;
        return pingLooper$doPings$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PingLooper$doPings$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = this.p$;
            Job access$getPingJob$p = this.this$0.pingJob;
            if (access$getPingJob$p != null) {
                this.L$0 = coroutineScope3;
                this.label = 1;
                Object cancelAndJoin = JobKt.cancelAndJoin(access$getPingJob$p, this);
                if (cancelAndJoin == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope3;
                obj = cancelAndJoin;
            } else {
                coroutineScope = coroutineScope3;
                this.this$0.pingJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation) null), 3, (Object) null);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = (Unit) obj;
        coroutineScope = coroutineScope2;
        this.this$0.pingJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "io.flatcircle.connectivityhelper.PingLooper$doPings$1$1", f = "PingLooper.kt", i = {0}, l = {50}, m = "invokeSuspend", n = {"isConnectedThisLoop"}, s = {"L$0"})
    /* renamed from: io.flatcircle.connectivityhelper.PingLooper$doPings$1$1  reason: invalid class name */
    /* compiled from: PingLooper.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ PingLooper$doPings$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = false;
                for (ConnectionStateMonitor connectionStateMonitor : this.this$0.this$0.getConnectionMonitors()) {
                    if (!booleanRef.element && NetUtil.ping$default(NetUtil.INSTANCE, this.this$0.this$0.getEndpoint(), 0, 2, (Object) null)) {
                        this.this$0.this$0.getPingResultHandler().result(true);
                        booleanRef.element = true;
                    }
                }
                if (!booleanRef.element) {
                    this.this$0.this$0.getPingResultHandler().result(false);
                }
                this.L$0 = booleanRef;
                this.label = 1;
                if (DelayKt.delay(30000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.this$0.this$0.doPings();
            return Unit.INSTANCE;
        }
    }
}
