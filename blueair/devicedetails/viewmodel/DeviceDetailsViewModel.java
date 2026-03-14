package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.format.DateFormat;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.api.restapi.AntiFakeResetResp;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.Device$_CC;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.Filter;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasDisplayMode;
import com.blueair.core.model.HasDualOscillation;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasGestureRecognition;
import com.blueair.core.model.HasHinsMode;
import com.blueair.core.model.HasHourFormat;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasMoodLamp;
import com.blueair.core.model.HasNightLamp;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasSensorMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWaterTank;
import com.blueair.core.model.HasWeight;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.OscillationState;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SkuConfiguration;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.core.util.PhoneUtil;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.devicedetails.util.DeviceAttribute;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.StatusLabelState;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0013\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010¥\u0001\u001a\u00030¦\u00012\u001b\u0010§\u0001\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\u0005\u0012\u00030¦\u00010¨\u0001J\b\u0010©\u0001\u001a\u00030¦\u0001J\n\u0010ª\u0001\u001a\u00030¦\u0001H\u0002J\u001e\u0010«\u0001\u001a\u00030¬\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001JR\u0010±\u0001\u001a\u00030¬\u0001\"\u000b\b\u0000\u0010²\u0001\u0018\u0001*\u00020,2\u0006\u0010D\u001a\u00020,2*\b\u0004\u0010³\u0001\u001a#\b\u0001\u0012\u0005\u0012\u0003H²\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030¦\u00010µ\u0001\u0012\u0007\u0012\u0005\u0018\u00010¶\u00010´\u0001H\u0082\b¢\u0006\u0003\u0010·\u0001J\u001a\u0010¸\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010¹\u0001\u001a\u00030º\u0001J\u0019\u0010»\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010¼\u0001\u001a\u000205J\u0010\u0010½\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010¾\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010¿\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010À\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u001a\u0010Á\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Â\u0001\u001a\u00030Ã\u0001J\u001a\u0010Á\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Â\u0001\u001a\u00030Ä\u0001J\u0010\u0010Å\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010Æ\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u001a\u0010Ç\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010È\u0001\u001a\u00030Ä\u0001J\u001a\u0010É\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ê\u0001\u001a\u00030Ä\u0001J\u001a\u0010Ë\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ì\u0001\u001a\u00030Ä\u0001J\u001a\u0010Í\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ì\u0001\u001a\u00030Ä\u0001J\u0010\u0010Î\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010Ï\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010Ð\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010Ñ\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010Ò\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J.\u0010Ó\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ô\u0001\u001a\u00030Ä\u00012\b\u0010Õ\u0001\u001a\u00030Ä\u00012\b\u0010Ö\u0001\u001a\u00030Ä\u0001J\u0010\u0010×\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010Ø\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J$\u0010Ù\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u00012\t\b\u0002\u0010Ú\u0001\u001a\u000205J\u0019\u0010Û\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010Ü\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010Ý\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010Þ\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030ß\u0001J\u0019\u0010à\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030ß\u0001J\u0019\u0010á\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010â\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010ã\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010ä\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J&\u0010å\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010æ\u0001\u001a\u00030Ä\u00012\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001J&\u0010é\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010æ\u0001\u001a\u00030Ä\u00012\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001J\u0010\u0010ê\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010ë\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010ì\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0010\u0010í\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010î\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010ï\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0010\u0010ð\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010ñ\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0010\u0010ò\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010ó\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010ô\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010õ\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0019\u0010ö\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u001a\u0010÷\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ì\u0001\u001a\u00030Ä\u0001J\u0018\u0010ø\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0006\u0010?\u001a\u000205Ja\u0010ù\u0001\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010ú\u0001\u001a\u00030Ä\u00012\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u000123\b\u0002\u0010§\u0001\u001a,\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030þ\u00010ý\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030¦\u00010µ\u0001\u0012\u0007\u0012\u0005\u0018\u00010¶\u0001\u0018\u00010´\u0001¢\u0006\u0003\u0010ÿ\u0001J$\u0010\u0080\u0002\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\b\u0010\u0081\u0002\u001a\u00030Ä\u00012\b\u0010\u0082\u0002\u001a\u00030Ä\u0001J\u0010\u0010\u0083\u0002\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010\u0084\u0002\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Ä\u0001J\u0018\u0010\u0085\u0002\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,2\u0006\u0010?\u001a\u000205J\u0010\u0010\u0086\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010\u0087\u0002\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010\u0088\u0002\u001a\u00030¬\u00012\u0006\u0010D\u001a\u00020,J8\u0010\u0089\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010\u008a\u0002\u001a\u0002052\b\u0010\u008b\u0002\u001a\u00030\u008c\u00022\b\u0010\u008d\u0002\u001a\u00030\u008e\u00022\t\b\u0002\u0010\u008f\u0002\u001a\u000205J\u0012\u0010\u0090\u0002\u001a\u00030¦\u00012\b\u0010\u0091\u0002\u001a\u00030\u0092\u0002J\u001c\u0010\u0090\u0002\u001a\u00030¦\u00012\b\u0010\u0093\u0002\u001a\u00030\u0092\u00022\b\u0010\u0094\u0002\u001a\u00030\u0092\u0002J\u0011\u0010\u0095\u0002\u001a\u00030¦\u00012\u0007\u0010\u008a\u0002\u001a\u000205J#\u0010\u0096\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,2\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0086@¢\u0006\u0003\u0010\u0099\u0002J\u0011\u0010\u009a\u0002\u001a\u0002052\b\u0010D\u001a\u0004\u0018\u00010,J\u001a\u0010\u009f\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,2\b\u0010 \u0002\u001a\u00030¡\u0002J@\u0010¢\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010£\u0002\u001a\u0002052\u0007\u0010¤\u0002\u001a\u0002052\b\u0010¥\u0002\u001a\u00030¡\u00022\u0007\u0010¦\u0002\u001a\u00020:2\t\b\u0002\u0010§\u0002\u001a\u000205J$\u0010¨\u0002\u001a\u00030¦\u00012\b\u0010©\u0002\u001a\u00030ª\u00022\u0007\u0010«\u0002\u001a\u00020:2\u0007\u0010¬\u0002\u001a\u00020:J\u0007\u0010\u00ad\u0002\u001a\u000205J\u0019\u0010®\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010¯\u0002\u001a\u00020:J\u0010\u0010°\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010±\u0002\u001a\u00030¦\u00012\u0006\u0010D\u001a\u00020,H\u0086@¢\u0006\u0003\u0010²\u0002J\b\u0010³\u0002\u001a\u00030¦\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000*8F¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u00020:2\u0006\u0010?\u001a\u00020:@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R/\u0010D\u001a\u0004\u0018\u00010,2\b\u0010C\u001a\u0004\u0018\u00010,8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0*¢\u0006\b\n\u0000\u001a\u0004\bN\u0010.R\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0*8F¢\u0006\u0006\u001a\u0004\bP\u0010.R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0*8F¢\u0006\u0006\u001a\u0004\bS\u0010.R+\u0010U\u001a\u00020T2\u0006\u0010C\u001a\u00020T8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010J\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010\\\u001a\u00020[2\u0006\u0010C\u001a\u00020[8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010J\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R/\u0010c\u001a\u0004\u0018\u00010b2\b\u0010C\u001a\u0004\u0018\u00010b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bh\u0010J\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u0002050*8F¢\u0006\u0006\u001a\u0004\bk\u0010.R\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u0002050*¢\u0006\b\n\u0000\u001a\u0004\bn\u0010.R\u001a\u0010o\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00106\"\u0004\bq\u00108R\u001a\u0010r\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00106\"\u0004\bt\u00108R\u001a\u0010u\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00106\"\u0004\bw\u00108R\u001a\u0010x\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00106\"\u0004\bz\u00108R\u000e\u0010{\u001a\u00020|X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u007f\u001a\b\u0012\u0004\u0012\u0002050*¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010.R'\u0010\u0081\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u00106\"\u0005\b\u0083\u0001\u00108R'\u0010\u0084\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u00106\"\u0005\b\u0086\u0001\u00108R'\u0010\u0087\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u00106\"\u0005\b\u0089\u0001\u00108R'\u0010\u008a\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u00106\"\u0005\b\u008c\u0001\u00108R'\u0010\u008d\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u00106\"\u0005\b\u008f\u0001\u00108R'\u0010\u0090\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u00106\"\u0005\b\u0092\u0001\u00108R'\u0010\u0093\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u00106\"\u0005\b\u0095\u0001\u00108R'\u0010\u0096\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u00106\"\u0005\b\u0098\u0001\u00108R'\u0010\u0099\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u00106\"\u0005\b\u009b\u0001\u00108R'\u0010\u009c\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009d\u0001\u00106\"\u0005\b\u009e\u0001\u00108R'\u0010\u009f\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b \u0001\u00106\"\u0005\b¡\u0001\u00108R'\u0010¢\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u00106\"\u0005\b¤\u0001\u00108R\u0016\u0010\u009b\u0002\u001a\t\u0012\u0005\u0012\u00030\u009c\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u009d\u0002\u001a\t\u0012\u0005\u0012\u00030\u009c\u00020*¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0002\u0010.¨\u0006´\u0002"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "getMapType", "()Lcom/blueair/auth/LocationService$MapType;", "currentTimeFormatter", "Ljava/text/SimpleDateFormat;", "getCurrentTimeFormatter", "()Ljava/text/SimpleDateFormat;", "currentTimeFormatter$delegate", "liveDevices", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/Device;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "deviceDetailsState", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsState;", "getDeviceDetailsState", "_deviceDetailsState", "Landroidx/lifecycle/MutableLiveData;", "isAttachedToDeviceDetailsDialogFragment", "", "()Z", "setAttachedToDeviceDetailsDialogFragment", "(Z)V", "actionType", "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "value", "deviceId", "getDeviceId", "setDeviceId", "<set-?>", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "device$delegate", "Lkotlin/properties/ReadWriteProperty;", "_liveLocation", "Lcom/blueair/core/model/TrackedLocation;", "liveLocation", "getLiveLocation", "liveDevice", "getLiveDevice", "liveLatestDataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getLiveLatestDataPoint", "Lcom/blueair/core/model/SensorType;", "selectedSensorType", "getSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "setSelectedSensorType", "(Lcom/blueair/core/model/SensorType;)V", "selectedSensorType$delegate", "Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "selectedSettingsType", "getSelectedSettingsType", "()Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "setSelectedSettingsType", "(Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;)V", "selectedSettingsType$delegate", "Lcom/blueair/core/model/DeviceData;", "deviceData", "getDeviceData", "()Lcom/blueair/core/model/DeviceData;", "setDeviceData", "(Lcom/blueair/core/model/DeviceData;)V", "deviceData$delegate", "_networkAvailable", "networkAvailable", "getNetworkAvailable", "_deviceOffline", "deviceOffline", "getDeviceOffline", "bannerBodyNotMountedClosed", "getBannerBodyNotMountedClosed", "setBannerBodyNotMountedClosed", "bannerFilterExpiredClosed", "getBannerFilterExpiredClosed", "setBannerFilterExpiredClosed", "bannerWickExpiredClosed", "getBannerWickExpiredClosed", "setBannerWickExpiredClosed", "bannerWaterShortageClosed", "getBannerWaterShortageClosed", "setBannerWaterShortageClosed", "lastFilterPurchaseClickTime", "", "autoModeClickedBefore", "_autoModeFirstClicked", "autoModeFirstClicked", "getAutoModeFirstClicked", "autoRefreshHintClosedBefore", "getAutoRefreshHintClosedBefore", "setAutoRefreshHintClosedBefore", "controlsHintClosedBefore", "getControlsHintClosedBefore", "setControlsHintClosedBefore", "humHintClosedBefore", "getHumHintClosedBefore", "setHumHintClosedBefore", "skinHintClosedBefore", "getSkinHintClosedBefore", "setSkinHintClosedBefore", "smartHintClosedBefore", "getSmartHintClosedBefore", "setSmartHintClosedBefore", "heatingHintClosedBefore", "getHeatingHintClosedBefore", "setHeatingHintClosedBefore", "cantHeatHintClosedBefore", "getCantHeatHintClosedBefore", "setCantHeatHintClosedBefore", "sunRiseLightHintClosedBefore", "getSunRiseLightHintClosedBefore", "setSunRiseLightHintClosedBefore", "oscillationAngleHintClosedBefore", "getOscillationAngleHintClosedBefore", "setOscillationAngleHintClosedBefore", "oscillationResetPosHintClosedBefore", "getOscillationResetPosHintClosedBefore", "setOscillationResetPosHintClosedBefore", "oscillationLoopHintClosedBefore", "getOscillationLoopHintClosedBefore", "setOscillationLoopHintClosedBefore", "nightSleepHintClosedBefore", "getNightSleepHintClosedBefore", "setNightSleepHintClosedBefore", "getDevices", "", "onResult", "Lkotlin/Function1;", "updateEverything", "updateState", "linkDeviceSelected", "Lkotlinx/coroutines/Job;", "parentDevice", "Lcom/blueair/core/model/HasLinkingCapability;", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "setActuator", "T", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "fanspeedSliderChanged", "nuFanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "autoModeChanged", "nuMode", "setManualMode", "standByChanged", "ecoModeChanged", "g4NightModeChanged", "brightnessChanged", "brightness", "Lcom/blueair/core/model/Brightness;", "", "wickDryCanceled", "wickDryEnabledChanged", "autorhChanged", "autorh", "timerStatusChanged", "status", "timerDurationChanged", "duration", "updateTimerDurationAndRestart", "childLockChanged", "germShieldChanged", "disinfectionChanged", "gsnmChanged", "oscillationStateChanged", "setOscillationParams", "angle", "direction", "fanSpeed", "temperatureUnitChanged", "setMainMode", "setApSubMode", "overwriteMainMode", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolFanSpeedLevel", "setCoolAutoLevel", "setCoolAutoPresets", "tag", "presets", "", "setCoolEcoPresets", "hinsModeChanged", "hinsNightModeChanged", "setMode", "humModeChanged", "setDehSubMode", "setSmartSubMode", "setTare", "setPanelDisplayMode", "hoverEnabledChanged", "setAutoRefreshStatus", "setNightLampBrightness", "setNightLampSteplessBrightness", "setWickDryDuration", "updateWickDryDurationAndRestart", "setYwrmEnabled", "setAlarm", "index", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "(Lcom/blueair/core/model/Device;ILcom/blueair/core/model/DeviceAlarm;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "playAlarm", "sound", "volume", "stopAlarm", "setHumSubMode", "setUse24Hour", "autoRefreshEnabledChanged", "sensorModeChange", "oscillationModeChange", "setDualOscillationConfig", "horizontal", "state", "Lcom/blueair/core/model/OscillationState;", "newConfig", "Lcom/blueair/core/model/DualOscillationConfig;", "onlyUpdateState", "autoModeFilterTriggerChanged", "nuFilterTrigger", "Lcom/blueair/core/model/FilterTrigger;", "nuAutoModeFilterTrigger", "nuG4NightModeFilterTrigger", "resetOscillationPosition", "setFilter", "nuFilter", "Lcom/blueair/core/model/Filter;", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/Filter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceSupportAntiFake", "_resetFilterLifeResult", "Lcom/blueair/devicedetails/viewmodel/FilterLifeResetResult;", "resetFilterLifeResult", "getResetFilterLifeResult", "resetFilterLife", "type", "Lcom/blueair/core/model/DeviceFilterType;", "analyticsLogFilterClickEvent", "isPurchase", "isSelect", "filterType", "filterName", "fromNotification", "openFilterUrl", "context", "Landroid/content/Context;", "url", "title", "isInWelcomeHomeRegion", "setDeviceName", "nuName", "removeDevice", "removeDeviceWithLock", "(Lcom/blueair/core/model/Device;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureUseProtectRegion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetailsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceDetailsViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceDetailsViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceDetailsViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceDetailsViewModel.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceDetailsViewModel.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DeviceDetailsViewModel.class, "device", "getDevice()Lcom/blueair/core/model/Device;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DeviceDetailsViewModel.class, "selectedSensorType", "getSelectedSensorType()Lcom/blueair/core/model/SensorType;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DeviceDetailsViewModel.class, "selectedSettingsType", "getSelectedSettingsType()Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DeviceDetailsViewModel.class, "deviceData", "getDeviceData()Lcom/blueair/core/model/DeviceData;", 0)))};
   private final MutableLiveData _autoModeFirstClicked;
   private final MutableLiveData _deviceDetailsState;
   private final MutableLiveData _deviceOffline;
   private final MutableLiveData _liveLocation;
   private final MutableLiveData _networkAvailable;
   private final MutableLiveData _resetFilterLifeResult;
   private String actionType;
   private final Lazy authService$delegate;
   private boolean autoModeClickedBefore;
   private final LiveData autoModeFirstClicked;
   private boolean bannerBodyNotMountedClosed;
   private boolean bannerFilterExpiredClosed;
   private boolean bannerWaterShortageClosed;
   private boolean bannerWickExpiredClosed;
   private final Lazy currentTimeFormatter$delegate;
   private final ReadWriteProperty device$delegate;
   private final ReadWriteProperty deviceData$delegate;
   private String deviceId;
   private final LiveData deviceOffline;
   private boolean isAttachedToDeviceDetailsDialogFragment;
   private long lastFilterPurchaseClickTime;
   private final LiveData liveDevices;
   private final LiveData liveLocation;
   private final Lazy locationService$delegate;
   private final Lazy networkMonitor$delegate;
   private final Lazy outdoorService$delegate;
   private final Lazy prefs$delegate;
   private final LiveData resetFilterLifeResult;
   private final ReadWriteProperty selectedSensorType$delegate;
   private final ReadWriteProperty selectedSettingsType$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$19J23CV_JqBT4iqESg0_MV_0OUM(MediatorLiveData var0, DeviceDetailsViewModel var1, Boolean var2) {
      return deviceOffline$lambda$8$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$ZNnIxVcMsMLgGNl1PEW5dcb9__Y/* $FF was: $r8$lambda$ZNnIxVcMsMLgGNl1PEW5dcb9--Y*/(Application var0) {
      return currentTimeFormatter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$x0nrYqcuYQ_DEARHAnTkrFj_dFQ/* $FF was: $r8$lambda$x0nrYqcuYQ_DEARHAnTkrFj-dFQ*/(MediatorLiveData var0, DeviceDetailsViewModel var1, Boolean var2) {
      return deviceOffline$lambda$8$lambda$6(var0, var1, var2);
   }

   public DeviceDetailsViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var3 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var5 = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null);
      KProperty[] var4 = $$delegatedProperties;
      Boolean var15 = false;
      this.authService$delegate = var5.provideDelegate(this, var4[0]);
      JVMTypeToken var18 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var18, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var18, LocationService.class)), (Object)null).provideDelegate(this, var4[1]);
      var18 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var18, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.outdoorService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var18, OutdoorService.class)), (Object)null).provideDelegate(this, var4[2]);
      var18 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var18, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var18, NetworkMonitor.class)), (Object)null).provideDelegate(this, var4[3]);
      var18 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var18, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var18, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var4[4]);
      this.currentTimeFormatter$delegate = LazyKt.lazy(new DeviceDetailsViewModel$$ExternalSyntheticLambda0(var1));
      this.liveDevices = this.getDeviceManager().getLiveDevices();
      this._deviceDetailsState = new MutableLiveData();
      this.deviceId = "";
      Delegates var6 = Delegates.INSTANCE;
      this.device$delegate = (ReadWriteProperty)(new ObservableProperty((Object)null, this) {
         final DeviceDetailsViewModel this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            var3 = var3;
            Device var21 = (Device)var2;
            MutableLiveData var23 = this.this$0._deviceOffline;
            boolean var4;
            if (var3 != null && var3.getConnectivityStatusIndex() == ConnectivityStatus.ONLINE.ordinal()) {
               var4 = true;
            } else {
               var4 = false;
            }

            var23.postValue(var4 ^ true);
            String var24;
            if (var21 != null) {
               var24 = var21.getUid();
            } else {
               var24 = null;
            }

            String var37;
            if (var3 != null) {
               var37 = var3.getUid();
            } else {
               var37 = null;
            }

            boolean var5;
            label273: {
               if (Intrinsics.areEqual(var24, var37)) {
                  if (var21 != null) {
                     var24 = var21.getName();
                  } else {
                     var24 = null;
                  }

                  if (var3 != null) {
                     var37 = var3.getName();
                  } else {
                     var37 = null;
                  }

                  if (Intrinsics.areEqual(var24, var37)) {
                     var5 = true;
                     break label273;
                  }
               }

               var5 = false;
            }

            if (var21 != null) {
               var24 = var21.getModelName();
            } else {
               var24 = null;
            }

            if (var3 != null) {
               var37 = var3.getModelName();
            } else {
               var37 = null;
            }

            boolean var19 = Intrinsics.areEqual(var24, var37);
            TimeZone var27;
            if (var21 != null) {
               var27 = Device$_CC.getTimezone$default(var21, (Context)null, 1, (Object)null);
            } else {
               var27 = null;
            }

            TimeZone var40;
            if (var3 != null) {
               var40 = Device$_CC.getTimezone$default(var3, (Context)null, 1, (Object)null);
            } else {
               var40 = null;
            }

            boolean var18 = Intrinsics.areEqual(var27, var40);
            boolean var10 = var21 instanceof HasFanSpeed;
            boolean var6;
            if (!var10 || !(var3 instanceof HasFanSpeed) || DeviceKt.fanSpeedValue(var21) == DeviceKt.fanSpeedValue(var3) && ((HasFanSpeed)var21).getAutoMode() == ((HasFanSpeed)var3).getAutoMode()) {
               var6 = true;
            } else {
               var6 = false;
            }

            boolean var7;
            if (var21 instanceof HasBrightness && var3 instanceof HasBrightness && ((HasBrightness)var21).getBrightness() != ((HasBrightness)var3).getBrightness()) {
               var7 = false;
            } else {
               var7 = true;
            }

            boolean var8;
            if (var21 instanceof HasChildLock && var3 instanceof HasChildLock && ((HasChildLock)var21).isChildLockOn() != ((HasChildLock)var3).isChildLockOn()) {
               var8 = false;
            } else {
               var8 = true;
            }

            boolean var9;
            if (var21 instanceof HasSafetySwitch && var3 instanceof HasSafetySwitch && ((HasSafetySwitch)var21).isSafetySwitchOn() != ((HasSafetySwitch)var3).isSafetySwitchOn()) {
               var9 = false;
            } else {
               var9 = true;
            }

            label237: {
               if (var10 && var3 instanceof HasFanSpeed) {
                  HasFanSpeed var28 = (HasFanSpeed)var21;
                  Filter var22 = var28.getFilter();
                  HasFanSpeed var41 = (HasFanSpeed)var3;
                  if (!Intrinsics.areEqual(var22, var41.getFilter()) || !Intrinsics.areEqual(var28.getFilterLife(), var41.getFilterLife())) {
                     var10 = false;
                     break label237;
                  }
               }

               var10 = true;
            }

            ConnectivityStatus var29;
            if (var21 != null) {
               var29 = var21.getConnectivityStatus();
            } else {
               var29 = null;
            }

            ConnectivityStatus var42;
            if (var3 != null) {
               var42 = var3.getConnectivityStatus();
            } else {
               var42 = null;
            }

            boolean var11;
            if (var29 == var42) {
               var11 = true;
            } else {
               var11 = false;
            }

            Integer var30;
            if (var21 != null) {
               var30 = var21.getUpdateProgress();
            } else {
               var30 = null;
            }

            Integer var43;
            if (var3 != null) {
               var43 = var3.getUpdateProgress();
            } else {
               var43 = null;
            }

            boolean var20;
            boolean var50;
            label226: {
               var20 = Intrinsics.areEqual(var30, var43);
               if (var21 instanceof HasWick && var3 instanceof HasWick) {
                  HasWick var44 = (HasWick)var21;
                  var50 = var44.getWaterShortage();
                  HasWick var31 = (HasWick)var3;
                  if (var50 != var31.getWaterShortage() || var44.getWickUsage() != var31.getWickUsage()) {
                     var50 = false;
                     break label226;
                  }
               }

               var50 = true;
            }

            boolean var13;
            label216: {
               if (var21 instanceof HasRemoveYellowWater && var3 instanceof HasRemoveYellowWater) {
                  HasRemoveYellowWater var32 = (HasRemoveYellowWater)var21;
                  Boolean var45 = var32.getYwrmEnabled();
                  HasRemoveYellowWater var51 = (HasRemoveYellowWater)var3;
                  if (!Intrinsics.areEqual(var45, var51.getYwrmEnabled()) || var32.getYwrmUsage() != var51.getYwrmUsage()) {
                     var13 = false;
                     break label216;
                  }
               }

               var13 = true;
            }

            boolean var14;
            if (var21 instanceof HasWaterLevel && var3 instanceof HasWaterLevel && ((HasWaterLevel)var21).getWaterLevel() != ((HasWaterLevel)var3).getWaterLevel()) {
               var14 = false;
            } else {
               var14 = true;
            }

            boolean var15;
            if (var21 instanceof HasWaterTank && var3 instanceof HasWaterTank && ((HasWaterTank)var21).getWaterTankFailure() != ((HasWaterTank)var3).getWaterTankFailure()) {
               var15 = false;
            } else {
               var15 = true;
            }

            boolean var16;
            if (var21 instanceof HasSensorMode && var3 instanceof HasSensorMode && ((HasSensorMode)var21).getSensorMode() != ((HasSensorMode)var3).getSensorMode()) {
               var16 = false;
            } else {
               var16 = true;
            }

            boolean var17;
            if (var21 instanceof HasTemperatureUnit && var3 instanceof HasTemperatureUnit && ((HasTemperatureUnit)var21).getTemperatureUnit() != ((HasTemperatureUnit)var3).getTemperatureUnit()) {
               var17 = false;
            } else {
               var17 = true;
            }

            Iterable var33 = (Iterable)CollectionsKt.listOf(new Boolean[]{var5, var19, var18, var7, var6, var8, var9, var10, var11, var20, var50, var14, var15, var13, var16, var17});
            if (!(var33 instanceof Collection) || !((Collection)var33).isEmpty()) {
               Iterator var34 = var33.iterator();

               while(var34.hasNext()) {
                  if (!(Boolean)var34.next()) {
                     this.this$0.updateState();
                     break;
                  }
               }
            }

            if (this.this$0.isAttachedToDeviceDetailsDialogFragment()) {
               if (var21 == null) {
                  var5 = true;
               } else {
                  var5 = var21 instanceof HasLocation;
               }

               if (var5 && var3 instanceof HasLocation) {
                  label167: {
                     HasLocation var35 = (HasLocation)var21;
                     if (var35 != null) {
                        String var46 = var35.getLocationId();
                        var36 = var46;
                        if (var46 != null) {
                           break label167;
                        }
                     }

                     var36 = "";
                  }

                  if (!Intrinsics.areEqual(var36, ((HasLocation)var3).getLocationId())) {
                     BuildersKt.launch$default(this.this$0, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this.this$0, var3, (Continuation)null) {
                        final Device $newValue;
                        int label;
                        final DeviceDetailsViewModel this$0;

                        {
                           this.this$0 = var1;
                           this.$newValue = var2;
                        }

                        public final Continuation create(Object var1, Continuation var2) {
                           return (Continuation)(new <anonymous constructor>(this.this$0, this.$newValue, var2));
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
                              String var3 = ((HasLocation)this.$newValue).getLocationId();
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

         }
      });
      MutableLiveData var7 = new MutableLiveData();
      this._liveLocation = var7;
      this.liveLocation = Transformations.distinctUntilChanged((LiveData)var7);
      Delegates var8 = Delegates.INSTANCE;
      this.selectedSensorType$delegate = (ReadWriteProperty)(new ObservableProperty(SensorType.PM25, this) {
         final DeviceDetailsViewModel this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            SensorType var4 = (SensorType)var3;
            if ((SensorType)var2 != var4) {
               this.this$0.updateState();
            }

         }
      });
      var8 = Delegates.INSTANCE;
      this.selectedSettingsType$delegate = (ReadWriteProperty)(new ObservableProperty(DeviceSettingsType.Fanspeed, this) {
         final DeviceDetailsViewModel this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            DeviceSettingsType var4 = (DeviceSettingsType)var3;
            if ((DeviceSettingsType)var2 != var4) {
               this.this$0.updateState();
            }

         }
      });
      var8 = Delegates.INSTANCE;
      this.deviceData$delegate = (ReadWriteProperty)(new ObservableProperty((Object)null, this) {
         final DeviceDetailsViewModel this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            DeviceData var4 = (DeviceData)var3;
            if (!Intrinsics.areEqual((DeviceData)var2, var4)) {
               this.this$0.updateState();
            }

         }
      });
      this._networkAvailable = new MutableLiveData();
      MutableLiveData var16 = new MutableLiveData();
      this._deviceOffline = var16;
      MediatorLiveData var11 = new MediatorLiveData();
      var11.addSource(this.getNetworkAvailable(), new Observer(new DeviceDetailsViewModel$$ExternalSyntheticLambda1(var11, this)) {
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
      var11.addSource((LiveData)var16, new Observer(new DeviceDetailsViewModel$$ExternalSyntheticLambda2(var11, this)) {
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
      this.deviceOffline = (LiveData)var11;
      MutableLiveData var12 = new MutableLiveData(var15);
      this._autoModeFirstClicked = var12;
      this.autoModeFirstClicked = (LiveData)var12;
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DeviceDetailsViewModel this$0;

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
               Flow var6 = this.this$0.getNetworkMonitor().getConnectivityStatus();
               FlowCollector var4 = new FlowCollector(this.this$0) {
                  final DeviceDetailsViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(boolean var1, Continuation var2) {
                     this.this$0._networkAvailable.postValue(Boxing.boxBoolean(var1));
                     return Unit.INSTANCE;
                  }
               };
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var6.collect(var4, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      DeviceAttribute.Companion var13 = DeviceAttribute.Companion;
      Prefs var17 = this.getPrefs();
      var13.setShowDetectCat((Boolean)PreferencesHelper.INSTANCE.get(var17.getBackend(), "KEY_SHOW_DETECT_CAT", var15, Reflection.getOrCreateKotlinClass(Boolean.class)));
      MutableLiveData var14 = new MutableLiveData((Object)null);
      this._resetFilterLifeResult = var14;
      this.resetFilterLifeResult = (LiveData)var14;
   }

   // $FF: synthetic method
   public static void analyticsLogFilterClickEvent$default(DeviceDetailsViewModel var0, Device var1, boolean var2, boolean var3, DeviceFilterType var4, String var5, boolean var6, int var7, Object var8) {
      if ((var7 & 32) != 0) {
         var6 = false;
      }

      var0.analyticsLogFilterClickEvent(var1, var2, var3, var4, var5, var6);
   }

   private static final SimpleDateFormat currentTimeFormatter_delegate$lambda$0(Application var0) {
      String var1;
      if (DateFormat.is24HourFormat((Context)var0)) {
         var1 = "HH:mm";
      } else {
         var1 = "hh:mm a";
      }

      return new SimpleDateFormat(var1);
   }

   private static final Unit deviceOffline$lambda$8$lambda$6(MediatorLiveData var0, DeviceDetailsViewModel var1, Boolean var2) {
      boolean var5 = var2;
      boolean var4 = true;
      boolean var3 = var4;
      if (var5) {
         if (Intrinsics.areEqual(var1._deviceOffline.getValue(), true)) {
            var3 = var4;
         } else {
            var3 = false;
         }
      }

      var0.postValue(var3);
      return Unit.INSTANCE;
   }

   private static final Unit deviceOffline$lambda$8$lambda$7(MediatorLiveData var0, DeviceDetailsViewModel var1, Boolean var2) {
      Object var4 = var1.getNetworkAvailable().getValue();
      boolean var3 = false;
      if (Intrinsics.areEqual(var4, false) || var2) {
         var3 = true;
      }

      var0.postValue(var3);
      return Unit.INSTANCE;
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
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

   private final SensorType getSelectedSensorType() {
      return (SensorType)this.selectedSensorType$delegate.getValue(this, $$delegatedProperties[6]);
   }

   private final DeviceSettingsType getSelectedSettingsType() {
      return (DeviceSettingsType)this.selectedSettingsType$delegate.getValue(this, $$delegatedProperties[7]);
   }

   // $FF: synthetic method
   private final Job setActuator(Device var1, Function2 var2) {
      CoroutineScope var3 = this;
      CoroutineContext var4 = (CoroutineContext)Dispatchers.getIO();
      Intrinsics.needClassReification();
      return BuildersKt.launch$default(var3, var4, (CoroutineStart)null, new Function2(var1, var2, (Continuation)null) {
         final Function2 $action;
         final Device $device;
         int label;

         public {
            this.$device = var1;
            this.$action = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, this.$action, var2));
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
               var1 = this.$device;
               Intrinsics.reifiedOperationMarker(3, "T");
               if (var1 instanceof Device) {
                  Function2 var4 = this.$action;
                  var1 = this.$device;
                  this.label = 1;
                  if (var4.invoke(var1, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }

         public final Object invokeSuspend$$forInline(Object var1) {
            var1 = this.$device;
            Intrinsics.reifiedOperationMarker(3, "T");
            if (var1 instanceof Device) {
               this.$action.invoke(this.$device, this);
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   // $FF: synthetic method
   public static Job setAlarm$default(DeviceDetailsViewModel var0, Device var1, int var2, DeviceAlarm var3, Function2 var4, int var5, Object var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      return var0.setAlarm(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Job setApSubMode$default(DeviceDetailsViewModel var0, Device var1, int var2, boolean var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      return var0.setApSubMode(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void setDualOscillationConfig$default(DeviceDetailsViewModel var0, Device var1, boolean var2, OscillationState var3, DualOscillationConfig var4, boolean var5, int var6, Object var7) {
      if ((var6 & 16) != 0) {
         var5 = false;
      }

      var0.setDualOscillationConfig(var1, var2, var3, var4, var5);
   }

   private final void setSelectedSensorType(SensorType var1) {
      this.selectedSensorType$delegate.setValue(this, $$delegatedProperties[6], var1);
   }

   private final void setSelectedSettingsType(DeviceSettingsType var1) {
      this.selectedSettingsType$delegate.setValue(this, $$delegatedProperties[7], var1);
   }

   private final void updateState() {
      Device var7 = this.getDevice();
      if (var7 != null) {
         boolean var3;
         Object var6;
         List var10;
         label49: {
            var3 = var7 instanceof HasSensorData;
            DeviceData var4 = this.getDeviceData();
            var6 = null;
            if (var4 != null) {
               List var5 = DeviceData.toSimpleDataPoints$default(var4, this.getSelectedSensorType(), false, 2, (Object)null);
               var10 = var5;
               if (var5 != null) {
                  break label49;
               }
            }

            var10 = CollectionsKt.emptyList();
         }

         DeviceSettingsType var11 = this.getSelectedSettingsType();
         int var2 = DeviceDetailsViewModel.WhenMappings.$EnumSwitchMapping$0[var11.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  if (var2 != 4) {
                     if (var2 != 5) {
                        throw new NoWhenBranchMatchedException();
                     }

                     var2 = R.string.link_title;
                  } else {
                     var2 = R.string.nightmode_title;
                  }
               } else {
                  var2 = R.string.childlock_title;
               }
            } else {
               var2 = R.string.brightness_title;
            }
         } else {
            var2 = R.string.fan_title;
         }

         StatusLabelState var12 = var6;
         if (var3) {
            HasSensorData var8 = (HasSensorData)var7;
            var12 = var6;
            if (var8.getLatestSensorDatapoint() != null) {
               float var1;
               label41: {
                  var13 = StatusLabelState.Companion;
                  var6 = var8.getLatestSensorDatapoint();
                  if (var6 != null) {
                     Float var15 = var6.valueFor(this.getSelectedSensorType());
                     if (var15 != null) {
                        var1 = var15;
                        break label41;
                     }
                  }

                  var1 = 0.0F;
               }

               var12 = var13.from(var8, (double)var1, this.getSelectedSensorType());
            }
         }

         this._deviceDetailsState.postValue(new DeviceDetailsState(var3, var7, this.getSelectedSensorType(), var10, this.getSelectedSettingsType(), var12, var2, (TrackedLocation)null));
      }

   }

   public final void analyticsLogFilterClickEvent(Device var1, boolean var2, boolean var3, DeviceFilterType var4, String var5, boolean var6) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var4, "filterType");
      Intrinsics.checkNotNullParameter(var5, "filterName");
      if (!var3) {
         this.lastFilterPurchaseClickTime = System.currentTimeMillis();
      }

      AnalyticEvent.FilterClickEvent var7;
      if (var2) {
         if (var6) {
            var7 = new AnalyticEvent.FilterClickEvent.HomepageFilterClickPurchase(this.lastFilterPurchaseClickTime, var4, var5, var1, this.getAuthService().getUserIdForBlueCloud(), this.getAuthService().getCloudUserRegion());
         } else {
            var7 = new AnalyticEvent.FilterClickEvent.FilterCLickPurchase(this.lastFilterPurchaseClickTime, var4, var5, var1, this.getAuthService().getUserIdForBlueCloud(), this.getAuthService().getCloudUserRegion());
         }
      } else if (var6) {
         var7 = new AnalyticEvent.FilterClickEvent.HomepageFilterClickSubscribe(this.lastFilterPurchaseClickTime, var4, var5, var1, this.getAuthService().getUserIdForBlueCloud(), this.getAuthService().getCloudUserRegion());
      } else {
         var7 = new AnalyticEvent.FilterClickEvent.FilterCLickSubscribe(this.lastFilterPurchaseClickTime, var4, var5, var1, this.getAuthService().getUserIdForBlueCloud(), this.getAuthService().getCloudUserRegion());
      }

      this.getAnalyticsService().event(var7);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var7, (Continuation)null) {
         final AnalyticEvent.FilterClickEvent $event;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
            this.$event = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$event, var2));
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
               DeviceManager var5 = this.this$0.getDeviceManager();
               var1 = this.$event;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.analyticsLogFilterClickEvent(var1, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job autoModeChanged(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, var1, var2, this) {
         final Device $device;
         final Device $device$inlined;
         final boolean $nuMode$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.$device$inlined = var3;
            this.$nuMode$inlined = var4;
            this.this$0 = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.$device$inlined, this.$nuMode$inlined, this.this$0));
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

               HasFanSpeed var11 = (HasFanSpeed)this.L$1;
               Continuation var12 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.$device;
               if (var1 instanceof HasFanSpeed) {
                  Continuation var4 = (Continuation)this;
                  HasFanSpeed var5 = (HasFanSpeed)var1;
                  if (this.$device$inlined instanceof HasAutoRh && this.$nuMode$inlined && !this.this$0.autoModeClickedBefore) {
                     this.this$0._autoModeFirstClicked.postValue(Boxing.boxBoolean(true));
                     this.this$0.autoModeClickedBefore = true;
                     Prefs var7 = this.this$0.getPrefs();
                     String var6 = String.format("KEY_AUTO_MODE_CLICKED_BEFORE_%s", Arrays.copyOf(new Object[]{this.$device$inlined.getUid()}, 1));
                     Intrinsics.checkNotNullExpressionValue(var6, "format(...)");
                     Boolean var9 = Boxing.boxBoolean(true);
                     PreferencesHelper.INSTANCE.set(var7.getBackend(), var6, var9, Reflection.getOrCreateKotlinClass(Boolean.class));
                  }

                  DeviceManager var14 = this.this$0.getDeviceManager();
                  Device var13 = var5;
                  AutoMode var10;
                  if (this.$nuMode$inlined) {
                     var10 = AutoMode.ON;
                  } else {
                     var10 = AutoMode.OFF;
                  }

                  this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (DeviceManager.setAutoMode$default(var14, var13, var10, false, this, 4, (Object)null) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void autoModeFilterTriggerChanged(FilterTrigger var1) {
      Intrinsics.checkNotNullParameter(var1, "nuFilterTrigger");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final FilterTrigger $nuFilterTrigger;
         int I$0;
         Object L$0;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
            this.$nuFilterTrigger = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$nuFilterTrigger, var2));
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

               Device var7 = (Device)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.this$0.getDevice();
               if (var4 != null) {
                  DeviceDetailsViewModel var5 = this.this$0;
                  var1 = this.$nuFilterTrigger;
                  DeviceManager var8 = var5.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var8.updateAutoModeFilterTrigger(var4, var1, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void autoModeFilterTriggerChanged(FilterTrigger var1, FilterTrigger var2) {
      Intrinsics.checkNotNullParameter(var1, "nuAutoModeFilterTrigger");
      Intrinsics.checkNotNullParameter(var2, "nuG4NightModeFilterTrigger");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final FilterTrigger $nuAutoModeFilterTrigger;
         final FilterTrigger $nuG4NightModeFilterTrigger;
         int I$0;
         Object L$0;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
            this.$nuAutoModeFilterTrigger = var2;
            this.$nuG4NightModeFilterTrigger = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$nuAutoModeFilterTrigger, this.$nuG4NightModeFilterTrigger, var2));
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

               Device var8 = (Device)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.this$0.getDevice();
               if (var1 != null) {
                  DeviceDetailsViewModel var6 = this.this$0;
                  FilterTrigger var5 = this.$nuAutoModeFilterTrigger;
                  FilterTrigger var4 = this.$nuG4NightModeFilterTrigger;
                  DeviceManager var9 = var6.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var1);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.updateAutoModeFilterTrigger(var1, var5, var4, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void autoRefreshEnabledChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasAirRefresh) {
         if (((HasAirRefresh)var1).getAirRefreshEnabled()) {
            Prefs var2 = this.getPrefs();
            String var3 = String.format("KEY_AUTO_REFRESH_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{var1.getUid()}, 1));
            Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
            PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, false, Reflection.getOrCreateKotlinClass(Boolean.class));
         }

         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final Device $device;
            int label;
            final DeviceDetailsViewModel this$0;

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
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var1 = (HasAirRefresh)this.$device;
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var5.setAirRefreshEnabled(var1, var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }
   }

   public final Job autorhChanged(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final int $autorh$inlined;
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$autorh$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$autorh$inlined));
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

               HasAutoRh var8 = (HasAutoRh)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasAutoRh) {
                  Continuation var6 = (Continuation)this;
                  HasAutoRh var10 = (HasAutoRh)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$autorh$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setAutorh(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job brightnessChanged(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final int $brightness$inlined;
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$brightness$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$brightness$inlined));
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

               HasBrightness var8 = (HasBrightness)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasBrightness) {
                  Continuation var6 = (Continuation)this;
                  HasBrightness var5 = (HasBrightness)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$brightness$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.updateBrightness(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job brightnessChanged(Device var1, Brightness var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "brightness");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Brightness $brightness$inlined;
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$brightness$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$brightness$inlined));
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

               HasBrightness var8 = (HasBrightness)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasBrightness) {
                  Continuation var7 = (Continuation)this;
                  HasBrightness var10 = (HasBrightness)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  Brightness var6 = this.$brightness$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateBrightness(var10, var6, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job childLockChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasChildLock var7 = (HasChildLock)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasChildLock) {
                  Continuation var6 = (Continuation)this;
                  HasChildLock var9 = (HasChildLock)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateChildLock(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final boolean deviceSupportAntiFake(Device var1) {
      if (BuildEnvironment.INSTANCE.isChina()) {
         SkuConfiguration var2 = SkuConfigurationManager.INSTANCE.getConfig();
         String var3;
         if (var1 != null) {
            var3 = DeviceKt.getSkuCompat(var1);
         } else {
            var3 = null;
         }

         if (var2.skuSupportAntiFake(var3)) {
            return true;
         }
      }

      return false;
   }

   public final Job disinfectionChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasDisinfection var7 = (HasDisinfection)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasDisinfection) {
                  Continuation var6 = (Continuation)this;
                  HasDisinfection var9 = (HasDisinfection)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (DeviceManager.updateDisinfection$default(var5, var9, false, this, 2, (Object)null) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job ecoModeChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasEcoMode var7 = (HasEcoMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasEcoMode) {
                  Continuation var6 = (Continuation)this;
                  HasEcoMode var5 = (HasEcoMode)var4;
                  DeviceManager var9 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.updateEcoMode(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void ensureUseProtectRegion() {
      DeviceType.Companion.setInG4ProtectRegion(this.getLocationService().isInG4ProtectRegion());
   }

   public final Job fanspeedSliderChanged(Device var1, FanSpeedEnum var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "nuFanSpeedEnum");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final FanSpeedEnum $nuFanSpeedEnum$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$nuFanSpeedEnum$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$nuFanSpeedEnum$inlined));
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

               HasFanSpeed var8 = (HasFanSpeed)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasFanSpeed) {
                  Continuation var7 = (Continuation)this;
                  HasFanSpeed var10 = (HasFanSpeed)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  FanSpeedEnum var6 = this.$nuFanSpeedEnum$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setFanSpeed(var10, var6, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job g4NightModeChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasG4NightMode var7 = (HasG4NightMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasG4NightMode) {
                  Continuation var6 = (Continuation)this;
                  HasG4NightMode var9 = (HasG4NightMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (DeviceManager.updateG4NightMode$default(var5, var9, false, this, 2, (Object)null) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job germShieldChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasGermShieldMode var7 = (HasGermShieldMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasGermShieldMode) {
                  Continuation var6 = (Continuation)this;
                  HasGermShieldMode var5 = (HasGermShieldMode)var4;
                  DeviceManager var9 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.updateGermShieldMode(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final String getActionType() {
      return this.actionType;
   }

   public final LiveData getAutoModeFirstClicked() {
      return this.autoModeFirstClicked;
   }

   public final boolean getAutoRefreshHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_AUTO_REFRESH_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getBannerBodyNotMountedClosed() {
      return this.bannerBodyNotMountedClosed;
   }

   public final boolean getBannerFilterExpiredClosed() {
      return this.bannerFilterExpiredClosed;
   }

   public final boolean getBannerWaterShortageClosed() {
      return this.bannerWaterShortageClosed;
   }

   public final boolean getBannerWickExpiredClosed() {
      return this.bannerWickExpiredClosed;
   }

   public final boolean getCantHeatHintClosedBefore() {
      Prefs var2 = this.getPrefs();
      String var1 = String.format("KEY_CANT_HEAT_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var2.getBackend(), var1, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getControlsHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_CONTROLS_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final SimpleDateFormat getCurrentTimeFormatter() {
      return (SimpleDateFormat)this.currentTimeFormatter$delegate.getValue();
   }

   public final Device getDevice() {
      return (Device)this.device$delegate.getValue(this, $$delegatedProperties[5]);
   }

   public final DeviceData getDeviceData() {
      return (DeviceData)this.deviceData$delegate.getValue(this, $$delegatedProperties[8]);
   }

   public final LiveData getDeviceDetailsState() {
      return (LiveData)this._deviceDetailsState;
   }

   public final String getDeviceId() {
      return this.deviceId;
   }

   public final LiveData getDeviceOffline() {
      return this.deviceOffline;
   }

   public final void getDevices(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onResult");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final Function1 $onResult;
         int I$0;
         Object L$0;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
            this.$onResult = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$onResult, var2));
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

               List var7 = (List)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               List var4 = this.this$0.getDeviceManager().getDevices();
               Function1 var5 = this.$onResult;
               CoroutineContext var6 = (CoroutineContext)Dispatchers.getMain();
               Function2 var8 = new Function2(var5, var4, (Continuation)null) {
                  final List $it;
                  final Function1 $onResult;
                  int label;

                  {
                     this.$onResult = var1;
                     this.$it = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$onResult, this.$it, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.$onResult.invoke(this.$it);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
               this.I$0 = 0;
               this.label = 1;
               if (BuildersKt.withContext(var6, var8, this) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final boolean getHeatingHintClosedBefore() {
      Prefs var2 = this.getPrefs();
      String var1 = String.format("KEY_HEATING_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var2.getBackend(), var1, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getHumHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_HUM_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final LiveData getLiveDevice() {
      return this.getDeviceManager().databaseDevice(this.deviceId);
   }

   public final LiveData getLiveDevices() {
      return this.liveDevices;
   }

   public final LiveData getLiveLatestDataPoint() {
      return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(this.getDeviceManager().getFlowLatestDatapoint(this.deviceId)), ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final LiveData getLiveLocation() {
      return this.liveLocation;
   }

   public final LocationService.MapType getMapType() {
      return this.getLocationService().getMapType();
   }

   public final LiveData getNetworkAvailable() {
      return (LiveData)this._networkAvailable;
   }

   public final boolean getNightSleepHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_NIGHT_SLEEP_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getOscillationAngleHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_OSCILLATION_ANGLE_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getOscillationLoopHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_OSCILLATION_LOOP_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getOscillationResetPosHintClosedBefore() {
      Prefs var2 = this.getPrefs();
      String var1 = String.format("KEY_OSCILLATION_RESET_POSITION_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var2.getBackend(), var1, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final LiveData getResetFilterLifeResult() {
      return this.resetFilterLifeResult;
   }

   public final boolean getSkinHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_SKIN_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getSmartHintClosedBefore() {
      Prefs var2 = this.getPrefs();
      String var1 = String.format("KEY_SMART_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var2.getBackend(), var1, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean getSunRiseLightHintClosedBefore() {
      Prefs var1 = this.getPrefs();
      String var2 = String.format("KEY_SUNRISE_LIGHT_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), var2, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job gsnmChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasGermShieldMode var7 = (HasGermShieldMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasGermShieldMode) {
                  Continuation var6 = (Continuation)this;
                  HasGermShieldMode var9 = (HasGermShieldMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateGermShieldNightMode(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job hinsModeChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasHinsMode var7 = (HasHinsMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasHinsMode) {
                  Continuation var6 = (Continuation)this;
                  HasHinsMode var5 = (HasHinsMode)var4;
                  DeviceManager var9 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.updateHinsMode(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job hinsNightModeChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasHinsMode var7 = (HasHinsMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasHinsMode) {
                  Continuation var6 = (Continuation)this;
                  HasHinsMode var5 = (HasHinsMode)var4;
                  DeviceManager var9 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.updateHinsNightMode(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job hoverEnabledChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasGestureRecognition var7 = (HasGestureRecognition)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasGestureRecognition) {
                  Continuation var6 = (Continuation)this;
                  HasGestureRecognition var9 = (HasGestureRecognition)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateHoverEnabled(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job humModeChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasHumMode var7 = (HasHumMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasHumMode) {
                  Continuation var6 = (Continuation)this;
                  HasHumMode var9 = (HasHumMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateHumMode(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final boolean isAttachedToDeviceDetailsDialogFragment() {
      return this.isAttachedToDeviceDetailsDialogFragment;
   }

   public final boolean isInWelcomeHomeRegion() {
      return this.getLocationService().isInWelcomeHomeRegion() && PhoneUtil.INSTANCE.isGoogleServicesAvailable((Context)this.getApplication());
   }

   public final Job linkDeviceSelected(HasLinkingCapability var1, DeviceAware var2) {
      Intrinsics.checkNotNullParameter(var1, "parentDevice");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, var2, this, (Continuation)null) {
         final DeviceAware $linkedDevice;
         final HasLinkingCapability $parentDevice;
         private Object L$0;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.$parentDevice = var1;
            this.$linkedDevice = var2;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.$parentDevice, this.$linkedDevice, this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            CoroutineScope var3 = (CoroutineScope)this.L$0;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               String var5 = this.$parentDevice.getLinkedToUid();
               var1 = this.$linkedDevice;
               String var9;
               if (var1 != null) {
                  var9 = var1.getUid();
               } else {
                  var9 = null;
               }

               if (Intrinsics.areEqual(var5, var9)) {
                  CoroutineScopeKt.cancel$default(var3, (CancellationException)null, 1, (Object)null);
               }

               DeviceManager var11 = this.this$0.getDeviceManager();
               HasLinkingCapability var10 = this.$parentDevice;
               DeviceAware var7 = this.$linkedDevice;
               Continuation var6 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.label = 1;
               if (var11.updateDeviceSelectedLink(var10, var7, var6) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void openFilterUrl(Context var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "url");
      Intrinsics.checkNotNullParameter(var3, "title");
      DeviceConfigProvider.INSTANCE.openFilterUrl(var1, var2, var3);
   }

   public final Job oscillationModeChange(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasDualOscillation var7 = (HasDualOscillation)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasDualOscillation) {
                  Continuation var6 = (Continuation)this;
                  HasDualOscillation var5 = (HasDualOscillation)var4;
                  DeviceManager var9 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.oscillationModeChange(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job oscillationStateChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasOscillation var7 = (HasOscillation)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasOscillation) {
                  Continuation var6 = (Continuation)this;
                  HasOscillation var9 = (HasOscillation)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateOscillationState(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job playAlarm(Device var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3) {
         final Device $device;
         final int $sound$inlined;
         final int $volume$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$sound$inlined = var4;
            this.$volume$inlined = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$sound$inlined, this.$volume$inlined));
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

               HasAlarm var9 = (HasAlarm)this.L$1;
               Continuation var10 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var5 = this.$device;
               if (var5 instanceof HasAlarm) {
                  Continuation var7 = (Continuation)this;
                  HasAlarm var11 = (HasAlarm)var5;
                  DeviceManager var6 = this.this$0.getDeviceManager();
                  int var3 = this.$sound$inlined;
                  var2 = this.$volume$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var11);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var6.playAlarm(var11, var3, var2, this) == var4) {
                     return var4;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void removeDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.getDeviceManager().removeDevice(var1);
   }

   public final Object removeDeviceWithLock(Device var1, Continuation var2) {
      Object var3 = this.getDeviceManager().removeDeviceWithLock(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final void resetFilterLife(Device var1, DeviceFilterType var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "type");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final Device $device;
         final DeviceFilterType $type;
         Object L$0;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$type = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$type, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Device var3;
            Object var5;
            label49: {
               label53: {
                  var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              if (var2 != 4) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              var3 = (Device)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           }

                           var3 = (Device)this.L$0;
                           ResultKt.throwOnFailure(var1);
                           break label49;
                        }

                        var3 = (Device)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        break label53;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     DeviceManager var15 = this.this$0.getDeviceManager();
                     String var4 = this.$device.getUid();
                     Continuation var8 = (Continuation)this;
                     this.label = 1;
                     Object var16 = var15.getDatabaseDevice(var4, var8);
                     var1 = var16;
                     if (var16 == var5) {
                        return var5;
                     }
                  }

                  var3 = (Device)var1;
                  if (var3 == null) {
                     this.this$0._resetFilterLifeResult.postValue(FilterLifeResetResult.FAILED);
                     Unit var13 = Unit.INSTANCE;
                     return Unit.INSTANCE;
                  }

                  if (var3.getConnectivityStatus() != ConnectivityStatus.ONLINE) {
                     this.this$0._resetFilterLifeResult.postValue(FilterLifeResetResult.DEVICE_OFFLINE);
                     Unit var12 = Unit.INSTANCE;
                     return Unit.INSTANCE;
                  }

                  DeviceManager var17 = this.this$0.getDeviceManager();
                  String var6 = var3.getUid();
                  DeviceFilterType var7 = this.$type;
                  Continuation var9 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                  this.label = 2;
                  var1 = var17.resetFilterLife(var6, var7, var9);
                  if (var1 == var5) {
                     return var5;
                  }
               }

               ApiResult var21 = (ApiResult)var1;
               Function2 var10 = new Function2(this.this$0, (Continuation)null) {
                  Object L$0;
                  int label;
                  final DeviceDetailsViewModel this$0;

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
                     AntiFakeResetResp var3 = (AntiFakeResetResp)this.L$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        int var2 = var3.getStatus();
                        FilterLifeResetResult var4;
                        if (var2 != 0) {
                           if (var2 != 3) {
                              var4 = FilterLifeResetResult.FAILED;
                           } else {
                              var4 = FilterLifeResetResult.DEVICE_OFFLINE;
                           }
                        } else {
                           var4 = FilterLifeResetResult.SUCCESS;
                        }

                        this.this$0._resetFilterLifeResult.postValue(var4);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var18 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.label = 3;
               Object var19 = ApiResultKt.onSuccess(var21, var10, var18);
               var1 = var19;
               if (var19 == var5) {
                  return var5;
               }
            }

            ApiResult var11 = (ApiResult)var1;
            Function2 var22 = new Function2(this.this$0, (Continuation)null) {
               int label;
               final DeviceDetailsViewModel this$0;

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
                     this.this$0._resetFilterLifeResult.postValue(FilterLifeResetResult.FAILED);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var20 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
            this.label = 4;
            if (ApiResultKt.onFail(var11, var22, var20) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final void resetOscillationPosition(boolean var1) {
      Device var2 = this.getDevice();
      HasDualOscillation var3;
      if (var2 instanceof HasDualOscillation) {
         var3 = (HasDualOscillation)var2;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var3, var1, (Continuation)null) {
            final boolean $horizontal;
            final HasDualOscillation $it;
            int label;
            final DeviceDetailsViewModel this$0;

            {
               this.this$0 = var1;
               this.$it = var2;
               this.$horizontal = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, this.$horizontal, var2));
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
                  DeviceManager var6 = this.this$0.getDeviceManager();
                  HasDualOscillation var5 = this.$it;
                  boolean var3 = this.$horizontal;
                  Continuation var7 = (Continuation)this;
                  this.label = 1;
                  if (var6.calibrateOscillationPosition(var5, var3, var7) == var4) {
                     return var4;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

   }

   public final Job sensorModeChange(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasSensorMode var7 = (HasSensorMode)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasSensorMode) {
                  Continuation var6 = (Continuation)this;
                  HasSensorMode var9 = (HasSensorMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.sensorModeChange(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setActionType(String var1) {
      this.actionType = var1;
   }

   public final Job setAlarm(Device var1, int var2, DeviceAlarm var3, Function2 var4) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3, var4) {
         final DeviceAlarm $alarm$inlined;
         final Device $device;
         final int $index$inlined;
         final Function2 $onResult$inlined;
         int I$0;
         int I$1;
         int I$2;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$index$inlined = var4;
            this.$alarm$inlined = var5;
            this.$onResult$inlined = var6;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$index$inlined, this.$alarm$inlined, this.$onResult$inlined));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            Continuation var3;
            HasAlarm var4;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  Function2 var14 = (Function2)this.L$3;
                  ApiResult var15 = (ApiResult)this.L$2;
                  HasAlarm var16 = (HasAlarm)this.L$1;
                  Continuation var17 = (Continuation)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               var2 = this.I$0;
               var4 = (HasAlarm)this.L$1;
               var3 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.$device;
               if (!(var1 instanceof HasAlarm)) {
                  return Unit.INSTANCE;
               }

               var3 = (Continuation)this;
               var4 = (HasAlarm)var1;
               var1 = this.this$0.getDeviceManager();
               var2 = this.$index$inlined;
               DeviceAlarm var6 = this.$alarm$inlined;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
               this.I$0 = 0;
               this.label = 1;
               var1 = (DeviceManager)var1.setAlarm(var4, var2, var6, this);
               if (var1 == var5) {
                  return var5;
               }

               var2 = 0;
            }

            ApiResult var7 = (ApiResult)var1;
            Function2 var8 = this.$onResult$inlined;
            if (var8 != null) {
               CoroutineContext var11 = (CoroutineContext)Dispatchers.getMain();
               Function2 var18 = new Function2(var8, var7, (Continuation)null) {
                  final Function2 $it;
                  final ApiResult $result;
                  int label;

                  {
                     this.$it = var1;
                     this.$result = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$it, this.$result, var2));
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
                        Function2 var5 = this.$it;
                        ApiResult var4 = this.$result;
                        this.label = 1;
                        if (var5.invoke(var4, this) == var3) {
                           return var3;
                        }
                     }

                     return Unit.INSTANCE;
                  }
               };
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
               this.L$2 = SpillingKt.nullOutSpilledVariable(var7);
               this.L$3 = SpillingKt.nullOutSpilledVariable(var8);
               this.I$0 = var2;
               this.I$1 = 0;
               this.I$2 = 0;
               this.label = 2;
               if (BuildersKt.withContext(var11, var18, this) == var5) {
                  return var5;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setApFanSpeed(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasCombo3in1MainMode var8 = (HasCombo3in1MainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCombo3in1MainMode) {
                  Continuation var6 = (Continuation)this;
                  HasCombo3in1MainMode var10 = (HasCombo3in1MainMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setApFanSpeed(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setApSubMode(Device var1, int var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3) {
         final Device $device;
         final boolean $overwriteMainMode$inlined;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
            this.$overwriteMainMode$inlined = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined, this.$overwriteMainMode$inlined));
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

               HasMainMode var9 = (HasMainMode)this.L$1;
               Continuation var10 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var5 = this.$device;
               if (var5 instanceof HasMainMode) {
                  Continuation var7 = (Continuation)this;
                  HasMainMode var11 = (HasMainMode)var5;
                  DeviceManager var6 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  boolean var3;
                  if (this.$overwriteMainMode$inlined && !var11.isInMainMode(MainMode.AirPurify)) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var11);
                  this.I$0 = 0;
                  this.label = 1;
                  if (DeviceManager.setApSubMode$default(var6, var11, var2, false, var3, (String)null, this, 20, (Object)null) == var4) {
                     return var4;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setAttachedToDeviceDetailsDialogFragment(boolean var1) {
      this.isAttachedToDeviceDetailsDialogFragment = var1;
   }

   public final void setAutoRefreshHintClosedBefore(boolean var1) {
      Prefs var3 = this.getPrefs();
      String var2 = String.format("KEY_AUTO_REFRESH_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      PreferencesHelper.INSTANCE.set(var3.getBackend(), var2, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setAutoRefreshStatus(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasAirRefresh var8 = (HasAirRefresh)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasAirRefresh) {
                  Continuation var6 = (Continuation)this;
                  HasAirRefresh var5 = (HasAirRefresh)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setAirRefreshStatus(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setBannerBodyNotMountedClosed(boolean var1) {
      this.bannerBodyNotMountedClosed = var1;
   }

   public final void setBannerFilterExpiredClosed(boolean var1) {
      this.bannerFilterExpiredClosed = var1;
   }

   public final void setBannerWaterShortageClosed(boolean var1) {
      this.bannerWaterShortageClosed = var1;
   }

   public final void setBannerWickExpiredClosed(boolean var1) {
      this.bannerWickExpiredClosed = var1;
   }

   public final void setCantHeatHintClosedBefore(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_CANT_HEAT_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setControlsHintClosedBefore(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_CONTROLS_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setCoolAutoLevel(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasCoolMainMode var8 = (HasCoolMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCoolMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasCoolMainMode var5 = (HasCoolMainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setCoolAutoLevel(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setCoolAutoPresets(Device var1, int var2, double[] var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3) {
         final Device $device;
         final double[] $presets$inlined;
         final int $tag$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$tag$inlined = var4;
            this.$presets$inlined = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$tag$inlined, this.$presets$inlined));
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

               HasCombo3in1MainMode var9 = (HasCombo3in1MainMode)this.L$1;
               Continuation var10 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCombo3in1MainMode) {
                  Continuation var7 = (Continuation)this;
                  HasCombo3in1MainMode var11 = (HasCombo3in1MainMode)var4;
                  DeviceManager var6 = this.this$0.getDeviceManager();
                  var2 = this.$tag$inlined;
                  double[] var5 = this.$presets$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var11);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var6.setCoolAutoPresets(var11, var2, var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setCoolEcoPresets(Device var1, int var2, double[] var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3) {
         final Device $device;
         final double[] $presets$inlined;
         final int $tag$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$tag$inlined = var4;
            this.$presets$inlined = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$tag$inlined, this.$presets$inlined));
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

               HasCombo3in1MainMode var9 = (HasCombo3in1MainMode)this.L$1;
               Continuation var10 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCombo3in1MainMode) {
                  Continuation var7 = (Continuation)this;
                  HasCombo3in1MainMode var11 = (HasCombo3in1MainMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$tag$inlined;
                  double[] var6 = this.$presets$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var11);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setCoolEcoPresets(var11, var2, var6, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setCoolFanSpeed(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasCombo3in1MainMode var8 = (HasCombo3in1MainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCombo3in1MainMode) {
                  Continuation var6 = (Continuation)this;
                  HasCombo3in1MainMode var5 = (HasCombo3in1MainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setCoolFanSpeed(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setCoolFanSpeedLevel(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasCoolMainMode var8 = (HasCoolMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCoolMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasCoolMainMode var5 = (HasCoolMainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setCoolFanSpeedLevel(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setCoolSubMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasMainMode var8 = (HasMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasMainMode var10 = (HasMainMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setCoolSubMode(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setDehSubMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasDehumidifierMainMode var8 = (HasDehumidifierMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasDehumidifierMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasDehumidifierMainMode var5 = (HasDehumidifierMainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setDehSubMode(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setDevice(Device var1) {
      this.device$delegate.setValue(this, $$delegatedProperties[5], var1);
   }

   public final void setDeviceData(DeviceData var1) {
      this.deviceData$delegate.setValue(this, $$delegatedProperties[8], var1);
   }

   public final void setDeviceId(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("device id new value: ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      boolean var2;
      if (!Intrinsics.areEqual(this.deviceId, var1) && ((CharSequence)var1).length() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.deviceId = var1;
      Prefs var6 = this.getPrefs();
      var1 = String.format("KEY_AUTO_MODE_CLICKED_BEFORE_%s", Arrays.copyOf(new Object[]{var1}, 1));
      Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
      this.autoModeClickedBefore = (Boolean)PreferencesHelper.INSTANCE.get(var6.getBackend(), var1, false, Reflection.getOrCreateKotlinClass(Boolean.class));
      if (var2) {
         this.updateEverything();
      }

   }

   public final void setDeviceName(Device var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "nuName");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final Device $device;
         final String $nuName;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$nuName = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$nuName, var2));
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
               Device var5 = this.$device;
               String var6 = this.$nuName;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var1.setDeviceName(var5, var6, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setDualOscillationConfig(Device var1, boolean var2, OscillationState var3, DualOscillationConfig var4, boolean var5) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var3, "state");
      Intrinsics.checkNotNullParameter(var4, "newConfig");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3, var4, var5) {
         final Device $device;
         final boolean $horizontal$inlined;
         final DualOscillationConfig $newConfig$inlined;
         final boolean $onlyUpdateState$inlined;
         final OscillationState $state$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$horizontal$inlined = var4;
            this.$state$inlined = var5;
            this.$newConfig$inlined = var6;
            this.$onlyUpdateState$inlined = var7;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$horizontal$inlined, this.$state$inlined, this.$newConfig$inlined, this.$onlyUpdateState$inlined));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               HasDualOscillation var11 = (HasDualOscillation)this.L$1;
               Continuation var12 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var6 = this.$device;
               if (var6 instanceof HasDualOscillation) {
                  Continuation var10 = (Continuation)this;
                  HasDualOscillation var8 = (HasDualOscillation)var6;
                  DeviceManager var7 = this.this$0.getDeviceManager();
                  boolean var4 = this.$horizontal$inlined;
                  OscillationState var9 = this.$state$inlined;
                  DualOscillationConfig var13 = this.$newConfig$inlined;
                  boolean var3 = this.$onlyUpdateState$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var10);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var8);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var7.setDualOscillationConfig(var8, var4, var9, var13, var3, this) == var5) {
                     return var5;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Object setFilter(Device var1, Filter var2, Continuation var3) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("setFilter: nuFilter = ");
      var5.append(var2);
      var4.d(var5.toString(), new Object[0]);
      Object var6 = this.getDeviceManager().setFilter(var1, var2, var3);
      return var6 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var6 : Unit.INSTANCE;
   }

   public final Job setHeatAutoTmp(Device var1, double var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final double $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var4 = this.label;
            if (var4 != 0) {
               if (var4 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               HasCombo3in1MainMode var9 = (HasCombo3in1MainMode)this.L$1;
               Continuation var10 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var6 = this.$device;
               if (var6 instanceof HasCombo3in1MainMode) {
                  Continuation var8 = (Continuation)this;
                  HasCombo3in1MainMode var11 = (HasCombo3in1MainMode)var6;
                  DeviceManager var7 = this.this$0.getDeviceManager();
                  double var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var8);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var11);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var7.setHeatAutoTmp(var11, var2, this) == var5) {
                     return var5;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setHeatEcoTmp(Device var1, double var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final double $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var4 = this.label;
            if (var4 != 0) {
               if (var4 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               HasCombo3in1MainMode var9 = (HasCombo3in1MainMode)this.L$1;
               Continuation var10 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var6 = this.$device;
               if (var6 instanceof HasCombo3in1MainMode) {
                  Continuation var8 = (Continuation)this;
                  HasCombo3in1MainMode var11 = (HasCombo3in1MainMode)var6;
                  DeviceManager var7 = this.this$0.getDeviceManager();
                  double var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var8);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var11);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var7.setHeatEcoTmp(var11, var2, this) == var5) {
                     return var5;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setHeatFanSpeed(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasCombo3in1MainMode var8 = (HasCombo3in1MainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCombo3in1MainMode) {
                  Continuation var6 = (Continuation)this;
                  HasCombo3in1MainMode var5 = (HasCombo3in1MainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setHeatFanSpeed(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setHeatSubMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasCombo3in1MainMode var8 = (HasCombo3in1MainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasCombo3in1MainMode) {
                  Continuation var6 = (Continuation)this;
                  HasCombo3in1MainMode var5 = (HasCombo3in1MainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setHeatSubMode(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setHeatingHintClosedBefore(boolean var1) {
      Prefs var3 = this.getPrefs();
      String var2 = String.format("KEY_HEATING_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      PreferencesHelper.INSTANCE.set(var3.getBackend(), var2, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setHumHintClosedBefore(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_HUM_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setHumSubMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasHumMainMode var8 = (HasHumMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasHumMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasHumMainMode var10 = (HasHumMainMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setHumSubMode(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setMainMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasMainMode var8 = (HasMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasMainMode var10 = (HasMainMode)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (DeviceManager.setMainMode$default(var5, var10, var2, (String)null, this, 4, (Object)null) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setManualMode(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasFanSpeed var7 = (HasFanSpeed)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasFanSpeed) {
                  Continuation var6 = (Continuation)this;
                  HasFanSpeed var9 = (HasFanSpeed)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setManualMode(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, var1, var2, this) {
         final Device $device;
         final Device $device$inlined;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.$device$inlined = var3;
            this.$value$inlined = var4;
            this.this$0 = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.$device$inlined, this.$value$inlined, this.this$0));
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

               HasMode var11 = (HasMode)this.L$1;
               Continuation var12 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var5 = this.$device;
               if (var5 instanceof HasMode) {
                  Continuation var9 = (Continuation)this;
                  HasMode var13 = (HasMode)var5;
                  Device var6 = this.$device$inlined;
                  if (var6 instanceof HasAutoRh && (!(var6 instanceof HasHumMode) || ((HasHumMode)var6).getHumMode()) && this.$value$inlined == Mode.AUTO.getValue() && !this.this$0.autoModeClickedBefore) {
                     this.this$0._autoModeFirstClicked.postValue(Boxing.boxBoolean(true));
                     this.this$0.autoModeClickedBefore = true;
                     Prefs var14 = this.this$0.getPrefs();
                     String var8 = String.format("KEY_AUTO_MODE_CLICKED_BEFORE_%s", Arrays.copyOf(new Object[]{this.$device$inlined.getUid()}, 1));
                     Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
                     Boolean var7 = Boxing.boxBoolean(true);
                     PreferencesHelper.INSTANCE.set(var14.getBackend(), var8, var7, Reflection.getOrCreateKotlinClass(Boolean.class));
                  }

                  DeviceManager var15 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  boolean var3 = DeviceKt.isCancellable(this.$device$inlined);
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var9);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var13);
                  this.I$0 = 0;
                  this.label = 1;
                  if (DeviceManager.setMode$default(var15, var13, var2, var3 ^ true, (String)null, this, 8, (Object)null) == var4) {
                     return var4;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setNightLampBrightness(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasMoodLamp var8 = (HasMoodLamp)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasMoodLamp) {
                  Continuation var6 = (Continuation)this;
                  HasMoodLamp var5 = (HasMoodLamp)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setNightLampBrightness(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setNightLampSteplessBrightness(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasNightLamp var8 = (HasNightLamp)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasNightLamp) {
                  Continuation var6 = (Continuation)this;
                  HasNightLamp var5 = (HasNightLamp)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setNightLampSteplessBrightness(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setNightSleepHintClosedBefore(boolean var1) {
      Prefs var3 = this.getPrefs();
      String var2 = String.format("KEY_NIGHT_SLEEP_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      PreferencesHelper.INSTANCE.set(var3.getBackend(), var2, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setOscillationAngleHintClosedBefore(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_OSCILLATION_ANGLE_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setOscillationLoopHintClosedBefore(boolean var1) {
      Prefs var3 = this.getPrefs();
      String var2 = String.format("KEY_OSCILLATION_LOOP_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      PreferencesHelper.INSTANCE.set(var3.getBackend(), var2, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setOscillationParams(Device var1, int var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2, var3, var4) {
         final int $angle$inlined;
         final Device $device;
         final int $direction$inlined;
         final int $fanSpeed$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$angle$inlined = var4;
            this.$direction$inlined = var5;
            this.$fanSpeed$inlined = var6;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$angle$inlined, this.$direction$inlined, this.$fanSpeed$inlined));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               HasOscillation var10 = (HasOscillation)this.L$1;
               Continuation var11 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var6 = this.$device;
               if (var6 instanceof HasOscillation) {
                  Continuation var8 = (Continuation)this;
                  HasOscillation var7 = (HasOscillation)var6;
                  DeviceManager var12 = this.this$0.getDeviceManager();
                  int var4 = this.$angle$inlined;
                  var2 = this.$direction$inlined;
                  int var3 = this.$fanSpeed$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var8);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var7);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var12.setOscillationParams(var7, var4, var2, var3, this) == var5) {
                     return var5;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setOscillationResetPosHintClosedBefore(boolean var1) {
      Prefs var3 = this.getPrefs();
      String var2 = String.format("KEY_OSCILLATION_RESET_POSITION_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      PreferencesHelper.INSTANCE.set(var3.getBackend(), var2, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setPanelDisplayMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasDisplayMode var8 = (HasDisplayMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasDisplayMode) {
                  Continuation var6 = (Continuation)this;
                  HasDisplayMode var5 = (HasDisplayMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setPanelDisplayMode(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setSkinHintClosedBefore(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_SKIN_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setSmartHintClosedBefore(boolean var1) {
      Prefs var3 = this.getPrefs();
      String var2 = String.format("KEY_SMART_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      PreferencesHelper.INSTANCE.set(var3.getBackend(), var2, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setSmartSubMode(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasPetMainMode var8 = (HasPetMainMode)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasPetMainMode) {
                  Continuation var6 = (Continuation)this;
                  HasPetMainMode var5 = (HasPetMainMode)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setSmartSubMode(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setSunRiseLightHintClosedBefore(boolean var1) {
      Prefs var2 = this.getPrefs();
      String var3 = String.format("KEY_SUNRISE_LIGHT_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{this.deviceId}, 1));
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      PreferencesHelper.INSTANCE.set(var2.getBackend(), var3, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final Job setTare(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasWeight var7 = (HasWeight)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasWeight) {
                  Continuation var6 = (Continuation)this;
                  HasWeight var9 = (HasWeight)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setTare(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setUse24Hour(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final boolean $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasHourFormat var8 = (HasHourFormat)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var5 = this.$device;
               if (var5 instanceof HasHourFormat) {
                  Continuation var7 = (Continuation)this;
                  HasHourFormat var10 = (HasHourFormat)var5;
                  DeviceManager var6 = this.this$0.getDeviceManager();
                  boolean var3 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var6.setUse24Hour(var10, var3, this) == var4) {
                     return var4;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setWickDryDuration(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasWickDryDuration var8 = (HasWickDryDuration)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasWickDryDuration) {
                  Continuation var6 = (Continuation)this;
                  HasWickDryDuration var10 = (HasWickDryDuration)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.setWickDryDuration(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job setYwrmEnabled(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final boolean $value$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$value$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$value$inlined));
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

               HasRemoveYellowWater var8 = (HasRemoveYellowWater)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var5 = this.$device;
               if (var5 instanceof HasRemoveYellowWater) {
                  Continuation var7 = (Continuation)this;
                  HasRemoveYellowWater var6 = (HasRemoveYellowWater)var5;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  boolean var3 = this.$value$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var6);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.setYwrmEnabled(var6, var3, this) == var4) {
                     return var4;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job standByChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasStandBy var7 = (HasStandBy)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasStandBy) {
                  Continuation var6 = (Continuation)this;
                  HasStandBy var9 = (HasStandBy)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateStandBy(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job stopAlarm(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasAlarm var7 = (HasAlarm)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasAlarm) {
                  Continuation var6 = (Continuation)this;
                  HasAlarm var9 = (HasAlarm)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.stopAlarm(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job temperatureUnitChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasTemperatureUnit var7 = (HasTemperatureUnit)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasTemperatureUnit) {
                  Continuation var6 = (Continuation)this;
                  HasTemperatureUnit var9 = (HasTemperatureUnit)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateTemperatureUnit(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job timerDurationChanged(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $duration$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$duration$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$duration$inlined));
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

               HasTimer var8 = (HasTimer)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasTimer) {
                  Continuation var6 = (Continuation)this;
                  HasTimer var10 = (HasTimer)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$duration$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateTimerDuration(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job timerStatusChanged(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $status$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$status$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$status$inlined));
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

               HasTimer var8 = (HasTimer)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasTimer) {
                  Continuation var6 = (Continuation)this;
                  HasTimer var10 = (HasTimer)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$status$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateTimerStatus(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void updateEverything() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         private Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            CoroutineScope var5 = (CoroutineScope)this.L$0;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            Object var3;
            DeviceDetailsViewModel var12;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var12 = (DeviceDetailsViewModel)this.L$1;
               ResultKt.throwOnFailure(var1);
               var3 = var1;
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceDetailsViewModel var8 = this.this$0;
               DeviceManager var7 = var8.getDeviceManager();
               String var10 = this.this$0.getDeviceId();
               Continuation var6 = (Continuation)this;
               this.L$0 = var5;
               this.L$1 = var8;
               this.label = 1;
               var3 = var7.getDatabaseDevice(var10, var6);
               if (var3 == var4) {
                  return var4;
               }

               var12 = var8;
            }

            var12.setDevice((Device)var3);
            var1 = this.this$0.getDevice();
            if (var1 != null) {
               DeviceDetailsViewModel var11 = this.this$0;
               if (var1 instanceof HasLinkingCapability) {
                  BuildersKt.launch$default(var5, (CoroutineContext)null, (CoroutineStart)null, new Function2(var11, var1, (Continuation)null) {
                     final Device $device;
                     int label;
                     final DeviceDetailsViewModel this$0;

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
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           DeviceManager var4 = this.this$0.getDeviceManager();
                           var1 = (HasLinkingCapability)this.$device;
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           if (var4.getLinkedUid(var1, var5) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  }, 3, (Object)null);
               }

               if (var1 instanceof HasBlueCloudFunctions && var11.isAttachedToDeviceDetailsDialogFragment()) {
                  if (var1 instanceof HasLocation) {
                     BuildersKt.launch$default(var5, (CoroutineContext)null, (CoroutineStart)null, new Function2(var11, var1, (Continuation)null) {
                        final Device $device;
                        int label;
                        final DeviceDetailsViewModel this$0;

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
                           Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           if (var2 != 0) {
                              if (var2 != 1) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResultKt.throwOnFailure(var1);
                           } else {
                              ResultKt.throwOnFailure(var1);
                              DeviceManager var5 = this.this$0.getDeviceManager();
                              String var6 = this.$device.getUid();
                              Continuation var4 = (Continuation)this;
                              this.label = 1;
                              if (var5.getDeviceLocation(var6, var4) == var3) {
                                 return var3;
                              }
                           }

                           return Unit.INSTANCE;
                        }
                     }, 3, (Object)null);
                  }

                  BuildersKt.launch$default(var5, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, var11, (Continuation)null) {
                     final Device $device;
                     int label;
                     final DeviceDetailsViewModel this$0;

                     {
                        this.$device = var1;
                        this.this$0 = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.$device, this.this$0, var2));
                     }

                     public final Object invoke(CoroutineScope var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              if (var2 != 2) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           Timber.Forest var3 = Timber.Forest;
                           StringBuilder var6 = new StringBuilder("check device connectivity status: ");
                           var6.append(this.$device.getUid());
                           var3.d(var6.toString(), new Object[0]);
                           DeviceManager var5 = this.this$0.getDeviceManager();
                           String var7 = this.$device.getUid();
                           Continuation var9 = (Continuation)this;
                           this.label = 1;
                           Object var10 = var5.getBlueDeviceStatus(var7, var9);
                           var1 = var10;
                           if (var10 == var4) {
                              return var4;
                           }
                        }

                        ApiResult var8 = (ApiResult)var1;
                        Function2 var12 = new Function2(this.$device, this.this$0, (Continuation)null) {
                           final Device $device;
                           boolean Z$0;
                           int label;
                           final DeviceDetailsViewModel this$0;

                           {
                              this.$device = var1;
                              this.this$0 = var2;
                           }

                           public final Continuation create(Object var1, Continuation var2) {
                              Function2 var3 = new <anonymous constructor>(this.$device, this.this$0, var2);
                              var3.Z$0 = (Boolean)var1;
                              return (Continuation)var3;
                           }

                           public final Object invoke(boolean var1, Continuation var2) {
                              return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                           }

                           public final Object invokeSuspend(Object var1) {
                              boolean var3 = this.Z$0;
                              Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              int var2 = this.label;
                              if (var2 != 0) {
                                 if (var2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 ResultKt.throwOnFailure(var1);
                              } else {
                                 ResultKt.throwOnFailure(var1);
                                 if (var3 && this.$device.getConnectivityStatus() == ConnectivityStatus.OFFLINE) {
                                    Timber.Forest.d("device local offline while cloud online, perform initialSetupCall", new Object[0]);
                                    DeviceManager var5 = this.this$0.getDeviceManager();
                                    List var6 = CollectionsKt.listOf(this.$device);
                                    Continuation var7 = (Continuation)this;
                                    this.Z$0 = var3;
                                    this.label = 1;
                                    if (var5.initialSetupCall(var6, var7) == var4) {
                                       return var4;
                                    }
                                 }
                              }

                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var11 = (Continuation)this;
                        this.label = 2;
                        if (ApiResultKt.onSuccess(var8, var12, var11) == var4) {
                           return var4;
                        } else {
                           return Unit.INSTANCE;
                        }
                     }
                  }, 3, (Object)null);
                  BuildersKt.launch$default(var5, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, var11, (Continuation)null) {
                     final Device $device;
                     int label;
                     final DeviceDetailsViewModel this$0;

                     {
                        this.$device = var1;
                        this.this$0 = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.$device, this.this$0, var2));
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
                           Timber.Forest var8 = Timber.Forest;
                           StringBuilder var4 = new StringBuilder("get device timezone: ");
                           var4.append(this.$device.getUid());
                           var8.d(var4.toString(), new Object[0]);
                           DeviceManager var5 = this.this$0.getDeviceManager();
                           String var6 = this.$device.getUid();
                           TimeZone var10 = TimeZone.getDefault();
                           Intrinsics.checkNotNullExpressionValue(var10, "getDefault(...)");
                           Context var7 = (Context)this.this$0.getApplication();
                           Continuation var9 = (Continuation)this;
                           this.label = 1;
                           if (var5.getDeviceTimezone(var6, var10, var7, var9) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  }, 3, (Object)null);
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job updateTimerDurationAndRestart(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $duration$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$duration$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$duration$inlined));
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

               HasTimer var8 = (HasTimer)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasTimer) {
                  Continuation var6 = (Continuation)this;
                  HasTimer var5 = (HasTimer)var4;
                  DeviceManager var10 = this.this$0.getDeviceManager();
                  var2 = this.$duration$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var10.updateTimerDurationAndRestart(var5, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job updateWickDryDurationAndRestart(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this, var2) {
         final Device $device;
         final int $duration$inlined;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
            this.$duration$inlined = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0, this.$duration$inlined));
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

               HasWickDryDuration var8 = (HasWickDryDuration)this.L$1;
               Continuation var9 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasWickDryDuration) {
                  Continuation var6 = (Continuation)this;
                  HasWickDryDuration var10 = (HasWickDryDuration)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  var2 = this.$duration$inlined;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateWickDryDurationAndRestart(var10, var2, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job wickDryCanceled(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasWick var7 = (HasWick)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasWick) {
                  Continuation var6 = (Continuation)this;
                  HasWick var9 = (HasWick)var4;
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var5.updateWickDryCanceled(var9, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Job wickDryEnabledChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, (Continuation)null, this) {
         final Device $device;
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final DeviceDetailsViewModel this$0;

         public {
            this.$device = var1;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, var2, this.this$0));
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

               HasWick var7 = (HasWick)this.L$1;
               Continuation var8 = (Continuation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasWick) {
                  Continuation var6 = (Continuation)this;
                  HasWick var5 = (HasWick)var4;
                  DeviceManager var9 = this.this$0.getDeviceManager();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var9.updateWickDryEnabled(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[DeviceSettingsType.values().length];

         try {
            var0[DeviceSettingsType.Fanspeed.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceSettingsType.Brightness.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceSettingsType.Childlock.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceSettingsType.Nightmode.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceSettingsType.Linking.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
