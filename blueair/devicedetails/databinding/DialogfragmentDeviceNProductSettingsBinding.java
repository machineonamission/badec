package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;

public abstract class DialogfragmentDeviceNProductSettingsBinding extends ViewDataBinding {
   public final ImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final Button doneBtn;
   public final View separator;
   public final RecyclerView settingsList;
   public final TextView title;

   protected DialogfragmentDeviceNProductSettingsBinding(Object var1, View var2, int var3, ImageButton var4, ConstraintLayout var5, Button var6, View var7, RecyclerView var8, TextView var9) {
      super(var1, var2, var3);
      this.closeBtn = var4;
      this.contentContainer = var5;
      this.doneBtn = var6;
      this.separator = var7;
      this.settingsList = var8;
      this.title = var9;
   }

   public static DialogfragmentDeviceNProductSettingsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceNProductSettingsBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceNProductSettingsBinding)bind(var1, var0, R.layout.dialogfragment_device_n_product_settings);
   }

   public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceNProductSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_n_product_settings, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceNProductSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_n_product_settings, (ViewGroup)null, false, var1);
   }
}
