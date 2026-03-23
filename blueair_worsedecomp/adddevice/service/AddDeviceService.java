package com.blueair.adddevice.service;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.DevicePairManager;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.auth.AuthService;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.MigrationOtaResponse;
import com.blueair.core.model.OnboardingFailureEvent;
import com.blueair.core.model.OnboardingSuccessEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.AblWifFirmwareUtils;
import com.blueair.core.util.MoshiSerializer;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.IcpDeviceInfo;
import com.blueair.viewcore.R;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.squareup.moshi.Types;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ³\u00012\u00020\u0001:\u0002³\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020A2\b\b\u0002\u0010T\u001a\u00020AH\u0002J\u001c\u0010U\u001a\u00020Q2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020A0WH\u0002J\u0006\u0010X\u001a\u00020AJ\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00140<H\u0002J\u0016\u0010Z\u001a\u00020Q2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00140<H\u0002J\u0010\u0010\\\u001a\u00020Q2\u0006\u0010]\u001a\u00020\u0014H\u0002J\b\u0010^\u001a\u00020QH\u0002J\u0010\u0010_\u001a\u00020Q2\b\u0010`\u001a\u0004\u0018\u00010\u0014J\u000e\u0010a\u001a\u00020Q2\u0006\u0010b\u001a\u00020OJ\u0006\u0010c\u001a\u00020QJ\u0006\u0010d\u001a\u00020QJ\u0006\u0010e\u001a\u00020QJ\u000e\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020hJ\u0006\u0010i\u001a\u00020QJ\u0006\u0010j\u001a\u00020QJ\u0006\u0010k\u001a\u00020QJ\u0006\u0010l\u001a\u00020QJ\u0006\u0010m\u001a\u00020QJ \u0010n\u001a\u00020Q2\b\u0010o\u001a\u0004\u0018\u00010*2\u0006\u0010p\u001a\u00020*2\u0006\u0010q\u001a\u00020*J\u0016\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020AJ\u0006\u0010v\u001a\u00020QJ\u0006\u0010w\u001a\u00020QJ\u0006\u0010x\u001a\u00020QJ\u0006\u0010y\u001a\u00020QJ\u0006\u0010z\u001a\u00020QJ\u0006\u0010{\u001a\u00020QJ\u0006\u0010|\u001a\u00020QJ\u0006\u0010}\u001a\u00020QJ\u0006\u0010~\u001a\u00020QJ\u0006\u0010\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020QJ\u0012\u0010\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0001\u001a\u00020AJ\u0006\u0010@\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020QJ\u0019\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020*H@¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020QJ\u0007\u0010\u0001\u001a\u00020*J\u0007\u0010\u0001\u001a\u00020*J\u0012\u0010\u0001\u001a\u00020Q2\t\u0010\u0001\u001a\u0004\u0018\u00010*J\u0012\u0010\u0001\u001a\u00020Q2\t\u0010\u0001\u001a\u0004\u0018\u00010*J\u0007\u0010\u0001\u001a\u00020*J\u0011\u0010\u0001\u001a\u00020Q2\b\u0010F\u001a\u0004\u0018\u00010*J!\u0010\u0001\u001a\u00020Q2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010*2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010*J\b\u0010\u0001\u001a\u00030\u0001J#\u0010\u0001\u001a\u00020Q2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010*2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010*H\u0002J \u0010\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u00012\u0007\u0010\u0001\u001a\u00020tH@¢\u0006\u0003\u0010\u0001J9\u0010\u0001\u001a\u0004\u0018\u00010Q2%\u0010\u0001\u001a \u0012\u0016\u0012\u00140*¢\u0006\u000f\b \u0001\u0012\n\b¡\u0001\u0012\u0005\b\b(¢\u0001\u0012\u0004\u0012\u00020Q0WH@¢\u0006\u0003\u0010£\u0001J\u000e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020A0¥\u0001J\u0007\u0010¦\u0001\u001a\u00020QJ\t\u0010§\u0001\u001a\u00020AH\u0002J\u0007\u0010¨\u0001\u001a\u00020AJ\u0019\u0010©\u0001\u001a\u00020A2\u0007\u0010ª\u0001\u001a\u00020*H@¢\u0006\u0003\u0010\u0001J\u0010\u0010«\u0001\u001a\u00020Q2\u0007\u0010¬\u0001\u001a\u00020*J%\u0010\u0001\u001a\u00030­\u00012\b\u0010®\u0001\u001a\u00030­\u00012\u000f\u0010¯\u0001\u001a\n\u0012\u0005\u0012\u00030°\u00010\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00020Q2\b\u0010®\u0001\u001a\u00030­\u0001H\u0002J\u0013\u0010²\u0001\u001a\u00020Q2\b\u0010®\u0001\u001a\u00030­\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR5\u0010\u001f\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198BX\u0002¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b%\u0010\u001cR5\u0010'\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b(\u0010#R!\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00198BX\u0002¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b+\u0010\u001cR5\u0010-\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010*0* !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010*0*\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b.\u0010#R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198BX\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b0\u0010\u001cR5\u00103\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b4\u0010#R!\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198BX\u0002¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b6\u0010\u001cR5\u00108\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b9\u0010#R'\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140<0;8BX\u0002¢\u0006\f\n\u0004\b?\u00102\u001a\u0004\b=\u0010>R\u001a\u0010@\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010L\u001a\u00020A2\u0006\u0010K\u001a\u00020A@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010CR\u000e\u0010N\u001a\u00020OX\u000e¢\u0006\u0002\n\u0000¨\u0006´\u0001"}, d2 = {"Lcom/blueair/adddevice/service/AddDeviceService;", "", "context", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "authService", "Lcom/blueair/auth/AuthService;", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Landroid/content/Context;Landroid/content/res/Resources;Lcom/blueair/devicemanager/DeviceManager;Lcom/blueair/auth/AuthService;Lcom/blueair/core/service/SecurePrefs;Lcom/blueair/core/service/UnsecurePrefs;Lcom/blueair/core/service/AnalyticsService;)V", "syncLock", "_state", "Lcom/blueair/adddevice/model/AddDeviceState;", "state", "getState", "()Lcom/blueair/adddevice/model/AddDeviceState;", "screenChangePublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "getScreenChangePublisher", "()Lio/reactivex/subjects/PublishSubject;", "screenChangePublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "screenChangeObserver", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "getScreenChangeObserver", "()Lio/reactivex/Observable;", "screenRevertPublisher", "getScreenRevertPublisher", "screenRevertPublisher$delegate", "screenRevertObserver", "getScreenRevertObserver", "messageDisplayPublisher", "", "getMessageDisplayPublisher", "messageDisplayPublisher$delegate", "messageDisplayObserver", "getMessageDisplayObserver", "performBackendAddPublisher", "getPerformBackendAddPublisher", "performBackendAddPublisher$delegate", "Lkotlin/Lazy;", "performBackendAddObserver", "getPerformBackendAddObserver", "successPublisher", "getSuccessPublisher", "successPublisher$delegate", "successObserver", "getSuccessObserver", "stateHistorySerializer", "Lcom/blueair/core/util/MoshiSerializer;", "", "getStateHistorySerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "stateHistorySerializer$delegate", "troubleshoot", "", "getTroubleshoot", "()Z", "setTroubleshoot", "(Z)V", "wifiPassword", "getWifiPassword", "()Ljava/lang/String;", "setWifiPassword", "(Ljava/lang/String;)V", "value", "troubleshootThirdItemSelected", "getTroubleshootThirdItemSelected", "autoFailCount", "", "updateState", "", "nuState", "changeScreen", "doSave", "downdateState", "requirement", "Lkotlin/Function1;", "popState", "loadStateHistory", "saveHistory", "history", "saveState", "theState", "clearStateHistory", "initState", "origState", "selectDevice", "nuDeviceType", "setupTextCompleted", "icpAddDeviceCompleted", "icpSetupDeviceCompleted", "icpPairingCompleted", "icpDeviceInfo", "Lcom/blueair/devicemanager/IcpDeviceInfo;", "autoStepCompleted", "autoFailStepCompleted", "startManualConfig", "startManualStepTwo", "manualStepCompleted", "setNetworkInfo", "wifiNetworkBSSID", "wifiNetworkSSID", "wifiNetworkPassword", "deviceConfigSuccess", "deviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "auto", "startManualConfigClassic", "startManualConfigStep2Classic", "startAutoOrManualClassic", "startActivateDeviceWifiClassic", "startConnectToNetworkClassic", "showAutoStep2", "showManualStep1", "autoConfigFail", "restartAddDeviceFlow", "restartAutoConfig", "restartManualConfig", "restartOnboarding", "showMessage", "recommendResetDevice", "manualConfigFailToAutoModeFailState", "successFinished", "validateManual", "chooseDeviceName", "nuDeviceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addOnbackendSuccess", "addOnBackendFail", "getSettingsWiFiNetworkSSID", "getCurrentNetworkSSIDEstimate", "setSettingsWiFiNetworkBSSID", "wifiBSSID", "setSettingsWiFiNetworkSSID", "wifiSSID", "getSettingsWiFiNetworkPassword", "setSettingsWiFiNetworkPassword", "autoPairDevice", "networkSSID", "networkPassPhrase", "manualPairDeviceAsync", "Lio/reactivex/Completable;", "manualPairDevice", "addDeviceForActiveUser", "Lio/flatcircle/coroutinehelper/ApiResult;", "origDeviceInfo", "(Lcom/blueair/adddevice/DeviceInformationLegacy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrationOtaCheck", "onFailure", "Lkotlin/ParameterName;", "name", "errorMsg", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "otaUpdateRunningCheckAsync", "Lio/reactivex/Single;", "forceOtaCompleted", "otaUpdateRunningCheck", "isUserLoggedIn", "fetchDeviceStatus", "deviceUUID", "updateDeviceStatusLocalToOtaUpdating", "deviceUid", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "deviceInfo", "migrationOtaCall", "Lcom/blueair/core/model/MigrationOtaResponse;", "firmwareVersionCheck", "addDeviceToDb", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceService.kt */
public final class AddDeviceService {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private static final long ARTIFICIAL_DELAY = 40000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FOOBOT = "foobot";
    public static final int OTA_CHECK_MAX_RETRIES = 3;
    public static final String STATE_HISTORY_KEY = "state_history";
    public static final String USER_FRIENDLY_MIGRATION_OTA_FAILURE_MSG = "There was an error processing this request. Please try again";
    public static final String WIFI_BSSID_KEY = "wifi_bssid_add";
    public static final String WIFI_PASSWORD_KEY = "password_wifi";
    public static final String WIFI_SSID_KEY = "wifi_ssid_add";
    private AddDeviceState _state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker) null);
    private final AnalyticsService analyticsService;
    private final AuthService authService;
    private int autoFailCount;
    private final Context context;
    /* access modifiers changed from: private */
    public final DeviceManager deviceManager;
    private final LazyPublishSubject messageDisplayPublisher$delegate = new LazyPublishSubject();
    private final Lazy performBackendAddPublisher$delegate = LazyKt.lazy(new AddDeviceService$$ExternalSyntheticLambda0());
    private final UnsecurePrefs prefs;
    private final Resources resources;
    private final LazyPublishSubject screenChangePublisher$delegate = new LazyPublishSubject();
    private final LazyPublishSubject screenRevertPublisher$delegate = new LazyPublishSubject();
    private final SecurePrefs securePrefs;
    private final Lazy stateHistorySerializer$delegate = LazyKt.lazy(new AddDeviceService$$ExternalSyntheticLambda2());
    private final Lazy successPublisher$delegate = LazyKt.lazy(new AddDeviceService$$ExternalSyntheticLambda1());
    private final Object syncLock = new Object();
    private boolean troubleshoot;
    private boolean troubleshootThirdItemSelected;
    private String wifiPassword = "";

    static {
        Class<AddDeviceService> cls = AddDeviceService.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "screenChangePublisher", "getScreenChangePublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "screenRevertPublisher", "getScreenRevertPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "messageDisplayPublisher", "getMessageDisplayPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    public AddDeviceService(Context context2, Resources resources2, DeviceManager deviceManager2, AuthService authService2, SecurePrefs securePrefs2, UnsecurePrefs unsecurePrefs, AnalyticsService analyticsService2) {
        Context context3 = context2;
        Resources resources3 = resources2;
        DeviceManager deviceManager3 = deviceManager2;
        AuthService authService3 = authService2;
        SecurePrefs securePrefs3 = securePrefs2;
        UnsecurePrefs unsecurePrefs2 = unsecurePrefs;
        AnalyticsService analyticsService3 = analyticsService2;
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(resources3, "resources");
        Intrinsics.checkNotNullParameter(deviceManager3, "deviceManager");
        Intrinsics.checkNotNullParameter(authService3, "authService");
        Intrinsics.checkNotNullParameter(securePrefs3, "securePrefs");
        Intrinsics.checkNotNullParameter(unsecurePrefs2, "prefs");
        Intrinsics.checkNotNullParameter(analyticsService3, "analyticsService");
        this.context = context3;
        this.resources = resources3;
        this.deviceManager = deviceManager3;
        this.authService = authService3;
        this.securePrefs = securePrefs3;
        this.prefs = unsecurePrefs2;
        this.analyticsService = analyticsService3;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/adddevice/service/AddDeviceService$Companion;", "", "<init>", "()V", "STATE_HISTORY_KEY", "", "WIFI_SSID_KEY", "WIFI_BSSID_KEY", "WIFI_PASSWORD_KEY", "OTA_CHECK_MAX_RETRIES", "", "FOOBOT", "USER_FRIENDLY_MIGRATION_OTA_FAILURE_MSG", "ARTIFICIAL_DELAY", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final AddDeviceState getState() {
        return this._state;
    }

    private final PublishSubject<AddDeviceUtils.AddDeviceScreen> getScreenChangePublisher() {
        return this.screenChangePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    public final Observable<AddDeviceUtils.AddDeviceScreen> getScreenChangeObserver() {
        return getScreenChangePublisher().hide();
    }

    private final PublishSubject<AddDeviceUtils.AddDeviceScreen> getScreenRevertPublisher() {
        return this.screenRevertPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    public final Observable<AddDeviceUtils.AddDeviceScreen> getScreenRevertObserver() {
        return getScreenRevertPublisher().hide();
    }

    private final PublishSubject<String> getMessageDisplayPublisher() {
        return this.messageDisplayPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    public final Observable<String> getMessageDisplayObserver() {
        return getMessageDisplayPublisher().hide();
    }

    private final PublishSubject<AddDeviceState> getPerformBackendAddPublisher() {
        Object value = this.performBackendAddPublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject performBackendAddPublisher_delegate$lambda$0() {
        return PublishSubject.create();
    }

    public final Observable<AddDeviceState> getPerformBackendAddObserver() {
        return getPerformBackendAddPublisher().hide();
    }

    private final PublishSubject<AddDeviceState> getSuccessPublisher() {
        Object value = this.successPublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject successPublisher_delegate$lambda$1() {
        return PublishSubject.create();
    }

    public final Observable<AddDeviceState> getSuccessObserver() {
        return getSuccessPublisher().hide();
    }

    private final MoshiSerializer<List<AddDeviceState>> getStateHistorySerializer() {
        return (MoshiSerializer) this.stateHistorySerializer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final MoshiSerializer stateHistorySerializer_delegate$lambda$2() {
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, AddDeviceState.class);
        Intrinsics.checkNotNullExpressionValue(newParameterizedType, "newParameterizedType(...)");
        return new MoshiSerializer(newParameterizedType, new Object[0]);
    }

    public final boolean getTroubleshoot() {
        return this.troubleshoot;
    }

    public final void setTroubleshoot(boolean z) {
        this.troubleshoot = z;
    }

    public final String getWifiPassword() {
        return this.wifiPassword;
    }

    public final void setWifiPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wifiPassword = str;
    }

    public final boolean getTroubleshootThirdItemSelected() {
        return this.troubleshootThirdItemSelected;
    }

    static /* synthetic */ void updateState$default(AddDeviceService addDeviceService, AddDeviceState addDeviceState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        addDeviceService.updateState(addDeviceState, z, z2);
    }

    private final void updateState(AddDeviceState addDeviceState, boolean z, boolean z2) {
        synchronized (this.syncLock) {
            AddDeviceState addDeviceState2 = this._state;
            Timber.Forest forest = Timber.Forest;
            forest.d("updateState: nuState: " + addDeviceState + ",\n oldState: " + addDeviceState2, new Object[0]);
            this._state = addDeviceState;
            if (z2) {
                saveState(addDeviceState2);
            }
            if (!AddDeviceUtils.INSTANCE.shouldChangeScreen(addDeviceState2, addDeviceState)) {
                if (!z) {
                    Timber.Forest.d("updateState: shouldChangeScreen == false", new Object[0]);
                    if (!addDeviceState2.isReadyForBackendAdding() && addDeviceState.isReadyForBackendAdding()) {
                        Timber.Forest.d("updateState: isReadyForBackEndAdding changed from false to true", new Object[0]);
                        getPerformBackendAddPublisher().onNext(addDeviceState);
                    }
                    if (!getState().getSuccessScreen() && getState().isSuccess()) {
                        AnalyticsService analyticsService2 = this.analyticsService;
                        String name = DeviceType.Companion.fromIndex(getState().getDeviceType()).getName();
                        DeviceInformationLegacy deviceInfo = getState().getDeviceInfo();
                        if (deviceInfo == null || (r0 = deviceInfo.getId()) == null) {
                            String str = "not available";
                        }
                        analyticsService2.amplitudeLog((AmplitudeEvent) new OnboardingSuccessEvent(name, str, getState().getAutoMode()));
                        Timber.Forest.d("updateState: Publish add device success state", new Object[0]);
                        getSuccessPublisher().onNext(getState());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Timber.Forest.d("updateState: shouldChangeScreen", new Object[0]);
            AddDeviceUtils.AddDeviceScreen screen = AddDeviceUtils.INSTANCE.getScreen(addDeviceState);
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("updateState: shouldChangeScreen to " + screen, new Object[0]);
            if (screen != AddDeviceUtils.AddDeviceScreen.NONE) {
                getScreenChangePublisher().onNext(screen);
            } else {
                Timber.Forest.w("updateState: no valid screen found to change to", new Object[0]);
            }
            Timber.Forest.d("updateState: isReadyForBackEndAdding changed from false to true", new Object[0]);
            getPerformBackendAddPublisher().onNext(addDeviceState);
            AnalyticsService analyticsService22 = this.analyticsService;
            String name2 = DeviceType.Companion.fromIndex(getState().getDeviceType()).getName();
            DeviceInformationLegacy deviceInfo2 = getState().getDeviceInfo();
            String str2 = "not available";
            analyticsService22.amplitudeLog((AmplitudeEvent) new OnboardingSuccessEvent(name2, str2, getState().getAutoMode()));
            Timber.Forest.d("updateState: Publish add device success state", new Object[0]);
            getSuccessPublisher().onNext(getState());
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void downdateState(Function1<? super AddDeviceState, Boolean> function1) {
        int i;
        synchronized (this.syncLock) {
            Timber.Forest.d("downdateState", new Object[0]);
            if (!function1.invoke(getState()).booleanValue()) {
                List<AddDeviceState> loadStateHistory = loadStateHistory();
                Timber.Forest.d("downdateState: stateHistory.size = " + loadStateHistory.size(), new Object[0]);
                ListIterator<AddDeviceState> listIterator = loadStateHistory.listIterator(loadStateHistory.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (function1.invoke(listIterator.previous()).booleanValue()) {
                            i = listIterator.nextIndex();
                            break;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                Timber.Forest.d("downdateState: validStateIndex = " + i, new Object[0]);
                if (i >= 0) {
                    AddDeviceState addDeviceState = loadStateHistory.get(i);
                    List mutableList = CollectionsKt.toMutableList(loadStateHistory);
                    int size = loadStateHistory.size() - 1;
                    if (i <= size) {
                        while (true) {
                            mutableList.remove(size);
                            if (size == i) {
                                break;
                            }
                            size--;
                        }
                    }
                    saveHistory(mutableList);
                    this._state = addDeviceState;
                    Timber.Forest.d("downdateState: nuState = " + addDeviceState, new Object[0]);
                    getScreenRevertPublisher().onNext(AddDeviceUtils.INSTANCE.getScreen(addDeviceState));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean popState() {
        boolean z;
        synchronized (this.syncLock) {
            List<AddDeviceState> loadStateHistory = loadStateHistory();
            z = false;
            Timber.Forest.d("popState: current state = " + getState() + ", history = " + loadStateHistory, new Object[0]);
            if (!loadStateHistory.isEmpty()) {
                List mutableList = CollectionsKt.toMutableList(loadStateHistory);
                saveHistory(mutableList);
                this._state = (AddDeviceState) mutableList.remove(loadStateHistory.size() - 1);
                Timber.Forest.d("popState: new current state = " + this._state, new Object[0]);
                z = true;
            }
        }
        return z;
    }

    private final List<AddDeviceState> loadStateHistory() {
        String str = (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), STATE_HISTORY_KEY, null, Reflection.getOrCreateKotlinClass(String.class));
        Timber.Forest forest = Timber.Forest;
        forest.d("loadStateHistory: history json = " + str, new Object[0]);
        List<AddDeviceState> fromJson = getStateHistorySerializer().fromJson(str);
        return fromJson == null ? CollectionsKt.emptyList() : fromJson;
    }

    private final void saveHistory(List<AddDeviceState> list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("saveState: new history = " + list, new Object[0]);
        PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), STATE_HISTORY_KEY, getStateHistorySerializer().toJson(list), Reflection.getOrCreateKotlinClass(String.class));
    }

    private final void saveState(AddDeviceState addDeviceState) {
        List<AddDeviceState> loadStateHistory = loadStateHistory();
        Timber.Forest forest = Timber.Forest;
        forest.d("saveState: old history = " + loadStateHistory, new Object[0]);
        if (loadStateHistory.isEmpty() || !Intrinsics.areEqual((Object) addDeviceState, CollectionsKt.last(loadStateHistory))) {
            List mutableList = CollectionsKt.toMutableList(loadStateHistory);
            mutableList.add(addDeviceState);
            saveHistory(mutableList);
            return;
        }
        Timber.Forest.d("saveState: state is duplicate, do not save", new Object[0]);
    }

    private final void clearStateHistory() {
        Timber.Forest.d("clearStateHistory", new Object[0]);
        this.securePrefs.remove(STATE_HISTORY_KEY);
    }

    public final void initState(AddDeviceState addDeviceState) {
        AddDeviceState addDeviceState2 = addDeviceState;
        Timber.Forest forest = Timber.Forest;
        forest.d("initState: origState = " + addDeviceState2, new Object[0]);
        if (addDeviceState2 == null) {
            clearStateHistory();
        }
        this.deviceManager.getAddDeviceProcessRunning().set(true);
        updateState$default(this, addDeviceState2 == null ? new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker) null) : addDeviceState2, false, false, 4, (Object) null);
    }

    public final void selectDevice(int i) {
        this.wifiPassword = "";
        this.troubleshootThirdItemSelected = false;
        this.autoFailCount = 0;
        AddDeviceState state = getState();
        updateState$default(this, AddDeviceState.copy$default(state, i, state.getAutoMode(), 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048572, (Object) null), false, false, 6, (Object) null);
    }

    public final void setupTextCompleted() {
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, true, false, 0, false, false, 1015807, (Object) null), false, false, 6, (Object) null);
    }

    public final void icpAddDeviceCompleted() {
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 917495, (Object) null), false, false, 6, (Object) null);
    }

    public final void icpSetupDeviceCompleted() {
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 1, false, false, 917495, (Object) null), false, false, 6, (Object) null);
    }

    public final void icpPairingCompleted(IcpDeviceInfo icpDeviceInfo) {
        IcpDeviceInfo icpDeviceInfo2 = icpDeviceInfo;
        Intrinsics.checkNotNullParameter(icpDeviceInfo2, "icpDeviceInfo");
        Timber.Forest forest = Timber.Forest;
        forest.e("icpPairingCompleted " + icpDeviceInfo2, new Object[0]);
        AddDeviceState state = getState();
        String macAddress = icpDeviceInfo2.getMacAddress();
        String serialNumber = icpDeviceInfo2.getSerialNumber();
        if (serialNumber == null) {
            serialNumber = "Unknown-ID";
        }
        String name = icpDeviceInfo2.getDevice().getName();
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
        updateState$default(this, AddDeviceState.copy$default(state, 0, false, 0, false, 0, 0, false, false, false, new DeviceInformationLegacy((String) null, macAddress, serialNumber, name, "Unknown", DeviceUtilsLegacy.DEVICE_COMPATIBILITY_STRING_ICP, id), (String) null, false, 0, false, false, false, false, 2, false, false, 916991, (Object) null), false, false, 6, (Object) null);
    }

    public final void autoStepCompleted() {
        Timber.Forest.d("autoStepCompleted", new Object[0]);
        if (this.autoFailCount != 1 || !this.troubleshootThirdItemSelected) {
            AddDeviceState state = getState();
            updateState$default(this, AddDeviceState.copy$default(state, 0, false, state.getAutoStepsCompleted() + 1, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048571, (Object) null), false, false, 6, (Object) null);
            return;
        }
        startManualConfigClassic();
    }

    public final void autoFailStepCompleted() {
        Timber.Forest.d("autoStepCompleted", new Object[0]);
        AddDeviceState state = getState();
        updateState$default(this, AddDeviceState.copy$default(state, 0, false, 0, false, state.getAutoFailStepsCompleted() + 1, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048559, (Object) null), false, false, 6, (Object) null);
    }

    public final void startManualConfig() {
        Timber.Forest.d("startManualConfig", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1031933, (Object) null), false, false, 6, (Object) null);
    }

    public final void startManualStepTwo() {
        Timber.Forest.d("startManualConfigStepTwo", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 1, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048285, (Object) null), false, false, 6, (Object) null);
    }

    public final void manualStepCompleted() {
        Timber.Forest.d("manualStepCompleted", new Object[0]);
        AddDeviceState state = getState();
        updateState$default(this, AddDeviceState.copy$default(state, 0, false, 0, false, 0, state.getManualStepsCompleted() + 1, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048543, (Object) null), false, false, 6, (Object) null);
    }

    public final void setNetworkInfo(String str, String str2, String str3) {
        String str4 = str2;
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str4, "wifiNetworkSSID");
        Intrinsics.checkNotNullParameter(str5, "wifiNetworkPassword");
        setSettingsWiFiNetworkBSSID(str);
        setSettingsWiFiNetworkSSID(str4);
        setSettingsWiFiNetworkPassword(str5);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, true, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048319, (Object) null), false, false, 6, (Object) null);
    }

    public final void deviceConfigSuccess(DeviceInformationLegacy deviceInformationLegacy, boolean z) {
        DeviceInformationLegacy deviceInformationLegacy2 = deviceInformationLegacy;
        Intrinsics.checkNotNullParameter(deviceInformationLegacy2, "deviceInformation");
        Timber.Forest forest = Timber.Forest;
        forest.i("Pairing Success: deviceInformation = " + deviceInformationLegacy2, new Object[0]);
        PreferencesHelper.INSTANCE.set(this.prefs.getBackend(), PrefKeys.KEY_LEGACY_DEVICE_TO_DELETE, deviceInformationLegacy2.getId(), Reflection.getOrCreateKotlinClass(String.class));
        AddDeviceState state = getState();
        deviceInformationLegacy2.setModel((String) null);
        deviceInformationLegacy2.setCompatibility(DeviceUtilsLegacy.getDeviceCompatibilityForBackend(state.getDeviceType()));
        updateState$default(this, AddDeviceState.copy$default(state, 0, false, 0, false, 0, 0, false, false, false, deviceInformationLegacy2, (String) null, false, 0, false, false, false, false, 0, false, false, 1048063, (Object) null), false, false, 6, (Object) null);
    }

    public final void startManualConfigClassic() {
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 523741, (Object) null), true, false, 4, (Object) null);
    }

    public final void startManualConfigStep2Classic() {
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 1, false, false, true, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 523485, (Object) null), true, false, 4, (Object) null);
    }

    public final void startAutoOrManualClassic() {
        if (this.autoFailCount == 1) {
            getScreenChangePublisher().onNext(AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2);
            this.troubleshoot = true;
        } else {
            startActivateDeviceWifiClassic();
        }
        this.troubleshootThirdItemSelected = true;
    }

    public final void startActivateDeviceWifiClassic() {
        this.troubleshootThirdItemSelected = false;
        this.troubleshoot = true;
        clearStateHistory();
        int deviceType = getState().getDeviceType();
        this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker) null);
        initState(new AddDeviceState(deviceType, true, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, true, false, 0, false, false, 1015804, (DefaultConstructorMarker) null));
    }

    public final void startConnectToNetworkClassic() {
        clearStateHistory();
        int deviceType = getState().getDeviceType();
        this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker) null);
        initState(new AddDeviceState(deviceType, false, 1, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, true, false, 0, false, false, 1015802, (DefaultConstructorMarker) null));
    }

    public final void showAutoStep2() {
        getScreenChangePublisher().onNext(AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2);
    }

    public final void showManualStep1() {
        getScreenChangePublisher().onNext(AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1);
    }

    public final void autoConfigFail() {
        Timber.Forest.d("autoConfigFail", new Object[0]);
        if (this.troubleshootThirdItemSelected) {
            this.autoFailCount++;
        }
        AddDeviceState state = getState();
        if (state.getDeviceType() == 3) {
            troubleshoot();
        } else {
            updateState$default(this, AddDeviceState.copy$default(state, 0, false, 0, true, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048055, (Object) null), false, false, 6, (Object) null);
        }
    }

    public final void restartAddDeviceFlow() {
        Timber.Forest.d("restartAddDeviceFlow", new Object[0]);
        downdateState(new AddDeviceService$$ExternalSyntheticLambda6());
    }

    /* access modifiers changed from: private */
    public static final boolean restartAddDeviceFlow$lambda$7(AddDeviceState addDeviceState) {
        Intrinsics.checkNotNullParameter(addDeviceState, "s");
        return addDeviceState.getDeviceType() == 0;
    }

    public final void restartAutoConfig() {
        Timber.Forest.d("restartAutoConfig", new Object[0]);
        this.wifiPassword = "";
        downdateState(new AddDeviceService$$ExternalSyntheticLambda5());
    }

    /* access modifiers changed from: private */
    public static final boolean restartAutoConfig$lambda$8(AddDeviceState addDeviceState) {
        Intrinsics.checkNotNullParameter(addDeviceState, "s");
        return addDeviceState.getAutoStepsCompleted() == 0;
    }

    public final void restartManualConfig() {
        Timber.Forest.d("restartManualConfig", new Object[0]);
        this.wifiPassword = "";
        downdateState(new AddDeviceService$$ExternalSyntheticLambda7());
    }

    /* access modifiers changed from: private */
    public static final boolean restartManualConfig$lambda$9(AddDeviceState addDeviceState) {
        Intrinsics.checkNotNullParameter(addDeviceState, "s");
        return addDeviceState.getManualStepsCompleted() == 0;
    }

    public static /* synthetic */ void restartOnboarding$default(AddDeviceService addDeviceService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        addDeviceService.restartOnboarding(z);
    }

    public final void restartOnboarding(boolean z) {
        this.wifiPassword = "";
        if (z) {
            getMessageDisplayPublisher().onNext(this.resources.getString(R.string.add_classic_device_error));
        }
        clearStateHistory();
        int deviceType = getState().getDeviceType();
        this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker) null);
        initState(new AddDeviceState(deviceType, true, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048572, (DefaultConstructorMarker) null));
    }

    public final void troubleshoot() {
        this.troubleshoot = false;
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, true, 524287, (Object) null), true, false, 4, (Object) null);
    }

    public final void recommendResetDevice() {
        Timber.Forest.d("resetDevice", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, true, false, false, 0, false, false, 1032191, (Object) null), false, false, 6, (Object) null);
    }

    public final void manualConfigFailToAutoModeFailState() {
        Timber.Forest.d("manualConfigFailToAutoModeFailState", new Object[0]);
        if (getState().getDeviceType() == 3) {
            getMessageDisplayPublisher().onNext(this.resources.getString(R.string.add_classic_device_manual_error));
            restartOnboarding$default(this, false, 1, (Object) null);
            return;
        }
        getMessageDisplayPublisher().onNext(this.resources.getString(R.string.add_device_info_missing));
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, true, 0, true, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1047557, (Object) null), false, false, 6, (Object) null);
    }

    public final void successFinished() {
        Timber.Forest.d("successFinished", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 983039, (Object) null), false, false, 6, (Object) null);
    }

    public final void validateManual() {
        Timber.Forest.d("validateManual", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, true, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048511, (Object) null), false, false, 6, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object chooseDeviceName(java.lang.String r30, kotlin.coroutines.Continuation<? super kotlin.Unit> r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            boolean r3 = r2 instanceof com.blueair.adddevice.service.AddDeviceService$chooseDeviceName$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.adddevice.service.AddDeviceService$chooseDeviceName$1 r3 = (com.blueair.adddevice.service.AddDeviceService$chooseDeviceName$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.adddevice.service.AddDeviceService$chooseDeviceName$1 r3 = new com.blueair.adddevice.service.AddDeviceService$chooseDeviceName$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L_0x004d
            if (r5 != r6) goto L_0x0045
            java.lang.Object r1 = r3.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r3.L$2
            com.blueair.adddevice.DeviceInformationLegacy r1 = (com.blueair.adddevice.DeviceInformationLegacy) r1
            java.lang.Object r4 = r3.L$1
            com.blueair.adddevice.model.AddDeviceState r4 = (com.blueair.adddevice.model.AddDeviceState) r4
            java.lang.Object r3 = r3.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r17 = r3
            r6 = r4
            goto L_0x00a3
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r2)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "chooseDeviceName: "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r2.d(r5, r7)
            com.blueair.adddevice.model.AddDeviceState r2 = r0.getState()
            com.blueair.adddevice.DeviceInformationLegacy r7 = r2.getDeviceInfo()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r15 = 127(0x7f, float:1.78E-43)
            r16 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            com.blueair.adddevice.DeviceInformationLegacy r5 = com.blueair.adddevice.DeviceInformationLegacy.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r5.setName(r1)
            java.lang.String r7 = r5.getId()
            com.blueair.devicemanager.DeviceManager r8 = r0.deviceManager
            r3.L$0 = r1
            r3.L$1 = r2
            r3.L$2 = r5
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$3 = r9
            r3.label = r6
            java.lang.Object r3 = r8.setAblDeviceName(r7, r1, r3)
            if (r3 != r4) goto L_0x009e
            return r4
        L_0x009e:
            r17 = r1
            r6 = r2
            r16 = r5
        L_0x00a3:
            com.blueair.adddevice.model.AddDeviceState r1 = r0.getState()
            int r1 = r1.getDeviceType()
            r2 = 40
            if (r1 != r2) goto L_0x00db
            r27 = 719359(0xaf9ff, float:1.008037E-39)
            r28 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1
            r24 = 0
            r25 = 1
            r26 = 0
            com.blueair.adddevice.model.AddDeviceState r1 = com.blueair.adddevice.model.AddDeviceState.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            updateState$default(r0, r1, r2, r3, r4, r5)
            goto L_0x0108
        L_0x00db:
            r27 = 981503(0xef9ff, float:1.375379E-39)
            r28 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1
            r24 = 0
            r25 = 0
            r26 = 0
            com.blueair.adddevice.model.AddDeviceState r1 = com.blueair.adddevice.model.AddDeviceState.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r29
            updateState$default(r0, r1, r2, r3, r4, r5)
        L_0x0108:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.service.AddDeviceService.chooseDeviceName(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void addOnbackendSuccess() {
        Timber.Forest.d("addOnbackendSuccess", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, true, 0, false, false, false, false, 0, false, false, 1046527, (Object) null), false, false, 6, (Object) null);
    }

    public final void addOnBackendFail() {
        String str;
        Timber.Forest.d("addOnBackendFail", new Object[0]);
        int deviceType = getState().getDeviceType();
        if (deviceType == 1) {
            str = DeviceType.Aware.INSTANCE.getName();
        } else if (deviceType == 2) {
            str = DeviceType.Sense.INSTANCE.getName();
        } else if (deviceType == 3) {
            str = DeviceType.Classic.INSTANCE.getName();
        } else if (deviceType != 40) {
            str = DeviceType.Companion.fromIndex(getState().getDeviceType()).getName();
        } else {
            str = DeviceType.Icp.INSTANCE.getName();
        }
        if (getState().getCurrentConfigMode() == 0) {
            autoConfigFail();
            this.analyticsService.amplitudeLog((AmplitudeEvent) new OnboardingFailureEvent(str, true, "Automatic pairing failed, missing device info"));
            return;
        }
        manualConfigFailToAutoModeFailState();
        this.analyticsService.amplitudeLog((AmplitudeEvent) new OnboardingFailureEvent(str, false, "Manual pairing failed, missing device info"));
    }

    public final String getSettingsWiFiNetworkSSID() {
        return (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), WIFI_SSID_KEY, "", Reflection.getOrCreateKotlinClass(String.class));
    }

    public final String getCurrentNetworkSSIDEstimate() {
        String activeWifiSSID = NetUtil.INSTANCE.getActiveWifiSSID(this.context);
        if (activeWifiSSID == null || DeviceUtilsLegacy.INSTANCE.isManualDeviceNetwork(activeWifiSSID)) {
            return getSettingsWiFiNetworkSSID();
        }
        return activeWifiSSID;
    }

    public final void setSettingsWiFiNetworkBSSID(String str) {
        if (str != null) {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), WIFI_BSSID_KEY, str, Reflection.getOrCreateKotlinClass(String.class));
        }
    }

    public final void setSettingsWiFiNetworkSSID(String str) {
        if (str != null) {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), WIFI_SSID_KEY, str, Reflection.getOrCreateKotlinClass(String.class));
        }
    }

    public final String getSettingsWiFiNetworkPassword() {
        return (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), WIFI_PASSWORD_KEY, "", Reflection.getOrCreateKotlinClass(String.class));
    }

    public final void setSettingsWiFiNetworkPassword(String str) {
        if (str != null) {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), WIFI_PASSWORD_KEY, str, Reflection.getOrCreateKotlinClass(String.class));
        }
    }

    public static /* synthetic */ void autoPairDevice$default(AddDeviceService addDeviceService, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addDeviceService.getSettingsWiFiNetworkSSID();
        }
        if ((i & 2) != 0) {
            str2 = addDeviceService.getSettingsWiFiNetworkPassword();
        }
        addDeviceService.autoPairDevice(str, str2);
    }

    public final void autoPairDevice(String str, String str2) {
        Timber.Forest forest = Timber.Forest;
        forest.d("autoPairDevice: networkSSID = " + str + ", networkPassPhrase = " + str2, new Object[0]);
        if (str == null || str2 == null) {
            Timber.Forest.d("autoPairDevice: Automatic pairing failed, missing network access info", new Object[0]);
            autoConfigFail();
            return;
        }
        DevicePairManager.INSTANCE.performAutomaticPairing(this.context, str, str2, new AddDeviceService$autoPairDevice$1(this));
    }

    public final Completable manualPairDeviceAsync() {
        Completable fromCallable = Completable.fromCallable(new AddDeviceService$$ExternalSyntheticLambda3(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable(...)");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    public static final Unit manualPairDeviceAsync$lambda$10(AddDeviceService addDeviceService) {
        manualPairDevice$default(addDeviceService, (String) null, (String) null, 3, (Object) null);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void manualPairDevice$default(AddDeviceService addDeviceService, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addDeviceService.getSettingsWiFiNetworkSSID();
        }
        if ((i & 2) != 0) {
            str2 = addDeviceService.getSettingsWiFiNetworkPassword();
        }
        addDeviceService.manualPairDevice(str, str2);
    }

    private final void manualPairDevice(String str, String str2) {
        Timber.Forest forest = Timber.Forest;
        forest.d("manualPairDevice: networkSSID = " + str + ", networkPassPhrase = " + str2, new Object[0]);
        Object systemService = this.context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addTransportType(1);
        connectivityManager.requestNetwork(builder.build(), new AddDeviceService$manualPairDevice$1(connectivityManager, str, str2, this));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x00e9: MOVE  (r5v4 java.lang.CharSequence) = (r2v8 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    public final java.lang.Object addDeviceForActiveUser(com.blueair.adddevice.DeviceInformationLegacy r13, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<kotlin.Unit>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.blueair.adddevice.service.AddDeviceService$addDeviceForActiveUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.blueair.adddevice.service.AddDeviceService$addDeviceForActiveUser$1 r0 = (com.blueair.adddevice.service.AddDeviceService$addDeviceForActiveUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.service.AddDeviceService$addDeviceForActiveUser$1 r0 = new com.blueair.adddevice.service.AddDeviceService$addDeviceForActiveUser$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 1
            r6 = 0
            r7 = 2
            r8 = 0
            if (r2 == 0) goto L_0x0074
            if (r2 == r5) goto L_0x006c
            if (r2 == r7) goto L_0x005b
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r13 = r0.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r0.L$1
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            java.lang.Object r13 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r13 = (com.blueair.adddevice.DeviceInformationLegacy) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0163
        L_0x0042:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x004a:
            java.lang.Object r13 = r0.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r0.L$1
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            java.lang.Object r4 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r4 = (com.blueair.adddevice.DeviceInformationLegacy) r4
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0146
        L_0x005b:
            java.lang.Object r13 = r0.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r0.L$1
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            java.lang.Object r5 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r5 = (com.blueair.adddevice.DeviceInformationLegacy) r5
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0111
        L_0x006c:
            java.lang.Object r13 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r13 = (com.blueair.adddevice.DeviceInformationLegacy) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00da
        L_0x0074:
            kotlin.ResultKt.throwOnFailure(r14)
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r9 = "addDevice: origDeviceInfo = "
            r2.<init>(r9)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r14.d(r2, r9)
            java.lang.String r14 = r13.getId()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r2 = "LPB100"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r14 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r2, (boolean) r8, (int) r7, (java.lang.Object) r6)
            if (r14 == 0) goto L_0x00ac
            io.flatcircle.coroutinehelper.ApiResult$Companion r13 = io.flatcircle.coroutinehelper.ApiResult.Companion
            com.blueair.adddevice.DeviceUtilsLegacy$AddDeviceBackendException r14 = new com.blueair.adddevice.DeviceUtilsLegacy$AddDeviceBackendException
            java.lang.String r0 = "DeviceInfoData could not be verified, wrong uuid LPB100 info sent."
            r14.<init>(r0)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            io.flatcircle.coroutinehelper.ApiResult r13 = r13.fail(r14)
            return r13
        L_0x00ac:
            com.blueair.devicemanager.DeviceManager r14 = r12.deviceManager
            java.lang.String r2 = r13.getId()
            java.lang.String r9 = r13.getMacAddress()
            if (r9 != 0) goto L_0x00ba
            java.lang.String r9 = ""
        L_0x00ba:
            com.blueair.core.model.DeviceType$Companion r10 = com.blueair.core.model.DeviceType.Companion
            java.lang.String r11 = r13.getCompatibility()
            com.blueair.core.model.DeviceType r10 = r10.fromSkuCompat(r11)
            com.blueair.core.model.DeviceType$Icp r11 = com.blueair.core.model.DeviceType.Icp.INSTANCE
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r14 = r14.getVerifiedDeviceId(r2, r9, r10, r0)
            if (r14 != r1) goto L_0x00da
            goto L_0x0162
        L_0x00da:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            java.lang.Object r2 = r14.getOrNull()
            java.lang.String r2 = (java.lang.String) r2
            boolean r5 = r14.isFailure()
            if (r5 != 0) goto L_0x01c7
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x01c7
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00f5
            goto L_0x01c7
        L_0x00f5:
            com.blueair.devicemanager.DeviceManager r5 = r12.deviceManager
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r0.L$1 = r9
            r0.L$2 = r2
            r0.label = r7
            java.lang.Object r5 = r5.addDeviceRemote(r2, r0)
            if (r5 != r1) goto L_0x010e
            goto L_0x0162
        L_0x010e:
            r5 = r13
            r13 = r2
            r2 = r14
        L_0x0111:
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "addDevice: Success adding a device "
            r7.<init>(r9)
            r7.append(r13)
            java.lang.String r9 = " to owner."
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r14.v(r7, r9)
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r14
            r0.L$2 = r13
            r0.label = r4
            r9 = 40000(0x9c40, double:1.97626E-319)
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r9, r0)
            if (r14 != r1) goto L_0x0145
            goto L_0x0162
        L_0x0145:
            r4 = r5
        L_0x0146:
            com.blueair.devicemanager.DeviceManager r14 = r12.deviceManager
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$0 = r4
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r14 = r14.getAblDeviceInfo(r13, r0)
            if (r14 != r1) goto L_0x0163
        L_0x0162:
            return r1
        L_0x0163:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            java.lang.Object r13 = r14.getOrNull()
            com.blueair.core.model.DeviceDetailsOnAblServer r13 = (com.blueair.core.model.DeviceDetailsOnAblServer) r13
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "addDevice: verifiedDeviceInfoData = "
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r0.d(r1, r2)
            if (r13 == 0) goto L_0x0186
            java.lang.String r6 = r13.getCompatibility()
        L_0x0186:
            boolean r14 = r14.isFailure()
            if (r14 != 0) goto L_0x01ab
            if (r13 == 0) goto L_0x01ab
            r14 = r6
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            if (r14 == 0) goto L_0x01ab
            int r14 = r14.length()
            if (r14 != 0) goto L_0x019a
            goto L_0x01ab
        L_0x019a:
            r12.addDeviceToDb(r13)
            com.blueair.devicemanager.DeviceManager r14 = r12.deviceManager
            r14.initNewDevice(r13)
            io.flatcircle.coroutinehelper.ApiResult$Companion r13 = io.flatcircle.coroutinehelper.ApiResult.Companion
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            io.flatcircle.coroutinehelper.ApiResult r13 = r13.success(r14)
            return r13
        L_0x01ab:
            io.flatcircle.coroutinehelper.ApiResult$Companion r13 = io.flatcircle.coroutinehelper.ApiResult.Companion
            com.blueair.adddevice.DeviceUtilsLegacy$AddDeviceBackendException r14 = new com.blueair.adddevice.DeviceUtilsLegacy$AddDeviceBackendException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "DeviceInfoData could not be verified, info was "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            io.flatcircle.coroutinehelper.ApiResult r13 = r13.fail(r14)
            return r13
        L_0x01c7:
            io.flatcircle.coroutinehelper.ApiResult$Companion r13 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r13 = r13.fromResult(r14, r6)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.service.AddDeviceService.addDeviceForActiveUser(com.blueair.adddevice.DeviceInformationLegacy, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object migrationOtaCheck(Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AddDeviceService$migrationOtaCheck$2(this, function1, (Continuation<? super AddDeviceService$migrationOtaCheck$2>) null), continuation);
    }

    public final Single<Boolean> otaUpdateRunningCheckAsync() {
        Timber.Forest.d("otaUpdateRunningCheckAsync()", new Object[0]);
        Single<Boolean> fromCallable = Single.fromCallable(new AddDeviceService$$ExternalSyntheticLambda4(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable(...)");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    public static final Boolean otaUpdateRunningCheckAsync$lambda$11(AddDeviceService addDeviceService) {
        return Boolean.valueOf(addDeviceService.otaUpdateRunningCheck());
    }

    public final void forceOtaCompleted() {
        Timber.Forest.d("forceOtaCompleted", new Object[0]);
        updateState$default(this, AddDeviceState.copy$default(getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, true, false, false, false, 0, false, false, 1040383, (Object) null), false, false, 6, (Object) null);
    }

    private final boolean otaUpdateRunningCheck() {
        Timber.Forest.d("otaUpdateRunningCheck()", new Object[0]);
        AddDeviceState state = getState();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (state.getDeviceInfo() != null) {
            try {
                Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new AddDeviceService$otaUpdateRunningCheck$1$1(booleanRef, BuildersKt__Builders_commonKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceService$otaUpdateRunningCheck$1$job$1(this, state, (Continuation<? super AddDeviceService$otaUpdateRunningCheck$1$job$1>) null), 3, (Object) null), (Continuation<? super AddDeviceService$otaUpdateRunningCheck$1$1>) null), 1, (Object) null);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.d("runBlocking failed with exception = " + e, new Object[0]);
            }
            int otaCheckAttempt = state.getOtaCheckAttempt() + 1;
            updateState$default(this, AddDeviceState.copy$default(state, 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, otaCheckAttempt, booleanRef.element || otaCheckAttempt >= 3, false, false, false, 0, false, false, 1036287, (Object) null), false, false, 6, (Object) null);
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("otaUpdateRunningCheck() : indoorService.isOTAUpdateRunning(" + state.getDeviceInfo().getId() + ") == " + booleanRef.element, new Object[0]);
        }
        return booleanRef.element;
    }

    public final boolean isUserLoggedIn() {
        return this.authService.isUserLoggedIn().getValue().booleanValue();
    }

    public final Object fetchDeviceStatus(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AddDeviceService$fetchDeviceStatus$2(this, str, (Continuation<? super AddDeviceService$fetchDeviceStatus$2>) null), continuation);
    }

    public final void updateDeviceStatusLocalToOtaUpdating(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceUid");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new AddDeviceService$updateDeviceStatusLocalToOtaUpdating$1(this, str, (Continuation<? super AddDeviceService$updateDeviceStatusLocalToOtaUpdating$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final DeviceDetailsOnAblServer migrationOtaCheck(DeviceDetailsOnAblServer deviceDetailsOnAblServer, ApiResult<MigrationOtaResponse> apiResult) {
        Timber.Forest forest = Timber.Forest;
        forest.d(" migrationOtaCheck: deviceInfo = " + deviceDetailsOnAblServer + ", migrationResponse = " + apiResult.getOrNull(), new Object[0]);
        MigrationOtaResponse orNull = apiResult.getOrNull();
        if (!this.deviceManager.isProbablyInMigrationOta(apiResult)) {
            return deviceDetailsOnAblServer;
        }
        String compatibility = orNull != null ? orNull.getCompatibility() : null;
        DeviceDetailsOnAblServer deviceDetailsOnAblServer2 = deviceDetailsOnAblServer;
        DeviceDetailsOnAblServer copy$default = DeviceDetailsOnAblServer.copy$default(deviceDetailsOnAblServer2, compatibility, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, TypedValues.PositionType.TYPE_POSITION_TYPE, (Object) null);
        updateDeviceStatusLocalToOtaUpdating(deviceDetailsOnAblServer2.getUuid());
        return copy$default;
    }

    /* access modifiers changed from: private */
    public final void firmwareVersionCheck(DeviceDetailsOnAblServer deviceDetailsOnAblServer) {
        if (!AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(deviceDetailsOnAblServer)) {
            Timber.Forest forest = Timber.Forest;
            forest.d("firmwareVersionCheck: deviceInfo = " + deviceDetailsOnAblServer + ", hasAtLeastMinimumWifiFirmwareVersion = false", new Object[0]);
            updateDeviceStatusLocalToOtaUpdating(deviceDetailsOnAblServer.getUuid());
        }
    }

    private final void addDeviceToDb(DeviceDetailsOnAblServer deviceDetailsOnAblServer) {
        Timber.Forest forest = Timber.Forest;
        forest.d("addDeviceToDb: deviceInfo = " + deviceDetailsOnAblServer, new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new AddDeviceService$addDeviceToDb$1(this, deviceDetailsOnAblServer, (Continuation<? super AddDeviceService$addDeviceToDb$1>) null), 2, (Object) null);
    }
}
