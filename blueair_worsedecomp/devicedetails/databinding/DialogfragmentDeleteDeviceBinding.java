package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeleteDeviceBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final MaterialButton cancelView;
    public final TextView dialogMsg;
    public final TextView dialogTitle;
    public final Guideline leftGuideline;
    public final MaterialButton okView;
    public final ProgressBlockerView progressView;
    public final Guideline rightGuideline;
    public final ConstraintLayout rootLayout;
    private final LinearLayout rootView;
    public final Guideline topGuideline;

    private DialogfragmentDeleteDeviceBinding(LinearLayout linearLayout, Guideline guideline, MaterialButton materialButton, TextView textView, TextView textView2, Guideline guideline2, MaterialButton materialButton2, ProgressBlockerView progressBlockerView, Guideline guideline3, ConstraintLayout constraintLayout, Guideline guideline4) {
        this.rootView = linearLayout;
        this.bottomGuideline = guideline;
        this.cancelView = materialButton;
        this.dialogMsg = textView;
        this.dialogTitle = textView2;
        this.leftGuideline = guideline2;
        this.okView = materialButton2;
        this.progressView = progressBlockerView;
        this.rightGuideline = guideline3;
        this.rootLayout = constraintLayout;
        this.topGuideline = guideline4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeleteDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeleteDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_delete_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentDeleteDeviceBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.cancel_view;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.dialog_msg;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.dialog_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.left_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            i = R.id.ok_view;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                            if (materialButton2 != null) {
                                i = R.id.progressView;
                                ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                                if (progressBlockerView != null) {
                                    i = R.id.right_guideline;
                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline3 != null) {
                                        i = R.id.rootLayout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout != null) {
                                            i = R.id.top_guideline;
                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline4 != null) {
                                                return new DialogfragmentDeleteDeviceBinding((LinearLayout) view, guideline, materialButton, textView, textView2, guideline2, materialButton2, progressBlockerView, guideline3, constraintLayout, guideline4);
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
