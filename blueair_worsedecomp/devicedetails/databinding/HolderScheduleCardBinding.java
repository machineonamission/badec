package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderScheduleCardBinding implements ViewBinding {
    public final ImageView ivLeading;
    public final ImageView ivMainMode;
    public final ImageView ivMode;
    public final LinearLayout llMode;
    public final ConstraintLayout rootLayout;
    private final ShadowLayout rootView;
    public final SwitchCompat switchSchedule;
    public final TextView timeRange;
    public final AppCompatTextView tvMode;
    public final AppCompatTextView tvName;
    public final TextView tvRepeat;

    private HolderScheduleCardBinding(ShadowLayout shadowLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ConstraintLayout constraintLayout, SwitchCompat switchCompat, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView2) {
        this.rootView = shadowLayout;
        this.ivLeading = imageView;
        this.ivMainMode = imageView2;
        this.ivMode = imageView3;
        this.llMode = linearLayout;
        this.rootLayout = constraintLayout;
        this.switchSchedule = switchCompat;
        this.timeRange = textView;
        this.tvMode = appCompatTextView;
        this.tvName = appCompatTextView2;
        this.tvRepeat = textView2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderScheduleCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderScheduleCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_schedule_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderScheduleCardBinding bind(View view) {
        int i = R.id.iv_leading;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_mainMode;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_mode;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.ll_mode;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.root_layout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.switch_schedule;
                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                            if (switchCompat != null) {
                                i = R.id.time_range;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_mode;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView != null) {
                                        i = R.id.tv_name;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView2 != null) {
                                            i = R.id.tv_repeat;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new HolderScheduleCardBinding((ShadowLayout) view, imageView, imageView2, imageView3, linearLayout, constraintLayout, switchCompat, textView, appCompatTextView, appCompatTextView2, textView2);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
