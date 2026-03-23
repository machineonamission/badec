package com.blueair.devicedetails.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/devicedetails/view/CustomWheelView$smoothScrollTo$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CustomWheelView.kt */
public final class CustomWheelView$smoothScrollTo$2 extends AnimatorListenerAdapter {
    final /* synthetic */ int $position;
    final /* synthetic */ CustomWheelView this$0;

    CustomWheelView$smoothScrollTo$2(CustomWheelView customWheelView, int i) {
        this.this$0 = customWheelView;
        this.$position = i;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.this$0.scrollTo(this.$position);
    }
}
