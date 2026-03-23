package com.blueair.login;

import com.gigya.android.sdk.account.models.GigyaAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.BaseLoginViewModel$authenticateUser$1", f = "BaseLoginViewModel.kt", i = {0, 0, 0, 1, 1}, l = {101, 103}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-BaseLoginViewModel$authenticateUser$1$accountResult$1", "$this$launch", "accountResult"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1"})
/* compiled from: BaseLoginViewModel.kt */
final class BaseLoginViewModel$authenticateUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super GigyaAccount>, Object> $accountGetter;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseLoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseLoginViewModel$authenticateUser$1(BaseLoginViewModel baseLoginViewModel, Function1<? super Continuation<? super GigyaAccount>, ? extends Object> function1, Continuation<? super BaseLoginViewModel$authenticateUser$1> continuation) {
        super(2, continuation);
        this.this$0 = baseLoginViewModel;
        this.$accountGetter = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseLoginViewModel$authenticateUser$1 baseLoginViewModel$authenticateUser$1 = new BaseLoginViewModel$authenticateUser$1(this.this$0, this.$accountGetter, continuation);
        baseLoginViewModel$authenticateUser$1.L$0 = obj;
        return baseLoginViewModel$authenticateUser$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseLoginViewModel$authenticateUser$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        if (r9 == r1) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0028
            if (r2 == r5) goto L_0x0020
            if (r2 != r4) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008d
        L_0x0018:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0020:
            java.lang.Object r2 = r8.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x004d }
            goto L_0x0046
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super com.gigya.android.sdk.account.models.GigyaAccount>, java.lang.Object> r9 = r8.$accountGetter
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x004d }
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x004d }
            r8.L$0 = r2     // Catch:{ all -> 0x004d }
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x004d }
            r8.L$1 = r2     // Catch:{ all -> 0x004d }
            r8.I$0 = r3     // Catch:{ all -> 0x004d }
            r8.label = r5     // Catch:{ all -> 0x004d }
            java.lang.Object r9 = r9.invoke(r8)     // Catch:{ all -> 0x004d }
            if (r9 != r1) goto L_0x0046
            goto L_0x008c
        L_0x0046:
            com.gigya.android.sdk.account.models.GigyaAccount r9 = (com.gigya.android.sdk.account.models.GigyaAccount) r9     // Catch:{ all -> 0x004d }
            java.lang.Object r9 = kotlin.Result.m9366constructorimpl(r9)     // Catch:{ all -> 0x004d }
            goto L_0x0058
        L_0x004d:
            r9 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m9366constructorimpl(r9)
        L_0x0058:
            com.blueair.login.BaseLoginViewModel r2 = r8.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.get_loading()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r2.setValue(r5)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.blueair.login.BaseLoginViewModel$authenticateUser$1$failure$1 r5 = new com.blueair.login.BaseLoginViewModel$authenticateUser$1$failure$1
            com.blueair.login.BaseLoginViewModel r6 = r8.this$0
            r7 = 0
            r5.<init>(r9, r6, r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r8.L$0 = r0
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$1 = r9
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r2, r5, r6)
            if (r9 != r1) goto L_0x008d
        L_0x008c:
            return r1
        L_0x008d:
            com.blueair.login.LoginFailure r9 = (com.blueair.login.LoginFailure) r9
            com.blueair.login.BaseLoginViewModel r0 = r8.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.get_loading()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r0.setValue(r1)
            if (r9 == 0) goto L_0x00a8
            com.blueair.login.BaseLoginViewModel r0 = r8.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.get_failure()
            r0.setValue(r9)
            goto L_0x00c0
        L_0x00a8:
            com.blueair.login.BaseLoginViewModel r9 = r8.this$0
            androidx.lifecycle.MutableLiveData r9 = r9._loginFinished
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r9.setValue(r0)
            com.blueair.login.BaseLoginViewModel r9 = r8.this$0
            com.blueair.core.service.HappyUserService r9 = r9.getHappyUserService()
            long r0 = java.lang.System.currentTimeMillis()
            r9.setSignUpStamp(r0)
        L_0x00c0:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.BaseLoginViewModel$authenticateUser$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
