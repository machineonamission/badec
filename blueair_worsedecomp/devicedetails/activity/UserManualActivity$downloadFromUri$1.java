package com.blueair.devicedetails.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1", f = "UserManualActivity.kt", i = {}, l = {66, 66, 91}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UserManualActivity.kt */
final class UserManualActivity$downloadFromUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ UserManualActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserManualActivity$downloadFromUri$1(UserManualActivity userManualActivity, String str, Continuation<? super UserManualActivity$downloadFromUri$1> continuation) {
        super(2, continuation);
        this.this$0 = userManualActivity;
        this.$url = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserManualActivity$downloadFromUri$1(this.this$0, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserManualActivity$downloadFromUri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r8 == r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r8 == r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r8, new com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1.AnonymousClass2>) null), r7) == r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r5) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006d
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003d
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.devicedetails.activity.UserManualActivity r8 = r7.this$0
            com.blueair.devicedetails.viewmodel.UserManualViewModel r8 = r8.getViewModel()
            java.lang.String r1 = r7.$url
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r5
            java.lang.Object r8 = r8.downloadFile(r1, r6)
            if (r8 != r0) goto L_0x003d
            goto L_0x006c
        L_0x003d:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1$1 r1 = new com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1$1
            com.blueair.devicedetails.activity.UserManualActivity r5 = r7.this$0
            java.lang.String r6 = r7.$url
            r1.<init>(r5, r6, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r4
            java.lang.Object r8 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r8, r1, r5)
            if (r8 != r0) goto L_0x0056
            goto L_0x006c
        L_0x0056:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1$2 r1 = new com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1$2
            com.blueair.devicedetails.activity.UserManualActivity r4 = r7.this$0
            r1.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.label = r3
            java.lang.Object r8 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r8, r1, r2)
            if (r8 != r0) goto L_0x006d
        L_0x006c:
            return r0
        L_0x006d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.activity.UserManualActivity$downloadFromUri$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
