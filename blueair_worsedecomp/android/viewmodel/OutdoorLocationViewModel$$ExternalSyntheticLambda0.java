package com.blueair.android.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.blueair.core.model.TrackedLocation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutdoorLocationViewModel$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ MediatorLiveData f$1;
    public final /* synthetic */ OutdoorLocationViewModel f$2;

    public /* synthetic */ OutdoorLocationViewModel$$ExternalSyntheticLambda0(Ref.ObjectRef objectRef, MediatorLiveData mediatorLiveData, OutdoorLocationViewModel outdoorLocationViewModel) {
        this.f$0 = objectRef;
        this.f$1 = mediatorLiveData;
        this.f$2 = outdoorLocationViewModel;
    }

    public final Object invoke(Object obj) {
        return OutdoorLocationViewModel.liveAqiData_delegate$lambda$4$lambda$3$lambda$2(this.f$0, this.f$1, this.f$2, (TrackedLocation) obj);
    }
}
