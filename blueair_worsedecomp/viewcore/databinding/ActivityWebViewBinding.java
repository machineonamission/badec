package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.appbar.AppBarLayout;

public final class ActivityWebViewBinding implements ViewBinding {
    public final AppBarLayout appbar;
    public final FrameLayout container;
    private final CoordinatorLayout rootView;
    public final Toolbar toolbar;

    private ActivityWebViewBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FrameLayout frameLayout, Toolbar toolbar2) {
        this.rootView = coordinatorLayout;
        this.appbar = appBarLayout;
        this.container = frameLayout;
        this.toolbar = toolbar2;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_web_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityWebViewBinding bind(View view) {
        int i = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
        if (appBarLayout != null) {
            i = R.id.container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i);
                if (toolbar2 != null) {
                    return new ActivityWebViewBinding((CoordinatorLayout) view, appBarLayout, frameLayout, toolbar2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
