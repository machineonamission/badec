package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class DialogMacAddressInfoBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final MaterialButton buttonClose;
    public final TextView dialogMsg;
    public final TextView dialogTitle;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final LinearLayout rootView;
    public final Guideline topGuideline;

    private DialogMacAddressInfoBinding(LinearLayout linearLayout, Guideline guideline, MaterialButton materialButton, TextView textView, TextView textView2, Guideline guideline2, Guideline guideline3, Guideline guideline4) {
        this.rootView = linearLayout;
        this.bottomGuideline = guideline;
        this.buttonClose = materialButton;
        this.dialogMsg = textView;
        this.dialogTitle = textView2;
        this.leftGuideline = guideline2;
        this.rightGuideline = guideline3;
        this.topGuideline = guideline4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogMacAddressInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogMacAddressInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_mac_address_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogMacAddressInfoBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.buttonClose;
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
                            i = R.id.right_guideline;
                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline3 != null) {
                                i = R.id.top_guideline;
                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline4 != null) {
                                    return new DialogMacAddressInfoBinding((LinearLayout) view, guideline, materialButton, textView, textView2, guideline2, guideline3, guideline4);
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
