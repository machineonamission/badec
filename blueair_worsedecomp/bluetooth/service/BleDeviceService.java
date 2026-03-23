package com.blueair.bluetooth.service;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.compose.material3.MenuKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.blueair.bluetooth.espressif.AppConstants;
import com.blueair.bluetooth.espressif.BLETransport;
import com.blueair.bluetooth.espressif.Provision;
import com.blueair.bluetooth.espressif.Security;
import com.blueair.bluetooth.espressif.Security1;
import com.blueair.bluetooth.espressif.Session;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.OnboardingError;
import com.blueair.core.model.OnboardingState;
import com.blueair.core.model.Ssid;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.MoshiSerializer;
import com.google.protobuf.InvalidProtocolBufferException;
import custom.CustomCommands;
import espressif.WifiScan;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 º\u00012\u00020\u0001:\u0002º\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010h\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010i\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010j\u001a\u00020\u001aJ\u000e\u0010k\u001a\u00020GH@¢\u0006\u0002\u0010lJ\u0006\u0010m\u001a\u00020\u001aJ\"\u0010n\u001a\u00020\u001a2\b\b\u0002\u0010o\u001a\u00020\u00052\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010qJ*\u0010r\u001a\u00020G2\b\b\u0002\u0010o\u001a\u00020\u00052\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010qH@¢\u0006\u0002\u0010sJ\u000e\u0010t\u001a\u00020GH@¢\u0006\u0002\u0010lJ\u0016\u0010u\u001a\u00020f2\u0006\u0010v\u001a\u00020wH@¢\u0006\u0002\u0010xJ\u0016\u0010y\u001a\u00020G2\u0006\u0010z\u001a\u00020\u0005H@¢\u0006\u0002\u0010{J\u000e\u0010|\u001a\u00020GH@¢\u0006\u0002\u0010lJ\u000e\u0010}\u001a\u00020GH@¢\u0006\u0002\u0010lJ\n\u0010~\u001a\u0004\u0018\u00010$H\u0002J\u0019\u0010\u001a\u00020G2\b\u0010\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J+\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020$2\b\u0010\u0001\u001a\u00030\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020G0cH\u0002J$\u0010\u0001\u001a\u00020G2\u0007\u0010\u0001\u001a\u00020\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u0005H@¢\u0006\u0003\u0010\u0001J,\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00052\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020G0cH\u0002J\u000f\u0010\u0001\u001a\u00020GH@¢\u0006\u0002\u0010lJ\u0018\u0010\u0001\u001a\u00020\u001a2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020G0cH\u0002J\u000f\u0010\u0001\u001a\u00020GH@¢\u0006\u0002\u0010lJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0005H@¢\u0006\u0002\u0010lJ(\u0010\u0001\u001a\u00020\u001a2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0005042\u0007\u0010\u0001\u001a\u00020\u0018H@¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u001aH\u0002J\u0014\u0010\u0001\u001a\u00020\u001a2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0001\u001a\u00020\u001a2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010\u0001\u001a\u00020GH@¢\u0006\u0002\u0010lJ\u0017\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H@¢\u0006\u0002\u0010lJ'\u0010\u0001\u001a\u00020\u001a2\u001c\u0010\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020\u001a0\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020\u001a2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002J'\u0010¢\u0001\u001a\u00020\u001a2\u001c\u0010\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020\u001a0\u0001H\u0002J1\u0010£\u0001\u001a\u00020\u001a2\b\u0010 \u0001\u001a\u00030¡\u00012\u001c\u0010\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020\u001a0\u0001H\u0002J9\u0010¤\u0001\u001a\u00020\u001a2\u0007\u0010¥\u0001\u001a\u00020f2\u0007\u0010¦\u0001\u001a\u00020f2\u001c\u0010\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020\u001a0\u0001H\u0002J9\u0010§\u0001\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020f2\u0007\u0010©\u0001\u001a\u00020f2\u001c\u0010\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020\u001a0\u0001H\u0002J\u001b\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002Je\u0010«\u0001\u001a\u00020\u001a2\b\u0010¬\u0001\u001a\u00030­\u00012'\u0010®\u0001\u001a\"\u0012\u0017\u0012\u00150­\u0001¢\u0006\u000f\b¯\u0001\u0012\n\b°\u0001\u0012\u0005\b\b(±\u0001\u0012\u0004\u0012\u00020\u001a0\u00012'\u0010²\u0001\u001a\"\u0012\u0017\u0012\u00150³\u0001¢\u0006\u000f\b¯\u0001\u0012\n\b°\u0001\u0012\u0005\b\b(´\u0001\u0012\u0004\u0012\u00020\u001a0\u0001H\u0002J\u0016\u0010µ\u0001\u001a\u00030­\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$8F@BX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000fR\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020$0.X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020$00¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R!\u00103\u001a\b\u0012\u0004\u0012\u00020$048BX\u0002¢\u0006\f\n\u0004\b7\u0010\u0016\u001a\u0004\b5\u00106R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020$098F¢\u0006\u0006\u001a\u0004\b:\u0010;R!\u0010<\u001a\b\u0012\u0004\u0012\u00020$0=8FX\u0002¢\u0006\f\n\u0004\b@\u0010\u0016\u001a\u0004\b>\u0010?R!\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d048BX\u0002¢\u0006\f\n\u0004\bC\u0010\u0016\u001a\u0004\bB\u00106R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d098F¢\u0006\u0006\u001a\u0004\bE\u0010;R\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bF\u0010HR\u0011\u0010I\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bJ\u0010HR\u0011\u0010K\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bK\u0010HR\u0011\u0010L\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bL\u0010HR\u0011\u0010M\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bM\u0010HR\u0011\u0010N\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bN\u0010HR\u0011\u0010O\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bO\u0010HR\u0011\u0010P\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bP\u0010HR\u001b\u0010Q\u001a\u00020R8FX\u0002¢\u0006\f\n\u0004\bU\u0010\u0016\u001a\u0004\bS\u0010TR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010d\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010g\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010¶\u0001\u001a\u00030·\u0001X\u0005¢\u0006\b\u001a\u0006\b¸\u0001\u0010¹\u0001¨\u0006»\u0001"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceService;", "Lkotlinx/coroutines/CoroutineScope;", "currentDevice", "Landroid/bluetooth/BluetoothDevice;", "serviceUuid", "", "context", "Landroid/content/Context;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Landroid/content/Context;Lcom/blueair/core/service/AnalyticsService;)V", "getCurrentDevice", "()Landroid/bluetooth/BluetoothDevice;", "getServiceUuid", "()Ljava/lang/String;", "deviceEventSerializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/DeviceEvent;", "getDeviceEventSerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "deviceEventSerializer$delegate", "Lkotlin/Lazy;", "pollingDeviceBoundedDisposable", "Lio/reactivex/disposables/Disposable;", "sideLoadError", "", "message", "nuError", "Lcom/blueair/bluetooth/service/BleDeviceError;", "error", "getError", "()Lcom/blueair/bluetooth/service/BleDeviceError;", "setError", "(Lcom/blueair/bluetooth/service/BleDeviceError;)V", "nuState", "Lcom/blueair/bluetooth/service/BleDeviceState;", "state", "getState", "()Lcom/blueair/bluetooth/service/BleDeviceState;", "setState", "(Lcom/blueair/bluetooth/service/BleDeviceState;)V", "value", "detectedDeviceUuid", "getDetectedDeviceUuid", "_deviceEvents", "Lkotlinx/coroutines/flow/MutableStateFlow;", "deviceStateStream", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateStream", "()Lkotlinx/coroutines/flow/StateFlow;", "deviceStatePublisher", "Lio/reactivex/subjects/PublishSubject;", "getDeviceStatePublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceStatePublisher$delegate", "deviceStateObserver", "Lio/reactivex/Observable;", "getDeviceStateObserver", "()Lio/reactivex/Observable;", "liveDeviceStateObserver", "Landroidx/lifecycle/LiveData;", "getLiveDeviceStateObserver", "()Landroidx/lifecycle/LiveData;", "liveDeviceStateObserver$delegate", "deviceErrorPublisher", "getDeviceErrorPublisher", "deviceErrorPublisher$delegate", "deviceErrorObserver", "getDeviceErrorObserver", "isConnected", "", "()Z", "hasSession", "getHasSession", "isProvisioningStarted", "isProvisioningConfigured", "isWifiConfigured", "isWifiConfigApplied", "isWifiConnected", "isBounded", "transport", "Lcom/blueair/bluetooth/espressif/BLETransport;", "getTransport", "()Lcom/blueair/bluetooth/espressif/BLETransport;", "transport$delegate", "security", "Lcom/blueair/bluetooth/espressif/Security;", "getSecurity", "()Lcom/blueair/bluetooth/espressif/Security;", "setSecurity", "(Lcom/blueair/bluetooth/espressif/Security;)V", "session", "Lcom/blueair/bluetooth/espressif/Session;", "getSession", "()Lcom/blueair/bluetooth/espressif/Session;", "setSession", "(Lcom/blueair/bluetooth/espressif/Session;)V", "connectionContinuation", "Lkotlin/coroutines/Continuation;", "establishSessionContinuation", "readFilterContinuation", "", "resetFilterContinuation", "updateState", "updateError", "connect", "connectSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "establishSession", "proofOfPossesion", "onSessionEstablished", "Lkotlin/Function0;", "establishSessionSync", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectAndEstablishSessionSync", "readFilterSync", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "(Lcom/blueair/core/model/DeviceFilterType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetFilterSync", "cipherText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProvisioningSync", "connectAndEstablishSessionAndStartProvisioningSync", "nextConfigureProvisionStep", "configureProvisionSync", "config", "Lcom/blueair/bluetooth/service/ProvisionConfig;", "(Lcom/blueair/bluetooth/service/ProvisionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureProvisionStep", "step", "provConfCont", "configureWifiSync", "ssid", "passphrase", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureWifi", "provisionCont", "applyWifiConfigSync", "applyWifiConfig", "pollWifiConnectionStatus", "getDeviceEvents", "startPollDeviceBounded", "publisher", "pollingDisposable", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPollDeviceBounded", "pollDeviceBoundedSuccess", "deviceEvent", "pollDeviceBoundedFail", "pollDeviceBounded", "wifiScanSync", "", "Lcom/blueair/core/model/Ssid;", "startWifiScan", "onResponse", "Lkotlin/Function1;", "processStartScan", "responseData", "", "getWifiScanStatus", "processGetWifiStatus", "getFullWiFiList", "totalCount", "startIndex", "getWiFiScanList", "start", "count", "processGetSSIDs", "sendWrapper", "wrapper", "Lcustom/CustomCommands$CommandWrapper;", "onSuccess", "Lkotlin/ParameterName;", "name", "responseWrapper", "onFail", "", "t", "processCustomCommand", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceService implements CoroutineScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PROOF_OF_POSSESION_DEFAULT = "";
    private static final int SSID_FETCH_SIZE = 4;
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final MutableStateFlow<BleDeviceState> _deviceEvents;
    private final AnalyticsService analyticsService;
    private Continuation<? super Boolean> connectionContinuation;
    private final BluetoothDevice currentDevice;
    private String detectedDeviceUuid;
    private final Lazy deviceErrorPublisher$delegate;
    private final Lazy deviceEventSerializer$delegate;
    private final Lazy deviceStatePublisher$delegate;
    private final StateFlow<BleDeviceState> deviceStateStream;
    private BleDeviceError error;
    private Continuation<? super Boolean> establishSessionContinuation;
    private final Lazy liveDeviceStateObserver$delegate;
    private Disposable pollingDeviceBoundedDisposable;
    /* access modifiers changed from: private */
    public Continuation<? super Integer> readFilterContinuation;
    /* access modifiers changed from: private */
    public Continuation<? super Boolean> resetFilterContinuation;
    private Security security;
    private final String serviceUuid;
    private Session session;
    private final Lazy transport$delegate;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public BleDeviceService(BluetoothDevice bluetoothDevice, String str, Context context, AnalyticsService analyticsService2) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "currentDevice");
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analyticsService2, "analyticsService");
        this.currentDevice = bluetoothDevice;
        this.serviceUuid = str;
        this.analyticsService = analyticsService2;
        this.deviceEventSerializer$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda1());
        MutableStateFlow<BleDeviceState> MutableStateFlow = StateFlowKt.MutableStateFlow(BleDeviceState.Disconnected.INSTANCE);
        this._deviceEvents = MutableStateFlow;
        this.deviceStateStream = MutableStateFlow;
        this.deviceStatePublisher$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda2());
        this.liveDeviceStateObserver$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda3(this));
        this.deviceErrorPublisher$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda4());
        this.transport$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda5(context, this));
    }

    public final BluetoothDevice getCurrentDevice() {
        return this.currentDevice;
    }

    public final String getServiceUuid() {
        return this.serviceUuid;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceService$Companion;", "", "<init>", "()V", "PROOF_OF_POSSESION_DEFAULT", "", "SSID_FETCH_SIZE", "", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final MoshiSerializer<DeviceEvent> getDeviceEventSerializer() {
        return (MoshiSerializer) this.deviceEventSerializer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final MoshiSerializer deviceEventSerializer_delegate$lambda$0() {
        return new MoshiSerializer(DeviceEvent.class, new Object[0]);
    }

    public final void sideLoadError(String str) {
        updateError(new BleDeviceError(getState(), str));
    }

    public final BleDeviceError getError() {
        return this.error;
    }

    private final void setError(BleDeviceError bleDeviceError) {
        this.error = bleDeviceError;
        if (bleDeviceError != null) {
            getDeviceErrorPublisher().onNext(bleDeviceError);
        }
    }

    public final BleDeviceState getState() {
        return this._deviceEvents.getValue();
    }

    private final void setState(BleDeviceState bleDeviceState) {
        this._deviceEvents.tryEmit(bleDeviceState);
        getDeviceStatePublisher().onNext(bleDeviceState);
    }

    public final String getDetectedDeviceUuid() {
        return this.detectedDeviceUuid;
    }

    public final StateFlow<BleDeviceState> getDeviceStateStream() {
        return this.deviceStateStream;
    }

    private final PublishSubject<BleDeviceState> getDeviceStatePublisher() {
        Object value = this.deviceStatePublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject deviceStatePublisher_delegate$lambda$1() {
        return PublishSubject.create();
    }

    public final Observable<BleDeviceState> getDeviceStateObserver() {
        Observable<BleDeviceState> hide = getDeviceStatePublisher().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    public final LiveData<BleDeviceState> getLiveDeviceStateObserver() {
        return (LiveData) this.liveDeviceStateObserver$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final LiveData liveDeviceStateObserver_delegate$lambda$2(BleDeviceService bleDeviceService) {
        Flowable<BleDeviceState> flowable = bleDeviceService.getDeviceStatePublisher().toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "toFlowable(...)");
        return LiveDataReactiveStreams.fromPublisher(flowable);
    }

    private final PublishSubject<BleDeviceError> getDeviceErrorPublisher() {
        Object value = this.deviceErrorPublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject deviceErrorPublisher_delegate$lambda$3() {
        return PublishSubject.create();
    }

    public final Observable<BleDeviceError> getDeviceErrorObserver() {
        Observable<BleDeviceError> hide = getDeviceErrorPublisher().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    public final boolean isConnected() {
        return getState().isEnabled(BleDeviceState.Connected.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.session;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getHasSession() {
        /*
            r2 = this;
            boolean r0 = r2.isConnected()
            if (r0 == 0) goto L_0x0012
            com.blueair.bluetooth.espressif.Session r0 = r2.session
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isEstablished()
            r1 = 1
            if (r0 != r1) goto L_0x0012
            return r1
        L_0x0012:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.bluetooth.service.BleDeviceService.getHasSession():boolean");
    }

    public final boolean isProvisioningStarted() {
        return getHasSession() && getState().getCode() >= BleDeviceState.ProvisioningStarted.INSTANCE.getCode();
    }

    public final boolean isProvisioningConfigured() {
        return getState().getCode() >= BleDeviceState.ProvisioningConfigured5.INSTANCE.getCode();
    }

    public final boolean isWifiConfigured() {
        return getState().getCode() >= BleDeviceState.WifiConfigured.INSTANCE.getCode();
    }

    public final boolean isWifiConfigApplied() {
        return getState().getCode() >= BleDeviceState.WifiConfigApplied.INSTANCE.getCode();
    }

    public final boolean isWifiConnected() {
        return getState().isEnabled(BleDeviceState.WifiConnected.INSTANCE);
    }

    public final boolean isBounded() {
        return getState().isEnabled(BleDeviceState.Bounded.INSTANCE);
    }

    public final BLETransport getTransport() {
        return (BLETransport) this.transport$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final BLETransport transport_delegate$lambda$4(Context context, BleDeviceService bleDeviceService) {
        return new BLETransport(context, new BleDeviceService$transport$2$1(bleDeviceService));
    }

    public final Security getSecurity() {
        return this.security;
    }

    public final void setSecurity(Security security2) {
        this.security = security2;
    }

    public final Session getSession() {
        return this.session;
    }

    public final void setSession(Session session2) {
        this.session = session2;
    }

    /* access modifiers changed from: private */
    public final void updateState(BleDeviceState bleDeviceState) {
        Timber.Forest forest = Timber.Forest;
        forest.d("updateState to " + bleDeviceState, new Object[0]);
        setState(bleDeviceState);
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.Connected.INSTANCE)) {
            Continuation<? super Boolean> continuation = this.connectionContinuation;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m9366constructorimpl(true));
            }
            this.connectionContinuation = null;
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.SessionEstablished.INSTANCE)) {
            Continuation<? super Boolean> continuation2 = this.establishSessionContinuation;
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m9366constructorimpl(true));
            }
            this.establishSessionContinuation = null;
        }
    }

    /* access modifiers changed from: private */
    public final void updateError(BleDeviceError bleDeviceError) {
        Timber.Forest forest = Timber.Forest;
        forest.d("updateError to " + bleDeviceError, new Object[0]);
        setError(bleDeviceError);
        BleDeviceState stateOccurred = bleDeviceError.getStateOccurred();
        if (Intrinsics.areEqual((Object) stateOccurred, (Object) BleDeviceState.Connecting.INSTANCE)) {
            Continuation<? super Boolean> continuation = this.connectionContinuation;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m9366constructorimpl(false));
            }
            this.connectionContinuation = null;
            Continuation<? super Boolean> continuation2 = this.establishSessionContinuation;
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m9366constructorimpl(false));
            }
            this.establishSessionContinuation = null;
            updateState(BleDeviceState.Disconnected.INSTANCE);
        } else if (Intrinsics.areEqual((Object) stateOccurred, (Object) BleDeviceState.SessionEstablishing.INSTANCE)) {
            Continuation<? super Boolean> continuation3 = this.establishSessionContinuation;
            if (continuation3 != null) {
                Result.Companion companion3 = Result.Companion;
                continuation3.resumeWith(Result.m9366constructorimpl(false));
            }
            this.establishSessionContinuation = null;
            updateState(BleDeviceState.Connected.INSTANCE);
        } else if (Intrinsics.areEqual((Object) stateOccurred, (Object) BleDeviceState.WifiConfigApplied.INSTANCE) || Intrinsics.areEqual((Object) stateOccurred, (Object) BleDeviceState.PollingWifiConfigStatus.INSTANCE)) {
            updateState(BleDeviceState.ProvisioningStarted.INSTANCE);
        }
    }

    public final void connect() {
        Timber.Forest forest = Timber.Forest;
        forest.d("connect: isConnected = " + isConnected(), new Object[0]);
        if (!isConnected()) {
            updateState(BleDeviceState.Connecting.INSTANCE);
            getTransport().connect(this.currentDevice, UUID.fromString(this.serviceUuid));
            return;
        }
        Continuation<? super Boolean> continuation = this.connectionContinuation;
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m9366constructorimpl(true));
        }
    }

    public final Object connectSync(Continuation<? super Boolean> continuation) {
        Timber.Forest.d("connectSync", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        this.connectionContinuation = safeContinuation;
        connect();
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void disconnect() {
        Timber.Forest forest = Timber.Forest;
        forest.d("disConnect: transport = " + getTransport(), new Object[0]);
        try {
            getTransport().disconnect();
        } catch (Throwable th) {
            Timber.Forest.w(th, "disConnect failed", new Object[0]);
        }
        stopPollDeviceBounded();
        this.security = null;
        this.session = null;
        Continuation<? super Boolean> continuation = this.connectionContinuation;
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m9366constructorimpl(false));
        }
        this.connectionContinuation = null;
        Continuation<? super Boolean> continuation2 = this.establishSessionContinuation;
        if (continuation2 != null) {
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m9366constructorimpl(false));
        }
        this.establishSessionContinuation = null;
        Continuation<? super Integer> continuation3 = this.readFilterContinuation;
        if (continuation3 != null) {
            Result.Companion companion3 = Result.Companion;
            continuation3.resumeWith(Result.m9366constructorimpl(-1));
        }
        this.readFilterContinuation = null;
        Continuation<? super Boolean> continuation4 = this.resetFilterContinuation;
        if (continuation4 != null) {
            Result.Companion companion4 = Result.Companion;
            continuation4.resumeWith(Result.m9366constructorimpl(false));
        }
        this.resetFilterContinuation = null;
        updateState(BleDeviceState.Disconnected.INSTANCE);
    }

    public static /* synthetic */ void establishSession$default(BleDeviceService bleDeviceService, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        bleDeviceService.establishSession(str, function0);
    }

    public final void establishSession(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "proofOfPossesion");
        Timber.Forest forest = Timber.Forest;
        forest.d("establishSession: isConnected = " + isConnected() + ", hasSession = " + getHasSession(), new Object[0]);
        if (!isConnected()) {
            Continuation<? super Boolean> continuation = this.establishSessionContinuation;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m9366constructorimpl(false));
            }
        } else if (getHasSession()) {
            Continuation<? super Boolean> continuation2 = this.establishSessionContinuation;
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m9366constructorimpl(true));
            }
        } else {
            updateState(BleDeviceState.SessionEstablishing.INSTANCE);
            Security security1 = new Security1(str);
            this.security = security1;
            Session session2 = new Session(getTransport(), security1);
            session2.sessionListener = new BleDeviceService$establishSession$1(this, function0);
            this.session = session2;
            session2.init((byte[]) null);
        }
    }

    public static /* synthetic */ Object establishSessionSync$default(BleDeviceService bleDeviceService, String str, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return bleDeviceService.establishSessionSync(str, function0, continuation);
    }

    public final Object establishSessionSync(String str, Function0<Unit> function0, Continuation<? super Boolean> continuation) {
        Timber.Forest.d("establishSessionSync", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        this.establishSessionContinuation = safeContinuation;
        establishSession(str, function0);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r8 == r0) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connectAndEstablishSessionSync(kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionSync$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionSync$1 r0 = (com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionSync$1 r0 = new com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionSync$1
            r0.<init>(r7, r8)
        L_0x0019:
            r4 = r0
            java.lang.Object r8 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 0
            r3 = 2
            r5 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 == r5) goto L_0x0037
            if (r1 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r8)
            return r8
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0050
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
            timber.log.Timber$Forest r8 = timber.log.Timber.Forest
            java.lang.String r1 = "connectAndEstablishSessionSync"
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r8.d(r1, r6)
            r4.label = r5
            java.lang.Object r8 = r7.connectSync(r4)
            if (r8 != r0) goto L_0x0050
            goto L_0x0065
        L_0x0050:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0067
            r4.label = r3
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r1 = r7
            java.lang.Object r8 = establishSessionSync$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x0066
        L_0x0065:
            return r0
        L_0x0066:
            return r8
        L_0x0067:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.bluetooth.service.BleDeviceService.connectAndEstablishSessionSync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object readFilterSync(DeviceFilterType deviceFilterType, Continuation<? super Integer> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("readFilterSync: " + deviceFilterType, new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation<? super Integer> continuation2 = safeContinuation;
        this.readFilterContinuation = continuation2;
        CustomCommands.CommandWrapper commandWrapper = (CustomCommands.CommandWrapper) CustomCommands.CommandWrapper.newBuilder().setFilterReadCmd((CustomCommands.FilterReadCmd) CustomCommands.FilterReadCmd.newBuilder().setType(String.valueOf(deviceFilterType.ordinal())).build()).build();
        Intrinsics.checkNotNull(commandWrapper);
        sendWrapper(commandWrapper, new BleDeviceService$readFilterSync$2$1(continuation2, this), new BleDeviceService$readFilterSync$2$2(continuation2, this));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object resetFilterSync(String str, Continuation<? super Boolean> continuation) {
        Timber.Forest.d("resetFilterSync", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation<? super Boolean> continuation2 = safeContinuation;
        this.resetFilterContinuation = continuation2;
        CustomCommands.CommandWrapper commandWrapper = (CustomCommands.CommandWrapper) CustomCommands.CommandWrapper.newBuilder().setFilterSetCmd((CustomCommands.FilterSetCmd) CustomCommands.FilterSetCmd.newBuilder().setFilter(str).build()).build();
        Intrinsics.checkNotNull(commandWrapper);
        sendWrapper(commandWrapper, new BleDeviceService$resetFilterSync$2$1(continuation2, this), new BleDeviceService$resetFilterSync$2$2(continuation2, this));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object startProvisioningSync(Continuation<? super Boolean> continuation) {
        Timber.Forest.d("startProvisioningSync", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        CustomCommands.CommandWrapper commandWrapper = (CustomCommands.CommandWrapper) CustomCommands.CommandWrapper.newBuilder().setStartCmd((CustomCommands.StartCmd) CustomCommands.StartCmd.newBuilder().build()).build();
        Intrinsics.checkNotNull(commandWrapper);
        sendWrapper(commandWrapper, new BleDeviceService$startProvisioningSync$2$1(this, continuation2), new BleDeviceService$startProvisioningSync$2$2(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        if (r9 == r1) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connectAndEstablishSessionAndStartProvisioningSync(kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1 r0 = (com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1 r0 = new com.blueair.bluetooth.service.BleDeviceService$connectAndEstablishSessionAndStartProvisioningSync$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r6) goto L_0x003d
            if (r2 == r5) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r9)
            return r9
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0066
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            return r9
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest
            java.lang.String r2 = "connectEstablishSessionAndStartProvisioningSync"
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r9.d(r2, r7)
            boolean r9 = r8.getHasSession()
            if (r9 == 0) goto L_0x005d
            r0.label = r6
            java.lang.Object r9 = r8.startProvisioningSync(r0)
            if (r9 != r1) goto L_0x005c
            goto L_0x0076
        L_0x005c:
            return r9
        L_0x005d:
            r0.label = r5
            java.lang.Object r9 = r8.connectAndEstablishSessionSync(r0)
            if (r9 != r1) goto L_0x0066
            goto L_0x0076
        L_0x0066:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0078
            r0.label = r4
            java.lang.Object r9 = r8.startProvisioningSync(r0)
            if (r9 != r1) goto L_0x0077
        L_0x0076:
            return r1
        L_0x0077:
            return r9
        L_0x0078:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.bluetooth.service.BleDeviceService.connectAndEstablishSessionAndStartProvisioningSync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final BleDeviceState nextConfigureProvisionStep() {
        if (isProvisioningStarted() && !isProvisioningConfigured()) {
            BleDeviceState state = getState();
            if (Intrinsics.areEqual((Object) state, (Object) BleDeviceState.ProvisioningStarted.INSTANCE)) {
                return BleDeviceState.ProvisioningConfigured0.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) state, (Object) BleDeviceState.ProvisioningConfigured0.INSTANCE)) {
                return BleDeviceState.ProvisioningConfigured1.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) state, (Object) BleDeviceState.ProvisioningConfigured1.INSTANCE)) {
                return BleDeviceState.ProvisioningConfigured2.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) state, (Object) BleDeviceState.ProvisioningConfigured2.INSTANCE)) {
                return BleDeviceState.ProvisioningConfigured3.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) state, (Object) BleDeviceState.ProvisioningConfigured3.INSTANCE)) {
                return BleDeviceState.ProvisioningConfigured4.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) state, (Object) BleDeviceState.ProvisioningConfigured4.INSTANCE)) {
                return BleDeviceState.ProvisioningConfigured5.INSTANCE;
            }
        }
        return null;
    }

    public final Object configureProvisionSync(ProvisionConfig provisionConfig, Continuation<? super Boolean> continuation) {
        Timber.Forest forest = Timber.Forest;
        boolean z = false;
        forest.d("configureProvisionSync: config = " + provisionConfig, new Object[0]);
        if (isProvisioningConfigured()) {
            z = true;
        } else if (!isProvisioningStarted()) {
            updateError(new BleDeviceError(getState(), "Not in required state of ProvisioningStarted"));
        } else {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Continuation continuation2 = safeContinuation;
            BleDeviceState nextConfigureProvisionStep = nextConfigureProvisionStep();
            if (nextConfigureProvisionStep != null) {
                configureProvisionStep(nextConfigureProvisionStep, provisionConfig, continuation2);
            } else {
                Timber.Forest.e("configureProvisionSync: step should not be null", new Object[0]);
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m9366constructorimpl(Boxing.boxBoolean(false)));
            }
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(z);
    }

    private final void configureProvisionStep(BleDeviceState bleDeviceState, ProvisionConfig provisionConfig, Continuation<? super Boolean> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("configureProvisionStep: step = " + bleDeviceState + ", config = " + provisionConfig, new Object[0]);
        CustomCommands.ConfigCmd.Builder newBuilder = CustomCommands.ConfigCmd.newBuilder();
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.ProvisioningConfigured0.INSTANCE)) {
            newBuilder.setApiUrl(provisionConfig.getApiUrl());
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.ProvisioningConfigured1.INSTANCE)) {
            newBuilder.setAuthUrl(provisionConfig.getAuthUrl());
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.ProvisioningConfigured2.INSTANCE)) {
            newBuilder.setBrokerUrl(provisionConfig.getBrokerUrl());
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.ProvisioningConfigured3.INSTANCE)) {
            newBuilder.setRegion(provisionConfig.getRegion());
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.ProvisioningConfigured4.INSTANCE)) {
            newBuilder.setRandomText(provisionConfig.getRandomText());
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.ProvisioningConfigured5.INSTANCE)) {
            newBuilder.setSecureRandom(provisionConfig.getSecureRandom());
        }
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("configureProvisionStep: configRequest = " + newBuilder, new Object[0]);
        CustomCommands.CommandWrapper commandWrapper = (CustomCommands.CommandWrapper) CustomCommands.CommandWrapper.newBuilder().setConfigCmd((CustomCommands.ConfigCmd) newBuilder.build()).build();
        Intrinsics.checkNotNull(commandWrapper);
        sendWrapper(commandWrapper, new BleDeviceService$$ExternalSyntheticLambda13(this, bleDeviceState, provisionConfig, continuation), new BleDeviceService$$ExternalSyntheticLambda14(continuation));
    }

    /* access modifiers changed from: private */
    public static final Unit configureProvisionStep$lambda$11(BleDeviceService bleDeviceService, BleDeviceState bleDeviceState, ProvisionConfig provisionConfig, Continuation continuation, CustomCommands.CommandWrapper commandWrapper) {
        Intrinsics.checkNotNullParameter(commandWrapper, "wrappedResponse");
        Timber.Forest forest = Timber.Forest;
        forest.d("configureProvisionStep:  onSuccess: response status: " + commandWrapper.getConfigResp().getStatus(), new Object[0]);
        bleDeviceService.updateState(bleDeviceState);
        BleDeviceState nextConfigureProvisionStep = bleDeviceService.nextConfigureProvisionStep();
        if (nextConfigureProvisionStep != null) {
            bleDeviceService.configureProvisionStep(nextConfigureProvisionStep, provisionConfig, continuation);
        } else {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m9366constructorimpl(true));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureProvisionStep$lambda$12(Continuation continuation, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Timber.Forest.e(th, "configureProvisionStep:  onFail", new Object[0]);
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(false));
        return Unit.INSTANCE;
    }

    public final Object configureWifiSync(String str, String str2, Continuation<? super Boolean> continuation) {
        Timber.Forest forest = Timber.Forest;
        boolean z = false;
        forest.d("configureWifiSync: ssid = " + str + ", passphrase = " + str2, new Object[0]);
        if (isWifiConfigured()) {
            z = true;
        } else if (isProvisioningConfigured()) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            configureWifi(str, str2, safeContinuation);
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(z);
    }

    private final void configureWifi(String str, String str2, Continuation<? super Boolean> continuation) {
        new Provision(this.session).configureWifi(str, str2, new BleDeviceService$configureWifi$1(this, continuation));
    }

    public final Object applyWifiConfigSync(Continuation<? super Boolean> continuation) {
        boolean z = false;
        Timber.Forest.d("applyWifiConfigSync", new Object[0]);
        if (isWifiConfigApplied()) {
            z = true;
        } else if (isWifiConfigured()) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            applyWifiConfig(safeContinuation);
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(z);
    }

    private final void applyWifiConfig(Continuation<? super Boolean> continuation) {
        Timber.Forest.d("applyWifiConfig", new Object[0]);
        new Provision(this.session).applyConfigurations(new BleDeviceService$applyWifiConfig$1(this, continuation));
    }

    public final Object pollWifiConnectionStatus(Continuation<? super Boolean> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("pollWifiConnectionStatus: state = " + getState(), new Object[0]);
        if (isWifiConnected()) {
            return Boxing.boxBoolean(false);
        }
        updateState(BleDeviceState.PollingWifiConfigStatus.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new BleDeviceService$pollWifiConnectionStatus$2(this, (Continuation<? super BleDeviceService$pollWifiConnectionStatus$2>) null), 2, (Object) null);
        return Boxing.boxBoolean(true);
    }

    /* access modifiers changed from: private */
    public final Object getDeviceEvents(Continuation<? super String> continuation) {
        Timber.Forest.d("getDeviceEvents", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        CustomCommands.CommandWrapper commandWrapper = (CustomCommands.CommandWrapper) CustomCommands.CommandWrapper.newBuilder().setEventCmd((CustomCommands.EventCmd) CustomCommands.EventCmd.newBuilder().build()).build();
        Intrinsics.checkNotNull(commandWrapper);
        sendWrapper(commandWrapper, new BleDeviceService$getDeviceEvents$2$1(continuation2), new BleDeviceService$getDeviceEvents$2$2(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0163, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r9, r2) != r3) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object startPollDeviceBounded(io.reactivex.subjects.PublishSubject<java.lang.String> r22, io.reactivex.disposables.Disposable r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r24
            boolean r2 = r0 instanceof com.blueair.bluetooth.service.BleDeviceService$startPollDeviceBounded$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.blueair.bluetooth.service.BleDeviceService$startPollDeviceBounded$1 r2 = (com.blueair.bluetooth.service.BleDeviceService$startPollDeviceBounded$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.blueair.bluetooth.service.BleDeviceService$startPollDeviceBounded$1 r2 = new com.blueair.bluetooth.service.BleDeviceService$startPollDeviceBounded$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0072
            if (r4 == r7) goto L_0x0056
            if (r4 != r5) goto L_0x004e
            int r4 = r2.I$2
            long r9 = r2.J$2
            int r11 = r2.I$1
            long r12 = r2.J$1
            long r14 = r2.J$0
            int r5 = r2.I$0
            java.lang.Object r8 = r2.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r2.L$1
            io.reactivex.disposables.Disposable r8 = (io.reactivex.disposables.Disposable) r8
            java.lang.Object r7 = r2.L$0
            io.reactivex.subjects.PublishSubject r7 = (io.reactivex.subjects.PublishSubject) r7
            kotlin.ResultKt.throwOnFailure(r0)
            r1 = 2
        L_0x004a:
            r16 = 1
            goto L_0x0166
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0056:
            int r4 = r2.I$2
            long r7 = r2.J$2
            int r5 = r2.I$1
            long r9 = r2.J$1
            long r11 = r2.J$0
            int r13 = r2.I$0
            java.lang.Object r14 = r2.L$1
            io.reactivex.disposables.Disposable r14 = (io.reactivex.disposables.Disposable) r14
            java.lang.Object r15 = r2.L$0
            io.reactivex.subjects.PublishSubject r15 = (io.reactivex.subjects.PublishSubject) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x006f }
            goto L_0x00c8
        L_0x006f:
            r0 = move-exception
            goto L_0x00db
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r0)
            long r4 = java.lang.System.currentTimeMillis()
            r7 = 120000(0x1d4c0, double:5.9288E-319)
            r9 = 500(0x1f4, double:2.47E-321)
            r0 = 60
            r13 = r4
            r11 = r7
            r8 = 0
            r4 = r23
            r7 = r0
            r5 = r2
            r0 = 0
            r2 = r22
        L_0x008a:
            if (r0 != 0) goto L_0x01a6
            if (r8 >= r7) goto L_0x01a6
            boolean r15 = r4.isDisposed()
            if (r15 != 0) goto L_0x01a6
            long r17 = java.lang.System.currentTimeMillis()
            long r17 = r17 - r13
            int r15 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x01a6
            r5.L$0 = r2     // Catch:{ all -> 0x00cf }
            r5.L$1 = r4     // Catch:{ all -> 0x00cf }
            r5.L$2 = r6     // Catch:{ all -> 0x00cf }
            r5.I$0 = r0     // Catch:{ all -> 0x00cf }
            r5.J$0 = r13     // Catch:{ all -> 0x00cf }
            r5.J$1 = r11     // Catch:{ all -> 0x00cf }
            r5.I$1 = r8     // Catch:{ all -> 0x00cf }
            r5.J$2 = r9     // Catch:{ all -> 0x00cf }
            r5.I$2 = r7     // Catch:{ all -> 0x00cf }
            r15 = 1
            r5.label = r15     // Catch:{ all -> 0x00cf }
            java.lang.Object r15 = r1.getDeviceEvents(r5)     // Catch:{ all -> 0x00cf }
            if (r15 != r3) goto L_0x00bb
            goto L_0x0165
        L_0x00bb:
            r19 = r13
            r13 = r0
            r14 = r4
            r4 = r7
            r0 = r15
            r15 = r2
            r2 = r5
            r5 = r8
            r7 = r9
            r9 = r11
            r11 = r19
        L_0x00c8:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x006f }
            r19 = r11
            r11 = r5
            r5 = r13
            goto L_0x00ee
        L_0x00cf:
            r0 = move-exception
            r15 = r2
            r2 = r5
            r5 = r8
            r19 = r13
            r14 = r4
            r4 = r7
            r7 = r9
            r9 = r11
            r11 = r19
        L_0x00db:
            timber.log.Timber$Forest r13 = timber.log.Timber.Forest
            java.lang.String r6 = "startPollDeviceBounded: deviceEventSerializer.fromJson failed"
            r22 = r2
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r13.e(r0, r6, r2)
            r2 = r22
            r0 = 0
            r19 = r11
            r11 = r5
            r5 = 1
        L_0x00ee:
            r12 = r9
            r9 = r7
            r8 = r14
            r7 = r15
            r14 = r19
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r18 = r3
            java.lang.String r3 = "startPollDeviceBounded: json = "
            r6.<init>(r3)
            r6.append(r0)
            java.lang.String r3 = ", length = "
            r6.append(r3)
            if (r0 == 0) goto L_0x0112
            int r3 = r0.length()
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            goto L_0x0113
        L_0x0112:
            r3 = 0
        L_0x0113:
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r22 = r4
            r6 = 0
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r1.v(r3, r4)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0140
            int r1 = r1.length()
            if (r1 != 0) goto L_0x012e
            goto L_0x0140
        L_0x012e:
            r7.onNext(r0)
            r0 = r5
            r4 = r8
            r11 = r12
            r13 = r14
            r3 = r18
            r1 = 2
            r8 = 0
            r16 = 1
            r5 = r2
            r2 = r7
            r7 = r22
            goto L_0x0179
        L_0x0140:
            if (r5 != 0) goto L_0x0171
            r2.L$0 = r7
            r2.L$1 = r8
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r2.L$2 = r0
            r2.I$0 = r5
            r2.J$0 = r14
            r2.J$1 = r12
            r2.I$1 = r11
            r2.J$2 = r9
            r4 = r22
            r2.I$2 = r4
            r1 = 2
            r2.label = r1
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r9, r2)
            r3 = r18
            if (r0 != r3) goto L_0x004a
        L_0x0165:
            return r3
        L_0x0166:
            int r11 = r11 + 1
        L_0x0168:
            r0 = r5
            r5 = r2
            r2 = r7
            r7 = r4
            r4 = r8
            r8 = r11
            r11 = r12
            r13 = r14
            goto L_0x0179
        L_0x0171:
            r4 = r22
            r3 = r18
            r1 = 2
            r16 = 1
            goto L_0x0168
        L_0x0179:
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "startPollDeviceBounded: isException = "
            r15.<init>(r1)
            if (r0 == 0) goto L_0x0187
            r1 = r16
            goto L_0x0188
        L_0x0187:
            r1 = 0
        L_0x0188:
            r15.append(r1)
            java.lang.String r1 = ", failCount = "
            r15.append(r1)
            r15.append(r8)
            java.lang.String r1 = r15.toString()
            r22 = r0
            r15 = 0
            java.lang.Object[] r0 = new java.lang.Object[r15]
            r6.v(r1, r0)
            r1 = r21
            r0 = r22
            r6 = 0
            goto L_0x008a
        L_0x01a6:
            java.lang.String r0 = "WILL CAUSE DESERIALIZE EXCEPTION"
            r2.onNext(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.bluetooth.service.BleDeviceService.startPollDeviceBounded(io.reactivex.subjects.PublishSubject, io.reactivex.disposables.Disposable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void stopPollDeviceBounded() {
        Timber.Forest.v("stopPollDeviceBounded", new Object[0]);
        Disposable disposable = this.pollingDeviceBoundedDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.pollingDeviceBoundedDisposable = null;
    }

    private final void pollDeviceBoundedSuccess(DeviceEvent deviceEvent) {
        String str;
        Timber.Forest.v("pollDeviceBoundedSuccess", new Object[0]);
        AnalyticsService analyticsService2 = this.analyticsService;
        if (deviceEvent == null || (str = deviceEvent.getOrigin()) == null) {
            str = "";
        }
        analyticsService2.event(new AnalyticEvent.BT_SUCCESS(str));
        updateState(BleDeviceState.Bounded.INSTANCE);
        stopPollDeviceBounded();
    }

    private final void pollDeviceBoundedFail(DeviceEvent deviceEvent) {
        String str;
        String connectionEvent;
        int i = 0;
        Timber.Forest.v("pollDeviceBoundedFail", new Object[0]);
        AnalyticsService analyticsService2 = this.analyticsService;
        String str2 = "";
        if (deviceEvent == null || (str = deviceEvent.getOrigin()) == null) {
            str = str2;
        }
        if (!(deviceEvent == null || (connectionEvent = deviceEvent.getConnectionEvent()) == null)) {
            str2 = connectionEvent;
        }
        if (deviceEvent != null) {
            i = deviceEvent.getErrorCode();
        }
        analyticsService2.event(new AnalyticEvent.BT_EVENT_FAILURE(str, str2, i));
        updateError(new BleDeviceError(BleDeviceState.WifiConnected.INSTANCE, deviceEvent != null ? deviceEvent.getErrorMessage() : null));
        stopPollDeviceBounded();
    }

    public final Object pollDeviceBounded(Continuation<? super Boolean> continuation) {
        Timber.Forest.v("pollDeviceBounded", new Object[0]);
        if (isBounded()) {
            return Boxing.boxBoolean(false);
        }
        if (this.pollingDeviceBoundedDisposable != null) {
            stopPollDeviceBounded();
        }
        PublishSubject create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        Disposable subscribe = create.subscribe(new BleDeviceService$$ExternalSyntheticLambda6(new BleDeviceService$$ExternalSyntheticLambda0(this)), new BleDeviceService$$ExternalSyntheticLambda8(new BleDeviceService$$ExternalSyntheticLambda7(this)));
        this.pollingDeviceBoundedDisposable = subscribe;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new BleDeviceService$pollDeviceBounded$3(this, create, subscribe, (Continuation<? super BleDeviceService$pollDeviceBounded$3>) null), 2, (Object) null);
        return Boxing.boxBoolean(true);
    }

    /* access modifiers changed from: private */
    public static final void pollDeviceBounded$lambda$19(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit pollDeviceBounded$lambda$18(BleDeviceService bleDeviceService, String str) {
        DeviceEvent deviceEvent;
        boolean z;
        String origin;
        Boolean bool = null;
        boolean z2 = true;
        try {
            Timber.Forest.v("pollDeviceBounded: pollDeviceBounded: json = " + str, new Object[0]);
            MoshiSerializer<DeviceEvent> deviceEventSerializer = bleDeviceService.getDeviceEventSerializer();
            Intrinsics.checkNotNull(str);
            deviceEvent = deviceEventSerializer.fromJson(str);
            z = false;
        } catch (Throwable th) {
            Timber.Forest.e(th, "pollDeviceBounded: deviceEventSerializer.fromJson failed", new Object[0]);
            deviceEvent = null;
            z = true;
        }
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("pollDeviceBounded: onboardingState = ");
        sb.append(deviceEvent != null ? deviceEvent.getOnboardingState() : null);
        sb.append(", hasError = ");
        if (deviceEvent != null) {
            bool = Boolean.valueOf(deviceEvent.getHasError());
        }
        sb.append(bool);
        sb.append(", event = ");
        sb.append(deviceEvent);
        forest.v(sb.toString(), new Object[0]);
        if (!(deviceEvent == null || (origin = deviceEvent.getOrigin()) == null || origin.length() == 0)) {
            bleDeviceService.detectedDeviceUuid = origin;
        }
        boolean z3 = deviceEvent != null && Intrinsics.areEqual((Object) deviceEvent.getOnboardingState(), (Object) OnboardingState.DeviceBound.INSTANCE) && !deviceEvent.getHasError();
        if (!z && (deviceEvent == null || !deviceEvent.getHasError() || Intrinsics.areEqual((Object) OnboardingError.Companion.getOnboardingError(deviceEvent), (Object) OnboardingError.HoldingError.INSTANCE))) {
            z2 = false;
        }
        if (z3) {
            Timber.Forest.v("pollDeviceBounded: SUCCESS", new Object[0]);
            bleDeviceService.pollDeviceBoundedSuccess(deviceEvent);
        } else if (z2) {
            Timber.Forest.v("pollDeviceBounded: FAIL", new Object[0]);
            bleDeviceService.pollDeviceBoundedFail(deviceEvent);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void pollDeviceBounded$lambda$21(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit pollDeviceBounded$lambda$20(BleDeviceService bleDeviceService, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest forest = Timber.Forest;
        forest.e(th, "pollDeviceBounded: eventPublisher FAIL, isBounded = " + bleDeviceService.isBounded(), new Object[0]);
        if (bleDeviceService.isBounded()) {
            bleDeviceService.stopPollDeviceBounded();
        } else {
            bleDeviceService.pollDeviceBoundedFail((DeviceEvent) null);
        }
        return Unit.INSTANCE;
    }

    public final Object wifiScanSync(Continuation<? super List<Ssid>> continuation) {
        Timber.Forest.d("wifiScanSync", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        startWifiScan(new BleDeviceService$wifiScanSync$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void startWifiScan(Function1<? super List<Ssid>, Unit> function1) {
        Timber.Forest.d("startWifiScan", new Object[0]);
        WifiScan.WiFiScanPayload wiFiScanPayload = (WifiScan.WiFiScanPayload) WifiScan.WiFiScanPayload.newBuilder().setMsg(WifiScan.WiFiScanMsgType.TypeCmdScanStart).setCmdScanStart((WifiScan.CmdScanStart) WifiScan.CmdScanStart.newBuilder().setBlocking(true).setPassive(false).setGroupChannels(0).setPeriodMs(MenuKt.InTransitionDuration).build()).build();
        try {
            Security security2 = this.security;
            byte[] encrypt = security2 != null ? security2.encrypt(wiFiScanPayload.toByteArray()) : null;
            Timber.Forest forest = Timber.Forest;
            forest.d("startWifiScan: data = " + encrypt, new Object[0]);
            getTransport().sendConfigData(AppConstants.HANDLER_PROV_SCAN, encrypt, new BleDeviceService$startWifiScan$1(this, function1));
        } catch (Exception e) {
            Timber.Forest.e(e, "startWifiScan: fail", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void processStartScan(byte[] bArr) {
        Timber.Forest forest = Timber.Forest;
        forest.d("processStartScan: responseData = " + bArr, new Object[0]);
        Security security2 = this.security;
        byte[] decrypt = security2 != null ? security2.decrypt(bArr) : null;
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("processStartScan: decryptedData = " + decrypt, new Object[0]);
        try {
            WifiScan.RespScanStart parseFrom = WifiScan.RespScanStart.parseFrom(WifiScan.WiFiScanPayload.parseFrom(decrypt).toByteArray());
            Timber.Forest forest3 = Timber.Forest;
            forest3.d("processStartScan: response " + parseFrom, new Object[0]);
        } catch (InvalidProtocolBufferException e) {
            Timber.Forest.e(e, "processStartScan: parse fail", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void getWifiScanStatus(Function1<? super List<Ssid>, Unit> function1) {
        Timber.Forest.d("getWifiScanStatus", new Object[0]);
        WifiScan.WiFiScanPayload wiFiScanPayload = (WifiScan.WiFiScanPayload) WifiScan.WiFiScanPayload.newBuilder().setMsg(WifiScan.WiFiScanMsgType.TypeCmdScanStatus).setCmdScanStatus((WifiScan.CmdScanStatus) WifiScan.CmdScanStatus.newBuilder().build()).build();
        Security security2 = this.security;
        byte[] encrypt = security2 != null ? security2.encrypt(wiFiScanPayload.toByteArray()) : null;
        Timber.Forest forest = Timber.Forest;
        forest.d("getWifiScanStatus: data = " + encrypt, new Object[0]);
        getTransport().sendConfigData(AppConstants.HANDLER_PROV_SCAN, encrypt, new BleDeviceService$getWifiScanStatus$1(this, function1));
    }

    /* access modifiers changed from: private */
    public final void processGetWifiStatus(byte[] bArr, Function1<? super List<Ssid>, Unit> function1) {
        Timber.Forest.d("processGetWifiStatus", new Object[0]);
        Security security2 = this.security;
        byte[] decrypt = security2 != null ? security2.decrypt(bArr) : null;
        Timber.Forest forest = Timber.Forest;
        forest.d("processGetWifiStatus: decryptedData = " + decrypt, new Object[0]);
        try {
            WifiScan.RespScanStatus respScanStatus = WifiScan.WiFiScanPayload.parseFrom(decrypt).getRespScanStatus();
            if (respScanStatus.getScanFinished()) {
                getFullWiFiList(respScanStatus.getResultCount(), 0, new BleDeviceService$$ExternalSyntheticLambda11(function1));
                return;
            }
            Timber.Forest.e("processGetWifiStatus: scan not finished", new Object[0]);
            function1.invoke(CollectionsKt.emptyList());
        } catch (InvalidProtocolBufferException e) {
            Timber.Forest.e(e, "processGetWifiStatus error", new Object[0]);
            function1.invoke(CollectionsKt.emptyList());
        }
    }

    /* access modifiers changed from: private */
    public static final Unit processGetWifiStatus$lambda$23(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        function1.invoke(list);
        return Unit.INSTANCE;
    }

    private final void getFullWiFiList(int i, int i2, Function1<? super List<Ssid>, Unit> function1) {
        int i3 = i - i2;
        Timber.Forest forest = Timber.Forest;
        forest.d("getFullWiFiList: Total totalCount : " + i + ", startIndex = " + i2 + ", currentCount = " + i3, new Object[0]);
        if (i3 == 0) {
            function1.invoke(CollectionsKt.emptyList());
        } else if (i3 < 4) {
            getWiFiScanList(i2, i3, new BleDeviceService$$ExternalSyntheticLambda9(function1));
        } else {
            getWiFiScanList(i2, 4, new BleDeviceService$$ExternalSyntheticLambda10(i2, this, i, function1));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit getFullWiFiList$lambda$24(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        function1.invoke(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit getFullWiFiList$lambda$26(int i, BleDeviceService bleDeviceService, int i2, Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        bleDeviceService.getFullWiFiList(i2, i + 4, new BleDeviceService$$ExternalSyntheticLambda12(function1, list));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit getFullWiFiList$lambda$26$lambda$25(Function1 function1, List list, List list2) {
        Intrinsics.checkNotNullParameter(list2, "nuList");
        function1.invoke(CollectionsKt.plus(list, list2));
        return Unit.INSTANCE;
    }

    private final void getWiFiScanList(int i, int i2, Function1<? super List<Ssid>, Unit> function1) {
        Timber.Forest forest = Timber.Forest;
        forest.d("getWiFiScanList: start = " + i + ", count " + i2, new Object[0]);
        WifiScan.WiFiScanPayload wiFiScanPayload = (WifiScan.WiFiScanPayload) WifiScan.WiFiScanPayload.newBuilder().setMsg(WifiScan.WiFiScanMsgType.TypeCmdScanResult).setCmdScanResult((WifiScan.CmdScanResult) WifiScan.CmdScanResult.newBuilder().setStartIndex(i).setCount(i2).build()).build();
        Security security2 = this.security;
        getTransport().sendConfigData(AppConstants.HANDLER_PROV_SCAN, security2 != null ? security2.encrypt(wiFiScanPayload.toByteArray()) : null, new BleDeviceService$getWiFiScanList$1(this, function1));
    }

    /* access modifiers changed from: private */
    public final List<Ssid> processGetSSIDs(byte[] bArr) {
        Security security2 = this.security;
        byte[] decrypt = security2 != null ? security2.decrypt(bArr) : null;
        Timber.Forest forest = Timber.Forest;
        forest.d("processGetSSIDs: decryptedData = " + decrypt, new Object[0]);
        try {
            WifiScan.RespScanResult respScanResult = WifiScan.WiFiScanPayload.parseFrom(decrypt).getRespScanResult();
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("processGetSSIDs: Response count = " + respScanResult.getEntriesCount() + ", response = " + respScanResult, new Object[0]);
            List<WifiScan.WiFiScanResult> entriesList = respScanResult.getEntriesList();
            if (entriesList == null) {
                return CollectionsKt.emptyList();
            }
            Iterable<WifiScan.WiFiScanResult> iterable = entriesList;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (WifiScan.WiFiScanResult wiFiScanResult : iterable) {
                arrayList.add(new Ssid(wiFiScanResult.getSsid().toStringUtf8(), wiFiScanResult.getBssid().toStringUtf8(), wiFiScanResult.getRssi(), wiFiScanResult.getAuth().name()));
            }
            return (List) arrayList;
        } catch (InvalidProtocolBufferException e) {
            Timber.Forest.e(e, "processGetSSIDs failed", new Object[0]);
            return CollectionsKt.emptyList();
        }
    }

    private final void sendWrapper(CustomCommands.CommandWrapper commandWrapper, Function1<? super CustomCommands.CommandWrapper, Unit> function1, Function1<? super Throwable, Unit> function12) {
        try {
            Security security2 = this.security;
            byte[] encrypt = security2 != null ? security2.encrypt(commandWrapper.toByteArray()) : null;
            Timber.Forest forest = Timber.Forest;
            forest.d("sendWrapper: data = " + encrypt, new Object[0]);
            getTransport().sendConfigData(AppConstants.HANDLER_CUSTOM_COMMANDS, encrypt, new BleDeviceService$sendWrapper$1(function1, this, function12));
        } catch (Exception e) {
            Timber.Forest.e(e, "sendWrapper: failed", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final CustomCommands.CommandWrapper processCustomCommand(byte[] bArr) {
        Security security2 = this.security;
        CustomCommands.CommandWrapper parseFrom = CustomCommands.CommandWrapper.parseFrom(security2 != null ? security2.decrypt(bArr) : null);
        Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(...)");
        return parseFrom;
    }
}
