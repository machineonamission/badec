package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$updateTimezoneList$1", f = "HomeViewModel.kt", i = {0, 1}, l = {293, 293}, m = "invokeSuspend", n = {"lastVersion", "lastVersion"}, s = {"L$0", "L$0"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$updateTimezoneList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$updateTimezoneList$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$updateTimezoneList$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$updateTimezoneList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$updateTimezoneList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006e, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r7, new com.blueair.android.viewmodel.HomeViewModel$updateTimezoneList$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.android.viewmodel.HomeViewModel$updateTimezoneList$1.AnonymousClass1>) null), r6) == r0) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0070, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
        if (r7 == r0) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r6.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0071
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            java.lang.Object r1 = r6.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.core.util.TimezoneUtils r7 = com.blueair.core.util.TimezoneUtils.INSTANCE
            com.blueair.android.viewmodel.HomeViewModel r1 = r6.this$0
            android.app.Application r1 = r1.getApplication()
            android.content.Context r1 = (android.content.Context) r1
            com.blueair.core.util.TimezoneList r7 = r7.getTimezoneList(r1)
            java.lang.String r1 = r7.getVersion()
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            com.blueair.devicemanager.DeviceManager r7 = r7.getDeviceManager()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$0 = r5
            r6.label = r3
            java.lang.Object r7 = r7.updateTimezoneList(r1, r4)
            if (r7 != r0) goto L_0x0053
            goto L_0x0070
        L_0x0053:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.android.viewmodel.HomeViewModel$updateTimezoneList$1$1 r3 = new com.blueair.android.viewmodel.HomeViewModel$updateTimezoneList$1$1
            com.blueair.android.viewmodel.HomeViewModel r4 = r6.this$0
            r5 = 0
            r3.<init>(r4, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r3, r4)
            if (r7 != r0) goto L_0x0071
        L_0x0070:
            return r0
        L_0x0071:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$updateTimezoneList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
