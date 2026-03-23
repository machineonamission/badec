package com.blueair.adddevice.viewmodel;

import com.blueair.bluetooth.service.BleDeviceState;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AddDeviceViewModel$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ AddDeviceViewModel f$0;

    public /* synthetic */ AddDeviceViewModel$$ExternalSyntheticLambda1(AddDeviceViewModel addDeviceViewModel) {
        this.f$0 = addDeviceViewModel;
    }

    public final Object invoke(Object obj) {
        return AddDeviceViewModel.gotoWifiPassword$lambda$11(this.f$0, (BleDeviceState) obj);
    }
}
