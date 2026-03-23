package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;

public final class DeviceGraphBinding implements ViewBinding {
    public final LineChart lineChart;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;
    public final TextView scaleDayButton;
    public final TextView scaleMonthButton;
    public final TextView scaleWeekButton;

    private DeviceGraphBinding(ConstraintLayout constraintLayout, LineChart lineChart2, ProgressBlockerView progressBlockerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.lineChart = lineChart2;
        this.progressView = progressBlockerView;
        this.scaleDayButton = textView;
        this.scaleMonthButton = textView2;
        this.scaleWeekButton = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DeviceGraphBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DeviceGraphBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.device_graph, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DeviceGraphBinding bind(View view) {
        int i = R.id.lineChart;
        LineChart lineChart2 = (LineChart) ViewBindings.findChildViewById(view, i);
        if (lineChart2 != null) {
            i = R.id.progressView;
            ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
            if (progressBlockerView != null) {
                i = R.id.scaleDayButton;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.scaleMonthButton;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.scaleWeekButton;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new DeviceGraphBinding((ConstraintLayout) view, lineChart2, progressBlockerView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
