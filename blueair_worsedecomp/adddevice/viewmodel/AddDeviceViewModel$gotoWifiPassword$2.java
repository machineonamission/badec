package com.blueair.adddevice.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.AddDeviceViewModel$gotoWifiPassword$2", f = "AddDeviceViewModel.kt", i = {1}, l = {584, 588}, m = "invokeSuspend", n = {"success"}, s = {"Z$0"})
/* compiled from: AddDeviceViewModel.kt */
final class AddDeviceViewModel$gotoWifiPassword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceViewModel$gotoWifiPassword$2(AddDeviceViewModel addDeviceViewModel, Continuation<? super AddDeviceViewModel$gotoWifiPassword$2> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceViewModel$gotoWifiPassword$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceViewModel$gotoWifiPassword$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        if (r6.this$0.pollwifiConnected(r6) == r0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r7 == r0) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003d
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$gotoWifiPassword$2$success$1 r1 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$gotoWifiPassword$2$success$1
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r4 = r6.this$0
            r5 = 0
            r1.<init>(r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r4)
            if (r7 != r0) goto L_0x003d
            goto L_0x0054
        L_0x003d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0055
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r1 = r6.this$0
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.Z$0 = r7
            r6.label = r2
            java.lang.Object r7 = r1.pollwifiConnected(r3)
            if (r7 != r0) goto L_0x0055
        L_0x0054:
            return r0
        L_0x0055:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel$gotoWifiPassword$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
