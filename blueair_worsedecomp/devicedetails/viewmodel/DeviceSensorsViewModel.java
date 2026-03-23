package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.Interval;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000207J\u0013\u0010\u0001\u001a\u0004\u0018\u0001072\b\u0010\u0001\u001a\u00030\u0001J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020d0c2\u0007\u0010\u0001\u001a\u00020DH@¢\u0006\u0003\u0010\u0001J%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020d0c2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002010cH@¢\u0006\u0003\u0010\u0001J\u001a\u0010\u0001\u001a\u00030\u00012\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010x\u001a\u00020\u0017J\u0010\u0010\u0001\u001a\u00030\u00012\u0006\u0010 \u001a\u00020\u001fJ\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002072\t\b\u0002\u0010\u0001\u001a\u00020\u0017J\b\u0010\u0001\u001a\u00030\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001c\u0010\u0019R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX.¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0$¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0018\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010103X\u0004¢\u0006\u0002\n\u0000R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010$¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u001b\u00106\u001a\u0002078FX\u0002¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b8\u00109R\u0011\u0010;\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b<\u00109R!\u0010=\u001a\b\u0012\u0004\u0012\u0002070,8BX\u0002¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\b>\u0010?R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u0002070$8F¢\u0006\u0006\u001a\u0004\bB\u0010&R\u0013\u0010C\u001a\u0004\u0018\u00010D8F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020D0,X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020D0$8F¢\u0006\u0006\u001a\u0004\bI\u0010&R\u0013\u0010J\u001a\u0004\u0018\u00010D8F¢\u0006\u0006\u001a\u0004\bK\u0010FR\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020D0,X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020D0$8F¢\u0006\u0006\u001a\u0004\bN\u0010&R\u001b\u0010O\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bP\u0010\u0019R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020S0$8F¢\u0006\u0006\u001a\u0004\bT\u0010&R!\u0010U\u001a\b\u0012\u0004\u0012\u00020D0V8BX\u0002¢\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bW\u0010XR#\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0$8FX\u0002¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b[\u0010&R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020S0$8F¢\u0006\u0006\u001a\u0004\b^\u0010&R!\u0010_\u001a\b\u0012\u0004\u0012\u00020D0V8BX\u0002¢\u0006\f\n\u0004\ba\u0010\u000b\u001a\u0004\b`\u0010XR\u001a\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bf\u0010&R\u001a\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bi\u0010&R\u001a\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bl\u0010&R\u001a\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bo\u0010&R!\u0010p\u001a\b\u0012\u0004\u0012\u0002070c8FX\u0002¢\u0006\f\n\u0004\bs\u0010\u000b\u001a\u0004\bq\u0010rR!\u0010t\u001a\b\u0012\u0004\u0012\u0002070c8FX\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bu\u0010rR\u0011\u0010w\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bw\u0010\u0019R\u001e\u0010x\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0019R\u0011\u0010z\u001a\u00020{8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170,X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\b\u0012\u0004\u0012\u00020\u00170,X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170,X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170$¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010&R\u0019\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170,¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010?R,\u0010\u0001\u001a\u0004\u0018\u0001072\b\u0010\u001e\u001a\u0004\u0018\u0001078F@FX\u000e¢\u0006\u000f\u001a\u0005\b\u0001\u00109\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u000e¢\u0006\u000f\u001a\u0005\b\u0001\u0010\u0019\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "Lkotlin/Lazy;", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "supportPM25", "", "getSupportPM25", "()Z", "supportPM25$delegate", "supportParticles", "getSupportParticles", "supportParticles$delegate", "value", "Lcom/blueair/core/model/HasSensorData;", "device", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "liveDevice", "Landroidx/lifecycle/LiveData;", "getLiveDevice", "()Landroidx/lifecycle/LiveData;", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "_liveLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/core/model/TrackedLocation;", "liveLocation", "getLiveLocation", "_liveSourceAqiData", "Lcom/blueair/core/model/AqiData;", "_liveAqiData", "Landroidx/lifecycle/MediatorLiveData;", "liveAqiData", "getLiveAqiData", "defaultSelectedSensor", "Lcom/blueair/core/model/SensorType;", "getDefaultSelectedSensor", "()Lcom/blueair/core/model/SensorType;", "defaultSelectedSensor$delegate", "selectedSensor", "getSelectedSensor", "_liveSelectedSensor", "get_liveSelectedSensor", "()Landroidx/lifecycle/MutableLiveData;", "_liveSelectedSensor$delegate", "liveSelectedSensor", "getLiveSelectedSensor", "lastDeviceHistoricalData", "Lcom/blueair/core/model/DeviceData;", "getLastDeviceHistoricalData", "()Lcom/blueair/core/model/DeviceData;", "_liveDeviceHistoricalData", "liveDeviceHistoricalData", "getLiveDeviceHistoricalData", "lastDeviceRealTimeData", "getLastDeviceRealTimeData", "_liveDeviceRealTimeData", "liveDeviceRealTimeData", "getLiveDeviceRealTimeData", "showFanHistory", "getShowFanHistory", "showFanHistory$delegate", "historicalDataListener", "", "getHistoricalDataListener", "flowDeviceHistoricalData", "Lkotlinx/coroutines/flow/Flow;", "getFlowDeviceHistoricalData", "()Lkotlinx/coroutines/flow/Flow;", "flowDeviceHistoricalData$delegate", "liveDeviceLatestData", "getLiveDeviceLatestData", "liveDeviceLatestData$delegate", "realTimeDataListener", "getRealTimeDataListener", "flowDeviceRealTimeData", "getFlowDeviceRealTimeData", "flowDeviceRealTimeData$delegate", "_liveSelectedSensorHistoricalData", "", "Lcom/blueair/core/model/SimpleDatapoint;", "liveSelectedSensorHistoricalData", "getLiveSelectedSensorHistoricalData", "_liveSelectedSensorRealTimeData", "liveSelectedSensorRealTimeData", "getLiveSelectedSensorRealTimeData", "_liveFanSensorHistoricalData", "liveFanSensorHistoricalData", "getLiveFanSensorHistoricalData", "_liveFanSensorRealTimeData", "liveFanSensorRealTimeData", "getLiveFanSensorRealTimeData", "supportedSensors", "getSupportedSensors", "()Ljava/util/List;", "supportedSensors$delegate", "supportedSensorTabs", "getSupportedSensorTabs", "supportedSensorTabs$delegate", "isTempCelsius", "ignoreTemperatureUnit", "getIgnoreTemperatureUnit", "indoorAirRatings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "getIndoorAirRatings", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "_networkAvailable", "_deviceOffline", "_deviceStandby", "disableSensorCards", "getDisableSensorCards", "graphExpended", "getGraphExpended", "lastSelectedSensor", "getLastSelectedSensor", "setLastSelectedSensor", "(Lcom/blueair/core/model/SensorType;)V", "lastGraphExpended", "getLastGraphExpended", "setLastGraphExpended", "(Z)V", "getSensorPos", "", "sensorType", "getSensorAtPos", "pos", "getSelectedSensorData", "data", "(Lcom/blueair/core/model/DeviceData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelectedPollutantData", "datapoints", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "", "updateDevice", "selectSensor", "triggerGraphExpend", "refresh", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorsViewModel.kt */
public final class DeviceSensorsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final List<SensorType> sensorList = CollectionsKt.listOf(SensorType.PM1, SensorType.PM25, SensorType.PM10, SensorType.VOC, SensorType.HCHO, SensorType.TMP, SensorType.HUM);
    private static final List<SensorType> sensorListV2 = CollectionsKt.listOf(SensorType.PM25, SensorType.PM1, SensorType.PM10, SensorType.VOC, SensorType.HCHO, SensorType.HUM, SensorType.TMP);
    private final MutableLiveData<Boolean> _deviceOffline;
    private final MutableLiveData<Boolean> _deviceStandby;
    private final MediatorLiveData<AqiData> _liveAqiData;
    /* access modifiers changed from: private */
    public final MutableLiveData<DeviceData> _liveDeviceHistoricalData;
    /* access modifiers changed from: private */
    public final MutableLiveData<DeviceData> _liveDeviceRealTimeData;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<SimpleDatapoint>> _liveFanSensorHistoricalData;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<SimpleDatapoint>> _liveFanSensorRealTimeData;
    /* access modifiers changed from: private */
    public final MutableLiveData<TrackedLocation> _liveLocation;
    private final Lazy _liveSelectedSensor$delegate;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<SimpleDatapoint>> _liveSelectedSensorHistoricalData;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<SimpleDatapoint>> _liveSelectedSensorRealTimeData;
    private LiveData<AqiData> _liveSourceAqiData;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _networkAvailable;
    private final Lazy defaultSelectedSensor$delegate;
    private HasSensorData device;
    private final LiveData<Boolean> disableSensorCards;
    private final Lazy flowDeviceHistoricalData$delegate;
    private final Lazy flowDeviceRealTimeData$delegate;
    private final MutableLiveData<Boolean> graphExpended;
    private boolean ignoreTemperatureUnit;
    private final LiveData<AqiData> liveAqiData;
    private final Lazy liveDeviceLatestData$delegate;
    private final LiveData<TrackedLocation> liveLocation;
    private final Lazy networkMonitor$delegate;
    private final Lazy outdoorService$delegate;
    private final Lazy prefs$delegate;
    private final Lazy showFanHistory$delegate;
    private final Lazy supportPM25$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda6(this));
    private final Lazy supportParticles$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda11(this));
    private final Lazy supportedSensorTabs$delegate;
    private final Lazy supportedSensors$delegate;

    static {
        Class<DeviceSensorsViewModel> cls = DeviceSensorsViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSensorsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceSensorsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, OutdoorService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.outdoorService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceSensorsViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.networkMonitor$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, NetworkMonitor.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DeviceSensorsViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        MutableLiveData<TrackedLocation> mutableLiveData = new MutableLiveData<>();
        this._liveLocation = mutableLiveData;
        LiveData<TrackedLocation> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        this.liveLocation = distinctUntilChanged;
        MediatorLiveData<AqiData> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(distinctUntilChanged, new DeviceSensorsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceSensorsViewModel$$ExternalSyntheticLambda12(this, mediatorLiveData)));
        this._liveAqiData = mediatorLiveData;
        this.liveAqiData = mediatorLiveData;
        this.defaultSelectedSensor$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda13(this));
        this._liveSelectedSensor$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda14(this));
        this._liveDeviceHistoricalData = new MutableLiveData<>();
        this._liveDeviceRealTimeData = new MutableLiveData<>();
        this.showFanHistory$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda1(this));
        this.flowDeviceHistoricalData$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda2(this));
        this.liveDeviceLatestData$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda3(this));
        this.flowDeviceRealTimeData$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda4(this));
        this._liveSelectedSensorHistoricalData = new MutableLiveData<>();
        this._liveSelectedSensorRealTimeData = new MutableLiveData<>();
        this._liveFanSensorHistoricalData = new MutableLiveData<>();
        this._liveFanSensorRealTimeData = new MutableLiveData<>();
        this.supportedSensors$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda5(this));
        this.supportedSensorTabs$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda7(this));
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._networkAvailable = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._deviceOffline = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._deviceStandby = mutableLiveData4;
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        mediatorLiveData2.addSource(mutableLiveData2, new DeviceSensorsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceSensorsViewModel$$ExternalSyntheticLambda8(mediatorLiveData2, this)));
        mediatorLiveData2.addSource(mutableLiveData3, new DeviceSensorsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceSensorsViewModel$$ExternalSyntheticLambda9(mediatorLiveData2, this)));
        mediatorLiveData2.addSource(mutableLiveData4, new DeviceSensorsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceSensorsViewModel$$ExternalSyntheticLambda10(mediatorLiveData2, this)));
        this.disableSensorCards = Transformations.distinctUntilChanged(mediatorLiveData2);
        this.graphExpended = new MutableLiveData<>(false);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH@¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H@¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel$Companion;", "", "<init>", "()V", "sensorList", "", "Lcom/blueair/core/model/SensorType;", "sensorListV2", "getSensorData", "Lcom/blueair/core/model/SimpleDatapoint;", "data", "Lcom/blueair/core/model/DeviceData;", "sensor", "ignoreTemperatureUnit", "", "(Lcom/blueair/core/model/DeviceData;Lcom/blueair/core/model/SensorType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPollutantData", "datapoints", "Lcom/blueair/core/model/AqiData;", "pollutant", "Lcom/blueair/core/model/PollutantType;", "(Ljava/util/List;Lcom/blueair/core/model/PollutantType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorsViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ Object getSensorData$default(Companion companion, DeviceData deviceData, SensorType sensorType, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getSensorData(deviceData, sensorType, z, continuation);
        }

        /* access modifiers changed from: private */
        public final Object getSensorData(DeviceData deviceData, SensorType sensorType, boolean z, Continuation<? super List<SimpleDatapoint>> continuation) {
            Timber.Forest forest = Timber.Forest;
            forest.d("getSelectedSensorData thread = " + Thread.currentThread(), new Object[0]);
            return deviceData.toSimpleDataPoints(sensorType, z);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0027 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object getPollutantData(java.util.List<com.blueair.core.model.AqiData> r6, com.blueair.core.model.PollutantType r7, kotlin.coroutines.Continuation<? super java.util.List<com.blueair.core.model.SimpleDatapoint>> r8) {
            /*
                r5 = this;
                timber.log.Timber$Forest r8 = timber.log.Timber.Forest
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "getSelectedSensorData thread = "
                r0.<init>(r1)
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r8.d(r0, r1)
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Iterator r6 = r6.iterator()
            L_0x0027:
                boolean r0 = r6.hasNext()
                if (r0 == 0) goto L_0x00fe
                java.lang.Object r0 = r6.next()
                com.blueair.core.model.AqiData r0 = (com.blueair.core.model.AqiData) r0
                com.blueair.core.model.PollutantType$PM25 r1 = com.blueair.core.model.PollutantType.PM25.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                r2 = 0
                if (r1 == 0) goto L_0x0051
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getPm25()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
                goto L_0x00e7
            L_0x004e:
                r1 = r2
                goto L_0x00e7
            L_0x0051:
                com.blueair.core.model.PollutantType$PM10 r1 = com.blueair.core.model.PollutantType.PM10.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x006b
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getPm10()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
                goto L_0x00e7
            L_0x006b:
                com.blueair.core.model.PollutantType$AQI r1 = com.blueair.core.model.PollutantType.AQI.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x0084
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getAqi()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
                goto L_0x00e7
            L_0x0084:
                com.blueair.core.model.PollutantType$CO r1 = com.blueair.core.model.PollutantType.CO.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x009d
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getCo()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
                goto L_0x00e7
            L_0x009d:
                com.blueair.core.model.PollutantType$NO2 r1 = com.blueair.core.model.PollutantType.NO2.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x00b6
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getNo2()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
                goto L_0x00e7
            L_0x00b6:
                com.blueair.core.model.PollutantType$O3 r1 = com.blueair.core.model.PollutantType.O3.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x00cf
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getO3()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
                goto L_0x00e7
            L_0x00cf:
                com.blueair.core.model.PollutantType$SO2 r1 = com.blueair.core.model.PollutantType.SO2.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.OutdoorPollutants r1 = r0.getPollutants()
                if (r1 == 0) goto L_0x004e
                com.blueair.core.model.Pollutant r1 = r1.getSo2()
                if (r1 == 0) goto L_0x004e
                java.lang.Double r1 = r1.getConcentration()
            L_0x00e7:
                long r3 = r0.getDatetime()
                if (r1 == 0) goto L_0x00f7
                com.blueair.core.model.SimpleDatapoint r2 = new com.blueair.core.model.SimpleDatapoint
                double r0 = r1.doubleValue()
                float r0 = (float) r0
                r2.<init>(r3, r0)
            L_0x00f7:
                if (r2 == 0) goto L_0x0027
                r8.add(r2)
                goto L_0x0027
            L_0x00fe:
                java.util.List r8 = (java.util.List) r8
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel.Companion.getPollutantData(java.util.List, com.blueair.core.model.PollutantType, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NetworkMonitor getNetworkMonitor() {
        return (NetworkMonitor) this.networkMonitor$delegate.getValue();
    }

    private final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final boolean supportPM25_delegate$lambda$0(DeviceSensorsViewModel deviceSensorsViewModel) {
        return deviceSensorsViewModel.getSupportedSensors().contains(SensorType.PM25);
    }

    public final boolean getSupportPM25() {
        return ((Boolean) this.supportPM25$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean supportParticles_delegate$lambda$1(DeviceSensorsViewModel deviceSensorsViewModel) {
        return deviceSensorsViewModel.getSupportedSensors().containsAll(SetsKt.setOf(SensorType.PM25, SensorType.PM1, SensorType.PM10));
    }

    public final boolean getSupportParticles() {
        return ((Boolean) this.supportParticles$delegate.getValue()).booleanValue();
    }

    public final HasSensorData getDevice() {
        HasSensorData hasSensorData = this.device;
        if (hasSensorData != null) {
            return hasSensorData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final LiveData<HasSensorData> getLiveDevice() {
        return FlowLiveDataConversions.asLiveData$default((Flow) FlowKt.distinctUntilChanged(getDeviceManager().getFlowHasSensorDevice(getDeviceId())), ViewModelKt.getViewModelScope(this).getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    public final String getDeviceId() {
        return getDevice().getUid();
    }

    public final LiveData<TrackedLocation> getLiveLocation() {
        return this.liveLocation;
    }

    /* access modifiers changed from: private */
    public static final Unit _liveAqiData$lambda$5$lambda$4(DeviceSensorsViewModel deviceSensorsViewModel, MediatorLiveData mediatorLiveData, TrackedLocation trackedLocation) {
        if (trackedLocation == null) {
            LiveData<AqiData> liveData = deviceSensorsViewModel._liveSourceAqiData;
            if (liveData != null) {
                mediatorLiveData.removeSource(liveData);
            }
            deviceSensorsViewModel._liveSourceAqiData = null;
            mediatorLiveData.setValue(null);
        } else {
            LiveData<AqiData> liveAqiData2 = deviceSensorsViewModel.getOutdoorService().liveAqiData(trackedLocation);
            deviceSensorsViewModel._liveSourceAqiData = liveAqiData2;
            Intrinsics.checkNotNull(liveAqiData2);
            mediatorLiveData.addSource(liveAqiData2, new DeviceSensorsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceSensorsViewModel$$ExternalSyntheticLambda0(mediatorLiveData)));
            Job unused = BuildersKt__Builders_commonKt.launch$default(deviceSensorsViewModel, Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsViewModel$_liveAqiData$1$1$3(deviceSensorsViewModel, trackedLocation, (Continuation<? super DeviceSensorsViewModel$_liveAqiData$1$1$3>) null), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit _liveAqiData$lambda$5$lambda$4$lambda$3(MediatorLiveData mediatorLiveData, AqiData aqiData) {
        mediatorLiveData.setValue(aqiData);
        return Unit.INSTANCE;
    }

    public final LiveData<AqiData> getLiveAqiData() {
        return this.liveAqiData;
    }

    public final SensorType getDefaultSelectedSensor() {
        return (SensorType) this.defaultSelectedSensor$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SensorType defaultSelectedSensor_delegate$lambda$6(DeviceSensorsViewModel deviceSensorsViewModel) {
        HasSensorData device2 = deviceSensorsViewModel.getDevice();
        if ((device2 instanceof DeviceDehumidifier) || (device2 instanceof DeviceHumidifier20) || (device2 instanceof DeviceHumidifier)) {
            return SensorType.HUM;
        }
        return SensorType.PM25;
    }

    public final SensorType getSelectedSensor() {
        SensorType value = get_liveSelectedSensor().getValue();
        return value == null ? getDefaultSelectedSensor() : value;
    }

    private final MutableLiveData<SensorType> get_liveSelectedSensor() {
        return (MutableLiveData) this._liveSelectedSensor$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final MutableLiveData _liveSelectedSensor_delegate$lambda$8(DeviceSensorsViewModel deviceSensorsViewModel) {
        Object obj;
        Iterator it = sensorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (deviceSensorsViewModel.getDevice().supports((SensorType) obj)) {
                break;
            }
        }
        SensorType sensorType = (SensorType) obj;
        if (sensorType == null) {
            sensorType = deviceSensorsViewModel.getDefaultSelectedSensor();
        }
        return new MutableLiveData(sensorType);
    }

    public final LiveData<SensorType> getLiveSelectedSensor() {
        return Transformations.distinctUntilChanged(get_liveSelectedSensor());
    }

    public final DeviceData getLastDeviceHistoricalData() {
        return this._liveDeviceHistoricalData.getValue();
    }

    public final LiveData<DeviceData> getLiveDeviceHistoricalData() {
        return Transformations.distinctUntilChanged(this._liveDeviceHistoricalData);
    }

    public final DeviceData getLastDeviceRealTimeData() {
        return this._liveDeviceRealTimeData.getValue();
    }

    public final LiveData<DeviceData> getLiveDeviceRealTimeData() {
        return Transformations.distinctUntilChanged(this._liveDeviceRealTimeData);
    }

    public final boolean getShowFanHistory() {
        return ((Boolean) this.showFanHistory$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean showFanHistory_delegate$lambda$9(DeviceSensorsViewModel deviceSensorsViewModel) {
        return deviceSensorsViewModel.getDevice().supports(SensorType.FAN);
    }

    public final LiveData<Object> getHistoricalDataListener() {
        return FlowLiveDataConversions.asLiveData$default((Flow) new DeviceSensorsViewModel$special$$inlined$map$1(getFlowDeviceHistoricalData(), this), ViewModelKt.getViewModelScope(this).getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    private final Flow<DeviceData> getFlowDeviceHistoricalData() {
        return (Flow) this.flowDeviceHistoricalData$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Flow flowDeviceHistoricalData_delegate$lambda$11(DeviceSensorsViewModel deviceSensorsViewModel) {
        return FlowKt.distinctUntilChanged(deviceSensorsViewModel.getDeviceManager().getFlowDeviceDataBetween(deviceSensorsViewModel.getDeviceId(), Interval.MONTH, false));
    }

    public final LiveData<DeviceData> getLiveDeviceLatestData() {
        return (LiveData) this.liveDeviceLatestData$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final LiveData liveDeviceLatestData_delegate$lambda$12(DeviceSensorsViewModel deviceSensorsViewModel) {
        return Transformations.distinctUntilChanged(deviceSensorsViewModel.getDeviceManager().getLiveLatestDeviceData(deviceSensorsViewModel.getDeviceId()));
    }

    public final LiveData<Object> getRealTimeDataListener() {
        return FlowLiveDataConversions.asLiveData$default((Flow) new DeviceSensorsViewModel$special$$inlined$map$2(getFlowDeviceRealTimeData(), this), ViewModelKt.getViewModelScope(this).getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    private final Flow<DeviceData> getFlowDeviceRealTimeData() {
        return (Flow) this.flowDeviceRealTimeData$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Flow flowDeviceRealTimeData_delegate$lambda$14(DeviceSensorsViewModel deviceSensorsViewModel) {
        return FlowKt.distinctUntilChanged(deviceSensorsViewModel.getDeviceManager().getFlowRealTimeDeviceData(deviceSensorsViewModel.getDeviceId()));
    }

    public final LiveData<List<SimpleDatapoint>> getLiveSelectedSensorHistoricalData() {
        return this._liveSelectedSensorHistoricalData;
    }

    public final LiveData<List<SimpleDatapoint>> getLiveSelectedSensorRealTimeData() {
        return this._liveSelectedSensorRealTimeData;
    }

    public final LiveData<List<SimpleDatapoint>> getLiveFanSensorHistoricalData() {
        return Transformations.distinctUntilChanged(this._liveFanSensorHistoricalData);
    }

    public final LiveData<List<SimpleDatapoint>> getLiveFanSensorRealTimeData() {
        return Transformations.distinctUntilChanged(this._liveFanSensorRealTimeData);
    }

    public final List<SensorType> getSupportedSensors() {
        return (List) this.supportedSensors$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List supportedSensors_delegate$lambda$17(DeviceSensorsViewModel deviceSensorsViewModel) {
        if (deviceSensorsViewModel.getDevice() instanceof DeviceDehumidifier) {
            return CollectionsKt.listOf(SensorType.HUM, SensorType.PM25, SensorType.TMP);
        } else if (deviceSensorsViewModel.getDevice() instanceof DeviceCombo2in120) {
            return CollectionsKt.listOf(SensorType.HUM, SensorType.PM25, SensorType.PM1, SensorType.PM10, SensorType.TMP);
        } else if (DeviceKt.useV2UI(deviceSensorsViewModel.getDevice())) {
            Collection arrayList = new ArrayList();
            for (Object next : sensorListV2) {
                if (deviceSensorsViewModel.getDevice().supports((SensorType) next)) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        } else {
            Collection arrayList2 = new ArrayList();
            for (Object next2 : sensorList) {
                if (deviceSensorsViewModel.getDevice().supports((SensorType) next2)) {
                    arrayList2.add(next2);
                }
            }
            return (List) arrayList2;
        }
    }

    public final List<SensorType> getSupportedSensorTabs() {
        return (List) this.supportedSensorTabs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List supportedSensorTabs_delegate$lambda$18(DeviceSensorsViewModel deviceSensorsViewModel) {
        HasSensorData device2 = deviceSensorsViewModel.getDevice();
        if (device2 instanceof DeviceCombo2in1) {
            return CollectionsKt.listOf(SensorType.PM25, SensorType.HUM);
        } else if (device2 instanceof DeviceCombo3in1) {
            return CollectionsKt.listOf(SensorType.PM25, SensorType.TMP);
        } else if (!(device2 instanceof DevicePet20)) {
            return CollectionsKt.emptyList();
        } else {
            return CollectionsKt.listOf(SensorType.PM1, SensorType.PM25, SensorType.PM10, SensorType.VOC);
        }
    }

    public final boolean isTempCelsius() {
        return getDevice() instanceof HasTemperatureUnit ? DeviceKt.isCelsiusUnit(getDevice()) : getPrefs().isTempCelsius();
    }

    public final boolean getIgnoreTemperatureUnit() {
        return this.ignoreTemperatureUnit;
    }

    public final IndoorAirRatingRanges getIndoorAirRatings() {
        return IndoorAirRatingRanges.Companion.instance(getDevice());
    }

    public final LiveData<Boolean> getDisableSensorCards() {
        return this.disableSensorCards;
    }

    /* access modifiers changed from: private */
    public static final Unit disableSensorCards$lambda$22$lambda$19(MediatorLiveData mediatorLiveData, DeviceSensorsViewModel deviceSensorsViewModel, Boolean bool) {
        boolean z = true;
        if (bool.booleanValue() && !Intrinsics.areEqual((Object) deviceSensorsViewModel._deviceOffline.getValue(), (Object) true) && !Intrinsics.areEqual((Object) deviceSensorsViewModel._deviceStandby.getValue(), (Object) true)) {
            z = false;
        }
        mediatorLiveData.postValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit disableSensorCards$lambda$22$lambda$20(MediatorLiveData mediatorLiveData, DeviceSensorsViewModel deviceSensorsViewModel, Boolean bool) {
        boolean z = false;
        if (Intrinsics.areEqual((Object) deviceSensorsViewModel._networkAvailable.getValue(), (Object) false) || bool.booleanValue() || Intrinsics.areEqual((Object) deviceSensorsViewModel._deviceStandby.getValue(), (Object) true)) {
            z = true;
        }
        mediatorLiveData.postValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit disableSensorCards$lambda$22$lambda$21(MediatorLiveData mediatorLiveData, DeviceSensorsViewModel deviceSensorsViewModel, Boolean bool) {
        boolean z = false;
        if (Intrinsics.areEqual((Object) deviceSensorsViewModel._networkAvailable.getValue(), (Object) false) || Intrinsics.areEqual((Object) deviceSensorsViewModel._deviceOffline.getValue(), (Object) true) || bool.booleanValue()) {
            z = true;
        }
        mediatorLiveData.postValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    public final MutableLiveData<Boolean> getGraphExpended() {
        return this.graphExpended;
    }

    public final SensorType getLastSelectedSensor() {
        Object obj;
        String format = String.format(PrefKeys.KEY_SELECTED_SENSOR_BEFORE, Arrays.copyOf(new Object[]{getDeviceId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        String str = (String) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, "", Reflection.getOrCreateKotlinClass(String.class));
        try {
            Result.Companion companion = Result.Companion;
            DeviceSensorsViewModel deviceSensorsViewModel = this;
            obj = Result.m9366constructorimpl(SensorType.valueOf(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m9366constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9372isFailureimpl(obj)) {
            obj = null;
        }
        return (SensorType) obj;
    }

    public final void setLastSelectedSensor(SensorType sensorType) {
        String str;
        Prefs prefs = getPrefs();
        String format = String.format(PrefKeys.KEY_SELECTED_SENSOR_BEFORE, Arrays.copyOf(new Object[]{getDeviceId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        if (sensorType == null || (str = sensorType.name()) == null) {
            str = "";
        }
        PreferencesHelper.INSTANCE.set(prefs.getBackend(), format, str, Reflection.getOrCreateKotlinClass(String.class));
    }

    public final boolean getLastGraphExpended() {
        String format = String.format(PrefKeys.KEY_GRAPH_EXPENDED_BEFORE, Arrays.copyOf(new Object[]{getDeviceId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setLastGraphExpended(boolean z) {
        String format = String.format(PrefKeys.KEY_GRAPH_EXPENDED_BEFORE, Arrays.copyOf(new Object[]{getDeviceId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public final int getSensorPos(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        return getSupportedSensors().indexOf(sensorType);
    }

    public final SensorType getSensorAtPos(int i) {
        return (SensorType) CollectionsKt.getOrNull(getSupportedSensors(), i);
    }

    /* access modifiers changed from: private */
    public final Object getSelectedSensorData(DeviceData deviceData, Continuation<? super List<SimpleDatapoint>> continuation) {
        return Companion.getSensorData(deviceData, getSelectedSensor(), this.ignoreTemperatureUnit, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getSelectedPollutantData(List<AqiData> list, Continuation<? super List<SimpleDatapoint>> continuation) {
        return Companion.getPollutantData(list, PollutantType.Companion.fromSensorType(getSelectedSensor()), continuation);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$1", f = "DeviceSensorsViewModel.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel$1  reason: invalid class name */
    /* compiled from: DeviceSensorsViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DeviceSensorsViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> connectivityStatus = this.this$0.getNetworkMonitor().getConnectivityStatus();
                final DeviceSensorsViewModel deviceSensorsViewModel = this.this$0;
                this.label = 1;
                if (connectivityStatus.collect(new FlowCollector() {
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        deviceSensorsViewModel._networkAvailable.postValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void init$default(DeviceSensorsViewModel deviceSensorsViewModel, HasSensorData hasSensorData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        deviceSensorsViewModel.init(hasSensorData, z);
    }

    public final void init(HasSensorData hasSensorData, boolean z) {
        Intrinsics.checkNotNullParameter(hasSensorData, "device");
        updateDevice(hasSensorData);
        this.ignoreTemperatureUnit = z;
    }

    public final void updateDevice(HasSensorData hasSensorData) {
        Intrinsics.checkNotNullParameter(hasSensorData, "device");
        this.device = hasSensorData;
        this._deviceStandby.setValue(Boolean.valueOf(DeviceKt.isStandByOn(hasSensorData)));
        this._deviceOffline.setValue(Boolean.valueOf(hasSensorData.getConnectivityStatusIndex() != ConnectivityStatus.ONLINE.ordinal()));
        if (hasSensorData instanceof HasLocation) {
            TrackedLocation value = this.liveLocation.getValue();
            if (!Intrinsics.areEqual((Object) value != null ? value.getId() : null, (Object) ((HasLocation) hasSensorData).getLocationId())) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsViewModel$updateDevice$1(this, hasSensorData, (Continuation<? super DeviceSensorsViewModel$updateDevice$1>) null), 2, (Object) null);
            }
        }
    }

    public static /* synthetic */ void selectSensor$default(DeviceSensorsViewModel deviceSensorsViewModel, SensorType sensorType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        deviceSensorsViewModel.selectSensor(sensorType, z);
    }

    public final void selectSensor(SensorType sensorType, boolean z) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Timber.Forest forest = Timber.Forest;
        forest.d("selectSensor: " + sensorType + " | " + z, new Object[0]);
        if (z) {
            this.graphExpended.setValue(true);
        }
        get_liveSelectedSensor().setValue(sensorType);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), (CoroutineStart) null, new DeviceSensorsViewModel$selectSensor$1(this, (Continuation<? super DeviceSensorsViewModel$selectSensor$1>) null), 2, (Object) null);
    }

    public final void refresh() {
        CoroutineScope coroutineScope = this;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsViewModel$refresh$1(this, (Continuation<? super DeviceSensorsViewModel$refresh$1>) null), 2, (Object) null);
        TrackedLocation value = this.liveLocation.getValue();
        if (value != null) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsViewModel$refresh$2$1(this, value, (Continuation<? super DeviceSensorsViewModel$refresh$2$1>) null), 2, (Object) null);
        }
    }
}
