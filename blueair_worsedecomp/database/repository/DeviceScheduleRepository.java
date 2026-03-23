package com.blueair.database.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.entity.DeviceScheduleEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bH@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u0016\u001a\u00020\u0017H@¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0016\u001a\u00020\u0017H@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0012H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0017H@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/blueair/database/repository/DeviceScheduleRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "<init>", "(Lcom/blueair/database/BlueairDatabase;)V", "liveDataScheduleList", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/database/entity/DeviceScheduleEntity;", "getLiveDataScheduleList", "()Landroidx/lifecycle/LiveData;", "liveDataMergedSchedules", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "getLiveDataMergedSchedules", "()Landroidx/lifecycle/MediatorLiveData;", "getSchedules", "Lcom/blueair/core/model/DeviceSchedule;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMergedSchedules", "getMergedSchedulesFor", "deviceId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replace", "", "deviceSchedules", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "schedule", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "scheduleId", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleRepository.kt */
public final class DeviceScheduleRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BlueairDatabase blueairDb;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\t"}, d2 = {"Lcom/blueair/database/repository/DeviceScheduleRepository$Companion;", "", "<init>", "()V", "legacyScheduleMergeIfNeeded", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "deviceScheduleList", "Lcom/blueair/core/model/DeviceSchedule;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceScheduleMerged> legacyScheduleMergeIfNeeded(List<DeviceSchedule> list) {
            Intrinsics.checkNotNullParameter(list, "deviceScheduleList");
            List<List> arrayList = new ArrayList<>();
            for (DeviceSchedule listOf : list) {
                arrayList.add(CollectionsKt.listOf(listOf));
            }
            Collection arrayList2 = new ArrayList();
            for (List newInstance : arrayList) {
                DeviceScheduleMerged newInstance2 = DeviceScheduleMerged.Companion.newInstance(newInstance);
                if (newInstance2 != null) {
                    arrayList2.add(newInstance2);
                }
            }
            return (List) arrayList2;
        }
    }

    public DeviceScheduleRepository(BlueairDatabase blueairDatabase) {
        Intrinsics.checkNotNullParameter(blueairDatabase, "blueairDb");
        this.blueairDb = blueairDatabase;
    }

    private final LiveData<List<DeviceScheduleEntity>> getLiveDataScheduleList() {
        return this.blueairDb.deviceScheduleDao().getLiveSchedules();
    }

    public final MediatorLiveData<List<DeviceScheduleMerged>> getLiveDataMergedSchedules() {
        MediatorLiveData<List<DeviceScheduleMerged>> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(getLiveDataScheduleList(), new DeviceScheduleRepository$sam$androidx_lifecycle_Observer$0(new DeviceScheduleRepository$$ExternalSyntheticLambda0(mediatorLiveData)));
        return mediatorLiveData;
    }

    /* access modifiers changed from: private */
    public static final Unit _get_liveDataMergedSchedules_$lambda$2$lambda$1(MediatorLiveData mediatorLiveData, List list) {
        Companion companion = Companion;
        Intrinsics.checkNotNull(list);
        Iterable<DeviceScheduleEntity> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DeviceScheduleEntity deviceSchedule : iterable) {
            arrayList.add(deviceSchedule.toDeviceSchedule());
        }
        mediatorLiveData.setValue(companion.legacyScheduleMergeIfNeeded((List) arrayList));
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d A[LOOP:0: B:16:0x0057->B:18:0x005d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSchedules(kotlin.coroutines.Continuation<? super java.util.List<com.blueair.core.model.DeviceSchedule>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.database.repository.DeviceScheduleRepository$getSchedules$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.database.repository.DeviceScheduleRepository$getSchedules$1 r0 = (com.blueair.database.repository.DeviceScheduleRepository$getSchedules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.DeviceScheduleRepository$getSchedules$1 r0 = new com.blueair.database.repository.DeviceScheduleRepository$getSchedules$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.database.BlueairDatabase r5 = r4.blueairDb
            com.blueair.database.dao.DeviceScheduleDao r5 = r5.deviceScheduleDao()
            r0.label = r3
            java.lang.Object r5 = r5.getAll(r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L_0x0057:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x006b
            java.lang.Object r1 = r5.next()
            com.blueair.database.entity.DeviceScheduleEntity r1 = (com.blueair.database.entity.DeviceScheduleEntity) r1
            com.blueair.core.model.DeviceSchedule r1 = r1.toDeviceSchedule()
            r0.add(r1)
            goto L_0x0057
        L_0x006b:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.DeviceScheduleRepository.getSchedules(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A[LOOP:0: B:16:0x0059->B:18:0x005f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMergedSchedules(kotlin.coroutines.Continuation<? super java.util.List<com.blueair.core.model.DeviceScheduleMerged>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedules$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedules$1 r0 = (com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedules$1 r0 = new com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedules$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.database.BlueairDatabase r5 = r4.blueairDb
            com.blueair.database.dao.DeviceScheduleDao r5 = r5.deviceScheduleDao()
            r0.label = r3
            java.lang.Object r5 = r5.getAll(r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L_0x0059:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x006d
            java.lang.Object r1 = r5.next()
            com.blueair.database.entity.DeviceScheduleEntity r1 = (com.blueair.database.entity.DeviceScheduleEntity) r1
            com.blueair.core.model.DeviceSchedule r1 = r1.toDeviceSchedule()
            r0.add(r1)
            goto L_0x0059
        L_0x006d:
            java.util.List r0 = (java.util.List) r0
            com.blueair.database.repository.DeviceScheduleRepository$Companion r5 = Companion
            java.util.List r5 = r5.legacyScheduleMergeIfNeeded(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.DeviceScheduleRepository.getMergedSchedules(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a A[LOOP:0: B:16:0x0064->B:18:0x006a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMergedSchedulesFor(java.lang.String r5, kotlin.coroutines.Continuation<? super java.util.List<com.blueair.core.model.DeviceScheduleMerged>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedulesFor$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedulesFor$1 r0 = (com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedulesFor$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedulesFor$1 r0 = new com.blueair.database.repository.DeviceScheduleRepository$getMergedSchedulesFor$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.database.BlueairDatabase r6 = r4.blueairDb
            com.blueair.database.dao.DeviceScheduleDao r6 = r6.deviceScheduleDao()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.getByDeviceId(r5, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.util.List r6 = (java.util.List) r6
            r5 = r6
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L_0x0064:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0078
            java.lang.Object r1 = r5.next()
            com.blueair.database.entity.DeviceScheduleEntity r1 = (com.blueair.database.entity.DeviceScheduleEntity) r1
            com.blueair.core.model.DeviceSchedule r1 = r1.toDeviceSchedule()
            r0.add(r1)
            goto L_0x0064
        L_0x0078:
            java.util.List r0 = (java.util.List) r0
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "After querying the db "
            r1.<init>(r2)
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            r1.append(r6)
            java.lang.String r6 = ", converted records "
            r1.append(r6)
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r5.d(r6, r1)
            com.blueair.database.repository.DeviceScheduleRepository$Companion r5 = Companion
            java.util.List r5 = r5.legacyScheduleMergeIfNeeded(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.DeviceScheduleRepository.getMergedSchedulesFor(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c4, code lost:
        if (r10.insert(r8, r0) == r1) goto L_0x00c6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object replace(java.util.List<com.blueair.core.model.DeviceSchedule> r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.blueair.database.repository.DeviceScheduleRepository$replace$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.database.repository.DeviceScheduleRepository$replace$1 r0 = (com.blueair.database.repository.DeviceScheduleRepository$replace$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.DeviceScheduleRepository$replace$1 r0 = new com.blueair.database.repository.DeviceScheduleRepository$replace$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r8 = r0.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$0
            java.util.List r8 = (java.util.List) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c7
        L_0x003a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0042:
            java.lang.Object r8 = r0.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009d
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r8
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x0063:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x007b
            java.lang.Object r5 = r10.next()
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            com.blueair.database.entity.DeviceScheduleEntity$Companion r6 = com.blueair.database.entity.DeviceScheduleEntity.Companion
            com.blueair.database.entity.DeviceScheduleEntity r5 = r6.fromDeviceSchedule(r5)
            if (r5 == 0) goto L_0x0063
            r2.add(r5)
            goto L_0x0063
        L_0x007b:
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            com.blueair.database.BlueairDatabase r2 = r7.blueairDb
            com.blueair.database.dao.DeviceScheduleDao r2 = r2.deviceScheduleDao()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r5
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r2 = r2.deleteAllForDevice(r9, r0)
            if (r2 != r1) goto L_0x009b
            goto L_0x00c6
        L_0x009b:
            r2 = r8
            r8 = r10
        L_0x009d:
            r10 = r8
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x00ca
            com.blueair.database.BlueairDatabase r10 = r7.blueairDb
            com.blueair.database.dao.DeviceScheduleDao r10 = r10.deviceScheduleDao()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$0 = r2
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r8 = r10.insert(r8, r0)
            if (r8 != r1) goto L_0x00c7
        L_0x00c6:
            return r1
        L_0x00c7:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00ca:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.DeviceScheduleRepository.replace(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object update(DeviceSchedule deviceSchedule, Continuation<? super Unit> continuation) {
        Object update;
        DeviceScheduleEntity fromDeviceSchedule = DeviceScheduleEntity.Companion.fromDeviceSchedule(deviceSchedule);
        if (fromDeviceSchedule == null || (update = this.blueairDb.deviceScheduleDao().update(fromDeviceSchedule, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return update;
    }

    public final Object delete(String str, Continuation<? super Unit> continuation) {
        Object delete = this.blueairDb.deviceScheduleDao().delete(str, continuation);
        return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
    }
}
