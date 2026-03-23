package com.blueair.auth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService$startAblTokenRefreshingJob$1", f = "AuthService.kt", i = {0, 1, 1, 2}, l = {750, 759, 761}, m = "invokeSuspend", n = {"timeUntilExpiry", "timeUntilExpiry", "nuTimeUntilExpiry", "timeUntilExpiry"}, s = {"J$0", "J$0", "J$1", "J$0"})
/* compiled from: AuthService.kt */
final class AuthService$startAblTokenRefreshingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    long J$1;
    int label;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$startAblTokenRefreshingJob$1(AuthService authService, Continuation<? super AuthService$startAblTokenRefreshingJob$1> continuation) {
        super(2, continuation);
        this.this$0 = authService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthService$startAblTokenRefreshingJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthService$startAblTokenRefreshingJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r9, r11) == r0) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r8, r11) == r0) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r7) goto L_0x0021
            if (r1 == r6) goto L_0x001d
            if (r1 != r5) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007a
        L_0x0021:
            long r7 = r11.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0046
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r12)
            com.blueair.auth.AuthService r12 = r11.this$0
            long r8 = r12.millisUntilAblTokenExpires()
            int r12 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r12 > 0) goto L_0x006c
            com.blueair.auth.AuthService r12 = r11.this$0
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.J$0 = r8
            r11.label = r7
            r5 = 0
            java.lang.Object r12 = com.blueair.auth.AuthService.getAblJwt$default(r12, r2, r1, r7, r5)
            if (r12 != r0) goto L_0x0045
            goto L_0x0079
        L_0x0045:
            r7 = r8
        L_0x0046:
            com.blueair.auth.AuthService r12 = r11.this$0
            long r9 = r12.millisUntilAblTokenExpires()
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 > 0) goto L_0x005c
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.String r1 = "stopAblTokenRefreshingJob: refresh failed!"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r12.w(r1, r2)
            r9 = 300000(0x493e0, double:1.482197E-318)
        L_0x005c:
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r11.J$0 = r7
            r11.J$1 = r9
            r11.label = r6
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r9, r12)
            if (r12 != r0) goto L_0x007a
            goto L_0x0079
        L_0x006c:
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r11.J$0 = r8
            r11.label = r5
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r8, r12)
            if (r12 != r0) goto L_0x007a
        L_0x0079:
            return r0
        L_0x007a:
            com.blueair.auth.AuthService r12 = r11.this$0
            r12.startAblTokenRefreshingJob()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService$startAblTokenRefreshingJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
