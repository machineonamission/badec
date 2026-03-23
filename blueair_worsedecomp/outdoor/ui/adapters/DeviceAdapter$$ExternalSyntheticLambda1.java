package com.blueair.outdoor.ui.adapters;

import android.view.View;
import com.blueair.core.model.HasLocation;
import com.blueair.outdoor.databinding.HolderAssignDeviceBinding;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ DeviceAdapter f$0;
    public final /* synthetic */ HasLocation f$1;
    public final /* synthetic */ HolderAssignDeviceBinding f$2;

    public /* synthetic */ DeviceAdapter$$ExternalSyntheticLambda1(DeviceAdapter deviceAdapter, HasLocation hasLocation, HolderAssignDeviceBinding holderAssignDeviceBinding) {
        this.f$0 = deviceAdapter;
        this.f$1 = hasLocation;
        this.f$2 = holderAssignDeviceBinding;
    }

    public final void onClick(View view) {
        DeviceAdapter.onBindViewHolder$lambda$4$lambda$3(this.f$0, this.f$1, this.f$2, view);
    }
}
