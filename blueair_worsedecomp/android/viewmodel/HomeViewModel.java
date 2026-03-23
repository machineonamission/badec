package com.blueair.android.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaServer;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.auth.LogoutReason;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.Device;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SkuConfigurationData;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010A\u001a\u00020+2\b\u0010B\u001a\u0004\u0018\u0001092\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0002\u0010EJ'\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020H2\b\u0010B\u001a\u0004\u0018\u0001092\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0002\u0010IJ\u0006\u0010w\u001a\u00020VJ\u0006\u0010x\u001a\u00020'J\u0006\u0010y\u001a\u00020OJ\u000e\u0010z\u001a\u00020VH@¢\u0006\u0002\u0010{J\u0006\u0010|\u001a\u00020VJ\u0016\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0=2\u0006\u0010~\u001a\u00020OJ\b\u0010\u001a\u00020VH\u0002J\t\u0010\u0001\u001a\u00020VH\u0002J\u0007\u0010\u0001\u001a\u00020VJ\u0007\u0010\u0001\u001a\u00020VJ\u0007\u0010\u0001\u001a\u00020VJ\u0007\u0010\u0001\u001a\u00020VJ\u0007\u0010\u0001\u001a\u00020VJ%\u0010\u0001\u001a\u00020V2\u001c\u0010\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020V0\u0001J\u0007\u0010\u0001\u001a\u00020VJ\u001d\u0010\u0001\u001a\u00020V2\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020V0\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010*\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010+0+0&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001f\u00103\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010+0+0&¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R)\u00105\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002090807068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>070=¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020'0K¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010LR!\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N8BX\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020O0X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020V068F¢\u0006\u0006\u001a\u0004\b\\\u0010;R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020'0^¢\u0006\b\n\u0000\u001a\u0004\b]\u0010_R\u0011\u0010`\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bb\u0010aR\u0011\u0010c\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bc\u0010aR\u0011\u0010d\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bd\u0010aR\u0011\u0010e\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\be\u0010aR\u0011\u0010f\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bf\u0010aR\u0011\u0010g\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bg\u0010aR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020'06¢\u0006\b\n\u0000\u001a\u0004\bi\u0010;R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020'06¢\u0006\b\n\u0000\u001a\u0004\bj\u0010;R\u001f\u0010k\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&¢\u0006\b\n\u0000\u001a\u0004\bk\u0010-R\u001f\u0010l\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&¢\u0006\b\n\u0000\u001a\u0004\bm\u0010-R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\bo\u0010-R\u001c\u0010p\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\br\u0010-R\u001c\u0010s\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010t\u001a\b\u0012\u0004\u0012\u00020'0=¢\u0006\b\n\u0000\u001a\u0004\bu\u0010@R\u0011\u0010v\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bv\u0010a¨\u0006\u0001"}, d2 = {"Lcom/blueair/android/viewmodel/HomeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "logoutService", "Lcom/blueair/auth/LogOutService;", "getLogoutService", "()Lcom/blueair/auth/LogOutService;", "logoutService$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "loadingDeviceList", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "loadingLocations", "deviceNum", "", "getDeviceNum", "()Landroidx/lifecycle/MutableLiveData;", "lastRatingIndex", "getLastRatingIndex", "()I", "setLastRatingIndex", "(I)V", "lvAirStateStringRes", "getLvAirStateStringRes", "flowDevicesRating", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "", "getFlowDevicesRating", "()Lkotlinx/coroutines/flow/Flow;", "liveDevices", "Landroidx/lifecycle/LiveData;", "Lcom/blueair/core/model/Device;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "computeHumRatingIndex", "sensorValue", "airRatingRanges", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "(Ljava/lang/Float;Lcom/blueair/core/util/IndoorAirRatingRanges;)I", "computeRatingValue", "sensorType", "Lcom/blueair/core/model/SensorType;", "(Lcom/blueair/core/model/SensorType;Ljava/lang/Float;Lcom/blueair/core/util/IndoorAirRatingRanges;)F", "isLoading", "Landroidx/lifecycle/MediatorLiveData;", "()Landroidx/lifecycle/MediatorLiveData;", "userAblRegionPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getUserAblRegionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "userAblRegionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "userAblRegionFetchErrorChannel", "Lkotlinx/coroutines/channels/Channel;", "", "userAblRegionObserver", "Lio/reactivex/Observable;", "getUserAblRegionObserver", "()Lio/reactivex/Observable;", "userAblRegionFetchErrorFlow", "getUserAblRegionFetchErrorFlow", "isUserSignedIn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isInTmallRegion", "()Z", "isInAlexaRegion", "isInGoogleAssistantRegion", "isInB4Region", "isInG4Region", "isInG4ProtectRegion", "isInAntiFakeRegion", "smartIntegrationsAvailable", "getSmartIntegrationsAvailable", "isWarrantyAvailable", "isTempCelsius", "settingsLoading", "getSettingsLoading", "googleLinked", "getGoogleLinked", "fetchingGoogleLinked", "alexaLinked", "getAlexaLinked", "fetchingAlexaLinked", "fetchingSmartIntegrationStatus", "getFetchingSmartIntegrationStatus", "isAppVersionSupported", "logout", "shouldShowIcpNo", "getCountry", "fetchAblGranularRegion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSwipeToRefresh", "getDevice", "deviceId", "refreshDeviceList", "refreshTrackedLocationList", "toggleIsTempCelsius", "getTemperatureSettings", "getGoogleLinkStatus", "getAlexaLinkStatus", "updateTimezoneList", "updateSkuConfiguration", "onComplete", "Lkotlin/Function1;", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/SkuConfigurationData;", "checkUserInfoCollections", "checkChinaPrivacyUpdate", "onResult", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HomeViewModel.kt */
public final class HomeViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private final MutableLiveData<Boolean> alexaLinked;
    private final Application app;
    private final Lazy authService$delegate;
    private final MutableLiveData<Integer> deviceNum = new MutableLiveData<>(0);
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> fetchingAlexaLinked;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> fetchingGoogleLinked;
    private final LiveData<Boolean> fetchingSmartIntegrationStatus;
    private final Lazy gigyaService$delegate;
    private final MutableLiveData<Boolean> googleLinked;
    private final boolean isAppVersionSupported;
    private final MediatorLiveData<Boolean> isLoading;
    private final MutableLiveData<Boolean> isTempCelsius;
    private final StateFlow<Boolean> isUserSignedIn;
    private final Flow<Boolean> isWarrantyAvailable;
    private int lastRatingIndex = -1;
    private final LiveData<List<Device>> liveDevices = getDeviceManager().getLiveDevices();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> loadingDeviceList;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> loadingLocations;
    private final Lazy locationService$delegate;
    private final Lazy logoutService$delegate;
    private final MutableLiveData<Integer> lvAirStateStringRes = new MutableLiveData<>(Integer.valueOf(R.string.state_no_readings));
    private final Lazy outdoorService$delegate;
    private final Lazy prefs$delegate;
    private final MutableLiveData<Boolean> settingsLoading;
    private final Flow<Boolean> smartIntegrationsAvailable;
    private final Channel<Unit> userAblRegionFetchErrorChannel;
    private final LazyPublishSubject userAblRegionPublisher$delegate;

    static {
        Class<HomeViewModel> cls = HomeViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "logoutService", "getLogoutService()Lcom/blueair/auth/LogOutService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "userAblRegionPublisher", "getUserAblRegionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        this.app = application;
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new HomeViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, LogOutService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        boolean z = false;
        this.logoutService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new HomeViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new HomeViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.gigyaService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, GigyaService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new HomeViewModel$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new HomeViewModel$special$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[4]);
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new HomeViewModel$special$$inlined$instance$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.outdoorService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken6, OutdoorService.class), (Object) null).provideDelegate(this, kPropertyArr[5]);
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this.loadingDeviceList = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this.loadingLocations = mutableLiveData2;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(mutableLiveData, new HomeViewModel$sam$androidx_lifecycle_Observer$0(new HomeViewModel$$ExternalSyntheticLambda0(mediatorLiveData, this)));
        mediatorLiveData.addSource(mutableLiveData2, new HomeViewModel$sam$androidx_lifecycle_Observer$0(new HomeViewModel$$ExternalSyntheticLambda1(mediatorLiveData, this)));
        this.isLoading = mediatorLiveData;
        this.userAblRegionPublisher$delegate = new LazyPublishSubject();
        this.userAblRegionFetchErrorChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.isUserSignedIn = getAuthService().isUserLoggedIn();
        this.smartIntegrationsAvailable = new HomeViewModel$special$$inlined$map$1(getAuthService().isUserLoggedIn(), this);
        this.isWarrantyAvailable = new HomeViewModel$special$$inlined$map$2(getAuthService().isUserLoggedIn(), this);
        this.isTempCelsius = new MutableLiveData<>(Boolean.valueOf(getPrefs().isTempCelsius()));
        this.settingsLoading = new MutableLiveData<>(false);
        this.googleLinked = new MutableLiveData<>(null);
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this.fetchingGoogleLinked = mutableLiveData3;
        this.alexaLinked = new MutableLiveData<>(null);
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(false);
        this.fetchingAlexaLinked = mutableLiveData4;
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        mediatorLiveData2.setValue(false);
        mediatorLiveData2.addSource(mutableLiveData3, new HomeViewModel$sam$androidx_lifecycle_Observer$0(new HomeViewModel$$ExternalSyntheticLambda2(mediatorLiveData2, this)));
        mediatorLiveData2.addSource(mutableLiveData4, new HomeViewModel$sam$androidx_lifecycle_Observer$0(new HomeViewModel$$ExternalSyntheticLambda3(mediatorLiveData2, this)));
        this.fetchingSmartIntegrationStatus = mediatorLiveData2;
        this.isAppVersionSupported = 2272 >= getLocationService().getRemoteConfig().getMinSupportedVersion() ? true : z;
    }

    private final LogOutService getLogoutService() {
        return (LogOutService) this.logoutService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final GigyaService getGigyaService() {
        return (GigyaService) this.gigyaService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    public final MutableLiveData<Integer> getDeviceNum() {
        return this.deviceNum;
    }

    public final int getLastRatingIndex() {
        return this.lastRatingIndex;
    }

    public final void setLastRatingIndex(int i) {
        this.lastRatingIndex = i;
    }

    public final MutableLiveData<Integer> getLvAirStateStringRes() {
        return this.lvAirStateStringRes;
    }

    public final Flow<List<Pair<Integer, Float>>> getFlowDevicesRating() {
        return FlowKt.flowCombine(getDeviceManager().getFlowDevices(), getDeviceManager().getFlowLatestDevicesDatapoints(), new HomeViewModel$flowDevicesRating$1(this, (Continuation<? super HomeViewModel$flowDevicesRating$1>) null));
    }

    public final LiveData<List<Device>> getLiveDevices() {
        return this.liveDevices;
    }

    /* access modifiers changed from: private */
    public final int computeHumRatingIndex(Float f, IndoorAirRatingRanges indoorAirRatingRanges) {
        IndoorAirRatingRanges.IndoorAirRating rating;
        if (f == null || (rating = indoorAirRatingRanges.rating((double) f.floatValue(), SensorType.HUM)) == null) {
            return -1;
        }
        return rating.getRating();
    }

    /* access modifiers changed from: private */
    public final float computeRatingValue(SensorType sensorType, Float f, IndoorAirRatingRanges indoorAirRatingRanges) {
        if (f == null) {
            return -1.0f;
        }
        return indoorAirRatingRanges.ratingValue(f.floatValue(), sensorType);
    }

    public final MediatorLiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    /* access modifiers changed from: private */
    public static final Unit isLoading$lambda$2$lambda$0(MediatorLiveData mediatorLiveData, HomeViewModel homeViewModel, Boolean bool) {
        boolean z = false;
        if (bool.booleanValue()) {
            Boolean value = homeViewModel.loadingLocations.getValue();
            if (value != null ? value.booleanValue() : false) {
                z = true;
            }
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit isLoading$lambda$2$lambda$1(MediatorLiveData mediatorLiveData, HomeViewModel homeViewModel, Boolean bool) {
        boolean z = false;
        if (bool.booleanValue()) {
            Boolean value = homeViewModel.loadingDeviceList.getValue();
            if (value != null ? value.booleanValue() : false) {
                z = true;
            }
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    private final PublishSubject<String> getUserAblRegionPublisher() {
        return this.userAblRegionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[6]);
    }

    public final Observable<String> getUserAblRegionObserver() {
        Observable<String> hide = getUserAblRegionPublisher().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    public final Flow<Unit> getUserAblRegionFetchErrorFlow() {
        return FlowKt.receiveAsFlow(this.userAblRegionFetchErrorChannel);
    }

    public final StateFlow<Boolean> isUserSignedIn() {
        return this.isUserSignedIn;
    }

    public final boolean isInTmallRegion() {
        return getLocationService().isInTmallRegion() || ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), PrefKeys.KEY_FORCE_TMALL_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final boolean isInAlexaRegion() {
        return getLocationService().isInAlexaRegion() || ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), PrefKeys.KEY_FORCE_ALEXA_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final boolean isInGoogleAssistantRegion() {
        return getLocationService().isInGoogleAssistantRegion() || ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), PrefKeys.KEY_FORCE_GASSISTANT_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final boolean isInB4Region() {
        return getLocationService().isInB4Region();
    }

    public final boolean isInG4Region() {
        return getLocationService().isInG4Region();
    }

    public final boolean isInG4ProtectRegion() {
        return getLocationService().isInG4ProtectRegion();
    }

    public final boolean isInAntiFakeRegion() {
        return getLocationService().isInAntiFakeRegion();
    }

    public final Flow<Boolean> getSmartIntegrationsAvailable() {
        return this.smartIntegrationsAvailable;
    }

    public final Flow<Boolean> isWarrantyAvailable() {
        return this.isWarrantyAvailable;
    }

    public final MutableLiveData<Boolean> isTempCelsius() {
        return this.isTempCelsius;
    }

    public final MutableLiveData<Boolean> getSettingsLoading() {
        return this.settingsLoading;
    }

    public final MutableLiveData<Boolean> getGoogleLinked() {
        return this.googleLinked;
    }

    public final MutableLiveData<Boolean> getAlexaLinked() {
        return this.alexaLinked;
    }

    public final LiveData<Boolean> getFetchingSmartIntegrationStatus() {
        return this.fetchingSmartIntegrationStatus;
    }

    /* access modifiers changed from: private */
    public static final Unit fetchingSmartIntegrationStatus$lambda$7$lambda$5(MediatorLiveData mediatorLiveData, HomeViewModel homeViewModel, Boolean bool) {
        boolean z = true;
        if (!bool.booleanValue() && !Intrinsics.areEqual((Object) homeViewModel.fetchingAlexaLinked.getValue(), (Object) true)) {
            z = false;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit fetchingSmartIntegrationStatus$lambda$7$lambda$6(MediatorLiveData mediatorLiveData, HomeViewModel homeViewModel, Boolean bool) {
        boolean z = true;
        if (!bool.booleanValue() && !Intrinsics.areEqual((Object) homeViewModel.fetchingGoogleLinked.getValue(), (Object) true)) {
            z = false;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    public final boolean isAppVersionSupported() {
        return this.isAppVersionSupported;
    }

    public final void logout() {
        getLogoutService().logOutRegistered(LogoutReason.USER_LOGOUT);
    }

    public final boolean shouldShowIcpNo() {
        if (this.isUserSignedIn.getValue().booleanValue()) {
            return Intrinsics.areEqual((Object) getAuthService().getCloudUserRegion(), (Object) "cn");
        }
        String deviceRegion = getLocationService().getDeviceRegion();
        String country = Locale.CHINA.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        String lowerCase = country.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual((Object) deviceRegion, (Object) lowerCase);
    }

    public final String getCountry() {
        return getLocationService().getCountry();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r6 == r1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (r2.send(r4, r0) == r1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchAblGranularRegion(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.android.viewmodel.HomeViewModel$fetchAblGranularRegion$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.android.viewmodel.HomeViewModel$fetchAblGranularRegion$1 r0 = (com.blueair.android.viewmodel.HomeViewModel$fetchAblGranularRegion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.android.viewmodel.HomeViewModel$fetchAblGranularRegion$1 r0 = new com.blueair.android.viewmodel.HomeViewModel$fetchAblGranularRegion$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006e
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.auth.AuthService r6 = r5.getAuthService()
            r0.label = r4
            java.lang.Object r6 = r6.fetchAblGranularRegion(r0)
            if (r6 != r1) goto L_0x004d
            goto L_0x006d
        L_0x004d:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x005b
            io.reactivex.subjects.PublishSubject r0 = r5.getUserAblRegionPublisher()
            r0.onNext(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x005b:
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r5.userAblRegionFetchErrorChannel
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.send(r4, r0)
            if (r6 != r1) goto L_0x006e
        L_0x006d:
            return r1
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel.fetchAblGranularRegion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onSwipeToRefresh() {
        refreshDeviceList();
        refreshTrackedLocationList();
    }

    public final LiveData<Device> getDevice(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return getDeviceManager().databaseDevice(str);
    }

    private final void refreshDeviceList() {
        if (getAuthService().isUserLoggedIn().getValue().booleanValue()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$refreshDeviceList$1(this, (Continuation<? super HomeViewModel$refreshDeviceList$1>) null), 2, (Object) null);
        }
    }

    private final void refreshTrackedLocationList() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$refreshTrackedLocationList$1(this, (Continuation<? super HomeViewModel$refreshTrackedLocationList$1>) null), 2, (Object) null);
    }

    public final void toggleIsTempCelsius() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$toggleIsTempCelsius$1(this, (Continuation<? super HomeViewModel$toggleIsTempCelsius$1>) null), 2, (Object) null);
    }

    public final void getTemperatureSettings() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new HomeViewModel$getTemperatureSettings$1(this, (Continuation<? super HomeViewModel$getTemperatureSettings$1>) null), 3, (Object) null);
    }

    public final void getGoogleLinkStatus() {
        if (!Intrinsics.areEqual((Object) this.fetchingGoogleLinked.getValue(), (Object) true)) {
            this.fetchingGoogleLinked.setValue(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$getGoogleLinkStatus$1(this, (Continuation<? super HomeViewModel$getGoogleLinkStatus$1>) null), 2, (Object) null);
        }
    }

    public final void getAlexaLinkStatus() {
        if (!Intrinsics.areEqual((Object) this.fetchingAlexaLinked.getValue(), (Object) true)) {
            this.fetchingAlexaLinked.setValue(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$getAlexaLinkStatus$1(this, (Continuation<? super HomeViewModel$getAlexaLinkStatus$1>) null), 2, (Object) null);
        }
    }

    public final void updateTimezoneList() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$updateTimezoneList$1(this, (Continuation<? super HomeViewModel$updateTimezoneList$1>) null), 2, (Object) null);
    }

    public final void updateSkuConfiguration(Function1<? super ApiResult<SkuConfigurationData>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$updateSkuConfiguration$1(this, function1, (Continuation<? super HomeViewModel$updateSkuConfiguration$1>) null), 2, (Object) null);
    }

    public final void checkUserInfoCollections() {
        if (UserInfoCollectionsManager.INSTANCE.getEnabled()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$checkUserInfoCollections$1(this, (Continuation<? super HomeViewModel$checkUserInfoCollections$1>) null), 2, (Object) null);
        }
    }

    public final void checkChinaPrivacyUpdate(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        if (BuildEnvironment.INSTANCE.isChina() && Intrinsics.areEqual((Object) getGigyaService().getGigyaDataCenter(), (Object) GigyaServer.CHINA.INSTANCE.getCountryCode())) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new HomeViewModel$checkChinaPrivacyUpdate$1(this, function1, (Continuation<? super HomeViewModel$checkChinaPrivacyUpdate$1>) null), 2, (Object) null);
        }
    }
}
