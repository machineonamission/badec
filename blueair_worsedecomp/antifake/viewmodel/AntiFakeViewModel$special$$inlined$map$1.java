package com.blueair.antifake.viewmodel;

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
public final class AntiFakeViewModel$special$$inlined$map$1 implements Flow<List<? extends BluetoothDevice>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ AntiFakeViewModel this$0;

    public AntiFakeViewModel$special$$inlined$map$1(Flow flow, AntiFakeViewModel antiFakeViewModel) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = antiFakeViewModel;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final AntiFakeViewModel antiFakeViewModel = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                /*
                    r18 = this;
                    r0 = r18
                    r1 = r20
                    boolean r2 = r1 instanceof com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r2 == 0) goto L_0x0018
                    r2 = r1
                    com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1$2$1 r2 = (com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                    int r3 = r2.label
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r3 & r4
                    if (r3 == 0) goto L_0x0018
                    int r1 = r2.label
                    int r1 = r1 - r4
                    r2.label = r1
                    goto L_0x001d
                L_0x0018:
                    com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1$2$1 r2 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1$2$1
                    r2.<init>(r0, r1)
                L_0x001d:
                    java.lang.Object r1 = r2.result
                    java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r4 = r2.label
                    r5 = 1
                    if (r4 == 0) goto L_0x0045
                    if (r4 != r5) goto L_0x003d
                    int r3 = r2.I$0
                    java.lang.Object r3 = r2.L$3
                    kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
                    java.lang.Object r3 = r2.L$2
                    java.lang.Object r3 = r2.L$1
                    com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1$2$1 r3 = (com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r3
                    java.lang.Object r2 = r2.L$0
                    kotlin.ResultKt.throwOnFailure(r1)
                    goto L_0x0110
                L_0x003d:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L_0x0045:
                    kotlin.ResultKt.throwOnFailure(r1)
                    kotlinx.coroutines.flow.FlowCollector r1 = r4
                    r4 = r2
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r4 = r19
                    java.util.List r4 = (java.util.List) r4
                    java.lang.Iterable r4 = (java.lang.Iterable) r4
                    java.util.ArrayList r6 = new java.util.ArrayList
                    r7 = 10
                    int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r7)
                    r6.<init>(r7)
                    java.util.Collection r6 = (java.util.Collection) r6
                    java.util.Iterator r4 = r4.iterator()
                L_0x0064:
                    boolean r7 = r4.hasNext()
                    if (r7 == 0) goto L_0x00ea
                    java.lang.Object r7 = r4.next()
                    com.blueair.bluetooth.model.BleScannedDevice r7 = (com.blueair.bluetooth.model.BleScannedDevice) r7
                    android.bluetooth.BluetoothDevice r8 = r7.getDevice()
                    java.lang.String r8 = r8.getName()
                    java.lang.String r9 = ""
                    if (r8 != 0) goto L_0x007d
                    r8 = r9
                L_0x007d:
                    android.bluetooth.BluetoothDevice r10 = r7.getDevice()
                    java.lang.String r10 = r10.getAddress()
                    if (r10 != 0) goto L_0x0089
                    r13 = r9
                    goto L_0x008a
                L_0x0089:
                    r13 = r10
                L_0x008a:
                    r10 = r8
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    int r11 = r10.length()
                    if (r11 <= 0) goto L_0x00bd
                    r11 = r13
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    int r11 = r11.length()
                    if (r11 <= 0) goto L_0x00bd
                    com.blueair.antifake.viewmodel.AntiFakeViewModel r11 = r2
                    java.util.Map r11 = r11.getBleDeviceMacNameCache()
                    java.lang.Object r11 = r11.get(r13)
                    boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r8)
                    if (r11 != 0) goto L_0x00bd
                    com.blueair.antifake.viewmodel.AntiFakeViewModel r11 = r2
                    java.util.Map r12 = r11.getBleDeviceMacNameCache()
                    kotlin.Pair r8 = kotlin.TuplesKt.to(r13, r8)
                    java.util.Map r8 = kotlin.collections.MapsKt.plus(r12, r8)
                    r11.setBleDeviceMacNameCache(r8)
                L_0x00bd:
                    int r8 = r10.length()
                    if (r8 != 0) goto L_0x00d4
                    com.blueair.antifake.viewmodel.AntiFakeViewModel r8 = r2
                    java.util.Map r8 = r8.getBleDeviceMacNameCache()
                    java.lang.Object r8 = r8.get(r13)
                    java.lang.String r8 = (java.lang.String) r8
                    if (r8 != 0) goto L_0x00d2
                    goto L_0x00d3
                L_0x00d2:
                    r9 = r8
                L_0x00d3:
                    r10 = r9
                L_0x00d4:
                    r12 = r10
                    java.lang.String r12 = (java.lang.String) r12
                    boolean r14 = r7.getConnectable()
                    com.blueair.core.model.BluetoothDevice r11 = new com.blueair.core.model.BluetoothDevice
                    r15 = 0
                    r16 = 8
                    r17 = 0
                    r11.<init>(r12, r13, r14, r15, r16, r17)
                    r6.add(r11)
                    goto L_0x0064
                L_0x00ea:
                    java.util.List r6 = (java.util.List) r6
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
                    r2.L$0 = r4
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                    r2.L$1 = r4
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
                    r2.L$2 = r4
                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                    r2.L$3 = r4
                    r4 = 0
                    r2.I$0 = r4
                    r2.label = r5
                    java.lang.Object r1 = r1.emit(r6, r2)
                    if (r1 != r3) goto L_0x0110
                    return r3
                L_0x0110:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.viewmodel.AntiFakeViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
