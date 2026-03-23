package io.flatcircle.stomp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.stomp.StompService$startPingJob$1", f = "StompService.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StompService.kt */
final class StompService$startPingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uuid;
    int label;
    final /* synthetic */ StompService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StompService$startPingJob$1(StompService stompService, String str, Continuation<? super StompService$startPingJob$1> continuation) {
        super(2, continuation);
        this.this$0 = stompService;
        this.$uuid = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StompService$startPingJob$1(this.this$0, this.$uuid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StompService$startPingJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0022  */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x000f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x001a:
            io.flatcircle.stomp.StompService r6 = r5.this$0
            com.foobot.liblabclient.async.StompMessenger r6 = r6.messenger
            if (r6 == 0) goto L_0x0027
            java.lang.String r1 = r5.$uuid
            r6.ping(r1)
        L_0x0027:
            io.flatcircle.stomp.StompService r6 = r5.this$0
            java.lang.String r1 = r5.$uuid
            r6.requestDataForDevice(r1)
            io.flatcircle.stomp.StompService r6 = r5.this$0
            java.lang.String r1 = r5.$uuid
            r6.incrementPingCounter(r1)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r2
            r3 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x0043
            return r0
        L_0x0043:
            io.flatcircle.stomp.StompService r6 = r5.this$0
            java.lang.String r1 = r5.$uuid
            boolean r6 = r6.isDeviceOffline(r1)
            if (r6 == 0) goto L_0x001a
            io.flatcircle.stomp.StompService r6 = r5.this$0
            io.flatcircle.stomp.StompEvent r1 = new io.flatcircle.stomp.StompEvent
            java.lang.String r3 = r5.$uuid
            com.blueair.core.model.ConnectivityStatus r4 = com.blueair.core.model.ConnectivityStatus.OFFLINE
            r1.<init>(r3, r4)
            r6.sendEvent(r1)
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService$startPingJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
