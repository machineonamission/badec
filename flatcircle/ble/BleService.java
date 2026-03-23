package io.flatcircle.ble;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.IndoorDatapoint;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.ble.BleIcpController;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0012J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0015H\u0007J\u0006\u0010\u001d\u001a\u00020\u0015J\u001a\u0010!\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0014\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u00100\u001a\u00020+H\u0002J\u0014\u00101\u001a\u00020\u00152\n\u00102\u001a\u0006\u0012\u0002\b\u00030\nH\u0002J\u0016\u00103\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u00107\u001a\u00020)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR8\u0010\u000f\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012 \u0013*\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00110\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00150\u00150\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0017X\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020 0\u00110\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020#0\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u000209X\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lio/flatcircle/ble/BleService;", "Lkotlinx/coroutines/CoroutineScope;", "bleIcpController", "Lio/flatcircle/ble/BleIcpController;", "<init>", "(Lio/flatcircle/ble/BleIcpController;)V", "lastPingTime", "", "_eventObservable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/flatcircle/ble/BleEvent;", "eventObservable", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventObservable", "()Lkotlinx/coroutines/flow/SharedFlow;", "connectSubject", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "initializeSubject", "", "registeredUuids", "", "register", "uuid", "macAddress", "unregister", "onResume", "subscribe", "pingJobs", "", "Lkotlinx/coroutines/Job;", "startPingJob", "pingCounters", "", "pingLock", "", "resetPingCounter", "incrementPingCounter", "attemptToConnectKnownDevices", "", "getConnectionState", "Lio/flatcircle/ble/BleIcpController$IcpDeviceConnectionState;", "devices", "", "Lcom/blueair/core/model/Device;", "sendConnectionUpdateEvent", "cs", "sendEvent", "bleEvent", "setFanSpeed", "fanSpeed", "Lio/flatcircle/ble/BleIcpController$FanSpeed;", "setAutoMode", "enabled", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService implements CoroutineScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long PINGED_STATUS_UPDATE_DELAY = 5000;
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    /* access modifiers changed from: private */
    public final MutableSharedFlow<BleEvent<?>> _eventObservable;
    /* access modifiers changed from: private */
    public final BleIcpController bleIcpController;
    private final PublishSubject<Pair<String, String>> connectSubject;
    private final PublishSubject<Unit> initializeSubject;
    /* access modifiers changed from: private */
    public long lastPingTime;
    private final Map<String, Integer> pingCounters;
    /* access modifiers changed from: private */
    public final List<Pair<String, Job>> pingJobs;
    private final Object pingLock;
    private final Map<String, String> registeredUuids;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public BleService(BleIcpController bleIcpController2) {
        Intrinsics.checkNotNullParameter(bleIcpController2, "bleIcpController");
        this.bleIcpController = bleIcpController2;
        this._eventObservable = SharedFlowKt.MutableSharedFlow$default(0, 64, (BufferOverflow) null, 5, (Object) null);
        PublishSubject<Pair<String, String>> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.connectSubject = create;
        PublishSubject<Unit> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        this.initializeSubject = create2;
        this.registeredUuids = new LinkedHashMap();
        this.pingJobs = new ArrayList();
        this.pingCounters = new LinkedHashMap();
        this.pingLock = new Object();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/flatcircle/ble/BleService$Companion;", "", "<init>", "()V", "PINGED_STATUS_UPDATE_DELAY", "", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SharedFlow<BleEvent<?>> getEventObservable() {
        return this._eventObservable;
    }

    public final void register(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Timber.Forest forest = Timber.Forest;
        forest.d("Register device " + str, new Object[0]);
        register(str, (String) null);
    }

    public final void register(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Timber.Forest forest = Timber.Forest;
        forest.d("Register device " + str + ", " + str2, new Object[0]);
        this.registeredUuids.put(str, str2);
        resetPingCounter(str);
        startPingJob(str, str2);
        this.connectSubject.onNext(new Pair(str, str2));
    }

    public final void unregister(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Timber.Forest forest = Timber.Forest;
        forest.d("Unregister device " + str, new Object[0]);
        this.registeredUuids.remove(str);
        this.bleIcpController.disconnect(str);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        subscribe();
    }

    public final void subscribe() {
        Timber.Forest.d("Subscribing...", new Object[0]);
        this.bleIcpController.getConnectionStateObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BleService$$ExternalSyntheticLambda3(new BleService$$ExternalSyntheticLambda11(this)));
        this.connectSubject.throttleFirst(15, TimeUnit.SECONDS).filter(new BleService$$ExternalSyntheticLambda20(new BleService$$ExternalSyntheticLambda15(this))).filter(new BleService$$ExternalSyntheticLambda23(new BleService$$ExternalSyntheticLambda21(this))).switchMap(new BleService$$ExternalSyntheticLambda25(new BleService$$ExternalSyntheticLambda24(this))).subscribe(new BleService$$ExternalSyntheticLambda27(new BleService$$ExternalSyntheticLambda26(this)), new BleService$$ExternalSyntheticLambda28(new BleService$$ExternalSyntheticLambda22(this)));
        this.initializeSubject.switchMap(new BleService$$ExternalSyntheticLambda30(new BleService$$ExternalSyntheticLambda29(this))).subscribe(new BleService$$ExternalSyntheticLambda32(new BleService$$ExternalSyntheticLambda31()), new BleService$$ExternalSyntheticLambda34(new BleService$$ExternalSyntheticLambda33()));
        RxExtensionsKt.filterRapidClicks(this.bleIcpController.getFanSpeedObservable()).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new BleService$$ExternalSyntheticLambda2(new BleService$$ExternalSyntheticLambda1(this)), new BleService$$ExternalSyntheticLambda5(new BleService$$ExternalSyntheticLambda4()));
        this.bleIcpController.getFanModeObservable().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new BleService$$ExternalSyntheticLambda7(new BleService$$ExternalSyntheticLambda6(this)), new BleService$$ExternalSyntheticLambda9(new BleService$$ExternalSyntheticLambda8()));
        this.bleIcpController.getDataPointObservable().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new BleService$$ExternalSyntheticLambda12(new BleService$$ExternalSyntheticLambda10(this)), new BleService$$ExternalSyntheticLambda14(new BleService$$ExternalSyntheticLambda13()));
        this.bleIcpController.getFilterUsageObservable().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new BleService$$ExternalSyntheticLambda17(new BleService$$ExternalSyntheticLambda16(this)), new BleService$$ExternalSyntheticLambda19(new BleService$$ExternalSyntheticLambda18()));
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$0(BleService bleService, BleIcpController.IcpDeviceConnection icpDeviceConnection) {
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("Connection state changed ");
        sb.append(icpDeviceConnection.getConnectionState());
        sb.append(", ");
        BleIcpController.IcpDevice device = icpDeviceConnection.getDevice();
        String str = null;
        sb.append(device != null ? device.getUuid() : null);
        sb.append(", ");
        BleIcpController.IcpDevice device2 = icpDeviceConnection.getDevice();
        sb.append(device2 != null ? device2.getMacAddress() : null);
        forest.d(sb.toString(), new Object[0]);
        BleIcpController.IcpDevice device3 = icpDeviceConnection.getDevice();
        if (device3 != null) {
            str = device3.getUuid();
        }
        if (str != null) {
            Timber.Forest.d("Clear filter opened status", new Object[0]);
            if ((icpDeviceConnection.getConnectionState() == BleIcpController.IcpDeviceConnectionState.DISCONNECTED || icpDeviceConnection.getConnectionState() == BleIcpController.IcpDeviceConnectionState.UNKNOWN) && bleService.registeredUuids.containsKey(icpDeviceConnection.getDevice().getUuid())) {
                Timber.Forest forest2 = Timber.Forest;
                forest2.i("Connection dropped, reconnect to " + icpDeviceConnection.getDevice().getUuid(), new Object[0]);
            }
            if (icpDeviceConnection.getConnectionState() == BleIcpController.IcpDeviceConnectionState.CONNECTED) {
                Timber.Forest.d("Check for firmware.", new Object[0]);
                Timber.Forest.d("Check for errors.", new Object[0]);
            }
        } else {
            Timber.Forest.i("UUID was null", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final boolean subscribe$lambda$3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean subscribe$lambda$2(BleService bleService, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        Timber.Forest forest = Timber.Forest;
        forest.d("connectSubject: contains registeredUuids: " + bleService.registeredUuids.containsKey(pair.getFirst()), new Object[0]);
        return bleService.registeredUuids.containsKey(pair.getFirst());
    }

    /* access modifiers changed from: private */
    public static final boolean subscribe$lambda$5(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean subscribe$lambda$4(BleService bleService, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        BleIcpController.IcpDeviceConnectionState connectionState = bleService.bleIcpController.getConnectionState((String) pair.getFirst());
        Timber.Forest forest = Timber.Forest;
        forest.d("connectSubject: conectionState == " + connectionState, new Object[0]);
        if (connectionState != BleIcpController.IcpDeviceConnectionState.CONNECTED) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final ObservableSource subscribe$lambda$7(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (ObservableSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ObservableSource subscribe$lambda$6(BleService bleService, Pair pair) {
        Observable<BleIcpController.IcpDevice> observable;
        Intrinsics.checkNotNullParameter(pair, "it");
        if (pair.getSecond() == null) {
            Timber.Forest.d("connectSubject: calling connect() - uuid only", new Object[0]);
            observable = bleService.bleIcpController.connect((String) pair.getFirst()).toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        } else {
            Timber.Forest.d("connectSubject: calling connect() -- uuid and mac", new Object[0]);
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second);
            observable = bleService.bleIcpController.connect((String) pair.getFirst(), (String) second).toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
        return observable;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$9(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$8(BleService bleService, BleIcpController.IcpDevice icpDevice) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Connection about to be established " + icpDevice, new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("connectSubject: subscribed result == " + icpDevice, new Object[0]);
        if ((icpDevice != null ? icpDevice.getUuid() : null) == null) {
            bleService.initializeSubject.onNext(Unit.INSTANCE);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(bleService, (CoroutineContext) null, (CoroutineStart) null, new BleService$subscribe$5$1(bleService, icpDevice, (Continuation<? super BleService$subscribe$5$1>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$11(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$10(BleService bleService, Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.w("Connection failed " + th, new Object[0]);
        bleService.initializeSubject.onNext(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final ObservableSource subscribe$lambda$14(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (ObservableSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ObservableSource subscribe$lambda$13(BleService bleService, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return Observable.fromCallable(new BleService$$ExternalSyntheticLambda0(bleService)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public static final Boolean subscribe$lambda$13$lambda$12(BleService bleService) {
        return Boolean.valueOf(bleService.attemptToConnectKnownDevices());
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$16(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$15(Boolean bool) {
        Timber.Forest.d("Initialized", new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$18(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$17(Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.w("Initialized failed " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$21(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$20(BleService bleService, Pair pair) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Got fan speed " + pair.getSecond(), new Object[0]);
        String uuid = ((BleIcpController.IcpDevice) pair.getFirst()).getUuid();
        if (uuid != null) {
            bleService.sendEvent(new BleEvent(uuid, new DeviceStreamAttribute.FanSpeed(((BleIcpController.FanSpeed) pair.getSecond()).ordinal())));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$23(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$22(Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.w("Failed to read fan speed: " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$26(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$25(BleService bleService, Pair pair) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Got fan mode " + pair.getSecond() + " -- fanModeOberservable - origin from device", new Object[0]);
        String uuid = ((BleIcpController.IcpDevice) pair.getFirst()).getUuid();
        if (uuid != null) {
            String lowerCase = ((BleIcpController.FanMode) pair.getSecond()).name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            bleService.sendEvent(new BleEvent(uuid, new DeviceStreamAttribute.AutoMode(lowerCase)));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$28(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$27(Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.w("Failed to read fan mode: " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$31(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$30(BleService bleService, Pair pair) {
        String uuid = ((BleIcpController.IcpDevice) pair.getFirst()).getUuid();
        if (uuid != null) {
            BleIcpController.DataPoint dataPoint = (BleIcpController.DataPoint) pair.getSecond();
            bleService.sendEvent(new BleEvent(uuid, new IndoorDatapoint(dataPoint.getTimestamp(), Float.valueOf((float) dataPoint.getPm1()), Float.valueOf((float) dataPoint.getPm10()), Float.valueOf((float) dataPoint.getPm25()), (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null)));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$33(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$32(Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.w("Failed to read datapoints: " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$36(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$35(BleService bleService, Pair pair) {
        String uuid = ((BleIcpController.IcpDevice) pair.getFirst()).getUuid();
        if (uuid != null) {
            bleService.sendEvent(new BleEvent(uuid, new DeviceStreamAttribute.FilterUsage(((Number) pair.getSecond()).intValue())));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void subscribe$lambda$38(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit subscribe$lambda$37(Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.w("Failed to read filterUsage: " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: kotlin.Pair} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startPingJob(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Resetting old job"
            r0.v(r3, r2)
            java.util.List<kotlin.Pair<java.lang.String, kotlinx.coroutines.Job>> r0 = r12.pingJobs
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r2 = 0
            if (r0 != 0) goto L_0x003b
            java.util.List<kotlin.Pair<java.lang.String, kotlinx.coroutines.Job>> r0 = r12.pingJobs
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r0.next()
            r4 = r3
            kotlin.Pair r4 = (kotlin.Pair) r4
            if (r4 != 0) goto L_0x002e
            r4 = r1
            goto L_0x0036
        L_0x002e:
            java.lang.Object r4 = r4.getFirst()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r13)
        L_0x0036:
            if (r4 == 0) goto L_0x001d
            r2 = r3
        L_0x0039:
            kotlin.Pair r2 = (kotlin.Pair) r2
        L_0x003b:
            r4 = r2
            java.util.List<kotlin.Pair<java.lang.String, kotlinx.coroutines.Job>> r0 = r12.pingJobs
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x0043:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r0.next()
            kotlin.Pair r3 = (kotlin.Pair) r3
            if (r3 != 0) goto L_0x0053
            r3 = r1
            goto L_0x005b
        L_0x0053:
            java.lang.Object r3 = r3.getFirst()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r13)
        L_0x005b:
            if (r3 == 0) goto L_0x005e
            goto L_0x0062
        L_0x005e:
            int r2 = r2 + 1
            goto L_0x0043
        L_0x0061:
            r2 = -1
        L_0x0062:
            r5 = r2
            r0 = r12
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            io.flatcircle.ble.BleService$startPingJob$1 r3 = new io.flatcircle.ble.BleService$startPingJob$1
            r9 = 0
            r6 = r12
            r7 = r13
            r8 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r9 = r3
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            r6 = r0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.ble.BleService.startPingJob(java.lang.String, java.lang.String):void");
    }

    private final void resetPingCounter(String str) {
        synchronized (this.pingLock) {
            if (this.pingCounters.containsKey(str)) {
                this.pingCounters.put(str, 0);
            } else {
                this.pingCounters.put(str, 0);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void incrementPingCounter(String str) {
        synchronized (this.pingLock) {
            Timber.Forest forest = Timber.Forest;
            forest.d("PingCounter = " + this.pingCounters, new Object[0]);
            if (this.pingCounters.containsKey(str)) {
                this.pingCounters.put(str, Integer.valueOf(((Number) MapsKt.getValue(this.pingCounters, str)).intValue() + 1));
            } else {
                this.pingCounters.put(str, 1);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final boolean attemptToConnectKnownDevices() {
        for (Map.Entry next : this.registeredUuids.entrySet()) {
            register((String) next.getKey(), (String) next.getValue());
        }
        return true;
    }

    public final BleIcpController.IcpDeviceConnectionState getConnectionState(List<? extends Device> list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        return this.bleIcpController.getConnectionState(((Device) list.get(0)).getUid());
    }

    /* access modifiers changed from: private */
    public final void sendConnectionUpdateEvent(String str, BleIcpController.IcpDeviceConnectionState icpDeviceConnectionState) {
        Timber.Forest forest = Timber.Forest;
        forest.d("sendConnectionUpdateEvent - " + icpDeviceConnectionState, new Object[0]);
        if (icpDeviceConnectionState == BleIcpController.IcpDeviceConnectionState.CONNECTED) {
            sendEvent(new BleEvent(str, ConnectivityStatus.ONLINE));
        } else {
            sendEvent(new BleEvent(str, ConnectivityStatus.OFFLINE));
        }
    }

    private final void sendEvent(BleEvent<?> bleEvent) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Sending BleEvent: conent = " + bleEvent.getContent(), new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new BleService$sendEvent$1(this, bleEvent, (Continuation<? super BleService$sendEvent$1>) null), 3, (Object) null);
    }

    public final void setFanSpeed(String str, BleIcpController.FanSpeed fanSpeed) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(fanSpeed, "fanSpeed");
        this.bleIcpController.setFanSpeed(str, fanSpeed);
    }

    public final void setAutoMode(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.bleIcpController.setFanMode(str, z ? BleIcpController.FanMode.AUTO : BleIcpController.FanMode.MANUAL);
    }
}
