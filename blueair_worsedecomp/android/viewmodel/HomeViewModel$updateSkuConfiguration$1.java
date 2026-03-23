package com.blueair.android.viewmodel;

import com.blueair.core.model.SkuConfigurationData;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1", f = "HomeViewModel.kt", i = {2}, l = {301, 301, 307}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$updateSkuConfiguration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ApiResult<SkuConfigurationData>, Unit> $onComplete;
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$updateSkuConfiguration$1(HomeViewModel homeViewModel, Function1<? super ApiResult<SkuConfigurationData>, Unit> function1, Continuation<? super HomeViewModel$updateSkuConfiguration$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$onComplete = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$updateSkuConfiguration$1(this.this$0, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$updateSkuConfiguration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r9 == r0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (r9 == r0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0082, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1.AnonymousClass1>) null), r8) == r0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0084, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r5) goto L_0x0026
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            java.lang.Object r0 = r8.L$0
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0085
        L_0x001a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004b
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.android.viewmodel.HomeViewModel r9 = r8.this$0
            com.blueair.devicemanager.DeviceManager r9 = r9.getDeviceManager()
            com.blueair.core.util.SkuConfigurationManager r1 = com.blueair.core.util.SkuConfigurationManager.INSTANCE
            int r1 = r1.getVersion()
            com.blueair.core.util.SkuConfigurationManager r6 = com.blueair.core.util.SkuConfigurationManager.INSTANCE
            int r6 = r6.getSeries()
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.label = r5
            java.lang.Object r9 = r9.updateSkuConfiguration(r1, r6, r7)
            if (r9 != r0) goto L_0x004b
            goto L_0x0084
        L_0x004b:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1$result$1 r1 = new com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1$result$1
            com.blueair.android.viewmodel.HomeViewModel r5 = r8.this$0
            r1.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.label = r4
            java.lang.Object r9 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r9, r1, r5)
            if (r9 != r0) goto L_0x0062
            goto L_0x0084
        L_0x0062:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1$1 r4 = new com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1$1
            kotlin.jvm.functions.Function1<io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.SkuConfigurationData>, kotlin.Unit> r5 = r8.$onComplete
            r4.<init>(r5, r9, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2 = r8
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$0 = r9
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r2)
            if (r9 != r0) goto L_0x0085
        L_0x0084:
            return r0
        L_0x0085:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
