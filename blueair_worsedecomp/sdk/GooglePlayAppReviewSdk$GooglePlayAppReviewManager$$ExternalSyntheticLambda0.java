package com.blueair.sdk;

import com.blueair.sdk.GooglePlayAppReviewSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final void onComplete(Task task) {
        GooglePlayAppReviewSdk.GooglePlayAppReviewManager.requestInAppReview$lambda$1$lambda$0(this.f$0, task);
    }
}
