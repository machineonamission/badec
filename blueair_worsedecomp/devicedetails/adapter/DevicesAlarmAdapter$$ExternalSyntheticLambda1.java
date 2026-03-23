package com.blueair.devicedetails.adapter;

import android.view.View;
import com.blueair.core.model.HasAlarm;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DevicesAlarmAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ DevicesAlarmAdapter f$0;
    public final /* synthetic */ HasAlarm f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DevicesAlarmAdapter$$ExternalSyntheticLambda1(DevicesAlarmAdapter devicesAlarmAdapter, HasAlarm hasAlarm, int i) {
        this.f$0 = devicesAlarmAdapter;
        this.f$1 = hasAlarm;
        this.f$2 = i;
    }

    public final void onClick(View view) {
        DevicesAlarmAdapter.onBindViewHolder$lambda$1(this.f$0, this.f$1, this.f$2, view);
    }
}
