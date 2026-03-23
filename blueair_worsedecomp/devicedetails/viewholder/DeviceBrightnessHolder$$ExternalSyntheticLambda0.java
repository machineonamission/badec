package com.blueair.devicedetails.viewholder;

import com.blueair.core.model.Brightness;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceBrightnessHolder$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DeviceBrightnessHolder f$0;
    public final /* synthetic */ Brightness f$1;

    public /* synthetic */ DeviceBrightnessHolder$$ExternalSyntheticLambda0(DeviceBrightnessHolder deviceBrightnessHolder, Brightness brightness) {
        this.f$0 = deviceBrightnessHolder;
        this.f$1 = brightness;
    }

    public final void run() {
        DeviceBrightnessHolder.onProgressSet$lambda$1(this.f$0, this.f$1);
    }
}
