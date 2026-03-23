package com.blueair.outdoor.ui.viewmodels;

import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlacesSearchViewModel$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ GooglePlacesSearchViewModel f$0;

    public /* synthetic */ GooglePlacesSearchViewModel$$ExternalSyntheticLambda5(GooglePlacesSearchViewModel googlePlacesSearchViewModel) {
        this.f$0 = googlePlacesSearchViewModel;
    }

    public final Object invoke(Object obj) {
        return GooglePlacesSearchViewModel.query$lambda$6(this.f$0, (FindAutocompletePredictionsResponse) obj);
    }
}
