package com.blueair.outdoor.ui.viewmodels;

import androidx.lifecycle.MediatorLiveData;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapsViewModel$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ MapsViewModel f$0;
    public final /* synthetic */ MediatorLiveData f$1;

    public /* synthetic */ MapsViewModel$$ExternalSyntheticLambda1(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData) {
        this.f$0 = mapsViewModel;
        this.f$1 = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return MapsViewModel.createMergedSavedLocationsLiveData$lambda$10$lambda$7(this.f$0, this.f$1, (List) obj);
    }
}
