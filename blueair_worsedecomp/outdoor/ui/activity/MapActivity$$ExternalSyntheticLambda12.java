package com.blueair.outdoor.ui.activity;

import com.blueair.core.model.TrackedLocation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda12 implements Function1 {
    public final /* synthetic */ MapActivity f$0;
    public final /* synthetic */ Ref.BooleanRef f$1;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda12(MapActivity mapActivity, Ref.BooleanRef booleanRef) {
        this.f$0 = mapActivity;
        this.f$1 = booleanRef;
    }

    public final Object invoke(Object obj) {
        return MapActivity.configureSavedLocations$lambda$41(this.f$0, this.f$1, (TrackedLocation) obj);
    }
}
