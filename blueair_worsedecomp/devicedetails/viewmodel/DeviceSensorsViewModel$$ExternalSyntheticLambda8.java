package com.blueair.devicedetails.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsViewModel$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ MediatorLiveData f$0;
    public final /* synthetic */ DeviceSensorsViewModel f$1;

    public /* synthetic */ DeviceSensorsViewModel$$ExternalSyntheticLambda8(MediatorLiveData mediatorLiveData, DeviceSensorsViewModel deviceSensorsViewModel) {
        this.f$0 = mediatorLiveData;
        this.f$1 = deviceSensorsViewModel;
    }

    public final Object invoke(Object obj) {
        return DeviceSensorsViewModel.disableSensorCards$lambda$22$lambda$19(this.f$0, this.f$1, (Boolean) obj);
    }
}
