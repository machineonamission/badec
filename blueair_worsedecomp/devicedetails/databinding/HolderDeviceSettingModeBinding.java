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

public final class HolderDeviceSettingModeBinding implements ViewBinding {
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final TextView settingSummary;
    public final SwitchCompat settingSwitch;
    public final TextView settingTitle;

    private HolderDeviceSettingModeBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        this.rootView = constraintLayout;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
        this.settingSummary = textView;
        this.settingSwitch = switchCompat;
        this.settingTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceSettingModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceSettingModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_setting_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceSettingModeBinding bind(View view) {
        int i = R.id.left_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.right_guideline;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.setting_summary;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.setting_switch;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                    if (switchCompat != null) {
                        i = R.id.setting_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new HolderDeviceSettingModeBinding((ConstraintLayout) view, guideline, guideline2, textView, switchCompat, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
