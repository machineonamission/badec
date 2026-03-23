package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class FragmentAddDeviceManualFailBinding implements ViewBinding {
    public final Button buttonRestart;
    public final ImageView imgManualFail;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceTitle;

    private FragmentAddDeviceManualFailBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.buttonRestart = button;
        this.imgManualFail = imageView;
        this.textAddDeviceTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceManualFailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceManualFailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_manual_fail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceManualFailBinding bind(View view) {
        int i = R.id.button_restart;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.img_manual_fail;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.textAddDeviceTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentAddDeviceManualFailBinding((ConstraintLayout) view, button, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
