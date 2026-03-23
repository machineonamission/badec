package com.blueair.devicedetails.fragment;

import androidx.lifecycle.Observer;
import com.blueair.graph.view.GraphView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsFragment$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ DeviceSensorsFragment f$0;

    public /* synthetic */ DeviceSensorsFragment$$ExternalSyntheticLambda2(DeviceSensorsFragment deviceSensorsFragment) {
        this.f$0 = deviceSensorsFragment;
    }

    public final void onChanged(Object obj) {
        DeviceSensorsFragment.observeViewModel$lambda$8(this.f$0, (GraphView.ScaleEvent) obj);
    }
}
