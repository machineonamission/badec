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

   protected FragmentRegisterBinding(Object var1, View var2, int var3, AppCompatImageButton var4, AppCompatImageButton var5, AppCompatButton var6, MaterialButton var7, MaterialCheckBox var8, MaterialCheckBox var9, MaterialCheckBox var10, MaterialCheckBox var11, TextInputEditText var12, TextInputEditText var13, TextInputEditText var14, TextInputEditText var15, ProgressBlockerView var16, TextInputEditText var17, TextView var18, ScrollView var19, ConstraintLayout var20, AppCompatTextView var21, SimpleTextInputLayout var22, AppCompatTextView var23, SimpleTextInputLayout var24, AppCompatTextView var25, SimpleTextInputLayout var26, AppCompatTextView var27, AppCompatTextView var28, SimpleTextInputLayout var29, AppCompatTextView var30, AppCompatTextView var31, SimpleTextInputLayout var32, AppCompatTextView var33, AppCompatTextView var34) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnClose = var5;
      this.btnLogin = var6;
      this.btnRegister = var7;
      this.cbConsent = var8;
      this.cbPrivacy = var9;
      this.cbSubscribe = var10;
      this.cbYears = var11;
      this.confirmPassword = var12;
      this.email = var13;
      this.firstName = var14;
      this.lastName = var15;
      this.loading = var16;
      this.password = var17;
      this.privacyText = var18;
      this.scrollableRoot = var19;
      this.toolbar = var20;
      this.tvTip = var21;
      this.txtConfirmPassword = var22;
      this.txtConfirmPasswordError = var23;
      this.txtEmail = var24;
      this.txtEmailError = var25;
      this.txtFirstName = var26;
      this.txtFirstNameError = var27;
      this.txtGetStarted = var28;
      this.txtLastName = var29;
      this.txtLastNameError = var30;
      this.txtLoginTitle = var31;
      this.txtPassword = var32;
      this.txtPasswordError = var33;
      this.txtPasswordRequirement = var34;
   }

   public static FragmentRegisterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentRegisterBinding bind(View var0, Object var1) {
      return (FragmentRegisterBinding)bind(var1, var0, R.layout.fragment_register);
   }

   public static FragmentRegisterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentRegisterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentRegisterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentRegisterBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_register, var1, var2, var3);
   }

   @Deprecated
   public static FragmentRegisterBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentRegisterBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_register, (ViewGroup)null, false, var1);
   }

   public RegisterViewModel getViewModel() {
      return this.mViewModel;
   }

   public abstract void setViewModel(RegisterViewModel var1);
}
