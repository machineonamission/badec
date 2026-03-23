package com.blueair.adddevice.viewmodel;

import com.blueair.core.model.BluetoothDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class AddDeviceViewModel$special$$inlined$map$1 implements Flow<List<? extends BluetoothDevice>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ AddDeviceViewModel this$0;

    public AddDeviceViewModel$special$$inlined$map$1(Flow flow, AddDeviceViewModel addDeviceViewModel) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = addDeviceViewModel;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final AddDeviceViewModel addDeviceViewModel = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.blueair.core.model.HasBlueCloudFunctions} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: com.blueair.core.model.HasBlueCloudFunctions} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: com.blueair.bluetooth.model.BleScannedDevice} */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x02dd, code lost:
                if (r4.emit((java.util.List) r1, r7) == r3) goto L_0x02df;
             */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x00b2  */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x00eb  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x017a  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x01a7  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x01aa  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x01b8  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x01bb  */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x01d1  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x01f7  */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0201  */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0233  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0278  */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x027b  */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x0284  */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x029d  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r33, kotlin.coroutines.Continuation r34) {
                /*
                    r32 = this;
                    r0 = r32
                    r1 = r34
                    boolean r2 = r1 instanceof com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r2 == 0) goto L_0x0018
                    r2 = r1
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1$2$1 r2 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                    int r3 = r2.label
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r3 & r4
                    if (r3 == 0) goto L_0x0018
                    int r1 = r2.label
                    int r1 = r1 - r4
                    r2.label = r1
                    goto L_0x001d
                L_0x0018:
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1$2$1 r2 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1$2$1
                    r2.<init>(r0, r1)
                L_0x001d:
                    java.lang.Object r1 = r2.result
                    java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r4 = r2.label
                    r5 = 2
                    r6 = 1
                    if (r4 == 0) goto L_0x00b2
                    if (r4 == r6) goto L_0x0048
                    if (r4 != r5) goto L_0x0040
                    int r3 = r2.I$0
                    java.lang.Object r3 = r2.L$3
                    kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
                    java.lang.Object r3 = r2.L$2
                    java.lang.Object r3 = r2.L$1
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1$2$1 r3 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r3
                    java.lang.Object r2 = r2.L$0
                    kotlin.ResultKt.throwOnFailure(r1)
                    goto L_0x02e0
                L_0x0040:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L_0x0048:
                    int r4 = r2.I$4
                    int r4 = r2.I$3
                    int r9 = r2.I$2
                    int r10 = r2.I$1
                    int r11 = r2.I$0
                    java.lang.Object r12 = r2.L$14
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r12 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel) r12
                    java.lang.Object r13 = r2.L$13
                    java.util.Collection r13 = (java.util.Collection) r13
                    java.lang.Object r14 = r2.L$12
                    com.blueair.bluetooth.model.BleScannedDevice r14 = (com.blueair.bluetooth.model.BleScannedDevice) r14
                    java.lang.Object r15 = r2.L$11
                    java.lang.Object r15 = r2.L$10
                    java.util.Iterator r15 = (java.util.Iterator) r15
                    java.lang.Object r5 = r2.L$9
                    java.util.Collection r5 = (java.util.Collection) r5
                    java.lang.Object r8 = r2.L$8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.lang.Object r6 = r2.L$7
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.lang.Object r7 = r2.L$6
                    java.util.List r7 = (java.util.List) r7
                    r17 = r1
                    java.lang.Object r1 = r2.L$5
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r33 = r1
                    java.lang.Object r1 = r2.L$4
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    r18 = r1
                    java.lang.Object r1 = r2.L$3
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    r19 = r1
                    java.lang.Object r1 = r2.L$2
                    r20 = r1
                    java.lang.Object r1 = r2.L$1
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1$2$1 r1 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r1
                    r21 = r1
                    java.lang.Object r1 = r2.L$0
                    kotlin.ResultKt.throwOnFailure(r17)
                    r16 = r20
                    r20 = r19
                    r19 = r16
                    r16 = r13
                    r22 = r15
                    r13 = r9
                    r15 = r11
                    r9 = r4
                    r11 = r7
                    r4 = r33
                    r7 = r2
                    r2 = r1
                    r1 = r17
                    r17 = r14
                    r14 = r12
                    r12 = r8
                    r8 = 1
                    goto L_0x018e
                L_0x00b2:
                    r17 = r1
                    kotlin.ResultKt.throwOnFailure(r17)
                    kotlinx.coroutines.flow.FlowCollector r1 = r4
                    r4 = r2
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r5 = r33
                    java.util.List r5 = (java.util.List) r5
                    r6 = r5
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.util.ArrayList r7 = new java.util.ArrayList
                    r8 = 10
                    int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r8)
                    r7.<init>(r8)
                    java.util.Collection r7 = (java.util.Collection) r7
                    java.util.Iterator r8 = r6.iterator()
                    r11 = r5
                    r10 = r6
                    r12 = r10
                    r17 = r8
                    r9 = 0
                    r13 = 0
                    r14 = 0
                    r15 = 0
                    r5 = r1
                    r8 = r2
                    r6 = r4
                    r2 = r33
                    r4 = r5
                    r1 = r7
                    r7 = r8
                L_0x00e5:
                    boolean r18 = r17.hasNext()
                    if (r18 == 0) goto L_0x029d
                    java.lang.Object r18 = r17.next()
                    r19 = r2
                    r2 = r18
                    com.blueair.bluetooth.model.BleScannedDevice r2 = (com.blueair.bluetooth.model.BleScannedDevice) r2
                    r20 = r5
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r5 = r2
                    java.util.List r5 = r5.onboardedDevices
                    java.util.Collection r5 = (java.util.Collection) r5
                    if (r5 == 0) goto L_0x0116
                    boolean r5 = r5.isEmpty()
                    if (r5 == 0) goto L_0x0108
                    goto L_0x0116
                L_0x0108:
                    r18 = r4
                    r21 = r8
                    r22 = r17
                    r8 = 1
                    r4 = r1
                    r17 = r2
                    r2 = r33
                    goto L_0x0199
                L_0x0116:
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r5 = r2
                    r21 = r6
                    com.blueair.devicemanager.DeviceManager r6 = r5.getDeviceManager()
                    r22 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r33)
                    r7.L$0 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)
                    r7.L$1 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
                    r7.L$2 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
                    r7.L$3 = r8
                    r7.L$4 = r4
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21)
                    r7.L$5 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
                    r7.L$6 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
                    r7.L$7 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                    r7.L$8 = r8
                    r7.L$9 = r1
                    r8 = r17
                    r7.L$10 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18)
                    r7.L$11 = r8
                    r7.L$12 = r2
                    r7.L$13 = r1
                    r7.L$14 = r5
                    r7.I$0 = r15
                    r7.I$1 = r14
                    r7.I$2 = r13
                    r7.I$3 = r9
                    r8 = 0
                    r7.I$4 = r8
                    r8 = 1
                    r7.label = r8
                    java.lang.Object r6 = r6.getBlueDevices(r7)
                    if (r6 != r3) goto L_0x017a
                    goto L_0x02df
                L_0x017a:
                    r16 = r1
                    r18 = r4
                    r4 = r21
                    r21 = r22
                    r1 = r6
                    r6 = r10
                    r10 = r14
                    r22 = r17
                    r17 = r2
                    r14 = r5
                    r2 = r33
                    r5 = r16
                L_0x018e:
                    java.util.List r1 = (java.util.List) r1
                    r14.onboardedDevices = r1
                    r1 = r5
                    r14 = r10
                    r10 = r6
                    r6 = r4
                    r4 = r16
                L_0x0199:
                    r5 = r20
                    android.bluetooth.BluetoothDevice r16 = r17.getDevice()
                    java.lang.String r16 = r16.getName()
                    java.lang.String r20 = ""
                    if (r16 != 0) goto L_0x01aa
                    r8 = r20
                    goto L_0x01ac
                L_0x01aa:
                    r8 = r16
                L_0x01ac:
                    android.bluetooth.BluetoothDevice r16 = r17.getDevice()
                    java.lang.String r16 = r16.getAddress()
                    r33 = r1
                    if (r16 != 0) goto L_0x01bb
                    r1 = r20
                    goto L_0x01bd
                L_0x01bb:
                    r1 = r16
                L_0x01bd:
                    r16 = r8
                    java.lang.CharSequence r16 = (java.lang.CharSequence) r16
                    int r23 = r16.length()
                    if (r23 <= 0) goto L_0x01f7
                    r23 = r1
                    java.lang.CharSequence r23 = (java.lang.CharSequence) r23
                    int r23 = r23.length()
                    if (r23 <= 0) goto L_0x01f7
                    r30 = r2
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r2 = r2
                    java.util.Map r2 = r2.getBleDeviceMacNameCache()
                    java.lang.Object r2 = r2.get(r1)
                    boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r8)
                    if (r2 != 0) goto L_0x01f9
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r2 = r2
                    r31 = r5
                    java.util.Map r5 = r2.getBleDeviceMacNameCache()
                    kotlin.Pair r8 = kotlin.TuplesKt.to(r1, r8)
                    java.util.Map r5 = kotlin.collections.MapsKt.plus(r5, r8)
                    r2.setBleDeviceMacNameCache(r5)
                    goto L_0x01fb
                L_0x01f7:
                    r30 = r2
                L_0x01f9:
                    r31 = r5
                L_0x01fb:
                    int r2 = r16.length()
                    if (r2 != 0) goto L_0x0214
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r2 = r2
                    java.util.Map r2 = r2.getBleDeviceMacNameCache()
                    java.lang.Object r2 = r2.get(r1)
                    java.lang.String r2 = (java.lang.String) r2
                    if (r2 != 0) goto L_0x0210
                    goto L_0x0212
                L_0x0210:
                    r20 = r2
                L_0x0212:
                    r16 = r20
                L_0x0214:
                    r24 = r16
                    java.lang.String r24 = (java.lang.String) r24
                    boolean r26 = r17.getConnectable()
                    com.blueair.core.model.BluetoothDevice r23 = new com.blueair.core.model.BluetoothDevice
                    r27 = 0
                    r28 = 8
                    r29 = 0
                    r25 = r1
                    r23.<init>(r24, r25, r26, r27, r28, r29)
                    r1 = r23
                    com.blueair.adddevice.viewmodel.AddDeviceViewModel r2 = r2
                    java.util.List r2 = r2.onboardedDevices
                    if (r2 == 0) goto L_0x0278
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.Iterator r2 = r2.iterator()
                L_0x0239:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L_0x0274
                    java.lang.Object r5 = r2.next()
                    r8 = r5
                    com.blueair.core.model.HasBlueCloudFunctions r8 = (com.blueair.core.model.HasBlueCloudFunctions) r8
                    java.lang.String r8 = r8.getMac()
                    java.util.Locale r0 = java.util.Locale.ROOT
                    java.lang.String r0 = r8.toLowerCase(r0)
                    java.lang.String r8 = "toLowerCase(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
                    r16 = r2
                    java.lang.String r2 = r1.getWifiMac()
                    r17 = r5
                    java.util.Locale r5 = java.util.Locale.ROOT
                    java.lang.String r2 = r2.toLowerCase(r5)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
                    if (r0 == 0) goto L_0x026f
                    r5 = r17
                    goto L_0x0275
                L_0x026f:
                    r0 = r32
                    r2 = r16
                    goto L_0x0239
                L_0x0274:
                    r5 = 0
                L_0x0275:
                    com.blueair.core.model.HasBlueCloudFunctions r5 = (com.blueair.core.model.HasBlueCloudFunctions) r5
                    goto L_0x0279
                L_0x0278:
                    r5 = 0
                L_0x0279:
                    if (r5 == 0) goto L_0x0284
                    boolean r0 = r5.isOnline()
                    java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
                    goto L_0x0285
                L_0x0284:
                    r0 = 0
                L_0x0285:
                    r1.setOnline(r0)
                    r4.add(r1)
                    r0 = r32
                    r1 = r33
                    r4 = r18
                    r2 = r19
                    r8 = r21
                    r17 = r22
                    r33 = r30
                    r5 = r31
                    goto L_0x00e5
                L_0x029d:
                    r19 = r2
                    r20 = r5
                    r22 = r8
                    java.util.List r1 = (java.util.List) r1
                    java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r33)
                    r7.L$0 = r0
                    java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)
                    r7.L$1 = r0
                    java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
                    r7.L$2 = r0
                    java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
                    r7.L$3 = r0
                    r0 = 0
                    r7.L$4 = r0
                    r7.L$5 = r0
                    r7.L$6 = r0
                    r7.L$7 = r0
                    r7.L$8 = r0
                    r7.L$9 = r0
                    r7.L$10 = r0
                    r7.L$11 = r0
                    r7.L$12 = r0
                    r7.L$13 = r0
                    r7.L$14 = r0
                    r7.I$0 = r15
                    r0 = 2
                    r7.label = r0
                    java.lang.Object r0 = r4.emit(r1, r7)
                    if (r0 != r3) goto L_0x02e0
                L_0x02df:
                    return r3
                L_0x02e0:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
