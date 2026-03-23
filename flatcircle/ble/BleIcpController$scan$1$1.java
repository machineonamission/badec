package io.flatcircle.ble;

import com.airboxlab.icp.sdk.IcpDevice;
import com.airboxlab.icp.sdk.ScanListener;
import io.reactivex.SingleEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001b\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"io/flatcircle/ble/BleIcpController$scan$1$1", "Lcom/airboxlab/icp/sdk/ScanListener;", "onError", "", "throwable", "", "onScanEnded", "devices", "", "Lcom/airboxlab/icp/sdk/IcpDevice;", "([Lcom/airboxlab/icp/sdk/IcpDevice;)V", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleIcpController.kt */
public final class BleIcpController$scan$1$1 implements ScanListener {
    final /* synthetic */ SingleEmitter<IcpDevice[]> $it;

    BleIcpController$scan$1$1(SingleEmitter<IcpDevice[]> singleEmitter) {
        this.$it = singleEmitter;
    }

    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.$it.onError(th);
    }

    public void onScanEnded(IcpDevice[] icpDeviceArr) {
        Intrinsics.checkNotNullParameter(icpDeviceArr, "devices");
        Timber.Forest forest = Timber.Forest;
        forest.i("scan completed, found devices: " + icpDeviceArr.length, new Object[0]);
        this.$it.onSuccess(icpDeviceArr);
    }
}
