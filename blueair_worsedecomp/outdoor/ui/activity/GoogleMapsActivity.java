package com.blueair.outdoor.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0017J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u000fH\u0014J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0014J\f\u0010)\u001a\u00020**\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006,"}, d2 = {"Lcom/blueair/outdoor/ui/activity/GoogleMapsActivity;", "Lcom/blueair/outdoor/ui/activity/MapActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "<init>", "()V", "map", "Lcom/google/android/gms/maps/GoogleMap;", "markers", "", "Lcom/google/android/gms/maps/model/Marker;", "mapType", "", "getMapType", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureForGoogle", "startSearchIntent", "onMapReady", "googleMap", "addMapMarkersImpl", "locations", "", "Lcom/blueair/core/model/TrackedLocation;", "clearMapMarkersImpl", "styleMarker", "markerId", "isSelected", "", "isCurrentLocation", "getMarkerIcon", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "resId", "", "size", "gotoLocationImpl", "location", "zoom", "", "getLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GoogleMapsActivity.kt */
public final class GoogleMapsActivity extends MapActivity implements OnMapReadyCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<Place.Field> PLACES_DATA_FIELDS = CollectionsKt.listOf(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.VIEWPORT);
    private GoogleMap map;
    private final String mapType = TrackedLocation.MAP_TYPE_GCJ;
    private final List<Marker> markers = new ArrayList();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/outdoor/ui/activity/GoogleMapsActivity$Companion;", "", "<init>", "()V", "PLACES_DATA_FIELDS", "", "Lcom/google/android/libraries/places/api/model/Place$Field;", "getPLACES_DATA_FIELDS", "()Ljava/util/List;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GoogleMapsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Place.Field> getPLACES_DATA_FIELDS() {
            return GoogleMapsActivity.PLACES_DATA_FIELDS;
        }
    }

    public String getMapType() {
        return this.mapType;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        configureForGoogle();
    }

    private final void configureForGoogle() {
        SupportMapFragment newInstance = SupportMapFragment.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.replace(R.id.map_container, newInstance);
        beginTransaction.commit();
        newInstance.getMapAsync(this);
    }

    /* access modifiers changed from: protected */
    public void startSearchIntent() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("request_code", 101);
        startActivityForResult(intent, 101);
    }

    public void onMapReady(GoogleMap googleMap) {
        Intrinsics.checkNotNullParameter(googleMap, "googleMap");
        this.map = googleMap;
        setupLocationServices();
        Timber.Forest.d("onMapReady", new Object[0]);
        onMapReady();
        googleMap.setMyLocationEnabled(false);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        googleMap.getUiSettings().setTiltGesturesEnabled(false);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(false);
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        googleMap.setMaxZoomPreference(16.0f);
        googleMap.setOnMapLongClickListener(new GoogleMapsActivity$$ExternalSyntheticLambda0(this));
        googleMap.setOnCameraMoveStartedListener(new GoogleMapsActivity$$ExternalSyntheticLambda1(this));
        googleMap.setOnCameraMoveListener(new GoogleMapsActivity$$ExternalSyntheticLambda2(googleMap, this));
        googleMap.setOnMarkerClickListener(new GoogleMapsActivity$$ExternalSyntheticLambda3(this));
        MutableLiveDataExtensionKt.forceRefresh(getViewModel().getViewLocation());
    }

    /* access modifiers changed from: private */
    public static final void onMapReady$lambda$5$lambda$1(GoogleMapsActivity googleMapsActivity, LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        googleMapsActivity.setMinimizedModeIfNeeded();
        googleMapsActivity.getViewModel().viewLocation(latLng.latitude, latLng.longitude, googleMapsActivity.getLocalMapType());
    }

    /* access modifiers changed from: private */
    public static final void onMapReady$lambda$5$lambda$2(GoogleMapsActivity googleMapsActivity, int i) {
        if (i == 1) {
            googleMapsActivity.setMinimizedModeIfNeeded();
        }
    }

    /* access modifiers changed from: private */
    public static final void onMapReady$lambda$5$lambda$3(GoogleMap googleMap, GoogleMapsActivity googleMapsActivity) {
        LatLng latLng = googleMap.getCameraPosition().target;
        Intrinsics.checkNotNullExpressionValue(latLng, TypedValues.AttributesType.S_TARGET);
        googleMapsActivity.getViewModel().setCurrentlyViewedLocation(latLng.latitude, latLng.longitude, googleMapsActivity.getLocalMapType());
        googleMapsActivity.updateAirQualityIfNeeded(latLng.latitude, latLng.longitude);
    }

    /* access modifiers changed from: private */
    public static final boolean onMapReady$lambda$5$lambda$4(GoogleMapsActivity googleMapsActivity, Marker marker) {
        Intrinsics.checkNotNullParameter(marker, "marker");
        String id = marker.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        googleMapsActivity.onMarkerTapped(id);
        return true;
    }

    /* access modifiers changed from: protected */
    public void addMapMarkersImpl(List<TrackedLocation> list) {
        Intrinsics.checkNotNullParameter(list, "locations");
        BitmapDescriptor markerIcon = getMarkerIcon(com.blueair.viewcore.R.drawable.ic_location_marker, 80);
        BitmapDescriptor markerIcon2 = getMarkerIcon(com.blueair.viewcore.R.drawable.ic_gps_marker, 45);
        Map linkedHashMap = new LinkedHashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TrackedLocation trackedLocation = list.get(i);
            MarkerOptions position = new MarkerOptions().title(getString(com.blueair.viewcore.R.string.map_marker_title, new Object[]{trackedLocation.getCityName(), trackedLocation.getLocationName()})).position(getLatLng(trackedLocation));
            BitmapDescriptor bitmapDescriptor = trackedLocation.isCurrentLocation() ? markerIcon2 : markerIcon;
            if (bitmapDescriptor != null) {
                position.icon(bitmapDescriptor);
            }
            Intrinsics.checkNotNullExpressionValue(position, "apply(...)");
            GoogleMap googleMap = this.map;
            if (googleMap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("map");
                googleMap = null;
            }
            Marker addMarker = googleMap.addMarker(position);
            if (addMarker != null) {
                this.markers.add(addMarker);
                linkedHashMap.put(addMarker.getId(), trackedLocation.getId());
            }
        }
        getViewModel().setMarkers(linkedHashMap);
    }

    /* access modifiers changed from: protected */
    public void clearMapMarkersImpl() {
        for (Marker remove : this.markers) {
            remove.remove();
        }
        this.markers.clear();
        getViewModel().getMarkers().clear();
    }

    /* access modifiers changed from: protected */
    public void styleMarker(String str, boolean z, boolean z2) {
        Object obj;
        BitmapDescriptor bitmapDescriptor;
        Intrinsics.checkNotNullParameter(str, "markerId");
        Iterator it = this.markers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Marker) obj).getId(), (Object) str)) {
                break;
            }
        }
        Marker marker = (Marker) obj;
        if (marker != null) {
            if (z2) {
                bitmapDescriptor = getMarkerIcon(z ? com.blueair.viewcore.R.drawable.ic_gps_marker_selected : com.blueair.viewcore.R.drawable.ic_gps_marker, 45);
            } else {
                bitmapDescriptor = getMarkerIcon(z ? com.blueair.viewcore.R.drawable.ic_location_marker_selected : com.blueair.viewcore.R.drawable.ic_location_marker, 80);
            }
            marker.setIcon(bitmapDescriptor);
        }
    }

    private final BitmapDescriptor getMarkerIcon(int i, int i2) {
        Bitmap markerIcon = getMarkerIcon(i, i2, i2);
        if (markerIcon != null) {
            return BitmapDescriptorFactory.fromBitmap(markerIcon);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void gotoLocationImpl(TrackedLocation trackedLocation, float f) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        CameraPosition build = new CameraPosition.Builder().target(getLatLng(trackedLocation)).zoom(f).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        GoogleMap googleMap = this.map;
        if (googleMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("map");
            googleMap = null;
        }
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(build));
    }

    private final LatLng getLatLng(TrackedLocation trackedLocation) {
        Pair<Double, Double> latLngInGCJ = trackedLocation.getLatLngInGCJ();
        return new LatLng(latLngInGCJ.getFirst().doubleValue(), latLngInGCJ.getSecond().doubleValue());
    }
}
