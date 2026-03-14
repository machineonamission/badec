package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentWifiPasswordBinding extends ViewDataBinding {
   public final MaterialButton buttonNext;
   public final TextInputLayout inputPassword;
   public final TextView logView;
   @Bindable
   protected AddDeviceViewModel mAddDeviceViewModel;
   public final TextInputEditText passwordEditText;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   public final TextInputEditText ssidEditText;
   public final TextInputLayout ssidEditTextLayout;
   public final AppCompatTextView tvError;
   public final AppCompatTextView tvSubtitle;
   public final AppCompatTextView tvTitle;

   protected FragmentWifiPasswordBinding(Object var1, View var2, int var3, MaterialButton var4, TextInputLayout var5, TextView var6, TextInputEditText var7, ProgressBlockerView var8, ConstraintLayout var9, TextInputEditText var10, TextInputLayout var11, AppCompatTextView var12, AppCompatTextView var13, AppCompatTextView var14) {
      super(var1, var2, var3);
      this.buttonNext = var4;
      this.inputPassword = var5;
      this.logView = var6;
      this.passwordEditText = var7;
      this.progressView = var8;
      this.rootLayout = var9;
      this.ssidEditText = var10;
      this.ssidEditTextLayout = var11;
      this.tvError = var12;
      this.tvSubtitle = var13;
      this.tvTitle = var14;
   }

   public static FragmentWifiPasswordBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentWifiPasswordBinding bind(View var0, Object var1) {
      return (FragmentWifiPasswordBinding)bind(var1, var0, R.layout.fragment_wifi_password);
   }

   public static FragmentWifiPasswordBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentWifiPasswordBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentWifiPasswordBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentWifiPasswordBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_wifi_password, var1, var2, var3);
   }

   @Deprecated
   public static FragmentWifiPasswordBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentWifiPasswordBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_wifi_password, (ViewGroup)null, false, var1);
   }

   public AddDeviceViewModel getAddDeviceViewModel() {
      return this.mAddDeviceViewModel;
   }

   public abstract void setAddDeviceViewModel(AddDeviceViewModel var1);
}
