package com.blueair.devicedetails.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Build.VERSION;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.AppSettingsIntent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0003J\b\u0010\u0014\u001a\u00020\u0012H\u0003J\b\u0010\u0015\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0003J\b\u0010\u0019\u001a\u00020\u0007H\u0003J\b\u0010\u001a\u001a\u00020\u0007H\u0002J$\u0010\u001b\u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dJ&\u0010\u001f\u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0002J&\u0010 \u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0003J&\u0010!\u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0003J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0003J\b\u0010&\u001a\u00020\u0012H\u0003J\b\u0010'\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \f*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e0\u000e0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"},
   d2 = {"Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "isAndroidQ", "", "isAndroidR", "locationPermissionResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "locationPermissionResultLauncherApi29", "", "locationPermissionResultLauncherApi30", "backgroundLocationPermissionResultLauncher", "requestLocationPermission", "", "requestLocationPermissionApi29", "requestLocationPermissionApi30", "requestBackgroundLocationPermission", "isLocationPermissionGranted", "shouldShowLocationPermissionRationale", "isBackgroundLocationPermissionGranted", "shouldShowBackgroundLocationPermissionRationale", "isLocationEnabled", "checkAndRequest", "actionDenied", "Lkotlin/Function0;", "actionGranted", "checkAndRequestApiPre29", "checkAndRequestApi29", "checkAndRequestApi30", "onPermissionGrantedAndLocationEnabled", "onLocationPermissionRationale", "onLocationPermissionDenied", "onBackgroundLocationPermissionRationale", "onBackgroundLocationPermissionDenied", "onLocationDisabled", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomePermissionManager {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String TAG_BG_LOCATION_DENIED_DIALOG = "TAG_BG_LOCATION_DENIED_DIALOG";
   private static final String TAG_BG_LOCATION_RATIONALE_DIALOG = "TAG_BG_LOCATION_RATIONALE_DIALOG";
   private static final String TAG_LOCATION_DENIED_DIALOG = "TAG_LOCATION_DENIED_DIALOG";
   private static final String TAG_LOCATION_DISABLED_DIALOG = "TAG_LOCATION_DISABLED_DIALOG";
   private static final String TAG_LOCATION_RATIONALE_DIALOG = "TAG_LOCATION_RATIONALE_DIALOG";
   private final ActivityResultLauncher backgroundLocationPermissionResultLauncher;
   private final Fragment fragment;
   private final boolean isAndroidQ;
   private final boolean isAndroidR;
   private final ActivityResultLauncher locationPermissionResultLauncher;
   private final ActivityResultLauncher locationPermissionResultLauncherApi29;
   private final ActivityResultLauncher locationPermissionResultLauncherApi30;
   private Function0 onPermissionGrantedAndLocationEnabled;

   // $FF: synthetic method
   public static void $r8$lambda$3gBiGlj2Z4cqx1Saw_AY2xdPy2E/* $FF was: $r8$lambda$3gBiGlj2Z4cqx1Saw-AY2xdPy2E*/(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      onBackgroundLocationPermissionRationale$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$8Kmae8jUkX8VCejO1b1xkj9jPXA() {
      return checkAndRequestApi30$lambda$7();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$9_wnEoSGObNH0NDKYaFQgZQECc8() {
      return checkAndRequest$lambda$4();
   }

   // $FF: synthetic method
   public static void $r8$lambda$FsppQtwBHBx9UIGU3i1S0Wg3SFc(WelcomeHomePermissionManager var0, Boolean var1) {
      backgroundLocationPermissionResultLauncher$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KwD_cD2FTb7hOMy4cIGGgDXOsio(WelcomeHomePermissionManager var0, Boolean var1) {
      locationPermissionResultLauncher$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$L4Sq1A2vqymoOB81lwWR8iDjd_Q/* $FF was: $r8$lambda$L4Sq1A2vqymoOB81lwWR8iDjd-Q*/() {
      return checkAndRequestApi29$lambda$6();
   }

   // $FF: synthetic method
   public static void $r8$lambda$LCXhk01MVsHUodLc_qmEnTZFhOY/* $FF was: $r8$lambda$LCXhk01MVsHUodLc-qmEnTZFhOY*/(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      onBackgroundLocationPermissionDenied$lambda$11(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$LqT9bbgc3zKEHINdMMPh8v9YiUM(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      onLocationPermissionRationale$lambda$8(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$SvIleiNxWWd7aY4a3cC_mB_Eid8/* $FF was: $r8$lambda$SvIleiNxWWd7aY4a3cC-mB-Eid8*/(WelcomeHomePermissionManager var0, Map var1) {
      locationPermissionResultLauncherApi29$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nPOghapzOUDyWb18jCBNZi_dCq0(WelcomeHomePermissionManager var0, Boolean var1) {
      locationPermissionResultLauncherApi30$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$v9U_2hK2usz4Ew1EarydhRU78wI(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      onLocationPermissionDenied$lambda$9(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$w2weTo8uRbQBucRZ3JXj4XqwXwg(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      onLocationDisabled$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wno8HyfQvIdls9l40KMw4Wqlam4() {
      return checkAndRequestApiPre29$lambda$5();
   }

   public WelcomeHomePermissionManager(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      super();
      this.fragment = var1;
      int var2 = VERSION.SDK_INT;
      boolean var4 = true;
      boolean var3;
      if (var2 == 29) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.isAndroidQ = var3;
      if (VERSION.SDK_INT >= 30) {
         var3 = var4;
      } else {
         var3 = false;
      }

      this.isAndroidR = var3;
      ActivityResultLauncher var5 = var1.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestPermission()), new WelcomeHomePermissionManager$$ExternalSyntheticLambda11(this));
      Intrinsics.checkNotNullExpressionValue(var5, "registerForActivityResult(...)");
      this.locationPermissionResultLauncher = var5;
      var5 = var1.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestMultiplePermissions()), new WelcomeHomePermissionManager$$ExternalSyntheticLambda12(this));
      Intrinsics.checkNotNullExpressionValue(var5, "registerForActivityResult(...)");
      this.locationPermissionResultLauncherApi29 = var5;
      var5 = var1.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestPermission()), new WelcomeHomePermissionManager$$ExternalSyntheticLambda0(this));
      Intrinsics.checkNotNullExpressionValue(var5, "registerForActivityResult(...)");
      this.locationPermissionResultLauncherApi30 = var5;
      ActivityResultLauncher var6 = var1.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestPermission()), new WelcomeHomePermissionManager$$ExternalSyntheticLambda1(this));
      Intrinsics.checkNotNullExpressionValue(var6, "registerForActivityResult(...)");
      this.backgroundLocationPermissionResultLauncher = var6;
   }

   private static final void backgroundLocationPermissionResultLauncher$lambda$3(WelcomeHomePermissionManager var0, Boolean var1) {
      if (var1) {
         if (!var0.isLocationEnabled()) {
            var0.onLocationDisabled();
            return;
         }

         Function0 var2 = var0.onPermissionGrantedAndLocationEnabled;
         if (var2 != null) {
            var2.invoke();
            return;
         }
      } else if (!var0.shouldShowBackgroundLocationPermissionRationale()) {
         var0.onBackgroundLocationPermissionDenied();
         return;
      }

   }

   // $FF: synthetic method
   public static void checkAndRequest$default(WelcomeHomePermissionManager var0, Function0 var1, Function0 var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = new WelcomeHomePermissionManager$$ExternalSyntheticLambda10();
      }

      var0.checkAndRequest((Function0)var1, var2);
   }

   private static final Unit checkAndRequest$lambda$4() {
      return Unit.INSTANCE;
   }

   private final void checkAndRequestApi29(Function0 var1, Function0 var2) {
      this.onPermissionGrantedAndLocationEnabled = var2;
      if (this.shouldShowLocationPermissionRationale()) {
         this.onLocationPermissionRationale();
         var1.invoke();
      } else if (!this.isLocationPermissionGranted()) {
         this.requestLocationPermissionApi29();
         var1.invoke();
      } else if (this.shouldShowBackgroundLocationPermissionRationale()) {
         this.onBackgroundLocationPermissionRationale();
         var1.invoke();
      } else if (!this.isBackgroundLocationPermissionGranted()) {
         this.requestBackgroundLocationPermission();
         var1.invoke();
      } else if (!this.isLocationEnabled()) {
         this.onLocationDisabled();
         var1.invoke();
      } else {
         var1 = this.onPermissionGrantedAndLocationEnabled;
         if (var1 != null) {
            var1.invoke();
         }

      }
   }

   // $FF: synthetic method
   static void checkAndRequestApi29$default(WelcomeHomePermissionManager var0, Function0 var1, Function0 var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = new WelcomeHomePermissionManager$$ExternalSyntheticLambda8();
      }

      var0.checkAndRequestApi29((Function0)var1, var2);
   }

   private static final Unit checkAndRequestApi29$lambda$6() {
      return Unit.INSTANCE;
   }

   private final void checkAndRequestApi30(Function0 var1, Function0 var2) {
      this.onPermissionGrantedAndLocationEnabled = var2;
      if (this.shouldShowLocationPermissionRationale()) {
         this.onLocationPermissionRationale();
         var1.invoke();
      } else if (!this.isLocationPermissionGranted()) {
         this.requestLocationPermissionApi30();
         var1.invoke();
      } else if (this.shouldShowBackgroundLocationPermissionRationale()) {
         this.onBackgroundLocationPermissionRationale();
         var1.invoke();
      } else if (!this.isBackgroundLocationPermissionGranted()) {
         this.requestBackgroundLocationPermission();
         var1.invoke();
      } else if (!this.isLocationEnabled()) {
         this.onLocationDisabled();
         var1.invoke();
      } else {
         var1 = this.onPermissionGrantedAndLocationEnabled;
         if (var1 != null) {
            var1.invoke();
         }

      }
   }

   // $FF: synthetic method
   static void checkAndRequestApi30$default(WelcomeHomePermissionManager var0, Function0 var1, Function0 var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = new WelcomeHomePermissionManager$$ExternalSyntheticLambda5();
      }

      var0.checkAndRequestApi30((Function0)var1, var2);
   }

   private static final Unit checkAndRequestApi30$lambda$7() {
      return Unit.INSTANCE;
   }

   private final void checkAndRequestApiPre29(Function0 var1, Function0 var2) {
      this.onPermissionGrantedAndLocationEnabled = var2;
      if (this.shouldShowLocationPermissionRationale()) {
         this.onLocationPermissionRationale();
         var1.invoke();
      } else if (!this.isLocationPermissionGranted()) {
         this.requestLocationPermission();
         var1.invoke();
      } else if (!this.isLocationEnabled()) {
         this.onLocationDisabled();
         var1.invoke();
      } else {
         var1 = this.onPermissionGrantedAndLocationEnabled;
         if (var1 != null) {
            var1.invoke();
         }

      }
   }

   // $FF: synthetic method
   static void checkAndRequestApiPre29$default(WelcomeHomePermissionManager var0, Function0 var1, Function0 var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = new WelcomeHomePermissionManager$$ExternalSyntheticLambda7();
      }

      var0.checkAndRequestApiPre29((Function0)var1, var2);
   }

   private static final Unit checkAndRequestApiPre29$lambda$5() {
      return Unit.INSTANCE;
   }

   private final boolean isBackgroundLocationPermissionGranted() {
      if (this.isAndroidQ) {
         return ContextCompat.checkSelfPermission(this.fragment.requireContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
      } else {
         return true;
      }
   }

   private final boolean isLocationEnabled() {
      try {
         Object var2 = this.fragment.requireContext().getSystemService("location");
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type android.location.LocationManager");
         LocationManager var5 = (LocationManager)var2;
         if (VERSION.SDK_INT >= 28) {
            return BlueairApp$$ExternalSyntheticApiModelOutline0.m(var5);
         } else {
            boolean var1 = var5.isProviderEnabled("gps");
            return var1;
         }
      } catch (Throwable var4) {
         Timber.Forest.w(var4, "isLocationEnabled failed", new Object[0]);
         return false;
      }
   }

   private final boolean isLocationPermissionGranted() {
      return ContextCompat.checkSelfPermission(this.fragment.requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0;
   }

   private static final void locationPermissionResultLauncher$lambda$0(WelcomeHomePermissionManager var0, Boolean var1) {
      if (var1) {
         if (!var0.isLocationEnabled()) {
            var0.onLocationDisabled();
            return;
         }

         Function0 var2 = var0.onPermissionGrantedAndLocationEnabled;
         if (var2 != null) {
            var2.invoke();
            return;
         }
      } else if (!var0.shouldShowLocationPermissionRationale()) {
         var0.onLocationPermissionDenied();
         return;
      }

   }

   private static final void locationPermissionResultLauncherApi29$lambda$1(WelcomeHomePermissionManager var0, Map var1) {
      Boolean var2 = false;
      if (!var1.containsValue(var2)) {
         if (!var0.isLocationEnabled()) {
            var0.onLocationDisabled();
            return;
         }

         Function0 var3 = var0.onPermissionGrantedAndLocationEnabled;
         if (var3 != null) {
            var3.invoke();
            return;
         }
      } else {
         if (Intrinsics.areEqual(var1.get("android.permission.ACCESS_FINE_LOCATION"), true) && Intrinsics.areEqual(var1.get("android.permission.ACCESS_BACKGROUND_LOCATION"), var2) && var0.shouldShowBackgroundLocationPermissionRationale()) {
            var0.onBackgroundLocationPermissionRationale();
            return;
         }

         if (!var0.shouldShowLocationPermissionRationale() && !var0.shouldShowBackgroundLocationPermissionRationale()) {
            var0.onLocationPermissionDenied();
         }
      }

   }

   private static final void locationPermissionResultLauncherApi30$lambda$2(WelcomeHomePermissionManager var0, Boolean var1) {
      if (var1) {
         if (!var0.isBackgroundLocationPermissionGranted() && var0.shouldShowBackgroundLocationPermissionRationale()) {
            var0.onBackgroundLocationPermissionRationale();
            return;
         }

         if (!var0.isLocationEnabled()) {
            var0.onLocationDisabled();
            return;
         }

         Function0 var2 = var0.onPermissionGrantedAndLocationEnabled;
         if (var2 != null) {
            var2.invoke();
            return;
         }
      } else if (!var0.shouldShowLocationPermissionRationale()) {
         var0.onLocationPermissionDenied();
         return;
      }

   }

   private final void onBackgroundLocationPermissionDenied() {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.permission_denied, R.string.wh_bg_permission_denied_description, R.string.btn_goto_settings, R.string.btn_cancel, false, false, false, (String[])null, 240, (Object)null).show(this.fragment.getChildFragmentManager(), "TAG_BG_LOCATION_DENIED_DIALOG");
      this.fragment.getChildFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda2(this));
   }

   private static final void onBackgroundLocationPermissionDenied$lambda$11(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         AppSettingsIntent var4 = AppSettingsIntent.INSTANCE;
         Context var3 = var0.fragment.requireContext();
         Intrinsics.checkNotNullExpressionValue(var3, "requireContext(...)");
         var4.start(var3);
      }

   }

   private final void onBackgroundLocationPermissionRationale() {
      int var1;
      if (this.isAndroidR) {
         var1 = R.string.btn_goto_settings;
      } else {
         var1 = R.string.snackbar_ok;
      }

      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.wh_bg_location_permission_dialog_title, R.string.wh_bg_location_permission_rationale, var1, R.string.btn_cancel, this.isAndroidR, false, false, (String[])null, 224, (Object)null).show(this.fragment.getChildFragmentManager(), "TAG_BG_LOCATION_RATIONALE_DIALOG");
      this.fragment.getChildFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda3(this));
   }

   private static final void onBackgroundLocationPermissionRationale$lambda$10(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.requestBackgroundLocationPermission();
      }

   }

   private final void onLocationDisabled() {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.wh_location_permission_dialog_title, R.string.welcome_home_enable_location, R.string.enable_locations, R.string.btn_cancel, false, false, false, (String[])null, 224, (Object)null).show(this.fragment.getChildFragmentManager(), "TAG_LOCATION_DISABLED_DIALOG");
      this.fragment.getChildFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda6(this));
   }

   private static final void onLocationDisabled$lambda$12(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         Intent var3 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
         var3.setFlags(268435456);
         var0.fragment.startActivity(var3);
      }

   }

   private final void onLocationPermissionDenied() {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.permission_denied, R.string.wh_permission_denied_description, R.string.btn_goto_settings, R.string.btn_cancel, false, false, false, (String[])null, 240, (Object)null).show(this.fragment.getChildFragmentManager(), "TAG_LOCATION_DENIED_DIALOG");
      this.fragment.getChildFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda9(this));
   }

   private static final void onLocationPermissionDenied$lambda$9(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         AppSettingsIntent var4 = AppSettingsIntent.INSTANCE;
         Context var3 = var0.fragment.requireContext();
         Intrinsics.checkNotNullExpressionValue(var3, "requireContext(...)");
         var4.start(var3);
      }

   }

   private final void onLocationPermissionRationale() {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.wh_location_permission_dialog_title, R.string.wh_location_permission_dialog_description, R.string.snackbar_ok, R.string.btn_cancel, false, false, false, (String[])null, 240, (Object)null).show(this.fragment.getChildFragmentManager(), "TAG_LOCATION_RATIONALE_DIALOG");
      this.fragment.getChildFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda4(this));
   }

   private static final void onLocationPermissionRationale$lambda$8(WelcomeHomePermissionManager var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.requestLocationPermission();
      }

   }

   private final void requestLocationPermission() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
      this.locationPermissionResultLauncher.launch("android.permission.ACCESS_FINE_LOCATION");
   }

   private final void requestLocationPermissionApi29() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
      this.locationPermissionResultLauncherApi29.launch(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"});
   }

   private final void requestLocationPermissionApi30() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
      this.locationPermissionResultLauncherApi30.launch("android.permission.ACCESS_FINE_LOCATION");
   }

   private final boolean shouldShowBackgroundLocationPermissionRationale() {
      return this.isAndroidQ ? ActivityCompat.shouldShowRequestPermissionRationale((Activity)this.fragment.requireActivity(), "android.permission.ACCESS_BACKGROUND_LOCATION") : false;
   }

   private final boolean shouldShowLocationPermissionRationale() {
      return ActivityCompat.shouldShowRequestPermissionRationale((Activity)this.fragment.requireActivity(), "android.permission.ACCESS_FINE_LOCATION");
   }

   public final void checkAndRequest(Function0 var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "actionDenied");
      Intrinsics.checkNotNullParameter(var2, "actionGranted");
      if (this.isAndroidR) {
         this.checkAndRequestApi30(var1, var2);
      } else if (this.isAndroidQ) {
         this.checkAndRequestApi29(var1, var2);
      } else {
         this.checkAndRequestApiPre29(var1, var2);
      }
   }

   public final void requestBackgroundLocationPermission() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
      this.backgroundLocationPermissionResultLauncher.launch("android.permission.ACCESS_BACKGROUND_LOCATION");
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager$Companion;", "", "<init>", "()V", "TAG_LOCATION_DISABLED_DIALOG", "", "TAG_BG_LOCATION_DENIED_DIALOG", "TAG_BG_LOCATION_RATIONALE_DIALOG", "TAG_LOCATION_DENIED_DIALOG", "TAG_LOCATION_RATIONALE_DIALOG", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
