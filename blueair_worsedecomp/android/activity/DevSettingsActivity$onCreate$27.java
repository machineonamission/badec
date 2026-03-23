package com.blueair.android.activity;

import com.blueair.auth.AuthService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.activity.DevSettingsActivity$onCreate$27", f = "DevSettingsActivity.kt", i = {1}, l = {170, 171}, m = "invokeSuspend", n = {"cloudToken"}, s = {"L$0"})
/* compiled from: DevSettingsActivity.kt */
final class DevSettingsActivity$onCreate$27 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<AuthService> $authService$delegate;
    Object L$0;
    int label;
    final /* synthetic */ DevSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DevSettingsActivity$onCreate$27(Lazy<AuthService> lazy, DevSettingsActivity devSettingsActivity, Continuation<? super DevSettingsActivity$onCreate$27> continuation) {
        super(2, continuation);
        this.$authService$delegate = lazy;
        this.this$0 = devSettingsActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevSettingsActivity$onCreate$27(this.$authService$delegate, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevSettingsActivity$onCreate$27) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.android.activity.DevSettingsActivity$onCreate$27.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.android.activity.DevSettingsActivity$onCreate$27.AnonymousClass1>) null), r6) == r0) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r7 == r0) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r6.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0037
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Lazy<com.blueair.auth.AuthService> r7 = r6.$authService$delegate
            com.blueair.auth.AuthService r7 = com.blueair.android.activity.DevSettingsActivity.onCreate$lambda$27(r7)
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r3
            java.lang.Object r7 = r7.getCloudJwt(r1)
            if (r7 != r0) goto L_0x0037
            goto L_0x005a
        L_0x0037:
            java.lang.String r7 = (java.lang.String) r7
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.blueair.android.activity.DevSettingsActivity$onCreate$27$1 r3 = new com.blueair.android.activity.DevSettingsActivity$onCreate$27$1
            com.blueair.android.activity.DevSettingsActivity r4 = r6.this$0
            r5 = 0
            r3.<init>(r4, r7, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4)
            if (r7 != r0) goto L_0x005b
        L_0x005a:
            return r0
        L_0x005b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.DevSettingsActivity$onCreate$27.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
