package com.blueair.devicedetails.adapter;

import android.view.View;
import com.blueair.core.model.DeviceAware;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LinkedDevicesAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ LinkedDevicesAdapter f$0;
    public final /* synthetic */ DeviceAware f$1;

    public /* synthetic */ LinkedDevicesAdapter$$ExternalSyntheticLambda0(LinkedDevicesAdapter linkedDevicesAdapter, DeviceAware deviceAware) {
        this.f$0 = linkedDevicesAdapter;
        this.f$1 = deviceAware;
    }

    public final void onClick(View view) {
        LinkedDevicesAdapter.onBindViewHolder$lambda$7(this.f$0, this.f$1, view);
    }
}
