package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderWelcomeHomeModeBinding implements ViewBinding {
    public final ConstraintLayout clLocation;
    public final AppCompatImageView ivEdit;
    public final Guideline leftGuideline;
    public final LottieAnimationView progressView;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final TextView settingSummary;
    public final SwitchCompat settingSwitch;
    public final AppCompatTextView settingTitle;
    public final AppCompatTextView tvLocation;
    public final AppCompatTextView tvRadius;

    private HolderWelcomeHomeModeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, Guideline guideline, LottieAnimationView lottieAnimationView, Guideline guideline2, TextView textView, SwitchCompat switchCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.rootView = constraintLayout;
        this.clLocation = constraintLayout2;
        this.ivEdit = appCompatImageView;
        this.leftGuideline = guideline;
        this.progressView = lottieAnimationView;
        this.rightGuideline = guideline2;
        this.settingSummary = textView;
        this.settingSwitch = switchCompat;
        this.settingTitle = appCompatTextView;
        this.tvLocation = appCompatTextView2;
        this.tvRadius = appCompatTextView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderWelcomeHomeModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderWelcomeHomeModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_welcome_home_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderWelcomeHomeModeBinding bind(View view) {
        int i = R.id.cl_location;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.iv_edit;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.left_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.progress_view;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                    if (lottieAnimationView != null) {
                        i = R.id.right_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            i = R.id.setting_summary;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.setting_switch;
                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                if (switchCompat != null) {
                                    i = R.id.setting_title;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView != null) {
                                        i = R.id.tv_location;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView2 != null) {
                                            i = R.id.tv_radius;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatTextView3 != null) {
                                                return new HolderWelcomeHomeModeBinding((ConstraintLayout) view, constraintLayout, appCompatImageView, guideline, lottieAnimationView, guideline2, textView, switchCompat, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
