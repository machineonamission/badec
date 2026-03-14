package com.blueair.bluetooth.service;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.blueair.bluetooth.espressif.BLETransport;
import com.blueair.bluetooth.espressif.Provision;
import com.blueair.bluetooth.espressif.ResponseListener;
import com.blueair.bluetooth.espressif.Security;
import com.blueair.bluetooth.espressif.Security1;
import com.blueair.bluetooth.espressif.Session;
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
import custom.CustomCommands.CommandWrapper;
import custom.CustomCommands.ConfigCmd;
import custom.CustomCommands.EventCmd;
import custom.CustomCommands.FilterReadCmd;
import custom.CustomCommands.FilterSetCmd;
import custom.CustomCommands.StartCmd;
import espressif.Constants;
import espressif.WifiConstants;
import espressif.WifiScan;
import espressif.Constants.Status;
import espressif.WifiConstants.WifiStationState;
import espressif.WifiScan.CmdScanResult;
import espressif.WifiScan.CmdScanStart;
import espressif.WifiScan.CmdScanStatus;
import espressif.WifiScan.RespScanStart;
import espressif.WifiScan.WiFiScanMsgType;
import espressif.WifiScan.WiFiScanPayload;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.reactivestreams.Publisher;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 º\u00012\u00020\u0001:\u0002º\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010h\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010i\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010j\u001a\u00020\u001aJ\u000e\u0010k\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\u0006\u0010m\u001a\u00020\u001aJ\"\u0010n\u001a\u00020\u001a2\b\b\u0002\u0010o\u001a\u00020\u00052\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010qJ*\u0010r\u001a\u00020G2\b\b\u0002\u0010o\u001a\u00020\u00052\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010qH\u0086@¢\u0006\u0002\u0010sJ\u000e\u0010t\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\u0016\u0010u\u001a\u00020f2\u0006\u0010v\u001a\u00020wH\u0086@¢\u0006\u0002\u0010xJ\u0016\u0010y\u001a\u00020G2\u0006\u0010z\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010{J\u000e\u0010|\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\u000e\u0010}\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\n\u0010~\u001a\u0004\u0018\u00010$H\u0002J\u0019\u0010\u007f\u001a\u00020G2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0086@¢\u0006\u0003\u0010\u0082\u0001J+\u0010\u0083\u0001\u001a\u00020\u001a2\u0007\u0010\u0084\u0001\u001a\u00020$2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020G0cH\u0002J$\u0010\u0086\u0001\u001a\u00020G2\u0007\u0010\u0087\u0001\u001a\u00020\u00052\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0003\u0010\u0089\u0001J,\u0010\u008a\u0001\u001a\u00020\u001a2\u0007\u0010\u0087\u0001\u001a\u00020\u00052\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00052\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020G0cH\u0002J\u000f\u0010\u008c\u0001\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\u0018\u0010\u008d\u0001\u001a\u00020\u001a2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020G0cH\u0002J\u000f\u0010\u008e\u0001\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010lJ(\u0010\u0090\u0001\u001a\u00020\u001a2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u0005042\u0007\u0010\u0092\u0001\u001a\u00020\u0018H\u0082@¢\u0006\u0003\u0010\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u001aH\u0002J\u0014\u0010\u0095\u0001\u001a\u00020\u001a2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0097\u0001\u001a\u00020\u001a2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010\u0098\u0001\u001a\u00020GH\u0086@¢\u0006\u0002\u0010lJ\u0017\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001H\u0086@¢\u0006\u0002\u0010lJ'\u0010\u009c\u0001\u001a\u00020\u001a2\u001c\u0010\u009d\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u0001H\u0002J\u0015\u0010\u009f\u0001\u001a\u00020\u001a2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002J'\u0010¢\u0001\u001a\u00020\u001a2\u001c\u0010\u009d\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u0001H\u0002J1\u0010£\u0001\u001a\u00020\u001a2\b\u0010 \u0001\u001a\u00030¡\u00012\u001c\u0010\u009d\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u0001H\u0002J9\u0010¤\u0001\u001a\u00020\u001a2\u0007\u0010¥\u0001\u001a\u00020f2\u0007\u0010¦\u0001\u001a\u00020f2\u001c\u0010\u009d\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u0001H\u0002J9\u0010§\u0001\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020f2\u0007\u0010©\u0001\u001a\u00020f2\u001c\u0010\u009d\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u0001H\u0002J\u001b\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u00012\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002Je\u0010«\u0001\u001a\u00020\u001a2\b\u0010¬\u0001\u001a\u00030\u00ad\u00012'\u0010®\u0001\u001a\"\u0012\u0017\u0012\u00150\u00ad\u0001¢\u0006\u000f\b¯\u0001\u0012\n\b°\u0001\u0012\u0005\b\b(±\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u00012'\u0010²\u0001\u001a\"\u0012\u0017\u0012\u00150³\u0001¢\u0006\u000f\b¯\u0001\u0012\n\b°\u0001\u0012\u0005\b\b(´\u0001\u0012\u0004\u0012\u00020\u001a0\u009e\u0001H\u0002J\u0016\u0010µ\u0001\u001a\u00030\u00ad\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000fR\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020$0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020$00¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R!\u00103\u001a\b\u0012\u0004\u0012\u00020$048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0016\u001a\u0004\b5\u00106R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020$098F¢\u0006\u0006\u001a\u0004\b:\u0010;R!\u0010<\u001a\b\u0012\u0004\u0012\u00020$0=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0016\u001a\u0004\b>\u0010?R!\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0016\u001a\u0004\bB\u00106R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d098F¢\u0006\u0006\u001a\u0004\bE\u0010;R\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bF\u0010HR\u0011\u0010I\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bJ\u0010HR\u0011\u0010K\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bK\u0010HR\u0011\u0010L\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bL\u0010HR\u0011\u0010M\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bM\u0010HR\u0011\u0010N\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bN\u0010HR\u0011\u0010O\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bO\u0010HR\u0011\u0010P\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bP\u0010HR\u001b\u0010Q\u001a\u00020R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0016\u001a\u0004\bS\u0010TR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010d\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010g\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010¶\u0001\u001a\u00030·\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b¸\u0001\u0010¹\u0001¨\u0006»\u0001"},
   d2 = {"Lcom/blueair/bluetooth/service/BleDeviceService;", "Lkotlinx/coroutines/CoroutineScope;", "currentDevice", "Landroid/bluetooth/BluetoothDevice;", "serviceUuid", "", "context", "Landroid/content/Context;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Landroid/content/Context;Lcom/blueair/core/service/AnalyticsService;)V", "getCurrentDevice", "()Landroid/bluetooth/BluetoothDevice;", "getServiceUuid", "()Ljava/lang/String;", "deviceEventSerializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/DeviceEvent;", "getDeviceEventSerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "deviceEventSerializer$delegate", "Lkotlin/Lazy;", "pollingDeviceBoundedDisposable", "Lio/reactivex/disposables/Disposable;", "sideLoadError", "", "message", "nuError", "Lcom/blueair/bluetooth/service/BleDeviceError;", "error", "getError", "()Lcom/blueair/bluetooth/service/BleDeviceError;", "setError", "(Lcom/blueair/bluetooth/service/BleDeviceError;)V", "nuState", "Lcom/blueair/bluetooth/service/BleDeviceState;", "state", "getState", "()Lcom/blueair/bluetooth/service/BleDeviceState;", "setState", "(Lcom/blueair/bluetooth/service/BleDeviceState;)V", "value", "detectedDeviceUuid", "getDetectedDeviceUuid", "_deviceEvents", "Lkotlinx/coroutines/flow/MutableStateFlow;", "deviceStateStream", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateStream", "()Lkotlinx/coroutines/flow/StateFlow;", "deviceStatePublisher", "Lio/reactivex/subjects/PublishSubject;", "getDeviceStatePublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceStatePublisher$delegate", "deviceStateObserver", "Lio/reactivex/Observable;", "getDeviceStateObserver", "()Lio/reactivex/Observable;", "liveDeviceStateObserver", "Landroidx/lifecycle/LiveData;", "getLiveDeviceStateObserver", "()Landroidx/lifecycle/LiveData;", "liveDeviceStateObserver$delegate", "deviceErrorPublisher", "getDeviceErrorPublisher", "deviceErrorPublisher$delegate", "deviceErrorObserver", "getDeviceErrorObserver", "isConnected", "", "()Z", "hasSession", "getHasSession", "isProvisioningStarted", "isProvisioningConfigured", "isWifiConfigured", "isWifiConfigApplied", "isWifiConnected", "isBounded", "transport", "Lcom/blueair/bluetooth/espressif/BLETransport;", "getTransport", "()Lcom/blueair/bluetooth/espressif/BLETransport;", "transport$delegate", "security", "Lcom/blueair/bluetooth/espressif/Security;", "getSecurity", "()Lcom/blueair/bluetooth/espressif/Security;", "setSecurity", "(Lcom/blueair/bluetooth/espressif/Security;)V", "session", "Lcom/blueair/bluetooth/espressif/Session;", "getSession", "()Lcom/blueair/bluetooth/espressif/Session;", "setSession", "(Lcom/blueair/bluetooth/espressif/Session;)V", "connectionContinuation", "Lkotlin/coroutines/Continuation;", "establishSessionContinuation", "readFilterContinuation", "", "resetFilterContinuation", "updateState", "updateError", "connect", "connectSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "establishSession", "proofOfPossesion", "onSessionEstablished", "Lkotlin/Function0;", "establishSessionSync", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectAndEstablishSessionSync", "readFilterSync", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "(Lcom/blueair/core/model/DeviceFilterType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetFilterSync", "cipherText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProvisioningSync", "connectAndEstablishSessionAndStartProvisioningSync", "nextConfigureProvisionStep", "configureProvisionSync", "config", "Lcom/blueair/bluetooth/service/ProvisionConfig;", "(Lcom/blueair/bluetooth/service/ProvisionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureProvisionStep", "step", "provConfCont", "configureWifiSync", "ssid", "passphrase", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureWifi", "provisionCont", "applyWifiConfigSync", "applyWifiConfig", "pollWifiConnectionStatus", "getDeviceEvents", "startPollDeviceBounded", "publisher", "pollingDisposable", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPollDeviceBounded", "pollDeviceBoundedSuccess", "deviceEvent", "pollDeviceBoundedFail", "pollDeviceBounded", "wifiScanSync", "", "Lcom/blueair/core/model/Ssid;", "startWifiScan", "onResponse", "Lkotlin/Function1;", "processStartScan", "responseData", "", "getWifiScanStatus", "processGetWifiStatus", "getFullWiFiList", "totalCount", "startIndex", "getWiFiScanList", "start", "count", "processGetSSIDs", "sendWrapper", "wrapper", "Lcustom/CustomCommands$CommandWrapper;", "onSuccess", "Lkotlin/ParameterName;", "name", "responseWrapper", "onFail", "", "t", "processCustomCommand", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BleDeviceService implements CoroutineScope {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String PROOF_OF_POSSESION_DEFAULT = "";
   private static final int SSID_FETCH_SIZE = 4;
   private final DefaultCoroutineScope $$delegate_0;
   private final MutableStateFlow _deviceEvents;
   private final AnalyticsService analyticsService;
   private Continuation connectionContinuation;
   private final BluetoothDevice currentDevice;
   private String detectedDeviceUuid;
   private final Lazy deviceErrorPublisher$delegate;
   private final Lazy deviceEventSerializer$delegate;
   private final Lazy deviceStatePublisher$delegate;
   private final StateFlow deviceStateStream;
   private BleDeviceError error;
   private Continuation establishSessionContinuation;
   private final Lazy liveDeviceStateObserver$delegate;
   private Disposable pollingDeviceBoundedDisposable;
   private Continuation readFilterContinuation;
   private Continuation resetFilterContinuation;
   private Security security;
   private final String serviceUuid;
   private Session session;
   private final Lazy transport$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$CWGD4YugLFS2dumLAiVXw8ZTN3E(BleDeviceService var0, Throwable var1) {
      return pollDeviceBounded$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$En_Lzs3jOAfUV7V1wOZhSrODnrY/* $FF was: $r8$lambda$En-Lzs3jOAfUV7V1wOZhSrODnrY*/(BleDeviceService var0, String var1) {
      return pollDeviceBounded$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$FxwANsZ09IgvdmDyc0pdIrarHHM(Function1 var0, List var1, List var2) {
      return getFullWiFiList$lambda$26$lambda$25(var0, var1, var2);
   }

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$IJTJc6XGCdstSaUxNl__XriHfRs() {
      return deviceStatePublisher_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static void $r8$lambda$JkDwsASaiJHe5Mp2oRNiB1Xudnc(Function1 var0, Object var1) {
      pollDeviceBounded$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MgVmjLJpyIlqwTGxZMnc18blr_U/* $FF was: $r8$lambda$MgVmjLJpyIlqwTGxZMnc18blr-U*/(Continuation var0, Throwable var1) {
      return configureProvisionStep$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$P0wnMTdFROqjiBI2pBFGgG3KQaA(Function1 var0, Object var1) {
      pollDeviceBounded$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$StAHR6lqRj9rkGxDKoJDA8x5Mig(Function1 var0, List var1) {
      return processGetWifiStatus$lambda$23(var0, var1);
   }

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$Wkq8dqUCyp4DGHSMvlrH_RDNi18/* $FF was: $r8$lambda$Wkq8dqUCyp4DGHSMvlrH-RDNi18*/() {
      return deviceErrorPublisher_delegate$lambda$3();
   }

   // $FF: synthetic method
   public static BLETransport $r8$lambda$XQrNHbGXAFufKzPO2ODAJhqtiMU(Context var0, BleDeviceService var1) {
      return transport_delegate$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static LiveData $r8$lambda$gUn1Oc4_3ZBBWoU3cRY0CcNcJmk(BleDeviceService var0) {
      return liveDeviceStateObserver_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mlqrPyy93IJc98lb7OUPZ4XYYf8(BleDeviceService var0, BleDeviceState var1, ProvisionConfig var2, Continuation var3, CustomCommands.CommandWrapper var4) {
      return configureProvisionStep$lambda$11(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$qxz0KdprR8YmGW5UC_60paoK7LM/* $FF was: $r8$lambda$qxz0KdprR8YmGW5UC-60paoK7LM*/(Function1 var0, List var1) {
      return getFullWiFiList$lambda$24(var0, var1);
   }

   // $FF: synthetic method
   public static MoshiSerializer $r8$lambda$uTWZQflE4Xu9KAklyWBHEvVP6mw() {
      return deviceEventSerializer_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wfgWVxTtLJvJHN8JnSMuSYHAYps(int var0, BleDeviceService var1, int var2, Function1 var3, List var4) {
      return getFullWiFiList$lambda$26(var0, var1, var2, var3, var4);
   }

   public BleDeviceService(BluetoothDevice var1, String var2, Context var3, AnalyticsService var4) {
      Intrinsics.checkNotNullParameter(var1, "currentDevice");
      Intrinsics.checkNotNullParameter(var2, "serviceUuid");
      Intrinsics.checkNotNullParameter(var3, "context");
      Intrinsics.checkNotNullParameter(var4, "analyticsService");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.currentDevice = var1;
      this.serviceUuid = var2;
      this.analyticsService = var4;
      this.deviceEventSerializer$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda1());
      MutableStateFlow var5 = StateFlowKt.MutableStateFlow(BleDeviceState.Disconnected.INSTANCE);
      this._deviceEvents = var5;
      this.deviceStateStream = (StateFlow)var5;
      this.deviceStatePublisher$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda2());
      this.liveDeviceStateObserver$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda3(this));
      this.deviceErrorPublisher$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda4());
      this.transport$delegate = LazyKt.lazy(new BleDeviceService$$ExternalSyntheticLambda5(var3, this));
   }

   // $FF: synthetic method
   public static final Object access$getDeviceEvents(BleDeviceService var0, Continuation var1) {
      return var0.getDeviceEvents(var1);
   }

   private final void applyWifiConfig(Continuation var1) {
      Timber.Forest.d("applyWifiConfig", new Object[0]);
      (new Provision(this.session)).applyConfigurations(new Provision.ProvisionActionListener(this, var1) {
         final Continuation $provisionCont;
         final BleDeviceService this$0;

         {
            this.this$0 = var1;
            this.$provisionCont = var2;
         }

         public void onComplete(Constants.Status var1, Exception var2) {
            Timber.Forest var4 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("applyWifiConfig: onComplete: status = ");
            var3.append(var1);
            var3.append(", e = ");
            var3.append(var2);
            var4.d(var3.toString(), new Object[0]);
            if (var1 == Status.Success) {
               this.this$0.updateState(BleDeviceState.WifiConfigApplied.INSTANCE);
               Continuation var8 = this.$provisionCont;
               Result.Companion var6 = Result.Companion;
               var8.resumeWith(Result.constructor-impl(true));
            } else {
               Continuation var5 = this.$provisionCont;
               Result.Companion var7 = Result.Companion;
               var5.resumeWith(Result.constructor-impl(false));
            }
         }
      });
   }

   private final void configureProvisionStep(BleDeviceState var1, ProvisionConfig var2, Continuation var3) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("configureProvisionStep: step = ");
      var5.append(var1);
      var5.append(", config = ");
      var5.append(var2);
      var4.d(var5.toString(), new Object[0]);
      CustomCommands.ConfigCmd.Builder var6 = ConfigCmd.newBuilder();
      if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured0.INSTANCE)) {
         var6.setApiUrl(var2.getApiUrl());
      } else if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured1.INSTANCE)) {
         var6.setAuthUrl(var2.getAuthUrl());
      } else if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured2.INSTANCE)) {
         var6.setBrokerUrl(var2.getBrokerUrl());
      } else if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured3.INSTANCE)) {
         var6.setRegion(var2.getRegion());
      } else if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured4.INSTANCE)) {
         var6.setRandomText(var2.getRandomText());
      } else if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured5.INSTANCE)) {
         var6.setSecureRandom(var2.getSecureRandom());
      }

      var4 = Timber.Forest;
      var5 = new StringBuilder("configureProvisionStep: configRequest = ");
      var5.append(var6);
      var4.d(var5.toString(), new Object[0]);
      CustomCommands.CommandWrapper var8 = (CustomCommands.CommandWrapper)CommandWrapper.newBuilder().setConfigCmd((CustomCommands.ConfigCmd)var6.build()).build();
      Intrinsics.checkNotNull(var8);
      this.sendWrapper(var8, new BleDeviceService$$ExternalSyntheticLambda13(this, var1, var2, var3), new BleDeviceService$$ExternalSyntheticLambda14(var3));
   }

   private static final Unit configureProvisionStep$lambda$11(BleDeviceService var0, BleDeviceState var1, ProvisionConfig var2, Continuation var3, CustomCommands.CommandWrapper var4) {
      Intrinsics.checkNotNullParameter(var4, "wrappedResponse");
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("configureProvisionStep:  onSuccess: response status: ");
      var5.append(var4.getConfigResp().getStatus());
      var6.d(var5.toString(), new Object[0]);
      var0.updateState(var1);
      var1 = var0.nextConfigureProvisionStep();
      if (var1 != null) {
         var0.configureProvisionStep(var1, var2, var3);
      } else {
         Result.Companion var7 = Result.Companion;
         var3.resumeWith(Result.constructor-impl(true));
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureProvisionStep$lambda$12(Continuation var0, Throwable var1) {
      Intrinsics.checkNotNullParameter(var1, "error");
      Timber.Forest.e(var1, "configureProvisionStep:  onFail", new Object[0]);
      Result.Companion var2 = Result.Companion;
      var0.resumeWith(Result.constructor-impl(false));
      return Unit.INSTANCE;
   }

   private final void configureWifi(String var1, String var2, Continuation var3) {
      (new Provision(this.session)).configureWifi(var1, var2, new Provision.ProvisionActionListener(this, var3) {
         final Continuation $provisionCont;
         final BleDeviceService this$0;

         {
            this.this$0 = var1;
            this.$provisionCont = var2;
         }

         public void onComplete(Constants.Status var1, Exception var2) {
            Timber.Forest var4 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("configureWifi: onComplete status = ");
            var3.append(var1);
            var4.d(var3.toString(), new Object[0]);
            if (var1 == Status.Success) {
               Timber.Forest.d("configureWifi: onComplete success", new Object[0]);
               this.this$0.updateState(BleDeviceState.WifiConfigured.INSTANCE);
               Continuation var6 = this.$provisionCont;
               Result.Companion var8 = Result.Companion;
               var6.resumeWith(Result.constructor-impl(true));
            } else {
               Timber.Forest.e((Throwable)var2, "configureWifi: onComplete failed", new Object[0]);
               Continuation var5 = this.$provisionCont;
               Result.Companion var7 = Result.Companion;
               var5.resumeWith(Result.constructor-impl(false));
            }
         }
      });
   }

   private static final PublishSubject deviceErrorPublisher_delegate$lambda$3() {
      return PublishSubject.create();
   }

   private static final MoshiSerializer deviceEventSerializer_delegate$lambda$0() {
      return new MoshiSerializer((Type)DeviceEvent.class, new Object[0]);
   }

   private static final PublishSubject deviceStatePublisher_delegate$lambda$1() {
      return PublishSubject.create();
   }

   // $FF: synthetic method
   public static void establishSession$default(BleDeviceService var0, String var1, Function0 var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = "";
      }

      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.establishSession(var1, var2);
   }

   // $FF: synthetic method
   public static Object establishSessionSync$default(BleDeviceService var0, String var1, Function0 var2, Continuation var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = "";
      }

      if ((var4 & 2) != 0) {
         var2 = null;
      }

      return var0.establishSessionSync(var1, var2, var3);
   }

   private final PublishSubject getDeviceErrorPublisher() {
      Object var1 = this.deviceErrorPublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private final MoshiSerializer getDeviceEventSerializer() {
      return (MoshiSerializer)this.deviceEventSerializer$delegate.getValue();
   }

   private final Object getDeviceEvents(Continuation var1) {
      Timber.Forest.d("getDeviceEvents", new Object[0]);
      SafeContinuation var3 = new SafeContinuation(IntrinsicsKt.intercepted(var1));
      Continuation var2 = (Continuation)var3;
      CustomCommands.EventCmd.Builder var4 = EventCmd.newBuilder();
      CustomCommands.CommandWrapper var6 = (CustomCommands.CommandWrapper)CommandWrapper.newBuilder().setEventCmd((CustomCommands.EventCmd)var4.build()).build();
      Intrinsics.checkNotNull(var6);
      this.sendWrapper(var6, new Function1(var2) {
         final Continuation $cont;

         {
            this.$cont = var1;
         }

         public final void invoke(CustomCommands.CommandWrapper var1) {
            Intrinsics.checkNotNullParameter(var1, "wrappedResponse");
            Timber.Forest var2 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("getDeviceEvents:  onSuccess: response numberOfEvents: ");
            var3.append(var1.getEventResp().getNumberOfEvents());
            var3.append(", json = ");
            var3.append(var1.getEventResp().getJson());
            var2.d(var3.toString(), new Object[0]);
            Continuation var4 = this.$cont;
            Result.Companion var5 = Result.Companion;
            var4.resumeWith(Result.constructor-impl(var1.getEventResp().getJson()));
         }
      }, new Function1(var2) {
         final Continuation $cont;

         {
            this.$cont = var1;
         }

         public final void invoke(Throwable var1) {
            Intrinsics.checkNotNullParameter(var1, "error");
            Timber.Forest.e(var1, "getDeviceEvents:  onFail", new Object[0]);
            Continuation var2 = this.$cont;
            Result.Companion var3 = Result.Companion;
            var2.resumeWith(Result.constructor-impl(ResultKt.createFailure(var1)));
         }
      });
      Object var5 = var3.getOrThrow();
      if (var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var1);
      }

      return var5;
   }

   private final PublishSubject getDeviceStatePublisher() {
      Object var1 = this.deviceStatePublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private final void getFullWiFiList(int var1, int var2, Function1 var3) {
      int var4 = var1 - var2;
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("getFullWiFiList: Total totalCount : ");
      var6.append(var1);
      var6.append(", startIndex = ");
      var6.append(var2);
      var6.append(", currentCount = ");
      var6.append(var4);
      var5.d(var6.toString(), new Object[0]);
      if (var4 == 0) {
         var3.invoke(CollectionsKt.emptyList());
      } else if (var4 < 4) {
         this.getWiFiScanList(var2, var4, new BleDeviceService$$ExternalSyntheticLambda9(var3));
      } else {
         this.getWiFiScanList(var2, 4, new BleDeviceService$$ExternalSyntheticLambda10(var2, this, var1, var3));
      }
   }

   private static final Unit getFullWiFiList$lambda$24(Function1 var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.invoke(var1);
      return Unit.INSTANCE;
   }

   private static final Unit getFullWiFiList$lambda$26(int var0, BleDeviceService var1, int var2, Function1 var3, List var4) {
      Intrinsics.checkNotNullParameter(var4, "oldList");
      var1.getFullWiFiList(var2, var0 + 4, new BleDeviceService$$ExternalSyntheticLambda12(var3, var4));
      return Unit.INSTANCE;
   }

   private static final Unit getFullWiFiList$lambda$26$lambda$25(Function1 var0, List var1, List var2) {
      Intrinsics.checkNotNullParameter(var2, "nuList");
      var0.invoke(CollectionsKt.plus((Collection)var1, (Iterable)var2));
      return Unit.INSTANCE;
   }

   private final void getWiFiScanList(int var1, int var2, Function1 var3) {
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("getWiFiScanList: start = ");
      var4.append(var1);
      var4.append(", count ");
      var4.append(var2);
      var5.d(var4.toString(), new Object[0]);
      WifiScan.CmdScanResult var6 = (WifiScan.CmdScanResult)CmdScanResult.newBuilder().setStartIndex(var1).setCount(var2).build();
      WifiScan.WiFiScanMsgType var9 = WiFiScanMsgType.TypeCmdScanResult;
      WifiScan.WiFiScanPayload var7 = (WifiScan.WiFiScanPayload)WiFiScanPayload.newBuilder().setMsg(var9).setCmdScanResult(var6).build();
      Security var10 = this.security;
      byte[] var8;
      if (var10 != null) {
         var8 = var10.encrypt(var7.toByteArray());
      } else {
         var8 = null;
      }

      this.getTransport().sendConfigData("prov-scan", var8, new ResponseListener(this, var3) {
         final Function1 $onResponse;
         final BleDeviceService this$0;

         {
            this.this$0 = var1;
            this.$onResponse = var2;
         }

         public void onFailure(Exception var1) {
            Timber.Forest.e((Throwable)var1, "getWiFiScanList: onFailure", new Object[0]);
            this.$onResponse.invoke(CollectionsKt.emptyList());
         }

         public void onSuccess(byte[] var1) {
            Intrinsics.checkNotNullParameter(var1, "returnData");
            Timber.Forest var2 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("getWiFiScanList: onSuccess returnData = ");
            var3.append(var1);
            var2.d(var3.toString(), new Object[0]);
            List var6 = this.this$0.processGetSSIDs(var1);
            Timber.Forest var4 = Timber.Forest;
            StringBuilder var5 = new StringBuilder("getWiFiScanList: onSuccess ssidList = ");
            var5.append(var6);
            var4.d(var5.toString(), new Object[0]);
            this.$onResponse.invoke(var6);
         }
      });
   }

   private final void getWifiScanStatus(Function1 var1) {
      Timber.Forest.d("getWifiScanStatus", new Object[0]);
      WifiScan.CmdScanStatus var3 = (WifiScan.CmdScanStatus)CmdScanStatus.newBuilder().build();
      WifiScan.WiFiScanMsgType var2 = WiFiScanMsgType.TypeCmdScanStatus;
      WifiScan.WiFiScanPayload var5 = (WifiScan.WiFiScanPayload)WiFiScanPayload.newBuilder().setMsg(var2).setCmdScanStatus(var3).build();
      Security var7 = this.security;
      byte[] var6;
      if (var7 != null) {
         var6 = var7.encrypt(var5.toByteArray());
      } else {
         var6 = null;
      }

      Timber.Forest var8 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("getWifiScanStatus: data = ");
      var4.append(var6);
      var8.d(var4.toString(), new Object[0]);
      this.getTransport().sendConfigData("prov-scan", var6, new ResponseListener(this, var1) {
         final Function1 $onResponse;
         final BleDeviceService this$0;

         // $FF: synthetic method
         public static Unit $r8$lambda$oIxkHWqlRiaK6Oly7ye1PBD3tf8(Function1 var0, List var1) {
            return onSuccess$lambda$0(var0, var1);
         }

         {
            this.this$0 = var1;
            this.$onResponse = var2;
         }

         private static final Unit onSuccess$lambda$0(Function1 var0, List var1) {
            Intrinsics.checkNotNullParameter(var1, "it");
            var0.invoke(var1);
            return Unit.INSTANCE;
         }

         public void onFailure(Exception var1) {
            Timber.Forest.e((Throwable)var1, "getWifiScanStatus: onFailure", new Object[0]);
            this.$onResponse.invoke(CollectionsKt.emptyList());
            BleDeviceService var3 = this.this$0;
            BleDeviceState var2 = this.this$0.getState();
            String var4;
            if (var1 != null) {
               var4 = var1.getMessage();
            } else {
               var4 = null;
            }

            var3.updateError(new BleDeviceError(var2, var4));
         }

         public void onSuccess(byte[] var1) {
            Intrinsics.checkNotNullParameter(var1, "returnData");
            Timber.Forest.d("getWifiScanStatus: Successfully got scan result", new Object[0]);
            this.this$0.processGetWifiStatus(var1, new BleDeviceService$getWifiScanStatus$1$$ExternalSyntheticLambda0(this.$onResponse));
         }
      });
   }

   private static final LiveData liveDeviceStateObserver_delegate$lambda$2(BleDeviceService var0) {
      Flowable var1 = var0.getDeviceStatePublisher().toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var1, "toFlowable(...)");
      return LiveDataReactiveStreams.fromPublisher((Publisher)var1);
   }

   private final BleDeviceState nextConfigureProvisionStep() {
      if (this.isProvisioningStarted() && !this.isProvisioningConfigured()) {
         BleDeviceState var1 = this.getState();
         if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningStarted.INSTANCE)) {
            return BleDeviceState.ProvisioningConfigured0.INSTANCE;
         }

         if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured0.INSTANCE)) {
            return BleDeviceState.ProvisioningConfigured1.INSTANCE;
         }

         if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured1.INSTANCE)) {
            return BleDeviceState.ProvisioningConfigured2.INSTANCE;
         }

         if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured2.INSTANCE)) {
            return BleDeviceState.ProvisioningConfigured3.INSTANCE;
         }

         if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured3.INSTANCE)) {
            return BleDeviceState.ProvisioningConfigured4.INSTANCE;
         }

         if (Intrinsics.areEqual(var1, BleDeviceState.ProvisioningConfigured4.INSTANCE)) {
            return BleDeviceState.ProvisioningConfigured5.INSTANCE;
         }
      }

      return null;
   }

   private static final Unit pollDeviceBounded$lambda$18(BleDeviceService var0, String var1) {
      Object var7 = null;
      boolean var5 = true;

      boolean var2;
      label124: {
         try {
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var6 = new StringBuilder("pollDeviceBounded: pollDeviceBounded: json = ");
            var6.append(var1);
            var8.v(var6.toString(), new Object[0]);
            MoshiSerializer var13 = var0.getDeviceEventSerializer();
            Intrinsics.checkNotNull(var1);
            var12 = (DeviceEvent)var13.fromJson(var1);
         } catch (Throwable var11) {
            Timber.Forest.e(var11, "pollDeviceBounded: deviceEventSerializer.fromJson failed", new Object[0]);
            var12 = null;
            var2 = true;
            break label124;
         }

         var2 = false;
      }

      Timber.Forest var9 = Timber.Forest;
      StringBuilder var17 = new StringBuilder("pollDeviceBounded: onboardingState = ");
      OnboardingState var14;
      if (var12 != null) {
         var14 = var12.getOnboardingState();
      } else {
         var14 = null;
      }

      var17.append(var14);
      var17.append(", hasError = ");
      Boolean var15 = (Boolean)var7;
      if (var12 != null) {
         var15 = var12.getHasError();
      }

      var17.append(var15);
      var17.append(", event = ");
      var17.append(var12);
      var9.v(var17.toString(), new Object[0]);
      if (var12 != null) {
         String var16 = var12.getOrigin();
         if (var16 != null && ((CharSequence)var16).length() != 0) {
            var0.detectedDeviceUuid = var16;
         }
      }

      boolean var3;
      if (var12 != null && Intrinsics.areEqual(var12.getOnboardingState(), OnboardingState.DeviceBound.INSTANCE) && !var12.getHasError()) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4 = var5;
      if (!var2) {
         if (var12 != null && var12.getHasError() && !Intrinsics.areEqual(OnboardingError.Companion.getOnboardingError(var12), OnboardingError.HoldingError.INSTANCE)) {
            var4 = var5;
         } else {
            var4 = false;
         }
      }

      if (var3) {
         Timber.Forest.v("pollDeviceBounded: SUCCESS", new Object[0]);
         var0.pollDeviceBoundedSuccess(var12);
      } else if (var4) {
         Timber.Forest.v("pollDeviceBounded: FAIL", new Object[0]);
         var0.pollDeviceBoundedFail(var12);
      }

      return Unit.INSTANCE;
   }

   private static final void pollDeviceBounded$lambda$19(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit pollDeviceBounded$lambda$20(BleDeviceService var0, Throwable var1) {
      Intrinsics.checkNotNullParameter(var1, "t");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("pollDeviceBounded: eventPublisher FAIL, isBounded = ");
      var3.append(var0.isBounded());
      var2.e(var1, var3.toString(), new Object[0]);
      if (var0.isBounded()) {
         var0.stopPollDeviceBounded();
      } else {
         var0.pollDeviceBoundedFail((DeviceEvent)null);
      }

      return Unit.INSTANCE;
   }

   private static final void pollDeviceBounded$lambda$21(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final void pollDeviceBoundedFail(DeviceEvent var1) {
      int var2;
      String var5;
      AnalyticsService var6;
      String var8;
      label26: {
         Timber.Forest var3 = Timber.Forest;
         var2 = 0;
         var3.v("pollDeviceBoundedFail", new Object[0]);
         var6 = this.analyticsService;
         var5 = "";
         if (var1 != null) {
            String var4 = var1.getOrigin();
            var8 = var4;
            if (var4 != null) {
               break label26;
            }
         }

         var8 = "";
      }

      String var10 = var5;
      if (var1 != null) {
         var10 = var1.getConnectionEvent();
         if (var10 == null) {
            var10 = var5;
         }
      }

      if (var1 != null) {
         var2 = var1.getErrorCode();
      }

      var6.event(new AnalyticEvent.BT_EVENT_FAILURE(var8, var10, var2));
      BleDeviceState var9 = BleDeviceState.WifiConnected.INSTANCE;
      String var7;
      if (var1 != null) {
         var7 = var1.getErrorMessage();
      } else {
         var7 = null;
      }

      this.updateError(new BleDeviceError(var9, var7));
      this.stopPollDeviceBounded();
   }

   private final void pollDeviceBoundedSuccess(DeviceEvent var1) {
      AnalyticsService var3;
      label11: {
         Timber.Forest.v("pollDeviceBoundedSuccess", new Object[0]);
         var3 = this.analyticsService;
         if (var1 != null) {
            String var2 = var1.getOrigin();
            var4 = var2;
            if (var2 != null) {
               break label11;
            }
         }

         var4 = "";
      }

      var3.event(new AnalyticEvent.BT_SUCCESS(var4));
      this.updateState(BleDeviceState.Bounded.INSTANCE);
      this.stopPollDeviceBounded();
   }

   private final CustomCommands.CommandWrapper processCustomCommand(byte[] var1) {
      Security var2 = this.security;
      if (var2 != null) {
         var1 = var2.decrypt(var1);
      } else {
         var1 = null;
      }

      CustomCommands.CommandWrapper var4 = CommandWrapper.parseFrom(var1);
      Intrinsics.checkNotNullExpressionValue(var4, "parseFrom(...)");
      return var4;
   }

   private final List processGetSSIDs(byte[] var1) {
      Security var3 = this.security;
      if (var3 != null) {
         var1 = var3.decrypt(var1);
      } else {
         var1 = null;
      }

      Timber.Forest var20 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("processGetSSIDs: decryptedData = ");
      var4.append(var1);
      var20.d(var4.toString(), new Object[0]);

      InvalidProtocolBufferException var10000;
      label49: {
         try {
            WifiScan.RespScanResult var14 = WiFiScanPayload.parseFrom(var1).getRespScanResult();
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("processGetSSIDs: Response count = ");
            var21.append(var14.getEntriesCount());
            var21.append(", response = ");
            var21.append(var14);
            var24.d(var21.toString(), new Object[0]);
            var15 = var14.getEntriesList();
         } catch (InvalidProtocolBufferException var12) {
            var10000 = var12;
            boolean var10001 = false;
            break label49;
         }

         if (var15 != null) {
            label53: {
               try {
                  Iterable var22 = (Iterable)var15;
                  ArrayList var16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(var22, 10));
                  var17 = (Collection)var16;
                  var23 = var22.iterator();
               } catch (InvalidProtocolBufferException var9) {
                  var10000 = var9;
                  boolean var27 = false;
                  break label53;
               }

               while(true) {
                  try {
                     if (!var23.hasNext()) {
                        break;
                     }

                     WifiScan.WiFiScanResult var6 = (WifiScan.WiFiScanResult)var23.next();
                     String var5 = var6.getSsid().toStringUtf8();
                     int var2 = var6.getRssi();
                     String var25 = var6.getBssid().toStringUtf8();
                     String var7 = var6.getAuth().name();
                     Ssid var26 = new Ssid(var5, var25, var2, var7);
                     var17.add(var26);
                  } catch (InvalidProtocolBufferException var10) {
                     var10000 = var10;
                     boolean var28 = false;
                     break label53;
                  }
               }

               try {
                  return (List)var17;
               } catch (InvalidProtocolBufferException var8) {
                  var10000 = var8;
                  boolean var29 = false;
               }
            }
         } else {
            try {
               List var19 = CollectionsKt.emptyList();
               return var19;
            } catch (InvalidProtocolBufferException var11) {
               var10000 = var11;
               boolean var30 = false;
            }
         }
      }

      InvalidProtocolBufferException var18 = var10000;
      Timber.Forest.e((Throwable)var18, "processGetSSIDs failed", new Object[0]);
      return CollectionsKt.emptyList();
   }

   private final void processGetWifiStatus(byte[] var1, Function1 var2) {
      Timber.Forest.d("processGetWifiStatus", new Object[0]);
      Security var4 = this.security;
      if (var4 != null) {
         var1 = var4.decrypt(var1);
      } else {
         var1 = null;
      }

      Timber.Forest var5 = Timber.Forest;
      StringBuilder var10 = new StringBuilder("processGetWifiStatus: decryptedData = ");
      var10.append(var1);
      var5.d(var10.toString(), new Object[0]);

      try {
         WifiScan.RespScanStatus var8 = WiFiScanPayload.parseFrom(var1).getRespScanStatus();
         if (var8.getScanFinished()) {
            int var3 = var8.getResultCount();
            BleDeviceService$$ExternalSyntheticLambda11 var9 = new BleDeviceService$$ExternalSyntheticLambda11(var2);
            this.getFullWiFiList(var3, 0, var9);
         } else {
            Timber.Forest.e("processGetWifiStatus: scan not finished", new Object[0]);
            var2.invoke(CollectionsKt.emptyList());
         }
      } catch (InvalidProtocolBufferException var6) {
         Timber.Forest.e((Throwable)var6, "processGetWifiStatus error", new Object[0]);
         var2.invoke(CollectionsKt.emptyList());
      }
   }

   private static final Unit processGetWifiStatus$lambda$23(Function1 var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.invoke(var1);
      return Unit.INSTANCE;
   }

   private final void processStartScan(byte[] var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("processStartScan: responseData = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      Security var7 = this.security;
      if (var7 != null) {
         var1 = var7.decrypt(var1);
      } else {
         var1 = null;
      }

      var3 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("processStartScan: decryptedData = ");
      var8.append(var1);
      var3.d(var8.toString(), new Object[0]);

      try {
         WifiScan.RespScanStart var11 = RespScanStart.parseFrom(WiFiScanPayload.parseFrom(var1).toByteArray());
         Timber.Forest var6 = Timber.Forest;
         var8 = new StringBuilder("processStartScan: response ");
         var8.append(var11);
         var6.d(var8.toString(), new Object[0]);
      } catch (InvalidProtocolBufferException var4) {
         Timber.Forest.e((Throwable)var4, "processStartScan: parse fail", new Object[0]);
      }
   }

   private final void sendWrapper(CustomCommands.CommandWrapper var1, Function1 var2, Function1 var3) {
      Exception var10000;
      label30: {
         Security var4;
         try {
            var4 = this.security;
         } catch (Exception var8) {
            var10000 = var8;
            boolean var10001 = false;
            break label30;
         }

         byte[] var9;
         if (var4 != null) {
            try {
               var9 = var4.encrypt(var1.toByteArray());
            } catch (Exception var7) {
               var10000 = var7;
               boolean var14 = false;
               break label30;
            }
         } else {
            var9 = null;
         }

         try {
            Timber.Forest var5 = Timber.Forest;
            StringBuilder var11 = new StringBuilder("sendWrapper: data = ");
            var11.append(var9);
            var5.d(var11.toString(), new Object[0]);
            BLETransport var12 = this.getTransport();
            ResponseListener var13 = new ResponseListener(var2, this, var3) {
               final Function1 $onFail;
               final Function1 $onSuccess;
               final BleDeviceService this$0;

               {
                  this.$onSuccess = var1;
                  this.this$0 = var2;
                  this.$onFail = var3;
               }

               public void onFailure(Exception var1) {
                  Intrinsics.checkNotNullParameter(var1, "e");
                  Timber.Forest.e((Throwable)var1, "sendWrapper: sendConfigData failed", new Object[0]);
                  this.$onFail.invoke(var1);
               }

               public void onSuccess(byte[] var1) {
                  Timber.Forest.d("sendWrapper: sendConfigData: Successfully sent custom command", new Object[0]);

                  try {
                     this.$onSuccess.invoke(this.this$0.processCustomCommand(var1));
                  } catch (Throwable var3) {
                     this.$onFail.invoke(var3);
                     return;
                  }
               }
            };
            var12.sendConfigData("custom-endpoint", var9, var13);
            return;
         } catch (Exception var6) {
            var10000 = var6;
            boolean var15 = false;
         }
      }

      Exception var10 = var10000;
      Timber.Forest.e((Throwable)var10, "sendWrapper: failed", new Object[0]);
   }

   private final void setError(BleDeviceError var1) {
      this.error = var1;
      if (var1 != null) {
         this.getDeviceErrorPublisher().onNext(var1);
      }

   }

   private final void setState(BleDeviceState var1) {
      this._deviceEvents.tryEmit(var1);
      this.getDeviceStatePublisher().onNext(var1);
   }

   private final Object startPollDeviceBounded(PublishSubject param1, Disposable param2, Continuation param3) {
      // $FF: Couldn't be decompiled
   }

   private final void startWifiScan(Function1 var1) {
      Timber.Forest.d("startWifiScan", new Object[0]);
      WifiScan.CmdScanStart var2 = (WifiScan.CmdScanStart)CmdScanStart.newBuilder().setBlocking(true).setPassive(false).setGroupChannels(0).setPeriodMs(120).build();
      WifiScan.WiFiScanMsgType var3 = WiFiScanMsgType.TypeCmdScanStart;
      WifiScan.WiFiScanPayload var9 = (WifiScan.WiFiScanPayload)WiFiScanPayload.newBuilder().setMsg(var3).setCmdScanStart(var2).build();

      Exception var10000;
      label34: {
         try {
            var11 = this.security;
         } catch (Exception var7) {
            var10000 = var7;
            boolean var10001 = false;
            break label34;
         }

         byte[] var10;
         if (var11 != null) {
            try {
               var10 = var11.encrypt(var9.toByteArray());
            } catch (Exception var6) {
               var10000 = var6;
               boolean var15 = false;
               break label34;
            }
         } else {
            var10 = null;
         }

         try {
            Timber.Forest var12 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("startWifiScan: data = ");
            var4.append(var10);
            var12.d(var4.toString(), new Object[0]);
            BLETransport var14 = this.getTransport();
            ResponseListener var13 = new ResponseListener(this, var1) {
               final Function1 $onResponse;
               final BleDeviceService this$0;

               // $FF: synthetic method
               public static Unit $r8$lambda$5ypp8n_kc2Z5g6wxgmgGjpB5MrU(Function1 var0, List var1) {
                  return onSuccess$lambda$0(var0, var1);
               }

               {
                  this.this$0 = var1;
                  this.$onResponse = var2;
               }

               private static final Unit onSuccess$lambda$0(Function1 var0, List var1) {
                  Intrinsics.checkNotNullParameter(var1, "it");
                  var0.invoke(var1);
                  return Unit.INSTANCE;
               }

               public void onFailure(Exception var1) {
                  Intrinsics.checkNotNullParameter(var1, "e");
                  Timber.Forest.e((Throwable)var1, "startWifiScan: onFailure", new Object[0]);
                  this.$onResponse.invoke(CollectionsKt.emptyList());
               }

               public void onSuccess(byte[] var1) {
                  Timber.Forest.d("Successfully sent start scan", new Object[0]);
                  this.this$0.processStartScan(var1);
                  this.this$0.getWifiScanStatus(new BleDeviceService$startWifiScan$1$$ExternalSyntheticLambda0(this.$onResponse));
               }
            };
            var14.sendConfigData("prov-scan", var10, var13);
            return;
         } catch (Exception var5) {
            var10000 = var5;
            boolean var16 = false;
         }
      }

      Exception var8 = var10000;
      Timber.Forest.e((Throwable)var8, "startWifiScan: fail", new Object[0]);
   }

   private final void stopPollDeviceBounded() {
      Timber.Forest.v("stopPollDeviceBounded", new Object[0]);
      Disposable var1 = this.pollingDeviceBoundedDisposable;
      if (var1 != null) {
         var1.dispose();
      }

      this.pollingDeviceBoundedDisposable = null;
   }

   private static final BLETransport transport_delegate$lambda$4(Context var0, BleDeviceService var1) {
      return new BLETransport(var0, new BLETransport.BLETransportListener(var1) {
         final BleDeviceService this$0;

         {
            this.this$0 = var1;
         }

         public void onFailure(Exception var1) {
            Timber.Forest.e((Throwable)var1, "onFailure", new Object[0]);
            BleDeviceService var2 = this.this$0;
            BleDeviceState var3 = this.this$0.getState();
            String var4;
            if (var1 != null) {
               var4 = var1.getMessage();
            } else {
               var4 = null;
            }

            var2.updateError(new BleDeviceError(var3, var4));
            this.this$0.disconnect();
         }

         public void onPeripheralConfigured(BluetoothDevice var1) {
            Timber.Forest var3 = Timber.Forest;
            StringBuilder var2 = new StringBuilder("onPeripheralConfigured: deviceCapabilities = ");
            BLETransport var4 = this.this$0.getTransport();
            ArrayList var5;
            if (var4 != null) {
               var5 = var4.deviceCapabilities;
            } else {
               var5 = null;
            }

            var2.append(var5);
            var3.d(var2.toString(), new Object[0]);
            this.this$0.updateState(BleDeviceState.Connected.INSTANCE);
         }

         public void onPeripheralDisconnected(Exception var1) {
            Timber.Forest.d("BLETransport.BLETransportListener.onPeripheralDisconnected", new Object[0]);
            this.this$0.updateState(BleDeviceState.Disconnected.INSTANCE);
         }

         public void onPeripheralNotConfigured(BluetoothDevice var1) {
            Timber.Forest.e("onPeripheralNotConfigured", new Object[0]);
            this.this$0.updateError(new BleDeviceError(BleDeviceState.Connecting.INSTANCE, "onPeripheralNotConfigured"));
            this.this$0.disconnect();
         }
      });
   }

   private final void updateError(BleDeviceError var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("updateError to ");
      var2.append(var1);
      String var4 = var2.toString();
      Boolean var9 = false;
      var3.d(var4, new Object[0]);
      this.setError(var1);
      BleDeviceState var5 = var1.getStateOccurred();
      if (Intrinsics.areEqual(var5, BleDeviceState.Connecting.INSTANCE)) {
         Continuation var7 = this.connectionContinuation;
         if (var7 != null) {
            Result.Companion var11 = Result.Companion;
            var7.resumeWith(Result.constructor-impl(var9));
         }

         this.connectionContinuation = null;
         Continuation var12 = this.establishSessionContinuation;
         if (var12 != null) {
            Result.Companion var8 = Result.Companion;
            var12.resumeWith(Result.constructor-impl(var9));
         }

         this.establishSessionContinuation = null;
         this.updateState(BleDeviceState.Disconnected.INSTANCE);
      } else if (Intrinsics.areEqual(var5, BleDeviceState.SessionEstablishing.INSTANCE)) {
         Continuation var6 = this.establishSessionContinuation;
         if (var6 != null) {
            Result.Companion var10 = Result.Companion;
            var6.resumeWith(Result.constructor-impl(var9));
         }

         this.establishSessionContinuation = null;
         this.updateState(BleDeviceState.Connected.INSTANCE);
      } else if (Intrinsics.areEqual(var5, BleDeviceState.WifiConfigApplied.INSTANCE) || Intrinsics.areEqual(var5, BleDeviceState.PollingWifiConfigStatus.INSTANCE)) {
         this.updateState(BleDeviceState.ProvisioningStarted.INSTANCE);
      }
   }

   private final void updateState(BleDeviceState var1) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("updateState to ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      this.setState(var1);
      boolean var2 = Intrinsics.areEqual(var1, BleDeviceState.Connected.INSTANCE);
      Boolean var7 = true;
      if (var2) {
         Continuation var6 = this.connectionContinuation;
         if (var6 != null) {
            Result.Companion var9 = Result.Companion;
            var6.resumeWith(Result.constructor-impl(var7));
         }

         this.connectionContinuation = null;
      } else {
         if (Intrinsics.areEqual(var1, BleDeviceState.SessionEstablished.INSTANCE)) {
            Continuation var5 = this.establishSessionContinuation;
            if (var5 != null) {
               Result.Companion var8 = Result.Companion;
               var5.resumeWith(Result.constructor-impl(var7));
            }

            this.establishSessionContinuation = null;
         }

      }
   }

   public final Object applyWifiConfigSync(Continuation var1) {
      Timber.Forest var3 = Timber.Forest;
      boolean var2 = false;
      var3.d("applyWifiConfigSync", new Object[0]);
      if (this.isWifiConfigApplied()) {
         var2 = true;
      } else if (this.isWifiConfigured()) {
         SafeContinuation var4 = new SafeContinuation(IntrinsicsKt.intercepted(var1));
         this.applyWifiConfig((Continuation)var4);
         Object var5 = var4.getOrThrow();
         if (var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(var1);
         }

         return var5;
      }

      return Boxing.boxBoolean(var2);
   }

   public final Object configureProvisionSync(ProvisionConfig var1, Continuation var2) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("configureProvisionSync: config = ");
      var5.append(var1);
      String var10 = var5.toString();
      boolean var3 = false;
      var4.d(var10, new Object[0]);
      if (this.isProvisioningConfigured()) {
         var3 = true;
      } else {
         if (this.isProvisioningStarted()) {
            SafeContinuation var11 = new SafeContinuation(IntrinsicsKt.intercepted(var2));
            Continuation var9 = (Continuation)var11;
            BleDeviceState var6 = this.nextConfigureProvisionStep();
            if (var6 != null) {
               this.configureProvisionStep(var6, var1, var9);
            } else {
               Timber.Forest.e("configureProvisionSync: step should not be null", new Object[0]);
               Result.Companion var7 = Result.Companion;
               var9.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
            }

            Object var8 = var11.getOrThrow();
            if (var8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
               DebugProbesKt.probeCoroutineSuspended(var2);
            }

            return var8;
         }

         this.updateError(new BleDeviceError(this.getState(), "Not in required state of ProvisioningStarted"));
      }

      return Boxing.boxBoolean(var3);
   }

   public final Object configureWifiSync(String var1, String var2, Continuation var3) {
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("configureWifiSync: ssid = ");
      var6.append(var1);
      var6.append(", passphrase = ");
      var6.append(var2);
      String var9 = var6.toString();
      boolean var4 = false;
      var5.d(var9, new Object[0]);
      if (this.isWifiConfigured()) {
         var4 = true;
      } else if (this.isProvisioningConfigured()) {
         SafeContinuation var8 = new SafeContinuation(IntrinsicsKt.intercepted(var3));
         this.configureWifi(var1, var2, (Continuation)var8);
         Object var7 = var8.getOrThrow();
         if (var7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(var3);
         }

         return var7;
      }

      return Boxing.boxBoolean(var4);
   }

   public final void connect() {
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("connect: isConnected = ");
      var2.append(this.isConnected());
      var1.d(var2.toString(), new Object[0]);
      if (!this.isConnected()) {
         this.updateState(BleDeviceState.Connecting.INSTANCE);
         this.getTransport().connect(this.currentDevice, UUID.fromString(this.serviceUuid));
      } else {
         Continuation var3 = this.connectionContinuation;
         if (var3 != null) {
            Result.Companion var4 = Result.Companion;
            var3.resumeWith(Result.constructor-impl(true));
         }

      }
   }

   public final Object connectAndEstablishSessionAndStartProvisioningSync(Continuation var1) {
      label47: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label47;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final BleDeviceService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.connectAndEstablishSessionAndStartProvisioningSync((Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var6).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var6).label;
      if (var2 != 0) {
         if (var2 == 1) {
            ResultKt.throwOnFailure(var9);
            return var9;
         }

         if (var2 != 2) {
            if (var2 == 3) {
               ResultKt.throwOnFailure(var9);
               return var9;
            }

            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var9);
      } else {
         ResultKt.throwOnFailure(var9);
         Timber.Forest.d("connectEstablishSessionAndStartProvisioningSync", new Object[0]);
         if (this.getHasSession()) {
            ((<undefinedtype>)var6).label = 1;
            Object var8 = this.startProvisioningSync((Continuation)var6);
            if (var8 != var5) {
               return var8;
            }

            return var5;
         }

         ((<undefinedtype>)var6).label = 2;
         Object var4 = this.connectAndEstablishSessionSync((Continuation)var6);
         var9 = var4;
         if (var4 == var5) {
            return var5;
         }
      }

      if (!(Boolean)var9) {
         return Boxing.boxBoolean(false);
      } else {
         ((<undefinedtype>)var6).label = 3;
         Object var7 = this.startProvisioningSync((Continuation)var6);
         if (var7 != var5) {
            return var7;
         } else {
            return var5;
         }
      }
   }

   public final Object connectAndEstablishSessionSync(Continuation var1) {
      label36: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label36;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final BleDeviceService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.connectAndEstablishSessionSync((Continuation)this);
            }
         };
      }

      Object var8 = ((<undefinedtype>)var6).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var6).label;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 == 2) {
               ResultKt.throwOnFailure(var8);
               return var8;
            }

            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var8);
      } else {
         ResultKt.throwOnFailure(var8);
         Timber.Forest.d("connectAndEstablishSessionSync", new Object[0]);
         ((<undefinedtype>)var6).label = 1;
         Object var4 = this.connectSync((Continuation)var6);
         var8 = var4;
         if (var4 == var5) {
            return var5;
         }
      }

      if (!(Boolean)var8) {
         return Boxing.boxBoolean(false);
      } else {
         ((<undefinedtype>)var6).label = 2;
         Object var7 = establishSessionSync$default(this, (String)null, (Function0)null, (Continuation)var6, 3, (Object)null);
         if (var7 != var5) {
            return var7;
         } else {
            return var5;
         }
      }
   }

   public final Object connectSync(Continuation var1) {
      Timber.Forest.d("connectSync", new Object[0]);
      SafeContinuation var2 = new SafeContinuation(IntrinsicsKt.intercepted(var1));
      this.connectionContinuation = (Continuation)var2;
      this.connect();
      Object var3 = var2.getOrThrow();
      if (var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var1);
      }

      return var3;
   }

   public final void disconnect() {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("disConnect: transport = ");
      var1.append(this.getTransport());
      String var3 = var1.toString();
      Boolean var6 = false;
      var2.d(var3, new Object[0]);

      label56:
      try {
         this.getTransport().disconnect();
      } catch (Throwable var5) {
         Timber.Forest.w(var5, "disConnect failed", new Object[0]);
         break label56;
      }

      this.stopPollDeviceBounded();
      this.security = null;
      this.session = null;
      Continuation var7 = this.connectionContinuation;
      if (var7 != null) {
         Result.Companion var11 = Result.Companion;
         var7.resumeWith(Result.constructor-impl(var6));
      }

      this.connectionContinuation = null;
      var7 = this.establishSessionContinuation;
      if (var7 != null) {
         Result.Companion var12 = Result.Companion;
         var7.resumeWith(Result.constructor-impl(var6));
      }

      this.establishSessionContinuation = null;
      Continuation var13 = this.readFilterContinuation;
      if (var13 != null) {
         Result.Companion var9 = Result.Companion;
         var13.resumeWith(Result.constructor-impl(-1));
      }

      this.readFilterContinuation = null;
      var13 = this.resetFilterContinuation;
      if (var13 != null) {
         Result.Companion var10 = Result.Companion;
         var13.resumeWith(Result.constructor-impl(var6));
      }

      this.resetFilterContinuation = null;
      this.updateState(BleDeviceState.Disconnected.INSTANCE);
   }

   public final void establishSession(String var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "proofOfPossesion");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("establishSession: isConnected = ");
      var3.append(this.isConnected());
      var3.append(", hasSession = ");
      var3.append(this.getHasSession());
      var4.d(var3.toString(), new Object[0]);
      if (!this.isConnected()) {
         Continuation var9 = this.establishSessionContinuation;
         if (var9 != null) {
            Result.Companion var5 = Result.Companion;
            var9.resumeWith(Result.constructor-impl(false));
            return;
         }
      } else {
         if (!this.getHasSession()) {
            this.updateState(BleDeviceState.SessionEstablishing.INSTANCE);
            Security var7 = new Security1(var1);
            this.security = var7;
            Session var8 = new Session(this.getTransport(), var7);
            var8.sessionListener = new Session.SessionListener(this, var2) {
               final Function0 $onSessionEstablished;
               final BleDeviceService this$0;

               {
                  this.this$0 = var1;
                  this.$onSessionEstablished = var2;
               }

               public void OnSessionEstablishFailed(Exception var1) {
                  Timber.Forest.e("OnSessionEstablishFailed", new Object[0]);
                  BleDeviceService var2 = this.this$0;
                  BleDeviceState var3 = BleDeviceState.SessionEstablishing.INSTANCE;
                  String var4;
                  if (var1 != null) {
                     var4 = var1.getMessage();
                  } else {
                     var4 = null;
                  }

                  var2.updateError(new BleDeviceError(var3, var4));
               }

               public void OnSessionEstablished() {
                  Timber.Forest.d("OnSessionEstablished", new Object[0]);
                  this.this$0.updateState(BleDeviceState.SessionEstablished.INSTANCE);
                  Function0 var1 = this.$onSessionEstablished;
                  if (var1 != null) {
                     var1.invoke();
                  }

               }
            };
            this.session = var8;
            var8.init((byte[])null);
            return;
         }

         Continuation var10 = this.establishSessionContinuation;
         if (var10 != null) {
            Result.Companion var6 = Result.Companion;
            var10.resumeWith(Result.constructor-impl(true));
         }
      }

   }

   public final Object establishSessionSync(String var1, Function0 var2, Continuation var3) {
      Timber.Forest.d("establishSessionSync", new Object[0]);
      SafeContinuation var4 = new SafeContinuation(IntrinsicsKt.intercepted(var3));
      this.establishSessionContinuation = (Continuation)var4;
      this.establishSession(var1, var2);
      Object var5 = var4.getOrThrow();
      if (var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var3);
      }

      return var5;
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final BluetoothDevice getCurrentDevice() {
      return this.currentDevice;
   }

   public final String getDetectedDeviceUuid() {
      return this.detectedDeviceUuid;
   }

   public final Observable getDeviceErrorObserver() {
      Observable var1 = this.getDeviceErrorPublisher().hide();
      Intrinsics.checkNotNullExpressionValue(var1, "hide(...)");
      return var1;
   }

   public final Observable getDeviceStateObserver() {
      Observable var1 = this.getDeviceStatePublisher().hide();
      Intrinsics.checkNotNullExpressionValue(var1, "hide(...)");
      return var1;
   }

   public final StateFlow getDeviceStateStream() {
      return this.deviceStateStream;
   }

   public final BleDeviceError getError() {
      return this.error;
   }

   public final boolean getHasSession() {
      if (this.isConnected()) {
         Session var1 = this.session;
         if (var1 != null && var1.isEstablished()) {
            return true;
         }
      }

      return false;
   }

   public final LiveData getLiveDeviceStateObserver() {
      return (LiveData)this.liveDeviceStateObserver$delegate.getValue();
   }

   public final Security getSecurity() {
      return this.security;
   }

   public final String getServiceUuid() {
      return this.serviceUuid;
   }

   public final Session getSession() {
      return this.session;
   }

   public final BleDeviceState getState() {
      return (BleDeviceState)this._deviceEvents.getValue();
   }

   public final BLETransport getTransport() {
      return (BLETransport)this.transport$delegate.getValue();
   }

   public final boolean isBounded() {
      return this.getState().isEnabled(BleDeviceState.Bounded.INSTANCE);
   }

   public final boolean isConnected() {
      return this.getState().isEnabled(BleDeviceState.Connected.INSTANCE);
   }

   public final boolean isProvisioningConfigured() {
      return this.getState().getCode() >= BleDeviceState.ProvisioningConfigured5.INSTANCE.getCode();
   }

   public final boolean isProvisioningStarted() {
      return this.getHasSession() && this.getState().getCode() >= BleDeviceState.ProvisioningStarted.INSTANCE.getCode();
   }

   public final boolean isWifiConfigApplied() {
      return this.getState().getCode() >= BleDeviceState.WifiConfigApplied.INSTANCE.getCode();
   }

   public final boolean isWifiConfigured() {
      return this.getState().getCode() >= BleDeviceState.WifiConfigured.INSTANCE.getCode();
   }

   public final boolean isWifiConnected() {
      return this.getState().isEnabled(BleDeviceState.WifiConnected.INSTANCE);
   }

   public final Object pollDeviceBounded(Continuation var1) {
      Timber.Forest.v("pollDeviceBounded", new Object[0]);
      if (this.isBounded()) {
         return Boxing.boxBoolean(false);
      } else {
         if (this.pollingDeviceBoundedDisposable != null) {
            this.stopPollDeviceBounded();
         }

         PublishSubject var3 = PublishSubject.create();
         Intrinsics.checkNotNullExpressionValue(var3, "create(...)");
         Disposable var2 = var3.subscribe(new BleDeviceService$$ExternalSyntheticLambda6(new BleDeviceService$$ExternalSyntheticLambda0(this)), new BleDeviceService$$ExternalSyntheticLambda8(new BleDeviceService$$ExternalSyntheticLambda7(this)));
         this.pollingDeviceBoundedDisposable = var2;
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var3, var2, (Continuation)null) {
            final PublishSubject $eventPublisher;
            final Disposable $pollingDisposable;
            int label;
            final BleDeviceService this$0;

            {
               this.this$0 = var1;
               this.$eventPublisher = var2;
               this.$pollingDisposable = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$eventPublisher, this.$pollingDisposable, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  BleDeviceService var4 = this.this$0;
                  PublishSubject var7 = this.$eventPublisher;
                  Disposable var6 = this.$pollingDisposable;
                  Intrinsics.checkNotNull(var6);
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (var4.startPollDeviceBounded(var7, var6, var5) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
         return Boxing.boxBoolean(true);
      }
   }

   public final Object pollWifiConnectionStatus(Continuation var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("pollWifiConnectionStatus: state = ");
      var2.append(this.getState());
      var3.d(var2.toString(), new Object[0]);
      if (this.isWifiConnected()) {
         return Boxing.boxBoolean(false);
      } else {
         this.updateState(BleDeviceState.PollingWifiConfigStatus.INSTANCE);
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final BleDeviceService this$0;

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
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  (new Provision(this.this$0.getSession())).pollForWifiConnectionStatus(new Provision.WifiStateListener(this.this$0) {
                     final BleDeviceService this$0;

                     {
                        this.this$0 = var1;
                     }

                     public void onWifiStateUpdated(WifiConstants.WifiStationState var1, WifiConstants.WifiConnectFailedReason var2, Exception var3) {
                        Timber.Forest var5 = Timber.Forest;
                        StringBuilder var4 = new StringBuilder("pollWifiConnectionStatus: state = ");
                        var4.append(var1);
                        var4.append(", failedReason = ");
                        var4.append(var2);
                        var5.d(var4.toString(), new Object[0]);
                        if (var3 != null) {
                           Timber.Forest.e((Throwable)var3, "pollWifiConnectionStatus failed", new Object[0]);
                        }

                        if (var1 == WifiStationState.Connected) {
                           this.this$0.updateState(BleDeviceState.WifiConnected.INSTANCE);
                        } else if (var1 == WifiStationState.ConnectionFailed || var1 == WifiStationState.Disconnected || var3 != null) {
                           Object var11 = null;
                           String var8;
                           if (var2 != null) {
                              var8 = var2.name();
                           } else {
                              var8 = null;
                           }

                           String var9;
                           if (var3 != null) {
                              var9 = var3.getMessage();
                           } else {
                              var9 = null;
                           }

                           label61: {
                              var13 = this.this$0;
                              var10 = BleDeviceState.PollingWifiConfigStatus.INSTANCE;
                              CharSequence var7 = (CharSequence)var8;
                              if (var7 != null && var7.length() != 0) {
                                 CharSequence var6 = (CharSequence)var9;
                                 if (var6 != null && var6.length() != 0) {
                                    StringBuilder var12 = new StringBuilder();
                                    var12.append(var8);
                                    var12.append(" -- ");
                                    var12.append(var9);
                                    var8 = var12.toString();
                                    break label61;
                                 }
                              }

                              if (var7 == null || var7.length() == 0) {
                                 CharSequence var14 = (CharSequence)var9;
                                 var8 = (String)var11;
                                 if (var14 != null) {
                                    if (var14.length() == 0) {
                                       var8 = (String)var11;
                                    } else {
                                       var8 = var9;
                                    }
                                 }
                              }
                           }

                           var13.updateError(new BleDeviceError(var10, var8));
                        }
                     }
                  });
                  return Unit.INSTANCE;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         }, 2, (Object)null);
         return Boxing.boxBoolean(true);
      }
   }

   public final Object readFilterSync(DeviceFilterType var1, Continuation var2) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("readFilterSync: ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      SafeContinuation var8 = new SafeContinuation(IntrinsicsKt.intercepted(var2));
      Continuation var9 = (Continuation)var8;
      this.readFilterContinuation = var9;
      CustomCommands.FilterReadCmd var5 = (CustomCommands.FilterReadCmd)FilterReadCmd.newBuilder().setType(String.valueOf(var1.ordinal())).build();
      CustomCommands.CommandWrapper var6 = (CustomCommands.CommandWrapper)CommandWrapper.newBuilder().setFilterReadCmd(var5).build();
      Intrinsics.checkNotNull(var6);
      this.sendWrapper(var6, new Function1(var9, this) {
         final Continuation $cont;
         final BleDeviceService this$0;

         {
            this.$cont = var1;
            this.this$0 = var2;
         }

         public final void invoke(CustomCommands.CommandWrapper var1) {
            Intrinsics.checkNotNullParameter(var1, "response");
            Timber.Forest var3 = Timber.Forest;
            StringBuilder var2 = new StringBuilder("readFilter: onSuccess: usage = ");
            var2.append(var1.getFilterReadResp().getFilter());
            var3.d(var2.toString(), new Object[0]);
            Continuation var4 = this.$cont;
            Result.Companion var5 = Result.Companion;
            var4.resumeWith(Result.constructor-impl(var1.getFilterReadResp().getFilter()));
            this.this$0.readFilterContinuation = null;
         }
      }, new Function1(var9, this) {
         final Continuation $cont;
         final BleDeviceService this$0;

         {
            this.$cont = var1;
            this.this$0 = var2;
         }

         public final void invoke(Throwable var1) {
            Intrinsics.checkNotNullParameter(var1, "t");
            Timber.Forest.e(var1, "readFilter: onFail", new Object[0]);
            Continuation var3 = this.$cont;
            Result.Companion var2 = Result.Companion;
            var3.resumeWith(Result.constructor-impl(-1));
            this.this$0.readFilterContinuation = null;
         }
      });
      Object var7 = var8.getOrThrow();
      if (var7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var2);
      }

      return var7;
   }

   public final Object resetFilterSync(String var1, Continuation var2) {
      Timber.Forest.d("resetFilterSync", new Object[0]);
      SafeContinuation var3 = new SafeContinuation(IntrinsicsKt.intercepted(var2));
      Continuation var4 = (Continuation)var3;
      this.resetFilterContinuation = var4;
      CustomCommands.FilterSetCmd var5 = (CustomCommands.FilterSetCmd)FilterSetCmd.newBuilder().setFilter(var1).build();
      CustomCommands.CommandWrapper var6 = (CustomCommands.CommandWrapper)CommandWrapper.newBuilder().setFilterSetCmd(var5).build();
      Intrinsics.checkNotNull(var6);
      this.sendWrapper(var6, new Function1(var4, this) {
         final Continuation $cont;
         final BleDeviceService this$0;

         {
            this.$cont = var1;
            this.this$0 = var2;
         }

         public final void invoke(CustomCommands.CommandWrapper var1) {
            Intrinsics.checkNotNullParameter(var1, "response");
            Timber.Forest var3 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("resetFilter: onSuccess: status = ");
            var4.append(var1.getFilterSetResp().getStatus());
            String var6 = var4.toString();
            boolean var2 = false;
            var3.d(var6, new Object[0]);
            Continuation var5 = this.$cont;
            Result.Companion var7 = Result.Companion;
            if (var1.getFilterSetResp().getStatus() == custom.CustomCommands.Status.Success) {
               var2 = true;
            }

            var5.resumeWith(Result.constructor-impl(var2));
            this.this$0.resetFilterContinuation = null;
         }
      }, new Function1(var4, this) {
         final Continuation $cont;
         final BleDeviceService this$0;

         {
            this.$cont = var1;
            this.this$0 = var2;
         }

         public final void invoke(Throwable var1) {
            Intrinsics.checkNotNullParameter(var1, "t");
            Timber.Forest.e(var1, "resetFilter: onFail", new Object[0]);
            Continuation var2 = this.$cont;
            Result.Companion var3 = Result.Companion;
            var2.resumeWith(Result.constructor-impl(false));
            this.this$0.resetFilterContinuation = null;
         }
      });
      Object var7 = var3.getOrThrow();
      if (var7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var2);
      }

      return var7;
   }

   public final void setSecurity(Security var1) {
      this.security = var1;
   }

   public final void setSession(Session var1) {
      this.session = var1;
   }

   public final void sideLoadError(String var1) {
      this.updateError(new BleDeviceError(this.getState(), var1));
   }

   public final Object startProvisioningSync(Continuation var1) {
      Timber.Forest.d("startProvisioningSync", new Object[0]);
      SafeContinuation var2 = new SafeContinuation(IntrinsicsKt.intercepted(var1));
      Continuation var3 = (Continuation)var2;
      CustomCommands.StartCmd var4 = (CustomCommands.StartCmd)StartCmd.newBuilder().build();
      CustomCommands.CommandWrapper var6 = (CustomCommands.CommandWrapper)CommandWrapper.newBuilder().setStartCmd(var4).build();
      Intrinsics.checkNotNull(var6);
      this.sendWrapper(var6, new Function1(this, var3) {
         final Continuation $cont;
         final BleDeviceService this$0;

         {
            this.this$0 = var1;
            this.$cont = var2;
         }

         public final void invoke(CustomCommands.CommandWrapper var1) {
            Intrinsics.checkNotNullParameter(var1, "response");
            Timber.Forest var3 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("startProvisioning: onSuccess: status: ");
            var4.append(var1.getStartResp().getStatus());
            var4.append(", status value = ");
            var4.append(var1.getStartResp().getStatusValue());
            String var6 = var4.toString();
            boolean var2 = false;
            var3.d(var6, new Object[0]);
            this.this$0.updateState(BleDeviceState.ProvisioningStarted.INSTANCE);
            Continuation var7 = this.$cont;
            Result.Companion var5 = Result.Companion;
            if (var1.getStartResp().getStatus() == custom.CustomCommands.Status.Success) {
               var2 = true;
            }

            var7.resumeWith(Result.constructor-impl(var2));
         }
      }, new Function1(var3) {
         final Continuation $cont;

         {
            this.$cont = var1;
         }

         public final void invoke(Throwable var1) {
            Intrinsics.checkNotNullParameter(var1, "t");
            Timber.Forest.e(var1, "startProvisioning: onFail", new Object[0]);
            Continuation var2 = this.$cont;
            Result.Companion var3 = Result.Companion;
            var2.resumeWith(Result.constructor-impl(false));
         }
      });
      Object var5 = var2.getOrThrow();
      if (var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var1);
      }

      return var5;
   }

   public final Object wifiScanSync(Continuation var1) {
      Timber.Forest.d("wifiScanSync", new Object[0]);
      SafeContinuation var2 = new SafeContinuation(IntrinsicsKt.intercepted(var1));
      this.startWifiScan(new Function1((Continuation)var2) {
         final Continuation $cont;

         {
            this.$cont = var1;
         }

         public final void invoke(List var1) {
            Intrinsics.checkNotNullParameter(var1, "ssidList");
            Timber.Forest var3 = Timber.Forest;
            StringBuilder var2 = new StringBuilder("wifiScanSync: ssidList = ");
            var2.append(var1);
            var3.d(var2.toString(), new Object[0]);
            Continuation var5 = this.$cont;
            Result.Companion var4 = Result.Companion;
            var5.resumeWith(Result.constructor-impl(var1));
         }
      });
      Object var3 = var2.getOrThrow();
      if (var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var1);
      }

      return var3;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"},
      d2 = {"Lcom/blueair/bluetooth/service/BleDeviceService$Companion;", "", "<init>", "()V", "PROOF_OF_POSSESION_DEFAULT", "", "SSID_FETCH_SIZE", "", "bluetooth_otherRelease"},
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
