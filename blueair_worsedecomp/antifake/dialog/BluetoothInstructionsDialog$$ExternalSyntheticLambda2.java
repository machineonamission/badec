package com.blueair.antifake.dialog;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothInstructionsDialog$$ExternalSyntheticLambda2 implements ActivityResultCallback {
    public final /* synthetic */ BluetoothInstructionsDialog f$0;

    public /* synthetic */ BluetoothInstructionsDialog$$ExternalSyntheticLambda2(BluetoothInstructionsDialog bluetoothInstructionsDialog) {
        this.f$0 = bluetoothInstructionsDialog;
    }

    public final void onActivityResult(Object obj) {
        BluetoothInstructionsDialog.requestBluetoothPermissionsLauncher$lambda$3(this.f$0, (Map) obj);
    }
}
