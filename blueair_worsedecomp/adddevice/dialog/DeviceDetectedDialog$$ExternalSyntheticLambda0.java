package com.blueair.adddevice.dialog;

import android.view.View;
import com.blueair.core.model.BluetoothDevice;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDetectedDialog$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DeviceDetectedDialog f$0;
    public final /* synthetic */ BluetoothDevice f$1;

    public /* synthetic */ DeviceDetectedDialog$$ExternalSyntheticLambda0(DeviceDetectedDialog deviceDetectedDialog, BluetoothDevice bluetoothDevice) {
        this.f$0 = deviceDetectedDialog;
        this.f$1 = bluetoothDevice;
    }

    public final void onClick(View view) {
        DeviceDetectedDialog.onCreateDialog$lambda$5$lambda$2(this.f$0, this.f$1, view);
    }
}
