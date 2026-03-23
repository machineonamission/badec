package com.blueair.outdoor.ui.activity;

import com.mapbox.maps.plugin.annotation.Annotation;
import com.mapbox.maps.plugin.annotation.generated.OnPointAnnotationClickListener;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotation;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapBoxActivity$$ExternalSyntheticLambda1 implements OnPointAnnotationClickListener {
    public final /* synthetic */ MapBoxActivity f$0;

    public /* synthetic */ MapBoxActivity$$ExternalSyntheticLambda1(MapBoxActivity mapBoxActivity) {
        this.f$0 = mapBoxActivity;
    }

    public final boolean onAnnotationClick(Annotation annotation) {
        return MapBoxActivity.configureForMapBox$lambda$6(this.f$0, (PointAnnotation) annotation);
    }
}
