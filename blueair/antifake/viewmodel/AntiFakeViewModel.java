package com.blueair.antifake.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.api.restapi.AntiFakeResetResp;
import com.blueair.api.restapi.AntiFakeVerifyResult;
import com.blueair.bluetooth.model.BleScannedDevice;
import com.blueair.bluetooth.service.BleDeviceService;
import com.blueair.bluetooth.service.BleScanningService;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasSKU;
import com.blueair.core.util.PersistentObjectDelegate;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
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
   d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0090\u00012\u00020\u0001:\u0002\u0090\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010W\u001a\u00020XH\u0002J\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z020\u0012J\u001a\u0010[\u001a\u00020X2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010$J\u000e\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020\u0018J\u0006\u0010^\u001a\u00020XJ\u0006\u0010_\u001a\u00020XJ\u000e\u0010_\u001a\u00020X2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010`\u001a\u00020XJ\u0018\u0010a\u001a\u00020X2\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u0018H\u0002J\b\u0010d\u001a\u0004\u0018\u00010eJ\u0010\u0010f\u001a\u00020X2\b\u0010g\u001a\u0004\u0018\u00010\u0018J\u000e\u0010h\u001a\u00020X2\u0006\u0010\u001f\u001a\u00020iJ\u0006\u0010j\u001a\u00020XJ\u0006\u0010U\u001a\u00020XJ\u000e\u0010k\u001a\u00020XH\u0082@¢\u0006\u0002\u0010lJ\u0016\u0010h\u001a\u00020X2\u0006\u0010m\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010nJ\u0016\u0010o\u001a\u00020X2\u0006\u0010p\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010nJ\u0010\u0010q\u001a\u00020X2\u0006\u0010r\u001a\u00020\u0010H\u0002J\u0006\u0010s\u001a\u000208J\u0007\u0010\u008d\u0001\u001a\u00020XJ\u0007\u0010\u008e\u0001\u001a\u00020XJ\t\u0010\u008f\u0001\u001a\u00020XH\u0014R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0017\u001a\u0004\u0018\u00010$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR$\u0010.\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010'\"\u0004\b0\u00101R0\u00103\u001a\b\u0012\u0004\u0012\u00020\u0018022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001802@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00109\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001e\u0010<\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u001e\u0010>\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001bR\u001e\u0010@\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001bR\u001e\u0010B\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001bR\u001e\u0010D\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001bR\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0\u0012¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0014R\u0016\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0\u0012¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0014R\u001e\u0010U\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u001b\u0010t\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bu\u0010\tR\u001b\u0010w\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u000b\u001a\u0004\by\u0010zR\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010~\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b~\u0010;R\u001e\u0010\u007f\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010;RM\u0010\u0082\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0081\u00012\u0014\u0010\u0080\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0081\u00018B@BX\u0082\u008e\u0002¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R&\u0010\u0089\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020i020\u008a\u00018\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u0091\u0001"},
   d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "btConnectivityService", "Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "getBtConnectivityService", "()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "btConnectivityService$delegate", "Lkotlin/Lazy;", "connectivitySubscription", "Lio/reactivex/disposables/Disposable;", "_currentPage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "currentPage", "Landroidx/lifecycle/LiveData;", "getCurrentPage", "()Landroidx/lifecycle/LiveData;", "pageStack", "Ljava/util/Stack;", "value", "", "rawCode", "getRawCode", "()Ljava/lang/String;", "code", "getCode", "Lcom/blueair/core/model/HasSKU;", "device", "getDevice", "()Lcom/blueair/core/model/HasSKU;", "setDevice", "(Lcom/blueair/core/model/HasSKU;)V", "Lcom/blueair/core/model/DeviceFilterType;", "targetType", "getTargetType", "()Lcom/blueair/core/model/DeviceFilterType;", "Lcom/blueair/antifake/viewmodel/ScanResult;", "verifyResult", "getVerifyResult", "()Lcom/blueair/antifake/viewmodel/ScanResult;", "filterSku", "getFilterSku", "filterType", "getFilterType", "setFilterType", "(Lcom/blueair/core/model/DeviceFilterType;)V", "", "filterSupportedDeviceSku", "getFilterSupportedDeviceSku", "()Ljava/util/List;", "setFilterSupportedDeviceSku", "(Ljava/util/List;)V", "", "filterMismatch", "getFilterMismatch", "()Z", "deviceMismatch", "getDeviceMismatch", "resetDeviceSku", "getResetDeviceSku", "resetDeviceId", "getResetDeviceId", "resetDeviceWifiMac", "getResetDeviceWifiMac", "resetDeviceMac", "getResetDeviceMac", "resetDeviceType", "Lcom/blueair/core/model/DeviceType;", "getResetDeviceType", "()Lcom/blueair/core/model/DeviceType;", "resetDeviceFilterUsage", "", "resetFilterBluetoothCipherText", "_bluetoothResult", "Lcom/blueair/antifake/viewmodel/BluetoothResult;", "bluetoothResult", "getBluetoothResult", "_resetResult", "Lcom/blueair/antifake/viewmodel/ResetResult;", "resetResult", "getResetResult", "retryViaBluetooth", "getRetryViaBluetooth", "updateDeviceMismatch", "", "getLiveDevices", "Lcom/blueair/core/model/Device;", "init", "validateCode", "pRawCode", "retryValidateCode", "resetFilter", "retryResetFilterByWifi", "resetFilterByWifi", "deviceSku", "deviceId", "getFilterConfig", "Lcom/blueair/core/model/FilterConfig;", "scanBluetooth", "targetDeviceWifiMac", "resetFilterByBluetooth", "Lcom/blueair/core/model/BluetoothDevice;", "retryResetFilterByBluetooth", "connectBluetoothAndResetFilter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cipherText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logBluetoothResetResult", "result", "setPage", "page", "goBack", "bleConnectivityService", "getBleConnectivityService", "bleConnectivityService$delegate", "bleScanningService", "Lcom/blueair/bluetooth/service/BleScanningService;", "getBleScanningService", "()Lcom/blueair/bluetooth/service/BleScanningService;", "bleScanningService$delegate", "bleDeviceService", "Lcom/blueair/bluetooth/service/BleDeviceService;", "isBluetoothEnabled", "isBluetoothScanning", "<set-?>", "", "bleDeviceMacNameCache", "getBleDeviceMacNameCache", "()Ljava/util/Map;", "setBleDeviceMacNameCache", "(Ljava/util/Map;)V", "bleDeviceMacNameCache$delegate", "Lcom/blueair/core/util/PersistentObjectDelegate;", "bleDevicesFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getBleDevicesFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "startBluetoothScanning", "resetBluetoothScanning", "onCleared", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AntiFakeViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AntiFakeViewModel.class, "btConnectivityService", "getBtConnectivityService()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AntiFakeViewModel.class, "bleConnectivityService", "getBleConnectivityService()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AntiFakeViewModel.class, "bleScanningService", "getBleScanningService()Lcom/blueair/bluetooth/service/BleScanningService;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AntiFakeViewModel.class, "bleDeviceMacNameCache", "getBleDeviceMacNameCache()Ljava/util/Map;", 0)))};
   public static final String CUSTOMER_SUPPORT_TEL = "400-006-9693";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final MutableLiveData _bluetoothResult;
   private final MutableLiveData _currentPage;
   private final MutableLiveData _resetResult;
   private final Lazy bleConnectivityService$delegate;
   private final PersistentObjectDelegate bleDeviceMacNameCache$delegate;
   private BleDeviceService bleDeviceService;
   private final StateFlow bleDevicesFlow;
   private final Lazy bleScanningService$delegate;
   private final LiveData bluetoothResult;
   private final Lazy btConnectivityService$delegate;
   private String code;
   private Disposable connectivitySubscription;
   private final LiveData currentPage;
   private HasSKU device;
   private boolean deviceMismatch;
   private boolean filterMismatch;
   private String filterSku;
   private List filterSupportedDeviceSku;
   private DeviceFilterType filterType;
   private boolean isBluetoothScanning;
   private final Stack pageStack;
   private String rawCode;
   private int resetDeviceFilterUsage;
   private String resetDeviceId;
   private String resetDeviceMac;
   private String resetDeviceSku;
   private String resetDeviceWifiMac;
   private String resetFilterBluetoothCipherText;
   private final LiveData resetResult;
   private boolean retryViaBluetooth;
   private DeviceFilterType targetType;
   private ScanResult verifyResult;

   // $FF: synthetic method
   public static Unit $r8$lambda$Y2F7rt4PipKzJzs1PU2fA8Q3QeA(AntiFakeViewModel var0, Boolean var1) {
      return connectBluetoothAndResetFilter$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$v3d0VlCLj0MFDEWwlW9Qgh5wK8E(Function1 var0, Object var1) {
      connectBluetoothAndResetFilter$lambda$3(var0, var1);
   }

   public AntiFakeViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var4 = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, BluetoothConnectivityService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.btConnectivityService$delegate = var4.provideDelegate(this, var5[0]);
      MutableLiveData var6 = new MutableLiveData(AntiFakePage.CodeVerifying.INSTANCE);
      this._currentPage = var6;
      this.currentPage = (LiveData)var6;
      this.pageStack = new Stack();
      this.rawCode = "";
      this.code = "";
      this.verifyResult = ScanResult.INVALID;
      this.filterSku = "";
      this.filterType = DeviceFilterType.FILTER;
      this.filterSupportedDeviceSku = CollectionsKt.emptyList();
      this.resetDeviceSku = "";
      this.resetDeviceId = "";
      this.resetDeviceWifiMac = "";
      this.resetDeviceMac = "";
      this.resetDeviceFilterUsage = -1;
      this.resetFilterBluetoothCipherText = "";
      var6 = new MutableLiveData();
      this._bluetoothResult = var6;
      this.bluetoothResult = (LiveData)var6;
      var6 = new MutableLiveData();
      this._resetResult = var6;
      this.resetResult = (LiveData)var6;
      JVMTypeToken var9 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.bleConnectivityService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var9, BluetoothConnectivityService.class)), (Object)null).provideDelegate(this, var5[1]);
      var9 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.bleScanningService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var9, BleScanningService.class)), (Object)null).provideDelegate(this, var5[2]);
      this.bleDeviceMacNameCache$delegate = new PersistentObjectDelegate((Context)var1, "ble_device_mac_name_map_file", MapsKt.emptyMap(), (Type)Map.class, new Type[]{String.class, String.class});
      this.bleDevicesFlow = FlowKt.stateIn(new Flow(FlowKt.filterNotNull((Flow)this.getBleScanningService().getResultFlow()), this) {
         final Flow $this_unsafeTransform$inlined;
         final AntiFakeViewModel this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final AntiFakeViewModel this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  Object var4;
                  label54: {
                     if (var2 instanceof <undefinedtype>) {
                        var4 = (<undefinedtype>)var2;
                        if ((((<undefinedtype>)var4).label & Integer.MIN_VALUE) != 0) {
                           ((<undefinedtype>)var4).label += Integer.MIN_VALUE;
                           break label54;
                        }
                     }

                     var4 = new ContinuationImpl(this, var2) {
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

                  Object var18 = ((<undefinedtype>)var4).result;
                  Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var4).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var4).I$0;
                     FlowCollector var14 = (FlowCollector)((<undefinedtype>)var4).L$3;
                     Object var15 = ((<undefinedtype>)var4).L$2;
                     <undefinedtype> var16 = (<undefinedtype>)((<undefinedtype>)var4).L$1;
                     Object var17 = ((<undefinedtype>)var4).L$0;
                     ResultKt.throwOnFailure(var18);
                  } else {
                     ResultKt.throwOnFailure(var18);
                     FlowCollector var9 = this.$this_unsafeFlow;
                     Continuation var19 = (Continuation)var4;
                     Iterable var20 = (Iterable)((List)var1);
                     Collection var10 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var20, 10)));

                     for(BleScannedDevice var11 : var20) {
                        String var5 = var11.getDevice().getName();
                        String var6 = "";
                        String var21 = var5;
                        if (var5 == null) {
                           var21 = "";
                        }

                        var5 = var11.getDevice().getAddress();
                        if (var5 == null) {
                           var5 = "";
                        }

                        CharSequence var7 = (CharSequence)var21;
                        if (var7.length() > 0 && ((CharSequence)var5).length() > 0 && !Intrinsics.areEqual(this.this$0.getBleDeviceMacNameCache().get(var5), var21)) {
                           AntiFakeViewModel var13 = this.this$0;
                           var13.setBleDeviceMacNameCache(MapsKt.plus(var13.getBleDeviceMacNameCache(), TuplesKt.to(var5, var21)));
                        }

                        Object var22 = var7;
                        if (var7.length() == 0) {
                           var22 = (String)this.this$0.getBleDeviceMacNameCache().get(var5);
                           if (var22 == null) {
                              var22 = var6;
                           }
                        }

                        var10.add(new BluetoothDevice((String)var22, var5, var11.getConnectable(), (Boolean)null, 8, (DefaultConstructorMarker)null));
                     }

                     List var23 = (List)var10;
                     ((<undefinedtype>)var4).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var4).L$1 = SpillingKt.nullOutSpilledVariable(var4);
                     ((<undefinedtype>)var4).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var4).L$3 = SpillingKt.nullOutSpilledVariable(var9);
                     ((<undefinedtype>)var4).I$0 = 0;
                     ((<undefinedtype>)var4).label = 1;
                     if (var9.emit(var23, (Continuation)var4) == var8) {
                        return var8;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, ViewModelKt.getViewModelScope((ViewModel)this), SharingStarted.Companion.getLazily(), CollectionsKt.emptyList());
   }

   private final Object connectBluetoothAndResetFilter(Continuation var1) {
      Object var6;
      label136: {
         if (var1 instanceof <undefinedtype>) {
            var6 = (<undefinedtype>)var1;
            if ((((<undefinedtype>)var6).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var6).label += Integer.MIN_VALUE;
               break label136;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int I$0;
            Object L$0;
            Object L$1;
            boolean Z$0;
            int label;
            Object result;
            final AntiFakeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.connectBluetoothAndResetFilter((Continuation)this);
            }
         };
      }

      label126: {
         label125: {
            label124: {
               label153: {
                  BleDeviceService var5;
                  Object var8;
                  int var24;
                  boolean var28;
                  BleScannedDevice var36;
                  label154: {
                     label140: {
                        label141: {
                           var11 = ((<undefinedtype>)var6).result;
                           var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           switch (((<undefinedtype>)var6).label) {
                              case 0:
                                 ResultKt.throwOnFailure(var11);
                                 var36 = this.getBleScanningService().getScannedDevice(this.resetDeviceMac);
                                 if (var36 == null) {
                                    this._bluetoothResult.postValue(BluetoothResult.CONNECT_FAILED);
                                    ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                                    ((<undefinedtype>)var6).label = 1;
                                    if (this.logBluetoothResetResult("Bluetooth connection failed", (Continuation)var6) != var8) {
                                       return Unit.INSTANCE;
                                    }

                                    return var8;
                                 }

                                 BleDeviceService var13 = this.bleDeviceService;
                                 if (var13 != null) {
                                    var13.disconnect();
                                 }

                                 var5 = new BleDeviceService(var36.getDevice(), var36.getServiceUuid(), (Context)this.getApplication(), this.getAnalyticsService());
                                 this.bleDeviceService = var5;
                                 if (this.connectivitySubscription == null) {
                                    this.connectivitySubscription = this.getBtConnectivityService().getStateObserver().subscribe(new AntiFakeViewModel$$ExternalSyntheticLambda1(new AntiFakeViewModel$$ExternalSyntheticLambda0(this)));
                                 }

                                 ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                                 ((<undefinedtype>)var6).L$1 = var5;
                                 ((<undefinedtype>)var6).label = 2;
                                 var11 = var5.connectAndEstablishSessionSync((Continuation)var6);
                                 if (var11 == var8) {
                                    return var8;
                                 }
                                 break;
                              case 1:
                                 var36 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 return Unit.INSTANCE;
                              case 2:
                                 var5 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 var36 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break;
                              case 3:
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 var37 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 BleScannedDevice var7 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 var5 = (BleDeviceService)var11;
                                 var12 = var7;
                                 break label141;
                              case 4:
                                 var24 = ((<undefinedtype>)var6).I$0;
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 var5 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 var36 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break label140;
                              case 5:
                                 var24 = ((<undefinedtype>)var6).I$0;
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 var5 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 var36 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break label154;
                              case 6:
                                 var24 = ((<undefinedtype>)var6).I$0;
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 BleDeviceService var34 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 BleScannedDevice var35 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break label126;
                              case 7:
                                 var24 = ((<undefinedtype>)var6).I$0;
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 BleDeviceService var32 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 BleScannedDevice var33 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break label125;
                              case 8:
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 BleDeviceService var30 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 BleScannedDevice var31 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break label124;
                              case 9:
                                 var28 = ((<undefinedtype>)var6).Z$0;
                                 BleDeviceService var4 = (BleDeviceService)((<undefinedtype>)var6).L$1;
                                 BleScannedDevice var29 = (BleScannedDevice)((<undefinedtype>)var6).L$0;
                                 ResultKt.throwOnFailure(var11);
                                 break label153;
                              default:
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           var28 = (Boolean)var11;
                           if (!var28) {
                              this._bluetoothResult.postValue(BluetoothResult.CONNECT_FAILED);
                              ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                              ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var5);
                              ((<undefinedtype>)var6).Z$0 = var28;
                              ((<undefinedtype>)var6).label = 9;
                              if (this.logBluetoothResetResult("Bluetooth connection failed", (Continuation)var6) == var8) {
                                 return var8;
                              }
                              break label153;
                           }

                           if (((CharSequence)this.resetFilterBluetoothCipherText).length() != 0) {
                              this._bluetoothResult.postValue(BluetoothResult.SUCCESS);
                              String var19 = this.resetFilterBluetoothCipherText;
                              ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                              ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var5);
                              ((<undefinedtype>)var6).Z$0 = var28;
                              ((<undefinedtype>)var6).label = 8;
                              if (this.resetFilterByBluetooth(var19, (Continuation)var6) == var8) {
                                 return var8;
                              }
                              break label124;
                           }

                           DeviceFilterType var14 = this.filterType;
                           ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                           ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var5);
                           ((<undefinedtype>)var6).Z$0 = var28;
                           ((<undefinedtype>)var6).label = 3;
                           Object var15 = var5.readFilterSync(var14, (Continuation)var6);
                           if (var15 == var8) {
                              return var8;
                           }

                           BleDeviceService var43 = var5;
                           var5 = (BleDeviceService)var15;
                           var12 = var36;
                           var37 = var43;
                        }

                        var24 = ((Number)var5).intValue();
                        if (var24 < 0) {
                           this._bluetoothResult.postValue(BluetoothResult.READ_FILTER_FAILED);
                           ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var12);
                           ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var37);
                           ((<undefinedtype>)var6).Z$0 = var28;
                           ((<undefinedtype>)var6).I$0 = var24;
                           ((<undefinedtype>)var6).label = 7;
                           if (this.logBluetoothResetResult("Get consumable usage is fail", (Continuation)var6) == var8) {
                              return var8;
                           }
                           break label125;
                        }

                        this.resetDeviceFilterUsage = var24;
                        this._bluetoothResult.postValue(BluetoothResult.SUCCESS);
                        DeviceManager var9 = this.getDeviceManager();
                        String var42 = this.code;
                        String var44 = this.resetDeviceSku;
                        String var10 = this.resetDeviceWifiMac;
                        ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var12);
                        ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var37);
                        ((<undefinedtype>)var6).Z$0 = var28;
                        ((<undefinedtype>)var6).I$0 = var24;
                        ((<undefinedtype>)var6).label = 4;
                        Object var45 = var9.antiFakeResetByBluetooth(var42, var44, var10, var24, (Continuation)var6);
                        if (var45 == var8) {
                           return var8;
                        }

                        var5 = var37;
                        var36 = var12;
                        var11 = var45;
                     }

                     ApiResult var16 = (ApiResult)var11;
                     Function2 var46 = new Function2(this, (Continuation)null) {
                        Object L$0;
                        Object L$1;
                        int label;
                        final AntiFakeViewModel this$0;

                        {
                           this.this$0 = var1;
                        }

                        public final Continuation create(Object var1, Continuation var2) {
                           Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                           var3.L$0 = var1;
                           return (Continuation)var3;
                        }

                        public final Object invoke(AntiFakeResetResp var1, Continuation var2) {
                           return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           AntiFakeResetResp var4 = (AntiFakeResetResp)this.L$0;
                           Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           if (var2 != 0) {
                              if (var2 != 1 && var2 != 2 && var2 != 3) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResetResult var9 = (ResetResult)this.L$1;
                              ResultKt.throwOnFailure(var1);
                           } else {
                              ResultKt.throwOnFailure(var1);
                              ResetResult var8 = ResetResult.Companion.fromStatusCode(var4.getStatus());
                              if (var8 == ResetResult.SUCCESS) {
                                 CharSequence var10 = (CharSequence)var4.getCiphertext();
                                 if (var10 != null && var10.length() != 0) {
                                    AntiFakeViewModel var12 = this.this$0;
                                    String var15 = var4.getCiphertext();
                                    Intrinsics.checkNotNull(var15);
                                    var12.resetFilterBluetoothCipherText = var15;
                                    var12 = this.this$0;
                                    var15 = var12.resetFilterBluetoothCipherText;
                                    Continuation var7 = (Continuation)this;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(var8);
                                    this.label = 2;
                                    if (var12.resetFilterByBluetooth(var15, var7) == var3) {
                                       return var3;
                                    }
                                 } else {
                                    this.this$0._resetResult.postValue(ResetResult.INTERNAL_ERROR);
                                    AntiFakeViewModel var11 = this.this$0;
                                    Continuation var14 = (Continuation)this;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(var8);
                                    this.label = 1;
                                    if (var11.logBluetoothResetResult("Fail", var14) == var3) {
                                       return var3;
                                    }
                                 }
                              } else {
                                 this.this$0._resetResult.postValue(var8);
                                 AntiFakeViewModel var5 = this.this$0;
                                 Continuation var6 = (Continuation)this;
                                 this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                                 this.L$1 = SpillingKt.nullOutSpilledVariable(var8);
                                 this.label = 3;
                                 if (var5.logBluetoothResetResult("Fail", var6) == var3) {
                                    return var3;
                                 }
                              }
                           }

                           return Unit.INSTANCE;
                        }
                     };
                     ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                     ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var5);
                     ((<undefinedtype>)var6).Z$0 = var28;
                     ((<undefinedtype>)var6).I$0 = var24;
                     ((<undefinedtype>)var6).label = 5;
                     Object var47 = ApiResultKt.onSuccess(var16, var46, (Continuation)var6);
                     var11 = var47;
                     if (var47 == var8) {
                        return var8;
                     }
                  }

                  ApiResult var17 = (ApiResult)var11;
                  Function2 var48 = new Function2(this, (Continuation)null) {
                     int label;
                     final AntiFakeViewModel this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                     }

                     public final Object invoke(Throwable var1, Continuation var2) {
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
                           this.this$0._resetResult.postValue(ResetResult.INTERNAL_ERROR);
                           AntiFakeViewModel var4 = this.this$0;
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           if (var4.logBluetoothResetResult("Fail", var5) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                  ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  ((<undefinedtype>)var6).Z$0 = var28;
                  ((<undefinedtype>)var6).I$0 = var24;
                  ((<undefinedtype>)var6).label = 6;
                  if (ApiResultKt.onFail(var17, var48, (Continuation)var6) == var8) {
                     return var8;
                  }
                  break label126;
               }

               Unit var21 = Unit.INSTANCE;
               break label126;
            }

            Unit var20 = Unit.INSTANCE;
            break label126;
         }

         Unit var18 = Unit.INSTANCE;
      }

      BleDeviceService var22 = this.bleDeviceService;
      if (var22 != null) {
         var22.disconnect();
      }

      this.bleDeviceService = null;
      return Unit.INSTANCE;
   }

   private static final Unit connectBluetoothAndResetFilter$lambda$2(AntiFakeViewModel var0, Boolean var1) {
      if (!var1) {
         BleDeviceService var2 = var0.bleDeviceService;
         if (var2 != null) {
            var2.disconnect();
         }

         var0.bleDeviceService = null;
      }

      return Unit.INSTANCE;
   }

   private static final void connectBluetoothAndResetFilter$lambda$3(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final BluetoothConnectivityService getBleConnectivityService() {
      return (BluetoothConnectivityService)this.bleConnectivityService$delegate.getValue();
   }

   private final Map getBleDeviceMacNameCache() {
      return (Map)this.bleDeviceMacNameCache$delegate.getValue(this, $$delegatedProperties[3]);
   }

   private final BleScanningService getBleScanningService() {
      return (BleScanningService)this.bleScanningService$delegate.getValue();
   }

   private final Object logBluetoothResetResult(String var1, Continuation var2) {
      Object var3 = this.getDeviceManager().antiFakeLogBluetooth(this.code, this.resetDeviceSku, this.resetDeviceWifiMac, var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   private final Object resetFilterByBluetooth(String var1, Continuation var2) {
      label48: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var9 = var4;
               break label48;
            }
         }

         var9 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final AntiFakeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.resetFilterByBluetooth((String)null, (Continuation)this);
            }
         };
      }

      BleDeviceService var10 = (BleDeviceService)((<undefinedtype>)var9).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var9).label;
      if (var3 != 0) {
         if (var3 != 1) {
            if (var3 == 2) {
               var1 = (String)((<undefinedtype>)var9).L$0;
               ResultKt.throwOnFailure(var10);
               return Unit.INSTANCE;
            }

            if (var3 != 3) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var1 = (String)((<undefinedtype>)var9).L$0;
            ResultKt.throwOnFailure(var10);
            return Unit.INSTANCE;
         }

         var1 = (String)((<undefinedtype>)var9).L$0;
         ResultKt.throwOnFailure(var10);
      } else {
         ResultKt.throwOnFailure(var10);
         var10 = this.bleDeviceService;
         Intrinsics.checkNotNull(var10);
         ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var9).label = 1;
         Object var5 = var10.resetFilterSync(var1, (Continuation)var9);
         var10 = (BleDeviceService)var5;
         if (var5 == var6) {
            return var6;
         }
      }

      if ((Boolean)var10) {
         this._resetResult.postValue(ResetResult.SUCCESS);
         ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var9).label = 2;
         if (this.logBluetoothResetResult("Success", (Continuation)var9) != var6) {
            return Unit.INSTANCE;
         } else {
            return var6;
         }
      } else {
         this._resetResult.postValue(ResetResult.BLUETOOTH_FAILED);
         ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var9).label = 3;
         if (this.logBluetoothResetResult("Fail", (Continuation)var9) == var6) {
            return var6;
         } else {
            return Unit.INSTANCE;
         }
      }
   }

   private final void resetFilterByWifi(String var1, String var2) {
      this._resetResult.setValue((Object)null);
      this.resetDeviceSku = var1;
      this.resetDeviceId = var2;
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final String $deviceId;
         final String $deviceSku;
         int label;
         final AntiFakeViewModel this$0;

         {
            this.this$0 = var1;
            this.$deviceSku = var2;
            this.$deviceId = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceSku, this.$deviceId, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4;
            label32: {
               var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
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

                     ResultKt.throwOnFailure(var1);
                     break label32;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  var1 = this.this$0.getDeviceManager();
                  String var7 = this.this$0.getCode();
                  String var3 = this.$deviceSku;
                  String var6 = this.$deviceId;
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  Object var11 = var1.antiFakeResetByWifi(var7, var3, var6, var5);
                  var1 = (DeviceManager)var11;
                  if (var11 == var4) {
                     return var4;
                  }
               }

               ApiResult var15 = (ApiResult)var1;
               Function2 var12 = new Function2(this.this$0, (Continuation)null) {
                  Object L$0;
                  int label;
                  final AntiFakeViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                     var3.L$0 = var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(AntiFakeResetResp var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     AntiFakeResetResp var2 = (AntiFakeResetResp)this.L$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.this$0._resetResult.postValue(ResetResult.Companion.fromStatusCode(var2.getStatus()));
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var9 = (Continuation)this;
               this.label = 2;
               Object var13 = ApiResultKt.onSuccess(var15, var12, var9);
               var1 = (DeviceManager)var13;
               if (var13 == var4) {
                  return var4;
               }
            }

            ApiResult var10 = (ApiResult)var1;
            Function2 var14 = new Function2(this.this$0, (Continuation)null) {
               int label;
               final AntiFakeViewModel this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, var2));
               }

               public final Object invoke(Throwable var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.this$0._resetResult.postValue(ResetResult.INTERNAL_ERROR);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var16 = (Continuation)this;
            this.label = 3;
            if (ApiResultKt.onFail(var10, var14, var16) == var4) {
               return var4;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   private final void setBleDeviceMacNameCache(Map var1) {
      this.bleDeviceMacNameCache$delegate.setValue(this, $$delegatedProperties[3], var1);
   }

   private final void setDevice(HasSKU var1) {
      this.device = var1;
      this.updateDeviceMismatch();
   }

   private final void setFilterSupportedDeviceSku(List var1) {
      this.filterSupportedDeviceSku = var1;
      this.updateDeviceMismatch();
   }

   private final void setFilterType(DeviceFilterType var1) {
      this.filterType = var1;
      DeviceFilterType var4 = this.targetType;
      boolean var3 = false;
      boolean var2 = var3;
      if (var4 != null) {
         var2 = var3;
         if (var4 != var1) {
            var2 = true;
         }
      }

      this.filterMismatch = var2;
   }

   private final void setPage(AntiFakePage var1) {
      this._currentPage.postValue(var1);
      if (!Intrinsics.areEqual(var1, AntiFakePage.CodeVerifying.INSTANCE)) {
         if (!(var1 instanceof AntiFakePage.CodeVerifyResult) && !Intrinsics.areEqual(var1, AntiFakePage.ScanBluetooth.INSTANCE)) {
            if (Intrinsics.areEqual(var1, AntiFakePage.SelectDevice.INSTANCE)) {
               this.getBleScanningService().reset();
               this.pageStack.push(var1);
               return;
            }

            if (!(var1 instanceof AntiFakePage.ResetByWifi) && !(var1 instanceof AntiFakePage.ResetByBluetooth)) {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            this.pageStack.push(var1);
         }
      }

   }

   private final void updateDeviceMismatch() {
      HasSKU var2 = this.device;
      boolean var1;
      if (var2 != null) {
         var1 = CollectionsKt.contains((Iterable)this.filterSupportedDeviceSku, var2.getSku()) ^ true;
      } else {
         var1 = false;
      }

      this.deviceMismatch = var1;
   }

   public final StateFlow getBleDevicesFlow() {
      return this.bleDevicesFlow;
   }

   public final LiveData getBluetoothResult() {
      return this.bluetoothResult;
   }

   public final BluetoothConnectivityService getBtConnectivityService() {
      return (BluetoothConnectivityService)this.btConnectivityService$delegate.getValue();
   }

   public final String getCode() {
      return this.code;
   }

   public final LiveData getCurrentPage() {
      return this.currentPage;
   }

   public final HasSKU getDevice() {
      return this.device;
   }

   public final boolean getDeviceMismatch() {
      return this.deviceMismatch;
   }

   public final FilterConfig getFilterConfig() {
      return DeviceConfigProvider.INSTANCE.getFilterConfig(this.resetDeviceSku, this.filterType);
   }

   public final boolean getFilterMismatch() {
      return this.filterMismatch;
   }

   public final String getFilterSku() {
      return this.filterSku;
   }

   public final List getFilterSupportedDeviceSku() {
      return this.filterSupportedDeviceSku;
   }

   public final DeviceFilterType getFilterType() {
      return this.filterType;
   }

   public final LiveData getLiveDevices() {
      return this.getDeviceManager().getLiveDevices();
   }

   public final String getRawCode() {
      return this.rawCode;
   }

   public final String getResetDeviceId() {
      return this.resetDeviceId;
   }

   public final String getResetDeviceMac() {
      return this.resetDeviceMac;
   }

   public final String getResetDeviceSku() {
      return this.resetDeviceSku;
   }

   public final DeviceType getResetDeviceType() {
      return DeviceType.Companion.fromSkuCompat(this.resetDeviceSku);
   }

   public final String getResetDeviceWifiMac() {
      return this.resetDeviceWifiMac;
   }

   public final LiveData getResetResult() {
      return this.resetResult;
   }

   public final boolean getRetryViaBluetooth() {
      return this.retryViaBluetooth;
   }

   public final DeviceFilterType getTargetType() {
      return this.targetType;
   }

   public final ScanResult getVerifyResult() {
      return this.verifyResult;
   }

   public final boolean goBack() {
      if (this.pageStack.size() > 1) {
         AntiFakePage var1 = (AntiFakePage)this.pageStack.peek();
         if (!(var1 instanceof AntiFakePage.ResetByWifi) && !Intrinsics.areEqual(var1, AntiFakePage.ResetByBluetooth.INSTANCE)) {
            this.pageStack.pop();
            this._currentPage.postValue(this.pageStack.peek());
            return true;
         }
      }

      return false;
   }

   public final void init(HasSKU var1, DeviceFilterType var2) {
      this.setDevice(var1);
      this.targetType = var2;
   }

   public final boolean isBluetoothEnabled() {
      return this.getBleConnectivityService().isBluetoothEnabled();
   }

   public final boolean isBluetoothScanning() {
      return this.isBluetoothScanning;
   }

   protected void onCleared() {
      super.onCleared();
      Disposable var1 = this.connectivitySubscription;
      if (var1 != null) {
         var1.dispose();
      }

      this.connectivitySubscription = null;
      this.resetBluetoothScanning();
      BleDeviceService var2 = this.bleDeviceService;
      if (var2 != null) {
         var2.disconnect();
      }

      this.bleDeviceService = null;
   }

   public final void resetBluetoothScanning() {
      if (this.isBluetoothScanning) {
         Timber.Forest.d("resetBluetoothScanning", new Object[0]);
         this.isBluetoothScanning = false;
         this.getBleScanningService().stopScanning();
         this.getBleScanningService().reset();
      }
   }

   public final void resetFilter() {
      if (this.device == null) {
         this.setPage(AntiFakePage.SelectDevice.INSTANCE);
      } else {
         this.setPage(new AntiFakePage.ResetByWifi(1));
         HasSKU var1 = this.device;
         Intrinsics.checkNotNull(var1);
         String var3 = var1.getSku();
         Intrinsics.checkNotNull(var3);
         HasSKU var2 = this.device;
         Intrinsics.checkNotNull(var2);
         this.resetFilterByWifi(var3, var2.getUid());
      }
   }

   public final void resetFilter(HasSKU var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      String var2 = var1.getSku();
      Intrinsics.checkNotNull(var2);
      this.resetDeviceSku = var2;
      this.resetDeviceId = var1.getUid();
      this.resetDeviceWifiMac = var1.getMac();
      this.setPage(new AntiFakePage.ResetByWifi(2));
      this.resetFilterByWifi(this.resetDeviceSku, this.resetDeviceId);
   }

   public final void resetFilterByBluetooth(BluetoothDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.resetDeviceSku = var1.getSku();
      this.resetDeviceMac = var1.getMac();
      this.resetDeviceWifiMac = var1.getWifiMac();
      this.setPage(AntiFakePage.ResetByBluetooth.INSTANCE);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final AntiFakeViewModel this$0;

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
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               AntiFakeViewModel var4 = this.this$0;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var4.connectBluetoothAndResetFilter(var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void retryResetFilterByBluetooth() {
      this._bluetoothResult.setValue((Object)null);
      this._resetResult.setValue((Object)null);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final AntiFakeViewModel this$0;

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
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               AntiFakeViewModel var5 = this.this$0;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.connectBluetoothAndResetFilter(var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void retryResetFilterByWifi() {
      this.resetFilterByWifi(this.resetDeviceSku, this.resetDeviceId);
   }

   public final void retryValidateCode() {
      this.pageStack.pop();
      this.setPage(AntiFakePage.CodeVerifying.INSTANCE);
      this.validateCode(this.rawCode);
   }

   public final void retryViaBluetooth() {
      this.retryViaBluetooth = true;

      while(!((Collection)this.pageStack).isEmpty() && !SetsKt.setOf(new AntiFakePage[]{AntiFakePage.SelectDevice.INSTANCE, AntiFakePage.CodeVerifyResult.INSTANCE}).contains(this.pageStack.peek())) {
         this.pageStack.pop();
      }

      this._currentPage.setValue(this.pageStack.peek());
      this._bluetoothResult.setValue((Object)null);
      this._resetResult.setValue((Object)null);
   }

   public final void scanBluetooth(String var1) {
      String var2 = var1;
      if (var1 == null) {
         var2 = "";
      }

      this.resetDeviceWifiMac = var2;
      this.setPage(AntiFakePage.ScanBluetooth.INSTANCE);
   }

   public final void startBluetoothScanning() {
      if (!this.isBluetoothScanning) {
         Timber.Forest.d("startBluetoothScanning", new Object[0]);
         this.isBluetoothScanning = true;
         this.getBleScanningService().startScanning();
      }
   }

   public final void validateCode(String var1) {
      Intrinsics.checkNotNullParameter(var1, "pRawCode");
      var1 = StringsKt.trim((CharSequence)var1).toString();
      this.rawCode = var1;
      boolean var2;
      if (StringsKt.startsWith$default(var1, "https://www.blueair.cn/miniprogram?code=", false, 2, (Object)null)) {
         var1 = this.rawCode.substring(40);
         Intrinsics.checkNotNullExpressionValue(var1, "substring(...)");
         this.code = var1;
         CharSequence var5 = (CharSequence)var1;
         var2 = (new Regex("[0-9]{6}[0-9a-z]{32}")).matches(var5);
      } else {
         var2 = false;
      }

      if (var2) {
         var1 = this.code.substring(0, 6);
         Intrinsics.checkNotNullExpressionValue(var1, "substring(...)");
         this.filterSku = var1;
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final AntiFakeViewModel this$0;

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
               label32: {
                  var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
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

                        ResultKt.throwOnFailure(var1);
                        break label32;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     var1 = this.this$0.getDeviceManager();
                     String var5 = this.this$0.getCode();
                     Continuation var3 = (Continuation)this;
                     this.label = 1;
                     Object var9 = var1.antiFakeVerify(var5, var3);
                     var1 = (DeviceManager)var9;
                     if (var9 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var7 = (ApiResult)var1;
                  Function2 var13 = new Function2(this.this$0, (Continuation)null) {
                     Object L$0;
                     int label;
                     final AntiFakeViewModel this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                        var3.L$0 = var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(AntiFakeVerifyResult var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        AntiFakeVerifyResult var4 = (AntiFakeVerifyResult)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           AntiFakeViewModel var3 = this.this$0;
                           int var2 = var4.getStatus();
                           ScanResult var6;
                           if (var2 != 0) {
                              if (var2 != 1) {
                                 var6 = ScanResult.INVALID;
                              } else {
                                 var6 = ScanResult.REPEAT;
                              }
                           } else {
                              String var7 = var4.getType();
                              if (var7 != null) {
                                 AntiFakeViewModel var5 = this.this$0;
                                 DeviceFilterType var8;
                                 if (Intrinsics.areEqual(var7, "filter")) {
                                    var8 = DeviceFilterType.FILTER;
                                 } else {
                                    var8 = DeviceFilterType.WICK;
                                 }

                                 var5.setFilterType(var8);
                              }

                              List var9 = var4.getSupportedDeviceSku();
                              if (var9 != null) {
                                 this.this$0.setFilterSupportedDeviceSku(var9);
                              }

                              var6 = ScanResult.CORRECT;
                           }

                           var3.verifyResult = var6;
                           this.this$0.setPage(AntiFakePage.CodeVerifyResult.INSTANCE);
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var10 = (Continuation)this;
                  this.label = 2;
                  Object var11 = ApiResultKt.onSuccess(var7, var13, var10);
                  var1 = (DeviceManager)var11;
                  if (var11 == var4) {
                     return var4;
                  }
               }

               ApiResult var14 = (ApiResult)var1;
               Function2 var12 = new Function2(this.this$0, (Continuation)null) {
                  Object L$0;
                  int label;
                  final AntiFakeViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                     var3.L$0 = var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(Throwable var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Throwable var3 = (Throwable)this.L$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        AntiFakeViewModel var2 = this.this$0;
                        ScanResult var4;
                        if (var3 instanceof UnknownHostException) {
                           var4 = ScanResult.NETWORK;
                        } else {
                           var4 = ScanResult.INVALID;
                        }

                        var2.verifyResult = var4;
                        this.this$0.setPage(AntiFakePage.CodeVerifyResult.INSTANCE);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var8 = (Continuation)this;
               this.label = 3;
               if (ApiResultKt.onFail(var14, var12, var8) == var4) {
                  return var4;
               } else {
                  return Unit.INSTANCE;
               }
            }
         }, 2, (Object)null);
      } else {
         this.verifyResult = ScanResult.UNRECOG;
         this.setPage(AntiFakePage.CodeVerifyResult.INSTANCE);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakeViewModel$Companion;", "", "<init>", "()V", "CUSTOMER_SUPPORT_TEL", "", "antifake_otherRelease"},
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
