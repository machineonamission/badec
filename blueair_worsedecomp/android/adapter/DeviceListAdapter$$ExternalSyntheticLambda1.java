package com.blueair.android.adapter;

import android.view.View;
import com.blueair.core.model.Device;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceListAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Device f$0;
    public final /* synthetic */ DeviceListAdapter f$1;

    public /* synthetic */ DeviceListAdapter$$ExternalSyntheticLambda1(Device device, DeviceListAdapter deviceListAdapter) {
        this.f$0 = device;
        this.f$1 = deviceListAdapter;
    }

    public final void onClick(View view) {
        DeviceListAdapter.onBindViewHolder$lambda$4(this.f$0, this.f$1, view);
    }
}
