package com.blueair.android.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeViewModel$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ MediatorLiveData f$0;
    public final /* synthetic */ HomeViewModel f$1;

    public /* synthetic */ HomeViewModel$$ExternalSyntheticLambda3(MediatorLiveData mediatorLiveData, HomeViewModel homeViewModel) {
        this.f$0 = mediatorLiveData;
        this.f$1 = homeViewModel;
    }

    public final Object invoke(Object obj) {
        return HomeViewModel.fetchingSmartIntegrationStatus$lambda$7$lambda$6(this.f$0, this.f$1, (Boolean) obj);
    }
}
