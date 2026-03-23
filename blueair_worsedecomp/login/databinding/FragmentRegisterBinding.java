package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.blueair.login.RegisterViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

public abstract class FragmentRegisterBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton btnClose;
    public final AppCompatButton btnLogin;
    public final MaterialButton btnRegister;
    public final MaterialCheckBox cbConsent;
    public final MaterialCheckBox cbPrivacy;
    public final MaterialCheckBox cbSubscribe;
    public final MaterialCheckBox cbYears;
    public final TextInputEditText confirmPassword;
    public final TextInputEditText email;
    public final TextInputEditText firstName;
    public final TextInputEditText lastName;
    public final ProgressBlockerView loading;
    @Bindable
    protected RegisterViewModel mViewModel;
    public final TextInputEditText password;
    public final TextView privacyText;
    public final ScrollView scrollableRoot;
    public final ConstraintLayout toolbar;
    public final AppCompatTextView tvTip;
    public final SimpleTextInputLayout txtConfirmPassword;
    public final AppCompatTextView txtConfirmPasswordError;
    public final SimpleTextInputLayout txtEmail;
    public final AppCompatTextView txtEmailError;
    public final SimpleTextInputLayout txtFirstName;
    public final AppCompatTextView txtFirstNameError;
    public final AppCompatTextView txtGetStarted;
    public final SimpleTextInputLayout txtLastName;
    public final AppCompatTextView txtLastNameError;
    public final AppCompatTextView txtLoginTitle;
    public final SimpleTextInputLayout txtPassword;
    public final AppCompatTextView txtPasswordError;
    public final AppCompatTextView txtPasswordRequirement;

    public abstract void setViewModel(RegisterViewModel registerViewModel);

    protected FragmentRegisterBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, AppCompatButton appCompatButton, MaterialButton materialButton, MaterialCheckBox materialCheckBox, MaterialCheckBox materialCheckBox2, MaterialCheckBox materialCheckBox3, MaterialCheckBox materialCheckBox4, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, ProgressBlockerView progressBlockerView, TextInputEditText textInputEditText5, TextView textView, ScrollView scrollView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, SimpleTextInputLayout simpleTextInputLayout, AppCompatTextView appCompatTextView2, SimpleTextInputLayout simpleTextInputLayout2, AppCompatTextView appCompatTextView3, SimpleTextInputLayout simpleTextInputLayout3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, SimpleTextInputLayout simpleTextInputLayout4, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, SimpleTextInputLayout simpleTextInputLayout5, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.btnClose = appCompatImageButton2;
        this.btnLogin = appCompatButton;
        this.btnRegister = materialButton;
        this.cbConsent = materialCheckBox;
        this.cbPrivacy = materialCheckBox2;
        this.cbSubscribe = materialCheckBox3;
        this.cbYears = materialCheckBox4;
        this.confirmPassword = textInputEditText;
        this.email = textInputEditText2;
        this.firstName = textInputEditText3;
        this.lastName = textInputEditText4;
        this.loading = progressBlockerView;
        this.password = textInputEditText5;
        this.privacyText = textView;
        this.scrollableRoot = scrollView;
        this.toolbar = constraintLayout;
        this.tvTip = appCompatTextView;
        this.txtConfirmPassword = simpleTextInputLayout;
        this.txtConfirmPasswordError = appCompatTextView2;
        this.txtEmail = simpleTextInputLayout2;
        this.txtEmailError = appCompatTextView3;
        this.txtFirstName = simpleTextInputLayout3;
        this.txtFirstNameError = appCompatTextView4;
        this.txtGetStarted = appCompatTextView5;
        this.txtLastName = simpleTextInputLayout4;
        this.txtLastNameError = appCompatTextView6;
        this.txtLoginTitle = appCompatTextView7;
        this.txtPassword = simpleTextInputLayout5;
        this.txtPasswordError = appCompatTextView8;
        this.txtPasswordRequirement = appCompatTextView9;
    }

    public RegisterViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRegisterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_register, viewGroup, z, obj);
    }

    public static FragmentRegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegisterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRegisterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_register, (ViewGroup) null, false, obj);
    }

    public static FragmentRegisterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegisterBinding bind(View view, Object obj) {
        return (FragmentRegisterBinding) bind(obj, view, R.layout.fragment_register);
    }
}
