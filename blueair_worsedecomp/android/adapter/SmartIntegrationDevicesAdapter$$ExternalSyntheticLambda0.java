package com.blueair.android.adapter;

import android.view.View;
import com.blueair.android.fragment.integration.IotDeviceConfig;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SmartIntegrationDevicesAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ SmartIntegrationDevicesAdapter f$0;
    public final /* synthetic */ IotDeviceConfig f$1;

    public /* synthetic */ SmartIntegrationDevicesAdapter$$ExternalSyntheticLambda0(SmartIntegrationDevicesAdapter smartIntegrationDevicesAdapter, IotDeviceConfig iotDeviceConfig) {
        this.f$0 = smartIntegrationDevicesAdapter;
        this.f$1 = iotDeviceConfig;
    }

    public final void onClick(View view) {
        SmartIntegrationDevicesAdapter.onBindViewHolder$lambda$0(this.f$0, this.f$1, view);
    }
}
