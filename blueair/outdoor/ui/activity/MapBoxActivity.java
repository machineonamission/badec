package com.blueair.outdoor.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.blueair.api.client.MbGeoClient;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.MutableLiveDataExtensionKt;
import com.blueair.outdoor.R;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.common.MapboxOptions;
import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapInitOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;
import com.mapbox.maps.extension.style.layers.properties.generated.IconRotationAlignment;
import com.mapbox.maps.plugin.annotation.Annotation;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationOptions;
import com.mapbox.maps.plugin.annotation.AnnotationsUtils;
import com.mapbox.maps.plugin.annotation.OnAnnotationClickListener;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotation;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.mapbox.maps.plugin.compass.CompassUtils;
import com.mapbox.maps.plugin.delegates.MapPluginExtensionsDelegate;
import com.mapbox.maps.plugin.delegates.MapPluginProviderDelegate;
import com.mapbox.maps.plugin.gestures.GesturesPlugin;
import com.mapbox.maps.plugin.gestures.GesturesUtils;
import com.mapbox.maps.plugin.gestures.OnMoveListener;
import com.mapbox.maps.plugin.scalebar.ScaleBarUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0016\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0!H\u0014J \u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0014J\b\u0010'\u001a\u00020\u0015H\u0014J\f\u0010(\u001a\u00020)*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"},
   d2 = {"Lcom/blueair/outdoor/ui/activity/MapBoxActivity;", "Lcom/blueair/outdoor/ui/activity/MapActivity;", "<init>", "()V", "mapView", "Lcom/mapbox/maps/MapView;", "mapBoxMap", "Lcom/mapbox/maps/MapboxMap;", "markerManager", "Lcom/mapbox/maps/plugin/annotation/generated/PointAnnotationManager;", "mapType", "", "getMapType", "()Ljava/lang/String;", "mbGeoClient", "Lcom/blueair/api/client/MbGeoClient;", "getMbGeoClient", "()Lcom/blueair/api/client/MbGeoClient;", "mbGeoClient$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureForMapBox", "startSearchIntent", "gotoLocationImpl", "location", "Lcom/blueair/core/model/TrackedLocation;", "zoom", "", "addMapMarkersImpl", "locations", "", "styleMarker", "markerId", "isSelected", "", "isCurrentLocation", "clearMapMarkersImpl", "getPoint", "Lcom/mapbox/geojson/Point;", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public class MapBoxActivity extends MapActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(MapBoxActivity.class, "mbGeoClient", "getMbGeoClient()Lcom/blueair/api/client/MbGeoClient;", 0)))};
   private static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @Deprecated
   public static final String MARKER_GPS_ICON = "gps_icon";
   @Deprecated
   public static final String MARKER_GPS_SELECTED_ICON = "gps_selected_icon";
   @Deprecated
   public static final String MARKER_LOCATION_ICON = "location_icon";
   @Deprecated
   public static final String MARKER_LOCATION_SELECTED_ICON = "location_selected_icon";
   private MapboxMap mapBoxMap;
   private final String mapType = "WGS";
   private MapView mapView;
   private PointAnnotationManager markerManager;
   private final Lazy mbGeoClient$delegate;

   // $FF: synthetic method
   public static boolean $r8$lambda$JqQoVuXTB_Q9jx7__yXnh_rN3II/* $FF was: $r8$lambda$JqQoVuXTB_Q9jx7-_yXnh_rN3II*/(MapBoxActivity var0, Point var1) {
      return configureForMapBox$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$La6N5_ka0QpO5k8jBs3s12pkII8(MapBoxActivity var0, Style var1) {
      configureForMapBox$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$ZmbAUvppVCAvRexq5CM1R7I2eeA(MapBoxActivity var0, PointAnnotation var1) {
      return configureForMapBox$lambda$6(var0, var1);
   }

   public MapBoxActivity() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.mbGeoClient$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, MbGeoClient.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final void configureForMapBox() {
      Context var1 = (Context)this;
      Object var2 = null;
      MapView var5 = new MapView(var1, (MapInitOptions)null, 2, (DefaultConstructorMarker)null);
      var5.setId(View.generateViewId());
      this.setMapViewId(var5.getId());
      ((FrameLayout)this.findViewById(R.id.map_container)).addView((View)var5);
      View var3 = this.findViewById(this.getMapViewId());
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.mapView = (MapView)var3;
      MapPluginProviderDelegate var4 = (MapPluginProviderDelegate)var5;
      GesturesPlugin var11 = GesturesUtils.getGestures(var4);
      var11.setRotateEnabled(false);
      var11.setPitchEnabled(false);
      CompassUtils.getCompass(var4).setEnabled(false);
      ScaleBarUtils.getScaleBar(var4).setEnabled(false);
      MapboxMap var12 = var5.getMapboxMap();
      this.mapBoxMap = var12;
      MapboxMap var6 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
         var6 = null;
      }

      var6.loadStyle("mapbox://styles/mapbox/streets-v12", new MapBoxActivity$$ExternalSyntheticLambda0(this));
      PointAnnotationManager var13 = PointAnnotationManagerKt.createPointAnnotationManager$default(AnnotationsUtils.getAnnotations(var4), (AnnotationConfig)null, 1, (Object)null);
      this.markerManager = var13;
      PointAnnotationManager var7 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("markerManager");
         var7 = null;
      }

      var7.setIconRotationAlignment(IconRotationAlignment.VIEWPORT);
      var13 = this.markerManager;
      var7 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("markerManager");
         var7 = null;
      }

      var7.addClickListener((OnAnnotationClickListener)(new MapBoxActivity$$ExternalSyntheticLambda1(this)));
      this.onMapReady();
      MapboxMap var15 = this.mapBoxMap;
      MapboxMap var9 = var15;
      if (var15 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
         var9 = null;
      }

      GesturesUtils.addOnMapLongClickListener((MapPluginExtensionsDelegate)var9, new MapBoxActivity$$ExternalSyntheticLambda2(this));
      var9 = this.mapBoxMap;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
         var9 = (MapboxMap)var2;
      }

      GesturesUtils.addOnMoveListener((MapPluginExtensionsDelegate)var9, new OnMoveListener(this) {
         final MapBoxActivity this$0;

         {
            this.this$0 = var1;
         }

         public boolean onMove(MoveGestureDetector var1) {
            Intrinsics.checkNotNullParameter(var1, "detector");
            return false;
         }

         public void onMoveBegin(MoveGestureDetector var1) {
            Intrinsics.checkNotNullParameter(var1, "detector");
            this.this$0.setMinimizedModeIfNeeded();
         }

         public void onMoveEnd(MoveGestureDetector var1) {
            Intrinsics.checkNotNullParameter(var1, "detector");
            MapboxMap var2 = this.this$0.mapBoxMap;
            MapboxMap var3 = var2;
            if (var2 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
               var3 = null;
            }

            Point var4 = var3.getCameraState().getCenter();
            Intrinsics.checkNotNullExpressionValue(var4, "getCenter(...)");
            this.this$0.getViewModel().setCurrentlyViewedLocation(var4.latitude(), var4.longitude(), this.this$0.getLocalMapType());
            this.this$0.updateAirQualityIfNeeded(var4.latitude(), var4.longitude());
         }
      });
      this.setupLocationServices();
      MutableLiveDataExtensionKt.forceRefresh(this.getViewModel().getViewLocation());
   }

   private static final void configureForMapBox$lambda$5(MapBoxActivity var0, Style var1) {
      Intrinsics.checkNotNullParameter(var1, "style");
      Bitmap var2 = var0.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_location_marker, 80, 80);
      if (var2 != null) {
         var1.addImage("location_icon", var2);
      }

      var2 = var0.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_location_marker_selected, 80, 80);
      if (var2 != null) {
         var1.addImage("location_selected_icon", var2);
      }

      var2 = var0.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_gps_marker, 45, 45);
      if (var2 != null) {
         var1.addImage("gps_icon", var2);
      }

      Bitmap var3 = var0.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_gps_marker_selected, 45, 45);
      if (var3 != null) {
         var1.addImage("gps_selected_icon", var3);
      }

   }

   private static final boolean configureForMapBox$lambda$6(MapBoxActivity var0, PointAnnotation var1) {
      Intrinsics.checkNotNullParameter(var1, "marker");
      var0.onMarkerTapped(var1.getId());
      return true;
   }

   private static final boolean configureForMapBox$lambda$7(MapBoxActivity var0, Point var1) {
      Intrinsics.checkNotNullParameter(var1, "point");
      var0.setMinimizedModeIfNeeded();
      var0.getViewModel().viewLocation(var1.latitude(), var1.longitude(), var0.getLocalMapType());
      return true;
   }

   private final MbGeoClient getMbGeoClient() {
      return (MbGeoClient)this.mbGeoClient$delegate.getValue();
   }

   private final Point getPoint(TrackedLocation var1) {
      Pair var2 = var1.getLatLngInWGS();
      Point var3 = Point.fromLngLat(((Number)var2.getSecond()).doubleValue(), ((Number)var2.getFirst()).doubleValue());
      Intrinsics.checkNotNullExpressionValue(var3, "fromLngLat(...)");
      return var3;
   }

   protected void addMapMarkersImpl(List var1) {
      Intrinsics.checkNotNullParameter(var1, "locations");
      Map var3 = (Map)(new LinkedHashMap());

      for(TrackedLocation var5 : var1) {
         PointAnnotationOptions var2 = (new PointAnnotationOptions()).withPoint(this.getPoint(var5));
         String var7;
         if (var5.isCurrentLocation()) {
            var7 = "gps_icon";
         } else {
            var7 = "location_icon";
         }

         PointAnnotationOptions var6 = var2.withIconImage(var7);
         PointAnnotationManager var9 = this.markerManager;
         PointAnnotationManager var8 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            var8 = null;
         }

         var3.put(((PointAnnotation)var8.create((AnnotationOptions)var6)).getId(), var5.getId());
      }

      this.getViewModel().setMarkers(var3);
   }

   protected void clearMapMarkersImpl() {
      PointAnnotationManager var2 = this.markerManager;
      PointAnnotationManager var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("markerManager");
         var1 = null;
      }

      var1.deleteAll();
      this.getViewModel().getMarkers().clear();
   }

   public String getMapType() {
      return this.mapType;
   }

   protected void gotoLocationImpl(TrackedLocation var1, float var2) {
      Intrinsics.checkNotNullParameter(var1, "location");
      MapboxMap var4 = this.mapBoxMap;
      MapboxMap var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
         var3 = null;
      }

      CameraOptions.Builder var6 = new CameraOptions.Builder();
      var6.center(this.getPoint(var1));
      var6.zoom((double)var2);
      CameraOptions var5 = var6.build();
      Intrinsics.checkNotNullExpressionValue(var5, "Builder().apply(block).build()");
      var3.setCamera(var5);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      MapboxOptions.setAccessToken(this.getMbGeoClient().getKey());
      this.configureForMapBox();
   }

   protected void startSearchIntent() {
      Intent var1 = new Intent((Context)this, SearchActivity.class);
      var1.putExtra("request_code", 102);
      this.startActivityForResult(var1, 102);
   }

   protected void styleMarker(String var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "markerId");
      PointAnnotationManager var6 = this.markerManager;
      Object var5 = null;
      PointAnnotationManager var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("markerManager");
         var4 = null;
      }

      Iterator var12 = ((Iterable)var4.getAnnotations()).iterator();

      while(true) {
         if (var12.hasNext()) {
            Object var10 = var12.next();
            if (!Intrinsics.areEqual(((PointAnnotation)var10).getId(), var1)) {
               continue;
            }

            var7 = var10;
            break;
         }

         var7 = null;
         break;
      }

      PointAnnotation var11 = (PointAnnotation)var7;
      if (var11 != null) {
         if (var3) {
            if (var2) {
               var1 = "gps_selected_icon";
            } else {
               var1 = "gps_icon";
            }
         } else if (var2) {
            var1 = "location_selected_icon";
         } else {
            var1 = "location_icon";
         }

         var11.setIconImage(var1);
         PointAnnotationManager var9 = this.markerManager;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            var9 = (PointAnnotationManager)var5;
         }

         var9.update((Annotation)var11);
      }

   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/outdoor/ui/activity/MapBoxActivity$Companion;", "", "<init>", "()V", "MARKER_LOCATION_ICON", "", "MARKER_LOCATION_SELECTED_ICON", "MARKER_GPS_ICON", "MARKER_GPS_SELECTED_ICON", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
