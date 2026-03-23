package com.blueair.devicedetails.fragment;

import androidx.lifecycle.Observer;
import com.blueair.core.model.SensorType;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsFragment$$ExternalSyntheticLambda8 implements Observer {
    public final /* synthetic */ DeviceSensorsFragment f$0;

    public /* synthetic */ DeviceSensorsFragment$$ExternalSyntheticLambda8(DeviceSensorsFragment deviceSensorsFragment) {
        this.f$0 = deviceSensorsFragment;
    }

    public final void onChanged(Object obj) {
        DeviceSensorsFragment.observeViewModel$lambda$2(this.f$0, (SensorType) obj);
    }
}
