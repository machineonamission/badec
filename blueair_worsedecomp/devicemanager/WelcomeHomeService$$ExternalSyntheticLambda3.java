package com.blueair.devicemanager;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomeService$$ExternalSyntheticLambda3 implements OnFailureListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ WelcomeHomeService$$ExternalSyntheticLambda3(String str) {
        this.f$0 = str;
    }

    public final void onFailure(Exception exc) {
        WelcomeHomeService.addGeofence$lambda$4$lambda$3(this.f$0, exc);
    }
}
