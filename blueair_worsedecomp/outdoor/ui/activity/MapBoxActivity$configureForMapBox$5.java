package com.blueair.outdoor.ui.activity;

import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.geojson.Point;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.plugin.gestures.OnMoveListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/blueair/outdoor/ui/activity/MapBoxActivity$configureForMapBox$5", "Lcom/mapbox/maps/plugin/gestures/OnMoveListener;", "onMove", "", "detector", "Lcom/mapbox/android/gestures/MoveGestureDetector;", "onMoveBegin", "", "onMoveEnd", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MapBoxActivity.kt */
public final class MapBoxActivity$configureForMapBox$5 implements OnMoveListener {
    final /* synthetic */ MapBoxActivity this$0;

    public boolean onMove(MoveGestureDetector moveGestureDetector) {
        Intrinsics.checkNotNullParameter(moveGestureDetector, "detector");
        return false;
    }

    MapBoxActivity$configureForMapBox$5(MapBoxActivity mapBoxActivity) {
        this.this$0 = mapBoxActivity;
    }

    public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
        Intrinsics.checkNotNullParameter(moveGestureDetector, "detector");
        this.this$0.setMinimizedModeIfNeeded();
    }

    public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
        Intrinsics.checkNotNullParameter(moveGestureDetector, "detector");
        MapboxMap access$getMapBoxMap$p = this.this$0.mapBoxMap;
        if (access$getMapBoxMap$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapBoxMap");
            access$getMapBoxMap$p = null;
        }
        Point center = access$getMapBoxMap$p.getCameraState().getCenter();
        Intrinsics.checkNotNullExpressionValue(center, "getCenter(...)");
        this.this$0.getViewModel().setCurrentlyViewedLocation(center.latitude(), center.longitude(), this.this$0.getLocalMapType());
        this.this$0.updateAirQualityIfNeeded(center.latitude(), center.longitude());
    }
}
