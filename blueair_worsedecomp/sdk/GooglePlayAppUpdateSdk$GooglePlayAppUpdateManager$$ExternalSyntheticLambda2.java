package com.blueair.sdk;

import com.blueair.sdk.GooglePlayAppUpdateSdk;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda2(GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager googlePlayAppUpdateManager, int i) {
        this.f$0 = googlePlayAppUpdateManager;
        this.f$1 = i;
    }

    public final Object invoke(Object obj) {
        return GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager.resumeInAppUpdate$lambda$2(this.f$0, this.f$1, (AppUpdateInfo) obj);
    }
}
