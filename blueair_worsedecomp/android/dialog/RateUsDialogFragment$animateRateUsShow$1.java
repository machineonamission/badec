package com.blueair.android.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.blueair.android.databinding.DialogfragmentRateUsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/android/dialog/RateUsDialogFragment$animateRateUsShow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RateUsDialogFragment.kt */
public final class RateUsDialogFragment$animateRateUsShow$1 extends AnimatorListenerAdapter {
    final /* synthetic */ RateUsDialogFragment this$0;

    RateUsDialogFragment$animateRateUsShow$1(RateUsDialogFragment rateUsDialogFragment) {
        this.this$0 = rateUsDialogFragment;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        DialogfragmentRateUsBinding access$getBinding$p = this.this$0.binding;
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.buttonRateCancel.setClickable(true);
        DialogfragmentRateUsBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentRateUsBinding = access$getBinding$p2;
        }
        dialogfragmentRateUsBinding.buttonRateRedirect.setClickable(true);
    }
}
