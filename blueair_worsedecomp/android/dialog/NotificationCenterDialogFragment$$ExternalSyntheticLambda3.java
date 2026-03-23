package com.blueair.android.dialog;

import com.blueair.android.databinding.DialogNotificationCenterBinding;
import com.blueair.core.model.NotificationSetting;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationCenterDialogFragment$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ DialogNotificationCenterBinding f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ NotificationCenterDialogFragment f$2;

    public /* synthetic */ NotificationCenterDialogFragment$$ExternalSyntheticLambda3(DialogNotificationCenterBinding dialogNotificationCenterBinding, boolean z, NotificationCenterDialogFragment notificationCenterDialogFragment) {
        this.f$0 = dialogNotificationCenterBinding;
        this.f$1 = z;
        this.f$2 = notificationCenterDialogFragment;
    }

    public final Object invoke(Object obj) {
        return NotificationCenterDialogFragment.onCreateView$lambda$19$lambda$7(this.f$0, this.f$1, this.f$2, (NotificationSetting) obj);
    }
}
