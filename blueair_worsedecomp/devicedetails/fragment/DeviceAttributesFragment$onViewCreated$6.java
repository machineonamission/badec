package com.blueair.devicedetails.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceAttributesFragment$onViewCreated$6", f = "DeviceAttributesFragment.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceAttributesFragment.kt */
final class DeviceAttributesFragment$onViewCreated$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceAttributesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceAttributesFragment$onViewCreated$6(DeviceAttributesFragment deviceAttributesFragment, Continuation<? super DeviceAttributesFragment$onViewCreated$6> continuation) {
        super(2, continuation);
        this.this$0 = deviceAttributesFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceAttributesFragment$onViewCreated$6(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceAttributesFragment$onViewCreated$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[RETURN] */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0028
        L_0x000f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x001a:
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r3, r7)
            if (r7 != r0) goto L_0x0028
            return r0
        L_0x0028:
            com.blueair.devicedetails.fragment.DeviceAttributesFragment r7 = r6.this$0
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r7 = r7.getAdapter()
            com.blueair.core.model.Device r7 = r7.getDevice()
            boolean r1 = r7 instanceof com.blueair.core.model.HasTimer
            if (r1 == 0) goto L_0x0039
            com.blueair.core.model.HasTimer r7 = (com.blueair.core.model.HasTimer) r7
            goto L_0x003a
        L_0x0039:
            r7 = 0
        L_0x003a:
            if (r7 == 0) goto L_0x001a
            com.blueair.devicedetails.fragment.DeviceAttributesFragment r1 = r6.this$0
            r3 = 2
            com.blueair.core.model.TimerState[] r3 = new com.blueair.core.model.TimerState[r3]
            r4 = 0
            com.blueair.core.model.TimerState r5 = com.blueair.core.model.TimerState.START
            r3[r4] = r5
            com.blueair.core.model.TimerState r4 = com.blueair.core.model.TimerState.RESUME
            r3[r2] = r4
            java.util.Set r3 = kotlin.collections.SetsKt.setOf(r3)
            com.blueair.core.model.TimerState r7 = r7.timerStatus()
            boolean r7 = r3.contains(r7)
            if (r7 == 0) goto L_0x001a
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r7 = r1.getAdapter()
            r7.notifyTimerLeftTimeChanged()
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceAttributesFragment$onViewCreated$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
