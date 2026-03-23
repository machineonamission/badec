package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceHSettingsBinding implements ViewBinding {
    public final MaterialButton btnSettings;
    private final FrameLayout rootView;

    private FragmentDeviceHSettingsBinding(FrameLayout frameLayout, MaterialButton materialButton) {
        this.rootView = frameLayout;
        this.btnSettings = materialButton;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceHSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceHSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_h_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeviceHSettingsBinding bind(View view) {
        int i = R.id.btn_settings;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            return new FragmentDeviceHSettingsBinding((FrameLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
