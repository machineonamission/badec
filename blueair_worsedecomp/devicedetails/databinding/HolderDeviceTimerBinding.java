package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.devicedetails.R;

public final class HolderDeviceTimerBinding implements ViewBinding {
    public final CheckBox cbSwitch;
    public final ConstraintLayout contentContainer;
    public final AppCompatImageView ivClose;
    public final LottieAnimationView lavProgress;
    public final AppCompatImageView leadingIcon;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final AppCompatTextView tvTimer;

    private HolderDeviceTimerBinding(ConstraintLayout constraintLayout, CheckBox checkBox, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView2, TextView textView, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.cbSwitch = checkBox;
        this.contentContainer = constraintLayout2;
        this.ivClose = appCompatImageView;
        this.lavProgress = lottieAnimationView;
        this.leadingIcon = appCompatImageView2;
        this.title = textView;
        this.tvTimer = appCompatTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceTimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceTimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_timer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceTimerBinding bind(View view) {
        int i = R.id.cb_switch;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.lav_progress;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                if (lottieAnimationView != null) {
                    i = R.id.leading_icon;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_timer;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView != null) {
                                return new HolderDeviceTimerBinding(constraintLayout, checkBox, constraintLayout, appCompatImageView, lottieAnimationView, appCompatImageView2, textView, appCompatTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
