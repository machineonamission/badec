package com.blueair.outdoor.ui.adapters;

import android.view.View;
import com.blueair.core.model.HasLocation;
import com.blueair.outdoor.databinding.HolderAssignDeviceBinding;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ HolderAssignDeviceBinding f$0;
    public final /* synthetic */ DeviceAdapter f$1;
    public final /* synthetic */ HasLocation f$2;

    public /* synthetic */ DeviceAdapter$$ExternalSyntheticLambda0(HolderAssignDeviceBinding holderAssignDeviceBinding, DeviceAdapter deviceAdapter, HasLocation hasLocation) {
        this.f$0 = holderAssignDeviceBinding;
        this.f$1 = deviceAdapter;
        this.f$2 = hasLocation;
    }

    public final void onClick(View view) {
        DeviceAdapter.onBindViewHolder$lambda$4$lambda$2(this.f$0, this.f$1, this.f$2, view);
    }
}
