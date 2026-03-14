package com.blueair.auth;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.blueair.core.util.LocationUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010'\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0017J\u0010\u00102\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00064"},
   d2 = {"Lcom/blueair/auth/GpsLocation;", "Landroid/location/LocationListener;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isGPSEnabled", "", "isGPSEnabled$auth_otherRelease", "()Z", "setGPSEnabled$auth_otherRelease", "(Z)V", "isNetworkEnabled", "isNetworkEnabled$auth_otherRelease", "setNetworkEnabled$auth_otherRelease", "canGetLocation", "getCanGetLocation$auth_otherRelease", "setCanGetLocation$auth_otherRelease", "location", "Landroid/location/Location;", "getLocation$auth_otherRelease", "()Landroid/location/Location;", "setLocation$auth_otherRelease", "(Landroid/location/Location;)V", "latitude", "", "getLatitude$auth_otherRelease", "()D", "setLatitude$auth_otherRelease", "(D)V", "longitude", "getLongitude$auth_otherRelease", "setLongitude$auth_otherRelease", "locationManager", "Landroid/location/LocationManager;", "getLocationManager", "()Landroid/location/LocationManager;", "setLocationManager", "(Landroid/location/LocationManager;)V", "getLocation", "stopUsingGPS", "", "onLocationChanged", "onStatusChanged", "provider", "", "status", "", "extras", "Landroid/os/Bundle;", "onProviderEnabled", "onProviderDisabled", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GpsLocation implements LocationListener {
   private boolean canGetLocation;
   private boolean isGPSEnabled;
   private boolean isNetworkEnabled;
   private double latitude;
   private Location location;
   private LocationManager locationManager;
   private double longitude;
   private final Context mContext;

   public GpsLocation(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "mContext");
      super();
      this.mContext = var1;
   }

   private final void stopUsingGPS() {
      if (this.locationManager != null && LocationUtils.INSTANCE.isLocationPermissionGranted(this.mContext)) {
         LocationManager var1 = this.locationManager;
         Intrinsics.checkNotNull(var1);
         var1.removeUpdates(this);
      }

   }

   public final boolean getCanGetLocation$auth_otherRelease() {
      return this.canGetLocation;
   }

   public final double getLatitude$auth_otherRelease() {
      return this.latitude;
   }

   public final Location getLocation() {
      Exception var10000;
      label83: {
         boolean var1;
         label79: {
            try {
               Object var2 = this.mContext.getSystemService("location");
               Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type android.location.LocationManager");
               LocationManager var13 = (LocationManager)var2;
               this.locationManager = var13;
               Intrinsics.checkNotNull(var13);
               this.isGPSEnabled = var13.isProviderEnabled("gps");
               var13 = this.locationManager;
               Intrinsics.checkNotNull(var13);
               var1 = var13.isProviderEnabled("network");
               this.isNetworkEnabled = var1;
               if (this.isGPSEnabled) {
                  break label79;
               }
            } catch (Exception var12) {
               var10000 = var12;
               boolean var10001 = false;
               break label83;
            }

            if (!var1) {
               return null;
            }
         }

         try {
            this.canGetLocation = true;
         } catch (Exception var11) {
            var10000 = var11;
            boolean var27 = false;
            break label83;
         }

         if (var1) {
            LocationManager var16;
            try {
               var16 = this.locationManager;
               Intrinsics.checkNotNull(var16);
               var16.requestLocationUpdates("network", 0L, 0.0F, this);
               var16 = this.locationManager;
            } catch (Exception var10) {
               var10000 = var10;
               boolean var28 = false;
               break label83;
            }

            if (var16 != null) {
               try {
                  Intrinsics.checkNotNull(var16);
                  var17 = var16.getLastKnownLocation("network");
                  this.location = var17;
               } catch (Exception var9) {
                  var10000 = var9;
                  boolean var29 = false;
                  break label83;
               }

               if (var17 != null) {
                  try {
                     Intrinsics.checkNotNull(var17);
                     this.latitude = var17.getLatitude();
                     Location var18 = this.location;
                     Intrinsics.checkNotNull(var18);
                     this.longitude = var18.getLongitude();
                  } catch (Exception var8) {
                     var10000 = var8;
                     boolean var30 = false;
                     break label83;
                  }
               }
            }
         }

         LocationManager var20;
         try {
            if (!this.isGPSEnabled || this.location != null || !LocationUtils.INSTANCE.isLocationPermissionGranted(this.mContext)) {
               return this.location;
            }

            var20 = this.locationManager;
            Intrinsics.checkNotNull(var20);
            var20.requestLocationUpdates("gps", 0L, 0.0F, this);
            var20 = this.locationManager;
         } catch (Exception var7) {
            var10000 = var7;
            boolean var31 = false;
            break label83;
         }

         if (var20 == null) {
            return this.location;
         }

         try {
            Intrinsics.checkNotNull(var20);
            var21 = var20.getLastKnownLocation("gps");
            this.location = var21;
         } catch (Exception var6) {
            var10000 = var6;
            boolean var32 = false;
            break label83;
         }

         if (var21 == null) {
            return this.location;
         }

         try {
            Timber.Forest var23 = Timber.Forest;
            StringBuilder var24 = new StringBuilder("Latitude: ");
            Location var25 = this.location;
            Intrinsics.checkNotNull(var25);
            var24.append(var25.getLatitude());
            var24.append(" Longitude: ");
            var25 = this.location;
            Intrinsics.checkNotNull(var25);
            var24.append(var25.getLongitude());
            var23.d(var24.toString(), new Object[0]);
            return this.location;
         } catch (Exception var5) {
            var10000 = var5;
            boolean var33 = false;
         }
      }

      Exception var3 = var10000;
      Timber.Forest var22 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("getLocation failed ");
      var4.append(var3);
      var22.e(var4.toString(), new Object[0]);
      return this.location;
   }

   public final Location getLocation$auth_otherRelease() {
      return this.location;
   }

   protected final LocationManager getLocationManager() {
      return this.locationManager;
   }

   public final double getLongitude$auth_otherRelease() {
      return this.longitude;
   }

   public final boolean isGPSEnabled$auth_otherRelease() {
      return this.isGPSEnabled;
   }

   public final boolean isNetworkEnabled$auth_otherRelease() {
      return this.isNetworkEnabled;
   }

   public void onLocationChanged(Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      this.latitude = var1.getLatitude();
      this.longitude = var1.getLongitude();
      this.stopUsingGPS();
   }

   public void onProviderDisabled(String var1) {
      Intrinsics.checkNotNullParameter(var1, "provider");
   }

   public void onProviderEnabled(String var1) {
      Intrinsics.checkNotNullParameter(var1, "provider");
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onStatusChanged(String var1, int var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "provider");
      Intrinsics.checkNotNullParameter(var3, "extras");
   }

   public final void setCanGetLocation$auth_otherRelease(boolean var1) {
      this.canGetLocation = var1;
   }

   public final void setGPSEnabled$auth_otherRelease(boolean var1) {
      this.isGPSEnabled = var1;
   }

   public final void setLatitude$auth_otherRelease(double var1) {
      this.latitude = var1;
   }

   public final void setLocation$auth_otherRelease(Location var1) {
      this.location = var1;
   }

   protected final void setLocationManager(LocationManager var1) {
      this.locationManager = var1;
   }

   public final void setLongitude$auth_otherRelease(double var1) {
      this.longitude = var1;
   }

   public final void setNetworkEnabled$auth_otherRelease(boolean var1) {
      this.isNetworkEnabled = var1;
   }
}
