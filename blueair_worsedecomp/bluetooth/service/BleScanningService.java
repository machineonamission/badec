package com.blueair.bluetooth.service;

import android.bluetooth.BluetoothDevice;
import com.blueair.bluetooth.model.BleScannedDevice;
import com.blueair.core.model.AnalyticEvent;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanResult;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import timber.log.Timber;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\r\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u001dR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u001e\u001a\u00020\u001fX\u0005¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/blueair/bluetooth/service/BleScanningService;", "Lkotlinx/coroutines/CoroutineScope;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "scanObservable", "Lio/reactivex/Observable;", "Lcom/polidea/rxandroidble2/scan/ScanResult;", "scanDisposable", "Lio/reactivex/disposables/Disposable;", "devices", "", "Lcom/blueair/bluetooth/model/BleScannedDevice;", "_resultStream", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "resultFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getResultFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "startScanning", "", "reset", "resetResult", "stopScanning", "()Lkotlin/Unit;", "getScannedDevice", "mac", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleScanningService.kt */
public final class BleScanningService implements CoroutineScope {
    private static final String BLE_SERVICE_UUID_DEFAULT = "4772911e-d07c-4617-8241-f4d10948d6ae";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String G4_UUID = "4772911e-d07c-4617-8241-f4d10948d6ae";
    private static final int UNDOCUMENTED_SCAN_THROTTLE_ERROR_CODE = 2147483646;
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final MutableStateFlow<List<BleScannedDevice>> _resultStream;
    private final List<BleScannedDevice> devices = new ArrayList();
    private final StateFlow<List<BleScannedDevice>> resultFlow;
    private Disposable scanDisposable;
    private Observable<ScanResult> scanObservable;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x006e, code lost:
        r6 = (r6 = r6.scanBleDevices(r0, r2)).subscribeOn(io.reactivex.schedulers.Schedulers.io());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BleScanningService(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "appContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r5.<init>()
            io.flatcircle.coroutinehelper.DefaultCoroutineScope r0 = new io.flatcircle.coroutinehelper.DefaultCoroutineScope
            r0.<init>()
            r5.$$delegate_0 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r5.devices = r0
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            kotlinx.coroutines.flow.MutableStateFlow r0 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r0)
            r5._resultStream = r0
            kotlinx.coroutines.flow.StateFlow r0 = (kotlinx.coroutines.flow.StateFlow) r0
            r5.resultFlow = r0
            android.content.pm.PackageManager r0 = r6.getPackageManager()
            java.lang.String r1 = "android.hardware.bluetooth_le"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 == 0) goto L_0x008a
            com.polidea.rxandroidble2.scan.ScanSettings$Builder r0 = new com.polidea.rxandroidble2.scan.ScanSettings$Builder
            r0.<init>()
            r1 = 2
            com.polidea.rxandroidble2.scan.ScanSettings$Builder r0 = r0.setScanMode(r1)
            r1 = 1
            com.polidea.rxandroidble2.scan.ScanSettings$Builder r0 = r0.setCallbackType(r1)
            com.polidea.rxandroidble2.scan.ScanSettings r0 = r0.build()
            com.polidea.rxandroidble2.scan.ScanFilter$Builder r2 = new com.polidea.rxandroidble2.scan.ScanFilter$Builder
            r2.<init>()
            android.os.ParcelUuid r3 = new android.os.ParcelUuid
            java.lang.String r4 = "4772911e-d07c-4617-8241-f4d10948d6ae"
            java.util.UUID r4 = java.util.UUID.fromString(r4)
            r3.<init>(r4)
            com.polidea.rxandroidble2.scan.ScanFilter$Builder r2 = r2.setServiceUuid(r3)
            com.polidea.rxandroidble2.scan.ScanFilter r2 = r2.build()
            com.polidea.rxandroidble2.RxBleClient r6 = com.polidea.rxandroidble2.RxBleClient.create(r6)
            if (r6 == 0) goto L_0x0087
            com.polidea.rxandroidble2.scan.ScanFilter[] r1 = new com.polidea.rxandroidble2.scan.ScanFilter[r1]
            r3 = 0
            r1[r3] = r2
            io.reactivex.Observable r6 = r6.scanBleDevices(r0, r1)
            if (r6 == 0) goto L_0x0087
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Observable r6 = r6.subscribeOn(r0)
            if (r6 == 0) goto L_0x0087
            com.blueair.bluetooth.service.BleScanningService$$ExternalSyntheticLambda0 r0 = new com.blueair.bluetooth.service.BleScanningService$$ExternalSyntheticLambda0
            r0.<init>()
            com.blueair.bluetooth.service.BleScanningService$$ExternalSyntheticLambda1 r1 = new com.blueair.bluetooth.service.BleScanningService$$ExternalSyntheticLambda1
            r1.<init>(r0)
            io.reactivex.Observable r6 = r6.retry((io.reactivex.functions.Predicate<? super java.lang.Throwable>) r1)
            goto L_0x0088
        L_0x0087:
            r6 = 0
        L_0x0088:
            r5.scanObservable = r6
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.bluetooth.service.BleScanningService.<init>(android.content.Context):void");
    }

    public final StateFlow<List<BleScannedDevice>> getResultFlow() {
        return this.resultFlow;
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$0(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest.d(th, "rx ble retry", new Object[0]);
        if (!(th instanceof BleScanException) || ((BleScanException) th).getReason() == 2147483646) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void startScanning$lambda$4(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final void startScanning() {
        Observable<ScanResult> observable = this.scanObservable;
        this.scanDisposable = observable != null ? observable.subscribe(new BleScanningService$$ExternalSyntheticLambda3(new BleScanningService$$ExternalSyntheticLambda2(this)), new BleScanningService$$ExternalSyntheticLambda5(new BleScanningService$$ExternalSyntheticLambda4(this))) : null;
    }

    /* access modifiers changed from: private */
    public static final Unit startScanning$lambda$3(BleScanningService bleScanningService, ScanResult scanResult) {
        BluetoothDevice bluetoothDevice = scanResult.getBleDevice().getBluetoothDevice();
        Intrinsics.checkNotNullExpressionValue(bluetoothDevice, "getBluetoothDevice(...)");
        boolean z = true;
        BleScannedDevice bleScannedDevice = new BleScannedDevice(bluetoothDevice, "4772911e-d07c-4617-8241-f4d10948d6ae", scanResult.isConnectable() == IsConnectable.CONNECTABLE);
        Timber.Forest.d("rx ble device found " + scanResult.getBleDevice().getName() + '-' + bleScannedDevice.getConnectable(), new Object[0]);
        Iterator<BleScannedDevice> it = bleScanningService.devices.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) it.next().getDevice().getAddress(), (Object) bleScannedDevice.getDevice().getAddress())) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            bleScanningService.devices.add(bleScannedDevice);
        } else if (bleScanningService.devices.get(i).getConnectable() != bleScannedDevice.getConnectable()) {
            bleScanningService.devices.set(i, bleScannedDevice);
        } else {
            z = false;
        }
        if (!bleScanningService.devices.isEmpty() && z) {
            bleScanningService._resultStream.tryEmit(CollectionsKt.toList(bleScanningService.devices));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void startScanning$lambda$6(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit startScanning$lambda$5(BleScanningService bleScanningService, Throwable th) {
        Timber.Forest.e(th, "rx ble scan error", new Object[0]);
        bleScanningService._resultStream.tryEmit(CollectionsKt.emptyList());
        return Unit.INSTANCE;
    }

    public final void reset() {
        stopScanning();
        resetResult();
    }

    public final void resetResult() {
        this.devices.clear();
        this._resultStream.tryEmit(CollectionsKt.emptyList());
    }

    public final Unit stopScanning() {
        Disposable disposable = this.scanDisposable;
        if (disposable == null) {
            return null;
        }
        disposable.dispose();
        return Unit.INSTANCE;
    }

    public final BleScannedDevice getScannedDevice(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, AnalyticEvent.KEY_MAC);
        Iterator it = this.devices.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((BleScannedDevice) obj).getDevice().getAddress(), (Object) str)) {
                break;
            }
        }
        return (BleScannedDevice) obj;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/bluetooth/service/BleScanningService$Companion;", "", "<init>", "()V", "G4_UUID", "", "BLE_SERVICE_UUID_DEFAULT", "UNDOCUMENTED_SCAN_THROTTLE_ERROR_CODE", "", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleScanningService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
