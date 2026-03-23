package io.flatcircle.connectivityhelper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\f\r\u000e\u000f\u0010\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001\u0006\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType;", "", "networkCapablity", "", "isConnectedTo", "", "(IZ)V", "()Z", "setConnectedTo", "(Z)V", "getNetworkCapablity", "()I", "Cellular", "Ethernet", "LoWPAN", "VPN", "WiFi", "WiFiAware", "Lio/flatcircle/connectivityhelper/ConnectionType$Cellular;", "Lio/flatcircle/connectivityhelper/ConnectionType$WiFi;", "Lio/flatcircle/connectivityhelper/ConnectionType$Ethernet;", "Lio/flatcircle/connectivityhelper/ConnectionType$VPN;", "Lio/flatcircle/connectivityhelper/ConnectionType$WiFiAware;", "Lio/flatcircle/connectivityhelper/ConnectionType$LoWPAN;", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ConnectionType.kt */
public abstract class ConnectionType {
    private boolean isConnectedTo;
    private final int networkCapablity;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType$Cellular;", "Lio/flatcircle/connectivityhelper/ConnectionType;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionType.kt */
    public static final class Cellular extends ConnectionType {
        public static final Cellular INSTANCE = new Cellular();

        private Cellular() {
            super(0, false, 2, (DefaultConstructorMarker) null);
        }
    }

    private ConnectionType(int i, boolean z) {
        this.networkCapablity = i;
        this.isConnectedTo = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ ConnectionType(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    public final int getNetworkCapablity() {
        return this.networkCapablity;
    }

    public final boolean isConnectedTo() {
        return this.isConnectedTo;
    }

    public final void setConnectedTo(boolean z) {
        this.isConnectedTo = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType$WiFi;", "Lio/flatcircle/connectivityhelper/ConnectionType;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionType.kt */
    public static final class WiFi extends ConnectionType {
        public static final WiFi INSTANCE = new WiFi();

        private WiFi() {
            super(1, false, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType$Ethernet;", "Lio/flatcircle/connectivityhelper/ConnectionType;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionType.kt */
    public static final class Ethernet extends ConnectionType {
        public static final Ethernet INSTANCE = new Ethernet();

        private Ethernet() {
            super(3, false, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType$VPN;", "Lio/flatcircle/connectivityhelper/ConnectionType;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionType.kt */
    public static final class VPN extends ConnectionType {
        public static final VPN INSTANCE = new VPN();

        private VPN() {
            super(4, false, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType$WiFiAware;", "Lio/flatcircle/connectivityhelper/ConnectionType;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionType.kt */
    public static final class WiFiAware extends ConnectionType {
        public static final WiFiAware INSTANCE = new WiFiAware();

        private WiFiAware() {
            super(5, false, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionType$LoWPAN;", "Lio/flatcircle/connectivityhelper/ConnectionType;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionType.kt */
    public static final class LoWPAN extends ConnectionType {
        public static final LoWPAN INSTANCE = new LoWPAN();

        private LoWPAN() {
            super(6, false, 2, (DefaultConstructorMarker) null);
        }
    }
}
