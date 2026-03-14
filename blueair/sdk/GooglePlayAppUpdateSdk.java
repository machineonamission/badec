package com.blueair.sdk;

import android.app.Activity;
import android.content.Context;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"},
   d2 = {"Lcom/blueair/sdk/GooglePlayAppUpdateSdk;", "", "<init>", "()V", "createAppUpdateManager", "Lcom/blueair/sdk/GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager;", "activity", "Landroid/app/Activity;", "GooglePlayAppUpdateManager", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GooglePlayAppUpdateSdk {
   public static final GooglePlayAppUpdateSdk INSTANCE = new GooglePlayAppUpdateSdk();

   private GooglePlayAppUpdateSdk() {
   }

   public final GooglePlayAppUpdateManager createAppUpdateManager(Activity var1) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      return new GooglePlayAppUpdateManager(var1);
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/sdk/GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "checkInAppUpdate", "", "requestCode", "", "resumeInAppUpdate", "sdk_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GooglePlayAppUpdateManager {
      private final Activity activity;
      private final AppUpdateManager appUpdateManager;

      // $FF: synthetic method
      public static void $r8$lambda$_5KnZ4Oq38eXNL0EgIbyNwquiEY/* $FF was: $r8$lambda$-5KnZ4Oq38eXNL0EgIbyNwquiEY*/(Function1 var0, Object var1) {
         resumeInAppUpdate$lambda$3(var0, var1);
      }

      // $FF: synthetic method
      public static Unit $r8$lambda$RDGdy0eu7yZmCQp3v2HfP3Wry90(GooglePlayAppUpdateManager var0, int var1, AppUpdateInfo var2) {
         return resumeInAppUpdate$lambda$2(var0, var1, var2);
      }

      // $FF: synthetic method
      public static void $r8$lambda$n_ByUIYRjKICJzyw6vSb3fppliY(Function1 var0, Object var1) {
         checkInAppUpdate$lambda$1(var0, var1);
      }

      // $FF: synthetic method
      public static Unit $r8$lambda$wXqX78_pJ84Q1FRrjujrWVSu21E(GooglePlayAppUpdateManager var0, int var1, AppUpdateInfo var2) {
         return checkInAppUpdate$lambda$0(var0, var1, var2);
      }

      public GooglePlayAppUpdateManager(Activity var1) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         super();
         this.activity = var1;
         AppUpdateManager var2 = AppUpdateManagerFactory.create((Context)var1);
         Intrinsics.checkNotNullExpressionValue(var2, "create(...)");
         this.appUpdateManager = var2;
      }

      private static final Unit checkInAppUpdate$lambda$0(GooglePlayAppUpdateManager var0, int var1, AppUpdateInfo var2) {
         if (var2.updateAvailability() == 2 && var2.isUpdateTypeAllowed(1)) {
            var0.appUpdateManager.startUpdateFlowForResult(var2, 1, var0.activity, var1);
         }

         return Unit.INSTANCE;
      }

      private static final void checkInAppUpdate$lambda$1(Function1 var0, Object var1) {
         var0.invoke(var1);
      }

      private static final Unit resumeInAppUpdate$lambda$2(GooglePlayAppUpdateManager var0, int var1, AppUpdateInfo var2) {
         if (var2.updateAvailability() == 3) {
            var0.appUpdateManager.startUpdateFlowForResult(var2, 1, var0.activity, var1);
         }

         return Unit.INSTANCE;
      }

      private static final void resumeInAppUpdate$lambda$3(Function1 var0, Object var1) {
         var0.invoke(var1);
      }

      public final void checkInAppUpdate(int var1) {
         this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda1(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda0(this, var1)));
      }

      public final void resumeInAppUpdate(int var1) {
         this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda3(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda2(this, var1)));
      }
   }
}
