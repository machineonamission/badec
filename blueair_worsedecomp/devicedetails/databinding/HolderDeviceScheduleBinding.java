package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceScheduleBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final Guideline endGuideline;
    public final TextView mode;
    public final TextView nameAndRepeat;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final Guideline startGuideline;
    public final LinearLayout timeContainer;
    public final TextView timeRange;
    public final Guideline topGuideline;

    private HolderDeviceScheduleBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, Guideline guideline3, LinearLayout linearLayout, TextView textView3, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.endGuideline = guideline2;
        this.mode = textView;
        this.nameAndRepeat = textView2;
        this.rootLayout = constraintLayout2;
        this.startGuideline = guideline3;
        this.timeContainer = linearLayout;
        this.timeRange = textView3;
        this.topGuideline = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceScheduleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceScheduleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceScheduleBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.end_guideline;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.mode;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.name_and_repeat;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.start_guideline;
                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline3 != null) {
                            i = R.id.time_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.time_range;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.top_guideline;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline4 != null) {
                                        return new HolderDeviceScheduleBinding(constraintLayout, guideline, guideline2, textView, textView2, constraintLayout, guideline3, linearLayout, textView3, guideline4);
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
