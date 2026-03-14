package com.blueair.sdk;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"},
   d2 = {"Lcom/blueair/sdk/GooglePlayAppReviewSdk;", "", "<init>", "()V", "createAppReviewManager", "Lcom/blueair/sdk/GooglePlayAppReviewSdk$GooglePlayAppReviewManager;", "activity", "Landroid/app/Activity;", "GooglePlayAppReviewManager", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GooglePlayAppReviewSdk {
   public static final GooglePlayAppReviewSdk INSTANCE = new GooglePlayAppReviewSdk();

   private GooglePlayAppReviewSdk() {
   }

   public final GooglePlayAppReviewManager createAppReviewManager(Activity var1) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      return new GooglePlayAppReviewManager(var1);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/sdk/GooglePlayAppReviewSdk$GooglePlayAppReviewManager;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "appReviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "requestInAppReview", "", "onComplete", "Lkotlin/Function0;", "sdk_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GooglePlayAppReviewManager {
      private final Activity activity;
      private final ReviewManager appReviewManager;

      // $FF: synthetic method
      public static void $r8$lambda$MjUHlUxWPZUnb3IWds8kEuyz0Kw(Function0 var0, Task var1) {
         requestInAppReview$lambda$1$lambda$0(var0, var1);
      }

      // $FF: synthetic method
      public static void $r8$lambda$c0CKH0JfHs0GC0drAudnWl6W4t4(GooglePlayAppReviewManager var0, Function0 var1, Task var2) {
         requestInAppReview$lambda$1(var0, var1, var2);
      }

      public GooglePlayAppReviewManager(Activity var1) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         super();
         this.activity = var1;
         ReviewManager var2 = ReviewManagerFactory.create((Context)var1);
         Intrinsics.checkNotNullExpressionValue(var2, "create(...)");
         this.appReviewManager = var2;
      }

      private static final void requestInAppReview$lambda$1(GooglePlayAppReviewManager var0, Function0 var1, Task var2) {
         Intrinsics.checkNotNullParameter(var2, "reviewInfoTask");
         if (var2.isSuccessful()) {
            ReviewInfo var3 = (ReviewInfo)var2.getResult();
            var0.appReviewManager.launchReviewFlow(var0.activity, var3).addOnCompleteListener(new GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda0(var1));
         }

      }

      private static final void requestInAppReview$lambda$1$lambda$0(Function0 var0, Task var1) {
         Intrinsics.checkNotNullParameter(var1, "it");
         var0.invoke();
      }

      public final void requestInAppReview(Function0 var1) {
         Intrinsics.checkNotNullParameter(var1, "onComplete");
         this.appReviewManager.requestReviewFlow().addOnCompleteListener(new GooglePlayAppReviewSdk$GooglePlayAppReviewManager$$ExternalSyntheticLambda1(this, var1));
      }
   }
}
