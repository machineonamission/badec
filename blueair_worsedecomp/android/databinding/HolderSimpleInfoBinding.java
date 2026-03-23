package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.devicedetails.view.ButtonTileConstraintLayout;

public final class HolderSimpleInfoBinding implements ViewBinding {
    public final Guideline leftGuideline;
    public final ButtonTileConstraintLayout regularSettingLayout;
    public final Guideline rightGuideline;
    private final ButtonTileConstraintLayout rootView;
    public final AppCompatImageView settingArrow;
    public final TextView tvTitle;

    private HolderSimpleInfoBinding(ButtonTileConstraintLayout buttonTileConstraintLayout, Guideline guideline, ButtonTileConstraintLayout buttonTileConstraintLayout2, Guideline guideline2, AppCompatImageView appCompatImageView, TextView textView) {
        this.rootView = buttonTileConstraintLayout;
        this.leftGuideline = guideline;
        this.regularSettingLayout = buttonTileConstraintLayout2;
        this.rightGuideline = guideline2;
        this.settingArrow = appCompatImageView;
        this.tvTitle = textView;
    }

    public ButtonTileConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderSimpleInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderSimpleInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_simple_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderSimpleInfoBinding bind(View view) {
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
                    i = R.id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new HolderSimpleInfoBinding(buttonTileConstraintLayout, guideline, buttonTileConstraintLayout, guideline2, appCompatImageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
