package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceNScheduleBinding implements ViewBinding {
    public final View arrow;
    public final AppCompatImageView iconMainMode;
    public final AppCompatImageView iconMode;
    public final TextView mainMode;
    public final TextView mode;
    public final TextView nameAndRepeat;
    private final ConstraintLayout rootView;
    public final TextView scheduleSwitch;
    public final TextView timeRange;

    private HolderDeviceNScheduleBinding(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.arrow = view;
        this.iconMainMode = appCompatImageView;
        this.iconMode = appCompatImageView2;
        this.mainMode = textView;
        this.mode = textView2;
        this.nameAndRepeat = textView3;
        this.scheduleSwitch = textView4;
        this.timeRange = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceNScheduleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceNScheduleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_n_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceNScheduleBinding bind(View view) {
        int i = R.id.arrow;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.icon_main_mode;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.icon_mode;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.main_mode;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.mode;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.name_and_repeat;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.schedule_switch;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.time_range;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        return new HolderDeviceNScheduleBinding((ConstraintLayout) view, findChildViewById, appCompatImageView, appCompatImageView2, textView, textView2, textView3, textView4, textView5);
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
