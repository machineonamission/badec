package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1", f = "HomeViewModel.kt", i = {}, l = {230, 230, 230, 230}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$refreshTrackedLocationList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$refreshTrackedLocationList$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$refreshTrackedLocationList$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$refreshTrackedLocationList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$refreshTrackedLocationList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r8 == r0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        if (r8 == r0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        if (r8 == r0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.m9342finally((io.flatcircle.coroutinehelper.ApiResult) r8, new com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1.AnonymousClass3((kotlin.coroutines.Continuation<? super com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1.AnonymousClass3>) null), r7) == r0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0090, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r6) goto L_0x002a
            if (r1 == r4) goto L_0x0026
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0091
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007a
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0065
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0050
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.android.viewmodel.HomeViewModel r8 = r7.this$0
            androidx.lifecycle.MutableLiveData r8 = r8.loadingLocations
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            r8.postValue(r1)
            com.blueair.android.viewmodel.HomeViewModel r8 = r7.this$0
            com.blueair.outdoor.service.OutdoorService r8 = r8.getOutdoorService()
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r6
            java.lang.Object r8 = r8.downloadTrackedLocations(r1)
            if (r8 != r0) goto L_0x0050
            goto L_0x0090
        L_0x0050:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1$1 r1 = new com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1$1
            r1.<init>(r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r4
            java.lang.Object r8 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r8, r1, r6)
            if (r8 != r0) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1$2 r1 = new com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1$2
            r1.<init>(r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.label = r3
            java.lang.Object r8 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r8, r1, r4)
            if (r8 != r0) goto L_0x007a
            goto L_0x0090
        L_0x007a:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1$3 r1 = new com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1$3
            com.blueair.android.viewmodel.HomeViewModel r3 = r7.this$0
            r1.<init>(r3, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.label = r2
            java.lang.Object r8 = io.flatcircle.coroutinehelper.ApiResultKt.m9342finally(r8, r1, r3)
            if (r8 != r0) goto L_0x0091
        L_0x0090:
            return r0
        L_0x0091:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$refreshTrackedLocationList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
