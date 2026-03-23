package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.viewcore.R;

public final class ProgressBlockerBinding implements ViewBinding {
    public final LottieAnimationView progressBar;
    public final FrameLayout progressContainer;
    private final FrameLayout rootView;

    private ProgressBlockerBinding(FrameLayout frameLayout, LottieAnimationView lottieAnimationView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.progressBar = lottieAnimationView;
        this.progressContainer = frameLayout2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ProgressBlockerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ProgressBlockerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.progress_blocker, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProgressBlockerBinding bind(View view) {
        int i = R.id.progressBar;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ProgressBlockerBinding(frameLayout, lottieAnimationView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
