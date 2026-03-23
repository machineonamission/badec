package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;

public final class HolderCommonDeviceNameBinding implements ViewBinding {
    public final RadioButton root;
    private final RadioButton rootView;

    private HolderCommonDeviceNameBinding(RadioButton radioButton, RadioButton radioButton2) {
        this.rootView = radioButton;
        this.root = radioButton2;
    }

    public RadioButton getRoot() {
        return this.rootView;
    }

    public static HolderCommonDeviceNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderCommonDeviceNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_common_device_name, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderCommonDeviceNameBinding bind(View view) {
        if (view != null) {
            RadioButton radioButton = (RadioButton) view;
            return new HolderCommonDeviceNameBinding(radioButton, radioButton);
        }
        throw new NullPointerException("rootView");
    }
}
