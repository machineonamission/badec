package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceScheduleService$deleteMergedSchedule$2", f = "DeviceScheduleService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {64, 65}, m = "invokeSuspend", n = {"scheduleIds", "$this$forEach$iv", "element$iv", "scheduleId", "$i$f$forEach", "$i$a$-forEach-DeviceScheduleService$deleteMergedSchedule$2$1", "scheduleIds", "$this$forEach$iv", "element$iv", "scheduleId", "$i$f$forEach", "$i$a$-forEach-DeviceScheduleService$deleteMergedSchedule$2$1"}, s = {"L$0", "L$1", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$5", "L$6", "I$0", "I$1"})
/* compiled from: DeviceScheduleService.kt */
final class DeviceScheduleService$deleteMergedSchedule$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ DeviceScheduleMerged $merged;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DeviceScheduleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceScheduleService$deleteMergedSchedule$2(DeviceScheduleMerged deviceScheduleMerged, DeviceScheduleService deviceScheduleService, Device device, Continuation<? super DeviceScheduleService$deleteMergedSchedule$2> continuation) {
        super(2, continuation);
        this.$merged = deviceScheduleMerged;
        this.this$0 = deviceScheduleService;
        this.$device = device;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceScheduleService$deleteMergedSchedule$2(this.$merged, this.this$0, this.$device, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceScheduleService$deleteMergedSchedule$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0063
            if (r1 == r3) goto L_0x003b
            if (r1 != r2) goto L_0x0033
            int r1 = r14.I$0
            java.lang.Object r5 = r14.L$6
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r14.L$4
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r14.L$3
            com.blueair.core.model.Device r6 = (com.blueair.core.model.Device) r6
            java.lang.Object r7 = r14.L$2
            com.blueair.devicemanager.DeviceScheduleService r7 = (com.blueair.devicemanager.DeviceScheduleService) r7
            java.lang.Object r8 = r14.L$1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.Object r9 = r14.L$0
            java.util.List r9 = (java.util.List) r9
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r7
            r7 = r5
            r5 = r15
            r15 = r8
            r8 = r1
            r1 = r9
            goto L_0x009d
        L_0x0033:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x003b:
            int r1 = r14.I$1
            int r5 = r14.I$0
            java.lang.Object r6 = r14.L$6
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r14.L$5
            java.lang.Object r8 = r14.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r14.L$3
            com.blueair.core.model.Device r9 = (com.blueair.core.model.Device) r9
            java.lang.Object r10 = r14.L$2
            com.blueair.devicemanager.DeviceScheduleService r10 = (com.blueair.devicemanager.DeviceScheduleService) r10
            java.lang.Object r11 = r14.L$1
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r14.L$0
            java.util.List r12 = (java.util.List) r12
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r1
            r1 = r5
            r5 = r8
            r8 = r7
            r7 = r10
            goto L_0x00df
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.core.model.DeviceScheduleMerged r15 = r14.$merged
            java.util.List r15 = r15.getSchedule()
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r15 = r15.iterator()
        L_0x0079:
            boolean r5 = r15.hasNext()
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r15.next()
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            java.lang.String r5 = r5.getScheduleId()
            if (r5 == 0) goto L_0x0079
            r1.add(r5)
            goto L_0x0079
        L_0x008f:
            java.util.List r1 = (java.util.List) r1
            r15 = r1
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            com.blueair.devicemanager.DeviceScheduleService r5 = r14.this$0
            com.blueair.core.model.Device r6 = r14.$device
            java.util.Iterator r7 = r15.iterator()
            r8 = r4
        L_0x009d:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0116
            java.lang.Object r9 = r7.next()
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            com.blueair.devicemanager.DeviceManager r11 = r5.deviceManager
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r14.L$0 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r14.L$1 = r12
            r14.L$2 = r5
            r14.L$3 = r6
            r14.L$4 = r7
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r14.L$5 = r12
            r14.L$6 = r10
            r14.I$0 = r8
            r14.I$1 = r4
            r14.label = r3
            java.lang.Object r11 = r11.deleteSchedule(r6, r10, r14)
            if (r11 != r0) goto L_0x00d5
            goto L_0x010d
        L_0x00d5:
            r11 = r7
            r7 = r5
            r5 = r11
            r11 = r15
            r12 = r1
            r15 = r4
            r1 = r8
            r8 = r9
            r9 = r6
            r6 = r10
        L_0x00df:
            com.blueair.database.repository.DeviceScheduleRepository r10 = r7.deviceScheduleRepository
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r14.L$0 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r14.L$1 = r13
            r14.L$2 = r7
            r14.L$3 = r9
            r14.L$4 = r5
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r14.L$5 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r14.L$6 = r8
            r14.I$0 = r1
            r14.I$1 = r15
            r14.label = r2
            java.lang.Object r15 = r10.delete(r6, r14)
            if (r15 != r0) goto L_0x010e
        L_0x010d:
            return r0
        L_0x010e:
            r15 = r7
            r7 = r5
            r5 = r15
            r8 = r1
            r6 = r9
            r15 = r11
            r1 = r12
            goto L_0x009d
        L_0x0116:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.String r0 = "deleteMergedSchedule: done"
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.d(r0, r1)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceScheduleService$deleteMergedSchedule$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
