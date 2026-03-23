package io.flatcircle.connectivityhelper;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionStateMonitor;", "Landroid/net/ConnectivityManager$NetworkCallback;", "connectionType", "Lio/flatcircle/connectivityhelper/ConnectionType;", "(Lio/flatcircle/connectivityhelper/ConnectionType;)V", "connectionObserver", "Lio/flatcircle/connectivityhelper/ConnectivityEventObserver;", "getConnectionObserver", "()Lio/flatcircle/connectivityhelper/ConnectivityEventObserver;", "setConnectionObserver", "(Lio/flatcircle/connectivityhelper/ConnectivityEventObserver;)V", "getConnectionType", "()Lio/flatcircle/connectivityhelper/ConnectionType;", "networkRequest", "Landroid/net/NetworkRequest;", "disable", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "enable", "connectivityEventObserver", "onAvailable", "network", "Landroid/net/Network;", "onLost", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ConnectionStateMonitor.kt */
public final class ConnectionStateMonitor extends ConnectivityManager.NetworkCallback {
    private ConnectivityEventObserver connectionObserver;
    private final ConnectionType connectionType;
    private final NetworkRequest networkRequest;

    public ConnectionStateMonitor(ConnectionType connectionType2) {
        Intrinsics.checkParameterIsNotNull(connectionType2, "connectionType");
        this.connectionType = connectionType2;
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(connectionType2.getNetworkCapablity()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "NetworkRequest\n         …networkCapablity).build()");
        this.networkRequest = build;
    }

    public final ConnectionType getConnectionType() {
        return this.connectionType;
    }

    public final ConnectivityEventObserver getConnectionObserver() {
        return this.connectionObserver;
    }

    public final void setConnectionObserver(ConnectivityEventObserver connectivityEventObserver) {
        this.connectionObserver = connectivityEventObserver;
    }

    public final void enable(ConnectivityManager connectivityManager, ConnectivityEventObserver connectivityEventObserver) {
        Intrinsics.checkParameterIsNotNull(connectivityManager, "connectivityManager");
        Intrinsics.checkParameterIsNotNull(connectivityEventObserver, "connectivityEventObserver");
        this.connectionObserver = connectivityEventObserver;
        connectivityManager.registerNetworkCallback(this.networkRequest, this);
    }

    public final void disable(ConnectivityManager connectivityManager) {
        ConnectivityEventObserver connectivityEventObserver = null;
        this.connectionObserver = null;
        if (connectivityManager != null) {
            connectivityManager.unregisterNetworkCallback(this);
        }
    }

    public void onAvailable(Network network) {
        Intrinsics.checkParameterIsNotNull(network, "network");
        ConnectivityEventObserver connectivityEventObserver = this.connectionObserver;
        if (connectivityEventObserver != null) {
            connectivityEventObserver.handleConnectivityEvent(new ConnectivityEvent(true, this.connectionType));
        }
    }

    public void onLost(Network network) {
        ConnectivityEventObserver connectivityEventObserver = this.connectionObserver;
        if (connectivityEventObserver != null) {
            connectivityEventObserver.handleConnectivityEvent(new ConnectivityEvent(false, this.connectionType));
        }
    }
}
