package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.ForgotPasswordViewModel$forgotPassword$1", f = "ForgotPasswordViewModel.kt", i = {1, 1, 2}, l = {34, 35, 40}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ForgotPasswordViewModel$forgotPassword$1$forgotResult$1", "forgotResult"}, s = {"L$0", "I$0", "L$0"})
/* compiled from: ForgotPasswordViewModel.kt */
final class ForgotPasswordViewModel$forgotPassword$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ ForgotPasswordViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForgotPasswordViewModel$forgotPassword$1(ForgotPasswordViewModel forgotPasswordViewModel, Continuation<? super ForgotPasswordViewModel$forgotPassword$1> continuation) {
        super(1, continuation);
        this.this$0 = forgotPasswordViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ForgotPasswordViewModel$forgotPassword$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ForgotPasswordViewModel$forgotPassword$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r7.this$0._forgotPasswordFailure.emit(null, r7) == r0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
        if (r7.this$0._forgotPasswordFailure.emit(com.blueair.login.LoginFailure.Companion.fromCode(kotlin.Result.m9369exceptionOrNullimpl(r8), true), r7) == r0) goto L_0x00d0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002c
            if (r1 == r4) goto L_0x0028
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00d1
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            java.lang.Object r1 = r7.L$0
            com.blueair.login.ForgotPasswordViewModel r1 = (com.blueair.login.ForgotPasswordViewModel) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0026 }
            goto L_0x006a
        L_0x0026:
            r8 = move-exception
            goto L_0x0071
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0043
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.login.ForgotPasswordViewModel r8 = r7.this$0
            kotlinx.coroutines.flow.MutableStateFlow r8 = r8._forgotPasswordFailure
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r4
            r5 = 0
            java.lang.Object r8 = r8.emit(r5, r1)
            if (r8 != r0) goto L_0x0043
            goto L_0x00d0
        L_0x0043:
            com.blueair.login.ForgotPasswordViewModel r8 = r7.this$0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0026 }
            com.blueair.auth.GigyaService r1 = r8.getGigyaService()     // Catch:{ all -> 0x0026 }
            androidx.lifecycle.MutableLiveData r5 = r8.getEmail()     // Catch:{ all -> 0x0026 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0026 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x0026 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0026 }
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch:{ all -> 0x0026 }
            r7.L$0 = r8     // Catch:{ all -> 0x0026 }
            r8 = 0
            r7.I$0 = r8     // Catch:{ all -> 0x0026 }
            r7.label = r3     // Catch:{ all -> 0x0026 }
            java.lang.Object r8 = r1.forgotPassword(r5, r7)     // Catch:{ all -> 0x0026 }
            if (r8 != r0) goto L_0x006a
            goto L_0x00d0
        L_0x006a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0026 }
            java.lang.Object r8 = kotlin.Result.m9366constructorimpl(r8)     // Catch:{ all -> 0x0026 }
            goto L_0x007b
        L_0x0071:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m9366constructorimpl(r8)
        L_0x007b:
            com.blueair.login.ForgotPasswordViewModel r1 = r7.this$0
            com.blueair.core.service.AnalyticsService r1 = r1.getAnalyticsService()
            com.blueair.core.model.AnalyticEvent$ForgotPasswordEvent r3 = new com.blueair.core.model.AnalyticEvent$ForgotPasswordEvent
            boolean r5 = kotlin.Result.m9373isSuccessimpl(r8)
            java.lang.Throwable r6 = kotlin.Result.m9369exceptionOrNullimpl(r8)
            if (r6 == 0) goto L_0x0093
            java.lang.String r6 = r6.getMessage()
            if (r6 != 0) goto L_0x0095
        L_0x0093:
            java.lang.String r6 = ""
        L_0x0095:
            r3.<init>(r5, r6)
            com.blueair.core.model.AnalyticEvent r3 = (com.blueair.core.model.AnalyticEvent) r3
            r1.event(r3)
            boolean r1 = kotlin.Result.m9373isSuccessimpl(r8)
            if (r1 == 0) goto L_0x00af
            com.blueair.login.ForgotPasswordViewModel r8 = r7.this$0
            androidx.lifecycle.MutableLiveData r8 = r8._forgotFinished
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8.setValue(r0)
            goto L_0x00d1
        L_0x00af:
            com.blueair.login.ForgotPasswordViewModel r1 = r7.this$0
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1._forgotPasswordFailure
            com.blueair.login.LoginFailure$Companion r3 = com.blueair.login.LoginFailure.Companion
            java.lang.Throwable r5 = kotlin.Result.m9369exceptionOrNullimpl(r8)
            com.blueair.login.LoginFailure r3 = r3.fromCode(r5, r4)
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r8 = r1.emit(r3, r4)
            if (r8 != r0) goto L_0x00d1
        L_0x00d0:
            return r0
        L_0x00d1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.ForgotPasswordViewModel$forgotPassword$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
