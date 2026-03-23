package com.blueair.adddevice.fragment;

import com.blueair.core.model.BluetoothDevice;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda17 implements Function1 {
    public final /* synthetic */ BluetoothScanResultFragment f$0;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda17(BluetoothScanResultFragment bluetoothScanResultFragment) {
        this.f$0 = bluetoothScanResultFragment;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(BluetoothScanResultFragment.onResume$lambda$13(this.f$0, (BluetoothDevice) obj));
    }
}
