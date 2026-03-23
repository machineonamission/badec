package com.blueair.adddevice.fragment;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda6 implements ActivityResultCallback {
    public final /* synthetic */ BluetoothScanResultFragment f$0;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda6(BluetoothScanResultFragment bluetoothScanResultFragment) {
        this.f$0 = bluetoothScanResultFragment;
    }

    public final void onActivityResult(Object obj) {
        BluetoothScanResultFragment.requestBluetoothPermissionsLauncher$lambda$5(this.f$0, (Map) obj);
    }
}
