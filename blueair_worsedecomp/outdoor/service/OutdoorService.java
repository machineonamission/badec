package com.blueair.outdoor.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.amplitude.api.Constants;
import com.blueair.api.client.OutdoorClient;
import com.blueair.auth.AuthService;
import com.blueair.auth.LogOutable;
import com.blueair.core.FileNames;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.PersistentObjectDelegate;
import com.blueair.database.repository.TrackedLocationRepository;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0 2\u0006\u00100\u001a\u00020\u001cJ\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 2\u0006\u00102\u001a\u00020\u0011J\u0018\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020\u0011H@¢\u0006\u0002\u00104J\u001e\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u000206H@¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H@¢\u0006\u0002\u0010<J,\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001c0>2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020?H@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020?2\u0006\u0010A\u001a\u00020\u001cH@¢\u0006\u0002\u0010FJ6\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020-\u0018\u00010H2\u0006\u00107\u001a\u0002082\u0006\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u0011H@¢\u0006\u0002\u0010KJ\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\"\u0010N\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH@¢\u0006\u0002\u0010OJ\"\u0010N\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020?H@¢\u0006\u0002\u0010QJ\u0018\u0010R\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u001cH@¢\u0006\u0002\u0010FJ\b\u0010S\u001a\u000206H\u0002J\b\u0010T\u001a\u000206H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000RC\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010'\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 ¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0012\u0010U\u001a\u00020VX\u0005¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Lcom/blueair/outdoor/service/OutdoorService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/blueair/auth/LogOutable;", "context", "Landroid/content/Context;", "trackedLocationRepository", "Lcom/blueair/database/repository/TrackedLocationRepository;", "outdoorClient", "Lcom/blueair/api/client/OutdoorClient;", "geocodeService", "Lcom/blueair/outdoor/service/GeocodeService;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Landroid/content/Context;Lcom/blueair/database/repository/TrackedLocationRepository;Lcom/blueair/api/client/OutdoorClient;Lcom/blueair/outdoor/service/GeocodeService;Lcom/blueair/auth/AuthService;)V", "<set-?>", "", "", "", "aqiDataRefreshTime", "getAqiDataRefreshTime", "()Ljava/util/Map;", "setAqiDataRefreshTime", "(Ljava/util/Map;)V", "aqiDataRefreshTime$delegate", "Lcom/blueair/core/util/PersistentObjectDelegate;", "databaseTrackedLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "getDatabaseTrackedLocations", "()Ljava/util/List;", "databaseLiveTrackedLocations", "Landroidx/lifecycle/LiveData;", "getDatabaseLiveTrackedLocations", "()Landroidx/lifecycle/LiveData;", "databaseUserTrackedLocations", "getDatabaseUserTrackedLocations", "databaseLiveUserTrackedLocations", "getDatabaseLiveUserTrackedLocations", "databaseCurrentLocation", "getDatabaseCurrentLocation", "()Lcom/blueair/core/model/TrackedLocation;", "databaseLiveCurrentLocation", "getDatabaseLiveCurrentLocation", "databaseLiveAqiData", "Lcom/blueair/core/model/AqiData;", "getDatabaseLiveAqiData", "liveAqiData", "location", "liveTrackedLocation", "locationId", "getTrackedLocation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCurrentLocation", "", "lat", "", "lon", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCurrentLocation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadTrackedLocations", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "insertTrackedLocation", "trackedLocation", "aqiData", "isUpdate", "(Lcom/blueair/core/model/TrackedLocation;Lcom/blueair/core/model/AqiData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackedLocation", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTrackedLocationWithAqiData", "Lkotlin/Pair;", "lng", "mapType", "(DDLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterAllowRefreshLocations", "locations", "fetchAqiData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceFetch", "(Lcom/blueair/core/model/TrackedLocation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAqiData", "deleteAllOutdoorDataInBackground", "logOut", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorService.kt */
public final class OutdoorService implements CoroutineScope, LogOutable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OutdoorService.class, "aqiDataRefreshTime", "getAqiDataRefreshTime()Ljava/util/Map;", 0))};
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final PersistentObjectDelegate aqiDataRefreshTime$delegate;
    /* access modifiers changed from: private */
    public final AuthService authService;
    private final Context context;
    private final LiveData<List<AqiData>> databaseLiveAqiData;
    private final LiveData<TrackedLocation> databaseLiveCurrentLocation;
    private final LiveData<List<TrackedLocation>> databaseLiveTrackedLocations;
    private final LiveData<List<TrackedLocation>> databaseLiveUserTrackedLocations;
    /* access modifiers changed from: private */
    public final GeocodeService geocodeService;
    /* access modifiers changed from: private */
    public final OutdoorClient outdoorClient;
    /* access modifiers changed from: private */
    public final TrackedLocationRepository trackedLocationRepository;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public OutdoorService(Context context2, TrackedLocationRepository trackedLocationRepository2, OutdoorClient outdoorClient2, GeocodeService geocodeService2, AuthService authService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(trackedLocationRepository2, "trackedLocationRepository");
        Intrinsics.checkNotNullParameter(outdoorClient2, "outdoorClient");
        Intrinsics.checkNotNullParameter(geocodeService2, "geocodeService");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.context = context2;
        this.trackedLocationRepository = trackedLocationRepository2;
        this.outdoorClient = outdoorClient2;
        this.geocodeService = geocodeService2;
        this.authService = authService2;
        Context context3 = context2;
        this.aqiDataRefreshTime$delegate = new PersistentObjectDelegate(context3, FileNames.AQI_DATA_REFRESH_TIME_MAP_FILE, MapsKt.emptyMap(), Map.class, String.class, Long.class);
        this.databaseLiveTrackedLocations = trackedLocationRepository2.getLiveTrackedLocations();
        this.databaseLiveUserTrackedLocations = trackedLocationRepository2.getLiveUserTrackedLocations();
        this.databaseLiveCurrentLocation = trackedLocationRepository2.getLiveCurrentLocation();
        this.databaseLiveAqiData = trackedLocationRepository2.getLiveAqiData();
    }

    /* access modifiers changed from: private */
    public final Map<String, Long> getAqiDataRefreshTime() {
        return (Map) this.aqiDataRefreshTime$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final void setAqiDataRefreshTime(Map<String, Long> map) {
        this.aqiDataRefreshTime$delegate.setValue(this, $$delegatedProperties[0], map);
    }

    public final List<TrackedLocation> getDatabaseTrackedLocations() {
        return this.trackedLocationRepository.getTrackedLocations();
    }

    public final LiveData<List<TrackedLocation>> getDatabaseLiveTrackedLocations() {
        return this.databaseLiveTrackedLocations;
    }

    public final List<TrackedLocation> getDatabaseUserTrackedLocations() {
        return this.trackedLocationRepository.getTrackedLocations();
    }

    public final LiveData<List<TrackedLocation>> getDatabaseLiveUserTrackedLocations() {
        return this.databaseLiveUserTrackedLocations;
    }

    public final TrackedLocation getDatabaseCurrentLocation() {
        return this.trackedLocationRepository.getCurrentLocation();
    }

    public final LiveData<TrackedLocation> getDatabaseLiveCurrentLocation() {
        return this.databaseLiveCurrentLocation;
    }

    public final LiveData<List<AqiData>> getDatabaseLiveAqiData() {
        return this.databaseLiveAqiData;
    }

    public final LiveData<AqiData> liveAqiData(TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        return this.trackedLocationRepository.liveAqiData(trackedLocation.getId());
    }

    public final LiveData<TrackedLocation> liveTrackedLocation(String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        return this.trackedLocationRepository.getLiveTrackedLocation(str);
    }

    public final Object getTrackedLocation(String str, Continuation<? super TrackedLocation> continuation) {
        return this.trackedLocationRepository.getTrackedLocation(str, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x016f, code lost:
        if (r1 != r7) goto L_0x0172;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setCurrentLocation(double r25, double r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            r24 = this;
            r0 = r24
            r3 = r25
            r5 = r27
            r1 = r29
            boolean r2 = r1 instanceof com.blueair.outdoor.service.OutdoorService$setCurrentLocation$1
            if (r2 == 0) goto L_0x001c
            r2 = r1
            com.blueair.outdoor.service.OutdoorService$setCurrentLocation$1 r2 = (com.blueair.outdoor.service.OutdoorService$setCurrentLocation$1) r2
            int r7 = r2.label
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 & r8
            if (r7 == 0) goto L_0x001c
            int r1 = r2.label
            int r1 = r1 - r8
            r2.label = r1
            goto L_0x0021
        L_0x001c:
            com.blueair.outdoor.service.OutdoorService$setCurrentLocation$1 r2 = new com.blueair.outdoor.service.OutdoorService$setCurrentLocation$1
            r2.<init>(r0, r1)
        L_0x0021:
            r13 = r2
            java.lang.Object r1 = r13.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r13.label
            r15 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x0088
            if (r2 == r8) goto L_0x006e
            if (r2 == r7) goto L_0x0054
            if (r2 != r15) goto L_0x004c
            int r2 = r13.I$0
            double r2 = r13.D$1
            double r2 = r13.D$0
            java.lang.Object r2 = r13.L$2
            com.blueair.core.model.TrackedLocation r2 = (com.blueair.core.model.TrackedLocation) r2
            java.lang.Object r2 = r13.L$1
            com.blueair.core.model.TrackedLocation r2 = (com.blueair.core.model.TrackedLocation) r2
            java.lang.Object r2 = r13.L$0
            com.blueair.core.model.TrackedLocation r2 = (com.blueair.core.model.TrackedLocation) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0172
        L_0x004c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0054:
            int r2 = r13.I$0
            double r3 = r13.D$1
            double r5 = r13.D$0
            java.lang.Object r7 = r13.L$2
            com.blueair.core.model.TrackedLocation r7 = (com.blueair.core.model.TrackedLocation) r7
            java.lang.Object r9 = r13.L$1
            com.blueair.core.model.TrackedLocation r9 = (com.blueair.core.model.TrackedLocation) r9
            java.lang.Object r10 = r13.L$0
            com.blueair.core.model.TrackedLocation r10 = (com.blueair.core.model.TrackedLocation) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r7
            r7 = r14
            r14 = r8
            goto L_0x0150
        L_0x006e:
            double r2 = r13.D$1
            double r4 = r13.D$0
            java.lang.Object r6 = r13.L$1
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            java.lang.Object r9 = r13.L$0
            com.blueair.core.model.TrackedLocation r9 = (com.blueair.core.model.TrackedLocation) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r9
            r7 = r14
            r9 = r6
            r14 = r8
            r22 = r4
            r5 = r2
            r3 = r22
            goto L_0x0108
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.core.model.TrackedLocation r1 = r0.getDatabaseCurrentLocation()
            if (r1 == 0) goto L_0x009a
            double r9 = r1.getLat()
            java.lang.Double r2 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r9)
            goto L_0x009b
        L_0x009a:
            r2 = 0
        L_0x009b:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Double) r2, (double) r3)
            if (r2 == 0) goto L_0x00ac
            double r9 = r1.getLon()
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00ac
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00ac:
            com.blueair.core.util.UserInfoCollectionsManager r16 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.core.model.UserInfoItem r17 = com.blueair.core.model.UserInfoItem.USER_LOCATION
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r9 = ", "
            r2.append(r9)
            r2.append(r5)
            java.lang.String r18 = r2.toString()
            r20 = 4
            r21 = 0
            r19 = 0
            com.blueair.core.util.UserInfoCollectionsManager.addRecord$default(r16, r17, r18, r19, r20, r21)
            r2 = r1
            com.blueair.core.model.TrackedLocation r1 = new com.blueair.core.model.TrackedLocation
            r11 = 0
            java.lang.String r12 = "WGS"
            r9 = r2
            java.lang.String r2 = "current"
            r10 = r7
            r7 = 0
            r16 = r8
            r8 = 0
            r17 = r9
            r9 = 0
            r18 = r10
            r10 = 0
            r15 = r16
            r16 = r14
            r14 = r15
            r15 = r17
            r1.<init>(r2, r3, r5, r7, r8, r9, r10, r11, r12)
            com.blueair.outdoor.service.GeocodeService r2 = r0.geocodeService
            r13.L$0 = r15
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r13.L$1 = r7
            r13.D$0 = r3
            r13.D$1 = r5
            r13.label = r14
            java.lang.Object r2 = r2.getTrackedLocation(r1, r13)
            r7 = r16
            if (r2 != r7) goto L_0x0105
            goto L_0x0171
        L_0x0105:
            r9 = r1
            r1 = r2
            r10 = r15
        L_0x0108:
            com.blueair.core.model.TrackedLocation r1 = (com.blueair.core.model.TrackedLocation) r1
            if (r1 == 0) goto L_0x0174
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "setCurrentLocation: oldCurrentLocation = "
            r8.<init>(r11)
            r8.append(r10)
            java.lang.String r11 = ", nuCurrentLocation = "
            r8.append(r11)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r11 = 0
            java.lang.Object[] r12 = new java.lang.Object[r11]
            r2.d(r8, r12)
            com.blueair.database.repository.TrackedLocationRepository r2 = r0.trackedLocationRepository
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r13.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r13.L$1 = r8
            r13.L$2 = r1
            r13.D$0 = r3
            r13.D$1 = r5
            r13.I$0 = r11
            r8 = 2
            r13.label = r8
            java.lang.Object r2 = r2.insertTrackedLocation(r1, r13)
            if (r2 != r7) goto L_0x014a
            goto L_0x0171
        L_0x014a:
            r22 = r5
            r5 = r3
            r3 = r22
            r2 = r11
        L_0x0150:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r13.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r13.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r13.L$2 = r8
            r13.D$0 = r5
            r13.D$1 = r3
            r13.I$0 = r2
            r2 = 3
            r13.label = r2
            java.lang.Object r1 = r0.fetchAqiData(r1, r14, r13)
            if (r1 != r7) goto L_0x0172
        L_0x0171:
            return r7
        L_0x0172:
            com.blueair.core.model.AqiData r1 = (com.blueair.core.model.AqiData) r1
        L_0x0174:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.setCurrentLocation(double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object clearCurrentLocation(Continuation<? super Unit> continuation) {
        Object deleteTrackedLocation;
        TrackedLocation currentLocation = this.trackedLocationRepository.getCurrentLocation();
        if (currentLocation == null || (deleteTrackedLocation = this.trackedLocationRepository.deleteTrackedLocation(currentLocation, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return deleteTrackedLocation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r13 == r1) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (r13 != r1) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadTrackedLocations(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Boolean>> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$1 r0 = (com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$1 r0 = new com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$1
            r0.<init>(r12, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x008f
        L_0x002e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x007d
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r13)
            com.blueair.auth.AuthService r13 = r12.authService
            kotlinx.coroutines.flow.StateFlow r13 = r13.isUserLoggedIn()
            java.lang.Object r13 = r13.getValue()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x005a
            io.flatcircle.coroutinehelper.ApiResult$Companion r13 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            io.flatcircle.coroutinehelper.ApiResult r13 = r13.success(r0)
            return r13
        L_0x005a:
            r6 = r12
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()
            r7 = r13
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$2 r13 = new com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$2
            r13.<init>(r12, r3)
            r9 = r13
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 2
            r11 = 0
            r8 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            com.blueair.api.client.OutdoorClient r13 = r12.outdoorClient
            r0.label = r5
            java.lang.Object r13 = r13.getTrackedLocations(r0)
            if (r13 != r1) goto L_0x007d
            goto L_0x008e
        L_0x007d:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$result$1 r2 = new com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$result$1
            r2.<init>(r12, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r4
            java.lang.Object r13 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r13, r2, r0)
            if (r13 != r1) goto L_0x008f
        L_0x008e:
            return r1
        L_0x008f:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            boolean r1 = r13.isSuccess()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            io.flatcircle.coroutinehelper.ApiResult r13 = r0.fromResult(r13, r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.downloadTrackedLocations(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object insertTrackedLocation(com.blueair.core.model.TrackedLocation r24, com.blueair.core.model.AqiData r25, boolean r26, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.TrackedLocation>> r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            boolean r3 = r2 instanceof com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$1 r3 = (com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$1 r3 = new com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x005b
            if (r5 == r7) goto L_0x0049
            if (r5 != r6) goto L_0x0041
            boolean r1 = r3.Z$0
            java.lang.Object r1 = r3.L$2
            com.blueair.core.model.TrackedLocation r1 = (com.blueair.core.model.TrackedLocation) r1
            java.lang.Object r1 = r3.L$1
            com.blueair.core.model.AqiData r1 = (com.blueair.core.model.AqiData) r1
            java.lang.Object r1 = r3.L$0
            com.blueair.core.model.TrackedLocation r1 = (com.blueair.core.model.TrackedLocation) r1
            kotlin.ResultKt.throwOnFailure(r2)
            return r2
        L_0x0041:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0049:
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$2
            com.blueair.core.model.TrackedLocation r5 = (com.blueair.core.model.TrackedLocation) r5
            java.lang.Object r7 = r3.L$1
            com.blueair.core.model.AqiData r7 = (com.blueair.core.model.AqiData) r7
            java.lang.Object r8 = r3.L$0
            com.blueair.core.model.TrackedLocation r8 = (com.blueair.core.model.TrackedLocation) r8
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x009f
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 == 0) goto L_0x0063
            r5 = r24
            goto L_0x007f
        L_0x0063:
            r21 = 510(0x1fe, float:7.15E-43)
            r22 = 0
            java.lang.String r10 = ""
            r11 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r9 = r24
            com.blueair.core.model.TrackedLocation r2 = com.blueair.core.model.TrackedLocation.copy$default(r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r21, r22)
            r5 = r2
        L_0x007f:
            com.blueair.api.client.OutdoorClient r2 = r0.outdoorClient
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r3.L$0 = r8
            r8 = r25
            r3.L$1 = r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$2 = r9
            r3.Z$0 = r1
            r3.label = r7
            java.lang.Object r2 = r2.addTrackedLocation(r5, r3)
            if (r2 != r4) goto L_0x009c
            goto L_0x00c5
        L_0x009c:
            r7 = r8
            r8 = r24
        L_0x009f:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$2 r9 = new com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$2
            r10 = 0
            r9.<init>(r0, r7, r10)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$0 = r8
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$1 = r7
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$2 = r5
            r3.Z$0 = r1
            r3.label = r6
            java.lang.Object r1 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r2, r9, r3)
            if (r1 != r4) goto L_0x00c6
        L_0x00c5:
            return r4
        L_0x00c6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.insertTrackedLocation(com.blueair.core.model.TrackedLocation, com.blueair.core.model.AqiData, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r7 == r1) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r7 != r1) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteTrackedLocation(com.blueair.core.model.TrackedLocation r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$1 r0 = (com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$1 r0 = new com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.L$0
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006a
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            java.lang.Object r6 = r0.L$0
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.api.client.OutdoorClient r7 = r5.outdoorClient
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.removeTrackedLocation((com.blueair.core.model.TrackedLocation) r6, (kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<okhttp3.ResponseBody>>) r0)
            if (r7 != r1) goto L_0x0051
            goto L_0x0069
        L_0x0051:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$result$1 r2 = new com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$result$1
            r4 = 0
            r2.<init>(r5, r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r2, r0)
            if (r7 != r1) goto L_0x006a
        L_0x0069:
            return r1
        L_0x006a:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            boolean r6 = r7.isSuccess()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.deleteTrackedLocation(com.blueair.core.model.TrackedLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x014f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchTrackedLocationWithAqiData(double r27, double r29, java.lang.String r31, kotlin.coroutines.Continuation<? super kotlin.Pair<com.blueair.core.model.TrackedLocation, com.blueair.core.model.AqiData>> r32) {
        /*
            r26 = this;
            r0 = r26
            r1 = r32
            boolean r2 = r1 instanceof com.blueair.outdoor.service.OutdoorService$fetchTrackedLocationWithAqiData$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.outdoor.service.OutdoorService$fetchTrackedLocationWithAqiData$1 r2 = (com.blueair.outdoor.service.OutdoorService$fetchTrackedLocationWithAqiData$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.outdoor.service.OutdoorService$fetchTrackedLocationWithAqiData$1 r2 = new com.blueair.outdoor.service.OutdoorService$fetchTrackedLocationWithAqiData$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0057
            if (r4 == r7) goto L_0x0047
            if (r4 != r6) goto L_0x003f
            double r3 = r2.D$1
            double r3 = r2.D$0
            java.lang.Object r3 = r2.L$1
            com.blueair.core.model.TrackedLocation r3 = (com.blueair.core.model.TrackedLocation) r3
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0145
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            double r8 = r2.D$1
            double r10 = r2.D$0
            java.lang.Object r4 = r2.L$1
            com.blueair.core.model.TrackedLocation r4 = (com.blueair.core.model.TrackedLocation) r4
            java.lang.Object r4 = r2.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008e
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.core.model.TrackedLocation r12 = new com.blueair.core.model.TrackedLocation
            r21 = 0
            r22 = 0
            java.lang.String r13 = "temp"
            r18 = 0
            r19 = 0
            r20 = 0
            r14 = r27
            r16 = r29
            r23 = r31
            r12.<init>(r13, r14, r16, r18, r19, r20, r21, r22, r23)
            com.blueair.outdoor.service.GeocodeService r1 = r0.geocodeService
            r4 = r31
            r2.L$0 = r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$1 = r8
            r2.D$0 = r14
            r8 = r29
            r2.D$1 = r8
            r2.label = r7
            java.lang.Object r1 = r1.getTrackedLocation(r12, r2)
            if (r1 != r3) goto L_0x008d
            goto L_0x0143
        L_0x008d:
            r10 = r14
        L_0x008e:
            r12 = r1
            com.blueair.core.model.TrackedLocation r12 = (com.blueair.core.model.TrackedLocation) r12
            if (r12 != 0) goto L_0x0094
            return r5
        L_0x0094:
            boolean r1 = r12.useGCJ()
            r13 = 0
            if (r1 == 0) goto L_0x00d0
            com.blueair.core.util.CoordinateTransformUtils r1 = com.blueair.core.util.CoordinateTransformUtils.INSTANCE
            double r14 = r12.getLon()
            double r16 = r12.getLat()
            java.lang.Boolean r18 = r12.isInMainlandChina()
            r27 = r1
            r28 = r14
            r30 = r16
            r32 = r18
            double[] r1 = r27.gcj02towgs84(r28, r30, r32)
            r14 = r1[r7]
            r16 = r1[r13]
            r24 = 249(0xf9, float:3.49E-43)
            r25 = 0
            r1 = r13
            r13 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            java.lang.String r23 = "WGS"
            com.blueair.core.model.TrackedLocation r7 = com.blueair.core.model.TrackedLocation.copy$default(r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x00f2
        L_0x00d0:
            r1 = r13
            boolean r7 = r12.isLocalMapType()
            if (r7 == 0) goto L_0x00f1
            r24 = 255(0xff, float:3.57E-43)
            r25 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            java.lang.String r23 = "WGS"
            com.blueair.core.model.TrackedLocation r7 = com.blueair.core.model.TrackedLocation.copy$default(r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x00f2
        L_0x00f1:
            r7 = r12
        L_0x00f2:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "fetchTrackedLocationWithAqiData("
            r13.<init>(r14)
            r13.append(r10)
            java.lang.String r14 = ", "
            r13.append(r14)
            r13.append(r8)
            r13.append(r14)
            r13.append(r4)
            java.lang.String r14 = "): "
            r13.append(r14)
            r13.append(r7)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r12.d(r13, r1)
            com.blueair.api.client.OutdoorClient r1 = r0.outdoorClient
            double r12 = r7.getLat()
            double r14 = r7.getLon()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r2.L$0 = r4
            r2.L$1 = r7
            r2.D$0 = r10
            r2.D$1 = r8
            r2.label = r6
            r27 = r1
            r32 = r2
            r28 = r12
            r30 = r14
            java.lang.Object r1 = r27.getAqiDataByLatLng(r28, r30, r32)
            if (r1 != r3) goto L_0x0144
        L_0x0143:
            return r3
        L_0x0144:
            r3 = r7
        L_0x0145:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r1.getOrNull()
            com.blueair.core.model.AqiData r1 = (com.blueair.core.model.AqiData) r1
            if (r1 != 0) goto L_0x0150
            return r5
        L_0x0150:
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r3, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.fetchTrackedLocationWithAqiData(double, double, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<TrackedLocation> filterAllowRefreshLocations(List<TrackedLocation> list) {
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("filterAllowRefreshLocations: ");
        Iterable<TrackedLocation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TrackedLocation locationName : iterable) {
            arrayList.add(locationName.getLocationName());
        }
        sb.append((List) arrayList);
        forest.d(sb.toString(), new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        List<AqiData> aqiData = this.trackedLocationRepository.getAqiData();
        if (!aqiData.isEmpty()) {
            Collection arrayList2 = new ArrayList();
            for (Object next : iterable) {
                TrackedLocation trackedLocation = (TrackedLocation) next;
                Iterable iterable2 = aqiData;
                if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                    Iterator it = iterable2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AqiData aqiData2 = (AqiData) it.next();
                        if (Intrinsics.areEqual((Object) aqiData2.getLocationId(), (Object) trackedLocation.getId()) && currentTimeMillis - aqiData2.getDatetime() <= 3600000) {
                            break;
                        }
                    }
                }
                arrayList2.add(next);
            }
            list = (List) arrayList2;
            Timber.Forest forest2 = Timber.Forest;
            StringBuilder sb2 = new StringBuilder("filterAllowRefreshLocations: after filter aqi data time: ");
            Iterable<TrackedLocation> iterable3 = list;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
            for (TrackedLocation locationName2 : iterable3) {
                arrayList3.add(locationName2.getLocationName());
            }
            sb2.append((List) arrayList3);
            forest2.d(sb2.toString(), new Object[0]);
            if (list.isEmpty()) {
                return CollectionsKt.emptyList();
            }
        }
        Collection arrayList4 = new ArrayList();
        for (Object next2 : list) {
            Long l = getAqiDataRefreshTime().get(((TrackedLocation) next2).getId());
            if (currentTimeMillis - (l != null ? l.longValue() : 0) > Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS) {
                arrayList4.add(next2);
            }
        }
        List<TrackedLocation> list2 = (List) arrayList4;
        Timber.Forest forest3 = Timber.Forest;
        StringBuilder sb3 = new StringBuilder("filterAllowRefreshLocations: after filter last refresh time: ");
        Iterable<TrackedLocation> iterable4 = list2;
        Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable4, 10));
        for (TrackedLocation locationName3 : iterable4) {
            arrayList5.add(locationName3.getLocationName());
        }
        sb3.append((List) arrayList5);
        forest3.d(sb3.toString(), new Object[0]);
        if (list2.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        Map<String, Long> aqiDataRefreshTime = getAqiDataRefreshTime();
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable4, 10)), 16));
        for (TrackedLocation id : iterable4) {
            Pair pair = TuplesKt.to(id.getId(), Long.valueOf(currentTimeMillis));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        setAqiDataRefreshTime(MapsKt.plus(aqiDataRefreshTime, (Map<String, Long>) linkedHashMap));
        return list2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (r2 == r1) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        if (r9 != r1) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchAqiData(java.util.List<com.blueair.core.model.TrackedLocation> r8, kotlin.coroutines.Continuation<? super java.util.List<com.blueair.core.model.AqiData>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.blueair.outdoor.service.OutdoorService$fetchAqiData$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.outdoor.service.OutdoorService$fetchAqiData$1 r0 = (com.blueair.outdoor.service.OutdoorService$fetchAqiData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.outdoor.service.OutdoorService$fetchAqiData$1 r0 = new com.blueair.outdoor.service.OutdoorService$fetchAqiData$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = r0.L$0
            java.util.List r8 = (java.util.List) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0099
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003d:
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r9
            r9 = r8
            r8 = r2
            r2 = r6
            goto L_0x007a
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.List r9 = r7.filterAllowRefreshLocations(r8)
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x0061
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            return r8
        L_0x0061:
            java.util.List r9 = (java.util.List) r9
            com.blueair.api.client.OutdoorClient r2 = r7.outdoorClient
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r2 = r2.getAqiDataByLocation(r9, r0)
            if (r2 != r1) goto L_0x007a
            goto L_0x0098
        L_0x007a:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            com.blueair.outdoor.service.OutdoorService$fetchAqiData$result$1 r4 = new com.blueair.outdoor.service.OutdoorService$fetchAqiData$result$1
            r5 = 0
            r4.<init>(r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r2, r4, r0)
            if (r9 != r1) goto L_0x0099
        L_0x0098:
            return r1
        L_0x0099:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            java.lang.Object r8 = r9.getOrNull()
            java.util.List r8 = (java.util.List) r8
            if (r8 != 0) goto L_0x00a7
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00a7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.fetchAqiData(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object fetchAqiData$default(OutdoorService outdoorService, TrackedLocation trackedLocation, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return outdoorService.fetchAqiData(trackedLocation, z, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bb, code lost:
        if (r3 == r4) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0105, code lost:
        if (r3 == r4) goto L_0x0107;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchAqiData(com.blueair.core.model.TrackedLocation r22, boolean r23, kotlin.coroutines.Continuation<? super com.blueair.core.model.AqiData> r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            boolean r4 = r3 instanceof com.blueair.outdoor.service.OutdoorService$fetchAqiData$2
            if (r4 == 0) goto L_0x001c
            r4 = r3
            com.blueair.outdoor.service.OutdoorService$fetchAqiData$2 r4 = (com.blueair.outdoor.service.OutdoorService$fetchAqiData$2) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            com.blueair.outdoor.service.OutdoorService$fetchAqiData$2 r4 = new com.blueair.outdoor.service.OutdoorService$fetchAqiData$2
            r4.<init>(r0, r3)
        L_0x0021:
            r10 = r4
            java.lang.Object r3 = r10.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r10.label
            r11 = 0
            r6 = 3
            r12 = 2
            r7 = 1
            if (r5 == 0) goto L_0x0066
            if (r5 == r7) goto L_0x0057
            if (r5 == r12) goto L_0x0049
            if (r5 != r6) goto L_0x0041
            boolean r1 = r10.Z$0
            java.lang.Object r1 = r10.L$0
            com.blueair.core.model.TrackedLocation r1 = (com.blueair.core.model.TrackedLocation) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0108
        L_0x0041:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0049:
            boolean r1 = r10.Z$0
            java.lang.Object r1 = r10.L$1
            com.blueair.core.model.AqiData r1 = (com.blueair.core.model.AqiData) r1
            java.lang.Object r2 = r10.L$0
            com.blueair.core.model.TrackedLocation r2 = (com.blueair.core.model.TrackedLocation) r2
            kotlin.ResultKt.throwOnFailure(r3)
            return r1
        L_0x0057:
            boolean r1 = r10.Z$0
            java.lang.Object r2 = r10.L$0
            com.blueair.core.model.TrackedLocation r2 = (com.blueair.core.model.TrackedLocation) r2
            kotlin.ResultKt.throwOnFailure(r3)
            r20 = r2
            r2 = r1
            r1 = r20
            goto L_0x00be
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r3)
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "fetchAqiData("
            r5.<init>(r8)
            r5.append(r1)
            java.lang.String r8 = ", "
            r5.append(r8)
            r5.append(r2)
            r8 = 41
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            r8 = 0
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r3.d(r5, r8)
            boolean r3 = r1.isCurrentLocation()
            if (r3 == 0) goto L_0x00f3
            if (r2 != 0) goto L_0x00a5
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r1)
            java.util.List r3 = r0.filterAllowRefreshLocations(r3)
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00a5
            return r11
        L_0x00a5:
            com.blueair.api.client.OutdoorClient r5 = r0.outdoorClient
            double r8 = r1.getLat()
            r13 = r8
            double r8 = r1.getLon()
            r10.L$0 = r1
            r10.Z$0 = r2
            r10.label = r7
            r6 = r13
            java.lang.Object r3 = r5.getAqiDataByLatLng(r6, r8, r10)
            if (r3 != r4) goto L_0x00be
            goto L_0x0107
        L_0x00be:
            io.flatcircle.coroutinehelper.ApiResult r3 = (io.flatcircle.coroutinehelper.ApiResult) r3
            java.lang.Object r3 = r3.getOrNull()
            r13 = r3
            com.blueair.core.model.AqiData r13 = (com.blueair.core.model.AqiData) r13
            if (r13 == 0) goto L_0x00f2
            java.lang.String r14 = r1.getId()
            r18 = 6
            r19 = 0
            r15 = 0
            r17 = 0
            com.blueair.core.model.AqiData r3 = com.blueair.core.model.AqiData.copy$default(r13, r14, r15, r17, r18, r19)
            if (r3 != 0) goto L_0x00dc
            goto L_0x00f2
        L_0x00dc:
            com.blueair.database.repository.TrackedLocationRepository r5 = r0.trackedLocationRepository
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r1
            r10.L$1 = r3
            r10.Z$0 = r2
            r10.label = r12
            java.lang.Object r1 = r5.insertAqiData((com.blueair.core.model.AqiData) r3, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r10)
            if (r1 != r4) goto L_0x00f1
            goto L_0x0107
        L_0x00f1:
            return r3
        L_0x00f2:
            return r11
        L_0x00f3:
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r1)
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r1
            r10.Z$0 = r2
            r10.label = r6
            java.lang.Object r3 = r0.fetchAqiData(r3, r10)
            if (r3 != r4) goto L_0x0108
        L_0x0107:
            return r4
        L_0x0108:
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.blueair.core.model.AqiData r1 = (com.blueair.core.model.AqiData) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService.fetchAqiData(com.blueair.core.model.TrackedLocation, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getAqiData(TrackedLocation trackedLocation, Continuation<? super AqiData> continuation) {
        return this.trackedLocationRepository.getAqiData(trackedLocation.getId(), continuation);
    }

    private final void deleteAllOutdoorDataInBackground() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorService$deleteAllOutdoorDataInBackground$1(this, (Continuation<? super OutdoorService$deleteAllOutdoorDataInBackground$1>) null), 2, (Object) null);
    }

    public void logOut() {
        deleteAllOutdoorDataInBackground();
    }
}
