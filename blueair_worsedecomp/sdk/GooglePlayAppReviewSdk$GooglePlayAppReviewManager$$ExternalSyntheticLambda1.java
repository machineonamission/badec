package com.blueair.sdk;

import com.blueair.sdk.GooglePlayAppReviewSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public final /* synthetic */ GooglePlayAppReviewSdk.GooglePlayAppReviewManager f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda1(GooglePlayAppReviewSdk.GooglePlayAppReviewManager googlePlayAppReviewManager, Function0 function0) {
        this.f$0 = googlePlayAppReviewManager;
        this.f$1 = function0;
    }

    public final void onComplete(Task task) {
        GooglePlayAppReviewSdk.GooglePlayAppReviewManager.requestInAppReview$lambda$1(this.f$0, this.f$1, task);
    }
}
