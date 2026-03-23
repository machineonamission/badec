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
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceHumidificationBinding implements ViewBinding {
    public final ConstraintLayout clContainer;
    public final LinearLayout contentContainer;
    public final HolderDeviceHintBinding hintContainer;
    public final ImageView leadingIcon;
    private final LinearLayout rootView;
    public final SwitchCompat switchMode;
    public final TextView title;

    private HolderDeviceHumidificationBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, HolderDeviceHintBinding holderDeviceHintBinding, ImageView imageView, SwitchCompat switchCompat, TextView textView) {
        this.rootView = linearLayout;
        this.clContainer = constraintLayout;
        this.contentContainer = linearLayout2;
        this.hintContainer = holderDeviceHintBinding;
        this.leadingIcon = imageView;
        this.switchMode = switchCompat;
        this.title = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHumidificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHumidificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_humidification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceHumidificationBinding bind(View view) {
        int i = R.id.cl_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.hint_container;
            View findChildViewById = ViewBindings.findChildViewById(view, i);
            if (findChildViewById != null) {
                HolderDeviceHintBinding bind = HolderDeviceHintBinding.bind(findChildViewById);
                i = R.id.leading_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.switch_mode;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                    if (switchCompat != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new HolderDeviceHumidificationBinding(linearLayout, constraintLayout, linearLayout, bind, imageView, switchCompat, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
