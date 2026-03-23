package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceFilterPurchaseBinding implements ViewBinding {
    public final MaterialButton buttonFilterPurchase;
    private final RelativeLayout rootView;

    private HolderDeviceFilterPurchaseBinding(RelativeLayout relativeLayout, MaterialButton materialButton) {
        this.rootView = relativeLayout;
        this.buttonFilterPurchase = materialButton;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFilterPurchaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFilterPurchaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_filter_purchase, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceFilterPurchaseBinding bind(View view) {
        int i = R.id.buttonFilterPurchase;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            return new HolderDeviceFilterPurchaseBinding((RelativeLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
