package com.blueair.devicedetails.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ MediatorLiveData f$0;
    public final /* synthetic */ DeviceCreateEditScheduleViewModel f$1;

    public /* synthetic */ DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda3(MediatorLiveData mediatorLiveData, DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel) {
        this.f$0 = mediatorLiveData;
        this.f$1 = deviceCreateEditScheduleViewModel;
    }

    public final Object invoke(Object obj) {
        return DeviceCreateEditScheduleViewModel.saveBtnEnabled$lambda$8$lambda$6(this.f$0, this.f$1, (Boolean) obj);
    }
}
