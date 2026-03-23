package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceModeButtonsV2Binding implements ViewBinding {
    public final RecyclerView modeButtons;
    private final RecyclerView rootView;

    private HolderDeviceModeButtonsV2Binding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.modeButtons = recyclerView2;
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static HolderDeviceModeButtonsV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceModeButtonsV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_mode_buttons_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceModeButtonsV2Binding bind(View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new HolderDeviceModeButtonsV2Binding(recyclerView, recyclerView);
        }
        throw new NullPointerException("rootView");
    }
}
