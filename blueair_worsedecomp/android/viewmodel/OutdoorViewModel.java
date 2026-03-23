package com.blueair.android.viewmodel;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import com.amplitude.api.Constants;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001d2\u0006\u0010/\u001a\u00020\"J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001eJ\b\u00103\u001a\u000201H\u0014J\u000e\u00104\u001a\u0002012\u0006\u0010/\u001a\u00020\"J\u0016\u00105\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u000201J\u000e\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020<R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u001d8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001d8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001fRG\u0010&\u001a.\u0012\u0004\u0012\u00020(\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001d0'j\u0016\u0012\u0004\u0012\u00020(\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001d`*8FX\u0002¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b+\u0010,¨\u0006="}, d2 = {"Lcom/blueair/android/viewmodel/OutdoorViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "lastRefreshTime", "", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "getMapType", "()Lcom/blueair/auth/LocationService$MapType;", "isUserLoggedIn", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "liveUserLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "getLiveUserLocations", "liveCurrentLocation", "getLiveCurrentLocation", "aqiDataMap", "Ljava/util/HashMap;", "", "Lcom/blueair/core/model/AqiData;", "Lkotlin/collections/HashMap;", "getAqiDataMap", "()Ljava/util/HashMap;", "aqiDataMap$delegate", "liveAqiData", "location", "refreshTrackedLocationList", "", "hasBeenPaused", "onCleared", "refreshAqiData", "setCurrentLocation", "lat", "", "lon", "clearCurrentLocation", "trackEvent", "event", "Lcom/blueair/core/model/AnalyticEvent;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorViewModel.kt */
public final class OutdoorViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private final Lazy aqiDataMap$delegate = LazyKt.lazy(new OutdoorViewModel$$ExternalSyntheticLambda0());
    private final Lazy authService$delegate;
    private final LiveData<Boolean> isUserLoggedIn = FlowLiveDataConversions.asLiveData$default((Flow) getAuthService().isUserLoggedIn(), (CoroutineContext) null, 0, 3, (Object) null);
    private long lastRefreshTime;
    private final Lazy locationService$delegate;
    private final Lazy outdoorService$delegate;

    static {
        Class<OutdoorViewModel> cls = OutdoorViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutdoorViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, OutdoorService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.outdoorService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new OutdoorViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new OutdoorViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public final LocationService.MapType getMapType() {
        return getLocationService().getMapType();
    }

    public final LiveData<Boolean> isUserLoggedIn() {
        return this.isUserLoggedIn;
    }

    public final LiveData<List<TrackedLocation>> getLiveUserLocations() {
        return getOutdoorService().getDatabaseLiveUserTrackedLocations();
    }

    public final LiveData<TrackedLocation> getLiveCurrentLocation() {
        return getOutdoorService().getDatabaseLiveCurrentLocation();
    }

    public final HashMap<String, LiveData<AqiData>> getAqiDataMap() {
        return (HashMap) this.aqiDataMap$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final HashMap aqiDataMap_delegate$lambda$0() {
        return new HashMap();
    }

    public final LiveData<AqiData> liveAqiData(TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        return getOutdoorService().liveAqiData(trackedLocation);
    }

    public final void refreshTrackedLocationList(boolean z) {
        boolean booleanValue = getAuthService().isUserLoggedIn().getValue().booleanValue();
        Timber.Forest forest = Timber.Forest;
        forest.d("refresh location list: hasBeenPaused = " + z + ", isUserLoggedIn = " + booleanValue, new Object[0]);
        if (booleanValue) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.lastRefreshTime;
            if (!z || j > Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS) {
                this.lastRefreshTime = currentTimeMillis;
                Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorViewModel$refreshTrackedLocationList$1(this, (Continuation<? super OutdoorViewModel$refreshTrackedLocationList$1>) null), 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        getAqiDataMap().clear();
    }

    public final void refreshAqiData(TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorViewModel$refreshAqiData$1(this, trackedLocation, (Continuation<? super OutdoorViewModel$refreshAqiData$1>) null), 2, (Object) null);
    }

    public final void setCurrentLocation(double d, double d2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorViewModel$setCurrentLocation$1(this, d, d2, (Continuation<? super OutdoorViewModel$setCurrentLocation$1>) null), 2, (Object) null);
    }

    public final void clearCurrentLocation() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorViewModel$clearCurrentLocation$1(this, (Continuation<? super OutdoorViewModel$clearCurrentLocation$1>) null), 2, (Object) null);
    }

    public final void trackEvent(AnalyticEvent analyticEvent) {
        Intrinsics.checkNotNullParameter(analyticEvent, "event");
        getAnalyticsService().event(analyticEvent);
    }
}
