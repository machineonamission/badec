package com.blueair.devicedetails.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceAttributesFragment$onViewCreated$5", f = "DeviceAttributesFragment.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceAttributesFragment.kt */
final class DeviceAttributesFragment$onViewCreated$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceAttributesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceAttributesFragment$onViewCreated$5(DeviceAttributesFragment deviceAttributesFragment, Continuation<? super DeviceAttributesFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = deviceAttributesFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceAttributesFragment$onViewCreated$5(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceAttributesFragment$onViewCreated$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[RETURN] */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0028
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x001a:
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r2
            r3 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r8)
            if (r8 != r0) goto L_0x0028
            return r0
        L_0x0028:
            com.blueair.devicedetails.fragment.DeviceAttributesFragment r8 = r7.this$0
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r8 = r8.getAdapter()
            com.blueair.core.model.Device r8 = r8.getDevice()
            boolean r1 = r8 instanceof com.blueair.core.model.HasDisinfection
            if (r1 == 0) goto L_0x0039
            com.blueair.core.model.HasDisinfection r8 = (com.blueair.core.model.HasDisinfection) r8
            goto L_0x003a
        L_0x0039:
            r8 = 0
        L_0x003a:
            if (r8 == 0) goto L_0x001a
            java.lang.Boolean r1 = r8.getDisinfection()
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x001a
            java.lang.Integer r1 = r8.getDisinfectLeftTime()
            if (r1 == 0) goto L_0x001a
            java.lang.Long r1 = r8.getDisinfectLeftTimeUpdateTime()
            if (r1 == 0) goto L_0x001a
            long r3 = java.lang.System.currentTimeMillis()
            r1 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r1
            long r3 = r3 / r5
            java.lang.Long r8 = r8.getDisinfectLeftTimeUpdateTime()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            long r5 = r8.longValue()
            int r8 = (int) r5
            long r5 = (long) r8
            long r3 = r3 - r5
            r5 = 25
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x001a
            com.blueair.devicedetails.fragment.DeviceAttributesFragment r8 = r7.this$0
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r8 = r8.getAdapter()
            r8.notifyDisinfectLeftTimeChanged()
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceAttributesFragment$onViewCreated$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
