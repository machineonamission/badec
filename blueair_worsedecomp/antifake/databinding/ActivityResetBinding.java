package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class ActivityResetBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final AppCompatImageView btnClose;
    public final FrameLayout containerFragment;
    public final ConstraintLayout headerBar;
    public final LinearProgressIndicator headerProgress;
    public final TextView headerTitle;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final TextView step1;
    public final TextView step2;
    public final TextView step3;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private ActivityResetBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout, ConstraintLayout constraintLayout, LinearProgressIndicator linearProgressIndicator, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout2) {
        this.rootView = linearLayout;
        this.btnBack = appCompatImageView;
        this.btnClose = appCompatImageView2;
        this.containerFragment = frameLayout;
        this.headerBar = constraintLayout;
        this.headerProgress = linearProgressIndicator;
        this.headerTitle = textView;
        this.main = linearLayout2;
        this.step1 = textView2;
        this.step2 = textView3;
        this.step3 = textView4;
        this.title = textView5;
        this.titleBar = constraintLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityResetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_reset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityResetBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
        if (appCompatImageView != null) {
            i = R.id.btn_close;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
            if (appCompatImageView2 != null) {
                i = R.id.container_fragment;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                if (frameLayout != null) {
                    i = R.id.header_bar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                    if (constraintLayout != null) {
                        i = R.id.header_progress;
                        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view2, i);
                        if (linearProgressIndicator != null) {
                            i = R.id.header_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView != null) {
                                LinearLayout linearLayout = (LinearLayout) view2;
                                i = R.id.step1;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView2 != null) {
                                    i = R.id.step2;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView3 != null) {
                                        i = R.id.step3;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView4 != null) {
                                            i = R.id.title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView5 != null) {
                                                i = R.id.title_bar;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                if (constraintLayout2 != null) {
                                                    return new ActivityResetBinding(linearLayout, appCompatImageView, appCompatImageView2, frameLayout, constraintLayout, linearProgressIndicator, textView, linearLayout, textView2, textView3, textView4, textView5, constraintLayout2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
