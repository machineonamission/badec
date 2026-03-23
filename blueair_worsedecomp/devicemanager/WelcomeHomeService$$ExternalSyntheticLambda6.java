package com.blueair.devicemanager;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomeService$$ExternalSyntheticLambda6 implements OnFailureListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ WelcomeHomeService$$ExternalSyntheticLambda6(String str) {
        this.f$0 = str;
    }

    public final void onFailure(Exception exc) {
        WelcomeHomeService.disableWelcomeHomeLocation$lambda$8$lambda$7(this.f$0, exc);
    }
}
