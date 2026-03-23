package com.blueair.devicedetails.fragment;

import androidx.lifecycle.Observer;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsFragment$$ExternalSyntheticLambda11 implements Observer {
    public final /* synthetic */ DeviceSensorsFragment f$0;

    public /* synthetic */ DeviceSensorsFragment$$ExternalSyntheticLambda11(DeviceSensorsFragment deviceSensorsFragment) {
        this.f$0 = deviceSensorsFragment;
    }

    public final void onChanged(Object obj) {
        DeviceSensorsFragment.observeViewModel$lambda$3(this.f$0, (List) obj);
    }
}
