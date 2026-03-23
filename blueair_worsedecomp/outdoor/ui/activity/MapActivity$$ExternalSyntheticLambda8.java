package com.blueair.outdoor.ui.activity;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda8 implements Function3 {
    public final /* synthetic */ MapActivity f$0;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda8(MapActivity mapActivity) {
        this.f$0 = mapActivity;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return MapActivity.configureSavedLocations$lambda$37(this.f$0, (TrackedLocation) obj, (List) obj2, (AqiData) obj3);
    }
}
