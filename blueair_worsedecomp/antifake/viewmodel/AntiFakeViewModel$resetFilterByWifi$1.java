package com.blueair.antifake.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1", f = "AntiFakeViewModel.kt", i = {}, l = {178, 178, 178}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AntiFakeViewModel.kt */
final class AntiFakeViewModel$resetFilterByWifi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $deviceSku;
    int label;
    final /* synthetic */ AntiFakeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AntiFakeViewModel$resetFilterByWifi$1(AntiFakeViewModel antiFakeViewModel, String str, String str2, Continuation<? super AntiFakeViewModel$resetFilterByWifi$1> continuation) {
        super(2, continuation);
        this.this$0 = antiFakeViewModel;
        this.$deviceSku = str;
        this.$deviceId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AntiFakeViewModel$resetFilterByWifi$1(this.this$0, this.$deviceSku, this.$deviceId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AntiFakeViewModel$resetFilterByWifi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r10 == r0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0059, code lost:
        if (r10 == r0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r10, new com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1.AnonymousClass2>) null), r9) == r0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r5) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0073
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005c
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0045
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r10)
            com.blueair.antifake.viewmodel.AntiFakeViewModel r10 = r9.this$0
            com.blueair.devicemanager.DeviceManager r10 = r10.getDeviceManager()
            com.blueair.antifake.viewmodel.AntiFakeViewModel r1 = r9.this$0
            java.lang.String r1 = r1.getCode()
            java.lang.String r6 = r9.$deviceSku
            java.lang.String r7 = r9.$deviceId
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9.label = r5
            java.lang.Object r10 = r10.antiFakeResetByWifi(r1, r6, r7, r8)
            if (r10 != r0) goto L_0x0045
            goto L_0x0072
        L_0x0045:
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1$1 r1 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1$1
            com.blueair.antifake.viewmodel.AntiFakeViewModel r5 = r9.this$0
            r1.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.label = r4
            java.lang.Object r10 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r10, r1, r5)
            if (r10 != r0) goto L_0x005c
            goto L_0x0072
        L_0x005c:
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1$2 r1 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1$2
            com.blueair.antifake.viewmodel.AntiFakeViewModel r4 = r9.this$0
            r1.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.label = r3
            java.lang.Object r10 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r10, r1, r2)
            if (r10 != r0) goto L_0x0073
        L_0x0072:
            return r0
        L_0x0073:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByWifi$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
