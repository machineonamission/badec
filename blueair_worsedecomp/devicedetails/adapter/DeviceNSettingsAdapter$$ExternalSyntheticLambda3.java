package com.blueair.devicedetails.adapter;

import android.view.View;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.util.DeviceNSettings;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceNSettingsAdapter$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ DeviceNSettingsAdapter f$0;
    public final /* synthetic */ DeviceNSettings f$1;
    public final /* synthetic */ Device f$2;

    public /* synthetic */ DeviceNSettingsAdapter$$ExternalSyntheticLambda3(DeviceNSettingsAdapter deviceNSettingsAdapter, DeviceNSettings deviceNSettings, Device device) {
        this.f$0 = deviceNSettingsAdapter;
        this.f$1 = deviceNSettings;
        this.f$2 = device;
    }

    public final void onClick(View view) {
        DeviceNSettingsAdapter.onBindViewHolder$lambda$3(this.f$0, this.f$1, this.f$2, view);
    }
}
