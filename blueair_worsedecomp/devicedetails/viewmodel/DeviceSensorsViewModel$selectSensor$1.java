package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$selectSensor$1", f = "DeviceSensorsViewModel.kt", i = {0, 0, 1, 1}, l = {325, 328}, m = "invokeSuspend", n = {"it", "$i$a$-let-DeviceSensorsViewModel$selectSensor$1$1", "it", "$i$a$-let-DeviceSensorsViewModel$selectSensor$1$2"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* compiled from: DeviceSensorsViewModel.kt */
final class DeviceSensorsViewModel$selectSensor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceSensorsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSensorsViewModel$selectSensor$1(DeviceSensorsViewModel deviceSensorsViewModel, Continuation<? super DeviceSensorsViewModel$selectSensor$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceSensorsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSensorsViewModel$selectSensor$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSensorsViewModel$selectSensor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r4) goto L_0x0023
            if (r1 != r3) goto L_0x001b
            java.lang.Object r0 = r7.L$1
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            java.lang.Object r1 = r7.L$0
            com.blueair.core.model.DeviceData r1 = (com.blueair.core.model.DeviceData) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x001b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0023:
            java.lang.Object r1 = r7.L$1
            androidx.lifecycle.MutableLiveData r1 = (androidx.lifecycle.MutableLiveData) r1
            java.lang.Object r4 = r7.L$0
            com.blueair.core.model.DeviceData r4 = (com.blueair.core.model.DeviceData) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0054
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r8 = r7.this$0
            com.blueair.core.model.DeviceData r8 = r8.getLastDeviceRealTimeData()
            if (r8 == 0) goto L_0x0057
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r1 = r7.this$0
            androidx.lifecycle.MutableLiveData r5 = r1._liveSelectedSensorRealTimeData
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r6
            r7.L$1 = r5
            r7.I$0 = r2
            r7.label = r4
            java.lang.Object r8 = r1.getSelectedSensorData(r8, r7)
            if (r8 != r0) goto L_0x0053
            goto L_0x0077
        L_0x0053:
            r1 = r5
        L_0x0054:
            r1.setValue(r8)
        L_0x0057:
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r8 = r7.this$0
            com.blueair.core.model.DeviceData r8 = r8.getLastDeviceHistoricalData()
            if (r8 == 0) goto L_0x007c
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r1 = r7.this$0
            androidx.lifecycle.MutableLiveData r4 = r1._liveSelectedSensorHistoricalData
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r5
            r7.L$1 = r4
            r7.I$0 = r2
            r7.label = r3
            java.lang.Object r8 = r1.getSelectedSensorData(r8, r7)
            if (r8 != r0) goto L_0x0078
        L_0x0077:
            return r0
        L_0x0078:
            r0 = r4
        L_0x0079:
            r0.setValue(r8)
        L_0x007c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$selectSensor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
