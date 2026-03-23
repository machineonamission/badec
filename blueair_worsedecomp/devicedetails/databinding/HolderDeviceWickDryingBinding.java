package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceWickDryingBinding implements ViewBinding {
    public final MaterialButton btnHigh;
    public final MaterialButton btnLow;
    public final ConstraintLayout contentContainer;
    public final SwitchCompat expendSwitch;
    public final Group expendedContent;
    public final ImageView ivInfo;
    public final ImageView leadingIcon;
    public final LinearProgressIndicator progressIndicator;
    private final ShadowLayout rootView;
    public final ShadowLayout slContainer;
    public final AppCompatTextView title;
    public final AppCompatTextView tvDuration;
    public final AppCompatTextView tvLeft;

    private HolderDeviceWickDryingBinding(ShadowLayout shadowLayout, MaterialButton materialButton, MaterialButton materialButton2, ConstraintLayout constraintLayout, SwitchCompat switchCompat, Group group, ImageView imageView, ImageView imageView2, LinearProgressIndicator linearProgressIndicator, ShadowLayout shadowLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.rootView = shadowLayout;
        this.btnHigh = materialButton;
        this.btnLow = materialButton2;
        this.contentContainer = constraintLayout;
        this.expendSwitch = switchCompat;
        this.expendedContent = group;
        this.ivInfo = imageView;
        this.leadingIcon = imageView2;
        this.progressIndicator = linearProgressIndicator;
        this.slContainer = shadowLayout2;
        this.title = appCompatTextView;
        this.tvDuration = appCompatTextView2;
        this.tvLeft = appCompatTextView3;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceWickDryingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceWickDryingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_wick_drying, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceWickDryingBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn_high;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
        if (materialButton != null) {
            i = R.id.btn_low;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton2 != null) {
                i = R.id.content_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                if (constraintLayout != null) {
                    i = R.id.expend_switch;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view2, i);
                    if (switchCompat != null) {
                        i = R.id.expended_content;
                        Group group = (Group) ViewBindings.findChildViewById(view2, i);
                        if (group != null) {
                            i = R.id.iv_info;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                            if (imageView != null) {
                                i = R.id.leading_icon;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                if (imageView2 != null) {
                                    i = R.id.progress_indicator;
                                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view2, i);
                                    if (linearProgressIndicator != null) {
                                        ShadowLayout shadowLayout = (ShadowLayout) view2;
                                        i = R.id.title;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                        if (appCompatTextView != null) {
                                            i = R.id.tv_duration;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                            if (appCompatTextView2 != null) {
                                                i = R.id.tv_left;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                                if (appCompatTextView3 != null) {
                                                    return new HolderDeviceWickDryingBinding(shadowLayout, materialButton, materialButton2, constraintLayout, switchCompat, group, imageView, imageView2, linearProgressIndicator, shadowLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
