package com.blueair.devicedetails.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.blueair.core.model.AqiData;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSensorsViewModel$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ MediatorLiveData f$0;

    public /* synthetic */ DeviceSensorsViewModel$$ExternalSyntheticLambda0(MediatorLiveData mediatorLiveData) {
        this.f$0 = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return DeviceSensorsViewModel._liveAqiData$lambda$5$lambda$4$lambda$3(this.f$0, (AqiData) obj);
    }
}
