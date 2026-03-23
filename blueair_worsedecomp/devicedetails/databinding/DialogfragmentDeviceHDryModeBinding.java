package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceHDryModeBinding implements ViewBinding {
    public final AppCompatImageView backBtn;
    public final LinearLayout contentBack;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout contentContainerSwitch;
    public final TextView dryModeInfo;
    public final Guideline endGuideline;
    private final FrameLayout rootView;
    public final MaterialButton saveBtn;
    public final Guideline startGuideline;
    public final SwitchCompat switchBtn;
    public final TextView title;

    private DialogfragmentDeviceHDryModeBinding(FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, Guideline guideline, MaterialButton materialButton, Guideline guideline2, SwitchCompat switchCompat, TextView textView2) {
        this.rootView = frameLayout;
        this.backBtn = appCompatImageView;
        this.contentBack = linearLayout;
        this.contentContainer = constraintLayout;
        this.contentContainerSwitch = constraintLayout2;
        this.dryModeInfo = textView;
        this.endGuideline = guideline;
        this.saveBtn = materialButton;
        this.startGuideline = guideline2;
        this.switchBtn = switchCompat;
        this.title = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceHDryModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceHDryModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_h_dry_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentDeviceHDryModeBinding bind(View view) {
        int i = R.id.back_btn;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.content_back;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.content_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.content_container_switch;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.dry_mode_info;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.end_guideline;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                i = R.id.save_btn;
                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                if (materialButton != null) {
                                    i = R.id.start_guideline;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline2 != null) {
                                        i = R.id.switch_btn;
                                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                        if (switchCompat != null) {
                                            i = R.id.title;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new DialogfragmentDeviceHDryModeBinding((FrameLayout) view, appCompatImageView, linearLayout, constraintLayout, constraintLayout2, textView, guideline, materialButton, guideline2, switchCompat, textView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
