package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.viewmodel.IndoorViewModel;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentIndoorBinding extends ViewDataBinding {
   public final MaterialButton btnAddProduct;
   public final ConstraintLayout emptyLayout;
   public final AppCompatImageView ivAddFooter;
   public final ImageView ivAlarm;
   public final ConstraintLayout layoutMain;
   public final RecyclerView listDevices;
   @Bindable
   protected IndoorViewModel mIndoorViewModel;
   public final ShadowLayout slAlarm;
   public final AppCompatTextView textEmptyTitle;
   public final TextView tvAlarmLabel;
   public final TextView tvAlarmValue;

   protected FragmentIndoorBinding(Object var1, View var2, int var3, MaterialButton var4, ConstraintLayout var5, AppCompatImageView var6, ImageView var7, ConstraintLayout var8, RecyclerView var9, ShadowLayout var10, AppCompatTextView var11, TextView var12, TextView var13) {
      super(var1, var2, var3);
      this.btnAddProduct = var4;
      this.emptyLayout = var5;
      this.ivAddFooter = var6;
      this.ivAlarm = var7;
      this.layoutMain = var8;
      this.listDevices = var9;
      this.slAlarm = var10;
      this.textEmptyTitle = var11;
      this.tvAlarmLabel = var12;
      this.tvAlarmValue = var13;
   }

   public static FragmentIndoorBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentIndoorBinding bind(View var0, Object var1) {
      return (FragmentIndoorBinding)bind(var1, var0, R.layout.fragment_indoor);
   }

   public static FragmentIndoorBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentIndoorBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentIndoorBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentIndoorBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_indoor, var1, var2, var3);
   }

   @Deprecated
   public static FragmentIndoorBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentIndoorBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_indoor, (ViewGroup)null, false, var1);
   }

   public IndoorViewModel getIndoorViewModel() {
      return this.mIndoorViewModel;
   }

   public abstract void setIndoorViewModel(IndoorViewModel var1);
}
