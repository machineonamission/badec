package com.blueair.devicedetails.activity;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomeConfigActivity$$ExternalSyntheticLambda20 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ WelcomeHomeConfigActivity$$ExternalSyntheticLambda20(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        WelcomeHomeConfigActivity.requestLocation$lambda$16(this.f$0, obj);
    }
}
