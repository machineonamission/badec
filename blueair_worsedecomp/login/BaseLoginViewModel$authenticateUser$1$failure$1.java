package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/blueair/login/LoginFailure;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.BaseLoginViewModel$authenticateUser$1$failure$1", f = "BaseLoginViewModel.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {113, 117, 120, 121}, m = "invokeSuspend", n = {"account", "email", "uid", "account", "email", "uid", "account", "email", "uid", "account", "email", "uid"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: BaseLoginViewModel.kt */
final class BaseLoginViewModel$authenticateUser$1$failure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoginFailure>, Object> {
    final /* synthetic */ Object $accountResult;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BaseLoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseLoginViewModel$authenticateUser$1$failure$1(Object obj, BaseLoginViewModel baseLoginViewModel, Continuation<? super BaseLoginViewModel$authenticateUser$1$failure$1> continuation) {
        super(2, continuation);
        this.$accountResult = obj;
        this.this$0 = baseLoginViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseLoginViewModel$authenticateUser$1$failure$1(this.$accountResult, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoginFailure> continuation) {
        return ((BaseLoginViewModel$authenticateUser$1$failure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.gigya.android.sdk.account.models.GigyaAccount} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 4
            r3 = 3
            r4 = 1
            r5 = 0
            r6 = 2
            if (r1 == 0) goto L_0x0061
            if (r1 == r4) goto L_0x0050
            if (r1 == r6) goto L_0x003f
            if (r1 == r3) goto L_0x002e
            if (r1 != r2) goto L_0x0026
            java.lang.Object r0 = r12.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r12.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r12.L$0
            com.gigya.android.sdk.account.models.GigyaAccount r0 = (com.gigya.android.sdk.account.models.GigyaAccount) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x015f
        L_0x0026:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002e:
            java.lang.Object r1 = r12.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r12.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r12.L$0
            com.gigya.android.sdk.account.models.GigyaAccount r4 = (com.gigya.android.sdk.account.models.GigyaAccount) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x013b
        L_0x003f:
            java.lang.Object r1 = r12.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r12.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r12.L$0
            com.gigya.android.sdk.account.models.GigyaAccount r6 = (com.gigya.android.sdk.account.models.GigyaAccount) r6
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0113
        L_0x0050:
            java.lang.Object r1 = r12.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r12.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r7 = r12.L$0
            com.gigya.android.sdk.account.models.GigyaAccount r7 = (com.gigya.android.sdk.account.models.GigyaAccount) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00da
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.$accountResult
            boolean r13 = kotlin.Result.m9372isFailureimpl(r13)
            if (r13 == 0) goto L_0x0087
            java.lang.Object r13 = r12.$accountResult
            java.lang.Throwable r13 = kotlin.Result.m9369exceptionOrNullimpl(r13)
            boolean r13 = r13 instanceof java.util.concurrent.CancellationException
            if (r13 == 0) goto L_0x0079
            com.blueair.login.LoginFailure r13 = com.blueair.login.LoginFailure.CANCELED
            return r13
        L_0x0079:
            com.blueair.login.LoginFailure$Companion r13 = com.blueair.login.LoginFailure.Companion
            java.lang.Object r0 = r12.$accountResult
            java.lang.Throwable r0 = kotlin.Result.m9369exceptionOrNullimpl(r0)
            r1 = 0
            com.blueair.login.LoginFailure r13 = com.blueair.login.LoginFailure.Companion.fromCode$default(r13, r0, r1, r6, r5)
            return r13
        L_0x0087:
            java.lang.Object r13 = r12.$accountResult
            kotlin.ResultKt.throwOnFailure(r13)
            r7 = r13
            com.gigya.android.sdk.account.models.GigyaAccount r7 = (com.gigya.android.sdk.account.models.GigyaAccount) r7
            com.gigya.android.sdk.account.models.Profile r13 = r7.getProfile()
            if (r13 == 0) goto L_0x009a
            java.lang.String r13 = r13.getEmail()
            goto L_0x009b
        L_0x009a:
            r13 = r5
        L_0x009b:
            java.lang.String r1 = r7.getUID()
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r1)
            java.lang.Object r1 = r13.component1()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r13 = r13.component2()
            java.lang.String r13 = (java.lang.String) r13
            if (r1 != 0) goto L_0x00b4
            com.blueair.login.LoginFailure r13 = com.blueair.login.LoginFailure.SERVER_ERROR
            return r13
        L_0x00b4:
            if (r13 != 0) goto L_0x00b9
            com.blueair.login.LoginFailure r13 = com.blueair.login.LoginFailure.SERVER_ERROR
            return r13
        L_0x00b9:
            com.blueair.login.BaseLoginViewModel r8 = r12.this$0
            com.blueair.auth.GigyaService r8 = r8.getGigyaService()
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r12.L$0 = r10
            r12.L$1 = r1
            r12.L$2 = r13
            r12.label = r4
            java.lang.Object r4 = r8.refreshGigyaJwt(r9)
            if (r4 != r0) goto L_0x00d6
            goto L_0x015e
        L_0x00d6:
            r11 = r1
            r1 = r13
            r13 = r4
            r4 = r11
        L_0x00da:
            java.lang.String r13 = (java.lang.String) r13
            if (r13 != 0) goto L_0x00e1
            com.blueair.login.LoginFailure r13 = com.blueair.login.LoginFailure.SERVER_ERROR
            return r13
        L_0x00e1:
            com.blueair.core.util.UserInfoCollectionsManager r13 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.login.BaseLoginViewModel r8 = r12.this$0
            android.app.Application r8 = r8.getApplication()
            android.content.Context r8 = (android.content.Context) r8
            r13.initializeCollections(r4, r8)
            com.blueair.login.BaseLoginViewModel r13 = r12.this$0
            com.blueair.auth.AuthService r13 = r13.getAuthService()
            r8 = r12
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r12.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r12.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r12.L$2 = r9
            r12.label = r6
            java.lang.Object r13 = r13.authenticateAblUser(r4, r1, r8)
            if (r13 != r0) goto L_0x0112
            goto L_0x015e
        L_0x0112:
            r6 = r7
        L_0x0113:
            com.blueair.devicemanager.DeviceManager$Companion r13 = com.blueair.devicemanager.DeviceManager.Companion
            com.blueair.login.BaseLoginViewModel r7 = r12.this$0
            com.blueair.devicemanager.DeviceManager r7 = r7.getDeviceManager()
            r8 = r12
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r12.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r12.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r12.L$2 = r9
            r12.label = r3
            java.lang.Object r13 = r13.downloadDeviceList(r7, r8)
            if (r13 != r0) goto L_0x0139
            goto L_0x015e
        L_0x0139:
            r3 = r4
            r4 = r6
        L_0x013b:
            com.blueair.login.BaseLoginViewModel r13 = r12.this$0
            com.blueair.outdoor.service.OutdoorService r13 = r13.getOutdoorService()
            r6 = r12
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r12.L$0 = r4
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r12.L$1 = r3
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r12.L$2 = r1
            r12.label = r2
            java.lang.Object r13 = r13.downloadTrackedLocations(r6)
            if (r13 != r0) goto L_0x015f
        L_0x015e:
            return r0
        L_0x015f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.BaseLoginViewModel$authenticateUser$1$failure$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
