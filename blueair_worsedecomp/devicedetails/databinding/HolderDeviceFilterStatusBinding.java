package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceFilterStatusBinding implements ViewBinding {
    public final TextView attributeTitle;
    public final Barrier barrierDescript;
    public final Barrier barrierLifetime;
    public final MaterialButton buyNew;
    public final TextView filterChangeView;
    public final MaterialButton filterReplacement;
    public final TextView filterTimeLeftView;
    public final TextView filterTimePercentView;
    public final ConstraintLayout holderDeviceFilterStatus;
    public final MaterialButton howToReplace;
    public final Guideline leftGuideline;
    public final LinearProgressIndicator progress;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;

    private HolderDeviceFilterStatusBinding(ConstraintLayout constraintLayout, TextView textView, Barrier barrier, Barrier barrier2, MaterialButton materialButton, TextView textView2, MaterialButton materialButton2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, MaterialButton materialButton3, Guideline guideline, LinearProgressIndicator linearProgressIndicator, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.attributeTitle = textView;
        this.barrierDescript = barrier;
        this.barrierLifetime = barrier2;
        this.buyNew = materialButton;
        this.filterChangeView = textView2;
        this.filterReplacement = materialButton2;
        this.filterTimeLeftView = textView3;
        this.filterTimePercentView = textView4;
        this.holderDeviceFilterStatus = constraintLayout2;
        this.howToReplace = materialButton3;
        this.leftGuideline = guideline;
        this.progress = linearProgressIndicator;
        this.rightGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFilterStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFilterStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_filter_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceFilterStatusBinding bind(View view) {
        View view2 = view;
        int i = R.id.attribute_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.barrier_descript;
            Barrier barrier = (Barrier) ViewBindings.findChildViewById(view2, i);
            if (barrier != null) {
                i = R.id.barrier_lifetime;
                Barrier barrier2 = (Barrier) ViewBindings.findChildViewById(view2, i);
                if (barrier2 != null) {
                    i = R.id.buy_new;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                    if (materialButton != null) {
                        i = R.id.filter_change_view;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView2 != null) {
                            i = R.id.filter_replacement;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                            if (materialButton2 != null) {
                                i = R.id.filter_time_left_view;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView3 != null) {
                                    i = R.id.filter_time_percent_view;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView4 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                                        i = R.id.how_to_replace;
                                        MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                        if (materialButton3 != null) {
                                            i = R.id.left_guideline;
                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i);
                                            if (guideline != null) {
                                                i = R.id.progress;
                                                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view2, i);
                                                if (linearProgressIndicator != null) {
                                                    i = R.id.right_guideline;
                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                    if (guideline2 != null) {
                                                        return new HolderDeviceFilterStatusBinding(constraintLayout, textView, barrier, barrier2, materialButton, textView2, materialButton2, textView3, textView4, constraintLayout, materialButton3, guideline, linearProgressIndicator, guideline2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
