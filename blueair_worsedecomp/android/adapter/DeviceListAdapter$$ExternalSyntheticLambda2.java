package com.blueair.android.adapter;

import android.view.View;
import com.blueair.core.model.Device;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceListAdapter$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ DeviceListAdapter f$0;
    public final /* synthetic */ Device f$1;

    public /* synthetic */ DeviceListAdapter$$ExternalSyntheticLambda2(DeviceListAdapter deviceListAdapter, Device device) {
        this.f$0 = deviceListAdapter;
        this.f$1 = device;
    }

    public final void onClick(View view) {
        DeviceListAdapter.onBindViewHolder$lambda$5(this.f$0, this.f$1, view);
    }
}
