package com.blueair.adddevice.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaService;
import com.blueair.bluetooth.model.BleScannedDevice;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceService;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.bluetooth.service.BleScanningService;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import com.blueair.core.FileNames;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.Ssid;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.util.PersistentObjectDelegate;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 ß\u00012\u00020\u0001:\u0002ß\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020&2\u0007\u0010\u0001\u001a\u000204H\u0002J\u0015\u0010\u0001\u001a\u00020&2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0013\u0010 \u0001\u001a\u00030\u00012\u0007\u0010¡\u0001\u001a\u000204H\u0002J\u0011\u0010¢\u0001\u001a\u00030\u00012\u0007\u0010£\u0001\u001a\u00020dJ\u001a\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010£\u0001\u001a\u00020d2\u0007\u0010¥\u0001\u001a\u000204J%\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u0002042\u0007\u0010¨\u0001\u001a\u0002042\t\b\u0002\u0010©\u0001\u001a\u000204J'\u0010ª\u0001\u001a\u00030\u00012\b\u0010«\u0001\u001a\u00030\u00012\b\u0010¬\u0001\u001a\u00030\u00012\t\b\u0002\u0010©\u0001\u001a\u000204JI\u0010­\u0001\u001a\u00030\u00012\u0007\u0010®\u0001\u001a\u0002042\u0007\u0010¯\u0001\u001a\u0002042\u0007\u0010°\u0001\u001a\u0002042\u0007\u0010±\u0001\u001a\u0002042\u0007\u0010²\u0001\u001a\u0002042\u0007\u0010³\u0001\u001a\u0002042\t\b\u0002\u0010©\u0001\u001a\u000204J\u0013\u0010´\u0001\u001a\u00030\u00012\t\b\u0002\u0010©\u0001\u001a\u000204J\u0013\u0010µ\u0001\u001a\u00030\u00012\t\b\u0002\u0010©\u0001\u001a\u000204J\u0011\u0010¶\u0001\u001a\u00030\u00012\u0007\u0010·\u0001\u001a\u000204J\u001b\u0010¸\u0001\u001a\u0002042\u0007\u0010¹\u0001\u001a\u00020\u001c2\u0007\u0010º\u0001\u001a\u00020oH\u0002J\b\u0010»\u0001\u001a\u00030\u0001J\b\u0010¼\u0001\u001a\u00030\u0001J\b\u0010½\u0001\u001a\u00030\u0001J\b\u0010¾\u0001\u001a\u00030\u0001J\b\u0010¿\u0001\u001a\u00030\u0001J\n\u0010À\u0001\u001a\u00030\u0001H\u0014J\b\u0010Á\u0001\u001a\u00030\u0001J\b\u0010Â\u0001\u001a\u00030\u0001J\u0010\u0010Ã\u0001\u001a\u00020&H@¢\u0006\u0003\u0010Ä\u0001J\u0010\u0010Å\u0001\u001a\u00020&H@¢\u0006\u0003\u0010Ä\u0001J\n\u0010Æ\u0001\u001a\u00030\u0001H\u0002J\b\u0010Ç\u0001\u001a\u00030\u0001J\u0012\u0010È\u0001\u001a\u00030\u00012\b\u0010É\u0001\u001a\u00030Ê\u0001J\b\u0010Ë\u0001\u001a\u00030\u0001J\b\u0010Ì\u0001\u001a\u00030\u0001J#\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010g2\u0007\u0010Î\u0001\u001a\u00020d2\t\b\u0002\u0010Ï\u0001\u001a\u00020&J\b\u0010Ð\u0001\u001a\u00030\u0001J\u0010\u0010Ñ\u0001\u001a\u00020&H@¢\u0006\u0003\u0010Ä\u0001J\u001d\u0010Ò\u0001\u001a\u00030\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010 2\b\b\u0002\u00109\u001a\u00020&J\u001a\u0010Ô\u0001\u001a\u00030\u00012\u0007\u0010Õ\u0001\u001a\u00020dH@¢\u0006\u0003\u0010Ö\u0001J\b\u0010×\u0001\u001a\u00030\u0001J\b\u0010Ø\u0001\u001a\u00030\u0001J\u0007\u0010Ù\u0001\u001a\u00020&J\u0011\u0010Ú\u0001\u001a\u00030\u00012\u0007\u0010Û\u0001\u001a\u000204J\u0013\u0010Ü\u0001\u001a\u00030\u00012\t\b\u0002\u0010Ý\u0001\u001a\u00020&J\b\u0010Þ\u0001\u001a\u00030\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\"\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00106\"\u0004\b?\u00108R\u001a\u0010@\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00106\"\u0004\bB\u00108R\u001a\u0010C\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0.¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020J0.¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R!\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M8FX\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020&0.¢\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u001a\u0010U\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010:\"\u0004\bW\u0010<R\u0016\u0010X\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000RC\u0010\\\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040[2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040[8B@BX\u0002¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001d\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\be\u0010$R!\u0010f\u001a\b\u0012\u0004\u0012\u00020&0g8FX\u0002¢\u0006\f\n\u0004\bj\u0010\u000b\u001a\u0004\bh\u0010iR\u0011\u0010k\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\bk\u0010:R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020&0.¢\u0006\b\n\u0000\u001a\u0004\bm\u00100R\u0019\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010g8F¢\u0006\u0006\u001a\u0004\bp\u0010iR\u0019\u0010q\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010g8F¢\u0006\u0006\u001a\u0004\bs\u0010iR\u0013\u0010t\u001a\u0004\u0018\u00010u8F¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0011\u0010x\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\by\u0010:R\u001e\u0010{\u001a\u00020&2\u0006\u0010z\u001a\u00020&@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b{\u0010:R\u0013\u0010|\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0013\u0010~\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b~\u0010}R\u0013\u0010\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b\u0010}R\u0016\u0010\u0001\u001a\u0004\u0018\u00010r8F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040.X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001040\u00018F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u0004\u0018\u0001048F¢\u0006\u0007\u001a\u0005\b\u0001\u00106R%\u0010\u0001\u001a\u0004\u0018\u00010d2\b\u0010z\u001a\u0004\u0018\u00010d@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u0004\u0018\u0001048F¢\u0006\u0007\u001a\u0005\b\u0001\u00106R\u000f\u0010\u0001\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006à\u0001"}, d2 = {"Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "bleScanningService", "Lcom/blueair/bluetooth/service/BleScanningService;", "getBleScanningService", "()Lcom/blueair/bluetooth/service/BleScanningService;", "bleScanningService$delegate", "btConnectivityService", "Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "getBtConnectivityService", "()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "btConnectivityService$delegate", "selectedBleDeviceService", "Lcom/blueair/bluetooth/service/BleDeviceService;", "_ssids", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/blueair/core/model/Ssid;", "ssids", "Lkotlinx/coroutines/flow/StateFlow;", "getSsids", "()Lkotlinx/coroutines/flow/StateFlow;", "_isRefreshingSsids", "", "isRefreshingSsids", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "selectedSsid", "Landroidx/lifecycle/MutableLiveData;", "getSelectedSsid", "()Landroidx/lifecycle/MutableLiveData;", "setSelectedSsid", "(Landroidx/lifecycle/MutableLiveData;)V", "password", "", "getPassword$adddevice_otherRelease", "()Ljava/lang/String;", "setPassword$adddevice_otherRelease", "(Ljava/lang/String;)V", "isHiddenNetwork", "()Z", "setHiddenNetwork", "(Z)V", "rand", "getRand", "setRand", "text", "getText", "setText", "hasSharedError", "getHasSharedError", "setHasSharedError", "onboardingDevice", "Lcom/blueair/core/model/DeviceG4;", "getOnboardingDevice", "currentScreen", "Lcom/blueair/adddevice/viewmodel/AddDeviceScreen;", "getCurrentScreen", "actionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/viewmodel/AddDeviceAction;", "getActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "actionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "lvBlockNavigation", "getLvBlockNavigation", "polling", "getPolling", "setPolling", "onboardedDevices", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "<set-?>", "", "bleDeviceMacNameCache", "getBleDeviceMacNameCache", "()Ljava/util/Map;", "setBleDeviceMacNameCache", "(Ljava/util/Map;)V", "bleDeviceMacNameCache$delegate", "Lcom/blueair/core/util/PersistentObjectDelegate;", "bleDevicesFlow", "Lcom/blueair/core/model/BluetoothDevice;", "getBleDevicesFlow", "bluetoothConnectionStateObserver", "Lio/reactivex/Observable;", "getBluetoothConnectionStateObserver", "()Lio/reactivex/Observable;", "bluetoothConnectionStateObserver$delegate", "isBluetoothEnabled", "lvDeviceScanned", "getLvDeviceScanned", "selectedBleDeviceStateObserver", "Lcom/blueair/bluetooth/service/BleDeviceState;", "getSelectedBleDeviceStateObserver", "selectedBleDeviceErrorObserver", "Lcom/blueair/bluetooth/service/BleDeviceError;", "getSelectedBleDeviceErrorObserver", "selectedBleDevice", "Landroid/bluetooth/BluetoothDevice;", "getSelectedBleDevice", "()Landroid/bluetooth/BluetoothDevice;", "hasSelectedBleDevice", "getHasSelectedBleDevice", "value", "isRandRegisterFailed", "isSelectedBleDeviceWifiConnected", "()Ljava/lang/Boolean;", "isSelectedBleDeviceConnected", "isSelectedBleDeviceBounded", "selectedBleDeviceError", "getSelectedBleDeviceError", "()Lcom/blueair/bluetooth/service/BleDeviceError;", "_selectedDeviceName", "liveSelectedDeviceName", "Landroidx/lifecycle/LiveData;", "getLiveSelectedDeviceName", "()Landroidx/lifecycle/LiveData;", "selectedDeviceName", "getSelectedDeviceName", "selectedUiDevice", "getSelectedUiDevice", "()Lcom/blueair/core/model/BluetoothDevice;", "detectedDeviceUuid", "getDetectedDeviceUuid", "wifiStateListenerAdded", "logSessionUuid", "logEvents", "", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "wifiListRefreshCount", "", "stayScreenName", "stayScreenStartTime", "", "addLogEvent", "", "event", "sendLogEvents", "isStepSuccess", "result", "isStepError", "uploadOnboardingLog", "message", "logStep0SelectDevice", "device", "logStep1ConnectionInstructions", "connectType", "logStep2Connecting", "bleEstablishSession", "bleStartProvision", "extra", "logStep3WifiList", "refreshCount", "ssidCount", "logStep4WifiPassword", "cloudRegion", "registerForOnboarding", "bleConfigProvision", "bleConfigWifi", "bleApplyWifi", "blePollWifiConnected", "logStep5OnboardingSuccess", "logStep5OnboardingFailure", "recordResume", "screenName", "getStateResult", "service", "state", "showConnectionLost", "restart", "clearOnboardedDevices", "reset", "resetScanResult", "onCleared", "disableSoftAp", "gotoWifiList", "provisionSelectedBleDevice", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollwifiConnected", "pollDeviceBounded", "refreshSsidsList", "unbindNetwork", "activity", "Landroid/app/Activity;", "startBluetoothScanning", "stopBluetoothScanning", "selectBluetoothDevice", "uiDevice", "forceNew", "deselectBluetoothDevice", "connectAndEstablishSessionAndStartProvisioningForBleDeviceSync", "gotoWifiPassword", "ssid", "removeOwnedDevice", "bluetoothDevice", "(Lcom/blueair/core/model/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoSuccessScreen", "gotoEnterNameScreen", "isUserLoggedIn", "setDeviceName", "nuName", "blockNavigation", "block", "addDevice", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceViewModel.kt */
public final class AddDeviceViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_PROVISION_ATTEMPTS = 2;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> _isRefreshingSsids;
    private final MutableLiveData<String> _selectedDeviceName;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<Ssid>> _ssids;
    private final LazyPublishSubject actionPublisher$delegate;
    private final Lazy authService$delegate;
    private final PersistentObjectDelegate bleDeviceMacNameCache$delegate;
    private final StateFlow<List<BluetoothDevice>> bleDevicesFlow;
    private final Lazy bleScanningService$delegate;
    private final Lazy bluetoothConnectionStateObserver$delegate;
    private final Lazy btConnectivityService$delegate;
    private final MutableLiveData<AddDeviceScreen> currentScreen;
    private final Lazy gigyaService$delegate;
    private final Lazy happyUserService$delegate;
    private boolean hasSharedError;
    private boolean isHiddenNetwork;
    private boolean isRandRegisterFailed;
    private final StateFlow<Boolean> isRefreshingSsids;
    /* access modifiers changed from: private */
    public final List<AnalyticEvent.OnboardingLogEvent> logEvents;
    private String logSessionUuid;
    private final MutableLiveData<Boolean> lvBlockNavigation;
    private final MutableLiveData<Boolean> lvDeviceScanned;
    /* access modifiers changed from: private */
    public List<? extends HasBlueCloudFunctions> onboardedDevices;
    private final MutableLiveData<DeviceG4> onboardingDevice = new MutableLiveData<>();
    private String password;
    private volatile boolean polling;
    private String rand = "";
    /* access modifiers changed from: private */
    public BleDeviceService selectedBleDeviceService;
    private MutableLiveData<Ssid> selectedSsid = new MutableLiveData<>();
    private BluetoothDevice selectedUiDevice;
    private final StateFlow<List<Ssid>> ssids;
    private String stayScreenName;
    private long stayScreenStartTime;
    private String text = "";
    /* access modifiers changed from: private */
    public int wifiListRefreshCount;
    private boolean wifiStateListenerAdded;

    static {
        Class<AddDeviceViewModel> cls = AddDeviceViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "bleScanningService", "getBleScanningService()Lcom/blueair/bluetooth/service/BleScanningService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "btConnectivityService", "getBtConnectivityService()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "actionPublisher", "getActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "bleDeviceMacNameCache", "getBleDeviceMacNameCache()Ljava/util/Map;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddDeviceViewModel(Application application) {
        super(application);
        Application application2 = application;
        Intrinsics.checkNotNullParameter(application2, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AddDeviceViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.gigyaService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, GigyaService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AddDeviceViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.bleScanningService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, BleScanningService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AddDeviceViewModel$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.btConnectivityService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, BluetoothConnectivityService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        MutableStateFlow<List<Ssid>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._ssids = MutableStateFlow;
        this.ssids = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isRefreshingSsids = MutableStateFlow2;
        this.isRefreshingSsids = FlowKt.asStateFlow(MutableStateFlow2);
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new AddDeviceViewModel$special$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.happyUserService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, HappyUserService.class), (Object) null).provideDelegate(this, kPropertyArr[4]);
        MutableLiveData<AddDeviceScreen> mutableLiveData = new MutableLiveData<>();
        this.currentScreen = mutableLiveData;
        this.actionPublisher$delegate = new LazyPublishSubject();
        this.lvBlockNavigation = new MutableLiveData<>(false);
        this.bleDeviceMacNameCache$delegate = new PersistentObjectDelegate(application2, FileNames.BLE_DEVICE_MAC_NAME_MAP_FILE, MapsKt.emptyMap(), Map.class, String.class, String.class);
        this.bleDevicesFlow = FlowKt.stateIn(new AddDeviceViewModel$special$$inlined$map$1(FlowKt.filterNotNull(getBleScanningService().getResultFlow()), this), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), CollectionsKt.emptyList());
        this.bluetoothConnectionStateObserver$delegate = LazyKt.lazy(new AddDeviceViewModel$$ExternalSyntheticLambda0(this));
        this.lvDeviceScanned = new MutableLiveData<>(false);
        this._selectedDeviceName = new MutableLiveData<>(null);
        this.logSessionUuid = "";
        this.logEvents = new ArrayList();
        this.stayScreenName = "";
        mutableLiveData.setValue(AddDeviceScreen.ChooseDevice);
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final GigyaService getGigyaService() {
        return (GigyaService) this.gigyaService$delegate.getValue();
    }

    private final BleScanningService getBleScanningService() {
        return (BleScanningService) this.bleScanningService$delegate.getValue();
    }

    private final BluetoothConnectivityService getBtConnectivityService() {
        return (BluetoothConnectivityService) this.btConnectivityService$delegate.getValue();
    }

    public final StateFlow<List<Ssid>> getSsids() {
        return this.ssids;
    }

    public final StateFlow<Boolean> isRefreshingSsids() {
        return this.isRefreshingSsids;
    }

    private final HappyUserService getHappyUserService() {
        return (HappyUserService) this.happyUserService$delegate.getValue();
    }

    public final MutableLiveData<Ssid> getSelectedSsid() {
        return this.selectedSsid;
    }

    public final void setSelectedSsid(MutableLiveData<Ssid> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.selectedSsid = mutableLiveData;
    }

    public final String getPassword$adddevice_otherRelease() {
        return this.password;
    }

    public final void setPassword$adddevice_otherRelease(String str) {
        this.password = str;
    }

    public final boolean isHiddenNetwork() {
        return this.isHiddenNetwork;
    }

    public final void setHiddenNetwork(boolean z) {
        this.isHiddenNetwork = z;
    }

    public final String getRand() {
        return this.rand;
    }

    public final void setRand(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rand = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final boolean getHasSharedError() {
        return this.hasSharedError;
    }

    public final void setHasSharedError(boolean z) {
        this.hasSharedError = z;
    }

    public final MutableLiveData<DeviceG4> getOnboardingDevice() {
        return this.onboardingDevice;
    }

    public final MutableLiveData<AddDeviceScreen> getCurrentScreen() {
        return this.currentScreen;
    }

    public final PublishSubject<AddDeviceAction> getActionPublisher() {
        return this.actionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[5]);
    }

    public final MutableLiveData<Boolean> getLvBlockNavigation() {
        return this.lvBlockNavigation;
    }

    public final boolean getPolling() {
        return this.polling;
    }

    public final void setPolling(boolean z) {
        this.polling = z;
    }

    /* access modifiers changed from: private */
    public final Map<String, String> getBleDeviceMacNameCache() {
        return (Map) this.bleDeviceMacNameCache$delegate.getValue(this, $$delegatedProperties[6]);
    }

    /* access modifiers changed from: private */
    public final void setBleDeviceMacNameCache(Map<String, String> map) {
        this.bleDeviceMacNameCache$delegate.setValue(this, $$delegatedProperties[6], map);
    }

    public final StateFlow<List<BluetoothDevice>> getBleDevicesFlow() {
        return this.bleDevicesFlow;
    }

    public final Observable<Boolean> getBluetoothConnectionStateObserver() {
        Object value = this.bluetoothConnectionStateObserver$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Observable) value;
    }

    /* access modifiers changed from: private */
    public static final Observable bluetoothConnectionStateObserver_delegate$lambda$4(AddDeviceViewModel addDeviceViewModel) {
        return addDeviceViewModel.getBtConnectivityService().getStateObserver().hide();
    }

    public final boolean isBluetoothEnabled() {
        return getBtConnectivityService().isBluetoothEnabled();
    }

    public final MutableLiveData<Boolean> getLvDeviceScanned() {
        return this.lvDeviceScanned;
    }

    public final Observable<BleDeviceState> getSelectedBleDeviceStateObserver() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return bleDeviceService.getDeviceStateObserver();
        }
        return null;
    }

    public final Observable<BleDeviceError> getSelectedBleDeviceErrorObserver() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return bleDeviceService.getDeviceErrorObserver();
        }
        return null;
    }

    public final android.bluetooth.BluetoothDevice getSelectedBleDevice() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return bleDeviceService.getCurrentDevice();
        }
        return null;
    }

    public final boolean getHasSelectedBleDevice() {
        return this.selectedBleDeviceService != null;
    }

    public final boolean isRandRegisterFailed() {
        return this.isRandRegisterFailed;
    }

    public final Boolean isSelectedBleDeviceWifiConnected() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return Boolean.valueOf(bleDeviceService.isWifiConnected());
        }
        return null;
    }

    public final Boolean isSelectedBleDeviceConnected() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return Boolean.valueOf(bleDeviceService.isConnected());
        }
        return null;
    }

    public final Boolean isSelectedBleDeviceBounded() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return Boolean.valueOf(bleDeviceService.isBounded());
        }
        return null;
    }

    public final BleDeviceError getSelectedBleDeviceError() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return bleDeviceService.getError();
        }
        return null;
    }

    public final LiveData<String> getLiveSelectedDeviceName() {
        return Transformations.distinctUntilChanged(this._selectedDeviceName);
    }

    public final String getSelectedDeviceName() {
        return this._selectedDeviceName.getValue();
    }

    public final BluetoothDevice getSelectedUiDevice() {
        return this.selectedUiDevice;
    }

    public final String getDetectedDeviceUuid() {
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            return bleDeviceService.getDetectedDeviceUuid();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r0.getPayload();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addLogEvent(com.blueair.core.model.AnalyticEvent.OnboardingLogEvent r4) {
        /*
            r3 = this;
            java.util.List<com.blueair.core.model.AnalyticEvent$OnboardingLogEvent> r0 = r3.logEvents
            java.lang.Object r0 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            com.blueair.core.model.AnalyticEvent$OnboardingLogEvent r0 = (com.blueair.core.model.AnalyticEvent.OnboardingLogEvent) r0
            java.lang.String r1 = "step"
            if (r0 == 0) goto L_0x0017
            java.util.Map r0 = r0.getPayload()
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = r0.get(r1)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            java.util.Map r2 = r4.getPayload()
            java.lang.Object r1 = r2.get(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            java.util.List<com.blueair.core.model.AnalyticEvent$OnboardingLogEvent> r0 = r3.logEvents
            r0.add(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel.addLogEvent(com.blueair.core.model.AnalyticEvent$OnboardingLogEvent):void");
    }

    private final void sendLogEvents() {
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent;
        if (this.logEvents.size() > 0 && (onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents)) != null && !isStepError(onboardingLogEvent) && !Intrinsics.areEqual(onboardingLogEvent.getPayload().get("step"), (Object) 5)) {
            addLogEvent(new AnalyticEvent.OnboardingLogEvent.ScreenStayEvent(this.logSessionUuid, this.stayScreenName, (int) ((System.currentTimeMillis() - this.stayScreenStartTime) / ((long) 1000)), (String) null, 8, (DefaultConstructorMarker) null));
        }
        for (AnalyticEvent.OnboardingLogEvent event : this.logEvents) {
            getAnalyticsService().event(event);
        }
        this.logEvents.clear();
        this.wifiListRefreshCount = 0;
    }

    private final boolean isStepSuccess(String str) {
        return Intrinsics.areEqual((Object) str, (Object) "success");
    }

    private final boolean isStepError(AnalyticEvent.OnboardingLogEvent onboardingLogEvent) {
        if (onboardingLogEvent == null) {
            return false;
        }
        Iterable values = onboardingLogEvent.getPayload().values();
        if ((values instanceof Collection) && ((Collection) values).isEmpty()) {
            return false;
        }
        for (Object next : values) {
            if ((next instanceof String) && StringsKt.startsWith$default((String) next, AnalyticEvent.OnboardingLogEvent.RESULT_FAILED, false, 2, (Object) null) && !Intrinsics.areEqual(next, (Object) "failed: unknown")) {
                return true;
            }
        }
        return false;
    }

    private final void uploadOnboardingLog(String str) {
        if (str.length() != 0 && isStepError((AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AddDeviceViewModel$uploadOnboardingLog$1(this, str, (Continuation<? super AddDeviceViewModel$uploadOnboardingLog$1>) null), 2, (Object) null);
        }
    }

    public final void logStep0SelectDevice(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        sendLogEvents();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.logSessionUuid = uuid;
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.SelectDevice(this.logSessionUuid, bluetoothDevice.getSku(), bluetoothDevice.getWifiMac(), bluetoothDevice.getFamilyName(), bluetoothDevice.getModelName(), (String) null, 32, (DefaultConstructorMarker) null));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep0SelectDevice: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
    }

    public final void logStep1ConnectionInstructions(BluetoothDevice bluetoothDevice, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        Intrinsics.checkNotNullParameter(str, "connectType");
        if (bluetoothDevice.getAutoButtonPressNeeded()) {
            str2 = bluetoothDevice.getHasNoAutoButton() ? AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN : "auto";
        } else {
            str2 = AnalyticEvent.OnboardingLogEvent.TYPE_NULL;
        }
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.ConnectInstructions(this.logSessionUuid, str2, str, (String) null, 8, (DefaultConstructorMarker) null));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep1ConnectionInstructions: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
    }

    public static /* synthetic */ void logStep2Connecting$default(AddDeviceViewModel addDeviceViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        addDeviceViewModel.logStep2Connecting(str, str2, str3);
    }

    public final void logStep2Connecting(String str, String str2, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(str, "bleEstablishSession");
        Intrinsics.checkNotNullParameter(str2, "bleStartProvision");
        Intrinsics.checkNotNullParameter(str3, "extra");
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.Connecting(this.logSessionUuid, str, str2, str3));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep2Connecting: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
        if (!isStepSuccess(str)) {
            str4 = this.logSessionUuid + ": step 2 connecting: bleEstablishSession: " + str;
        } else if (!isStepSuccess(str2)) {
            str4 = this.logSessionUuid + ": step 2 connecting: bleStartProvision: " + str2;
        } else {
            str4 = "";
        }
        uploadOnboardingLog(str4);
    }

    public static /* synthetic */ void logStep3WifiList$default(AddDeviceViewModel addDeviceViewModel, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        addDeviceViewModel.logStep3WifiList(i, i2, str);
    }

    public final void logStep3WifiList(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "extra");
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.WifiList(this.logSessionUuid, i, i2, str));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep3WifiList: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
    }

    public static /* synthetic */ void logStep4WifiPassword$default(AddDeviceViewModel addDeviceViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        addDeviceViewModel.logStep4WifiPassword(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? "" : str7);
    }

    public final void logStep4WifiPassword(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        Intrinsics.checkNotNullParameter(str, "cloudRegion");
        Intrinsics.checkNotNullParameter(str2, "registerForOnboarding");
        Intrinsics.checkNotNullParameter(str3, "bleConfigProvision");
        Intrinsics.checkNotNullParameter(str4, "bleConfigWifi");
        Intrinsics.checkNotNullParameter(str5, "bleApplyWifi");
        Intrinsics.checkNotNullParameter(str6, "blePollWifiConnected");
        String str9 = str7;
        Intrinsics.checkNotNullParameter(str9, "extra");
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.WifiPassword(this.logSessionUuid, str, str2, str3, str4, str5, str6, str9));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep4WifiPassword: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
        if (!isStepSuccess(str2)) {
            str8 = this.logSessionUuid + ": step 4 wifi_password: registerForOnboarding: " + str2;
        } else if (!isStepSuccess(str3)) {
            str8 = this.logSessionUuid + ": step 4 wifi_password: bleConfigProvision: " + str3;
        } else if (!isStepSuccess(str4)) {
            str8 = this.logSessionUuid + ": step 4 wifi_password: bleConfigWifi: " + str4;
        } else if (!isStepSuccess(str5)) {
            str8 = this.logSessionUuid + ": step 4 wifi_password: bleApplyWifi: " + str5;
        } else {
            str8 = "";
        }
        uploadOnboardingLog(str8);
    }

    public static /* synthetic */ void logStep5OnboardingSuccess$default(AddDeviceViewModel addDeviceViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        addDeviceViewModel.logStep5OnboardingSuccess(str);
    }

    public final void logStep5OnboardingSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "extra");
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.Onboarding(this.logSessionUuid, "success", str));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep5OnboardingSuccess: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
    }

    public static /* synthetic */ void logStep5OnboardingFailure$default(AddDeviceViewModel addDeviceViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        addDeviceViewModel.logStep5OnboardingFailure(str);
    }

    public final void logStep5OnboardingFailure(String str) {
        Intrinsics.checkNotNullParameter(str, "extra");
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        String stateResult = bleDeviceService == null ? "failed: null BleDeviceService" : getStateResult(bleDeviceService, BleDeviceState.Bounded.INSTANCE);
        addLogEvent(new AnalyticEvent.OnboardingLogEvent.Onboarding(this.logSessionUuid, stateResult, str));
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("logStep5OnboardingFailure: ");
        AnalyticEvent.OnboardingLogEvent onboardingLogEvent = (AnalyticEvent.OnboardingLogEvent) CollectionsKt.lastOrNull(this.logEvents);
        sb.append(onboardingLogEvent != null ? onboardingLogEvent.getPayload() : null);
        forest.d(sb.toString(), new Object[0]);
        uploadOnboardingLog(this.logSessionUuid + ": step 5 onboarding: ble_poll_device_bound: " + stateResult);
    }

    public final void recordResume(String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        if (!Intrinsics.areEqual((Object) this.stayScreenName, (Object) str)) {
            this.stayScreenName = str;
            this.stayScreenStartTime = System.currentTimeMillis();
        }
    }

    private final String getStateResult(BleDeviceService bleDeviceService, BleDeviceState bleDeviceState) {
        if (bleDeviceService.getState().getCode() >= bleDeviceState.getCode()) {
            return "success";
        }
        BleDeviceError error = bleDeviceService.getError();
        String str = "unknown";
        if (error != null && error.getStateOccurred().getCode() <= bleDeviceState.getCode()) {
            str = error.getStateOccurred().getName() + ", " + error.getMessage();
        }
        return "failed: " + str;
    }

    public final void showConnectionLost() {
        getActionPublisher().onNext(AddDeviceAction.ShowConnectionLost);
    }

    public final void restart() {
        getActionPublisher().onNext(AddDeviceAction.Restart);
    }

    public final void clearOnboardedDevices() {
        this.onboardedDevices = null;
    }

    public final void reset() {
        Timber.Forest.d("reset: selectedBleDeviceService", new Object[0]);
        this.selectedSsid.setValue(null);
        this._isRefreshingSsids.setValue(false);
        this.password = "";
        this.hasSharedError = false;
        deselectBluetoothDevice();
        stopBluetoothScanning();
        getBleScanningService().reset();
    }

    public final void resetScanResult() {
        getBleScanningService().resetResult();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        Timber.Forest.v("onCleared", new Object[0]);
        super.onCleared();
        sendLogEvents();
        reset();
    }

    public final void disableSoftAp() {
        DeviceG4 value = this.onboardingDevice.getValue();
        if (value != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceViewModel$disableSoftAp$1$1(this, value, (Continuation<? super AddDeviceViewModel$disableSoftAp$1$1>) null), 3, (Object) null);
        }
    }

    public final void gotoWifiList() {
        this.currentScreen.setValue(AddDeviceScreen.WifiList);
        BaseViewModel.showProgress$default(this, false, 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0182, code lost:
        if (kotlinx.coroutines.DelayKt.delay(3000, r2) == r3) goto L_0x03ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01ab, code lost:
        if (r5 != r3) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object provisionSelectedBleDevice(kotlin.coroutines.Continuation<? super java.lang.Boolean> r63) {
        /*
            r62 = this;
            r0 = r62
            r1 = r63
            boolean r2 = r1 instanceof com.blueair.adddevice.viewmodel.AddDeviceViewModel$provisionSelectedBleDevice$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$provisionSelectedBleDevice$1 r2 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$provisionSelectedBleDevice$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$provisionSelectedBleDevice$1 r2 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$provisionSelectedBleDevice$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 0
            r9 = 2
            r10 = 1
            r11 = 0
            if (r4 == 0) goto L_0x00e6
            if (r4 == r10) goto L_0x00cd
            if (r4 == r9) goto L_0x00b2
            if (r4 == r7) goto L_0x0091
            if (r4 == r6) goto L_0x0067
            if (r4 != r5) goto L_0x005f
            int r3 = r2.I$0
            java.lang.Object r3 = r2.L$7
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r3 = r2.L$6
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r3 = r2.L$5
            com.blueair.bluetooth.service.ProvisionConfig r3 = (com.blueair.bluetooth.service.ProvisionConfig) r3
            java.lang.Object r3 = r2.L$4
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.L$3
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r4 = r2.L$2
            io.flatcircle.coroutinehelper.ApiResult r4 = (io.flatcircle.coroutinehelper.ApiResult) r4
            java.lang.Object r4 = r2.L$1
            com.blueair.core.model.DeviceG4 r4 = (com.blueair.core.model.DeviceG4) r4
            java.lang.Object r2 = r2.L$0
            com.blueair.bluetooth.service.BleDeviceService r2 = (com.blueair.bluetooth.service.BleDeviceService) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x03ae
        L_0x005f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0067:
            int r4 = r2.I$0
            java.lang.Object r6 = r2.L$7
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.L$6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.L$5
            com.blueair.bluetooth.service.ProvisionConfig r8 = (com.blueair.bluetooth.service.ProvisionConfig) r8
            java.lang.Object r9 = r2.L$4
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.L$3
            kotlin.Pair r10 = (kotlin.Pair) r10
            java.lang.Object r12 = r2.L$2
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            java.lang.Object r13 = r2.L$1
            com.blueair.core.model.DeviceG4 r13 = (com.blueair.core.model.DeviceG4) r13
            java.lang.Object r14 = r2.L$0
            com.blueair.bluetooth.service.BleDeviceService r14 = (com.blueair.bluetooth.service.BleDeviceService) r14
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x008c:
            r5 = r4
            r4 = r2
            r2 = r14
            goto L_0x0371
        L_0x0091:
            int r4 = r2.I$0
            java.lang.Object r7 = r2.L$5
            com.blueair.bluetooth.service.ProvisionConfig r7 = (com.blueair.bluetooth.service.ProvisionConfig) r7
            java.lang.Object r9 = r2.L$4
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.L$3
            kotlin.Pair r10 = (kotlin.Pair) r10
            java.lang.Object r12 = r2.L$2
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            java.lang.Object r13 = r2.L$1
            com.blueair.core.model.DeviceG4 r13 = (com.blueair.core.model.DeviceG4) r13
            java.lang.Object r14 = r2.L$0
            com.blueair.bluetooth.service.BleDeviceService r14 = (com.blueair.bluetooth.service.BleDeviceService) r14
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = r7
            r7 = r1
            goto L_0x0301
        L_0x00b2:
            int r4 = r2.I$1
            int r12 = r2.I$0
            java.lang.Object r12 = r2.L$3
            kotlin.Pair r12 = (kotlin.Pair) r12
            java.lang.Object r12 = r2.L$2
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            java.lang.Object r12 = r2.L$1
            com.blueair.core.model.DeviceG4 r12 = (com.blueair.core.model.DeviceG4) r12
            java.lang.Object r13 = r2.L$0
            com.blueair.bluetooth.service.BleDeviceService r13 = (com.blueair.bluetooth.service.BleDeviceService) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r1
        L_0x00ca:
            r15 = r12
            goto L_0x01af
        L_0x00cd:
            int r4 = r2.I$1
            int r12 = r2.I$0
            java.lang.Object r13 = r2.L$3
            kotlin.Pair r13 = (kotlin.Pair) r13
            java.lang.Object r14 = r2.L$2
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.core.model.DeviceG4 r15 = (com.blueair.core.model.DeviceG4) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.bluetooth.service.BleDeviceService r5 = (com.blueair.bluetooth.service.BleDeviceService) r5
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0186
        L_0x00e6:
            kotlin.ResultKt.throwOnFailure(r1)
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.String r4 = "provisionSelectedBleDevice"
            java.lang.Object[] r5 = new java.lang.Object[r11]
            r1.d(r4, r5)
            com.blueair.bluetooth.service.BleDeviceService r1 = r0.selectedBleDeviceService
            if (r1 != 0) goto L_0x00fb
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r1
        L_0x00fb:
            com.blueair.core.model.DeviceG4 r12 = new com.blueair.core.model.DeviceG4
            r59 = 4095(0xfff, float:5.738E-42)
            r60 = 0
            java.lang.String r13 = ""
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = -2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            r5 = r1
            r13 = r8
            r14 = r13
            r4 = r11
            r15 = r12
            r12 = r4
        L_0x0162:
            if (r4 >= r9) goto L_0x01d3
            if (r4 <= 0) goto L_0x0186
            r2.L$0 = r5
            r2.L$1 = r15
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r2.L$2 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r2.L$3 = r1
            r2.I$0 = r12
            r2.I$1 = r4
            r2.label = r10
            r6 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r6, r2)
            if (r6 != r3) goto L_0x0186
            goto L_0x03ac
        L_0x0186:
            r6 = r13
            r13 = r5
            r5 = r12
            r12 = r15
            com.blueair.devicemanager.DeviceManager r7 = r0.getDeviceManager()
            r15 = r12
            com.blueair.core.model.Device r15 = (com.blueair.core.model.Device) r15
            r2.L$0 = r13
            r2.L$1 = r12
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r2.L$2 = r14
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r2.L$3 = r6
            r2.I$0 = r5
            r2.I$1 = r4
            r2.label = r9
            java.lang.Object r5 = r7.getRandForDevice(r15, r2)
            if (r5 != r3) goto L_0x00ca
            goto L_0x03ac
        L_0x01af:
            r14 = r5
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            java.lang.Object r5 = r14.getOrNull()
            kotlin.Pair r5 = (kotlin.Pair) r5
            if (r5 == 0) goto L_0x01c3
            boolean r6 = r14.isFailure()
            if (r6 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01c1:
            r12 = r11
            goto L_0x01c4
        L_0x01c3:
            r12 = r10
        L_0x01c4:
            if (r12 != 0) goto L_0x01cc
            r61 = r13
            r13 = r5
            r5 = r61
            goto L_0x01d3
        L_0x01cc:
            int r4 = r4 + r10
            r6 = r13
            r13 = r5
            r5 = r6
            r6 = 4
            r7 = 3
            goto L_0x0162
        L_0x01d3:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "provisionSelectedBleDevice: randResultValue = "
            r6.<init>(r7)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r4.d(r6, r7)
            com.blueair.auth.GigyaService r4 = r0.getGigyaService()
            com.blueair.auth.BlueCloudDomain r4 = r4.getBlueCloudDomain()
            java.lang.String r4 = r4.tag()
            if (r12 == 0) goto L_0x024f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            java.lang.Throwable r1 = r14.exceptionOrNull()
            if (r1 == 0) goto L_0x0205
            java.lang.String r1 = r1.getMessage()
            if (r1 != 0) goto L_0x0207
        L_0x0205:
            java.lang.String r1 = ""
        L_0x0207:
            com.blueair.core.service.AnalyticsService r2 = r0.getAnalyticsService()
            com.blueair.core.model.AnalyticEvent$BT_REGISTER_ONBOARDING_ERROR r3 = new com.blueair.core.model.AnalyticEvent$BT_REGISTER_ONBOARDING_ERROR
            r3.<init>(r1)
            com.blueair.core.model.AnalyticEvent r3 = (com.blueair.core.model.AnalyticEvent) r3
            r2.event(r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Fail register for onboarding API -- "
            r2.<init>(r3)
            java.lang.Throwable r3 = r14.exceptionOrNull()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r5.sideLoadError(r2)
            r0.isRandRegisterFailed = r10
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "failed: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r8 = 64
            r9 = 0
            java.lang.String r3 = ""
            r1 = r4
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r7 = 0
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r1
        L_0x024f:
            r0.isRandRegisterFailed = r11
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.Object r6 = r13.getFirst()
            java.lang.String r6 = (java.lang.String) r6
            r0.rand = r6
            java.lang.Object r6 = r13.getSecond()
            java.lang.String r6 = (java.lang.String) r6
            r0.text = r6
            com.blueair.auth.AuthService r6 = r0.getAuthService()
            java.lang.String r6 = r6.getBlueHomeHost()
            java.lang.String r7 = "/"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r6, r7, r11, r9, r8)
            if (r7 == 0) goto L_0x0282
            int r7 = r6.length()
            int r7 = r7 - r10
            java.lang.String r6 = r6.substring(r11, r7)
            java.lang.String r7 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
        L_0x0282:
            r18 = r6
            com.blueair.auth.AuthService r6 = r0.getAuthService()
            java.lang.String r6 = r6.getBlueHomeHost()
            android.net.Uri r6 = android.net.Uri.parse(r6)
            android.net.Uri$Builder r6 = r6.buildUpon()
            java.lang.String r7 = "c"
            android.net.Uri$Builder r6 = r6.appendPath(r7)
            java.lang.String r7 = "authenticate"
            android.net.Uri$Builder r6 = r6.appendPath(r7)
            android.net.Uri r6 = r6.build()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.blueair.auth.AuthService r7 = r0.getAuthService()
            java.lang.String r20 = r7.getBlueBrokerURL()
            com.blueair.auth.GigyaService r7 = r0.getGigyaService()
            com.blueair.auth.BlueCloudDomain r7 = r7.getBlueCloudDomain()
            java.lang.String r21 = r7.getRegionCode()
            java.lang.String r7 = r0.rand
            java.lang.String r9 = r0.text
            com.blueair.bluetooth.service.ProvisionConfig r17 = new com.blueair.bluetooth.service.ProvisionConfig
            r19 = r6
            r23 = r7
            r22 = r9
            r17.<init>(r18, r19, r20, r21, r22, r23)
            r6 = r17
            r2.L$0 = r5
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r2.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r2.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r2.L$3 = r7
            r2.L$4 = r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r2.L$5 = r7
            r2.I$0 = r12
            r7 = 3
            r2.label = r7
            java.lang.Object r7 = r5.configureProvisionSync(r6, r2)
            if (r7 != r3) goto L_0x02fb
            goto L_0x03ac
        L_0x02fb:
            r9 = r4
            r4 = r12
            r10 = r13
            r12 = r14
            r13 = r15
            r14 = r5
        L_0x0301:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r5 = r7.booleanValue()
            if (r5 == 0) goto L_0x0402
            androidx.lifecycle.MutableLiveData<com.blueair.core.model.Ssid> r5 = r0.selectedSsid
            java.lang.Object r5 = r5.getValue()
            com.blueair.core.model.Ssid r5 = (com.blueair.core.model.Ssid) r5
            if (r5 == 0) goto L_0x0317
            java.lang.String r8 = r5.getSsid()
        L_0x0317:
            java.lang.String r5 = r0.password
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "provisionSelectedBleDevice: ssid = "
            r15.<init>(r1)
            r15.append(r8)
            java.lang.String r1 = "}, password = "
            r15.append(r1)
            r15.append(r5)
            java.lang.String r1 = r15.toString()
            java.lang.Object[] r15 = new java.lang.Object[r11]
            r7.d(r1, r15)
            if (r8 == 0) goto L_0x03ed
            r2.L$0 = r14
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r2.L$1 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$2 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r2.L$3 = r1
            r2.L$4 = r9
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r2.L$5 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r2.L$7 = r1
            r2.I$0 = r4
            r1 = 4
            r2.label = r1
            java.lang.Object r1 = r14.configureWifiSync(r8, r5, r2)
            if (r1 != r3) goto L_0x036c
            goto L_0x03ac
        L_0x036c:
            r7 = r8
            r8 = r6
            r6 = r5
            goto L_0x008c
        L_0x0371:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x03d4
            r4.L$0 = r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$1 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r4.L$2 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$3 = r1
            r4.L$4 = r9
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r4.L$5 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r4.L$6 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r4.L$7 = r1
            r4.I$0 = r5
            r1 = 5
            r4.label = r1
            java.lang.Object r1 = r2.applyWifiConfigSync(r4)
            if (r1 != r3) goto L_0x03ad
        L_0x03ac:
            return r3
        L_0x03ad:
            r3 = r9
        L_0x03ae:
            r10 = r1
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
            if (r1 != 0) goto L_0x03cf
            com.blueair.bluetooth.service.BleDeviceState$WifiConfigApplied r1 = com.blueair.bluetooth.service.BleDeviceState.WifiConfigApplied.INSTANCE
            com.blueair.bluetooth.service.BleDeviceState r1 = (com.blueair.bluetooth.service.BleDeviceState) r1
            java.lang.String r5 = r0.getStateResult(r2, r1)
            r8 = 64
            r9 = 0
            java.lang.String r2 = "success"
            r1 = r3
            java.lang.String r3 = "success"
            java.lang.String r4 = "success"
            java.lang.String r6 = ""
            r7 = 0
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x03cf:
            boolean r11 = r10.booleanValue()
            goto L_0x041a
        L_0x03d4:
            com.blueair.bluetooth.service.BleDeviceState$WifiConfigured r1 = com.blueair.bluetooth.service.BleDeviceState.WifiConfigured.INSTANCE
            com.blueair.bluetooth.service.BleDeviceState r1 = (com.blueair.bluetooth.service.BleDeviceState) r1
            java.lang.String r4 = r0.getStateResult(r2, r1)
            r8 = 64
            r1 = r9
            r9 = 0
            java.lang.String r2 = "success"
            java.lang.String r3 = "success"
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r7 = 0
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x041a
        L_0x03ed:
            r8 = 64
            r1 = r9
            r9 = 0
            java.lang.String r2 = "success"
            java.lang.String r3 = "success"
            java.lang.String r4 = "failed: null ssid"
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r7 = 0
            r0 = r62
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x041a
        L_0x0402:
            r1 = r9
            com.blueair.bluetooth.service.BleDeviceState$ProvisioningConfigured5 r2 = com.blueair.bluetooth.service.BleDeviceState.ProvisioningConfigured5.INSTANCE
            com.blueair.bluetooth.service.BleDeviceState r2 = (com.blueair.bluetooth.service.BleDeviceState) r2
            java.lang.String r3 = r0.getStateResult(r14, r2)
            r8 = 64
            r9 = 0
            java.lang.String r2 = "success"
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r7 = 0
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x041a:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel.provisionSelectedBleDevice(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object pollwifiConnected(kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            r11 = this;
            boolean r2 = r12 instanceof com.blueair.adddevice.viewmodel.AddDeviceViewModel$pollwifiConnected$1
            if (r2 == 0) goto L_0x0014
            r2 = r12
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$pollwifiConnected$1 r2 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$pollwifiConnected$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0014
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$pollwifiConnected$1 r2 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$pollwifiConnected$1
            r2.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r3 = r2.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.L$0
            com.blueair.bluetooth.service.BleDeviceService r2 = (com.blueair.bluetooth.service.BleDeviceService) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0074
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.bluetooth.service.BleDeviceService r1 = r11.selectedBleDeviceService
            com.blueair.auth.GigyaService r4 = r11.getGigyaService()
            com.blueair.auth.BlueCloudDomain r4 = r4.getBlueCloudDomain()
            java.lang.String r4 = r4.tag()
            if (r1 != 0) goto L_0x0062
            r8 = 64
            r9 = 0
            java.lang.String r2 = "success"
            java.lang.String r3 = "success"
            r1 = r4
            java.lang.String r4 = "success"
            java.lang.String r5 = "success"
            java.lang.String r6 = "failed: null BleDeviceService"
            r7 = 0
            r0 = r11
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            goto L_0x00ae
        L_0x0062:
            r0 = r4
            r2.L$0 = r1
            r2.L$1 = r0
            r2.label = r5
            java.lang.Object r2 = r1.pollWifiConnectionStatus(r2)
            if (r2 != r3) goto L_0x0070
            return r3
        L_0x0070:
            r3 = r2
            r2 = r1
            r1 = r3
            r3 = r0
        L_0x0074:
            r10 = r1
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r0 = r10.booleanValue()
            if (r0 == 0) goto L_0x0091
            r8 = 64
            r9 = 0
            java.lang.String r2 = "success"
            r1 = r3
            java.lang.String r3 = "success"
            java.lang.String r4 = "success"
            java.lang.String r5 = "success"
            java.lang.String r6 = "success"
            r7 = 0
            r0 = r11
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x00aa
        L_0x0091:
            r1 = r3
            com.blueair.bluetooth.service.BleDeviceState$PollingWifiConfigStatus r3 = com.blueair.bluetooth.service.BleDeviceState.PollingWifiConfigStatus.INSTANCE
            com.blueair.bluetooth.service.BleDeviceState r3 = (com.blueair.bluetooth.service.BleDeviceState) r3
            java.lang.String r6 = r11.getStateResult(r2, r3)
            r8 = 64
            r9 = 0
            java.lang.String r2 = "success"
            java.lang.String r3 = "success"
            java.lang.String r4 = "success"
            java.lang.String r5 = "success"
            r7 = 0
            r0 = r11
            logStep4WifiPassword$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x00aa:
            boolean r0 = r10.booleanValue()
        L_0x00ae:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel.pollwifiConnected(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void pollDeviceBounded() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceViewModel$pollDeviceBounded$1(this, (Continuation<? super AddDeviceViewModel$pollDeviceBounded$1>) null), 3, (Object) null);
    }

    public final void refreshSsidsList() {
        if (!this._isRefreshingSsids.getValue().booleanValue()) {
            if (!Intrinsics.areEqual((Object) isSelectedBleDeviceConnected(), (Object) true)) {
                showConnectionLost();
                return;
            }
            this._isRefreshingSsids.setValue(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AddDeviceViewModel$refreshSsidsList$1(this, (Continuation<? super AddDeviceViewModel$refreshSsidsList$1>) null), 2, (Object) null);
        }
    }

    public final void unbindNetwork(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Object systemService = activity.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).bindProcessToNetwork((Network) null);
    }

    public final void startBluetoothScanning() {
        Timber.Forest.d("startBluetoothScanning", new Object[0]);
        getBleScanningService().startScanning();
    }

    public final void stopBluetoothScanning() {
        Timber.Forest.d("stopBluetoothScanning", new Object[0]);
        getBleScanningService().stopScanning();
    }

    public static /* synthetic */ Observable selectBluetoothDevice$default(AddDeviceViewModel addDeviceViewModel, BluetoothDevice bluetoothDevice, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return addDeviceViewModel.selectBluetoothDevice(bluetoothDevice, z);
    }

    public final Observable<BleDeviceState> selectBluetoothDevice(BluetoothDevice bluetoothDevice, boolean z) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "uiDevice");
        if (z) {
            deselectBluetoothDevice();
        }
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        android.bluetooth.BluetoothDevice currentDevice = bleDeviceService != null ? bleDeviceService.getCurrentDevice() : null;
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("selectBluetoothDevice: old address = ");
        sb.append(currentDevice != null ? currentDevice.getAddress() : null);
        sb.append(", new address = ");
        sb.append(bluetoothDevice.getMac());
        forest.d(sb.toString(), new Object[0]);
        if (bleDeviceService == null || currentDevice == null || !Intrinsics.areEqual((Object) currentDevice.getAddress(), (Object) bluetoothDevice.getMac())) {
            deselectBluetoothDevice();
            BleScannedDevice scannedDevice = getBleScanningService().getScannedDevice(bluetoothDevice.getMac());
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("selectBluetoothDevice: scanDevice = " + scannedDevice, new Object[0]);
            if (scannedDevice != null) {
                BleDeviceService bleDeviceService2 = new BleDeviceService(scannedDevice.getDevice(), scannedDevice.getServiceUuid(), getApplication(), getAnalyticsService());
                this.selectedBleDeviceService = bleDeviceService2;
                this.selectedUiDevice = bluetoothDevice;
                Timber.Forest forest3 = Timber.Forest;
                forest3.d("selectBluetoothDevice: new selectedBleDeviceService = " + this.selectedBleDeviceService, new Object[0]);
                return bleDeviceService2.getDeviceStateObserver();
            }
            Timber.Forest forest4 = Timber.Forest;
            forest4.w("selectDevice: selected device " + bluetoothDevice.getMac() + " NOT FOUND", new Object[0]);
            return null;
        }
        Timber.Forest forest5 = Timber.Forest;
        forest5.d("selectDevice: selected the same device " + bluetoothDevice.getMac(), new Object[0]);
        return bleDeviceService.getDeviceStateObserver();
    }

    public final void deselectBluetoothDevice() {
        Timber.Forest forest = Timber.Forest;
        forest.d("deselectBluetoothDevice: selectedBleDeviceService = " + this.selectedBleDeviceService, new Object[0]);
        BleDeviceService bleDeviceService = this.selectedBleDeviceService;
        if (bleDeviceService != null) {
            bleDeviceService.disconnect();
        }
        this.selectedBleDeviceService = null;
        this.selectedUiDevice = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connectAndEstablishSessionAndStartProvisioningForBleDeviceSync(kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.adddevice.viewmodel.AddDeviceViewModel$connectAndEstablishSessionAndStartProvisioningForBleDeviceSync$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$connectAndEstablishSessionAndStartProvisioningForBleDeviceSync$1 r0 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$connectAndEstablishSessionAndStartProvisioningForBleDeviceSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$connectAndEstablishSessionAndStartProvisioningForBleDeviceSync$1 r0 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$connectAndEstablishSessionAndStartProvisioningForBleDeviceSync$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.blueair.bluetooth.service.BleDeviceService r0 = (com.blueair.bluetooth.service.BleDeviceService) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0054
        L_0x002e:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r15)
            r14.stopBluetoothScanning()
            com.blueair.bluetooth.service.BleDeviceService r15 = r14.selectedBleDeviceService
            if (r15 != 0) goto L_0x0046
            r15 = 0
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r15
        L_0x0046:
            r0.L$0 = r15
            r0.label = r3
            java.lang.Object r0 = r15.connectAndEstablishSessionAndStartProvisioningSync(r0)
            if (r0 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r13 = r0
            r0 = r15
            r15 = r13
        L_0x0054:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0068
            r5 = 4
            r6 = 0
            java.lang.String r2 = "success"
            java.lang.String r3 = "success"
            r4 = 0
            r1 = r14
            logStep2Connecting$default(r1, r2, r3, r4, r5, r6)
            goto L_0x0080
        L_0x0068:
            r1 = r14
            com.blueair.bluetooth.service.BleDeviceState$SessionEstablished r2 = com.blueair.bluetooth.service.BleDeviceState.SessionEstablished.INSTANCE
            com.blueair.bluetooth.service.BleDeviceState r2 = (com.blueair.bluetooth.service.BleDeviceState) r2
            java.lang.String r8 = r14.getStateResult(r0, r2)
            com.blueair.bluetooth.service.BleDeviceState$ProvisioningConfigured5 r2 = com.blueair.bluetooth.service.BleDeviceState.ProvisioningConfigured5.INSTANCE
            com.blueair.bluetooth.service.BleDeviceState r2 = (com.blueair.bluetooth.service.BleDeviceState) r2
            java.lang.String r9 = r14.getStateResult(r0, r2)
            r11 = 4
            r12 = 0
            r10 = 0
            r7 = r1
            logStep2Connecting$default(r7, r8, r9, r10, r11, r12)
        L_0x0080:
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel.connectAndEstablishSessionAndStartProvisioningForBleDeviceSync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void gotoWifiPassword$default(AddDeviceViewModel addDeviceViewModel, Ssid ssid, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        addDeviceViewModel.gotoWifiPassword(ssid, z);
    }

    public final void gotoWifiPassword(Ssid ssid, boolean z) {
        Observable<BleDeviceState> computationThread;
        this.selectedSsid.setValue(ssid);
        this.isHiddenNetwork = z;
        if (!this.wifiStateListenerAdded) {
            this.wifiStateListenerAdded = true;
            Observable<BleDeviceState> selectedBleDeviceStateObserver = getSelectedBleDeviceStateObserver();
            if (!(selectedBleDeviceStateObserver == null || (computationThread = RxExtensionsKt.computationThread(selectedBleDeviceStateObserver)) == null)) {
                RxExtensionsKt.subscribeAndLogE(computationThread, new AddDeviceViewModel$$ExternalSyntheticLambda1(this));
            }
        }
        if (Intrinsics.areEqual((Object) ssid != null ? ssid.getAuth() : null, (Object) "Open")) {
            this.password = null;
            BaseViewModel.showProgress$default(this, false, 1, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new AddDeviceViewModel$gotoWifiPassword$2(this, (Continuation<? super AddDeviceViewModel$gotoWifiPassword$2>) null), 2, (Object) null);
            return;
        }
        this.currentScreen.setValue(AddDeviceScreen.WifiPassword);
    }

    /* access modifiers changed from: private */
    public static final Unit gotoWifiPassword$lambda$11(AddDeviceViewModel addDeviceViewModel, BleDeviceState bleDeviceState) {
        Intrinsics.checkNotNullParameter(bleDeviceState, "it");
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.WifiConnected.INSTANCE)) {
            addDeviceViewModel.pollDeviceBounded();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeOwnedDevice(com.blueair.core.model.BluetoothDevice r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.blueair.adddevice.viewmodel.AddDeviceViewModel$removeOwnedDevice$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$removeOwnedDevice$1 r0 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel$removeOwnedDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$removeOwnedDevice$1 r0 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$removeOwnedDevice$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r9 = r0.I$0
            java.lang.Object r9 = r0.L$1
            com.blueair.core.model.HasBlueCloudFunctions r9 = (com.blueair.core.model.HasBlueCloudFunctions) r9
            java.lang.Object r0 = r0.L$0
            com.blueair.core.model.BluetoothDevice r0 = (com.blueair.core.model.BluetoothDevice) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009b
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.List<? extends com.blueair.core.model.HasBlueCloudFunctions> r10 = r8.onboardedDevices
            if (r10 == 0) goto L_0x00ac
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0049:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r10.next()
            r4 = r2
            com.blueair.core.model.HasBlueCloudFunctions r4 = (com.blueair.core.model.HasBlueCloudFunctions) r4
            java.lang.String r4 = r4.getMac()
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r5)
            java.lang.String r5 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r6 = r9.getWifiMac()
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x0049
            goto L_0x007a
        L_0x0079:
            r2 = 0
        L_0x007a:
            r10 = r2
            com.blueair.core.model.HasBlueCloudFunctions r10 = (com.blueair.core.model.HasBlueCloudFunctions) r10
            if (r10 == 0) goto L_0x00ac
            com.blueair.devicemanager.DeviceManager r2 = r8.getDeviceManager()
            r4 = r10
            com.blueair.core.model.Device r4 = (com.blueair.core.model.Device) r4
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$0 = r9
            r0.L$1 = r10
            r9 = 0
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r9 = r2.removeDeviceWithLock(r4, r0)
            if (r9 != r1) goto L_0x009a
            return r1
        L_0x009a:
            r9 = r10
        L_0x009b:
            java.util.List<? extends com.blueair.core.model.HasBlueCloudFunctions> r10 = r8.onboardedDevices
            if (r10 == 0) goto L_0x00ac
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.List r10 = kotlin.collections.CollectionsKt.toMutableList(r10)
            if (r10 == 0) goto L_0x00ac
            r10.remove(r9)
            r8.onboardedDevices = r10
        L_0x00ac:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel.removeOwnedDevice(com.blueair.core.model.BluetoothDevice, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void gotoSuccessScreen() {
        this.currentScreen.setValue(AddDeviceScreen.Success);
    }

    public final void gotoEnterNameScreen() {
        DeviceType deviceType;
        BluetoothDevice bluetoothDevice = this.selectedUiDevice;
        if (!(bluetoothDevice == null || (deviceType = bluetoothDevice.getDeviceType()) == null || !deviceType.isNewPlatform())) {
            getHappyUserService().setG4NewBlueOnboardStamp(System.currentTimeMillis());
        }
        this.currentScreen.setValue(AddDeviceScreen.EnterDeviceName);
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final void setDeviceName(String str) {
        Intrinsics.checkNotNullParameter(str, "nuName");
        this._selectedDeviceName.setValue(str);
    }

    public static /* synthetic */ void blockNavigation$default(AddDeviceViewModel addDeviceViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        addDeviceViewModel.blockNavigation(z);
    }

    public final void blockNavigation(boolean z) {
        this.lvBlockNavigation.setValue(Boolean.valueOf(z));
    }

    public final void addDevice() {
        BluetoothDevice bluetoothDevice;
        HasSKU device;
        String detectedDeviceUuid = getDetectedDeviceUuid();
        CharSequence charSequence = detectedDeviceUuid;
        if (charSequence != null && charSequence.length() != 0 && (bluetoothDevice = this.selectedUiDevice) != null && (device = bluetoothDevice.toDevice(detectedDeviceUuid, detectedDeviceUuid)) != null) {
            getDeviceManager().addOrUpdateDevice(device);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel$Companion;", "", "<init>", "()V", "MAX_PROVISION_ATTEMPTS", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
