package com.blueair.devicemanager;

import com.airboxlab.icp.sdk.BlueAirManager;
import com.airboxlab.icp.sdk.DeviceConnectionState;
import com.airboxlab.icp.sdk.DeviceSpec;
import com.airboxlab.icp.sdk.IcpDevice;
import com.airboxlab.icp.sdk.IcpDeviceInformation;
import com.polidea.rxandroidble2.RxBleClient;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rJ(\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b`\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00168F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00168F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019¨\u0006%"}, d2 = {"Lcom/blueair/devicemanager/IcpDeviceManager;", "", "blueairManager", "Lcom/airboxlab/icp/sdk/BlueAirManager;", "<init>", "(Lcom/airboxlab/icp/sdk/BlueAirManager;)V", "currentConnectionStates", "Ljava/util/HashMap;", "", "Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "Lkotlin/collections/HashMap;", "macAddressToUuid", "pair", "Lio/reactivex/Single;", "Lcom/blueair/devicemanager/IcpDevice;", "scan", "", "Lcom/airboxlab/icp/sdk/IcpDevice;", "timeoutSeconds", "", "maxDevices", "deviceInfoObservable", "Lio/reactivex/Observable;", "Lcom/blueair/devicemanager/IcpDeviceInfo;", "getDeviceInfoObservable", "()Lio/reactivex/Observable;", "asIcpDevice", "d", "uuid", "bleClientStateObservable", "Lcom/blueair/devicemanager/IcpDeviceManager$BluetoothClientState;", "getBleClientStateObservable", "connectionStateObservable", "Lcom/blueair/devicemanager/IcpDeviceConnection;", "getConnectionStateObservable", "IcpDeviceConnectionState", "BluetoothClientState", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IcpDeviceManager.kt */
public final class IcpDeviceManager {
    private final BlueAirManager blueairManager;
    private HashMap<String, IcpDeviceConnectionState> currentConnectionStates = new HashMap<>();
    private HashMap<String, String> macAddressToUuid = new HashMap<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IcpDeviceManager.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005d */
        static {
            /*
                com.polidea.rxandroidble2.RxBleClient$State[] r0 = com.polidea.rxandroidble2.RxBleClient.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.polidea.rxandroidble2.RxBleClient$State r2 = com.polidea.rxandroidble2.RxBleClient.State.BLUETOOTH_NOT_ENABLED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.polidea.rxandroidble2.RxBleClient$State r3 = com.polidea.rxandroidble2.RxBleClient.State.BLUETOOTH_NOT_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.polidea.rxandroidble2.RxBleClient$State r4 = com.polidea.rxandroidble2.RxBleClient.State.LOCATION_PERMISSION_NOT_GRANTED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.polidea.rxandroidble2.RxBleClient$State r5 = com.polidea.rxandroidble2.RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.polidea.rxandroidble2.RxBleClient$State r6 = com.polidea.rxandroidble2.RxBleClient.State.READY     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                com.airboxlab.icp.sdk.DeviceConnectionState[] r0 = com.airboxlab.icp.sdk.DeviceConnectionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.airboxlab.icp.sdk.DeviceConnectionState r6 = com.airboxlab.icp.sdk.DeviceConnectionState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.airboxlab.icp.sdk.DeviceConnectionState r1 = com.airboxlab.icp.sdk.DeviceConnectionState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.airboxlab.icp.sdk.DeviceConnectionState r1 = com.airboxlab.icp.sdk.DeviceConnectionState.DISCONNECTING     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.airboxlab.icp.sdk.DeviceConnectionState r1 = com.airboxlab.icp.sdk.DeviceConnectionState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.airboxlab.icp.sdk.DeviceConnectionState r1 = com.airboxlab.icp.sdk.DeviceConnectionState.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.IcpDeviceManager.WhenMappings.<clinit>():void");
        }
    }

    public IcpDeviceManager(BlueAirManager blueAirManager) {
        Intrinsics.checkNotNullParameter(blueAirManager, "blueairManager");
        this.blueairManager = blueAirManager;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "CONNECTED", "DISCONNECTING", "DISCONNECTED", "UNKNOWN", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IcpDeviceManager.kt */
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/blueair/devicemanager/IcpDeviceManager$BluetoothClientState;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH_NOT_AVAILABLE", "LOCATION_PERMISSION_NOT_GRANTED", "BLUETOOTH_NOT_ENABLED", "LOCATION_SERVICES_NOT_ENABLED", "READY", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IcpDeviceManager.kt */
    public enum BluetoothClientState {
        BLUETOOTH_NOT_AVAILABLE,
        LOCATION_PERMISSION_NOT_GRANTED,
        BLUETOOTH_NOT_ENABLED,
        LOCATION_SERVICES_NOT_ENABLED,
        READY;

        public static EnumEntries<BluetoothClientState> getEntries() {
            return $ENTRIES;
        }

        static {
            BluetoothClientState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final Single<IcpDevice> pair() {
        Single<R> flatMap = scan(30, 1).flatMap(new IcpDeviceManager$$ExternalSyntheticLambda5(new IcpDeviceManager$$ExternalSyntheticLambda4(this)));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    /* access modifiers changed from: private */
    public static final SingleSource pair$lambda$2(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (SingleSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final SingleSource pair$lambda$1(IcpDeviceManager icpDeviceManager, IcpDevice[] icpDeviceArr) {
        Single single;
        Intrinsics.checkNotNullParameter(icpDeviceArr, "it");
        if (!(icpDeviceArr.length == 0)) {
            IcpDevice icpDevice = icpDeviceArr[0];
            IcpDevice icpDevice2 = new IcpDevice(icpDevice.getMacAddress(), icpDevice.getName(), icpDevice.getUuid());
            BlueAirManager.connect$default(icpDeviceManager.blueairManager, icpDevice, false, (Function2) new IcpDeviceManager$$ExternalSyntheticLambda3(), 2, (Object) null);
            single = Single.just(icpDevice2);
            Intrinsics.checkNotNull(single);
        } else {
            Timber.Forest.d("No device found.", new Object[0]);
            single = Single.just(null);
            Intrinsics.checkNotNull(single);
        }
        return single;
    }

    /* access modifiers changed from: private */
    public static final Unit pair$lambda$1$lambda$0(IcpDevice icpDevice, Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.i("ICPOnConnecting " + icpDevice + ", " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Single scan$default(IcpDeviceManager icpDeviceManager, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 30;
        }
        if ((i & 2) != 0) {
            j2 = Long.MAX_VALUE;
        }
        return icpDeviceManager.scan(j, j2);
    }

    private final Single<IcpDevice[]> scan(long j, long j2) {
        Single<IcpDevice[]> create = Single.create(new IcpDeviceManager$$ExternalSyntheticLambda0(this, j, j2));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void scan$lambda$3(IcpDeviceManager icpDeviceManager, long j, long j2, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        icpDeviceManager.blueairManager.scan(new DeviceSpec.IcpDeviceSpec(), j, j2, new IcpDeviceManager$scan$1$1(singleEmitter));
    }

    public final Observable<IcpDeviceInfo> getDeviceInfoObservable() {
        Observable<R> map = this.blueairManager.deviceInfoObservable().map(new IcpDeviceManager$$ExternalSyntheticLambda9(new IcpDeviceManager$$ExternalSyntheticLambda8(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final IcpDeviceInfo _get_deviceInfoObservable_$lambda$5(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (IcpDeviceInfo) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final IcpDeviceInfo _get_deviceInfoObservable_$lambda$4(IcpDeviceManager icpDeviceManager, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return new IcpDeviceInfo(icpDeviceManager.asIcpDevice((IcpDevice) pair.getFirst()), ((IcpDeviceInformation) pair.getSecond()).getFirmwareChildMain(), ((IcpDeviceInformation) pair.getSecond()).getFirmwareChildPlug(), ((IcpDeviceInformation) pair.getSecond()).getFirmwareRevision(), ((IcpDeviceInformation) pair.getSecond()).getHardwareRevision(), ((IcpDeviceInformation) pair.getSecond()).getMacAddress(), ((IcpDeviceInformation) pair.getSecond()).getManufacturerName(), ((IcpDeviceInformation) pair.getSecond()).getSerialNumber());
    }

    private final IcpDevice asIcpDevice(IcpDevice icpDevice) {
        return new IcpDevice(icpDevice.getMacAddress(), icpDevice.getName(), icpDevice.getUuid());
    }

    private final IcpDevice asIcpDevice(IcpDevice icpDevice, String str) {
        return new IcpDevice(icpDevice.getMacAddress(), icpDevice.getName(), str);
    }

    public final Observable<BluetoothClientState> getBleClientStateObservable() {
        Observable<R> map = this.blueairManager.managerStateObservable().map(new IcpDeviceManager$$ExternalSyntheticLambda2(new IcpDeviceManager$$ExternalSyntheticLambda1()));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final BluetoothClientState _get_bleClientStateObservable_$lambda$7(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (BluetoothClientState) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final BluetoothClientState _get_bleClientStateObservable_$lambda$6(RxBleClient.State state) {
        Intrinsics.checkNotNullParameter(state, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return BluetoothClientState.BLUETOOTH_NOT_ENABLED;
        }
        if (i == 2) {
            return BluetoothClientState.BLUETOOTH_NOT_AVAILABLE;
        }
        if (i == 3) {
            return BluetoothClientState.LOCATION_PERMISSION_NOT_GRANTED;
        }
        if (i == 4) {
            return BluetoothClientState.LOCATION_SERVICES_NOT_ENABLED;
        }
        if (i == 5) {
            return BluetoothClientState.READY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Observable<IcpDeviceConnection> getConnectionStateObservable() {
        Observable<R> map = this.blueairManager.connectionStateObservable().map(new IcpDeviceManager$$ExternalSyntheticLambda7(new IcpDeviceManager$$ExternalSyntheticLambda6(this)));
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* access modifiers changed from: private */
    public static final IcpDeviceConnection _get_connectionStateObservable_$lambda$9(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (IcpDeviceConnection) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final IcpDeviceConnection _get_connectionStateObservable_$lambda$8(IcpDeviceManager icpDeviceManager, Pair pair) {
        IcpDeviceConnectionState icpDeviceConnectionState;
        String str;
        Intrinsics.checkNotNullParameter(pair, "it");
        int i = WhenMappings.$EnumSwitchMapping$1[((DeviceConnectionState) pair.getSecond()).ordinal()];
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
        forest.i("Connection state changed " + pair.getSecond() + " for " + ((IcpDevice) pair.getFirst()).getUuid() + ", " + ((IcpDevice) pair.getFirst()).getMacAddress(), new Object[0]);
        if (((IcpDevice) pair.getFirst()).getCache().getDeviceInformation() != null) {
            IcpDeviceInformation deviceInformation = ((IcpDevice) pair.getFirst()).getCache().getDeviceInformation();
            str = deviceInformation != null ? deviceInformation.getSerialNumber() : null;
        } else if (((IcpDevice) pair.getFirst()).getUuid() != null) {
            str = icpDeviceManager.macAddressToUuid.get(((IcpDevice) pair.getFirst()).getUuid());
        } else {
            str = icpDeviceManager.macAddressToUuid.get(((IcpDevice) pair.getFirst()).getMacAddress());
        }
        if (str != null) {
            icpDeviceManager.currentConnectionStates.put(str, icpDeviceConnectionState);
        }
        IcpDevice asIcpDevice = icpDeviceManager.asIcpDevice((IcpDevice) pair.getFirst(), str);
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("Update connection state for " + icpDeviceConnectionState + ", " + asIcpDevice.getUuid() + ", " + asIcpDevice.getMacAddress(), new Object[0]);
        return new IcpDeviceConnection(icpDeviceConnectionState, asIcpDevice);
    }
}
