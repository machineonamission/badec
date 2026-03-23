package com.blueair.core.util;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/blueair/core/util/NetworkMonitor$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkMonitor.kt */
public final class NetworkMonitor$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkMonitor this$0;

    NetworkMonitor$networkCallback$1(NetworkMonitor networkMonitor) {
        this.this$0 = networkMonitor;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.this$0._connectivityStatus.tryEmit(true);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.this$0._connectivityStatus.tryEmit(false);
    }
}
