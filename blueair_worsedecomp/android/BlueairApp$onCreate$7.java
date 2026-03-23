package com.blueair.android;

import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LogOutService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.BlueairApp$onCreate$7", f = "BlueairApp.kt", i = {0, 1, 1, 1}, l = {247, 249}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-BlueairApp$onCreate$7$profileDisabled$1"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* compiled from: BlueairApp.kt */
final class BlueairApp$onCreate$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<AuthService> $authService$delegate;
    final /* synthetic */ Lazy<GigyaService> $gigyaService$delegate;
    final /* synthetic */ Lazy<LogOutService> $logoutService$delegate;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlueairApp$onCreate$7(Lazy<AuthService> lazy, Lazy<GigyaService> lazy2, Lazy<LogOutService> lazy3, Continuation<? super BlueairApp$onCreate$7> continuation) {
        super(2, continuation);
        this.$authService$delegate = lazy;
        this.$gigyaService$delegate = lazy2;
        this.$logoutService$delegate = lazy3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BlueairApp$onCreate$7 blueairApp$onCreate$7 = new BlueairApp$onCreate$7(this.$authService$delegate, this.$gigyaService$delegate, this.$logoutService$delegate, continuation);
        blueairApp$onCreate$7.L$0 = obj;
        return blueairApp$onCreate$7;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BlueairApp$onCreate$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (com.blueair.android.BlueairApp.onCreate$lambda$12(r5.$authService$delegate).updateLanguage(r5) == r1) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        if (r6 == r1) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r5.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0028
            if (r2 == r4) goto L_0x0024
            if (r2 != r3) goto L_0x001c
            java.lang.Object r0 = r5.L$1
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x001a }
            goto L_0x005f
        L_0x001a:
            r6 = move-exception
            goto L_0x0066
        L_0x001c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Lazy<com.blueair.auth.AuthService> r6 = r5.$authService$delegate
            com.blueair.auth.AuthService r6 = com.blueair.android.BlueairApp.onCreate$lambda$12(r6)
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r5.L$0 = r0
            r5.label = r4
            java.lang.Object r6 = r6.updateLanguage(r2)
            if (r6 != r1) goto L_0x003f
            goto L_0x005e
        L_0x003f:
            kotlin.Lazy<com.blueair.auth.GigyaService> r6 = r5.$gigyaService$delegate
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x001a }
            com.blueair.auth.GigyaService r6 = com.blueair.android.BlueairApp.onCreate$lambda$19(r6)     // Catch:{ all -> 0x001a }
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x001a }
            r5.L$0 = r2     // Catch:{ all -> 0x001a }
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x001a }
            r5.L$1 = r0     // Catch:{ all -> 0x001a }
            r0 = 0
            r5.I$0 = r0     // Catch:{ all -> 0x001a }
            r5.label = r3     // Catch:{ all -> 0x001a }
            java.lang.Object r6 = r6.getProfile(r5)     // Catch:{ all -> 0x001a }
            if (r6 != r1) goto L_0x005f
        L_0x005e:
            return r1
        L_0x005f:
            com.blueair.auth.GigyaAccountExtended r6 = (com.blueair.auth.GigyaAccountExtended) r6     // Catch:{ all -> 0x001a }
            java.lang.Object r6 = kotlin.Result.m9366constructorimpl(r6)     // Catch:{ all -> 0x001a }
            goto L_0x0070
        L_0x0066:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m9366constructorimpl(r6)
        L_0x0070:
            boolean r0 = kotlin.Result.m9372isFailureimpl(r6)
            r1 = 0
            if (r0 == 0) goto L_0x0078
            r6 = r1
        L_0x0078:
            com.blueair.auth.GigyaAccountExtended r6 = (com.blueair.auth.GigyaAccountExtended) r6
            if (r6 == 0) goto L_0x0084
            boolean r6 = r6.getDisabled()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0084:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0099
            kotlin.Lazy<com.blueair.auth.LogOutService> r6 = r5.$logoutService$delegate
            com.blueair.auth.LogOutService r6 = com.blueair.android.BlueairApp.onCreate$lambda$18(r6)
            com.blueair.auth.LogoutReason r0 = com.blueair.auth.LogoutReason.ACCOUNT_DISABLED
            r6.logOutRegistered(r0)
        L_0x0099:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.BlueairApp$onCreate$7.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
