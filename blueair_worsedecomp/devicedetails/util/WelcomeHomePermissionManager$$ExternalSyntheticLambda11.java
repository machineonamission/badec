package com.blueair.devicedetails.util;

import androidx.activity.result.ActivityResultCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomePermissionManager$$ExternalSyntheticLambda11 implements ActivityResultCallback {
    public final /* synthetic */ WelcomeHomePermissionManager f$0;

    public /* synthetic */ WelcomeHomePermissionManager$$ExternalSyntheticLambda11(WelcomeHomePermissionManager welcomeHomePermissionManager) {
        this.f$0 = welcomeHomePermissionManager;
    }

    public final void onActivityResult(Object obj) {
        WelcomeHomePermissionManager.locationPermissionResultLauncher$lambda$0(this.f$0, (Boolean) obj);
    }
}
