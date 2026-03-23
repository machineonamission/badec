package com.blueair.adddevice.fragment;

import com.blueair.bluetooth.service.BleDeviceState;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ BluetoothScanResultFragment f$0;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda7(BluetoothScanResultFragment bluetoothScanResultFragment) {
        this.f$0 = bluetoothScanResultFragment;
    }

    public final Object invoke(Object obj) {
        return BluetoothScanResultFragment.connectBleDevice$lambda$30$lambda$29(this.f$0, (BleDeviceState) obj);
    }
}
