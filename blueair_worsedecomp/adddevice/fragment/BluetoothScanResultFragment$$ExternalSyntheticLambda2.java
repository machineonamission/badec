package com.blueair.adddevice.fragment;

import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.core.model.BluetoothDevice;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ BluetoothScanResultFragment f$0;
    public final /* synthetic */ ConnectInstructionsDialog f$1;
    public final /* synthetic */ BluetoothDevice f$2;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda2(BluetoothScanResultFragment bluetoothScanResultFragment, ConnectInstructionsDialog connectInstructionsDialog, BluetoothDevice bluetoothDevice) {
        this.f$0 = bluetoothScanResultFragment;
        this.f$1 = connectInstructionsDialog;
        this.f$2 = bluetoothDevice;
    }

    public final Object invoke() {
        return BluetoothScanResultFragment.startConnectBleDevice$lambda$25$lambda$24$lambda$23(this.f$0, this.f$1, this.f$2);
    }
}
