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

   protected FragmentSignInBinding(Object var1, View var2, int var3, AppCompatButton var4, AppCompatTextView var5, AppCompatButton var6, MaterialCheckBox var7, TextInputEditText var8, Group var9, AppCompatImageView var10, AppCompatImageView var11, TextInputEditText var12, TextView var13, ConstraintLayout var14, SimpleTextInputLayout var15, AppCompatTextView var16, SimpleTextInputLayout var17, AppCompatTextView var18, AppCompatTextView var19, AppCompatTextView var20) {
      super(var1, var2, var3);
      this.btnForgotPassword = var4;
      this.btnLogin = var5;
      this.btnRegister = var6;
      this.cbPrivacy = var7;
      this.email = var8;
      this.groupPrivacy = var9;
      this.ivBack = var10;
      this.ivClose = var11;
      this.password = var12;
      this.privacyText = var13;
      this.toolbar = var14;
      this.txtEmail = var15;
      this.txtEmailError = var16;
      this.txtPassword = var17;
      this.txtPasswordError = var18;
      this.txtRegisterTitle = var19;
      this.txtWelcomeBack = var20;
   }

   public static FragmentSignInBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentSignInBinding bind(View var0, Object var1) {
      return (FragmentSignInBinding)bind(var1, var0, R.layout.fragment_sign_in);
   }

   public static FragmentSignInBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentSignInBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentSignInBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentSignInBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_sign_in, var1, var2, var3);
   }

   @Deprecated
   public static FragmentSignInBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentSignInBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_sign_in, (ViewGroup)null, false, var1);
   }

   public SignInViewModel getViewModel() {
      return this.mViewModel;
   }

   public abstract void setViewModel(SignInViewModel var1);
}
