package com.blueair.devicemanager;

import com.blueair.auth.GigyaService;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.database.repository.DeviceScheduleRepository;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import org.joda.time.format.DateTimeFormat;
import timber.log.Timber;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010!\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\"\u001a\n #*\u0004\u0018\u00010\u00160\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020&X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/blueair/devicemanager/DeviceScheduleService;", "Lkotlinx/coroutines/CoroutineScope;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "deviceScheduleRepository", "Lcom/blueair/database/repository/DeviceScheduleRepository;", "<init>", "(Lcom/blueair/devicemanager/DeviceManager;Lcom/blueair/database/repository/DeviceScheduleRepository;)V", "createSchedule", "", "device", "Lcom/blueair/core/model/Device;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "editingSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceSchedule;Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedulesFor", "", "deviceId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMergedSchedule", "merged", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMergedScheduleLocally", "(Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSchedulesForDevice", "getUpdatedDefaultNameIfRequired", "nuSchedule", "oldSchedule", "getDefaultScheduleName", "to12hFormat", "kotlin.jvm.PlatformType", "time", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleService.kt */
public final class DeviceScheduleService implements CoroutineScope {
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    /* access modifiers changed from: private */
    public final DeviceManager deviceManager;
    /* access modifiers changed from: private */
    public final DeviceScheduleRepository deviceScheduleRepository;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public DeviceScheduleService(DeviceManager deviceManager2, DeviceScheduleRepository deviceScheduleRepository2) {
        Intrinsics.checkNotNullParameter(deviceManager2, "deviceManager");
        Intrinsics.checkNotNullParameter(deviceScheduleRepository2, "deviceScheduleRepository");
        this.deviceManager = deviceManager2;
        this.deviceScheduleRepository = deviceScheduleRepository2;
    }

    public final Object createSchedule(Device device, DeviceSchedule deviceSchedule, Continuation<? super Unit> continuation) {
        Object await = BuildersKt__Builders_commonKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DeviceScheduleService$createSchedule$2(device, deviceSchedule, this, (Continuation<? super DeviceScheduleService$createSchedule$2>) null), 3, (Object) null).await(continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b4, code lost:
        if (deleteMergedSchedule(r1, r3, r5) == r6) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d5, code lost:
        if (deleteMergedScheduleLocally(r3, r5) == r6) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e5, code lost:
        r11 = r3.getSchedule();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01c4, code lost:
        if (r4.updateSchedule(r8, r1, r5) != r6) goto L_0x01c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateSchedule(com.blueair.core.model.Device r29, com.blueair.core.model.DeviceSchedule r30, com.blueair.core.model.DeviceScheduleMerged r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            boolean r5 = r4 instanceof com.blueair.devicemanager.DeviceScheduleService$updateSchedule$1
            if (r5 == 0) goto L_0x001e
            r5 = r4
            com.blueair.devicemanager.DeviceScheduleService$updateSchedule$1 r5 = (com.blueair.devicemanager.DeviceScheduleService$updateSchedule$1) r5
            int r6 = r5.label
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r7
            if (r6 == 0) goto L_0x001e
            int r4 = r5.label
            int r4 = r4 - r7
            r5.label = r4
            goto L_0x0023
        L_0x001e:
            com.blueair.devicemanager.DeviceScheduleService$updateSchedule$1 r5 = new com.blueair.devicemanager.DeviceScheduleService$updateSchedule$1
            r5.<init>(r0, r4)
        L_0x0023:
            java.lang.Object r4 = r5.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r7 = r5.label
            r8 = 0
            r9 = 4
            r10 = 3
            r11 = 2
            r12 = 1
            if (r7 == 0) goto L_0x0091
            if (r7 == r12) goto L_0x0074
            if (r7 == r11) goto L_0x0074
            if (r7 == r10) goto L_0x005b
            if (r7 != r9) goto L_0x0053
            java.lang.Object r1 = r5.L$4
            com.blueair.core.model.DeviceSchedule r1 = (com.blueair.core.model.DeviceSchedule) r1
            java.lang.Object r1 = r5.L$3
            com.blueair.core.model.DeviceSchedule r1 = (com.blueair.core.model.DeviceSchedule) r1
            java.lang.Object r1 = r5.L$2
            com.blueair.core.model.DeviceScheduleMerged r1 = (com.blueair.core.model.DeviceScheduleMerged) r1
            java.lang.Object r1 = r5.L$1
            com.blueair.core.model.DeviceSchedule r1 = (com.blueair.core.model.DeviceSchedule) r1
            java.lang.Object r1 = r5.L$0
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x01c7
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x005b:
            java.lang.Object r1 = r5.L$4
            com.blueair.core.model.DeviceSchedule r1 = (com.blueair.core.model.DeviceSchedule) r1
            java.lang.Object r2 = r5.L$3
            com.blueair.core.model.DeviceSchedule r2 = (com.blueair.core.model.DeviceSchedule) r2
            java.lang.Object r3 = r5.L$2
            com.blueair.core.model.DeviceScheduleMerged r3 = (com.blueair.core.model.DeviceScheduleMerged) r3
            java.lang.Object r7 = r5.L$1
            com.blueair.core.model.DeviceSchedule r7 = (com.blueair.core.model.DeviceSchedule) r7
            java.lang.Object r8 = r5.L$0
            com.blueair.core.model.Device r8 = (com.blueair.core.model.Device) r8
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x019e
        L_0x0074:
            int r1 = r5.I$0
            java.lang.Object r1 = r5.L$4
            com.blueair.core.model.DeviceScheduleMerged r1 = (com.blueair.core.model.DeviceScheduleMerged) r1
            java.lang.Object r1 = r5.L$3
            com.blueair.core.model.DeviceSchedule r1 = (com.blueair.core.model.DeviceSchedule) r1
            java.lang.Object r2 = r5.L$2
            com.blueair.core.model.DeviceScheduleMerged r2 = (com.blueair.core.model.DeviceScheduleMerged) r2
            java.lang.Object r3 = r5.L$1
            com.blueair.core.model.DeviceSchedule r3 = (com.blueair.core.model.DeviceSchedule) r3
            java.lang.Object r7 = r5.L$0
            com.blueair.core.model.Device r7 = (com.blueair.core.model.Device) r7
            kotlin.ResultKt.throwOnFailure(r4)
            r4 = r2
            r2 = r1
            r1 = r7
            goto L_0x00d9
        L_0x0091:
            kotlin.ResultKt.throwOnFailure(r4)
            if (r3 == 0) goto L_0x00dd
            boolean r4 = r1 instanceof com.blueair.core.model.HasAblCloudFunctions
            if (r4 == 0) goto L_0x00bb
            r5.L$0 = r1
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$1 = r4
            r5.L$2 = r3
            r5.L$3 = r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$4 = r4
            r5.I$0 = r8
            r5.label = r12
            java.lang.Object r4 = r0.deleteMergedSchedule(r1, r3, r5)
            if (r4 != r6) goto L_0x00b8
            goto L_0x01c6
        L_0x00b8:
            r4 = r3
            r3 = r2
            goto L_0x00d9
        L_0x00bb:
            r5.L$0 = r1
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$1 = r4
            r5.L$2 = r3
            r5.L$3 = r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$4 = r4
            r5.I$0 = r8
            r5.label = r11
            java.lang.Object r4 = r0.deleteMergedScheduleLocally(r3, r5)
            if (r4 != r6) goto L_0x00b8
            goto L_0x01c6
        L_0x00d9:
            r13 = r2
            r2 = r3
            r3 = r4
            goto L_0x00de
        L_0x00dd:
            r13 = r2
        L_0x00de:
            boolean r4 = r1 instanceof com.blueair.core.model.HasBlueCloudFunctions
            r7 = 0
            if (r4 == 0) goto L_0x012d
            if (r3 == 0) goto L_0x00f2
            java.util.List r11 = r3.getSchedule()
            if (r11 == 0) goto L_0x00f2
            java.lang.Object r11 = kotlin.collections.CollectionsKt.first(r11)
            com.blueair.core.model.DeviceSchedule r11 = (com.blueair.core.model.DeviceSchedule) r11
            goto L_0x00f3
        L_0x00f2:
            r11 = r7
        L_0x00f3:
            if (r11 == 0) goto L_0x00fa
            java.lang.String r14 = r11.getScheduleId()
            goto L_0x00fb
        L_0x00fa:
            r14 = r7
        L_0x00fb:
            java.lang.String r16 = r0.getUpdatedDefaultNameIfRequired(r13, r11)
            java.util.Set r11 = r13.getDaysOfWeek()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            com.blueair.devicemanager.DeviceScheduleService$updateSchedule$$inlined$sortedBy$1 r15 = new com.blueair.devicemanager.DeviceScheduleService$updateSchedule$$inlined$sortedBy$1
            r15.<init>()
            java.util.Comparator r15 = (java.util.Comparator) r15
            java.util.List r11 = kotlin.collections.CollectionsKt.sortedWith(r11, r15)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Set r21 = kotlin.collections.CollectionsKt.toSet(r11)
            r25 = 1914(0x77a, float:2.682E-42)
            r26 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            com.blueair.core.model.DeviceSchedule r13 = com.blueair.core.model.DeviceSchedule.copy$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x012d:
            r14 = r13
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r15 = "updateSchedule: "
            r13.<init>(r15)
            r13.append(r14)
            java.lang.String r15 = " editingSchedule = "
            r13.append(r15)
            r13.append(r3)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r11.d(r13, r8)
            if (r4 == 0) goto L_0x0178
            java.util.TimeZone r4 = com.blueair.core.model.Device.CC.getTimezone$default(r1, r7, r12, r7)
            java.lang.String r4 = r4.getID()
            java.lang.String r7 = "getID(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            r26 = 1791(0x6ff, float:2.51E-42)
            r27 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r23 = r4
            com.blueair.core.model.DeviceSchedule r4 = com.blueair.core.model.DeviceSchedule.copy$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0179
        L_0x0178:
            r4 = r14
        L_0x0179:
            com.blueair.database.repository.DeviceScheduleRepository r7 = r0.deviceScheduleRepository
            r5.L$0 = r1
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$2 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r5.L$3 = r8
            r5.L$4 = r4
            r5.label = r10
            java.lang.Object r7 = r7.update(r4, r5)
            if (r7 != r6) goto L_0x019a
            goto L_0x01c6
        L_0x019a:
            r8 = r1
            r7 = r2
            r1 = r4
            r2 = r14
        L_0x019e:
            com.blueair.devicemanager.DeviceManager r4 = r0.deviceManager
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r5.L$0 = r10
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r5.L$1 = r7
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$2 = r3
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$3 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r5.L$4 = r2
            r5.label = r9
            java.lang.Object r1 = r4.updateSchedule(r8, r1, r5)
            if (r1 != r6) goto L_0x01c7
        L_0x01c6:
            return r6
        L_0x01c7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceScheduleService.updateSchedule(com.blueair.core.model.Device, com.blueair.core.model.DeviceSchedule, com.blueair.core.model.DeviceScheduleMerged, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getSchedulesFor(String str, Continuation<? super List<DeviceScheduleMerged>> continuation) {
        return this.deviceScheduleRepository.getMergedSchedulesFor(str, continuation);
    }

    public final Object deleteMergedSchedule(Device device, DeviceScheduleMerged deviceScheduleMerged, Continuation<? super Unit> continuation) {
        Timber.Forest.d("deleteMergedSchedule: start", new Object[0]);
        Object await = BuildersKt__Builders_commonKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DeviceScheduleService$deleteMergedSchedule$2(deviceScheduleMerged, this, device, (Continuation<? super DeviceScheduleService$deleteMergedSchedule$2>) null), 3, (Object) null).await(continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteMergedScheduleLocally(com.blueair.core.model.DeviceScheduleMerged r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.blueair.devicemanager.DeviceScheduleService$deleteMergedScheduleLocally$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.devicemanager.DeviceScheduleService$deleteMergedScheduleLocally$1 r0 = (com.blueair.devicemanager.DeviceScheduleService$deleteMergedScheduleLocally$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.devicemanager.DeviceScheduleService$deleteMergedScheduleLocally$1 r0 = new com.blueair.devicemanager.DeviceScheduleService$deleteMergedScheduleLocally$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x004f
            if (r2 != r4) goto L_0x0047
            int r12 = r0.I$1
            int r12 = r0.I$0
            java.lang.Object r2 = r0.L$5
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r0.L$4
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            com.blueair.core.model.DeviceScheduleMerged r7 = (com.blueair.core.model.DeviceScheduleMerged) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            r12 = r7
            goto L_0x0086
        L_0x0047:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.List r13 = r12.getSchedule()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r13 = r13.iterator()
        L_0x0063:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x0079
            java.lang.Object r5 = r13.next()
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            java.lang.String r5 = r5.getScheduleId()
            if (r5 == 0) goto L_0x0063
            r2.add(r5)
            goto L_0x0063
        L_0x0079:
            java.util.List r2 = (java.util.List) r2
            r13 = r2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r5 = r13.iterator()
            r6 = r2
            r2 = r5
            r5 = r13
            r13 = r3
        L_0x0086:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x00c2
            java.lang.Object r7 = r2.next()
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            com.blueair.database.repository.DeviceScheduleRepository r9 = r11.deviceScheduleRepository
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$2 = r10
            r0.L$3 = r2
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$4 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$5 = r7
            r0.I$0 = r13
            r0.I$1 = r3
            r0.label = r4
            java.lang.Object r7 = r9.delete(r8, r0)
            if (r7 != r1) goto L_0x0086
            return r1
        L_0x00c2:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceScheduleService.deleteMergedScheduleLocally(com.blueair.core.model.DeviceScheduleMerged, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        if (r9 == r1) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008b, code lost:
        if (r9 == r1) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008d, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadSchedulesForDevice(java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.blueair.devicemanager.DeviceScheduleService$downloadSchedulesForDevice$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.devicemanager.DeviceScheduleService$downloadSchedulesForDevice$1 r0 = (com.blueair.devicemanager.DeviceScheduleService$downloadSchedulesForDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.devicemanager.DeviceScheduleService$downloadSchedulesForDevice$1 r0 = new com.blueair.devicemanager.DeviceScheduleService$downloadSchedulesForDevice$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            int r8 = r0.I$0
            java.lang.Object r8 = r0.L$1
            com.blueair.core.model.Device r8 = (com.blueair.core.model.Device) r8
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008e
        L_0x0038:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0040:
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0071
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r9)
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "downloadSchedulesForDevice: deviceId = "
            r2.<init>(r6)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r9.d(r2, r6)
            com.blueair.devicemanager.DeviceManager r9 = r7.deviceManager
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r9 = r9.getDatabaseDevice(r8, r0)
            if (r9 != r1) goto L_0x0071
            goto L_0x008d
        L_0x0071:
            com.blueair.core.model.Device r9 = (com.blueair.core.model.Device) r9
            if (r9 == 0) goto L_0x0090
            com.blueair.devicemanager.DeviceManager r2 = r7.deviceManager
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r8
            r0.I$0 = r3
            r0.label = r4
            java.lang.Object r9 = r2.getSchedules(r9, r0)
            if (r9 != r1) goto L_0x008e
        L_0x008d:
            return r1
        L_0x008e:
            java.util.List r9 = (java.util.List) r9
        L_0x0090:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceScheduleService.downloadSchedulesForDevice(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getUpdatedDefaultNameIfRequired(DeviceSchedule deviceSchedule, DeviceSchedule deviceSchedule2) {
        if (Intrinsics.areEqual((Object) deviceSchedule.getScheduleName(), (Object) getDefaultScheduleName(deviceSchedule2))) {
            return getDefaultScheduleName(deviceSchedule);
        }
        return deviceSchedule.getScheduleName();
    }

    private final String getDefaultScheduleName(DeviceSchedule deviceSchedule) {
        List split$default;
        String str;
        String obj;
        String str2 = null;
        if (deviceSchedule != null) {
            try {
                String scheduleName = deviceSchedule.getScheduleName();
                if (!(scheduleName == null || (split$default = StringsKt.split$default((CharSequence) scheduleName, new String[]{GigyaService.DEFAULT_USER_NAME}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.first(split$default)) == null || (obj = StringsKt.trim((CharSequence) str).toString()) == null)) {
                    new SimpleDateFormat("hh:mm a", Locale.getDefault()).parse(obj);
                    String str3 = to12hFormat(deviceSchedule.getStartTime()) + " - " + to12hFormat(deviceSchedule.getEndTime());
                    if (str3 != null) {
                        return str3;
                    }
                }
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append(deviceSchedule != null ? deviceSchedule.getStartTime() : null);
                sb.append(" - ");
                if (deviceSchedule != null) {
                    str2 = deviceSchedule.getEndTime();
                }
                sb.append(str2);
                return sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(deviceSchedule != null ? deviceSchedule.getStartTime() : null);
        sb2.append(" - ");
        sb2.append(deviceSchedule != null ? deviceSchedule.getEndTime() : null);
        return sb2.toString();
    }

    private final String to12hFormat(String str) {
        return DateTimeFormat.forPattern("HH:mm").parseDateTime(str).toLocalTime().toString("hh:mm a");
    }
}
