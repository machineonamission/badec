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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010'\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0017J\u0010\u00102\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00064"}, d2 = {"Lcom/blueair/auth/GpsLocation;", "Landroid/location/LocationListener;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isGPSEnabled", "", "isGPSEnabled$auth_otherRelease", "()Z", "setGPSEnabled$auth_otherRelease", "(Z)V", "isNetworkEnabled", "isNetworkEnabled$auth_otherRelease", "setNetworkEnabled$auth_otherRelease", "canGetLocation", "getCanGetLocation$auth_otherRelease", "setCanGetLocation$auth_otherRelease", "location", "Landroid/location/Location;", "getLocation$auth_otherRelease", "()Landroid/location/Location;", "setLocation$auth_otherRelease", "(Landroid/location/Location;)V", "latitude", "", "getLatitude$auth_otherRelease", "()D", "setLatitude$auth_otherRelease", "(D)V", "longitude", "getLongitude$auth_otherRelease", "setLongitude$auth_otherRelease", "locationManager", "Landroid/location/LocationManager;", "getLocationManager", "()Landroid/location/LocationManager;", "setLocationManager", "(Landroid/location/LocationManager;)V", "getLocation", "stopUsingGPS", "", "onLocationChanged", "onStatusChanged", "provider", "", "status", "", "extras", "Landroid/os/Bundle;", "onProviderEnabled", "onProviderDisabled", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GpsLocation.kt */
public final class GpsLocation implements LocationListener {
    private boolean canGetLocation;
    private boolean isGPSEnabled;
    private boolean isNetworkEnabled;
    private double latitude;
    private Location location;
    private LocationManager locationManager;
    private double longitude;
    private final Context mContext;

    public void onProviderDisabled(String str) {
        Intrinsics.checkNotNullParameter(str, "provider");
    }

    public void onProviderEnabled(String str) {
        Intrinsics.checkNotNullParameter(str, "provider");
    }

    @Deprecated(message = "Deprecated in Java")
    public void onStatusChanged(String str, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "provider");
        Intrinsics.checkNotNullParameter(bundle, "extras");
    }

    public GpsLocation(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    public final boolean isGPSEnabled$auth_otherRelease() {
        return this.isGPSEnabled;
    }

    public final void setGPSEnabled$auth_otherRelease(boolean z) {
        this.isGPSEnabled = z;
    }

    public final boolean isNetworkEnabled$auth_otherRelease() {
        return this.isNetworkEnabled;
    }

    public final void setNetworkEnabled$auth_otherRelease(boolean z) {
        this.isNetworkEnabled = z;
    }

    public final boolean getCanGetLocation$auth_otherRelease() {
        return this.canGetLocation;
    }

    public final void setCanGetLocation$auth_otherRelease(boolean z) {
        this.canGetLocation = z;
    }

    public final Location getLocation$auth_otherRelease() {
        return this.location;
    }

    public final void setLocation$auth_otherRelease(Location location2) {
        this.location = location2;
    }

    public final double getLatitude$auth_otherRelease() {
        return this.latitude;
    }

    public final void setLatitude$auth_otherRelease(double d) {
        this.latitude = d;
    }

    public final double getLongitude$auth_otherRelease() {
        return this.longitude;
    }

    public final void setLongitude$auth_otherRelease(double d) {
        this.longitude = d;
    }

    /* access modifiers changed from: protected */
    public final LocationManager getLocationManager() {
        return this.locationManager;
    }

    /* access modifiers changed from: protected */
    public final void setLocationManager(LocationManager locationManager2) {
        this.locationManager = locationManager2;
    }

    public final Location getLocation() {
        try {
            Object systemService = this.mContext.getSystemService("location");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            LocationManager locationManager2 = (LocationManager) systemService;
            this.locationManager = locationManager2;
            Intrinsics.checkNotNull(locationManager2);
            this.isGPSEnabled = locationManager2.isProviderEnabled("gps");
            LocationManager locationManager3 = this.locationManager;
            Intrinsics.checkNotNull(locationManager3);
            boolean isProviderEnabled = locationManager3.isProviderEnabled("network");
            this.isNetworkEnabled = isProviderEnabled;
            if (!this.isGPSEnabled && !isProviderEnabled) {
                return null;
            }
            this.canGetLocation = true;
            if (isProviderEnabled) {
                LocationManager locationManager4 = this.locationManager;
                Intrinsics.checkNotNull(locationManager4);
                locationManager4.requestLocationUpdates("network", 0, 0.0f, this);
                LocationManager locationManager5 = this.locationManager;
                if (locationManager5 != null) {
                    Intrinsics.checkNotNull(locationManager5);
                    Location lastKnownLocation = locationManager5.getLastKnownLocation("network");
                    this.location = lastKnownLocation;
                    if (lastKnownLocation != null) {
                        Intrinsics.checkNotNull(lastKnownLocation);
                        this.latitude = lastKnownLocation.getLatitude();
                        Location location2 = this.location;
                        Intrinsics.checkNotNull(location2);
                        this.longitude = location2.getLongitude();
                    }
                }
            }
            if (this.isGPSEnabled && this.location == null && LocationUtils.INSTANCE.isLocationPermissionGranted(this.mContext)) {
                LocationManager locationManager6 = this.locationManager;
                Intrinsics.checkNotNull(locationManager6);
                locationManager6.requestLocationUpdates("gps", 0, 0.0f, this);
                LocationManager locationManager7 = this.locationManager;
                if (locationManager7 != null) {
                    Intrinsics.checkNotNull(locationManager7);
                    Location lastKnownLocation2 = locationManager7.getLastKnownLocation("gps");
                    this.location = lastKnownLocation2;
                    if (lastKnownLocation2 != null) {
                        Timber.Forest forest = Timber.Forest;
                        StringBuilder sb = new StringBuilder("Latitude: ");
                        Location location3 = this.location;
                        Intrinsics.checkNotNull(location3);
                        sb.append(location3.getLatitude());
                        sb.append(" Longitude: ");
                        Location location4 = this.location;
                        Intrinsics.checkNotNull(location4);
                        sb.append(location4.getLongitude());
                        forest.d(sb.toString(), new Object[0]);
                    }
                }
            }
            return this.location;
        } catch (Exception e) {
            Timber.Forest forest2 = Timber.Forest;
            forest2.e("getLocation failed " + e, new Object[0]);
        }
    }

    private final void stopUsingGPS() {
        if (this.locationManager != null && LocationUtils.INSTANCE.isLocationPermissionGranted(this.mContext)) {
            LocationManager locationManager2 = this.locationManager;
            Intrinsics.checkNotNull(locationManager2);
            locationManager2.removeUpdates(this);
        }
    }

    public void onLocationChanged(Location location2) {
        Intrinsics.checkNotNullParameter(location2, "location");
        this.latitude = location2.getLatitude();
        this.longitude = location2.getLongitude();
        stopUsingGPS();
    }
}
