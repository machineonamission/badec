package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1", f = "DeviceDetailsViewModel.kt", i = {1, 2, 3}, l = {507, 512, 512, 512}, m = "invokeSuspend", n = {"d", "d", "d"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$resetFilterLife$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ DeviceFilterType $type;
    Object L$0;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$resetFilterLife$1(DeviceDetailsViewModel deviceDetailsViewModel, Device device, DeviceFilterType deviceFilterType, Continuation<? super DeviceDetailsViewModel$resetFilterLife$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceDetailsViewModel;
        this.$device = device;
        this.$type = deviceFilterType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$resetFilterLife$1(this.this$0, this.$device, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$resetFilterLife$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r12 == r0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ad, code lost:
        if (r12 != r0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ca, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r12, new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1.AnonymousClass2>) null), r11) == r0) goto L_0x00cc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 == r6) goto L_0x0037
            if (r1 == r5) goto L_0x002f
            if (r1 == r4) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            java.lang.Object r0 = r11.L$0
            com.blueair.core.model.Device r0 = (com.blueair.core.model.Device) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00da
        L_0x001e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0026:
            java.lang.Object r1 = r11.L$0
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b0
        L_0x002f:
            java.lang.Object r1 = r11.L$0
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0093
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0057
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r12)
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r12 = r11.this$0
            com.blueair.devicemanager.DeviceManager r12 = r12.getDeviceManager()
            com.blueair.core.model.Device r1 = r11.$device
            java.lang.String r1 = r1.getUid()
            r7 = r11
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r11.label = r6
            java.lang.Object r12 = r12.getDatabaseDevice(r1, r7)
            if (r12 != r0) goto L_0x0057
            goto L_0x00cc
        L_0x0057:
            com.blueair.core.model.Device r12 = (com.blueair.core.model.Device) r12
            if (r12 != 0) goto L_0x006a
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r12 = r11.this$0
            androidx.lifecycle.MutableLiveData r12 = r12._resetFilterLifeResult
            com.blueair.devicedetails.viewmodel.FilterLifeResetResult r0 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.FAILED
            r12.postValue(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            goto L_0x00da
        L_0x006a:
            com.blueair.core.model.ConnectivityStatus r1 = r12.getConnectivityStatus()
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            if (r1 != r6) goto L_0x00cd
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r1 = r11.this$0
            com.blueair.devicemanager.DeviceManager r1 = r1.getDeviceManager()
            java.lang.String r6 = r12.getUid()
            com.blueair.core.model.DeviceFilterType r7 = r11.$type
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r11.L$0 = r9
            r11.label = r5
            java.lang.Object r1 = r1.resetFilterLife(r6, r7, r8)
            if (r1 != r0) goto L_0x0090
            goto L_0x00cc
        L_0x0090:
            r10 = r1
            r1 = r12
            r12 = r10
        L_0x0093:
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1$1 r5 = new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1$1
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r6 = r11.this$0
            r5.<init>(r6, r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r11.L$0 = r7
            r11.label = r4
            java.lang.Object r12 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r12, r5, r6)
            if (r12 != r0) goto L_0x00b0
            goto L_0x00cc
        L_0x00b0:
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1$2 r4 = new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1$2
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r5 = r11.this$0
            r4.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r11.L$0 = r1
            r11.label = r3
            java.lang.Object r12 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r12, r4, r2)
            if (r12 != r0) goto L_0x00da
        L_0x00cc:
            return r0
        L_0x00cd:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r12 = r11.this$0
            androidx.lifecycle.MutableLiveData r12 = r12._resetFilterLifeResult
            com.blueair.devicedetails.viewmodel.FilterLifeResetResult r0 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.DEVICE_OFFLINE
            r12.postValue(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
        L_0x00da:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$resetFilterLife$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
