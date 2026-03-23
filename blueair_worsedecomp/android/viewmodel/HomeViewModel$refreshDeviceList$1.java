package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$refreshDeviceList$1", f = "HomeViewModel.kt", i = {}, l = {219, 220}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$refreshDeviceList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$refreshDeviceList$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$refreshDeviceList$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$refreshDeviceList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$refreshDeviceList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r6.this$0.getDeviceManager().restartStomp(r6) == r0) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x001f }
            goto L_0x0057
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x001f }
            goto L_0x0045
        L_0x001f:
            r7 = move-exception
            goto L_0x0067
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.loadingDeviceList
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r7.postValue(r1)
            com.blueair.devicemanager.DeviceManager$Companion r7 = com.blueair.devicemanager.DeviceManager.Companion     // Catch:{ all -> 0x001f }
            com.blueair.android.viewmodel.HomeViewModel r1 = r6.this$0     // Catch:{ all -> 0x001f }
            com.blueair.devicemanager.DeviceManager r1 = r1.getDeviceManager()     // Catch:{ all -> 0x001f }
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x001f }
            r6.label = r4     // Catch:{ all -> 0x001f }
            java.lang.Object r7 = r7.downloadDeviceList(r1, r5)     // Catch:{ all -> 0x001f }
            if (r7 != r0) goto L_0x0045
            goto L_0x0056
        L_0x0045:
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0     // Catch:{ all -> 0x001f }
            com.blueair.devicemanager.DeviceManager r7 = r7.getDeviceManager()     // Catch:{ all -> 0x001f }
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ all -> 0x001f }
            r6.label = r3     // Catch:{ all -> 0x001f }
            java.lang.Object r7 = r7.restartStomp(r1)     // Catch:{ all -> 0x001f }
            if (r7 != r0) goto L_0x0057
        L_0x0056:
            return r0
        L_0x0057:
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.loadingDeviceList
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r7.postValue(r0)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0067:
            com.blueair.android.viewmodel.HomeViewModel r0 = r6.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.loadingDeviceList
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r0.postValue(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$refreshDeviceList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
