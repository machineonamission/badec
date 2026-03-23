package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderAlarmCardBinding implements ViewBinding {
    public final ConstraintLayout clLayout;
    public final ImageView ivLight;
    public final ImageView ivSound;
    private final ShadowLayout rootView;
    public final SwitchCompat switchAlarm;
    public final AppCompatTextView tvName;
    public final TextView tvRepeat;
    public final TextView tvTime;

    private HolderAlarmCardBinding(ShadowLayout shadowLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, SwitchCompat switchCompat, AppCompatTextView appCompatTextView, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.clLayout = constraintLayout;
        this.ivLight = imageView;
        this.ivSound = imageView2;
        this.switchAlarm = switchCompat;
        this.tvName = appCompatTextView;
        this.tvRepeat = textView;
        this.tvTime = textView2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderAlarmCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderAlarmCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_alarm_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderAlarmCardBinding bind(View view) {
        int i = R.id.cl_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.iv_light;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_sound;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.switch_alarm;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                    if (switchCompat != null) {
                        i = R.id.tv_name;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                        if (appCompatTextView != null) {
                            i = R.id.tv_repeat;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_time;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new HolderAlarmCardBinding((ShadowLayout) view, constraintLayout, imageView, imageView2, switchCompat, appCompatTextView, textView, textView2);
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
