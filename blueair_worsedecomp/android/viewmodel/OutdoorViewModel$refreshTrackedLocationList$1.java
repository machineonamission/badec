package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1", f = "OutdoorViewModel.kt", i = {}, l = {50, 50, 50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutdoorViewModel.kt */
final class OutdoorViewModel$refreshTrackedLocationList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OutdoorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorViewModel$refreshTrackedLocationList$1(OutdoorViewModel outdoorViewModel, Continuation<? super OutdoorViewModel$refreshTrackedLocationList$1> continuation) {
        super(2, continuation);
        this.this$0 = outdoorViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutdoorViewModel$refreshTrackedLocationList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutdoorViewModel$refreshTrackedLocationList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r7 == r0) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r7 == r0) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r7, new com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1.AnonymousClass2>) null), r6) == r0) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r5) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0065
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0050
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003b
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.android.viewmodel.OutdoorViewModel r7 = r6.this$0
            com.blueair.outdoor.service.OutdoorService r7 = r7.getOutdoorService()
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r5
            java.lang.Object r7 = r7.downloadTrackedLocations(r1)
            if (r7 != r0) goto L_0x003b
            goto L_0x0064
        L_0x003b:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1$1 r1 = new com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1$1
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r4
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r7, r1, r5)
            if (r7 != r0) goto L_0x0050
            goto L_0x0064
        L_0x0050:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1$2 r1 = new com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r6.label = r3
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r1, r2)
            if (r7 != r0) goto L_0x0065
        L_0x0064:
            return r0
        L_0x0065:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.OutdoorViewModel$refreshTrackedLocationList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
