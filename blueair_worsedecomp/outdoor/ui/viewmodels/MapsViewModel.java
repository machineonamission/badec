package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.outdoor.ui.adapters.LocationItem;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.ResponseBody;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001iB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070)0M2\u0006\u0010N\u001a\u000207H@¢\u0006\u0002\u0010OJ8\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0M2\u0006\u0010N\u001a\u0002072\f\u0010R\u001a\b\u0012\u0004\u0012\u0002070)2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002070)H@¢\u0006\u0002\u0010TJ \u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J\u0010\u0010\u0017\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0019H\u0002J \u0010\u0017\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J \u0010!\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J \u0010\\\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J\u0006\u0010]\u001a\u00020ZJ\u0006\u0010^\u001a\u00020ZJ\u0006\u0010_\u001a\u00020ZJ\b\u0010A\u001a\u0004\u0018\u00010@J<\u0010`\u001a\u00020Z2\u0006\u0010a\u001a\u00020\u00192\u0006\u0010b\u001a\u0002012\u0006\u0010c\u001a\u00020\u00122\u001c\b\u0002\u0010d\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190M\u0012\u0004\u0012\u00020Z\u0018\u00010eJ\u000e\u0010f\u001a\u00020Z2\u0006\u0010a\u001a\u00020\u0019J\u0014\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0)09H\u0002J\u0010\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R#\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00120$0\u0018¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190(¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190)0(¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010)0(X\u0004¢\u0006\u0002\n\u0000R\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030)0(¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u001c\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u00010706X\u0004¢\u0006\u0002\n\u0000R\u0019\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001d\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0)09¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<R \u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR.\u0010C\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u000201\u0018\u00010$0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR&\u0010F\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020706X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bK\u0010\u0014¨\u0006j"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "mapIsReady", "", "getMapIsReady", "()Z", "setMapIsReady", "(Z)V", "viewLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/core/model/TrackedLocation;", "getViewLocation", "()Landroidx/lifecycle/MutableLiveData;", "setViewLocation", "(Landroidx/lifecycle/MutableLiveData;)V", "currentlyViewedLocation", "getCurrentlyViewedLocation", "()Lcom/blueair/core/model/TrackedLocation;", "setCurrentlyViewedLocation", "(Lcom/blueair/core/model/TrackedLocation;)V", "savedLocationViewIndex", "Lkotlin/Pair;", "", "getSavedLocationViewIndex", "trackedLocations", "Landroidx/lifecycle/LiveData;", "", "getTrackedLocations", "()Landroidx/lifecycle/LiveData;", "currentLocation", "getCurrentLocation", "allLocations", "getAllLocations", "pollutants", "Lcom/blueair/core/model/AqiData;", "devices", "Lcom/blueair/core/model/Device;", "getDevices", "deviceLocationMap", "", "", "currentLocationWithPollutants", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "getCurrentLocationWithPollutants", "()Landroidx/lifecycle/MediatorLiveData;", "trackedLocationWithPollutants", "getTrackedLocationWithPollutants", "mode", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel$MapMode;", "getMode", "setMode", "addLocationModel", "getAddLocationModel", "setAddLocationModel", "markers", "getMarkers", "()Ljava/util/Map;", "setMarkers", "(Ljava/util/Map;)V", "isUserLoggedIn", "queryLocationDevices", "Lio/flatcircle/coroutinehelper/ApiResult;", "locationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLocationDevices", "Lokhttp3/ResponseBody;", "deviceIdList", "resetDeviceIdList", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEmptyLocation", "lat", "", "lng", "mapType", "", "location", "fetchAirQuality", "setAddMode", "setNormalMode", "setMinimizedMode", "insertTrackedLocation", "trackedLocation", "pollutant", "isUpdate", "completion", "Lkotlin/Function1;", "deleteLocation", "createMergedSavedLocationsLiveData", "createMergedCurrentLocation", "MapMode", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MapsViewModel.kt */
public final class MapsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private MutableLiveData<Pair<TrackedLocation, AqiData>> addLocationModel = new MutableLiveData<>();
    private final LiveData<List<TrackedLocation>> allLocations = Transformations.map(getOutdoorService().getDatabaseLiveTrackedLocations(), new MapsViewModel$$ExternalSyntheticLambda3());
    private final Lazy authService$delegate;
    private final LiveData<TrackedLocation> currentLocation = getOutdoorService().getDatabaseLiveCurrentLocation();
    private final MediatorLiveData<LocationItem> currentLocationWithPollutants = createMergedCurrentLocation();
    private TrackedLocation currentlyViewedLocation;
    private final Map<String, String> deviceLocationMap = new LinkedHashMap();
    private final LiveData<List<Device>> devices = getDeviceManager().getLiveDevices();
    private boolean mapIsReady;
    private Map<String, String> markers = new LinkedHashMap();
    private MutableLiveData<MapMode> mode = new MutableLiveData<>(MapMode.INITIAL);
    private final Lazy outdoorService$delegate;
    private final LiveData<List<AqiData>> pollutants = getOutdoorService().getDatabaseLiveAqiData();
    private final MutableLiveData<Pair<Integer, Boolean>> savedLocationViewIndex = new MutableLiveData<>(new Pair(0, true));
    private final MediatorLiveData<List<LocationItem>> trackedLocationWithPollutants = createMergedSavedLocationsLiveData();
    private final LiveData<List<TrackedLocation>> trackedLocations = getOutdoorService().getDatabaseLiveUserTrackedLocations();
    private MutableLiveData<TrackedLocation> viewLocation = new MutableLiveData<>();

    static {
        Class<MapsViewModel> cls = MapsViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new MapsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, OutdoorService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.outdoorService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new MapsViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel$MapMode;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "SAVED_LOCATIONS", "ADD_LOCATION", "MINIMIZED", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MapsViewModel.kt */
    public enum MapMode {
        INITIAL,
        SAVED_LOCATIONS,
        ADD_LOCATION,
        MINIMIZED;

        public static EnumEntries<MapMode> getEntries() {
            return $ENTRIES;
        }

        static {
            MapMode[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    public final boolean getMapIsReady() {
        return this.mapIsReady;
    }

    public final void setMapIsReady(boolean z) {
        this.mapIsReady = z;
    }

    public final MutableLiveData<TrackedLocation> getViewLocation() {
        return this.viewLocation;
    }

    public final void setViewLocation(MutableLiveData<TrackedLocation> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.viewLocation = mutableLiveData;
    }

    public final TrackedLocation getCurrentlyViewedLocation() {
        return this.currentlyViewedLocation;
    }

    public final void setCurrentlyViewedLocation(TrackedLocation trackedLocation) {
        this.currentlyViewedLocation = trackedLocation;
    }

    public final MutableLiveData<Pair<Integer, Boolean>> getSavedLocationViewIndex() {
        return this.savedLocationViewIndex;
    }

    public final LiveData<List<TrackedLocation>> getTrackedLocations() {
        return this.trackedLocations;
    }

    public final LiveData<TrackedLocation> getCurrentLocation() {
        return this.currentLocation;
    }

    /* access modifiers changed from: private */
    public static final List allLocations$lambda$1(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return CollectionsKt.sortedWith(list, new MapsViewModel$allLocations$lambda$1$$inlined$sortedByDescending$1());
    }

    public final LiveData<List<TrackedLocation>> getAllLocations() {
        return this.allLocations;
    }

    public final LiveData<List<Device>> getDevices() {
        return this.devices;
    }

    public final MediatorLiveData<LocationItem> getCurrentLocationWithPollutants() {
        return this.currentLocationWithPollutants;
    }

    public final MediatorLiveData<List<LocationItem>> getTrackedLocationWithPollutants() {
        return this.trackedLocationWithPollutants;
    }

    public final MutableLiveData<MapMode> getMode() {
        return this.mode;
    }

    public final void setMode(MutableLiveData<MapMode> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mode = mutableLiveData;
    }

    public final MutableLiveData<Pair<TrackedLocation, AqiData>> getAddLocationModel() {
        return this.addLocationModel;
    }

    public final void setAddLocationModel(MutableLiveData<Pair<TrackedLocation, AqiData>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addLocationModel = mutableLiveData;
    }

    public final Map<String, String> getMarkers() {
        return this.markers;
    }

    public final void setMarkers(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.markers = map;
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final Object queryLocationDevices(String str, Continuation<? super ApiResult<List<String>>> continuation) {
        return getDeviceManager().getLocationDevices(str, continuation);
    }

    public final Object setLocationDevices(String str, List<String> list, List<String> list2, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return getDeviceManager().setupDeviceLocation(str, list, list2, continuation);
    }

    public final TrackedLocation createEmptyLocation(double d, double d2, String str) {
        return new TrackedLocation("", d, d2, (String) null, (String) null, (String) null, (String) null, (String) null, str);
    }

    private final void viewLocation(TrackedLocation trackedLocation) {
        this.viewLocation.setValue(trackedLocation);
        this.currentlyViewedLocation = trackedLocation;
    }

    public final void viewLocation(double d, double d2, String str) {
        viewLocation(createEmptyLocation(d, d2, str));
    }

    public final void setCurrentlyViewedLocation(double d, double d2, String str) {
        this.currentlyViewedLocation = createEmptyLocation(d, d2, str);
    }

    public final void fetchAirQuality(double d, double d2, String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new MapsViewModel$fetchAirQuality$1(this, d, d2, str, (Continuation<? super MapsViewModel$fetchAirQuality$1>) null), 2, (Object) null);
    }

    public final void setAddMode() {
        this.mode.setValue(MapMode.ADD_LOCATION);
    }

    public final void setNormalMode() {
        this.mode.setValue(MapMode.SAVED_LOCATIONS);
    }

    public final void setMinimizedMode() {
        this.mode.setValue(MapMode.MINIMIZED);
    }

    /* renamed from: getMode  reason: collision with other method in class */
    public final MapMode m8652getMode() {
        return this.mode.getValue();
    }

    public static /* synthetic */ void insertTrackedLocation$default(MapsViewModel mapsViewModel, TrackedLocation trackedLocation, AqiData aqiData, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        mapsViewModel.insertTrackedLocation(trackedLocation, aqiData, z, function1);
    }

    public final void insertTrackedLocation(TrackedLocation trackedLocation, AqiData aqiData, boolean z, Function1<? super ApiResult<TrackedLocation>, Unit> function1) {
        Intrinsics.checkNotNullParameter(trackedLocation, "trackedLocation");
        Intrinsics.checkNotNullParameter(aqiData, "pollutant");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new MapsViewModel$insertTrackedLocation$1(this, trackedLocation, aqiData, z, function1, (Continuation<? super MapsViewModel$insertTrackedLocation$1>) null), 2, (Object) null);
    }

    public final void deleteLocation(TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "trackedLocation");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new MapsViewModel$deleteLocation$1(this, trackedLocation, (Continuation<? super MapsViewModel$deleteLocation$1>) null), 2, (Object) null);
    }

    private final MediatorLiveData<List<LocationItem>> createMergedSavedLocationsLiveData() {
        MediatorLiveData<List<LocationItem>> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(this.trackedLocations, new MapsViewModel$sam$androidx_lifecycle_Observer$0(new MapsViewModel$$ExternalSyntheticLambda0(this, mediatorLiveData)));
        mediatorLiveData.addSource(this.pollutants, new MapsViewModel$sam$androidx_lifecycle_Observer$0(new MapsViewModel$$ExternalSyntheticLambda1(this, mediatorLiveData)));
        mediatorLiveData.addSource(this.devices, new MapsViewModel$sam$androidx_lifecycle_Observer$0(new MapsViewModel$$ExternalSyntheticLambda2(this, mediatorLiveData)));
        return mediatorLiveData;
    }

    private static final void createMergedSavedLocationsLiveData$lambda$10$mergeData(MapsViewModel mapsViewModel, MediatorLiveData<List<LocationItem>> mediatorLiveData) {
        List value;
        Object obj;
        List list;
        List arrayList = new ArrayList();
        List value2 = mapsViewModel.devices.getValue();
        List<TrackedLocation> value3 = mapsViewModel.trackedLocations.getValue();
        if (!(value3 == null || (value = mapsViewModel.pollutants.getValue()) == null)) {
            for (TrackedLocation trackedLocation : value3) {
                Iterator it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((AqiData) obj).getLocationId(), (Object) trackedLocation.getId())) {
                        break;
                    }
                }
                AqiData aqiData = (AqiData) obj;
                if (aqiData != null) {
                    if (value2 != null) {
                        Collection arrayList2 = new ArrayList();
                        for (Object next : value2) {
                            Device device = (Device) next;
                            if ((device instanceof HasLocation) && Intrinsics.areEqual((Object) ((HasLocation) device).getLocationId(), (Object) trackedLocation.getId())) {
                                arrayList2.add(next);
                            }
                        }
                        list = (List) arrayList2;
                    } else {
                        list = CollectionsKt.emptyList();
                    }
                    arrayList.add(new LocationItem(trackedLocation, aqiData, list));
                }
            }
        }
        mediatorLiveData.setValue(arrayList);
    }

    /* access modifiers changed from: private */
    public static final Unit createMergedSavedLocationsLiveData$lambda$10$lambda$6(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData, List list) {
        createMergedSavedLocationsLiveData$lambda$10$mergeData(mapsViewModel, mediatorLiveData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit createMergedSavedLocationsLiveData$lambda$10$lambda$7(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData, List list) {
        createMergedSavedLocationsLiveData$lambda$10$mergeData(mapsViewModel, mediatorLiveData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit createMergedSavedLocationsLiveData$lambda$10$lambda$9(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData, List list) {
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Device device = (Device) it.next();
            if (device instanceof HasLocation) {
                HasLocation hasLocation = (HasLocation) device;
                if (!Intrinsics.areEqual((Object) mapsViewModel.deviceLocationMap.get(device.getUid()), (Object) hasLocation.getLocationId())) {
                    mapsViewModel.deviceLocationMap.put(device.getUid(), hasLocation.getLocationId());
                    z = true;
                }
            }
        }
        if (z) {
            createMergedSavedLocationsLiveData$lambda$10$mergeData(mapsViewModel, mediatorLiveData);
        }
        return Unit.INSTANCE;
    }

    private final MediatorLiveData<LocationItem> createMergedCurrentLocation() {
        MediatorLiveData<LocationItem> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(this.pollutants, new MapsViewModel$sam$androidx_lifecycle_Observer$0(new MapsViewModel$$ExternalSyntheticLambda4(this, mediatorLiveData)));
        mediatorLiveData.addSource(this.currentLocation, new MapsViewModel$sam$androidx_lifecycle_Observer$0(new MapsViewModel$$ExternalSyntheticLambda5(this, mediatorLiveData)));
        return mediatorLiveData;
    }

    private static final void createMergedCurrentLocation$lambda$17$mergeData$14(MapsViewModel mapsViewModel, MediatorLiveData<LocationItem> mediatorLiveData) {
        List value;
        Object obj;
        TrackedLocation value2 = mapsViewModel.currentLocation.getValue();
        LocationItem locationItem = null;
        if (!(value2 == null || (value = mapsViewModel.pollutants.getValue()) == null)) {
            Iterator it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((AqiData) obj).getLocationId(), (Object) value2.getId())) {
                    break;
                }
            }
            AqiData aqiData = (AqiData) obj;
            if (aqiData != null) {
                locationItem = new LocationItem(value2, aqiData, CollectionsKt.emptyList());
            }
        }
        mediatorLiveData.setValue(locationItem);
    }

    /* access modifiers changed from: private */
    public static final Unit createMergedCurrentLocation$lambda$17$lambda$15(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData, List list) {
        createMergedCurrentLocation$lambda$17$mergeData$14(mapsViewModel, mediatorLiveData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit createMergedCurrentLocation$lambda$17$lambda$16(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData, TrackedLocation trackedLocation) {
        createMergedCurrentLocation$lambda$17$mergeData$14(mapsViewModel, mediatorLiveData);
        return Unit.INSTANCE;
    }
}
