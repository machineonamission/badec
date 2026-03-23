package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.blueair.login.SignInViewModel;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

public abstract class FragmentSignInBinding extends ViewDataBinding {
    public final AppCompatButton btnForgotPassword;
    public final AppCompatTextView btnLogin;
    public final AppCompatButton btnRegister;
    public final MaterialCheckBox cbPrivacy;
    public final TextInputEditText email;
    public final Group groupPrivacy;
    public final AppCompatImageView ivBack;
    public final AppCompatImageView ivClose;
    @Bindable
    protected SignInViewModel mViewModel;
    public final TextInputEditText password;
    public final TextView privacyText;
    public final ConstraintLayout toolbar;
    public final SimpleTextInputLayout txtEmail;
    public final AppCompatTextView txtEmailError;
    public final SimpleTextInputLayout txtPassword;
    public final AppCompatTextView txtPasswordError;
    public final AppCompatTextView txtRegisterTitle;
    public final AppCompatTextView txtWelcomeBack;

    public abstract void setViewModel(SignInViewModel signInViewModel);

    protected FragmentSignInBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton2, MaterialCheckBox materialCheckBox, TextInputEditText textInputEditText, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextInputEditText textInputEditText2, TextView textView, ConstraintLayout constraintLayout, SimpleTextInputLayout simpleTextInputLayout, AppCompatTextView appCompatTextView2, SimpleTextInputLayout simpleTextInputLayout2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        super(obj, view, i);
        this.btnForgotPassword = appCompatButton;
        this.btnLogin = appCompatTextView;
        this.btnRegister = appCompatButton2;
        this.cbPrivacy = materialCheckBox;
        this.email = textInputEditText;
        this.groupPrivacy = group;
        this.ivBack = appCompatImageView;
        this.ivClose = appCompatImageView2;
        this.password = textInputEditText2;
        this.privacyText = textView;
        this.toolbar = constraintLayout;
        this.txtEmail = simpleTextInputLayout;
        this.txtEmailError = appCompatTextView2;
        this.txtPassword = simpleTextInputLayout2;
        this.txtPasswordError = appCompatTextView3;
        this.txtRegisterTitle = appCompatTextView4;
        this.txtWelcomeBack = appCompatTextView5;
    }

    public SignInViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentSignInBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignInBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSignInBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sign_in, viewGroup, z, obj);
    }

    public static FragmentSignInBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignInBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSignInBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sign_in, (ViewGroup) null, false, obj);
    }

    public static FragmentSignInBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignInBinding bind(View view, Object obj) {
        return (FragmentSignInBinding) bind(obj, view, R.layout.fragment_sign_in);
    }
}
