package com.blueair.auth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService$updateHomeHost$1", f = "AuthService.kt", i = {1}, l = {628, 637}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* compiled from: AuthService.kt */
final class AuthService$updateHomeHost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$updateHomeHost$1(AuthService authService, Continuation<? super AuthService$updateHomeHost$1> continuation) {
        super(2, continuation);
        this.this$0 = authService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthService$updateHomeHost$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthService$updateHomeHost$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0095, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, new com.blueair.auth.AuthService$updateHomeHost$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.auth.AuthService$updateHomeHost$1.AnonymousClass1>) null), r6) == r0) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0097, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        if (r7 == r0) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r6.L$0
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0098
        L_0x0017:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0045
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.auth.AuthService$updateHomeHost$1$response$1 r7 = new com.blueair.auth.AuthService$updateHomeHost$1$response$1
            com.blueair.auth.AuthService r1 = r6.this$0
            com.blueair.auth.retrofit.AblUserApi r1 = r1.userApi
            r7.<init>(r1)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            com.blueair.auth.AuthService r1 = r6.this$0
            java.lang.String r1 = r1.getUsername()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r7 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r7, r1, r4)
            if (r7 != r0) goto L_0x0045
            goto L_0x0097
        L_0x0045:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getHomeHost: response = "
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r1.d(r3, r5)
            boolean r1 = r7.isFailure()
            if (r1 == 0) goto L_0x007c
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r3 = "getHomeHost returned failure"
            r1.<init>(r3)
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.Throwable r5 = r7.exceptionOrNull()
            if (r5 != 0) goto L_0x0075
            r5 = r1
            java.lang.Throwable r5 = (java.lang.Throwable) r5
        L_0x0075:
            java.lang.String r1 = "loginUser: getHomeHost() failed"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r3.e(r5, r1, r4)
        L_0x007c:
            com.blueair.auth.AuthService$updateHomeHost$1$1 r1 = new com.blueair.auth.AuthService$updateHomeHost$1$1
            com.blueair.auth.AuthService r3 = r6.this$0
            r4 = 0
            r1.<init>(r3, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r1, r3)
            if (r7 != r0) goto L_0x0098
        L_0x0097:
            return r0
        L_0x0098:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService$updateHomeHost$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
