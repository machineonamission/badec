package com.blueair.outdoor.ui.activity;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ MapActivity f$0;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda6(MapActivity mapActivity) {
        this.f$0 = mapActivity;
    }

    public final Object invoke(Object obj, Object obj2) {
        return MapActivity.configureSavedLocations$lambda$30(this.f$0, (TrackedLocation) obj, (AqiData) obj2);
    }
}
