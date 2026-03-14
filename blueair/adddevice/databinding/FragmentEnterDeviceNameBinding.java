package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public abstract class FragmentEnterDeviceNameBinding extends ViewDataBinding {
   public final MaterialButton buttonDone;
   public final TextInputEditText etDeviceName;
   public final TextInputLayout inputDeviceName;
   @Bindable
   protected AddDeviceViewModel mAddDeviceViewModel;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   public final AppCompatTextView tvSubtitle;
   public final AppCompatTextView tvTitle;

   protected FragmentEnterDeviceNameBinding(Object var1, View var2, int var3, MaterialButton var4, TextInputEditText var5, TextInputLayout var6, ProgressBlockerView var7, ConstraintLayout var8, AppCompatTextView var9, AppCompatTextView var10) {
      super(var1, var2, var3);
      this.buttonDone = var4;
      this.etDeviceName = var5;
      this.inputDeviceName = var6;
      this.progressView = var7;
      this.rootLayout = var8;
      this.tvSubtitle = var9;
      this.tvTitle = var10;
   }

   public static FragmentEnterDeviceNameBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentEnterDeviceNameBinding bind(View var0, Object var1) {
      return (FragmentEnterDeviceNameBinding)bind(var1, var0, R.layout.fragment_enter_device_name);
   }

   public static FragmentEnterDeviceNameBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentEnterDeviceNameBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentEnterDeviceNameBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentEnterDeviceNameBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_enter_device_name, var1, var2, var3);
   }

   @Deprecated
   public static FragmentEnterDeviceNameBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentEnterDeviceNameBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_enter_device_name, (ViewGroup)null, false, var1);
   }

   public AddDeviceViewModel getAddDeviceViewModel() {
      return this.mAddDeviceViewModel;
   }

   public abstract void setAddDeviceViewModel(AddDeviceViewModel var1);
}
