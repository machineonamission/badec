package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityScheduleListBinding extends ViewDataBinding {
   public final LinearLayout bottomBar;
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnCreate;
   public final AppCompatImageButton btnMore;
   public final RecyclerView rvList;
   public final View separator;
   public final AppCompatTextView tvSubtitle;
   public final AppCompatTextView tvTitle;

   protected ActivityScheduleListBinding(Object var1, View var2, int var3, LinearLayout var4, AppCompatImageButton var5, MaterialButton var6, AppCompatImageButton var7, RecyclerView var8, View var9, AppCompatTextView var10, AppCompatTextView var11) {
      super(var1, var2, var3);
      this.bottomBar = var4;
      this.btnBack = var5;
      this.btnCreate = var6;
      this.btnMore = var7;
      this.rvList = var8;
      this.separator = var9;
      this.tvSubtitle = var10;
      this.tvTitle = var11;
   }

   public static ActivityScheduleListBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityScheduleListBinding bind(View var0, Object var1) {
      return (ActivityScheduleListBinding)bind(var1, var0, R.layout.activity_schedule_list);
   }

   public static ActivityScheduleListBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityScheduleListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityScheduleListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityScheduleListBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_schedule_list, var1, var2, var3);
   }

   @Deprecated
   public static ActivityScheduleListBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityScheduleListBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_schedule_list, (ViewGroup)null, false, var1);
   }
}
