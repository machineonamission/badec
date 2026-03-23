package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class ActivityWelcomeBinding implements ViewBinding {
    public final AppCompatButton btnLogin;
    public final MaterialButton btnRegister;
    private final ConstraintLayout rootView;
    public final AppCompatTextView txtWelcomeMsg;

    private ActivityWelcomeBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, MaterialButton materialButton, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.btnLogin = appCompatButton;
        this.btnRegister = materialButton;
        this.txtWelcomeMsg = appCompatTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_welcome, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityWelcomeBinding bind(View view) {
        int i = R.id.btnLogin;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.btnRegister;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.txt_welcomeMsg;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView != null) {
                    return new ActivityWelcomeBinding((ConstraintLayout) view, appCompatButton, materialButton, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
