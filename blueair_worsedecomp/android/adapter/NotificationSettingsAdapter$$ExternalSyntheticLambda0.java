package com.blueair.android.adapter;

import android.view.View;
import com.blueair.core.model.NotificationSetting;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationSettingsAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ NotificationSettingsAdapter f$0;
    public final /* synthetic */ NotificationSetting f$1;

    public /* synthetic */ NotificationSettingsAdapter$$ExternalSyntheticLambda0(NotificationSettingsAdapter notificationSettingsAdapter, NotificationSetting notificationSetting) {
        this.f$0 = notificationSettingsAdapter;
        this.f$1 = notificationSetting;
    }

    public final void onClick(View view) {
        NotificationSettingsAdapter.onBindViewHolder$lambda$0(this.f$0, this.f$1, view);
    }
}
