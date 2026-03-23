package com.blueair.devicedetails.viewholder;

import com.blueair.core.model.HasFanSpeed;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DeviceScheduleManualModeViewHolder f$0;
    public final /* synthetic */ HasFanSpeed f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda0(DeviceScheduleManualModeViewHolder deviceScheduleManualModeViewHolder, HasFanSpeed hasFanSpeed, int i) {
        this.f$0 = deviceScheduleManualModeViewHolder;
        this.f$1 = hasFanSpeed;
        this.f$2 = i;
    }

    public final void run() {
        DeviceScheduleManualModeViewHolder.onProgressSet$lambda$3(this.f$0, this.f$1, this.f$2);
    }
}
