package com.blueair.devicedetails.activity;

import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.ActivityAlarmListBinding;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AlarmListActivity$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ AlarmListActivity f$0;
    public final /* synthetic */ ActivityAlarmListBinding f$1;

    public /* synthetic */ AlarmListActivity$$ExternalSyntheticLambda8(AlarmListActivity alarmListActivity, ActivityAlarmListBinding activityAlarmListBinding) {
        this.f$0 = alarmListActivity;
        this.f$1 = activityAlarmListBinding;
    }

    public final Object invoke(Object obj) {
        return AlarmListActivity.configure$lambda$11$lambda$10(this.f$0, this.f$1, (Device) obj);
    }
}
