package com.blueair.devicemanager;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WelcomeHomeService$$ExternalSyntheticLambda5 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ WelcomeHomeService$$ExternalSyntheticLambda5(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        WelcomeHomeService.disableWelcomeHomeLocation$lambda$8$lambda$6(this.f$0, obj);
    }
}
