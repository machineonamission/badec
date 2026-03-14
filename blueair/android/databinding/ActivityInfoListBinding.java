package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;

public abstract class ActivityInfoListBinding extends ViewDataBinding {
   public final AppCompatImageButton btnBack;
   public final ShadowedRecyclerViewLayout srvList;
   public final AppCompatTextView tvTitle;

   protected ActivityInfoListBinding(Object var1, View var2, int var3, AppCompatImageButton var4, ShadowedRecyclerViewLayout var5, AppCompatTextView var6) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.srvList = var5;
      this.tvTitle = var6;
   }

   public static ActivityInfoListBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityInfoListBinding bind(View var0, Object var1) {
      return (ActivityInfoListBinding)bind(var1, var0, R.layout.activity_info_list);
   }

   public static ActivityInfoListBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityInfoListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityInfoListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityInfoListBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_info_list, var1, var2, var3);
   }

   @Deprecated
   public static ActivityInfoListBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityInfoListBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_info_list, (ViewGroup)null, false, var1);
   }
}
