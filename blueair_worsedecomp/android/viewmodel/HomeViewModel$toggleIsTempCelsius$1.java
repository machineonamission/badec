package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$toggleIsTempCelsius$1", f = "HomeViewModel.kt", i = {0, 1}, l = {244, 244}, m = "invokeSuspend", n = {"value", "value"}, s = {"L$0", "L$0"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$toggleIsTempCelsius$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$toggleIsTempCelsius$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$toggleIsTempCelsius$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$toggleIsTempCelsius$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$toggleIsTempCelsius$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if (r7 == r0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0080, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r7, new com.blueair.android.viewmodel.HomeViewModel$toggleIsTempCelsius$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.android.viewmodel.HomeViewModel$toggleIsTempCelsius$1.AnonymousClass1>) null), r6) == r0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r6.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0083
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            java.lang.Object r1 = r6.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0065
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getSettingsLoading()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r7.postValue(r1)
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.isTempCelsius()
            java.lang.Object r7 = r7.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x004e
            java.lang.String r7 = "Fahrenheit"
            goto L_0x0050
        L_0x004e:
            java.lang.String r7 = "Celsius"
        L_0x0050:
            r1 = r7
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            com.blueair.devicemanager.DeviceManager r7 = r7.getDeviceManager()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.setTemperatureSettings(r1, r4)
            if (r7 != r0) goto L_0x0065
            goto L_0x0082
        L_0x0065:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.android.viewmodel.HomeViewModel$toggleIsTempCelsius$1$1 r3 = new com.blueair.android.viewmodel.HomeViewModel$toggleIsTempCelsius$1$1
            com.blueair.android.viewmodel.HomeViewModel r4 = r6.this$0
            r5 = 0
            r3.<init>(r1, r4, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r3, r4)
            if (r7 != r0) goto L_0x0083
        L_0x0082:
            return r0
        L_0x0083:
            com.blueair.android.viewmodel.HomeViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getSettingsLoading()
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r7.postValue(r0)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$toggleIsTempCelsius$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
