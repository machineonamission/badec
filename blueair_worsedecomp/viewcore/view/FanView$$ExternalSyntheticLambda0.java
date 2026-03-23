package com.blueair.viewcore.view;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FanView$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FanView f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ FanView$$ExternalSyntheticLambda0(FanView fanView, float f, float f2) {
        this.f$0 = fanView;
        this.f$1 = f;
        this.f$2 = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FanView.animateFanAngles$lambda$1(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
