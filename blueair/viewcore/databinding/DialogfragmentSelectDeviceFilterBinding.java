package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;

public abstract class DialogfragmentSelectDeviceFilterBinding extends ViewDataBinding {
   public final ImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final Guideline endGuideline;
   public final RecyclerView filterList;
   public final ImageView filterScrollLeft;
   public final ImageView filterScrollRight;
   public final Guideline startGuideline;
   public final TextView title;

   protected DialogfragmentSelectDeviceFilterBinding(Object var1, View var2, int var3, ImageButton var4, ConstraintLayout var5, Guideline var6, RecyclerView var7, ImageView var8, ImageView var9, Guideline var10, TextView var11) {
      super(var1, var2, var3);
      this.closeBtn = var4;
      this.contentContainer = var5;
      this.endGuideline = var6;
      this.filterList = var7;
      this.filterScrollLeft = var8;
      this.filterScrollRight = var9;
      this.startGuideline = var10;
      this.title = var11;
   }

   public static DialogfragmentSelectDeviceFilterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentSelectDeviceFilterBinding bind(View var0, Object var1) {
      return (DialogfragmentSelectDeviceFilterBinding)bind(var1, var0, R.layout.dialogfragment_select_device_filter);
   }

   public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentSelectDeviceFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_select_device_filter, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentSelectDeviceFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_select_device_filter, (ViewGroup)null, false, var1);
   }
}
