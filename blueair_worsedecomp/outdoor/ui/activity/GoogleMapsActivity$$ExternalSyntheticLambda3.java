package com.blueair.outdoor.ui.activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GoogleMapsActivity$$ExternalSyntheticLambda3 implements GoogleMap.OnMarkerClickListener {
    public final /* synthetic */ GoogleMapsActivity f$0;

    public /* synthetic */ GoogleMapsActivity$$ExternalSyntheticLambda3(GoogleMapsActivity googleMapsActivity) {
        this.f$0 = googleMapsActivity;
    }

    public final boolean onMarkerClick(Marker marker) {
        return GoogleMapsActivity.onMapReady$lambda$5$lambda$4(this.f$0, marker);
    }
}
