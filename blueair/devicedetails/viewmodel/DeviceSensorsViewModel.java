package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.Interval;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
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
import kotlin.Function;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
   d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u000207J\u0013\u0010\u0090\u0001\u001a\u0004\u0018\u0001072\b\u0010\u0091\u0001\u001a\u00030\u008e\u0001J\u001f\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020d0c2\u0007\u0010\u0093\u0001\u001a\u00020DH\u0083@¢\u0006\u0003\u0010\u0094\u0001J%\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020d0c2\r\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u0002010cH\u0083@¢\u0006\u0003\u0010\u0097\u0001J\u001a\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010x\u001a\u00020\u0017J\u0010\u0010\u009a\u0001\u001a\u00030\u0099\u00012\u0006\u0010 \u001a\u00020\u001fJ\u001c\u0010\u009b\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u008f\u0001\u001a\u0002072\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u0017J\b\u0010\u009d\u0001\u001a\u00030\u0099\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001c\u0010\u0019R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0$¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0018\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010103X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010$¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u001b\u00106\u001a\u0002078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b8\u00109R\u0011\u0010;\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b<\u00109R!\u0010=\u001a\b\u0012\u0004\u0012\u0002070,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\b>\u0010?R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u0002070$8F¢\u0006\u0006\u001a\u0004\bB\u0010&R\u0013\u0010C\u001a\u0004\u0018\u00010D8F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020D0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020D0$8F¢\u0006\u0006\u001a\u0004\bI\u0010&R\u0013\u0010J\u001a\u0004\u0018\u00010D8F¢\u0006\u0006\u001a\u0004\bK\u0010FR\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020D0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020D0$8F¢\u0006\u0006\u001a\u0004\bN\u0010&R\u001b\u0010O\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bP\u0010\u0019R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020S0$8F¢\u0006\u0006\u001a\u0004\bT\u0010&R!\u0010U\u001a\b\u0012\u0004\u0012\u00020D0V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bW\u0010XR#\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b[\u0010&R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020S0$8F¢\u0006\u0006\u001a\u0004\b^\u0010&R!\u0010_\u001a\b\u0012\u0004\u0012\u00020D0V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u000b\u001a\u0004\b`\u0010XR\u001a\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bf\u0010&R\u001a\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bi\u0010&R\u001a\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bl\u0010&R\u001a\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0$8F¢\u0006\u0006\u001a\u0004\bo\u0010&R!\u0010p\u001a\b\u0012\u0004\u0012\u0002070c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\u000b\u001a\u0004\bq\u0010rR!\u0010t\u001a\b\u0012\u0004\u0012\u0002070c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bu\u0010rR\u0011\u0010w\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bw\u0010\u0019R\u001e\u0010x\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0019R\u0011\u0010z\u001a\u00020{8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00170,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170$¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010&R\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170,¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010?R,\u0010\u0085\u0001\u001a\u0004\u0018\u0001072\b\u0010\u001e\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0086\u0001\u00109\"\u0006\b\u0087\u0001\u0010\u0088\u0001R(\u0010\u0089\u0001\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u008a\u0001\u0010\u0019\"\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u009f\u0001"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "Lkotlin/Lazy;", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "supportPM25", "", "getSupportPM25", "()Z", "supportPM25$delegate", "supportParticles", "getSupportParticles", "supportParticles$delegate", "value", "Lcom/blueair/core/model/HasSensorData;", "device", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "liveDevice", "Landroidx/lifecycle/LiveData;", "getLiveDevice", "()Landroidx/lifecycle/LiveData;", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "_liveLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/core/model/TrackedLocation;", "liveLocation", "getLiveLocation", "_liveSourceAqiData", "Lcom/blueair/core/model/AqiData;", "_liveAqiData", "Landroidx/lifecycle/MediatorLiveData;", "liveAqiData", "getLiveAqiData", "defaultSelectedSensor", "Lcom/blueair/core/model/SensorType;", "getDefaultSelectedSensor", "()Lcom/blueair/core/model/SensorType;", "defaultSelectedSensor$delegate", "selectedSensor", "getSelectedSensor", "_liveSelectedSensor", "get_liveSelectedSensor", "()Landroidx/lifecycle/MutableLiveData;", "_liveSelectedSensor$delegate", "liveSelectedSensor", "getLiveSelectedSensor", "lastDeviceHistoricalData", "Lcom/blueair/core/model/DeviceData;", "getLastDeviceHistoricalData", "()Lcom/blueair/core/model/DeviceData;", "_liveDeviceHistoricalData", "liveDeviceHistoricalData", "getLiveDeviceHistoricalData", "lastDeviceRealTimeData", "getLastDeviceRealTimeData", "_liveDeviceRealTimeData", "liveDeviceRealTimeData", "getLiveDeviceRealTimeData", "showFanHistory", "getShowFanHistory", "showFanHistory$delegate", "historicalDataListener", "", "getHistoricalDataListener", "flowDeviceHistoricalData", "Lkotlinx/coroutines/flow/Flow;", "getFlowDeviceHistoricalData", "()Lkotlinx/coroutines/flow/Flow;", "flowDeviceHistoricalData$delegate", "liveDeviceLatestData", "getLiveDeviceLatestData", "liveDeviceLatestData$delegate", "realTimeDataListener", "getRealTimeDataListener", "flowDeviceRealTimeData", "getFlowDeviceRealTimeData", "flowDeviceRealTimeData$delegate", "_liveSelectedSensorHistoricalData", "", "Lcom/blueair/core/model/SimpleDatapoint;", "liveSelectedSensorHistoricalData", "getLiveSelectedSensorHistoricalData", "_liveSelectedSensorRealTimeData", "liveSelectedSensorRealTimeData", "getLiveSelectedSensorRealTimeData", "_liveFanSensorHistoricalData", "liveFanSensorHistoricalData", "getLiveFanSensorHistoricalData", "_liveFanSensorRealTimeData", "liveFanSensorRealTimeData", "getLiveFanSensorRealTimeData", "supportedSensors", "getSupportedSensors", "()Ljava/util/List;", "supportedSensors$delegate", "supportedSensorTabs", "getSupportedSensorTabs", "supportedSensorTabs$delegate", "isTempCelsius", "ignoreTemperatureUnit", "getIgnoreTemperatureUnit", "indoorAirRatings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "getIndoorAirRatings", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "_networkAvailable", "_deviceOffline", "_deviceStandby", "disableSensorCards", "getDisableSensorCards", "graphExpended", "getGraphExpended", "lastSelectedSensor", "getLastSelectedSensor", "setLastSelectedSensor", "(Lcom/blueair/core/model/SensorType;)V", "lastGraphExpended", "getLastGraphExpended", "setLastGraphExpended", "(Z)V", "getSensorPos", "", "sensorType", "getSensorAtPos", "pos", "getSelectedSensorData", "data", "(Lcom/blueair/core/model/DeviceData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelectedPollutantData", "datapoints", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "", "updateDevice", "selectSensor", "triggerGraphExpend", "refresh", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSensorsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSensorsViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSensorsViewModel.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSensorsViewModel.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final List sensorList;
   private static final List sensorListV2;
   private final MutableLiveData _deviceOffline;
   private final MutableLiveData _deviceStandby;
   private final MediatorLiveData _liveAqiData;
   private final MutableLiveData _liveDeviceHistoricalData;
   private final MutableLiveData _liveDeviceRealTimeData;
   private final MutableLiveData _liveFanSensorHistoricalData;
   private final MutableLiveData _liveFanSensorRealTimeData;
   private final MutableLiveData _liveLocation;
   private final Lazy _liveSelectedSensor$delegate;
   private final MutableLiveData _liveSelectedSensorHistoricalData;
   private final MutableLiveData _liveSelectedSensorRealTimeData;
   private LiveData _liveSourceAqiData;
   private final MutableLiveData _networkAvailable;
   private final Lazy defaultSelectedSensor$delegate;
   private HasSensorData device;
   private final LiveData disableSensorCards;
   private final Lazy flowDeviceHistoricalData$delegate;
   private final Lazy flowDeviceRealTimeData$delegate;
   private final MutableLiveData graphExpended;
   private boolean ignoreTemperatureUnit;
   private final LiveData liveAqiData;
   private final Lazy liveDeviceLatestData$delegate;
   private final LiveData liveLocation;
   private final Lazy networkMonitor$delegate;
   private final Lazy outdoorService$delegate;
   private final Lazy prefs$delegate;
   private final Lazy showFanHistory$delegate;
   private final Lazy supportPM25$delegate;
   private final Lazy supportParticles$delegate;
   private final Lazy supportedSensorTabs$delegate;
   private final Lazy supportedSensors$delegate;

   // $FF: synthetic method
   public static boolean $r8$lambda$2nrWksLPGpZrS22RQy160oxfs7Y(DeviceSensorsViewModel var0) {
      return showFanHistory_delegate$lambda$9(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$8aIjlCrEVEF8g8V5Fk81ieHVwXo(MediatorLiveData var0, AqiData var1) {
      return _liveAqiData$lambda$5$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$CfAeGh_msvsbyR6H_o6IYII17qQ/* $FF was: $r8$lambda$CfAeGh_msvsbyR6H-o6IYII17qQ*/(MediatorLiveData var0, DeviceSensorsViewModel var1, Boolean var2) {
      return disableSensorCards$lambda$22$lambda$21(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Flow $r8$lambda$FcdkJ9n6uXFvzR0S7Wp7RNdwbiA(DeviceSensorsViewModel var0) {
      return flowDeviceRealTimeData_delegate$lambda$14(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$LLLpYP1kT6kmAgbivzwOz_4VPnc/* $FF was: $r8$lambda$LLLpYP1kT6kmAgbivzwOz-4VPnc*/(DeviceSensorsViewModel var0) {
      return supportPM25_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static MutableLiveData $r8$lambda$MEy2n1sChb8E_SreXW9Uf7Zrs1s(DeviceSensorsViewModel var0) {
      return _liveSelectedSensor_delegate$lambda$8(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_Qw7xyoiSF3ZmVn7r0NLlg3TRlQ(DeviceSensorsViewModel var0, MediatorLiveData var1, TrackedLocation var2) {
      return _liveAqiData$lambda$5$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fKhVIStyCTpc7rJDUK4hfURIXos(MediatorLiveData var0, DeviceSensorsViewModel var1, Boolean var2) {
      return disableSensorCards$lambda$22$lambda$20(var0, var1, var2);
   }

   // $FF: synthetic method
   public static List $r8$lambda$hJPxrGXIkKSmPkq__eTHZSJ2j28/* $FF was: $r8$lambda$hJPxrGXIkKSmPkq-_eTHZSJ2j28*/(DeviceSensorsViewModel var0) {
      return supportedSensorTabs_delegate$lambda$18(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$heKVe7EtwJf8kGit1I6rweb1GPw(MediatorLiveData var0, DeviceSensorsViewModel var1, Boolean var2) {
      return disableSensorCards$lambda$22$lambda$19(var0, var1, var2);
   }

   // $FF: synthetic method
   public static SensorType $r8$lambda$j5bFkwsi_nA3ETYCaPWfet6qzYc(DeviceSensorsViewModel var0) {
      return defaultSelectedSensor_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$nv_ftQ3Gq9qxB9sx_RkcfC6AwMA/* $FF was: $r8$lambda$nv-ftQ3Gq9qxB9sx_RkcfC6AwMA*/(DeviceSensorsViewModel var0) {
      return supportParticles_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static List $r8$lambda$uXy8E0H3KHFd_5nO_DDfRu_zC2I/* $FF was: $r8$lambda$uXy8E0H3KHFd-5nO_DDfRu_zC2I*/(DeviceSensorsViewModel var0) {
      return supportedSensors_delegate$lambda$17(var0);
   }

   // $FF: synthetic method
   public static LiveData $r8$lambda$u_u4AuF7oQ3T2hdON6X2YDS53TI(DeviceSensorsViewModel var0) {
      return liveDeviceLatestData_delegate$lambda$12(var0);
   }

   // $FF: synthetic method
   public static Flow $r8$lambda$xEE_7Q_B6hPz5zbWrgWQnmHTtio/* $FF was: $r8$lambda$xEE-7Q-B6hPz5zbWrgWQnmHTtio*/(DeviceSensorsViewModel var0) {
      return flowDeviceHistoricalData_delegate$lambda$11(var0);
   }

   static {
      sensorList = CollectionsKt.listOf(new SensorType[]{SensorType.PM1, SensorType.PM25, SensorType.PM10, SensorType.VOC, SensorType.HCHO, SensorType.TMP, SensorType.HUM});
      sensorListV2 = CollectionsKt.listOf(new SensorType[]{SensorType.PM25, SensorType.PM1, SensorType.PM10, SensorType.VOC, SensorType.HCHO, SensorType.TMP, SensorType.HUM});
   }

   public DeviceSensorsViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var5 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, OutdoorService.class)), (Object)null);
      KProperty[] var9 = $$delegatedProperties;
      this.outdoorService$delegate = var3.provideDelegate(this, var9[0]);
      JVMTypeToken var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, NetworkMonitor.class)), (Object)null).provideDelegate(this, var9[1]);
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var9[2]);
      this.supportPM25$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda6(this));
      this.supportParticles$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda11(this));
      MutableLiveData var6 = new MutableLiveData();
      this._liveLocation = var6;
      LiveData var10 = Transformations.distinctUntilChanged((LiveData)var6);
      this.liveLocation = var10;
      MediatorLiveData var7 = new MediatorLiveData();
      var7.addSource(var10, new Observer(new DeviceSensorsViewModel$$ExternalSyntheticLambda12(this, var7)) {
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
      this._liveAqiData = var7;
      this.liveAqiData = (LiveData)var7;
      this.defaultSelectedSensor$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda13(this));
      this._liveSelectedSensor$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda14(this));
      this._liveDeviceHistoricalData = new MutableLiveData();
      this._liveDeviceRealTimeData = new MutableLiveData();
      this.showFanHistory$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda1(this));
      this.flowDeviceHistoricalData$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda2(this));
      this.liveDeviceLatestData$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda3(this));
      this.flowDeviceRealTimeData$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda4(this));
      this._liveSelectedSensorHistoricalData = new MutableLiveData();
      this._liveSelectedSensorRealTimeData = new MutableLiveData();
      this._liveFanSensorHistoricalData = new MutableLiveData();
      this._liveFanSensorRealTimeData = new MutableLiveData();
      this.supportedSensors$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda5(this));
      this.supportedSensorTabs$delegate = LazyKt.lazy(new DeviceSensorsViewModel$$ExternalSyntheticLambda7(this));
      MutableLiveData var4 = new MutableLiveData();
      this._networkAvailable = var4;
      MutableLiveData var14 = new MutableLiveData();
      this._deviceOffline = var14;
      MutableLiveData var11 = new MutableLiveData();
      this._deviceStandby = var11;
      var7 = new MediatorLiveData();
      var7.addSource((LiveData)var4, new Observer(new DeviceSensorsViewModel$$ExternalSyntheticLambda8(var7, this)) {
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
      var7.addSource((LiveData)var14, new Observer(new DeviceSensorsViewModel$$ExternalSyntheticLambda9(var7, this)) {
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
      var7.addSource((LiveData)var11, new Observer(new DeviceSensorsViewModel$$ExternalSyntheticLambda10(var7, this)) {
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
      this.disableSensorCards = Transformations.distinctUntilChanged((LiveData)var7);
      this.graphExpended = new MutableLiveData(false);
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DeviceSensorsViewModel this$0;

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
               Flow var5 = this.this$0.getNetworkMonitor().getConnectivityStatus();
               FlowCollector var4 = new FlowCollector(this.this$0) {
                  final DeviceSensorsViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(boolean var1, Continuation var2) {
                     this.this$0._networkAvailable.postValue(Boxing.boxBoolean(var1));
                     return Unit.INSTANCE;
                  }
               };
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var5.collect(var4, var6) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   private static final Unit _liveAqiData$lambda$5$lambda$4(DeviceSensorsViewModel var0, MediatorLiveData var1, TrackedLocation var2) {
      if (var2 == null) {
         LiveData var4 = var0._liveSourceAqiData;
         if (var4 != null) {
            var1.removeSource(var4);
         }

         var0._liveSourceAqiData = null;
         var1.setValue((Object)null);
      } else {
         LiveData var3 = var0.getOutdoorService().liveAqiData(var2);
         var0._liveSourceAqiData = var3;
         Intrinsics.checkNotNull(var3);
         var1.addSource(var3, new Observer(new DeviceSensorsViewModel$$ExternalSyntheticLambda0(var1)) {
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
         BuildersKt.launch$default(var0, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var2, (Continuation)null) {
            final TrackedLocation $newLocation;
            int label;
            final DeviceSensorsViewModel this$0;

            {
               this.this$0 = var1;
               this.$newLocation = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$newLocation, var2));
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
                  OutdoorService var4 = this.this$0.getOutdoorService();
                  TrackedLocation var5 = this.$newLocation;
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (OutdoorService.fetchAqiData$default(var4, var5, false, var6, 2, (Object)null) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit _liveAqiData$lambda$5$lambda$4$lambda$3(MediatorLiveData var0, AqiData var1) {
      var0.setValue(var1);
      return Unit.INSTANCE;
   }

   private static final MutableLiveData _liveSelectedSensor_delegate$lambda$8(DeviceSensorsViewModel var0) {
      Iterator var3 = ((Iterable)sensorList).iterator();

      Object var1;
      SensorType var2;
      do {
         if (!var3.hasNext()) {
            var1 = null;
            break;
         }

         var1 = var3.next();
         var2 = (SensorType)var1;
      } while(!var0.getDevice().supports(var2));

      var2 = (SensorType)var1;
      SensorType var4 = var2;
      if (var2 == null) {
         var4 = var0.getDefaultSelectedSensor();
      }

      return new MutableLiveData(var4);
   }

   // $FF: synthetic method
   public static final Object access$getSelectedPollutantData(DeviceSensorsViewModel var0, List var1, Continuation var2) {
      return var0.getSelectedPollutantData(var1, var2);
   }

   private static final SensorType defaultSelectedSensor_delegate$lambda$6(DeviceSensorsViewModel var0) {
      HasSensorData var1 = var0.getDevice();
      if (!(var1 instanceof DeviceDehumidifier) && !(var1 instanceof DeviceHumidifier20) && !(var1 instanceof DeviceHumidifier)) {
         return var1 instanceof DeviceFanTable ? SensorType.TMP : SensorType.PM25;
      } else {
         return SensorType.HUM;
      }
   }

   private static final Unit disableSensorCards$lambda$22$lambda$19(MediatorLiveData var0, DeviceSensorsViewModel var1, Boolean var2) {
      boolean var5 = var2;
      boolean var4 = true;
      var2 = true;
      boolean var3 = var4;
      if (var5) {
         var3 = var4;
         if (!Intrinsics.areEqual(var1._deviceOffline.getValue(), var2)) {
            if (Intrinsics.areEqual(var1._deviceStandby.getValue(), var2)) {
               var3 = var4;
            } else {
               var3 = false;
            }
         }
      }

      var0.postValue(var3);
      return Unit.INSTANCE;
   }

   private static final Unit disableSensorCards$lambda$22$lambda$20(MediatorLiveData var0, DeviceSensorsViewModel var1, Boolean var2) {
      Object var4 = var1._networkAvailable.getValue();
      boolean var3 = false;
      if (Intrinsics.areEqual(var4, false) || var2 || Intrinsics.areEqual(var1._deviceStandby.getValue(), true)) {
         var3 = true;
      }

      var0.postValue(var3);
      return Unit.INSTANCE;
   }

   private static final Unit disableSensorCards$lambda$22$lambda$21(MediatorLiveData var0, DeviceSensorsViewModel var1, Boolean var2) {
      Object var4 = var1._networkAvailable.getValue();
      boolean var3 = false;
      if (Intrinsics.areEqual(var4, false) || Intrinsics.areEqual(var1._deviceOffline.getValue(), true) || var2) {
         var3 = true;
      }

      var0.postValue(var3);
      return Unit.INSTANCE;
   }

   private static final Flow flowDeviceHistoricalData_delegate$lambda$11(DeviceSensorsViewModel var0) {
      return FlowKt.distinctUntilChanged(var0.getDeviceManager().getFlowDeviceDataBetween(var0.getDeviceId(), Interval.MONTH, false));
   }

   private static final Flow flowDeviceRealTimeData_delegate$lambda$14(DeviceSensorsViewModel var0) {
      return FlowKt.distinctUntilChanged(var0.getDeviceManager().getFlowRealTimeDeviceData(var0.getDeviceId()));
   }

   private final Flow getFlowDeviceHistoricalData() {
      return (Flow)this.flowDeviceHistoricalData$delegate.getValue();
   }

   private final Flow getFlowDeviceRealTimeData() {
      return (Flow)this.flowDeviceRealTimeData$delegate.getValue();
   }

   private final NetworkMonitor getNetworkMonitor() {
      return (NetworkMonitor)this.networkMonitor$delegate.getValue();
   }

   private final OutdoorService getOutdoorService() {
      return (OutdoorService)this.outdoorService$delegate.getValue();
   }

   private final UnsecurePrefs getPrefs() {
      return (UnsecurePrefs)this.prefs$delegate.getValue();
   }

   private final Object getSelectedPollutantData(List var1, Continuation var2) {
      return Companion.getPollutantData(var1, PollutantType.Companion.fromSensorType(this.getSelectedSensor()), var2);
   }

   private final Object getSelectedSensorData(DeviceData var1, Continuation var2) {
      return Companion.getSensorData(var1, this.getSelectedSensor(), this.ignoreTemperatureUnit, var2);
   }

   private final MutableLiveData get_liveSelectedSensor() {
      return (MutableLiveData)this._liveSelectedSensor$delegate.getValue();
   }

   // $FF: synthetic method
   public static void init$default(DeviceSensorsViewModel var0, HasSensorData var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.init(var1, var2);
   }

   private static final LiveData liveDeviceLatestData_delegate$lambda$12(DeviceSensorsViewModel var0) {
      return Transformations.distinctUntilChanged(var0.getDeviceManager().getLiveLatestDeviceData(var0.getDeviceId()));
   }

   // $FF: synthetic method
   public static void selectSensor$default(DeviceSensorsViewModel var0, SensorType var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.selectSensor(var1, var2);
   }

   private static final boolean showFanHistory_delegate$lambda$9(DeviceSensorsViewModel var0) {
      return var0.getDevice().supports(SensorType.FAN);
   }

   private static final boolean supportPM25_delegate$lambda$0(DeviceSensorsViewModel var0) {
      return var0.getSupportedSensors().contains(SensorType.PM25);
   }

   private static final boolean supportParticles_delegate$lambda$1(DeviceSensorsViewModel var0) {
      return var0.getSupportedSensors().containsAll((Collection)SetsKt.setOf(new SensorType[]{SensorType.PM25, SensorType.PM1, SensorType.PM10}));
   }

   private static final List supportedSensorTabs_delegate$lambda$18(DeviceSensorsViewModel var0) {
      HasSensorData var1 = var0.getDevice();
      if (var1 instanceof DeviceCombo2in1) {
         return CollectionsKt.listOf(new SensorType[]{SensorType.PM25, SensorType.HUM});
      } else if (var1 instanceof DeviceCombo3in1) {
         return CollectionsKt.listOf(new SensorType[]{SensorType.PM25, SensorType.TMP});
      } else {
         return var1 instanceof DevicePet20 ? CollectionsKt.listOf(new SensorType[]{SensorType.PM1, SensorType.PM25, SensorType.PM10, SensorType.VOC}) : CollectionsKt.emptyList();
      }
   }

   private static final List supportedSensors_delegate$lambda$17(DeviceSensorsViewModel var0) {
      if (var0.getDevice() instanceof DeviceDehumidifier) {
         return CollectionsKt.listOf(new SensorType[]{SensorType.HUM, SensorType.PM25, SensorType.TMP});
      } else if (var0.getDevice() instanceof DeviceCombo2in120) {
         return CollectionsKt.listOf(new SensorType[]{SensorType.HUM, SensorType.PM25, SensorType.PM1, SensorType.PM10, SensorType.TMP});
      } else if (var0.getDevice() instanceof DeviceCombo2in1) {
         return CollectionsKt.listOf(new SensorType[]{SensorType.HUM, SensorType.PM25, SensorType.TMP});
      } else if (var0.getDevice() instanceof DeviceCombo3in1) {
         return CollectionsKt.listOf(new SensorType[]{SensorType.PM25, SensorType.TMP, SensorType.HUM});
      } else if (!(var0.getDevice() instanceof DeviceHumidifier) && !(var0.getDevice() instanceof DeviceHumidifier20)) {
         if (DeviceKt.useV2UI(var0.getDevice())) {
            Iterable var7 = (Iterable)sensorListV2;
            Collection var5 = (Collection)(new ArrayList());

            for(Object var9 : var7) {
               SensorType var8 = (SensorType)var9;
               if (var0.getDevice().supports(var8)) {
                  var5.add(var9);
               }
            }

            return (List)var5;
         } else {
            Iterable var2 = (Iterable)sensorList;
            Collection var1 = (Collection)(new ArrayList());

            for(Object var3 : var2) {
               SensorType var6 = (SensorType)var3;
               if (var0.getDevice().supports(var6)) {
                  var1.add(var3);
               }
            }

            return (List)var1;
         }
      } else {
         return CollectionsKt.listOf(new SensorType[]{SensorType.HUM, SensorType.TMP});
      }
   }

   public final SensorType getDefaultSelectedSensor() {
      return (SensorType)this.defaultSelectedSensor$delegate.getValue();
   }

   public final HasSensorData getDevice() {
      HasSensorData var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public final String getDeviceId() {
      return this.getDevice().getUid();
   }

   public final LiveData getDisableSensorCards() {
      return this.disableSensorCards;
   }

   public final MutableLiveData getGraphExpended() {
      return this.graphExpended;
   }

   public final LiveData getHistoricalDataListener() {
      return FlowLiveDataConversions.asLiveData$default(new Flow(this.getFlowDeviceHistoricalData(), this) {
         final Flow $this_unsafeTransform$inlined;
         final DeviceSensorsViewModel this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final DeviceSensorsViewModel this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label53: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var5 = (<undefinedtype>)var2;
                        if ((var5.label & Integer.MIN_VALUE) != 0) {
                           var5.label += Integer.MIN_VALUE;
                           var22 = var5;
                           break label53;
                        }
                     }

                     var22 = new ContinuationImpl(this, var2) {
                        int I$0;
                        int I$1;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        Object L$7;
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

                  FlowCollector var8;
                  Object var14;
                  int var23;
                  FlowCollector var28;
                  Object var32;
                  Object var34;
                  Object var36;
                  MutableLiveData var38;
                  label56: {
                     Object var26 = ((<undefinedtype>)var22).result;
                     var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     var23 = ((<undefinedtype>)var22).label;
                     int var4;
                     FlowCollector var7;
                     Continuation var9;
                     DeviceData var10;
                     Object var11;
                     MutableLiveData var12;
                     if (var23 != 0) {
                        if (var23 != 1) {
                           if (var23 != 2) {
                              if (var23 != 3) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              var23 = ((<undefinedtype>)var22).I$0;
                              FlowCollector var18 = (FlowCollector)((<undefinedtype>)var22).L$3;
                              Object var19 = ((<undefinedtype>)var22).L$2;
                              <undefinedtype> var20 = (<undefinedtype>)((<undefinedtype>)var22).L$1;
                              Object var21 = ((<undefinedtype>)var22).L$0;
                              ResultKt.throwOnFailure(var26);
                              return Unit.INSTANCE;
                           }

                           var23 = ((<undefinedtype>)var22).I$1;
                           var23 = ((<undefinedtype>)var22).I$0;
                           var38 = (MutableLiveData)((<undefinedtype>)var22).L$7;
                           var1 = (DeviceData)((<undefinedtype>)var22).L$6;
                           Continuation var16 = (Continuation)((<undefinedtype>)var22).L$5;
                           var8 = (FlowCollector)((<undefinedtype>)var22).L$4;
                           FlowCollector var39 = (FlowCollector)((<undefinedtype>)var22).L$3;
                           var1 = ((<undefinedtype>)var22).L$2;
                           var32 = (<undefinedtype>)((<undefinedtype>)var22).L$1;
                           var34 = ((<undefinedtype>)var22).L$0;
                           ResultKt.throwOnFailure(var26);
                           var36 = var26;
                           var28 = var39;
                           break label56;
                        }

                        var4 = ((<undefinedtype>)var22).I$1;
                        var23 = ((<undefinedtype>)var22).I$0;
                        var12 = (MutableLiveData)((<undefinedtype>)var22).L$7;
                        var10 = (DeviceData)((<undefinedtype>)var22).L$6;
                        var9 = (Continuation)((<undefinedtype>)var22).L$5;
                        var8 = (FlowCollector)((<undefinedtype>)var22).L$4;
                        var7 = (FlowCollector)((<undefinedtype>)var22).L$3;
                        var32 = ((<undefinedtype>)var22).L$2;
                        <undefinedtype> var13 = (<undefinedtype>)((<undefinedtype>)var22).L$1;
                        var1 = (DeviceData)((<undefinedtype>)var22).L$0;
                        ResultKt.throwOnFailure(var26);
                        var11 = var26;
                        var26 = var13;
                     } else {
                        ResultKt.throwOnFailure(var26);
                        var8 = this.$this_unsafeFlow;
                        var9 = (Continuation)var22;
                        var10 = var1;
                        Timber.Forest var33 = Timber.Forest;
                        StringBuilder var35 = new StringBuilder("dataListener: data.size = ");
                        List var29 = var10.getRawDataPoints();
                        Integer var30;
                        if (var29 != null) {
                           var30 = Boxing.boxInt(var29.size());
                        } else {
                           var30 = null;
                        }

                        var35.append(var30);
                        var35.append(", thread = ");
                        var35.append(Thread.currentThread());
                        var33.d(var35.toString(), new Object[0]);
                        this.this$0._liveDeviceHistoricalData.postValue(var10);
                        var12 = this.this$0._liveSelectedSensorHistoricalData;
                        DeviceSensorsViewModel var31 = this.this$0;
                        ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var22).L$1 = SpillingKt.nullOutSpilledVariable(var22);
                        ((<undefinedtype>)var22).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var22).L$3 = SpillingKt.nullOutSpilledVariable(var8);
                        ((<undefinedtype>)var22).L$4 = var8;
                        ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var9);
                        ((<undefinedtype>)var22).L$6 = var10;
                        ((<undefinedtype>)var22).L$7 = var12;
                        ((<undefinedtype>)var22).I$0 = 0;
                        ((<undefinedtype>)var22).I$1 = 0;
                        ((<undefinedtype>)var22).label = 1;
                        var11 = var31.getSelectedSensorData(var10, (Continuation)var22);
                        if (var11 == var14) {
                           return var14;
                        }

                        var32 = var1;
                        var7 = var8;
                        var23 = 0;
                        var26 = var22;
                        var4 = 0;
                     }

                     var12.postValue(var11);
                     MutableLiveData var40 = this.this$0._liveFanSensorHistoricalData;
                     Companion var42 = DeviceSensorsViewModel.Companion;
                     SensorType var44 = SensorType.FAN;
                     ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var22).L$1 = SpillingKt.nullOutSpilledVariable(var26);
                     ((<undefinedtype>)var22).L$2 = SpillingKt.nullOutSpilledVariable(var32);
                     ((<undefinedtype>)var22).L$3 = SpillingKt.nullOutSpilledVariable(var7);
                     ((<undefinedtype>)var22).L$4 = var8;
                     ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var9);
                     ((<undefinedtype>)var22).L$6 = SpillingKt.nullOutSpilledVariable(var10);
                     ((<undefinedtype>)var22).L$7 = var40;
                     ((<undefinedtype>)var22).I$0 = var23;
                     ((<undefinedtype>)var22).I$1 = var4;
                     ((<undefinedtype>)var22).label = 2;
                     var36 = DeviceSensorsViewModel.Companion.getSensorData$default(var42, var10, var44, false, (Continuation)var22, 4, (Object)null);
                     if (var36 == var14) {
                        return var14;
                     }

                     var38 = var40;
                     FlowCollector var41 = var7;
                     var42 = (Companion)var32;
                     var34 = var1;
                     var32 = var26;
                     var1 = var42;
                     var28 = var41;
                  }

                  var38.postValue(var36);
                  Boolean var37 = Boxing.boxBoolean(true);
                  ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var34);
                  ((<undefinedtype>)var22).L$1 = SpillingKt.nullOutSpilledVariable(var32);
                  ((<undefinedtype>)var22).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                  ((<undefinedtype>)var22).L$3 = SpillingKt.nullOutSpilledVariable(var28);
                  ((<undefinedtype>)var22).L$4 = null;
                  ((<undefinedtype>)var22).L$5 = null;
                  ((<undefinedtype>)var22).L$6 = null;
                  ((<undefinedtype>)var22).L$7 = null;
                  ((<undefinedtype>)var22).I$0 = var23;
                  ((<undefinedtype>)var22).label = 3;
                  if (var8.emit(var37, (Continuation)var22) == var14) {
                     return var14;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final boolean getIgnoreTemperatureUnit() {
      return this.ignoreTemperatureUnit;
   }

   public final IndoorAirRatingRanges getIndoorAirRatings() {
      return IndoorAirRatingRanges.Companion.instance(this.getDevice());
   }

   public final DeviceData getLastDeviceHistoricalData() {
      return (DeviceData)this._liveDeviceHistoricalData.getValue();
   }

   public final DeviceData getLastDeviceRealTimeData() {
      return (DeviceData)this._liveDeviceRealTimeData.getValue();
   }

   public final boolean getLastGraphExpended() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_GRAPH_EXPENDED_BEFORE_%s", Arrays.copyOf(new Object[]{this.getDeviceId()}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final SensorType getLastSelectedSensor() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_SELECTED_SENSOR_BEFORE_%s", Arrays.copyOf(new Object[]{this.getDeviceId()}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      String var5 = (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, "", Reflection.getOrCreateKotlinClass(String.class));

      label32:
      try {
         Result.Companion var8 = Result.Companion;
         DeviceSensorsViewModel var9 = this;
         var6 = Result.constructor-impl(SensorType.valueOf(var5));
      } catch (Throwable var4) {
         Result.Companion var7 = Result.Companion;
         var6 = Result.constructor-impl(ResultKt.createFailure(var4));
         break label32;
      }

      Object var10 = var6;
      if (Result.isFailure-impl(var6)) {
         var10 = null;
      }

      return (SensorType)var10;
   }

   public final LiveData getLiveAqiData() {
      return this.liveAqiData;
   }

   public final LiveData getLiveDevice() {
      return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(this.getDeviceManager().getFlowHasSensorDevice(this.getDeviceId())), ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final LiveData getLiveDeviceHistoricalData() {
      return Transformations.distinctUntilChanged((LiveData)this._liveDeviceHistoricalData);
   }

   public final LiveData getLiveDeviceLatestData() {
      return (LiveData)this.liveDeviceLatestData$delegate.getValue();
   }

   public final LiveData getLiveDeviceRealTimeData() {
      return Transformations.distinctUntilChanged((LiveData)this._liveDeviceRealTimeData);
   }

   public final LiveData getLiveFanSensorHistoricalData() {
      return Transformations.distinctUntilChanged((LiveData)this._liveFanSensorHistoricalData);
   }

   public final LiveData getLiveFanSensorRealTimeData() {
      return Transformations.distinctUntilChanged((LiveData)this._liveFanSensorRealTimeData);
   }

   public final LiveData getLiveLocation() {
      return this.liveLocation;
   }

   public final LiveData getLiveSelectedSensor() {
      return Transformations.distinctUntilChanged((LiveData)this.get_liveSelectedSensor());
   }

   public final LiveData getLiveSelectedSensorHistoricalData() {
      return (LiveData)this._liveSelectedSensorHistoricalData;
   }

   public final LiveData getLiveSelectedSensorRealTimeData() {
      return (LiveData)this._liveSelectedSensorRealTimeData;
   }

   public final LiveData getRealTimeDataListener() {
      return FlowLiveDataConversions.asLiveData$default(new Flow(this.getFlowDeviceRealTimeData(), this) {
         final Flow $this_unsafeTransform$inlined;
         final DeviceSensorsViewModel this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final DeviceSensorsViewModel this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label53: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var5 = (<undefinedtype>)var2;
                        if ((var5.label & Integer.MIN_VALUE) != 0) {
                           var5.label += Integer.MIN_VALUE;
                           var21 = var5;
                           break label53;
                        }
                     }

                     var21 = new ContinuationImpl(this, var2) {
                        int I$0;
                        int I$1;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        Object L$7;
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

                  FlowCollector var7;
                  FlowCollector var8;
                  Object var14;
                  int var22;
                  Object var27;
                  Object var31;
                  MutableLiveData var34;
                  Object var36;
                  label56: {
                     var27 = ((<undefinedtype>)var21).result;
                     var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     var22 = ((<undefinedtype>)var21).label;
                     int var4;
                     DeviceData var9;
                     Continuation var10;
                     MutableLiveData var12;
                     Object var13;
                     if (var22 != 0) {
                        if (var22 != 1) {
                           if (var22 != 2) {
                              if (var22 != 3) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              var22 = ((<undefinedtype>)var21).I$0;
                              FlowCollector var17 = (FlowCollector)((<undefinedtype>)var21).L$3;
                              Object var18 = ((<undefinedtype>)var21).L$2;
                              <undefinedtype> var19 = (<undefinedtype>)((<undefinedtype>)var21).L$1;
                              Object var20 = ((<undefinedtype>)var21).L$0;
                              ResultKt.throwOnFailure(var27);
                              return Unit.INSTANCE;
                           }

                           var22 = ((<undefinedtype>)var21).I$1;
                           var22 = ((<undefinedtype>)var21).I$0;
                           var34 = (MutableLiveData)((<undefinedtype>)var21).L$7;
                           var1 = (DeviceData)((<undefinedtype>)var21).L$6;
                           Continuation var16 = (Continuation)((<undefinedtype>)var21).L$5;
                           var8 = (FlowCollector)((<undefinedtype>)var21).L$4;
                           var7 = (FlowCollector)((<undefinedtype>)var21).L$3;
                           Object var37 = ((<undefinedtype>)var21).L$2;
                           var31 = (<undefinedtype>)((<undefinedtype>)var21).L$1;
                           var1 = (DeviceData)((<undefinedtype>)var21).L$0;
                           ResultKt.throwOnFailure(var27);
                           var36 = var27;
                           var27 = var37;
                           break label56;
                        }

                        var4 = ((<undefinedtype>)var21).I$1;
                        var22 = ((<undefinedtype>)var21).I$0;
                        var12 = (MutableLiveData)((<undefinedtype>)var21).L$7;
                        var9 = (DeviceData)((<undefinedtype>)var21).L$6;
                        var10 = (Continuation)((<undefinedtype>)var21).L$5;
                        var8 = (FlowCollector)((<undefinedtype>)var21).L$4;
                        var7 = (FlowCollector)((<undefinedtype>)var21).L$3;
                        var31 = ((<undefinedtype>)var21).L$2;
                        <undefinedtype> var11 = (<undefinedtype>)((<undefinedtype>)var21).L$1;
                        var1 = (DeviceData)((<undefinedtype>)var21).L$0;
                        ResultKt.throwOnFailure(var27);
                        var13 = var27;
                        var27 = var11;
                     } else {
                        ResultKt.throwOnFailure(var27);
                        var8 = this.$this_unsafeFlow;
                        var10 = (Continuation)var21;
                        var9 = var1;
                        Timber.Forest var32 = Timber.Forest;
                        StringBuilder var33 = new StringBuilder("dataListener: data.size = ");
                        List var28 = var9.getRawDataPoints();
                        Integer var29;
                        if (var28 != null) {
                           var29 = Boxing.boxInt(var28.size());
                        } else {
                           var29 = null;
                        }

                        var33.append(var29);
                        var33.append(", thread = ");
                        var33.append(Thread.currentThread());
                        var32.d(var33.toString(), new Object[0]);
                        this.this$0._liveDeviceRealTimeData.postValue(var9);
                        var12 = this.this$0._liveSelectedSensorRealTimeData;
                        DeviceSensorsViewModel var30 = this.this$0;
                        ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var21);
                        ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var8);
                        ((<undefinedtype>)var21).L$4 = var8;
                        ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var10);
                        ((<undefinedtype>)var21).L$6 = var9;
                        ((<undefinedtype>)var21).L$7 = var12;
                        ((<undefinedtype>)var21).I$0 = 0;
                        ((<undefinedtype>)var21).I$1 = 0;
                        ((<undefinedtype>)var21).label = 1;
                        Object var38 = var30.getSelectedSensorData(var9, (Continuation)var21);
                        if (var38 == var14) {
                           return var14;
                        }

                        var31 = var1;
                        var7 = var8;
                        var22 = 0;
                        var27 = var21;
                        var4 = 0;
                        var13 = var38;
                     }

                     var12.postValue(var13);
                     MutableLiveData var39 = this.this$0._liveFanSensorRealTimeData;
                     Companion var41 = DeviceSensorsViewModel.Companion;
                     SensorType var42 = SensorType.FAN;
                     ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var27);
                     ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var31);
                     ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var7);
                     ((<undefinedtype>)var21).L$4 = var8;
                     ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var10);
                     ((<undefinedtype>)var21).L$6 = SpillingKt.nullOutSpilledVariable(var9);
                     ((<undefinedtype>)var21).L$7 = var39;
                     ((<undefinedtype>)var21).I$0 = var22;
                     ((<undefinedtype>)var21).I$1 = var4;
                     ((<undefinedtype>)var21).label = 2;
                     var36 = DeviceSensorsViewModel.Companion.getSensorData$default(var41, var9, var42, false, (Continuation)var21, 4, (Object)null);
                     if (var36 == var14) {
                        return var14;
                     }

                     var34 = var39;
                     Object var40 = var31;
                     var31 = var27;
                     var27 = var40;
                  }

                  var34.postValue(var36);
                  Boolean var35 = Boxing.boxBoolean(true);
                  ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                  ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var31);
                  ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var27);
                  ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var7);
                  ((<undefinedtype>)var21).L$4 = null;
                  ((<undefinedtype>)var21).L$5 = null;
                  ((<undefinedtype>)var21).L$6 = null;
                  ((<undefinedtype>)var21).L$7 = null;
                  ((<undefinedtype>)var21).I$0 = var22;
                  ((<undefinedtype>)var21).label = 3;
                  if (var8.emit(var35, (Continuation)var21) == var14) {
                     return var14;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final SensorType getSelectedSensor() {
      SensorType var2 = (SensorType)this.get_liveSelectedSensor().getValue();
      SensorType var1 = var2;
      if (var2 == null) {
         var1 = this.getDefaultSelectedSensor();
      }

      return var1;
   }

   public final SensorType getSensorAtPos(int var1) {
      return (SensorType)CollectionsKt.getOrNull(this.getSupportedSensors(), var1);
   }

   public final int getSensorPos(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      return this.getSupportedSensors().indexOf(var1);
   }

   public final boolean getShowFanHistory() {
      return (Boolean)this.showFanHistory$delegate.getValue();
   }

   public final boolean getSupportPM25() {
      return (Boolean)this.supportPM25$delegate.getValue();
   }

   public final boolean getSupportParticles() {
      return (Boolean)this.supportParticles$delegate.getValue();
   }

   public final List getSupportedSensorTabs() {
      return (List)this.supportedSensorTabs$delegate.getValue();
   }

   public final List getSupportedSensors() {
      return (List)this.supportedSensors$delegate.getValue();
   }

   public final void init(HasSensorData var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.updateDevice(var1);
      this.ignoreTemperatureUnit = var2;
   }

   public final boolean isTempCelsius() {
      return this.getDevice() instanceof HasTemperatureUnit ? DeviceKt.isCelsiusUnit(this.getDevice()) : this.getPrefs().isTempCelsius();
   }

   public final void refresh() {
      CoroutineScope var2 = this;
      BuildersKt.launch$default(var2, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DeviceSensorsViewModel this$0;

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
               var1 = this.this$0.getDeviceManager();
               Device var5 = this.this$0.getDevice();
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var1.downloadHistoricalDataForDevice(var5, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
      TrackedLocation var1 = (TrackedLocation)this.liveLocation.getValue();
      if (var1 != null) {
         BuildersKt.launch$default(var2, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final TrackedLocation $location;
            int label;
            final DeviceSensorsViewModel this$0;

            {
               this.this$0 = var1;
               this.$location = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$location, var2));
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
                  OutdoorService var4 = this.this$0.getOutdoorService();
                  var1 = this.$location;
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (OutdoorService.fetchAqiData$default(var4, var1, false, var5, 2, (Object)null) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

   }

   public final void selectSensor(SensorType var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("selectSensor: ");
      var3.append(var1);
      var3.append(" | ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
      if (var2) {
         this.graphExpended.setValue(true);
      }

      this.get_liveSelectedSensor().setValue(var1);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceSensorsViewModel this$0;

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
            MutableLiveData var8;
            label39: {
               Object var4;
               label34: {
                  var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var8 = (MutableLiveData)this.L$1;
                        DeviceData var9 = (DeviceData)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        break label39;
                     }

                     var8 = (MutableLiveData)this.L$1;
                     DeviceData var5 = (DeviceData)this.L$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     var1 = this.this$0.getLastDeviceRealTimeData();
                     if (var1 == null) {
                        break label34;
                     }

                     DeviceSensorsViewModel var10 = this.this$0;
                     var8 = var10._liveSelectedSensorRealTimeData;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     this.L$1 = var8;
                     this.I$0 = 0;
                     this.label = 1;
                     var1 = (DeviceData)var10.getSelectedSensorData(var1, this);
                     if (var1 == var4) {
                        return var4;
                     }
                  }

                  var8.setValue(var1);
               }

               DeviceData var11 = this.this$0.getLastDeviceHistoricalData();
               if (var11 == null) {
                  return Unit.INSTANCE;
               }

               DeviceSensorsViewModel var7 = this.this$0;
               var8 = var7._liveSelectedSensorHistoricalData;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var11);
               this.L$1 = var8;
               this.I$0 = 0;
               this.label = 2;
               var1 = (DeviceData)var7.getSelectedSensorData(var11, this);
               if (var1 == var4) {
                  return var4;
               }
            }

            var8.setValue(var1);
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setLastGraphExpended(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_GRAPH_EXPENDED_BEFORE_%s", Arrays.copyOf(new Object[]{this.getDeviceId()}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setLastSelectedSensor(SensorType var1) {
      Prefs var3;
      String var4;
      label11: {
         var3 = this.getPrefs();
         var4 = String.format("KEY_SELECTED_SENSOR_BEFORE_%s", Arrays.copyOf(new Object[]{this.getDeviceId()}, 1));
         Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
         if (var1 != null) {
            String var2 = var1.name();
            var5 = var2;
            if (var2 != null) {
               break label11;
            }
         }

         var5 = "";
      }

      PreferencesHelper.INSTANCE.set(var3.getBackend(), var4, var5, Reflection.getOrCreateKotlinClass(String.class));
   }

   public final void updateDevice(HasSensorData var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.device = var1;
      this._deviceStandby.setValue(DeviceKt.isStandByOn(var1));
      MutableLiveData var3 = this._deviceOffline;
      boolean var2;
      if (var1.getConnectivityStatusIndex() != ConnectivityStatus.ONLINE.ordinal()) {
         var2 = true;
      } else {
         var2 = false;
      }

      var3.setValue(var2);
      if (var1 instanceof HasLocation) {
         TrackedLocation var4 = (TrackedLocation)this.liveLocation.getValue();
         String var5;
         if (var4 != null) {
            var5 = var4.getId();
         } else {
            var5 = null;
         }

         if (!Intrinsics.areEqual(var5, ((HasLocation)var1).getLocationId())) {
            BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
               final HasSensorData $device;
               int label;
               final DeviceSensorsViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$device = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     OutdoorService var5 = this.this$0.getOutdoorService();
                     String var3 = ((HasLocation)this.$device).getLocationId();
                     String var6 = var3;
                     if (var3 == null) {
                        var6 = "";
                     }

                     Continuation var8 = (Continuation)this;
                     this.label = 1;
                     Object var9 = var5.getTrackedLocation(var6, var8);
                     var1 = (TrackedLocation)var9;
                     if (var9 == var4) {
                        return var4;
                     }
                  }

                  var1 = var1;
                  this.this$0._liveLocation.postValue(var1);
                  return Unit.INSTANCE;
               }
            }, 2, (Object)null);
         }
      }

   }

   @Metadata(
      d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0083@¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0083@¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
      d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel$Companion;", "", "<init>", "()V", "sensorList", "", "Lcom/blueair/core/model/SensorType;", "sensorListV2", "getSensorData", "Lcom/blueair/core/model/SimpleDatapoint;", "data", "Lcom/blueair/core/model/DeviceData;", "sensor", "ignoreTemperatureUnit", "", "(Lcom/blueair/core/model/DeviceData;Lcom/blueair/core/model/SensorType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPollutantData", "datapoints", "Lcom/blueair/core/model/AqiData;", "pollutant", "Lcom/blueair/core/model/PollutantType;", "(Ljava/util/List;Lcom/blueair/core/model/PollutantType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"},
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

      private final Object getPollutantData(List var1, PollutantType var2, Continuation var3) {
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var7 = new StringBuilder("getSelectedSensorData thread = ");
         var7.append(Thread.currentThread());
         var26.d(var7.toString(), new Object[0]);
         Iterable var10 = (Iterable)var1;
         Collection var28 = (Collection)(new ArrayList());

         for(AqiData var9 : var10) {
            label67: {
               boolean var4 = Intrinsics.areEqual(var2, PollutantType.PM25.INSTANCE);
               var27 = null;
               if (var4) {
                  OutdoorPollutants var11 = var9.getPollutants();
                  if (var11 != null) {
                     Pollutant var12 = var11.getPm25();
                     if (var12 != null) {
                        var13 = var12.getConcentration();
                        break label67;
                     }
                  }
               } else if (Intrinsics.areEqual(var2, PollutantType.PM10.INSTANCE)) {
                  OutdoorPollutants var14 = var9.getPollutants();
                  if (var14 != null) {
                     Pollutant var15 = var14.getPm10();
                     if (var15 != null) {
                        var13 = var15.getConcentration();
                        break label67;
                     }
                  }
               } else if (Intrinsics.areEqual(var2, PollutantType.AQI.INSTANCE)) {
                  OutdoorPollutants var16 = var9.getPollutants();
                  if (var16 != null) {
                     Pollutant var17 = var16.getAqi();
                     if (var17 != null) {
                        var13 = var17.getConcentration();
                        break label67;
                     }
                  }
               } else if (Intrinsics.areEqual(var2, PollutantType.CO.INSTANCE)) {
                  OutdoorPollutants var18 = var9.getPollutants();
                  if (var18 != null) {
                     Pollutant var19 = var18.getCo();
                     if (var19 != null) {
                        var13 = var19.getConcentration();
                        break label67;
                     }
                  }
               } else if (Intrinsics.areEqual(var2, PollutantType.NO2.INSTANCE)) {
                  OutdoorPollutants var20 = var9.getPollutants();
                  if (var20 != null) {
                     Pollutant var21 = var20.getNo2();
                     if (var21 != null) {
                        var13 = var21.getConcentration();
                        break label67;
                     }
                  }
               } else if (Intrinsics.areEqual(var2, PollutantType.O3.INSTANCE)) {
                  OutdoorPollutants var22 = var9.getPollutants();
                  if (var22 != null) {
                     Pollutant var23 = var22.getO3();
                     if (var23 != null) {
                        var13 = var23.getConcentration();
                        break label67;
                     }
                  }
               } else if (Intrinsics.areEqual(var2, PollutantType.SO2.INSTANCE)) {
                  OutdoorPollutants var24 = var9.getPollutants();
                  if (var24 != null) {
                     Pollutant var25 = var24.getSo2();
                     if (var25 != null) {
                        var13 = var25.getConcentration();
                        break label67;
                     }
                  }
               }

               var13 = null;
            }

            long var5 = var9.getDatetime();
            if (var13 != null) {
               var27 = new SimpleDatapoint(var5, (float)var13);
            }

            if (var27 != null) {
               var28.add(var27);
            }
         }

         return (List)var28;
      }

      private final Object getSensorData(DeviceData var1, SensorType var2, boolean var3, Continuation var4) {
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("getSelectedSensorData thread = ");
         var6.append(Thread.currentThread());
         var5.d(var6.toString(), new Object[0]);
         return var1.toSimpleDataPoints(var2, var3);
      }

      // $FF: synthetic method
      static Object getSensorData$default(Companion var0, DeviceData var1, SensorType var2, boolean var3, Continuation var4, int var5, Object var6) {
         if ((var5 & 4) != 0) {
            var3 = false;
         }

         return var0.getSensorData(var1, var2, var3, var4);
      }
   }
}
