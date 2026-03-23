package com.blueair.sdk;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/sdk/GooglePlayAppReviewSdk;", "", "<init>", "()V", "createAppReviewManager", "Lcom/blueair/sdk/GooglePlayAppReviewSdk$GooglePlayAppReviewManager;", "activity", "Landroid/app/Activity;", "GooglePlayAppReviewManager", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GooglePlayAppReviewSdk.kt */
public final class GooglePlayAppReviewSdk {
    public static final GooglePlayAppReviewSdk INSTANCE = new GooglePlayAppReviewSdk();

    private GooglePlayAppReviewSdk() {
    }

    public final GooglePlayAppReviewManager createAppReviewManager(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new GooglePlayAppReviewManager(activity);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/sdk/GooglePlayAppReviewSdk$GooglePlayAppReviewManager;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "appReviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "requestInAppReview", "", "onComplete", "Lkotlin/Function0;", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GooglePlayAppReviewSdk.kt */
    public static final class GooglePlayAppReviewManager {
        private final Activity activity;
        private final ReviewManager appReviewManager;

        public GooglePlayAppReviewManager(Activity activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
            ReviewManager create = ReviewManagerFactory.create(activity2);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            this.appReviewManager = create;
        }

        public final void requestInAppReview(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onComplete");
            this.appReviewManager.requestReviewFlow().addOnCompleteListener(new GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda1(this, function0));
        }

        /* access modifiers changed from: private */
        public static final void requestInAppReview$lambda$1(GooglePlayAppReviewManager googlePlayAppReviewManager, Function0 function0, Task task) {
            Intrinsics.checkNotNullParameter(task, "reviewInfoTask");
            if (task.isSuccessful()) {
                googlePlayAppReviewManager.appReviewManager.launchReviewFlow(googlePlayAppReviewManager.activity, (ReviewInfo) task.getResult()).addOnCompleteListener(new GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda0(function0));
            }
        }

        /* access modifiers changed from: private */
        public static final void requestInAppReview$lambda$1$lambda$0(Function0 function0, Task task) {
            Intrinsics.checkNotNullParameter(task, "it");
            function0.invoke();
        }
    }
}
