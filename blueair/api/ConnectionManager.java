package com.blueair.api;

import android.content.res.Resources;
import com.blueair.api.client.AblCloudClient;
import com.blueair.api.client.BlueCloudClient;
import com.blueair.api.client.BluetoothDeviceClient;
import com.blueair.api.client.CanGetAttributes;
import com.blueair.api.client.CanGetSensorData;
import com.blueair.api.client.CanGetStatus;
import com.blueair.api.client.CanLinkWithAware;
import com.blueair.api.client.CanManageSchedule;
import com.blueair.api.client.CanManageWelcomeHome;
import com.blueair.api.client.CanProvisionCloud;
import com.blueair.api.client.CanProvisionLocal;
import com.blueair.api.client.CanSetAirRefresh;
import com.blueair.api.client.CanSetAlarm;
import com.blueair.api.client.CanSetAutoModeDependency;
import com.blueair.api.client.CanSetAutoRh;
import com.blueair.api.client.CanSetBrightness;
import com.blueair.api.client.CanSetChildLock;
import com.blueair.api.client.CanSetDehSubMode;
import com.blueair.api.client.CanSetDeviceName;
import com.blueair.api.client.CanSetDisinfection;
import com.blueair.api.client.CanSetEcoMode;
import com.blueair.api.client.CanSetFan;
import com.blueair.api.client.CanSetFilterType;
import com.blueair.api.client.CanSetG4NightMode;
import com.blueair.api.client.CanSetGermShieldMode;
import com.blueair.api.client.CanSetHinsMode;
import com.blueair.api.client.CanSetHourFormat;
import com.blueair.api.client.CanSetHoverEnabled;
import com.blueair.api.client.CanSetHumMode;
import com.blueair.api.client.CanSetHumSubMode;
import com.blueair.api.client.CanSetMainMode;
import com.blueair.api.client.CanSetMode;
import com.blueair.api.client.CanSetNightLamp;
import com.blueair.api.client.CanSetOscillation;
import com.blueair.api.client.CanSetPanelDisplayMode;
import com.blueair.api.client.CanSetSensorMode;
import com.blueair.api.client.CanSetSmartSubMode;
import com.blueair.api.client.CanSetStandBy;
import com.blueair.api.client.CanSetTare;
import com.blueair.api.client.CanSetTemperatureUnit;
import com.blueair.api.client.CanSetTimer;
import com.blueair.api.client.CanSetWick;
import com.blueair.api.client.CanSetYellowWaterRemove;
import com.blueair.api.client.DeviceClient;
import com.blueair.api.client.OnboardingEventsBody;
import com.blueair.api.client.ProvisionBody;
import com.blueair.api.client.RandomVerifyText;
import com.blueair.api.client.WifiDeviceClient;
import com.blueair.api.model.ConnectionCapability;
import com.blueair.api.model.UsesAblCloud;
import com.blueair.api.model.UsesBlueCloud;
import com.blueair.api.model.UsesBluetooth;
import com.blueair.api.model.UsesWifi;
import com.blueair.auth.AuthService;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.Ipv4;
import com.blueair.core.model.OnboardingError;
import com.blueair.core.model.WelcomeHomeLocation;
import io.flatcircle.ble.BleService;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import io.flatcircle.coroutinehelper.PurposeFullyLeftEmptyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0013\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ß\u00012\u00020\u0001:\u0002ß\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J@\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010 \"\n\b\u0001\u0010!\u0018\u0001*\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u001f0#H\u0082H¢\u0006\u0002\u0010$J.\u0010%\u001a\u00020\u0019\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u000f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00190#H\u0082H¢\u0006\u0002\u0010$JT\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010&\"\u0004\b\u0001\u0010 \"\n\b\u0002\u0010!\u0018\u0001*\u00020\u000f2\u001e\u0010\"\u001a\u001a\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u001f0'2\u0006\u0010(\u001a\u0002H&H\u0082H¢\u0006\u0002\u0010)J@\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010 \"\n\b\u0001\u0010!\u0018\u0001*\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u001f0*H\u0082H¢\u0006\u0002\u0010+JB\u0010%\u001a\u00020\u0019\"\u0004\b\u0000\u0010&\"\n\b\u0001\u0010!\u0018\u0001*\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00190'2\u0006\u0010(\u001a\u0002H&H\u0082H¢\u0006\u0002\u0010)J\u0010\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.J \u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015000\u001fH\u0086@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0015J\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001fH\u0086@¢\u0006\u0002\u00101J\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000208070\u001fH\u0086@¢\u0006\u0002\u00101J,\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:070\u001f2\u0006\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010=H\u0086@¢\u0006\u0002\u0010>J<\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u001f2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f2\b\u0010H\u001a\u0004\u0018\u000105H\u0086@¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fH\u0086@¢\u0006\u0002\u00101J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u001fH\u0086@¢\u0006\u0002\u00101J\"\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L070\u001f2\u0006\u0010N\u001a\u00020OH\u0086@¢\u0006\u0002\u0010PJ\u001a\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R070\u001fH\u0086@¢\u0006\u0002\u00101J\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u001fH\u0086@¢\u0006\u0002\u00101J\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010W\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ&\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010Z\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\\J\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fH\u0086@¢\u0006\u0002\u00101J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010_\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010`J\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010b\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010d\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010f\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001a\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0015070\u001fH\u0086@¢\u0006\u0002\u00101J\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010j\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010kJ&\u0010l\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010m\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\\J\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010o\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010q\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010s\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ&\u0010t\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010u\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\\J\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010w\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u0014\u0010}\u001a\b\u0012\u0004\u0012\u00020V0\u001fH\u0086@¢\u0006\u0002\u00101J\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001c\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ(\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u0083\u0001\u001a\u00020\u00112\u0007\u0010\u0084\u0001\u001a\u00020\u0011H\u0086@¢\u0006\u0003\u0010\u0085\u0001J\u001d\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ1\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u0089\u0001\u001a\u00020\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0086@¢\u0006\u0003\u0010\u008c\u0001J(\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u008e\u0001\u001a\u00020T2\u0007\u0010\u008f\u0001\u001a\u00020\u0011H\u0086@¢\u0006\u0003\u0010\u0090\u0001J:\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u008e\u0001\u001a\u00020T2\u0007\u0010\u008f\u0001\u001a\u00020\u00112\u0007\u0010\u0092\u0001\u001a\u00020\u00112\u0007\u0010\u0093\u0001\u001a\u00020\u0011H\u0086@¢\u0006\u0003\u0010\u0094\u0001J1\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u008e\u0001\u001a\u00020T2\u0007\u0010\u008f\u0001\u001a\u00020\u00112\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0086@¢\u0006\u0003\u0010\u0097\u0001J'\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\\J1\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u00112\u0007\u0010\u009a\u0001\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0003\u0010\u009b\u0001J\u001d\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001f\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010{\u001a\u00030 \u0001H\u0086@¢\u0006\u0003\u0010¡\u0001J\u001f\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010{\u001a\u00030 \u0001H\u0086@¢\u0006\u0003\u0010¡\u0001J\u001d\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ+\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010¨\u0001\u001a\u00020\u00112\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0086@¢\u0006\u0003\u0010«\u0001J+\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010¨\u0001\u001a\u00020\u00112\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0086@¢\u0006\u0003\u0010«\u0001J'\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\\J\u001d\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001d\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u0015\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001fH\u0086@¢\u0006\u0002\u00101J\u001d\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001d\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001d\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ+\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010º\u0001\u001a\u00020\u00112\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0086@¢\u0006\u0003\u0010½\u0001J(\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010¿\u0001\u001a\u00020\u00112\u0007\u0010À\u0001\u001a\u00020\u0011H\u0086@¢\u0006\u0003\u0010\u0085\u0001J\u0015\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001fH\u0086@¢\u0006\u0002\u00101J)\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u00112\t\b\u0002\u0010Ã\u0001\u001a\u00020TH\u0086@¢\u0006\u0003\u0010Ä\u0001J\u001d\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020TH\u0086@¢\u0006\u0002\u0010gJ\u001e\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010Ç\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010kJ!\u0010È\u0001\u001a\t\u0012\u0005\u0012\u00030É\u00010\u001f2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0086@¢\u0006\u0003\u0010Ì\u0001J\"\u0010Í\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0086@¢\u0006\u0003\u0010Ì\u0001J\u001c\u0010Î\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ë\u0001070\u001fH\u0086@¢\u0006\u0002\u00101J\u0018\u0010Ï\u0001\u001a\u00020\u00192\u0007\u0010Ð\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010kJ\u001d\u0010Ñ\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u0007\u0010Ò\u0001\u001a\u00020\u0019J\u001e\u0010Ó\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010kJ\u001e\u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010Ö\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010kJ\u0015\u0010×\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fH\u0086@¢\u0006\u0002\u00101J \u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f2\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0086@¢\u0006\u0003\u0010Û\u0001J\u0015\u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH\u0086@¢\u0006\u0002\u00101J\u001d\u0010Ý\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XJ\u001d\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010{\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010XR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006à\u0001"},
   d2 = {"Lcom/blueair/api/ConnectionManager;", "", "resources", "Landroid/content/res/Resources;", "bleService", "Lio/flatcircle/ble/BleService;", "authService", "Lcom/blueair/auth/AuthService;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Landroid/content/res/Resources;Lio/flatcircle/ble/BleService;Lcom/blueair/auth/AuthService;Lcom/blueair/core/model/Device;)V", "clientLock", "clients", "", "Lcom/blueair/api/client/DeviceClient;", "clientsSize", "", "getClientsSize", "()I", "uid", "", "getUid", "()Ljava/lang/String;", "updateDevice", "", "nuDevice", "generateNewClients", "addDeviceIpToClient", "client", "doApiCall", "Lio/flatcircle/coroutinehelper/ApiResult;", "Output", "CanCall", "call", "Lkotlin/reflect/KSuspendFunction1;", "(Lkotlin/reflect/KFunction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doApiCallUnit", "Input", "Lkotlin/reflect/KSuspendFunction2;", "input", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logApiError", "error", "", "getRand", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignJwtToClients", "deviceJwt", "getNewUuid", "Lcom/blueair/core/model/DeviceUuid;", "getSsids", "", "Lcom/blueair/core/model/Ssid;", "getOnboardingEvents", "Lcom/blueair/core/model/DeviceEvent;", "iteration", "mockedError", "Lcom/blueair/core/model/OnboardingError;", "(ILcom/blueair/core/model/OnboardingError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "ssid", "bssid", "password", "rand", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetDevice", "deviceUuid", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "getLatestSensorData", "Lcom/blueair/core/model/IndoorDatapoint;", "getMonthSensorData", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttributes", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "getIsUpdating", "", "setFanSpeed", "Lcom/blueair/api/restapi/SimpleResponse;", "nuFanspeed", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "type", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetAutoModeDependency", "setAutoModeDependency", "nuValue", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBrightness", "nuBrightness", "setChildLock", "nuChildLock", "setDisinfection", "nuDisinfection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinkedUid", "setLinkedUid", "nuUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setStandBy", "nuStandBy", "setEcoMode", "newValue", "setHinsMode", "hinsMode", "setHinsNightMode", "hinsNightMode", "setG4NightMode", "nuG4NightMode", "setGermShieldMode", "nuGermShieldMode", "setGermShieldNightMode", "nuGermShieldNightMode", "setWickDryEnabled", "value", "setWickDryOn", "cancelWickDryMode", "setWickdryDurationAndOn", "setAutoRh", "setTimerStatus", "setTimerDuration", "setTimerDurationAndStatus", "duration", "status", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTemperatureUnit", "setOscillationState", "setOscillationParams", "angle", "direction", "fanSpeed", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDualOscillationState", "horizontal", "state", "(ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOscillationSwing", "minAngle", "maxAngle", "(ZIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOscillationFixed", "fixAngle", "(ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainMode", "setApSubMode", "overwriteMainMode", "(IZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolFanSpeedLevel", "setCoolAutoLevel", "setCoolAutoPresets", "tag", "presets", "", "(I[DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoolEcoPresets", "setMode", "setHumMode", "setDehSubMode", "setSmartSubMode", "setTare", "setPanelDisplayMode", "setHoverEnabled", "setAirRefreshStatus", "setAirRefreshEnabled", "setNightLampBrightness", "setNightLampSteplessBrightness", "setYwrmEnabled", "setAlarm", "index", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "(ILcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playAlarm", "sound", "volume", "stopAlarm", "setHumSubMode", "cancelWickDry", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUse24Hour", "deleteLinkedUid", "linkedUid", "createSchedule", "Lokhttp3/ResponseBody;", "deviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "getSchedules", "deleteSchedule", "scheduleId", "setSensorMode", "clear", "setDeviceName", "name", "setFilterType", "nuFilter", "getDeviceStatus", "createWelcomeHome", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "(Lcom/blueair/core/model/WelcomeHomeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWelcomeHome", "calibrateOscillationPosition", "setOscillationMode", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConnectionManager {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String TYPE_WELCOME_HOME = "welcome_home";
   private final AuthService authService;
   private final BleService bleService;
   private final Object clientLock;
   private final List clients;
   private Device device;

   public ConnectionManager(Resources var1, BleService var2, AuthService var3, Device var4) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "bleService");
      Intrinsics.checkNotNullParameter(var3, "authService");
      Intrinsics.checkNotNullParameter(var4, "device");
      super();
      this.bleService = var2;
      this.authService = var3;
      this.device = var4;
      this.clientLock = new Object();
      this.clients = (List)(new ArrayList());
      this.generateNewClients(var1);
   }

   private final void addDeviceIpToClient(DeviceClient var1, Device var2) {
      if (var1 instanceof WifiDeviceClient && var2 instanceof HasBlueProvisionCalls) {
         label23: {
            DeviceUuid var5 = ((HasBlueProvisionCalls)var2).getDeviceUuid();
            if (var5 != null) {
               Ipv4 var6 = var5.getIpv4();
               if (var6 != null) {
                  var7 = var6.getIp();
                  break label23;
               }
            }

            var7 = null;
         }

         if (var7 != null) {
            CharSequence var3 = (CharSequence)var7;
            if (var3.length() > 0 && !StringsKt.contains$default(var3, (CharSequence)"localhost", false, 2, (Object)null) && !Intrinsics.areEqual(var7, "0.0.0.0")) {
               var1 = var1;
               StringBuilder var8 = new StringBuilder("https://");
               var8.append(var7);
               var1.setBaseUrl(var8.toString());
            }
         }
      }

   }

   // $FF: synthetic method
   private final Object doApiCall(Function1 var1, Continuation var2) {
      Ref.ObjectRef var8 = new Ref.ObjectRef();
      StringBuilder var3 = new StringBuilder("None of the clients in ");
      var3.append(this);
      var3.append(" is ");
      Intrinsics.reifiedOperationMarker(4, "CanCall");
      var3.append(Reflection.getOrCreateKotlinClass(DeviceClient.class).getQualifiedName());
      var8.element = new Failure((Throwable)(new UnknownError(var3.toString())));
      Iterable var4 = (Iterable)this.clients;
      Collection var9 = (Collection)(new ArrayList());

      for(Object var5 : var4) {
         Intrinsics.reifiedOperationMarker(3, "CanCall");
         if (var5 instanceof Object) {
            var9.add(var5);
         }
      }

      for(DeviceClient var10 : (Iterable)((List)var9)) {
         var8.element = var1.invoke(var10);
         if (((ApiResult)var8.element).isSuccess()) {
            Timber.Forest var7 = Timber.Forest;
            StringBuilder var14 = new StringBuilder("client ");
            var14.append(var10);
            var14.append(" gave good result ");
            var14.append(var8.element);
            var14.append(" for call");
            var7.v(var14.toString(), new Object[0]);
            return var8.element;
         }

         Timber.Forest var6 = Timber.Forest;
         StringBuilder var15 = new StringBuilder("client ");
         var15.append(var10);
         var15.append(" gave failed result\n");
         var15.append(var8.element);
         var15.append(" for call, \nwith details:");
         var6.w(var15.toString(), new Object[0]);
         Unit var11 = Unit.INSTANCE;
      }

      this.logApiError(((ApiResult)var8.element).exceptionOrNull());
      return var8.element;
   }

   // $FF: synthetic method
   private final Object doApiCall(KFunction var1, Object var2, Continuation var3) {
      Timber.Forest var9 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("Attempting to doApiCall ");
      var4.append(var1);
      var4.append(", with ");
      var4.append(var2);
      var4.append(" on ");
      var4.append(this.clients.size());
      var4.append(" clients");
      var9.d(var4.toString(), new Object[0]);
      var9 = Timber.Forest;
      var4 = new StringBuilder("Client info: ");
      var4.append(this.clients);
      var9.v(var4.toString(), new Object[0]);
      Ref.ObjectRef var11 = new Ref.ObjectRef();
      var4 = new StringBuilder("None of the clients in ");
      var4.append(this);
      var4.append(" could call ");
      var4.append(var1);
      var11.element = new Failure((Throwable)(new UnknownError(var4.toString())));
      Iterable var5 = (Iterable)this.clients;
      Collection var14 = (Collection)(new ArrayList());

      for(Object var17 : var5) {
         Intrinsics.reifiedOperationMarker(3, "CanCall");
         if (var17 instanceof Object) {
            var14.add(var17);
         }
      }

      for(DeviceClient var15 : (Iterable)((List)var14)) {
         var11.element = ((Function3)var1).invoke(var15, var2, (Object)null);
         if (((ApiResult)var11.element).isSuccess()) {
            Timber.Forest var19 = Timber.Forest;
            StringBuilder var8 = new StringBuilder("client ");
            var8.append(var15);
            var8.append(" gave good result ");
            var8.append(var11.element);
            var8.append(" for call ");
            var8.append(var1);
            var19.v(var8.toString(), new Object[0]);
            return var11.element;
         }

         Timber.Forest var7 = Timber.Forest;
         StringBuilder var20 = new StringBuilder("client ");
         var20.append(var15);
         var20.append(" gave failed result\n");
         var20.append(var11.element);
         var20.append(" for call \n");
         var20.append(var1);
         var20.append(", \nwith details:");
         var7.w(var20.toString(), new Object[0]);
         Unit var16 = Unit.INSTANCE;
      }

      this.logApiError(((ApiResult)var11.element).exceptionOrNull());
      return var11.element;
   }

   // $FF: synthetic method
   private final Object doApiCall(KFunction var1, Continuation var2) {
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("Attempting to doApiCall ");
      var3.append(var1);
      var3.append(" on ");
      var3.append(this.clients.size());
      var3.append(" clients");
      var7.d(var3.toString(), new Object[0]);
      Timber.Forest var10 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("Client info: ");
      var8.append(this.clients);
      var10.v(var8.toString(), new Object[0]);
      Ref.ObjectRef var9 = new Ref.ObjectRef();
      StringBuilder var11 = new StringBuilder("None of the clients in ");
      var11.append(this);
      var11.append(" could call ");
      var11.append(var1);
      var9.element = new Failure((Throwable)(new UnknownError(var11.toString())));
      Iterable var4 = (Iterable)this.clients;
      Collection var12 = (Collection)(new ArrayList());

      for(Object var15 : var4) {
         Intrinsics.reifiedOperationMarker(3, "CanCall");
         if (var15 instanceof Object) {
            var12.add(var15);
         }
      }

      for(DeviceClient var13 : (Iterable)((List)var12)) {
         var9.element = ((Function2)var1).invoke(var13, (Object)null);
         if (((ApiResult)var9.element).isSuccess()) {
            Timber.Forest var19 = Timber.Forest;
            StringBuilder var17 = new StringBuilder("client ");
            var17.append(var13);
            var17.append(" gave good result ");
            var17.append(var9.element);
            var17.append(" for call ");
            var17.append(var1);
            var19.v(var17.toString(), new Object[0]);
            return var9.element;
         }

         Timber.Forest var18 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("client ");
         var6.append(var13);
         var6.append(" gave failed result\n");
         var6.append(var9.element);
         var6.append(" for call \n");
         var6.append(var1);
         var6.append(", \nwith details:");
         var18.w(var6.toString(), new Object[0]);
         Unit var14 = Unit.INSTANCE;
      }

      this.logApiError(((ApiResult)var9.element).exceptionOrNull());
      return var9.element;
   }

   // $FF: synthetic method
   private final Object doApiCallUnit(KFunction var1, Object var2, Continuation var3) {
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("Attempting to doApiCall ");
      var4.append(var1);
      var4.append(" on ");
      var4.append(this.clients.size());
      var4.append(" clients");
      var6.d(var4.toString(), new Object[0]);
      var6 = Timber.Forest;
      var4 = new StringBuilder("Client info: ");
      var4.append(this.clients);
      var6.v(var4.toString(), new Object[0]);
      Iterable var11 = (Iterable)this.clients;
      Collection var8 = (Collection)(new ArrayList());

      for(Object var5 : var11) {
         Intrinsics.reifiedOperationMarker(3, "CanCall");
         if (var5 instanceof Object) {
            var8.add(var5);
         }
      }

      for(DeviceClient var13 : (Iterable)((List)var8)) {
         ((Function3)var1).invoke(var13, var2, (Object)null);
         Unit var14 = Unit.INSTANCE;
      }

      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   private final Object doApiCallUnit(KFunction var1, Continuation var2) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("Attempting to doApiCall ");
      var5.append(var1);
      var5.append(" on ");
      var5.append(this.clients.size());
      var5.append(" clients");
      var3.d(var5.toString(), new Object[0]);
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var9 = new StringBuilder("Client info: ");
      var9.append(this.clients);
      var6.v(var9.toString(), new Object[0]);
      Iterable var10 = (Iterable)this.clients;
      Collection var7 = (Collection)(new ArrayList());

      for(Object var11 : var10) {
         Intrinsics.reifiedOperationMarker(3, "CanCall");
         if (var11 instanceof Object) {
            var7.add(var11);
         }
      }

      for(DeviceClient var12 : (Iterable)((List)var7)) {
         ((Function2)var1).invoke(var12, (Object)null);
         Unit var13 = Unit.INSTANCE;
      }

      return Unit.INSTANCE;
   }

   private final void generateNewClients(Resources var1) {
      ConnectionCapability var3 = ConnectionCapability.Companion.from(this.device);
      Object var2 = this.clientLock;
      synchronized(var2){}

      Throwable var10000;
      label531: {
         Iterator var4;
         try {
            var4 = ((Iterable)this.clients).iterator();
         } catch (Throwable var60) {
            var10000 = var60;
            boolean var10001 = false;
            break label531;
         }

         while(true) {
            try {
               if (var4.hasNext()) {
                  ((DeviceClient)var4.next()).clear();
                  continue;
               }
            } catch (Throwable var61) {
               var10000 = var61;
               boolean var70 = false;
               break;
            }

            try {
               this.clients.clear();
               if (var3 instanceof UsesBluetooth) {
                  List var5 = this.clients;
                  BluetoothDeviceClient var65 = new BluetoothDeviceClient(this.bleService, var1, this.authService, this.device.getUid(), (String)null, (Interceptor)null, 48, (DefaultConstructorMarker)null);
                  var5.add(var65);
               }
            } catch (Throwable var59) {
               var10000 = var59;
               boolean var71 = false;
               break;
            }

            try {
               if (var3 instanceof UsesWifi) {
                  WifiDeviceClient var66 = new WifiDeviceClient(var1, this.device.getUid(), (String)null, this.authService, (Interceptor)null, 20, (DefaultConstructorMarker)null);
                  this.clients.add(var66);
               }
            } catch (Throwable var58) {
               var10000 = var58;
               boolean var72 = false;
               break;
            }

            try {
               if (var3 instanceof UsesBlueCloud) {
                  List var69 = this.clients;
                  BlueCloudClient var67 = new BlueCloudClient(var1, this.authService, this.device.getUid(), (Interceptor)null, 8, (DefaultConstructorMarker)null);
                  var69.add(var67);
               }
            } catch (Throwable var57) {
               var10000 = var57;
               boolean var73 = false;
               break;
            }

            try {
               if (var3 instanceof UsesAblCloud) {
                  List var68 = this.clients;
                  AblCloudClient var64 = new AblCloudClient(var1, this.authService, this.device.getUid(), (Interceptor)null, 8, (DefaultConstructorMarker)null);
                  var68.add(var64);
               }
            } catch (Throwable var56) {
               var10000 = var56;
               boolean var74 = false;
               break;
            }

            try {
               Unit var63 = Unit.INSTANCE;
               return;
            } catch (Throwable var55) {
               var10000 = var55;
               boolean var75 = false;
               break;
            }
         }
      }

      Throwable var62 = var10000;
      throw var62;
   }

   // $FF: synthetic method
   public static Object setHumSubMode$default(ConnectionManager var0, int var1, boolean var2, Continuation var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      return var0.setHumSubMode(var1, var2, var3);
   }

   public final void assignJwtToClients(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceJwt");
      Iterable var3 = (Iterable)this.clients;
      Collection var2 = (Collection)(new ArrayList());

      for(Object var7 : var3) {
         if (var7 instanceof CanProvisionLocal) {
            var2.add(var7);
         }
      }

      for(CanProvisionLocal var8 : (Iterable)((List)var2)) {
         var8.setDeviceJwt(var1);
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var9 = new StringBuilder("saved JWT for ");
         var9.append(var8);
         var9.append(" was added. Token = ");
         var9.append(var8.getDeviceJwt());
         var5.d(var9.toString(), new Object[0]);
      }

   }

   public final Object calibrateOscillationPosition(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.calibrateOscillationPosition(0, (Continuation)this);
            }
         };
      }

      Object var20 = ((<undefinedtype>)var16).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      Iterable var8;
      Iterator var9;
      ConnectionManager var10;
      Ref.ObjectRef var22;
      Object var30;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var16).I$4;
         var1 = ((<undefinedtype>)var16).I$3;
         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var1 = ((<undefinedtype>)var16).I$0;
         Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var16).L$7;
         CanSetOscillation var6 = (CanSetOscillation)((<undefinedtype>)var16).L$6;
         var6 = (DeviceClient)((<undefinedtype>)var16).L$5;
         var30 = ((<undefinedtype>)var16).L$4;
         var9 = (Iterator)((<undefinedtype>)var16).L$3;
         var8 = (Iterable)((<undefinedtype>)var16).L$2;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var16).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var20);
         var30 = var16;
         var11.element = (ApiResult)var20;
         if (((ApiResult)var12.element).isSuccess()) {
            Timber.Forest var31 = Timber.Forest;
            StringBuilder var23 = new StringBuilder("client ");
            var23.append(var6);
            var23.append(" gave good result ");
            var23.append(var12.element);
            var23.append(" for call");
            var31.v(var23.toString(), new Object[0]);
            return var12.element;
         }

         Timber.Forest var36 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("client ");
         var21.append(var6);
         var21.append(" gave failed result\n");
         var21.append(var12.element);
         var21.append(" for call, \nwith details:");
         var36.w(var21.toString(), new Object[0]);
         var22 = var12;
      } else {
         ResultKt.throwOnFailure(var20);
         var22 = new Ref.ObjectRef();
         StringBuilder var27 = new StringBuilder("None of the clients in ");
         var27.append(this);
         var27.append(" is ");
         var27.append(Reflection.getOrCreateKotlinClass(CanSetOscillation.class).getQualifiedName());
         var22.element = new Failure((Throwable)(new UnknownError(var27.toString())));
         Iterable var32 = (Iterable)this.clients;
         Collection var28 = (Collection)(new ArrayList());

         for(Object var35 : var32) {
            if (var35 instanceof CanSetOscillation) {
               var28.add(var35);
            }
         }

         var8 = (Iterable)((List)var28);
         var9 = var8.iterator();
         var10 = this;
         var3 = 0;
         var4 = 0;
         var30 = var16;
      }

      while(var9.hasNext()) {
         Object var37 = var9.next();
         DeviceClient var29 = (DeviceClient)var37;
         CanSetOscillation var17 = (CanSetOscillation)var29;
         ((<undefinedtype>)var30).L$0 = var10;
         ((<undefinedtype>)var30).L$1 = var22;
         ((<undefinedtype>)var30).L$2 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var30).L$3 = var9;
         ((<undefinedtype>)var30).L$4 = SpillingKt.nullOutSpilledVariable(var37);
         ((<undefinedtype>)var30).L$5 = var29;
         ((<undefinedtype>)var30).L$6 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var30).L$7 = var22;
         ((<undefinedtype>)var30).I$0 = var1;
         ((<undefinedtype>)var30).I$1 = var4;
         ((<undefinedtype>)var30).I$2 = var3;
         ((<undefinedtype>)var30).I$3 = 0;
         ((<undefinedtype>)var30).I$4 = 0;
         ((<undefinedtype>)var30).label = 1;
         Object var39 = var17.calibrateOscillationPosition(var1, (Continuation)var30);
         if (var39 == var13) {
            return var13;
         }

         Ref.ObjectRef var18 = var22;
         var22.element = (ApiResult)var39;
         if (((ApiResult)var22.element).isSuccess()) {
            Timber.Forest var34 = Timber.Forest;
            StringBuilder var25 = new StringBuilder("client ");
            var25.append(var29);
            var25.append(" gave good result ");
            var25.append(var18.element);
            var25.append(" for call");
            var34.v(var25.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var38 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("client ");
         var24.append(var29);
         var24.append(" gave failed result\n");
         var24.append(var18.element);
         var24.append(" for call, \nwith details:");
         var38.w(var24.toString(), new Object[0]);
         var22 = var18;
      }

      var10.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object cancelWickDryMode(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var1;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var15 = var5;
               break label43;
            }
         }

         var15 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.cancelWickDryMode((Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var15).result;
      Object var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var15).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var8;
      Iterable var10;
      ConnectionManager var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var16;
      Object var23;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var15).I$2;
         var2 = ((<undefinedtype>)var15).I$1;
         var4 = ((<undefinedtype>)var15).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var15).L$7;
         var7 = (DeviceClient)((<undefinedtype>)var15).L$6;
         var23 = ((<undefinedtype>)var15).L$5;
         var8 = (Iterator)((<undefinedtype>)var15).L$4;
         var10 = (Iterable)((<undefinedtype>)var15).L$3;
         Ref.ObjectRef var9 = (Ref.ObjectRef)((<undefinedtype>)var15).L$2;
         var6 = (KFunction)((<undefinedtype>)var15).L$1;
         var11 = (ConnectionManager)((<undefinedtype>)var15).L$0;
         ResultKt.throwOnFailure(var12);
         var23 = var15;
         var16 = var9;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetWick) {
               var32.add(var36);
            }
         }

         var10 = (Iterable)((List)var32);
         var8 = var10.iterator();
         var11 = this;
         byte var3 = 0;
         var2 = 0;
         Object var37 = var15;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var12 = var8.next();
         var7 = (DeviceClient)var12;
         Function2 var17 = (Function2)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var26;
         ((<undefinedtype>)var37).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var37).L$4 = var8;
         ((<undefinedtype>)var37).L$5 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var37).L$6 = var7;
         ((<undefinedtype>)var37).L$7 = var26;
         ((<undefinedtype>)var37).I$0 = var2;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var12 = var17.invoke(var7, var37);
         if (var12 == var14) {
            return var14;
         }

         var16 = var26;
         var13 = var26;
         var4 = var2;
         var2 = var3;
         var23 = var37;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var16.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var16.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var16.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var38 = new StringBuilder("client ");
         var38.append(var7);
         var38.append(" gave failed result\n");
         var38.append(var16.element);
         var38.append(" for call \n");
         var38.append(var6);
         var38.append(", \nwith details:");
         var41.w(var38.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var16;
         if (!var8.hasNext()) {
            var11.logApiError(((ApiResult)var16.element).exceptionOrNull());
            return var16.element;
         }

         Object var42 = var8.next();
         var7 = (DeviceClient)var42;
         Function2 var18 = (Function2)var6;
         ((<undefinedtype>)var39).L$0 = var11;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var27;
         ((<undefinedtype>)var39).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var39).L$4 = var8;
         ((<undefinedtype>)var39).L$5 = SpillingKt.nullOutSpilledVariable(var42);
         ((<undefinedtype>)var39).L$6 = var7;
         ((<undefinedtype>)var39).L$7 = var27;
         ((<undefinedtype>)var39).I$0 = var4;
         ((<undefinedtype>)var39).I$1 = var2;
         ((<undefinedtype>)var39).I$2 = 0;
         ((<undefinedtype>)var39).label = 1;
         var12 = var18.invoke(var7, var39);
         if (var12 == var14) {
            return var14;
         }

         var16 = var27;
         var13 = var27;
         var4 = var4;
         var2 = var2;
         var23 = var39;
      }
   }

   public final void clear() {
      Object var1 = this.clientLock;
      synchronized(var1){}

      Throwable var10000;
      label132: {
         Iterator var2;
         try {
            var2 = ((Iterable)this.clients).iterator();
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var10001 = false;
            break label132;
         }

         while(true) {
            try {
               if (var2.hasNext()) {
                  ((DeviceClient)var2.next()).clear();
                  continue;
               }
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var17 = false;
               break;
            }

            try {
               this.clients.clear();
               Unit var16 = Unit.INSTANCE;
               return;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var18 = false;
               break;
            }
         }
      }

      Throwable var15 = var10000;
      throw var15;
   }

   public final Object configureOscillationFixed(boolean var1, int var2, int var3, Continuation var4) {
      label43: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var8 = (<undefinedtype>)var4;
            if ((var8.label & Integer.MIN_VALUE) != 0) {
               var8.label += Integer.MIN_VALUE;
               var21 = var8;
               break label43;
            }
         }

         var21 = new ContinuationImpl(this, var4) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            int I$5;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.configureOscillationFixed(false, 0, 0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var21).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var21).label;
      int var6;
      Iterable var10;
      Iterator var11;
      ConnectionManager var12;
      Ref.ObjectRef var22;
      if (var5 != 0) {
         if (var5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var21).I$5;
         var2 = ((<undefinedtype>)var21).I$4;
         var3 = ((<undefinedtype>)var21).I$3;
         var2 = ((<undefinedtype>)var21).I$2;
         int var7 = ((<undefinedtype>)var21).I$1;
         var5 = ((<undefinedtype>)var21).I$0;
         var1 = ((<undefinedtype>)var21).Z$0;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var21).L$7;
         CanSetOscillation var31 = (CanSetOscillation)((<undefinedtype>)var21).L$6;
         DeviceClient var9 = (DeviceClient)((<undefinedtype>)var21).L$5;
         var31 = (CanSetOscillation)((<undefinedtype>)var21).L$4;
         var11 = (Iterator)((<undefinedtype>)var21).L$3;
         var10 = (Iterable)((<undefinedtype>)var21).L$2;
         Ref.ObjectRef var33 = (Ref.ObjectRef)((<undefinedtype>)var21).L$1;
         var12 = (ConnectionManager)((<undefinedtype>)var21).L$0;
         ResultKt.throwOnFailure(var13);
         var6 = var5;
         var5 = var7;
         var7 = var3;
         var14.element = (ApiResult)var13;
         if (((ApiResult)var33.element).isSuccess()) {
            Timber.Forest var40 = Timber.Forest;
            StringBuilder var23 = new StringBuilder("client ");
            var23.append(var9);
            var23.append(" gave good result ");
            var23.append(var33.element);
            var23.append(" for call");
            var40.v(var23.toString(), new Object[0]);
            return var33.element;
         }

         Timber.Forest var45 = Timber.Forest;
         StringBuilder var48 = new StringBuilder("client ");
         var48.append(var9);
         var48.append(" gave failed result\n");
         var48.append(var33.element);
         var48.append(" for call, \nwith details:");
         var45.w(var48.toString(), new Object[0]);
         var3 = var5;
         var13 = var21;
         var5 = var7;
         var22 = var33;
      } else {
         ResultKt.throwOnFailure(var13);
         Ref.ObjectRef var34 = new Ref.ObjectRef();
         StringBuilder var37 = new StringBuilder("None of the clients in ");
         var37.append(this);
         var37.append(" is ");
         var37.append(Reflection.getOrCreateKotlinClass(CanSetOscillation.class).getQualifiedName());
         var34.element = new Failure((Throwable)(new UnknownError(var37.toString())));
         var10 = (Iterable)this.clients;
         Collection var38 = (Collection)(new ArrayList());

         for(Object var44 : var10) {
            if (var44 instanceof CanSetOscillation) {
               var38.add(var44);
            }
         }

         var10 = (Iterable)((List)var38);
         var11 = var10.iterator();
         var12 = this;
         var5 = 0;
         byte var30 = 0;
         var13 = var21;
         var6 = var2;
         var22 = var34;
         var2 = var30;
      }

      while(var11.hasNext()) {
         Object var35 = var11.next();
         DeviceClient var39 = (DeviceClient)var35;
         CanSetOscillation var49 = (CanSetOscillation)var39;
         ((<undefinedtype>)var13).L$0 = var12;
         ((<undefinedtype>)var13).L$1 = var22;
         ((<undefinedtype>)var13).L$2 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var13).L$3 = var11;
         ((<undefinedtype>)var13).L$4 = SpillingKt.nullOutSpilledVariable(var35);
         ((<undefinedtype>)var13).L$5 = var39;
         ((<undefinedtype>)var13).L$6 = SpillingKt.nullOutSpilledVariable(var49);
         ((<undefinedtype>)var13).L$7 = var22;
         ((<undefinedtype>)var13).Z$0 = var1;
         ((<undefinedtype>)var13).I$0 = var6;
         ((<undefinedtype>)var13).I$1 = var3;
         ((<undefinedtype>)var13).I$2 = var2;
         ((<undefinedtype>)var13).I$3 = var5;
         ((<undefinedtype>)var13).I$4 = 0;
         ((<undefinedtype>)var13).I$5 = 0;
         ((<undefinedtype>)var13).label = 1;
         Object var15 = var49.configureOscillationFixed(var1, var6, var3, (Continuation)var13);
         if (var15 == var16) {
            return var16;
         }

         Ref.ObjectRef var36 = var22;
         Ref.ObjectRef var50 = var22;
         Object var24 = var13;
         var50.element = (ApiResult)var15;
         if (((ApiResult)var36.element).isSuccess()) {
            Timber.Forest var43 = Timber.Forest;
            StringBuilder var25 = new StringBuilder("client ");
            var25.append(var39);
            var25.append(" gave good result ");
            var25.append(var36.element);
            var25.append(" for call");
            var43.v(var25.toString(), new Object[0]);
            return var36.element;
         }

         Timber.Forest var47 = Timber.Forest;
         StringBuilder var51 = new StringBuilder("client ");
         var51.append(var39);
         var51.append(" gave failed result\n");
         var51.append(var36.element);
         var51.append(" for call, \nwith details:");
         var47.w(var51.toString(), new Object[0]);
         var3 = var3;
         var13 = var24;
         var5 = var5;
         var22 = var36;
      }

      var12.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object configureOscillationSwing(boolean var1, int var2, int var3, int var4, Continuation var5) {
      label43: {
         if (var5 instanceof <undefinedtype>) {
            <undefinedtype> var9 = (<undefinedtype>)var5;
            if ((var9.label & Integer.MIN_VALUE) != 0) {
               var9.label += Integer.MIN_VALUE;
               var24 = var9;
               break label43;
            }
         }

         var24 = new ContinuationImpl(this, var5) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            int I$5;
            int I$6;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.configureOscillationSwing(false, 0, 0, 0, (Continuation)this);
            }
         };
      }

      CanSetOscillation var14 = (CanSetOscillation)((<undefinedtype>)var24).result;
      Object var17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var6 = ((<undefinedtype>)var24).label;
      int var8;
      Iterator var10;
      Object var11;
      Iterable var12;
      Ref.ObjectRef var25;
      int var28;
      ConnectionManager var31;
      if (var6 != 0) {
         if (var6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var24).I$6;
         var2 = ((<undefinedtype>)var24).I$5;
         var4 = ((<undefinedtype>)var24).I$4;
         var28 = ((<undefinedtype>)var24).I$3;
         var2 = ((<undefinedtype>)var24).I$2;
         var6 = ((<undefinedtype>)var24).I$1;
         var3 = ((<undefinedtype>)var24).I$0;
         var1 = ((<undefinedtype>)var24).Z$0;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var24).L$7;
         CanSetOscillation var29 = (CanSetOscillation)((<undefinedtype>)var24).L$6;
         DeviceClient var13 = (DeviceClient)((<undefinedtype>)var24).L$5;
         var29 = (CanSetOscillation)((<undefinedtype>)var24).L$4;
         var10 = (Iterator)((<undefinedtype>)var24).L$3;
         var12 = (Iterable)((<undefinedtype>)var24).L$2;
         Ref.ObjectRef var16 = (Ref.ObjectRef)((<undefinedtype>)var24).L$1;
         var31 = (ConnectionManager)((<undefinedtype>)var24).L$0;
         ResultKt.throwOnFailure(var14);
         var11 = var24;
         var25 = var16;
         var15.element = (ApiResult)var14;
         if (((ApiResult)var16.element).isSuccess()) {
            Timber.Forest var32 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var13);
            var35.append(" gave good result ");
            var35.append(var16.element);
            var35.append(" for call");
            var32.v(var35.toString(), new Object[0]);
            return var16.element;
         }

         Timber.Forest var47 = Timber.Forest;
         StringBuilder var43 = new StringBuilder("client ");
         var43.append(var13);
         var43.append(" gave failed result\n");
         var43.append(var16.element);
         var43.append(" for call, \nwith details:");
         var47.w(var43.toString(), new Object[0]);
         var8 = var28;
         var28 = var4;
         var4 = var3;
         var3 = var6;
      } else {
         ResultKt.throwOnFailure(var14);
         Ref.ObjectRef var33 = new Ref.ObjectRef();
         StringBuilder var36 = new StringBuilder("None of the clients in ");
         var36.append(this);
         var36.append(" is ");
         var36.append(Reflection.getOrCreateKotlinClass(CanSetOscillation.class).getQualifiedName());
         var33.element = new Failure((Throwable)(new UnknownError(var36.toString())));
         Iterable var39 = (Iterable)this.clients;
         Collection var37 = (Collection)(new ArrayList());

         for(Object var40 : var39) {
            if (var40 instanceof CanSetOscillation) {
               var37.add(var40);
            }
         }

         var12 = (Iterable)((List)var37);
         var10 = var12.iterator();
         var6 = var2;
         var2 = var4;
         var11 = var24;
         var8 = 0;
         var28 = 0;
         var25 = var33;
         var4 = var6;
         var31 = this;
      }

      while(var10.hasNext()) {
         Object var48 = var10.next();
         DeviceClient var42 = (DeviceClient)var48;
         var14 = (CanSetOscillation)var42;
         ((<undefinedtype>)var11).L$0 = var31;
         ((<undefinedtype>)var11).L$1 = var25;
         ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var11).L$3 = var10;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var48);
         ((<undefinedtype>)var11).L$5 = var42;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var11).L$7 = var25;
         ((<undefinedtype>)var11).Z$0 = var1;
         ((<undefinedtype>)var11).I$0 = var4;
         ((<undefinedtype>)var11).I$1 = var3;
         ((<undefinedtype>)var11).I$2 = var2;
         ((<undefinedtype>)var11).I$3 = var8;
         ((<undefinedtype>)var11).I$4 = var28;
         ((<undefinedtype>)var11).I$5 = 0;
         ((<undefinedtype>)var11).I$6 = 0;
         ((<undefinedtype>)var11).label = 1;
         var14 = (CanSetOscillation)var14.configureOscillationSwing(var1, var4, var3, var2, (Continuation)var11);
         if (var14 == var17) {
            return var17;
         }

         Ref.ObjectRef var49 = var25;
         var25 = var25;
         var49.element = (ApiResult)var14;
         if (((ApiResult)var25.element).isSuccess()) {
            Timber.Forest var34 = Timber.Forest;
            StringBuilder var38 = new StringBuilder("client ");
            var38.append(var42);
            var38.append(" gave good result ");
            var38.append(var25.element);
            var38.append(" for call");
            var34.v(var38.toString(), new Object[0]);
            return var25.element;
         }

         Timber.Forest var50 = Timber.Forest;
         StringBuilder var46 = new StringBuilder("client ");
         var46.append(var42);
         var46.append(" gave failed result\n");
         var46.append(var25.element);
         var46.append(" for call, \nwith details:");
         var50.w(var46.toString(), new Object[0]);
         var8 = var8;
         var28 = var28;
         var4 = var4;
         var3 = var3;
      }

      var31.logApiError(((ApiResult)var25.element).exceptionOrNull());
      return var25.element;
   }

   public final Object createSchedule(DeviceSchedule var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.createSchedule((DeviceSchedule)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      ConnectionManager var8;
      Iterable var9;
      Iterator var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var23;
      DeviceSchedule var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var10 = (Iterator)((<undefinedtype>)var22).L$6;
         var9 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (DeviceSchedule)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var8 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (DeviceSchedule)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var33 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var27 = var1;
         var29.append(var1);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var33.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var18 = new StringBuilder("Client info: ");
         var18.append(this.clients);
         var30.v(var18.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanManageSchedule) {
               var32.add(var36);
            }
         }

         var9 = (Iterable)((List)var32);
         var10 = var9.iterator();
         var8 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var41 = var10.next();
         var11 = (DeviceClient)var41;
         Function3 var38 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var22).L$6 = var10;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var38.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var13 = var19;
         var1 = var27;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var21 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var11);
            var28.append(" gave good result ");
            var28.append(var23.element);
            var28.append(" for call ");
            var28.append(var6);
            var21.v(var28.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var11);
         var39.append(" gave failed result\n");
         var39.append(var23.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         DeviceSchedule var37 = var1;
         Ref.ObjectRef var20 = var23;
         DeviceSchedule var24 = var37;
         if (!var10.hasNext()) {
            var8.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var43 = var10.next();
         var11 = (DeviceClient)var43;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var8;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var7).L$6 = var10;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var40.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         DeviceSchedule var44 = var24;
         var23 = var20;
         var13 = var20;
         var1 = var44;
      }
   }

   public final Object createWelcomeHome(WelcomeHomeLocation var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.createWelcomeHome((WelcomeHomeLocation)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      ConnectionManager var8;
      Iterable var9;
      Iterator var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var23;
      WelcomeHomeLocation var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var10 = (Iterator)((<undefinedtype>)var22).L$6;
         var9 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (WelcomeHomeLocation)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var8 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (WelcomeHomeLocation)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var33 = new StringBuilder("Attempting to doApiCall ");
         var33.append(var6);
         var33.append(", with ");
         var27 = var1;
         var33.append(var1);
         var33.append(" on ");
         var33.append(this.clients.size());
         var33.append(" clients");
         var29.d(var33.toString(), new Object[0]);
         Timber.Forest var18 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var18.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanManageWelcomeHome) {
               var32.add(var35);
            }
         }

         var9 = (Iterable)((List)var32);
         var10 = var9.iterator();
         var8 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var41 = var10.next();
         var11 = (DeviceClient)var41;
         Function3 var38 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var22).L$6 = var10;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var38.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var13 = var19;
         var1 = var27;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("client ");
            var21.append(var11);
            var21.append(" gave good result ");
            var21.append(var23.element);
            var21.append(" for call ");
            var21.append(var6);
            var28.v(var21.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var11);
         var39.append(" gave failed result\n");
         var39.append(var23.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         WelcomeHomeLocation var37 = var1;
         Ref.ObjectRef var20 = var23;
         WelcomeHomeLocation var24 = var37;
         if (!var10.hasNext()) {
            var8.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var43 = var10.next();
         var11 = (DeviceClient)var43;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var8;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var7).L$6 = var10;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var40.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         WelcomeHomeLocation var44 = var24;
         var23 = var20;
         var13 = var20;
         var1 = var44;
      }
   }

   public final Object deleteLinkedUid(String var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteLinkedUid((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      Iterator var8;
      ConnectionManager var9;
      Iterable var10;
      DeviceClient var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var23;
      String var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var8 = (Iterator)((<undefinedtype>)var22).L$6;
         var10 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (String)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var9 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (String)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var13;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var33 = new StringBuilder("Attempting to doApiCall ");
         var33.append(var6);
         var33.append(", with ");
         var27 = var1;
         var33.append(var1);
         var33.append(" on ");
         var33.append(this.clients.size());
         var33.append(" clients");
         var29.d(var33.toString(), new Object[0]);
         var29 = Timber.Forest;
         StringBuilder var18 = new StringBuilder("Client info: ");
         var18.append(this.clients);
         var29.v(var18.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanLinkWithAware) {
               var32.add(var36);
            }
         }

         var10 = (Iterable)((List)var32);
         var8 = var10.iterator();
         var9 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var41 = var8.next();
         var11 = (DeviceClient)var41;
         Function3 var38 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var22).L$6 = var8;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var38.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var14 = var19;
         var1 = var27;
      }

      while(true) {
         var14.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("client ");
            var21.append(var11);
            var21.append(" gave good result ");
            var21.append(var23.element);
            var21.append(" for call ");
            var21.append(var6);
            var28.v(var21.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var39 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var11);
         var42.append(" gave failed result\n");
         var42.append(var23.element);
         var42.append(" for call \n");
         var42.append(var6);
         var42.append(", \nwith details:");
         var39.w(var42.toString(), new Object[0]);
         String var37 = var1;
         Ref.ObjectRef var20 = var23;
         String var24 = var37;
         if (!var8.hasNext()) {
            var9.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var43 = var8.next();
         var11 = (DeviceClient)var43;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var9;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var7).L$6 = var8;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var40.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         String var44 = var24;
         var23 = var20;
         var14 = var20;
         var1 = var44;
      }
   }

   public final Object deleteSchedule(String var1, Continuation var2) {
      label39: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label39;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteSchedule((String)null, (Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var16).result;
      Object var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      Iterable var6;
      KFunction var7;
      ConnectionManager var8;
      Iterator var9;
      String var19;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var3 = ((<undefinedtype>)var16).I$0;
         DeviceClient var14 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var14 = (DeviceClient)((<undefinedtype>)var16).L$6;
         var9 = (Iterator)((<undefinedtype>)var16).L$5;
         var6 = (Iterable)((<undefinedtype>)var16).L$4;
         var1 = (String)((<undefinedtype>)var16).L$3;
         var7 = (KFunction)((<undefinedtype>)var16).L$2;
         var8 = (ConnectionManager)((<undefinedtype>)var16).L$1;
         var19 = (String)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var11);
      } else {
         ResultKt.throwOnFailure(var11);
         var7 = (KFunction)null.INSTANCE;
         Timber.Forest var23 = Timber.Forest;
         StringBuilder var20 = new StringBuilder("Attempting to doApiCall ");
         var20.append(var7);
         var20.append(" on ");
         var20.append(this.clients.size());
         var20.append(" clients");
         var23.d(var20.toString(), new Object[0]);
         var23 = Timber.Forest;
         var20 = new StringBuilder("Client info: ");
         var20.append(this.clients);
         var23.v(var20.toString(), new Object[0]);
         Iterable var25 = (Iterable)this.clients;
         Collection var22 = (Collection)(new ArrayList());

         for(Object var26 : var25) {
            if (var26 instanceof CanManageSchedule) {
               var22.add(var26);
            }
         }

         var6 = (Iterable)((List)var22);
         var9 = var6.iterator();
         var8 = this;
         var3 = 0;
         var4 = 0;
         var19 = var1;
      }

      while(var9.hasNext()) {
         var11 = var9.next();
         DeviceClient var13 = (DeviceClient)var11;
         Function3 var12 = (Function3)var7;
         ((<undefinedtype>)var16).L$0 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var16).L$1 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var16).L$2 = var7;
         ((<undefinedtype>)var16).L$3 = var1;
         ((<undefinedtype>)var16).L$4 = SpillingKt.nullOutSpilledVariable(var6);
         ((<undefinedtype>)var16).L$5 = var9;
         ((<undefinedtype>)var16).L$6 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var16).L$7 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var16).I$0 = var3;
         ((<undefinedtype>)var16).I$1 = var4;
         ((<undefinedtype>)var16).I$2 = 0;
         ((<undefinedtype>)var16).label = 1;
         if (var12.invoke(var13, var1, var16) == var10) {
            return var10;
         }
      }

      Timber.Forest.d("Failing here?", new Object[0]);
      return Unit.INSTANCE;
   }

   public final Object deleteWelcomeHome(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteWelcomeHome((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      ConnectionManager var7;
      Object var8;
      Iterable var9;
      Iterator var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var2 = ((<undefinedtype>)var14).I$1;
         var3 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var10 = (Iterator)((<undefinedtype>)var14).L$4;
         var9 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var7 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var8 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("Attempting to doApiCall ");
         var21.append(var25);
         var21.append(" on ");
         var21.append(this.clients.size());
         var21.append(" clients");
         var26.d(var21.toString(), new Object[0]);
         Timber.Forest var22 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var22.v(var27.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var27 = new StringBuilder("None of the clients in ");
         var27.append(this);
         var27.append(" could call ");
         var27.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var27.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var33 : var30) {
            if (var33 instanceof CanManageWelcomeHome) {
               var29.add(var33);
            }
         }

         var9 = (Iterable)((List)var29);
         var10 = var9.iterator();
         var7 = this;
         var2 = 0;
         var3 = 0;
         var8 = var14;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var16 = var10.next();
         var6 = (DeviceClient)var16;
         Function2 var34 = (Function2)var25;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var25;
         ((<undefinedtype>)var8).L$2 = var20;
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var8).L$4 = var10;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var8).L$6 = var6;
         ((<undefinedtype>)var8).L$7 = var20;
         ((<undefinedtype>)var8).I$0 = var3;
         ((<undefinedtype>)var8).I$1 = var2;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         var11 = var34.invoke(var6, var8);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var32 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var6);
            var24.append(" gave good result ");
            var24.append(var15.element);
            var24.append(" for call ");
            var24.append(var25);
            var32.v(var24.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var6);
         var23.append(" gave failed result\n");
         var23.append(var15.element);
         var23.append(" for call \n");
         var23.append(var25);
         var23.append(", \nwith details:");
         var35.w(var23.toString(), new Object[0]);
         var20 = var15;
         if (!var10.hasNext()) {
            var7.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var10.next();
         var6 = (DeviceClient)var17;
         Function2 var36 = (Function2)var25;
         ((<undefinedtype>)var8).L$0 = var7;
         ((<undefinedtype>)var8).L$1 = var25;
         ((<undefinedtype>)var8).L$2 = var20;
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var8).L$4 = var10;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var8).L$6 = var6;
         ((<undefinedtype>)var8).L$7 = var20;
         ((<undefinedtype>)var8).I$0 = var3;
         ((<undefinedtype>)var8).I$1 = var2;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         var11 = var36.invoke(var6, var8);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final Object getAttributes(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAttributes((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Object var7;
      Iterable var8;
      ConnectionManager var9;
      Iterator var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var10 = (Iterator)((<undefinedtype>)var14).L$4;
         var8 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("Attempting to doApiCall ");
         var21.append(var25);
         var21.append(" on ");
         var21.append(this.clients.size());
         var21.append(" clients");
         var26.d(var21.toString(), new Object[0]);
         Timber.Forest var22 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var22.v(var27.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var27 = new StringBuilder("None of the clients in ");
         var27.append(this);
         var27.append(" could call ");
         var27.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var27.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var33 : var30) {
            if (var33 instanceof CanGetAttributes) {
               var29.add(var33);
            }
         }

         var8 = (Iterable)((List)var29);
         var10 = var8.iterator();
         var9 = this;
         var3 = 0;
         var2 = 0;
         var7 = var14;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var16 = var10.next();
         var6 = (DeviceClient)var16;
         Function2 var34 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = this;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$4 = var10;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var34.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var6);
            var32.append(" gave good result ");
            var32.append(var15.element);
            var32.append(" for call ");
            var32.append(var25);
            var24.v(var32.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var23 = Timber.Forest;
         StringBuilder var35 = new StringBuilder("client ");
         var35.append(var6);
         var35.append(" gave failed result\n");
         var35.append(var15.element);
         var35.append(" for call \n");
         var35.append(var25);
         var35.append(", \nwith details:");
         var23.w(var35.toString(), new Object[0]);
         var20 = var15;
         if (!var10.hasNext()) {
            var9.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var10.next();
         var6 = (DeviceClient)var17;
         Function2 var36 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = var9;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$4 = var10;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var36.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final int getClientsSize() {
      return this.clients.size();
   }

   public final Object getDeviceStatus(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getDeviceStatus((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Iterable var7;
      Object var8;
      Iterator var9;
      ConnectionManager var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var2 = ((<undefinedtype>)var14).I$1;
         var3 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var9 = (Iterator)((<undefinedtype>)var14).L$4;
         var7 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var8 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var21 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("Attempting to doApiCall ");
         var26.append(var25);
         var26.append(" on ");
         var26.append(this.clients.size());
         var26.append(" clients");
         var21.d(var26.toString(), new Object[0]);
         Timber.Forest var22 = Timber.Forest;
         var26 = new StringBuilder("Client info: ");
         var26.append(this.clients);
         var22.v(var26.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var26 = new StringBuilder("None of the clients in ");
         var26.append(this);
         var26.append(" could call ");
         var26.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var26.toString())));
         var7 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var31 : var7) {
            if (var31 instanceof CanGetStatus) {
               var29.add(var31);
            }
         }

         var7 = (Iterable)((List)var29);
         var9 = var7.iterator();
         var10 = this;
         var2 = 0;
         var3 = 0;
         var8 = var14;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         var11 = var9.next();
         var6 = (DeviceClient)var11;
         Function2 var16 = (Function2)var25;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var25;
         ((<undefinedtype>)var8).L$2 = var20;
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var8).L$4 = var9;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var8).L$6 = var6;
         ((<undefinedtype>)var8).L$7 = var20;
         ((<undefinedtype>)var8).I$0 = var3;
         ((<undefinedtype>)var8).I$1 = var2;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         var11 = var16.invoke(var6, var8);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var32 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var6);
            var24.append(" gave good result ");
            var24.append(var15.element);
            var24.append(" for call ");
            var24.append(var25);
            var32.v(var24.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var6);
         var23.append(" gave failed result\n");
         var23.append(var15.element);
         var23.append(" for call \n");
         var23.append(var25);
         var23.append(", \nwith details:");
         var35.w(var23.toString(), new Object[0]);
         var20 = var15;
         if (!var9.hasNext()) {
            var10.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var36 = var9.next();
         var6 = (DeviceClient)var36;
         Function2 var17 = (Function2)var25;
         ((<undefinedtype>)var8).L$0 = var10;
         ((<undefinedtype>)var8).L$1 = var25;
         ((<undefinedtype>)var8).L$2 = var20;
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var8).L$4 = var9;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var36);
         ((<undefinedtype>)var8).L$6 = var6;
         ((<undefinedtype>)var8).L$7 = var20;
         ((<undefinedtype>)var8).I$0 = var3;
         ((<undefinedtype>)var8).I$1 = var2;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         var11 = var17.invoke(var6, var8);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final Object getIsUpdating(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getIsUpdating((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      KFunction var5;
      DeviceClient var6;
      Iterator var7;
      ConnectionManager var8;
      Iterable var10;
      Ref.ObjectRef var12;
      Ref.ObjectRef var15;
      Object var21;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         var21 = ((<undefinedtype>)var14).L$5;
         var7 = (Iterator)((<undefinedtype>)var14).L$4;
         var10 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var9 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var5 = (KFunction)((<undefinedtype>)var14).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var21 = var14;
         var15 = var9;
      } else {
         ResultKt.throwOnFailure(var11);
         var5 = (KFunction)null.INSTANCE;
         Timber.Forest var27 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("Attempting to doApiCall ");
         var22.append(var5);
         var22.append(" on ");
         var22.append(this.clients.size());
         var22.append(" clients");
         var27.d(var22.toString(), new Object[0]);
         Timber.Forest var23 = Timber.Forest;
         StringBuilder var28 = new StringBuilder("Client info: ");
         var28.append(this.clients);
         var23.v(var28.toString(), new Object[0]);
         Ref.ObjectRef var24 = new Ref.ObjectRef();
         var28 = new StringBuilder("None of the clients in ");
         var28.append(this);
         var28.append(" could call ");
         var28.append(var5);
         var24.element = new Failure((Throwable)(new UnknownError(var28.toString())));
         Iterable var31 = (Iterable)this.clients;
         Collection var30 = (Collection)(new ArrayList());

         for(Object var34 : var31) {
            if (var34 instanceof CanGetAttributes) {
               var30.add(var34);
            }
         }

         var10 = (Iterable)((List)var30);
         var7 = var10.iterator();
         var8 = this;
         var3 = 0;
         var2 = 0;
         Object var35 = var14;
         if (!var7.hasNext()) {
            this.logApiError(((ApiResult)var24.element).exceptionOrNull());
            return var24.element;
         }

         Object var16 = var7.next();
         var6 = (DeviceClient)var16;
         Function2 var38 = (Function2)var5;
         ((<undefinedtype>)var35).L$0 = this;
         ((<undefinedtype>)var35).L$1 = var5;
         ((<undefinedtype>)var35).L$2 = var24;
         ((<undefinedtype>)var35).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var35).L$4 = var7;
         ((<undefinedtype>)var35).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var35).L$6 = var6;
         ((<undefinedtype>)var35).L$7 = var24;
         ((<undefinedtype>)var35).I$0 = var2;
         ((<undefinedtype>)var35).I$1 = var3;
         ((<undefinedtype>)var35).I$2 = 0;
         ((<undefinedtype>)var35).label = 1;
         var11 = var38.invoke(var6, var35);
         if (var11 == var13) {
            return var13;
         }

         var15 = var24;
         var12 = var24;
         var21 = var35;
      }

      while(true) {
         var12.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var33 = new StringBuilder("client ");
            var33.append(var6);
            var33.append(" gave good result ");
            var33.append(var15.element);
            var33.append(" for call ");
            var33.append(var5);
            var26.v(var33.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var36 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var6);
         var39.append(" gave failed result\n");
         var39.append(var15.element);
         var39.append(" for call \n");
         var39.append(var5);
         var39.append(", \nwith details:");
         var36.w(var39.toString(), new Object[0]);
         Object var37 = var21;
         Ref.ObjectRef var25 = var15;
         if (!var7.hasNext()) {
            var8.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var7.next();
         var6 = (DeviceClient)var17;
         Function2 var40 = (Function2)var5;
         ((<undefinedtype>)var37).L$0 = var8;
         ((<undefinedtype>)var37).L$1 = var5;
         ((<undefinedtype>)var37).L$2 = var25;
         ((<undefinedtype>)var37).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var37).L$4 = var7;
         ((<undefinedtype>)var37).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var37).L$6 = var6;
         ((<undefinedtype>)var37).L$7 = var25;
         ((<undefinedtype>)var37).I$0 = var2;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var11 = var40.invoke(var6, var37);
         if (var11 == var13) {
            return var13;
         }

         var15 = var25;
         var12 = var25;
         var21 = var37;
      }
   }

   public final Object getLatestSensorData(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getLatestSensorData((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Object var7;
      Iterable var8;
      ConnectionManager var9;
      Iterator var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var10 = (Iterator)((<undefinedtype>)var14).L$4;
         var8 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var21 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("Attempting to doApiCall ");
         var26.append(var25);
         var26.append(" on ");
         var26.append(this.clients.size());
         var26.append(" clients");
         var21.d(var26.toString(), new Object[0]);
         Timber.Forest var22 = Timber.Forest;
         var26 = new StringBuilder("Client info: ");
         var26.append(this.clients);
         var22.v(var26.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var26 = new StringBuilder("None of the clients in ");
         var26.append(this);
         var26.append(" could call ");
         var26.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var26.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var31 : var30) {
            if (var31 instanceof CanGetSensorData) {
               var29.add(var31);
            }
         }

         var8 = (Iterable)((List)var29);
         var10 = var8.iterator();
         var9 = this;
         var3 = 0;
         var2 = 0;
         var7 = var14;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var16 = var10.next();
         var6 = (DeviceClient)var16;
         Function2 var34 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = this;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$4 = var10;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var34.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var6);
            var32.append(" gave good result ");
            var32.append(var15.element);
            var32.append(" for call ");
            var32.append(var25);
            var24.v(var32.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var6);
         var23.append(" gave failed result\n");
         var23.append(var15.element);
         var23.append(" for call \n");
         var23.append(var25);
         var23.append(", \nwith details:");
         var35.w(var23.toString(), new Object[0]);
         var20 = var15;
         if (!var10.hasNext()) {
            var9.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var10.next();
         var6 = (DeviceClient)var17;
         Function2 var36 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = var9;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$4 = var10;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var36.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final Object getLinkedUid(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getLinkedUid((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Object var7;
      Iterable var8;
      Iterator var9;
      ConnectionManager var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var9 = (Iterator)((<undefinedtype>)var14).L$4;
         var8 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var21 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("Attempting to doApiCall ");
         var26.append(var25);
         var26.append(" on ");
         var26.append(this.clients.size());
         var26.append(" clients");
         var21.d(var26.toString(), new Object[0]);
         Timber.Forest var22 = Timber.Forest;
         var26 = new StringBuilder("Client info: ");
         var26.append(this.clients);
         var22.v(var26.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var26 = new StringBuilder("None of the clients in ");
         var26.append(this);
         var26.append(" could call ");
         var26.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var26.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var31 : var30) {
            if (var31 instanceof CanLinkWithAware) {
               var29.add(var31);
            }
         }

         var8 = (Iterable)((List)var29);
         var9 = var8.iterator();
         var10 = this;
         var3 = 0;
         var2 = 0;
         var7 = var14;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         var11 = var9.next();
         var6 = (DeviceClient)var11;
         Function2 var16 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = this;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$4 = var9;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var16.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var6);
            var32.append(" gave good result ");
            var32.append(var15.element);
            var32.append(" for call ");
            var32.append(var25);
            var24.v(var32.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var6);
         var23.append(" gave failed result\n");
         var23.append(var15.element);
         var23.append(" for call \n");
         var23.append(var25);
         var23.append(", \nwith details:");
         var35.w(var23.toString(), new Object[0]);
         var20 = var15;
         if (!var9.hasNext()) {
            var10.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var36 = var9.next();
         var6 = (DeviceClient)var36;
         Function2 var17 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = var10;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$4 = var9;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var36);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var17.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final Object getMonthSensorData(long var1, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var3;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var18 = var6;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            long J$0;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getMonthSensorData(0L, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var18).result;
      Object var17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var18).label;
      int var5;
      DeviceClient var7;
      Long var8;
      Iterator var9;
      Object var10;
      Iterable var11;
      ConnectionManager var13;
      Ref.ObjectRef var15;
      KFunction var19;
      Ref.ObjectRef var26;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var4 = ((<undefinedtype>)var18).I$2;
         var5 = ((<undefinedtype>)var18).I$1;
         var4 = ((<undefinedtype>)var18).I$0;
         var1 = ((<undefinedtype>)var18).J$0;
         var15 = (Ref.ObjectRef)((<undefinedtype>)var18).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var18).L$7;
         Object var24 = ((<undefinedtype>)var18).L$6;
         var9 = (Iterator)((<undefinedtype>)var18).L$5;
         var11 = (Iterable)((<undefinedtype>)var18).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var18).L$3;
         var8 = (Long)((<undefinedtype>)var18).L$2;
         KFunction var25 = (KFunction)((<undefinedtype>)var18).L$1;
         var13 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var12);
         var10 = var18;
         var19 = var25;
         var26 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         KFunction var42 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxLong(var1);
         Timber.Forest var32 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Attempting to doApiCall ");
         var27.append(var42);
         var27.append(", with ");
         var27.append(var8);
         var27.append(" on ");
         var27.append(this.clients.size());
         var27.append(" clients");
         var32.d(var27.toString(), new Object[0]);
         Timber.Forest var28 = Timber.Forest;
         StringBuilder var33 = new StringBuilder("Client info: ");
         var33.append(this.clients);
         var28.v(var33.toString(), new Object[0]);
         Ref.ObjectRef var29 = new Ref.ObjectRef();
         var33 = new StringBuilder("None of the clients in ");
         var33.append(this);
         var33.append(" could call ");
         var33.append(var42);
         var29.element = new Failure((Throwable)(new UnknownError(var33.toString())));
         Iterable var37 = (Iterable)this.clients;
         Collection var35 = (Collection)(new ArrayList());

         for(Object var40 : var37) {
            if (var40 instanceof CanGetSensorData) {
               var35.add(var40);
            }
         }

         var11 = (Iterable)((List)var35);
         var9 = var11.iterator();
         var5 = 0;
         var4 = 0;
         Object var47 = var18;
         Ref.ObjectRef var20 = var29;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var29.element).exceptionOrNull());
            return var29.element;
         }

         Object var30 = var9.next();
         var7 = (DeviceClient)var30;
         Function3 var45 = (Function3)var42;
         ((<undefinedtype>)var47).L$0 = this;
         ((<undefinedtype>)var47).L$1 = var42;
         ((<undefinedtype>)var47).L$2 = var8;
         ((<undefinedtype>)var47).L$3 = var20;
         ((<undefinedtype>)var47).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var47).L$5 = var9;
         ((<undefinedtype>)var47).L$6 = SpillingKt.nullOutSpilledVariable(var30);
         ((<undefinedtype>)var47).L$7 = var7;
         ((<undefinedtype>)var47).L$8 = var20;
         ((<undefinedtype>)var47).J$0 = var1;
         ((<undefinedtype>)var47).I$0 = var4;
         ((<undefinedtype>)var47).I$1 = var5;
         ((<undefinedtype>)var47).I$2 = 0;
         ((<undefinedtype>)var47).label = 1;
         Object var16 = var45.invoke(var7, var8, var47);
         if (var16 == var17) {
            return var17;
         }

         var26 = var20;
         var15 = var20;
         var13 = this;
         var19 = var42;
         var10 = var47;
         var12 = var16;
      }

      while(true) {
         var15.element = var12;
         if (((ApiResult)var26.element).isSuccess()) {
            Timber.Forest var36 = Timber.Forest;
            StringBuilder var39 = new StringBuilder("client ");
            var39.append(var7);
            var39.append(" gave good result ");
            var39.append(var26.element);
            var39.append(" for call ");
            var39.append(var19);
            var36.v(var39.toString(), new Object[0]);
            return var26.element;
         }

         Timber.Forest var43 = Timber.Forest;
         StringBuilder var48 = new StringBuilder("client ");
         var48.append(var7);
         var48.append(" gave failed result\n");
         var48.append(var26.element);
         var48.append(" for call \n");
         var48.append(var19);
         var48.append(", \nwith details:");
         var43.w(var48.toString(), new Object[0]);
         Object var49 = var10;
         KFunction var44 = var19;
         ConnectionManager var41 = var13;
         Ref.ObjectRef var21 = var26;
         if (!var9.hasNext()) {
            var13.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var31 = var9.next();
         var7 = (DeviceClient)var31;
         Function3 var46 = (Function3)var44;
         ((<undefinedtype>)var49).L$0 = var41;
         ((<undefinedtype>)var49).L$1 = var44;
         ((<undefinedtype>)var49).L$2 = var8;
         ((<undefinedtype>)var49).L$3 = var21;
         ((<undefinedtype>)var49).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var49).L$5 = var9;
         ((<undefinedtype>)var49).L$6 = SpillingKt.nullOutSpilledVariable(var31);
         ((<undefinedtype>)var49).L$7 = var7;
         ((<undefinedtype>)var49).L$8 = var21;
         ((<undefinedtype>)var49).J$0 = var1;
         ((<undefinedtype>)var49).I$0 = var4;
         ((<undefinedtype>)var49).I$1 = var5;
         ((<undefinedtype>)var49).I$2 = 0;
         ((<undefinedtype>)var49).label = 1;
         Object var50 = var46.invoke(var7, var8, var49);
         if (var50 == var17) {
            return var17;
         }

         var26 = var21;
         var15 = var21;
         var13 = var41;
         var19 = var44;
         var10 = var49;
         var12 = var50;
      }
   }

   public final Object getNewUuid(Continuation var1) {
      label69: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label69;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getNewUuid((Continuation)this);
            }
         };
      }

      label64: {
         Object var10 = ((<undefinedtype>)var14).result;
         Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var2 = ((<undefinedtype>)var14).label;
         int var3;
         KFunction var5;
         DeviceClient var6;
         ConnectionManager var7;
         Iterator var8;
         Iterable var9;
         Ref.ObjectRef var11;
         Ref.ObjectRef var15;
         Object var23;
         if (var2 != 0) {
            if (var2 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2 = ((<undefinedtype>)var14).I$2;
            var3 = ((<undefinedtype>)var14).I$1;
            var2 = ((<undefinedtype>)var14).I$0;
            var11 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
            var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
            var23 = ((<undefinedtype>)var14).L$5;
            var8 = (Iterator)((<undefinedtype>)var14).L$4;
            var9 = (Iterable)((<undefinedtype>)var14).L$3;
            Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
            var5 = (KFunction)((<undefinedtype>)var14).L$1;
            var7 = (ConnectionManager)((<undefinedtype>)var14).L$0;
            ResultKt.throwOnFailure(var10);
            var23 = var14;
            var15 = var12;
         } else {
            ResultKt.throwOnFailure(var10);
            var5 = (KFunction)null.INSTANCE;
            Timber.Forest var30 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
            var24.append(var5);
            var24.append(" on ");
            var24.append(this.clients.size());
            var24.append(" clients");
            var30.d(var24.toString(), new Object[0]);
            var30 = Timber.Forest;
            var24 = new StringBuilder("Client info: ");
            var24.append(this.clients);
            var30.v(var24.toString(), new Object[0]);
            Ref.ObjectRef var26 = new Ref.ObjectRef();
            StringBuilder var32 = new StringBuilder("None of the clients in ");
            var32.append(this);
            var32.append(" could call ");
            var32.append(var5);
            var26.element = new Failure((Throwable)(new UnknownError(var32.toString())));
            Iterable var34 = (Iterable)this.clients;
            Collection var33 = (Collection)(new ArrayList());

            for(Object var37 : var34) {
               if (var37 instanceof CanProvisionLocal) {
                  var33.add(var37);
               }
            }

            var9 = (Iterable)((List)var33);
            var8 = var9.iterator();
            var7 = this;
            var3 = 0;
            var2 = 0;
            var10 = var14;
            if (!var8.hasNext()) {
               this.logApiError(((ApiResult)var26.element).exceptionOrNull());
               var18 = var26.element;
               break label64;
            }

            Object var16 = var8.next();
            var6 = (DeviceClient)var16;
            Function2 var41 = (Function2)var5;
            ((<undefinedtype>)var10).L$0 = this;
            ((<undefinedtype>)var10).L$1 = var5;
            ((<undefinedtype>)var10).L$2 = var26;
            ((<undefinedtype>)var10).L$3 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var10).L$4 = var8;
            ((<undefinedtype>)var10).L$5 = SpillingKt.nullOutSpilledVariable(var16);
            ((<undefinedtype>)var10).L$6 = var6;
            ((<undefinedtype>)var10).L$7 = var26;
            ((<undefinedtype>)var10).I$0 = var2;
            ((<undefinedtype>)var10).I$1 = var3;
            ((<undefinedtype>)var10).I$2 = 0;
            ((<undefinedtype>)var10).label = 1;
            Object var44 = var41.invoke(var6, var10);
            if (var44 == var13) {
               return var13;
            }

            var15 = var26;
            var11 = var26;
            var23 = var10;
            var10 = var44;
         }

         while(true) {
            var11.element = var10;
            if (((ApiResult)var15.element).isSuccess()) {
               Timber.Forest var28 = Timber.Forest;
               StringBuilder var36 = new StringBuilder("client ");
               var36.append(var6);
               var36.append(" gave good result ");
               var36.append(var15.element);
               var36.append(" for call ");
               var36.append(var5);
               var28.v(var36.toString(), new Object[0]);
               var18 = var15.element;
               break;
            }

            Timber.Forest var39 = Timber.Forest;
            StringBuilder var42 = new StringBuilder("client ");
            var42.append(var6);
            var42.append(" gave failed result\n");
            var42.append(var15.element);
            var42.append(" for call \n");
            var42.append(var5);
            var42.append(", \nwith details:");
            var39.w(var42.toString(), new Object[0]);
            Object var40 = var23;
            Ref.ObjectRef var27 = var15;
            if (!var8.hasNext()) {
               var7.logApiError(((ApiResult)var15.element).exceptionOrNull());
               var18 = var15.element;
               break;
            }

            Object var17 = var8.next();
            var6 = (DeviceClient)var17;
            Function2 var43 = (Function2)var5;
            ((<undefinedtype>)var40).L$0 = var7;
            ((<undefinedtype>)var40).L$1 = var5;
            ((<undefinedtype>)var40).L$2 = var27;
            ((<undefinedtype>)var40).L$3 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var40).L$4 = var8;
            ((<undefinedtype>)var40).L$5 = SpillingKt.nullOutSpilledVariable(var17);
            ((<undefinedtype>)var40).L$6 = var6;
            ((<undefinedtype>)var40).L$7 = var27;
            ((<undefinedtype>)var40).I$0 = var2;
            ((<undefinedtype>)var40).I$1 = var3;
            ((<undefinedtype>)var40).I$2 = 0;
            ((<undefinedtype>)var40).label = 1;
            Object var45 = var43.invoke(var6, var40);
            if (var45 == var13) {
               return var13;
            }

            var15 = var27;
            var11 = var27;
            var23 = var40;
            var10 = var45;
         }
      }

      ApiResult var19 = (ApiResult)var18;
      DeviceUuid var29 = (DeviceUuid)var19.getOrNull();
      if (var29 != null) {
         this.updateDevice(new DeviceG4(var29.getUuid(), "", 0, (Integer)null, 0, (String)null, (String)null, (DeviceUuid)null, false, (IndoorDatapoint)null, 0, false, 0, 0L, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (double[])null, (double[])null, (double[])null, (double[])null, (double[])null, 0, false, false, false, (Boolean)null, (String)null, false, (String)null, 0, (String)null, (WelcomeHomeLocation)null, (Boolean)null, (Integer)null, (Long)null, -4, 3711, (DefaultConstructorMarker)null));
      }

      return var19;
   }

   public final Object getOnboardingEvents(int var1, OnboardingError var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var3;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var25 = var6;
               break label43;
            }
         }

         var25 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getOnboardingEvents(0, (OnboardingError)null, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var25).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var25).label;
      int var5;
      Iterable var7;
      Object var8;
      OnboardingError var9;
      Iterator var10;
      OnboardingEventsBody var11;
      Ref.ObjectRef var20;
      ConnectionManager var26;
      KFunction var43;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var25).I$3;
         var5 = ((<undefinedtype>)var25).I$2;
         var4 = ((<undefinedtype>)var25).I$1;
         var1 = ((<undefinedtype>)var25).I$0;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var25).L$9;
         DeviceClient var12 = (DeviceClient)((<undefinedtype>)var25).L$8;
         Object var18 = ((<undefinedtype>)var25).L$7;
         var10 = (Iterator)((<undefinedtype>)var25).L$6;
         var7 = (Iterable)((<undefinedtype>)var25).L$5;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var25).L$4;
         var11 = (OnboardingEventsBody)((<undefinedtype>)var25).L$3;
         KFunction var29 = (KFunction)((<undefinedtype>)var25).L$2;
         ConnectionManager var19 = (ConnectionManager)((<undefinedtype>)var25).L$1;
         var9 = (OnboardingError)((<undefinedtype>)var25).L$0;
         ResultKt.throwOnFailure(var13);
         var8 = var25;
         var14.element = var13;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("client ");
            var21.append(var12);
            var21.append(" gave good result ");
            var21.append(var15.element);
            var21.append(" for call ");
            var21.append(var29);
            var33.v(var21.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var49 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var12);
         var45.append(" gave failed result\n");
         var45.append(var15.element);
         var45.append(" for call \n");
         var45.append(var29);
         var45.append(", \nwith details:");
         var49.w(var45.toString(), new Object[0]);
         ConnectionManager var42 = var19;
         var20 = var15;
         var26 = var42;
         var43 = var29;
      } else {
         ResultKt.throwOnFailure(var13);
         var43 = (KFunction)null.INSTANCE;
         OnboardingError var30 = var2;
         var11 = new OnboardingEventsBody(var1, var2);
         Timber.Forest var34 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("Attempting to doApiCall ");
         var22.append(var43);
         var22.append(", with ");
         var22.append(var11);
         var22.append(" on ");
         var22.append(this.clients.size());
         var22.append(" clients");
         var34.d(var22.toString(), new Object[0]);
         Timber.Forest var23 = Timber.Forest;
         StringBuilder var35 = new StringBuilder("Client info: ");
         var35.append(this.clients);
         var23.v(var35.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var35 = new StringBuilder("None of the clients in ");
         var35.append(this);
         var35.append(" could call ");
         var35.append(var43);
         var20.element = new Failure((Throwable)(new UnknownError(var35.toString())));
         Iterable var39 = (Iterable)this.clients;
         Collection var37 = (Collection)(new ArrayList());

         for(Object var41 : var39) {
            if (var41 instanceof CanProvisionLocal) {
               var37.add(var41);
            }
         }

         var7 = (Iterable)((List)var37);
         var10 = var7.iterator();
         var5 = 0;
         var4 = 0;
         var9 = var30;
         var8 = var25;
         var26 = this;
      }

      while(var10.hasNext()) {
         Object var31 = var10.next();
         DeviceClient var50 = (DeviceClient)var31;
         Function3 var46 = (Function3)var43;
         ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var8).L$1 = var26;
         ((<undefinedtype>)var8).L$2 = var43;
         ((<undefinedtype>)var8).L$3 = var11;
         ((<undefinedtype>)var8).L$4 = var20;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var8).L$6 = var10;
         ((<undefinedtype>)var8).L$7 = SpillingKt.nullOutSpilledVariable(var31);
         ((<undefinedtype>)var8).L$8 = var50;
         ((<undefinedtype>)var8).L$9 = var20;
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).I$1 = var4;
         ((<undefinedtype>)var8).I$2 = var5;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).label = 1;
         Object var47 = var46.invoke(var50, var11, var8);
         if (var47 == var16) {
            return var16;
         }

         ConnectionManager var52 = var26;
         Ref.ObjectRef var27 = var20;
         KFunction var32 = var43;
         DeviceClient var44 = var50;
         var20.element = var47;
         if (((ApiResult)var20.element).isSuccess()) {
            Timber.Forest var38 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var50);
            var24.append(" gave good result ");
            var24.append(var27.element);
            var24.append(" for call ");
            var24.append(var32);
            var38.v(var24.toString(), new Object[0]);
            return var27.element;
         }

         Timber.Forest var51 = Timber.Forest;
         StringBuilder var48 = new StringBuilder("client ");
         var48.append(var44);
         var48.append(" gave failed result\n");
         var48.append(var20.element);
         var48.append(" for call \n");
         var48.append(var32);
         var48.append(", \nwith details:");
         var51.w(var48.toString(), new Object[0]);
         var20 = var20;
         var26 = var52;
         var43 = var32;
      }

      var26.logApiError(((ApiResult)var20.element).exceptionOrNull());
      return var20.element;
   }

   public final Object getRand(Continuation var1) {
      label69: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var1;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var15 = var5;
               break label69;
            }
         }

         var15 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getRand((Continuation)this);
            }
         };
      }

      label64: {
         Object var13 = ((<undefinedtype>)var15).result;
         Object var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var2 = ((<undefinedtype>)var15).label;
         int var3;
         KFunction var6;
         DeviceClient var7;
         ConnectionManager var8;
         Iterable var9;
         Iterator var11;
         Ref.ObjectRef var12;
         Ref.ObjectRef var16;
         Object var25;
         if (var2 != 0) {
            if (var2 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2 = ((<undefinedtype>)var15).I$2;
            var2 = ((<undefinedtype>)var15).I$1;
            var3 = ((<undefinedtype>)var15).I$0;
            var12 = (Ref.ObjectRef)((<undefinedtype>)var15).L$7;
            var7 = (DeviceClient)((<undefinedtype>)var15).L$6;
            var25 = ((<undefinedtype>)var15).L$5;
            var11 = (Iterator)((<undefinedtype>)var15).L$4;
            var9 = (Iterable)((<undefinedtype>)var15).L$3;
            Ref.ObjectRef var10 = (Ref.ObjectRef)((<undefinedtype>)var15).L$2;
            var6 = (KFunction)((<undefinedtype>)var15).L$1;
            var8 = (ConnectionManager)((<undefinedtype>)var15).L$0;
            ResultKt.throwOnFailure(var13);
            var25 = var15;
            var16 = var10;
         } else {
            ResultKt.throwOnFailure(var13);
            var6 = (KFunction)null.INSTANCE;
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("Attempting to doApiCall ");
            var32.append(var6);
            var32.append(" on ");
            var32.append(this.clients.size());
            var32.append(" clients");
            var26.d(var32.toString(), new Object[0]);
            var26 = Timber.Forest;
            var32 = new StringBuilder("Client info: ");
            var32.append(this.clients);
            var26.v(var32.toString(), new Object[0]);
            Ref.ObjectRef var28 = new Ref.ObjectRef();
            var32 = new StringBuilder("None of the clients in ");
            var32.append(this);
            var32.append(" could call ");
            var32.append(var6);
            var28.element = new Failure((Throwable)(new UnknownError(var32.toString())));
            Iterable var36 = (Iterable)this.clients;
            Collection var35 = (Collection)(new ArrayList());

            for(Object var39 : var36) {
               if (var39 instanceof CanProvisionCloud) {
                  var35.add(var39);
               }
            }

            var9 = (Iterable)((List)var35);
            var11 = var9.iterator();
            var8 = this;
            byte var4 = 0;
            var2 = 0;
            Object var40 = var15;
            if (!var11.hasNext()) {
               this.logApiError(((ApiResult)var28.element).exceptionOrNull());
               var19 = var28.element;
               break label64;
            }

            Object var43 = var11.next();
            var7 = (DeviceClient)var43;
            Function2 var17 = (Function2)var6;
            ((<undefinedtype>)var40).L$0 = this;
            ((<undefinedtype>)var40).L$1 = var6;
            ((<undefinedtype>)var40).L$2 = var28;
            ((<undefinedtype>)var40).L$3 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var40).L$4 = var11;
            ((<undefinedtype>)var40).L$5 = SpillingKt.nullOutSpilledVariable(var43);
            ((<undefinedtype>)var40).L$6 = var7;
            ((<undefinedtype>)var40).L$7 = var28;
            ((<undefinedtype>)var40).I$0 = var2;
            ((<undefinedtype>)var40).I$1 = var4;
            ((<undefinedtype>)var40).I$2 = 0;
            ((<undefinedtype>)var40).label = 1;
            var13 = var17.invoke(var7, var40);
            if (var13 == var14) {
               return var14;
            }

            var16 = var28;
            var12 = var28;
            var3 = var2;
            var2 = var4;
            var25 = var40;
         }

         while(true) {
            var12.element = var13;
            if (((ApiResult)var16.element).isSuccess()) {
               Timber.Forest var38 = Timber.Forest;
               StringBuilder var30 = new StringBuilder("client ");
               var30.append(var7);
               var30.append(" gave good result ");
               var30.append(var16.element);
               var30.append(" for call ");
               var30.append(var6);
               var38.v(var30.toString(), new Object[0]);
               var19 = var16.element;
               break;
            }

            Timber.Forest var44 = Timber.Forest;
            StringBuilder var41 = new StringBuilder("client ");
            var41.append(var7);
            var41.append(" gave failed result\n");
            var41.append(var16.element);
            var41.append(" for call \n");
            var41.append(var6);
            var41.append(", \nwith details:");
            var44.w(var41.toString(), new Object[0]);
            Object var42 = var25;
            Ref.ObjectRef var29 = var16;
            if (!var11.hasNext()) {
               var8.logApiError(((ApiResult)var16.element).exceptionOrNull());
               var19 = var16.element;
               break;
            }

            Object var45 = var11.next();
            var7 = (DeviceClient)var45;
            Function2 var18 = (Function2)var6;
            ((<undefinedtype>)var42).L$0 = var8;
            ((<undefinedtype>)var42).L$1 = var6;
            ((<undefinedtype>)var42).L$2 = var29;
            ((<undefinedtype>)var42).L$3 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var42).L$4 = var11;
            ((<undefinedtype>)var42).L$5 = SpillingKt.nullOutSpilledVariable(var45);
            ((<undefinedtype>)var42).L$6 = var7;
            ((<undefinedtype>)var42).L$7 = var29;
            ((<undefinedtype>)var42).I$0 = var3;
            ((<undefinedtype>)var42).I$1 = var2;
            ((<undefinedtype>)var42).I$2 = 0;
            ((<undefinedtype>)var42).label = 1;
            var13 = var18.invoke(var7, var42);
            if (var13 == var14) {
               return var14;
            }

            var16 = var29;
            var12 = var29;
            var3 = var3;
            var2 = var2;
            var25 = var42;
         }
      }

      ApiResult var31 = (ApiResult)var19;
      RandomVerifyText var20 = (RandomVerifyText)var31.getOrNull();
      return var20 == null ? ApiResult.Companion.fromResult(var31, (Object)null) : ApiResult.Companion.fromResult(var31, new Pair(var20.getRand(), var20.getText()));
   }

   public final Object getSchedules(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getSchedules((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      KFunction var5;
      DeviceClient var6;
      Iterable var7;
      ConnectionManager var8;
      Iterator var10;
      Ref.ObjectRef var12;
      Ref.ObjectRef var15;
      Object var21;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         var21 = ((<undefinedtype>)var14).L$5;
         var10 = (Iterator)((<undefinedtype>)var14).L$4;
         var7 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var9 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var5 = (KFunction)((<undefinedtype>)var14).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var21 = var14;
         var15 = var9;
      } else {
         ResultKt.throwOnFailure(var11);
         var5 = (KFunction)null.INSTANCE;
         Timber.Forest var27 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("Attempting to doApiCall ");
         var22.append(var5);
         var22.append(" on ");
         var22.append(this.clients.size());
         var22.append(" clients");
         var27.d(var22.toString(), new Object[0]);
         var27 = Timber.Forest;
         var22 = new StringBuilder("Client info: ");
         var22.append(this.clients);
         var27.v(var22.toString(), new Object[0]);
         Ref.ObjectRef var24 = new Ref.ObjectRef();
         StringBuilder var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var5);
         var24.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         var7 = (Iterable)this.clients;
         Collection var30 = (Collection)(new ArrayList());

         for(Object var32 : var7) {
            if (var32 instanceof CanManageSchedule) {
               var30.add(var32);
            }
         }

         var7 = (Iterable)((List)var30);
         var10 = var7.iterator();
         var8 = this;
         var3 = 0;
         var2 = 0;
         Object var35 = var14;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var24.element).exceptionOrNull());
            return var24.element;
         }

         Object var16 = var10.next();
         var6 = (DeviceClient)var16;
         Function2 var38 = (Function2)var5;
         ((<undefinedtype>)var35).L$0 = this;
         ((<undefinedtype>)var35).L$1 = var5;
         ((<undefinedtype>)var35).L$2 = var24;
         ((<undefinedtype>)var35).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var35).L$4 = var10;
         ((<undefinedtype>)var35).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var35).L$6 = var6;
         ((<undefinedtype>)var35).L$7 = var24;
         ((<undefinedtype>)var35).I$0 = var2;
         ((<undefinedtype>)var35).I$1 = var3;
         ((<undefinedtype>)var35).I$2 = 0;
         ((<undefinedtype>)var35).label = 1;
         var11 = var38.invoke(var6, var35);
         if (var11 == var13) {
            return var13;
         }

         var15 = var24;
         var12 = var24;
         var21 = var35;
      }

      while(true) {
         var12.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var33 = new StringBuilder("client ");
            var33.append(var6);
            var33.append(" gave good result ");
            var33.append(var15.element);
            var33.append(" for call ");
            var33.append(var5);
            var26.v(var33.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var36 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var6);
         var39.append(" gave failed result\n");
         var39.append(var15.element);
         var39.append(" for call \n");
         var39.append(var5);
         var39.append(", \nwith details:");
         var36.w(var39.toString(), new Object[0]);
         Object var37 = var21;
         Ref.ObjectRef var25 = var15;
         if (!var10.hasNext()) {
            var8.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var10.next();
         var6 = (DeviceClient)var17;
         Function2 var40 = (Function2)var5;
         ((<undefinedtype>)var37).L$0 = var8;
         ((<undefinedtype>)var37).L$1 = var5;
         ((<undefinedtype>)var37).L$2 = var25;
         ((<undefinedtype>)var37).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var37).L$4 = var10;
         ((<undefinedtype>)var37).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var37).L$6 = var6;
         ((<undefinedtype>)var37).L$7 = var25;
         ((<undefinedtype>)var37).I$0 = var2;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var11 = var40.invoke(var6, var37);
         if (var11 == var13) {
            return var13;
         }

         var15 = var25;
         var12 = var25;
         var21 = var37;
      }
   }

   public final Object getSsids(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getSsids((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Object var7;
      Iterator var8;
      Iterable var9;
      ConnectionManager var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var8 = (Iterator)((<undefinedtype>)var14).L$4;
         var9 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("Attempting to doApiCall ");
         var21.append(var25);
         var21.append(" on ");
         var21.append(this.clients.size());
         var21.append(" clients");
         var26.d(var21.toString(), new Object[0]);
         var26 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("Client info: ");
         var22.append(this.clients);
         var26.v(var22.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         StringBuilder var28 = new StringBuilder("None of the clients in ");
         var28.append(this);
         var28.append(" could call ");
         var28.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var28.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var31 : var30) {
            if (var31 instanceof CanProvisionLocal) {
               var29.add(var31);
            }
         }

         var9 = (Iterable)((List)var29);
         var8 = var9.iterator();
         var10 = this;
         var3 = 0;
         var2 = 0;
         var7 = var14;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var16 = var8.next();
         var6 = (DeviceClient)var16;
         Function2 var34 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = this;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var7).L$4 = var8;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var34.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var6);
            var32.append(" gave good result ");
            var32.append(var15.element);
            var32.append(" for call ");
            var32.append(var25);
            var24.v(var32.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var6);
         var23.append(" gave failed result\n");
         var23.append(var15.element);
         var23.append(" for call \n");
         var23.append(var25);
         var23.append(", \nwith details:");
         var35.w(var23.toString(), new Object[0]);
         var20 = var15;
         if (!var8.hasNext()) {
            var10.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var8.next();
         var6 = (DeviceClient)var17;
         Function2 var36 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = var10;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var7).L$4 = var8;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var2;
         ((<undefinedtype>)var7).I$1 = var3;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var36.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final String getUid() {
      return this.device.getUid();
   }

   public final void logApiError(Throwable var1) {
      if (var1 != null) {
         if (var1 instanceof PurposeFullyLeftEmptyException) {
            Timber.Forest.v(var1);
         } else if (var1 instanceof NotImplementedError) {
            Timber.Forest.w(var1);
         } else {
            Timber.Forest.e(var1);
         }
      }
   }

   public final Object playAlarm(int var1, int var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var20 = var7;
               break label43;
            }
         }

         var20 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            int I$5;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.playAlarm(0, 0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var20).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var20).label;
      int var6;
      Object var9;
      ConnectionManager var10;
      Iterable var11;
      Ref.ObjectRef var23;
      Iterator var46;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var20).I$5;
         var1 = ((<undefinedtype>)var20).I$4;
         var2 = ((<undefinedtype>)var20).I$3;
         int var5 = ((<undefinedtype>)var20).I$2;
         var4 = ((<undefinedtype>)var20).I$1;
         var1 = ((<undefinedtype>)var20).I$0;
         Ref.ObjectRef var8 = (Ref.ObjectRef)((<undefinedtype>)var20).L$7;
         CanSetAlarm var31 = (CanSetAlarm)((<undefinedtype>)var20).L$6;
         DeviceClient var12 = (DeviceClient)((<undefinedtype>)var20).L$5;
         var31 = (CanSetAlarm)((<undefinedtype>)var20).L$4;
         Iterator var14 = (Iterator)((<undefinedtype>)var20).L$3;
         var11 = (Iterable)((<undefinedtype>)var20).L$2;
         Ref.ObjectRef var33 = (Ref.ObjectRef)((<undefinedtype>)var20).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var20).L$0;
         ResultKt.throwOnFailure(var13);
         var9 = var20;
         var23 = var8;
         DeviceClient var37 = var12;
         var46 = var14;
         var23.element = (ApiResult)var13;
         if (((ApiResult)var33.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var41 = new StringBuilder("client ");
            var41.append(var37);
            var41.append(" gave good result ");
            var41.append(var33.element);
            var41.append(" for call");
            var24.v(var41.toString(), new Object[0]);
            return var33.element;
         }

         Timber.Forest var47 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("client ");
         var22.append(var37);
         var22.append(" gave failed result\n");
         var22.append(var33.element);
         var22.append(" for call, \nwith details:");
         var47.w(var22.toString(), new Object[0]);
         var23 = var33;
         var6 = var4;
         var4 = var2;
         var2 = var5;
      } else {
         ResultKt.throwOnFailure(var13);
         Ref.ObjectRef var34 = new Ref.ObjectRef();
         StringBuilder var38 = new StringBuilder("None of the clients in ");
         var38.append(this);
         var38.append(" is ");
         var38.append(Reflection.getOrCreateKotlinClass(CanSetAlarm.class).getQualifiedName());
         var34.element = new Failure((Throwable)(new UnknownError(var38.toString())));
         Iterable var42 = (Iterable)this.clients;
         Collection var39 = (Collection)(new ArrayList());

         for(Object var45 : var42) {
            if (var45 instanceof CanSetAlarm) {
               var39.add(var45);
            }
         }

         var11 = (Iterable)((List)var39);
         var46 = var11.iterator();
         var10 = this;
         var4 = 0;
         var9 = var20;
         byte var30 = 0;
         var6 = var2;
         var23 = var34;
         var2 = var4;
         var4 = var30;
      }

      while(var46.hasNext()) {
         var13 = var46.next();
         DeviceClient var40 = (DeviceClient)var13;
         CanSetAlarm var35 = (CanSetAlarm)var40;
         ((<undefinedtype>)var9).L$0 = var10;
         ((<undefinedtype>)var9).L$1 = var23;
         ((<undefinedtype>)var9).L$2 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var9).L$3 = var46;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var9).L$5 = var40;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var35);
         ((<undefinedtype>)var9).L$7 = var23;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var6;
         ((<undefinedtype>)var9).I$2 = var2;
         ((<undefinedtype>)var9).I$3 = var4;
         ((<undefinedtype>)var9).I$4 = 0;
         ((<undefinedtype>)var9).I$5 = 0;
         ((<undefinedtype>)var9).label = 1;
         var13 = var35.playAlarm(var1, var6, (Continuation)var9);
         if (var13 == var15) {
            return var15;
         }

         Ref.ObjectRef var36 = var23;
         var23.element = (ApiResult)var13;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var44 = new StringBuilder("client ");
            var44.append(var40);
            var44.append(" gave good result ");
            var44.append(var36.element);
            var44.append(" for call");
            var26.v(var44.toString(), new Object[0]);
            return var36.element;
         }

         Timber.Forest var50 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("client ");
         var25.append(var40);
         var25.append(" gave failed result\n");
         var25.append(var36.element);
         var25.append(" for call, \nwith details:");
         var50.w(var25.toString(), new Object[0]);
         var23 = var36;
         var6 = var6;
         var4 = var4;
         var2 = var2;
      }

      var10.logApiError(((ApiResult)var23.element).exceptionOrNull());
      return var23.element;
   }

   public final Object provisionDevice(String var1, String var2, String var3, String var4, String var5, Continuation var6) {
      label44: {
         if (var6 instanceof <undefinedtype>) {
            <undefinedtype> var10 = (<undefinedtype>)var6;
            if ((var10.label & Integer.MIN_VALUE) != 0) {
               var10.label += Integer.MIN_VALUE;
               var42 = var10;
               break label44;
            }
         }

         var42 = new ContinuationImpl(this, var6) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$10;
            Object L$11;
            Object L$12;
            Object L$13;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.provisionDevice((String)null, (String)null, (String)null, (String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var16 = ((<undefinedtype>)var42).result;
      Object var22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var7 = ((<undefinedtype>)var42).label;
      Ref.ObjectRef var25;
      Object var40;
      String var44;
      int var50;
      Iterable var52;
      Iterator var59;
      ConnectionManager var67;
      KFunction var71;
      ProvisionBody var74;
      String var78;
      if (var7 != 0) {
         if (var7 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var7 = ((<undefinedtype>)var42).I$2;
         var50 = ((<undefinedtype>)var42).I$1;
         var7 = ((<undefinedtype>)var42).I$0;
         Ref.ObjectRef var36 = (Ref.ObjectRef)((<undefinedtype>)var42).L$13;
         DeviceClient var19 = (DeviceClient)((<undefinedtype>)var42).L$12;
         Object var23 = ((<undefinedtype>)var42).L$11;
         Iterator var14 = (Iterator)((<undefinedtype>)var42).L$10;
         Iterable var29 = (Iterable)((<undefinedtype>)var42).L$9;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var42).L$8;
         ProvisionBody var13 = (ProvisionBody)((<undefinedtype>)var42).L$7;
         KFunction var51 = (KFunction)((<undefinedtype>)var42).L$6;
         ConnectionManager var24 = (ConnectionManager)((<undefinedtype>)var42).L$5;
         String var38 = (String)((<undefinedtype>)var42).L$4;
         String var17 = (String)((<undefinedtype>)var42).L$3;
         String var18 = (String)((<undefinedtype>)var42).L$2;
         String var11 = (String)((<undefinedtype>)var42).L$1;
         var78 = (String)((<undefinedtype>)var42).L$0;
         ResultKt.throwOnFailure(var16);
         Ref.ObjectRef var20 = var36;
         var4 = var38;
         var38 = var17;
         var20.element = var16;
         if (((ApiResult)var12.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var31 = new StringBuilder("client ");
            var31.append(var19);
            var31.append(" gave good result ");
            var31.append(var12.element);
            var31.append(" for call ");
            var31.append(var51);
            var26.v(var31.toString(), new Object[0]);
            return var12.element;
         }

         Timber.Forest var86 = Timber.Forest;
         String var82 = var78;
         StringBuilder var77 = new StringBuilder("client ");
         var77.append(var19);
         var77.append(" gave failed result\n");
         var77.append(var12.element);
         var77.append(" for call \n");
         var77.append(var51);
         var77.append(", \nwith details:");
         var86.w(var77.toString(), new Object[0]);
         Ref.ObjectRef var87 = var12;
         KFunction var66 = var51;
         var78 = var11;
         Object var58 = var42;
         int var9 = var7;
         var52 = var29;
         ConnectionManager var43 = var24;
         var2 = var18;
         var3 = var38;
         var40 = var58;
         var7 = var50;
         var50 = var9;
         var25 = var87;
         var59 = var14;
         var74 = var13;
         var71 = var66;
         var67 = var43;
         var44 = var82;
      } else {
         ResultKt.throwOnFailure(var16);
         var71 = (KFunction)null.INSTANCE;
         var74 = new ProvisionBody(var1, var2, var3, var4, var5);
         Timber.Forest var60 = Timber.Forest;
         StringBuilder var53 = new StringBuilder("Attempting to doApiCall ");
         var53.append(var71);
         var53.append(", with ");
         var53.append(var74);
         var53.append(" on ");
         var53.append(this.clients.size());
         var53.append(" clients");
         var60.d(var53.toString(), new Object[0]);
         Timber.Forest var54 = Timber.Forest;
         StringBuilder var61 = new StringBuilder("Client info: ");
         var61.append(this.clients);
         var54.v(var61.toString(), new Object[0]);
         Ref.ObjectRef var83 = new Ref.ObjectRef();
         StringBuilder var55 = new StringBuilder("None of the clients in ");
         var55.append(this);
         var55.append(" could call ");
         var55.append(var71);
         var83.element = new Failure((Throwable)(new UnknownError(var55.toString())));
         Iterable var62 = (Iterable)this.clients;
         Collection var56 = (Collection)(new ArrayList());

         for(Object var63 : var62) {
            if (var63 instanceof CanProvisionLocal) {
               var56.add(var63);
            }
         }

         var52 = (Iterable)((List)var56);
         var59 = var52.iterator();
         var67 = this;
         var7 = 0;
         var50 = 0;
         var78 = var3;
         var3 = var4;
         var4 = var5;
         var40 = var42;
         String var88 = var2;
         var44 = var1;
         var25 = var83;
         var2 = var78;
         var78 = var88;
      }

      while(var59.hasNext()) {
         Object var93 = var59.next();
         DeviceClient var96 = (DeviceClient)var93;
         Function3 var89 = (Function3)var71;
         String var84 = var78;
         ((<undefinedtype>)var40).L$0 = SpillingKt.nullOutSpilledVariable(var44);
         ((<undefinedtype>)var40).L$1 = SpillingKt.nullOutSpilledVariable(var78);
         ((<undefinedtype>)var40).L$2 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var40).L$3 = SpillingKt.nullOutSpilledVariable(var3);
         ((<undefinedtype>)var40).L$4 = SpillingKt.nullOutSpilledVariable(var4);
         ((<undefinedtype>)var40).L$5 = var67;
         ((<undefinedtype>)var40).L$6 = var71;
         ((<undefinedtype>)var40).L$7 = var74;
         ((<undefinedtype>)var40).L$8 = var25;
         ((<undefinedtype>)var40).L$9 = SpillingKt.nullOutSpilledVariable(var52);
         ((<undefinedtype>)var40).L$10 = var59;
         ((<undefinedtype>)var40).L$11 = SpillingKt.nullOutSpilledVariable(var93);
         ((<undefinedtype>)var40).L$12 = var96;
         ((<undefinedtype>)var40).L$13 = var25;
         ((<undefinedtype>)var40).I$0 = var50;
         ((<undefinedtype>)var40).I$1 = var7;
         ((<undefinedtype>)var40).I$2 = 0;
         ((<undefinedtype>)var40).label = 1;
         Object var21 = var89.invoke(var96, var74, var40);
         if (var21 == var22) {
            return var22;
         }

         ProvisionBody var90 = var74;
         KFunction var75 = var71;
         ConnectionManager var94 = var67;
         Ref.ObjectRef var69 = var25;
         Iterable var72 = var52;
         Object var97 = var40;
         var78 = var44;
         KFunction var57 = var75;
         var44 = var2;
         String var41 = var3;
         Object var35 = var97;
         Ref.ObjectRef var98 = var25;
         Iterator var76 = var59;
         Iterable var32 = var72;
         ProvisionBody var73 = var90;
         ConnectionManager var27 = var94;
         String var64 = var84;
         var98.element = var21;
         if (((ApiResult)var69.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var33 = new StringBuilder("client ");
            var33.append(var96);
            var33.append(" gave good result ");
            var33.append(var69.element);
            var33.append(" for call ");
            var33.append(var57);
            var28.v(var33.toString(), new Object[0]);
            return var69.element;
         }

         Timber.Forest var91 = Timber.Forest;
         var84 = var78;
         StringBuilder var81 = new StringBuilder("client ");
         var81.append(var96);
         var81.append(" gave failed result\n");
         var81.append(var69.element);
         var81.append(" for call \n");
         var81.append(var57);
         var81.append(", \nwith details:");
         var91.w(var81.toString(), new Object[0]);
         Ref.ObjectRef var92 = var69;
         KFunction var70 = var57;
         var78 = var64;
         String var95 = var44;
         Object var65 = var35;
         var52 = var32;
         ConnectionManager var46 = var27;
         var2 = var95;
         var3 = var41;
         var40 = var65;
         var7 = var7;
         var50 = var50;
         var25 = var92;
         var59 = var76;
         var74 = var73;
         var71 = var70;
         var67 = var46;
         var44 = var84;
      }

      var67.logApiError(((ApiResult)var25.element).exceptionOrNull());
      return var25.element;
   }

   public final Object resetAutoModeDependency(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.resetAutoModeDependency((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Object var7;
      Iterator var8;
      ConnectionManager var9;
      Iterable var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var2 = ((<undefinedtype>)var14).I$1;
         var3 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var8 = (Iterator)((<undefinedtype>)var14).L$4;
         var10 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("Attempting to doApiCall ");
         var21.append(var25);
         var21.append(" on ");
         var21.append(this.clients.size());
         var21.append(" clients");
         var26.d(var21.toString(), new Object[0]);
         var26 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("Client info: ");
         var22.append(this.clients);
         var26.v(var22.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         StringBuilder var28 = new StringBuilder("None of the clients in ");
         var28.append(this);
         var28.append(" could call ");
         var28.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var28.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var31 : var30) {
            if (var31 instanceof CanSetAutoModeDependency) {
               var29.add(var31);
            }
         }

         var10 = (Iterable)((List)var29);
         var8 = var10.iterator();
         var9 = this;
         var2 = 0;
         var3 = 0;
         var7 = var14;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var16 = var8.next();
         var6 = (DeviceClient)var16;
         Function2 var34 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = this;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var7).L$4 = var8;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var2;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var34.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var6);
            var32.append(" gave good result ");
            var32.append(var15.element);
            var32.append(" for call ");
            var32.append(var25);
            var24.v(var32.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var23 = Timber.Forest;
         StringBuilder var35 = new StringBuilder("client ");
         var35.append(var6);
         var35.append(" gave failed result\n");
         var35.append(var15.element);
         var35.append(" for call \n");
         var35.append(var25);
         var35.append(", \nwith details:");
         var23.w(var35.toString(), new Object[0]);
         var20 = var15;
         if (!var8.hasNext()) {
            var9.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var8.next();
         var6 = (DeviceClient)var17;
         Function2 var36 = (Function2)var25;
         ((<undefinedtype>)var7).L$0 = var9;
         ((<undefinedtype>)var7).L$1 = var25;
         ((<undefinedtype>)var7).L$2 = var20;
         ((<undefinedtype>)var7).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var7).L$4 = var8;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var7).L$6 = var6;
         ((<undefinedtype>)var7).L$7 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var2;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var11 = var36.invoke(var6, var7);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final Object resetDevice(DeviceUuid var1, Continuation var2) {
      DeviceUuid var5;
      label47: {
         var5 = var1;
         if (var2 instanceof <undefinedtype>) {
            var17 = (<undefinedtype>)var2;
            if ((((<undefinedtype>)var17).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var17).label += Integer.MIN_VALUE;
               break label47;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.resetDevice((DeviceUuid)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var17).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var8;
      DeviceUuid var9;
      Object var10;
      ConnectionManager var11;
      Ref.ObjectRef var22;
      Iterator var35;
      Iterable var40;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var3 = ((<undefinedtype>)var17).I$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$9;
         DeviceClient var7 = (DeviceClient)((<undefinedtype>)var17).L$8;
         Object var20 = ((<undefinedtype>)var17).L$7;
         Iterator var30 = (Iterator)((<undefinedtype>)var17).L$6;
         Iterable var21 = (Iterable)((<undefinedtype>)var17).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$4;
         var9 = (DeviceUuid)((<undefinedtype>)var17).L$3;
         var8 = (KFunction)((<undefinedtype>)var17).L$2;
         var11 = (ConnectionManager)((<undefinedtype>)var17).L$1;
         DeviceUuid var6 = (DeviceUuid)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var12);
         var10 = var17;
         var13.element = var12;
         if (((ApiResult)var14.element).isSuccess()) {
            Timber.Forest var23 = Timber.Forest;
            StringBuilder var31 = new StringBuilder("client ");
            var31.append(var7);
            var31.append(" gave good result ");
            var31.append(var14.element);
            var31.append(" for call ");
            var31.append(var8);
            var23.v(var31.toString(), new Object[0]);
            return var14.element;
         }

         Timber.Forest var49 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var7);
         var45.append(" gave failed result\n");
         var45.append(var14.element);
         var45.append(" for call \n");
         var45.append(var8);
         var45.append(", \nwith details:");
         var49.w(var45.toString(), new Object[0]);
         var40 = var21;
         var1 = var6;
         var22 = var14;
         var35 = var30;
      } else {
         ResultKt.throwOnFailure(var12);
         if (var5 == null) {
            return ApiResult.Companion.fail((Throwable)(new IllegalArgumentException("deviceUuid should be filled in")));
         }

         var8 = (KFunction)null.INSTANCE;
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var36 = new StringBuilder("Attempting to doApiCall ");
         var36.append(var8);
         var36.append(", with ");
         var36.append(var5);
         var36.append(" on ");
         var36.append(this.clients.size());
         var36.append(" clients");
         var24.d(var36.toString(), new Object[0]);
         Timber.Forest var25 = Timber.Forest;
         var36 = new StringBuilder("Client info: ");
         var36.append(this.clients);
         var25.v(var36.toString(), new Object[0]);
         var22 = new Ref.ObjectRef();
         var36 = new StringBuilder("None of the clients in ");
         var36.append(this);
         var36.append(" could call ");
         var36.append(var8);
         var22.element = new Failure((Throwable)(new UnknownError(var36.toString())));
         var40 = (Iterable)this.clients;
         Collection var39 = (Collection)(new ArrayList());

         for(Object var44 : var40) {
            if (var44 instanceof CanProvisionLocal) {
               var39.add(var44);
            }
         }

         var40 = (Iterable)((List)var39);
         var35 = var40.iterator();
         var11 = this;
         var3 = 0;
         var4 = 0;
         var10 = var17;
         var1 = var5;
         var9 = var5;
      }

      while(var35.hasNext()) {
         Object var50 = var35.next();
         DeviceClient var32 = (DeviceClient)var50;
         Function3 var46 = (Function3)var8;
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).L$1 = var11;
         ((<undefinedtype>)var10).L$2 = var8;
         ((<undefinedtype>)var10).L$3 = var9;
         ((<undefinedtype>)var10).L$4 = var22;
         ((<undefinedtype>)var10).L$5 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var10).L$6 = var35;
         ((<undefinedtype>)var10).L$7 = SpillingKt.nullOutSpilledVariable(var50);
         ((<undefinedtype>)var10).L$8 = var32;
         ((<undefinedtype>)var10).L$9 = var22;
         ((<undefinedtype>)var10).I$0 = var3;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = 0;
         ((<undefinedtype>)var10).label = 1;
         Object var47 = var46.invoke(var32, var9, var10);
         if (var47 == var16) {
            return var16;
         }

         Iterable var51 = var40;
         DeviceClient var43 = var32;
         Ref.ObjectRef var33 = var22;
         DeviceUuid var53 = var1;
         Ref.ObjectRef var15 = var22;
         Iterable var26 = var51;
         Ref.ObjectRef var19 = var33;
         var15.element = var47;
         if (((ApiResult)var33.element).isSuccess()) {
            Timber.Forest var27 = Timber.Forest;
            StringBuilder var34 = new StringBuilder("client ");
            var34.append(var43);
            var34.append(" gave good result ");
            var34.append(var19.element);
            var34.append(" for call ");
            var34.append(var8);
            var27.v(var34.toString(), new Object[0]);
            return var19.element;
         }

         Timber.Forest var52 = Timber.Forest;
         StringBuilder var48 = new StringBuilder("client ");
         var48.append(var43);
         var48.append(" gave failed result\n");
         var48.append(var33.element);
         var48.append(" for call \n");
         var48.append(var8);
         var48.append(", \nwith details:");
         var52.w(var48.toString(), new Object[0]);
         var40 = var26;
         var1 = var53;
         var22 = var33;
         var35 = var35;
      }

      var11.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object setAirRefreshEnabled(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAirRefreshEnabled(false, (Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      ConnectionManager var8;
      Iterable var9;
      Boolean var10;
      Iterator var12;
      Ref.ObjectRef var13;
      Ref.ObjectRef var17;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var3 = ((<undefinedtype>)var16).I$1;
         var4 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = ((<undefinedtype>)var16).L$6;
         var12 = (Iterator)((<undefinedtype>)var16).L$5;
         var9 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var10 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var11);
         var23 = var16;
         var17 = var14;
      } else {
         ResultKt.throwOnFailure(var11);
         var6 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxBoolean(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var10);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var33) {
            if (var34 instanceof CanSetAirRefresh) {
               var32.add(var34);
            }
         }

         var9 = (Iterable)((List)var32);
         var12 = var9.iterator();
         var3 = 0;
         var8 = this;
         var4 = 0;
         var11 = var16;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var12.next();
         var7 = (DeviceClient)var18;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var11).L$0 = this;
         ((<undefinedtype>)var11).L$1 = var6;
         ((<undefinedtype>)var11).L$2 = var10;
         ((<undefinedtype>)var11).L$3 = var26;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var11).L$5 = var12;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var26;
         ((<undefinedtype>)var11).Z$0 = var1;
         ((<undefinedtype>)var11).I$0 = var4;
         ((<undefinedtype>)var11).I$1 = var3;
         ((<undefinedtype>)var11).I$2 = 0;
         ((<undefinedtype>)var11).label = 1;
         Object var43 = var40.invoke(var7, var10, var11);
         if (var43 == var15) {
            return var15;
         }

         var17 = var26;
         var13 = var26;
         var23 = var11;
         var11 = var43;
      }

      while(true) {
         var13.element = var11;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var38 = new StringBuilder("client ");
         var38.append(var7);
         var38.append(" gave failed result\n");
         var38.append(var17.element);
         var38.append(" for call \n");
         var38.append(var6);
         var38.append(", \nwith details:");
         var41.w(var38.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var12.hasNext()) {
            var8.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var12.next();
         var7 = (DeviceClient)var19;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var8;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var10;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var39).L$5 = var12;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).Z$0 = var1;
         ((<undefinedtype>)var39).I$0 = var4;
         ((<undefinedtype>)var39).I$1 = var3;
         ((<undefinedtype>)var39).I$2 = 0;
         ((<undefinedtype>)var39).label = 1;
         Object var44 = var42.invoke(var7, var10, var39);
         if (var44 == var15) {
            return var15;
         }

         var17 = var27;
         var13 = var27;
         var23 = var39;
         var11 = var44;
      }
   }

   public final Object setAirRefreshStatus(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAirRefreshStatus(0, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterable var8;
      Iterator var9;
      Integer var10;
      Object var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var9 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var10 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var12);
         var11 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxInt(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var10);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         Timber.Forest var25 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var25.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         var8 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var8) {
            if (var34 instanceof CanSetAirRefresh) {
               var32.add(var34);
            }
         }

         var8 = (Iterable)((List)var32);
         var9 = var8.iterator();
         var3 = 0;
         var4 = 0;
         var11 = var17;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var19 = var9.next();
         var7 = (DeviceClient)var19;
         Function3 var39 = (Function3)var6;
         ((<undefinedtype>)var11).L$0 = this;
         ((<undefinedtype>)var11).L$1 = var6;
         ((<undefinedtype>)var11).L$2 = var10;
         ((<undefinedtype>)var11).L$3 = var26;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var11).L$5 = var9;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var26;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var4;
         ((<undefinedtype>)var11).I$2 = var3;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         Object var42 = var39.invoke(var7, var10, var11);
         if (var42 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = this;
         var12 = var42;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var37 = new StringBuilder("client ");
         var37.append(var7);
         var37.append(" gave failed result\n");
         var37.append(var18.element);
         var37.append(" for call \n");
         var37.append(var6);
         var37.append(", \nwith details:");
         var40.w(var37.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var9.hasNext()) {
            var38.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var9.next();
         var7 = (DeviceClient)var20;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var11).L$0 = var38;
         ((<undefinedtype>)var11).L$1 = var6;
         ((<undefinedtype>)var11).L$2 = var10;
         ((<undefinedtype>)var11).L$3 = var27;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var11).L$5 = var9;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var27;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var4;
         ((<undefinedtype>)var11).I$2 = var3;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         Object var43 = var41.invoke(var7, var10, var11);
         if (var43 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var38;
         var12 = var43;
      }
   }

   public final Object setAlarm(int var1, DeviceAlarm var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var22 = var7;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAlarm(0, (DeviceAlarm)null, (Continuation)this);
            }
         };
      }

      CanSetAlarm var12 = (CanSetAlarm)((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var22).label;
      int var5;
      DeviceAlarm var9;
      Object var10;
      Ref.ObjectRef var21;
      Iterator var23;
      Iterable var28;
      ConnectionManager var33;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var22).I$4;
         var1 = ((<undefinedtype>)var22).I$3;
         var5 = ((<undefinedtype>)var22).I$2;
         var1 = ((<undefinedtype>)var22).I$1;
         var4 = ((<undefinedtype>)var22).I$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$8;
         CanSetAlarm var19 = (CanSetAlarm)((<undefinedtype>)var22).L$7;
         DeviceClient var11 = (DeviceClient)((<undefinedtype>)var22).L$6;
         var19 = (CanSetAlarm)((<undefinedtype>)var22).L$5;
         Iterator var8 = (Iterator)((<undefinedtype>)var22).L$4;
         var28 = (Iterable)((<undefinedtype>)var22).L$3;
         var21 = (Ref.ObjectRef)((<undefinedtype>)var22).L$2;
         ConnectionManager var14 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var9 = (DeviceAlarm)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var10 = var22;
         var13.element = (ApiResult)var12;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var29 = new StringBuilder("client ");
            var29.append(var11);
            var29.append(" gave good result ");
            var29.append(var21.element);
            var29.append(" for call");
            var24.v(var29.toString(), new Object[0]);
            return var21.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var11);
         var45.append(" gave failed result\n");
         var45.append(var21.element);
         var45.append(" for call, \nwith details:");
         var40.w(var45.toString(), new Object[0]);
         int var6 = var4;
         var4 = var1;
         var1 = var6;
         var23 = var8;
         var33 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         Ref.ObjectRef var36 = new Ref.ObjectRef();
         StringBuilder var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" is ");
         var30.append(Reflection.getOrCreateKotlinClass(CanSetAlarm.class).getQualifiedName());
         var36.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var31 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetAlarm) {
               var31.add(var35);
            }
         }

         var28 = (Iterable)((List)var31);
         Iterator var41 = var28.iterator();
         var33 = this;
         var4 = 0;
         var10 = var22;
         var5 = 0;
         DeviceAlarm var38 = var2;
         var23 = var41;
         var21 = var36;
         var9 = var38;
      }

      while(var23.hasNext()) {
         Object var46 = var23.next();
         DeviceClient var39 = (DeviceClient)var46;
         var12 = (CanSetAlarm)var39;
         ((<undefinedtype>)var10).L$0 = var9;
         ((<undefinedtype>)var10).L$1 = var33;
         ((<undefinedtype>)var10).L$2 = var21;
         ((<undefinedtype>)var10).L$3 = SpillingKt.nullOutSpilledVariable(var28);
         ((<undefinedtype>)var10).L$4 = var23;
         ((<undefinedtype>)var10).L$5 = SpillingKt.nullOutSpilledVariable(var46);
         ((<undefinedtype>)var10).L$6 = var39;
         ((<undefinedtype>)var10).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var10).L$8 = var21;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var5;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).I$4 = 0;
         ((<undefinedtype>)var10).label = 1;
         var12 = (CanSetAlarm)var12.setAlarm(var1, var9, (Continuation)var10);
         if (var12 == var15) {
            return var15;
         }

         var21.element = (ApiResult)var12;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var25 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var39);
            var32.append(" gave good result ");
            var32.append(var21.element);
            var32.append(" for call");
            var25.v(var32.toString(), new Object[0]);
            return var21.element;
         }

         Timber.Forest var44 = Timber.Forest;
         StringBuilder var47 = new StringBuilder("client ");
         var47.append(var39);
         var47.append(" gave failed result\n");
         var47.append(var21.element);
         var47.append(" for call, \nwith details:");
         var44.w(var47.toString(), new Object[0]);
         var4 = var4;
         var1 = var1;
         var23 = var23;
         var33 = var33;
      }

      var33.logApiError(((ApiResult)var21.element).exceptionOrNull());
      return var21.element;
   }

   public final Object setApFanSpeed(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setApFanSpeed(0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Integer var8;
      Iterable var9;
      Iterator var10;
      Object var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var10 = (Iterator)((<undefinedtype>)var17).L$5;
         var9 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var8 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var14);
         var11 = (ConnectionManager)var17;
         var18 = var12;
      } else {
         ResultKt.throwOnFailure(var14);
         var6 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxInt(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var8);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         var29 = Timber.Forest;
         var24 = new StringBuilder("Client info: ");
         var24.append(this.clients);
         var29.v(var24.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         var9 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var9) {
            if (var36 instanceof CanSetMainMode) {
               var32.add(var36);
            }
         }

         var9 = (Iterable)((List)var32);
         var10 = var9.iterator();
         var4 = 0;
         var3 = 0;
         Object var38 = var17;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var41 = var10.next();
         var7 = (DeviceClient)var41;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var38).L$0 = this;
         ((<undefinedtype>)var38).L$1 = var6;
         ((<undefinedtype>)var38).L$2 = var8;
         ((<undefinedtype>)var38).L$3 = var26;
         ((<undefinedtype>)var38).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var38).L$5 = var10;
         ((<undefinedtype>)var38).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var38).L$7 = var7;
         ((<undefinedtype>)var38).L$8 = var26;
         ((<undefinedtype>)var38).I$0 = var1;
         ((<undefinedtype>)var38).I$1 = var3;
         ((<undefinedtype>)var38).I$2 = var4;
         ((<undefinedtype>)var38).I$3 = 0;
         ((<undefinedtype>)var38).label = 1;
         var14 = var19.invoke(var7, var8, var38);
         if (var14 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = this;
         var11 = (ConnectionManager)var38;
      }

      while(true) {
         var13.element = var14;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var33.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var39 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var7);
         var42.append(" gave failed result\n");
         var42.append(var18.element);
         var42.append(" for call \n");
         var42.append(var6);
         var42.append(", \nwith details:");
         var39.w(var42.toString(), new Object[0]);
         Object var40 = var11;
         var11 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var10.hasNext()) {
            var11.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var43 = var10.next();
         var7 = (DeviceClient)var43;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var40).L$0 = var11;
         ((<undefinedtype>)var40).L$1 = var6;
         ((<undefinedtype>)var40).L$2 = var8;
         ((<undefinedtype>)var40).L$3 = var27;
         ((<undefinedtype>)var40).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var40).L$5 = var10;
         ((<undefinedtype>)var40).L$6 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var40).L$7 = var7;
         ((<undefinedtype>)var40).L$8 = var27;
         ((<undefinedtype>)var40).I$0 = var1;
         ((<undefinedtype>)var40).I$1 = var3;
         ((<undefinedtype>)var40).I$2 = var4;
         ((<undefinedtype>)var40).I$3 = 0;
         ((<undefinedtype>)var40).label = 1;
         var14 = var20.invoke(var7, var8, var40);
         if (var14 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var11;
         var11 = (ConnectionManager)var40;
      }
   }

   public final Object setApSubMode(int var1, boolean var2, String var3, Continuation var4) {
      label43: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var8 = (<undefinedtype>)var4;
            if ((var8.label & Integer.MIN_VALUE) != 0) {
               var8.label += Integer.MIN_VALUE;
               var26 = var8;
               break label43;
            }
         }

         var26 = new ContinuationImpl(this, var4) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setApSubMode(0, false, (String)null, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var26).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var26).label;
      int var7;
      String var9;
      ConnectionManager var10;
      Iterable var12;
      Iterator var13;
      Ref.ObjectRef var22;
      Object var42;
      if (var5 != 0) {
         if (var5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var26).I$4;
         var1 = ((<undefinedtype>)var26).I$3;
         var5 = ((<undefinedtype>)var26).I$2;
         int var6 = ((<undefinedtype>)var26).I$1;
         var2 = ((<undefinedtype>)var26).Z$0;
         var1 = ((<undefinedtype>)var26).I$0;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var26).L$8;
         CanSetMainMode var19 = (CanSetMainMode)((<undefinedtype>)var26).L$7;
         DeviceClient var32 = (DeviceClient)((<undefinedtype>)var26).L$6;
         var19 = (CanSetMainMode)((<undefinedtype>)var26).L$5;
         var13 = (Iterator)((<undefinedtype>)var26).L$4;
         var12 = (Iterable)((<undefinedtype>)var26).L$3;
         Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var26).L$2;
         var10 = (ConnectionManager)((<undefinedtype>)var26).L$1;
         var9 = (String)((<undefinedtype>)var26).L$0;
         ResultKt.throwOnFailure(var15);
         var19 = (CanSetMainMode)var26;
         Ref.ObjectRef var27 = var11;
         var14.element = (ApiResult)var15;
         if (((ApiResult)var11.element).isSuccess()) {
            Timber.Forest var23 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var32);
            var35.append(" gave good result ");
            var35.append(var11.element);
            var35.append(" for call");
            var23.v(var35.toString(), new Object[0]);
            return var11.element;
         }

         Timber.Forest var45 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var32);
         var41.append(" gave failed result\n");
         var41.append(var27.element);
         var41.append(" for call, \nwith details:");
         var45.w(var41.toString(), new Object[0]);
         var42 = var19;
         var7 = var5;
         var5 = var6;
         var22 = var27;
      } else {
         ResultKt.throwOnFailure(var15);
         Ref.ObjectRef var33 = new Ref.ObjectRef();
         StringBuilder var36 = new StringBuilder("None of the clients in ");
         var36.append(this);
         var36.append(" is ");
         var36.append(Reflection.getOrCreateKotlinClass(CanSetMainMode.class).getQualifiedName());
         var33.element = new Failure((Throwable)(new UnknownError(var36.toString())));
         Iterable var39 = (Iterable)this.clients;
         Collection var37 = (Collection)(new ArrayList());

         for(Object var40 : var39) {
            if (var40 instanceof CanSetMainMode) {
               var37.add(var40);
            }
         }

         var12 = (Iterable)((List)var37);
         var13 = var12.iterator();
         var10 = this;
         var7 = 0;
         var5 = 0;
         var9 = var3;
         var22 = var33;
         var42 = var26;
      }

      while(var13.hasNext()) {
         Object var46 = var13.next();
         DeviceClient var34 = (DeviceClient)var46;
         CanSetMainMode var28 = (CanSetMainMode)var34;
         ((<undefinedtype>)var42).L$0 = var9;
         ((<undefinedtype>)var42).L$1 = var10;
         ((<undefinedtype>)var42).L$2 = var22;
         ((<undefinedtype>)var42).L$3 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var42).L$4 = var13;
         ((<undefinedtype>)var42).L$5 = SpillingKt.nullOutSpilledVariable(var46);
         ((<undefinedtype>)var42).L$6 = var34;
         ((<undefinedtype>)var42).L$7 = SpillingKt.nullOutSpilledVariable(var28);
         ((<undefinedtype>)var42).L$8 = var22;
         ((<undefinedtype>)var42).I$0 = var1;
         ((<undefinedtype>)var42).Z$0 = var2;
         ((<undefinedtype>)var42).I$1 = var5;
         ((<undefinedtype>)var42).I$2 = var7;
         ((<undefinedtype>)var42).I$3 = 0;
         ((<undefinedtype>)var42).I$4 = 0;
         ((<undefinedtype>)var42).label = 1;
         var15 = var28.setApSubMode(var1, var2, var9, (Continuation)var42);
         if (var15 == var16) {
            return var16;
         }

         Ref.ObjectRef var29 = var22;
         Ref.ObjectRef var47 = var22;
         Object var24 = var42;
         var47.element = (ApiResult)var15;
         if (((ApiResult)var29.element).isSuccess()) {
            Timber.Forest var25 = Timber.Forest;
            StringBuilder var38 = new StringBuilder("client ");
            var38.append(var34);
            var38.append(" gave good result ");
            var38.append(var29.element);
            var38.append(" for call");
            var25.v(var38.toString(), new Object[0]);
            return var29.element;
         }

         Timber.Forest var48 = Timber.Forest;
         StringBuilder var44 = new StringBuilder("client ");
         var44.append(var34);
         var44.append(" gave failed result\n");
         var44.append(var29.element);
         var44.append(" for call, \nwith details:");
         var48.w(var44.toString(), new Object[0]);
         var42 = var24;
         var7 = var7;
         var5 = var5;
         var22 = var29;
      }

      var10.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object setAutoMode(int var1, String var2, Continuation var3) {
      label66: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var25 = var7;
               break label66;
            }
         }

         var25 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAutoMode(0, (String)null, (Continuation)this);
            }
         };
      }

      CanSetFan var13 = (CanSetFan)((<undefinedtype>)var25).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var25).label;
      int var6;
      Object var8;
      Iterable var9;
      ConnectionManager var10;
      Iterator var11;
      Ref.ObjectRef var21;
      String var26;
      int var29;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var25).I$4;
         var1 = ((<undefinedtype>)var25).I$3;
         var1 = ((<undefinedtype>)var25).I$2;
         var29 = ((<undefinedtype>)var25).I$1;
         var4 = ((<undefinedtype>)var25).I$0;
         var21 = (Ref.ObjectRef)((<undefinedtype>)var25).L$8;
         CanSetFan var30 = (CanSetFan)((<undefinedtype>)var25).L$7;
         DeviceClient var12 = (DeviceClient)((<undefinedtype>)var25).L$6;
         var30 = (CanSetFan)((<undefinedtype>)var25).L$5;
         var11 = (Iterator)((<undefinedtype>)var25).L$4;
         var9 = (Iterable)((<undefinedtype>)var25).L$3;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var25).L$2;
         var10 = (ConnectionManager)((<undefinedtype>)var25).L$1;
         String var32 = (String)((<undefinedtype>)var25).L$0;
         ResultKt.throwOnFailure(var13);
         var6 = var1;
         var8 = var25;
         var21.element = (ApiResult)var13;
         if (((ApiResult)var14.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var22 = new StringBuilder("client ");
            var22.append(var12);
            var22.append(" gave good result ");
            var22.append(var14.element);
            var22.append(" for call");
            var33.v(var22.toString(), new Object[0]);
            return var14.element;
         }

         Timber.Forest var20 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var12);
         var45.append(" gave failed result\n");
         var45.append(var14.element);
         var45.append(" for call, \nwith details:");
         var20.w(var45.toString(), new Object[0]);
         var21 = var14;
         var26 = var32;
         var29 = var29;
      } else {
         ResultKt.throwOnFailure(var13);
         if (var1 < 0 || var1 >= 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }

         Ref.ObjectRef var34 = new Ref.ObjectRef();
         StringBuilder var38 = new StringBuilder("None of the clients in ");
         var38.append(this);
         var38.append(" is ");
         var38.append(Reflection.getOrCreateKotlinClass(CanSetFan.class).getQualifiedName());
         var34.element = new Failure((Throwable)(new UnknownError(var38.toString())));
         var9 = (Iterable)this.clients;
         Collection var39 = (Collection)(new ArrayList());

         for(Object var42 : var9) {
            if (var42 instanceof CanSetFan) {
               var39.add(var42);
            }
         }

         var9 = (Iterable)((List)var39);
         var11 = var9.iterator();
         var10 = this;
         String var43 = var2;
         var6 = 0;
         var29 = 0;
         var21 = var34;
         var8 = var25;
         var26 = var43;
         var4 = var1;
      }

      while(var11.hasNext()) {
         Object var35 = var11.next();
         DeviceClient var44 = (DeviceClient)var35;
         var13 = (CanSetFan)var44;
         ((<undefinedtype>)var8).L$0 = var26;
         ((<undefinedtype>)var8).L$1 = var10;
         ((<undefinedtype>)var8).L$2 = var21;
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var8).L$4 = var11;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var35);
         ((<undefinedtype>)var8).L$6 = var44;
         ((<undefinedtype>)var8).L$7 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var8).L$8 = var21;
         ((<undefinedtype>)var8).I$0 = var4;
         ((<undefinedtype>)var8).I$1 = var29;
         ((<undefinedtype>)var8).I$2 = var6;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).I$4 = 0;
         ((<undefinedtype>)var8).label = 1;
         var13 = (CanSetFan)var13.setAutoMode(var4, var26, (Continuation)var8);
         if (var13 == var15) {
            return var15;
         }

         String var36 = var26;
         Ref.ObjectRef var27 = var21;
         var21.element = (ApiResult)var13;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var37 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var44);
            var24.append(" gave good result ");
            var24.append(var27.element);
            var24.append(" for call");
            var37.v(var24.toString(), new Object[0]);
            return var27.element;
         }

         Timber.Forest var23 = Timber.Forest;
         StringBuilder var48 = new StringBuilder("client ");
         var48.append(var44);
         var48.append(" gave failed result\n");
         var48.append(var27.element);
         var48.append(" for call, \nwith details:");
         var23.w(var48.toString(), new Object[0]);
         var21 = var27;
         var26 = var36;
         var29 = var29;
      }

      var10.logApiError(((ApiResult)var21.element).exceptionOrNull());
      return var21.element;
   }

   public final Object setAutoModeDependency(Object var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAutoModeDependency((Object)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      Iterator var8;
      Iterable var9;
      ConnectionManager var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var23;
      Object var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         var1 = ((<undefinedtype>)var22).L$7;
         var8 = (Iterator)((<undefinedtype>)var22).L$6;
         var9 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = ((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var10 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = ((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var33 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var27 = var1;
         var29.append(var1);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var33.d(var29.toString(), new Object[0]);
         Timber.Forest var18 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var18.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanSetAutoModeDependency) {
               var32.add(var36);
            }
         }

         var9 = (Iterable)((List)var32);
         var8 = var9.iterator();
         var10 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         var12 = var8.next();
         var11 = (DeviceClient)var12;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var22).L$6 = var8;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var41.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var13 = var19;
         var1 = var27;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("client ");
            var21.append(var11);
            var21.append(" gave good result ");
            var21.append(var23.element);
            var21.append(" for call ");
            var21.append(var6);
            var28.v(var21.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var39 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var11);
         var42.append(" gave failed result\n");
         var42.append(var23.element);
         var42.append(" for call \n");
         var42.append(var6);
         var42.append(", \nwith details:");
         var39.w(var42.toString(), new Object[0]);
         var11 = (DeviceClient)var1;
         Ref.ObjectRef var20 = var23;
         Object var24 = var11;
         if (!var8.hasNext()) {
            var10.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var40 = var8.next();
         var11 = (DeviceClient)var40;
         Function3 var43 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var10;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var7).L$6 = var8;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var43.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         Object var44 = var24;
         var23 = var20;
         var13 = var20;
         var1 = var44;
      }
   }

   public final Object setAutoRh(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var18 = var6;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAutoRh(0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var18).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var18).label;
      int var5;
      DeviceClient var8;
      Object var9;
      ConnectionManager var10;
      Integer var11;
      Iterator var12;
      Iterable var13;
      Ref.ObjectRef var19;
      Ref.ObjectRef var24;
      KFunction var29;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var18).I$3;
         var3 = ((<undefinedtype>)var18).I$2;
         var5 = ((<undefinedtype>)var18).I$1;
         var1 = ((<undefinedtype>)var18).I$0;
         var24 = (Ref.ObjectRef)((<undefinedtype>)var18).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var18).L$7;
         Object var7 = ((<undefinedtype>)var18).L$6;
         var12 = (Iterator)((<undefinedtype>)var18).L$5;
         var13 = (Iterable)((<undefinedtype>)var18).L$4;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var18).L$3;
         var11 = (Integer)((<undefinedtype>)var18).L$2;
         var29 = (KFunction)((<undefinedtype>)var18).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = var18;
         var19 = var15;
      } else {
         ResultKt.throwOnFailure(var14);
         var29 = (KFunction)null.INSTANCE;
         var11 = Boxing.boxInt(var1);
         Timber.Forest var25 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Attempting to doApiCall ");
         var30.append(var29);
         var30.append(", with ");
         var30.append(var11);
         var30.append(" on ");
         var30.append(this.clients.size());
         var30.append(" clients");
         var25.d(var30.toString(), new Object[0]);
         Timber.Forest var26 = Timber.Forest;
         var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var26.v(var30.toString(), new Object[0]);
         var24 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var29);
         var24.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var33 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetAutoRh) {
               var33.add(var35);
            }
         }

         var13 = (Iterable)((List)var33);
         var12 = var13.iterator();
         byte var4 = 0;
         var10 = this;
         var3 = 0;
         var9 = var18;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var24.element).exceptionOrNull());
            return var24.element;
         }

         var14 = var12.next();
         var8 = (DeviceClient)var14;
         Function3 var20 = (Function3)var29;
         ((<undefinedtype>)var9).L$0 = this;
         ((<undefinedtype>)var9).L$1 = var29;
         ((<undefinedtype>)var9).L$2 = var11;
         ((<undefinedtype>)var9).L$3 = var24;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var9).L$7 = var8;
         ((<undefinedtype>)var9).L$8 = var24;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = var4;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         var14 = var20.invoke(var8, var11, var9);
         if (var14 == var16) {
            return var16;
         }

         var19 = var24;
         var5 = var3;
         var3 = var4;
      }

      while(true) {
         var24.element = var14;
         if (((ApiResult)var19.element).isSuccess()) {
            Timber.Forest var36 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var8);
            var28.append(" gave good result ");
            var28.append(var19.element);
            var28.append(" for call ");
            var28.append(var29);
            var36.v(var28.toString(), new Object[0]);
            return var19.element;
         }

         Timber.Forest var27 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var8);
         var39.append(" gave failed result\n");
         var39.append(var19.element);
         var39.append(" for call \n");
         var39.append(var29);
         var39.append(", \nwith details:");
         var27.w(var39.toString(), new Object[0]);
         var24 = var19;
         if (!var12.hasNext()) {
            var10.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var40 = var12.next();
         var8 = (DeviceClient)var40;
         Function3 var21 = (Function3)var29;
         ((<undefinedtype>)var9).L$0 = var10;
         ((<undefinedtype>)var9).L$1 = var29;
         ((<undefinedtype>)var9).L$2 = var11;
         ((<undefinedtype>)var9).L$3 = var24;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var9).L$7 = var8;
         ((<undefinedtype>)var9).L$8 = var24;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var5;
         ((<undefinedtype>)var9).I$2 = var3;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         var14 = var21.invoke(var8, var11, var9);
         if (var14 == var16) {
            return var16;
         }

         var19 = var24;
         var5 = var5;
         var3 = var3;
      }
   }

   public final Object setBrightness(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var18 = var6;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setBrightness(0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var18).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var18).label;
      int var5;
      KFunction var7;
      DeviceClient var8;
      Integer var9;
      Iterator var10;
      Iterable var11;
      Object var12;
      Ref.ObjectRef var15;
      Ref.ObjectRef var19;
      ConnectionManager var25;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var18).I$3;
         var3 = ((<undefinedtype>)var18).I$2;
         var5 = ((<undefinedtype>)var18).I$1;
         var1 = ((<undefinedtype>)var18).I$0;
         var15 = (Ref.ObjectRef)((<undefinedtype>)var18).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var18).L$7;
         var25 = (ConnectionManager)((<undefinedtype>)var18).L$6;
         var10 = (Iterator)((<undefinedtype>)var18).L$5;
         var11 = (Iterable)((<undefinedtype>)var18).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var18).L$3;
         var9 = (Integer)((<undefinedtype>)var18).L$2;
         var7 = (KFunction)((<undefinedtype>)var18).L$1;
         var25 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var14);
         var12 = (ConnectionManager)var18;
         var19 = var13;
      } else {
         ResultKt.throwOnFailure(var14);
         var7 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxInt(var1);
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var31 = new StringBuilder("Attempting to doApiCall ");
         var31.append(var7);
         var31.append(", with ");
         var31.append(var9);
         var31.append(" on ");
         var31.append(this.clients.size());
         var31.append(" clients");
         var26.d(var31.toString(), new Object[0]);
         Timber.Forest var32 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var32.v(var27.toString(), new Object[0]);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         StringBuilder var33 = new StringBuilder("None of the clients in ");
         var33.append(this);
         var33.append(" could call ");
         var33.append(var7);
         var28.element = new Failure((Throwable)(new UnknownError(var33.toString())));
         Iterable var36 = (Iterable)this.clients;
         Collection var34 = (Collection)(new ArrayList());

         for(Object var38 : var36) {
            if (var38 instanceof CanSetBrightness) {
               var34.add(var38);
            }
         }

         var11 = (Iterable)((List)var34);
         var10 = var11.iterator();
         byte var4 = 0;
         var3 = 0;
         Object var40 = var18;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var28.element).exceptionOrNull());
            return var28.element;
         }

         Object var20 = var10.next();
         var8 = (DeviceClient)var20;
         Function3 var43 = (Function3)var7;
         ((<undefinedtype>)var40).L$0 = this;
         ((<undefinedtype>)var40).L$1 = var7;
         ((<undefinedtype>)var40).L$2 = var9;
         ((<undefinedtype>)var40).L$3 = var28;
         ((<undefinedtype>)var40).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var40).L$5 = var10;
         ((<undefinedtype>)var40).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var40).L$7 = var8;
         ((<undefinedtype>)var40).L$8 = var28;
         ((<undefinedtype>)var40).I$0 = var1;
         ((<undefinedtype>)var40).I$1 = var3;
         ((<undefinedtype>)var40).I$2 = var4;
         ((<undefinedtype>)var40).I$3 = 0;
         ((<undefinedtype>)var40).label = 1;
         var14 = var43.invoke(var8, var9, var40);
         if (var14 == var16) {
            return var16;
         }

         var19 = var28;
         var15 = var28;
         var5 = var3;
         var25 = this;
         var3 = var4;
         var12 = (ConnectionManager)var40;
      }

      while(true) {
         var15.element = var14;
         if (((ApiResult)var19.element).isSuccess()) {
            Timber.Forest var30 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var8);
            var35.append(" gave good result ");
            var35.append(var19.element);
            var35.append(" for call ");
            var35.append(var7);
            var30.v(var35.toString(), new Object[0]);
            return var19.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var44 = new StringBuilder("client ");
         var44.append(var8);
         var44.append(" gave failed result\n");
         var44.append(var19.element);
         var44.append(" for call \n");
         var44.append(var7);
         var44.append(", \nwith details:");
         var41.w(var44.toString(), new Object[0]);
         Object var42 = var12;
         var12 = var25;
         Ref.ObjectRef var29 = var19;
         if (!var10.hasNext()) {
            var12.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var21 = var10.next();
         var8 = (DeviceClient)var21;
         Function3 var45 = (Function3)var7;
         ((<undefinedtype>)var42).L$0 = var12;
         ((<undefinedtype>)var42).L$1 = var7;
         ((<undefinedtype>)var42).L$2 = var9;
         ((<undefinedtype>)var42).L$3 = var29;
         ((<undefinedtype>)var42).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var42).L$5 = var10;
         ((<undefinedtype>)var42).L$6 = SpillingKt.nullOutSpilledVariable(var21);
         ((<undefinedtype>)var42).L$7 = var8;
         ((<undefinedtype>)var42).L$8 = var29;
         ((<undefinedtype>)var42).I$0 = var1;
         ((<undefinedtype>)var42).I$1 = var5;
         ((<undefinedtype>)var42).I$2 = var3;
         ((<undefinedtype>)var42).I$3 = 0;
         ((<undefinedtype>)var42).label = 1;
         var14 = var45.invoke(var8, var9, var42);
         if (var14 == var16) {
            return var16;
         }

         var19 = var29;
         var15 = var29;
         var5 = var5;
         var25 = var12;
         var3 = var3;
         var12 = (ConnectionManager)var42;
      }
   }

   public final Object setChildLock(int var1, Continuation var2) {
      int var4;
      label72: {
         var4 = var1;
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var19 = var5;
               break label72;
            }
         }

         var19 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setChildLock(0, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var19).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      var1 = ((<undefinedtype>)var19).label;
      int var3;
      Object var6;
      KFunction var7;
      Iterator var8;
      Iterable var9;
      Integer var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var20;
      ConnectionManager var23;
      if (var1 != 0) {
         if (var1 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var19).I$3;
         var3 = ((<undefinedtype>)var19).I$2;
         var1 = ((<undefinedtype>)var19).I$1;
         var4 = ((<undefinedtype>)var19).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var19).L$8;
         var11 = (DeviceClient)((<undefinedtype>)var19).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var19).L$6;
         var8 = (Iterator)((<undefinedtype>)var19).L$5;
         var9 = (Iterable)((<undefinedtype>)var19).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var19).L$3;
         var10 = (Integer)((<undefinedtype>)var19).L$2;
         var7 = (KFunction)((<undefinedtype>)var19).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var19).L$0;
         ResultKt.throwOnFailure(var12);
         var6 = var19;
         var20 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         if (var4 < 0 || var4 >= 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }

         var7 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxInt(var4);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var7);
         var29.append(", with ");
         var29.append(var10);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var7);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var35 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var37 : var35) {
            if (var37 instanceof CanSetChildLock) {
               var32.add(var37);
            }
         }

         var9 = (Iterable)((List)var32);
         var8 = var9.iterator();
         var3 = 0;
         var1 = 0;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var42 = var8.next();
         var11 = (DeviceClient)var42;
         Function3 var39 = (Function3)var7;
         ((<undefinedtype>)var19).L$0 = this;
         ((<undefinedtype>)var19).L$1 = var7;
         ((<undefinedtype>)var19).L$2 = var10;
         ((<undefinedtype>)var19).L$3 = var26;
         ((<undefinedtype>)var19).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var19).L$5 = var8;
         ((<undefinedtype>)var19).L$6 = SpillingKt.nullOutSpilledVariable(var42);
         ((<undefinedtype>)var19).L$7 = var11;
         ((<undefinedtype>)var19).L$8 = var26;
         ((<undefinedtype>)var19).I$0 = var4;
         ((<undefinedtype>)var19).I$1 = var1;
         ((<undefinedtype>)var19).I$2 = var3;
         ((<undefinedtype>)var19).I$3 = 0;
         ((<undefinedtype>)var19).label = 1;
         var12 = var39.invoke(var11, var10, var19);
         if (var12 == var15) {
            return var15;
         }

         var6 = var19;
         var20 = var26;
         var13 = var26;
         var23 = this;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var20.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var34 = new StringBuilder("client ");
            var34.append(var11);
            var34.append(" gave good result ");
            var34.append(var20.element);
            var34.append(" for call ");
            var34.append(var7);
            var28.v(var34.toString(), new Object[0]);
            return var20.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var43 = new StringBuilder("client ");
         var43.append(var11);
         var43.append(" gave failed result\n");
         var43.append(var20.element);
         var43.append(" for call \n");
         var43.append(var7);
         var43.append(", \nwith details:");
         var40.w(var43.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var20;
         Object var21 = var6;
         ConnectionManager var33 = var38;
         if (!var8.hasNext()) {
            var38.logApiError(((ApiResult)var27.element).exceptionOrNull());
            return var27.element;
         }

         Object var44 = var8.next();
         var11 = (DeviceClient)var44;
         Function3 var41 = (Function3)var7;
         ((<undefinedtype>)var21).L$0 = var33;
         ((<undefinedtype>)var21).L$1 = var7;
         ((<undefinedtype>)var21).L$2 = var10;
         ((<undefinedtype>)var21).L$3 = var27;
         ((<undefinedtype>)var21).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var21).L$5 = var8;
         ((<undefinedtype>)var21).L$6 = SpillingKt.nullOutSpilledVariable(var44);
         ((<undefinedtype>)var21).L$7 = var11;
         ((<undefinedtype>)var21).L$8 = var27;
         ((<undefinedtype>)var21).I$0 = var4;
         ((<undefinedtype>)var21).I$1 = var1;
         ((<undefinedtype>)var21).I$2 = var3;
         ((<undefinedtype>)var21).I$3 = 0;
         ((<undefinedtype>)var21).label = 1;
         var12 = var41.invoke(var11, var10, var21);
         if (var12 == var15) {
            return var15;
         }

         ConnectionManager var45 = var33;
         var6 = var21;
         var20 = var27;
         var13 = var27;
         var23 = var45;
      }
   }

   public final Object setCoolAutoLevel(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCoolAutoLevel(0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Object var8;
      Integer var9;
      Iterator var10;
      Iterable var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var10 = (Iterator)((<undefinedtype>)var17).L$5;
         var11 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var9 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var14);
         var8 = var17;
         var18 = var12;
      } else {
         ResultKt.throwOnFailure(var14);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var9);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetMainMode) {
               var32.add(var36);
            }
         }

         var11 = (Iterable)((List)var32);
         var10 = var11.iterator();
         var4 = 0;
         var3 = 0;
         var8 = var17;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var39 = var10.next();
         var7 = (DeviceClient)var39;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var9;
         ((<undefinedtype>)var8).L$3 = var26;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var8).L$5 = var10;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var39);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var26;
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).I$1 = var3;
         ((<undefinedtype>)var8).I$2 = var4;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).label = 1;
         var14 = var19.invoke(var7, var9, var8);
         if (var14 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = this;
      }

      while(true) {
         var13.element = var14;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var7);
         var40.append(" gave failed result\n");
         var40.append(var18.element);
         var40.append(" for call \n");
         var40.append(var6);
         var40.append(", \nwith details:");
         var37.w(var40.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var10.hasNext()) {
            var38.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var41 = var10.next();
         var7 = (DeviceClient)var41;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = var38;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var9;
         ((<undefinedtype>)var8).L$3 = var27;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var8).L$5 = var10;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var27;
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).I$1 = var3;
         ((<undefinedtype>)var8).I$2 = var4;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).label = 1;
         var14 = var20.invoke(var7, var9, var8);
         if (var14 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var38;
      }
   }

   public final Object setCoolAutoPresets(int var1, double[] var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var27 = var7;
               break label43;
            }
         }

         var27 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCoolAutoPresets(0, (double[])null, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var27).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var27).label;
      int var5;
      Object var9;
      double[] var10;
      Ref.ObjectRef var23;
      Iterator var28;
      Iterable var35;
      ConnectionManager var40;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var27).I$4;
         var1 = ((<undefinedtype>)var27).I$3;
         var5 = ((<undefinedtype>)var27).I$2;
         var1 = ((<undefinedtype>)var27).I$1;
         var4 = ((<undefinedtype>)var27).I$0;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var27).L$8;
         CanSetMainMode var20 = (CanSetMainMode)((<undefinedtype>)var27).L$7;
         DeviceClient var11 = (DeviceClient)((<undefinedtype>)var27).L$6;
         var20 = (CanSetMainMode)((<undefinedtype>)var27).L$5;
         Iterator var8 = (Iterator)((<undefinedtype>)var27).L$4;
         var35 = (Iterable)((<undefinedtype>)var27).L$3;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var27).L$2;
         ConnectionManager var22 = (ConnectionManager)((<undefinedtype>)var27).L$1;
         var10 = (double[])((<undefinedtype>)var27).L$0;
         ResultKt.throwOnFailure(var13);
         var9 = var27;
         var12.element = (ApiResult)var13;
         if (((ApiResult)var14.element).isSuccess()) {
            Timber.Forest var36 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var11);
            var24.append(" gave good result ");
            var24.append(var14.element);
            var24.append(" for call");
            var36.v(var24.toString(), new Object[0]);
            return var14.element;
         }

         Timber.Forest var51 = Timber.Forest;
         StringBuilder var56 = new StringBuilder("client ");
         var56.append(var11);
         var56.append(" gave failed result\n");
         var56.append(var14.element);
         var56.append(" for call, \nwith details:");
         var51.w(var56.toString(), new Object[0]);
         int var6 = var4;
         var4 = var1;
         ConnectionManager var47 = var22;
         var1 = var6;
         var23 = var14;
         var28 = var8;
         var40 = var47;
      } else {
         ResultKt.throwOnFailure(var13);
         Ref.ObjectRef var44 = new Ref.ObjectRef();
         StringBuilder var37 = new StringBuilder("None of the clients in ");
         var37.append(this);
         var37.append(" is ");
         var37.append(Reflection.getOrCreateKotlinClass(CanSetMainMode.class).getQualifiedName());
         var44.element = new Failure((Throwable)(new UnknownError(var37.toString())));
         Iterable var41 = (Iterable)this.clients;
         Collection var38 = (Collection)(new ArrayList());

         for(Object var42 : var41) {
            if (var42 instanceof CanSetMainMode) {
               var38.add(var42);
            }
         }

         var35 = (Iterable)((List)var38);
         Iterator var46 = var35.iterator();
         var40 = this;
         var4 = 0;
         Object var52 = var27;
         var5 = 0;
         double[] var48 = var2;
         var28 = var46;
         var23 = var44;
         var9 = var52;
         var10 = var48;
      }

      while(var28.hasNext()) {
         var13 = var28.next();
         DeviceClient var49 = (DeviceClient)var13;
         CanSetMainMode var53 = (CanSetMainMode)var49;
         ((<undefinedtype>)var9).L$0 = var10;
         ((<undefinedtype>)var9).L$1 = var40;
         ((<undefinedtype>)var9).L$2 = var23;
         ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var35);
         ((<undefinedtype>)var9).L$4 = var28;
         ((<undefinedtype>)var9).L$5 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var9).L$6 = var49;
         ((<undefinedtype>)var9).L$7 = SpillingKt.nullOutSpilledVariable(var53);
         ((<undefinedtype>)var9).L$8 = var23;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var4;
         ((<undefinedtype>)var9).I$2 = var5;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).I$4 = 0;
         ((<undefinedtype>)var9).label = 1;
         var13 = var53.setCoolAutoPresets(var1, var10, (Continuation)var9);
         if (var13 == var15) {
            return var15;
         }

         ConnectionManager var54 = var40;
         Iterator var43 = var28;
         Ref.ObjectRef var29 = var23;
         int var33 = var4;
         var4 = var1;
         Ref.ObjectRef var60 = var23;
         ConnectionManager var25 = var54;
         var1 = var33;
         var60.element = (ApiResult)var13;
         if (((ApiResult)var29.element).isSuccess()) {
            Timber.Forest var39 = Timber.Forest;
            StringBuilder var26 = new StringBuilder("client ");
            var26.append(var49);
            var26.append(" gave good result ");
            var26.append(var29.element);
            var26.append(" for call");
            var39.v(var26.toString(), new Object[0]);
            return var29.element;
         }

         Timber.Forest var55 = Timber.Forest;
         StringBuilder var59 = new StringBuilder("client ");
         var59.append(var49);
         var59.append(" gave failed result\n");
         var59.append(var29.element);
         var59.append(" for call, \nwith details:");
         var55.w(var59.toString(), new Object[0]);
         var33 = var4;
         var4 = var1;
         ConnectionManager var50 = var25;
         var1 = var33;
         var23 = var29;
         var28 = var43;
         var40 = var50;
      }

      var40.logApiError(((ApiResult)var23.element).exceptionOrNull());
      return var23.element;
   }

   public final Object setCoolEcoPresets(int var1, double[] var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var26 = var7;
               break label43;
            }
         }

         var26 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCoolEcoPresets(0, (double[])null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var26).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var26).label;
      int var5;
      double[] var9;
      Object var10;
      Ref.ObjectRef var23;
      Iterator var27;
      Iterable var34;
      ConnectionManager var39;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var26).I$4;
         var1 = ((<undefinedtype>)var26).I$3;
         var5 = ((<undefinedtype>)var26).I$2;
         var1 = ((<undefinedtype>)var26).I$1;
         var4 = ((<undefinedtype>)var26).I$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var26).L$8;
         CanSetMainMode var20 = (CanSetMainMode)((<undefinedtype>)var26).L$7;
         DeviceClient var11 = (DeviceClient)((<undefinedtype>)var26).L$6;
         var20 = (CanSetMainMode)((<undefinedtype>)var26).L$5;
         Iterator var8 = (Iterator)((<undefinedtype>)var26).L$4;
         var34 = (Iterable)((<undefinedtype>)var26).L$3;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var26).L$2;
         ConnectionManager var22 = (ConnectionManager)((<undefinedtype>)var26).L$1;
         var9 = (double[])((<undefinedtype>)var26).L$0;
         ResultKt.throwOnFailure(var12);
         var10 = var26;
         var13.element = (ApiResult)var12;
         if (((ApiResult)var14.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var11);
            var24.append(" gave good result ");
            var24.append(var14.element);
            var24.append(" for call");
            var35.v(var24.toString(), new Object[0]);
            return var14.element;
         }

         Timber.Forest var49 = Timber.Forest;
         StringBuilder var54 = new StringBuilder("client ");
         var54.append(var11);
         var54.append(" gave failed result\n");
         var54.append(var14.element);
         var54.append(" for call, \nwith details:");
         var49.w(var54.toString(), new Object[0]);
         int var6 = var4;
         var4 = var1;
         ConnectionManager var46 = var22;
         var1 = var6;
         var23 = var14;
         var27 = var8;
         var39 = var46;
      } else {
         ResultKt.throwOnFailure(var12);
         Ref.ObjectRef var43 = new Ref.ObjectRef();
         StringBuilder var36 = new StringBuilder("None of the clients in ");
         var36.append(this);
         var36.append(" is ");
         var36.append(Reflection.getOrCreateKotlinClass(CanSetMainMode.class).getQualifiedName());
         var43.element = new Failure((Throwable)(new UnknownError(var36.toString())));
         Iterable var40 = (Iterable)this.clients;
         Collection var37 = (Collection)(new ArrayList());

         for(Object var44 : var40) {
            if (var44 instanceof CanSetMainMode) {
               var37.add(var44);
            }
         }

         var34 = (Iterable)((List)var37);
         Iterator var45 = var34.iterator();
         var39 = this;
         var4 = 0;
         Object var47 = var26;
         var5 = 0;
         double[] var50 = var2;
         var27 = var45;
         var23 = var43;
         var10 = var47;
         var9 = var50;
      }

      while(var27.hasNext()) {
         var12 = var27.next();
         DeviceClient var48 = (DeviceClient)var12;
         CanSetMainMode var55 = (CanSetMainMode)var48;
         ((<undefinedtype>)var10).L$0 = var9;
         ((<undefinedtype>)var10).L$1 = var39;
         ((<undefinedtype>)var10).L$2 = var23;
         ((<undefinedtype>)var10).L$3 = SpillingKt.nullOutSpilledVariable(var34);
         ((<undefinedtype>)var10).L$4 = var27;
         ((<undefinedtype>)var10).L$5 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var10).L$6 = var48;
         ((<undefinedtype>)var10).L$7 = SpillingKt.nullOutSpilledVariable(var55);
         ((<undefinedtype>)var10).L$8 = var23;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var5;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).I$4 = 0;
         ((<undefinedtype>)var10).label = 1;
         var12 = var55.setCoolEcoPresets(var1, var9, (Continuation)var10);
         if (var12 == var15) {
            return var15;
         }

         ConnectionManager var57 = var39;
         Iterator var42 = var27;
         Ref.ObjectRef var28 = var23;
         int var32 = var4;
         var4 = var1;
         var1 = var32;
         var23.element = (ApiResult)var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var38 = Timber.Forest;
            StringBuilder var25 = new StringBuilder("client ");
            var25.append(var48);
            var25.append(" gave good result ");
            var25.append(var28.element);
            var25.append(" for call");
            var38.v(var25.toString(), new Object[0]);
            return var28.element;
         }

         Timber.Forest var53 = Timber.Forest;
         StringBuilder var56 = new StringBuilder("client ");
         var56.append(var48);
         var56.append(" gave failed result\n");
         var56.append(var23.element);
         var56.append(" for call, \nwith details:");
         var53.w(var56.toString(), new Object[0]);
         var32 = var4;
         var4 = var1;
         var1 = var32;
         var23 = var23;
         var27 = var42;
         var39 = var57;
      }

      var39.logApiError(((ApiResult)var23.element).exceptionOrNull());
      return var23.element;
   }

   public final Object setCoolFanSpeed(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCoolFanSpeed(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var9;
      Iterable var10;
      Object var11;
      Integer var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var9 = (Iterator)((<undefinedtype>)var17).L$5;
         var10 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var8 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var12 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var11 = var17;
         var18 = var8;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var12 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var12);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var38 : var33) {
            if (var38 instanceof CanSetMainMode) {
               var32.add(var38);
            }
         }

         var10 = (Iterable)((List)var32);
         var9 = var10.iterator();
         var4 = 0;
         var3 = 0;
         var11 = var17;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var13 = var9.next();
         var7 = (DeviceClient)var13;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var11).L$0 = this;
         ((<undefinedtype>)var11).L$1 = var6;
         ((<undefinedtype>)var11).L$2 = var12;
         ((<undefinedtype>)var11).L$3 = var26;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var11).L$5 = var9;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var26;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var3;
         ((<undefinedtype>)var11).I$2 = var4;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         var13 = var19.invoke(var7, var12, var11);
         if (var13 == var15) {
            return var15;
         }

         var18 = var26;
         var14 = var26;
         var23 = this;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var37 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var37.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var7);
         var40.append(" gave failed result\n");
         var40.append(var18.element);
         var40.append(" for call \n");
         var40.append(var6);
         var40.append(", \nwith details:");
         var35.w(var40.toString(), new Object[0]);
         ConnectionManager var36 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var9.hasNext()) {
            var36.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var41 = var9.next();
         var7 = (DeviceClient)var41;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var11).L$0 = var36;
         ((<undefinedtype>)var11).L$1 = var6;
         ((<undefinedtype>)var11).L$2 = var12;
         ((<undefinedtype>)var11).L$3 = var27;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var11).L$5 = var9;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var27;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var3;
         ((<undefinedtype>)var11).I$2 = var4;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         var13 = var20.invoke(var7, var12, var11);
         if (var13 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var23 = var36;
      }
   }

   public final Object setCoolFanSpeedLevel(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCoolFanSpeedLevel(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterable var8;
      Integer var9;
      ConnectionManager var10;
      Iterator var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = ((<undefinedtype>)var17).L$6;
         var11 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var9 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var23 = var17;
         var18 = var12;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxInt(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var9);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         var29 = Timber.Forest;
         var24 = new StringBuilder("Client info: ");
         var24.append(this.clients);
         var29.v(var24.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         var8 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var8) {
            if (var36 instanceof CanSetMainMode) {
               var32.add(var36);
            }
         }

         var8 = (Iterable)((List)var32);
         var11 = var8.iterator();
         var3 = 0;
         var10 = this;
         var4 = 0;
         Object var37 = var17;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var13 = var11.next();
         var7 = (DeviceClient)var13;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var9;
         ((<undefinedtype>)var37).L$3 = var26;
         ((<undefinedtype>)var37).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var37).L$5 = var11;
         ((<undefinedtype>)var37).L$6 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var37).L$7 = var7;
         ((<undefinedtype>)var37).L$8 = var26;
         ((<undefinedtype>)var37).I$0 = var1;
         ((<undefinedtype>)var37).I$1 = var4;
         ((<undefinedtype>)var37).I$2 = var3;
         ((<undefinedtype>)var37).I$3 = 0;
         ((<undefinedtype>)var37).label = 1;
         var13 = var19.invoke(var7, var9, var37);
         if (var13 == var15) {
            return var15;
         }

         var18 = var26;
         var14 = var26;
         var23 = var37;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var38 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var7);
         var41.append(" gave failed result\n");
         var41.append(var18.element);
         var41.append(" for call \n");
         var41.append(var6);
         var41.append(", \nwith details:");
         var38.w(var41.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var11.hasNext()) {
            var10.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var42 = var11.next();
         var7 = (DeviceClient)var42;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var10;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var9;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var39).L$5 = var11;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var42);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).I$0 = var1;
         ((<undefinedtype>)var39).I$1 = var4;
         ((<undefinedtype>)var39).I$2 = var3;
         ((<undefinedtype>)var39).I$3 = 0;
         ((<undefinedtype>)var39).label = 1;
         var13 = var20.invoke(var7, var9, var39);
         if (var13 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var23 = var39;
      }
   }

   public final Object setCoolSubMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCoolSubMode(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterable var8;
      Object var9;
      Integer var10;
      Iterator var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var12 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var10 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var9 = var17;
         var18 = var11;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var10);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         var8 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var8) {
            if (var36 instanceof CanSetMainMode) {
               var32.add(var36);
            }
         }

         var8 = (Iterable)((List)var32);
         var12 = var8.iterator();
         var4 = 0;
         var3 = 0;
         var9 = var17;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var13 = var12.next();
         var7 = (DeviceClient)var13;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var9).L$0 = this;
         ((<undefinedtype>)var9).L$1 = var6;
         ((<undefinedtype>)var9).L$2 = var10;
         ((<undefinedtype>)var9).L$3 = var26;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var9).L$7 = var7;
         ((<undefinedtype>)var9).L$8 = var26;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = var4;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         var13 = var19.invoke(var7, var10, var9);
         if (var13 == var15) {
            return var15;
         }

         var18 = var26;
         var14 = var26;
         var23 = this;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var7);
            var35.append(" gave good result ");
            var35.append(var18.element);
            var35.append(" for call ");
            var35.append(var6);
            var28.v(var35.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var37 = new StringBuilder("client ");
         var37.append(var7);
         var37.append(" gave failed result\n");
         var37.append(var18.element);
         var37.append(" for call \n");
         var37.append(var6);
         var37.append(", \nwith details:");
         var40.w(var37.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var12.hasNext()) {
            var38.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var41 = var12.next();
         var7 = (DeviceClient)var41;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var9).L$0 = var38;
         ((<undefinedtype>)var9).L$1 = var6;
         ((<undefinedtype>)var9).L$2 = var10;
         ((<undefinedtype>)var9).L$3 = var27;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var9).L$7 = var7;
         ((<undefinedtype>)var9).L$8 = var27;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = var4;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         var13 = var20.invoke(var7, var10, var9);
         if (var13 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var23 = var38;
      }
   }

   public final Object setDehSubMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var18 = var6;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setDehSubMode(0, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var18).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var18).label;
      int var5;
      KFunction var7;
      DeviceClient var8;
      Integer var9;
      Object var10;
      Iterator var11;
      Iterable var13;
      Ref.ObjectRef var14;
      Ref.ObjectRef var19;
      ConnectionManager var25;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var18).I$3;
         var3 = ((<undefinedtype>)var18).I$2;
         var5 = ((<undefinedtype>)var18).I$1;
         var1 = ((<undefinedtype>)var18).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var18).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var18).L$7;
         var25 = (ConnectionManager)((<undefinedtype>)var18).L$6;
         var11 = (Iterator)((<undefinedtype>)var18).L$5;
         var13 = (Iterable)((<undefinedtype>)var18).L$4;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var18).L$3;
         var9 = (Integer)((<undefinedtype>)var18).L$2;
         var7 = (KFunction)((<undefinedtype>)var18).L$1;
         var25 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var12);
         var10 = var18;
         var19 = var15;
      } else {
         ResultKt.throwOnFailure(var12);
         var7 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxInt(var1);
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var31 = new StringBuilder("Attempting to doApiCall ");
         var31.append(var7);
         var31.append(", with ");
         var31.append(var9);
         var31.append(" on ");
         var31.append(this.clients.size());
         var31.append(" clients");
         var26.d(var31.toString(), new Object[0]);
         Timber.Forest var32 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var32.v(var27.toString(), new Object[0]);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         StringBuilder var33 = new StringBuilder("None of the clients in ");
         var33.append(this);
         var33.append(" could call ");
         var33.append(var7);
         var28.element = new Failure((Throwable)(new UnknownError(var33.toString())));
         Iterable var36 = (Iterable)this.clients;
         Collection var34 = (Collection)(new ArrayList());

         for(Object var38 : var36) {
            if (var38 instanceof CanSetDehSubMode) {
               var34.add(var38);
            }
         }

         var13 = (Iterable)((List)var34);
         var11 = var13.iterator();
         byte var4 = 0;
         var3 = 0;
         var10 = var18;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var28.element).exceptionOrNull());
            return var28.element;
         }

         Object var20 = var11.next();
         var8 = (DeviceClient)var20;
         Function3 var41 = (Function3)var7;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var7;
         ((<undefinedtype>)var10).L$2 = var9;
         ((<undefinedtype>)var10).L$3 = var28;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var10).L$5 = var11;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var10).L$7 = var8;
         ((<undefinedtype>)var10).L$8 = var28;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var3;
         ((<undefinedtype>)var10).I$2 = var4;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         Object var44 = var41.invoke(var8, var9, var10);
         if (var44 == var16) {
            return var16;
         }

         var19 = var28;
         var14 = var28;
         var5 = var3;
         var25 = this;
         var3 = var4;
         var12 = var44;
      }

      while(true) {
         var14.element = var12;
         if (((ApiResult)var19.element).isSuccess()) {
            Timber.Forest var30 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var8);
            var35.append(" gave good result ");
            var35.append(var19.element);
            var35.append(" for call ");
            var35.append(var7);
            var30.v(var35.toString(), new Object[0]);
            return var19.element;
         }

         Timber.Forest var39 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var8);
         var42.append(" gave failed result\n");
         var42.append(var19.element);
         var42.append(" for call \n");
         var42.append(var7);
         var42.append(", \nwith details:");
         var39.w(var42.toString(), new Object[0]);
         ConnectionManager var40 = var25;
         Ref.ObjectRef var29 = var19;
         if (!var11.hasNext()) {
            var40.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var21 = var11.next();
         var8 = (DeviceClient)var21;
         Function3 var43 = (Function3)var7;
         ((<undefinedtype>)var10).L$0 = var40;
         ((<undefinedtype>)var10).L$1 = var7;
         ((<undefinedtype>)var10).L$2 = var9;
         ((<undefinedtype>)var10).L$3 = var29;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var10).L$5 = var11;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var21);
         ((<undefinedtype>)var10).L$7 = var8;
         ((<undefinedtype>)var10).L$8 = var29;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var5;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         Object var45 = var43.invoke(var8, var9, var10);
         if (var45 == var16) {
            return var16;
         }

         var19 = var29;
         var14 = var29;
         var5 = var5;
         var25 = var40;
         var3 = var3;
         var12 = var45;
      }
   }

   public final Object setDeviceName(String var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setDeviceName((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      Iterable var8;
      Iterator var9;
      ConnectionManager var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var23;
      String var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var9 = (Iterator)((<undefinedtype>)var22).L$6;
         var8 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (String)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var10 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (String)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var33 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var27 = var1;
         var29.append(var1);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var33.d(var29.toString(), new Object[0]);
         Timber.Forest var18 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var18.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanSetDeviceName) {
               var32.add(var36);
            }
         }

         var8 = (Iterable)((List)var32);
         var9 = var8.iterator();
         var10 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         var12 = var9.next();
         var11 = (DeviceClient)var12;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var22).L$6 = var9;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var41.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var13 = var19;
         var1 = var27;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("client ");
            var21.append(var11);
            var21.append(" gave good result ");
            var21.append(var23.element);
            var21.append(" for call ");
            var21.append(var6);
            var28.v(var21.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var11);
         var39.append(" gave failed result\n");
         var39.append(var23.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         String var37 = var1;
         Ref.ObjectRef var20 = var23;
         String var24 = var37;
         if (!var9.hasNext()) {
            var10.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var40 = var9.next();
         var11 = (DeviceClient)var40;
         Function3 var43 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var10;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var7).L$6 = var9;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var43.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         String var44 = var24;
         var23 = var20;
         var13 = var20;
         var1 = var44;
      }
   }

   public final Object setDisinfection(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setDisinfection(false, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Boolean var8;
      Object var9;
      Iterable var10;
      Iterator var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var17;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var3 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$6;
         var11 = (Iterator)((<undefinedtype>)var16).L$5;
         var10 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var8 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = (ConnectionManager)var16;
         var17 = var12;
      } else {
         ResultKt.throwOnFailure(var14);
         var6 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxBoolean(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var8);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         var29 = Timber.Forest;
         var24 = new StringBuilder("Client info: ");
         var24.append(this.clients);
         var29.v(var24.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetDisinfection) {
               var32.add(var35);
            }
         }

         var10 = (Iterable)((List)var32);
         var11 = var10.iterator();
         var4 = 0;
         var3 = 0;
         Object var38 = var16;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var41 = var11.next();
         var7 = (DeviceClient)var41;
         Function3 var18 = (Function3)var6;
         ((<undefinedtype>)var38).L$0 = this;
         ((<undefinedtype>)var38).L$1 = var6;
         ((<undefinedtype>)var38).L$2 = var8;
         ((<undefinedtype>)var38).L$3 = var26;
         ((<undefinedtype>)var38).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var38).L$5 = var11;
         ((<undefinedtype>)var38).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var38).L$7 = var7;
         ((<undefinedtype>)var38).L$8 = var26;
         ((<undefinedtype>)var38).Z$0 = var1;
         ((<undefinedtype>)var38).I$0 = var3;
         ((<undefinedtype>)var38).I$1 = var4;
         ((<undefinedtype>)var38).I$2 = 0;
         ((<undefinedtype>)var38).label = 1;
         var14 = var18.invoke(var7, var8, var38);
         if (var14 == var15) {
            return var15;
         }

         var17 = var26;
         var13 = var26;
         var23 = this;
         var9 = (ConnectionManager)var38;
      }

      while(true) {
         var13.element = var14;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var33 = new StringBuilder("client ");
            var33.append(var7);
            var33.append(" gave good result ");
            var33.append(var17.element);
            var33.append(" for call ");
            var33.append(var6);
            var28.v(var33.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var7);
         var39.append(" gave failed result\n");
         var39.append(var17.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         Object var40 = var9;
         var9 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var11.hasNext()) {
            var9.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var43 = var11.next();
         var7 = (DeviceClient)var43;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var40).L$0 = var9;
         ((<undefinedtype>)var40).L$1 = var6;
         ((<undefinedtype>)var40).L$2 = var8;
         ((<undefinedtype>)var40).L$3 = var27;
         ((<undefinedtype>)var40).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var40).L$5 = var11;
         ((<undefinedtype>)var40).L$6 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var40).L$7 = var7;
         ((<undefinedtype>)var40).L$8 = var27;
         ((<undefinedtype>)var40).Z$0 = var1;
         ((<undefinedtype>)var40).I$0 = var3;
         ((<undefinedtype>)var40).I$1 = var4;
         ((<undefinedtype>)var40).I$2 = 0;
         ((<undefinedtype>)var40).label = 1;
         var14 = var19.invoke(var7, var8, var40);
         if (var14 == var15) {
            return var15;
         }

         var17 = var27;
         var13 = var27;
         var23 = var9;
         var9 = (ConnectionManager)var40;
      }
   }

   public final Object setDualOscillationState(boolean var1, int var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var19 = var7;
               break label43;
            }
         }

         var19 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setDualOscillationState(false, 0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var19).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var19).label;
      int var5;
      ConnectionManager var9;
      Iterator var10;
      Object var11;
      Iterable var12;
      Ref.ObjectRef var21;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var19).I$4;
         var2 = ((<undefinedtype>)var19).I$3;
         var5 = ((<undefinedtype>)var19).I$2;
         var2 = ((<undefinedtype>)var19).I$1;
         var4 = ((<undefinedtype>)var19).I$0;
         var1 = ((<undefinedtype>)var19).Z$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var19).L$7;
         CanSetOscillation var26 = (CanSetOscillation)((<undefinedtype>)var19).L$6;
         DeviceClient var8 = (DeviceClient)((<undefinedtype>)var19).L$5;
         var26 = (CanSetOscillation)((<undefinedtype>)var19).L$4;
         var10 = (Iterator)((<undefinedtype>)var19).L$3;
         var12 = (Iterable)((<undefinedtype>)var19).L$2;
         Ref.ObjectRef var28 = (Ref.ObjectRef)((<undefinedtype>)var19).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var19).L$0;
         ResultKt.throwOnFailure(var14);
         var11 = var19;
         var13.element = (ApiResult)var14;
         if (((ApiResult)var28.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var22 = new StringBuilder("client ");
            var22.append(var8);
            var22.append(" gave good result ");
            var22.append(var28.element);
            var22.append(" for call");
            var35.v(var22.toString(), new Object[0]);
            return var28.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var20 = new StringBuilder("client ");
         var20.append(var8);
         var20.append(" gave failed result\n");
         var20.append(var28.element);
         var20.append(" for call, \nwith details:");
         var40.w(var20.toString(), new Object[0]);
         var21 = var28;
      } else {
         ResultKt.throwOnFailure(var14);
         Ref.ObjectRef var29 = new Ref.ObjectRef();
         StringBuilder var32 = new StringBuilder("None of the clients in ");
         var32.append(this);
         var32.append(" is ");
         var32.append(Reflection.getOrCreateKotlinClass(CanSetOscillation.class).getQualifiedName());
         var29.element = new Failure((Throwable)(new UnknownError(var32.toString())));
         Iterable var36 = (Iterable)this.clients;
         Collection var33 = (Collection)(new ArrayList());

         for(Object var37 : var36) {
            if (var37 instanceof CanSetOscillation) {
               var33.add(var37);
            }
         }

         var12 = (Iterable)((List)var33);
         var10 = var12.iterator();
         var9 = this;
         byte var6 = 0;
         var11 = var19;
         var5 = 0;
         var4 = var2;
         var21 = var29;
         var2 = var6;
      }

      while(var10.hasNext()) {
         Object var41 = var10.next();
         DeviceClient var34 = (DeviceClient)var41;
         CanSetOscillation var30 = (CanSetOscillation)var34;
         ((<undefinedtype>)var11).L$0 = var9;
         ((<undefinedtype>)var11).L$1 = var21;
         ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var11).L$3 = var10;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var11).L$5 = var34;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var30);
         ((<undefinedtype>)var11).L$7 = var21;
         ((<undefinedtype>)var11).Z$0 = var1;
         ((<undefinedtype>)var11).I$0 = var4;
         ((<undefinedtype>)var11).I$1 = var2;
         ((<undefinedtype>)var11).I$2 = var5;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).I$4 = 0;
         ((<undefinedtype>)var11).label = 1;
         var14 = var30.setDualOscillationState(var1, var4, (Continuation)var11);
         if (var14 == var15) {
            return var15;
         }

         Ref.ObjectRef var31 = var21;
         var21.element = (ApiResult)var14;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var38 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var34);
            var24.append(" gave good result ");
            var24.append(var31.element);
            var24.append(" for call");
            var38.v(var24.toString(), new Object[0]);
            return var31.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var34);
         var23.append(" gave failed result\n");
         var23.append(var31.element);
         var23.append(" for call, \nwith details:");
         var42.w(var23.toString(), new Object[0]);
         var21 = var31;
      }

      var9.logApiError(((ApiResult)var21.element).exceptionOrNull());
      return var21.element;
   }

   public final Object setEcoMode(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var17 = var6;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setEcoMode(false, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var5;
      KFunction var7;
      DeviceClient var8;
      Boolean var9;
      Iterable var10;
      Object var11;
      Iterator var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      ConnectionManager var25;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var5 = ((<undefinedtype>)var17).I$0;
         var1 = ((<undefinedtype>)var17).Z$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var25 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var12 = (Iterator)((<undefinedtype>)var17).L$5;
         var10 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var9 = (Boolean)((<undefinedtype>)var17).L$2;
         var7 = (KFunction)((<undefinedtype>)var17).L$1;
         var25 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var11 = (ConnectionManager)var17;
         var18 = var15;
      } else {
         ResultKt.throwOnFailure(var13);
         var7 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxBoolean(var1);
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var31 = new StringBuilder("Attempting to doApiCall ");
         var31.append(var7);
         var31.append(", with ");
         var31.append(var9);
         var31.append(" on ");
         var31.append(this.clients.size());
         var31.append(" clients");
         var26.d(var31.toString(), new Object[0]);
         var26 = Timber.Forest;
         var31 = new StringBuilder("Client info: ");
         var31.append(this.clients);
         var26.v(var31.toString(), new Object[0]);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var7);
         var28.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         var10 = (Iterable)this.clients;
         Collection var34 = (Collection)(new ArrayList());

         for(Object var37 : var10) {
            if (var37 instanceof CanSetEcoMode) {
               var34.add(var37);
            }
         }

         var10 = (Iterable)((List)var34);
         var12 = var10.iterator();
         byte var4 = 0;
         var3 = 0;
         var13 = var17;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var28.element).exceptionOrNull());
            return var28.element;
         }

         Object var19 = var12.next();
         var8 = (DeviceClient)var19;
         Function3 var43 = (Function3)var7;
         ((<undefinedtype>)var13).L$0 = this;
         ((<undefinedtype>)var13).L$1 = var7;
         ((<undefinedtype>)var13).L$2 = var9;
         ((<undefinedtype>)var13).L$3 = var28;
         ((<undefinedtype>)var13).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var13).L$5 = var12;
         ((<undefinedtype>)var13).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var13).L$7 = var8;
         ((<undefinedtype>)var13).L$8 = var28;
         ((<undefinedtype>)var13).Z$0 = var1;
         ((<undefinedtype>)var13).I$0 = var3;
         ((<undefinedtype>)var13).I$1 = var4;
         ((<undefinedtype>)var13).I$2 = 0;
         ((<undefinedtype>)var13).label = 1;
         Object var46 = var43.invoke(var8, var9, var13);
         if (var46 == var16) {
            return var16;
         }

         var18 = var28;
         var14 = var28;
         var5 = var3;
         var25 = this;
         var3 = var4;
         var11 = (ConnectionManager)var13;
         var13 = var46;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var30 = new StringBuilder("client ");
            var30.append(var8);
            var30.append(" gave good result ");
            var30.append(var18.element);
            var30.append(" for call ");
            var30.append(var7);
            var35.v(var30.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var44 = new StringBuilder("client ");
         var44.append(var8);
         var44.append(" gave failed result\n");
         var44.append(var18.element);
         var44.append(" for call \n");
         var44.append(var7);
         var44.append(", \nwith details:");
         var41.w(var44.toString(), new Object[0]);
         Object var42 = var11;
         var11 = var25;
         Ref.ObjectRef var29 = var18;
         if (!var12.hasNext()) {
            var11.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var12.next();
         var8 = (DeviceClient)var20;
         Function3 var45 = (Function3)var7;
         ((<undefinedtype>)var42).L$0 = var11;
         ((<undefinedtype>)var42).L$1 = var7;
         ((<undefinedtype>)var42).L$2 = var9;
         ((<undefinedtype>)var42).L$3 = var29;
         ((<undefinedtype>)var42).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var42).L$5 = var12;
         ((<undefinedtype>)var42).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var42).L$7 = var8;
         ((<undefinedtype>)var42).L$8 = var29;
         ((<undefinedtype>)var42).Z$0 = var1;
         ((<undefinedtype>)var42).I$0 = var5;
         ((<undefinedtype>)var42).I$1 = var3;
         ((<undefinedtype>)var42).I$2 = 0;
         ((<undefinedtype>)var42).label = 1;
         Object var47 = var45.invoke(var8, var9, var42);
         if (var47 == var16) {
            return var16;
         }

         var18 = var29;
         var14 = var29;
         var5 = var5;
         var25 = var11;
         var3 = var3;
         var11 = (ConnectionManager)var42;
         var13 = var47;
      }
   }

   public final Object setFanSpeed(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setFanSpeed(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      DeviceClient var7;
      Integer var8;
      Iterable var9;
      Object var10;
      Iterator var11;
      ConnectionManager var12;
      Ref.ObjectRef var18;
      Ref.ObjectRef var22;
      KFunction var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var22 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         Object var6 = ((<undefinedtype>)var17).L$6;
         var11 = (Iterator)((<undefinedtype>)var17).L$5;
         var9 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var8 = (Integer)((<undefinedtype>)var17).L$2;
         var27 = (KFunction)((<undefinedtype>)var17).L$1;
         var12 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var10 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var13);
         var27 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxInt(var1);
         Timber.Forest var28 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("Attempting to doApiCall ");
         var23.append(var27);
         var23.append(", with ");
         var23.append(var8);
         var23.append(" on ");
         var23.append(this.clients.size());
         var23.append(" clients");
         var28.d(var23.toString(), new Object[0]);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         var22 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var27);
         var22.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         var9 = (Iterable)this.clients;
         Collection var31 = (Collection)(new ArrayList());

         for(Object var34 : var9) {
            if (var34 instanceof CanSetFan) {
               var31.add(var34);
            }
         }

         var9 = (Iterable)((List)var31);
         var11 = var9.iterator();
         var3 = 0;
         var12 = this;
         var4 = 0;
         var10 = var17;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var22.element).exceptionOrNull());
            return var22.element;
         }

         Object var19 = var11.next();
         var7 = (DeviceClient)var19;
         Function3 var36 = (Function3)var27;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var27;
         ((<undefinedtype>)var10).L$2 = var8;
         ((<undefinedtype>)var10).L$3 = var22;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$5 = var11;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var22;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         var13 = var36.invoke(var7, var8, var10);
         if (var13 == var15) {
            return var15;
         }

         var18 = var22;
      }

      while(true) {
         var22.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var7);
            var32.append(" gave good result ");
            var32.append(var18.element);
            var32.append(" for call ");
            var32.append(var27);
            var26.v(var32.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var25 = Timber.Forest;
         StringBuilder var37 = new StringBuilder("client ");
         var37.append(var7);
         var37.append(" gave failed result\n");
         var37.append(var18.element);
         var37.append(" for call \n");
         var37.append(var27);
         var37.append(", \nwith details:");
         var25.w(var37.toString(), new Object[0]);
         var22 = var18;
         if (!var11.hasNext()) {
            var12.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var11.next();
         var7 = (DeviceClient)var20;
         Function3 var38 = (Function3)var27;
         ((<undefinedtype>)var10).L$0 = var12;
         ((<undefinedtype>)var10).L$1 = var27;
         ((<undefinedtype>)var10).L$2 = var8;
         ((<undefinedtype>)var10).L$3 = var22;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$5 = var11;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var22;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         var13 = var38.invoke(var7, var8, var10);
         if (var13 == var15) {
            return var15;
         }

         var18 = var22;
      }
   }

   public final Object setFilterType(String var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setFilterType((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      Iterator var8;
      Iterable var9;
      ConnectionManager var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var23;
      String var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var8 = (Iterator)((<undefinedtype>)var22).L$6;
         var9 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (String)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var10 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (String)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var33 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var27 = var1;
         var29.append(var1);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var33.d(var29.toString(), new Object[0]);
         Timber.Forest var18 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var18.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanSetFilterType) {
               var32.add(var36);
            }
         }

         var9 = (Iterable)((List)var32);
         var8 = var9.iterator();
         var10 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var41 = var8.next();
         var11 = (DeviceClient)var41;
         Function3 var38 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var22).L$6 = var8;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var38.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var13 = var19;
         var1 = var27;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var21 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var11);
            var28.append(" gave good result ");
            var28.append(var23.element);
            var28.append(" for call ");
            var28.append(var6);
            var21.v(var28.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var11);
         var39.append(" gave failed result\n");
         var39.append(var23.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         String var37 = var1;
         Ref.ObjectRef var20 = var23;
         String var24 = var37;
         if (!var8.hasNext()) {
            var10.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var43 = var8.next();
         var11 = (DeviceClient)var43;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var10;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var7).L$6 = var8;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var40.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         String var44 = var24;
         var23 = var20;
         var13 = var20;
         var1 = var44;
      }
   }

   public final Object setG4NightMode(int var1, String var2, Continuation var3) {
      label66: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var25 = var7;
               break label66;
            }
         }

         var25 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setG4NightMode(0, (String)null, (Continuation)this);
            }
         };
      }

      CanSetG4NightMode var13 = (CanSetG4NightMode)((<undefinedtype>)var25).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var25).label;
      int var5;
      int var6;
      Object var8;
      ConnectionManager var9;
      Iterable var10;
      Iterator var11;
      Ref.ObjectRef var21;
      String var26;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var25).I$4;
         var1 = ((<undefinedtype>)var25).I$3;
         var1 = ((<undefinedtype>)var25).I$2;
         var4 = ((<undefinedtype>)var25).I$1;
         var5 = ((<undefinedtype>)var25).I$0;
         var21 = (Ref.ObjectRef)((<undefinedtype>)var25).L$8;
         CanSetG4NightMode var30 = (CanSetG4NightMode)((<undefinedtype>)var25).L$7;
         DeviceClient var12 = (DeviceClient)((<undefinedtype>)var25).L$6;
         var30 = (CanSetG4NightMode)((<undefinedtype>)var25).L$5;
         var11 = (Iterator)((<undefinedtype>)var25).L$4;
         var10 = (Iterable)((<undefinedtype>)var25).L$3;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var25).L$2;
         var9 = (ConnectionManager)((<undefinedtype>)var25).L$1;
         String var32 = (String)((<undefinedtype>)var25).L$0;
         ResultKt.throwOnFailure(var13);
         var6 = var1;
         var8 = var25;
         var21.element = (ApiResult)var13;
         if (((ApiResult)var14.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var22 = new StringBuilder("client ");
            var22.append(var12);
            var22.append(" gave good result ");
            var22.append(var14.element);
            var22.append(" for call");
            var33.v(var22.toString(), new Object[0]);
            return var14.element;
         }

         Timber.Forest var20 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var12);
         var45.append(" gave failed result\n");
         var45.append(var14.element);
         var45.append(" for call, \nwith details:");
         var20.w(var45.toString(), new Object[0]);
         var21 = var14;
         var26 = var32;
         var4 = var4;
      } else {
         ResultKt.throwOnFailure(var13);
         if (var1 < 0 || var1 >= 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }

         Ref.ObjectRef var34 = new Ref.ObjectRef();
         StringBuilder var38 = new StringBuilder("None of the clients in ");
         var38.append(this);
         var38.append(" is ");
         var38.append(Reflection.getOrCreateKotlinClass(CanSetG4NightMode.class).getQualifiedName());
         var34.element = new Failure((Throwable)(new UnknownError(var38.toString())));
         Iterable var40 = (Iterable)this.clients;
         Collection var39 = (Collection)(new ArrayList());

         for(Object var42 : var40) {
            if (var42 instanceof CanSetG4NightMode) {
               var39.add(var42);
            }
         }

         var10 = (Iterable)((List)var39);
         var11 = var10.iterator();
         var9 = this;
         String var43 = var2;
         var6 = 0;
         var4 = 0;
         var21 = var34;
         var8 = var25;
         var26 = var43;
         var5 = var1;
      }

      while(var11.hasNext()) {
         Object var35 = var11.next();
         DeviceClient var44 = (DeviceClient)var35;
         var13 = (CanSetG4NightMode)var44;
         ((<undefinedtype>)var8).L$0 = var26;
         ((<undefinedtype>)var8).L$1 = var9;
         ((<undefinedtype>)var8).L$2 = var21;
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$4 = var11;
         ((<undefinedtype>)var8).L$5 = SpillingKt.nullOutSpilledVariable(var35);
         ((<undefinedtype>)var8).L$6 = var44;
         ((<undefinedtype>)var8).L$7 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var8).L$8 = var21;
         ((<undefinedtype>)var8).I$0 = var5;
         ((<undefinedtype>)var8).I$1 = var4;
         ((<undefinedtype>)var8).I$2 = var6;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).I$4 = 0;
         ((<undefinedtype>)var8).label = 1;
         var13 = (CanSetG4NightMode)var13.setG4NightMode(var5, var26, (Continuation)var8);
         if (var13 == var15) {
            return var15;
         }

         String var36 = var26;
         Ref.ObjectRef var27 = var21;
         var21.element = (ApiResult)var13;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var37 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var44);
            var24.append(" gave good result ");
            var24.append(var27.element);
            var24.append(" for call");
            var37.v(var24.toString(), new Object[0]);
            return var27.element;
         }

         Timber.Forest var23 = Timber.Forest;
         StringBuilder var48 = new StringBuilder("client ");
         var48.append(var44);
         var48.append(" gave failed result\n");
         var48.append(var27.element);
         var48.append(" for call, \nwith details:");
         var23.w(var48.toString(), new Object[0]);
         var21 = var27;
         var26 = var36;
         var4 = var4;
      }

      var9.logApiError(((ApiResult)var21.element).exceptionOrNull());
      return var21.element;
   }

   public final Object setGermShieldMode(int var1, Continuation var2) {
      int var4;
      label72: {
         var4 = var1;
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var19 = var5;
               break label72;
            }
         }

         var19 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setGermShieldMode(0, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var19).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      var1 = ((<undefinedtype>)var19).label;
      int var3;
      Object var6;
      KFunction var7;
      Integer var8;
      Iterable var9;
      Iterator var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var20;
      ConnectionManager var23;
      if (var1 != 0) {
         if (var1 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var19).I$3;
         var3 = ((<undefinedtype>)var19).I$2;
         var1 = ((<undefinedtype>)var19).I$1;
         var4 = ((<undefinedtype>)var19).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var19).L$8;
         var11 = (DeviceClient)((<undefinedtype>)var19).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var19).L$6;
         var10 = (Iterator)((<undefinedtype>)var19).L$5;
         var9 = (Iterable)((<undefinedtype>)var19).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var19).L$3;
         var8 = (Integer)((<undefinedtype>)var19).L$2;
         var7 = (KFunction)((<undefinedtype>)var19).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var19).L$0;
         ResultKt.throwOnFailure(var12);
         var6 = var19;
         var20 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         if (var4 < 0 || var4 >= 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }

         var7 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxInt(var4);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var7);
         var29.append(", with ");
         var29.append(var8);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var7);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         var9 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var9) {
            if (var36 instanceof CanSetGermShieldMode) {
               var32.add(var36);
            }
         }

         var9 = (Iterable)((List)var32);
         var10 = var9.iterator();
         var3 = 0;
         var1 = 0;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var12 = var10.next();
         var11 = (DeviceClient)var12;
         Function3 var42 = (Function3)var7;
         ((<undefinedtype>)var19).L$0 = this;
         ((<undefinedtype>)var19).L$1 = var7;
         ((<undefinedtype>)var19).L$2 = var8;
         ((<undefinedtype>)var19).L$3 = var26;
         ((<undefinedtype>)var19).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var19).L$5 = var10;
         ((<undefinedtype>)var19).L$6 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var19).L$7 = var11;
         ((<undefinedtype>)var19).L$8 = var26;
         ((<undefinedtype>)var19).I$0 = var4;
         ((<undefinedtype>)var19).I$1 = var1;
         ((<undefinedtype>)var19).I$2 = var3;
         ((<undefinedtype>)var19).I$3 = 0;
         ((<undefinedtype>)var19).label = 1;
         var12 = var42.invoke(var11, var8, var19);
         if (var12 == var15) {
            return var15;
         }

         Object var45 = var19;
         var20 = var26;
         var13 = var26;
         var23 = this;
         var6 = var45;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var20.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var34 = new StringBuilder("client ");
            var34.append(var11);
            var34.append(" gave good result ");
            var34.append(var20.element);
            var34.append(" for call ");
            var34.append(var7);
            var28.v(var34.toString(), new Object[0]);
            return var20.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var43 = new StringBuilder("client ");
         var43.append(var11);
         var43.append(" gave failed result\n");
         var43.append(var20.element);
         var43.append(" for call \n");
         var43.append(var7);
         var43.append(", \nwith details:");
         var40.w(var43.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var20;
         Object var21 = var6;
         ConnectionManager var33 = var38;
         if (!var10.hasNext()) {
            var38.logApiError(((ApiResult)var27.element).exceptionOrNull());
            return var27.element;
         }

         Object var41 = var10.next();
         var11 = (DeviceClient)var41;
         Function3 var44 = (Function3)var7;
         ((<undefinedtype>)var21).L$0 = var33;
         ((<undefinedtype>)var21).L$1 = var7;
         ((<undefinedtype>)var21).L$2 = var8;
         ((<undefinedtype>)var21).L$3 = var27;
         ((<undefinedtype>)var21).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var21).L$5 = var10;
         ((<undefinedtype>)var21).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var21).L$7 = var11;
         ((<undefinedtype>)var21).L$8 = var27;
         ((<undefinedtype>)var21).I$0 = var4;
         ((<undefinedtype>)var21).I$1 = var1;
         ((<undefinedtype>)var21).I$2 = var3;
         ((<undefinedtype>)var21).I$3 = 0;
         ((<undefinedtype>)var21).label = 1;
         var12 = var44.invoke(var11, var8, var21);
         if (var12 == var15) {
            return var15;
         }

         Object var46 = var21;
         var20 = var27;
         var13 = var27;
         var23 = var33;
         var6 = var46;
      }
   }

   public final Object setGermShieldNightMode(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var17 = var6;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setGermShieldNightMode(false, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var17).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var5;
      DeviceClient var8;
      Iterator var9;
      Object var10;
      Iterable var11;
      ConnectionManager var12;
      Boolean var13;
      Ref.ObjectRef var18;
      Ref.ObjectRef var24;
      KFunction var29;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var5 = ((<undefinedtype>)var17).I$0;
         var1 = ((<undefinedtype>)var17).Z$0;
         var24 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var17).L$7;
         Object var7 = ((<undefinedtype>)var17).L$6;
         var9 = (Iterator)((<undefinedtype>)var17).L$5;
         var11 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var13 = (Boolean)((<undefinedtype>)var17).L$2;
         var29 = (KFunction)((<undefinedtype>)var17).L$1;
         var12 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var14);
         var10 = var17;
         var18 = var15;
      } else {
         ResultKt.throwOnFailure(var14);
         var29 = (KFunction)null.INSTANCE;
         var13 = Boxing.boxBoolean(var1);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Attempting to doApiCall ");
         var25.append(var29);
         var25.append(", with ");
         var25.append(var13);
         var25.append(" on ");
         var25.append(this.clients.size());
         var25.append(" clients");
         var30.d(var25.toString(), new Object[0]);
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var31 = new StringBuilder("Client info: ");
         var31.append(this.clients);
         var26.v(var31.toString(), new Object[0]);
         var24 = new Ref.ObjectRef();
         var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var29);
         var24.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var33 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetGermShieldMode) {
               var33.add(var35);
            }
         }

         var11 = (Iterable)((List)var33);
         var9 = var11.iterator();
         byte var4 = 0;
         var12 = this;
         var3 = 0;
         var10 = var17;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var24.element).exceptionOrNull());
            return var24.element;
         }

         var14 = var9.next();
         var8 = (DeviceClient)var14;
         Function3 var19 = (Function3)var29;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var29;
         ((<undefinedtype>)var10).L$2 = var13;
         ((<undefinedtype>)var10).L$3 = var24;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var10).L$5 = var9;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var10).L$7 = var8;
         ((<undefinedtype>)var10).L$8 = var24;
         ((<undefinedtype>)var10).Z$0 = var1;
         ((<undefinedtype>)var10).I$0 = var3;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = 0;
         ((<undefinedtype>)var10).label = 1;
         var14 = var19.invoke(var8, var13, var10);
         if (var14 == var16) {
            return var16;
         }

         var18 = var24;
         var5 = var3;
         var3 = var4;
      }

      while(true) {
         var24.element = var14;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var36 = new StringBuilder("client ");
            var36.append(var8);
            var36.append(" gave good result ");
            var36.append(var18.element);
            var36.append(" for call ");
            var36.append(var29);
            var28.v(var36.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var39 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("client ");
         var27.append(var8);
         var27.append(" gave failed result\n");
         var27.append(var18.element);
         var27.append(" for call \n");
         var27.append(var29);
         var27.append(", \nwith details:");
         var39.w(var27.toString(), new Object[0]);
         var24 = var18;
         if (!var9.hasNext()) {
            var12.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var40 = var9.next();
         var8 = (DeviceClient)var40;
         Function3 var20 = (Function3)var29;
         ((<undefinedtype>)var10).L$0 = var12;
         ((<undefinedtype>)var10).L$1 = var29;
         ((<undefinedtype>)var10).L$2 = var13;
         ((<undefinedtype>)var10).L$3 = var24;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var10).L$5 = var9;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var10).L$7 = var8;
         ((<undefinedtype>)var10).L$8 = var24;
         ((<undefinedtype>)var10).Z$0 = var1;
         ((<undefinedtype>)var10).I$0 = var5;
         ((<undefinedtype>)var10).I$1 = var3;
         ((<undefinedtype>)var10).I$2 = 0;
         ((<undefinedtype>)var10).label = 1;
         var14 = var20.invoke(var8, var13, var10);
         if (var14 == var16) {
            return var16;
         }

         var18 = var24;
         var5 = var5;
         var3 = var3;
      }
   }

   public final Object setHeatAutoTmp(double var1, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var3;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var17 = var6;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var3) {
            double D$0;
            int I$0;
            int I$1;
            int I$2;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHeatAutoTmp((double)0.0F, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var17).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var17).label;
      int var5;
      DeviceClient var7;
      Iterable var8;
      ConnectionManager var9;
      Object var10;
      Iterator var11;
      Double var12;
      Ref.ObjectRef var14;
      KFunction var18;
      Ref.ObjectRef var25;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var4 = ((<undefinedtype>)var17).I$2;
         var5 = ((<undefinedtype>)var17).I$1;
         var4 = ((<undefinedtype>)var17).I$0;
         var1 = ((<undefinedtype>)var17).D$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         Object var23 = ((<undefinedtype>)var17).L$6;
         var11 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var12 = (Double)((<undefinedtype>)var17).L$2;
         KFunction var24 = (KFunction)((<undefinedtype>)var17).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var15);
         var10 = var17;
         var18 = var24;
         var25 = var13;
      } else {
         ResultKt.throwOnFailure(var15);
         KFunction var40 = (KFunction)null.INSTANCE;
         var12 = Boxing.boxDouble(var1);
         Timber.Forest var31 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("Attempting to doApiCall ");
         var26.append(var40);
         var26.append(", with ");
         var26.append(var12);
         var26.append(" on ");
         var26.append(this.clients.size());
         var26.append(" clients");
         var31.d(var26.toString(), new Object[0]);
         Timber.Forest var27 = Timber.Forest;
         StringBuilder var32 = new StringBuilder("Client info: ");
         var32.append(this.clients);
         var27.v(var32.toString(), new Object[0]);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         var32 = new StringBuilder("None of the clients in ");
         var32.append(this);
         var32.append(" could call ");
         var32.append(var40);
         var28.element = new Failure((Throwable)(new UnknownError(var32.toString())));
         var8 = (Iterable)this.clients;
         Collection var34 = (Collection)(new ArrayList());

         for(Object var36 : var8) {
            if (var36 instanceof CanSetMainMode) {
               var34.add(var36);
            }
         }

         var8 = (Iterable)((List)var34);
         var11 = var8.iterator();
         var5 = 0;
         var4 = 0;
         var9 = this;
         Object var42 = var17;
         Ref.ObjectRef var19 = var28;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var28.element).exceptionOrNull());
            return var28.element;
         }

         Object var45 = var11.next();
         var7 = (DeviceClient)var45;
         Function3 var29 = (Function3)var40;
         ((<undefinedtype>)var42).L$0 = this;
         ((<undefinedtype>)var42).L$1 = var40;
         ((<undefinedtype>)var42).L$2 = var12;
         ((<undefinedtype>)var42).L$3 = var19;
         ((<undefinedtype>)var42).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var42).L$5 = var11;
         ((<undefinedtype>)var42).L$6 = SpillingKt.nullOutSpilledVariable(var45);
         ((<undefinedtype>)var42).L$7 = var7;
         ((<undefinedtype>)var42).L$8 = var19;
         ((<undefinedtype>)var42).D$0 = var1;
         ((<undefinedtype>)var42).I$0 = var4;
         ((<undefinedtype>)var42).I$1 = var5;
         ((<undefinedtype>)var42).I$2 = 0;
         ((<undefinedtype>)var42).label = 1;
         var15 = var29.invoke(var7, var12, var42);
         if (var15 == var16) {
            return var16;
         }

         var25 = var19;
         var14 = var19;
         var18 = var40;
         var10 = var42;
      }

      while(true) {
         var14.element = var15;
         if (((ApiResult)var25.element).isSuccess()) {
            Timber.Forest var37 = Timber.Forest;
            StringBuilder var39 = new StringBuilder("client ");
            var39.append(var7);
            var39.append(" gave good result ");
            var39.append(var25.element);
            var39.append(" for call ");
            var39.append(var18);
            var37.v(var39.toString(), new Object[0]);
            return var25.element;
         }

         Timber.Forest var46 = Timber.Forest;
         StringBuilder var43 = new StringBuilder("client ");
         var43.append(var7);
         var43.append(" gave failed result\n");
         var43.append(var25.element);
         var43.append(" for call \n");
         var43.append(var18);
         var43.append(", \nwith details:");
         var46.w(var43.toString(), new Object[0]);
         Object var44 = var10;
         KFunction var41 = var18;
         Ref.ObjectRef var20 = var25;
         if (!var11.hasNext()) {
            var9.logApiError(((ApiResult)var25.element).exceptionOrNull());
            return var25.element;
         }

         Object var47 = var11.next();
         var7 = (DeviceClient)var47;
         Function3 var30 = (Function3)var41;
         ((<undefinedtype>)var44).L$0 = var9;
         ((<undefinedtype>)var44).L$1 = var41;
         ((<undefinedtype>)var44).L$2 = var12;
         ((<undefinedtype>)var44).L$3 = var20;
         ((<undefinedtype>)var44).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var44).L$5 = var11;
         ((<undefinedtype>)var44).L$6 = SpillingKt.nullOutSpilledVariable(var47);
         ((<undefinedtype>)var44).L$7 = var7;
         ((<undefinedtype>)var44).L$8 = var20;
         ((<undefinedtype>)var44).D$0 = var1;
         ((<undefinedtype>)var44).I$0 = var4;
         ((<undefinedtype>)var44).I$1 = var5;
         ((<undefinedtype>)var44).I$2 = 0;
         ((<undefinedtype>)var44).label = 1;
         var15 = var30.invoke(var7, var12, var44);
         if (var15 == var16) {
            return var16;
         }

         var25 = var20;
         var14 = var20;
         var18 = var41;
         var10 = var44;
      }
   }

   public final Object setHeatEcoTmp(double var1, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var3;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var17 = var6;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var3) {
            double D$0;
            int I$0;
            int I$1;
            int I$2;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHeatEcoTmp((double)0.0F, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var17).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var17).label;
      int var5;
      DeviceClient var7;
      Iterable var8;
      Object var9;
      ConnectionManager var10;
      Iterator var11;
      Double var13;
      Ref.ObjectRef var15;
      KFunction var18;
      Ref.ObjectRef var25;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var4 = ((<undefinedtype>)var17).I$2;
         var5 = ((<undefinedtype>)var17).I$1;
         var4 = ((<undefinedtype>)var17).I$0;
         var1 = ((<undefinedtype>)var17).D$0;
         var15 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         Object var23 = ((<undefinedtype>)var17).L$6;
         var11 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var13 = (Double)((<undefinedtype>)var17).L$2;
         KFunction var24 = (KFunction)((<undefinedtype>)var17).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = var17;
         var18 = var24;
         var25 = var12;
      } else {
         ResultKt.throwOnFailure(var14);
         KFunction var38 = (KFunction)null.INSTANCE;
         var13 = Boxing.boxDouble(var1);
         Timber.Forest var31 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("Attempting to doApiCall ");
         var26.append(var38);
         var26.append(", with ");
         var26.append(var13);
         var26.append(" on ");
         var26.append(this.clients.size());
         var26.append(" clients");
         var31.d(var26.toString(), new Object[0]);
         var31 = Timber.Forest;
         var26 = new StringBuilder("Client info: ");
         var26.append(this.clients);
         var31.v(var26.toString(), new Object[0]);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         StringBuilder var33 = new StringBuilder("None of the clients in ");
         var33.append(this);
         var33.append(" could call ");
         var33.append(var38);
         var28.element = new Failure((Throwable)(new UnknownError(var33.toString())));
         var8 = (Iterable)this.clients;
         Collection var34 = (Collection)(new ArrayList());

         for(Object var36 : var8) {
            if (var36 instanceof CanSetMainMode) {
               var34.add(var36);
            }
         }

         var8 = (Iterable)((List)var34);
         var11 = var8.iterator();
         var5 = 0;
         var4 = 0;
         var10 = this;
         Object var42 = var17;
         Ref.ObjectRef var19 = var28;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var28.element).exceptionOrNull());
            return var28.element;
         }

         var14 = var11.next();
         var7 = (DeviceClient)var14;
         Function3 var29 = (Function3)var38;
         ((<undefinedtype>)var42).L$0 = this;
         ((<undefinedtype>)var42).L$1 = var38;
         ((<undefinedtype>)var42).L$2 = var13;
         ((<undefinedtype>)var42).L$3 = var19;
         ((<undefinedtype>)var42).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var42).L$5 = var11;
         ((<undefinedtype>)var42).L$6 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var42).L$7 = var7;
         ((<undefinedtype>)var42).L$8 = var19;
         ((<undefinedtype>)var42).D$0 = var1;
         ((<undefinedtype>)var42).I$0 = var4;
         ((<undefinedtype>)var42).I$1 = var5;
         ((<undefinedtype>)var42).I$2 = 0;
         ((<undefinedtype>)var42).label = 1;
         var14 = var29.invoke(var7, var13, var42);
         if (var14 == var16) {
            return var16;
         }

         var25 = var19;
         var15 = var19;
         var18 = var38;
         var9 = var42;
      }

      while(true) {
         var15.element = var14;
         if (((ApiResult)var25.element).isSuccess()) {
            Timber.Forest var40 = Timber.Forest;
            StringBuilder var37 = new StringBuilder("client ");
            var37.append(var7);
            var37.append(" gave good result ");
            var37.append(var25.element);
            var37.append(" for call ");
            var37.append(var18);
            var40.v(var37.toString(), new Object[0]);
            return var25.element;
         }

         Timber.Forest var46 = Timber.Forest;
         StringBuilder var43 = new StringBuilder("client ");
         var43.append(var7);
         var43.append(" gave failed result\n");
         var43.append(var25.element);
         var43.append(" for call \n");
         var43.append(var18);
         var43.append(", \nwith details:");
         var46.w(var43.toString(), new Object[0]);
         Object var44 = var9;
         KFunction var39 = var18;
         Ref.ObjectRef var20 = var25;
         if (!var11.hasNext()) {
            var10.logApiError(((ApiResult)var25.element).exceptionOrNull());
            return var25.element;
         }

         Object var47 = var11.next();
         var7 = (DeviceClient)var47;
         Function3 var30 = (Function3)var39;
         ((<undefinedtype>)var44).L$0 = var10;
         ((<undefinedtype>)var44).L$1 = var39;
         ((<undefinedtype>)var44).L$2 = var13;
         ((<undefinedtype>)var44).L$3 = var20;
         ((<undefinedtype>)var44).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var44).L$5 = var11;
         ((<undefinedtype>)var44).L$6 = SpillingKt.nullOutSpilledVariable(var47);
         ((<undefinedtype>)var44).L$7 = var7;
         ((<undefinedtype>)var44).L$8 = var20;
         ((<undefinedtype>)var44).D$0 = var1;
         ((<undefinedtype>)var44).I$0 = var4;
         ((<undefinedtype>)var44).I$1 = var5;
         ((<undefinedtype>)var44).I$2 = 0;
         ((<undefinedtype>)var44).label = 1;
         var14 = var30.invoke(var7, var13, var44);
         if (var14 == var16) {
            return var16;
         }

         var25 = var20;
         var15 = var20;
         var18 = var39;
         var9 = var44;
      }
   }

   public final Object setHeatFanSpeed(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHeatFanSpeed(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      DeviceClient var7;
      ConnectionManager var8;
      Iterator var9;
      Integer var10;
      Object var11;
      Iterable var12;
      Ref.ObjectRef var18;
      Ref.ObjectRef var22;
      KFunction var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var22 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         Object var6 = ((<undefinedtype>)var17).L$6;
         var9 = (Iterator)((<undefinedtype>)var17).L$5;
         var12 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var10 = (Integer)((<undefinedtype>)var17).L$2;
         var27 = (KFunction)((<undefinedtype>)var17).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var11 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var13);
         var27 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxInt(var1);
         Timber.Forest var23 = Timber.Forest;
         StringBuilder var28 = new StringBuilder("Attempting to doApiCall ");
         var28.append(var27);
         var28.append(", with ");
         var28.append(var10);
         var28.append(" on ");
         var28.append(this.clients.size());
         var28.append(" clients");
         var23.d(var28.toString(), new Object[0]);
         Timber.Forest var24 = Timber.Forest;
         var28 = new StringBuilder("Client info: ");
         var28.append(this.clients);
         var24.v(var28.toString(), new Object[0]);
         var22 = new Ref.ObjectRef();
         var28 = new StringBuilder("None of the clients in ");
         var28.append(this);
         var28.append(" could call ");
         var28.append(var27);
         var22.element = new Failure((Throwable)(new UnknownError(var28.toString())));
         Iterable var32 = (Iterable)this.clients;
         Collection var31 = (Collection)(new ArrayList());

         for(Object var33 : var32) {
            if (var33 instanceof CanSetMainMode) {
               var31.add(var33);
            }
         }

         var12 = (Iterable)((List)var31);
         var9 = var12.iterator();
         var3 = 0;
         var8 = this;
         var4 = 0;
         var11 = var17;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var22.element).exceptionOrNull());
            return var22.element;
         }

         var13 = var9.next();
         var7 = (DeviceClient)var13;
         Function3 var19 = (Function3)var27;
         ((<undefinedtype>)var11).L$0 = this;
         ((<undefinedtype>)var11).L$1 = var27;
         ((<undefinedtype>)var11).L$2 = var10;
         ((<undefinedtype>)var11).L$3 = var22;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var11).L$5 = var9;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var22;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var4;
         ((<undefinedtype>)var11).I$2 = var3;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         var13 = var19.invoke(var7, var10, var11);
         if (var13 == var15) {
            return var15;
         }

         var18 = var22;
      }

      while(true) {
         var22.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var34 = new StringBuilder("client ");
            var34.append(var7);
            var34.append(" gave good result ");
            var34.append(var18.element);
            var34.append(" for call ");
            var34.append(var27);
            var26.v(var34.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var25 = Timber.Forest;
         StringBuilder var37 = new StringBuilder("client ");
         var37.append(var7);
         var37.append(" gave failed result\n");
         var37.append(var18.element);
         var37.append(" for call \n");
         var37.append(var27);
         var37.append(", \nwith details:");
         var25.w(var37.toString(), new Object[0]);
         var22 = var18;
         if (!var9.hasNext()) {
            var8.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var38 = var9.next();
         var7 = (DeviceClient)var38;
         Function3 var20 = (Function3)var27;
         ((<undefinedtype>)var11).L$0 = var8;
         ((<undefinedtype>)var11).L$1 = var27;
         ((<undefinedtype>)var11).L$2 = var10;
         ((<undefinedtype>)var11).L$3 = var22;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var11).L$5 = var9;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var38);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var22;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var4;
         ((<undefinedtype>)var11).I$2 = var3;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         var13 = var20.invoke(var7, var10, var11);
         if (var13 == var15) {
            return var15;
         }

         var18 = var22;
      }
   }

   public final Object setHeatSubMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHeatSubMode(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var8;
      Integer var10;
      ConnectionManager var11;
      Iterable var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = ((<undefinedtype>)var17).L$6;
         var8 = (Iterator)((<undefinedtype>)var17).L$5;
         var12 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var9 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var10 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var11 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var23 = var17;
         var18 = var9;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var10);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetMainMode) {
               var32.add(var36);
            }
         }

         var12 = (Iterable)((List)var32);
         var8 = var12.iterator();
         var4 = 0;
         var11 = this;
         var3 = 0;
         Object var37 = var17;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var19 = var8.next();
         var7 = (DeviceClient)var19;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var10;
         ((<undefinedtype>)var37).L$3 = var26;
         ((<undefinedtype>)var37).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var37).L$5 = var8;
         ((<undefinedtype>)var37).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var37).L$7 = var7;
         ((<undefinedtype>)var37).L$8 = var26;
         ((<undefinedtype>)var37).I$0 = var1;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = var4;
         ((<undefinedtype>)var37).I$3 = 0;
         ((<undefinedtype>)var37).label = 1;
         var13 = var40.invoke(var7, var10, var37);
         if (var13 == var15) {
            return var15;
         }

         var18 = var26;
         var14 = var26;
         var23 = var37;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var7);
            var35.append(" gave good result ");
            var35.append(var18.element);
            var35.append(" for call ");
            var35.append(var6);
            var28.v(var35.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var38 = new StringBuilder("client ");
         var38.append(var7);
         var38.append(" gave failed result\n");
         var38.append(var18.element);
         var38.append(" for call \n");
         var38.append(var6);
         var38.append(", \nwith details:");
         var41.w(var38.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var8.hasNext()) {
            var11.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var8.next();
         var7 = (DeviceClient)var20;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var11;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var10;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var39).L$5 = var8;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).I$0 = var1;
         ((<undefinedtype>)var39).I$1 = var3;
         ((<undefinedtype>)var39).I$2 = var4;
         ((<undefinedtype>)var39).I$3 = 0;
         ((<undefinedtype>)var39).label = 1;
         var13 = var42.invoke(var7, var10, var39);
         if (var13 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var23 = var39;
      }
   }

   public final Object setHinsMode(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHinsMode(false, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Object var8;
      Iterator var9;
      Iterable var10;
      Boolean var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var17;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var3 = ((<undefinedtype>)var16).I$1;
         var4 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$6;
         var9 = (Iterator)((<undefinedtype>)var16).L$5;
         var10 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var11 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var12);
         var8 = var16;
         var17 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         var11 = Boxing.boxBoolean(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var11);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetHinsMode) {
               var32.add(var36);
            }
         }

         var10 = (Iterable)((List)var32);
         var9 = var10.iterator();
         var3 = 0;
         var4 = 0;
         var8 = var16;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var9.next();
         var7 = (DeviceClient)var18;
         Function3 var39 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var11;
         ((<undefinedtype>)var8).L$3 = var26;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$5 = var9;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var26;
         ((<undefinedtype>)var8).Z$0 = var1;
         ((<undefinedtype>)var8).I$0 = var4;
         ((<undefinedtype>)var8).I$1 = var3;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         Object var42 = var39.invoke(var7, var11, var8);
         if (var42 == var15) {
            return var15;
         }

         var17 = var26;
         var13 = var26;
         var23 = this;
         var12 = var42;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var37 = new StringBuilder("client ");
         var37.append(var7);
         var37.append(" gave failed result\n");
         var37.append(var17.element);
         var37.append(" for call \n");
         var37.append(var6);
         var37.append(", \nwith details:");
         var40.w(var37.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var9.hasNext()) {
            var38.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var9.next();
         var7 = (DeviceClient)var19;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = var38;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var11;
         ((<undefinedtype>)var8).L$3 = var27;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$5 = var9;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var27;
         ((<undefinedtype>)var8).Z$0 = var1;
         ((<undefinedtype>)var8).I$0 = var4;
         ((<undefinedtype>)var8).I$1 = var3;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         Object var43 = var41.invoke(var7, var11, var8);
         if (var43 == var15) {
            return var15;
         }

         var17 = var27;
         var13 = var27;
         var23 = var38;
         var12 = var43;
      }
   }

   public final Object setHinsNightMode(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHinsNightMode(false, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Object var8;
      Boolean var9;
      Iterable var10;
      Iterator var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var17;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var3 = ((<undefinedtype>)var16).I$1;
         var4 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$6;
         var11 = (Iterator)((<undefinedtype>)var16).L$5;
         var10 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var9 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var13);
         var8 = var16;
         var17 = var12;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxBoolean(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var9);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         var29 = Timber.Forest;
         var24 = new StringBuilder("Client info: ");
         var24.append(this.clients);
         var29.v(var24.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var33) {
            if (var34 instanceof CanSetHinsMode) {
               var32.add(var34);
            }
         }

         var10 = (Iterable)((List)var32);
         var11 = var10.iterator();
         var3 = 0;
         var4 = 0;
         var8 = var16;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var13 = var11.next();
         var7 = (DeviceClient)var13;
         Function3 var18 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var9;
         ((<undefinedtype>)var8).L$3 = var26;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$5 = var11;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var26;
         ((<undefinedtype>)var8).Z$0 = var1;
         ((<undefinedtype>)var8).I$0 = var4;
         ((<undefinedtype>)var8).I$1 = var3;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         var13 = var18.invoke(var7, var9, var8);
         if (var13 == var15) {
            return var15;
         }

         var17 = var26;
         var14 = var26;
         var23 = this;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var7);
            var35.append(" gave good result ");
            var35.append(var17.element);
            var35.append(" for call ");
            var35.append(var6);
            var28.v(var35.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var7);
         var40.append(" gave failed result\n");
         var40.append(var17.element);
         var40.append(" for call \n");
         var40.append(var6);
         var40.append(", \nwith details:");
         var37.w(var40.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var11.hasNext()) {
            var38.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var41 = var11.next();
         var7 = (DeviceClient)var41;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = var38;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var9;
         ((<undefinedtype>)var8).L$3 = var27;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$5 = var11;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var27;
         ((<undefinedtype>)var8).Z$0 = var1;
         ((<undefinedtype>)var8).I$0 = var4;
         ((<undefinedtype>)var8).I$1 = var3;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         var13 = var19.invoke(var7, var9, var8);
         if (var13 == var15) {
            return var15;
         }

         var17 = var27;
         var14 = var27;
         var23 = var38;
      }
   }

   public final Object setHoverEnabled(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHoverEnabled(false, (Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var8;
      Boolean var9;
      ConnectionManager var11;
      Iterable var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var17;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var3 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = ((<undefinedtype>)var16).L$6;
         var8 = (Iterator)((<undefinedtype>)var16).L$5;
         var12 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var9 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var11 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var10);
         var23 = var16;
         var17 = var13;
      } else {
         ResultKt.throwOnFailure(var10);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxBoolean(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var9);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var33) {
            if (var34 instanceof CanSetHoverEnabled) {
               var32.add(var34);
            }
         }

         var12 = (Iterable)((List)var32);
         var8 = var12.iterator();
         var4 = 0;
         var11 = this;
         var3 = 0;
         var10 = var16;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var40 = var8.next();
         var7 = (DeviceClient)var40;
         Function3 var18 = (Function3)var6;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var6;
         ((<undefinedtype>)var10).L$2 = var9;
         ((<undefinedtype>)var10).L$3 = var26;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var10).L$5 = var8;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var26;
         ((<undefinedtype>)var10).Z$0 = var1;
         ((<undefinedtype>)var10).I$0 = var3;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = 0;
         ((<undefinedtype>)var10).label = 1;
         var40 = var18.invoke(var7, var9, var10);
         if (var40 == var15) {
            return var15;
         }

         var17 = var26;
         var14 = var26;
         var23 = var10;
         var10 = var40;
      }

      while(true) {
         var14.element = var10;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var38 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var7);
         var42.append(" gave failed result\n");
         var42.append(var17.element);
         var42.append(" for call \n");
         var42.append(var6);
         var42.append(", \nwith details:");
         var38.w(var42.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var8.hasNext()) {
            var11.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var43 = var8.next();
         var7 = (DeviceClient)var43;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var11;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var9;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var39).L$5 = var8;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).Z$0 = var1;
         ((<undefinedtype>)var39).I$0 = var3;
         ((<undefinedtype>)var39).I$1 = var4;
         ((<undefinedtype>)var39).I$2 = 0;
         ((<undefinedtype>)var39).label = 1;
         var43 = var19.invoke(var7, var9, var39);
         if (var43 == var15) {
            return var15;
         }

         var17 = var27;
         var14 = var27;
         var23 = var39;
         var10 = var43;
      }
   }

   public final Object setHumMode(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHumMode(false, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Boolean var8;
      Object var9;
      Iterator var10;
      Iterable var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var17;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var3 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$6;
         var10 = (Iterator)((<undefinedtype>)var16).L$5;
         var11 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var8 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = (ConnectionManager)var16;
         var17 = var12;
      } else {
         ResultKt.throwOnFailure(var14);
         var6 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxBoolean(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var8);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var37 : var34) {
            if (var37 instanceof CanSetHumMode) {
               var32.add(var37);
            }
         }

         var11 = (Iterable)((List)var32);
         var10 = var11.iterator();
         var4 = 0;
         var3 = 0;
         Object var38 = var16;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var10.next();
         var7 = (DeviceClient)var18;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var38).L$0 = this;
         ((<undefinedtype>)var38).L$1 = var6;
         ((<undefinedtype>)var38).L$2 = var8;
         ((<undefinedtype>)var38).L$3 = var26;
         ((<undefinedtype>)var38).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var38).L$5 = var10;
         ((<undefinedtype>)var38).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var38).L$7 = var7;
         ((<undefinedtype>)var38).L$8 = var26;
         ((<undefinedtype>)var38).Z$0 = var1;
         ((<undefinedtype>)var38).I$0 = var3;
         ((<undefinedtype>)var38).I$1 = var4;
         ((<undefinedtype>)var38).I$2 = 0;
         ((<undefinedtype>)var38).label = 1;
         var14 = var41.invoke(var7, var8, var38);
         if (var14 == var15) {
            return var15;
         }

         var17 = var26;
         var13 = var26;
         var23 = this;
         var9 = (ConnectionManager)var38;
      }

      while(true) {
         var13.element = var14;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var33.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var39 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var7);
         var42.append(" gave failed result\n");
         var42.append(var17.element);
         var42.append(" for call \n");
         var42.append(var6);
         var42.append(", \nwith details:");
         var39.w(var42.toString(), new Object[0]);
         Object var40 = var9;
         var9 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var10.hasNext()) {
            var9.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var10.next();
         var7 = (DeviceClient)var19;
         Function3 var43 = (Function3)var6;
         ((<undefinedtype>)var40).L$0 = var9;
         ((<undefinedtype>)var40).L$1 = var6;
         ((<undefinedtype>)var40).L$2 = var8;
         ((<undefinedtype>)var40).L$3 = var27;
         ((<undefinedtype>)var40).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var40).L$5 = var10;
         ((<undefinedtype>)var40).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var40).L$7 = var7;
         ((<undefinedtype>)var40).L$8 = var27;
         ((<undefinedtype>)var40).Z$0 = var1;
         ((<undefinedtype>)var40).I$0 = var3;
         ((<undefinedtype>)var40).I$1 = var4;
         ((<undefinedtype>)var40).I$2 = 0;
         ((<undefinedtype>)var40).label = 1;
         var14 = var43.invoke(var7, var8, var40);
         if (var14 == var15) {
            return var15;
         }

         var17 = var27;
         var13 = var27;
         var23 = var9;
         var9 = (ConnectionManager)var40;
      }
   }

   public final Object setHumSubMode(int var1, boolean var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var18 = var7;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setHumSubMode(0, false, (Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var18).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var18).label;
      int var5;
      Iterable var10;
      Iterator var11;
      ConnectionManager var12;
      Ref.ObjectRef var19;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var18).I$4;
         var1 = ((<undefinedtype>)var18).I$3;
         var4 = ((<undefinedtype>)var18).I$2;
         int var6 = ((<undefinedtype>)var18).I$1;
         var2 = ((<undefinedtype>)var18).Z$0;
         var1 = ((<undefinedtype>)var18).I$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var18).L$7;
         CanSetHumSubMode var25 = (CanSetHumSubMode)((<undefinedtype>)var18).L$6;
         DeviceClient var8 = (DeviceClient)((<undefinedtype>)var18).L$5;
         var25 = (CanSetHumSubMode)((<undefinedtype>)var18).L$4;
         var11 = (Iterator)((<undefinedtype>)var18).L$3;
         var10 = (Iterable)((<undefinedtype>)var18).L$2;
         Ref.ObjectRef var27 = (Ref.ObjectRef)((<undefinedtype>)var18).L$1;
         var12 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var9);
         var13.element = (ApiResult)var9;
         if (((ApiResult)var27.element).isSuccess()) {
            Timber.Forest var20 = Timber.Forest;
            StringBuilder var36 = new StringBuilder("client ");
            var36.append(var8);
            var36.append(" gave good result ");
            var36.append(var27.element);
            var36.append(" for call");
            var20.v(var36.toString(), new Object[0]);
            return var27.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var34 = new StringBuilder("client ");
         var34.append(var8);
         var34.append(" gave failed result\n");
         var34.append(var27.element);
         var34.append(" for call, \nwith details:");
         var42.w(var34.toString(), new Object[0]);
         var9 = var18;
         var5 = var4;
         var4 = var6;
         var19 = var27;
      } else {
         ResultKt.throwOnFailure(var9);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" is ");
         var31.append(Reflection.getOrCreateKotlinClass(CanSetHumSubMode.class).getQualifiedName());
         var28.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var37 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var38 : var37) {
            if (var38 instanceof CanSetHumSubMode) {
               var32.add(var38);
            }
         }

         var10 = (Iterable)((List)var32);
         var11 = var10.iterator();
         var12 = this;
         var4 = 0;
         var9 = var18;
         var5 = 0;
         var19 = var28;
      }

      while(var11.hasNext()) {
         Object var29 = var11.next();
         DeviceClient var33 = (DeviceClient)var29;
         CanSetHumSubMode var43 = (CanSetHumSubMode)var33;
         ((<undefinedtype>)var9).L$0 = var12;
         ((<undefinedtype>)var9).L$1 = var19;
         ((<undefinedtype>)var9).L$2 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var9).L$3 = var11;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var29);
         ((<undefinedtype>)var9).L$5 = var33;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var43);
         ((<undefinedtype>)var9).L$7 = var19;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).Z$0 = var2;
         ((<undefinedtype>)var9).I$1 = var4;
         ((<undefinedtype>)var9).I$2 = var5;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).I$4 = 0;
         ((<undefinedtype>)var9).label = 1;
         Object var14 = var43.setHumSubMode(var1, var2, (Continuation)var9);
         if (var14 == var15) {
            return var15;
         }

         Ref.ObjectRef var30 = var19;
         Ref.ObjectRef var44 = var19;
         Object var21 = var9;
         var44.element = (ApiResult)var14;
         if (((ApiResult)var30.element).isSuccess()) {
            Timber.Forest var22 = Timber.Forest;
            StringBuilder var40 = new StringBuilder("client ");
            var40.append(var33);
            var40.append(" gave good result ");
            var40.append(var30.element);
            var40.append(" for call");
            var22.v(var40.toString(), new Object[0]);
            return var30.element;
         }

         Timber.Forest var45 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var33);
         var39.append(" gave failed result\n");
         var39.append(var30.element);
         var39.append(" for call, \nwith details:");
         var45.w(var39.toString(), new Object[0]);
         var9 = var21;
         var5 = var5;
         var4 = var4;
         var19 = var30;
      }

      var12.logApiError(((ApiResult)var19.element).exceptionOrNull());
      return var19.element;
   }

   public final Object setLinkedUid(String var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setLinkedUid((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      ConnectionManager var8;
      Iterator var9;
      Iterable var10;
      DeviceClient var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var23;
      String var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var9 = (Iterator)((<undefinedtype>)var22).L$6;
         var10 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (String)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var8 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (String)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var33 = new StringBuilder("Attempting to doApiCall ");
         var33.append(var6);
         var33.append(", with ");
         var27 = var1;
         var33.append(var1);
         var33.append(" on ");
         var33.append(this.clients.size());
         var33.append(" clients");
         var29.d(var33.toString(), new Object[0]);
         Timber.Forest var18 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var18.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanLinkWithAware) {
               var32.add(var36);
            }
         }

         var10 = (Iterable)((List)var32);
         var9 = var10.iterator();
         var8 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         var12 = var9.next();
         var11 = (DeviceClient)var12;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var22).L$6 = var9;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var41.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var13 = var19;
         var1 = var27;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var21 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var11);
            var28.append(" gave good result ");
            var28.append(var23.element);
            var28.append(" for call ");
            var28.append(var6);
            var21.v(var28.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var11);
         var39.append(" gave failed result\n");
         var39.append(var23.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         String var37 = var1;
         Ref.ObjectRef var20 = var23;
         String var24 = var37;
         if (!var9.hasNext()) {
            var8.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var40 = var9.next();
         var11 = (DeviceClient)var40;
         Function3 var43 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var8;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var7).L$6 = var9;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var43.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         String var44 = var24;
         var23 = var20;
         var13 = var20;
         var1 = var44;
      }
   }

   public final Object setMainMode(int var1, String var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var22 = var7;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setMainMode(0, (String)null, (Continuation)this);
            }
         };
      }

      CanSetMainMode var12 = (CanSetMainMode)((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var22).label;
      int var5;
      Object var9;
      String var10;
      Ref.ObjectRef var21;
      Iterator var23;
      Iterable var28;
      ConnectionManager var33;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var22).I$4;
         var1 = ((<undefinedtype>)var22).I$3;
         var5 = ((<undefinedtype>)var22).I$2;
         var1 = ((<undefinedtype>)var22).I$1;
         var4 = ((<undefinedtype>)var22).I$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$8;
         CanSetMainMode var19 = (CanSetMainMode)((<undefinedtype>)var22).L$7;
         DeviceClient var11 = (DeviceClient)((<undefinedtype>)var22).L$6;
         var19 = (CanSetMainMode)((<undefinedtype>)var22).L$5;
         Iterator var8 = (Iterator)((<undefinedtype>)var22).L$4;
         var28 = (Iterable)((<undefinedtype>)var22).L$3;
         var21 = (Ref.ObjectRef)((<undefinedtype>)var22).L$2;
         ConnectionManager var14 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var10 = (String)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var9 = var22;
         var13.element = (ApiResult)var12;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var24 = Timber.Forest;
            StringBuilder var29 = new StringBuilder("client ");
            var29.append(var11);
            var29.append(" gave good result ");
            var29.append(var21.element);
            var29.append(" for call");
            var24.v(var29.toString(), new Object[0]);
            return var21.element;
         }

         Timber.Forest var46 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var11);
         var41.append(" gave failed result\n");
         var41.append(var21.element);
         var41.append(" for call, \nwith details:");
         var46.w(var41.toString(), new Object[0]);
         int var6 = var4;
         var4 = var1;
         var1 = var6;
         var23 = var8;
         var33 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         Ref.ObjectRef var36 = new Ref.ObjectRef();
         StringBuilder var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" is ");
         var30.append(Reflection.getOrCreateKotlinClass(CanSetMainMode.class).getQualifiedName());
         var36.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var31 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetMainMode) {
               var31.add(var35);
            }
         }

         var28 = (Iterable)((List)var31);
         Iterator var38 = var28.iterator();
         var33 = this;
         var4 = 0;
         Object var39 = var22;
         var5 = 0;
         String var42 = var2;
         var23 = var38;
         var21 = var36;
         var9 = var39;
         var10 = var42;
      }

      while(var23.hasNext()) {
         Object var47 = var23.next();
         DeviceClient var40 = (DeviceClient)var47;
         var12 = (CanSetMainMode)var40;
         ((<undefinedtype>)var9).L$0 = var10;
         ((<undefinedtype>)var9).L$1 = var33;
         ((<undefinedtype>)var9).L$2 = var21;
         ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var28);
         ((<undefinedtype>)var9).L$4 = var23;
         ((<undefinedtype>)var9).L$5 = SpillingKt.nullOutSpilledVariable(var47);
         ((<undefinedtype>)var9).L$6 = var40;
         ((<undefinedtype>)var9).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var9).L$8 = var21;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var4;
         ((<undefinedtype>)var9).I$2 = var5;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).I$4 = 0;
         ((<undefinedtype>)var9).label = 1;
         var12 = (CanSetMainMode)var12.setMainMode(var1, var10, (Continuation)var9);
         if (var12 == var15) {
            return var15;
         }

         var21.element = (ApiResult)var12;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var25 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var40);
            var32.append(" gave good result ");
            var32.append(var21.element);
            var32.append(" for call");
            var25.v(var32.toString(), new Object[0]);
            return var21.element;
         }

         Timber.Forest var48 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var40);
         var45.append(" gave failed result\n");
         var45.append(var21.element);
         var45.append(" for call, \nwith details:");
         var48.w(var45.toString(), new Object[0]);
         var4 = var4;
         var1 = var1;
         var23 = var23;
         var33 = var33;
      }

      var33.logApiError(((ApiResult)var21.element).exceptionOrNull());
      return var21.element;
   }

   public final Object setMode(int var1, String var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var23 = var7;
               break label43;
            }
         }

         var23 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setMode(0, (String)null, (Continuation)this);
            }
         };
      }

      CanSetMode var12 = (CanSetMode)((<undefinedtype>)var23).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var23).label;
      int var5;
      String var9;
      Object var10;
      Ref.ObjectRef var22;
      Iterator var24;
      Iterable var33;
      ConnectionManager var38;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var23).I$4;
         var1 = ((<undefinedtype>)var23).I$3;
         var5 = ((<undefinedtype>)var23).I$2;
         var1 = ((<undefinedtype>)var23).I$1;
         var4 = ((<undefinedtype>)var23).I$0;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var23).L$8;
         CanSetMode var20 = (CanSetMode)((<undefinedtype>)var23).L$7;
         DeviceClient var11 = (DeviceClient)((<undefinedtype>)var23).L$6;
         var20 = (CanSetMode)((<undefinedtype>)var23).L$5;
         Iterator var8 = (Iterator)((<undefinedtype>)var23).L$4;
         var33 = (Iterable)((<undefinedtype>)var23).L$3;
         var22 = (Ref.ObjectRef)((<undefinedtype>)var23).L$2;
         ConnectionManager var14 = (ConnectionManager)((<undefinedtype>)var23).L$1;
         var9 = (String)((<undefinedtype>)var23).L$0;
         ResultKt.throwOnFailure(var12);
         var10 = var23;
         var13.element = (ApiResult)var12;
         if (((ApiResult)var22.element).isSuccess()) {
            Timber.Forest var25 = Timber.Forest;
            StringBuilder var34 = new StringBuilder("client ");
            var34.append(var11);
            var34.append(" gave good result ");
            var34.append(var22.element);
            var34.append(" for call");
            var25.v(var34.toString(), new Object[0]);
            return var22.element;
         }

         Timber.Forest var47 = Timber.Forest;
         StringBuilder var52 = new StringBuilder("client ");
         var52.append(var11);
         var52.append(" gave failed result\n");
         var52.append(var22.element);
         var52.append(" for call, \nwith details:");
         var47.w(var52.toString(), new Object[0]);
         int var6 = var4;
         var4 = var1;
         var1 = var6;
         var24 = var8;
         var38 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         Ref.ObjectRef var42 = new Ref.ObjectRef();
         StringBuilder var35 = new StringBuilder("None of the clients in ");
         var35.append(this);
         var35.append(" is ");
         var35.append(Reflection.getOrCreateKotlinClass(CanSetMode.class).getQualifiedName());
         var42.element = new Failure((Throwable)(new UnknownError(var35.toString())));
         Iterable var39 = (Iterable)this.clients;
         Collection var36 = (Collection)(new ArrayList());

         for(Object var43 : var39) {
            if (var43 instanceof CanSetMode) {
               var36.add(var43);
            }
         }

         var33 = (Iterable)((List)var36);
         Iterator var48 = var33.iterator();
         var38 = this;
         var4 = 0;
         var10 = var23;
         var5 = 0;
         String var44 = var2;
         var24 = var48;
         var22 = var42;
         var9 = var44;
      }

      while(var24.hasNext()) {
         Object var53 = var24.next();
         DeviceClient var45 = (DeviceClient)var53;
         var12 = (CanSetMode)var45;
         ((<undefinedtype>)var10).L$0 = var9;
         ((<undefinedtype>)var10).L$1 = var38;
         ((<undefinedtype>)var10).L$2 = var22;
         ((<undefinedtype>)var10).L$3 = SpillingKt.nullOutSpilledVariable(var33);
         ((<undefinedtype>)var10).L$4 = var24;
         ((<undefinedtype>)var10).L$5 = SpillingKt.nullOutSpilledVariable(var53);
         ((<undefinedtype>)var10).L$6 = var45;
         ((<undefinedtype>)var10).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var10).L$8 = var22;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var5;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).I$4 = 0;
         ((<undefinedtype>)var10).label = 1;
         var12 = (CanSetMode)var12.setMode(var1, var9, (Continuation)var10);
         if (var12 == var15) {
            return var15;
         }

         ConnectionManager var54 = var38;
         Iterator var41 = var24;
         int var31 = var4;
         var4 = var1;
         ConnectionManager var26 = var54;
         var1 = var31;
         var22.element = (ApiResult)var12;
         if (((ApiResult)var22.element).isSuccess()) {
            Timber.Forest var27 = Timber.Forest;
            StringBuilder var37 = new StringBuilder("client ");
            var37.append(var45);
            var37.append(" gave good result ");
            var37.append(var22.element);
            var37.append(" for call");
            var27.v(var37.toString(), new Object[0]);
            return var22.element;
         }

         Timber.Forest var51 = Timber.Forest;
         StringBuilder var55 = new StringBuilder("client ");
         var55.append(var45);
         var55.append(" gave failed result\n");
         var55.append(var22.element);
         var55.append(" for call, \nwith details:");
         var51.w(var55.toString(), new Object[0]);
         var31 = var4;
         var4 = var1;
         ConnectionManager var46 = var26;
         var1 = var31;
         var24 = var41;
         var38 = var46;
      }

      var38.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object setNightLampBrightness(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setNightLampBrightness(0, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      ConnectionManager var8;
      Integer var9;
      Iterable var10;
      Iterator var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = ((<undefinedtype>)var17).L$6;
         var11 = (Iterator)((<undefinedtype>)var17).L$5;
         var10 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var9 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var13);
         var23 = var17;
         var18 = var12;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var9);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetNightLamp) {
               var32.add(var36);
            }
         }

         var10 = (Iterable)((List)var32);
         var11 = var10.iterator();
         var3 = 0;
         var8 = this;
         var4 = 0;
         Object var37 = var17;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var19 = var11.next();
         var7 = (DeviceClient)var19;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var9;
         ((<undefinedtype>)var37).L$3 = var26;
         ((<undefinedtype>)var37).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var37).L$5 = var11;
         ((<undefinedtype>)var37).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var37).L$7 = var7;
         ((<undefinedtype>)var37).L$8 = var26;
         ((<undefinedtype>)var37).I$0 = var1;
         ((<undefinedtype>)var37).I$1 = var4;
         ((<undefinedtype>)var37).I$2 = var3;
         ((<undefinedtype>)var37).I$3 = 0;
         ((<undefinedtype>)var37).label = 1;
         var13 = var40.invoke(var7, var9, var37);
         if (var13 == var15) {
            return var15;
         }

         var18 = var26;
         var14 = var26;
         var23 = var37;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var38 = new StringBuilder("client ");
         var38.append(var7);
         var38.append(" gave failed result\n");
         var38.append(var18.element);
         var38.append(" for call \n");
         var38.append(var6);
         var38.append(", \nwith details:");
         var41.w(var38.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var11.hasNext()) {
            var8.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var11.next();
         var7 = (DeviceClient)var20;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var8;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var9;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var39).L$5 = var11;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).I$0 = var1;
         ((<undefinedtype>)var39).I$1 = var4;
         ((<undefinedtype>)var39).I$2 = var3;
         ((<undefinedtype>)var39).I$3 = 0;
         ((<undefinedtype>)var39).label = 1;
         var13 = var42.invoke(var7, var9, var39);
         if (var13 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var23 = var39;
      }
   }

   public final Object setNightLampSteplessBrightness(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setNightLampSteplessBrightness(0, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterable var8;
      Iterator var9;
      ConnectionManager var10;
      Integer var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = ((<undefinedtype>)var17).L$6;
         var9 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var11 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var12);
         var23 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         var11 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var11);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         var8 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var8) {
            if (var36 instanceof CanSetNightLamp) {
               var32.add(var36);
            }
         }

         var8 = (Iterable)((List)var32);
         var9 = var8.iterator();
         var4 = 0;
         var10 = this;
         var3 = 0;
         var12 = var17;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var40 = var9.next();
         var7 = (DeviceClient)var40;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var12).L$0 = this;
         ((<undefinedtype>)var12).L$1 = var6;
         ((<undefinedtype>)var12).L$2 = var11;
         ((<undefinedtype>)var12).L$3 = var26;
         ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var12).L$5 = var9;
         ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var12).L$7 = var7;
         ((<undefinedtype>)var12).L$8 = var26;
         ((<undefinedtype>)var12).I$0 = var1;
         ((<undefinedtype>)var12).I$1 = var3;
         ((<undefinedtype>)var12).I$2 = var4;
         ((<undefinedtype>)var12).I$3 = 0;
         ((<undefinedtype>)var12).label = 1;
         Object var43 = var19.invoke(var7, var11, var12);
         if (var43 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = var12;
         var12 = var43;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var7);
            var35.append(" gave good result ");
            var35.append(var18.element);
            var35.append(" for call ");
            var35.append(var6);
            var28.v(var35.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var38 = new StringBuilder("client ");
         var38.append(var7);
         var38.append(" gave failed result\n");
         var38.append(var18.element);
         var38.append(" for call \n");
         var38.append(var6);
         var38.append(", \nwith details:");
         var41.w(var38.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var9.hasNext()) {
            var10.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var42 = var9.next();
         var7 = (DeviceClient)var42;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var10;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var11;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var39).L$5 = var9;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var42);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).I$0 = var1;
         ((<undefinedtype>)var39).I$1 = var3;
         ((<undefinedtype>)var39).I$2 = var4;
         ((<undefinedtype>)var39).I$3 = 0;
         ((<undefinedtype>)var39).label = 1;
         Object var44 = var20.invoke(var7, var11, var39);
         if (var44 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var39;
         var12 = var44;
      }
   }

   public final Object setOscillationMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setOscillationMode(0, (Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var16).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      Iterator var7;
      ConnectionManager var8;
      Iterable var9;
      Ref.ObjectRef var22;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var16).I$4;
         var1 = ((<undefinedtype>)var16).I$3;
         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var1 = ((<undefinedtype>)var16).I$0;
         Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var16).L$7;
         CanSetOscillation var20 = (CanSetOscillation)((<undefinedtype>)var16).L$6;
         DeviceClient var6 = (DeviceClient)((<undefinedtype>)var16).L$5;
         var20 = (CanSetOscillation)((<undefinedtype>)var16).L$4;
         var7 = (Iterator)((<undefinedtype>)var16).L$3;
         var9 = (Iterable)((<undefinedtype>)var16).L$2;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var16).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var10);
         var11.element = (ApiResult)var10;
         if (((ApiResult)var12.element).isSuccess()) {
            Timber.Forest var23 = Timber.Forest;
            StringBuilder var29 = new StringBuilder("client ");
            var29.append(var6);
            var29.append(" gave good result ");
            var29.append(var12.element);
            var29.append(" for call");
            var23.v(var29.toString(), new Object[0]);
            return var12.element;
         }

         Timber.Forest var34 = Timber.Forest;
         StringBuilder var37 = new StringBuilder("client ");
         var37.append(var6);
         var37.append(" gave failed result\n");
         var37.append(var12.element);
         var37.append(" for call, \nwith details:");
         var34.w(var37.toString(), new Object[0]);
         var10 = var16;
         var22 = var12;
      } else {
         ResultKt.throwOnFailure(var10);
         var22 = new Ref.ObjectRef();
         StringBuilder var26 = new StringBuilder("None of the clients in ");
         var26.append(this);
         var26.append(" is ");
         var26.append(Reflection.getOrCreateKotlinClass(CanSetOscillation.class).getQualifiedName());
         var22.element = new Failure((Throwable)(new UnknownError(var26.toString())));
         Iterable var30 = (Iterable)this.clients;
         Collection var27 = (Collection)(new ArrayList());

         for(Object var31 : var30) {
            if (var31 instanceof CanSetOscillation) {
               var27.add(var31);
            }
         }

         var9 = (Iterable)((List)var27);
         var7 = var9.iterator();
         var8 = this;
         var3 = 0;
         var4 = 0;
         var10 = var16;
      }

      while(var7.hasNext()) {
         Object var17 = var7.next();
         DeviceClient var28 = (DeviceClient)var17;
         CanSetOscillation var38 = (CanSetOscillation)var28;
         ((<undefinedtype>)var10).L$0 = var8;
         ((<undefinedtype>)var10).L$1 = var22;
         ((<undefinedtype>)var10).L$2 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$3 = var7;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var10).L$5 = var28;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var38);
         ((<undefinedtype>)var10).L$7 = var22;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).I$4 = 0;
         ((<undefinedtype>)var10).label = 1;
         Object var41 = var38.setOscillationMode(var1, (Continuation)var10);
         if (var41 == var13) {
            return var13;
         }

         Ref.ObjectRef var18 = var22;
         Ref.ObjectRef var39 = var22;
         Object var24 = var10;
         var39.element = (ApiResult)var41;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var25 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("client ");
            var32.append(var28);
            var32.append(" gave good result ");
            var32.append(var18.element);
            var32.append(" for call");
            var25.v(var32.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var36 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var28);
         var40.append(" gave failed result\n");
         var40.append(var18.element);
         var40.append(" for call, \nwith details:");
         var36.w(var40.toString(), new Object[0]);
         var10 = var24;
         var22 = var18;
      }

      var8.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object setOscillationParams(int var1, int var2, int var3, Continuation var4) {
      label43: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var8 = (<undefinedtype>)var4;
            if ((var8.label & Integer.MIN_VALUE) != 0) {
               var8.label += Integer.MIN_VALUE;
               var21 = var8;
               break label43;
            }
         }

         var21 = new ContinuationImpl(this, var4) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            int I$5;
            int I$6;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setOscillationParams(0, 0, 0, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var21).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var21).label;
      int var7;
      ConnectionManager var10;
      Iterable var11;
      Object var12;
      Iterator var13;
      Ref.ObjectRef var23;
      if (var5 != 0) {
         if (var5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var21).I$6;
         var1 = ((<undefinedtype>)var21).I$5;
         var7 = ((<undefinedtype>)var21).I$4;
         int var6 = ((<undefinedtype>)var21).I$3;
         var3 = ((<undefinedtype>)var21).I$2;
         var2 = ((<undefinedtype>)var21).I$1;
         var1 = ((<undefinedtype>)var21).I$0;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var21).L$7;
         CanSetOscillation var29 = (CanSetOscillation)((<undefinedtype>)var21).L$6;
         DeviceClient var9 = (DeviceClient)((<undefinedtype>)var21).L$5;
         var29 = (CanSetOscillation)((<undefinedtype>)var21).L$4;
         var13 = (Iterator)((<undefinedtype>)var21).L$3;
         var11 = (Iterable)((<undefinedtype>)var21).L$2;
         Ref.ObjectRef var31 = (Ref.ObjectRef)((<undefinedtype>)var21).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var21).L$0;
         ResultKt.throwOnFailure(var15);
         var12 = var21;
         var14.element = (ApiResult)var15;
         if (((ApiResult)var31.element).isSuccess()) {
            Timber.Forest var38 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var9);
            var24.append(" gave good result ");
            var24.append(var31.element);
            var24.append(" for call");
            var38.v(var24.toString(), new Object[0]);
            return var31.element;
         }

         Timber.Forest var43 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("client ");
         var22.append(var9);
         var22.append(" gave failed result\n");
         var22.append(var31.element);
         var22.append(" for call, \nwith details:");
         var43.w(var22.toString(), new Object[0]);
         var23 = var31;
         var5 = var3;
         var3 = var6;
      } else {
         ResultKt.throwOnFailure(var15);
         Ref.ObjectRef var32 = new Ref.ObjectRef();
         StringBuilder var35 = new StringBuilder("None of the clients in ");
         var35.append(this);
         var35.append(" is ");
         var35.append(Reflection.getOrCreateKotlinClass(CanSetOscillation.class).getQualifiedName());
         var32.element = new Failure((Throwable)(new UnknownError(var35.toString())));
         Iterable var39 = (Iterable)this.clients;
         Collection var36 = (Collection)(new ArrayList());

         for(Object var40 : var39) {
            if (var40 instanceof CanSetOscillation) {
               var36.add(var40);
            }
         }

         var11 = (Iterable)((List)var36);
         var13 = var11.iterator();
         var10 = this;
         var7 = 0;
         byte var28 = 0;
         var5 = var3;
         var12 = var21;
         var23 = var32;
         var3 = var28;
      }

      while(var13.hasNext()) {
         Object var33 = var13.next();
         DeviceClient var37 = (DeviceClient)var33;
         CanSetOscillation var44 = (CanSetOscillation)var37;
         ((<undefinedtype>)var12).L$0 = var10;
         ((<undefinedtype>)var12).L$1 = var23;
         ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var12).L$3 = var13;
         ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var33);
         ((<undefinedtype>)var12).L$5 = var37;
         ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var44);
         ((<undefinedtype>)var12).L$7 = var23;
         ((<undefinedtype>)var12).I$0 = var1;
         ((<undefinedtype>)var12).I$1 = var2;
         ((<undefinedtype>)var12).I$2 = var5;
         ((<undefinedtype>)var12).I$3 = var3;
         ((<undefinedtype>)var12).I$4 = var7;
         ((<undefinedtype>)var12).I$5 = 0;
         ((<undefinedtype>)var12).I$6 = 0;
         ((<undefinedtype>)var12).label = 1;
         var15 = var44.setOscillationParams(var1, var2, var5, (Continuation)var12);
         if (var15 == var16) {
            return var16;
         }

         Ref.ObjectRef var34 = var23;
         var23.element = (ApiResult)var15;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var41 = Timber.Forest;
            StringBuilder var26 = new StringBuilder("client ");
            var26.append(var37);
            var26.append(" gave good result ");
            var26.append(var34.element);
            var26.append(" for call");
            var41.v(var26.toString(), new Object[0]);
            return var34.element;
         }

         Timber.Forest var45 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("client ");
         var25.append(var37);
         var25.append(" gave failed result\n");
         var25.append(var34.element);
         var25.append(" for call, \nwith details:");
         var45.w(var25.toString(), new Object[0]);
         var23 = var34;
         var5 = var5;
         var3 = var3;
      }

      var10.logApiError(((ApiResult)var23.element).exceptionOrNull());
      return var23.element;
   }

   public final Object setOscillationState(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setOscillationState(0, (Continuation)this);
            }
         };
      }

      Object var22 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      DeviceClient var7;
      Object var8;
      ConnectionManager var9;
      Iterator var10;
      Integer var11;
      Iterable var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      KFunction var29;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         Object var6 = ((<undefinedtype>)var17).L$6;
         var10 = (Iterator)((<undefinedtype>)var17).L$5;
         var12 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var11 = (Integer)((<undefinedtype>)var17).L$2;
         var29 = (KFunction)((<undefinedtype>)var17).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var22);
         var8 = var17;
         var18 = var13;
      } else {
         ResultKt.throwOnFailure(var22);
         var29 = (KFunction)null.INSTANCE;
         var11 = Boxing.boxInt(var1);
         Timber.Forest var23 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Attempting to doApiCall ");
         var30.append(var29);
         var30.append(", with ");
         var30.append(var11);
         var30.append(" on ");
         var30.append(this.clients.size());
         var30.append(" clients");
         var23.d(var30.toString(), new Object[0]);
         var23 = Timber.Forest;
         var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var23.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var25 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var29);
         var25.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var33 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetOscillation) {
               var33.add(var35);
            }
         }

         var12 = (Iterable)((List)var33);
         var10 = var12.iterator();
         var3 = 0;
         var9 = this;
         var4 = 0;
         var8 = var17;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var25.element).exceptionOrNull());
            return var25.element;
         }

         Object var38 = var10.next();
         var7 = (DeviceClient)var38;
         Function3 var19 = (Function3)var29;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var29;
         ((<undefinedtype>)var8).L$2 = var11;
         ((<undefinedtype>)var8).L$3 = var25;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var8).L$5 = var10;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var38);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var25;
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).I$1 = var4;
         ((<undefinedtype>)var8).I$2 = var3;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).label = 1;
         var38 = var19.invoke(var7, var11, var8);
         if (var38 == var15) {
            return var15;
         }

         var18 = var25;
         var14 = var25;
         var22 = var38;
      }

      while(true) {
         var14.element = var22;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var36 = new StringBuilder("client ");
            var36.append(var7);
            var36.append(" gave good result ");
            var36.append(var18.element);
            var36.append(" for call ");
            var36.append(var29);
            var28.v(var36.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var40 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("client ");
         var26.append(var7);
         var26.append(" gave failed result\n");
         var26.append(var18.element);
         var26.append(" for call \n");
         var26.append(var29);
         var26.append(", \nwith details:");
         var40.w(var26.toString(), new Object[0]);
         Ref.ObjectRef var27 = var18;
         if (!var10.hasNext()) {
            var9.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var41 = var10.next();
         var7 = (DeviceClient)var41;
         Function3 var20 = (Function3)var29;
         ((<undefinedtype>)var8).L$0 = var9;
         ((<undefinedtype>)var8).L$1 = var29;
         ((<undefinedtype>)var8).L$2 = var11;
         ((<undefinedtype>)var8).L$3 = var27;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var8).L$5 = var10;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var27;
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).I$1 = var4;
         ((<undefinedtype>)var8).I$2 = var3;
         ((<undefinedtype>)var8).I$3 = 0;
         ((<undefinedtype>)var8).label = 1;
         var41 = var20.invoke(var7, var11, var8);
         if (var41 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var22 = var41;
      }
   }

   public final Object setPanelDisplayMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setPanelDisplayMode(0, (Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Integer var8;
      ConnectionManager var10;
      Iterator var11;
      Iterable var12;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = ((<undefinedtype>)var17).L$6;
         var11 = (Iterator)((<undefinedtype>)var17).L$5;
         var12 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var8 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var9);
         var23 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var9);
         var6 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var8);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetPanelDisplayMode) {
               var32.add(var35);
            }
         }

         var12 = (Iterable)((List)var32);
         var11 = var12.iterator();
         var4 = 0;
         var10 = this;
         var3 = 0;
         Object var36 = var17;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var19 = var11.next();
         var7 = (DeviceClient)var19;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var36).L$0 = this;
         ((<undefinedtype>)var36).L$1 = var6;
         ((<undefinedtype>)var36).L$2 = var8;
         ((<undefinedtype>)var36).L$3 = var26;
         ((<undefinedtype>)var36).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var36).L$5 = var11;
         ((<undefinedtype>)var36).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var36).L$7 = var7;
         ((<undefinedtype>)var36).L$8 = var26;
         ((<undefinedtype>)var36).I$0 = var1;
         ((<undefinedtype>)var36).I$1 = var3;
         ((<undefinedtype>)var36).I$2 = var4;
         ((<undefinedtype>)var36).I$3 = 0;
         ((<undefinedtype>)var36).label = 1;
         Object var43 = var40.invoke(var7, var8, var36);
         if (var43 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = var36;
         var9 = var43;
      }

      while(true) {
         var13.element = var9;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var33.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var7);
         var41.append(" gave failed result\n");
         var41.append(var18.element);
         var41.append(" for call \n");
         var41.append(var6);
         var41.append(", \nwith details:");
         var37.w(var41.toString(), new Object[0]);
         Object var38 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var11.hasNext()) {
            var10.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var11.next();
         var7 = (DeviceClient)var20;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var38).L$0 = var10;
         ((<undefinedtype>)var38).L$1 = var6;
         ((<undefinedtype>)var38).L$2 = var8;
         ((<undefinedtype>)var38).L$3 = var27;
         ((<undefinedtype>)var38).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var38).L$5 = var11;
         ((<undefinedtype>)var38).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var38).L$7 = var7;
         ((<undefinedtype>)var38).L$8 = var27;
         ((<undefinedtype>)var38).I$0 = var1;
         ((<undefinedtype>)var38).I$1 = var3;
         ((<undefinedtype>)var38).I$2 = var4;
         ((<undefinedtype>)var38).I$3 = 0;
         ((<undefinedtype>)var38).label = 1;
         Object var44 = var42.invoke(var7, var8, var38);
         if (var44 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var38;
         var9 = var44;
      }
   }

   public final Object setSensorMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setSensorMode(0, (Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var8;
      Iterable var9;
      Object var10;
      Integer var12;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var8 = (Iterator)((<undefinedtype>)var17).L$5;
         var9 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var12 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var11);
         var10 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var11);
         var6 = (KFunction)null.INSTANCE;
         var12 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var12);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetSensorMode) {
               var32.add(var36);
            }
         }

         var9 = (Iterable)((List)var32);
         var8 = var9.iterator();
         var3 = 0;
         var4 = 0;
         var10 = var17;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var39 = var8.next();
         var7 = (DeviceClient)var39;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var6;
         ((<undefinedtype>)var10).L$2 = var12;
         ((<undefinedtype>)var10).L$3 = var26;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$5 = var8;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var39);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var26;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         Object var42 = var19.invoke(var7, var12, var10);
         if (var42 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = this;
         var11 = var42;
      }

      while(true) {
         var13.element = var11;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var18.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var7);
         var40.append(" gave failed result\n");
         var40.append(var18.element);
         var40.append(" for call \n");
         var40.append(var6);
         var40.append(", \nwith details:");
         var37.w(var40.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var8.hasNext()) {
            var38.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var41 = var8.next();
         var7 = (DeviceClient)var41;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var10).L$0 = var38;
         ((<undefinedtype>)var10).L$1 = var6;
         ((<undefinedtype>)var10).L$2 = var12;
         ((<undefinedtype>)var10).L$3 = var27;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$5 = var8;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var27;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         Object var43 = var20.invoke(var7, var12, var10);
         if (var43 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var38;
         var11 = var43;
      }
   }

   public final Object setSmartSubMode(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setSmartSubMode(0, (Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Integer var8;
      Object var9;
      Iterable var10;
      Iterator var12;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var12 = (Iterator)((<undefinedtype>)var17).L$5;
         var10 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var8 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var11);
         var9 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var11);
         var6 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var8);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var35 : var34) {
            if (var35 instanceof CanSetSmartSubMode) {
               var32.add(var35);
            }
         }

         var10 = (Iterable)((List)var32);
         var12 = var10.iterator();
         var4 = 0;
         var3 = 0;
         var9 = var17;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var19 = var12.next();
         var7 = (DeviceClient)var19;
         Function3 var39 = (Function3)var6;
         ((<undefinedtype>)var9).L$0 = this;
         ((<undefinedtype>)var9).L$1 = var6;
         ((<undefinedtype>)var9).L$2 = var8;
         ((<undefinedtype>)var9).L$3 = var26;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var9).L$7 = var7;
         ((<undefinedtype>)var9).L$8 = var26;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = var4;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         Object var42 = var39.invoke(var7, var8, var9);
         if (var42 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = this;
         var11 = var42;
      }

      while(true) {
         var13.element = var11;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var33 = new StringBuilder("client ");
            var33.append(var7);
            var33.append(" gave good result ");
            var33.append(var18.element);
            var33.append(" for call ");
            var33.append(var6);
            var28.v(var33.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var7);
         var40.append(" gave failed result\n");
         var40.append(var18.element);
         var40.append(" for call \n");
         var40.append(var6);
         var40.append(", \nwith details:");
         var37.w(var40.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var12.hasNext()) {
            var38.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var12.next();
         var7 = (DeviceClient)var20;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var9).L$0 = var38;
         ((<undefinedtype>)var9).L$1 = var6;
         ((<undefinedtype>)var9).L$2 = var8;
         ((<undefinedtype>)var9).L$3 = var27;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var9).L$7 = var7;
         ((<undefinedtype>)var9).L$8 = var27;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = var4;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         Object var43 = var41.invoke(var7, var8, var9);
         if (var43 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var38;
         var11 = var43;
      }
   }

   public final Object setStandBy(int var1, String var2, Continuation var3) {
      label66: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var8 = (<undefinedtype>)var3;
            if ((var8.label & Integer.MIN_VALUE) != 0) {
               var8.label += Integer.MIN_VALUE;
               var26 = var8;
               break label66;
            }
         }

         var26 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setStandBy(0, (String)null, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var26).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var26).label;
      int var6;
      Object var9;
      Iterator var10;
      ConnectionManager var11;
      Iterable var12;
      Ref.ObjectRef var22;
      String var27;
      int var31;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var26).I$4;
         var1 = ((<undefinedtype>)var26).I$3;
         var1 = ((<undefinedtype>)var26).I$2;
         var31 = ((<undefinedtype>)var26).I$1;
         var4 = ((<undefinedtype>)var26).I$0;
         var22 = (Ref.ObjectRef)((<undefinedtype>)var26).L$8;
         CanSetStandBy var32 = (CanSetStandBy)((<undefinedtype>)var26).L$7;
         DeviceClient var13 = (DeviceClient)((<undefinedtype>)var26).L$6;
         var32 = (CanSetStandBy)((<undefinedtype>)var26).L$5;
         var10 = (Iterator)((<undefinedtype>)var26).L$4;
         var12 = (Iterable)((<undefinedtype>)var26).L$3;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var26).L$2;
         var11 = (ConnectionManager)((<undefinedtype>)var26).L$1;
         String var34 = (String)((<undefinedtype>)var26).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = var26;
         var22.element = (ApiResult)var14;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var23 = new StringBuilder("client ");
            var23.append(var13);
            var23.append(" gave good result ");
            var23.append(var15.element);
            var23.append(" for call");
            var35.v(var23.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var21 = Timber.Forest;
         StringBuilder var47 = new StringBuilder("client ");
         var47.append(var13);
         var47.append(" gave failed result\n");
         var47.append(var15.element);
         var47.append(" for call, \nwith details:");
         var21.w(var47.toString(), new Object[0]);
         var22 = var15;
         var27 = var34;
         var6 = var4;
         var4 = var1;
         var31 = var31;
      } else {
         ResultKt.throwOnFailure(var14);
         if (var1 < 0 || var1 >= 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }

         Ref.ObjectRef var36 = new Ref.ObjectRef();
         StringBuilder var40 = new StringBuilder("None of the clients in ");
         var40.append(this);
         var40.append(" is ");
         var40.append(Reflection.getOrCreateKotlinClass(CanSetStandBy.class).getQualifiedName());
         var36.element = new Failure((Throwable)(new UnknownError(var40.toString())));
         Iterable var42 = (Iterable)this.clients;
         Collection var41 = (Collection)(new ArrayList());

         for(Object var43 : var42) {
            if (var43 instanceof CanSetStandBy) {
               var41.add(var43);
            }
         }

         var12 = (Iterable)((List)var41);
         var10 = var12.iterator();
         var11 = this;
         String var45 = var2;
         var4 = 0;
         var31 = 0;
         var22 = var36;
         var9 = var26;
         var27 = var45;
         var6 = var1;
      }

      while(var10.hasNext()) {
         var14 = var10.next();
         DeviceClient var46 = (DeviceClient)var14;
         CanSetStandBy var37 = (CanSetStandBy)var46;
         ((<undefinedtype>)var9).L$0 = var27;
         ((<undefinedtype>)var9).L$1 = var11;
         ((<undefinedtype>)var9).L$2 = var22;
         ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var9).L$4 = var10;
         ((<undefinedtype>)var9).L$5 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var9).L$6 = var46;
         ((<undefinedtype>)var9).L$7 = SpillingKt.nullOutSpilledVariable(var37);
         ((<undefinedtype>)var9).L$8 = var22;
         ((<undefinedtype>)var9).I$0 = var6;
         ((<undefinedtype>)var9).I$1 = var31;
         ((<undefinedtype>)var9).I$2 = var4;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).I$4 = 0;
         ((<undefinedtype>)var9).label = 1;
         var14 = var37.setStandBy(var6, var27, (Continuation)var9);
         if (var14 == var16) {
            return var16;
         }

         String var38 = var27;
         Ref.ObjectRef var28 = var22;
         var22.element = (ApiResult)var14;
         if (((ApiResult)var22.element).isSuccess()) {
            Timber.Forest var39 = Timber.Forest;
            StringBuilder var25 = new StringBuilder("client ");
            var25.append(var46);
            var25.append(" gave good result ");
            var25.append(var28.element);
            var25.append(" for call");
            var39.v(var25.toString(), new Object[0]);
            return var28.element;
         }

         Timber.Forest var24 = Timber.Forest;
         StringBuilder var50 = new StringBuilder("client ");
         var50.append(var46);
         var50.append(" gave failed result\n");
         var50.append(var28.element);
         var50.append(" for call, \nwith details:");
         var24.w(var50.toString(), new Object[0]);
         var22 = var28;
         var27 = var38;
         var6 = var6;
         var4 = var4;
         var31 = var31;
      }

      var11.logApiError(((ApiResult)var22.element).exceptionOrNull());
      return var22.element;
   }

   public final Object setTare(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var1;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var15 = var5;
               break label43;
            }
         }

         var15 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setTare((Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var15).result;
      Object var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var15).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var8;
      ConnectionManager var10;
      Iterable var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var16;
      Object var23;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var15).I$2;
         var2 = ((<undefinedtype>)var15).I$1;
         var4 = ((<undefinedtype>)var15).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var15).L$7;
         var7 = (DeviceClient)((<undefinedtype>)var15).L$6;
         var23 = ((<undefinedtype>)var15).L$5;
         var8 = (Iterator)((<undefinedtype>)var15).L$4;
         var11 = (Iterable)((<undefinedtype>)var15).L$3;
         Ref.ObjectRef var9 = (Ref.ObjectRef)((<undefinedtype>)var15).L$2;
         var6 = (KFunction)((<undefinedtype>)var15).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var15).L$0;
         ResultKt.throwOnFailure(var12);
         var23 = var15;
         var16 = var9;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var33) {
            if (var36 instanceof CanSetTare) {
               var32.add(var36);
            }
         }

         var11 = (Iterable)((List)var32);
         var8 = var11.iterator();
         var10 = this;
         byte var3 = 0;
         var2 = 0;
         Object var37 = var15;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         var12 = var8.next();
         var7 = (DeviceClient)var12;
         Function2 var17 = (Function2)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var26;
         ((<undefinedtype>)var37).L$3 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var37).L$4 = var8;
         ((<undefinedtype>)var37).L$5 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var37).L$6 = var7;
         ((<undefinedtype>)var37).L$7 = var26;
         ((<undefinedtype>)var37).I$0 = var2;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var12 = var17.invoke(var7, var37);
         if (var12 == var14) {
            return var14;
         }

         var16 = var26;
         var13 = var26;
         var4 = var2;
         var2 = var3;
         var23 = var37;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var16.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var16.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var16.element;
         }

         Timber.Forest var38 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var7);
         var41.append(" gave failed result\n");
         var41.append(var16.element);
         var41.append(" for call \n");
         var41.append(var6);
         var41.append(", \nwith details:");
         var38.w(var41.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var16;
         if (!var8.hasNext()) {
            var10.logApiError(((ApiResult)var16.element).exceptionOrNull());
            return var16.element;
         }

         Object var42 = var8.next();
         var7 = (DeviceClient)var42;
         Function2 var18 = (Function2)var6;
         ((<undefinedtype>)var39).L$0 = var10;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var27;
         ((<undefinedtype>)var39).L$3 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var39).L$4 = var8;
         ((<undefinedtype>)var39).L$5 = SpillingKt.nullOutSpilledVariable(var42);
         ((<undefinedtype>)var39).L$6 = var7;
         ((<undefinedtype>)var39).L$7 = var27;
         ((<undefinedtype>)var39).I$0 = var4;
         ((<undefinedtype>)var39).I$1 = var2;
         ((<undefinedtype>)var39).I$2 = 0;
         ((<undefinedtype>)var39).label = 1;
         var12 = var18.invoke(var7, var39);
         if (var12 == var14) {
            return var14;
         }

         var16 = var27;
         var13 = var27;
         var4 = var4;
         var2 = var2;
         var23 = var39;
      }
   }

   public final Object setTemperatureUnit(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setTemperatureUnit(0, (Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterable var8;
      Object var9;
      Integer var10;
      Iterator var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var18;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var3 = ((<undefinedtype>)var17).I$2;
         var4 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$6;
         var12 = (Iterator)((<undefinedtype>)var17).L$5;
         var8 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var10 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var11);
         var9 = (ConnectionManager)var17;
         var18 = var13;
      } else {
         ResultKt.throwOnFailure(var11);
         var6 = (KFunction)null.INSTANCE;
         var10 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var10);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         var8 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var8) {
            if (var34 instanceof CanSetTemperatureUnit) {
               var32.add(var34);
            }
         }

         var8 = (Iterable)((List)var32);
         var12 = var8.iterator();
         var3 = 0;
         var4 = 0;
         var11 = var17;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var41 = var12.next();
         var7 = (DeviceClient)var41;
         Function3 var19 = (Function3)var6;
         ((<undefinedtype>)var11).L$0 = this;
         ((<undefinedtype>)var11).L$1 = var6;
         ((<undefinedtype>)var11).L$2 = var10;
         ((<undefinedtype>)var11).L$3 = var26;
         ((<undefinedtype>)var11).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var11).L$5 = var12;
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var41);
         ((<undefinedtype>)var11).L$7 = var7;
         ((<undefinedtype>)var11).L$8 = var26;
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).I$1 = var4;
         ((<undefinedtype>)var11).I$2 = var3;
         ((<undefinedtype>)var11).I$3 = 0;
         ((<undefinedtype>)var11).label = 1;
         var41 = var19.invoke(var7, var10, var11);
         if (var41 == var15) {
            return var15;
         }

         var18 = var26;
         var14 = var26;
         var23 = this;
         var9 = (ConnectionManager)var11;
         var11 = var41;
      }

      while(true) {
         var14.element = var11;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var7);
            var35.append(" gave good result ");
            var35.append(var18.element);
            var35.append(" for call ");
            var35.append(var6);
            var28.v(var35.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var43 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var7);
         var39.append(" gave failed result\n");
         var39.append(var18.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var43.w(var39.toString(), new Object[0]);
         Object var40 = var9;
         var9 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var12.hasNext()) {
            var9.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var44 = var12.next();
         var7 = (DeviceClient)var44;
         Function3 var20 = (Function3)var6;
         ((<undefinedtype>)var40).L$0 = var9;
         ((<undefinedtype>)var40).L$1 = var6;
         ((<undefinedtype>)var40).L$2 = var10;
         ((<undefinedtype>)var40).L$3 = var27;
         ((<undefinedtype>)var40).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var40).L$5 = var12;
         ((<undefinedtype>)var40).L$6 = SpillingKt.nullOutSpilledVariable(var44);
         ((<undefinedtype>)var40).L$7 = var7;
         ((<undefinedtype>)var40).L$8 = var27;
         ((<undefinedtype>)var40).I$0 = var1;
         ((<undefinedtype>)var40).I$1 = var4;
         ((<undefinedtype>)var40).I$2 = var3;
         ((<undefinedtype>)var40).I$3 = 0;
         ((<undefinedtype>)var40).label = 1;
         var44 = var20.invoke(var7, var10, var40);
         if (var44 == var15) {
            return var15;
         }

         var18 = var27;
         var14 = var27;
         var23 = var9;
         var9 = (ConnectionManager)var40;
         var11 = var44;
      }
   }

   public final Object setTimerDuration(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var18 = var6;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setTimerDuration(0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var18).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var18).label;
      int var4;
      KFunction var7;
      DeviceClient var8;
      Object var9;
      Iterable var10;
      Integer var11;
      Iterator var12;
      Ref.ObjectRef var15;
      Ref.ObjectRef var19;
      ConnectionManager var25;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var18).I$3;
         var3 = ((<undefinedtype>)var18).I$2;
         var4 = ((<undefinedtype>)var18).I$1;
         var1 = ((<undefinedtype>)var18).I$0;
         var15 = (Ref.ObjectRef)((<undefinedtype>)var18).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var18).L$7;
         var25 = (ConnectionManager)((<undefinedtype>)var18).L$6;
         var12 = (Iterator)((<undefinedtype>)var18).L$5;
         var10 = (Iterable)((<undefinedtype>)var18).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var18).L$3;
         var11 = (Integer)((<undefinedtype>)var18).L$2;
         var7 = (KFunction)((<undefinedtype>)var18).L$1;
         var25 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = var18;
         var19 = var13;
      } else {
         ResultKt.throwOnFailure(var14);
         var7 = (KFunction)null.INSTANCE;
         var11 = Boxing.boxInt(var1);
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var31 = new StringBuilder("Attempting to doApiCall ");
         var31.append(var7);
         var31.append(", with ");
         var31.append(var11);
         var31.append(" on ");
         var31.append(this.clients.size());
         var31.append(" clients");
         var26.d(var31.toString(), new Object[0]);
         Timber.Forest var32 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var32.v(var27.toString(), new Object[0]);
         Ref.ObjectRef var28 = new Ref.ObjectRef();
         StringBuilder var33 = new StringBuilder("None of the clients in ");
         var33.append(this);
         var33.append(" could call ");
         var33.append(var7);
         var28.element = new Failure((Throwable)(new UnknownError(var33.toString())));
         Iterable var35 = (Iterable)this.clients;
         Collection var34 = (Collection)(new ArrayList());

         for(Object var36 : var35) {
            if (var36 instanceof CanSetTimer) {
               var34.add(var36);
            }
         }

         var10 = (Iterable)((List)var34);
         var12 = var10.iterator();
         byte var5 = 0;
         var3 = 0;
         var9 = var18;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var28.element).exceptionOrNull());
            return var28.element;
         }

         Object var20 = var12.next();
         var8 = (DeviceClient)var20;
         Function3 var41 = (Function3)var7;
         ((<undefinedtype>)var9).L$0 = this;
         ((<undefinedtype>)var9).L$1 = var7;
         ((<undefinedtype>)var9).L$2 = var11;
         ((<undefinedtype>)var9).L$3 = var28;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var9).L$7 = var8;
         ((<undefinedtype>)var9).L$8 = var28;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = var5;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         var14 = var41.invoke(var8, var11, var9);
         if (var14 == var16) {
            return var16;
         }

         var19 = var28;
         var15 = var28;
         var4 = var3;
         var25 = this;
         var3 = var5;
      }

      while(true) {
         var15.element = var14;
         if (((ApiResult)var19.element).isSuccess()) {
            Timber.Forest var30 = Timber.Forest;
            StringBuilder var37 = new StringBuilder("client ");
            var37.append(var8);
            var37.append(" gave good result ");
            var37.append(var19.element);
            var37.append(" for call ");
            var37.append(var7);
            var30.v(var37.toString(), new Object[0]);
            return var19.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var8);
         var39.append(" gave failed result\n");
         var39.append(var19.element);
         var39.append(" for call \n");
         var39.append(var7);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         ConnectionManager var40 = var25;
         Ref.ObjectRef var29 = var19;
         if (!var12.hasNext()) {
            var40.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var21 = var12.next();
         var8 = (DeviceClient)var21;
         Function3 var43 = (Function3)var7;
         ((<undefinedtype>)var9).L$0 = var40;
         ((<undefinedtype>)var9).L$1 = var7;
         ((<undefinedtype>)var9).L$2 = var11;
         ((<undefinedtype>)var9).L$3 = var29;
         ((<undefinedtype>)var9).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var9).L$5 = var12;
         ((<undefinedtype>)var9).L$6 = SpillingKt.nullOutSpilledVariable(var21);
         ((<undefinedtype>)var9).L$7 = var8;
         ((<undefinedtype>)var9).L$8 = var29;
         ((<undefinedtype>)var9).I$0 = var1;
         ((<undefinedtype>)var9).I$1 = var4;
         ((<undefinedtype>)var9).I$2 = var3;
         ((<undefinedtype>)var9).I$3 = 0;
         ((<undefinedtype>)var9).label = 1;
         var14 = var43.invoke(var8, var11, var9);
         if (var14 == var16) {
            return var16;
         }

         var19 = var29;
         var15 = var29;
         var4 = var4;
         var25 = var40;
         var3 = var3;
      }
   }

   public final Object setTimerDurationAndStatus(int var1, int var2, Continuation var3) {
      label43: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var3;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var19 = var7;
               break label43;
            }
         }

         var19 = new ContinuationImpl(this, var3) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int I$4;
            int I$5;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setTimerDurationAndStatus(0, 0, (Continuation)this);
            }
         };
      }

      CanSetTimer var13 = (CanSetTimer)((<undefinedtype>)var19).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var19).label;
      int var5;
      Iterable var9;
      Object var10;
      ConnectionManager var11;
      Iterator var12;
      Ref.ObjectRef var21;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var19).I$5;
         var1 = ((<undefinedtype>)var19).I$4;
         var2 = ((<undefinedtype>)var19).I$3;
         int var6 = ((<undefinedtype>)var19).I$2;
         var4 = ((<undefinedtype>)var19).I$1;
         var1 = ((<undefinedtype>)var19).I$0;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var19).L$7;
         CanSetTimer var28 = (CanSetTimer)((<undefinedtype>)var19).L$6;
         DeviceClient var8 = (DeviceClient)((<undefinedtype>)var19).L$5;
         var28 = (CanSetTimer)((<undefinedtype>)var19).L$4;
         var12 = (Iterator)((<undefinedtype>)var19).L$3;
         var9 = (Iterable)((<undefinedtype>)var19).L$2;
         Ref.ObjectRef var30 = (Ref.ObjectRef)((<undefinedtype>)var19).L$1;
         var11 = (ConnectionManager)((<undefinedtype>)var19).L$0;
         ResultKt.throwOnFailure(var13);
         var10 = var19;
         var14.element = (ApiResult)var13;
         if (((ApiResult)var30.element).isSuccess()) {
            Timber.Forest var37 = Timber.Forest;
            StringBuilder var22 = new StringBuilder("client ");
            var22.append(var8);
            var22.append(" gave good result ");
            var22.append(var30.element);
            var22.append(" for call");
            var37.v(var22.toString(), new Object[0]);
            return var30.element;
         }

         Timber.Forest var20 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("client ");
         var42.append(var8);
         var42.append(" gave failed result\n");
         var42.append(var30.element);
         var42.append(" for call, \nwith details:");
         var20.w(var42.toString(), new Object[0]);
         var21 = var30;
         var5 = var4;
         var4 = var6;
      } else {
         ResultKt.throwOnFailure(var13);
         Ref.ObjectRef var31 = new Ref.ObjectRef();
         StringBuilder var34 = new StringBuilder("None of the clients in ");
         var34.append(this);
         var34.append(" is ");
         var34.append(Reflection.getOrCreateKotlinClass(CanSetTimer.class).getQualifiedName());
         var31.element = new Failure((Throwable)(new UnknownError(var34.toString())));
         var9 = (Iterable)this.clients;
         Collection var35 = (Collection)(new ArrayList());

         for(Object var39 : var9) {
            if (var39 instanceof CanSetTimer) {
               var35.add(var39);
            }
         }

         var9 = (Iterable)((List)var35);
         var12 = var9.iterator();
         var11 = this;
         var4 = 0;
         var10 = var19;
         byte var27 = 0;
         var5 = var2;
         var21 = var31;
         var2 = var27;
      }

      while(var12.hasNext()) {
         Object var32 = var12.next();
         DeviceClient var36 = (DeviceClient)var32;
         var13 = (CanSetTimer)var36;
         ((<undefinedtype>)var10).L$0 = var11;
         ((<undefinedtype>)var10).L$1 = var21;
         ((<undefinedtype>)var10).L$2 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$3 = var12;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var32);
         ((<undefinedtype>)var10).L$5 = var36;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var10).L$7 = var21;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var5;
         ((<undefinedtype>)var10).I$2 = var4;
         ((<undefinedtype>)var10).I$3 = var2;
         ((<undefinedtype>)var10).I$4 = 0;
         ((<undefinedtype>)var10).I$5 = 0;
         ((<undefinedtype>)var10).label = 1;
         var13 = (CanSetTimer)var13.setTimerDurationAndStatus(var1, var5, (Continuation)var10);
         if (var13 == var15) {
            return var15;
         }

         Ref.ObjectRef var33 = var21;
         var21.element = (ApiResult)var13;
         if (((ApiResult)var21.element).isSuccess()) {
            Timber.Forest var40 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var36);
            var24.append(" gave good result ");
            var24.append(var33.element);
            var24.append(" for call");
            var40.v(var24.toString(), new Object[0]);
            return var33.element;
         }

         Timber.Forest var23 = Timber.Forest;
         StringBuilder var45 = new StringBuilder("client ");
         var45.append(var36);
         var45.append(" gave failed result\n");
         var45.append(var33.element);
         var45.append(" for call, \nwith details:");
         var23.w(var45.toString(), new Object[0]);
         var21 = var33;
         var5 = var5;
         var4 = var4;
      }

      var11.logApiError(((ApiResult)var21.element).exceptionOrNull());
      return var21.element;
   }

   public final Object setTimerStatus(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var2;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var18 = var6;
               break label43;
            }
         }

         var18 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setTimerStatus(0, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var18).result;
      Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var18).label;
      int var5;
      DeviceClient var8;
      ConnectionManager var9;
      Object var10;
      Iterable var11;
      Integer var12;
      Iterator var13;
      Ref.ObjectRef var19;
      Ref.ObjectRef var24;
      KFunction var29;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var18).I$3;
         var3 = ((<undefinedtype>)var18).I$2;
         var5 = ((<undefinedtype>)var18).I$1;
         var1 = ((<undefinedtype>)var18).I$0;
         var24 = (Ref.ObjectRef)((<undefinedtype>)var18).L$8;
         var8 = (DeviceClient)((<undefinedtype>)var18).L$7;
         Object var7 = ((<undefinedtype>)var18).L$6;
         var13 = (Iterator)((<undefinedtype>)var18).L$5;
         var11 = (Iterable)((<undefinedtype>)var18).L$4;
         Ref.ObjectRef var15 = (Ref.ObjectRef)((<undefinedtype>)var18).L$3;
         var12 = (Integer)((<undefinedtype>)var18).L$2;
         var29 = (KFunction)((<undefinedtype>)var18).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var18).L$0;
         ResultKt.throwOnFailure(var14);
         var10 = var18;
         var19 = var15;
      } else {
         ResultKt.throwOnFailure(var14);
         var29 = (KFunction)null.INSTANCE;
         var12 = Boxing.boxInt(var1);
         Timber.Forest var25 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Attempting to doApiCall ");
         var30.append(var29);
         var30.append(", with ");
         var30.append(var12);
         var30.append(" on ");
         var30.append(this.clients.size());
         var30.append(" clients");
         var25.d(var30.toString(), new Object[0]);
         Timber.Forest var31 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("Client info: ");
         var26.append(this.clients);
         var31.v(var26.toString(), new Object[0]);
         var24 = new Ref.ObjectRef();
         StringBuilder var32 = new StringBuilder("None of the clients in ");
         var32.append(this);
         var32.append(" could call ");
         var32.append(var29);
         var24.element = new Failure((Throwable)(new UnknownError(var32.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var33 = (Collection)(new ArrayList());

         for(Object var37 : var34) {
            if (var37 instanceof CanSetTimer) {
               var33.add(var37);
            }
         }

         var11 = (Iterable)((List)var33);
         var13 = var11.iterator();
         byte var4 = 0;
         var9 = this;
         var3 = 0;
         var10 = var18;
         if (!var13.hasNext()) {
            this.logApiError(((ApiResult)var24.element).exceptionOrNull());
            return var24.element;
         }

         var14 = var13.next();
         var8 = (DeviceClient)var14;
         Function3 var20 = (Function3)var29;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var29;
         ((<undefinedtype>)var10).L$2 = var12;
         ((<undefinedtype>)var10).L$3 = var24;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var10).L$5 = var13;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var10).L$7 = var8;
         ((<undefinedtype>)var10).L$8 = var24;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var3;
         ((<undefinedtype>)var10).I$2 = var4;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         var14 = var20.invoke(var8, var12, var10);
         if (var14 == var16) {
            return var16;
         }

         var19 = var24;
         var5 = var3;
         var3 = var4;
      }

      while(true) {
         var24.element = var14;
         if (((ApiResult)var19.element).isSuccess()) {
            Timber.Forest var36 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var8);
            var28.append(" gave good result ");
            var28.append(var19.element);
            var28.append(" for call ");
            var28.append(var29);
            var36.v(var28.toString(), new Object[0]);
            return var19.element;
         }

         Timber.Forest var27 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var8);
         var39.append(" gave failed result\n");
         var39.append(var19.element);
         var39.append(" for call \n");
         var39.append(var29);
         var39.append(", \nwith details:");
         var27.w(var39.toString(), new Object[0]);
         var24 = var19;
         if (!var13.hasNext()) {
            var9.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         Object var40 = var13.next();
         var8 = (DeviceClient)var40;
         Function3 var21 = (Function3)var29;
         ((<undefinedtype>)var10).L$0 = var9;
         ((<undefinedtype>)var10).L$1 = var29;
         ((<undefinedtype>)var10).L$2 = var12;
         ((<undefinedtype>)var10).L$3 = var24;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var10).L$5 = var13;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var10).L$7 = var8;
         ((<undefinedtype>)var10).L$8 = var24;
         ((<undefinedtype>)var10).I$0 = var1;
         ((<undefinedtype>)var10).I$1 = var5;
         ((<undefinedtype>)var10).I$2 = var3;
         ((<undefinedtype>)var10).I$3 = 0;
         ((<undefinedtype>)var10).label = 1;
         var14 = var21.invoke(var8, var12, var10);
         if (var14 == var16) {
            return var16;
         }

         var19 = var24;
         var5 = var5;
         var3 = var3;
      }
   }

   public final Object setUse24Hour(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setUse24Hour(false, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      ConnectionManager var8;
      Boolean var9;
      Iterable var10;
      Iterator var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var17;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var3 = ((<undefinedtype>)var16).I$1;
         var4 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = ((<undefinedtype>)var16).L$6;
         var11 = (Iterator)((<undefinedtype>)var16).L$5;
         var10 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var9 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var13);
         var23 = var16;
         var17 = var12;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxBoolean(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var9);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         var29 = Timber.Forest;
         var24 = new StringBuilder("Client info: ");
         var24.append(this.clients);
         var29.v(var24.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var33) {
            if (var34 instanceof CanSetHourFormat) {
               var32.add(var34);
            }
         }

         var10 = (Iterable)((List)var32);
         var11 = var10.iterator();
         var3 = 0;
         var8 = this;
         var4 = 0;
         Object var37 = var16;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var11.next();
         var7 = (DeviceClient)var18;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var9;
         ((<undefinedtype>)var37).L$3 = var26;
         ((<undefinedtype>)var37).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var37).L$5 = var11;
         ((<undefinedtype>)var37).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var37).L$7 = var7;
         ((<undefinedtype>)var37).L$8 = var26;
         ((<undefinedtype>)var37).Z$0 = var1;
         ((<undefinedtype>)var37).I$0 = var4;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var13 = var40.invoke(var7, var9, var37);
         if (var13 == var15) {
            return var15;
         }

         var17 = var26;
         var14 = var26;
         var23 = var37;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var38 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var7);
         var41.append(" gave failed result\n");
         var41.append(var17.element);
         var41.append(" for call \n");
         var41.append(var6);
         var41.append(", \nwith details:");
         var38.w(var41.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var11.hasNext()) {
            var8.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var11.next();
         var7 = (DeviceClient)var19;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var8;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var9;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var39).L$5 = var11;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).Z$0 = var1;
         ((<undefinedtype>)var39).I$0 = var4;
         ((<undefinedtype>)var39).I$1 = var3;
         ((<undefinedtype>)var39).I$2 = 0;
         ((<undefinedtype>)var39).label = 1;
         var13 = var42.invoke(var7, var9, var39);
         if (var13 == var15) {
            return var15;
         }

         var17 = var27;
         var14 = var27;
         var23 = var39;
      }
   }

   public final Object setWickDryEnabled(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setWickDryEnabled(false, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Object var8;
      Boolean var9;
      Iterable var10;
      Iterator var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var17;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var3 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$6;
         var11 = (Iterator)((<undefinedtype>)var16).L$5;
         var10 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var9 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var12);
         var8 = var16;
         var17 = var13;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxBoolean(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var9);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         Timber.Forest var25 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var25.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var33) {
            if (var34 instanceof CanSetWick) {
               var32.add(var34);
            }
         }

         var10 = (Iterable)((List)var32);
         var11 = var10.iterator();
         var4 = 0;
         var3 = 0;
         var8 = var16;
         if (!var11.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var11.next();
         var7 = (DeviceClient)var18;
         Function3 var39 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = this;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var9;
         ((<undefinedtype>)var8).L$3 = var26;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$5 = var11;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var26;
         ((<undefinedtype>)var8).Z$0 = var1;
         ((<undefinedtype>)var8).I$0 = var3;
         ((<undefinedtype>)var8).I$1 = var4;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         Object var40 = var39.invoke(var7, var9, var8);
         if (var40 == var15) {
            return var15;
         }

         var17 = var26;
         var14 = var26;
         var23 = this;
         var12 = var40;
      }

      while(true) {
         var14.element = var12;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var7);
         var41.append(" gave failed result\n");
         var41.append(var17.element);
         var41.append(" for call \n");
         var41.append(var6);
         var41.append(", \nwith details:");
         var37.w(var41.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var11.hasNext()) {
            var38.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var11.next();
         var7 = (DeviceClient)var19;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var8).L$0 = var38;
         ((<undefinedtype>)var8).L$1 = var6;
         ((<undefinedtype>)var8).L$2 = var9;
         ((<undefinedtype>)var8).L$3 = var27;
         ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var8).L$5 = var11;
         ((<undefinedtype>)var8).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var8).L$7 = var7;
         ((<undefinedtype>)var8).L$8 = var27;
         ((<undefinedtype>)var8).Z$0 = var1;
         ((<undefinedtype>)var8).I$0 = var3;
         ((<undefinedtype>)var8).I$1 = var4;
         ((<undefinedtype>)var8).I$2 = 0;
         ((<undefinedtype>)var8).label = 1;
         Object var43 = var42.invoke(var7, var9, var8);
         if (var43 == var15) {
            return var15;
         }

         var17 = var27;
         var14 = var27;
         var23 = var38;
         var12 = var43;
      }
   }

   public final Object setWickDryOn(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setWickDryOn(false, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Boolean var8;
      Iterator var9;
      ConnectionManager var10;
      Iterable var12;
      Ref.ObjectRef var13;
      Ref.ObjectRef var17;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var3 = ((<undefinedtype>)var16).I$1;
         var4 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = ((<undefinedtype>)var16).L$6;
         var9 = (Iterator)((<undefinedtype>)var16).L$5;
         var12 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var8 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var14);
         var23 = var16;
         var17 = var11;
      } else {
         ResultKt.throwOnFailure(var14);
         var6 = (KFunction)null.INSTANCE;
         var8 = Boxing.boxBoolean(var1);
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("Attempting to doApiCall ");
         var24.append(var6);
         var24.append(", with ");
         var24.append(var8);
         var24.append(" on ");
         var24.append(this.clients.size());
         var24.append(" clients");
         var29.d(var24.toString(), new Object[0]);
         Timber.Forest var25 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var25.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanSetWick) {
               var32.add(var36);
            }
         }

         var12 = (Iterable)((List)var32);
         var9 = var12.iterator();
         var3 = 0;
         var10 = this;
         var4 = 0;
         Object var37 = var16;
         if (!var9.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var9.next();
         var7 = (DeviceClient)var18;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var37).L$0 = this;
         ((<undefinedtype>)var37).L$1 = var6;
         ((<undefinedtype>)var37).L$2 = var8;
         ((<undefinedtype>)var37).L$3 = var26;
         ((<undefinedtype>)var37).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var37).L$5 = var9;
         ((<undefinedtype>)var37).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var37).L$7 = var7;
         ((<undefinedtype>)var37).L$8 = var26;
         ((<undefinedtype>)var37).Z$0 = var1;
         ((<undefinedtype>)var37).I$0 = var4;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var14 = var40.invoke(var7, var8, var37);
         if (var14 == var15) {
            return var15;
         }

         var17 = var26;
         var13 = var26;
         var23 = var37;
      }

      while(true) {
         var13.element = var14;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var33 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var33.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var38 = Timber.Forest;
         StringBuilder var41 = new StringBuilder("client ");
         var41.append(var7);
         var41.append(" gave failed result\n");
         var41.append(var17.element);
         var41.append(" for call \n");
         var41.append(var6);
         var41.append(", \nwith details:");
         var38.w(var41.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var9.hasNext()) {
            var10.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var9.next();
         var7 = (DeviceClient)var19;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var10;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var8;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var39).L$5 = var9;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).Z$0 = var1;
         ((<undefinedtype>)var39).I$0 = var4;
         ((<undefinedtype>)var39).I$1 = var3;
         ((<undefinedtype>)var39).I$2 = 0;
         ((<undefinedtype>)var39).label = 1;
         var14 = var42.invoke(var7, var8, var39);
         if (var14 == var15) {
            return var15;
         }

         var17 = var27;
         var13 = var27;
         var23 = var39;
      }
   }

   public final Object setWickdryDurationAndOn(int var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var17 = var5;
               break label43;
            }
         }

         var17 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
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
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setWickdryDurationAndOn(0, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var17).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var17).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterator var8;
      Integer var9;
      ConnectionManager var10;
      Iterable var11;
      Ref.ObjectRef var13;
      Ref.ObjectRef var18;
      Object var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).I$3;
         var4 = ((<undefinedtype>)var17).I$2;
         var3 = ((<undefinedtype>)var17).I$1;
         var1 = ((<undefinedtype>)var17).I$0;
         var13 = (Ref.ObjectRef)((<undefinedtype>)var17).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var17).L$7;
         var23 = ((<undefinedtype>)var17).L$6;
         var8 = (Iterator)((<undefinedtype>)var17).L$5;
         var11 = (Iterable)((<undefinedtype>)var17).L$4;
         Ref.ObjectRef var14 = (Ref.ObjectRef)((<undefinedtype>)var17).L$3;
         var9 = (Integer)((<undefinedtype>)var17).L$2;
         var6 = (KFunction)((<undefinedtype>)var17).L$1;
         var10 = (ConnectionManager)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var12);
         var23 = var17;
         var18 = var14;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxInt(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var9);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         Timber.Forest var30 = Timber.Forest;
         StringBuilder var25 = new StringBuilder("Client info: ");
         var25.append(this.clients);
         var30.v(var25.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         StringBuilder var31 = new StringBuilder("None of the clients in ");
         var31.append(this);
         var31.append(" could call ");
         var31.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var31.toString())));
         Iterable var33 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var33) {
            if (var34 instanceof CanSetWick) {
               var32.add(var34);
            }
         }

         var11 = (Iterable)((List)var32);
         var8 = var11.iterator();
         var4 = 0;
         var10 = this;
         var3 = 0;
         var12 = var17;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var19 = var8.next();
         var7 = (DeviceClient)var19;
         Function3 var40 = (Function3)var6;
         ((<undefinedtype>)var12).L$0 = this;
         ((<undefinedtype>)var12).L$1 = var6;
         ((<undefinedtype>)var12).L$2 = var9;
         ((<undefinedtype>)var12).L$3 = var26;
         ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var12).L$5 = var8;
         ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var12).L$7 = var7;
         ((<undefinedtype>)var12).L$8 = var26;
         ((<undefinedtype>)var12).I$0 = var1;
         ((<undefinedtype>)var12).I$1 = var3;
         ((<undefinedtype>)var12).I$2 = var4;
         ((<undefinedtype>)var12).I$3 = 0;
         ((<undefinedtype>)var12).label = 1;
         Object var43 = var40.invoke(var7, var9, var12);
         if (var43 == var15) {
            return var15;
         }

         var18 = var26;
         var13 = var26;
         var23 = var12;
         var12 = var43;
      }

      while(true) {
         var13.element = var12;
         if (((ApiResult)var18.element).isSuccess()) {
            Timber.Forest var28 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("client ");
            var35.append(var7);
            var35.append(" gave good result ");
            var35.append(var18.element);
            var35.append(" for call ");
            var35.append(var6);
            var28.v(var35.toString(), new Object[0]);
            return var18.element;
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var38 = new StringBuilder("client ");
         var38.append(var7);
         var38.append(" gave failed result\n");
         var38.append(var18.element);
         var38.append(" for call \n");
         var38.append(var6);
         var38.append(", \nwith details:");
         var41.w(var38.toString(), new Object[0]);
         Object var39 = var23;
         Ref.ObjectRef var27 = var18;
         if (!var8.hasNext()) {
            var10.logApiError(((ApiResult)var18.element).exceptionOrNull());
            return var18.element;
         }

         Object var20 = var8.next();
         var7 = (DeviceClient)var20;
         Function3 var42 = (Function3)var6;
         ((<undefinedtype>)var39).L$0 = var10;
         ((<undefinedtype>)var39).L$1 = var6;
         ((<undefinedtype>)var39).L$2 = var9;
         ((<undefinedtype>)var39).L$3 = var27;
         ((<undefinedtype>)var39).L$4 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var39).L$5 = var8;
         ((<undefinedtype>)var39).L$6 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var39).L$7 = var7;
         ((<undefinedtype>)var39).L$8 = var27;
         ((<undefinedtype>)var39).I$0 = var1;
         ((<undefinedtype>)var39).I$1 = var3;
         ((<undefinedtype>)var39).I$2 = var4;
         ((<undefinedtype>)var39).I$3 = 0;
         ((<undefinedtype>)var39).label = 1;
         Object var44 = var42.invoke(var7, var9, var39);
         if (var44 == var15) {
            return var15;
         }

         var18 = var27;
         var13 = var27;
         var23 = var39;
         var12 = var44;
      }
   }

   public final Object setYwrmEnabled(boolean var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var16 = var5;
               break label43;
            }
         }

         var16 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            boolean Z$0;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setYwrmEnabled(false, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var16).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var16).label;
      int var4;
      KFunction var6;
      DeviceClient var7;
      Iterable var8;
      Boolean var9;
      Object var10;
      Iterator var12;
      Ref.ObjectRef var14;
      Ref.ObjectRef var17;
      ConnectionManager var23;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var16).I$2;
         var4 = ((<undefinedtype>)var16).I$1;
         var3 = ((<undefinedtype>)var16).I$0;
         var1 = ((<undefinedtype>)var16).Z$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var16).L$8;
         var7 = (DeviceClient)((<undefinedtype>)var16).L$7;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$6;
         var12 = (Iterator)((<undefinedtype>)var16).L$5;
         var8 = (Iterable)((<undefinedtype>)var16).L$4;
         Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var16).L$3;
         var9 = (Boolean)((<undefinedtype>)var16).L$2;
         var6 = (KFunction)((<undefinedtype>)var16).L$1;
         var23 = (ConnectionManager)((<undefinedtype>)var16).L$0;
         ResultKt.throwOnFailure(var13);
         var10 = var16;
         var17 = var11;
      } else {
         ResultKt.throwOnFailure(var13);
         var6 = (KFunction)null.INSTANCE;
         var9 = Boxing.boxBoolean(var1);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var29 = new StringBuilder("Attempting to doApiCall ");
         var29.append(var6);
         var29.append(", with ");
         var29.append(var9);
         var29.append(" on ");
         var29.append(this.clients.size());
         var29.append(" clients");
         var24.d(var29.toString(), new Object[0]);
         var24 = Timber.Forest;
         var29 = new StringBuilder("Client info: ");
         var29.append(this.clients);
         var24.v(var29.toString(), new Object[0]);
         Ref.ObjectRef var26 = new Ref.ObjectRef();
         var29 = new StringBuilder("None of the clients in ");
         var29.append(this);
         var29.append(" could call ");
         var29.append(var6);
         var26.element = new Failure((Throwable)(new UnknownError(var29.toString())));
         var8 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var34 : var8) {
            if (var34 instanceof CanSetYellowWaterRemove) {
               var32.add(var34);
            }
         }

         var8 = (Iterable)((List)var32);
         var12 = var8.iterator();
         var4 = 0;
         var3 = 0;
         var10 = var16;
         if (!var12.hasNext()) {
            this.logApiError(((ApiResult)var26.element).exceptionOrNull());
            return var26.element;
         }

         Object var18 = var12.next();
         var7 = (DeviceClient)var18;
         Function3 var39 = (Function3)var6;
         ((<undefinedtype>)var10).L$0 = this;
         ((<undefinedtype>)var10).L$1 = var6;
         ((<undefinedtype>)var10).L$2 = var9;
         ((<undefinedtype>)var10).L$3 = var26;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var10).L$5 = var12;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var26;
         ((<undefinedtype>)var10).Z$0 = var1;
         ((<undefinedtype>)var10).I$0 = var3;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = 0;
         ((<undefinedtype>)var10).label = 1;
         var13 = var39.invoke(var7, var9, var10);
         if (var13 == var15) {
            return var15;
         }

         var17 = var26;
         var14 = var26;
         var23 = this;
      }

      while(true) {
         var14.element = var13;
         if (((ApiResult)var17.element).isSuccess()) {
            Timber.Forest var35 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var7);
            var28.append(" gave good result ");
            var28.append(var17.element);
            var28.append(" for call ");
            var28.append(var6);
            var35.v(var28.toString(), new Object[0]);
            return var17.element;
         }

         Timber.Forest var37 = Timber.Forest;
         StringBuilder var40 = new StringBuilder("client ");
         var40.append(var7);
         var40.append(" gave failed result\n");
         var40.append(var17.element);
         var40.append(" for call \n");
         var40.append(var6);
         var40.append(", \nwith details:");
         var37.w(var40.toString(), new Object[0]);
         ConnectionManager var38 = var23;
         Ref.ObjectRef var27 = var17;
         if (!var12.hasNext()) {
            var38.logApiError(((ApiResult)var17.element).exceptionOrNull());
            return var17.element;
         }

         Object var19 = var12.next();
         var7 = (DeviceClient)var19;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var10).L$0 = var38;
         ((<undefinedtype>)var10).L$1 = var6;
         ((<undefinedtype>)var10).L$2 = var9;
         ((<undefinedtype>)var10).L$3 = var27;
         ((<undefinedtype>)var10).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var10).L$5 = var12;
         ((<undefinedtype>)var10).L$6 = SpillingKt.nullOutSpilledVariable(var19);
         ((<undefinedtype>)var10).L$7 = var7;
         ((<undefinedtype>)var10).L$8 = var27;
         ((<undefinedtype>)var10).Z$0 = var1;
         ((<undefinedtype>)var10).I$0 = var3;
         ((<undefinedtype>)var10).I$1 = var4;
         ((<undefinedtype>)var10).I$2 = 0;
         ((<undefinedtype>)var10).label = 1;
         var13 = var41.invoke(var7, var9, var10);
         if (var13 == var15) {
            return var15;
         }

         var17 = var27;
         var14 = var27;
         var23 = var38;
      }
   }

   public final Object stopAlarm(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.stopAlarm((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      DeviceClient var6;
      Iterable var7;
      ConnectionManager var8;
      Object var9;
      Iterator var10;
      Ref.ObjectRef var15;
      Ref.ObjectRef var20;
      KFunction var25;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var20 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         Object var5 = ((<undefinedtype>)var14).L$5;
         var10 = (Iterator)((<undefinedtype>)var14).L$4;
         var7 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var12 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var25 = (KFunction)((<undefinedtype>)var14).L$1;
         var8 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var11);
         var9 = var14;
         var15 = var12;
      } else {
         ResultKt.throwOnFailure(var11);
         var25 = (KFunction)null.INSTANCE;
         Timber.Forest var26 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("Attempting to doApiCall ");
         var21.append(var25);
         var21.append(" on ");
         var21.append(this.clients.size());
         var21.append(" clients");
         var26.d(var21.toString(), new Object[0]);
         Timber.Forest var22 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var22.v(var27.toString(), new Object[0]);
         var20 = new Ref.ObjectRef();
         var27 = new StringBuilder("None of the clients in ");
         var27.append(this);
         var27.append(" could call ");
         var27.append(var25);
         var20.element = new Failure((Throwable)(new UnknownError(var27.toString())));
         var7 = (Iterable)this.clients;
         Collection var29 = (Collection)(new ArrayList());

         for(Object var31 : var7) {
            if (var31 instanceof CanSetAlarm) {
               var29.add(var31);
            }
         }

         var7 = (Iterable)((List)var29);
         var10 = var7.iterator();
         var8 = this;
         var3 = 0;
         var2 = 0;
         var9 = var14;
         if (!var10.hasNext()) {
            this.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var16 = var10.next();
         var6 = (DeviceClient)var16;
         Function2 var34 = (Function2)var25;
         ((<undefinedtype>)var9).L$0 = this;
         ((<undefinedtype>)var9).L$1 = var25;
         ((<undefinedtype>)var9).L$2 = var20;
         ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var9).L$4 = var10;
         ((<undefinedtype>)var9).L$5 = SpillingKt.nullOutSpilledVariable(var16);
         ((<undefinedtype>)var9).L$6 = var6;
         ((<undefinedtype>)var9).L$7 = var20;
         ((<undefinedtype>)var9).I$0 = var2;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = 0;
         ((<undefinedtype>)var9).label = 1;
         var11 = var34.invoke(var6, var9);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }

      while(true) {
         var20.element = var11;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var32 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("client ");
            var24.append(var6);
            var24.append(" gave good result ");
            var24.append(var15.element);
            var24.append(" for call ");
            var24.append(var25);
            var32.v(var24.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var35 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("client ");
         var23.append(var6);
         var23.append(" gave failed result\n");
         var23.append(var15.element);
         var23.append(" for call \n");
         var23.append(var25);
         var23.append(", \nwith details:");
         var35.w(var23.toString(), new Object[0]);
         var20 = var15;
         if (!var10.hasNext()) {
            var8.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var17 = var10.next();
         var6 = (DeviceClient)var17;
         Function2 var36 = (Function2)var25;
         ((<undefinedtype>)var9).L$0 = var8;
         ((<undefinedtype>)var9).L$1 = var25;
         ((<undefinedtype>)var9).L$2 = var20;
         ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var9).L$4 = var10;
         ((<undefinedtype>)var9).L$5 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var9).L$6 = var6;
         ((<undefinedtype>)var9).L$7 = var20;
         ((<undefinedtype>)var9).I$0 = var2;
         ((<undefinedtype>)var9).I$1 = var3;
         ((<undefinedtype>)var9).I$2 = 0;
         ((<undefinedtype>)var9).label = 1;
         var11 = var36.invoke(var6, var9);
         if (var11 == var13) {
            return var13;
         }

         var15 = var20;
      }
   }

   public final Object switchOffSoftAp(Continuation var1) {
      label43: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label43;
            }
         }

         var14 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            int I$2;
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
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.switchOffSoftAp((Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var14).result;
      Object var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var14).label;
      int var3;
      KFunction var5;
      DeviceClient var6;
      Iterable var7;
      Iterator var8;
      ConnectionManager var9;
      Ref.ObjectRef var11;
      Ref.ObjectRef var15;
      Object var21;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$2;
         var3 = ((<undefinedtype>)var14).I$1;
         var2 = ((<undefinedtype>)var14).I$0;
         var11 = (Ref.ObjectRef)((<undefinedtype>)var14).L$7;
         var6 = (DeviceClient)((<undefinedtype>)var14).L$6;
         var21 = ((<undefinedtype>)var14).L$5;
         var8 = (Iterator)((<undefinedtype>)var14).L$4;
         var7 = (Iterable)((<undefinedtype>)var14).L$3;
         Ref.ObjectRef var10 = (Ref.ObjectRef)((<undefinedtype>)var14).L$2;
         var5 = (KFunction)((<undefinedtype>)var14).L$1;
         var9 = (ConnectionManager)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var12);
         var21 = var14;
         var15 = var10;
      } else {
         ResultKt.throwOnFailure(var12);
         var5 = (KFunction)null.INSTANCE;
         Timber.Forest var22 = Timber.Forest;
         StringBuilder var27 = new StringBuilder("Attempting to doApiCall ");
         var27.append(var5);
         var27.append(" on ");
         var27.append(this.clients.size());
         var27.append(" clients");
         var22.d(var27.toString(), new Object[0]);
         var22 = Timber.Forest;
         var27 = new StringBuilder("Client info: ");
         var27.append(this.clients);
         var22.v(var27.toString(), new Object[0]);
         Ref.ObjectRef var24 = new Ref.ObjectRef();
         var27 = new StringBuilder("None of the clients in ");
         var27.append(this);
         var27.append(" could call ");
         var27.append(var5);
         var24.element = new Failure((Throwable)(new UnknownError(var27.toString())));
         var7 = (Iterable)this.clients;
         Collection var30 = (Collection)(new ArrayList());

         for(Object var34 : var7) {
            if (var34 instanceof CanProvisionLocal) {
               var30.add(var34);
            }
         }

         var7 = (Iterable)((List)var30);
         var8 = var7.iterator();
         var9 = this;
         var3 = 0;
         var2 = 0;
         Object var35 = var14;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var24.element).exceptionOrNull());
            return var24.element;
         }

         Object var38 = var8.next();
         var6 = (DeviceClient)var38;
         Function2 var16 = (Function2)var5;
         ((<undefinedtype>)var35).L$0 = this;
         ((<undefinedtype>)var35).L$1 = var5;
         ((<undefinedtype>)var35).L$2 = var24;
         ((<undefinedtype>)var35).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var35).L$4 = var8;
         ((<undefinedtype>)var35).L$5 = SpillingKt.nullOutSpilledVariable(var38);
         ((<undefinedtype>)var35).L$6 = var6;
         ((<undefinedtype>)var35).L$7 = var24;
         ((<undefinedtype>)var35).I$0 = var2;
         ((<undefinedtype>)var35).I$1 = var3;
         ((<undefinedtype>)var35).I$2 = 0;
         ((<undefinedtype>)var35).label = 1;
         var12 = var16.invoke(var6, var35);
         if (var12 == var13) {
            return var13;
         }

         var15 = var24;
         var11 = var24;
         var21 = var35;
      }

      while(true) {
         var11.element = var12;
         if (((ApiResult)var15.element).isSuccess()) {
            Timber.Forest var26 = Timber.Forest;
            StringBuilder var33 = new StringBuilder("client ");
            var33.append(var6);
            var33.append(" gave good result ");
            var33.append(var15.element);
            var33.append(" for call ");
            var33.append(var5);
            var26.v(var33.toString(), new Object[0]);
            return var15.element;
         }

         Timber.Forest var36 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var6);
         var39.append(" gave failed result\n");
         var39.append(var15.element);
         var39.append(" for call \n");
         var39.append(var5);
         var39.append(", \nwith details:");
         var36.w(var39.toString(), new Object[0]);
         Object var37 = var21;
         Ref.ObjectRef var25 = var15;
         if (!var8.hasNext()) {
            var9.logApiError(((ApiResult)var15.element).exceptionOrNull());
            return var15.element;
         }

         Object var40 = var8.next();
         var6 = (DeviceClient)var40;
         Function2 var17 = (Function2)var5;
         ((<undefinedtype>)var37).L$0 = var9;
         ((<undefinedtype>)var37).L$1 = var5;
         ((<undefinedtype>)var37).L$2 = var25;
         ((<undefinedtype>)var37).L$3 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var37).L$4 = var8;
         ((<undefinedtype>)var37).L$5 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var37).L$6 = var6;
         ((<undefinedtype>)var37).L$7 = var25;
         ((<undefinedtype>)var37).I$0 = var2;
         ((<undefinedtype>)var37).I$1 = var3;
         ((<undefinedtype>)var37).I$2 = 0;
         ((<undefinedtype>)var37).label = 1;
         var12 = var17.invoke(var6, var37);
         if (var12 == var13) {
            return var13;
         }

         var15 = var25;
         var11 = var25;
         var21 = var37;
      }
   }

   public final void updateDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "nuDevice");
      if (((CharSequence)this.device.getUid()).length() != 0 && !Intrinsics.areEqual(this.device.getUid(), var1.getUid())) {
         throw new IllegalArgumentException("You can't change the device. Instantiate a new ConnectionManager instead.".toString());
      } else {
         this.device = var1;
         Iterator var2 = ((Iterable)this.clients).iterator();

         while(var2.hasNext()) {
            ((DeviceClient)var2.next()).setDeviceUuid(this.device.getUid());
         }

      }
   }

   public final Object updateSchedule(DeviceSchedule var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label43;
            }
         }

         var22 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            Object result;
            final ConnectionManager this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateSchedule((DeviceSchedule)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var22).result;
      Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var22).label;
      int var4;
      KFunction var6;
      Object var7;
      Iterator var8;
      ConnectionManager var9;
      Iterable var10;
      DeviceClient var11;
      Ref.ObjectRef var14;
      Ref.ObjectRef var23;
      DeviceSchedule var27;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var22).I$2;
         var4 = ((<undefinedtype>)var22).I$1;
         var3 = ((<undefinedtype>)var22).I$0;
         var14 = (Ref.ObjectRef)((<undefinedtype>)var22).L$9;
         var11 = (DeviceClient)((<undefinedtype>)var22).L$8;
         Object var16 = ((<undefinedtype>)var22).L$7;
         var8 = (Iterator)((<undefinedtype>)var22).L$6;
         var10 = (Iterable)((<undefinedtype>)var22).L$5;
         Ref.ObjectRef var13 = (Ref.ObjectRef)((<undefinedtype>)var22).L$4;
         var27 = (DeviceSchedule)((<undefinedtype>)var22).L$3;
         var6 = (KFunction)((<undefinedtype>)var22).L$2;
         var9 = (ConnectionManager)((<undefinedtype>)var22).L$1;
         var1 = (DeviceSchedule)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var22;
         var23 = var13;
      } else {
         ResultKt.throwOnFailure(var12);
         var6 = (KFunction)null.INSTANCE;
         Timber.Forest var29 = Timber.Forest;
         StringBuilder var33 = new StringBuilder("Attempting to doApiCall ");
         var33.append(var6);
         var33.append(", with ");
         var27 = var1;
         var33.append(var1);
         var33.append(" on ");
         var33.append(this.clients.size());
         var33.append(" clients");
         var29.d(var33.toString(), new Object[0]);
         Timber.Forest var18 = Timber.Forest;
         StringBuilder var30 = new StringBuilder("Client info: ");
         var30.append(this.clients);
         var18.v(var30.toString(), new Object[0]);
         Ref.ObjectRef var19 = new Ref.ObjectRef();
         var30 = new StringBuilder("None of the clients in ");
         var30.append(this);
         var30.append(" could call ");
         var30.append(var6);
         var19.element = new Failure((Throwable)(new UnknownError(var30.toString())));
         Iterable var34 = (Iterable)this.clients;
         Collection var32 = (Collection)(new ArrayList());

         for(Object var36 : var34) {
            if (var36 instanceof CanManageSchedule) {
               var32.add(var36);
            }
         }

         var10 = (Iterable)((List)var32);
         var8 = var10.iterator();
         var9 = this;
         var3 = 0;
         var4 = 0;
         var7 = var22;
         if (!var8.hasNext()) {
            this.logApiError(((ApiResult)var19.element).exceptionOrNull());
            return var19.element;
         }

         var12 = var8.next();
         var11 = (DeviceClient)var12;
         Function3 var41 = (Function3)var6;
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var27);
         ((<undefinedtype>)var22).L$1 = this;
         ((<undefinedtype>)var22).L$2 = var6;
         ((<undefinedtype>)var22).L$3 = var27;
         ((<undefinedtype>)var22).L$4 = var19;
         ((<undefinedtype>)var22).L$5 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var22).L$6 = var8;
         ((<undefinedtype>)var22).L$7 = SpillingKt.nullOutSpilledVariable(var12);
         ((<undefinedtype>)var22).L$8 = var11;
         ((<undefinedtype>)var22).L$9 = var19;
         ((<undefinedtype>)var22).I$0 = var3;
         ((<undefinedtype>)var22).I$1 = var4;
         ((<undefinedtype>)var22).I$2 = 0;
         ((<undefinedtype>)var22).label = 1;
         var12 = var41.invoke(var11, var27, var22);
         if (var12 == var15) {
            return var15;
         }

         var23 = var19;
         var14 = var19;
         var1 = var27;
      }

      while(true) {
         var14.element = var12;
         if (((ApiResult)var23.element).isSuccess()) {
            Timber.Forest var21 = Timber.Forest;
            StringBuilder var28 = new StringBuilder("client ");
            var28.append(var11);
            var28.append(" gave good result ");
            var28.append(var23.element);
            var28.append(" for call ");
            var28.append(var6);
            var21.v(var28.toString(), new Object[0]);
            return var23.element;
         }

         Timber.Forest var42 = Timber.Forest;
         StringBuilder var39 = new StringBuilder("client ");
         var39.append(var11);
         var39.append(" gave failed result\n");
         var39.append(var23.element);
         var39.append(" for call \n");
         var39.append(var6);
         var39.append(", \nwith details:");
         var42.w(var39.toString(), new Object[0]);
         DeviceSchedule var37 = var1;
         Ref.ObjectRef var20 = var23;
         DeviceSchedule var24 = var37;
         if (!var8.hasNext()) {
            var9.logApiError(((ApiResult)var20.element).exceptionOrNull());
            return var20.element;
         }

         Object var40 = var8.next();
         var11 = (DeviceClient)var40;
         Function3 var43 = (Function3)var6;
         ((<undefinedtype>)var7).L$0 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var7).L$1 = var9;
         ((<undefinedtype>)var7).L$2 = var6;
         ((<undefinedtype>)var7).L$3 = var27;
         ((<undefinedtype>)var7).L$4 = var20;
         ((<undefinedtype>)var7).L$5 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var7).L$6 = var8;
         ((<undefinedtype>)var7).L$7 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var7).L$8 = var11;
         ((<undefinedtype>)var7).L$9 = var20;
         ((<undefinedtype>)var7).I$0 = var3;
         ((<undefinedtype>)var7).I$1 = var4;
         ((<undefinedtype>)var7).I$2 = 0;
         ((<undefinedtype>)var7).label = 1;
         var12 = var43.invoke(var11, var27, var7);
         if (var12 == var15) {
            return var15;
         }

         DeviceSchedule var44 = var24;
         var23 = var20;
         var14 = var20;
         var1 = var44;
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/ConnectionManager$Companion;", "", "<init>", "()V", "TYPE_WELCOME_HOME", "", "api_otherRelease"},
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
