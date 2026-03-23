package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class HolderAddLocationBinding implements ViewBinding {
    public final AppCompatImageButton btnAdd;
    private final AppCompatImageButton rootView;

    private HolderAddLocationBinding(AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2) {
        this.rootView = appCompatImageButton;
        this.btnAdd = appCompatImageButton2;
    }

    public AppCompatImageButton getRoot() {
        return this.rootView;
    }

    public static HolderAddLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderAddLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_add_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderAddLocationBinding bind(View view) {
        if (view != null) {
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view;
            return new HolderAddLocationBinding(appCompatImageButton, appCompatImageButton);
        }
        throw new NullPointerException("rootView");
    }
}
