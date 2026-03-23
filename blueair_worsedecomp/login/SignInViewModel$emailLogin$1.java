package com.blueair.login;

import com.gigya.android.sdk.account.models.GigyaAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/gigya/android/sdk/account/models/GigyaAccount;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.SignInViewModel$emailLogin$1", f = "SignInViewModel.kt", i = {}, l = {34, 35, 36}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SignInViewModel.kt */
final class SignInViewModel$emailLogin$1 extends SuspendLambda implements Function1<Continuation<? super GigyaAccount>, Object> {
    int label;
    final /* synthetic */ SignInViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignInViewModel$emailLogin$1(SignInViewModel signInViewModel, Continuation<? super SignInViewModel$emailLogin$1> continuation) {
        super(1, continuation);
        this.this$0 = signInViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SignInViewModel$emailLogin$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super GigyaAccount> continuation) {
        return ((SignInViewModel$emailLogin$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        if (r5.this$0.getAuthService().updateGigyaDataCenter(r5) == r0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
        if (r6 == r0) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r6)
            return r6
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0068
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.login.SignInViewModel r6 = r5.this$0
            androidx.lifecycle.MutableLiveData r6 = r6.get_loading()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r6.setValue(r1)
            com.blueair.login.SignInViewModel r6 = r5.this$0
            com.blueair.auth.AuthService r6 = r6.getAuthService()
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r4
            java.lang.Object r6 = r6.updateGigyaDataCenter(r1)
            if (r6 != r0) goto L_0x0047
            goto L_0x009f
        L_0x0047:
            com.blueair.login.SignInViewModel r6 = r5.this$0
            com.blueair.auth.AuthService r6 = r6.getAuthService()
            com.blueair.login.SignInViewModel r1 = r5.this$0
            androidx.lifecycle.MutableLiveData r1 = r1.getEmail()
            java.lang.Object r1 = r1.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r6.doGigyaDataCentersHaveEmailAddress(r1, r4)
            if (r6 != r0) goto L_0x0068
            goto L_0x009f
        L_0x0068:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00a1
            com.blueair.login.SignInViewModel r6 = r5.this$0
            com.blueair.auth.GigyaService r6 = r6.getGigyaService()
            com.blueair.login.SignInViewModel r1 = r5.this$0
            androidx.lifecycle.MutableLiveData r1 = r1.getEmail()
            java.lang.Object r1 = r1.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.blueair.login.SignInViewModel r3 = r5.this$0
            androidx.lifecycle.MutableLiveData r3 = r3.getPassword()
            java.lang.Object r3 = r3.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r2
            java.lang.Object r6 = r6.emailLogin(r1, r3, r4)
            if (r6 != r0) goto L_0x00a0
        L_0x009f:
            return r0
        L_0x00a0:
            return r6
        L_0x00a1:
            java.lang.Exception r6 = new java.lang.Exception
            java.lang.String r0 = "403047"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.SignInViewModel$emailLogin$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
