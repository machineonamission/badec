package com.blueair.devicedetails.util;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomePermissionManager$$ExternalSyntheticLambda2 implements FragmentResultListener {
    public final /* synthetic */ WelcomeHomePermissionManager f$0;

    public /* synthetic */ WelcomeHomePermissionManager$$ExternalSyntheticLambda2(WelcomeHomePermissionManager welcomeHomePermissionManager) {
        this.f$0 = welcomeHomePermissionManager;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        WelcomeHomePermissionManager.onBackgroundLocationPermissionDenied$lambda$11(this.f$0, str, bundle);
    }
}
