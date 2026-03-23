package com.blueair.devicedetails.fragment;

import android.view.View;
import com.blueair.core.model.SensorType;
import com.google.android.material.tabs.TabLayout;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceHSensorsFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ DeviceHSensorsFragment f$0;
    public final /* synthetic */ SensorType f$1;
    public final /* synthetic */ TabLayout.Tab f$2;

    public /* synthetic */ DeviceHSensorsFragment$$ExternalSyntheticLambda3(DeviceHSensorsFragment deviceHSensorsFragment, SensorType sensorType, TabLayout.Tab tab) {
        this.f$0 = deviceHSensorsFragment;
        this.f$1 = sensorType;
        this.f$2 = tab;
    }

    public final void onClick(View view) {
        DeviceHSensorsFragment.setupGraphTabs$lambda$17$lambda$15$lambda$14(this.f$0, this.f$1, this.f$2, view);
    }
}
