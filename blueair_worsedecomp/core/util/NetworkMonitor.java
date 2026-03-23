package com.blueair.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003*\u0001\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/blueair/core/util/NetworkMonitor;", "", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connManager", "Landroid/net/ConnectivityManager;", "_connectivityStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "connectivityStatus", "Lkotlinx/coroutines/flow/Flow;", "getConnectivityStatus", "()Lkotlinx/coroutines/flow/Flow;", "_wifiStatus", "wifiStatus", "getWifiStatus", "networkCallback", "com/blueair/core/util/NetworkMonitor$networkCallback$1", "Lcom/blueair/core/util/NetworkMonitor$networkCallback$1;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkMonitor.kt */
public final class NetworkMonitor {
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> _connectivityStatus = StateFlowKt.MutableStateFlow(false);
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> _wifiStatus = StateFlowKt.MutableStateFlow(false);
    private final ConnectivityManager connManager;
    private final NetworkMonitor$networkCallback$1 networkCallback;

    public NetworkMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        this.connManager = connectivityManager;
        NetworkMonitor$networkCallback$1 networkMonitor$networkCallback$1 = new NetworkMonitor$networkCallback$1(this);
        this.networkCallback = networkMonitor$networkCallback$1;
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(networkMonitor$networkCallback$1);
        } else {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), networkMonitor$networkCallback$1);
        }
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), new ConnectivityManager.NetworkCallback(this) {
            final /* synthetic */ NetworkMonitor this$0;

            {
                this.this$0 = r1;
            }

            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.this$0._wifiStatus.tryEmit(true);
            }

            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.this$0._wifiStatus.tryEmit(false);
            }
        });
    }

    public final Flow<Boolean> getConnectivityStatus() {
        return FlowKt.onEach(new NetworkMonitor$special$$inlined$map$1(new NetworkMonitor$special$$inlined$filterNot$1(FlowKt.withIndex(this._connectivityStatus))), new NetworkMonitor$connectivityStatus$3((Continuation<? super NetworkMonitor$connectivityStatus$3>) null));
    }

    public final Flow<Boolean> getWifiStatus() {
        return FlowKt.onEach(FlowKt.debounce(this._wifiStatus, 250), new NetworkMonitor$wifiStatus$1((Continuation<? super NetworkMonitor$wifiStatus$1>) null));
    }
}
