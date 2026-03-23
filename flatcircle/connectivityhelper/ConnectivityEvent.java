package io.flatcircle.connectivityhelper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectivityEvent;", "", "isConnectedTo", "", "connectionType", "Lio/flatcircle/connectivityhelper/ConnectionType;", "(ZLio/flatcircle/connectivityhelper/ConnectionType;)V", "getConnectionType", "()Lio/flatcircle/connectivityhelper/ConnectionType;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ConnectionStateMonitor.kt */
public final class ConnectivityEvent {
    private final ConnectionType connectionType;
    private final boolean isConnectedTo;

    public static /* synthetic */ ConnectivityEvent copy$default(ConnectivityEvent connectivityEvent, boolean z, ConnectionType connectionType2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = connectivityEvent.isConnectedTo;
        }
        if ((i & 2) != 0) {
            connectionType2 = connectivityEvent.connectionType;
        }
        return connectivityEvent.copy(z, connectionType2);
    }

    public final boolean component1() {
        return this.isConnectedTo;
    }

    public final ConnectionType component2() {
        return this.connectionType;
    }

    public final ConnectivityEvent copy(boolean z, ConnectionType connectionType2) {
        Intrinsics.checkParameterIsNotNull(connectionType2, "connectionType");
        return new ConnectivityEvent(z, connectionType2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectivityEvent)) {
            return false;
        }
        ConnectivityEvent connectivityEvent = (ConnectivityEvent) obj;
        return this.isConnectedTo == connectivityEvent.isConnectedTo && Intrinsics.areEqual((Object) this.connectionType, (Object) connectivityEvent.connectionType);
    }

    public int hashCode() {
        boolean z = this.isConnectedTo;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        ConnectionType connectionType2 = this.connectionType;
        return i + (connectionType2 != null ? connectionType2.hashCode() : 0);
    }

    public String toString() {
        return "ConnectivityEvent(isConnectedTo=" + this.isConnectedTo + ", connectionType=" + this.connectionType + ")";
    }

    public ConnectivityEvent(boolean z, ConnectionType connectionType2) {
        Intrinsics.checkParameterIsNotNull(connectionType2, "connectionType");
        this.isConnectedTo = z;
        this.connectionType = connectionType2;
    }

    public final ConnectionType getConnectionType() {
        return this.connectionType;
    }

    public final boolean isConnectedTo() {
        return this.isConnectedTo;
    }
}
