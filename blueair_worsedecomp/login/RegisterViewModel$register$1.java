package com.blueair.login;

import com.gigya.android.sdk.account.models.GigyaAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/gigya/android/sdk/account/models/GigyaAccount;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.RegisterViewModel$register$1", f = "RegisterViewModel.kt", i = {2}, l = {73, 75, 77}, m = "invokeSuspend", n = {"userAlreadyExists"}, s = {"Z$0"})
/* compiled from: RegisterViewModel.kt */
final class RegisterViewModel$register$1 extends SuspendLambda implements Function1<Continuation<? super GigyaAccount>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ RegisterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterViewModel$register$1(RegisterViewModel registerViewModel, Continuation<? super RegisterViewModel$register$1> continuation) {
        super(1, continuation);
        this.this$0 = registerViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RegisterViewModel$register$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super GigyaAccount> continuation) {
        return ((RegisterViewModel$register$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (com.blueair.login.RegisterViewModel.access$updateGigyaDataCenter(r12.this$0, r12) == r0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (r13 == r0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0119, code lost:
        if (r13 == r0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011b, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002c
            if (r1 == r4) goto L_0x0028
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            boolean r1 = r12.Z$0
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0018 }
            goto L_0x011c
        L_0x0018:
            r0 = move-exception
            r13 = r0
            goto L_0x011f
        L_0x001c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0081
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005f
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r13)
            com.blueair.login.RegisterViewModel r13 = r12.this$0
            androidx.lifecycle.MutableLiveData r13 = r13.get_loading()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r13.setValue(r1)
            com.blueair.login.RegisterViewModel r13 = r12.this$0
            androidx.lifecycle.MutableLiveData r13 = r13._dataCenter
            java.lang.Object r13 = r13.getValue()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 == 0) goto L_0x0050
            int r13 = r13.length()
            if (r13 != 0) goto L_0x005f
        L_0x0050:
            com.blueair.login.RegisterViewModel r13 = r12.this$0
            r1 = r12
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r12.label = r4
            java.lang.Object r13 = r13.updateGigyaDataCenter(r1)
            if (r13 != r0) goto L_0x005f
            goto L_0x011b
        L_0x005f:
            com.blueair.login.RegisterViewModel r13 = r12.this$0
            com.blueair.auth.AuthService r13 = r13.getAuthService()
            com.blueair.login.RegisterViewModel r1 = r12.this$0
            androidx.lifecycle.MutableLiveData r1 = r1.getEmail()
            java.lang.Object r1 = r1.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r12.label = r3
            java.lang.Object r13 = r13.doGigyaDataCentersHaveEmailAddress(r1, r4)
            if (r13 != r0) goto L_0x0081
            goto L_0x011b
        L_0x0081:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
            com.blueair.login.RegisterViewModel r13 = r12.this$0     // Catch:{ all -> 0x0018 }
            com.blueair.auth.GigyaService r3 = r13.getGigyaService()     // Catch:{ all -> 0x0018 }
            com.blueair.core.BuildEnvironment r13 = com.blueair.core.BuildEnvironment.INSTANCE     // Catch:{ all -> 0x0018 }
            boolean r13 = r13.isChina()     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = "-"
            if (r13 == 0) goto L_0x0099
            r13 = r4
            goto L_0x00a8
        L_0x0099:
            com.blueair.login.RegisterViewModel r13 = r12.this$0     // Catch:{ all -> 0x0018 }
            androidx.lifecycle.MutableLiveData r13 = r13.getFirstName()     // Catch:{ all -> 0x0018 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ all -> 0x0018 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x0018 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0018 }
        L_0x00a8:
            com.blueair.core.BuildEnvironment r5 = com.blueair.core.BuildEnvironment.INSTANCE     // Catch:{ all -> 0x0018 }
            boolean r5 = r5.isChina()     // Catch:{ all -> 0x0018 }
            if (r5 == 0) goto L_0x00b2
        L_0x00b0:
            r5 = r4
            goto L_0x00c2
        L_0x00b2:
            com.blueair.login.RegisterViewModel r4 = r12.this$0     // Catch:{ all -> 0x0018 }
            androidx.lifecycle.MutableLiveData r4 = r4.getLastName()     // Catch:{ all -> 0x0018 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0018 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0018 }
            goto L_0x00b0
        L_0x00c2:
            com.blueair.login.RegisterViewModel r4 = r12.this$0     // Catch:{ all -> 0x0018 }
            androidx.lifecycle.MutableLiveData r4 = r4.getEmail()     // Catch:{ all -> 0x0018 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0018 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0018 }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0018 }
            com.blueair.login.RegisterViewModel r4 = r12.this$0     // Catch:{ all -> 0x0018 }
            androidx.lifecycle.MutableLiveData r4 = r4.getPassword()     // Catch:{ all -> 0x0018 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0018 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0018 }
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0018 }
            java.lang.String r8 = ""
            com.blueair.login.RegisterViewModel r4 = r12.this$0     // Catch:{ all -> 0x0018 }
            androidx.lifecycle.MutableLiveData r4 = r4.getConfirmSubscribe()     // Catch:{ all -> 0x0018 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0018 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0018 }
            r9 = 0
            if (r4 == 0) goto L_0x00f8
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0018 }
            goto L_0x00f9
        L_0x00f8:
            r4 = r9
        L_0x00f9:
            com.blueair.login.RegisterViewModel r10 = r12.this$0     // Catch:{ all -> 0x0018 }
            androidx.lifecycle.MutableLiveData r10 = r10.getConfirmConsentDate()     // Catch:{ all -> 0x0018 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0018 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0018 }
            if (r10 == 0) goto L_0x010b
            boolean r9 = r10.booleanValue()     // Catch:{ all -> 0x0018 }
        L_0x010b:
            r10 = r9
            r11 = r12
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x0018 }
            r12.Z$0 = r1     // Catch:{ all -> 0x0018 }
            r12.label = r2     // Catch:{ all -> 0x0018 }
            r9 = r4
            r4 = r13
            java.lang.Object r13 = r3.emailRegister(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0018 }
            if (r13 != r0) goto L_0x011c
        L_0x011b:
            return r0
        L_0x011c:
            com.gigya.android.sdk.account.models.GigyaAccount r13 = (com.gigya.android.sdk.account.models.GigyaAccount) r13     // Catch:{ all -> 0x0018 }
            return r13
        L_0x011f:
            java.lang.String r0 = r13.getMessage()
            java.lang.String r2 = "400009"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0135
            if (r1 == 0) goto L_0x0135
            java.lang.Exception r13 = new java.lang.Exception
            java.lang.String r0 = "400009-1"
            r13.<init>(r0)
            throw r13
        L_0x0135:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.RegisterViewModel$register$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
