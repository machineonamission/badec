package com.blueair.devicedetails.view;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CustomWheelView$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CustomWheelView f$0;

    public /* synthetic */ CustomWheelView$$ExternalSyntheticLambda1(CustomWheelView customWheelView) {
        this.f$0 = customWheelView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        CustomWheelView.smoothScrollTo$lambda$1(this.f$0, valueAnimator);
    }
}
