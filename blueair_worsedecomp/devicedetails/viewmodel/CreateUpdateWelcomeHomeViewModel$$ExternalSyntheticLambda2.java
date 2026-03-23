package com.blueair.devicedetails.viewmodel;

import android.location.Geocoder;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda2 implements Geocoder.GeocodeListener {
    public final /* synthetic */ CreateUpdateWelcomeHomeViewModel f$0;
    public final /* synthetic */ double f$1;
    public final /* synthetic */ double f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda2(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, double d, double d2, Function0 function0) {
        this.f$0 = createUpdateWelcomeHomeViewModel;
        this.f$1 = d;
        this.f$2 = d2;
        this.f$3 = function0;
    }

    public final void onGeocode(List list) {
        CreateUpdateWelcomeHomeViewModel.setAddressFromLatLng$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, list);
    }
}
