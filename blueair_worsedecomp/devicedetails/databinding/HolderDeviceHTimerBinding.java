package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public final class HolderDeviceHTimerBinding implements ViewBinding {
    public final LinearLayout contentCountdown;
    public final FrameLayout contentProgress;
    public final TextView countdownNumber;
    private final FrameLayout rootView;
    public final AppCompatImageView timerControlIcon;
    public final CircularProgressIndicator timerProgressBar;
    public final AppCompatImageView timerProgressStatusIcon;
    public final TextView timerSelect;
    public final TextView timerTitle;

    private HolderDeviceHTimerBinding(FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, TextView textView, AppCompatImageView appCompatImageView, CircularProgressIndicator circularProgressIndicator, AppCompatImageView appCompatImageView2, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.contentCountdown = linearLayout;
        this.contentProgress = frameLayout2;
        this.countdownNumber = textView;
        this.timerControlIcon = appCompatImageView;
        this.timerProgressBar = circularProgressIndicator;
        this.timerProgressStatusIcon = appCompatImageView2;
        this.timerSelect = textView2;
        this.timerTitle = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHTimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHTimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_h_timer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceHTimerBinding bind(View view) {
        int i = R.id.content_countdown;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.content_progress;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.countdown_number;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.timer_control_icon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.timer_progress_bar;
                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
                        if (circularProgressIndicator != null) {
                            i = R.id.timer_progress_status_icon;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.timer_select;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.timer_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new HolderDeviceHTimerBinding((FrameLayout) view, linearLayout, frameLayout, textView, appCompatImageView, circularProgressIndicator, appCompatImageView2, textView2, textView3);
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
