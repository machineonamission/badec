package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class ActivityAccountLinkingBinding implements ViewBinding {
    public final AppCompatTextView body;
    public final MaterialButton btnAllow;
    public final MaterialButton btnNotNow;
    public final AppCompatImageView imgError;
    public final AppCompatImageView imgLogo;
    public final ProgressBlockerView loading;
    private final FrameLayout rootView;
    public final AppCompatTextView subtitle;
    public final AppCompatTextView title;
    public final AppCompatTextView txtAllowDescription;

    private ActivityAccountLinkingBinding(FrameLayout frameLayout, AppCompatTextView appCompatTextView, MaterialButton materialButton, MaterialButton materialButton2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ProgressBlockerView progressBlockerView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.rootView = frameLayout;
        this.body = appCompatTextView;
        this.btnAllow = materialButton;
        this.btnNotNow = materialButton2;
        this.imgError = appCompatImageView;
        this.imgLogo = appCompatImageView2;
        this.loading = progressBlockerView;
        this.subtitle = appCompatTextView2;
        this.title = appCompatTextView3;
        this.txtAllowDescription = appCompatTextView4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAccountLinkingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAccountLinkingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_account_linking, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAccountLinkingBinding bind(View view) {
        int i = R.id.body;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
        if (appCompatTextView != null) {
            i = R.id.btnAllow;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.btnNotNow;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.imgError;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.imgLogo;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.loading;
                            ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                            if (progressBlockerView != null) {
                                i = R.id.subtitle;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                if (appCompatTextView2 != null) {
                                    i = R.id.title;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView3 != null) {
                                        i = R.id.txtAllowDescription;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView4 != null) {
                                            return new ActivityAccountLinkingBinding((FrameLayout) view, appCompatTextView, materialButton, materialButton2, appCompatImageView, appCompatImageView2, progressBlockerView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
