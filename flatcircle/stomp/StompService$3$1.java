package io.flatcircle.stomp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.stomp.StompService$3$1", f = "StompService.kt", i = {}, l = {70, 72}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StompService.kt */
final class StompService$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StompService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StompService$3$1(StompService stompService, Continuation<? super StompService$3$1> continuation) {
        super(2, continuation);
        this.this$0 = stompService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StompService$3$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StompService$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r5.this$0.restart(r5) == r0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r5) == r0) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x002f
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r3
            r3 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x002f
            goto L_0x0044
        L_0x002f:
            io.flatcircle.stomp.StompService r6 = r5.this$0
            boolean r6 = r6.hasRequiredInfo()
            if (r6 == 0) goto L_0x0045
            io.flatcircle.stomp.StompService r6 = r5.this$0
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r2
            java.lang.Object r6 = r6.restart(r1)
            if (r6 != r0) goto L_0x004f
        L_0x0044:
            return r0
        L_0x0045:
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "gigyaJwt or ablJwt changed but not all required auth values available to Stomp"
            r6.w(r1, r0)
        L_0x004f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
