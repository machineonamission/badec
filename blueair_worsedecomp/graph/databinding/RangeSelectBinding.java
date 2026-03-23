package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;
import com.google.android.material.button.MaterialButton;

public final class RangeSelectBinding implements ViewBinding {
    public final Guideline guideTimeEnd;
    public final MaterialButton rangeClose;
    public final MaterialButton rangeDay;
    public final MaterialButton rangeMonth;
    public final ConstraintLayout rangeSelectLayout;
    public final MaterialButton rangeWeek;
    private final ConstraintLayout rootView;
    public final MaterialButton timeButton;

    private RangeSelectBinding(ConstraintLayout constraintLayout, Guideline guideline, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, ConstraintLayout constraintLayout2, MaterialButton materialButton4, MaterialButton materialButton5) {
        this.rootView = constraintLayout;
        this.guideTimeEnd = guideline;
        this.rangeClose = materialButton;
        this.rangeDay = materialButton2;
        this.rangeMonth = materialButton3;
        this.rangeSelectLayout = constraintLayout2;
        this.rangeWeek = materialButton4;
        this.timeButton = materialButton5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RangeSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RangeSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.range_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RangeSelectBinding bind(View view) {
        int i = R.id.guide_time_end;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.range_close;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.range_day;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.range_month;
                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton3 != null) {
                        i = R.id.range_select_layout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.range_week;
                            MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                            if (materialButton4 != null) {
                                i = R.id.time_button;
                                MaterialButton materialButton5 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                if (materialButton5 != null) {
                                    return new RangeSelectBinding((ConstraintLayout) view, guideline, materialButton, materialButton2, materialButton3, constraintLayout, materialButton4, materialButton5);
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
