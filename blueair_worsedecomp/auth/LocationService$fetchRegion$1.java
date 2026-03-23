package com.blueair.auth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.LocationService$fetchRegion$1", f = "LocationService.kt", i = {1, 2, 2, 2}, l = {227, 228, 230}, m = "invokeSuspend", n = {"region", "region", "it", "$i$a$-let-LocationService$fetchRegion$1$1"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* compiled from: LocationService.kt */
final class LocationService$fetchRegion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LocationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationService$fetchRegion$1(LocationService locationService, Continuation<? super LocationService$fetchRegion$1> continuation) {
        super(2, continuation);
        this.this$0 = locationService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationService$fetchRegion$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocationService$fetchRegion$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (r7 == r0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        if (r6.this$0.ablRegion(r6) == r0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007e, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.CoroutineScopeKt.MainScope().getCoroutineContext(), new com.blueair.auth.LocationService$fetchRegion$1$1$1(r7, r1, (kotlin.coroutines.Continuation<? super com.blueair.auth.LocationService$fetchRegion$1$1$1>) null), r6) == r0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 == r4) goto L_0x002d
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r0 = r6.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r6.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0081
        L_0x001d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0025:
            java.lang.Object r1 = r6.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0042
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.auth.LocationService r7 = r6.this$0
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r4
            java.lang.Object r7 = r7.fetchBlueairRegion(r1)
            if (r7 != r0) goto L_0x0042
            goto L_0x0080
        L_0x0042:
            r1 = r7
            java.lang.String r1 = (java.lang.String) r1
            com.blueair.auth.LocationService r7 = r6.this$0
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.ablRegion(r4)
            if (r7 != r0) goto L_0x0055
            goto L_0x0080
        L_0x0055:
            if (r1 == 0) goto L_0x0081
            com.blueair.auth.LocationService r7 = r6.this$0
            kotlinx.coroutines.CoroutineScope r3 = kotlinx.coroutines.CoroutineScopeKt.MainScope()
            kotlin.coroutines.CoroutineContext r3 = r3.getCoroutineContext()
            com.blueair.auth.LocationService$fetchRegion$1$1$1 r4 = new com.blueair.auth.LocationService$fetchRegion$1$1$1
            r5 = 0
            r4.<init>(r7, r1, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$1 = r7
            r7 = 0
            r6.I$0 = r7
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r6)
            if (r7 != r0) goto L_0x0081
        L_0x0080:
            return r0
        L_0x0081:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.LocationService$fetchRegion$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
