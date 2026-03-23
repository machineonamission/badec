package com.blueair.outdoor.ui.viewmodels;

import androidx.lifecycle.MediatorLiveData;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapsViewModel$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ MapsViewModel f$0;
    public final /* synthetic */ MediatorLiveData f$1;

    public /* synthetic */ MapsViewModel$$ExternalSyntheticLambda4(MapsViewModel mapsViewModel, MediatorLiveData mediatorLiveData) {
        this.f$0 = mapsViewModel;
        this.f$1 = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return MapsViewModel.createMergedCurrentLocation$lambda$17$lambda$15(this.f$0, this.f$1, (List) obj);
    }
}
