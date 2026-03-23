package com.blueair.android.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.blueair.core.model.AqiData;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutdoorLocationViewModel$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ MediatorLiveData f$0;

    public /* synthetic */ OutdoorLocationViewModel$$ExternalSyntheticLambda2(MediatorLiveData mediatorLiveData) {
        this.f$0 = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return OutdoorLocationViewModel.liveAqiData_delegate$lambda$4$lambda$3$lambda$2$lambda$1(this.f$0, (AqiData) obj);
    }
}
