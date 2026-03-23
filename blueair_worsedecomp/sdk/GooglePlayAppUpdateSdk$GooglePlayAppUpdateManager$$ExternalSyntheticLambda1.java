package com.blueair.sdk;

import com.blueair.sdk.GooglePlayAppUpdateSdk;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda1 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager.checkInAppUpdate$lambda$1(this.f$0, obj);
    }
}
