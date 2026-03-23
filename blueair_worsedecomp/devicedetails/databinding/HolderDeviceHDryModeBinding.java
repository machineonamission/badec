package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceHDryModeBinding implements ViewBinding {
    public final TextView cancelDryMode;
    public final ConstraintLayout contentDryMode;
    public final TextView countdownNumber;
    public final ImageView dryModeIcon;
    public final TextView dryModeTitle;
    private final ConstraintLayout rootView;

    private HolderDeviceHDryModeBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, ImageView imageView, TextView textView3) {
        this.rootView = constraintLayout;
        this.cancelDryMode = textView;
        this.contentDryMode = constraintLayout2;
        this.countdownNumber = textView2;
        this.dryModeIcon = imageView;
        this.dryModeTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHDryModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHDryModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_h_dry_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceHDryModeBinding bind(View view) {
        int i = R.id.cancel_dry_mode;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.content_dry_mode;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.countdown_number;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.dry_mode_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.dry_mode_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new HolderDeviceHDryModeBinding((ConstraintLayout) view, textView, constraintLayout, textView2, imageView, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
