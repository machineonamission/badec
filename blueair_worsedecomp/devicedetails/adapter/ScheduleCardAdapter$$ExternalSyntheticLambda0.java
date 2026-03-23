package com.blueair.devicedetails.adapter;

import android.widget.CompoundButton;
import com.blueair.core.model.DeviceScheduleMerged;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScheduleCardAdapter$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ DeviceScheduleMerged f$0;
    public final /* synthetic */ ScheduleCardAdapter f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ScheduleCardAdapter$$ExternalSyntheticLambda0(DeviceScheduleMerged deviceScheduleMerged, ScheduleCardAdapter scheduleCardAdapter, int i) {
        this.f$0 = deviceScheduleMerged;
        this.f$1 = scheduleCardAdapter;
        this.f$2 = i;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ScheduleCardAdapter.onBindViewHolder$lambda$3(this.f$0, this.f$1, this.f$2, compoundButton, z);
    }
}
