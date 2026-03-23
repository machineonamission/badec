package com.blueair.devicedetails.adapter;

import android.view.View;
import com.blueair.core.model.DeviceScheduleMerged;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScheduleCardAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ ScheduleCardAdapter f$0;
    public final /* synthetic */ DeviceScheduleMerged f$1;

    public /* synthetic */ ScheduleCardAdapter$$ExternalSyntheticLambda1(ScheduleCardAdapter scheduleCardAdapter, DeviceScheduleMerged deviceScheduleMerged) {
        this.f$0 = scheduleCardAdapter;
        this.f$1 = deviceScheduleMerged;
    }

    public final void onClick(View view) {
        ScheduleCardAdapter.onBindViewHolder$lambda$4(this.f$0, this.f$1, view);
    }
}
