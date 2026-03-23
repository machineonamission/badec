package com.blueair.adddevice.fragment;

import com.blueair.core.model.BluetoothDevice;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ BluetoothScanResultFragment f$0;
    public final /* synthetic */ BluetoothDevice f$1;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda9(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice) {
        this.f$0 = bluetoothScanResultFragment;
        this.f$1 = bluetoothDevice;
    }

    public final Object invoke(Object obj) {
        return BluetoothScanResultFragment.onSelectionLost$lambda$33$lambda$32(this.f$0, this.f$1, ((Boolean) obj).booleanValue());
    }
}
