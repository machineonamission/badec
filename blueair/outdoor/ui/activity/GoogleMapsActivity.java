package com.blueair.outdoor.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.MutableLiveDataExtensionKt;
import com.blueair.outdoor.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.Place.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0017J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u000fH\u0014J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0014J\f\u0010)\u001a\u00020**\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006,"},
   d2 = {"Lcom/blueair/outdoor/ui/activity/GoogleMapsActivity;", "Lcom/blueair/outdoor/ui/activity/MapActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "<init>", "()V", "map", "Lcom/google/android/gms/maps/GoogleMap;", "markers", "", "Lcom/google/android/gms/maps/model/Marker;", "mapType", "", "getMapType", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureForGoogle", "startSearchIntent", "onMapReady", "googleMap", "addMapMarkersImpl", "locations", "", "Lcom/blueair/core/model/TrackedLocation;", "clearMapMarkersImpl", "styleMarker", "markerId", "isSelected", "", "isCurrentLocation", "getMarkerIcon", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "resId", "", "size", "gotoLocationImpl", "location", "zoom", "", "getLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GoogleMapsActivity extends MapActivity implements OnMapReadyCallback {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final List PLACES_DATA_FIELDS;
   private GoogleMap map;
   private final String mapType = "GCJ";
   private final List markers = (List)(new ArrayList());

   // $FF: synthetic method
   public static void $r8$lambda$E98LLEXMGeIjq3_S0elrnqcfoHQ/* $FF was: $r8$lambda$E98LLEXMGeIjq3-S0elrnqcfoHQ*/(GoogleMapsActivity var0, int var1) {
      onMapReady$lambda$5$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Pxi7UMHtsvumRUS2dyKRRxqB_HU(GoogleMapsActivity var0, LatLng var1) {
      onMapReady$lambda$5$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$_f_o4gVFFDQIDirRbTHdpZwDrFw/* $FF was: $r8$lambda$_f-o4gVFFDQIDirRbTHdpZwDrFw*/(GoogleMapsActivity var0, Marker var1) {
      return onMapReady$lambda$5$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$npOM4Tds7WmhN2MkNHTJLz_2E2Q(GoogleMap var0, GoogleMapsActivity var1) {
      onMapReady$lambda$5$lambda$3(var0, var1);
   }

   static {
      PLACES_DATA_FIELDS = CollectionsKt.listOf(new Place.Field[]{Field.ID, Field.NAME, Field.ADDRESS, Field.LAT_LNG, Field.VIEWPORT});
   }

   private final void configureForGoogle() {
      SupportMapFragment var1 = SupportMapFragment.newInstance();
      Intrinsics.checkNotNullExpressionValue(var1, "newInstance(...)");
      FragmentManager var2 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      FragmentTransaction var3 = var2.beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var3, "beginTransaction()");
      var3.replace(R.id.map_container, (Fragment)var1);
      var3.commit();
      var1.getMapAsync(this);
   }

   private final LatLng getLatLng(TrackedLocation var1) {
      Pair var2 = var1.getLatLngInGCJ();
      return new LatLng(((Number)var2.getFirst()).doubleValue(), ((Number)var2.getSecond()).doubleValue());
   }

   private final BitmapDescriptor getMarkerIcon(int var1, int var2) {
      Bitmap var3 = this.getMarkerIcon(var1, var2, var2);
      return var3 != null ? BitmapDescriptorFactory.fromBitmap(var3) : null;
   }

   private static final void onMapReady$lambda$5$lambda$1(GoogleMapsActivity var0, LatLng var1) {
      Intrinsics.checkNotNullParameter(var1, "latLng");
      var0.setMinimizedModeIfNeeded();
      var0.getViewModel().viewLocation(var1.latitude, var1.longitude, var0.getLocalMapType());
   }

   private static final void onMapReady$lambda$5$lambda$2(GoogleMapsActivity var0, int var1) {
      if (var1 == 1) {
         var0.setMinimizedModeIfNeeded();
      }

   }

   private static final void onMapReady$lambda$5$lambda$3(GoogleMap var0, GoogleMapsActivity var1) {
      LatLng var2 = var0.getCameraPosition().target;
      Intrinsics.checkNotNullExpressionValue(var2, "target");
      var1.getViewModel().setCurrentlyViewedLocation(var2.latitude, var2.longitude, var1.getLocalMapType());
      var1.updateAirQualityIfNeeded(var2.latitude, var2.longitude);
   }

   private static final boolean onMapReady$lambda$5$lambda$4(GoogleMapsActivity var0, Marker var1) {
      Intrinsics.checkNotNullParameter(var1, "marker");
      String var2 = var1.getId();
      Intrinsics.checkNotNullExpressionValue(var2, "getId(...)");
      var0.onMarkerTapped(var2);
      return true;
   }

   protected void addMapMarkersImpl(List var1) {
      Intrinsics.checkNotNullParameter(var1, "locations");
      BitmapDescriptor var5 = this.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_location_marker, 80);
      BitmapDescriptor var6 = this.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_gps_marker, 45);
      Map var8 = (Map)(new LinkedHashMap());
      int var3 = ((Collection)var1).size();

      for(int var2 = 0; var2 < var3; ++var2) {
         TrackedLocation var9 = (TrackedLocation)var1.get(var2);
         MarkerOptions var10 = (new MarkerOptions()).title(this.getString(com.blueair.viewcore.R.string.map_marker_title, new Object[]{var9.getCityName(), var9.getLocationName()})).position(this.getLatLng(var9));
         BitmapDescriptor var4;
         if (var9.isCurrentLocation()) {
            var4 = var6;
         } else {
            var4 = var5;
         }

         if (var4 != null) {
            var10.icon(var4);
         }

         Intrinsics.checkNotNullExpressionValue(var10, "apply(...)");
         GoogleMap var7 = this.map;
         GoogleMap var11 = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("map");
            var11 = null;
         }

         Marker var12 = var11.addMarker(var10);
         if (var12 != null) {
            this.markers.add(var12);
            var8.put(var12.getId(), var9.getId());
         }
      }

      this.getViewModel().setMarkers(var8);
   }

   protected void clearMapMarkersImpl() {
      Iterator var1 = this.markers.iterator();

      while(var1.hasNext()) {
         ((Marker)var1.next()).remove();
      }

      this.markers.clear();
      this.getViewModel().getMarkers().clear();
   }

   public String getMapType() {
      return this.mapType;
   }

   protected void gotoLocationImpl(TrackedLocation var1, float var2) {
      Intrinsics.checkNotNullParameter(var1, "location");
      CameraPosition var4 = (new CameraPosition.Builder()).target(this.getLatLng(var1)).zoom(var2).build();
      Intrinsics.checkNotNullExpressionValue(var4, "build(...)");
      GoogleMap var3 = this.map;
      GoogleMap var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("map");
         var5 = null;
      }

      var5.animateCamera(CameraUpdateFactory.newCameraPosition(var4));
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.configureForGoogle();
   }

   public void onMapReady(GoogleMap var1) {
      Intrinsics.checkNotNullParameter(var1, "googleMap");
      this.map = var1;
      this.setupLocationServices();
      Timber.Forest.d("onMapReady", new Object[0]);
      this.onMapReady();
      var1.setMyLocationEnabled(false);
      var1.getUiSettings().setCompassEnabled(false);
      var1.getUiSettings().setMapToolbarEnabled(true);
      var1.getUiSettings().setZoomControlsEnabled(false);
      var1.getUiSettings().setRotateGesturesEnabled(false);
      var1.getUiSettings().setTiltGesturesEnabled(false);
      var1.getUiSettings().setIndoorLevelPickerEnabled(false);
      var1.getUiSettings().setMyLocationButtonEnabled(false);
      var1.setMaxZoomPreference(16.0F);
      var1.setOnMapLongClickListener(new GoogleMapsActivity$$ExternalSyntheticLambda0(this));
      var1.setOnCameraMoveStartedListener(new GoogleMapsActivity$$ExternalSyntheticLambda1(this));
      var1.setOnCameraMoveListener(new GoogleMapsActivity$$ExternalSyntheticLambda2(var1, this));
      var1.setOnMarkerClickListener(new GoogleMapsActivity$$ExternalSyntheticLambda3(this));
      MutableLiveDataExtensionKt.forceRefresh(this.getViewModel().getViewLocation());
   }

   protected void startSearchIntent() {
      Intent var1 = new Intent((Context)this, SearchActivity.class);
      var1.putExtra("request_code", 101);
      this.startActivityForResult(var1, 101);
   }

   protected void styleMarker(String var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "markerId");
      Iterator var6 = ((Iterable)this.markers).iterator();

      while(true) {
         if (var6.hasNext()) {
            Object var5 = var6.next();
            if (!Intrinsics.areEqual(((Marker)var5).getId(), var1)) {
               continue;
            }

            var7 = var5;
            break;
         }

         var7 = null;
         break;
      }

      Marker var10 = (Marker)var7;
      if (var10 != null) {
         BitmapDescriptor var8;
         if (var3) {
            int var4;
            if (var2) {
               var4 = com.blueair.viewcore.R.drawable.ic_gps_marker_selected;
            } else {
               var4 = com.blueair.viewcore.R.drawable.ic_gps_marker;
            }

            var8 = this.getMarkerIcon(var4, 45);
         } else {
            int var9;
            if (var2) {
               var9 = com.blueair.viewcore.R.drawable.ic_location_marker_selected;
            } else {
               var9 = com.blueair.viewcore.R.drawable.ic_location_marker;
            }

            var8 = this.getMarkerIcon(var9, 80);
         }

         var10.setIcon(var8);
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lcom/blueair/outdoor/ui/activity/GoogleMapsActivity$Companion;", "", "<init>", "()V", "PLACES_DATA_FIELDS", "", "Lcom/google/android/libraries/places/api/model/Place$Field;", "getPLACES_DATA_FIELDS", "()Ljava/util/List;", "outdoor_otherRelease"},
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

      public final List getPLACES_DATA_FIELDS() {
         return GoogleMapsActivity.PLACES_DATA_FIELDS;
      }
   }
}
