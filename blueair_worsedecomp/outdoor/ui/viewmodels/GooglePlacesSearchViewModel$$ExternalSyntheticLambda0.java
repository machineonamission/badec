package com.blueair.outdoor.ui.viewmodels;

import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlacesSearchViewModel$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ SearchItemContainer f$1;

    public /* synthetic */ GooglePlacesSearchViewModel$$ExternalSyntheticLambda0(Function1 function1, SearchItemContainer searchItemContainer) {
        this.f$0 = function1;
        this.f$1 = searchItemContainer;
    }

    public final Object invoke(Object obj) {
        return GooglePlacesSearchViewModel.getPlace$lambda$8(this.f$0, this.f$1, (FetchPlaceResponse) obj);
    }
}
