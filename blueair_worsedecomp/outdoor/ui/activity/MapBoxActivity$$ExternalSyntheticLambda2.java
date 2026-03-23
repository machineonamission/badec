package com.blueair.outdoor.ui.activity;

import com.mapbox.geojson.Point;
import com.mapbox.maps.plugin.gestures.OnMapLongClickListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapBoxActivity$$ExternalSyntheticLambda2 implements OnMapLongClickListener {
    public final /* synthetic */ MapBoxActivity f$0;

    public /* synthetic */ MapBoxActivity$$ExternalSyntheticLambda2(MapBoxActivity mapBoxActivity) {
        this.f$0 = mapBoxActivity;
    }

    public final boolean onMapLongClick(Point point) {
        return MapBoxActivity.configureForMapBox$lambda$7(this.f$0, point);
    }
}
