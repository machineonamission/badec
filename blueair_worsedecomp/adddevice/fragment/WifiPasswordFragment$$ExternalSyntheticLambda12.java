package com.blueair.adddevice.fragment;

import com.blueair.bluetooth.service.BleDeviceError;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WifiPasswordFragment$$ExternalSyntheticLambda12 implements Function1 {
    public final /* synthetic */ Observable f$0;
    public final /* synthetic */ WifiPasswordFragment f$1;

    public /* synthetic */ WifiPasswordFragment$$ExternalSyntheticLambda12(Observable observable, WifiPasswordFragment wifiPasswordFragment) {
        this.f$0 = observable;
        this.f$1 = wifiPasswordFragment;
    }

    public final Object invoke(Object obj) {
        return WifiPasswordFragment.onResume$lambda$11$lambda$10(this.f$0, this.f$1, (BleDeviceError) obj);
    }
}
