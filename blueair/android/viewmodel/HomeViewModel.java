package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaServer;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.auth.LogoutReason;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SkuConfigurationData;
import com.blueair.core.model.UserInfoCollections;
import com.blueair.core.model.UserInfoExtras;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.core.util.TimezoneNames;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import okhttp3.ResponseBody;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010A\u001a\u00020+2\b\u0010B\u001a\u0004\u0018\u0001092\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0002\u0010EJ'\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020H2\b\u0010B\u001a\u0004\u0018\u0001092\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0002\u0010IJ\u0006\u0010z\u001a\u00020VJ\u0006\u0010{\u001a\u00020'J\u0006\u0010|\u001a\u00020OJ\u000e\u0010}\u001a\u00020VH\u0086@¢\u0006\u0002\u0010~J\u0006\u0010\u007f\u001a\u00020VJ\u0018\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0=2\u0007\u0010\u0081\u0001\u001a\u00020OJ\t\u0010\u0082\u0001\u001a\u00020VH\u0002J\t\u0010\u0083\u0001\u001a\u00020VH\u0002J\u0007\u0010\u0084\u0001\u001a\u00020VJ\u0007\u0010\u0085\u0001\u001a\u00020VJ\u0007\u0010\u0086\u0001\u001a\u00020VJ\u0007\u0010\u0087\u0001\u001a\u00020VJ\u0007\u0010\u0088\u0001\u001a\u00020VJ%\u0010\u0089\u0001\u001a\u00020V2\u001c\u0010\u008a\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001\u0012\u0004\u0012\u00020V0\u008b\u0001J\u0007\u0010\u008e\u0001\u001a\u00020VJ\u001d\u0010\u008f\u0001\u001a\u00020V2\u0014\u0010\u0090\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020V0\u008b\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010*\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010+0+0&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001f\u00103\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010+0+0&¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R)\u00105\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002090807068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>070=¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020'0K¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010LR!\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020O0X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020V068F¢\u0006\u0006\u001a\u0004\b\\\u0010;R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020'0^¢\u0006\b\n\u0000\u001a\u0004\b]\u0010_R\u0011\u0010`\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010c\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\be\u0010dR\u0011\u0010f\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0011\u0010g\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bg\u0010dR\u0011\u0010h\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bh\u0010dR\u0011\u0010i\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bi\u0010dR\u0011\u0010j\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bj\u0010dR\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020'06¢\u0006\b\n\u0000\u001a\u0004\bl\u0010;R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020'06¢\u0006\b\n\u0000\u001a\u0004\bm\u0010;R\u001f\u0010n\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&¢\u0006\b\n\u0000\u001a\u0004\bn\u0010-R\u001f\u0010o\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&¢\u0006\b\n\u0000\u001a\u0004\bp\u0010-R\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\br\u0010-R\u001c\u0010s\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010t\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\bu\u0010-R\u001c\u0010v\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020'0=¢\u0006\b\n\u0000\u001a\u0004\bx\u0010@R\u0011\u0010y\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\by\u0010d¨\u0006\u0091\u0001"},
   d2 = {"Lcom/blueair/android/viewmodel/HomeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "logoutService", "Lcom/blueair/auth/LogOutService;", "getLogoutService", "()Lcom/blueair/auth/LogOutService;", "logoutService$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "loadingDeviceList", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "loadingLocations", "deviceNum", "", "getDeviceNum", "()Landroidx/lifecycle/MutableLiveData;", "lastRatingIndex", "getLastRatingIndex", "()I", "setLastRatingIndex", "(I)V", "lvAirStateStringRes", "getLvAirStateStringRes", "flowDevicesRating", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "", "getFlowDevicesRating", "()Lkotlinx/coroutines/flow/Flow;", "liveDevices", "Landroidx/lifecycle/LiveData;", "Lcom/blueair/core/model/Device;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "computeHumRatingIndex", "sensorValue", "airRatingRanges", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "(Ljava/lang/Float;Lcom/blueair/core/util/IndoorAirRatingRanges;)I", "computeRatingValue", "sensorType", "Lcom/blueair/core/model/SensorType;", "(Lcom/blueair/core/model/SensorType;Ljava/lang/Float;Lcom/blueair/core/util/IndoorAirRatingRanges;)F", "isLoading", "Landroidx/lifecycle/MediatorLiveData;", "()Landroidx/lifecycle/MediatorLiveData;", "userAblRegionPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getUserAblRegionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "userAblRegionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "userAblRegionFetchErrorChannel", "Lkotlinx/coroutines/channels/Channel;", "", "userAblRegionObserver", "Lio/reactivex/Observable;", "getUserAblRegionObserver", "()Lio/reactivex/Observable;", "userAblRegionFetchErrorFlow", "getUserAblRegionFetchErrorFlow", "isUserSignedIn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "userEmail", "getUserEmail", "()Ljava/lang/String;", "isInTmallRegion", "()Z", "isInAlexaRegion", "isInGoogleAssistantRegion", "isInB4Region", "isInG4Region", "isInG4ProtectRegion", "isInAntiFakeRegion", "smartIntegrationsAvailable", "getSmartIntegrationsAvailable", "isWarrantyAvailable", "isTempCelsius", "settingsLoading", "getSettingsLoading", "googleLinked", "getGoogleLinked", "fetchingGoogleLinked", "alexaLinked", "getAlexaLinked", "fetchingAlexaLinked", "fetchingSmartIntegrationStatus", "getFetchingSmartIntegrationStatus", "isAppVersionSupported", "logout", "shouldShowIcpNo", "getCountry", "fetchAblGranularRegion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSwipeToRefresh", "getDevice", "deviceId", "refreshDeviceList", "refreshTrackedLocationList", "toggleIsTempCelsius", "getTemperatureSettings", "getGoogleLinkStatus", "getAlexaLinkStatus", "updateTimezoneList", "updateSkuConfiguration", "onComplete", "Lkotlin/Function1;", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/SkuConfigurationData;", "checkUserInfoCollections", "checkChinaPrivacyUpdate", "onResult", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class HomeViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "logoutService", "getLogoutService()Lcom/blueair/auth/LogOutService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeViewModel.class, "userAblRegionPublisher", "getUserAblRegionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final int $stable = 8;
   private final MutableLiveData alexaLinked;
   private final Application app;
   private final Lazy authService$delegate;
   private final MutableLiveData deviceNum;
   private final MutableLiveData fetchingAlexaLinked;
   private final MutableLiveData fetchingGoogleLinked;
   private final LiveData fetchingSmartIntegrationStatus;
   private final Lazy gigyaService$delegate;
   private final MutableLiveData googleLinked;
   private final boolean isAppVersionSupported;
   private final MediatorLiveData isLoading;
   private final MutableLiveData isTempCelsius;
   private final StateFlow isUserSignedIn;
   private final Flow isWarrantyAvailable;
   private int lastRatingIndex;
   private final LiveData liveDevices;
   private final MutableLiveData loadingDeviceList;
   private final MutableLiveData loadingLocations;
   private final Lazy locationService$delegate;
   private final Lazy logoutService$delegate;
   private final MutableLiveData lvAirStateStringRes;
   private final Lazy outdoorService$delegate;
   private final Lazy prefs$delegate;
   private final MutableLiveData settingsLoading;
   private final Flow smartIntegrationsAvailable;
   private final Channel userAblRegionFetchErrorChannel;
   private final LazyPublishSubject userAblRegionPublisher$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$3zWhPUgse3F17_R7gn0LPkyhnV0(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      return fetchingSmartIntegrationStatus$lambda$7$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WKg_qph6HW2UNa5B8aWwkxarQUM/* $FF was: $r8$lambda$WKg-qph6HW2UNa5B8aWwkxarQUM*/(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      return isLoading$lambda$2$lambda$1(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$seDzjjeUzBUy4pgotxIJu7SoURE(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      return isLoading$lambda$2$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xUZA3CvIUrDGbyCBc3240wQpZq0(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      return fetchingSmartIntegrationStatus$lambda$7$lambda$5(var0, var1, var2);
   }

   public HomeViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      this.app = var1;
      DIAware var3 = this;
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var5 = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LogOutService.class)), (Object)null);
      KProperty[] var4 = $$delegatedProperties;
      boolean var2 = false;
      Boolean var7 = false;
      this.logoutService$delegate = var5.provideDelegate(this, var4[0]);
      JVMTypeToken var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, AuthService.class)), (Object)null).provideDelegate(this, var4[1]);
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.gigyaService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, GigyaService.class)), (Object)null).provideDelegate(this, var4[2]);
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, LocationService.class)), (Object)null).provideDelegate(this, var4[3]);
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var4[4]);
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.outdoorService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, OutdoorService.class)), (Object)null).provideDelegate(this, var4[5]);
      MutableLiveData var8 = new MutableLiveData(var7);
      this.loadingDeviceList = var8;
      MutableLiveData var17 = new MutableLiveData(var7);
      this.loadingLocations = var17;
      this.deviceNum = new MutableLiveData(0);
      this.lastRatingIndex = -1;
      this.lvAirStateStringRes = new MutableLiveData(R.string.state_no_readings);
      this.liveDevices = this.getDeviceManager().getLiveDevices();
      MediatorLiveData var10 = new MediatorLiveData();
      var10.addSource((LiveData)var8, new Observer(new HomeViewModel$$ExternalSyntheticLambda0(var10, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      var10.addSource((LiveData)var17, new Observer(new HomeViewModel$$ExternalSyntheticLambda1(var10, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.isLoading = var10;
      this.userAblRegionPublisher$delegate = new LazyPublishSubject();
      this.userAblRegionFetchErrorChannel = ChannelKt.Channel$default(-1, (BufferOverflow)null, (Function1)null, 6, (Object)null);
      this.isUserSignedIn = this.getAuthService().isUserLoggedIn();
      this.smartIntegrationsAvailable = new Flow((Flow)this.getAuthService().isUserLoggedIn(), this) {
         final Flow $this_unsafeTransform$inlined;
         final HomeViewModel this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final HomeViewModel this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label45: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var5 = (<undefinedtype>)var2;
                        if ((var5.label & Integer.MIN_VALUE) != 0) {
                           var5.label += Integer.MIN_VALUE;
                           var12 = var5;
                           break label45;
                        }
                     }

                     var12 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var14 = ((<undefinedtype>)var12).result;
                  Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var12).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var12).I$0;
                     FlowCollector var8 = (FlowCollector)((<undefinedtype>)var12).L$3;
                     Object var9 = ((<undefinedtype>)var12).L$2;
                     <undefinedtype> var10 = (<undefinedtype>)((<undefinedtype>)var12).L$1;
                     Object var11 = ((<undefinedtype>)var12).L$0;
                     ResultKt.throwOnFailure(var14);
                  } else {
                     ResultKt.throwOnFailure(var14);
                     FlowCollector var15 = this.$this_unsafeFlow;
                     Continuation var7 = (Continuation)var12;
                     boolean var4;
                     if (!(Boolean)var1 || (!this.this$0.isInTmallRegion() || !this.this$0.isInG4Region() && !this.this$0.isInB4Region()) && !this.this$0.isInAlexaRegion() && !this.this$0.isInGoogleAssistantRegion()) {
                        var4 = false;
                     } else {
                        var4 = true;
                     }

                     Boolean var16 = Boxing.boxBoolean(var4);
                     ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var12);
                     ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var15);
                     ((<undefinedtype>)var12).I$0 = 0;
                     ((<undefinedtype>)var12).label = 1;
                     if (var15.emit(var16, (Continuation)var12) == var6) {
                        return var6;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
      this.isWarrantyAvailable = new Flow((Flow)this.getAuthService().isUserLoggedIn(), this) {
         final Flow $this_unsafeTransform$inlined;
         final HomeViewModel this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final HomeViewModel this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label32: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var5 = (<undefinedtype>)var2;
                        if ((var5.label & Integer.MIN_VALUE) != 0) {
                           var5.label += Integer.MIN_VALUE;
                           var12 = var5;
                           break label32;
                        }
                     }

                     var12 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var14 = ((<undefinedtype>)var12).result;
                  Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var12).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var12).I$0;
                     FlowCollector var8 = (FlowCollector)((<undefinedtype>)var12).L$3;
                     Object var9 = ((<undefinedtype>)var12).L$2;
                     <undefinedtype> var10 = (<undefinedtype>)((<undefinedtype>)var12).L$1;
                     Object var11 = ((<undefinedtype>)var12).L$0;
                     ResultKt.throwOnFailure(var14);
                  } else {
                     ResultKt.throwOnFailure(var14);
                     FlowCollector var15 = this.$this_unsafeFlow;
                     Continuation var7 = (Continuation)var12;
                     boolean var4;
                     if ((Boolean)var1 && this.this$0.getLocationService().isInWarrantyRegion()) {
                        var4 = true;
                     } else {
                        var4 = false;
                     }

                     Boolean var16 = Boxing.boxBoolean(var4);
                     ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var12);
                     ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var15);
                     ((<undefinedtype>)var12).I$0 = 0;
                     ((<undefinedtype>)var12).label = 1;
                     if (var15.emit(var16, (Continuation)var12) == var6) {
                        return var6;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
      this.isTempCelsius = new MutableLiveData(this.getPrefs().isTempCelsius());
      this.settingsLoading = new MutableLiveData(var7);
      this.googleLinked = new MutableLiveData((Object)null);
      var17 = new MutableLiveData(var7);
      this.fetchingGoogleLinked = var17;
      this.alexaLinked = new MutableLiveData((Object)null);
      var8 = new MutableLiveData(var7);
      this.fetchingAlexaLinked = var8;
      var10 = new MediatorLiveData();
      var10.setValue(var7);
      var10.addSource((LiveData)var17, new Observer(new HomeViewModel$$ExternalSyntheticLambda2(var10, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      var10.addSource((LiveData)var8, new Observer(new HomeViewModel$$ExternalSyntheticLambda3(var10, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.fetchingSmartIntegrationStatus = (LiveData)var10;
      if (2366L >= this.getLocationService().getRemoteConfig().getMinSupportedVersion()) {
         var2 = true;
      }

      this.isAppVersionSupported = var2;
   }

   private final int computeHumRatingIndex(Float var1, IndoorAirRatingRanges var2) {
      if (var1 == null) {
         return -1;
      } else {
         IndoorAirRatingRanges.IndoorAirRating var3 = var2.rating((double)var1, SensorType.HUM);
         return var3 != null ? var3.getRating() : -1;
      }
   }

   private final float computeRatingValue(SensorType var1, Float var2, IndoorAirRatingRanges var3) {
      return var2 == null ? -1.0F : var3.ratingValue(var2, var1);
   }

   private static final Unit fetchingSmartIntegrationStatus$lambda$7$lambda$5(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      boolean var5 = var2;
      boolean var4 = true;
      boolean var3 = var4;
      if (!var5) {
         if (Intrinsics.areEqual(var1.fetchingAlexaLinked.getValue(), true)) {
            var3 = var4;
         } else {
            var3 = false;
         }
      }

      var0.setValue(var3);
      return Unit.INSTANCE;
   }

   private static final Unit fetchingSmartIntegrationStatus$lambda$7$lambda$6(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      boolean var5 = var2;
      boolean var4 = true;
      boolean var3 = var4;
      if (!var5) {
         if (Intrinsics.areEqual(var1.fetchingGoogleLinked.getValue(), true)) {
            var3 = var4;
         } else {
            var3 = false;
         }
      }

      var0.setValue(var3);
      return Unit.INSTANCE;
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final GigyaService getGigyaService() {
      return (GigyaService)this.gigyaService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final LogOutService getLogoutService() {
      return (LogOutService)this.logoutService$delegate.getValue();
   }

   private final OutdoorService getOutdoorService() {
      return (OutdoorService)this.outdoorService$delegate.getValue();
   }

   private final UnsecurePrefs getPrefs() {
      return (UnsecurePrefs)this.prefs$delegate.getValue();
   }

   private final PublishSubject getUserAblRegionPublisher() {
      return this.userAblRegionPublisher$delegate.getValue(this, $$delegatedProperties[6]);
   }

   private static final Unit isLoading$lambda$2$lambda$0(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      boolean var4 = var2;
      boolean var5 = false;
      boolean var3 = var5;
      if (var4) {
         Boolean var6 = (Boolean)var1.loadingLocations.getValue();
         if (var6 != null) {
            var4 = var6;
         } else {
            var4 = false;
         }

         var3 = var5;
         if (var4) {
            var3 = true;
         }
      }

      var0.setValue(var3);
      return Unit.INSTANCE;
   }

   private static final Unit isLoading$lambda$2$lambda$1(MediatorLiveData var0, HomeViewModel var1, Boolean var2) {
      boolean var4 = var2;
      boolean var5 = false;
      boolean var3 = var5;
      if (var4) {
         Boolean var6 = (Boolean)var1.loadingDeviceList.getValue();
         if (var6 != null) {
            var4 = var6;
         } else {
            var4 = false;
         }

         var3 = var5;
         if (var4) {
            var3 = true;
         }
      }

      var0.setValue(var3);
      return Unit.INSTANCE;
   }

   private final void refreshDeviceList() {
      if ((Boolean)this.getAuthService().isUserLoggedIn().getValue()) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final HomeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               label243: {
                  Throwable var10000;
                  label247: {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           try {
                              ResultKt.throwOnFailure(var1);
                              break label243;
                           } catch (Throwable var22) {
                              var10000 = var22;
                              boolean var31 = false;
                              break label247;
                           }
                        }

                        try {
                           ResultKt.throwOnFailure(var1);
                        } catch (Throwable var25) {
                           var10000 = var25;
                           boolean var10001 = false;
                           break label247;
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.loadingDeviceList.postValue(Boxing.boxBoolean(true));

                        try {
                           var1 = DeviceManager.Companion;
                           DeviceManager var4 = this.this$0.getDeviceManager();
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           if (var1.downloadDeviceList(var4, var5) == var3) {
                              return var3;
                           }
                        } catch (Throwable var24) {
                           var10000 = var24;
                           boolean var32 = false;
                           break label247;
                        }
                     }

                     try {
                        var1 = this.this$0.getDeviceManager();
                        Continuation var30 = (Continuation)this;
                        this.label = 2;
                        var1 = var1.restartStomp(var30);
                     } catch (Throwable var23) {
                        var10000 = var23;
                        boolean var33 = false;
                        break label247;
                     }

                     if (var1 == var3) {
                        return var3;
                     }
                     break label243;
                  }

                  Throwable var27 = var10000;
                  this.this$0.loadingDeviceList.postValue(Boxing.boxBoolean(false));
                  throw var27;
               }

               this.this$0.loadingDeviceList.postValue(Boxing.boxBoolean(false));
               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }
   }

   private final void refreshTrackedLocationList() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final HomeViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4;
            label41: {
               label40: {
                  var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              if (var2 != 4) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           }

                           ResultKt.throwOnFailure(var1);
                           break label41;
                        }

                        ResultKt.throwOnFailure(var1);
                        break label40;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     this.this$0.loadingLocations.postValue(Boxing.boxBoolean(true));
                     var1 = this.this$0.getOutdoorService();
                     Continuation var3 = (Continuation)this;
                     this.label = 1;
                     Object var10 = var1.downloadTrackedLocations(var3);
                     var1 = (OutdoorService)var10;
                     if (var10 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var7 = (ApiResult)var1;
                  Function2 var11 = new Function2((Continuation)null) {
                     Object L$0;
                     int label;

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(var2);
                        var3.L$0 = var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(Throwable var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Throwable var2 = (Throwable)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           Timber.Forest var3 = Timber.Forest;
                           StringBuilder var4 = new StringBuilder("downloadTrackedLocationList: fail = ");
                           var4.append(var2);
                           var3.e(var2, var4.toString(), new Object[0]);
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var5 = (Continuation)this;
                  this.label = 2;
                  Object var12 = ApiResultKt.onFail(var7, var11, var5);
                  var1 = (OutdoorService)var12;
                  if (var12 == var4) {
                     return var4;
                  }
               }

               ApiResult var13 = (ApiResult)var1;
               Function2 var16 = new Function2((Continuation)null) {
                  boolean Z$0;
                  int label;

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(var2);
                     var3.Z$0 = (Boolean)var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(boolean var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     boolean var2 = this.Z$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        Timber.Forest var3 = Timber.Forest;
                        StringBuilder var4 = new StringBuilder("downloadTrackedLocationList: success = ");
                        var4.append(var2);
                        var3.d(var4.toString(), new Object[0]);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var8 = (Continuation)this;
               this.label = 3;
               Object var14 = ApiResultKt.onSuccess(var13, var16, var8);
               var1 = (OutdoorService)var14;
               if (var14 == var4) {
                  return var4;
               }
            }

            ApiResult var15 = (ApiResult)var1;
            Function2 var9 = new Function2(this.this$0, (Continuation)null) {
               int label;
               final HomeViewModel this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, var2));
               }

               public final Object invoke(ApiResult var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.this$0.loadingLocations.postValue(Boxing.boxBoolean(false));
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var17 = (Continuation)this;
            this.label = 4;
            if (ApiResultKt.finally(var15, var9, var17) == var4) {
               return var4;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final void checkChinaPrivacyUpdate(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onResult");
      if (BuildEnvironment.INSTANCE.isChina() && Intrinsics.areEqual(this.getGigyaService().getGigyaDataCenter(), GigyaServer.CHINA.INSTANCE.getCountryCode())) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final Function1 $onResult;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            private Object L$0;
            int label;
            final HomeViewModel this$0;

            {
               this.this$0 = var1;
               this.$onResult = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, this.$onResult, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               CoroutineScope var8 = (CoroutineScope)this.L$0;
               Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  int var3 = SkuConfigurationManager.INSTANCE.getChinaPrivacy().getVersion();
                  HomeViewModel var82 = this.this$0;

                  label771: {
                     Throwable var10000;
                     label778: {
                        label769: {
                           try {
                              Result.Companion var6 = Result.Companion;
                              FileInputStream var83 = var82.getApplication().openFileInput("china_privacy_consent_version");
                              Intrinsics.checkNotNullExpressionValue(var83, "openFileInput(...)");
                              InputStream var9 = (InputStream)var83;
                              Charset var96 = Charsets.UTF_8;
                              InputStreamReader var84 = new InputStreamReader(var9, var96);
                              var85 = (Reader)var84;
                              if (var85 instanceof BufferedReader) {
                                 var86 = (BufferedReader)var85;
                                 break label769;
                              }
                           } catch (Throwable var81) {
                              var10000 = var81;
                              boolean var10001 = false;
                              break label778;
                           }

                           try {
                              var86 = new BufferedReader(var85, 8192);
                           } catch (Throwable var80) {
                              var10000 = var80;
                              boolean var109 = false;
                              break label778;
                           }
                        }

                        try {
                           var87 = (Closeable)var86;
                        } catch (Throwable var79) {
                           var10000 = var79;
                           boolean var110 = false;
                           break label778;
                        }

                        String var97;
                        try {
                           var97 = TextStreamsKt.readText((Reader)((BufferedReader)var87));
                        } catch (Throwable var78) {
                           Throwable var106 = var78;

                           try {
                              throw var106;
                           } finally {
                              try {
                                 CloseableKt.closeFinally(var87, var106);
                              } catch (Throwable var75) {
                                 var10000 = var75;
                                 boolean var111 = false;
                                 break label778;
                              }
                           }
                        }

                        label755:
                        try {
                           CloseableKt.closeFinally(var87, (Throwable)null);
                           var89 = Result.constructor-impl(StringsKt.toIntOrNull(var97));
                           break label771;
                        } catch (Throwable var77) {
                           var10000 = var77;
                           boolean var112 = false;
                           break label755;
                        }
                     }

                     Throwable var98 = var10000;
                     Result.Companion var88 = Result.Companion;
                     var89 = Result.constructor-impl(ResultKt.createFailure(var98));
                  }

                  Object var99 = var89;
                  if (Result.isFailure-impl(var89)) {
                     var99 = null;
                  }

                  Integer var90 = (Integer)var99;
                  if (var90 != null) {
                     var2 = var90;
                  } else {
                     var2 = 0;
                  }

                  UserInfoCollectionsManager.INSTANCE.initializeCollections(this.this$0.getAuthService().getUsername(), (Context)this.this$0.getApplication());
                  int var5 = UserInfoCollectionsManager.INSTANCE.getExtras().getChinaPrivacyConsentVersion();
                  if (var2 > var5) {
                     Timber.Forest var91 = Timber.Forest;
                     StringBuilder var100 = new StringBuilder("checkChinaPrivacyUpdate: write localConsentVersion ");
                     var100.append(var2);
                     var100.append(" to remote");
                     var91.d(var100.toString(), new Object[0]);
                     HomeViewModel var92 = this.this$0;

                     label737:
                     try {
                        Result.Companion var102 = Result.Companion;
                        UserInfoCollectionsManager.INSTANCE.setChinaPrivacyConsentVersion(var2);
                        Prefs var107 = var92.getPrefs();
                        Long var103 = Boxing.boxLong(0L);
                        PreferencesHelper.INSTANCE.set(var107.getBackend(), "KEY_USER_INFO_COLLECTIONS_SYNC_TIME", var103, Reflection.getOrCreateKotlinClass(Long.class));
                        var92.checkUserInfoCollections();
                        Result.constructor-impl(Unit.INSTANCE);
                     } catch (Throwable var74) {
                        Result.Companion var101 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(var74));
                        break label737;
                     }
                  }

                  Timber.Forest var93 = Timber.Forest;
                  StringBuilder var104 = new StringBuilder("checkChinaPrivacyUpdate: ");
                  var104.append(var3);
                  var104.append(" | ");
                  var104.append(var2);
                  var104.append(" | ");
                  var104.append(var5);
                  var93.d(var104.toString(), new Object[0]);
                  int var4 = Math.max(var2, var5);
                  CoroutineContext var94 = (CoroutineContext)Dispatchers.getMain();
                  Function2 var105 = new Function2(this.$onResult, var3, var4, (Continuation)null) {
                     final int $consentVersion;
                     final int $latestVersion;
                     final Function1 $onResult;
                     int label;

                     {
                        this.$onResult = var1;
                        this.$latestVersion = var2;
                        this.$consentVersion = var3;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.$onResult, this.$latestVersion, this.$consentVersion, var2));
                     }

                     public final Object invoke(CoroutineScope var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           Function1 var3 = this.$onResult;
                           boolean var2;
                           if (this.$latestVersion > this.$consentVersion) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           var3.invoke(Boxing.boxBoolean(var2));
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var108 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var8);
                  this.I$0 = var3;
                  this.I$1 = var2;
                  this.I$2 = var5;
                  this.I$3 = var4;
                  this.label = 1;
                  if (BuildersKt.withContext(var94, var105, var108) == var7) {
                     return var7;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

   }

   public final void checkUserInfoCollections() {
      if (UserInfoCollectionsManager.INSTANCE.getEnabled()) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            long J$0;
            int label;
            final HomeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               long var4;
               Object var6;
               label35: {
                  var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                           return Unit.INSTANCE;
                        }

                        var4 = this.J$0;
                        ResultKt.throwOnFailure(var1);
                        break label35;
                     }

                     var4 = this.J$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     Timber.Forest.d("checkUserInfoCollections", new Object[0]);
                     Prefs var9 = this.this$0.getPrefs();
                     Long var7 = Boxing.boxLong(0L);
                     var4 = ((Number)PreferencesHelper.INSTANCE.get(var9.getBackend(), "KEY_USER_INFO_COLLECTIONS_SYNC_TIME", var7, Reflection.getOrCreateKotlinClass(Long.class))).longValue();
                     if (System.currentTimeMillis() - var4 <= 604800000L) {
                        return Unit.INSTANCE;
                     }

                     Timber.Forest.d("syncUserInfoCollections", new Object[0]);
                     UserInfoCollectionsManager.INSTANCE.initializeCollections(this.this$0.getAuthService().getUsername(), (Context)this.this$0.getApplication());
                     DeviceManager var10 = this.this$0.getDeviceManager();
                     var2 = UserInfoCollectionsManager.INSTANCE.getVersion();
                     int var3 = UserInfoCollectionsManager.INSTANCE.getSeries();
                     Continuation var14 = (Continuation)this;
                     this.J$0 = var4;
                     this.label = 1;
                     var1 = var10.getUserInfoCollections(var2, var3, var14);
                     if (var1 == var6) {
                        return var6;
                     }
                  }

                  ApiResult var15 = (ApiResult)var1;
                  Function2 var8 = new Function2(this.this$0, (Continuation)null) {
                     int I$0;
                     Object L$0;
                     int label;
                     final HomeViewModel this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                        var3.L$0 = var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(UserInfoCollections var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Object var4;
                        UserInfoCollections var5;
                        int var11;
                        label32: {
                           var5 = (UserInfoCollections)this.L$0;
                           var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           var11 = this.label;
                           if (var11 != 0) {
                              if (var11 != 1) {
                                 if (var11 != 2) {
                                    if (var11 != 3) {
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }

                                    ResultKt.throwOnFailure(var1);
                                    return Unit.INSTANCE;
                                 }

                                 var11 = this.I$0;
                                 ResultKt.throwOnFailure(var1);
                                 break label32;
                              }

                              var11 = this.I$0;
                              ResultKt.throwOnFailure(var1);
                           } else {
                              ResultKt.throwOnFailure(var1);
                              Timber.Forest var3 = Timber.Forest;
                              StringBuilder var7 = new StringBuilder("getUserInfoCollections success: ");
                              var7.append(var5.getSeries());
                              var7.append('-');
                              var7.append(var5.getVersion());
                              var3.d(var7.toString(), new Object[0]);
                              UserInfoCollectionsManager.INSTANCE.update(var5);
                              var11 = UserInfoCollectionsManager.INSTANCE.getVersion() + 1;
                              DeviceManager var6 = this.this$0.getDeviceManager();
                              UserInfoCollections var8 = UserInfoCollections.copy$default(UserInfoCollectionsManager.INSTANCE.toUserInfoCollections(), String.valueOf(var11), (String)null, (UserInfoExtras)null, (List)null, 14, (Object)null);
                              Continuation var12 = (Continuation)this;
                              this.L$0 = var5;
                              this.I$0 = var11;
                              this.label = 1;
                              Object var13 = var6.uploadUserInfoCollections(var8, var12);
                              var1 = var13;
                              if (var13 == var4) {
                                 return var4;
                              }
                           }

                           ApiResult var17 = (ApiResult)var1;
                           Function2 var14 = new Function2(var5, var11, this.this$0, (Continuation)null) {
                              final UserInfoCollections $newData;
                              final int $newVersion;
                              int label;
                              final HomeViewModel this$0;

                              {
                                 this.$newData = var1;
                                 this.$newVersion = var2;
                                 this.this$0 = var3;
                              }

                              public final Continuation create(Object var1, Continuation var2) {
                                 return (Continuation)(new <anonymous constructor>(this.$newData, this.$newVersion, this.this$0, var2));
                              }

                              public final Object invoke(ResponseBody var1, Continuation var2) {
                                 return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 if (this.label == 0) {
                                    ResultKt.throwOnFailure(var1);
                                    Timber.Forest var2 = Timber.Forest;
                                    StringBuilder var3 = new StringBuilder("uploadUserInfoCollections success: ");
                                    var3.append(this.$newData.getSeries());
                                    var3.append('-');
                                    var3.append(this.$newVersion);
                                    var2.d(var3.toString(), new Object[0]);
                                    UserInfoCollectionsManager.INSTANCE.setVersion(this.$newVersion);
                                    Prefs var5 = this.this$0.getPrefs();
                                    Long var4 = Boxing.boxLong(System.currentTimeMillis());
                                    PreferencesHelper.INSTANCE.set(var5.getBackend(), "KEY_USER_INFO_COLLECTIONS_SYNC_TIME", var4, Reflection.getOrCreateKotlinClass(Long.class));
                                    return Unit.INSTANCE;
                                 } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }
                              }
                           };
                           Continuation var9 = (Continuation)this;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                           this.I$0 = var11;
                           this.label = 2;
                           Object var15 = ApiResultKt.onSuccess(var17, var14, var9);
                           var1 = var15;
                           if (var15 == var4) {
                              return var4;
                           }
                        }

                        ApiResult var10 = (ApiResult)var1;
                        Function2 var16 = new Function2((Continuation)null) {
                           Object L$0;
                           int label;

                           public final Continuation create(Object var1, Continuation var2) {
                              Function2 var3 = new <anonymous constructor>(var2);
                              var3.L$0 = var1;
                              return (Continuation)var3;
                           }

                           public final Object invoke(Throwable var1, Continuation var2) {
                              return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                           }

                           public final Object invokeSuspend(Object var1) {
                              Throwable var2 = (Throwable)this.L$0;
                              IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              if (this.label == 0) {
                                 ResultKt.throwOnFailure(var1);
                                 Timber.Forest.e(var2, "uploadUserInfoCollections failed", new Object[0]);
                                 return Unit.INSTANCE;
                              } else {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }
                           }
                        };
                        Continuation var18 = (Continuation)this;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                        this.I$0 = var11;
                        this.label = 3;
                        if (ApiResultKt.onFail(var10, var16, var18) == var4) {
                           return var4;
                        } else {
                           return Unit.INSTANCE;
                        }
                     }
                  };
                  Continuation var11 = (Continuation)this;
                  this.J$0 = var4;
                  this.label = 2;
                  var1 = ApiResultKt.onSuccess(var15, var8, var11);
                  if (var1 == var6) {
                     return var6;
                  }
               }

               ApiResult var12 = (ApiResult)var1;
               Function2 var17 = new Function2((Continuation)null) {
                  Object L$0;
                  int label;

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(var2);
                     var3.L$0 = var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(Throwable var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Throwable var2 = (Throwable)this.L$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        Timber.Forest.e(var2, "getUserInfoCollections failed", new Object[0]);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var16 = (Continuation)this;
               this.J$0 = var4;
               this.label = 3;
               if (ApiResultKt.onFail(var12, var17, var16) == var6) {
                  return var6;
               } else {
                  return Unit.INSTANCE;
               }
            }
         }, 2, (Object)null);
      }
   }

   public final Object fetchAblGranularRegion(Continuation var1) {
      label39: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var7 = var3;
               break label39;
            }
         }

         var7 = new ContinuationImpl(this, var1) {
            Object L$0;
            int label;
            Object result;
            final HomeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchAblGranularRegion((Continuation)this);
            }
         };
      }

      AuthService var9 = (AuthService)((<undefinedtype>)var7).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var7).label;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            String var8 = (String)((<undefinedtype>)var7).L$0;
            ResultKt.throwOnFailure(var9);
            return Unit.INSTANCE;
         }

         ResultKt.throwOnFailure(var9);
      } else {
         ResultKt.throwOnFailure(var9);
         var9 = this.getAuthService();
         ((<undefinedtype>)var7).label = 1;
         Object var4 = var9.fetchAblGranularRegion((Continuation)var7);
         var9 = (AuthService)var4;
         if (var4 == var5) {
            return var5;
         }
      }

      String var6 = (String)var9;
      if (var6 != null) {
         this.getUserAblRegionPublisher().onNext(var6);
         return Unit.INSTANCE;
      } else {
         Channel var11 = this.userAblRegionFetchErrorChannel;
         Unit var12 = Unit.INSTANCE;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var6);
         ((<undefinedtype>)var7).label = 2;
         if (var11.send(var12, (Continuation)var7) == var5) {
            return var5;
         } else {
            return Unit.INSTANCE;
         }
      }
   }

   public final void getAlexaLinkStatus() {
      Object var2 = this.fetchingAlexaLinked.getValue();
      Boolean var1 = true;
      if (!Intrinsics.areEqual(var2, var1)) {
         this.fetchingAlexaLinked.setValue(var1);
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            Object L$0;
            int label;
            final HomeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Throwable var10000;
               label170: {
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  Object var3;
                  MutableLiveData var21;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var21 = (MutableLiveData)this.L$0;

                     try {
                        ResultKt.throwOnFailure(var1);
                     } catch (Throwable var17) {
                        var10000 = var17;
                        boolean var10001 = false;
                        break label170;
                     }

                     var3 = (DeviceManager)var1;
                  } else {
                     ResultKt.throwOnFailure(var1);

                     try {
                        var18 = this.this$0.getAlexaLinked();
                        var3 = this.this$0.getDeviceManager();
                        Continuation var5 = (Continuation)this;
                        this.L$0 = var18;
                        this.label = 1;
                        var3 = (DeviceManager)var3.getAlexaLinkStatus(var5);
                     } catch (Throwable var16) {
                        var10000 = var16;
                        boolean var22 = false;
                        break label170;
                     }

                     if (var3 == var4) {
                        return var4;
                     }

                     var21 = var18;
                  }

                  try {
                     var21.postValue(var3);
                  } catch (Throwable var15) {
                     var10000 = var15;
                     boolean var23 = false;
                     break label170;
                  }

                  this.this$0.fetchingAlexaLinked.postValue(Boxing.boxBoolean(false));
                  return Unit.INSTANCE;
               }

               Throwable var19 = var10000;
               this.this$0.fetchingAlexaLinked.postValue(Boxing.boxBoolean(false));
               throw var19;
            }
         }, 2, (Object)null);
      }
   }

   public final MutableLiveData getAlexaLinked() {
      return this.alexaLinked;
   }

   public final String getCountry() {
      return this.getLocationService().getCountry();
   }

   public final LiveData getDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return this.getDeviceManager().databaseDevice(var1);
   }

   public final MutableLiveData getDeviceNum() {
      return this.deviceNum;
   }

   public final LiveData getFetchingSmartIntegrationStatus() {
      return this.fetchingSmartIntegrationStatus;
   }

   public final Flow getFlowDevicesRating() {
      return FlowKt.flowCombine(this.getDeviceManager().getFlowDevices(), this.getDeviceManager().getFlowLatestDevicesDatapoints(), new Function3(this, (Continuation)null) {
         Object L$0;
         Object L$1;
         int label;
         final HomeViewModel this$0;

         // $FF: synthetic method
         public static Pair $r8$lambda$2e4Py_XfqzGNZIS7vpbCLpHADLg/* $FF was: $r8$lambda$2e4Py-XfqzGNZIS7vpbCLpHADLg*/(Map var0, HomeViewModel var1, HasSensorData var2) {
            return invokeSuspend$lambda$2(var0, var1, var2);
         }

         // $FF: synthetic method
         public static boolean $r8$lambda$MU2T2Ljb080nktWcvo_Aq4NT2Vw(HasSensorData var0) {
            return invokeSuspend$lambda$0(var0);
         }

         {
            this.this$0 = var1;
         }

         private static final boolean invokeSuspend$lambda$0(HasSensorData var0) {
            return var0 instanceof HasBlueProvisionCalls ? ((HasBlueProvisionCalls)var0).getHasFinishedOnboarding() : true;
         }

         private static final Pair invokeSuspend$lambda$2(Map var0, HomeViewModel var1, HasSensorData var2) {
            ConnectivityStatus var7 = var2.getConnectivityStatus();
            ConnectivityStatus var8 = ConnectivityStatus.ONLINE;
            float var3 = -1.0F;
            int var5 = -1;
            if (var7 == var8 && !DeviceKt.isStandByOn(var2)) {
               IndoorAirRatingRanges var9;
               label36: {
                  var9 = IndoorAirRatingRanges.Companion.instance(var2);
                  IndoorDatapoint var14 = (IndoorDatapoint)var0.get(var2.getUid());
                  var18 = null;
                  if (var14 != null) {
                     var11 = var14;
                     if (System.currentTimeMillis() - var14.getTimeInMillis() < 20000L) {
                        break label36;
                     }
                  }

                  var11 = null;
               }

               Pair var15 = var9.voteWorstRating(IndoorAirRatingRanges.Companion.getAirRatingSensors(var2), var11);
               int var6 = ((Number)var15.getSecond()).intValue();
               SensorType var10 = (SensorType)var15.getFirst();
               Float var16;
               if (var11 != null) {
                  var16 = var11.valueFor((SensorType)var15.getFirst());
               } else {
                  var16 = null;
               }

               float var4 = var1.computeRatingValue(var10, var16, var9);
               if (var2 instanceof HasWick || var2 instanceof DeviceDehumidifier) {
                  Float var12;
                  if (var11 != null) {
                     var12 = var11.getHum();
                  } else {
                     var12 = null;
                  }

                  var5 = var1.computeHumRatingIndex(var12, var9);
                  SensorType var17 = SensorType.HUM;
                  var12 = (Float)var18;
                  if (var11 != null) {
                     var12 = var11.getHum();
                  }

                  var3 = var1.computeRatingValue(var17, var12, var9);
               }

               return new Pair(RangesKt.coerceAtLeast(var6, var5), RangesKt.coerceAtLeast(var4, var3));
            } else {
               return new Pair(-1, -1.0F);
            }
         }

         public final Object invoke(List var1, Map var2, Continuation var3) {
            Function3 var4 = new <anonymous constructor>(this.this$0, var3);
            var4.L$0 = var1;
            var4.L$1 = var2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            List var3 = (List)this.L$0;
            Map var2 = (Map)this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               if ((Boolean)this.this$0.getAuthService().isUserLoggedIn().getValue()) {
                  Sequence var4 = SequencesKt.filter(CollectionsKt.asSequence((Iterable)var3), null.INSTANCE);
                  Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
                  return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(var4, new HomeViewModel$flowDevicesRating$1$$ExternalSyntheticLambda0()), new HomeViewModel$flowDevicesRating$1$$ExternalSyntheticLambda1(var2, this.this$0)));
               } else {
                  return CollectionsKt.emptyList();
               }
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
   }

   public final void getGoogleLinkStatus() {
      Object var2 = this.fetchingGoogleLinked.getValue();
      Boolean var1 = true;
      if (!Intrinsics.areEqual(var2, var1)) {
         this.fetchingGoogleLinked.setValue(var1);
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            Object L$0;
            int label;
            final HomeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Throwable var10000;
               label170: {
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  Object var3;
                  MutableLiveData var22;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var22 = (MutableLiveData)this.L$0;

                     try {
                        ResultKt.throwOnFailure(var1);
                     } catch (Throwable var18) {
                        var10000 = var18;
                        boolean var10001 = false;
                        break label170;
                     }

                     var3 = (DeviceManager)var1;
                  } else {
                     ResultKt.throwOnFailure(var1);

                     try {
                        var19 = this.this$0.getGoogleLinked();
                        var3 = this.this$0.getDeviceManager();
                        String var5 = LocationService.getGoogleClientId$default(this.this$0.getLocationService(), false, 1, (Object)null);
                        Continuation var6 = (Continuation)this;
                        this.L$0 = var19;
                        this.label = 1;
                        var3 = (DeviceManager)var3.getGoogleLinkStatus(var5, var6);
                     } catch (Throwable var17) {
                        var10000 = var17;
                        boolean var23 = false;
                        break label170;
                     }

                     if (var3 == var4) {
                        return var4;
                     }

                     var22 = var19;
                  }

                  try {
                     var22.postValue(var3);
                  } catch (Throwable var16) {
                     var10000 = var16;
                     boolean var24 = false;
                     break label170;
                  }

                  this.this$0.fetchingGoogleLinked.postValue(Boxing.boxBoolean(false));
                  return Unit.INSTANCE;
               }

               Throwable var20 = var10000;
               this.this$0.fetchingGoogleLinked.postValue(Boxing.boxBoolean(false));
               throw var20;
            }
         }, 2, (Object)null);
      }
   }

   public final MutableLiveData getGoogleLinked() {
      return this.googleLinked;
   }

   public final int getLastRatingIndex() {
      return this.lastRatingIndex;
   }

   public final LiveData getLiveDevices() {
      return this.liveDevices;
   }

   public final MutableLiveData getLvAirStateStringRes() {
      return this.lvAirStateStringRes;
   }

   public final MutableLiveData getSettingsLoading() {
      return this.settingsLoading;
   }

   public final Flow getSmartIntegrationsAvailable() {
      return this.smartIntegrationsAvailable;
   }

   public final void getTemperatureSettings() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final HomeViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            boolean var4 = true;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               this.this$0.getSettingsLoading().setValue(Boxing.boxBoolean(true));
               var1 = this.this$0.getDeviceManager();
               Continuation var5 = (Continuation)this;
               this.label = 1;
               Object var9 = var1.getTemperatureSettings(var5);
               var1 = (DeviceManager)var9;
               if (var9 == var6) {
                  return var6;
               }
            }

            String var8 = (String)var1;
            if (var8 != null) {
               Prefs var12 = this.this$0.getPrefs();
               Boolean var10 = Boxing.boxBoolean(Intrinsics.areEqual(var8, "Celsius"));
               PreferencesHelper.INSTANCE.set(var12.getBackend(), "temp_is_celsius", var10, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

            MutableLiveData var11 = this.this$0.isTempCelsius();
            boolean var3 = var4;
            if (var8 != null) {
               if (Intrinsics.areEqual(var8, "Celsius")) {
                  var3 = var4;
               } else {
                  var3 = false;
               }
            }

            var11.setValue(Boxing.boxBoolean(var3));
            this.this$0.getSettingsLoading().setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final Flow getUserAblRegionFetchErrorFlow() {
      return FlowKt.receiveAsFlow((ReceiveChannel)this.userAblRegionFetchErrorChannel);
   }

   public final Observable getUserAblRegionObserver() {
      Observable var1 = this.getUserAblRegionPublisher().hide();
      Intrinsics.checkNotNullExpressionValue(var1, "hide(...)");
      return var1;
   }

   public final String getUserEmail() {
      return this.getAuthService().getUsername();
   }

   public final boolean isAppVersionSupported() {
      return this.isAppVersionSupported;
   }

   public final boolean isInAlexaRegion() {
      if (!this.getLocationService().isInAlexaRegion()) {
         Prefs var1 = this.getPrefs();
         if (!(Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_FORCE_ALEXA_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return false;
         }
      }

      return true;
   }

   public final boolean isInAntiFakeRegion() {
      return this.getLocationService().isInAntiFakeRegion();
   }

   public final boolean isInB4Region() {
      return this.getLocationService().isInB4Region();
   }

   public final boolean isInG4ProtectRegion() {
      return this.getLocationService().isInG4ProtectRegion();
   }

   public final boolean isInG4Region() {
      return this.getLocationService().isInG4Region();
   }

   public final boolean isInGoogleAssistantRegion() {
      if (!this.getLocationService().isInGoogleAssistantRegion()) {
         Prefs var1 = this.getPrefs();
         if (!(Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_FORCE_GASSISTANT_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return false;
         }
      }

      return true;
   }

   public final boolean isInTmallRegion() {
      if (!this.getLocationService().isInTmallRegion()) {
         Prefs var1 = this.getPrefs();
         if (!(Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_FORCE_TMALL_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return false;
         }
      }

      return true;
   }

   public final MediatorLiveData isLoading() {
      return this.isLoading;
   }

   public final MutableLiveData isTempCelsius() {
      return this.isTempCelsius;
   }

   public final StateFlow isUserSignedIn() {
      return this.isUserSignedIn;
   }

   public final Flow isWarrantyAvailable() {
      return this.isWarrantyAvailable;
   }

   public final void logout() {
      this.getLogoutService().logOutRegistered(LogoutReason.USER_LOGOUT);
   }

   public final void onSwipeToRefresh() {
      this.refreshDeviceList();
      this.refreshTrackedLocationList();
   }

   public final void setLastRatingIndex(int var1) {
      this.lastRatingIndex = var1;
   }

   public final boolean shouldShowIcpNo() {
      if ((Boolean)this.isUserSignedIn.getValue()) {
         return Intrinsics.areEqual(this.getAuthService().getCloudUserRegion(), "cn");
      } else {
         String var1 = this.getLocationService().getDeviceRegion();
         String var2 = Locale.CHINA.getCountry();
         Intrinsics.checkNotNullExpressionValue(var2, "getCountry(...)");
         var2 = var2.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var2, "toLowerCase(...)");
         return Intrinsics.areEqual(var1, var2);
      }
   }

   public final void toggleIsTempCelsius() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final HomeViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label29: {
               Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               String var3;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = (String)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     break label29;
                  }

                  var3 = (String)this.L$0;
                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  this.this$0.getSettingsLoading().postValue(Boxing.boxBoolean(true));
                  var1 = this.this$0.isTempCelsius().getValue();
                  Intrinsics.checkNotNull(var1);
                  String var8;
                  if ((Boolean)var1) {
                     var8 = "Fahrenheit";
                  } else {
                     var8 = "Celsius";
                  }

                  DeviceManager var11 = this.this$0.getDeviceManager();
                  Continuation var4 = (Continuation)this;
                  this.L$0 = var8;
                  this.label = 1;
                  Object var12 = var11.setTemperatureSettings(var8, var4);
                  var3 = var8;
                  var1 = var12;
                  if (var12 == var5) {
                     return var5;
                  }
               }

               ApiResult var13 = (ApiResult)var1;
               Function2 var9 = new Function2(var3, this.this$0, (Continuation)null) {
                  final String $value;
                  int label;
                  final HomeViewModel this$0;

                  {
                     this.$value = var1;
                     this.this$0 = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$value, this.this$0, var2));
                  }

                  public final Object invoke(Unit var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        boolean var2 = Intrinsics.areEqual(this.$value, "Celsius");
                        this.this$0.isTempCelsius().postValue(Boxing.boxBoolean(var2));
                        Prefs var4 = this.this$0.getPrefs();
                        Boolean var3 = Boxing.boxBoolean(var2);
                        PreferencesHelper.INSTANCE.set(var4.getBackend(), "temp_is_celsius", var3, Reflection.getOrCreateKotlinClass(Boolean.class));
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var6 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.label = 2;
               if (ApiResultKt.onSuccess(var13, var9, var6) == var5) {
                  return var5;
               }
            }

            this.this$0.getSettingsLoading().postValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void updateSkuConfiguration(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onComplete");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final Function1 $onComplete;
         Object L$0;
         int label;
         final HomeViewModel this$0;

         {
            this.this$0 = var1;
            this.$onComplete = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$onComplete, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5;
            label32: {
               var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        if (var2 != 3) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ApiResult var4 = (ApiResult)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     ResultKt.throwOnFailure(var1);
                     break label32;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  var1 = this.this$0.getDeviceManager();
                  int var3 = SkuConfigurationManager.INSTANCE.getVersion();
                  var2 = SkuConfigurationManager.INSTANCE.getSeries();
                  Continuation var12 = (Continuation)this;
                  this.label = 1;
                  Object var13 = var1.updateSkuConfiguration(var3, var2, var12);
                  var1 = (DeviceManager)var13;
                  if (var13 == var5) {
                     return var5;
                  }
               }

               ApiResult var9 = (ApiResult)var1;
               Function2 var14 = new Function2(this.this$0, (Continuation)null) {
                  Object L$0;
                  int label;
                  final HomeViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                     var3.L$0 = var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(SkuConfigurationData var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     SkuConfigurationData var2 = (SkuConfigurationData)this.L$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        SkuConfigurationManager.INSTANCE.updateSkuConfiguration((Context)this.this$0.getApplication(), var2);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var6 = (Continuation)this;
               this.label = 2;
               Object var15 = ApiResultKt.onSuccess(var9, var14, var6);
               var1 = (DeviceManager)var15;
               if (var15 == var5) {
                  return var5;
               }
            }

            ApiResult var10 = (ApiResult)var1;
            CoroutineContext var7 = (CoroutineContext)Dispatchers.getMain();
            Function2 var16 = new Function2(this.$onComplete, var10, (Continuation)null) {
               final Function1 $onComplete;
               final ApiResult $result;
               int label;

               {
                  this.$onComplete = var1;
                  this.$result = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$onComplete, this.$result, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.$onComplete.invoke(this.$result);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var17 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var10);
            this.label = 3;
            if (BuildersKt.withContext(var7, var16, var17) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final void updateTimezoneList() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final HomeViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            String var3;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var3 = (String)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               var3 = (String)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var3 = TimezoneUtils.INSTANCE.getTimezoneList((Context)this.this$0.getApplication()).getVersion();
               DeviceManager var4 = this.this$0.getDeviceManager();
               Continuation var7 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.label = 1;
               Object var10 = var4.updateTimezoneList(var3, var7);
               var1 = var10;
               if (var10 == var5) {
                  return var5;
               }
            }

            ApiResult var6 = (ApiResult)var1;
            Function2 var8 = new Function2(this.this$0, (Continuation)null) {
               Object L$0;
               int label;
               final HomeViewModel this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                  var3.L$0 = var1;
                  return (Continuation)var3;
               }

               public final Object invoke(TimezoneNames var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  TimezoneNames var2 = (TimezoneNames)this.L$0;
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     TimezoneUtils.INSTANCE.updateTimezoneList((Context)this.this$0.getApplication(), var2);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var11 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
            this.label = 2;
            if (ApiResultKt.onSuccess(var6, var8, var11) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }
}
