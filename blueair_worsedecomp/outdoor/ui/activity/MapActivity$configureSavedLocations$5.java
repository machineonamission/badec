package com.blueair.outdoor.ui.activity;

import com.blueair.viewcore.utils.SnapOnScrollListener;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/outdoor/ui/activity/MapActivity$configureSavedLocations$5", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "onSnapPositionChange", "", "position", "", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MapActivity.kt */
public final class MapActivity$configureSavedLocations$5 implements SnapOnScrollListener.OnSnapPositionChangeListener {
    final /* synthetic */ Ref.BooleanRef $skipScroll;
    final /* synthetic */ MapActivity this$0;

    MapActivity$configureSavedLocations$5(Ref.BooleanRef booleanRef, MapActivity mapActivity) {
        this.$skipScroll = booleanRef;
        this.this$0 = mapActivity;
    }

    public void onSnapPositionChange(int i) {
        if (!this.$skipScroll.element) {
            this.this$0.getViewModel().getSavedLocationViewIndex().setValue(new Pair(Integer.valueOf(i), false));
        }
        this.$skipScroll.element = false;
    }
}
