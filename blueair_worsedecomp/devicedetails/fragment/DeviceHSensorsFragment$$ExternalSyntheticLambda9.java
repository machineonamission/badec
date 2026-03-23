package com.blueair.devicedetails.fragment;

import com.blueair.core.model.DeviceData;
import com.blueair.core.util.IndoorAirRatingRanges;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceHSensorsFragment$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ DeviceHSensorsFragment f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ IndoorAirRatingRanges f$2;

    public /* synthetic */ DeviceHSensorsFragment$$ExternalSyntheticLambda9(DeviceHSensorsFragment deviceHSensorsFragment, boolean z, IndoorAirRatingRanges indoorAirRatingRanges) {
        this.f$0 = deviceHSensorsFragment;
        this.f$1 = z;
        this.f$2 = indoorAirRatingRanges;
    }

    public final Object invoke(Object obj) {
        return DeviceHSensorsFragment.onViewCreated$lambda$5(this.f$0, this.f$1, this.f$2, (DeviceData) obj);
    }
}
