package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class HolderBluetoothEnableBinding implements ViewBinding {
    public final MaterialButton bleEnableBtn;
    public final TextView enableTitle;
    public final AppCompatImageView icBluetooth;
    private final ConstraintLayout rootView;
    public final TextView tvContent;

    private HolderBluetoothEnableBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView, AppCompatImageView appCompatImageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.bleEnableBtn = materialButton;
        this.enableTitle = textView;
        this.icBluetooth = appCompatImageView;
        this.tvContent = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderBluetoothEnableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderBluetoothEnableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_bluetooth_enable, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderBluetoothEnableBinding bind(View view) {
        int i = R.id.ble_enable_btn;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.enable_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.ic_bluetooth;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.tv_content;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new HolderBluetoothEnableBinding((ConstraintLayout) view, materialButton, textView, appCompatImageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
