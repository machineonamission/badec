package com.blueair.sdk;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirebaseSdk$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ FirebaseSdk$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onComplete(Task task) {
        FirebaseSdk.getInstallationsId$lambda$1(this.f$0, task);
    }
}
