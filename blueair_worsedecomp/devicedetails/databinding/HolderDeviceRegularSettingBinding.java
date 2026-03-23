package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.view.ButtonTileConstraintLayout;

public final class HolderDeviceRegularSettingBinding implements ViewBinding {
    public final Guideline leftGuideline;
    public final ButtonTileConstraintLayout regularSettingLayout;
    public final Guideline rightGuideline;
    private final ButtonTileConstraintLayout rootView;
    public final AppCompatImageView settingArrow;
    public final TextView settingTitle;
    public final TextView settingValue;

    private HolderDeviceRegularSettingBinding(ButtonTileConstraintLayout buttonTileConstraintLayout, Guideline guideline, ButtonTileConstraintLayout buttonTileConstraintLayout2, Guideline guideline2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.rootView = buttonTileConstraintLayout;
        this.leftGuideline = guideline;
        this.regularSettingLayout = buttonTileConstraintLayout2;
        this.rightGuideline = guideline2;
        this.settingArrow = appCompatImageView;
        this.settingTitle = textView;
        this.settingValue = textView2;
    }

    public ButtonTileConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceRegularSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceRegularSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_regular_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceRegularSettingBinding bind(View view) {
        int i = R.id.left_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            ButtonTileConstraintLayout buttonTileConstraintLayout = (ButtonTileConstraintLayout) view;
            i = R.id.right_guideline;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.setting_arrow;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.setting_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.setting_value;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new HolderDeviceRegularSettingBinding(buttonTileConstraintLayout, guideline, buttonTileConstraintLayout, guideline2, appCompatImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
