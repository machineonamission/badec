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

   protected FragmentForgotPasswordBinding(Object var1, View var2, int var3, AppCompatImageButton var4, AppCompatImageButton var5, MaterialButton var6, TextInputEditText var7, MaterialToolbar var8, TextInputLayout var9, AppCompatTextView var10, AppCompatTextView var11) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnClose = var5;
      this.btnForgotPassword = var6;
      this.email = var7;
      this.toolbar = var8;
      this.txtEmail = var9;
      this.txtEmailError = var10;
      this.txtTitle = var11;
   }

   public static FragmentForgotPasswordBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentForgotPasswordBinding bind(View var0, Object var1) {
      return (FragmentForgotPasswordBinding)bind(var1, var0, R.layout.fragment_forgot_password);
   }

   public static FragmentForgotPasswordBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentForgotPasswordBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentForgotPasswordBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentForgotPasswordBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_forgot_password, var1, var2, var3);
   }

   @Deprecated
   public static FragmentForgotPasswordBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentForgotPasswordBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_forgot_password, (ViewGroup)null, false, var1);
   }

   public ForgotPasswordViewModel getViewModel() {
      return this.mViewModel;
   }

   public abstract void setViewModel(ForgotPasswordViewModel var1);
}
