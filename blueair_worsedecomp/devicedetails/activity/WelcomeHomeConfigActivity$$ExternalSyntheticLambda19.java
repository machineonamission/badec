package com.blueair.devicedetails.activity;

import android.location.Location;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomeConfigActivity$$ExternalSyntheticLambda19 implements Function1 {
    public final /* synthetic */ WelcomeHomeConfigActivity f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ WelcomeHomeConfigActivity$$ExternalSyntheticLambda19(WelcomeHomeConfigActivity welcomeHomeConfigActivity, boolean z) {
        this.f$0 = welcomeHomeConfigActivity;
        this.f$1 = z;
    }

    public final Object invoke(Object obj) {
        return WelcomeHomeConfigActivity.requestLocation$lambda$15(this.f$0, this.f$1, (Location) obj);
    }
}
