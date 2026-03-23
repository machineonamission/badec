package com.blueair.devicedetails.fragment;

import android.widget.CompoundButton;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsGraphFragment$$ExternalSyntheticLambda5 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ FragmentDeviceSensorsGraphBinding f$0;
    public final /* synthetic */ DeviceSensorsGraphFragment f$1;

    public /* synthetic */ DeviceSensorsGraphFragment$$ExternalSyntheticLambda5(FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, DeviceSensorsGraphFragment deviceSensorsGraphFragment) {
        this.f$0 = fragmentDeviceSensorsGraphBinding;
        this.f$1 = deviceSensorsGraphFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        DeviceSensorsGraphFragment.onViewCreated$lambda$18$lambda$1(this.f$0, this.f$1, compoundButton, z);
    }
}
