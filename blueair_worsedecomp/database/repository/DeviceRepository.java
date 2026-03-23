package com.blueair.database.repository;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.blueair.auth.LocationService;
import com.blueair.core.model.DataTrend;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceOnBlueServer;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.database.entity.DeviceEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00142\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H@¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H@¢\u0006\u0002\u0010.J.\u00100\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u000205J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u00104\u001a\u000205J\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002080\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0018\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002080:0\u001aJ\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u00142\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0010J\u000e\u0010=\u001a\u00020)2\u0006\u0010?\u001a\u00020@J\u000e\u0010=\u001a\u00020)2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020EH\u0002J2\u0010F\u001a\u00020)\"\u0004\b\u0000\u0010G2\u0006\u0010\u001f\u001a\u00020 2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030I2\b\u0010J\u001a\u0004\u0018\u0001HGH@¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0010H\u0007J\u001e\u0010M\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010N\u001a\u000202H@¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u000205J\b\u0010R\u001a\u00020)H\u0007J\u0010\u0010S\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c¨\u0006T"}, d2 = {"Lcom/blueair/database/repository/DeviceRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "locationRepository", "Lcom/blueair/database/repository/TrackedLocationRepository;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "locationService", "Lcom/blueair/auth/LocationService;", "<init>", "(Lcom/blueair/database/BlueairDatabase;Lcom/blueair/database/repository/TrackedLocationRepository;Lcom/blueair/core/service/UnsecurePrefs;Lcom/blueair/core/service/AnalyticsService;Lcom/blueair/auth/LocationService;)V", "devices", "", "Lcom/blueair/core/model/Device;", "getDevices", "()Ljava/util/List;", "liveDevices", "Landroidx/lifecycle/LiveData;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "liveDevices$delegate", "Lkotlin/Lazy;", "flowDevices", "Lkotlinx/coroutines/flow/Flow;", "getFlowDevices", "()Lkotlinx/coroutines/flow/Flow;", "flowDevices$delegate", "liveDevice", "deviceId", "", "getDevice", "getFlowHasSensorDevice", "Lcom/blueair/core/model/HasSensorData;", "getFlowHasWelcomeHomeDevice", "Lcom/blueair/core/model/HasWelcomeHome;", "getAllDevices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDeviceData", "", "deviceData", "Lcom/blueair/core/model/DeviceData;", "dataTrend", "Lcom/blueair/core/model/DataTrend;", "(Lcom/blueair/core/model/DeviceData;Lcom/blueair/core/model/DataTrend;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAndReplaceDeviceData", "getFlowDeviceDataBetween", "startInclusive", "", "endInclusive", "allowRealTime", "", "getFlowLatestDatapointAsDeviceData", "getFlowLatestDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getFlowLatestDatapointForAllDevices", "", "getFlowRealTimeDeviceData", "getLiveLatestDeviceData", "updateDevice", "device", "deviceAbl", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "deviceBlue", "Lcom/blueair/core/model/DeviceOnBlueServer;", "updateDeviceEntity", "deviceEntity", "Lcom/blueair/database/entity/DeviceEntity;", "updateDeviceField", "T", "field", "Lcom/blueair/database/DeviceField;", "newValue", "(Ljava/lang/String;Lcom/blueair/database/DeviceField;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "deleteOldDeviceData", "monthAgoSeconds", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllDevicesBackground", "isAblDevice", "deleteAllDevices", "getLatestHistoricalDataTime", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceRepository.kt */
public final class DeviceRepository {
    private final AnalyticsService analyticsService;
    /* access modifiers changed from: private */
    public final BlueairDatabase blueairDb;
    private final Lazy flowDevices$delegate = LazyKt.lazy(new DeviceRepository$$ExternalSyntheticLambda1(this));
    private final Lazy liveDevices$delegate = LazyKt.lazy(new DeviceRepository$$ExternalSyntheticLambda0(this));
    private final TrackedLocationRepository locationRepository;
    private final LocationService locationService;
    /* access modifiers changed from: private */
    public final UnsecurePrefs prefs;

    public DeviceRepository(BlueairDatabase blueairDatabase, TrackedLocationRepository trackedLocationRepository, UnsecurePrefs unsecurePrefs, AnalyticsService analyticsService2, LocationService locationService2) {
        Intrinsics.checkNotNullParameter(blueairDatabase, "blueairDb");
        Intrinsics.checkNotNullParameter(trackedLocationRepository, "locationRepository");
        Intrinsics.checkNotNullParameter(unsecurePrefs, "prefs");
        Intrinsics.checkNotNullParameter(analyticsService2, "analyticsService");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        this.blueairDb = blueairDatabase;
        this.locationRepository = trackedLocationRepository;
        this.prefs = unsecurePrefs;
        this.analyticsService = analyticsService2;
        this.locationService = locationService2;
    }

    public final List<Device> getDevices() {
        Iterable<DeviceEntity> devices = this.blueairDb.deviceDao().getDevices();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(devices, 10));
        for (DeviceEntity device : devices) {
            arrayList.add(device.toDevice());
        }
        return (List) arrayList;
    }

    public final LiveData<List<Device>> getLiveDevices() {
        return (LiveData) this.liveDevices$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final LiveData liveDevices_delegate$lambda$1(DeviceRepository deviceRepository) {
        return FlowLiveDataConversions.asLiveData$default((Flow) deviceRepository.getFlowDevices(), GlobalScope.INSTANCE.getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    public final Flow<List<Device>> getFlowDevices() {
        return (Flow) this.flowDevices$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Flow flowDevices_delegate$lambda$4(DeviceRepository deviceRepository) {
        return new DeviceRepository$flowDevices_delegate$lambda$4$$inlined$map$1(FlowKt.distinctUntilChanged(deviceRepository.blueairDb.deviceDao().getFlowDevices()));
    }

    /* access modifiers changed from: private */
    public static final Device liveDevice$lambda$5(DeviceEntity deviceEntity) {
        if (deviceEntity != null) {
            return deviceEntity.toDevice();
        }
        return null;
    }

    public final LiveData<Device> liveDevice(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return Transformations.map(this.blueairDb.deviceDao().liveDevice(str), new DeviceRepository$$ExternalSyntheticLambda3());
    }

    public final Device getDevice(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        DeviceEntity device = this.blueairDb.deviceDao().device(str);
        if (device != null) {
            return device.toDevice();
        }
        return null;
    }

    public final Flow<HasSensorData> getFlowHasSensorDevice(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return new DeviceRepository$getFlowHasSensorDevice$$inlined$mapNotNull$1(this.blueairDb.deviceDao().getFlowDevice(str));
    }

    public final Flow<HasWelcomeHome> getFlowHasWelcomeHomeDevice(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return new DeviceRepository$getFlowHasWelcomeHomeDevice$$inlined$mapNotNull$1(this.blueairDb.deviceDao().getFlowDevice(str));
    }

    public final Object getAllDevices(Continuation<? super List<? extends Device>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DeviceRepository$getAllDevices$2(this, (Continuation<? super DeviceRepository$getAllDevices$2>) null), continuation);
    }

    public final Object insertDeviceData(DeviceData deviceData, DataTrend dataTrend, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DeviceRepository$insertDeviceData$2(this, deviceData, dataTrend, (Continuation<? super DeviceRepository$insertDeviceData$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object insertAndReplaceDeviceData(DeviceData deviceData, DataTrend dataTrend, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DeviceRepository$insertAndReplaceDeviceData$2(this, deviceData, dataTrend, (Continuation<? super DeviceRepository$insertAndReplaceDeviceData$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public static /* synthetic */ Flow getFlowDeviceDataBetween$default(DeviceRepository deviceRepository, String str, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return deviceRepository.getFlowDeviceDataBetween(str, j, j2, z);
    }

    public final Flow<DeviceData> getFlowDeviceDataBetween(String str, long j, long j2, boolean z) {
        Flow<List<DeviceDataEntity>> flow;
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        if (z) {
            flow = this.blueairDb.deviceDataDao().getFlowDeviceDataBetween(str, j, j2);
        } else {
            flow = this.blueairDb.deviceDataDao().getFlowDeviceNonRealTimeDataBetween(str, j, j2);
        }
        return new DeviceRepository$getFlowDeviceDataBetween$$inlined$map$1(flow, this);
    }

    public static /* synthetic */ Flow getFlowLatestDatapointAsDeviceData$default(DeviceRepository deviceRepository, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return deviceRepository.getFlowLatestDatapointAsDeviceData(str, z);
    }

    public final Flow<DeviceData> getFlowLatestDatapointAsDeviceData(String str, boolean z) {
        Flow<DeviceDataEntity> flow;
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        if (z) {
            flow = this.blueairDb.deviceDataDao().latestFlowDeviceData(str);
        } else {
            flow = this.blueairDb.deviceDataDao().latestFlowNonRealTimeDeviceData(str);
        }
        return new DeviceRepository$getFlowLatestDatapointAsDeviceData$$inlined$mapNotNull$1(flow, this);
    }

    public final Flow<IndoorDatapoint> getFlowLatestDatapoint(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return FlowKt.distinctUntilChanged(new DeviceRepository$getFlowLatestDatapoint$$inlined$mapNotNull$1(this.blueairDb.deviceDataDao().latestFlowDeviceData(str)));
    }

    public final Flow<Map<String, IndoorDatapoint>> getFlowLatestDatapointForAllDevices() {
        return FlowKt.distinctUntilChanged(new DeviceRepository$getFlowLatestDatapointForAllDevices$$inlined$mapNotNull$1(this.blueairDb.deviceDataDao().latestFlowDeviceDataForAllDevices()));
    }

    public final Flow<DeviceData> getFlowRealTimeDeviceData(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return new DeviceRepository$getFlowRealTimeDeviceData$$inlined$map$1(this.blueairDb.deviceDataDao().getFlowRealTimeDeviceData(str), this);
    }

    /* access modifiers changed from: private */
    public static final DeviceData getLiveLatestDeviceData$lambda$14(DeviceRepository deviceRepository, DeviceDataEntity deviceDataEntity) {
        if (deviceDataEntity != null) {
            return deviceDataEntity.toDeviceData(deviceRepository.prefs.isTempCelsius());
        }
        return null;
    }

    public final LiveData<DeviceData> getLiveLatestDeviceData(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return Transformations.map(this.blueairDb.deviceDataDao().latestLiveDeviceData(str), new DeviceRepository$$ExternalSyntheticLambda2(this));
    }

    public final void updateDevice(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Timber.Forest forest = Timber.Forest;
        forest.v("updateDevice: uid = " + device.getUid(), new Object[0]);
        if (device.getUid().length() != 0) {
            updateDeviceEntity(DeviceEntity.Companion.fromDevice(device, this.blueairDb.deviceDao().device(device.getUid())));
        }
    }

    public final void updateDevice(DeviceDetailsOnAblServer deviceDetailsOnAblServer) {
        Intrinsics.checkNotNullParameter(deviceDetailsOnAblServer, "deviceAbl");
        Timber.Forest.v("updateDevice: deviceAbl", new Object[0]);
        if (deviceDetailsOnAblServer.getUuid().length() > 0) {
            updateDeviceEntity(DeviceEntity.Companion.fromDeviceOnAblServer(deviceDetailsOnAblServer, this.blueairDb.deviceDao().device(deviceDetailsOnAblServer.getUuid())));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void updateDevice(DeviceOnBlueServer deviceOnBlueServer) {
        Intrinsics.checkNotNullParameter(deviceOnBlueServer, "deviceBlue");
        Timber.Forest.v("updateDevice: deviceBlue", new Object[0]);
        if (deviceOnBlueServer.getUuid().length() > 0) {
            DeviceEntity device = this.blueairDb.deviceDao().device(deviceOnBlueServer.getUuid());
            try {
                Result.Companion companion = Result.Companion;
                updateDeviceEntity(DeviceEntity.Companion.fromDeviceOnBlueServer(deviceOnBlueServer, device, this.locationService.isInG4ProtectRegion()));
                Result.m9366constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m9366constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final void updateDeviceEntity(DeviceEntity deviceEntity) {
        Timber.Forest forest = Timber.Forest;
        forest.v("updateDeviceEntity " + deviceEntity.getUid(), new Object[0]);
        if (deviceEntity.getUid().length() != 0) {
            if (this.blueairDb.deviceDao().device(deviceEntity.getUid()) != null) {
                int update = this.blueairDb.deviceDao().update(deviceEntity);
                Timber.Forest forest2 = Timber.Forest;
                forest2.d("updateDeviceEntity: update " + deviceEntity.getUid() + ", response = " + update, new Object[0]);
                return;
            }
            Timber.Forest forest3 = Timber.Forest;
            forest3.d("updateDeviceEntity: insert " + deviceEntity.getUid(), new Object[0]);
            this.blueairDb.deviceDao().insert(deviceEntity);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v48, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v51, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v60, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v63, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v69, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v78, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v84, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v87, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v93, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v141, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v153, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v159, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v165, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v168, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v171, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v174, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: com.blueair.database.repository.DeviceRepository$updateDeviceField$1} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v12, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v15, types: [java.util.List, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v18, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v24, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v27, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v30, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v33, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v36, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v39, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v42, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v45, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v54, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v57, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v66, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v72, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v75, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v81, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v90, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v96, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v99, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v102, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v105, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v108, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v111, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v114, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v117, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v120, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v123, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v126, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v129, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v132, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v135, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v138, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v144, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v147, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v150, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v156, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v162, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v185 */
    /* JADX WARNING: type inference failed for: r9v186 */
    /* JADX WARNING: type inference failed for: r9v187 */
    /* JADX WARNING: type inference failed for: r9v188 */
    /* JADX WARNING: type inference failed for: r9v189 */
    /* JADX WARNING: type inference failed for: r9v190 */
    /* JADX WARNING: type inference failed for: r9v191 */
    /* JADX WARNING: type inference failed for: r9v192 */
    /* JADX WARNING: type inference failed for: r9v193 */
    /* JADX WARNING: type inference failed for: r9v194 */
    /* JADX WARNING: type inference failed for: r9v195 */
    /* JADX WARNING: type inference failed for: r9v196 */
    /* JADX WARNING: type inference failed for: r9v197 */
    /* JADX WARNING: type inference failed for: r9v198 */
    /* JADX WARNING: type inference failed for: r9v199 */
    /* JADX WARNING: type inference failed for: r9v200 */
    /* JADX WARNING: type inference failed for: r9v201 */
    /* JADX WARNING: type inference failed for: r9v202 */
    /* JADX WARNING: type inference failed for: r9v203 */
    /* JADX WARNING: type inference failed for: r9v204 */
    /* JADX WARNING: type inference failed for: r9v205 */
    /* JADX WARNING: type inference failed for: r9v206 */
    /* JADX WARNING: type inference failed for: r9v207 */
    /* JADX WARNING: type inference failed for: r9v208 */
    /* JADX WARNING: type inference failed for: r9v209 */
    /* JADX WARNING: type inference failed for: r9v210 */
    /* JADX WARNING: type inference failed for: r9v211 */
    /* JADX WARNING: type inference failed for: r9v212 */
    /* JADX WARNING: type inference failed for: r9v213 */
    /* JADX WARNING: type inference failed for: r9v214 */
    /* JADX WARNING: type inference failed for: r9v215 */
    /* JADX WARNING: type inference failed for: r9v216 */
    /* JADX WARNING: type inference failed for: r9v217 */
    /* JADX WARNING: type inference failed for: r9v218 */
    /* JADX WARNING: type inference failed for: r9v219 */
    /* JADX WARNING: type inference failed for: r9v220 */
    /* JADX WARNING: type inference failed for: r9v221 */
    /* JADX WARNING: type inference failed for: r9v222 */
    /* JADX WARNING: type inference failed for: r9v223 */
    /* JADX WARNING: type inference failed for: r9v224 */
    /* JADX WARNING: type inference failed for: r9v225 */
    /* JADX WARNING: type inference failed for: r9v226 */
    /* JADX WARNING: type inference failed for: r9v227 */
    /* JADX WARNING: type inference failed for: r9v228 */
    /* JADX WARNING: type inference failed for: r9v229 */
    /* JADX WARNING: type inference failed for: r9v230 */
    /* JADX WARNING: type inference failed for: r9v231 */
    /* JADX WARNING: type inference failed for: r9v232 */
    /* JADX WARNING: type inference failed for: r9v233 */
    /* JADX WARNING: type inference failed for: r9v234 */
    /* JADX WARNING: type inference failed for: r9v235 */
    /* JADX WARNING: type inference failed for: r9v236 */
    /* JADX WARNING: type inference failed for: r9v237 */
    /* JADX WARNING: type inference failed for: r9v238 */
    /* JADX WARNING: type inference failed for: r9v239 */
    /* JADX WARNING: type inference failed for: r9v240 */
    /* JADX WARNING: type inference failed for: r9v241 */
    /* JADX WARNING: type inference failed for: r9v242 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c9, code lost:
        r2 = (java.lang.Boolean) r6.L$4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0a90, code lost:
        if (r4 != null) goto L_0x1b27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0a92, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0a93, code lost:
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0a98, code lost:
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
        r6.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r6.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4);
        r6.L$4 = null;
        r6.L$5 = null;
        r6.I$0 = r1;
        r6.label = 36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0ac5, code lost:
        if (r4.updateWelcomeHome(r5, (java.lang.Double) null, (java.lang.Double) null, (java.lang.Integer) null, (java.lang.String) null, (java.lang.Boolean) null, r6) != r0) goto L_0x0ac9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0ac9, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x012a, code lost:
        r2 = (com.blueair.database.dao.DeviceDao) r6.L$3;
        r2 = r6.L$2;
        r2 = (com.blueair.database.DeviceField) r6.L$1;
        r2 = (java.lang.String) r6.L$0;
        kotlin.ResultKt.throwOnFailure(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01f0, code lost:
        r1 = r7.getDisinftime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01f4, code lost:
        if (r1 == null) goto L_0x1b27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01f6, code lost:
        r1 = r1.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01fc, code lost:
        if (r1 <= 0) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01fe, code lost:
        r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1);
        r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7.getTimeInSeconds());
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r6.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r6.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9);
        r6.L$4 = r8;
        r6.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r6.I$0 = r5;
        r6.I$1 = r2;
        r6.I$2 = r1;
        r6.I$3 = 0;
        r6.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x023a, code lost:
        if (r9.updateDisinfectLeftTime(r12, r3, r4, r6) != r0) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x023e, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:739:0x1b29, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:745:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:778:?, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object updateDeviceField(java.lang.String r21, com.blueair.database.DeviceField<?> r22, T r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r20 = this;
            r0 = r20
            r2 = r21
            r14 = r22
            r15 = r23
            r1 = r24
            boolean r3 = r1 instanceof com.blueair.database.repository.DeviceRepository$updateDeviceField$1
            if (r3 == 0) goto L_0x001e
            r3 = r1
            com.blueair.database.repository.DeviceRepository$updateDeviceField$1 r3 = (com.blueair.database.repository.DeviceRepository$updateDeviceField$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001e
            int r1 = r3.label
            int r1 = r1 - r5
            r3.label = r1
            goto L_0x0023
        L_0x001e:
            com.blueair.database.repository.DeviceRepository$updateDeviceField$1 r3 = new com.blueair.database.repository.DeviceRepository$updateDeviceField$1
            r3.<init>(r0, r1)
        L_0x0023:
            r6 = r3
            java.lang.Object r1 = r6.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r6.label
            r9 = 0
            r5 = 0
            switch(r4) {
                case 0: goto L_0x013d;
                case 1: goto L_0x011e;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00d9;
                case 4: goto L_0x00ce;
                case 5: goto L_0x00ce;
                case 6: goto L_0x00ce;
                case 7: goto L_0x011e;
                case 8: goto L_0x00ce;
                case 9: goto L_0x00c3;
                case 10: goto L_0x011e;
                case 11: goto L_0x00ce;
                case 12: goto L_0x00ce;
                case 13: goto L_0x00ce;
                case 14: goto L_0x00b6;
                case 15: goto L_0x011e;
                case 16: goto L_0x011e;
                case 17: goto L_0x011e;
                case 18: goto L_0x00c3;
                case 19: goto L_0x00c3;
                case 20: goto L_0x00c3;
                case 21: goto L_0x00c3;
                case 22: goto L_0x00c3;
                case 23: goto L_0x00c3;
                case 24: goto L_0x00c3;
                case 25: goto L_0x011e;
                case 26: goto L_0x011e;
                case 27: goto L_0x011e;
                case 28: goto L_0x00c3;
                case 29: goto L_0x011e;
                case 30: goto L_0x011e;
                case 31: goto L_0x011e;
                case 32: goto L_0x00ce;
                case 33: goto L_0x011e;
                case 34: goto L_0x011e;
                case 35: goto L_0x0092;
                case 36: goto L_0x007d;
                case 37: goto L_0x00c3;
                case 38: goto L_0x006f;
                case 39: goto L_0x006b;
                case 40: goto L_0x00c3;
                case 41: goto L_0x00c3;
                case 42: goto L_0x006f;
                case 43: goto L_0x00ce;
                case 44: goto L_0x00c3;
                case 45: goto L_0x00ce;
                case 46: goto L_0x00c3;
                case 47: goto L_0x00ce;
                case 48: goto L_0x00ce;
                case 49: goto L_0x00ce;
                case 50: goto L_0x006f;
                case 51: goto L_0x00ce;
                case 52: goto L_0x00ce;
                case 53: goto L_0x00ce;
                case 54: goto L_0x00ce;
                case 55: goto L_0x00ce;
                case 56: goto L_0x00ce;
                case 57: goto L_0x00ce;
                case 58: goto L_0x00ce;
                case 59: goto L_0x00ce;
                case 60: goto L_0x00ce;
                case 61: goto L_0x005f;
                case 62: goto L_0x005f;
                case 63: goto L_0x00ce;
                case 64: goto L_0x00ce;
                case 65: goto L_0x00ce;
                case 66: goto L_0x0051;
                case 67: goto L_0x00ce;
                case 68: goto L_0x0051;
                case 69: goto L_0x011e;
                case 70: goto L_0x00ce;
                case 71: goto L_0x00c3;
                case 72: goto L_0x00ce;
                case 73: goto L_0x00ce;
                case 74: goto L_0x00c3;
                case 75: goto L_0x00ce;
                case 76: goto L_0x00c3;
                case 77: goto L_0x00c3;
                case 78: goto L_0x00ce;
                case 79: goto L_0x00ce;
                case 80: goto L_0x00c3;
                case 81: goto L_0x00c3;
                case 82: goto L_0x00ce;
                case 83: goto L_0x00ce;
                case 84: goto L_0x00ce;
                case 85: goto L_0x00ce;
                case 86: goto L_0x00ce;
                case 87: goto L_0x00ce;
                case 88: goto L_0x00ce;
                case 89: goto L_0x00ce;
                case 90: goto L_0x0047;
                case 91: goto L_0x00ce;
                case 92: goto L_0x0039;
                case 93: goto L_0x00ce;
                case 94: goto L_0x00c3;
                case 95: goto L_0x00c3;
                case 96: goto L_0x00ce;
                default: goto L_0x0031;
            }
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = r6.L$4
            java.util.List r2 = (java.util.List) r2
            goto L_0x012a
        L_0x0047:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            goto L_0x00c9
        L_0x0051:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            double[] r2 = (double[]) r2
            java.lang.Object r2 = r6.L$4
            double[] r2 = (double[]) r2
            goto L_0x012a
        L_0x005f:
            double r2 = r6.D$0
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$4
            java.lang.Double r2 = (java.lang.Double) r2
            goto L_0x012a
        L_0x006b:
            int r2 = r6.I$0
            goto L_0x012a
        L_0x006f:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r2 = r6.L$4
            kotlin.Pair r2 = (kotlin.Pair) r2
            goto L_0x012a
        L_0x007d:
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$3
            com.blueair.database.dao.DeviceDao r2 = (com.blueair.database.dao.DeviceDao) r2
            java.lang.Object r2 = r6.L$2
            java.lang.Object r2 = r6.L$1
            com.blueair.database.DeviceField r2 = (com.blueair.database.DeviceField) r2
            java.lang.Object r2 = r6.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0ac9
        L_0x0092:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r4 = r6.L$5
            com.blueair.core.model.WelcomeHomeLocation r4 = (com.blueair.core.model.WelcomeHomeLocation) r4
            java.lang.Object r4 = r6.L$4
            com.blueair.core.model.WelcomeHomeLocation r4 = (com.blueair.core.model.WelcomeHomeLocation) r4
            java.lang.Object r5 = r6.L$3
            com.blueair.database.dao.DeviceDao r5 = (com.blueair.database.dao.DeviceDao) r5
            java.lang.Object r7 = r6.L$2
            java.lang.Object r8 = r6.L$1
            com.blueair.database.DeviceField r8 = (com.blueair.database.DeviceField) r8
            java.lang.Object r10 = r6.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r2
            r0 = r3
            r15 = r7
            r14 = r8
            r2 = r10
            goto L_0x0a90
        L_0x00b6:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            com.blueair.database.DeviceField$SensorRanges r2 = (com.blueair.database.DeviceField.SensorRanges) r2
            java.lang.Object r2 = r6.L$4
            com.blueair.database.DeviceField$SensorRanges r2 = (com.blueair.database.DeviceField.SensorRanges) r2
            goto L_0x012a
        L_0x00c3:
            int r2 = r6.I$1
            boolean r2 = r6.Z$0
            int r2 = r6.I$0
        L_0x00c9:
            java.lang.Object r2 = r6.L$4
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            goto L_0x012a
        L_0x00ce:
            int r2 = r6.I$2
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$4
            java.lang.Integer r2 = (java.lang.Integer) r2
            goto L_0x012a
        L_0x00d9:
            int r2 = r6.I$3
            int r2 = r6.I$2
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            com.blueair.core.model.IndoorDatapoint r2 = (com.blueair.core.model.IndoorDatapoint) r2
            java.lang.Object r2 = r6.L$4
            com.blueair.core.model.IndoorDatapoint r2 = (com.blueair.core.model.IndoorDatapoint) r2
            java.lang.Object r2 = r6.L$3
            com.blueair.database.dao.DeviceDao r2 = (com.blueair.database.dao.DeviceDao) r2
            java.lang.Object r2 = r6.L$2
            java.lang.Object r2 = r6.L$1
            com.blueair.database.DeviceField r2 = (com.blueair.database.DeviceField) r2
            java.lang.Object r2 = r6.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x023e
        L_0x00fc:
            int r2 = r6.I$1
            int r4 = r6.I$0
            java.lang.Object r7 = r6.L$5
            com.blueair.core.model.IndoorDatapoint r7 = (com.blueair.core.model.IndoorDatapoint) r7
            java.lang.Object r8 = r6.L$4
            com.blueair.core.model.IndoorDatapoint r8 = (com.blueair.core.model.IndoorDatapoint) r8
            java.lang.Object r9 = r6.L$3
            com.blueair.database.dao.DeviceDao r9 = (com.blueair.database.dao.DeviceDao) r9
            java.lang.Object r10 = r6.L$2
            java.lang.Object r11 = r6.L$1
            com.blueair.database.DeviceField r11 = (com.blueair.database.DeviceField) r11
            java.lang.Object r12 = r6.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r0 = r3
            r5 = r4
            r15 = r10
            goto L_0x01f0
        L_0x011e:
            int r2 = r6.I$1
            int r2 = r6.I$0
            java.lang.Object r2 = r6.L$5
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r6.L$4
            java.lang.String r2 = (java.lang.String) r2
        L_0x012a:
            java.lang.Object r2 = r6.L$3
            com.blueair.database.dao.DeviceDao r2 = (com.blueair.database.dao.DeviceDao) r2
            java.lang.Object r2 = r6.L$2
            java.lang.Object r2 = r6.L$1
            com.blueair.database.DeviceField r2 = (com.blueair.database.DeviceField) r2
            java.lang.Object r2 = r6.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x1b27
        L_0x013d:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.database.BlueairDatabase r1 = r0.blueairDb
            com.blueair.database.dao.DeviceDao r1 = r1.deviceDao()
            com.blueair.database.DeviceField$Name r4 = com.blueair.database.DeviceField.Name.INSTANCE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0183
            r4 = r15
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x1b27
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r6.L$5 = r7
            r6.I$0 = r5
            r6.I$1 = r5
            r5 = 1
            r6.label = r5
            java.lang.Object r1 = r1.updateName(r2, r4, r6)
            if (r1 != r3) goto L_0x1b27
            r0 = r3
            goto L_0x1b1c
        L_0x0183:
            com.blueair.database.DeviceField$LatestSensorDataPoint r4 = com.blueair.database.DeviceField.LatestSensorDataPoint.INSTANCE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0242
            r4 = r15
            com.blueair.core.model.IndoorDatapoint r4 = (com.blueair.core.model.IndoorDatapoint) r4
            if (r4 == 0) goto L_0x1b27
            long r7 = r4.getTimeInSeconds()
            java.lang.Float r9 = r4.getPm1()
            java.lang.Float r10 = r4.getPm10()
            r11 = r7
            java.lang.Float r7 = r4.getPm25()
            java.lang.Float r8 = r4.getVoc()
            r13 = r9
            java.lang.Float r9 = r4.getHcho()
            r16 = r10
            java.lang.Float r10 = r4.getTmp()
            r17 = r11
            java.lang.Float r11 = r4.getHum()
            java.lang.Float r12 = r4.getFan()
            r6.L$0 = r2
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            r6.L$3 = r1
            r6.L$4 = r4
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r5 = 2
            r6.label = r5
            r0 = r3
            r5 = r13
            r13 = r6
            r6 = r16
            r16 = r4
            r3 = r17
            java.lang.Object r3 = r1.updateLatestSensorDataPoint(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r6 = r13
            if (r3 != r0) goto L_0x01e8
            goto L_0x1b1c
        L_0x01e8:
            r9 = r1
            r12 = r2
            r11 = r14
            r7 = r16
            r8 = r7
            r2 = 0
            r5 = 0
        L_0x01f0:
            java.lang.Integer r1 = r7.getDisinftime()
            if (r1 == 0) goto L_0x1b27
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            if (r1 <= 0) goto L_0x023e
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            long r13 = r7.getTimeInSeconds()
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r13)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r6.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r6.L$1 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$3 = r10
            r6.L$4 = r8
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$5 = r7
            r6.I$0 = r5
            r6.I$1 = r2
            r6.I$2 = r1
            r5 = 0
            r6.I$3 = r5
            r1 = 3
            r6.label = r1
            java.lang.Object r1 = r9.updateDisinfectLeftTime(r12, r3, r4, r6)
            if (r1 != r0) goto L_0x023e
            goto L_0x1b1c
        L_0x023e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x1b27
        L_0x0242:
            r0 = r3
            com.blueair.database.DeviceField$SelectedSensor r3 = com.blueair.database.DeviceField.SelectedSensor.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0287
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 4
            r6.label = r3
            java.lang.Object r1 = r1.updateLastSelectedSensorType(r2, r5, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0287:
            com.blueair.database.DeviceField$FanSpeed r3 = com.blueair.database.DeviceField.FanSpeed.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x02cb
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 5
            r6.label = r3
            java.lang.Object r1 = r1.updateFanSpeed(r2, r5, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x02cb:
            com.blueair.database.DeviceField$FanSpeedAndAutoMode r3 = com.blueair.database.DeviceField.FanSpeedAndAutoMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0311
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 6
            r6.label = r3
            java.lang.String r3 = "manual"
            java.lang.Object r1 = r1.updateFanSpeedAndAutoMode(r2, r5, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0311:
            com.blueair.database.DeviceField$AutoMode r3 = com.blueair.database.DeviceField.AutoMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x034e
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 7
            r6.label = r4
            java.lang.Object r1 = r1.updateAutoMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x034e:
            com.blueair.database.DeviceField$Brightness r3 = com.blueair.database.DeviceField.Brightness.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0393
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 8
            r6.label = r3
            java.lang.Object r1 = r1.updateBrightness(r2, r5, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0393:
            com.blueair.database.DeviceField$ChildLock r3 = com.blueair.database.DeviceField.ChildLock.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x03d1
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 9
            r6.label = r3
            java.lang.Object r1 = r1.updateChildLock(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x03d1:
            com.blueair.database.DeviceField$LinkedDeviceUid r3 = com.blueair.database.DeviceField.LinkedDeviceUid.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x040f
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 10
            r6.label = r4
            java.lang.Object r1 = r1.updateLinkedDeviceUid(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x040f:
            com.blueair.database.DeviceField$ConnectivityStatus r3 = com.blueair.database.DeviceField.ConnectivityStatus.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0450
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 11
            r6.label = r3
            java.lang.Object r1 = r1.updateConnectivityStatus(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0450:
            com.blueair.database.DeviceField$UpdateProgress r3 = com.blueair.database.DeviceField.UpdateProgress.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0491
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 12
            r6.label = r3
            java.lang.Object r1 = r1.updateProgress(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0491:
            com.blueair.database.DeviceField$FilterLife r3 = com.blueair.database.DeviceField.FilterLife.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x04d6
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 13
            r6.label = r3
            java.lang.Object r1 = r1.updateFilterLife(r2, r5, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x04d6:
            com.blueair.database.DeviceField$SensorRange r3 = com.blueair.database.DeviceField.SensorRange.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x054d
            r3 = r15
            com.blueair.database.DeviceField$SensorRanges r3 = (com.blueair.database.DeviceField.SensorRanges) r3
            if (r3 == 0) goto L_0x1b27
            com.blueair.database.DoubleArrayConverter$Companion r4 = com.blueair.database.DoubleArrayConverter.Companion
            double[] r5 = r3.getPm1Ranges()
            java.lang.String r4 = r4.fromDoubleArray(r5)
            com.blueair.database.DoubleArrayConverter$Companion r5 = com.blueair.database.DoubleArrayConverter.Companion
            double[] r7 = r3.getPm10Ranges()
            java.lang.String r5 = r5.fromDoubleArray(r7)
            com.blueair.database.DoubleArrayConverter$Companion r7 = com.blueair.database.DoubleArrayConverter.Companion
            double[] r8 = r3.getPm25Ranges()
            java.lang.String r7 = r7.fromDoubleArray(r8)
            com.blueair.database.DoubleArrayConverter$Companion r8 = com.blueair.database.DoubleArrayConverter.Companion
            double[] r9 = r3.getVocRanges()
            java.lang.String r8 = r8.fromDoubleArray(r9)
            com.blueair.database.DoubleArrayConverter$Companion r9 = com.blueair.database.DoubleArrayConverter.Companion
            double[] r10 = r3.getHchoRanges()
            java.lang.String r9 = r9.fromDoubleArray(r10)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r10
            r6.L$4 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r3
            r3 = 14
            r6.label = r3
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r9
            java.lang.Object r1 = r1.updateSensorRange(r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x054d:
            com.blueair.database.DeviceField$WifiFirmware r3 = com.blueair.database.DeviceField.WifiFirmware.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x058b
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 15
            r6.label = r4
            java.lang.Object r1 = r1.updateWifiFirmware(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x058b:
            com.blueair.database.DeviceField$McuFirmware r3 = com.blueair.database.DeviceField.McuFirmware.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05c9
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 16
            r6.label = r4
            java.lang.Object r1 = r1.updateMcuFirmware(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x05c9:
            com.blueair.database.DeviceField$Hardware r3 = com.blueair.database.DeviceField.Hardware.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0607
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 17
            r6.label = r4
            java.lang.Object r1 = r1.updateHardware(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0607:
            com.blueair.database.DeviceField$StandbyMode r3 = com.blueair.database.DeviceField.StandbyMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0645
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 18
            r6.label = r3
            java.lang.Object r1 = r1.updateStandByMode(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0645:
            com.blueair.database.DeviceField$EcoMode r3 = com.blueair.database.DeviceField.EcoMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0683
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 19
            r6.label = r3
            java.lang.Object r1 = r1.updateEcoMode(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0683:
            com.blueair.database.DeviceField$HinsMode r3 = com.blueair.database.DeviceField.HinsMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x06c1
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 20
            r6.label = r3
            java.lang.Object r1 = r1.updateHinsMode(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x06c1:
            com.blueair.database.DeviceField$HinsNightMode r3 = com.blueair.database.DeviceField.HinsNightMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x06ff
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 21
            r6.label = r3
            java.lang.Object r1 = r1.updateHinsNightMode(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x06ff:
            com.blueair.database.DeviceField$G4NightMode r3 = com.blueair.database.DeviceField.G4NightMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x073d
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 22
            r6.label = r3
            java.lang.Object r1 = r1.updateG4NightMode(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x073d:
            com.blueair.database.DeviceField$GermShieldMode r3 = com.blueair.database.DeviceField.GermShieldMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x077b
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 23
            r6.label = r3
            java.lang.Object r1 = r1.updateGermShieldMode(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x077b:
            com.blueair.database.DeviceField$GermShieldNightMode r3 = com.blueair.database.DeviceField.GermShieldNightMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x07bd
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 24
            r6.label = r3
            java.lang.Object r1 = r1.updateGermShieldNightMode(r2, r5, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x07bd:
            com.blueair.database.DeviceField$SerialNumber r3 = com.blueair.database.DeviceField.SerialNumber.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x07fb
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 25
            r6.label = r4
            java.lang.Object r1 = r1.updateSerialNumber(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x07fb:
            com.blueair.database.DeviceField$FilterTrigger r3 = com.blueair.database.DeviceField.FilterTrigger.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0839
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 26
            r6.label = r4
            java.lang.Object r1 = r1.updateFilterTrigger(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0839:
            com.blueair.database.DeviceField$G4NightModeFilterTrigger r3 = com.blueair.database.DeviceField.G4NightModeFilterTrigger.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0877
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 27
            r6.label = r4
            java.lang.Object r1 = r1.updateG4NightModeFilterTrigger(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0877:
            com.blueair.database.DeviceField$SafetySwitch r3 = com.blueair.database.DeviceField.SafetySwitch.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x08b5
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 28
            r6.label = r3
            java.lang.Object r1 = r1.updateSafetySwitch(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x08b5:
            com.blueair.database.DeviceField$MacAddress r3 = com.blueair.database.DeviceField.MacAddress.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x08f3
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 29
            r6.label = r4
            java.lang.Object r1 = r1.updateMacAddress(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x08f3:
            com.blueair.database.DeviceField$ModelName r3 = com.blueair.database.DeviceField.ModelName.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0931
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 30
            r6.label = r4
            java.lang.Object r1 = r1.updateModelName(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0931:
            com.blueair.database.DeviceField$FilterType r3 = com.blueair.database.DeviceField.FilterType.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x096f
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 31
            r6.label = r4
            java.lang.Object r1 = r1.updateFilterType(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x096f:
            com.blueair.database.DeviceField$DeviceType r3 = com.blueair.database.DeviceField.DeviceType.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x09b0
            r3 = r15
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x1b27
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.I$1 = r4
            r6.I$2 = r3
            r3 = 32
            r6.label = r3
            java.lang.Object r1 = r1.updateDeviceType(r2, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x09b0:
            com.blueair.database.DeviceField$DeviceSKU r3 = com.blueair.database.DeviceField.DeviceSKU.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x09ee
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 33
            r6.label = r4
            java.lang.Object r1 = r1.updateSku(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x09ee:
            com.blueair.database.DeviceField$DeviceCompatibility r3 = com.blueair.database.DeviceField.DeviceCompatibility.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0a2c
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 34
            r6.label = r4
            java.lang.Object r1 = r1.updateCompatibility(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0a2c:
            com.blueair.database.DeviceField$DeviceWelcomeHome r3 = com.blueair.database.DeviceField.DeviceWelcomeHome.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0acd
            r10 = r15
            com.blueair.core.model.WelcomeHomeLocation r10 = (com.blueair.core.model.WelcomeHomeLocation) r10
            if (r10 == 0) goto L_0x0a95
            double r3 = r10.getLat()
            java.lang.Double r3 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r3)
            double r4 = r10.getLng()
            java.lang.Double r4 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
            int r5 = r10.getRadius()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.String r7 = r10.getTextValue()
            boolean r8 = r10.isEnabled()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r6.L$0 = r2
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r11
            r6.L$3 = r1
            r6.L$4 = r10
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r6.L$5 = r11
            r11 = 0
            r6.I$0 = r11
            r6.I$1 = r11
            r11 = 35
            r6.label = r11
            r19 = r8
            r8 = r6
            r6 = r7
            r7 = r19
            java.lang.Object r3 = r1.updateWelcomeHome(r2, r3, r4, r5, r6, r7, r8)
            r6 = r8
            if (r3 != r0) goto L_0x0a8d
            goto L_0x1b1c
        L_0x0a8d:
            r5 = r1
            r4 = r10
            r1 = 0
        L_0x0a90:
            if (r4 != 0) goto L_0x1b27
            r4 = r5
        L_0x0a93:
            r5 = r2
            goto L_0x0a98
        L_0x0a95:
            r4 = r1
            r1 = 0
            goto L_0x0a93
        L_0x0a98:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r6.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r6.L$3 = r2
            r6.L$4 = r9
            r6.L$5 = r9
            r6.I$0 = r1
            r1 = 36
            r6.label = r1
            r8 = r6
            r6 = 0
            r7 = 0
            r11 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.Object r1 = r4.updateWelcomeHome(r5, r6, r7, r8, r9, r10, r11)
            if (r1 != r0) goto L_0x0ac9
            goto L_0x1b1c
        L_0x0ac9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x1b27
        L_0x0acd:
            com.blueair.database.DeviceField$Disinfection r3 = com.blueair.database.DeviceField.Disinfection.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0b0f
            r3 = r15
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x1b27
            boolean r4 = r3.booleanValue()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r3
            r3 = 0
            r6.I$0 = r3
            r6.Z$0 = r4
            r6.I$1 = r3
            r3 = 37
            r6.label = r3
            java.lang.Object r1 = r1.updateDisinfection(r2, r5, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0b0f:
            com.blueair.database.DeviceField$DisinfectLeftTime r3 = com.blueair.database.DeviceField.DisinfectLeftTime.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0b69
            boolean r3 = r15 instanceof kotlin.Pair
            if (r3 == 0) goto L_0x0b1e
            r9 = r15
            kotlin.Pair r9 = (kotlin.Pair) r9
        L_0x0b1e:
            if (r9 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getFirst()
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getSecond()
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getFirst()
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r4 = r9.getSecond()
            java.lang.Long r4 = (java.lang.Long) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r9
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r5
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r5 = 38
            r6.label = r5
            java.lang.Object r1 = r1.updateDisinfectLeftTime(r2, r3, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0b69:
            com.blueair.database.DeviceField$DeviceTimezone r3 = com.blueair.database.DeviceField.DeviceTimezone.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0b9f
            r3 = r15
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0b78
            java.lang.String r3 = ""
        L_0x0b78:
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r5 = 0
            r6.I$0 = r5
            r4 = 39
            r6.label = r4
            java.lang.Object r1 = r1.updateTimezone(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0b9f:
            com.blueair.database.DeviceField$WickdryEnabled r3 = com.blueair.database.DeviceField.WickdryEnabled.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0be1
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x0bae
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x0bae:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 40
            r6.label = r4
            java.lang.Object r1 = r1.updateWickdryEnabled(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0be1:
            com.blueair.database.DeviceField$WickdryOn r3 = com.blueair.database.DeviceField.WickdryOn.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0c23
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x0bf0
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x0bf0:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 41
            r6.label = r4
            java.lang.Object r1 = r1.updateWickdryOn(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0c23:
            com.blueair.database.DeviceField$WickdryLeftTime r3 = com.blueair.database.DeviceField.WickdryLeftTime.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0c8b
            boolean r3 = r15 instanceof kotlin.Pair
            if (r3 == 0) goto L_0x0c32
            r9 = r15
            kotlin.Pair r9 = (kotlin.Pair) r9
        L_0x0c32:
            if (r9 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getFirst()
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getSecond()
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getFirst()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r7
            r11 = 0
            r6.I$0 = r11
            r6.I$1 = r11
            r7 = 42
            r6.label = r7
            java.lang.Object r1 = r1.updateWickdryLeftTime(r2, r3, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0c8b:
            com.blueair.database.DeviceField$WickdryDuration r3 = com.blueair.database.DeviceField.WickdryDuration.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0cd0
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0c9a
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0c9a:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 43
            r6.label = r4
            java.lang.Object r1 = r1.updateWickdryDuration(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0cd0:
            com.blueair.database.DeviceField$WickdryDone r3 = com.blueair.database.DeviceField.WickdryDone.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0d12
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x0cdf
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x0cdf:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 44
            r6.label = r4
            java.lang.Object r1 = r1.updateWickdryDone(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0d12:
            com.blueair.database.DeviceField$WickUsage r3 = com.blueair.database.DeviceField.WickUsage.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0d57
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0d21
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0d21:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 45
            r6.label = r4
            java.lang.Object r1 = r1.updateWickUsage(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0d57:
            com.blueair.database.DeviceField$WaterShortage r3 = com.blueair.database.DeviceField.WaterShortage.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0d99
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x0d66
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x0d66:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 46
            r6.label = r4
            java.lang.Object r1 = r1.updateWaterShortage(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0d99:
            com.blueair.database.DeviceField$AutoRh r3 = com.blueair.database.DeviceField.AutoRh.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0dde
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0da8
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0da8:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 47
            r6.label = r4
            java.lang.Object r1 = r1.updateAutoRh(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0dde:
            com.blueair.database.DeviceField$TimerStatus r3 = com.blueair.database.DeviceField.TimerStatus.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0e23
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0ded
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0ded:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 48
            r6.label = r4
            java.lang.Object r1 = r1.updateTimerStatus(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0e23:
            com.blueair.database.DeviceField$TimerDuration r3 = com.blueair.database.DeviceField.TimerDuration.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0e68
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0e32
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0e32:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 49
            r6.label = r4
            java.lang.Object r1 = r1.updateTimerDuration(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0e68:
            com.blueair.database.DeviceField$TimerLeftTime r3 = com.blueair.database.DeviceField.TimerLeftTime.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0ed0
            boolean r3 = r15 instanceof kotlin.Pair
            if (r3 == 0) goto L_0x0e77
            r9 = r15
            kotlin.Pair r9 = (kotlin.Pair) r9
        L_0x0e77:
            if (r9 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getFirst()
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getSecond()
            if (r3 == 0) goto L_0x1b27
            java.lang.Object r3 = r9.getFirst()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r7
            r6.L$4 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r7
            r11 = 0
            r6.I$0 = r11
            r6.I$1 = r11
            r7 = 50
            r6.label = r7
            java.lang.Object r1 = r1.updateTimerLeftTime(r2, r3, r4, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0ed0:
            com.blueair.database.DeviceField$TemperatureUnit r3 = com.blueair.database.DeviceField.TemperatureUnit.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0f15
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0edf
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0edf:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 51
            r6.label = r4
            java.lang.Object r1 = r1.updateTemperatureUnit(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0f15:
            com.blueair.database.DeviceField$OscillationState r3 = com.blueair.database.DeviceField.OscillationState.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0f5a
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0f24
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0f24:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 52
            r6.label = r4
            java.lang.Object r1 = r1.updateOscillationState(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0f5a:
            com.blueair.database.DeviceField$OscillationAngle r3 = com.blueair.database.DeviceField.OscillationAngle.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0f9f
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0f69
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0f69:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 53
            r6.label = r4
            java.lang.Object r1 = r1.updateOscillationAngle(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0f9f:
            com.blueair.database.DeviceField$OscillationDirection r3 = com.blueair.database.DeviceField.OscillationDirection.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0fe4
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0fae
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0fae:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 54
            r6.label = r4
            java.lang.Object r1 = r1.updateOscillationDirection(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x0fe4:
            com.blueair.database.DeviceField$OscillationFanSpeed r3 = com.blueair.database.DeviceField.OscillationFanSpeed.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1029
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0ff3
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0ff3:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 55
            r6.label = r4
            java.lang.Object r1 = r1.updateOscillationFanSpeed(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1029:
            com.blueair.database.DeviceField$MainMode r3 = com.blueair.database.DeviceField.MainMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x106e
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1038
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1038:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 56
            r6.label = r4
            java.lang.Object r1 = r1.updateMainMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x106e:
            com.blueair.database.DeviceField$ApSubMode r3 = com.blueair.database.DeviceField.ApSubMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x10b3
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x107d
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x107d:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 57
            r6.label = r4
            java.lang.Object r1 = r1.updateApSubMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x10b3:
            com.blueair.database.DeviceField$ApFanSpeed r3 = com.blueair.database.DeviceField.ApFanSpeed.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x10f8
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x10c2
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x10c2:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 58
            r6.label = r4
            java.lang.Object r1 = r1.updateApFanSpeed(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x10f8:
            com.blueair.database.DeviceField$HeatSubMode r3 = com.blueair.database.DeviceField.HeatSubMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x113d
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1107
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1107:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 59
            r6.label = r4
            java.lang.Object r1 = r1.updateHeatSubMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x113d:
            com.blueair.database.DeviceField$HeatFanSpeed r3 = com.blueair.database.DeviceField.HeatFanSpeed.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1182
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x114c
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x114c:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 60
            r6.label = r4
            java.lang.Object r1 = r1.updateHeatFanSpeed(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1182:
            com.blueair.database.DeviceField$HeatAutoTmp r3 = com.blueair.database.DeviceField.HeatAutoTmp.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x11c7
            boolean r3 = r15 instanceof java.lang.Double
            if (r3 == 0) goto L_0x1191
            r9 = r15
            java.lang.Double r9 = (java.lang.Double) r9
        L_0x1191:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            double r3 = r3.doubleValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r6.D$0 = r3
            r5 = 61
            r6.label = r5
            java.lang.Object r1 = r1.updateHeatAutoTmp(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x11c7:
            com.blueair.database.DeviceField$HeatEcoTmp r3 = com.blueair.database.DeviceField.HeatEcoTmp.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x120c
            boolean r3 = r15 instanceof java.lang.Double
            if (r3 == 0) goto L_0x11d6
            r9 = r15
            java.lang.Double r9 = (java.lang.Double) r9
        L_0x11d6:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            double r3 = r3.doubleValue()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r5
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r6.D$0 = r3
            r5 = 62
            r6.label = r5
            java.lang.Object r1 = r1.updateHeatEcoTmp(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x120c:
            com.blueair.database.DeviceField$CoolSubMode r3 = com.blueair.database.DeviceField.CoolSubMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1251
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x121b
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x121b:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 63
            r6.label = r4
            java.lang.Object r1 = r1.updateCoolSubMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1251:
            com.blueair.database.DeviceField$CoolFanSpeed r3 = com.blueair.database.DeviceField.CoolFanSpeed.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1296
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1260
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1260:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 64
            r6.label = r4
            java.lang.Object r1 = r1.updateCoolFanSpeed(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1296:
            com.blueair.database.DeviceField$CoolAutoTag r3 = com.blueair.database.DeviceField.CoolAutoTag.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x12db
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x12a5
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x12a5:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 65
            r6.label = r4
            java.lang.Object r1 = r1.updateCoolAutoTag(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x12db:
            com.blueair.database.DeviceField$CoolAutoPresets r3 = com.blueair.database.DeviceField.CoolAutoPresets.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1323
            boolean r3 = r15 instanceof double[]
            if (r3 == 0) goto L_0x12ea
            r9 = r15
            double[] r9 = (double[]) r9
        L_0x12ea:
            if (r9 == 0) goto L_0x1b27
            com.blueair.database.DoubleArrayConverter$Companion r3 = com.blueair.database.DoubleArrayConverter.Companion
            java.lang.String r3 = r3.fromDoubleArray(r9)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 66
            r6.label = r4
            java.lang.Object r1 = r1.updateCoolAutoPresets(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1323:
            com.blueair.database.DeviceField$CoolEcoTag r3 = com.blueair.database.DeviceField.CoolEcoTag.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1368
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1332
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1332:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 67
            r6.label = r4
            java.lang.Object r1 = r1.updateCoolEcoTag(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1368:
            com.blueair.database.DeviceField$CoolEcoPresets r3 = com.blueair.database.DeviceField.CoolEcoPresets.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x13b0
            boolean r3 = r15 instanceof double[]
            if (r3 == 0) goto L_0x1377
            r9 = r15
            double[] r9 = (double[]) r9
        L_0x1377:
            if (r9 == 0) goto L_0x1b27
            com.blueair.database.DoubleArrayConverter$Companion r3 = com.blueair.database.DoubleArrayConverter.Companion
            java.lang.String r3 = r3.fromDoubleArray(r9)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 68
            r6.label = r4
            java.lang.Object r1 = r1.updateCoolEcoPresets(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x13b0:
            com.blueair.database.DeviceField$LocationId r3 = com.blueair.database.DeviceField.LocationId.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x13f2
            boolean r3 = r15 instanceof java.lang.String
            if (r3 == 0) goto L_0x13bf
            r9 = r15
            java.lang.String r9 = (java.lang.String) r9
        L_0x13bf:
            if (r9 == 0) goto L_0x1b27
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r3
            r6.L$4 = r9
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r3
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r3 = 69
            r6.label = r3
            java.lang.Object r1 = r1.updateLocationId(r2, r9, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x13f2:
            com.blueair.database.DeviceField$Mode r3 = com.blueair.database.DeviceField.Mode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1437
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1401
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1401:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 70
            r6.label = r4
            java.lang.Object r1 = r1.updateMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1437:
            com.blueair.database.DeviceField$HumMode r3 = com.blueair.database.DeviceField.HumMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1479
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x1446
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x1446:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 71
            r6.label = r4
            java.lang.Object r1 = r1.updateHumMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1479:
            com.blueair.database.DeviceField$WaterLevel r3 = com.blueair.database.DeviceField.WaterLevel.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x14be
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1488
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1488:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 72
            r6.label = r4
            java.lang.Object r1 = r1.updateWaterLevel(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x14be:
            com.blueair.database.DeviceField$DehSubMode r3 = com.blueair.database.DeviceField.DehSubMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1503
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x14cd
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x14cd:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 73
            r6.label = r4
            java.lang.Object r1 = r1.updateDehSubMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1503:
            com.blueair.database.DeviceField$WaterTankFailure r3 = com.blueair.database.DeviceField.WaterTankFailure.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1545
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x1512
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x1512:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 74
            r6.label = r4
            java.lang.Object r1 = r1.updateWaterTankFailure(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1545:
            com.blueair.database.DeviceField$SmartSubMode r3 = com.blueair.database.DeviceField.SmartSubMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x158a
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1554
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1554:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 75
            r6.label = r4
            java.lang.Object r1 = r1.updateSmartSubMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x158a:
            com.blueair.database.DeviceField$DetectCat r3 = com.blueair.database.DeviceField.DetectCat.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x15cc
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x1599
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x1599:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 76
            r6.label = r4
            java.lang.Object r1 = r1.updateDetectCat(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x15cc:
            com.blueair.database.DeviceField$BodyMounted r3 = com.blueair.database.DeviceField.BodyMounted.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x160e
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x15db
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x15db:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 77
            r6.label = r4
            java.lang.Object r1 = r1.updateBodyMounted(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x160e:
            com.blueair.database.DeviceField$CleanAirEta r3 = com.blueair.database.DeviceField.CleanAirEta.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1653
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x161d
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x161d:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 78
            r6.label = r4
            java.lang.Object r1 = r1.updateCleanAirEta(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1653:
            com.blueair.database.DeviceField$PanelDisplayMode r3 = com.blueair.database.DeviceField.PanelDisplayMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1698
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1662
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1662:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 79
            r6.label = r4
            java.lang.Object r1 = r1.updatePanelDisplayMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1698:
            com.blueair.database.DeviceField$HoverEnabled r3 = com.blueair.database.DeviceField.HoverEnabled.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x16da
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x16a7
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x16a7:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 80
            r6.label = r4
            java.lang.Object r1 = r1.updateHoverEnabled(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x16da:
            com.blueair.database.DeviceField$AirRefreshEnabled r3 = com.blueair.database.DeviceField.AirRefreshEnabled.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x171c
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x16e9
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x16e9:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 81
            r6.label = r4
            java.lang.Object r1 = r1.updateAirRefreshEnabled(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x171c:
            com.blueair.database.DeviceField$AirRefreshStatus r3 = com.blueair.database.DeviceField.AirRefreshStatus.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1761
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x172b
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x172b:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 82
            r6.label = r4
            java.lang.Object r1 = r1.updateAirRefreshStatus(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1761:
            com.blueair.database.DeviceField$AirRefreshDuration r3 = com.blueair.database.DeviceField.AirRefreshDuration.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x17a6
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1770
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1770:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 83
            r6.label = r4
            java.lang.Object r1 = r1.updateAirRefreshDuration(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x17a6:
            com.blueair.database.DeviceField$AirRefreshTimeStamp r3 = com.blueair.database.DeviceField.AirRefreshTimeStamp.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x17eb
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x17b5
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x17b5:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 84
            r6.label = r4
            java.lang.Object r1 = r1.updateAirRefreshTimeStamp(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x17eb:
            com.blueair.database.DeviceField$AirRefreshStartTimeStamp r3 = com.blueair.database.DeviceField.AirRefreshStartTimeStamp.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1830
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x17fa
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x17fa:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 85
            r6.label = r4
            java.lang.Object r1 = r1.updateAirRefreshStartTimeStamp(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1830:
            com.blueair.database.DeviceField$AirRefreshEndTimeStamp r3 = com.blueair.database.DeviceField.AirRefreshEndTimeStamp.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1875
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x183f
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x183f:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 86
            r6.label = r4
            java.lang.Object r1 = r1.updateAirRefreshEndTimeStamp(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1875:
            com.blueair.database.DeviceField$RoomType r3 = com.blueair.database.DeviceField.RoomType.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x18ba
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1884
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1884:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 87
            r6.label = r4
            java.lang.Object r1 = r1.updateRoomType(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x18ba:
            com.blueair.database.DeviceField$NightLampBrightness r3 = com.blueair.database.DeviceField.NightLampBrightness.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x18ff
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x18c9
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x18c9:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 88
            r6.label = r4
            java.lang.Object r1 = r1.updateNightLampBrightness(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x18ff:
            com.blueair.database.DeviceField$NightLampSteplessBrightness r3 = com.blueair.database.DeviceField.NightLampSteplessBrightness.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1944
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x190e
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x190e:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 89
            r6.label = r4
            java.lang.Object r1 = r1.updateNightLampSteplessBrightness(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1944:
            com.blueair.database.DeviceField$YwrmEnabled r3 = com.blueair.database.DeviceField.YwrmEnabled.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1984
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x1953
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x1953:
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r3
            r6.L$4 = r9
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r3
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r3 = 90
            r6.label = r3
            java.lang.Object r1 = r1.updateYwrmEnabled(r2, r9, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1984:
            com.blueair.database.DeviceField$YwrmUsage r3 = com.blueair.database.DeviceField.YwrmUsage.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x19c9
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1993
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1993:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 91
            r6.label = r4
            java.lang.Object r1 = r1.updateYwrmUsage(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x19c9:
            com.blueair.database.DeviceField$Alarms r3 = com.blueair.database.DeviceField.Alarms.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1a11
            boolean r3 = r15 instanceof java.util.List
            if (r3 == 0) goto L_0x19d8
            r9 = r15
            java.util.List r9 = (java.util.List) r9
        L_0x19d8:
            if (r9 == 0) goto L_0x1b27
            com.blueair.database.DeviceAlarmListConverter$Companion r3 = com.blueair.database.DeviceAlarmListConverter.Companion
            java.lang.String r3 = r3.fromDeviceAlarmList(r9)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$5 = r4
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r5
            r4 = 92
            r6.label = r4
            java.lang.Object r1 = r1.updateAlarms(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1a11:
            com.blueair.database.DeviceField$HumSubMode r3 = com.blueair.database.DeviceField.HumSubMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1a56
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1a20
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1a20:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 93
            r6.label = r4
            java.lang.Object r1 = r1.updateHumSubMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1a56:
            com.blueair.database.DeviceField$Use24Hour r3 = com.blueair.database.DeviceField.Use24Hour.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1a98
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x1a65
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x1a65:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 94
            r6.label = r4
            java.lang.Object r1 = r1.updateUse24Hour(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1a98:
            com.blueair.database.DeviceField$WaterInfill r3 = com.blueair.database.DeviceField.WaterInfill.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1ad9
            boolean r3 = r15 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x1aa7
            r9 = r15
            java.lang.Boolean r9 = (java.lang.Boolean) r9
        L_0x1aa7:
            if (r9 == 0) goto L_0x1b27
            boolean r3 = r9.booleanValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.Z$0 = r3
            r6.I$1 = r5
            r4 = 95
            r6.label = r4
            java.lang.Object r1 = r1.updatWaterInfill(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
            goto L_0x1b1c
        L_0x1ad9:
            com.blueair.database.DeviceField$SensorMode r3 = com.blueair.database.DeviceField.SensorMode.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x1b1d
            boolean r3 = r15 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x1ae8
            r9 = r15
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x1ae8:
            if (r9 == 0) goto L_0x1b27
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$3 = r4
            r6.L$4 = r9
            r5 = 0
            r6.I$0 = r5
            r6.I$1 = r3
            r6.I$2 = r5
            r4 = 96
            r6.label = r4
            java.lang.Object r1 = r1.updateSensorMode(r2, r3, r6)
            if (r1 != r0) goto L_0x1b27
        L_0x1b1c:
            return r0
        L_0x1b1d:
            com.blueair.database.DeviceField$Unknown r0 = com.blueair.database.DeviceField.Unknown.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x1b2a
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x1b27:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x1b2a:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.DeviceRepository.updateDeviceField(java.lang.String, com.blueair.database.DeviceField, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void deleteDevice(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Timber.Forest forest = Timber.Forest;
        forest.v("deleteDevice, uid = " + device.getUid(), new Object[0]);
        if (device.getUid().length() > 0) {
            this.blueairDb.deviceDao().delete(device.getUid());
            this.blueairDb.deviceDataDao().deleteAllForDevice(device.getUid());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Object deleteOldDeviceData(String str, long j, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DeviceRepository$deleteOldDeviceData$2(str, j, this, (Continuation<? super DeviceRepository$deleteOldDeviceData$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void deleteAllDevicesBackground(boolean z) {
        Timber.Forest forest = Timber.Forest;
        forest.v("deleteAllDevicesBackground: isAblDevice = " + z, new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new DeviceRepository$deleteAllDevicesBackground$1(this, z, (Continuation<? super DeviceRepository$deleteAllDevicesBackground$1>) null), 2, (Object) null);
    }

    public final void deleteAllDevices() {
        this.blueairDb.clearAllTables();
    }

    public final long getLatestHistoricalDataTime(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Long latestHistoricalDataTime = this.blueairDb.deviceDataDao().getLatestHistoricalDataTime(str);
        return (latestHistoricalDataTime != null ? latestHistoricalDataTime.longValue() : 0) * ((long) 1000);
    }
}
