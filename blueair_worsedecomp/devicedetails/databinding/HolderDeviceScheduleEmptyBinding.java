package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceScheduleEmptyBinding implements ViewBinding {
    public final MaterialButton buttonAdd;
    private final ConstraintLayout rootView;

    private HolderDeviceScheduleEmptyBinding(ConstraintLayout constraintLayout, MaterialButton materialButton) {
        this.rootView = constraintLayout;
        this.buttonAdd = materialButton;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceScheduleEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceScheduleEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_schedule_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceScheduleEmptyBinding bind(View view) {
        int i = R.id.button_add;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            return new HolderDeviceScheduleEmptyBinding((ConstraintLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
