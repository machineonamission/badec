package io.flatcircle.ble;

import android.bluetooth.BluetoothAdapter;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.airboxlab.icp.sdk.DeviceConnectionState;
import com.airboxlab.icp.sdk.DeviceSpec;
import com.airboxlab.icp.sdk.DeviceStuckInDfuModeException;
import com.airboxlab.icp.sdk.IcpDeviceInformation;
import com.airboxlab.icp.sdk.model.FilterUsage;
import com.airboxlab.icp.sdk.model.Plantower;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.auth.AuthService;
import com.blueair.core.AblEnvironment;
import com.facebook.internal.security.CertificateUtil;
import com.foobot.client.blueair.BlueairUser;
import com.foobot.liblabclient.core.ServiceResolver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import java.nio.channels.AlreadyConnectedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0006;<=>?@B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\"J\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150'2\u0006\u0010(\u001a\u00020\nJ\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150'2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\"2\u0006\u0010(\u001a\u00020\nJ\u001a\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0002J(\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0/0'2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000201H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010-2\u0006\u0010(\u001a\u00020\nH\u0002J\u000e\u00104\u001a\u00020\r2\u0006\u0010(\u001a\u00020\nJ\u0010\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0002J\u0016\u00107\u001a\u00020\"2\u0006\u0010(\u001a\u00020\n2\u0006\u00108\u001a\u00020\u0016J\u0016\u00109\u001a\u00020\"2\u0006\u0010(\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000bX\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r`\u000bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u000f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00190\u00140\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001c0\u00140\u000f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001f0\u00140\u000f8F¢\u0006\u0006\u001a\u0004\b \u0010\u0012¨\u0006A"}, d2 = {"Lio/flatcircle/ble/BleIcpController;", "", "blueairManager", "Lcom/airboxlab/icp/sdk/BlueAirManager;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Lcom/airboxlab/icp/sdk/BlueAirManager;Lcom/blueair/auth/AuthService;)V", "macAddressToUuid", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "currentConnectionStates", "Lio/flatcircle/ble/BleIcpController$IcpDeviceConnectionState;", "connectionStateObservable", "Lio/reactivex/Observable;", "Lio/flatcircle/ble/BleIcpController$IcpDeviceConnection;", "getConnectionStateObservable", "()Lio/reactivex/Observable;", "fanSpeedObservable", "Lkotlin/Pair;", "Lio/flatcircle/ble/BleIcpController$IcpDevice;", "Lio/flatcircle/ble/BleIcpController$FanSpeed;", "getFanSpeedObservable", "fanModeObservable", "Lio/flatcircle/ble/BleIcpController$FanMode;", "getFanModeObservable", "dataPointObservable", "Lio/flatcircle/ble/BleIcpController$DataPoint;", "getDataPointObservable", "filterUsageObservable", "", "getFilterUsageObservable", "login", "", "blueairUser", "Lcom/foobot/client/blueair/BlueairUser;", "logout", "connect", "Lio/reactivex/Single;", "uuid", "macAddress", "disconnect", "asIcpDevice", "d", "Lcom/airboxlab/icp/sdk/IcpDevice;", "scan", "", "timeoutSeconds", "", "maxDevices", "getInternalIcpDeviceBySerialUuid", "getConnectionState", "toMacAddress", "address", "setFanSpeed", "fanSpeed", "setFanMode", "fanMode", "IcpDeviceConnection", "IcpDeviceConnectionState", "IcpDevice", "FanSpeed", "FanMode", "DataPoint", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleIcpController.kt */
public final class BleIcpController {
    private final AuthService authService;
    private final BlueAirManager blueairManager;
    private HashMap<String, IcpDeviceConnectionState> currentConnectionStates = new HashMap<>();
    private HashMap<String, String> macAddressToUuid = new HashMap<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|(2:15|16)|17|19|20|21|22|23|24|(2:25|26)|27|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|45|46|47|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|(2:25|26)|27|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0076 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c0 */
        static {
            /*
                com.airboxlab.icp.sdk.DeviceConnectionState[] r0 = com.airboxlab.icp.sdk.DeviceConnectionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.airboxlab.icp.sdk.DeviceConnectionState r2 = com.airboxlab.icp.sdk.DeviceConnectionState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.airboxlab.icp.sdk.DeviceConnectionState r3 = com.airboxlab.icp.sdk.DeviceConnectionState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.airboxlab.icp.sdk.DeviceConnectionState r4 = com.airboxlab.icp.sdk.DeviceConnectionState.DISCONNECTING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.airboxlab.icp.sdk.DeviceConnectionState r5 = com.airboxlab.icp.sdk.DeviceConnectionState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.airboxlab.icp.sdk.DeviceConnectionState r5 = com.airboxlab.icp.sdk.DeviceConnectionState.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                com.airboxlab.icp.sdk.model.FanSpeed[] r0 = com.airboxlab.icp.sdk.model.FanSpeed.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.airboxlab.icp.sdk.model.FanSpeed r5 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_0     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.airboxlab.icp.sdk.model.FanSpeed r5 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_1     // Catch:{ NoSuchFieldError -> 0x004d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.airboxlab.icp.sdk.model.FanSpeed r5 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_2     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.airboxlab.icp.sdk.model.FanSpeed r5 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_3     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                $EnumSwitchMapping$1 = r0
                com.airboxlab.icp.sdk.model.FanMode[] r0 = com.airboxlab.icp.sdk.model.FanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.airboxlab.icp.sdk.model.FanMode r5 = com.airboxlab.icp.sdk.model.FanMode.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x006e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.airboxlab.icp.sdk.model.FanMode r5 = com.airboxlab.icp.sdk.model.FanMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0076 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0076 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                com.airboxlab.icp.sdk.model.FanMode r5 = com.airboxlab.icp.sdk.model.FanMode.AUTO     // Catch:{ NoSuchFieldError -> 0x007e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                com.airboxlab.icp.sdk.model.FanMode r5 = com.airboxlab.icp.sdk.model.FanMode.MAX_SPEED     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                $EnumSwitchMapping$2 = r0
                io.flatcircle.ble.BleIcpController$FanSpeed[] r0 = io.flatcircle.ble.BleIcpController.FanSpeed.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.flatcircle.ble.BleIcpController$FanSpeed r5 = io.flatcircle.ble.BleIcpController.FanSpeed.SPEED_0     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                io.flatcircle.ble.BleIcpController$FanSpeed r5 = io.flatcircle.ble.BleIcpController.FanSpeed.SPEED_1     // Catch:{ NoSuchFieldError -> 0x009f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                io.flatcircle.ble.BleIcpController$FanSpeed r5 = io.flatcircle.ble.BleIcpController.FanSpeed.SPEED_2     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                io.flatcircle.ble.BleIcpController$FanSpeed r3 = io.flatcircle.ble.BleIcpController.FanSpeed.SPEED_3     // Catch:{ NoSuchFieldError -> 0x00af }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                $EnumSwitchMapping$3 = r0
                io.flatcircle.ble.BleIcpController$FanMode[] r0 = io.flatcircle.ble.BleIcpController.FanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.flatcircle.ble.BleIcpController$FanMode r3 = io.flatcircle.ble.BleIcpController.FanMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                io.flatcircle.ble.BleIcpController$FanMode r1 = io.flatcircle.ble.BleIcpController.FanMode.AUTO     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                $EnumSwitchMapping$4 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.ble.BleIcpController.WhenMappings.<clinit>():void");
        }
    }

    public BleIcpController(BlueAirManager blueAirManager, AuthService authService2) {
        Intrinsics.checkNotNullParameter(blueAirManager, "blueairManager");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.blueairManager = blueAirManager;
        this.authService = authService2;
        BlueairUser Build = BlueairUser.Build(authService2.getUsername(), authService2.getGigyaJwt());
        Build.setApiKey(AblEnvironment.INSTANCE.getApiKey());
        Build.SetEnvironment(ServiceResolver.Environment.PROD);
        blueAirManager.setEnvironment(ServiceResolver.Environment.PROD);
        blueAirManager.setApiKey(AblEnvironment.INSTANCE.getApiKey());
        Intrinsics.checkNotNull(Build);
        login(Build);
    }

    public final Observable<IcpDeviceConnection> getConnectionStateObservable() {
        Observable<R> map = this.blueairManager.connectionStateObservable().map(new BleIcpController$$ExternalSyntheticLambda7(new BleIcpController$$ExternalSyntheticLambda6(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final IcpDeviceConnection _get_connectionStateObservable_$lambda$2(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (IcpDeviceConnection) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final IcpDeviceConnection _get_connectionStateObservable_$lambda$1(BleIcpController bleIcpController, Pair pair) {
        IcpDeviceConnectionState icpDeviceConnectionState;
        String str;
        Intrinsics.checkNotNullParameter(pair, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[((DeviceConnectionState) pair.getSecond()).ordinal()];
        if (i == 1) {
            icpDeviceConnectionState = IcpDeviceConnectionState.CONNECTING;
        } else if (i == 2) {
            icpDeviceConnectionState = IcpDeviceConnectionState.CONNECTED;
        } else if (i == 3) {
            icpDeviceConnectionState = IcpDeviceConnectionState.DISCONNECTING;
        } else if (i == 4) {
            icpDeviceConnectionState = IcpDeviceConnectionState.DISCONNECTED;
        } else if (i == 5) {
            icpDeviceConnectionState = IcpDeviceConnectionState.UNKNOWN;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Timber.Forest forest = Timber.Forest;
        forest.i("Connection state changed " + pair.getSecond() + " for " + ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid() + ", " + ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getMacAddress(), new Object[0]);
        if (((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getCache().getDeviceInformation() != null) {
            IcpDeviceInformation deviceInformation = ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getCache().getDeviceInformation();
            str = deviceInformation != null ? deviceInformation.getSerialNumber() : null;
        } else if (((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid() != null) {
            str = bleIcpController.macAddressToUuid.get(((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid());
        } else {
            str = bleIcpController.macAddressToUuid.get(((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getMacAddress());
        }
        if (str != null) {
            bleIcpController.currentConnectionStates.put(str, icpDeviceConnectionState);
        }
        IcpDevice asIcpDevice = bleIcpController.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst(), str);
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("Update connection state for " + icpDeviceConnectionState + ", " + asIcpDevice.getUuid() + ", " + asIcpDevice.getMacAddress(), new Object[0]);
        return new IcpDeviceConnection(icpDeviceConnectionState, asIcpDevice);
    }

    public final Observable<Pair<IcpDevice, FanSpeed>> getFanSpeedObservable() {
        Observable<R> map = this.blueairManager.fanSpeedObservable().map(new BleIcpController$$ExternalSyntheticLambda11(new BleIcpController$$ExternalSyntheticLambda10(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final Pair _get_fanSpeedObservable_$lambda$4(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair _get_fanSpeedObservable_$lambda$3(BleIcpController bleIcpController, Pair pair) {
        FanSpeed fanSpeed;
        Intrinsics.checkNotNullParameter(pair, "it");
        int i = WhenMappings.$EnumSwitchMapping$1[((com.airboxlab.icp.sdk.model.FanSpeed) pair.getSecond()).ordinal()];
        if (i == 1) {
            fanSpeed = FanSpeed.SPEED_1;
        } else if (i == 2) {
            fanSpeed = FanSpeed.SPEED_1;
        } else if (i == 3) {
            fanSpeed = FanSpeed.SPEED_2;
        } else if (i == 4) {
            fanSpeed = FanSpeed.SPEED_3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new Pair(bleIcpController.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst(), ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid()), fanSpeed);
    }

    public final Observable<Pair<IcpDevice, FanMode>> getFanModeObservable() {
        Observable<R> map = this.blueairManager.isFanModeAutoObservable().map(new BleIcpController$$ExternalSyntheticLambda13(new BleIcpController$$ExternalSyntheticLambda12(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final Pair _get_fanModeObservable_$lambda$6(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair _get_fanModeObservable_$lambda$5(BleIcpController bleIcpController, Pair pair) {
        FanMode fanMode;
        Intrinsics.checkNotNullParameter(pair, "it");
        int i = WhenMappings.$EnumSwitchMapping$2[((com.airboxlab.icp.sdk.model.FanMode) pair.getSecond()).ordinal()];
        if (i == 1) {
            fanMode = FanMode.UNKNOWN;
        } else if (i == 2) {
            fanMode = FanMode.MANUAL;
        } else if (i == 3) {
            fanMode = FanMode.AUTO;
        } else if (i == 4) {
            fanMode = FanMode.MAX_SPEED;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new Pair(bleIcpController.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst(), ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid()), fanMode);
    }

    public final Observable<Pair<IcpDevice, DataPoint>> getDataPointObservable() {
        Observable<R> map = this.blueairManager.datapointStreamObservable().map(new BleIcpController$$ExternalSyntheticLambda5(new BleIcpController$$ExternalSyntheticLambda4(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final Pair _get_dataPointObservable_$lambda$8(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair _get_dataPointObservable_$lambda$7(BleIcpController bleIcpController, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return new Pair(bleIcpController.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst(), ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid()), new DataPoint(((Plantower) pair.getSecond()).getPm1(), ((Plantower) pair.getSecond()).getPm10(), ((Plantower) pair.getSecond()).getPm25(), new Date().getTime() / ((long) 1000)));
    }

    /* access modifiers changed from: private */
    public static final Pair _get_filterUsageObservable_$lambda$10(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (Pair) function1.invoke(obj);
    }

    public final Observable<Pair<IcpDevice, Integer>> getFilterUsageObservable() {
        Observable<R> map = this.blueairManager.filterUsageObservable().map(new BleIcpController$$ExternalSyntheticLambda1(new BleIcpController$$ExternalSyntheticLambda16(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final Pair _get_filterUsageObservable_$lambda$9(BleIcpController bleIcpController, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return new Pair(bleIcpController.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst(), ((com.airboxlab.icp.sdk.IcpDevice) pair.getFirst()).getUuid()), Integer.valueOf(((FilterUsage) pair.getSecond()).getFilterRemainingMinutes()));
    }

    public final void login(BlueairUser blueairUser) {
        Intrinsics.checkNotNullParameter(blueairUser, "blueairUser");
        this.blueairManager.setBlueAirUser(blueairUser);
    }

    public final void logout() {
        this.blueairManager.unsetBlueAirUser();
    }

    public final Single<IcpDevice> connect(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Single<R> flatMap = scan(30, 1).flatMap(new BleIcpController$$ExternalSyntheticLambda3(new BleIcpController$$ExternalSyntheticLambda2(this, str)));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    /* access modifiers changed from: private */
    public static final SingleSource connect$lambda$13(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (SingleSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final SingleSource connect$lambda$12(BleIcpController bleIcpController, String str, com.airboxlab.icp.sdk.IcpDevice[] icpDeviceArr) {
        Single single;
        Intrinsics.checkNotNullParameter(icpDeviceArr, "it");
        Timber.Forest forest = Timber.Forest;
        forest.d("Found ICP devices " + icpDeviceArr.length, new Object[0]);
        if (!(icpDeviceArr.length == 0)) {
            com.airboxlab.icp.sdk.IcpDevice icpDevice = icpDeviceArr[0];
            IcpDevice asIcpDevice = bleIcpController.asIcpDevice(icpDevice, str);
            Timber.Forest forest2 = Timber.Forest;
            forest2.i("About to connect " + asIcpDevice, new Object[0]);
            try {
                BlueAirManager.connect$default(bleIcpController.blueairManager, icpDevice, false, (Function2) new BleIcpController$$ExternalSyntheticLambda0(), 2, (Object) null);
            } catch (AlreadyConnectedException unused) {
                Timber.Forest forest3 = Timber.Forest;
                forest3.i("Already connected to " + asIcpDevice, new Object[0]);
                bleIcpController.currentConnectionStates.put(str, IcpDeviceConnectionState.CONNECTED);
            }
            single = Single.just(asIcpDevice);
            Intrinsics.checkNotNull(single);
        } else {
            Timber.Forest.d("No ICP found.", new Object[0]);
            single = Single.just(null);
            Intrinsics.checkNotNull(single);
        }
        return single;
    }

    /* access modifiers changed from: private */
    public static final Unit connect$lambda$12$lambda$11(com.airboxlab.icp.sdk.IcpDevice icpDevice, Throwable th) {
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("OnConnecting ");
        sb.append(icpDevice != null ? icpDevice.getUuid() : null);
        sb.append(", ");
        sb.append(th);
        forest.i(sb.toString(), new Object[0]);
        boolean z = th instanceof DeviceStuckInDfuModeException;
        return Unit.INSTANCE;
    }

    public final Single<IcpDevice> connect(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(str2, "macAddress");
        Single<IcpDevice> create = Single.create(new BleIcpController$$ExternalSyntheticLambda9(str2, str, this));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void connect$lambda$15(String str, String str2, BleIcpController bleIcpController, SingleEmitter singleEmitter) {
        String str3;
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        Timber.Forest forest = Timber.Forest;
        forest.d("Connect by mac address " + str + ", " + str2, new Object[0]);
        try {
            BlueAirManager blueAirManager = bleIcpController.blueairManager;
            String str4 = str;
            try {
                str3 = str4;
                try {
                    BlueAirManager.connect$default(blueAirManager, StringsKt.replace$default(str4, CertificateUtil.DELIMITER, "", false, 4, (Object) null), false, (Function2) new BleIcpController$$ExternalSyntheticLambda15(), 2, (Object) null);
                } catch (AlreadyConnectedException unused) {
                }
            } catch (AlreadyConnectedException unused2) {
                str3 = str4;
                Timber.Forest forest2 = Timber.Forest;
                forest2.i("Already connected to " + str3 + TokenParser.SP + str2, new Object[0]);
                bleIcpController.currentConnectionStates.put(str2, IcpDeviceConnectionState.CONNECTED);
                singleEmitter.onSuccess(new IcpDevice(bleIcpController.toMacAddress(str3), (String) null, str2));
            }
        } catch (AlreadyConnectedException unused3) {
            str3 = str;
            Timber.Forest forest22 = Timber.Forest;
            forest22.i("Already connected to " + str3 + TokenParser.SP + str2, new Object[0]);
            bleIcpController.currentConnectionStates.put(str2, IcpDeviceConnectionState.CONNECTED);
            singleEmitter.onSuccess(new IcpDevice(bleIcpController.toMacAddress(str3), (String) null, str2));
        }
        singleEmitter.onSuccess(new IcpDevice(bleIcpController.toMacAddress(str3), (String) null, str2));
    }

    /* access modifiers changed from: private */
    public static final Unit connect$lambda$15$lambda$14(com.airboxlab.icp.sdk.IcpDevice icpDevice, Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.i("OnConnecting " + icpDevice + ", " + th, new Object[0]);
        if (th instanceof DeviceStuckInDfuModeException) {
            Timber.Forest.i("Device is stuck in DFU, attempt to resume", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    public final void disconnect(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.blueairManager.stopDfu();
        for (com.airboxlab.icp.sdk.IcpDevice next : this.blueairManager.getDevices()) {
            Timber.Forest forest = Timber.Forest;
            forest.i("About to disconnect " + next.getUuid(), new Object[0]);
            if (next.getUuid() != null && StringsKt.equals$default(next.getUuid(), str, false, 2, (Object) null)) {
                this.blueairManager.disconnect(next);
            }
        }
    }

    private final IcpDevice asIcpDevice(com.airboxlab.icp.sdk.IcpDevice icpDevice, String str) {
        return new IcpDevice(icpDevice.getMacAddress(), icpDevice.getName(), str);
    }

    static /* synthetic */ Single scan$default(BleIcpController bleIcpController, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 30;
        }
        if ((i & 2) != 0) {
            j2 = Long.MAX_VALUE;
        }
        return bleIcpController.scan(j, j2);
    }

    private final Single<com.airboxlab.icp.sdk.IcpDevice[]> scan(long j, long j2) {
        Single<com.airboxlab.icp.sdk.IcpDevice[]> create = Single.create(new BleIcpController$$ExternalSyntheticLambda14(this, j, j2));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void scan$lambda$16(BleIcpController bleIcpController, long j, long j2, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        bleIcpController.blueairManager.scan(new DeviceSpec.IcpDeviceSpec(), j, j2, new BleIcpController$scan$1$1(singleEmitter));
    }

    private final com.airboxlab.icp.sdk.IcpDevice getInternalIcpDeviceBySerialUuid(String str) {
        boolean z;
        Collection arrayList = new ArrayList();
        for (Object next : this.blueairManager.getDevices()) {
            com.airboxlab.icp.sdk.IcpDevice icpDevice = (com.airboxlab.icp.sdk.IcpDevice) next;
            if (icpDevice.getCache().getDeviceInformation() != null) {
                IcpDeviceInformation deviceInformation = icpDevice.getCache().getDeviceInformation();
                Intrinsics.checkNotNull(deviceInformation);
                z = Intrinsics.areEqual((Object) deviceInformation.getSerialNumber(), (Object) str);
            } else {
                z = Intrinsics.areEqual((Object) icpDevice.getUuid(), (Object) str);
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return (com.airboxlab.icp.sdk.IcpDevice) CollectionsKt.getOrNull((List) arrayList, 0);
    }

    public final IcpDeviceConnectionState getConnectionState(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        com.airboxlab.icp.sdk.IcpDevice internalIcpDeviceBySerialUuid = getInternalIcpDeviceBySerialUuid(str);
        if (internalIcpDeviceBySerialUuid == null) {
            return IcpDeviceConnectionState.DISCONNECTED;
        }
        if (internalIcpDeviceBySerialUuid.isDisconnected()) {
            return IcpDeviceConnectionState.DISCONNECTED;
        }
        return IcpDeviceConnectionState.CONNECTED;
    }

    private final String toMacAddress(String str) {
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return str;
        }
        List emptyList = CollectionsKt.emptyList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, 11, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                int i2 = i + 2;
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                emptyList = CollectionsKt.plus(emptyList, substring);
                if (i == progressionLastElement) {
                    break;
                }
                i = i2;
            }
        }
        String upperCase = CollectionsKt.joinToString$default(emptyList, CertificateUtil.DELIMITER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public final void setFanSpeed(String str, FanSpeed fanSpeed) {
        com.airboxlab.icp.sdk.model.FanSpeed fanSpeed2;
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(fanSpeed, "fanSpeed");
        com.airboxlab.icp.sdk.IcpDevice internalIcpDeviceBySerialUuid = getInternalIcpDeviceBySerialUuid(str);
        if (internalIcpDeviceBySerialUuid != null) {
            Timber.Forest forest = Timber.Forest;
            forest.i("Setting fan speed (" + str + ", " + fanSpeed + ')', new Object[0]);
            BlueAirManager blueAirManager = this.blueairManager;
            int i = WhenMappings.$EnumSwitchMapping$3[fanSpeed.ordinal()];
            if (i == 1) {
                fanSpeed2 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_1;
            } else if (i == 2) {
                fanSpeed2 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_1;
            } else if (i == 3) {
                fanSpeed2 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_2;
            } else if (i == 4) {
                fanSpeed2 = com.airboxlab.icp.sdk.model.FanSpeed.SPEED_3;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            blueAirManager.setFanSpeed(internalIcpDeviceBySerialUuid, fanSpeed2);
        }
    }

    public final void setFanMode(String str, FanMode fanMode) {
        com.airboxlab.icp.sdk.model.FanMode fanMode2;
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(fanMode, "fanMode");
        Timber.Forest.d("setFanMode()...", new Object[0]);
        com.airboxlab.icp.sdk.IcpDevice internalIcpDeviceBySerialUuid = getInternalIcpDeviceBySerialUuid(str);
        if (internalIcpDeviceBySerialUuid != null) {
            Timber.Forest forest = Timber.Forest;
            forest.i("Setting fan mode (" + str + ", " + fanMode + ')', new Object[0]);
            int i = WhenMappings.$EnumSwitchMapping$4[fanMode.ordinal()];
            if (i == 1) {
                fanMode2 = com.airboxlab.icp.sdk.model.FanMode.MANUAL;
            } else if (i != 2) {
                fanMode2 = com.airboxlab.icp.sdk.model.FanMode.UNKNOWN;
            } else {
                fanMode2 = com.airboxlab.icp.sdk.model.FanMode.AUTO;
            }
            if (fanMode2 == com.airboxlab.icp.sdk.model.FanMode.UNKNOWN) {
                Timber.Forest.w("Only AUTO or MANUAL fan mode supported.", new Object[0]);
            } else {
                this.blueairManager.setFanMode(internalIcpDeviceBySerialUuid, fanMode2, new BleIcpController$$ExternalSyntheticLambda8());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit setFanMode$lambda$18(com.airboxlab.icp.sdk.model.FanMode fanMode) {
        Intrinsics.checkNotNullParameter(fanMode, "it");
        Timber.Forest.d("Set fan mode", new Object[0]);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lio/flatcircle/ble/BleIcpController$IcpDeviceConnection;", "", "connectionState", "Lio/flatcircle/ble/BleIcpController$IcpDeviceConnectionState;", "device", "Lio/flatcircle/ble/BleIcpController$IcpDevice;", "<init>", "(Lio/flatcircle/ble/BleIcpController$IcpDeviceConnectionState;Lio/flatcircle/ble/BleIcpController$IcpDevice;)V", "getConnectionState", "()Lio/flatcircle/ble/BleIcpController$IcpDeviceConnectionState;", "getDevice", "()Lio/flatcircle/ble/BleIcpController$IcpDevice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public static final class IcpDeviceConnection {
        private final IcpDeviceConnectionState connectionState;
        private final IcpDevice device;

        public static /* synthetic */ IcpDeviceConnection copy$default(IcpDeviceConnection icpDeviceConnection, IcpDeviceConnectionState icpDeviceConnectionState, IcpDevice icpDevice, int i, Object obj) {
            if ((i & 1) != 0) {
                icpDeviceConnectionState = icpDeviceConnection.connectionState;
            }
            if ((i & 2) != 0) {
                icpDevice = icpDeviceConnection.device;
            }
            return icpDeviceConnection.copy(icpDeviceConnectionState, icpDevice);
        }

        public final IcpDeviceConnectionState component1() {
            return this.connectionState;
        }

        public final IcpDevice component2() {
            return this.device;
        }

        public final IcpDeviceConnection copy(IcpDeviceConnectionState icpDeviceConnectionState, IcpDevice icpDevice) {
            Intrinsics.checkNotNullParameter(icpDeviceConnectionState, "connectionState");
            return new IcpDeviceConnection(icpDeviceConnectionState, icpDevice);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IcpDeviceConnection)) {
                return false;
            }
            IcpDeviceConnection icpDeviceConnection = (IcpDeviceConnection) obj;
            return this.connectionState == icpDeviceConnection.connectionState && Intrinsics.areEqual((Object) this.device, (Object) icpDeviceConnection.device);
        }

        public int hashCode() {
            int hashCode = this.connectionState.hashCode() * 31;
            IcpDevice icpDevice = this.device;
            return hashCode + (icpDevice == null ? 0 : icpDevice.hashCode());
        }

        public String toString() {
            return "IcpDeviceConnection(connectionState=" + this.connectionState + ", device=" + this.device + ')';
        }

        public IcpDeviceConnection(IcpDeviceConnectionState icpDeviceConnectionState, IcpDevice icpDevice) {
            Intrinsics.checkNotNullParameter(icpDeviceConnectionState, "connectionState");
            this.connectionState = icpDeviceConnectionState;
            this.device = icpDevice;
        }

        public final IcpDeviceConnectionState getConnectionState() {
            return this.connectionState;
        }

        public final IcpDevice getDevice() {
            return this.device;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/flatcircle/ble/BleIcpController$IcpDeviceConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "CONNECTED", "DISCONNECTING", "DISCONNECTED", "UNKNOWN", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public enum IcpDeviceConnectionState {
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED,
        UNKNOWN;

        public static EnumEntries<IcpDeviceConnectionState> getEntries() {
            return $ENTRIES;
        }

        static {
            IcpDeviceConnectionState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lio/flatcircle/ble/BleIcpController$IcpDevice;", "", "macAddress", "", "name", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMacAddress", "()Ljava/lang/String;", "getName", "getUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public static final class IcpDevice {
        private final String macAddress;
        private final String name;
        private final String uuid;

        public static /* synthetic */ IcpDevice copy$default(IcpDevice icpDevice, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = icpDevice.macAddress;
            }
            if ((i & 2) != 0) {
                str2 = icpDevice.name;
            }
            if ((i & 4) != 0) {
                str3 = icpDevice.uuid;
            }
            return icpDevice.copy(str, str2, str3);
        }

        public final String component1() {
            return this.macAddress;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.uuid;
        }

        public final IcpDevice copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "macAddress");
            return new IcpDevice(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IcpDevice)) {
                return false;
            }
            IcpDevice icpDevice = (IcpDevice) obj;
            return Intrinsics.areEqual((Object) this.macAddress, (Object) icpDevice.macAddress) && Intrinsics.areEqual((Object) this.name, (Object) icpDevice.name) && Intrinsics.areEqual((Object) this.uuid, (Object) icpDevice.uuid);
        }

        public int hashCode() {
            int hashCode = this.macAddress.hashCode() * 31;
            String str = this.name;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.uuid;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "IcpDevice(macAddress=" + this.macAddress + ", name=" + this.name + ", uuid=" + this.uuid + ')';
        }

        public IcpDevice(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "macAddress");
            this.macAddress = str;
            this.name = str2;
            this.uuid = str3;
        }

        public final String getMacAddress() {
            return this.macAddress;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUuid() {
            return this.uuid;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/flatcircle/ble/BleIcpController$FanSpeed;", "", "<init>", "(Ljava/lang/String;I)V", "SPEED_0", "SPEED_1", "SPEED_2", "SPEED_3", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public enum FanSpeed {
        SPEED_0,
        SPEED_1,
        SPEED_2,
        SPEED_3;

        public static EnumEntries<FanSpeed> getEntries() {
            return $ENTRIES;
        }

        static {
            FanSpeed[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/flatcircle/ble/BleIcpController$FanMode;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MANUAL", "AUTO", "MAX_SPEED", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public enum FanMode {
        UNKNOWN,
        MANUAL,
        AUTO,
        MAX_SPEED;

        public static EnumEntries<FanMode> getEntries() {
            return $ENTRIES;
        }

        static {
            FanMode[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lio/flatcircle/ble/BleIcpController$DataPoint;", "", "pm1", "", "pm10", "pm25", "timestamp", "", "<init>", "(IIIJ)V", "getPm1", "()I", "setPm1", "(I)V", "getPm10", "setPm10", "getPm25", "setPm25", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleIcpController.kt */
    public static final class DataPoint {
        private int pm1;
        private int pm10;
        private int pm25;
        private long timestamp;

        public static /* synthetic */ DataPoint copy$default(DataPoint dataPoint, int i, int i2, int i3, long j, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = dataPoint.pm1;
            }
            if ((i4 & 2) != 0) {
                i2 = dataPoint.pm10;
            }
            if ((i4 & 4) != 0) {
                i3 = dataPoint.pm25;
            }
            if ((i4 & 8) != 0) {
                j = dataPoint.timestamp;
            }
            long j2 = j;
            return dataPoint.copy(i, i2, i3, j2);
        }

        public final int component1() {
            return this.pm1;
        }

        public final int component2() {
            return this.pm10;
        }

        public final int component3() {
            return this.pm25;
        }

        public final long component4() {
            return this.timestamp;
        }

        public final DataPoint copy(int i, int i2, int i3, long j) {
            return new DataPoint(i, i2, i3, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataPoint)) {
                return false;
            }
            DataPoint dataPoint = (DataPoint) obj;
            return this.pm1 == dataPoint.pm1 && this.pm10 == dataPoint.pm10 && this.pm25 == dataPoint.pm25 && this.timestamp == dataPoint.timestamp;
        }

        public int hashCode() {
            return (((((this.pm1 * 31) + this.pm10) * 31) + this.pm25) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timestamp);
        }

        public String toString() {
            return "DataPoint(pm1=" + this.pm1 + ", pm10=" + this.pm10 + ", pm25=" + this.pm25 + ", timestamp=" + this.timestamp + ')';
        }

        public DataPoint(int i, int i2, int i3, long j) {
            this.pm1 = i;
            this.pm10 = i2;
            this.pm25 = i3;
            this.timestamp = j;
        }

        public final int getPm1() {
            return this.pm1;
        }

        public final void setPm1(int i) {
            this.pm1 = i;
        }

        public final int getPm10() {
            return this.pm10;
        }

        public final void setPm10(int i) {
            this.pm10 = i;
        }

        public final int getPm25() {
            return this.pm25;
        }

        public final void setPm25(int i) {
            this.pm25 = i;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final void setTimestamp(long j) {
            this.timestamp = j;
        }
    }
}
