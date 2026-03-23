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
import com.facebook.internal.AnalyticsEvents;
import com.mapbox.common.MapboxOptions;
import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapInitOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;
import com.mapbox.maps.extension.style.layers.properties.generated.IconRotationAlignment;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationsUtils;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotation;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.mapbox.maps.plugin.compass.CompassUtils;
import com.mapbox.maps.plugin.delegates.MapPluginProviderDelegate;
import com.mapbox.maps.plugin.gestures.GesturesPlugin;
import com.mapbox.maps.plugin.gestures.GesturesUtils;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0016\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0!H\u0014J \u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0014J\b\u0010'\u001a\u00020\u0015H\u0014J\f\u0010(\u001a\u00020)*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"}, d2 = {"Lcom/blueair/outdoor/ui/activity/MapBoxActivity;", "Lcom/blueair/outdoor/ui/activity/MapActivity;", "<init>", "()V", "mapView", "Lcom/mapbox/maps/MapView;", "mapBoxMap", "Lcom/mapbox/maps/MapboxMap;", "markerManager", "Lcom/mapbox/maps/plugin/annotation/generated/PointAnnotationManager;", "mapType", "", "getMapType", "()Ljava/lang/String;", "mbGeoClient", "Lcom/blueair/api/client/MbGeoClient;", "getMbGeoClient", "()Lcom/blueair/api/client/MbGeoClient;", "mbGeoClient$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureForMapBox", "startSearchIntent", "gotoLocationImpl", "location", "Lcom/blueair/core/model/TrackedLocation;", "zoom", "", "addMapMarkersImpl", "locations", "", "styleMarker", "markerId", "isSelected", "", "isCurrentLocation", "clearMapMarkersImpl", "getPoint", "Lcom/mapbox/geojson/Point;", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MapBoxActivity.kt */
public class MapBoxActivity extends MapActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MapBoxActivity.class, "mbGeoClient", "getMbGeoClient()Lcom/blueair/api/client/MbGeoClient;", 0))};
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String MARKER_GPS_ICON = "gps_icon";
    @Deprecated
    public static final String MARKER_GPS_SELECTED_ICON = "gps_selected_icon";
    @Deprecated
    public static final String MARKER_LOCATION_ICON = "location_icon";
    @Deprecated
    public static final String MARKER_LOCATION_SELECTED_ICON = "location_selected_icon";
    /* access modifiers changed from: private */
    public MapboxMap mapBoxMap;
    private final String mapType = TrackedLocation.MAP_TYPE_WGS;
    private MapView mapView;
    private PointAnnotationManager markerManager;
    private final Lazy mbGeoClient$delegate;

    public MapBoxActivity() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new MapBoxActivity$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.mbGeoClient$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, MbGeoClient.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    public String getMapType() {
        return this.mapType;
    }

    private final MbGeoClient getMbGeoClient() {
        return (MbGeoClient) this.mbGeoClient$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MapboxOptions.setAccessToken(getMbGeoClient().getKey());
        configureForMapBox();
    }

    private final void configureForMapBox() {
        MapboxMap mapboxMap = null;
        MapView mapView2 = new MapView((Context) this, (MapInitOptions) null, 2, (DefaultConstructorMarker) null);
        mapView2.setId(View.generateViewId());
        setMapViewId(mapView2.getId());
        ((FrameLayout) findViewById(R.id.map_container)).addView(mapView2);
        View findViewById = findViewById(getMapViewId());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mapView = (MapView) findViewById;
        MapPluginProviderDelegate mapPluginProviderDelegate = mapView2;
        GesturesPlugin gestures = GesturesUtils.getGestures(mapPluginProviderDelegate);
        gestures.setRotateEnabled(false);
        gestures.setPitchEnabled(false);
        CompassUtils.getCompass(mapPluginProviderDelegate).setEnabled(false);
        ScaleBarUtils.getScaleBar(mapPluginProviderDelegate).setEnabled(false);
        MapboxMap mapboxMap2 = mapView2.getMapboxMapDeprecated();
        this.mapBoxMap = mapboxMap2;
        if (mapboxMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
            mapboxMap2 = null;
        }
        mapboxMap2.loadStyle(Style.MAPBOX_STREETS, (Style.OnStyleLoaded) new MapBoxActivity$$ExternalSyntheticLambda0(this));
        PointAnnotationManager createPointAnnotationManager$default = PointAnnotationManagerKt.createPointAnnotationManager$default(AnnotationsUtils.getAnnotations(mapPluginProviderDelegate), (AnnotationConfig) null, 1, (Object) null);
        this.markerManager = createPointAnnotationManager$default;
        if (createPointAnnotationManager$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            createPointAnnotationManager$default = null;
        }
        createPointAnnotationManager$default.setIconRotationAlignment(IconRotationAlignment.VIEWPORT);
        PointAnnotationManager pointAnnotationManager = this.markerManager;
        if (pointAnnotationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            pointAnnotationManager = null;
        }
        pointAnnotationManager.addClickListener(new MapBoxActivity$$ExternalSyntheticLambda1(this));
        onMapReady();
        MapboxMap mapboxMap3 = this.mapBoxMap;
        if (mapboxMap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
            mapboxMap3 = null;
        }
        GesturesUtils.addOnMapLongClickListener(mapboxMap3, new MapBoxActivity$$ExternalSyntheticLambda2(this));
        MapboxMap mapboxMap4 = this.mapBoxMap;
        if (mapboxMap4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
        } else {
            mapboxMap = mapboxMap4;
        }
        GesturesUtils.addOnMoveListener(mapboxMap, new MapBoxActivity$configureForMapBox$5(this));
        setupLocationServices();
        MutableLiveDataExtensionKt.forceRefresh(getViewModel().getViewLocation());
    }

    /* access modifiers changed from: private */
    public static final void configureForMapBox$lambda$5(MapBoxActivity mapBoxActivity, Style style) {
        Intrinsics.checkNotNullParameter(style, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        Bitmap markerIcon = mapBoxActivity.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_location_marker, 80, 80);
        if (markerIcon != null) {
            style.addImage(MARKER_LOCATION_ICON, markerIcon);
        }
        Bitmap markerIcon2 = mapBoxActivity.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_location_marker_selected, 80, 80);
        if (markerIcon2 != null) {
            style.addImage(MARKER_LOCATION_SELECTED_ICON, markerIcon2);
        }
        Bitmap markerIcon3 = mapBoxActivity.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_gps_marker, 45, 45);
        if (markerIcon3 != null) {
            style.addImage(MARKER_GPS_ICON, markerIcon3);
        }
        Bitmap markerIcon4 = mapBoxActivity.getMarkerIcon(com.blueair.viewcore.R.drawable.ic_gps_marker_selected, 45, 45);
        if (markerIcon4 != null) {
            style.addImage(MARKER_GPS_SELECTED_ICON, markerIcon4);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean configureForMapBox$lambda$6(MapBoxActivity mapBoxActivity, PointAnnotation pointAnnotation) {
        Intrinsics.checkNotNullParameter(pointAnnotation, "marker");
        mapBoxActivity.onMarkerTapped(pointAnnotation.getId());
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean configureForMapBox$lambda$7(MapBoxActivity mapBoxActivity, Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        mapBoxActivity.setMinimizedModeIfNeeded();
        mapBoxActivity.getViewModel().viewLocation(point.latitude(), point.longitude(), mapBoxActivity.getLocalMapType());
        return true;
    }

    /* access modifiers changed from: protected */
    public void startSearchIntent() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("request_code", 102);
        startActivityForResult(intent, 102);
    }

    /* access modifiers changed from: protected */
    public void gotoLocationImpl(TrackedLocation trackedLocation, float f) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        MapboxMap mapboxMap = this.mapBoxMap;
        if (mapboxMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
            mapboxMap = null;
        }
        CameraOptions.Builder builder = new CameraOptions.Builder();
        builder.center(getPoint(trackedLocation));
        builder.zoom(Double.valueOf((double) f));
        CameraOptions build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().apply(block).build()");
        mapboxMap.setCamera(build);
    }

    /* access modifiers changed from: protected */
    public void addMapMarkersImpl(List<TrackedLocation> list) {
        Intrinsics.checkNotNullParameter(list, "locations");
        Map linkedHashMap = new LinkedHashMap();
        for (TrackedLocation next : list) {
            PointAnnotationOptions withIconImage = new PointAnnotationOptions().withPoint(getPoint(next)).withIconImage(next.isCurrentLocation() ? MARKER_GPS_ICON : MARKER_LOCATION_ICON);
            PointAnnotationManager pointAnnotationManager = this.markerManager;
            if (pointAnnotationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("markerManager");
                pointAnnotationManager = null;
            }
            linkedHashMap.put(((PointAnnotation) pointAnnotationManager.create(withIconImage)).getId(), next.getId());
        }
        getViewModel().setMarkers(linkedHashMap);
    }

    /* access modifiers changed from: protected */
    public void styleMarker(String str, boolean z, boolean z2) {
        Object obj;
        String str2;
        Intrinsics.checkNotNullParameter(str, "markerId");
        PointAnnotationManager pointAnnotationManager = this.markerManager;
        PointAnnotationManager pointAnnotationManager2 = null;
        if (pointAnnotationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            pointAnnotationManager = null;
        }
        Iterator it = pointAnnotationManager.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((PointAnnotation) obj).getId(), (Object) str)) {
                break;
            }
        }
        PointAnnotation pointAnnotation = (PointAnnotation) obj;
        if (pointAnnotation != null) {
            if (z2) {
                str2 = z ? MARKER_GPS_SELECTED_ICON : MARKER_GPS_ICON;
            } else {
                str2 = z ? MARKER_LOCATION_SELECTED_ICON : MARKER_LOCATION_ICON;
            }
            pointAnnotation.setIconImage(str2);
            PointAnnotationManager pointAnnotationManager3 = this.markerManager;
            if (pointAnnotationManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            } else {
                pointAnnotationManager2 = pointAnnotationManager3;
            }
            pointAnnotationManager2.update(pointAnnotation);
        }
    }

    /* access modifiers changed from: protected */
    public void clearMapMarkersImpl() {
        PointAnnotationManager pointAnnotationManager = this.markerManager;
        if (pointAnnotationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("markerManager");
            pointAnnotationManager = null;
        }
        pointAnnotationManager.deleteAll();
        getViewModel().getMarkers().clear();
    }

    private final Point getPoint(TrackedLocation trackedLocation) {
        Pair<Double, Double> latLngInWGS = trackedLocation.getLatLngInWGS();
        Point fromLngLat = Point.fromLngLat(latLngInWGS.getSecond().doubleValue(), latLngInWGS.getFirst().doubleValue());
        Intrinsics.checkNotNullExpressionValue(fromLngLat, "fromLngLat(...)");
        return fromLngLat;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/outdoor/ui/activity/MapBoxActivity$Companion;", "", "<init>", "()V", "MARKER_LOCATION_ICON", "", "MARKER_LOCATION_SELECTED_ICON", "MARKER_GPS_ICON", "MARKER_GPS_SELECTED_ICON", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MapBoxActivity.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
