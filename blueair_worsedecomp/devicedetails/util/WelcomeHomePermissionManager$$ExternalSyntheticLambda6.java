package com.blueair.devicedetails.util;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomePermissionManager$$ExternalSyntheticLambda6 implements FragmentResultListener {
    public final /* synthetic */ WelcomeHomePermissionManager f$0;

    public /* synthetic */ WelcomeHomePermissionManager$$ExternalSyntheticLambda6(WelcomeHomePermissionManager welcomeHomePermissionManager) {
        this.f$0 = welcomeHomePermissionManager;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        WelcomeHomePermissionManager.onLocationDisabled$lambda$12(this.f$0, str, bundle);
    }
}
