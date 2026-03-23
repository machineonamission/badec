package com.blueair.outdoor.ui.activity;

import com.blueair.core.model.TrackedLocation;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda21 implements Function1 {
    public final /* synthetic */ MapActivity f$0;
    public final /* synthetic */ TrackedLocation f$1;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda21(MapActivity mapActivity, TrackedLocation trackedLocation) {
        this.f$0 = mapActivity;
        this.f$1 = trackedLocation;
    }

    public final Object invoke(Object obj) {
        return MapActivity.configureAddLocationListeners$lambda$21$lambda$20$lambda$19(this.f$0, this.f$1, (ApiResult) obj);
    }
}
