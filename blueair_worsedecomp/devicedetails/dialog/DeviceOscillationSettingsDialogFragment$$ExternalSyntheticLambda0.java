package com.blueair.devicedetails.dialog;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DeviceOscillationSettingsDialogFragment f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda0(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, int i) {
        this.f$0 = deviceOscillationSettingsDialogFragment;
        this.f$1 = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DeviceOscillationSettingsDialogFragment.updateDeviceImageAngle$lambda$16(this.f$0, this.f$1, valueAnimator);
    }
}
