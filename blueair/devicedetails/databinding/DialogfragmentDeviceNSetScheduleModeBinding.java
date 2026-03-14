package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceNSetScheduleModeBinding extends ViewDataBinding {
   public final ImageButton backBtn;
   public final LinearLayout contentContainer;
   public final RecyclerView modeControls;
   public final MaterialButton saveBtn;
   public final TextView title;
   public final FrameLayout titleBar;

   protected DialogfragmentDeviceNSetScheduleModeBinding(Object var1, View var2, int var3, ImageButton var4, LinearLayout var5, RecyclerView var6, MaterialButton var7, TextView var8, FrameLayout var9) {
      super(var1, var2, var3);
      this.backBtn = var4;
      this.contentContainer = var5;
      this.modeControls = var6;
      this.saveBtn = var7;
      this.title = var8;
      this.titleBar = var9;
   }

   public static DialogfragmentDeviceNSetScheduleModeBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceNSetScheduleModeBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceNSetScheduleModeBinding)bind(var1, var0, R.layout.dialogfragment_device_n_set_schedule_mode);
   }

   public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceNSetScheduleModeBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_n_set_schedule_mode, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceNSetScheduleModeBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_n_set_schedule_mode, (ViewGroup)null, false, var1);
   }
}
