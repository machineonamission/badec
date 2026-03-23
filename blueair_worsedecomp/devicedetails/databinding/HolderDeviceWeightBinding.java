package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceWeightBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final MaterialButton tareBtn;
    public final TextView title;
    public final TextView weightValue;

    private HolderDeviceWeightBinding(FrameLayout frameLayout, MaterialButton materialButton, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.tareBtn = materialButton;
        this.title = textView;
        this.weightValue = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceWeightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceWeightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_weight, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceWeightBinding bind(View view) {
        int i = R.id.tare_btn;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.weight_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new HolderDeviceWeightBinding((FrameLayout) view, materialButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
