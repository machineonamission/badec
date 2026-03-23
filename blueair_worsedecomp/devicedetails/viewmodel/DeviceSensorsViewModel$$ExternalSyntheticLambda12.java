package com.blueair.devicedetails.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.blueair.core.model.TrackedLocation;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsViewModel$$ExternalSyntheticLambda12 implements Function1 {
    public final /* synthetic */ DeviceSensorsViewModel f$0;
    public final /* synthetic */ MediatorLiveData f$1;

    public /* synthetic */ DeviceSensorsViewModel$$ExternalSyntheticLambda12(DeviceSensorsViewModel deviceSensorsViewModel, MediatorLiveData mediatorLiveData) {
        this.f$0 = deviceSensorsViewModel;
        this.f$1 = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return DeviceSensorsViewModel._liveAqiData$lambda$5$lambda$4(this.f$0, this.f$1, (TrackedLocation) obj);
    }
}
