package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.outdoor.ui.activity.SearchActivity;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010H\u001a\u00020BJ\b\u0010I\u001a\u00020BH\u0002J\u0006\u0010J\u001a\u00020BJ\u0006\u0010K\u001a\u00020BJ$\u0010L\u001a\u00020B2\u0006\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020B0NJ\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020BH\u0002J\u0016\u0010S\u001a\u00020B2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0UH\u0002J\u000e\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020XJ\u000e\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020[R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR*\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010(\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00107\u001a\u0004\u0018\u0001062\b\u0010 \u001a\u0004\u0018\u000106@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020B0=8F¢\u0006\u0006\u001a\u0004\bC\u0010?R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020B0=8F¢\u0006\u0006\u001a\u0004\bF\u0010?R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020B0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/CreateUpdateWelcomeHomeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "geocoder", "Landroid/location/Geocoder;", "car", "Landroidx/lifecycle/MutableLiveData;", "", "getCar", "()Landroidx/lifecycle/MutableLiveData;", "bicycle", "getBicycle", "walk", "getWalk", "commute", "getCommute", "welcomeHomeExist", "getWelcomeHomeExist", "gotAddress", "getGotAddress", "address", "", "getAddress", "shortAddress", "getShortAddress", "city", "getCity", "saveEnabled", "getSaveEnabled", "value", "", "lat", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng", "setLng", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "getDevice", "()Lcom/blueair/core/model/HasWelcomeHome;", "setDevice", "(Lcom/blueair/core/model/HasWelcomeHome;)V", "useShortAddress", "getUseShortAddress", "()Z", "setUseShortAddress", "(Z)V", "Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "selectedRadius", "getSelectedRadius", "()Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "setSelectedRadius", "(Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;)V", "loading", "Landroidx/lifecycle/LiveData;", "getLoading", "()Landroidx/lifecycle/LiveData;", "_loading", "failure", "", "getFailure", "_failure", "success", "getSuccess", "_success", "loadHomeLocation", "validateSettings", "saveHomeLocation", "deleteWelcomeHome", "setAddressFromLatLng", "onAddressFetch", "Lkotlin/Function0;", "fetchAddress", "addr", "Landroid/location/Address;", "fetchCity", "extractCity", "addressList", "", "setCustomPlace", "place", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "setTrackedLocation", "location", "Lcom/blueair/core/model/TrackedLocation;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
public final class CreateUpdateWelcomeHomeViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Unit> _failure;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _loading;
    /* access modifiers changed from: private */
    public final MutableLiveData<Unit> _success;
    private final MutableLiveData<String> address;
    private final MutableLiveData<Boolean> bicycle = new MutableLiveData<>();
    private final MutableLiveData<Boolean> car = new MutableLiveData<>();
    private final MutableLiveData<String> city;
    private final MutableLiveData<Boolean> commute = new MutableLiveData<>();
    public HasWelcomeHome device;
    /* access modifiers changed from: private */
    public final Geocoder geocoder;
    private final MutableLiveData<Boolean> gotAddress = new MutableLiveData<>(false);
    private Double lat;
    private Double lng;
    private final MutableLiveData<Boolean> saveEnabled;
    private WelcomeHomeLocation.WelcomeHomeRadius selectedRadius;
    private final MutableLiveData<String> shortAddress;
    private boolean useShortAddress;
    private final MutableLiveData<Boolean> walk = new MutableLiveData<>();
    private final MutableLiveData<Boolean> welcomeHomeExist = new MutableLiveData<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.blueair.core.model.WelcomeHomeLocation$WelcomeHomeRadius[] r0 = com.blueair.core.model.WelcomeHomeLocation.WelcomeHomeRadius.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.WelcomeHomeLocation$WelcomeHomeRadius r1 = com.blueair.core.model.WelcomeHomeLocation.WelcomeHomeRadius.CAR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.WelcomeHomeLocation$WelcomeHomeRadius r1 = com.blueair.core.model.WelcomeHomeLocation.WelcomeHomeRadius.BICYCLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.WelcomeHomeLocation$WelcomeHomeRadius r1 = com.blueair.core.model.WelcomeHomeLocation.WelcomeHomeRadius.WALK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.WelcomeHomeLocation$WelcomeHomeRadius r1 = com.blueair.core.model.WelcomeHomeLocation.WelcomeHomeRadius.COMMUTE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateUpdateWelcomeHomeViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.geocoder = new Geocoder(application);
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.observeForever(new CreateUpdateWelcomeHomeViewModel$sam$androidx_lifecycle_Observer$0(new CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda1(this)));
        this.address = mutableLiveData;
        this.shortAddress = new MutableLiveData<>();
        this.city = new MutableLiveData<>();
        this.saveEnabled = new MutableLiveData<>(false);
        this._loading = new MutableLiveData<>();
        this._failure = new MutableLiveData<>();
        this._success = new MutableLiveData<>();
    }

    public final MutableLiveData<Boolean> getCar() {
        return this.car;
    }

    public final MutableLiveData<Boolean> getBicycle() {
        return this.bicycle;
    }

    public final MutableLiveData<Boolean> getWalk() {
        return this.walk;
    }

    public final MutableLiveData<Boolean> getCommute() {
        return this.commute;
    }

    public final MutableLiveData<Boolean> getWelcomeHomeExist() {
        return this.welcomeHomeExist;
    }

    public final MutableLiveData<Boolean> getGotAddress() {
        return this.gotAddress;
    }

    public final MutableLiveData<String> getAddress() {
        return this.address;
    }

    /* access modifiers changed from: private */
    public static final Unit address$lambda$1$lambda$0(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, String str) {
        createUpdateWelcomeHomeViewModel.validateSettings();
        MutableLiveData<Boolean> mutableLiveData = createUpdateWelcomeHomeViewModel.gotAddress;
        Intrinsics.checkNotNull(str);
        mutableLiveData.setValue(Boolean.valueOf(str.length() > 0));
        return Unit.INSTANCE;
    }

    public final MutableLiveData<String> getShortAddress() {
        return this.shortAddress;
    }

    public final MutableLiveData<String> getCity() {
        return this.city;
    }

    public final MutableLiveData<Boolean> getSaveEnabled() {
        return this.saveEnabled;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final void setLat(Double d) {
        this.lat = d;
        validateSettings();
    }

    public final Double getLng() {
        return this.lng;
    }

    public final void setLng(Double d) {
        this.lng = d;
        validateSettings();
    }

    public final HasWelcomeHome getDevice() {
        HasWelcomeHome hasWelcomeHome = this.device;
        if (hasWelcomeHome != null) {
            return hasWelcomeHome;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(HasWelcomeHome hasWelcomeHome) {
        Intrinsics.checkNotNullParameter(hasWelcomeHome, "<set-?>");
        this.device = hasWelcomeHome;
    }

    public final boolean getUseShortAddress() {
        return this.useShortAddress;
    }

    public final void setUseShortAddress(boolean z) {
        this.useShortAddress = z;
    }

    public final WelcomeHomeLocation.WelcomeHomeRadius getSelectedRadius() {
        return this.selectedRadius;
    }

    public final void setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius welcomeHomeRadius) {
        int i;
        this.selectedRadius = welcomeHomeRadius;
        if (welcomeHomeRadius == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[welcomeHomeRadius.ordinal()];
        }
        if (i == 1) {
            this.car.setValue(true);
            this.bicycle.setValue(false);
            this.walk.setValue(false);
            this.commute.setValue(false);
        } else if (i == 2) {
            this.car.setValue(false);
            this.bicycle.setValue(true);
            this.walk.setValue(false);
            this.commute.setValue(false);
        } else if (i == 3) {
            this.car.setValue(false);
            this.bicycle.setValue(false);
            this.walk.setValue(true);
            this.commute.setValue(false);
        } else if (i == 4) {
            this.car.setValue(false);
            this.bicycle.setValue(false);
            this.walk.setValue(false);
            this.commute.setValue(true);
        }
        validateSettings();
    }

    public final LiveData<Boolean> getLoading() {
        return this._loading;
    }

    public final LiveData<Unit> getFailure() {
        return this._failure;
    }

    public final LiveData<Unit> getSuccess() {
        return this._success;
    }

    public final void loadHomeLocation() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1(this, (Continuation<? super CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1>) null), 2, (Object) null);
    }

    private final void validateSettings() {
        this.saveEnabled.postValue(Boolean.valueOf((this.lat == null || this.lng == null || this.selectedRadius == null || this.address.getValue() == null) ? false : true));
    }

    public final void saveHomeLocation() {
        if (Intrinsics.areEqual((Object) this.saveEnabled.getValue(), (Object) true)) {
            this._loading.setValue(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1(this, (Continuation<? super CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1>) null), 3, (Object) null);
        }
    }

    public final void deleteWelcomeHome() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1(this, (Continuation<? super CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1>) null), 3, (Object) null);
    }

    public final void setAddressFromLatLng(double d, double d2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onAddressFetch");
        if (Build.VERSION.SDK_INT >= 33) {
            Geocoder geocoder2 = this.geocoder;
            Geocoder geocoder3 = geocoder2;
            double d3 = d2;
            geocoder3.getFromLocation(d, d3, 1, new CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda2(this, d, d2, function0));
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2(this, d, d2, function0, (Continuation<? super CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void setAddressFromLatLng$lambda$3(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, double d, double d2, Function0 function0, List list) {
        Intrinsics.checkNotNullParameter(list, "addressList");
        Address address2 = (Address) CollectionsKt.firstOrNull(list);
        if (address2 != null) {
            createUpdateWelcomeHomeViewModel.setLat(Double.valueOf(d));
            createUpdateWelcomeHomeViewModel.setLng(Double.valueOf(d2));
            createUpdateWelcomeHomeViewModel.fetchAddress(address2);
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public final void fetchAddress(Address address2) {
        String addressLine = address2.getAddressLine(0);
        this.address.postValue(addressLine);
        Intrinsics.checkNotNull(addressLine);
        CharSequence charSequence = addressLine;
        String str = "";
        if (StringsKt.contains$default(charSequence, (CharSequence) ",", false, 2, (Object) null)) {
            this.shortAddress.postValue(CollectionsKt.firstOrNull(StringsKt.split$default(charSequence, new String[]{","}, false, 0, 6, (Object) null)));
        } else {
            StringBuilder sb = new StringBuilder();
            String thoroughfare = address2.getThoroughfare();
            if (thoroughfare == null) {
                thoroughfare = str;
            }
            sb.append(thoroughfare);
            String subThoroughfare = address2.getSubThoroughfare();
            if (subThoroughfare == null) {
                subThoroughfare = str;
            }
            sb.append(subThoroughfare);
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                this.shortAddress.postValue(sb2);
            } else {
                this.shortAddress.postValue(addressLine);
            }
        }
        MutableLiveData<String> mutableLiveData = this.city;
        String locality = address2.getLocality();
        if (locality != null) {
            str = locality;
        }
        mutableLiveData.postValue(str);
        CharSequence value = this.city.getValue();
        if (value == null || value.length() == 0) {
            fetchCity();
        }
    }

    /* access modifiers changed from: private */
    public final void fetchCity() {
        Double d = this.lat;
        if (d != null) {
            double doubleValue = d.doubleValue();
            Double d2 = this.lng;
            if (d2 != null) {
                double doubleValue2 = d2.doubleValue();
                if (Build.VERSION.SDK_INT >= 33) {
                    this.geocoder.getFromLocation(doubleValue, doubleValue2, 10, new CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda3(this));
                    return;
                }
                double d3 = doubleValue;
                CoroutineScope coroutineScope = this;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CreateUpdateWelcomeHomeViewModel$fetchCity$2(this, d3, doubleValue2, (Continuation<? super CreateUpdateWelcomeHomeViewModel$fetchCity$2>) null), 3, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void fetchCity$lambda$4(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, List list) {
        Intrinsics.checkNotNullParameter(list, "addressList");
        createUpdateWelcomeHomeViewModel.extractCity(list);
    }

    /* access modifiers changed from: private */
    public final void extractCity(List<? extends Address> list) {
        for (Address locality : list) {
            String locality2 = locality.getLocality();
            if (locality2 != null && locality2.length() > 0) {
                this.city.postValue(locality2);
                return;
            }
        }
        this.city.postValue("");
    }

    public final void setCustomPlace(CustomPlace customPlace) {
        Intrinsics.checkNotNullParameter(customPlace, SearchActivity.SEARCH_REQUEST_KEY);
        MutableLiveData<String> mutableLiveData = this.address;
        String address2 = customPlace.getAddress();
        String str = "";
        if (address2 == null) {
            address2 = str;
        }
        mutableLiveData.setValue(address2);
        MutableLiveData<String> mutableLiveData2 = this.shortAddress;
        String shortAddress2 = customPlace.getShortAddress();
        if (shortAddress2 != null) {
            str = shortAddress2;
        }
        mutableLiveData2.setValue(str);
        setLat(Double.valueOf(customPlace.getLat()));
        setLng(Double.valueOf(customPlace.getLng()));
        fetchCity();
    }

    public final void setTrackedLocation(TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        MutableLiveData<String> mutableLiveData = this.address;
        mutableLiveData.setValue(trackedLocation.getLocationName() + ". " + trackedLocation.getCityName() + ". " + trackedLocation.getCountryName());
        this.shortAddress.setValue(String.valueOf(trackedLocation.getLocationName()));
        setLat(Double.valueOf(trackedLocation.getLat()));
        setLng(Double.valueOf(trackedLocation.getLon()));
        MutableLiveData<String> mutableLiveData2 = this.city;
        String cityName = trackedLocation.getCityName();
        if (cityName == null) {
            cityName = "";
        }
        mutableLiveData2.setValue(cityName);
    }
}
