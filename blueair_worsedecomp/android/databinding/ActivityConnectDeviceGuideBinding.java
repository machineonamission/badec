package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class ActivityConnectDeviceGuideBinding implements ViewBinding {
    public final MaterialButton btnSearchFor;
    public final AppCompatButton btnSkip;
    public final AppCompatImageView icBluetooth;
    public final AppCompatImageView ivBack;
    public final AppCompatImageView ivClose;
    private final ConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvLabel;
    public final AppCompatTextView tvTitle;

    private ActivityConnectDeviceGuideBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, AppCompatButton appCompatButton, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, TextView textView, TextView textView2, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.btnSearchFor = materialButton;
        this.btnSkip = appCompatButton;
        this.icBluetooth = appCompatImageView;
        this.ivBack = appCompatImageView2;
        this.ivClose = appCompatImageView3;
        this.tvContent = textView;
        this.tvLabel = textView2;
        this.tvTitle = appCompatTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityConnectDeviceGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityConnectDeviceGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_connect_device_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityConnectDeviceGuideBinding bind(View view) {
        int i = R.id.btn_searchFor;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btnSkip;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R.id.ic_bluetooth;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.iv_back;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.iv_close;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView3 != null) {
                            i = R.id.tv_content;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_label;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_title;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView != null) {
                                        return new ActivityConnectDeviceGuideBinding((ConstraintLayout) view, materialButton, appCompatButton, appCompatImageView, appCompatImageView2, appCompatImageView3, textView, textView2, appCompatTextView);
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
