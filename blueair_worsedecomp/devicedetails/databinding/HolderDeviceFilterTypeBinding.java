package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceFilterTypeBinding implements ViewBinding {
    public final AppCompatImageView filterImage;
    public final TextView filterName;
    public final Guideline leftGuideline;
    public final MaterialButton myFilterBtn;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;

    private HolderDeviceFilterTypeBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, Guideline guideline, MaterialButton materialButton, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.filterImage = appCompatImageView;
        this.filterName = textView;
        this.leftGuideline = guideline;
        this.myFilterBtn = materialButton;
        this.rightGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFilterTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFilterTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_filter_type, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceFilterTypeBinding bind(View view) {
        int i = R.id.filter_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.filter_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.left_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.my_filter_btn;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton != null) {
                        i = R.id.right_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            return new HolderDeviceFilterTypeBinding((ConstraintLayout) view, appCompatImageView, textView, guideline, materialButton, guideline2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
