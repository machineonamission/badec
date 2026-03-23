package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceC3FanSpeedBinding implements ViewBinding {
    public final TextView cleanAirEta;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout contentSpeedLevel;
    public final AppCompatImageView downIcon;
    public final TextView fanSpeedLevel0;
    public final TextView fanSpeedLevel1;
    public final TextView fanSpeedLevel2;
    public final TextView fanSpeedLevel3;
    public final TextView fanSpeedLevel4;
    private final FrameLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final TextView title;
    public final AppCompatImageView upIcon;

    private HolderDeviceC3FanSpeedBinding(FrameLayout frameLayout, TextView textView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, AccessibleSeekBar accessibleSeekBar, TextView textView7, AppCompatImageView appCompatImageView2) {
        this.rootView = frameLayout;
        this.cleanAirEta = textView;
        this.contentContainer = constraintLayout;
        this.contentSpeedLevel = constraintLayout2;
        this.downIcon = appCompatImageView;
        this.fanSpeedLevel0 = textView2;
        this.fanSpeedLevel1 = textView3;
        this.fanSpeedLevel2 = textView4;
        this.fanSpeedLevel3 = textView5;
        this.fanSpeedLevel4 = textView6;
        this.seekbar = accessibleSeekBar;
        this.title = textView7;
        this.upIcon = appCompatImageView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceC3FanSpeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceC3FanSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_c3_fan_speed, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceC3FanSpeedBinding bind(View view) {
        View view2 = view;
        int i = R.id.clean_air_eta;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.content_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
            if (constraintLayout != null) {
                i = R.id.content_speed_level;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                if (constraintLayout2 != null) {
                    i = R.id.down_icon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                    if (appCompatImageView != null) {
                        i = R.id.fan_speed_level_0;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView2 != null) {
                            i = R.id.fan_speed_level_1;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView3 != null) {
                                i = R.id.fan_speed_level_2;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView4 != null) {
                                    i = R.id.fan_speed_level_3;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView5 != null) {
                                        i = R.id.fan_speed_level_4;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView6 != null) {
                                            i = R.id.seekbar;
                                            AccessibleSeekBar accessibleSeekBar = (AccessibleSeekBar) ViewBindings.findChildViewById(view2, i);
                                            if (accessibleSeekBar != null) {
                                                i = R.id.title;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView7 != null) {
                                                    i = R.id.up_icon;
                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                                    if (appCompatImageView2 != null) {
                                                        return new HolderDeviceC3FanSpeedBinding((FrameLayout) view2, textView, constraintLayout, constraintLayout2, appCompatImageView, textView2, textView3, textView4, textView5, textView6, accessibleSeekBar, textView7, appCompatImageView2);
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
