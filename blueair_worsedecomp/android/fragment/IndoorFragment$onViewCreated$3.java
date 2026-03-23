package com.blueair.android.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.fragment.IndoorFragment$onViewCreated$3", f = "IndoorFragment.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IndoorFragment.kt */
final class IndoorFragment$onViewCreated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IndoorFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IndoorFragment$onViewCreated$3(IndoorFragment indoorFragment, Continuation<? super IndoorFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = indoorFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IndoorFragment$onViewCreated$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IndoorFragment$onViewCreated$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[RETURN] */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0028
        L_0x000f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x001a:
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x0028
            return r0
        L_0x0028:
            com.blueair.android.fragment.IndoorFragment r6 = r5.this$0
            com.blueair.android.adapter.DeviceListAdapter r6 = r6.getAdapter()
            r6.notifyCountdownAndTimerChanged()
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.fragment.IndoorFragment$onViewCreated$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
