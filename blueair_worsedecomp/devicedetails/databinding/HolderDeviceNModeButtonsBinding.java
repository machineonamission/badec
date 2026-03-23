package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceNModeButtonsBinding implements ViewBinding {
    public final RecyclerView modeButtons;
    private final RecyclerView rootView;

    private HolderDeviceNModeButtonsBinding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.modeButtons = recyclerView2;
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static HolderDeviceNModeButtonsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceNModeButtonsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_n_mode_buttons, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceNModeButtonsBinding bind(View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new HolderDeviceNModeButtonsBinding(recyclerView, recyclerView);
        }
        throw new NullPointerException("rootView");
    }
}
