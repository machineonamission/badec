package com.blueair.push;

import androidx.activity.result.ActivityResultCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationPermissionManager$$ExternalSyntheticLambda2 implements ActivityResultCallback {
    public final /* synthetic */ NotificationPermissionManager f$0;

    public /* synthetic */ NotificationPermissionManager$$ExternalSyntheticLambda2(NotificationPermissionManager notificationPermissionManager) {
        this.f$0 = notificationPermissionManager;
    }

    public final void onActivityResult(Object obj) {
        NotificationPermissionManager.notificationPermissionResultLauncher$lambda$1(this.f$0, (Boolean) obj);
    }
}
