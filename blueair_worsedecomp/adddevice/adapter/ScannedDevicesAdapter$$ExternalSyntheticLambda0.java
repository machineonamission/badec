package com.blueair.adddevice.adapter;

import android.view.View;
import com.blueair.core.model.BluetoothDevice;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScannedDevicesAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ ScannedDevicesAdapter f$0;
    public final /* synthetic */ BluetoothDevice f$1;

    public /* synthetic */ ScannedDevicesAdapter$$ExternalSyntheticLambda0(ScannedDevicesAdapter scannedDevicesAdapter, BluetoothDevice bluetoothDevice) {
        this.f$0 = scannedDevicesAdapter;
        this.f$1 = bluetoothDevice;
    }

    public final void onClick(View view) {
        ScannedDevicesAdapter.onBindViewHolder$lambda$0(this.f$0, this.f$1, view);
    }
}
