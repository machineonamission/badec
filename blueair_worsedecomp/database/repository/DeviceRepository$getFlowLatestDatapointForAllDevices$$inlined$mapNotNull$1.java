package com.blueair.database.repository;

import com.blueair.core.model.IndoorDatapoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1 implements Flow<Map<String, ? extends IndoorDatapoint>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1$2$1 r0 = (com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1$2$1 r0 = new com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0045
                    if (r2 != r3) goto L_0x003d
                    int r8 = r0.I$0
                    java.lang.Object r8 = r0.L$4
                    java.util.Map r8 = (java.util.Map) r8
                    java.lang.Object r8 = r0.L$3
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    java.lang.Object r8 = r0.L$2
                    java.lang.Object r8 = r0.L$1
                    com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1$2$1 r8 = (com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r8
                    java.lang.Object r8 = r0.L$0
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x00bb
                L_0x003d:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0045:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    r2 = r8
                    java.util.List r2 = (java.util.List) r2
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    r4 = 10
                    int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r4)
                    int r4 = kotlin.collections.MapsKt.mapCapacity(r4)
                    r5 = 16
                    int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r5)
                    java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
                    r5.<init>(r4)
                    java.util.Map r5 = (java.util.Map) r5
                    java.util.Iterator r2 = r2.iterator()
                L_0x006d:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L_0x0091
                    java.lang.Object r4 = r2.next()
                    com.blueair.database.entity.DeviceDataEntity r4 = (com.blueair.database.entity.DeviceDataEntity) r4
                    java.lang.String r6 = r4.getDeviceId()
                    com.blueair.core.model.IndoorDatapoint r4 = r4.toIndoorDatapoint()
                    kotlin.Pair r4 = kotlin.TuplesKt.to(r6, r4)
                    java.lang.Object r6 = r4.getFirst()
                    java.lang.Object r4 = r4.getSecond()
                    r5.put(r6, r4)
                    goto L_0x006d
                L_0x0091:
                    java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                    r0.L$0 = r2
                    java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                    r0.L$1 = r2
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                    r0.L$2 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                    r0.L$3 = r8
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                    r0.L$4 = r8
                    r8 = 0
                    r0.I$0 = r8
                    r0.label = r3
                    java.lang.Object r8 = r9.emit(r5, r0)
                    if (r8 != r1) goto L_0x00bb
                    return r1
                L_0x00bb:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
