package com.blueair.devicedetails.activity;

import com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScheduleOverviewActivity$$ExternalSyntheticLambda19 implements Function1 {
    public final /* synthetic */ ScheduleOverviewActivity f$0;
    public final /* synthetic */ ActivityDeviceScheduleOverviewBinding f$1;

    public /* synthetic */ ScheduleOverviewActivity$$ExternalSyntheticLambda19(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding) {
        this.f$0 = scheduleOverviewActivity;
        this.f$1 = activityDeviceScheduleOverviewBinding;
    }

    public final Object invoke(Object obj) {
        return ScheduleOverviewActivity.configureView$lambda$39$lambda$24(this.f$0, this.f$1, (DeviceCreateEditScheduleViewModel.PurifierMode) obj);
    }
}
