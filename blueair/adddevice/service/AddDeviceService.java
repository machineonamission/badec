package com.blueair.adddevice.service;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.DevicePairManager;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
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
import io.flatcircle.preferenceshelper2.Prefs;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ³\u00012\u00020\u0001:\u0002³\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020A2\b\b\u0002\u0010T\u001a\u00020AH\u0002J\u001c\u0010U\u001a\u00020Q2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020A0WH\u0002J\u0006\u0010X\u001a\u00020AJ\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00140<H\u0002J\u0016\u0010Z\u001a\u00020Q2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00140<H\u0002J\u0010\u0010\\\u001a\u00020Q2\u0006\u0010]\u001a\u00020\u0014H\u0002J\b\u0010^\u001a\u00020QH\u0002J\u0010\u0010_\u001a\u00020Q2\b\u0010`\u001a\u0004\u0018\u00010\u0014J\u000e\u0010a\u001a\u00020Q2\u0006\u0010b\u001a\u00020OJ\u0006\u0010c\u001a\u00020QJ\u0006\u0010d\u001a\u00020QJ\u0006\u0010e\u001a\u00020QJ\u000e\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020hJ\u0006\u0010i\u001a\u00020QJ\u0006\u0010j\u001a\u00020QJ\u0006\u0010k\u001a\u00020QJ\u0006\u0010l\u001a\u00020QJ\u0006\u0010m\u001a\u00020QJ \u0010n\u001a\u00020Q2\b\u0010o\u001a\u0004\u0018\u00010*2\u0006\u0010p\u001a\u00020*2\u0006\u0010q\u001a\u00020*J\u0016\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020AJ\u0006\u0010v\u001a\u00020QJ\u0006\u0010w\u001a\u00020QJ\u0006\u0010x\u001a\u00020QJ\u0006\u0010y\u001a\u00020QJ\u0006\u0010z\u001a\u00020QJ\u0006\u0010{\u001a\u00020QJ\u0006\u0010|\u001a\u00020QJ\u0006\u0010}\u001a\u00020QJ\u0006\u0010~\u001a\u00020QJ\u0006\u0010\u007f\u001a\u00020QJ\u0007\u0010\u0080\u0001\u001a\u00020QJ\u0012\u0010\u0081\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0082\u0001\u001a\u00020AJ\u0006\u0010@\u001a\u00020QJ\u0007\u0010\u0083\u0001\u001a\u00020QJ\u0007\u0010\u0084\u0001\u001a\u00020QJ\u0007\u0010\u0085\u0001\u001a\u00020QJ\u0007\u0010\u0086\u0001\u001a\u00020QJ\u0019\u0010\u0087\u0001\u001a\u00020Q2\u0007\u0010\u0088\u0001\u001a\u00020*H\u0086@¢\u0006\u0003\u0010\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020QJ\u0007\u0010\u008b\u0001\u001a\u00020QJ\u0007\u0010\u008c\u0001\u001a\u00020*J\u0007\u0010\u008d\u0001\u001a\u00020*J\u0012\u0010\u008e\u0001\u001a\u00020Q2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010*J\u0012\u0010\u0090\u0001\u001a\u00020Q2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010*J\u0007\u0010\u0092\u0001\u001a\u00020*J\u0011\u0010\u0093\u0001\u001a\u00020Q2\b\u0010F\u001a\u0004\u0018\u00010*J!\u0010\u0094\u0001\u001a\u00020Q2\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010*2\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010*J\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J#\u0010\u0099\u0001\u001a\u00020Q2\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010*2\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010*H\u0002J \u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020tH\u0086@¢\u0006\u0003\u0010\u009d\u0001J9\u0010\u009e\u0001\u001a\u0004\u0018\u00010Q2%\u0010\u009f\u0001\u001a \u0012\u0016\u0012\u00140*¢\u0006\u000f\b \u0001\u0012\n\b¡\u0001\u0012\u0005\b\b(¢\u0001\u0012\u0004\u0012\u00020Q0WH\u0086@¢\u0006\u0003\u0010£\u0001J\u000e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020A0¥\u0001J\u0007\u0010¦\u0001\u001a\u00020QJ\t\u0010§\u0001\u001a\u00020AH\u0002J\u0007\u0010¨\u0001\u001a\u00020AJ\u0019\u0010©\u0001\u001a\u00020A2\u0007\u0010ª\u0001\u001a\u00020*H\u0086@¢\u0006\u0003\u0010\u0089\u0001J\u0010\u0010«\u0001\u001a\u00020Q2\u0007\u0010¬\u0001\u001a\u00020*J%\u0010\u009e\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030\u00ad\u00012\u000f\u0010¯\u0001\u001a\n\u0012\u0005\u0012\u00030°\u00010\u009b\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00020Q2\b\u0010®\u0001\u001a\u00030\u00ad\u0001H\u0002J\u0013\u0010²\u0001\u001a\u00020Q2\b\u0010®\u0001\u001a\u00030\u00ad\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR5\u0010\u001f\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b%\u0010\u001cR5\u0010'\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b(\u0010#R!\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b+\u0010\u001cR5\u0010-\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010*0* !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010*0*\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b.\u0010#R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b0\u0010\u001cR5\u00103\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b4\u0010#R!\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b6\u0010\u001cR5\u00108\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00140\u0014\u0018\u00010 0 8F¢\u0006\u0006\u001a\u0004\b9\u0010#R'\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140<0;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00102\u001a\u0004\b=\u0010>R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010L\u001a\u00020A2\u0006\u0010K\u001a\u00020A@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010CR\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006´\u0001"},
   d2 = {"Lcom/blueair/adddevice/service/AddDeviceService;", "", "context", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "authService", "Lcom/blueair/auth/AuthService;", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Landroid/content/Context;Landroid/content/res/Resources;Lcom/blueair/devicemanager/DeviceManager;Lcom/blueair/auth/AuthService;Lcom/blueair/core/service/SecurePrefs;Lcom/blueair/core/service/UnsecurePrefs;Lcom/blueair/core/service/AnalyticsService;)V", "syncLock", "_state", "Lcom/blueair/adddevice/model/AddDeviceState;", "state", "getState", "()Lcom/blueair/adddevice/model/AddDeviceState;", "screenChangePublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "getScreenChangePublisher", "()Lio/reactivex/subjects/PublishSubject;", "screenChangePublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "screenChangeObserver", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "getScreenChangeObserver", "()Lio/reactivex/Observable;", "screenRevertPublisher", "getScreenRevertPublisher", "screenRevertPublisher$delegate", "screenRevertObserver", "getScreenRevertObserver", "messageDisplayPublisher", "", "getMessageDisplayPublisher", "messageDisplayPublisher$delegate", "messageDisplayObserver", "getMessageDisplayObserver", "performBackendAddPublisher", "getPerformBackendAddPublisher", "performBackendAddPublisher$delegate", "Lkotlin/Lazy;", "performBackendAddObserver", "getPerformBackendAddObserver", "successPublisher", "getSuccessPublisher", "successPublisher$delegate", "successObserver", "getSuccessObserver", "stateHistorySerializer", "Lcom/blueair/core/util/MoshiSerializer;", "", "getStateHistorySerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "stateHistorySerializer$delegate", "troubleshoot", "", "getTroubleshoot", "()Z", "setTroubleshoot", "(Z)V", "wifiPassword", "getWifiPassword", "()Ljava/lang/String;", "setWifiPassword", "(Ljava/lang/String;)V", "value", "troubleshootThirdItemSelected", "getTroubleshootThirdItemSelected", "autoFailCount", "", "updateState", "", "nuState", "changeScreen", "doSave", "downdateState", "requirement", "Lkotlin/Function1;", "popState", "loadStateHistory", "saveHistory", "history", "saveState", "theState", "clearStateHistory", "initState", "origState", "selectDevice", "nuDeviceType", "setupTextCompleted", "icpAddDeviceCompleted", "icpSetupDeviceCompleted", "icpPairingCompleted", "icpDeviceInfo", "Lcom/blueair/devicemanager/IcpDeviceInfo;", "autoStepCompleted", "autoFailStepCompleted", "startManualConfig", "startManualStepTwo", "manualStepCompleted", "setNetworkInfo", "wifiNetworkBSSID", "wifiNetworkSSID", "wifiNetworkPassword", "deviceConfigSuccess", "deviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "auto", "startManualConfigClassic", "startManualConfigStep2Classic", "startAutoOrManualClassic", "startActivateDeviceWifiClassic", "startConnectToNetworkClassic", "showAutoStep2", "showManualStep1", "autoConfigFail", "restartAddDeviceFlow", "restartAutoConfig", "restartManualConfig", "restartOnboarding", "showMessage", "recommendResetDevice", "manualConfigFailToAutoModeFailState", "successFinished", "validateManual", "chooseDeviceName", "nuDeviceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addOnbackendSuccess", "addOnBackendFail", "getSettingsWiFiNetworkSSID", "getCurrentNetworkSSIDEstimate", "setSettingsWiFiNetworkBSSID", "wifiBSSID", "setSettingsWiFiNetworkSSID", "wifiSSID", "getSettingsWiFiNetworkPassword", "setSettingsWiFiNetworkPassword", "autoPairDevice", "networkSSID", "networkPassPhrase", "manualPairDeviceAsync", "Lio/reactivex/Completable;", "manualPairDevice", "addDeviceForActiveUser", "Lio/flatcircle/coroutinehelper/ApiResult;", "origDeviceInfo", "(Lcom/blueair/adddevice/DeviceInformationLegacy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrationOtaCheck", "onFailure", "Lkotlin/ParameterName;", "name", "errorMsg", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "otaUpdateRunningCheckAsync", "Lio/reactivex/Single;", "forceOtaCompleted", "otaUpdateRunningCheck", "isUserLoggedIn", "fetchDeviceStatus", "deviceUUID", "updateDeviceStatusLocalToOtaUpdating", "deviceUid", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "deviceInfo", "migrationOtaCall", "Lcom/blueair/core/model/MigrationOtaResponse;", "firmwareVersionCheck", "addDeviceToDb", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceService {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceService.class, "screenChangePublisher", "getScreenChangePublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceService.class, "screenRevertPublisher", "getScreenRevertPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceService.class, "messageDisplayPublisher", "getMessageDisplayPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   private static final long ARTIFICIAL_DELAY = 40000L;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String FOOBOT = "foobot";
   public static final int OTA_CHECK_MAX_RETRIES = 3;
   public static final String STATE_HISTORY_KEY = "state_history";
   public static final String USER_FRIENDLY_MIGRATION_OTA_FAILURE_MSG = "There was an error processing this request. Please try again";
   public static final String WIFI_BSSID_KEY = "wifi_bssid_add";
   public static final String WIFI_PASSWORD_KEY = "password_wifi";
   public static final String WIFI_SSID_KEY = "wifi_ssid_add";
   private AddDeviceState _state;
   private final AnalyticsService analyticsService;
   private final AuthService authService;
   private int autoFailCount;
   private final Context context;
   private final DeviceManager deviceManager;
   private final LazyPublishSubject messageDisplayPublisher$delegate;
   private final Lazy performBackendAddPublisher$delegate;
   private final UnsecurePrefs prefs;
   private final Resources resources;
   private final LazyPublishSubject screenChangePublisher$delegate;
   private final LazyPublishSubject screenRevertPublisher$delegate;
   private final SecurePrefs securePrefs;
   private final Lazy stateHistorySerializer$delegate;
   private final Lazy successPublisher$delegate;
   private final Object syncLock;
   private boolean troubleshoot;
   private boolean troubleshootThirdItemSelected;
   private String wifiPassword;

   // $FF: synthetic method
   public static Unit $r8$lambda$7F4c_RORTuloV7oMC5Jhsjkgzq4/* $FF was: $r8$lambda$7F4c-RORTuloV7oMC5Jhsjkgzq4*/(AddDeviceService var0) {
      return manualPairDeviceAsync$lambda$10(var0);
   }

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$H6WC6v_cIwGRYRIP_hQgSuCC2y4/* $FF was: $r8$lambda$H6WC6v-cIwGRYRIP-hQgSuCC2y4*/() {
      return performBackendAddPublisher_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$XNA6Pyc22V8t_uIG3xaI23l_s6w/* $FF was: $r8$lambda$XNA6Pyc22V8t-uIG3xaI23l-s6w*/() {
      return successPublisher_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$XUCBw3jj6R_QokJ2btqI0SuX7Ho(AddDeviceState var0) {
      return restartAddDeviceFlow$lambda$7(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$jyz7tu6upk1T52ODLtKTt5iC6Z4(AddDeviceState var0) {
      return restartManualConfig$lambda$9(var0);
   }

   // $FF: synthetic method
   public static MoshiSerializer $r8$lambda$lAaySw2G1gzIr8jOMhlGvr6wSlo() {
      return stateHistorySerializer_delegate$lambda$2();
   }

   // $FF: synthetic method
   public static Boolean $r8$lambda$nSdcGJGxW3_RswFXf73rlxQ_RaQ(AddDeviceService var0) {
      return otaUpdateRunningCheckAsync$lambda$11(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$pNUzR_JWCKyZ9JCFf2VUGRlmeEY/* $FF was: $r8$lambda$pNUzR-JWCKyZ9JCFf2VUGRlmeEY*/(AddDeviceState var0) {
      return restartAutoConfig$lambda$8(var0);
   }

   public AddDeviceService(Context var1, Resources var2, DeviceManager var3, AuthService var4, SecurePrefs var5, UnsecurePrefs var6, AnalyticsService var7) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "resources");
      Intrinsics.checkNotNullParameter(var3, "deviceManager");
      Intrinsics.checkNotNullParameter(var4, "authService");
      Intrinsics.checkNotNullParameter(var5, "securePrefs");
      Intrinsics.checkNotNullParameter(var6, "prefs");
      Intrinsics.checkNotNullParameter(var7, "analyticsService");
      super();
      this.context = var1;
      this.resources = var2;
      this.deviceManager = var3;
      this.authService = var4;
      this.securePrefs = var5;
      this.prefs = var6;
      this.analyticsService = var7;
      this.syncLock = new Object();
      this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null);
      this.screenChangePublisher$delegate = new LazyPublishSubject();
      this.screenRevertPublisher$delegate = new LazyPublishSubject();
      this.messageDisplayPublisher$delegate = new LazyPublishSubject();
      this.performBackendAddPublisher$delegate = LazyKt.lazy(new AddDeviceService$$ExternalSyntheticLambda0());
      this.successPublisher$delegate = LazyKt.lazy(new AddDeviceService$$ExternalSyntheticLambda1());
      this.stateHistorySerializer$delegate = LazyKt.lazy(new AddDeviceService$$ExternalSyntheticLambda2());
      this.wifiPassword = "";
   }

   private final void addDeviceToDb(DeviceDetailsOnAblServer var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("addDeviceToDb: deviceInfo = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final DeviceDetailsOnAblServer $deviceInfo;
         int label;
         final AddDeviceService this$0;

         {
            this.this$0 = var1;
            this.$deviceInfo = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceInfo, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               this.this$0.deviceManager.addAblDeviceToDb(this.$deviceInfo);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, 2, (Object)null);
   }

   // $FF: synthetic method
   public static void autoPairDevice$default(AddDeviceService var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.getSettingsWiFiNetworkSSID();
      }

      if ((var3 & 2) != 0) {
         var2 = var0.getSettingsWiFiNetworkPassword();
      }

      var0.autoPairDevice(var1, var2);
   }

   private final void clearStateHistory() {
      Timber.Forest.d("clearStateHistory", new Object[0]);
      this.securePrefs.remove("state_history");
   }

   private final void downdateState(Function1 var1) {
      Object var5 = this.syncLock;
      synchronized(var5){}

      Throwable var10000;
      label739: {
         boolean var4;
         try {
            Timber.Forest.d("downdateState", new Object[0]);
            var4 = (Boolean)var1.invoke(this.getState());
         } catch (Throwable var80) {
            var10000 = var80;
            boolean var10001 = false;
            break label739;
         }

         if (var4) {
            return;
         }

         List var6;
         ListIterator var86;
         try {
            var6 = this.loadStateHistory();
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var7 = new StringBuilder("downdateState: stateHistory.size = ");
            var7.append(var6.size());
            var8.d(var7.toString(), new Object[0]);
            var86 = var6.listIterator(var6.size());
         } catch (Throwable var78) {
            var10000 = var78;
            boolean var90 = false;
            break label739;
         }

         int var2;
         label723: {
            try {
               while(var86.hasPrevious()) {
                  if ((Boolean)var1.invoke((AddDeviceState)var86.previous())) {
                     var2 = var86.nextIndex();
                     break label723;
                  }
               }
            } catch (Throwable var79) {
               var10000 = var79;
               boolean var91 = false;
               break label739;
            }

            var2 = -1;
         }

         try {
            Timber.Forest var87 = Timber.Forest;
            StringBuilder var81 = new StringBuilder();
            var81.append("downdateState: validStateIndex = ");
            var81.append(var2);
            var87.d(var81.toString(), new Object[0]);
         } catch (Throwable var77) {
            var10000 = var77;
            boolean var92 = false;
            break label739;
         }

         if (var2 >= 0) {
            int var3;
            try {
               var82 = (AddDeviceState)var6.get(var2);
               var88 = CollectionsKt.toMutableList((Collection)var6);
               var3 = var6.size() - 1;
            } catch (Throwable var76) {
               var10000 = var76;
               boolean var93 = false;
               break label739;
            }

            if (var2 <= var3) {
               while(true) {
                  try {
                     var88.remove(var3);
                  } catch (Throwable var75) {
                     var10000 = var75;
                     boolean var94 = false;
                     break label739;
                  }

                  if (var3 == var2) {
                     break;
                  }

                  --var3;
               }
            }

            try {
               this.saveHistory(var88);
               this._state = var82;
               Timber.Forest var89 = Timber.Forest;
               StringBuilder var85 = new StringBuilder();
               var85.append("downdateState: nuState = ");
               var85.append(var82);
               var89.d(var85.toString(), new Object[0]);
               this.getScreenRevertPublisher().onNext(AddDeviceUtils.INSTANCE.getScreen(var82));
            } catch (Throwable var74) {
               var10000 = var74;
               boolean var95 = false;
               break label739;
            }
         }

         try {
            Unit var84 = Unit.INSTANCE;
         } catch (Throwable var73) {
            var10000 = var73;
            boolean var96 = false;
            break label739;
         }

         return;
      }

      Throwable var83 = var10000;
      throw var83;
   }

   private final void firmwareVersionCheck(DeviceDetailsOnAblServer var1) {
      if (!AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(var1)) {
         Timber.Forest var2 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("firmwareVersionCheck: deviceInfo = ");
         var3.append(var1);
         var3.append(", hasAtLeastMinimumWifiFirmwareVersion = false");
         var2.d(var3.toString(), new Object[0]);
         this.updateDeviceStatusLocalToOtaUpdating(var1.getUuid());
      }

   }

   private final PublishSubject getMessageDisplayPublisher() {
      return this.messageDisplayPublisher$delegate.getValue(this, $$delegatedProperties[2]);
   }

   private final PublishSubject getPerformBackendAddPublisher() {
      Object var1 = this.performBackendAddPublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private final PublishSubject getScreenChangePublisher() {
      return this.screenChangePublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final PublishSubject getScreenRevertPublisher() {
      return this.screenRevertPublisher$delegate.getValue(this, $$delegatedProperties[1]);
   }

   private final MoshiSerializer getStateHistorySerializer() {
      return (MoshiSerializer)this.stateHistorySerializer$delegate.getValue();
   }

   private final PublishSubject getSuccessPublisher() {
      Object var1 = this.successPublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private final List loadStateHistory() {
      Prefs var1 = this.securePrefs;
      String var2 = (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "state_history", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("loadStateHistory: history json = ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
      List var6 = (List)this.getStateHistorySerializer().fromJson(var2);
      List var5 = var6;
      if (var6 == null) {
         var5 = CollectionsKt.emptyList();
      }

      return var5;
   }

   private final void manualPairDevice(String var1, String var2) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("manualPairDevice: networkSSID = ");
      var3.append(var1);
      var3.append(", networkPassPhrase = ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
      Object var5 = this.context.getSystemService("connectivity");
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type android.net.ConnectivityManager");
      ConnectivityManager var7 = (ConnectivityManager)var5;
      NetworkRequest.Builder var6 = new NetworkRequest.Builder();
      var6.addTransportType(1);
      var7.requestNetwork(var6.build(), new ConnectivityManager.NetworkCallback(var7, var1, var2, this) {
         final ConnectivityManager $manager;
         final String $networkPassPhrase;
         final String $networkSSID;
         private boolean busy;
         final AddDeviceService this$0;

         {
            this.$manager = var1;
            this.$networkSSID = var2;
            this.$networkPassPhrase = var3;
            this.this$0 = var4;
         }

         public final boolean getBusy() {
            return this.busy;
         }

         public void onAvailable(Network var1) {
            Intrinsics.checkNotNullParameter(var1, "network");
            if (this.busy) {
               Timber.Forest.d("ignore onAvailable since busy", new Object[0]);
            } else {
               this.busy = true;
               this.$manager.unregisterNetworkCallback(this);
               this.$manager.bindProcessToNetwork(var1);

               try {
                  DevicePairManager var2 = DevicePairManager.INSTANCE;
                  String var3 = this.$networkSSID;
                  Intrinsics.checkNotNull(var3);
                  String var6 = this.$networkPassPhrase;
                  Intrinsics.checkNotNull(var6);
                  var5 = var2.performManualPairing(var3, var6);
               } catch (Exception var4) {
                  Timber.Forest.e((Throwable)var4);
                  var5 = null;
               }

               this.$manager.bindProcessToNetwork((Network)null);
               if (var5 != null) {
                  this.this$0.deviceConfigSuccess(var5, false);
               } else {
                  this.this$0.manualConfigFailToAutoModeFailState();
               }

            }
         }

         public final void setBusy(boolean var1) {
            this.busy = var1;
         }
      });
   }

   // $FF: synthetic method
   static void manualPairDevice$default(AddDeviceService var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.getSettingsWiFiNetworkSSID();
      }

      if ((var3 & 2) != 0) {
         var2 = var0.getSettingsWiFiNetworkPassword();
      }

      var0.manualPairDevice(var1, var2);
   }

   private static final Unit manualPairDeviceAsync$lambda$10(AddDeviceService var0) {
      manualPairDevice$default(var0, (String)null, (String)null, 3, (Object)null);
      return Unit.INSTANCE;
   }

   private final DeviceDetailsOnAblServer migrationOtaCheck(DeviceDetailsOnAblServer var1, ApiResult var2) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder(" migrationOtaCheck: deviceInfo = ");
      var3.append(var1);
      var3.append(", migrationResponse = ");
      var3.append(var2.getOrNull());
      var4.d(var3.toString(), new Object[0]);
      MigrationOtaResponse var7 = (MigrationOtaResponse)var2.getOrNull();
      if (this.deviceManager.isProbablyInMigrationOta(var2)) {
         String var5;
         if (var7 != null) {
            var5 = var7.getCompatibility();
         } else {
            var5 = null;
         }

         DeviceDetailsOnAblServer var6 = DeviceDetailsOnAblServer.copy$default(var1, var5, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (Long)null, 510, (Object)null);
         this.updateDeviceStatusLocalToOtaUpdating(var1.getUuid());
         return var6;
      } else {
         return var1;
      }
   }

   private final boolean otaUpdateRunningCheck() {
      Timber.Forest.d("otaUpdateRunningCheck()", new Object[0]);
      AddDeviceState var4 = this.getState();
      Ref.BooleanRef var3 = new Ref.BooleanRef();
      var3.element = true;
      if (var4.getDeviceInfo() != null) {
         Deferred var6 = BuildersKt.async$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var4, (Continuation)null) {
            final AddDeviceState $currentState;
            int label;
            final AddDeviceService this$0;

            {
               this.this$0 = var1;
               this.$currentState = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$currentState, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 == 1) {
                     ResultKt.throwOnFailure(var1);
                     return var1;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               } else {
                  ResultKt.throwOnFailure(var1);
                  var1 = this.this$0.deviceManager;
                  String var4 = this.$currentState.getDeviceInfo().getId();
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  var1 = var1.legacyOnBoardingOTAUpdateRunningCheck(var4, var5);
                  return var1 == var3 ? var3 : var1;
               }
            }
         }, 3, (Object)null);

         try {
            Function2 var5 = new Function2(var3, var6, (Continuation)null) {
               final Ref.BooleanRef $isRunning;
               final Deferred $job;
               Object L$0;
               int label;

               {
                  this.$isRunning = var1;
                  this.$job = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$isRunning, this.$job, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  boolean var3 = true;
                  Object var5;
                  Ref.BooleanRef var9;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var9 = (Ref.BooleanRef)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     var5 = var1;
                  } else {
                     ResultKt.throwOnFailure(var1);
                     Ref.BooleanRef var7 = this.$isRunning;
                     Deferred var10 = this.$job;
                     Continuation var6 = (Continuation)this;
                     this.L$0 = var7;
                     this.label = 1;
                     var5 = var10.await(var6);
                     if (var5 == var4) {
                        return var4;
                     }

                     var9 = var7;
                  }

                  Boolean var8 = (Boolean)((ApiResult)var5).getOrNull();
                  if (var8 != null) {
                     var3 = var8;
                  }

                  var9.element = var3;
                  return Unit.INSTANCE;
               }
            };
            BuildersKt.runBlocking$default((CoroutineContext)null, var5, 1, (Object)null);
         } catch (Exception var8) {
            Timber.Forest var10 = Timber.Forest;
            StringBuilder var7 = new StringBuilder("runBlocking failed with exception = ");
            var7.append(var8);
            var10.d(var7.toString(), new Object[0]);
         }

         int var1 = var4.getOtaCheckAttempt() + 1;
         boolean var2;
         if (!var3.element && var1 < 3) {
            var2 = false;
         } else {
            var2 = true;
         }

         updateState$default(this, AddDeviceState.copy$default(var4, 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, var1, var2, false, false, false, 0, false, false, 1036287, (Object)null), false, false, 6, (Object)null);
         Timber.Forest var11 = Timber.Forest;
         StringBuilder var9 = new StringBuilder("otaUpdateRunningCheck() : indoorService.isOTAUpdateRunning(");
         var9.append(var4.getDeviceInfo().getId());
         var9.append(") == ");
         var9.append(var3.element);
         var11.d(var9.toString(), new Object[0]);
      }

      return var3.element;
   }

   private static final Boolean otaUpdateRunningCheckAsync$lambda$11(AddDeviceService var0) {
      return var0.otaUpdateRunningCheck();
   }

   private static final PublishSubject performBackendAddPublisher_delegate$lambda$0() {
      return PublishSubject.create();
   }

   private static final boolean restartAddDeviceFlow$lambda$7(AddDeviceState var0) {
      Intrinsics.checkNotNullParameter(var0, "s");
      return var0.getDeviceType() == 0;
   }

   private static final boolean restartAutoConfig$lambda$8(AddDeviceState var0) {
      Intrinsics.checkNotNullParameter(var0, "s");
      return var0.getAutoStepsCompleted() == 0;
   }

   private static final boolean restartManualConfig$lambda$9(AddDeviceState var0) {
      Intrinsics.checkNotNullParameter(var0, "s");
      return var0.getManualStepsCompleted() == 0;
   }

   // $FF: synthetic method
   public static void restartOnboarding$default(AddDeviceService var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.restartOnboarding(var1);
   }

   private final void saveHistory(List var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("saveState: new history = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      Prefs var5 = this.securePrefs;
      String var4 = this.getStateHistorySerializer().toJson(var1);
      PreferencesHelper.INSTANCE.set(var5.getBackend(), "state_history", var4, Reflection.getOrCreateKotlinClass(String.class));
   }

   private final void saveState(AddDeviceState var1) {
      List var3 = this.loadStateHistory();
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("saveState: old history = ");
      var2.append(var3);
      var4.d(var2.toString(), new Object[0]);
      if (!var3.isEmpty() && Intrinsics.areEqual(var1, CollectionsKt.last(var3))) {
         Timber.Forest.d("saveState: state is duplicate, do not save", new Object[0]);
      } else {
         List var5 = CollectionsKt.toMutableList((Collection)var3);
         var5.add(var1);
         this.saveHistory(var5);
      }
   }

   private static final MoshiSerializer stateHistorySerializer_delegate$lambda$2() {
      ParameterizedType var0 = Types.newParameterizedType((Type)List.class, new Type[]{AddDeviceState.class});
      Intrinsics.checkNotNullExpressionValue(var0, "newParameterizedType(...)");
      return new MoshiSerializer((Type)var0, new Object[0]);
   }

   private static final PublishSubject successPublisher_delegate$lambda$1() {
      return PublishSubject.create();
   }

   private final void updateState(AddDeviceState var1, boolean var2, boolean var3) {
      Object var5 = this.syncLock;
      synchronized(var5){}

      Throwable var10000;
      label1210: {
         AddDeviceState var4;
         try {
            var4 = this._state;
            Timber.Forest var6 = Timber.Forest;
            StringBuilder var7 = new StringBuilder("updateState: nuState: ");
            var7.append(var1);
            var7.append(",\n oldState: ");
            var7.append(var4);
            var6.d(var7.toString(), new Object[0]);
            this._state = var1;
         } catch (Throwable var140) {
            var10000 = var140;
            boolean var10001 = false;
            break label1210;
         }

         if (var3) {
            try {
               this.saveState(var4);
            } catch (Throwable var139) {
               var10000 = var139;
               boolean var151 = false;
               break label1210;
            }
         }

         label1214: {
            label1196: {
               try {
                  if (AddDeviceUtils.INSTANCE.shouldChangeScreen(var4, var1)) {
                     break label1196;
                  }
               } catch (Throwable var138) {
                  var10000 = var138;
                  boolean var152 = false;
                  break label1210;
               }

               if (!var2) {
                  try {
                     Timber.Forest.d("updateState: shouldChangeScreen == false", new Object[0]);
                     break label1214;
                  } catch (Throwable var136) {
                     var10000 = var136;
                     boolean var153 = false;
                     break label1210;
                  }
               }
            }

            try {
               Timber.Forest.d("updateState: shouldChangeScreen", new Object[0]);
               AddDeviceUtils.AddDeviceScreen var148 = AddDeviceUtils.INSTANCE.getScreen(var1);
               Timber.Forest var146 = Timber.Forest;
               StringBuilder var8 = new StringBuilder("updateState: shouldChangeScreen to ");
               var8.append(var148);
               var146.d(var8.toString(), new Object[0]);
               if (var148 != AddDeviceUtils.AddDeviceScreen.NONE) {
                  this.getScreenChangePublisher().onNext(var148);
                  break label1214;
               }
            } catch (Throwable var137) {
               var10000 = var137;
               boolean var154 = false;
               break label1210;
            }

            try {
               Timber.Forest.w("updateState: no valid screen found to change to", new Object[0]);
            } catch (Throwable var135) {
               var10000 = var135;
               boolean var155 = false;
               break label1210;
            }
         }

         try {
            if (!var4.isReadyForBackendAdding() && var1.isReadyForBackendAdding()) {
               Timber.Forest.d("updateState: isReadyForBackEndAdding changed from false to true", new Object[0]);
               this.getPerformBackendAddPublisher().onNext(var1);
            }
         } catch (Throwable var134) {
            var10000 = var134;
            boolean var156 = false;
            break label1210;
         }

         label1212: {
            OnboardingSuccessEvent var147;
            AnalyticsService var149;
            String var150;
            try {
               if (this.getState().getSuccessScreen() || !this.getState().isSuccess()) {
                  break label1212;
               }

               var149 = this.analyticsService;
               var147 = new OnboardingSuccessEvent;
               var150 = DeviceType.Companion.fromIndex(this.getState().getDeviceType()).getName();
               var141 = this.getState().getDeviceInfo();
            } catch (Throwable var133) {
               var10000 = var133;
               boolean var157 = false;
               break label1210;
            }

            label1166: {
               if (var141 != null) {
                  try {
                     var145 = var141.getId();
                  } catch (Throwable var132) {
                     var10000 = var132;
                     boolean var158 = false;
                     break label1210;
                  }

                  var142 = var145;
                  if (var145 != null) {
                     break label1166;
                  }
               }

               var142 = "not available";
            }

            try {
               var147.<init>(var150, var142, this.getState().getAutoMode());
               var149.amplitudeLog(var147);
               Timber.Forest.d("updateState: Publish add device success state", new Object[0]);
               this.getSuccessPublisher().onNext(this.getState());
            } catch (Throwable var131) {
               var10000 = var131;
               boolean var159 = false;
               break label1210;
            }
         }

         label1158:
         try {
            Unit var144 = Unit.INSTANCE;
            return;
         } catch (Throwable var130) {
            var10000 = var130;
            boolean var160 = false;
            break label1158;
         }
      }

      Throwable var143 = var10000;
      throw var143;
   }

   // $FF: synthetic method
   static void updateState$default(AddDeviceService var0, AddDeviceState var1, boolean var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      if ((var4 & 4) != 0) {
         var3 = true;
      }

      var0.updateState(var1, var2, var3);
   }

   public final Object addDeviceForActiveUser(DeviceInformationLegacy var1, Continuation var2) {
      Object var6;
      label95: {
         if (var2 instanceof <undefinedtype>) {
            var6 = (<undefinedtype>)var2;
            if ((((<undefinedtype>)var6).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var6).label += Integer.MIN_VALUE;
               break label95;
            }
         }

         var6 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final AddDeviceService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.addDeviceForActiveUser((DeviceInformationLegacy)null, (Continuation)this);
            }
         };
      }

      Object var8;
      label87: {
         Object var9;
         String var25;
         label99: {
            label100: {
               var18 = ((<undefinedtype>)var6).result;
               var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var3 = ((<undefinedtype>)var6).label;
               var8 = null;
               if (var3 != 0) {
                  if (var3 != 1) {
                     if (var3 != 2) {
                        if (var3 != 3) {
                           if (var3 != 4) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           String var12 = (String)((<undefinedtype>)var6).L$2;
                           ApiResult var13 = (ApiResult)((<undefinedtype>)var6).L$1;
                           DeviceInformationLegacy var14 = (DeviceInformationLegacy)((<undefinedtype>)var6).L$0;
                           ResultKt.throwOnFailure(var18);
                           break label87;
                        }

                        var25 = (String)((<undefinedtype>)var6).L$2;
                        var11 = (ApiResult)((<undefinedtype>)var6).L$1;
                        DeviceInformationLegacy var35 = (DeviceInformationLegacy)((<undefinedtype>)var6).L$0;
                        ResultKt.throwOnFailure(var18);
                        var20 = var35;
                        break label99;
                     }

                     String var7 = (String)((<undefinedtype>)var6).L$2;
                     var11 = (ApiResult)((<undefinedtype>)var6).L$1;
                     var5 = (DeviceInformationLegacy)((<undefinedtype>)var6).L$0;
                     ResultKt.throwOnFailure(var18);
                     var19 = var7;
                     break label100;
                  }

                  var1 = (DeviceInformationLegacy)((<undefinedtype>)var6).L$0;
                  ResultKt.throwOnFailure(var18);
               } else {
                  ResultKt.throwOnFailure(var18);
                  Timber.Forest var26 = Timber.Forest;
                  StringBuilder var21 = new StringBuilder("addDevice: origDeviceInfo = ");
                  var21.append(var1);
                  var26.d(var21.toString(), new Object[0]);
                  if (StringsKt.contains$default((CharSequence)var1.getId(), (CharSequence)"LPB100", false, 2, (Object)null)) {
                     return ApiResult.Companion.fail((Throwable)(new DeviceUtilsLegacy.AddDeviceBackendException("DeviceInfoData could not be verified, wrong uuid LPB100 info sent.")));
                  }

                  DeviceManager var10 = this.deviceManager;
                  String var36 = var1.getId();
                  String var27 = var1.getMacAddress();
                  String var22 = var27;
                  if (var27 == null) {
                     var22 = "";
                  }

                  boolean var4 = Intrinsics.areEqual(DeviceType.Companion.fromSkuCompat(var1.getCompatibility()), DeviceType.Icp.INSTANCE);
                  ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                  ((<undefinedtype>)var6).label = 1;
                  Object var28 = var10.getVerifiedDeviceId(var36, var22, var4, (Continuation)var6);
                  var18 = var28;
                  if (var28 == var9) {
                     return var9;
                  }
               }

               ApiResult var37 = (ApiResult)var18;
               var19 = (String)var37.getOrNull();
               if (var37.isFailure()) {
                  return ApiResult.Companion.fromResult(var37, (Object)null);
               }

               CharSequence var29 = (CharSequence)var19;
               if (var29 == null || var29.length() == 0) {
                  return ApiResult.Companion.fromResult(var37, (Object)null);
               }

               DeviceManager var30 = this.deviceManager;
               ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var37);
               ((<undefinedtype>)var6).L$2 = var19;
               ((<undefinedtype>)var6).label = 2;
               if (var30.addDeviceRemote(var19, (Continuation)var6) == var9) {
                  return var9;
               }

               var5 = var1;
               var11 = var37;
            }

            Timber.Forest var41 = Timber.Forest;
            StringBuilder var38 = new StringBuilder("addDevice: Success adding a device ");
            var38.append(var19);
            var38.append(" to owner.");
            var41.v(var38.toString(), new Object[0]);
            ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var5);
            ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var11);
            ((<undefinedtype>)var6).L$2 = var19;
            ((<undefinedtype>)var6).label = 3;
            if (DelayKt.delay(40000L, (Continuation)var6) == var9) {
               return var9;
            }

            DeviceInformationLegacy var39 = var5;
            var25 = var19;
            var20 = var39;
         }

         DeviceManager var40 = this.deviceManager;
         ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var6).L$2 = SpillingKt.nullOutSpilledVariable(var25);
         ((<undefinedtype>)var6).label = 4;
         Object var15 = var40.getAblDeviceInfo(var25, (Continuation)var6);
         var18 = var15;
         if (var15 == var9) {
            return var9;
         }
      }

      ApiResult var31 = (ApiResult)var18;
      DeviceDetailsOnAblServer var23 = (DeviceDetailsOnAblServer)var31.getOrNull();
      Timber.Forest var34 = Timber.Forest;
      StringBuilder var16 = new StringBuilder("addDevice: verifiedDeviceInfoData = ");
      var16.append(var23);
      var34.d(var16.toString(), new Object[0]);
      String var17 = (String)var8;
      if (var23 != null) {
         var17 = var23.getCompatibility();
      }

      if (!var31.isFailure() && var23 != null) {
         CharSequence var32 = (CharSequence)var17;
         if (var32 != null && var32.length() != 0) {
            this.addDeviceToDb(var23);
            this.deviceManager.initNewDevice(var23);
            return ApiResult.Companion.success(Unit.INSTANCE);
         }
      }

      ApiResult.Companion var33 = ApiResult.Companion;
      StringBuilder var24 = new StringBuilder("DeviceInfoData could not be verified, info was ");
      var24.append(var17);
      return var33.fail((Throwable)(new DeviceUtilsLegacy.AddDeviceBackendException(var24.toString())));
   }

   public final void addOnBackendFail() {
      Timber.Forest.d("addOnBackendFail", new Object[0]);
      int var1 = this.getState().getDeviceType();
      String var2;
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               if (var1 != 40) {
                  var2 = DeviceType.Companion.fromIndex(this.getState().getDeviceType()).getName();
               } else {
                  var2 = DeviceType.Icp.INSTANCE.getName();
               }
            } else {
               var2 = DeviceType.Classic.INSTANCE.getName();
            }
         } else {
            var2 = DeviceType.Sense.INSTANCE.getName();
         }
      } else {
         var2 = DeviceType.Aware.INSTANCE.getName();
      }

      if (this.getState().getCurrentConfigMode() == 0) {
         this.autoConfigFail();
         this.analyticsService.amplitudeLog(new OnboardingFailureEvent(var2, true, "Automatic pairing failed, missing device info"));
      } else {
         this.manualConfigFailToAutoModeFailState();
         this.analyticsService.amplitudeLog(new OnboardingFailureEvent(var2, false, "Manual pairing failed, missing device info"));
      }
   }

   public final void addOnbackendSuccess() {
      Timber.Forest.d("addOnbackendSuccess", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, true, 0, false, false, false, false, 0, false, false, 1046527, (Object)null), false, false, 6, (Object)null);
   }

   public final void autoConfigFail() {
      Timber.Forest.d("autoConfigFail", new Object[0]);
      if (this.troubleshootThirdItemSelected) {
         ++this.autoFailCount;
      }

      AddDeviceState var1 = this.getState();
      if (var1.getDeviceType() == 3) {
         this.troubleshoot();
      } else {
         updateState$default(this, AddDeviceState.copy$default(var1, 0, false, 0, true, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048055, (Object)null), false, false, 6, (Object)null);
      }
   }

   public final void autoFailStepCompleted() {
      Timber.Forest.d("autoStepCompleted", new Object[0]);
      AddDeviceState var1 = this.getState();
      updateState$default(this, AddDeviceState.copy$default(var1, 0, false, 0, false, var1.getAutoFailStepsCompleted() + 1, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048559, (Object)null), false, false, 6, (Object)null);
   }

   public final void autoPairDevice(String var1, String var2) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("autoPairDevice: networkSSID = ");
      var4.append(var1);
      var4.append(", networkPassPhrase = ");
      var4.append(var2);
      var3.d(var4.toString(), new Object[0]);
      if (var1 != null && var2 != null) {
         DevicePairManager.INSTANCE.performAutomaticPairing(this.context, var1, var2, new DevicePairManager.AutoPairingListener(this) {
            final AddDeviceService this$0;

            {
               this.this$0 = var1;
            }

            public void onCompleted(DeviceInformationLegacy var1) {
               Timber.Forest var2 = Timber.Forest;
               StringBuilder var3 = new StringBuilder("autoPairDevice onCompleted:  deviceInformation = ");
               var3.append(var1);
               var3.append(' ');
               var2.d(var3.toString(), new Object[0]);
               if (var1 != null) {
                  AddDeviceState var5 = this.this$0.getState();
                  Timber.Forest var4 = Timber.Forest;
                  var3 = new StringBuilder("autoPairDevice: Automatic pairing success: ");
                  var3.append(var1);
                  var4.d(var3.toString(), new Object[0]);
                  var1.setModel((String)null);
                  var1.setCompatibility(DeviceUtilsLegacy.getDeviceCompatibilityForBackend(var5.getDeviceType()));
                  this.this$0.deviceConfigSuccess(var1, true);
               } else {
                  Timber.Forest.d("autoPairDevice: Automatic pairing failed", new Object[0]);
                  this.this$0.autoConfigFail();
               }
            }
         });
      } else {
         Timber.Forest.d("autoPairDevice: Automatic pairing failed, missing network access info", new Object[0]);
         this.autoConfigFail();
      }
   }

   public final void autoStepCompleted() {
      Timber.Forest.d("autoStepCompleted", new Object[0]);
      if (this.autoFailCount == 1 && this.troubleshootThirdItemSelected) {
         this.startManualConfigClassic();
      } else {
         AddDeviceState var1 = this.getState();
         updateState$default(this, AddDeviceState.copy$default(var1, 0, false, var1.getAutoStepsCompleted() + 1, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048571, (Object)null), false, false, 6, (Object)null);
      }
   }

   public final Object chooseDeviceName(String var1, Continuation var2) {
      label30: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label30;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final AddDeviceService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.chooseDeviceName((String)null, (Continuation)this);
            }
         };
      }

      Object var7 = ((<undefinedtype>)var11).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var11).label;
      String var12;
      AddDeviceState var13;
      DeviceInformationLegacy var16;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = (String)((<undefinedtype>)var11).L$3;
         var16 = (DeviceInformationLegacy)((<undefinedtype>)var11).L$2;
         var13 = (AddDeviceState)((<undefinedtype>)var11).L$1;
         var1 = (String)((<undefinedtype>)var11).L$0;
         ResultKt.throwOnFailure(var7);
         var16 = var16;
         var12 = var1;
      } else {
         ResultKt.throwOnFailure(var7);
         Timber.Forest var17 = Timber.Forest;
         StringBuilder var14 = new StringBuilder("chooseDeviceName: ");
         var14.append(var1);
         var17.d(var14.toString(), new Object[0]);
         AddDeviceState var15 = this.getState();
         DeviceInformationLegacy var18 = var15.getDeviceInfo();
         Intrinsics.checkNotNull(var18);
         var16 = DeviceInformationLegacy.copy$default(var18, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 127, (Object)null);
         var16.setName(var1);
         String var8 = var16.getId();
         DeviceManager var19 = this.deviceManager;
         ((<undefinedtype>)var11).L$0 = var1;
         ((<undefinedtype>)var11).L$1 = var15;
         ((<undefinedtype>)var11).L$2 = var16;
         ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var11).label = 1;
         if (var19.setAblDeviceName(var8, var1, (Continuation)var11) == var6) {
            return var6;
         }

         var12 = var1;
         var13 = var15;
      }

      if (this.getState().getDeviceType() == 40) {
         updateState$default(this, AddDeviceState.copy$default(var13, 0, false, 0, false, 0, 0, false, false, false, var16, var12, false, 0, false, false, false, true, 0, true, false, 719359, (Object)null), false, false, 6, (Object)null);
      } else {
         updateState$default(this, AddDeviceState.copy$default(var13, 0, false, 0, false, 0, 0, false, false, false, var16, var12, false, 0, false, false, false, true, 0, false, false, 981503, (Object)null), false, false, 6, (Object)null);
      }

      return Unit.INSTANCE;
   }

   public final void deviceConfigSuccess(DeviceInformationLegacy var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceInformation");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("Pairing Success: deviceInformation = ");
      var4.append(var1);
      var3.i(var4.toString(), new Object[0]);
      Prefs var5 = this.prefs;
      String var7 = var1.getId();
      PreferencesHelper.INSTANCE.set(var5.getBackend(), "KEY_LEGACY_DEVICE_TO_DELETE", var7, Reflection.getOrCreateKotlinClass(String.class));
      AddDeviceState var6 = this.getState();
      var1.setModel((String)null);
      var1.setCompatibility(DeviceUtilsLegacy.getDeviceCompatibilityForBackend(var6.getDeviceType()));
      updateState$default(this, AddDeviceState.copy$default(var6, 0, false, 0, false, 0, 0, false, false, false, var1, (String)null, false, 0, false, false, false, false, 0, false, false, 1048063, (Object)null), false, false, 6, (Object)null);
   }

   public final Object fetchDeviceStatus(String var1, Continuation var2) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(this, var1, (Continuation)null) {
         final String $deviceUUID;
         int label;
         final AddDeviceService this$0;

         {
            this.this$0 = var1;
            this.$deviceUUID = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceUUID, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 == 1) {
                  ResultKt.throwOnFailure(var1);
                  return var1;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var5 = this.this$0.deviceManager;
               String var6 = this.$deviceUUID;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               Object var7 = var5.getAblDeviceStatus(var6, var4);
               return var7 == var3 ? var3 : var7;
            }
         }
      }, var2);
   }

   public final void forceOtaCompleted() {
      Timber.Forest.d("forceOtaCompleted", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, true, false, false, false, 0, false, false, 1040383, (Object)null), false, false, 6, (Object)null);
   }

   public final String getCurrentNetworkSSIDEstimate() {
      String var1 = NetUtil.INSTANCE.getActiveWifiSSID(this.context);
      return var1 != null && !DeviceUtilsLegacy.INSTANCE.isManualDeviceNetwork(var1) ? var1 : this.getSettingsWiFiNetworkSSID();
   }

   public final Observable getMessageDisplayObserver() {
      return this.getMessageDisplayPublisher().hide();
   }

   public final Observable getPerformBackendAddObserver() {
      return this.getPerformBackendAddPublisher().hide();
   }

   public final Observable getScreenChangeObserver() {
      return this.getScreenChangePublisher().hide();
   }

   public final Observable getScreenRevertObserver() {
      return this.getScreenRevertPublisher().hide();
   }

   public final String getSettingsWiFiNetworkPassword() {
      Prefs var1 = this.securePrefs;
      return (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "password_wifi", "", Reflection.getOrCreateKotlinClass(String.class));
   }

   public final String getSettingsWiFiNetworkSSID() {
      Prefs var1 = this.securePrefs;
      return (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "wifi_ssid_add", "", Reflection.getOrCreateKotlinClass(String.class));
   }

   public final AddDeviceState getState() {
      return this._state;
   }

   public final Observable getSuccessObserver() {
      return this.getSuccessPublisher().hide();
   }

   public final boolean getTroubleshoot() {
      return this.troubleshoot;
   }

   public final boolean getTroubleshootThirdItemSelected() {
      return this.troubleshootThirdItemSelected;
   }

   public final String getWifiPassword() {
      return this.wifiPassword;
   }

   public final void icpAddDeviceCompleted() {
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 917495, (Object)null), false, false, 6, (Object)null);
   }

   public final void icpPairingCompleted(IcpDeviceInfo var1) {
      Intrinsics.checkNotNullParameter(var1, "icpDeviceInfo");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("icpPairingCompleted ");
      var2.append(var1);
      var3.e(var2.toString(), new Object[0]);
      AddDeviceState var4 = this.getState();
      String var5 = var1.getMacAddress();
      String var8 = var1.getSerialNumber();
      String var7 = var8;
      if (var8 == null) {
         var7 = "Unknown-ID";
      }

      var8 = var1.getDevice().getName();
      String var6 = TimeZone.getDefault().getID();
      Intrinsics.checkNotNullExpressionValue(var6, "getID(...)");
      updateState$default(this, AddDeviceState.copy$default(var4, 0, false, 0, false, 0, 0, false, false, false, new DeviceInformationLegacy((String)null, var5, var7, var8, "Unknown", "icp_p2i", var6), (String)null, false, 0, false, false, false, false, 2, false, false, 916991, (Object)null), false, false, 6, (Object)null);
   }

   public final void icpSetupDeviceCompleted() {
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 1, false, false, 917495, (Object)null), false, false, 6, (Object)null);
   }

   public final void initState(AddDeviceState var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("initState: origState = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      if (var1 == null) {
         this.clearStateHistory();
      }

      this.deviceManager.getAddDeviceProcessRunning().set(true);
      if (var1 == null) {
         var1 = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null);
      }

      updateState$default(this, var1, false, false, 4, (Object)null);
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.authService.isUserLoggedIn().getValue();
   }

   public final void manualConfigFailToAutoModeFailState() {
      Timber.Forest.d("manualConfigFailToAutoModeFailState", new Object[0]);
      if (this.getState().getDeviceType() == 3) {
         this.getMessageDisplayPublisher().onNext(this.resources.getString(R.string.add_classic_device_manual_error));
         restartOnboarding$default(this, false, 1, (Object)null);
      } else {
         this.getMessageDisplayPublisher().onNext(this.resources.getString(R.string.add_device_info_missing));
         updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, true, 0, true, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1047557, (Object)null), false, false, 6, (Object)null);
      }
   }

   public final Completable manualPairDeviceAsync() {
      Completable var1 = Completable.fromCallable(new AddDeviceService$$ExternalSyntheticLambda3(this));
      Intrinsics.checkNotNullExpressionValue(var1, "fromCallable(...)");
      return var1;
   }

   public final void manualStepCompleted() {
      Timber.Forest.d("manualStepCompleted", new Object[0]);
      AddDeviceState var1 = this.getState();
      updateState$default(this, AddDeviceState.copy$default(var1, 0, false, 0, false, 0, var1.getManualStepsCompleted() + 1, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048543, (Object)null), false, false, 6, (Object)null);
   }

   public final Object migrationOtaCheck(Function1 var1, Continuation var2) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getDefault(), new Function2(this, var1, (Continuation)null) {
         final Function1 $onFailure;
         int I$0;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         Object L$5;
         Object L$6;
         Object L$7;
         Object L$8;
         int label;
         final AddDeviceService this$0;

         {
            this.this$0 = var1;
            this.$onFailure = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$onFailure, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label87: {
               DeviceInformationLegacy var11;
               Object var15;
               int var19;
               String var20;
               ApiResult var29;
               DeviceInformationLegacy var33;
               Function1 var36;
               ApiResult var37;
               DeviceDetailsOnAblServer var45;
               AddDeviceState var49;
               label88: {
                  Object var13;
                  AddDeviceService var41;
                  label89: {
                     var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     var19 = this.label;
                     DeviceInformationLegacy var3;
                     AddDeviceService var4;
                     AddDeviceState var6;
                     Function1 var16;
                     if (var19 != 0) {
                        if (var19 != 1) {
                           if (var19 != 2) {
                              if (var19 != 3) {
                                 if (var19 != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 String var21 = (String)this.L$7;
                                 ApiResult var22 = (ApiResult)this.L$6;
                                 DeviceDetailsOnAblServer var23 = (DeviceDetailsOnAblServer)this.L$5;
                                 ApiResult var24 = (ApiResult)this.L$4;
                                 DeviceInformationLegacy var25 = (DeviceInformationLegacy)this.L$3;
                                 AddDeviceService var26 = (AddDeviceService)this.L$2;
                                 AddDeviceState var30 = (AddDeviceState)this.L$1;
                                 DeviceInformationLegacy var31 = (DeviceInformationLegacy)this.L$0;
                                 ResultKt.throwOnFailure(var1);
                                 var1 = var26;
                                 break label87;
                              }

                              var19 = this.I$0;
                              var20 = (String)this.L$8;
                              var29 = (ApiResult)this.L$7;
                              var45 = (DeviceDetailsOnAblServer)this.L$6;
                              var37 = (ApiResult)this.L$5;
                              var11 = (DeviceInformationLegacy)this.L$4;
                              var36 = (Function1)this.L$3;
                              var41 = (AddDeviceService)this.L$2;
                              var49 = (AddDeviceState)this.L$1;
                              var33 = (DeviceInformationLegacy)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              var1 = var41;
                              break label88;
                           }

                           var19 = this.I$0;
                           var20 = (String)this.L$7;
                           var10 = (DeviceDetailsOnAblServer)this.L$6;
                           var37 = (ApiResult)this.L$5;
                           DeviceInformationLegacy var9 = (DeviceInformationLegacy)this.L$4;
                           var28 = (Function1)this.L$3;
                           var41 = (AddDeviceService)this.L$2;
                           var32 = (AddDeviceState)this.L$1;
                           DeviceInformationLegacy var34 = (DeviceInformationLegacy)this.L$0;
                           ResultKt.throwOnFailure(var1);
                           var13 = var1;
                           var1 = var34;
                           var35 = var9;
                           break label89;
                        }

                        var19 = this.I$0;
                        var33 = (DeviceInformationLegacy)this.L$4;
                        Function1 var7 = (Function1)this.L$3;
                        var4 = (AddDeviceService)this.L$2;
                        var6 = (AddDeviceState)this.L$1;
                        var3 = (DeviceInformationLegacy)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        var41 = var1;
                        var16 = var7;
                     } else {
                        ResultKt.throwOnFailure(var1);
                        var33 = this.this$0.getState().getDeviceInfo();
                        var6 = this.this$0.getState();
                        if (var33 == null) {
                           return null;
                        }

                        var4 = this.this$0;
                        var16 = this.$onFailure;
                        DeviceManager var27 = var4.deviceManager;
                        String var38 = var33.getId();
                        this.L$0 = var33;
                        this.L$1 = var6;
                        this.L$2 = var4;
                        this.L$3 = var16;
                        this.L$4 = var33;
                        this.I$0 = 0;
                        this.label = 1;
                        var41 = (AddDeviceService)var27.getAblDeviceInfo(var38, this);
                        if (var41 == var15) {
                           return var15;
                        }

                        var3 = var33;
                        var19 = 0;
                     }

                     ApiResult var43 = (ApiResult)var41;
                     var10 = (DeviceDetailsOnAblServer)var43.getOrNull();
                     Timber.Forest var39 = Timber.Forest;
                     StringBuilder var46 = new StringBuilder("addDevice: verifiedDeviceInfoData = ");
                     var46.append(var10);
                     var39.d(var46.toString(), new Object[0]);
                     String var40;
                     if (var10 != null) {
                        var40 = var10.getCompatibility();
                     } else {
                        var40 = null;
                     }

                     if (var10 == null) {
                        return Unit.INSTANCE;
                     }

                     DeviceManager var52 = var4.deviceManager;
                     String var47 = var33.getId();
                     this.L$0 = var3;
                     this.L$1 = var6;
                     this.L$2 = var4;
                     this.L$3 = var16;
                     this.L$4 = SpillingKt.nullOutSpilledVariable(var33);
                     this.L$5 = SpillingKt.nullOutSpilledVariable(var43);
                     this.L$6 = var10;
                     this.L$7 = var40;
                     this.I$0 = var19;
                     this.label = 2;
                     Object var14 = var52.isMigrationOtaRunning(var47, this);
                     if (var14 == var15) {
                        return var15;
                     }

                     DeviceInformationLegacy var57 = var33;
                     AddDeviceService var53 = var4;
                     String var12 = var40;
                     DeviceInformationLegacy var48 = var3;
                     var32 = var6;
                     var35 = var57;
                     var28 = var16;
                     var37 = var43;
                     var13 = var14;
                     var41 = var53;
                     var20 = var12;
                     var1 = var48;
                  }

                  ApiResult var56 = (ApiResult)var13;
                  if (var20 == null || !StringsKt.contains$default((CharSequence)var20, (CharSequence)"foobot", false, 2, (Object)null)) {
                     if (var41.deviceManager.isProbablyInMigrationOta(var56)) {
                        var41.firmwareVersionCheck(var10);
                        AddDeviceService.updateState$default(var41, AddDeviceState.copy$default(var32, 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, true, false, 786431, (Object)null), false, false, 6, (Object)null);
                     } else {
                        AddDeviceService.updateState$default(var41, AddDeviceState.copy$default(var32, 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, true, false, 786431, (Object)null), false, false, 6, (Object)null);
                     }

                     return Unit.INSTANCE;
                  }

                  var45 = var41.migrationOtaCheck(var10, var56);
                  if (!Intrinsics.areEqual(var45.getCompatibility(), var20)) {
                     AddDeviceService.updateState$default(var41, AddDeviceState.copy$default(var32, 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, true, false, 786431, (Object)null), false, false, 6, (Object)null);
                     return Unit.INSTANCE;
                  }

                  Timber.Forest var54 = Timber.Forest;
                  StringBuilder var50 = new StringBuilder("migration ota failed, response = ");
                  var50.append(var56.getOrNull());
                  var50.append(", nuDeviceId = ");
                  var50.append(var1.getId());
                  var50.append(", nuDeviceInfo = ");
                  var50.append(var45);
                  var54.d(var50.toString(), new Object[0]);
                  DeviceManager var51 = var41.deviceManager;
                  String var55 = var1.getId();
                  this.L$0 = var1;
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var32);
                  this.L$2 = var41;
                  this.L$3 = var28;
                  this.L$4 = SpillingKt.nullOutSpilledVariable(var35);
                  this.L$5 = SpillingKt.nullOutSpilledVariable(var37);
                  this.L$6 = var45;
                  this.L$7 = var56;
                  this.L$8 = SpillingKt.nullOutSpilledVariable(var20);
                  this.I$0 = var19;
                  this.label = 3;
                  if (var51.removeAblDeviceRemote(var55, this) == var15) {
                     return var15;
                  }

                  var11 = var35;
                  var49 = var32;
                  var36 = var28;
                  var29 = var56;
                  var33 = var1;
                  var1 = var41;
               }

               if (!BuildEnvironment.INSTANCE.isRelease()) {
                  StringBuilder var44 = new StringBuilder("migration ota failed, response = ");
                  var44.append(var29.getOrNull());
                  var44.append(", nuDeviceId = ");
                  var44.append(var33.getId());
                  var44.append(", nuDeviceInfo = ");
                  var44.append(var45);
                  var36.invoke(var44.toString());
               }

               this.L$0 = SpillingKt.nullOutSpilledVariable(var33);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var49);
               this.L$2 = var1;
               this.L$3 = SpillingKt.nullOutSpilledVariable(var11);
               this.L$4 = SpillingKt.nullOutSpilledVariable(var37);
               this.L$5 = SpillingKt.nullOutSpilledVariable(var45);
               this.L$6 = SpillingKt.nullOutSpilledVariable(var29);
               this.L$7 = SpillingKt.nullOutSpilledVariable(var20);
               this.L$8 = null;
               this.I$0 = var19;
               this.label = 4;
               if (DelayKt.delay(5000L, this) == var15) {
                  return var15;
               }
            }

            AddDeviceService.updateState$default(var1, new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null), false, false, 6, (Object)null);
            return Unit.INSTANCE;
         }
      }, var2);
   }

   public final Single otaUpdateRunningCheckAsync() {
      Timber.Forest.d("otaUpdateRunningCheckAsync()", new Object[0]);
      Single var1 = Single.fromCallable(new AddDeviceService$$ExternalSyntheticLambda4(this));
      Intrinsics.checkNotNullExpressionValue(var1, "fromCallable(...)");
      return var1;
   }

   public final boolean popState() {
      Object var2 = this.syncLock;
      synchronized(var2){}

      boolean var1;
      label135: {
         Throwable var10000;
         label140: {
            List var3;
            Timber.Forest var4;
            String var23;
            try {
               var3 = this.loadStateHistory();
               var4 = Timber.Forest;
               StringBuilder var5 = new StringBuilder("popState: current state = ");
               var5.append(this.getState());
               var5.append(", history = ");
               var5.append(var3);
               var23 = var5.toString();
            } catch (Throwable var17) {
               var10000 = var17;
               boolean var10001 = false;
               break label140;
            }

            var1 = false;

            try {
               var4.d(var23, new Object[0]);
            } catch (Throwable var16) {
               var10000 = var16;
               boolean var24 = false;
               break label140;
            }

            label127:
            try {
               if (((Collection)var3).isEmpty()) {
                  return var1;
               }

               List var21 = CollectionsKt.toMutableList((Collection)var3);
               AddDeviceState var19 = (AddDeviceState)var21.remove(var3.size() - 1);
               this.saveHistory(var21);
               this._state = var19;
               Timber.Forest var22 = Timber.Forest;
               StringBuilder var20 = new StringBuilder("popState: new current state = ");
               var20.append(this._state);
               var22.d(var20.toString(), new Object[0]);
               break label135;
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var25 = false;
               break label127;
            }
         }

         Throwable var18 = var10000;
         throw var18;
      }

      var1 = true;
      return var1;
   }

   public final void recommendResetDevice() {
      Timber.Forest.d("resetDevice", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, true, false, false, 0, false, false, 1032191, (Object)null), false, false, 6, (Object)null);
   }

   public final void restartAddDeviceFlow() {
      Timber.Forest.d("restartAddDeviceFlow", new Object[0]);
      this.downdateState(new AddDeviceService$$ExternalSyntheticLambda6());
   }

   public final void restartAutoConfig() {
      Timber.Forest.d("restartAutoConfig", new Object[0]);
      this.wifiPassword = "";
      this.downdateState(new AddDeviceService$$ExternalSyntheticLambda5());
   }

   public final void restartManualConfig() {
      Timber.Forest.d("restartManualConfig", new Object[0]);
      this.wifiPassword = "";
      this.downdateState(new AddDeviceService$$ExternalSyntheticLambda7());
   }

   public final void restartOnboarding(boolean var1) {
      this.wifiPassword = "";
      if (var1) {
         this.getMessageDisplayPublisher().onNext(this.resources.getString(R.string.add_classic_device_error));
      }

      this.clearStateHistory();
      int var2 = this.getState().getDeviceType();
      this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null);
      this.initState(new AddDeviceState(var2, true, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048572, (DefaultConstructorMarker)null));
   }

   public final void selectDevice(int var1) {
      this.wifiPassword = "";
      this.troubleshootThirdItemSelected = false;
      this.autoFailCount = 0;
      AddDeviceState var2 = this.getState();
      updateState$default(this, AddDeviceState.copy$default(var2, var1, var2.getAutoMode(), 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048572, (Object)null), false, false, 6, (Object)null);
   }

   public final void setNetworkInfo(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var2, "wifiNetworkSSID");
      Intrinsics.checkNotNullParameter(var3, "wifiNetworkPassword");
      this.setSettingsWiFiNetworkBSSID(var1);
      this.setSettingsWiFiNetworkSSID(var2);
      this.setSettingsWiFiNetworkPassword(var3);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, true, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048319, (Object)null), false, false, 6, (Object)null);
   }

   public final void setSettingsWiFiNetworkBSSID(String var1) {
      if (var1 != null) {
         Prefs var2 = this.securePrefs;
         PreferencesHelper.INSTANCE.set(var2.getBackend(), "wifi_bssid_add", var1, Reflection.getOrCreateKotlinClass(String.class));
      }

   }

   public final void setSettingsWiFiNetworkPassword(String var1) {
      if (var1 != null) {
         Prefs var2 = this.securePrefs;
         PreferencesHelper.INSTANCE.set(var2.getBackend(), "password_wifi", var1, Reflection.getOrCreateKotlinClass(String.class));
      }

   }

   public final void setSettingsWiFiNetworkSSID(String var1) {
      if (var1 != null) {
         Prefs var2 = this.securePrefs;
         PreferencesHelper.INSTANCE.set(var2.getBackend(), "wifi_ssid_add", var1, Reflection.getOrCreateKotlinClass(String.class));
      }

   }

   public final void setTroubleshoot(boolean var1) {
      this.troubleshoot = var1;
   }

   public final void setWifiPassword(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.wifiPassword = var1;
   }

   public final void setupTextCompleted() {
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, true, false, 0, false, false, 1015807, (Object)null), false, false, 6, (Object)null);
   }

   public final void showAutoStep2() {
      this.getScreenChangePublisher().onNext(AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2);
   }

   public final void showManualStep1() {
      this.getScreenChangePublisher().onNext(AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1);
   }

   public final void startActivateDeviceWifiClassic() {
      this.troubleshootThirdItemSelected = false;
      this.troubleshoot = true;
      this.clearStateHistory();
      int var1 = this.getState().getDeviceType();
      this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null);
      this.initState(new AddDeviceState(var1, true, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, true, false, 0, false, false, 1015804, (DefaultConstructorMarker)null));
   }

   public final void startAutoOrManualClassic() {
      if (this.autoFailCount == 1) {
         this.getScreenChangePublisher().onNext(AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2);
         this.troubleshoot = true;
      } else {
         this.startActivateDeviceWifiClassic();
      }

      this.troubleshootThirdItemSelected = true;
   }

   public final void startConnectToNetworkClassic() {
      this.clearStateHistory();
      int var1 = this.getState().getDeviceType();
      this._state = new AddDeviceState(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null);
      this.initState(new AddDeviceState(var1, false, 1, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, true, false, 0, false, false, 1015802, (DefaultConstructorMarker)null));
   }

   public final void startManualConfig() {
      Timber.Forest.d("startManualConfig", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1031933, (Object)null), false, false, 6, (Object)null);
   }

   public final void startManualConfigClassic() {
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 523741, (Object)null), true, false, 4, (Object)null);
   }

   public final void startManualConfigStep2Classic() {
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 1, false, false, true, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 523485, (Object)null), true, false, 4, (Object)null);
   }

   public final void startManualStepTwo() {
      Timber.Forest.d("startManualConfigStepTwo", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 1, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048285, (Object)null), false, false, 6, (Object)null);
   }

   public final void successFinished() {
      Timber.Forest.d("successFinished", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 983039, (Object)null), false, false, 6, (Object)null);
   }

   public final void troubleshoot() {
      this.troubleshoot = false;
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, true, 524287, (Object)null), true, false, 4, (Object)null);
   }

   public final void updateDeviceStatusLocalToOtaUpdating(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceUid");
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final String $deviceUid;
         int label;
         final AddDeviceService this$0;

         {
            this.this$0 = var1;
            this.$deviceUid = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceUid, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               this.this$0.deviceManager.updateDeviceStatusLocalToOtaUpdating(this.$deviceUid);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, 2, (Object)null);
   }

   public final void validateManual() {
      Timber.Forest.d("validateManual", new Object[0]);
      updateState$default(this, AddDeviceState.copy$default(this.getState(), 0, false, 0, false, 0, 0, true, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048511, (Object)null), false, false, 6, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/adddevice/service/AddDeviceService$Companion;", "", "<init>", "()V", "STATE_HISTORY_KEY", "", "WIFI_SSID_KEY", "WIFI_BSSID_KEY", "WIFI_PASSWORD_KEY", "OTA_CHECK_MAX_RETRIES", "", "FOOBOT", "USER_FRIENDLY_MIGRATION_OTA_FAILURE_MSG", "ARTIFICIAL_DELAY", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
