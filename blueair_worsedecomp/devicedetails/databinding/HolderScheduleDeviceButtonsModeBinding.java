package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderScheduleDeviceButtonsModeBinding implements ViewBinding {
    public final AppCompatImageView automodeImageview;
    public final ConstraintLayout automodeRoot;
    public final TextView automodeTitleview;
    public final AppCompatImageView manualModeImageview;
    public final ConstraintLayout manualModeRoot;
    public final AppCompatTextView manualModeTitleview;
    public final AppCompatImageView nightmodeImageview;
    public final ConstraintLayout nightmodeRoot;
    public final TextView nightmodeTitleview;
    private final ConstraintLayout rootView;
    public final AppCompatImageView standbyModeImageview;
    public final ConstraintLayout standbyModeRoot;
    public final AppCompatTextView standbyModeTitleview;

    private HolderScheduleDeviceButtonsModeBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout4, TextView textView2, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout5, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.automodeImageview = appCompatImageView;
        this.automodeRoot = constraintLayout2;
        this.automodeTitleview = textView;
        this.manualModeImageview = appCompatImageView2;
        this.manualModeRoot = constraintLayout3;
        this.manualModeTitleview = appCompatTextView;
        this.nightmodeImageview = appCompatImageView3;
        this.nightmodeRoot = constraintLayout4;
        this.nightmodeTitleview = textView2;
        this.standbyModeImageview = appCompatImageView4;
        this.standbyModeRoot = constraintLayout5;
        this.standbyModeTitleview = appCompatTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderScheduleDeviceButtonsModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderScheduleDeviceButtonsModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_schedule_device_buttons_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderScheduleDeviceButtonsModeBinding bind(View view) {
        View view2 = view;
        int i = R.id.automode_imageview;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
        if (appCompatImageView != null) {
            i = R.id.automode_root;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
            if (constraintLayout != null) {
                i = R.id.automode_titleview;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView != null) {
                    i = R.id.manual_mode_imageview;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.manual_mode_root;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                        if (constraintLayout2 != null) {
                            i = R.id.manual_mode_titleview;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                            if (appCompatTextView != null) {
                                i = R.id.nightmode_imageview;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                if (appCompatImageView3 != null) {
                                    i = R.id.nightmode_root;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.nightmode_titleview;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView2 != null) {
                                            i = R.id.standby_mode_imageview;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                            if (appCompatImageView4 != null) {
                                                i = R.id.standby_mode_root;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.standby_mode_titleview;
                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                                    if (appCompatTextView2 != null) {
                                                        return new HolderScheduleDeviceButtonsModeBinding((ConstraintLayout) view2, appCompatImageView, constraintLayout, textView, appCompatImageView2, constraintLayout2, appCompatTextView, appCompatImageView3, constraintLayout3, textView2, appCompatImageView4, constraintLayout4, appCompatTextView2);
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
