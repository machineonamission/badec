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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class FragmentAddDeviceConfigureNetworkClassicBinding implements ViewBinding {
    public final MaterialButton buttonNext;
    public final TextInputEditText editTextPassword;
    public final TextView editTextSSID;
    public final TextInputLayout passwordViewContainer;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;

    private FragmentAddDeviceConfigureNetworkClassicBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, TextInputEditText textInputEditText, TextView textView, TextInputLayout textInputLayout, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonNext = materialButton;
        this.editTextPassword = textInputEditText;
        this.editTextSSID = textView;
        this.passwordViewContainer = textInputLayout;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceSubtitle = textView2;
        this.textAddDeviceTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceConfigureNetworkClassicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceConfigureNetworkClassicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_configure_network_classic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceConfigureNetworkClassicBinding bind(View view) {
        int i = R.id.buttonNext;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.editTextPassword;
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
            if (textInputEditText != null) {
                i = R.id.editTextSSID;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.passwordViewContainer;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                    if (textInputLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.textAddDeviceSubtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.textAddDeviceTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new FragmentAddDeviceConfigureNetworkClassicBinding(constraintLayout, materialButton, textInputEditText, textView, textInputLayout, constraintLayout, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
