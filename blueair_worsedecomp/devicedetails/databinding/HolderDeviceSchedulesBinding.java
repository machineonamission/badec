package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceSchedulesBinding implements ViewBinding {
    public final ConstraintLayout childLockContainer;
    public final ImageView childLockIcon;
    public final TextView childLockText;
    public final TextView childLockValue;
    private final LinearLayout rootView;
    public final ConstraintLayout schedulesContainer;
    public final ImageView schedulesIcon;
    public final TextView schedulesText;
    public final TextView schedulesValue;

    private HolderDeviceSchedulesBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.childLockContainer = constraintLayout;
        this.childLockIcon = imageView;
        this.childLockText = textView;
        this.childLockValue = textView2;
        this.schedulesContainer = constraintLayout2;
        this.schedulesIcon = imageView2;
        this.schedulesText = textView3;
        this.schedulesValue = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceSchedulesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceSchedulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_schedules, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceSchedulesBinding bind(View view) {
        int i = R.id.child_lock_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.child_lock_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.child_lock_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.child_lock_value;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.schedules_container;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.schedules_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.schedules_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.schedules_value;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        return new HolderDeviceSchedulesBinding((LinearLayout) view, constraintLayout, imageView, textView, textView2, constraintLayout2, imageView2, textView3, textView4);
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
