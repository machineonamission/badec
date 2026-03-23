package com.blueair.sdk;

import com.blueair.sdk.GooglePlayAppUpdateSdk;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda0(GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager googlePlayAppUpdateManager, int i) {
        this.f$0 = googlePlayAppUpdateManager;
        this.f$1 = i;
    }

    public final Object invoke(Object obj) {
        return GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager.checkInAppUpdate$lambda$0(this.f$0, this.f$1, (AppUpdateInfo) obj);
    }
}
