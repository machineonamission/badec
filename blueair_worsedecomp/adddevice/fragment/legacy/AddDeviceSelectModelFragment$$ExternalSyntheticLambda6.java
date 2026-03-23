package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AddDeviceSelectModelFragment$$ExternalSyntheticLambda6 implements FragmentResultListener {
    public final /* synthetic */ AddDeviceSelectModelFragment f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ AddDeviceSelectModelFragment$$ExternalSyntheticLambda6(AddDeviceSelectModelFragment addDeviceSelectModelFragment, boolean z) {
        this.f$0 = addDeviceSelectModelFragment;
        this.f$1 = z;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        AddDeviceSelectModelFragment.showPermissionDialog$lambda$16(this.f$0, this.f$1, str, bundle);
    }
}
