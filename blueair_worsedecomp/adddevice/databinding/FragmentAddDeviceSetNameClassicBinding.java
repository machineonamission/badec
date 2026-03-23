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

public final class FragmentAddDeviceSetNameClassicBinding implements ViewBinding {
    public final MaterialButton buttonNext;
    public final TextInputLayout deviceNameViewContainer;
    public final TextInputEditText editTextDeviceName;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceTitle;

    private FragmentAddDeviceSetNameClassicBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, TextInputLayout textInputLayout, TextInputEditText textInputEditText, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.buttonNext = materialButton;
        this.deviceNameViewContainer = textInputLayout;
        this.editTextDeviceName = textInputEditText;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceSetNameClassicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceSetNameClassicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_set_name_classic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceSetNameClassicBinding bind(View view) {
        int i = R.id.buttonNext;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.deviceNameViewContainer;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
            if (textInputLayout != null) {
                i = R.id.editTextDeviceName;
                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                if (textInputEditText != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.textAddDeviceTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new FragmentAddDeviceSetNameClassicBinding(constraintLayout, materialButton, textInputLayout, textInputEditText, constraintLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
