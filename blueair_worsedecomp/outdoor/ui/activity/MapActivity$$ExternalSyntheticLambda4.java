package com.blueair.outdoor.ui.activity;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ MapActivity f$0;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda4(MapActivity mapActivity) {
        this.f$0 = mapActivity;
    }

    public final Object invoke(Object obj, Object obj2) {
        return MapActivity.configureAddLocationListeners$lambda$21$lambda$18(this.f$0, (TrackedLocation) obj, (AqiData) obj2);
    }
}
