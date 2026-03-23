package com.blueair.antifake.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blueair.antifake.viewmodel.AntiFakePage;
import com.blueair.bluetooth.service.BleDeviceService;
import com.blueair.bluetooth.service.BleScanningService;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import com.blueair.core.FileNames;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasSKU;
import com.blueair.core.util.PersistentObjectDelegate;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010W\u001a\u00020XH\u0002J\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z020\u0012J\u001a\u0010[\u001a\u00020X2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010$J\u000e\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020\u0018J\u0006\u0010^\u001a\u00020XJ\u0006\u0010_\u001a\u00020XJ\u000e\u0010_\u001a\u00020X2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010`\u001a\u00020XJ\u0018\u0010a\u001a\u00020X2\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u0018H\u0002J\b\u0010d\u001a\u0004\u0018\u00010eJ\u0010\u0010f\u001a\u00020X2\b\u0010g\u001a\u0004\u0018\u00010\u0018J\u000e\u0010h\u001a\u00020X2\u0006\u0010\u001f\u001a\u00020iJ\u0006\u0010j\u001a\u00020XJ\u0006\u0010U\u001a\u00020XJ\u000e\u0010k\u001a\u00020XH@¢\u0006\u0002\u0010lJ\u0016\u0010h\u001a\u00020X2\u0006\u0010m\u001a\u00020\u0018H@¢\u0006\u0002\u0010nJ\u0016\u0010o\u001a\u00020X2\u0006\u0010p\u001a\u00020\u0018H@¢\u0006\u0002\u0010nJ\u0010\u0010q\u001a\u00020X2\u0006\u0010r\u001a\u00020\u0010H\u0002J\u0006\u0010s\u001a\u000208J\u0007\u0010\u0001\u001a\u00020XJ\u0007\u0010\u0001\u001a\u00020XJ\t\u0010\u0001\u001a\u00020XH\u0014R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0017\u001a\u0004\u0018\u00010$@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020(@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR$\u0010.\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010'\"\u0004\b0\u00101R0\u00103\u001a\b\u0012\u0004\u0012\u00020\u0018022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001802@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00109\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001e\u0010<\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u001e\u0010>\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001bR\u001e\u0010@\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001bR\u001e\u0010B\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001bR\u001e\u0010D\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001bR\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0\u0012¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0014R\u0016\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0\u0012¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0014R\u001e\u0010U\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u001b\u0010t\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bu\u0010\tR\u001b\u0010w\u001a\u00020x8BX\u0002¢\u0006\f\n\u0004\b{\u0010\u000b\u001a\u0004\by\u0010zR\u0010\u0010|\u001a\u0004\u0018\u00010}X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010~\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b~\u0010;R\u001e\u0010\u001a\u0002082\u0006\u0010\u0017\u001a\u000208@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010;RM\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00012\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00018B@BX\u0002¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020i020\u00018\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "btConnectivityService", "Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "getBtConnectivityService", "()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "btConnectivityService$delegate", "Lkotlin/Lazy;", "connectivitySubscription", "Lio/reactivex/disposables/Disposable;", "_currentPage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "currentPage", "Landroidx/lifecycle/LiveData;", "getCurrentPage", "()Landroidx/lifecycle/LiveData;", "pageStack", "Ljava/util/Stack;", "value", "", "rawCode", "getRawCode", "()Ljava/lang/String;", "code", "getCode", "Lcom/blueair/core/model/HasSKU;", "device", "getDevice", "()Lcom/blueair/core/model/HasSKU;", "setDevice", "(Lcom/blueair/core/model/HasSKU;)V", "Lcom/blueair/core/model/DeviceFilterType;", "targetType", "getTargetType", "()Lcom/blueair/core/model/DeviceFilterType;", "Lcom/blueair/antifake/viewmodel/ScanResult;", "verifyResult", "getVerifyResult", "()Lcom/blueair/antifake/viewmodel/ScanResult;", "filterSku", "getFilterSku", "filterType", "getFilterType", "setFilterType", "(Lcom/blueair/core/model/DeviceFilterType;)V", "", "filterSupportedDeviceSku", "getFilterSupportedDeviceSku", "()Ljava/util/List;", "setFilterSupportedDeviceSku", "(Ljava/util/List;)V", "", "filterMismatch", "getFilterMismatch", "()Z", "deviceMismatch", "getDeviceMismatch", "resetDeviceSku", "getResetDeviceSku", "resetDeviceId", "getResetDeviceId", "resetDeviceWifiMac", "getResetDeviceWifiMac", "resetDeviceMac", "getResetDeviceMac", "resetDeviceType", "Lcom/blueair/core/model/DeviceType;", "getResetDeviceType", "()Lcom/blueair/core/model/DeviceType;", "resetDeviceFilterUsage", "", "resetFilterBluetoothCipherText", "_bluetoothResult", "Lcom/blueair/antifake/viewmodel/BluetoothResult;", "bluetoothResult", "getBluetoothResult", "_resetResult", "Lcom/blueair/antifake/viewmodel/ResetResult;", "resetResult", "getResetResult", "retryViaBluetooth", "getRetryViaBluetooth", "updateDeviceMismatch", "", "getLiveDevices", "Lcom/blueair/core/model/Device;", "init", "validateCode", "pRawCode", "retryValidateCode", "resetFilter", "retryResetFilterByWifi", "resetFilterByWifi", "deviceSku", "deviceId", "getFilterConfig", "Lcom/blueair/core/model/FilterConfig;", "scanBluetooth", "targetDeviceWifiMac", "resetFilterByBluetooth", "Lcom/blueair/core/model/BluetoothDevice;", "retryResetFilterByBluetooth", "connectBluetoothAndResetFilter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cipherText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logBluetoothResetResult", "result", "setPage", "page", "goBack", "bleConnectivityService", "getBleConnectivityService", "bleConnectivityService$delegate", "bleScanningService", "Lcom/blueair/bluetooth/service/BleScanningService;", "getBleScanningService", "()Lcom/blueair/bluetooth/service/BleScanningService;", "bleScanningService$delegate", "bleDeviceService", "Lcom/blueair/bluetooth/service/BleDeviceService;", "isBluetoothEnabled", "isBluetoothScanning", "<set-?>", "", "bleDeviceMacNameCache", "getBleDeviceMacNameCache", "()Ljava/util/Map;", "setBleDeviceMacNameCache", "(Ljava/util/Map;)V", "bleDeviceMacNameCache$delegate", "Lcom/blueair/core/util/PersistentObjectDelegate;", "bleDevicesFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getBleDevicesFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "startBluetoothScanning", "resetBluetoothScanning", "onCleared", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AntiFakeViewModel.kt */
public final class AntiFakeViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final String CUSTOMER_SUPPORT_TEL = "400-006-9693";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableLiveData<BluetoothResult> _bluetoothResult;
    private final MutableLiveData<AntiFakePage> _currentPage;
    /* access modifiers changed from: private */
    public final MutableLiveData<ResetResult> _resetResult;
    private final Lazy bleConnectivityService$delegate;
    private final PersistentObjectDelegate bleDeviceMacNameCache$delegate;
    private BleDeviceService bleDeviceService;
    private final StateFlow<List<BluetoothDevice>> bleDevicesFlow;
    private final Lazy bleScanningService$delegate;
    private final LiveData<BluetoothResult> bluetoothResult;
    private final Lazy btConnectivityService$delegate;
    private String code = "";
    private Disposable connectivitySubscription;
    private final LiveData<AntiFakePage> currentPage;
    private HasSKU device;
    private boolean deviceMismatch;
    private boolean filterMismatch;
    private String filterSku = "";
    private List<String> filterSupportedDeviceSku = CollectionsKt.emptyList();
    private DeviceFilterType filterType = DeviceFilterType.FILTER;
    private boolean isBluetoothScanning;
    private final Stack<AntiFakePage> pageStack = new Stack<>();
    private String rawCode = "";
    private int resetDeviceFilterUsage = -1;
    private String resetDeviceId = "";
    private String resetDeviceMac = "";
    private String resetDeviceSku = "";
    private String resetDeviceWifiMac = "";
    /* access modifiers changed from: private */
    public String resetFilterBluetoothCipherText = "";
    private final LiveData<ResetResult> resetResult;
    private boolean retryViaBluetooth;
    private DeviceFilterType targetType;
    /* access modifiers changed from: private */
    public ScanResult verifyResult = ScanResult.INVALID;

    static {
        Class<AntiFakeViewModel> cls = AntiFakeViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "btConnectivityService", "getBtConnectivityService()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "bleConnectivityService", "getBleConnectivityService()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "bleScanningService", "getBleScanningService()Lcom/blueair/bluetooth/service/BleScanningService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "bleDeviceMacNameCache", "getBleDeviceMacNameCache()Ljava/util/Map;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AntiFakeViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AntiFakeViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, BluetoothConnectivityService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.btConnectivityService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        MutableLiveData<AntiFakePage> mutableLiveData = new MutableLiveData<>(AntiFakePage.CodeVerifying.INSTANCE);
        this._currentPage = mutableLiveData;
        this.currentPage = mutableLiveData;
        MutableLiveData<BluetoothResult> mutableLiveData2 = new MutableLiveData<>();
        this._bluetoothResult = mutableLiveData2;
        this.bluetoothResult = mutableLiveData2;
        MutableLiveData<ResetResult> mutableLiveData3 = new MutableLiveData<>();
        this._resetResult = mutableLiveData3;
        this.resetResult = mutableLiveData3;
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AntiFakeViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.bleConnectivityService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, BluetoothConnectivityService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AntiFakeViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.bleScanningService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, BleScanningService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        this.bleDeviceMacNameCache$delegate = new PersistentObjectDelegate(application, FileNames.BLE_DEVICE_MAC_NAME_MAP_FILE, MapsKt.emptyMap(), Map.class, String.class, String.class);
        this.bleDevicesFlow = FlowKt.stateIn(new AntiFakeViewModel$special$$inlined$map$1(FlowKt.filterNotNull(getBleScanningService().getResultFlow()), this), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), CollectionsKt.emptyList());
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakeViewModel$Companion;", "", "<init>", "()V", "CUSTOMER_SUPPORT_TEL", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final BluetoothConnectivityService getBtConnectivityService() {
        return (BluetoothConnectivityService) this.btConnectivityService$delegate.getValue();
    }

    public final LiveData<AntiFakePage> getCurrentPage() {
        return this.currentPage;
    }

    public final String getRawCode() {
        return this.rawCode;
    }

    public final String getCode() {
        return this.code;
    }

    public final HasSKU getDevice() {
        return this.device;
    }

    private final void setDevice(HasSKU hasSKU) {
        this.device = hasSKU;
        updateDeviceMismatch();
    }

    public final DeviceFilterType getTargetType() {
        return this.targetType;
    }

    public final ScanResult getVerifyResult() {
        return this.verifyResult;
    }

    public final String getFilterSku() {
        return this.filterSku;
    }

    public final DeviceFilterType getFilterType() {
        return this.filterType;
    }

    /* access modifiers changed from: private */
    public final void setFilterType(DeviceFilterType deviceFilterType) {
        this.filterType = deviceFilterType;
        DeviceFilterType deviceFilterType2 = this.targetType;
        boolean z = false;
        if (!(deviceFilterType2 == null || deviceFilterType2 == deviceFilterType)) {
            z = true;
        }
        this.filterMismatch = z;
    }

    public final List<String> getFilterSupportedDeviceSku() {
        return this.filterSupportedDeviceSku;
    }

    /* access modifiers changed from: private */
    public final void setFilterSupportedDeviceSku(List<String> list) {
        this.filterSupportedDeviceSku = list;
        updateDeviceMismatch();
    }

    public final boolean getFilterMismatch() {
        return this.filterMismatch;
    }

    public final boolean getDeviceMismatch() {
        return this.deviceMismatch;
    }

    public final String getResetDeviceSku() {
        return this.resetDeviceSku;
    }

    public final String getResetDeviceId() {
        return this.resetDeviceId;
    }

    public final String getResetDeviceWifiMac() {
        return this.resetDeviceWifiMac;
    }

    public final String getResetDeviceMac() {
        return this.resetDeviceMac;
    }

    public final DeviceType getResetDeviceType() {
        return DeviceType.Companion.fromSkuCompat(this.resetDeviceSku);
    }

    public final LiveData<BluetoothResult> getBluetoothResult() {
        return this.bluetoothResult;
    }

    public final LiveData<ResetResult> getResetResult() {
        return this.resetResult;
    }

    public final boolean getRetryViaBluetooth() {
        return this.retryViaBluetooth;
    }

    private final void updateDeviceMismatch() {
        HasSKU hasSKU = this.device;
        this.deviceMismatch = hasSKU != null ? !CollectionsKt.contains(this.filterSupportedDeviceSku, hasSKU.getSku()) : false;
    }

    public final LiveData<List<Device>> getLiveDevices() {
        return getDeviceManager().getLiveDevices();
    }

    public final void init(HasSKU hasSKU, DeviceFilterType deviceFilterType) {
        setDevice(hasSKU);
        this.targetType = deviceFilterType;
    }

    public final void validateCode(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "pRawCode");
        String obj = StringsKt.trim((CharSequence) str).toString();
        this.rawCode = obj;
        if (StringsKt.startsWith$default(obj, "https://www.blueair.cn/miniprogram?code=", false, 2, (Object) null)) {
            String substring = this.rawCode.substring(40);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            this.code = substring;
            z = new Regex("[0-9]{6}[0-9a-z]{32}").matches(substring);
        } else {
            z = false;
        }
        if (z) {
            String substring2 = this.code.substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            this.filterSku = substring2;
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AntiFakeViewModel$validateCode$1(this, (Continuation<? super AntiFakeViewModel$validateCode$1>) null), 2, (Object) null);
            return;
        }
        this.verifyResult = ScanResult.UNRECOG;
        setPage(AntiFakePage.CodeVerifyResult.INSTANCE);
    }

    public final void retryValidateCode() {
        this.pageStack.pop();
        setPage(AntiFakePage.CodeVerifying.INSTANCE);
        validateCode(this.rawCode);
    }

    public final void resetFilter() {
        if (this.device == null) {
            setPage(AntiFakePage.SelectDevice.INSTANCE);
            return;
        }
        setPage(new AntiFakePage.ResetByWifi(1));
        HasSKU hasSKU = this.device;
        Intrinsics.checkNotNull(hasSKU);
        String sku = hasSKU.getSku();
        Intrinsics.checkNotNull(sku);
        HasSKU hasSKU2 = this.device;
        Intrinsics.checkNotNull(hasSKU2);
        resetFilterByWifi(sku, hasSKU2.getUid());
    }

    public final void resetFilter(HasSKU hasSKU) {
        Intrinsics.checkNotNullParameter(hasSKU, "device");
        String sku = hasSKU.getSku();
        Intrinsics.checkNotNull(sku);
        this.resetDeviceSku = sku;
        this.resetDeviceId = hasSKU.getUid();
        this.resetDeviceWifiMac = hasSKU.getMac();
        setPage(new AntiFakePage.ResetByWifi(2));
        resetFilterByWifi(this.resetDeviceSku, this.resetDeviceId);
    }

    public final void retryResetFilterByWifi() {
        resetFilterByWifi(this.resetDeviceSku, this.resetDeviceId);
    }

    private final void resetFilterByWifi(String str, String str2) {
        this._resetResult.setValue(null);
        this.resetDeviceSku = str;
        this.resetDeviceId = str2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AntiFakeViewModel$resetFilterByWifi$1(this, str, str2, (Continuation<? super AntiFakeViewModel$resetFilterByWifi$1>) null), 2, (Object) null);
    }

    public final FilterConfig getFilterConfig() {
        return DeviceConfigProvider.INSTANCE.getFilterConfig(this.resetDeviceSku, this.filterType);
    }

    public final void scanBluetooth(String str) {
        if (str == null) {
            str = "";
        }
        this.resetDeviceWifiMac = str;
        setPage(AntiFakePage.ScanBluetooth.INSTANCE);
    }

    public final void resetFilterByBluetooth(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        this.resetDeviceSku = bluetoothDevice.getSku();
        this.resetDeviceMac = bluetoothDevice.getMac();
        this.resetDeviceWifiMac = bluetoothDevice.getWifiMac();
        setPage(AntiFakePage.ResetByBluetooth.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AntiFakeViewModel$resetFilterByBluetooth$1(this, (Continuation<? super AntiFakeViewModel$resetFilterByBluetooth$1>) null), 2, (Object) null);
    }

    public final void retryResetFilterByBluetooth() {
        this._bluetoothResult.setValue(null);
        this._resetResult.setValue(null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AntiFakeViewModel$retryResetFilterByBluetooth$1(this, (Continuation<? super AntiFakeViewModel$retryResetFilterByBluetooth$1>) null), 2, (Object) null);
    }

    public final void retryViaBluetooth() {
        this.retryViaBluetooth = true;
        while (!this.pageStack.isEmpty()) {
            if (SetsKt.setOf(AntiFakePage.SelectDevice.INSTANCE, AntiFakePage.CodeVerifyResult.INSTANCE).contains(this.pageStack.peek())) {
                break;
            }
            this.pageStack.pop();
        }
        this._currentPage.setValue(this.pageStack.peek());
        this._bluetoothResult.setValue(null);
        this._resetResult.setValue(null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a1, code lost:
        r10 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00dc, code lost:
        if (logBluetoothResetResult(com.blueair.antifake.viewmodel.BluetoothResetResult.CONNECT_FAIL, r6) == r0) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e2, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0135, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x013b, code lost:
        if (r13 == false) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0145, code lost:
        if (r12.resetFilterBluetoothCipherText.length() != 0) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0147, code lost:
        r2 = r12.filterType;
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r6.Z$0 = r13;
        r6.label = 3;
        r2 = r1.readFilterSync(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x015e, code lost:
        if (r2 != r0) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0162, code lost:
        r8 = r13;
        r9 = r1;
        r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0167, code lost:
        r5 = ((java.lang.Number) r13).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x016d, code lost:
        if (r5 < 0) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x016f, code lost:
        r12.resetDeviceFilterUsage = r5;
        r12._bluetoothResult.postValue(com.blueair.antifake.viewmodel.BluetoothResult.SUCCESS);
        r1 = getDeviceManager();
        r2 = r12.code;
        r3 = r12.resetDeviceSku;
        r4 = r12.resetDeviceWifiMac;
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9);
        r6.Z$0 = r8;
        r6.I$0 = r5;
        r6.label = 4;
        r13 = r1.antiFakeResetByBluetooth(r2, r3, r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0199, code lost:
        if (r13 != r0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x019d, code lost:
        r1 = r5;
        r2 = r8;
        r3 = r9;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01a1, code lost:
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3);
        r6.Z$0 = r2;
        r6.I$0 = r1;
        r6.label = 5;
        r13 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r13, new com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$3(r12, (kotlin.coroutines.Continuation<? super com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$3>) null), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01c1, code lost:
        if (r13 != r0) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01c5, code lost:
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3);
        r6.Z$0 = r2;
        r6.I$0 = r1;
        r6.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e5, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r13, new com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$4(r12, (kotlin.coroutines.Continuation<? super com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$4>) null), r6) != r0) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01e8, code lost:
        r12._bluetoothResult.postValue(com.blueair.antifake.viewmodel.BluetoothResult.READ_FILTER_FAILED);
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9);
        r6.Z$0 = r8;
        r6.I$0 = r5;
        r6.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0208, code lost:
        if (logBluetoothResetResult(com.blueair.antifake.viewmodel.BluetoothResetResult.READ_USAGE_FAIL, r6) != r0) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x020b, code lost:
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x020e, code lost:
        r12._bluetoothResult.postValue(com.blueair.antifake.viewmodel.BluetoothResult.SUCCESS);
        r2 = r12.resetFilterBluetoothCipherText;
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r6.Z$0 = r13;
        r6.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x022d, code lost:
        if (resetFilterByBluetooth(r2, r6) != r0) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0230, code lost:
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0233, code lost:
        r12._bluetoothResult.postValue(com.blueair.antifake.viewmodel.BluetoothResult.CONNECT_FAILED);
        r6.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3);
        r6.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r6.Z$0 = r13;
        r6.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0250, code lost:
        if (logBluetoothResetResult(com.blueair.antifake.viewmodel.BluetoothResetResult.CONNECT_FAIL, r6) != r0) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0252, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0253, code lost:
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0255, code lost:
        r13 = r12.bleDeviceService;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0257, code lost:
        if (r13 == null) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0259, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x025c, code lost:
        r12.bleDeviceService = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0260, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connectBluetoothAndResetFilter(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$1 r0 = (com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$1 r0 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$1
            r0.<init>(r12, r13)
        L_0x0019:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            java.lang.String r2 = "Bluetooth connection failed"
            r7 = 0
            switch(r1) {
                case 0: goto L_0x00b9;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0092;
                case 4: goto L_0x0081;
                case 5: goto L_0x0070;
                case 6: goto L_0x005f;
                case 7: goto L_0x004e;
                case 8: goto L_0x003f;
                case 9: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0030:
            boolean r0 = r6.Z$0
            java.lang.Object r0 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r0 = (com.blueair.bluetooth.service.BleDeviceService) r0
            java.lang.Object r0 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r0 = (com.blueair.bluetooth.model.BleScannedDevice) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0253
        L_0x003f:
            boolean r0 = r6.Z$0
            java.lang.Object r0 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r0 = (com.blueair.bluetooth.service.BleDeviceService) r0
            java.lang.Object r0 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r0 = (com.blueair.bluetooth.model.BleScannedDevice) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0230
        L_0x004e:
            int r0 = r6.I$0
            boolean r0 = r6.Z$0
            java.lang.Object r0 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r0 = (com.blueair.bluetooth.service.BleDeviceService) r0
            java.lang.Object r0 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r0 = (com.blueair.bluetooth.model.BleScannedDevice) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x020b
        L_0x005f:
            int r0 = r6.I$0
            boolean r0 = r6.Z$0
            java.lang.Object r0 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r0 = (com.blueair.bluetooth.service.BleDeviceService) r0
            java.lang.Object r0 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r0 = (com.blueair.bluetooth.model.BleScannedDevice) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0255
        L_0x0070:
            int r1 = r6.I$0
            boolean r2 = r6.Z$0
            java.lang.Object r3 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r3 = (com.blueair.bluetooth.service.BleDeviceService) r3
            java.lang.Object r4 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r4 = (com.blueair.bluetooth.model.BleScannedDevice) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x01c5
        L_0x0081:
            int r1 = r6.I$0
            boolean r2 = r6.Z$0
            java.lang.Object r3 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r3 = (com.blueair.bluetooth.service.BleDeviceService) r3
            java.lang.Object r4 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r4 = (com.blueair.bluetooth.model.BleScannedDevice) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x01a1
        L_0x0092:
            boolean r1 = r6.Z$0
            java.lang.Object r2 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r2 = (com.blueair.bluetooth.service.BleDeviceService) r2
            java.lang.Object r3 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r3 = (com.blueair.bluetooth.model.BleScannedDevice) r3
            kotlin.ResultKt.throwOnFailure(r13)
            r8 = r1
            r9 = r2
        L_0x00a1:
            r10 = r3
            goto L_0x0167
        L_0x00a4:
            java.lang.Object r1 = r6.L$1
            com.blueair.bluetooth.service.BleDeviceService r1 = (com.blueair.bluetooth.service.BleDeviceService) r1
            java.lang.Object r3 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r3 = (com.blueair.bluetooth.model.BleScannedDevice) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0135
        L_0x00b1:
            java.lang.Object r0 = r6.L$0
            com.blueair.bluetooth.model.BleScannedDevice r0 = (com.blueair.bluetooth.model.BleScannedDevice) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00e0
        L_0x00b9:
            kotlin.ResultKt.throwOnFailure(r13)
            com.blueair.bluetooth.service.BleScanningService r13 = r12.getBleScanningService()
            java.lang.String r1 = r12.resetDeviceMac
            com.blueair.bluetooth.model.BleScannedDevice r13 = r13.getScannedDevice(r1)
            if (r13 != 0) goto L_0x00e3
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.BluetoothResult> r1 = r12._bluetoothResult
            com.blueair.antifake.viewmodel.BluetoothResult r3 = com.blueair.antifake.viewmodel.BluetoothResult.CONNECT_FAILED
            r1.postValue(r3)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r6.L$0 = r13
            r13 = 1
            r6.label = r13
            java.lang.Object r13 = r12.logBluetoothResetResult(r2, r6)
            if (r13 != r0) goto L_0x00e0
            goto L_0x0252
        L_0x00e0:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00e3:
            com.blueair.bluetooth.service.BleDeviceService r1 = r12.bleDeviceService
            if (r1 == 0) goto L_0x00ea
            r1.disconnect()
        L_0x00ea:
            com.blueair.bluetooth.service.BleDeviceService r1 = new com.blueair.bluetooth.service.BleDeviceService
            android.bluetooth.BluetoothDevice r3 = r13.getDevice()
            java.lang.String r4 = r13.getServiceUuid()
            android.app.Application r5 = r12.getApplication()
            android.content.Context r5 = (android.content.Context) r5
            com.blueair.core.service.AnalyticsService r8 = r12.getAnalyticsService()
            r1.<init>(r3, r4, r5, r8)
            r12.bleDeviceService = r1
            io.reactivex.disposables.Disposable r3 = r12.connectivitySubscription
            if (r3 != 0) goto L_0x011f
            com.blueair.bluetooth.service.BluetoothConnectivityService r3 = r12.getBtConnectivityService()
            io.reactivex.Observable r3 = r3.getStateObserver()
            com.blueair.antifake.viewmodel.AntiFakeViewModel$$ExternalSyntheticLambda0 r4 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$$ExternalSyntheticLambda0
            r4.<init>(r12)
            com.blueair.antifake.viewmodel.AntiFakeViewModel$$ExternalSyntheticLambda1 r5 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$$ExternalSyntheticLambda1
            r5.<init>(r4)
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r5)
            r12.connectivitySubscription = r3
        L_0x011f:
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r6.L$0 = r3
            r6.L$1 = r1
            r3 = 2
            r6.label = r3
            java.lang.Object r3 = r1.connectAndEstablishSessionSync(r6)
            if (r3 != r0) goto L_0x0132
            goto L_0x0252
        L_0x0132:
            r11 = r3
            r3 = r13
            r13 = r11
        L_0x0135:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0233
            java.lang.String r2 = r12.resetFilterBluetoothCipherText
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x020e
            com.blueair.core.model.DeviceFilterType r2 = r12.filterType
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$1 = r4
            r6.Z$0 = r13
            r4 = 3
            r6.label = r4
            java.lang.Object r2 = r1.readFilterSync(r2, r6)
            if (r2 != r0) goto L_0x0162
            goto L_0x0252
        L_0x0162:
            r8 = r13
            r9 = r1
            r13 = r2
            goto L_0x00a1
        L_0x0167:
            java.lang.Number r13 = (java.lang.Number) r13
            int r5 = r13.intValue()
            if (r5 < 0) goto L_0x01e8
            r12.resetDeviceFilterUsage = r5
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.BluetoothResult> r13 = r12._bluetoothResult
            com.blueair.antifake.viewmodel.BluetoothResult r1 = com.blueair.antifake.viewmodel.BluetoothResult.SUCCESS
            r13.postValue(r1)
            com.blueair.devicemanager.DeviceManager r1 = r12.getDeviceManager()
            java.lang.String r2 = r12.code
            java.lang.String r3 = r12.resetDeviceSku
            java.lang.String r4 = r12.resetDeviceWifiMac
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r6.L$0 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$1 = r13
            r6.Z$0 = r8
            r6.I$0 = r5
            r13 = 4
            r6.label = r13
            java.lang.Object r13 = r1.antiFakeResetByBluetooth(r2, r3, r4, r5, r6)
            if (r13 != r0) goto L_0x019d
            goto L_0x0252
        L_0x019d:
            r1 = r5
            r2 = r8
            r3 = r9
            r4 = r10
        L_0x01a1:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$3 r5 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$3
            r5.<init>(r12, r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r6.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$1 = r8
            r6.Z$0 = r2
            r6.I$0 = r1
            r8 = 5
            r6.label = r8
            java.lang.Object r13 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r13, r5, r6)
            if (r13 != r0) goto L_0x01c5
            goto L_0x0252
        L_0x01c5:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$4 r5 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$4
            r5.<init>(r12, r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r6.L$0 = r4
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$1 = r3
            r6.Z$0 = r2
            r6.I$0 = r1
            r1 = 6
            r6.label = r1
            java.lang.Object r13 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r13, r5, r6)
            if (r13 != r0) goto L_0x0255
            goto L_0x0252
        L_0x01e8:
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.BluetoothResult> r13 = r12._bluetoothResult
            com.blueair.antifake.viewmodel.BluetoothResult r1 = com.blueair.antifake.viewmodel.BluetoothResult.READ_FILTER_FAILED
            r13.postValue(r1)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r6.L$0 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$1 = r13
            r6.Z$0 = r8
            r6.I$0 = r5
            r13 = 7
            r6.label = r13
            java.lang.String r13 = "Get consumable usage is fail"
            java.lang.Object r13 = r12.logBluetoothResetResult(r13, r6)
            if (r13 != r0) goto L_0x020b
            goto L_0x0252
        L_0x020b:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            goto L_0x0255
        L_0x020e:
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.BluetoothResult> r2 = r12._bluetoothResult
            com.blueair.antifake.viewmodel.BluetoothResult r4 = com.blueair.antifake.viewmodel.BluetoothResult.SUCCESS
            r2.postValue(r4)
            java.lang.String r2 = r12.resetFilterBluetoothCipherText
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$0 = r3
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$1 = r1
            r6.Z$0 = r13
            r13 = 8
            r6.label = r13
            java.lang.Object r13 = r12.resetFilterByBluetooth(r2, r6)
            if (r13 != r0) goto L_0x0230
            goto L_0x0252
        L_0x0230:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            goto L_0x0255
        L_0x0233:
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.BluetoothResult> r4 = r12._bluetoothResult
            com.blueair.antifake.viewmodel.BluetoothResult r5 = com.blueair.antifake.viewmodel.BluetoothResult.CONNECT_FAILED
            r4.postValue(r5)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$0 = r3
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r6.L$1 = r1
            r6.Z$0 = r13
            r13 = 9
            r6.label = r13
            java.lang.Object r13 = r12.logBluetoothResetResult(r2, r6)
            if (r13 != r0) goto L_0x0253
        L_0x0252:
            return r0
        L_0x0253:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
        L_0x0255:
            com.blueair.bluetooth.service.BleDeviceService r13 = r12.bleDeviceService
            if (r13 == 0) goto L_0x025c
            r13.disconnect()
        L_0x025c:
            r12.bleDeviceService = r7
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.viewmodel.AntiFakeViewModel.connectBluetoothAndResetFilter(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void connectBluetoothAndResetFilter$lambda$3(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit connectBluetoothAndResetFilter$lambda$2(AntiFakeViewModel antiFakeViewModel, Boolean bool) {
        if (!bool.booleanValue()) {
            BleDeviceService bleDeviceService2 = antiFakeViewModel.bleDeviceService;
            if (bleDeviceService2 != null) {
                bleDeviceService2.disconnect();
            }
            antiFakeViewModel.bleDeviceService = null;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (r8 == r1) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        if (logBluetoothResetResult("Success", r0) == r1) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        if (logBluetoothResetResult(com.blueair.antifake.viewmodel.BluetoothResetResult.FAIL, r0) == r1) goto L_0x009d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object resetFilterByBluetooth(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByBluetooth$2
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByBluetooth$2 r0 = (com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByBluetooth$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByBluetooth$2 r0 = new com.blueair.antifake.viewmodel.AntiFakeViewModel$resetFilterByBluetooth$2
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x009e
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0083
        L_0x0044:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.bluetooth.service.BleDeviceService r8 = r6.bleDeviceService
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r8 = r8.resetFilterSync(r7, r0)
            if (r8 != r1) goto L_0x0063
            goto L_0x009d
        L_0x0063:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0086
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.ResetResult> r8 = r6._resetResult
            com.blueair.antifake.viewmodel.ResetResult r2 = com.blueair.antifake.viewmodel.ResetResult.SUCCESS
            r8.postValue(r2)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            r0.label = r4
            java.lang.String r7 = "Success"
            java.lang.Object r7 = r6.logBluetoothResetResult(r7, r0)
            if (r7 != r1) goto L_0x0083
            goto L_0x009d
        L_0x0083:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0086:
            androidx.lifecycle.MutableLiveData<com.blueair.antifake.viewmodel.ResetResult> r8 = r6._resetResult
            com.blueair.antifake.viewmodel.ResetResult r2 = com.blueair.antifake.viewmodel.ResetResult.BLUETOOTH_FAILED
            r8.postValue(r2)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            r0.label = r3
            java.lang.String r7 = "Fail"
            java.lang.Object r7 = r6.logBluetoothResetResult(r7, r0)
            if (r7 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.viewmodel.AntiFakeViewModel.resetFilterByBluetooth(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object logBluetoothResetResult(String str, Continuation<? super Unit> continuation) {
        Object antiFakeLogBluetooth = getDeviceManager().antiFakeLogBluetooth(this.code, this.resetDeviceSku, this.resetDeviceWifiMac, str, continuation);
        return antiFakeLogBluetooth == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? antiFakeLogBluetooth : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void setPage(AntiFakePage antiFakePage) {
        this._currentPage.postValue(antiFakePage);
        if (Intrinsics.areEqual((Object) antiFakePage, (Object) AntiFakePage.CodeVerifying.INSTANCE)) {
            return;
        }
        if ((antiFakePage instanceof AntiFakePage.CodeVerifyResult) || Intrinsics.areEqual((Object) antiFakePage, (Object) AntiFakePage.ScanBluetooth.INSTANCE)) {
            this.pageStack.push(antiFakePage);
        } else if (Intrinsics.areEqual((Object) antiFakePage, (Object) AntiFakePage.SelectDevice.INSTANCE)) {
            getBleScanningService().reset();
            this.pageStack.push(antiFakePage);
        } else if (!(antiFakePage instanceof AntiFakePage.ResetByWifi) && !(antiFakePage instanceof AntiFakePage.ResetByBluetooth)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean goBack() {
        if (this.pageStack.size() <= 1) {
            return false;
        }
        AntiFakePage peek = this.pageStack.peek();
        if ((peek instanceof AntiFakePage.ResetByWifi) || Intrinsics.areEqual((Object) peek, (Object) AntiFakePage.ResetByBluetooth.INSTANCE)) {
            return false;
        }
        this.pageStack.pop();
        this._currentPage.postValue(this.pageStack.peek());
        return true;
    }

    private final BluetoothConnectivityService getBleConnectivityService() {
        return (BluetoothConnectivityService) this.bleConnectivityService$delegate.getValue();
    }

    private final BleScanningService getBleScanningService() {
        return (BleScanningService) this.bleScanningService$delegate.getValue();
    }

    public final boolean isBluetoothEnabled() {
        return getBleConnectivityService().isBluetoothEnabled();
    }

    public final boolean isBluetoothScanning() {
        return this.isBluetoothScanning;
    }

    /* access modifiers changed from: private */
    public final Map<String, String> getBleDeviceMacNameCache() {
        return (Map) this.bleDeviceMacNameCache$delegate.getValue(this, $$delegatedProperties[3]);
    }

    /* access modifiers changed from: private */
    public final void setBleDeviceMacNameCache(Map<String, String> map) {
        this.bleDeviceMacNameCache$delegate.setValue(this, $$delegatedProperties[3], map);
    }

    public final StateFlow<List<BluetoothDevice>> getBleDevicesFlow() {
        return this.bleDevicesFlow;
    }

    public final void startBluetoothScanning() {
        if (!this.isBluetoothScanning) {
            Timber.Forest.d("startBluetoothScanning", new Object[0]);
            this.isBluetoothScanning = true;
            getBleScanningService().startScanning();
        }
    }

    public final void resetBluetoothScanning() {
        if (this.isBluetoothScanning) {
            Timber.Forest.d("resetBluetoothScanning", new Object[0]);
            this.isBluetoothScanning = false;
            getBleScanningService().stopScanning();
            getBleScanningService().reset();
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.connectivitySubscription;
        if (disposable != null) {
            disposable.dispose();
        }
        this.connectivitySubscription = null;
        resetBluetoothScanning();
        BleDeviceService bleDeviceService2 = this.bleDeviceService;
        if (bleDeviceService2 != null) {
            bleDeviceService2.disconnect();
        }
        this.bleDeviceService = null;
    }
}
