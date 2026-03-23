package com.blueair.devicedetails.viewmodel;

import android.location.Geocoder;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda3 implements Geocoder.GeocodeListener {
    public final /* synthetic */ CreateUpdateWelcomeHomeViewModel f$0;

    public /* synthetic */ CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda3(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel) {
        this.f$0 = createUpdateWelcomeHomeViewModel;
    }

    public final void onGeocode(List list) {
        CreateUpdateWelcomeHomeViewModel.fetchCity$lambda$4(this.f$0, list);
    }
}
