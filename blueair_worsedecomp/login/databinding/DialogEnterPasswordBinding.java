package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.login.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class DialogEnterPasswordBinding implements ViewBinding {
    public final MaterialButton cancelView;
    public final TextView dialogMsg;
    public final TextView dialogTitle;
    public final TextInputEditText editText;
    public final TextInputLayout editTextLayout;
    public final MaterialButton okView;
    private final FrameLayout rootView;

    private DialogEnterPasswordBinding(FrameLayout frameLayout, MaterialButton materialButton, TextView textView, TextView textView2, TextInputEditText textInputEditText, TextInputLayout textInputLayout, MaterialButton materialButton2) {
        this.rootView = frameLayout;
        this.cancelView = materialButton;
        this.dialogMsg = textView;
        this.dialogTitle = textView2;
        this.editText = textInputEditText;
        this.editTextLayout = textInputLayout;
        this.okView = materialButton2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogEnterPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogEnterPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_enter_password, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogEnterPasswordBinding bind(View view) {
        int i = R.id.cancel_view;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.dialog_msg;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.editText;
                    TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                    if (textInputEditText != null) {
                        i = R.id.editTextLayout;
                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                        if (textInputLayout != null) {
                            i = R.id.ok_view;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                            if (materialButton2 != null) {
                                return new DialogEnterPasswordBinding((FrameLayout) view, materialButton, textView, textView2, textInputEditText, textInputLayout, materialButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
