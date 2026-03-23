package com.blueair.devicedetails.activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.card.MaterialCardView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomeConfigActivity$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ GoogleMap f$0;
    public final /* synthetic */ WelcomeHomeConfigActivity f$1;
    public final /* synthetic */ MaterialCardView f$2;

    public /* synthetic */ WelcomeHomeConfigActivity$$ExternalSyntheticLambda2(GoogleMap googleMap, WelcomeHomeConfigActivity welcomeHomeConfigActivity, MaterialCardView materialCardView) {
        this.f$0 = googleMap;
        this.f$1 = welcomeHomeConfigActivity;
        this.f$2 = materialCardView;
    }

    public final void run() {
        WelcomeHomeConfigActivity.onMapReady$lambda$27$lambda$26(this.f$0, this.f$1, this.f$2);
    }
}
