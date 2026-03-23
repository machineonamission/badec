package com.blueair.adddevice.fragment;

import com.blueair.bluetooth.service.BleDeviceError;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AddDeviceSuccessFragment$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ AddDeviceSuccessFragment f$0;

    public /* synthetic */ AddDeviceSuccessFragment$$ExternalSyntheticLambda0(AddDeviceSuccessFragment addDeviceSuccessFragment) {
        this.f$0 = addDeviceSuccessFragment;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(AddDeviceSuccessFragment.onResume$lambda$5$lambda$2(this.f$0, (BleDeviceError) obj));
    }
}
