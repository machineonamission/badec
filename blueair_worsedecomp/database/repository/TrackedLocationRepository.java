package com.blueair.database.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.dao.AqiDataDao;
import com.blueair.database.entity.AqiDataEntity;
import com.blueair.database.entity.TrackedLocationEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f2\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"H@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\bH@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\bH@¢\u0006\u0002\u0010'J\u000e\u0010)\u001a\u00020\u001eH@¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010+\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0\u0007H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H@¢\u0006\u0002\u0010$J\u0016\u0010/\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H@¢\u0006\u0002\u0010$J\u000e\u00100\u001a\u00020\u001eH@¢\u0006\u0002\u0010*J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\"H@¢\u0006\u0002\u0010$J\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\f2\u0006\u0010!\u001a\u00020\"J\u000e\u00101\u001a\u00020\u001eH@¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000e¨\u00062"}, d2 = {"Lcom/blueair/database/repository/TrackedLocationRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "<init>", "(Lcom/blueair/database/BlueairDatabase;)V", "trackedLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "getTrackedLocations", "()Ljava/util/List;", "liveTrackedLocations", "Landroidx/lifecycle/LiveData;", "getLiveTrackedLocations", "()Landroidx/lifecycle/LiveData;", "userTrackedLocations", "getUserTrackedLocations", "liveUserTrackedLocations", "getLiveUserTrackedLocations", "currentLocation", "getCurrentLocation", "()Lcom/blueair/core/model/TrackedLocation;", "liveCurrentLocation", "getLiveCurrentLocation", "aqiData", "Lcom/blueair/core/model/AqiData;", "getAqiData", "liveAqiData", "getLiveAqiData", "setTrackedLocations", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveTrackedLocation", "locationId", "", "getTrackedLocation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrackedLocation", "trackedLocation", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackedLocation", "deleteAllTrackedLocations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAqiData", "(Lcom/blueair/core/model/AqiData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAqiData", "locationIds", "deleteDeviceLocationInfo", "deleteAllAqiData", "deleteAllOutdoorData", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TrackedLocationRepository.kt */
public final class TrackedLocationRepository {
    private final BlueairDatabase blueairDb;
    private final LiveData<List<AqiData>> liveAqiData;
    private final LiveData<TrackedLocation> liveCurrentLocation;
    private final LiveData<List<TrackedLocation>> liveTrackedLocations;
    private final LiveData<List<TrackedLocation>> liveUserTrackedLocations;

    public TrackedLocationRepository(BlueairDatabase blueairDatabase) {
        Intrinsics.checkNotNullParameter(blueairDatabase, "blueairDb");
        this.blueairDb = blueairDatabase;
        LiveData<List<TrackedLocation>> distinctUntilChanged = Transformations.distinctUntilChanged(Transformations.map(blueairDatabase.trackedLocationDao().getLiveTrackedLocations(), new TrackedLocationRepository$$ExternalSyntheticLambda1()));
        this.liveTrackedLocations = distinctUntilChanged;
        this.liveUserTrackedLocations = Transformations.map(distinctUntilChanged, new TrackedLocationRepository$$ExternalSyntheticLambda2());
        this.liveCurrentLocation = Transformations.distinctUntilChanged(Transformations.map(blueairDatabase.trackedLocationDao().getLiveCurrentLocation(), new TrackedLocationRepository$$ExternalSyntheticLambda3()));
        this.liveAqiData = Transformations.distinctUntilChanged(Transformations.map(blueairDatabase.aqiDataDao().getLiveAqiData(), new TrackedLocationRepository$$ExternalSyntheticLambda4()));
    }

    public final List<TrackedLocation> getTrackedLocations() {
        Iterable<TrackedLocationEntity> trackedLocations = this.blueairDb.trackedLocationDao().getTrackedLocations();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(trackedLocations, 10));
        for (TrackedLocationEntity trackedLocation : trackedLocations) {
            arrayList.add(trackedLocation.toTrackedLocation());
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static final List liveTrackedLocations$lambda$2(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Iterable<TrackedLocationEntity> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TrackedLocationEntity trackedLocation : iterable) {
            arrayList.add(trackedLocation.toTrackedLocation());
        }
        return (List) arrayList;
    }

    public final LiveData<List<TrackedLocation>> getLiveTrackedLocations() {
        return this.liveTrackedLocations;
    }

    public final List<TrackedLocation> getUserTrackedLocations() {
        Collection arrayList = new ArrayList();
        for (Object next : getTrackedLocations()) {
            if (!Intrinsics.areEqual((Object) ((TrackedLocation) next).getId(), (Object) "current")) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final LiveData<List<TrackedLocation>> getLiveUserTrackedLocations() {
        return this.liveUserTrackedLocations;
    }

    /* access modifiers changed from: private */
    public static final List liveUserTrackedLocations$lambda$5(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((TrackedLocation) next).getId(), (Object) "current")) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final TrackedLocation getCurrentLocation() {
        TrackedLocationEntity currentLocation = this.blueairDb.trackedLocationDao().getCurrentLocation();
        if (currentLocation != null) {
            return currentLocation.toTrackedLocation();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final TrackedLocation liveCurrentLocation$lambda$6(TrackedLocationEntity trackedLocationEntity) {
        if (trackedLocationEntity != null) {
            return trackedLocationEntity.toTrackedLocation();
        }
        return null;
    }

    public final LiveData<TrackedLocation> getLiveCurrentLocation() {
        return this.liveCurrentLocation;
    }

    public final List<AqiData> getAqiData() {
        Iterable<AqiDataEntity> aqiData = this.blueairDb.aqiDataDao().getAqiData();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(aqiData, 10));
        for (AqiDataEntity aqiData2 : aqiData) {
            arrayList.add(aqiData2.toAqiData());
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static final List liveAqiData$lambda$9(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Iterable<AqiDataEntity> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (AqiDataEntity aqiData : iterable) {
            arrayList.add(aqiData.toAqiData());
        }
        return (List) arrayList;
    }

    public final LiveData<List<AqiData>> getLiveAqiData() {
        return this.liveAqiData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0130, code lost:
        if (r5.insert(r13, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) != r1) goto L_0x0133;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setTrackedLocations(java.util.List<com.blueair.core.model.TrackedLocation> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.blueair.database.repository.TrackedLocationRepository$setTrackedLocations$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.database.repository.TrackedLocationRepository$setTrackedLocations$1 r0 = (com.blueair.database.repository.TrackedLocationRepository$setTrackedLocations$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.TrackedLocationRepository$setTrackedLocations$1 r0 = new com.blueair.database.repository.TrackedLocationRepository$setTrackedLocations$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0062
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            int r12 = r0.I$0
            java.lang.Object r12 = r0.L$3
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r12 = r0.L$2
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r12 = r0.L$1
            com.blueair.database.dao.TrackedLocationDao r12 = (com.blueair.database.dao.TrackedLocationDao) r12
            java.lang.Object r12 = r0.L$0
            java.util.List r12 = (java.util.List) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0133
        L_0x0040:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0048:
            int r12 = r0.I$0
            java.lang.Object r2 = r0.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$2
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$1
            com.blueair.database.dao.TrackedLocationDao r5 = (com.blueair.database.dao.TrackedLocationDao) r5
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r6
            r6 = r12
            r12 = r10
            goto L_0x010a
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r13)
            com.blueair.database.BlueairDatabase r13 = r11.blueairDb
            com.blueair.database.dao.TrackedLocationDao r5 = r13.trackedLocationDao()
            r13 = r12
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r6 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r6)
            r2.<init>(r7)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r13 = r13.iterator()
        L_0x007f:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto L_0x0093
            java.lang.Object r7 = r13.next()
            com.blueair.core.model.TrackedLocation r7 = (com.blueair.core.model.TrackedLocation) r7
            java.lang.String r7 = r7.getId()
            r2.add(r7)
            goto L_0x007f
        L_0x0093:
            java.util.List r2 = (java.util.List) r2
            java.util.List r13 = r11.getUserTrackedLocations()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r13 = r13.iterator()
        L_0x00a6:
            boolean r8 = r13.hasNext()
            if (r8 == 0) goto L_0x00c1
            java.lang.Object r8 = r13.next()
            r9 = r8
            com.blueair.core.model.TrackedLocation r9 = (com.blueair.core.model.TrackedLocation) r9
            java.lang.String r9 = r9.getId()
            boolean r9 = r2.contains(r9)
            if (r9 != 0) goto L_0x00a6
            r7.add(r8)
            goto L_0x00a6
        L_0x00c1:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r13 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r6)
            r13.<init>(r6)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r6 = r7.iterator()
        L_0x00d4:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r6.next()
            com.blueair.core.model.TrackedLocation r7 = (com.blueair.core.model.TrackedLocation) r7
            java.lang.String r7 = r7.getId()
            r13.add(r7)
            goto L_0x00d4
        L_0x00e8:
            java.util.List r13 = (java.util.List) r13
            r5.deleteTrackedLocations(r13)
            r0.L$0 = r12
            r0.L$1 = r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$2 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$3 = r6
            r6 = 0
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r4 = r11.deleteAqiData((java.util.List<java.lang.String>) r13, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r4 != r1) goto L_0x0109
            goto L_0x0132
        L_0x0109:
            r4 = r13
        L_0x010a:
            com.blueair.database.entity.TrackedLocationEntity$Companion r13 = com.blueair.database.entity.TrackedLocationEntity.Companion
            java.util.List r13 = r13.fromTrackedLocations(r12)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$1 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$2 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$3 = r12
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r12 = r5.insert((java.util.List<com.blueair.database.entity.TrackedLocationEntity>) r13, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x0133
        L_0x0132:
            return r1
        L_0x0133:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.TrackedLocationRepository.setTrackedLocations(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final TrackedLocation getLiveTrackedLocation$lambda$14(TrackedLocationEntity trackedLocationEntity) {
        if (trackedLocationEntity != null) {
            return trackedLocationEntity.toTrackedLocation();
        }
        return null;
    }

    public final LiveData<TrackedLocation> getLiveTrackedLocation(String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        return Transformations.distinctUntilChanged(Transformations.map(this.blueairDb.trackedLocationDao().liveTrackedLocation(str), new TrackedLocationRepository$$ExternalSyntheticLambda0()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTrackedLocation(java.lang.String r5, kotlin.coroutines.Continuation<? super com.blueair.core.model.TrackedLocation> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.TrackedLocationRepository$getTrackedLocation$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.TrackedLocationRepository$getTrackedLocation$1 r0 = (com.blueair.database.repository.TrackedLocationRepository$getTrackedLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.TrackedLocationRepository$getTrackedLocation$1 r0 = new com.blueair.database.repository.TrackedLocationRepository$getTrackedLocation$1
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
            com.blueair.database.dao.TrackedLocationDao r6 = r6.trackedLocationDao()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.getTrackedLocation(r5, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.blueair.database.entity.TrackedLocationEntity r6 = (com.blueair.database.entity.TrackedLocationEntity) r6
            if (r6 == 0) goto L_0x0057
            com.blueair.core.model.TrackedLocation r5 = r6.toTrackedLocation()
            return r5
        L_0x0057:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.TrackedLocationRepository.getTrackedLocation(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object insertTrackedLocation(TrackedLocation trackedLocation, Continuation<? super Unit> continuation) {
        Object insert = this.blueairDb.trackedLocationDao().insert(TrackedLocationEntity.Companion.fromTrackedLocation(trackedLocation), continuation);
        return insert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insert : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r8.deleteTrackedLocation(r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) == r1) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if (deleteAqiData(r8, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) != r1) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0083, code lost:
        if (deleteDeviceLocationInfo(r8, r0) == r1) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteTrackedLocation(com.blueair.core.model.TrackedLocation r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.blueair.database.repository.TrackedLocationRepository$deleteTrackedLocation$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.database.repository.TrackedLocationRepository$deleteTrackedLocation$1 r0 = (com.blueair.database.repository.TrackedLocationRepository$deleteTrackedLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.TrackedLocationRepository$deleteTrackedLocation$1 r0 = new com.blueair.database.repository.TrackedLocationRepository$deleteTrackedLocation$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.L$0
            com.blueair.core.model.TrackedLocation r7 = (com.blueair.core.model.TrackedLocation) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0086
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            java.lang.Object r7 = r0.L$0
            com.blueair.core.model.TrackedLocation r7 = (com.blueair.core.model.TrackedLocation) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0073
        L_0x0044:
            java.lang.Object r7 = r0.L$0
            com.blueair.core.model.TrackedLocation r7 = (com.blueair.core.model.TrackedLocation) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0064
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.database.BlueairDatabase r8 = r6.blueairDb
            com.blueair.database.dao.TrackedLocationDao r8 = r8.trackedLocationDao()
            java.lang.String r2 = r7.getId()
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.deleteTrackedLocation((java.lang.String) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x0064
            goto L_0x0085
        L_0x0064:
            java.lang.String r8 = r7.getId()
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r6.deleteAqiData((java.lang.String) r8, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x0073
            goto L_0x0085
        L_0x0073:
            java.lang.String r8 = r7.getId()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r6.deleteDeviceLocationInfo(r8, r0)
            if (r7 != r1) goto L_0x0086
        L_0x0085:
            return r1
        L_0x0086:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.TrackedLocationRepository.deleteTrackedLocation(com.blueair.core.model.TrackedLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r6.deleteAll(r0) == r1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (deleteAllAqiData(r0) != r1) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteAllTrackedLocations(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.TrackedLocationRepository$deleteAllTrackedLocations$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.TrackedLocationRepository$deleteAllTrackedLocations$1 r0 = (com.blueair.database.repository.TrackedLocationRepository$deleteAllTrackedLocations$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.TrackedLocationRepository$deleteAllTrackedLocations$1 r0 = new com.blueair.database.repository.TrackedLocationRepository$deleteAllTrackedLocations$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.database.BlueairDatabase r6 = r5.blueairDb
            com.blueair.database.dao.TrackedLocationDao r6 = r6.trackedLocationDao()
            r0.label = r4
            java.lang.Object r6 = r6.deleteAll(r0)
            if (r6 != r1) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            r0.label = r3
            java.lang.Object r6 = r5.deleteAllAqiData(r0)
            if (r6 != r1) goto L_0x0054
        L_0x0053:
            return r1
        L_0x0054:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.TrackedLocationRepository.deleteAllTrackedLocations(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object insertAqiData(List<AqiData> list, Continuation<? super Unit> continuation) {
        AqiDataDao aqiDataDao = this.blueairDb.aqiDataDao();
        Iterable<AqiData> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (AqiData fromTrackedLocationData : iterable) {
            arrayList.add(AqiDataEntity.Companion.fromTrackedLocationData(fromTrackedLocationData));
        }
        Object insertAll = aqiDataDao.insertAll((List) arrayList, continuation);
        return insertAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insertAll : Unit.INSTANCE;
    }

    public final Object insertAqiData(AqiData aqiData, Continuation<? super Unit> continuation) {
        Object insert = this.blueairDb.aqiDataDao().insert(AqiDataEntity.Companion.fromTrackedLocationData(aqiData), continuation);
        return insert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insert : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object deleteAqiData(List<String> list, Continuation<? super Unit> continuation) {
        Object delete = this.blueairDb.aqiDataDao().delete(list, continuation);
        return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object deleteAqiData(String str, Continuation<? super Unit> continuation) {
        Object delete = this.blueairDb.aqiDataDao().delete(str, continuation);
        return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object deleteDeviceLocationInfo(String str, Continuation<? super Unit> continuation) {
        Object deleteLocationId = this.blueairDb.deviceDao().deleteLocationId(str, continuation);
        return deleteLocationId == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteLocationId : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object deleteAllAqiData(Continuation<? super Unit> continuation) {
        Object deleteAll = this.blueairDb.aqiDataDao().deleteAll(continuation);
        return deleteAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteAll : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAqiData(java.lang.String r5, kotlin.coroutines.Continuation<? super com.blueair.core.model.AqiData> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.TrackedLocationRepository$getAqiData$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.TrackedLocationRepository$getAqiData$1 r0 = (com.blueair.database.repository.TrackedLocationRepository$getAqiData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.TrackedLocationRepository$getAqiData$1 r0 = new com.blueair.database.repository.TrackedLocationRepository$getAqiData$1
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
            com.blueair.database.dao.AqiDataDao r6 = r6.aqiDataDao()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.getAqiData(r5, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.blueair.database.entity.AqiDataEntity r6 = (com.blueair.database.entity.AqiDataEntity) r6
            if (r6 == 0) goto L_0x0057
            com.blueair.core.model.AqiData r5 = r6.toAqiData()
            return r5
        L_0x0057:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.TrackedLocationRepository.getAqiData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final AqiData liveAqiData$lambda$16(AqiDataEntity aqiDataEntity) {
        if (aqiDataEntity != null) {
            return aqiDataEntity.toAqiData();
        }
        return null;
    }

    public final LiveData<AqiData> liveAqiData(String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        return Transformations.map(this.blueairDb.aqiDataDao().getLiveAqiData(str), new TrackedLocationRepository$$ExternalSyntheticLambda5());
    }

    public final Object deleteAllOutdoorData(Continuation<? super Unit> continuation) {
        Object deleteAllTrackedLocations = deleteAllTrackedLocations(continuation);
        return deleteAllTrackedLocations == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteAllTrackedLocations : Unit.INSTANCE;
    }
}
