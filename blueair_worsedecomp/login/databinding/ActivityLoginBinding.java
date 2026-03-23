package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.login.R;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.ProgressBlockerView;

public final class ActivityLoginBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    public final ProgressBlockerView loading;
    private final AbsorbInsetFrameLayout rootView;

    private ActivityLoginBinding(AbsorbInsetFrameLayout absorbInsetFrameLayout, FrameLayout frameLayout, ProgressBlockerView progressBlockerView) {
        this.rootView = absorbInsetFrameLayout;
        this.fragmentContainer = frameLayout;
        this.loading = progressBlockerView;
    }

    public AbsorbInsetFrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLoginBinding bind(View view) {
        int i = R.id.fragmentContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.loading;
            ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
            if (progressBlockerView != null) {
                return new ActivityLoginBinding((AbsorbInsetFrameLayout) view, frameLayout, progressBlockerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
