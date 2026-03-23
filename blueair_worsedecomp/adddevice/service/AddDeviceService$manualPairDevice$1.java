package com.blueair.adddevice.service;

import android.net.ConnectivityManager;
import android.net.Network;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.DevicePairManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"com/blueair/adddevice/service/AddDeviceService$manualPairDevice$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "busy", "", "getBusy", "()Z", "setBusy", "(Z)V", "onAvailable", "", "network", "Landroid/net/Network;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceService.kt */
public final class AddDeviceService$manualPairDevice$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ ConnectivityManager $manager;
    final /* synthetic */ String $networkPassPhrase;
    final /* synthetic */ String $networkSSID;
    private boolean busy;
    final /* synthetic */ AddDeviceService this$0;

    AddDeviceService$manualPairDevice$1(ConnectivityManager connectivityManager, String str, String str2, AddDeviceService addDeviceService) {
        this.$manager = connectivityManager;
        this.$networkSSID = str;
        this.$networkPassPhrase = str2;
        this.this$0 = addDeviceService;
    }

    public final boolean getBusy() {
        return this.busy;
    }

    public final void setBusy(boolean z) {
        this.busy = z;
    }

    public void onAvailable(Network network) {
        DeviceInformationLegacy deviceInformationLegacy;
        Intrinsics.checkNotNullParameter(network, "network");
        if (this.busy) {
            Timber.Forest.d("ignore onAvailable since busy", new Object[0]);
            return;
        }
        this.busy = true;
        this.$manager.unregisterNetworkCallback(this);
        this.$manager.bindProcessToNetwork(network);
        try {
            DevicePairManager devicePairManager = DevicePairManager.INSTANCE;
            String str = this.$networkSSID;
            Intrinsics.checkNotNull(str);
            String str2 = this.$networkPassPhrase;
            Intrinsics.checkNotNull(str2);
            deviceInformationLegacy = devicePairManager.performManualPairing(str, str2);
        } catch (Exception e) {
            Timber.Forest.e(e);
            deviceInformationLegacy = null;
        }
        this.$manager.bindProcessToNetwork((Network) null);
        if (deviceInformationLegacy != null) {
            this.this$0.deviceConfigSuccess(deviceInformationLegacy, false);
        } else {
            this.this$0.manualConfigFailToAutoModeFailState();
        }
    }
}
