package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class ConfirmationDialogLeftAlignedVerticalBinding implements ViewBinding {
    public final TextView body;
    public final Guideline bottomGuideline;
    public final MaterialButton confirmButton;
    public final MaterialButton dismissButton;
    public final Guideline endGuideline;
    public final AppCompatImageView ivClose;
    private final LinearLayout rootView;
    public final Guideline startGuideline;
    public final TextView subtitle;
    public final TextView title;
    public final Guideline topGuideline;

    private ConfirmationDialogLeftAlignedVerticalBinding(LinearLayout linearLayout, TextView textView, Guideline guideline, MaterialButton materialButton, MaterialButton materialButton2, Guideline guideline2, AppCompatImageView appCompatImageView, Guideline guideline3, TextView textView2, TextView textView3, Guideline guideline4) {
        this.rootView = linearLayout;
        this.body = textView;
        this.bottomGuideline = guideline;
        this.confirmButton = materialButton;
        this.dismissButton = materialButton2;
        this.endGuideline = guideline2;
        this.ivClose = appCompatImageView;
        this.startGuideline = guideline3;
        this.subtitle = textView2;
        this.title = textView3;
        this.topGuideline = guideline4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ConfirmationDialogLeftAlignedVerticalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ConfirmationDialogLeftAlignedVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.confirmation_dialog_left_aligned_vertical, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConfirmationDialogLeftAlignedVerticalBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bottom_guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.confirm_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.dismiss_button;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        i = R.id.end_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            i = R.id.iv_close;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView != null) {
                                i = R.id.start_guideline;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.subtitle;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.top_guideline;
                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline4 != null) {
                                                return new ConfirmationDialogLeftAlignedVerticalBinding((LinearLayout) view, textView, guideline, materialButton, materialButton2, guideline2, appCompatImageView, guideline3, textView2, textView3, guideline4);
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
