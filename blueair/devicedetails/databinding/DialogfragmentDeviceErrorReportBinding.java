package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;

public abstract class DialogfragmentDeviceErrorReportBinding extends ViewDataBinding {
   public final RecyclerView recyclerViewDeviceInfo;
   public final LinearLayout rootLayout;
   public final TextView screenTitle;
   public final Toolbar toolbar;

   protected DialogfragmentDeviceErrorReportBinding(Object var1, View var2, int var3, RecyclerView var4, LinearLayout var5, TextView var6, Toolbar var7) {
      super(var1, var2, var3);
      this.recyclerViewDeviceInfo = var4;
      this.rootLayout = var5;
      this.screenTitle = var6;
      this.toolbar = var7;
   }

   public static DialogfragmentDeviceErrorReportBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceErrorReportBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceErrorReportBinding)bind(var1, var0, R.layout.dialogfragment_device_error_report);
   }

   public static DialogfragmentDeviceErrorReportBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceErrorReportBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceErrorReportBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceErrorReportBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_error_report, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceErrorReportBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceErrorReportBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_error_report, (ViewGroup)null, false, var1);
   }
}
