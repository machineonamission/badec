package com.blueair.devicedetails.viewholder;

import android.widget.CompoundButton;
import com.blueair.core.model.DeviceAlarm;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AlarmCardViewHolder$$ExternalSyntheticLambda3 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AlarmCardViewHolder f$0;
    public final /* synthetic */ DeviceAlarm f$1;

    public /* synthetic */ AlarmCardViewHolder$$ExternalSyntheticLambda3(AlarmCardViewHolder alarmCardViewHolder, DeviceAlarm deviceAlarm) {
        this.f$0 = alarmCardViewHolder;
        this.f$1 = deviceAlarm;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AlarmCardViewHolder.bind$lambda$6$lambda$5(this.f$0, this.f$1, compoundButton, z);
    }
}
