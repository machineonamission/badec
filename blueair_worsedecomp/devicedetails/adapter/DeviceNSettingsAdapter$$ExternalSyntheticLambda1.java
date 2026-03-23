package com.blueair.devicedetails.adapter;

import com.blueair.core.model.Device;
import com.blueair.core.model.FilterTrigger;
import com.blueair.devicedetails.util.DeviceNSettings;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceNSettingsAdapter$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Device f$0;
    public final /* synthetic */ DeviceNSettingsAdapter f$1;
    public final /* synthetic */ DeviceNSettings f$2;

    public /* synthetic */ DeviceNSettingsAdapter$$ExternalSyntheticLambda1(Device device, DeviceNSettingsAdapter deviceNSettingsAdapter, DeviceNSettings deviceNSettings) {
        this.f$0 = device;
        this.f$1 = deviceNSettingsAdapter;
        this.f$2 = deviceNSettings;
    }

    public final Object invoke(Object obj) {
        return DeviceNSettingsAdapter.onBindViewHolder$lambda$1(this.f$0, this.f$1, this.f$2, (FilterTrigger) obj);
    }
}
