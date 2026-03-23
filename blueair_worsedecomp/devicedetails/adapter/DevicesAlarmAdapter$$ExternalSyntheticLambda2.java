package com.blueair.devicedetails.adapter;

import android.view.View;
import com.blueair.core.model.HasAlarm;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DevicesAlarmAdapter$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ DevicesAlarmAdapter f$0;
    public final /* synthetic */ HasAlarm f$1;

    public /* synthetic */ DevicesAlarmAdapter$$ExternalSyntheticLambda2(DevicesAlarmAdapter devicesAlarmAdapter, HasAlarm hasAlarm) {
        this.f$0 = devicesAlarmAdapter;
        this.f$1 = hasAlarm;
    }

    public final void onClick(View view) {
        DevicesAlarmAdapter.onBindViewHolder$lambda$2(this.f$0, this.f$1, view);
    }
}
