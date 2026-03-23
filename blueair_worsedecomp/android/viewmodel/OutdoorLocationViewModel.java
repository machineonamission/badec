package com.blueair.android.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u000203J\u0006\u0010;\u001a\u000203R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00168FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b-\u0010\nR\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006="}, d2 = {"Lcom/blueair/android/viewmodel/OutdoorLocationViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "value", "", "useCurrentLocation", "getUseCurrentLocation", "()Z", "", "position", "getPosition", "()I", "fixedLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/core/model/TrackedLocation;", "location", "getLocation", "()Lcom/blueair/core/model/TrackedLocation;", "liveLocation", "Landroidx/lifecycle/LiveData;", "getLiveLocation", "()Landroidx/lifecycle/LiveData;", "liveAqiData", "Lcom/blueair/core/model/AqiData;", "getLiveAqiData", "liveAqiData$delegate", "Lkotlin/Lazy;", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "isUserLoggedIn", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "getMapType", "()Lcom/blueair/auth/LocationService$MapType;", "update", "", "args", "Landroid/os/Bundle;", "setCurrentLocation", "lat", "", "lon", "clearCurrentLocation", "refreshAqiData", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorLocationViewModel.kt */
public final class OutdoorLocationViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public static final TrackedLocation BEJING = new TrackedLocation("beijing", 39.91509030149438d, 116.38416193043909d, "China", "北京市", "北京市", "China", "CN", TrackedLocation.MAP_TYPE_GCJ);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FALLBACK_POSITION = -1;
    public static final String KEY_COLLAPSE = "KEY_COLLAPSE";
    public static final String KEY_POSITION = "KEY_POSITION";
    public static final String KEY_TRACKED_LOCATION = "KEY_TRACKED_LOCATION";
    public static final String KEY_USE_CURRENT_LOCATION = "KEY_USE_CURRENT_LOCATION";
    private final Lazy authService$delegate;
    private MutableLiveData<TrackedLocation> fixedLocation = new MutableLiveData<>();
    private final Lazy liveAqiData$delegate = LazyKt.lazy(new OutdoorLocationViewModel$$ExternalSyntheticLambda1(this));
    private final Lazy locationService$delegate;
    private final Lazy outdoorService$delegate;
    private int position = -1;
    private boolean useCurrentLocation;

    static {
        Class<OutdoorLocationViewModel> cls = OutdoorLocationViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutdoorLocationViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorLocationViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, OutdoorService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.outdoorService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new OutdoorLocationViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new OutdoorLocationViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/android/viewmodel/OutdoorLocationViewModel$Companion;", "", "<init>", "()V", "KEY_TRACKED_LOCATION", "", "KEY_USE_CURRENT_LOCATION", "KEY_POSITION", "KEY_COLLAPSE", "FALLBACK_POSITION", "", "BEJING", "Lcom/blueair/core/model/TrackedLocation;", "getBEJING", "()Lcom/blueair/core/model/TrackedLocation;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorLocationViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrackedLocation getBEJING() {
            return OutdoorLocationViewModel.BEJING;
        }
    }

    public final boolean getUseCurrentLocation() {
        return this.useCurrentLocation;
    }

    public final int getPosition() {
        return this.position;
    }

    public final TrackedLocation getLocation() {
        return (TrackedLocation) (this.useCurrentLocation ? getLiveLocation().getValue() : this.fixedLocation.getValue());
    }

    public final LiveData<TrackedLocation> getLiveLocation() {
        return this.useCurrentLocation ? getOutdoorService().getDatabaseLiveCurrentLocation() : this.fixedLocation;
    }

    public final LiveData<AqiData> getLiveAqiData() {
        return (LiveData) this.liveAqiData$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final MediatorLiveData liveAqiData_delegate$lambda$4(OutdoorLocationViewModel outdoorLocationViewModel) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(outdoorLocationViewModel.getLiveLocation(), new OutdoorLocationViewModel$sam$androidx_lifecycle_Observer$0(new OutdoorLocationViewModel$$ExternalSyntheticLambda0(new Ref.ObjectRef(), mediatorLiveData, outdoorLocationViewModel)));
        return mediatorLiveData;
    }

    /* access modifiers changed from: private */
    public static final Unit liveAqiData_delegate$lambda$4$lambda$3$lambda$2(Ref.ObjectRef objectRef, MediatorLiveData mediatorLiveData, OutdoorLocationViewModel outdoorLocationViewModel, TrackedLocation trackedLocation) {
        if (trackedLocation == null) {
            LiveData liveData = (LiveData) objectRef.element;
            if (liveData != null) {
                mediatorLiveData.removeSource(liveData);
            }
            mediatorLiveData.setValue(null);
        } else {
            objectRef.element = outdoorLocationViewModel.getOutdoorService().liveAqiData(trackedLocation);
            T t = objectRef.element;
            Intrinsics.checkNotNull(t);
            mediatorLiveData.addSource((LiveData) t, new OutdoorLocationViewModel$sam$androidx_lifecycle_Observer$0(new OutdoorLocationViewModel$$ExternalSyntheticLambda2(mediatorLiveData)));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit liveAqiData_delegate$lambda$4$lambda$3$lambda$2$lambda$1(MediatorLiveData mediatorLiveData, AqiData aqiData) {
        mediatorLiveData.setValue(aqiData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final LocationService.MapType getMapType() {
        return getLocationService().getMapType();
    }

    public final void update(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "args");
        boolean z = bundle.getBoolean(KEY_USE_CURRENT_LOCATION, false);
        this.useCurrentLocation = z;
        if (!z) {
            MutableLiveData<TrackedLocation> mutableLiveData = this.fixedLocation;
            TrackedLocation trackedLocation = (TrackedLocation) bundle.getParcelable(KEY_TRACKED_LOCATION);
            if (trackedLocation == null) {
                trackedLocation = BEJING;
            }
            mutableLiveData.setValue(trackedLocation);
        }
        this.position = bundle.getInt(KEY_POSITION, -1);
        Timber.Forest forest = Timber.Forest;
        forest.d("update: position = " + this.position + ", useCurrentLocation = " + this.useCurrentLocation + ", fixedLocation.value arg = " + this.fixedLocation.getValue(), new Object[0]);
    }

    public final void setCurrentLocation(double d, double d2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorLocationViewModel$setCurrentLocation$1(this, d, d2, (Continuation<? super OutdoorLocationViewModel$setCurrentLocation$1>) null), 2, (Object) null);
    }

    public final void clearCurrentLocation() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorLocationViewModel$clearCurrentLocation$1(this, (Continuation<? super OutdoorLocationViewModel$clearCurrentLocation$1>) null), 2, (Object) null);
    }

    public final void refreshAqiData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new OutdoorLocationViewModel$refreshAqiData$1(this, (Continuation<? super OutdoorLocationViewModel$refreshAqiData$1>) null), 2, (Object) null);
    }
}
