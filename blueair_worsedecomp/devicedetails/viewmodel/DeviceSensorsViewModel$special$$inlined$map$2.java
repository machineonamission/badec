package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class DeviceSensorsViewModel$special$$inlined$map$2 implements Flow<Boolean> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ DeviceSensorsViewModel this$0;

    public DeviceSensorsViewModel$special$$inlined$map$2(Flow flow, DeviceSensorsViewModel deviceSensorsViewModel) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = deviceSensorsViewModel;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final DeviceSensorsViewModel deviceSensorsViewModel = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x01ab, code lost:
                if (r5.emit(r1, r7) != r2) goto L_0x01ae;
             */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x009b  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0171  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                /*
                    r18 = this;
                    r0 = r18
                    r1 = r20
                    boolean r2 = r1 instanceof com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1
                    if (r2 == 0) goto L_0x0018
                    r2 = r1
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2$2$1 r2 = (com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r2
                    int r3 = r2.label
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r3 & r4
                    if (r3 == 0) goto L_0x0018
                    int r1 = r2.label
                    int r1 = r1 - r4
                    r2.label = r1
                    goto L_0x001d
                L_0x0018:
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2$2$1 r2 = new com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2$2$1
                    r2.<init>(r0, r1)
                L_0x001d:
                    r7 = r2
                    java.lang.Object r1 = r7.result
                    java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r3 = r7.label
                    r10 = 3
                    r4 = 2
                    r11 = 1
                    if (r3 == 0) goto L_0x009b
                    if (r3 == r11) goto L_0x0073
                    if (r3 == r4) goto L_0x004c
                    if (r3 != r10) goto L_0x0044
                    int r2 = r7.I$0
                    java.lang.Object r2 = r7.L$3
                    kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                    java.lang.Object r2 = r7.L$2
                    java.lang.Object r2 = r7.L$1
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2$2$1 r2 = (com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r2
                    java.lang.Object r2 = r7.L$0
                    kotlin.ResultKt.throwOnFailure(r1)
                    goto L_0x01ae
                L_0x0044:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L_0x004c:
                    int r3 = r7.I$1
                    int r3 = r7.I$0
                    java.lang.Object r4 = r7.L$7
                    androidx.lifecycle.MutableLiveData r4 = (androidx.lifecycle.MutableLiveData) r4
                    java.lang.Object r5 = r7.L$6
                    com.blueair.core.model.DeviceData r5 = (com.blueair.core.model.DeviceData) r5
                    java.lang.Object r5 = r7.L$5
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    java.lang.Object r5 = r7.L$4
                    kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                    java.lang.Object r6 = r7.L$3
                    kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                    java.lang.Object r8 = r7.L$2
                    java.lang.Object r9 = r7.L$1
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2$2$1 r9 = (com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r9
                    java.lang.Object r13 = r7.L$0
                    kotlin.ResultKt.throwOnFailure(r1)
                    r17 = r11
                    goto L_0x017a
                L_0x0073:
                    int r3 = r7.I$1
                    int r5 = r7.I$0
                    java.lang.Object r6 = r7.L$7
                    androidx.lifecycle.MutableLiveData r6 = (androidx.lifecycle.MutableLiveData) r6
                    java.lang.Object r8 = r7.L$6
                    com.blueair.core.model.DeviceData r8 = (com.blueair.core.model.DeviceData) r8
                    java.lang.Object r9 = r7.L$5
                    kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                    java.lang.Object r13 = r7.L$4
                    kotlinx.coroutines.flow.FlowCollector r13 = (kotlinx.coroutines.flow.FlowCollector) r13
                    java.lang.Object r14 = r7.L$3
                    kotlinx.coroutines.flow.FlowCollector r14 = (kotlinx.coroutines.flow.FlowCollector) r14
                    java.lang.Object r15 = r7.L$2
                    java.lang.Object r10 = r7.L$1
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2$2$1 r10 = (com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r10
                    java.lang.Object r12 = r7.L$0
                    kotlin.ResultKt.throwOnFailure(r1)
                    r16 = r10
                    r10 = r5
                    goto L_0x0127
                L_0x009b:
                    kotlin.ResultKt.throwOnFailure(r1)
                    kotlinx.coroutines.flow.FlowCollector r1 = r4
                    r9 = r7
                    kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                    r8 = r19
                    com.blueair.core.model.DeviceData r8 = (com.blueair.core.model.DeviceData) r8
                    timber.log.Timber$Forest r3 = timber.log.Timber.Forest
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    java.lang.String r6 = "dataListener: data.size = "
                    r5.<init>(r6)
                    java.util.List r6 = r8.getRawDataPoints()
                    if (r6 == 0) goto L_0x00bf
                    int r6 = r6.size()
                    java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
                    goto L_0x00c0
                L_0x00bf:
                    r6 = 0
                L_0x00c0:
                    r5.append(r6)
                    java.lang.String r6 = ", thread = "
                    r5.append(r6)
                    java.lang.Thread r6 = java.lang.Thread.currentThread()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    r6 = 0
                    java.lang.Object[] r10 = new java.lang.Object[r6]
                    r3.d(r5, r10)
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r3 = r2
                    androidx.lifecycle.MutableLiveData r3 = r3._liveDeviceRealTimeData
                    r3.postValue(r8)
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r3 = r2
                    androidx.lifecycle.MutableLiveData r3 = r3._liveSelectedSensorRealTimeData
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r5 = r2
                    java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
                    r7.L$0 = r10
                    java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                    r7.L$1 = r10
                    java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
                    r7.L$2 = r10
                    java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                    r7.L$3 = r10
                    r7.L$4 = r1
                    java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                    r7.L$5 = r10
                    r7.L$6 = r8
                    r7.L$7 = r3
                    r7.I$0 = r6
                    r7.I$1 = r6
                    r7.label = r11
                    java.lang.Object r5 = r5.getSelectedSensorData(r8, r7)
                    if (r5 != r2) goto L_0x011c
                    goto L_0x01ad
                L_0x011c:
                    r12 = r19
                    r15 = r12
                    r13 = r1
                    r14 = r13
                    r1 = r5
                    r10 = r6
                    r16 = r7
                    r6 = r3
                    r3 = r10
                L_0x0127:
                    r6.postValue(r1)
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r1 = r2
                    androidx.lifecycle.MutableLiveData r1 = r1._liveFanSensorRealTimeData
                    com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$Companion r5 = com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel.Companion
                    r6 = r5
                    com.blueair.core.model.SensorType r5 = com.blueair.core.model.SensorType.FAN
                    r17 = r11
                    java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                    r7.L$0 = r11
                    java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
                    r7.L$1 = r11
                    java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
                    r7.L$2 = r11
                    java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
                    r7.L$3 = r11
                    r7.L$4 = r13
                    java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                    r7.L$5 = r9
                    java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                    r7.L$6 = r9
                    r7.L$7 = r1
                    r7.I$0 = r10
                    r7.I$1 = r3
                    r7.label = r4
                    r3 = r6
                    r6 = 0
                    r4 = r8
                    r8 = 4
                    r9 = 0
                    java.lang.Object r3 = com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel.Companion.getSensorData$default(r3, r4, r5, r6, r7, r8, r9)
                    if (r3 != r2) goto L_0x0171
                    goto L_0x01ad
                L_0x0171:
                    r4 = r1
                    r1 = r3
                    r3 = r10
                    r5 = r13
                    r6 = r14
                    r8 = r15
                    r9 = r16
                    r13 = r12
                L_0x017a:
                    r4.postValue(r1)
                    java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
                    r7.L$0 = r4
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                    r7.L$1 = r4
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                    r7.L$2 = r4
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                    r7.L$3 = r4
                    r4 = 0
                    r7.L$4 = r4
                    r7.L$5 = r4
                    r7.L$6 = r4
                    r7.L$7 = r4
                    r7.I$0 = r3
                    r3 = 3
                    r7.label = r3
                    java.lang.Object r1 = r5.emit(r1, r7)
                    if (r1 != r2) goto L_0x01ae
                L_0x01ad:
                    return r2
                L_0x01ae:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$special$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
