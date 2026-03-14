package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bin.david.form.core.SmartTable;
import com.blueair.android.R;

public abstract class ActivityInfoDetailBinding extends ViewDataBinding {
   public final View borderBottom;
   public final View borderEnd;
   public final View borderStart;
   public final AppCompatImageButton btnBack;
   public final SmartTable tableView;
   public final TextView tvPeriods;
   public final AppCompatTextView tvTitle;

   protected ActivityInfoDetailBinding(Object var1, View var2, int var3, View var4, View var5, View var6, AppCompatImageButton var7, SmartTable var8, TextView var9, AppCompatTextView var10) {
      super(var1, var2, var3);
      this.borderBottom = var4;
      this.borderEnd = var5;
      this.borderStart = var6;
      this.btnBack = var7;
      this.tableView = var8;
      this.tvPeriods = var9;
      this.tvTitle = var10;
   }

   public static ActivityInfoDetailBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityInfoDetailBinding bind(View var0, Object var1) {
      return (ActivityInfoDetailBinding)bind(var1, var0, R.layout.activity_info_detail);
   }

   public static ActivityInfoDetailBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityInfoDetailBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityInfoDetailBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityInfoDetailBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_info_detail, var1, var2, var3);
   }

   @Deprecated
   public static ActivityInfoDetailBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityInfoDetailBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_info_detail, (ViewGroup)null, false, var1);
   }
}
