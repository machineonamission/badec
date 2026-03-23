package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.ForgotPasswordViewModel;
import com.blueair.login.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentForgotPasswordBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnForgotPassword;
    public final TextInputEditText email;
    @Bindable
    protected ForgotPasswordViewModel mViewModel;
    public final MaterialToolbar toolbar;
    public final TextInputLayout txtEmail;
    public final AppCompatTextView txtEmailError;
    public final AppCompatTextView txtTitle;

    public abstract void setViewModel(ForgotPasswordViewModel forgotPasswordViewModel);

    protected FragmentForgotPasswordBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, MaterialButton materialButton, TextInputEditText textInputEditText, MaterialToolbar materialToolbar, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.btnClose = appCompatImageButton2;
        this.btnForgotPassword = materialButton;
        this.email = textInputEditText;
        this.toolbar = materialToolbar;
        this.txtEmail = textInputLayout;
        this.txtEmailError = appCompatTextView;
        this.txtTitle = appCompatTextView2;
    }

    public ForgotPasswordViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentForgotPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentForgotPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentForgotPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_forgot_password, viewGroup, z, obj);
    }

    public static FragmentForgotPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentForgotPasswordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentForgotPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_forgot_password, (ViewGroup) null, false, obj);
    }

    public static FragmentForgotPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentForgotPasswordBinding bind(View view, Object obj) {
        return (FragmentForgotPasswordBinding) bind(obj, view, R.layout.fragment_forgot_password);
    }
}
