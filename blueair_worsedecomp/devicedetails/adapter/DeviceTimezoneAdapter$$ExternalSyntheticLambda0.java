package com.blueair.devicedetails.adapter;

import android.view.View;
import java.util.TimeZone;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceTimezoneAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DeviceTimezoneAdapter f$0;
    public final /* synthetic */ TimeZone f$1;

    public /* synthetic */ DeviceTimezoneAdapter$$ExternalSyntheticLambda0(DeviceTimezoneAdapter deviceTimezoneAdapter, TimeZone timeZone) {
        this.f$0 = deviceTimezoneAdapter;
        this.f$1 = timeZone;
    }

    public final void onClick(View view) {
        DeviceTimezoneAdapter.onBindViewHolder$lambda$0(this.f$0, this.f$1, view);
    }
}
