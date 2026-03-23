package com.blueair.adddevice.dialog;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13", f = "FinalizeDialog.kt", i = {}, l = {124, 131, 131, 131}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FinalizeDialog.kt */
final class FinalizeDialog$onCreateView$13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ List<Deferred<?>> $jobs;
    Object L$0;
    int label;
    final /* synthetic */ FinalizeDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinalizeDialog$onCreateView$13(List<Deferred<?>> list, FinalizeDialog finalizeDialog, String str, Continuation<? super FinalizeDialog$onCreateView$13> continuation) {
        super(2, continuation);
        this.$jobs = list;
        this.this$0 = finalizeDialog;
        this.$deviceId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinalizeDialog$onCreateView$13(this.$jobs, this.this$0, this.$deviceId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FinalizeDialog$onCreateView$13) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.AnonymousClass1>) null), r9) == r1) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d2, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.AnonymousClass1>) null), r9) != r1) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010e, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.AnonymousClass1>) null), r9) != r1) goto L_0x0111;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.String r0 = "exception happens when doing finalize: "
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            r3 = 4
            r4 = 3
            r5 = 2
            java.lang.String r6 = "onboardingJob"
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0035
            if (r2 == r7) goto L_0x002f
            if (r2 == r5) goto L_0x002a
            if (r2 == r4) goto L_0x002a
            if (r2 == r3) goto L_0x0021
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0021:
            java.lang.Object r0 = r9.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0111
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d5
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0033 }
            goto L_0x0049
        L_0x0033:
            r10 = move-exception
            goto L_0x0088
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.List<kotlinx.coroutines.Deferred<?>> r10 = r9.$jobs     // Catch:{ all -> 0x0033 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ all -> 0x0033 }
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x0033 }
            r9.label = r7     // Catch:{ all -> 0x0033 }
            java.lang.Object r10 = kotlinx.coroutines.AwaitKt.awaitAll(r10, r2)     // Catch:{ all -> 0x0033 }
            if (r10 != r1) goto L_0x0049
            goto L_0x0110
        L_0x0049:
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0     // Catch:{ all -> 0x0033 }
            com.blueair.adddevice.viewmodel.FinalizeViewModel r10 = r10.getViewModel()     // Catch:{ all -> 0x0033 }
            r10.notifyAnalytics()     // Catch:{ all -> 0x0033 }
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0
            com.blueair.adddevice.viewmodel.FinalizeViewModel r10 = r10.getViewModel()
            java.lang.String r0 = r9.$deviceId
            r10.resubscribeMqttRt5s(r0)
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0
            kotlinx.coroutines.Job r10 = r10.onboardingJob
            if (r10 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r10 = r8
        L_0x0069:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r10, (java.util.concurrent.CancellationException) r8, (int) r7, (java.lang.Object) r8)
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13$1 r0 = new com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13$1
            com.blueair.adddevice.dialog.FinalizeDialog r2 = r9.this$0
            r0.<init>(r2, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.label = r5
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r0, r2)
            if (r10 != r1) goto L_0x00d5
            goto L_0x0110
        L_0x0088:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r5.<init>(r0)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = r10.getMessage()     // Catch:{ all -> 0x00d8 }
            r5.append(r0)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00d8 }
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00d8 }
            r2.e(r10, r0, r5)     // Catch:{ all -> 0x00d8 }
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0
            com.blueair.adddevice.viewmodel.FinalizeViewModel r10 = r10.getViewModel()
            java.lang.String r0 = r9.$deviceId
            r10.resubscribeMqttRt5s(r0)
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0
            kotlinx.coroutines.Job r10 = r10.onboardingJob
            if (r10 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r10 = r8
        L_0x00b7:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r10, (java.util.concurrent.CancellationException) r8, (int) r7, (java.lang.Object) r8)
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13$1 r0 = new com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13$1
            com.blueair.adddevice.dialog.FinalizeDialog r2 = r9.this$0
            r0.<init>(r2, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.label = r4
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r0, r2)
            if (r10 != r1) goto L_0x00d5
            goto L_0x0110
        L_0x00d5:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00d8:
            r10 = move-exception
            r0 = r10
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0
            com.blueair.adddevice.viewmodel.FinalizeViewModel r10 = r10.getViewModel()
            java.lang.String r2 = r9.$deviceId
            r10.resubscribeMqttRt5s(r2)
            com.blueair.adddevice.dialog.FinalizeDialog r10 = r9.this$0
            kotlinx.coroutines.Job r10 = r10.onboardingJob
            if (r10 != 0) goto L_0x00f1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r10 = r8
        L_0x00f1:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r10, (java.util.concurrent.CancellationException) r8, (int) r7, (java.lang.Object) r8)
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13$1 r2 = new com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13$1
            com.blueair.adddevice.dialog.FinalizeDialog r4 = r9.this$0
            r2.<init>(r4, r8)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.L$0 = r0
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r2, r4)
            if (r10 != r1) goto L_0x0111
        L_0x0110:
            return r1
        L_0x0111:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$13.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
