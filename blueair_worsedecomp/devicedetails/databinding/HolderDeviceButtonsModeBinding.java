package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceButtonsModeBinding implements ViewBinding {
    public final AppCompatImageView automodeImageview;
    public final LinearLayout automodeRoot;
    public final TextView automodeTitleview;
    public final AppCompatImageView childLockImageview;
    public final LinearLayout childLockRoot;
    public final AppCompatTextView childLockTitleview;
    public final AppCompatImageView disinfectionImageview;
    public final LinearLayout disinfectionRoot;
    public final AppCompatTextView disinfectionTitleview;
    public final AppCompatImageView manualModeImageview;
    public final LinearLayout manualModeRoot;
    public final AppCompatTextView manualModeTitleview;
    public final AppCompatImageView nightmodeImageview;
    public final LinearLayout nightmodeRoot;
    public final TextView nightmodeTitleview;
    private final ConstraintLayout rootView;
    public final AppCompatImageView standbyModeImageview;
    public final LinearLayout standbyModeRoot;
    public final TextView standbyModeTitleview;

    private HolderDeviceButtonsModeBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, LinearLayout linearLayout3, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView4, LinearLayout linearLayout4, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView5, LinearLayout linearLayout5, TextView textView2, AppCompatImageView appCompatImageView6, LinearLayout linearLayout6, TextView textView3) {
        this.rootView = constraintLayout;
        this.automodeImageview = appCompatImageView;
        this.automodeRoot = linearLayout;
        this.automodeTitleview = textView;
        this.childLockImageview = appCompatImageView2;
        this.childLockRoot = linearLayout2;
        this.childLockTitleview = appCompatTextView;
        this.disinfectionImageview = appCompatImageView3;
        this.disinfectionRoot = linearLayout3;
        this.disinfectionTitleview = appCompatTextView2;
        this.manualModeImageview = appCompatImageView4;
        this.manualModeRoot = linearLayout4;
        this.manualModeTitleview = appCompatTextView3;
        this.nightmodeImageview = appCompatImageView5;
        this.nightmodeRoot = linearLayout5;
        this.nightmodeTitleview = textView2;
        this.standbyModeImageview = appCompatImageView6;
        this.standbyModeRoot = linearLayout6;
        this.standbyModeTitleview = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceButtonsModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceButtonsModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_buttons_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceButtonsModeBinding bind(View view) {
        View view2 = view;
        int i = R.id.automode_imageview;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
        if (appCompatImageView != null) {
            i = R.id.automode_root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
            if (linearLayout != null) {
                i = R.id.automode_titleview;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView != null) {
                    i = R.id.child_lock_imageview;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.child_lock_root;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                        if (linearLayout2 != null) {
                            i = R.id.child_lock_titleview;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                            if (appCompatTextView != null) {
                                i = R.id.disinfection_imageview;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                if (appCompatImageView3 != null) {
                                    i = R.id.disinfection_root;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.disinfection_titleview;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                        if (appCompatTextView2 != null) {
                                            i = R.id.manual_mode_imageview;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                            if (appCompatImageView4 != null) {
                                                i = R.id.manual_mode_root;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.manual_mode_titleview;
                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                                    if (appCompatTextView3 != null) {
                                                        i = R.id.nightmode_imageview;
                                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                                        if (appCompatImageView5 != null) {
                                                            i = R.id.nightmode_root;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.nightmode_titleview;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.standby_mode_imageview;
                                                                    AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                                                    if (appCompatImageView6 != null) {
                                                                        i = R.id.standby_mode_root;
                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                        if (linearLayout6 != null) {
                                                                            i = R.id.standby_mode_titleview;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView3 != null) {
                                                                                return new HolderDeviceButtonsModeBinding((ConstraintLayout) view2, appCompatImageView, linearLayout, textView, appCompatImageView2, linearLayout2, appCompatTextView, appCompatImageView3, linearLayout3, appCompatTextView2, appCompatImageView4, linearLayout4, appCompatTextView3, appCompatImageView5, linearLayout5, textView2, appCompatImageView6, linearLayout6, textView3);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
