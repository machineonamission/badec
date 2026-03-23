package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceTimezoneHintBinding implements ViewBinding {
    public final TextView attributeDescription;
    public final TextView attributeTitle;
    public final TextView attributeValue;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;

    private HolderDeviceTimezoneHintBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, Guideline guideline, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.attributeDescription = textView;
        this.attributeTitle = textView2;
        this.attributeValue = textView3;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceTimezoneHintBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceTimezoneHintBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_timezone_hint, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceTimezoneHintBinding bind(View view) {
        int i = R.id.attribute_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.attribute_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.attribute_value;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.left_guideline;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.right_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            return new HolderDeviceTimezoneHintBinding((ConstraintLayout) view, textView, textView2, textView3, guideline, guideline2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
