package com.blueair.core.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/util/LocationPermissionTracker;", "", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "<init>", "(Lio/flatcircle/preferenceshelper2/Prefs;)V", "requestLocationPermission", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "preAction", "Lkotlin/Function0;", "requestCoarseLocationPermission", "requestLocationPermissionDialogOnly", "hasRequestedPermission", "", "hasRequestedCoarsePermission", "notifyRequestedPermission", "notifyRequestedCoarsePermission", "displayLocationPermissionDialog", "displayCoarseLocationPermissionDialog", "displayLocationPermissionAppInfo", "shouldShowLocationRequestPermissionDialog", "shouldShowCoarseLocationRequestPermissionDialog", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationPermissionTracker {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int REQUEST_CODE_LOCATION_PERMISSION = 10101;
   private final Prefs prefs;

   public LocationPermissionTracker(Prefs var1) {
      Intrinsics.checkNotNullParameter(var1, "prefs");
      super();
      this.prefs = var1;
   }

   private final void displayCoarseLocationPermissionDialog(Fragment var1) {
      this.notifyRequestedCoarsePermission();
      var1.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 10101);
   }

   private final void displayLocationPermissionAppInfo(Activity var1, Fragment var2) {
      Intent var3 = new Intent();
      var3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      var3.setData(Uri.fromParts("package", var1.getPackageName(), (String)null));
      if (var2 != null) {
         var2.startActivityForResult(var3, 10101);
      } else {
         var1.startActivityForResult(var3, 10101);
      }
   }

   private final void displayLocationPermissionAppInfo(Fragment var1) {
      FragmentActivity var2 = var1.getActivity();
      if (var2 != null) {
         this.displayLocationPermissionAppInfo((Activity)var2, var1);
      }

   }

   // $FF: synthetic method
   static void displayLocationPermissionAppInfo$default(LocationPermissionTracker var0, Activity var1, Fragment var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.displayLocationPermissionAppInfo(var1, var2);
   }

   private final void displayLocationPermissionDialog(Activity var1) {
      this.notifyRequestedPermission();
      ActivityCompat.requestPermissions(var1, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 10101);
   }

   private final void displayLocationPermissionDialog(Fragment var1, Function0 var2) {
      this.notifyRequestedPermission();
      var2.invoke();
      var1.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 10101);
   }

   private final boolean hasRequestedCoarsePermission() {
      Prefs var1 = this.prefs;
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "has_requested_coarse_location_permission", false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   private final boolean hasRequestedPermission() {
      Prefs var1 = this.prefs;
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "has_requested_location_permission", false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   private final void notifyRequestedCoarsePermission() {
      Prefs var1 = this.prefs;
      PreferencesHelper.INSTANCE.set(var1.getBackend(), "has_requested_coarse_location_permission", true, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   private final void notifyRequestedPermission() {
      Prefs var1 = this.prefs;
      PreferencesHelper.INSTANCE.set(var1.getBackend(), "has_requested_location_permission", true, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   private final boolean shouldShowCoarseLocationRequestPermissionDialog(Fragment var1) {
      return !this.hasRequestedCoarsePermission() || var1.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION");
   }

   private final boolean shouldShowLocationRequestPermissionDialog(Activity var1) {
      return !this.hasRequestedPermission() || ActivityCompat.shouldShowRequestPermissionRationale(var1, "android.permission.ACCESS_FINE_LOCATION") || ActivityCompat.shouldShowRequestPermissionRationale(var1, "android.permission.ACCESS_COARSE_LOCATION");
   }

   public final void requestCoarseLocationPermission(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      if (this.shouldShowCoarseLocationRequestPermissionDialog(var1)) {
         this.displayCoarseLocationPermissionDialog(var1);
      } else {
         this.displayLocationPermissionAppInfo(var1);
      }
   }

   public final void requestLocationPermission(Activity var1) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      if (this.shouldShowLocationRequestPermissionDialog(var1)) {
         this.displayLocationPermissionDialog(var1);
      } else {
         displayLocationPermissionAppInfo$default(this, var1, (Fragment)null, 2, (Object)null);
      }
   }

   public final void requestLocationPermission(Fragment var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      Intrinsics.checkNotNullParameter(var2, "preAction");
      if (this.shouldShowLocationRequestPermissionDialog(var1)) {
         this.displayLocationPermissionDialog(var1, var2);
      } else {
         this.displayLocationPermissionAppInfo(var1);
      }
   }

   public final void requestLocationPermissionDialogOnly(Fragment var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      Intrinsics.checkNotNullParameter(var2, "preAction");
      if (this.shouldShowLocationRequestPermissionDialog(var1)) {
         this.displayLocationPermissionDialog(var1, var2);
      }

   }

   public final boolean shouldShowLocationRequestPermissionDialog(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      return !this.hasRequestedPermission() || var1.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") || var1.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION");
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/util/LocationPermissionTracker$Companion;", "", "<init>", "()V", "REQUEST_CODE_LOCATION_PERMISSION", "", "core_otherRelease"},
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
