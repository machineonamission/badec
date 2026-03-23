package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.antifake.R;

public final class HolderManualResetBinding implements ViewBinding {
    public final LottieAnimationView animationView;
    public final TextView contentMessage;
    private final ConstraintLayout rootView;

    private HolderManualResetBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, TextView textView) {
        this.rootView = constraintLayout;
        this.animationView = lottieAnimationView;
        this.contentMessage = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderManualResetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderManualResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_manual_reset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderManualResetBinding bind(View view) {
        int i = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = R.id.content_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new HolderManualResetBinding((ConstraintLayout) view, lottieAnimationView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
