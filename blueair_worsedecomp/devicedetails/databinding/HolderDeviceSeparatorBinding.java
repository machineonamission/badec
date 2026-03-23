package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceSeparatorBinding implements ViewBinding {
    private final View rootView;
    public final View separator;

    private HolderDeviceSeparatorBinding(View view, View view2) {
        this.rootView = view;
        this.separator = view2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static HolderDeviceSeparatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceSeparatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_separator, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceSeparatorBinding bind(View view) {
        if (view != null) {
            return new HolderDeviceSeparatorBinding(view, view);
        }
        throw new NullPointerException("rootView");
    }
}
