package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.android.R;

public final class HolderOutdoorLocationBinding implements ViewBinding {
    public final View airQualityIndicator;
    public final Group groupInfo;
    public final LottieAnimationView progressView;
    private final ConstraintLayout rootView;
    public final TextView tvAirQuality;
    public final AppCompatTextView tvEnableLocation;
    public final AppCompatTextView tvLocation;

    private HolderOutdoorLocationBinding(ConstraintLayout constraintLayout, View view, Group group, LottieAnimationView lottieAnimationView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.airQualityIndicator = view;
        this.groupInfo = group;
        this.progressView = lottieAnimationView;
        this.tvAirQuality = textView;
        this.tvEnableLocation = appCompatTextView;
        this.tvLocation = appCompatTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderOutdoorLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderOutdoorLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_outdoor_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderOutdoorLocationBinding bind(View view) {
        int i = R.id.air_quality_indicator;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.group_info;
            Group group = (Group) ViewBindings.findChildViewById(view, i);
            if (group != null) {
                i = R.id.progress_view;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                if (lottieAnimationView != null) {
                    i = R.id.tv_air_quality;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_enable_location;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                        if (appCompatTextView != null) {
                            i = R.id.tv_location;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView2 != null) {
                                return new HolderOutdoorLocationBinding((ConstraintLayout) view, findChildViewById, group, lottieAnimationView, textView, appCompatTextView, appCompatTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
