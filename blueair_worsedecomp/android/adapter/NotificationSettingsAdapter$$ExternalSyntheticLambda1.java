package com.blueair.android.adapter;

import android.widget.CompoundButton;
import com.blueair.core.model.NotificationSetting;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationSettingsAdapter$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ NotificationSettingsAdapter f$0;
    public final /* synthetic */ NotificationSetting f$1;

    public /* synthetic */ NotificationSettingsAdapter$$ExternalSyntheticLambda1(NotificationSettingsAdapter notificationSettingsAdapter, NotificationSetting notificationSetting) {
        this.f$0 = notificationSettingsAdapter;
        this.f$1 = notificationSetting;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NotificationSettingsAdapter.onBindViewHolder$lambda$1(this.f$0, this.f$1, compoundButton, z);
    }
}
