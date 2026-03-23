package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceSettingsBinding implements ViewBinding {
    public final MaterialButton buttonProductSettings;
    private final MaterialButton rootView;

    private FragmentDeviceSettingsBinding(MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = materialButton;
        this.buttonProductSettings = materialButton2;
    }

    public MaterialButton getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeviceSettingsBinding bind(View view) {
        if (view != null) {
            MaterialButton materialButton = (MaterialButton) view;
            return new FragmentDeviceSettingsBinding(materialButton, materialButton);
        }
        throw new NullPointerException("rootView");
    }
}
