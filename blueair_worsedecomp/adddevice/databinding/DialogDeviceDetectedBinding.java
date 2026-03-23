package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class DialogDeviceDetectedBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final AppCompatImageButton closeButton;
    public final MaterialButton connectButton;
    public final ImageView deviceImg;
    public final Guideline endGuideline;
    public final TextView macNumberColon;
    public final TextView macNumberTitle;
    public final TextView macNumberValue;
    public final TextView prompt;
    private final ConstraintLayout rootView;
    public final Guideline startGuideline;
    public final TextView title;
    public final Guideline topGuideline;

    private DialogDeviceDetectedBinding(ConstraintLayout constraintLayout, Guideline guideline, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, ImageView imageView, Guideline guideline2, TextView textView, TextView textView2, TextView textView3, TextView textView4, Guideline guideline3, TextView textView5, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.closeButton = appCompatImageButton;
        this.connectButton = materialButton;
        this.deviceImg = imageView;
        this.endGuideline = guideline2;
        this.macNumberColon = textView;
        this.macNumberTitle = textView2;
        this.macNumberValue = textView3;
        this.prompt = textView4;
        this.startGuideline = guideline3;
        this.title = textView5;
        this.topGuideline = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogDeviceDetectedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogDeviceDetectedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_device_detected, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogDeviceDetectedBinding bind(View view) {
        View view2 = view;
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i);
        if (guideline != null) {
            i = R.id.close_button;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
            if (appCompatImageButton != null) {
                i = R.id.connect_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                if (materialButton != null) {
                    i = R.id.device_img;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView != null) {
                        i = R.id.end_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i);
                        if (guideline2 != null) {
                            i = R.id.mac_number_colon;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView != null) {
                                i = R.id.mac_number_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView2 != null) {
                                    i = R.id.mac_number_value;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView3 != null) {
                                        i = R.id.prompt;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView4 != null) {
                                            i = R.id.start_guideline;
                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                            if (guideline3 != null) {
                                                i = R.id.title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView5 != null) {
                                                    i = R.id.top_guideline;
                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                    if (guideline4 != null) {
                                                        return new DialogDeviceDetectedBinding((ConstraintLayout) view2, guideline, appCompatImageButton, materialButton, imageView, guideline2, textView, textView2, textView3, textView4, guideline3, textView5, guideline4);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
