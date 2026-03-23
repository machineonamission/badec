package com.blueair.database.repository;

import com.blueair.core.model.NotificationMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1 implements Flow<List<? extends NotificationMessage>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ NotificationRepository this$0;

    public NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1(Flow flow, NotificationRepository notificationRepository) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = notificationRepository;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final NotificationRepository notificationRepository = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r12
                    com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1$2$1 r0 = (com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r12 = r0.label
                    int r12 = r12 - r2
                    r0.label = r12
                    goto L_0x0019
                L_0x0014:
                    com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1$2$1 r0 = new com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1$2$1
                    r0.<init>(r10, r12)
                L_0x0019:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0041
                    if (r2 != r3) goto L_0x0039
                    int r11 = r0.I$0
                    java.lang.Object r11 = r0.L$3
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r11 = r0.L$2
                    java.lang.Object r11 = r0.L$1
                    com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1$2$1 r11 = (com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1.AnonymousClass2.AnonymousClass1) r11
                    java.lang.Object r11 = r0.L$0
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00b9
                L_0x0039:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0041:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    r2 = r11
                    java.util.List r2 = (java.util.List) r2
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Collection r4 = (java.util.Collection) r4
                    java.util.Iterator r2 = r2.iterator()
                L_0x0059:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L_0x0093
                    java.lang.Object r5 = r2.next()
                    com.blueair.database.entity.NotificationEntity r5 = (com.blueair.database.entity.NotificationEntity) r5
                    com.blueair.database.repository.NotificationRepository r6 = r2
                    com.blueair.database.repository.DeviceRepository r6 = r6.deviceRepository
                    java.lang.String r7 = r5.getDeviceId()
                    com.blueair.core.model.Device r6 = r6.getDevice(r7)
                    if (r6 != 0) goto L_0x0077
                    r5 = 0
                    goto L_0x008d
                L_0x0077:
                    com.blueair.core.model.NotificationMessage r7 = new com.blueair.core.model.NotificationMessage
                    java.lang.String r8 = r5.getType()
                    com.blueair.core.model.NotificationMsgType r8 = com.blueair.core.model.NotificationMsgType.valueOf(r8)
                    java.lang.String r9 = r5.getSubType()
                    int r5 = r5.getSubLevel()
                    r7.<init>(r6, r8, r9, r5)
                    r5 = r7
                L_0x008d:
                    if (r5 == 0) goto L_0x0059
                    r4.add(r5)
                    goto L_0x0059
                L_0x0093:
                    java.util.List r4 = (java.util.List) r4
                    java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
                    r0.L$0 = r2
                    java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                    r0.L$1 = r2
                    java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
                    r0.L$2 = r11
                    java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                    r0.L$3 = r11
                    r11 = 0
                    r0.I$0 = r11
                    r0.label = r3
                    java.lang.Object r11 = r12.emit(r4, r0)
                    if (r11 != r1) goto L_0x00b9
                    return r1
                L_0x00b9:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
