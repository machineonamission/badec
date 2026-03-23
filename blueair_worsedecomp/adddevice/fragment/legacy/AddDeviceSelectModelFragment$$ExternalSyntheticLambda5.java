package com.blueair.adddevice.fragment.legacy;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AddDeviceSelectModelFragment$$ExternalSyntheticLambda5 implements ActivityResultCallback {
    public final /* synthetic */ AddDeviceSelectModelFragment f$0;

    public /* synthetic */ AddDeviceSelectModelFragment$$ExternalSyntheticLambda5(AddDeviceSelectModelFragment addDeviceSelectModelFragment) {
        this.f$0 = addDeviceSelectModelFragment;
    }

    public final void onActivityResult(Object obj) {
        AddDeviceSelectModelFragment.requestBluetoothPermissionsLauncher$lambda$4(this.f$0, (Map) obj);
    }
}
