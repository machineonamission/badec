package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public final class FragmentAddDeviceSetNameBinding implements ViewBinding {
    public final MaterialButton buttonNext;
    public final TextInputLayout deviceNameViewContainer;
    public final EditText editTextDeviceName;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;

    private FragmentAddDeviceSetNameBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, TextInputLayout textInputLayout, EditText editText, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonNext = materialButton;
        this.deviceNameViewContainer = textInputLayout;
        this.editTextDeviceName = editText;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceSetNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceSetNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_set_name, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceSetNameBinding bind(View view) {
        int i = R.id.buttonNext;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.deviceNameViewContainer;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
            if (textInputLayout != null) {
                i = R.id.editTextDeviceName;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.textAddDeviceSubtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.textAddDeviceTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentAddDeviceSetNameBinding(constraintLayout, materialButton, textInputLayout, editText, constraintLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
