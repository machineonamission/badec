package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentRegionMismatchBinding implements ViewBinding {
    public final MaterialButton buttonClose;
    public final MaterialButton buttonRegister;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textError;
    public final TextView textTitle;

    private FragmentRegionMismatchBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonClose = materialButton;
        this.buttonRegister = materialButton2;
        this.rootLayout = constraintLayout2;
        this.textError = textView;
        this.textTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRegionMismatchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentRegionMismatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_region_mismatch, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentRegionMismatchBinding bind(View view) {
        int i = R.id.buttonClose;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.buttonRegister;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.textError;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.textTitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new FragmentRegionMismatchBinding(constraintLayout, materialButton, materialButton2, constraintLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
