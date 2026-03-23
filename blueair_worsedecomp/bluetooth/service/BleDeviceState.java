package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001\u0011 !\"#$%&'()*+,-./0¨\u00061"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState;", "", "code", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getName", "()Ljava/lang/String;", "isEnabled", "", "state", "Disconnected", "Connecting", "Connected", "SessionEstablishing", "SessionEstablished", "ProvisioningStarted", "ProvisioningConfigured0", "ProvisioningConfigured1", "ProvisioningConfigured2", "ProvisioningConfigured3", "ProvisioningConfigured4", "ProvisioningConfigured5", "WifiConfigured", "WifiConfigApplied", "PollingWifiConfigStatus", "WifiConnected", "Bounded", "Lcom/blueair/bluetooth/service/BleDeviceState$Bounded;", "Lcom/blueair/bluetooth/service/BleDeviceState$Connected;", "Lcom/blueair/bluetooth/service/BleDeviceState$Connecting;", "Lcom/blueair/bluetooth/service/BleDeviceState$Disconnected;", "Lcom/blueair/bluetooth/service/BleDeviceState$PollingWifiConfigStatus;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured0;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured1;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured2;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured3;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured4;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured5;", "Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningStarted;", "Lcom/blueair/bluetooth/service/BleDeviceState$SessionEstablished;", "Lcom/blueair/bluetooth/service/BleDeviceState$SessionEstablishing;", "Lcom/blueair/bluetooth/service/BleDeviceState$WifiConfigApplied;", "Lcom/blueair/bluetooth/service/BleDeviceState$WifiConfigured;", "Lcom/blueair/bluetooth/service/BleDeviceState$WifiConnected;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public abstract class BleDeviceState {
    private final int code;
    private final String name;

    public /* synthetic */ BleDeviceState(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$Disconnected;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class Disconnected extends BleDeviceState {
        public static final Disconnected INSTANCE = new Disconnected();

        private Disconnected() {
            super(0, "Disconnected", (DefaultConstructorMarker) null);
        }
    }

    private BleDeviceState(int i, String str) {
        this.code = i;
        this.name = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$Connecting;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class Connecting extends BleDeviceState {
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super(1, "Connecting", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$Connected;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class Connected extends BleDeviceState {
        public static final Connected INSTANCE = new Connected();

        private Connected() {
            super(2, "Connected", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$SessionEstablishing;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class SessionEstablishing extends BleDeviceState {
        public static final SessionEstablishing INSTANCE = new SessionEstablishing();

        private SessionEstablishing() {
            super(3, "Session Establishing", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$SessionEstablished;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class SessionEstablished extends BleDeviceState {
        public static final SessionEstablished INSTANCE = new SessionEstablished();

        private SessionEstablished() {
            super(4, "Session Established", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningStarted;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningStarted extends BleDeviceState {
        public static final ProvisioningStarted INSTANCE = new ProvisioningStarted();

        private ProvisioningStarted() {
            super(5, "Provisioning Started", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured0;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningConfigured0 extends BleDeviceState {
        public static final ProvisioningConfigured0 INSTANCE = new ProvisioningConfigured0();

        private ProvisioningConfigured0() {
            super(6, "Provisioning Configured 0 of 5", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured1;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningConfigured1 extends BleDeviceState {
        public static final ProvisioningConfigured1 INSTANCE = new ProvisioningConfigured1();

        private ProvisioningConfigured1() {
            super(7, "Provisioning Configured 1 of 5", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured2;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningConfigured2 extends BleDeviceState {
        public static final ProvisioningConfigured2 INSTANCE = new ProvisioningConfigured2();

        private ProvisioningConfigured2() {
            super(8, "Provisioning Configured 2 of 5", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured3;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningConfigured3 extends BleDeviceState {
        public static final ProvisioningConfigured3 INSTANCE = new ProvisioningConfigured3();

        private ProvisioningConfigured3() {
            super(9, "Provisioning Configured 3 of 5", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured4;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningConfigured4 extends BleDeviceState {
        public static final ProvisioningConfigured4 INSTANCE = new ProvisioningConfigured4();

        private ProvisioningConfigured4() {
            super(10, "Provisioning Configured 4 of 5", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$ProvisioningConfigured5;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class ProvisioningConfigured5 extends BleDeviceState {
        public static final ProvisioningConfigured5 INSTANCE = new ProvisioningConfigured5();

        private ProvisioningConfigured5() {
            super(11, "Provisioning Configured 5 of 5", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$WifiConfigured;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class WifiConfigured extends BleDeviceState {
        public static final WifiConfigured INSTANCE = new WifiConfigured();

        private WifiConfigured() {
            super(12, "Wifi Configured", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$WifiConfigApplied;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class WifiConfigApplied extends BleDeviceState {
        public static final WifiConfigApplied INSTANCE = new WifiConfigApplied();

        private WifiConfigApplied() {
            super(13, "Wifi Config Applied", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$PollingWifiConfigStatus;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class PollingWifiConfigStatus extends BleDeviceState {
        public static final PollingWifiConfigStatus INSTANCE = new PollingWifiConfigStatus();

        private PollingWifiConfigStatus() {
            super(14, "Polling Wifi Config status", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$WifiConnected;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class WifiConnected extends BleDeviceState {
        public static final WifiConnected INSTANCE = new WifiConnected();

        private WifiConnected() {
            super(15, "Wifi Connected", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceState$Bounded;", "Lcom/blueair/bluetooth/service/BleDeviceState;", "<init>", "()V", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BleDeviceService.kt */
    public static final class Bounded extends BleDeviceState {
        public static final Bounded INSTANCE = new Bounded();

        private Bounded() {
            super(16, "Bounded", (DefaultConstructorMarker) null);
        }
    }

    public final boolean isEnabled(BleDeviceState bleDeviceState) {
        Intrinsics.checkNotNullParameter(bleDeviceState, "state");
        int i = bleDeviceState.code;
        if (i > 0) {
            return i <= this.code;
        }
        return Intrinsics.areEqual((Object) this, (Object) bleDeviceState);
    }
}
