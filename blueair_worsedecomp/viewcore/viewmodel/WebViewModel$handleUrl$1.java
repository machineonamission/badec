package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1", f = "WebViewModel.kt", i = {0, 1, 2}, l = {20, 20, 21}, m = "invokeSuspend", n = {"link", "link", "link"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: WebViewModel.kt */
final class WebViewModel$handleUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onResult;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ WebViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewModel$handleUrl$1(String str, WebViewModel webViewModel, Function1<? super String, Unit> function1, Continuation<? super WebViewModel$handleUrl$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = webViewModel;
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewModel$handleUrl$1(this.$url, this.this$0, this.$onResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewModel$handleUrl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0076, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r11, new com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1.AnonymousClass1>) null), r10) == r0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0097, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1.AnonymousClass2>) null), r10) == r0) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r5) goto L_0x002b
            if (r1 == r4) goto L_0x0023
            if (r1 != r3) goto L_0x001b
            java.lang.Object r0 = r10.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009a
        L_0x001b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0023:
            java.lang.Object r1 = r10.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0079
        L_0x002b:
            java.lang.Object r1 = r10.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0062
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.lang.String r1 = r10.$url
            r11.element = r1
            com.blueair.viewcore.viewmodel.WebViewModel r1 = r10.this$0
            com.blueair.devicemanager.DeviceManager r1 = r1.getDeviceManager()
            com.blueair.viewcore.viewmodel.WebViewModel r6 = r10.this$0
            com.blueair.auth.AuthService r6 = r6.getAuthService()
            java.lang.String r6 = r6.getUsername()
            java.lang.String r7 = r10.$url
            r8 = r10
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r10.L$0 = r11
            r10.label = r5
            java.lang.Object r1 = r1.shopifyMultiPassLink(r6, r7, r8)
            if (r1 != r0) goto L_0x005f
            goto L_0x0099
        L_0x005f:
            r9 = r1
            r1 = r11
            r11 = r9
        L_0x0062:
            io.flatcircle.coroutinehelper.ApiResult r11 = (io.flatcircle.coroutinehelper.ApiResult) r11
            com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1$1 r5 = new com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1$1
            r5.<init>(r1, r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r11, r5, r6)
            if (r11 != r0) goto L_0x0079
            goto L_0x0099
        L_0x0079:
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1$2 r4 = new com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1$2
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r5 = r10.$onResult
            r4.<init>(r5, r1, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r4, r2)
            if (r11 != r0) goto L_0x009a
        L_0x0099:
            return r0
        L_0x009a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.viewmodel.WebViewModel$handleUrl$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
