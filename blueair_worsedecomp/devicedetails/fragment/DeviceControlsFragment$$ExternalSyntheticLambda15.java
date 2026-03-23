package com.blueair.devicedetails.fragment;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceControlsFragment$$ExternalSyntheticLambda15 implements ActivityResultCallback {
    public final /* synthetic */ DeviceControlsFragment f$0;

    public /* synthetic */ DeviceControlsFragment$$ExternalSyntheticLambda15(DeviceControlsFragment deviceControlsFragment) {
        this.f$0 = deviceControlsFragment;
    }

    public final void onActivityResult(Object obj) {
        DeviceControlsFragment.schedulePageLauncher$lambda$0(this.f$0, (ActivityResult) obj);
    }
}
