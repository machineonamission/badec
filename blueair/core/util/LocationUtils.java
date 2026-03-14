package com.blueair.core.util;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"},
   d2 = {"Lcom/blueair/core/util/LocationUtils;", "", "<init>", "()V", "isLocationPermissionGranted", "", "context", "Landroid/content/Context;", "isCoarseLocationPermissionGranted", "isLocationEnabled", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationUtils {
   public static final LocationUtils INSTANCE = new LocationUtils();

   private LocationUtils() {
   }

   public final boolean isCoarseLocationPermissionGranted(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return ContextCompat.checkSelfPermission(var1, "android.permission.ACCESS_COARSE_LOCATION") == 0;
   }

   public final boolean isLocationEnabled(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");

      try {
         Object var5 = var1.getSystemService("location");
         Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type android.location.LocationManager");
         LocationManager var6 = (LocationManager)var5;
         if (VERSION.SDK_INT >= 28) {
            return BlueairApp$$ExternalSyntheticApiModelOutline0.m(var6);
         } else {
            boolean var2 = var6.isProviderEnabled("gps");
            return var2;
         }
      } catch (Throwable var4) {
         Timber.Forest.w(var4, "isLocationEnabled failed", new Object[0]);
         return false;
      }
   }

   public final boolean isLocationPermissionGranted(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return ContextCompat.checkSelfPermission(var1, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(var1, "android.permission.ACCESS_COARSE_LOCATION") == 0;
   }
}
