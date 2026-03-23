package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.ProfileViewModel$updateProfile$1", f = "ProfileViewModel.kt", i = {0, 0, 0, 0, 0}, l = {156}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u241", "it", "$i$a$-runCatching-ProfileViewModel$updateProfile$1$result$1", "$i$a$-also-ProfileViewModel$updateProfile$1$result$1$1"}, s = {"L$0", "L$1", "L$3", "I$0", "I$1"})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$updateProfile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileViewModel$updateProfile$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$updateProfile$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$updateProfile$1 profileViewModel$updateProfile$1 = new ProfileViewModel$updateProfile$1(this.this$0, continuation);
        profileViewModel$updateProfile$1.L$0 = obj;
        return profileViewModel$updateProfile$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$updateProfile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x002c
            if (r2 != r4) goto L_0x0024
            java.lang.Object r0 = r6.L$3
            com.blueair.auth.GigyaAccountExtended r0 = (com.blueair.auth.GigyaAccountExtended) r0
            java.lang.Object r0 = r6.L$2
            com.blueair.auth.GigyaAccountExtended r0 = (com.blueair.auth.GigyaAccountExtended) r0
            java.lang.Object r1 = r6.L$1
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0123
        L_0x0021:
            r7 = move-exception
            goto L_0x0129
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.core.BuildEnvironment r7 = com.blueair.core.BuildEnvironment.INSTANCE
            boolean r7 = r7.isChina()
            if (r7 == 0) goto L_0x0073
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getFirstName()
            java.lang.Object r7 = r7.getValue()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r2 = "-"
            if (r7 == 0) goto L_0x004d
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0056
        L_0x004d:
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getFirstName()
            r7.setValue(r2)
        L_0x0056:
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getLastName()
            java.lang.Object r7 = r7.getValue()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x006a
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0073
        L_0x006a:
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getLastName()
            r7.setValue(r2)
        L_0x0073:
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getFirstNameValid()
            com.blueair.login.ProfileViewModel r2 = r6.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.getFirstName()
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r5 = 0
            if (r2 == 0) goto L_0x0094
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            r2 = r2 ^ r4
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            goto L_0x0095
        L_0x0094:
            r2 = r5
        L_0x0095:
            r7.setValue(r2)
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getLastNameValid()
            com.blueair.login.ProfileViewModel r2 = r6.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.getLastName()
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00b8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            r2 = r2 ^ r4
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            goto L_0x00b9
        L_0x00b8:
            r2 = r5
        L_0x00b9:
            r7.setValue(r2)
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getFirstNameValid()
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r2)
            if (r7 == 0) goto L_0x0169
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getLastNameValid()
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r2)
            if (r7 != 0) goto L_0x00e6
            goto L_0x0169
        L_0x00e6:
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7._loading
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r7.setValue(r2)
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0021 }
            com.blueair.auth.GigyaAccountExtended r2 = r7.account     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0124
            com.blueair.auth.GigyaService r7 = r7.getGigyaService()     // Catch:{ all -> 0x0021 }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x0021 }
            r6.L$0 = r5     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x0021 }
            r6.L$1 = r0     // Catch:{ all -> 0x0021 }
            r6.L$2 = r2     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch:{ all -> 0x0021 }
            r6.L$3 = r0     // Catch:{ all -> 0x0021 }
            r6.I$0 = r3     // Catch:{ all -> 0x0021 }
            r6.I$1 = r3     // Catch:{ all -> 0x0021 }
            r6.label = r4     // Catch:{ all -> 0x0021 }
            java.lang.Object r7 = r7.updateProfile(r2, r4, r6)     // Catch:{ all -> 0x0021 }
            if (r7 != r1) goto L_0x0122
            return r1
        L_0x0122:
            r0 = r2
        L_0x0123:
            r5 = r0
        L_0x0124:
            java.lang.Object r7 = kotlin.Result.m9366constructorimpl(r5)     // Catch:{ all -> 0x0021 }
            goto L_0x0133
        L_0x0129:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m9366constructorimpl(r7)
        L_0x0133:
            com.blueair.login.ProfileViewModel r0 = r6.this$0
            androidx.lifecycle.MutableLiveData r0 = r0._loading
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r0.setValue(r1)
            boolean r0 = kotlin.Result.m9372isFailureimpl(r7)
            if (r0 == 0) goto L_0x015b
            com.blueair.login.ProfileViewModel r0 = r6.this$0
            androidx.lifecycle.MutableLiveData r0 = r0._failure
            java.lang.Throwable r7 = kotlin.Result.m9369exceptionOrNullimpl(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r7 = r7.getMessage()
            r0.setValue(r7)
            goto L_0x0166
        L_0x015b:
            com.blueair.login.ProfileViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7._success
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r7.setValue(r0)
        L_0x0166:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0169:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.ProfileViewModel$updateProfile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
