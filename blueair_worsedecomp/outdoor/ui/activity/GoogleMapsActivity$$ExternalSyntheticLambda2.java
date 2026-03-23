package com.blueair.outdoor.ui.activity;

import com.google.android.gms.maps.GoogleMap;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GoogleMapsActivity$$ExternalSyntheticLambda2 implements GoogleMap.OnCameraMoveListener {
    public final /* synthetic */ GoogleMap f$0;
    public final /* synthetic */ GoogleMapsActivity f$1;

    public /* synthetic */ GoogleMapsActivity$$ExternalSyntheticLambda2(GoogleMap googleMap, GoogleMapsActivity googleMapsActivity) {
        this.f$0 = googleMap;
        this.f$1 = googleMapsActivity;
    }

    public final void onCameraMove() {
        GoogleMapsActivity.onMapReady$lambda$5$lambda$3(this.f$0, this.f$1);
    }
}
