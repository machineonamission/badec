package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceGermShieldNightModeBinding implements ViewBinding {
    public final TextView gsnmDescription;
    public final SwitchCompat gsnmSwitch;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;

    private HolderDeviceGermShieldNightModeBinding(ConstraintLayout constraintLayout, TextView textView, SwitchCompat switchCompat, Guideline guideline, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.gsnmDescription = textView;
        this.gsnmSwitch = switchCompat;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceGermShieldNightModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceGermShieldNightModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_germ_shield_night_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceGermShieldNightModeBinding bind(View view) {
        int i = R.id.gsnm_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.gsnm_switch;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
            if (switchCompat != null) {
                i = R.id.left_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.right_guideline;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline2 != null) {
                        return new HolderDeviceGermShieldNightModeBinding((ConstraintLayout) view, textView, switchCompat, guideline, guideline2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
