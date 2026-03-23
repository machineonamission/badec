package com.blueair.devicedetails.fragment;

import androidx.lifecycle.Observer;
import com.blueair.graph.view.GraphView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsFragment$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ DeviceSensorsFragment f$0;

    public /* synthetic */ DeviceSensorsFragment$$ExternalSyntheticLambda4(DeviceSensorsFragment deviceSensorsFragment) {
        this.f$0 = deviceSensorsFragment;
    }

    public final void onChanged(Object obj) {
        DeviceSensorsFragment.observeViewModel$lambda$10(this.f$0, (GraphView.ScaleEvent) obj);
    }
}
