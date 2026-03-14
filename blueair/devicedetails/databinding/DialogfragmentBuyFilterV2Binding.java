package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentBuyFilterV2Binding extends ViewDataBinding {
   public final MaterialButton btnPurchase;
   public final MaterialButton btnSubscribe;
   public final AppCompatImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final TextView discountHint;
   public final Guideline endGuideline;
   public final RecyclerView filterList;
   public final ProgressBlockerView progressView;
   public final Guideline startGuideline;
   public final AppCompatTextView title;
   public final View vTop;

   protected DialogfragmentBuyFilterV2Binding(Object var1, View var2, int var3, MaterialButton var4, MaterialButton var5, AppCompatImageButton var6, ConstraintLayout var7, TextView var8, Guideline var9, RecyclerView var10, ProgressBlockerView var11, Guideline var12, AppCompatTextView var13, View var14) {
      super(var1, var2, var3);
      this.btnPurchase = var4;
      this.btnSubscribe = var5;
      this.closeBtn = var6;
      this.contentContainer = var7;
      this.discountHint = var8;
      this.endGuideline = var9;
      this.filterList = var10;
      this.progressView = var11;
      this.startGuideline = var12;
      this.title = var13;
      this.vTop = var14;
   }

   public static DialogfragmentBuyFilterV2Binding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentBuyFilterV2Binding bind(View var0, Object var1) {
      return (DialogfragmentBuyFilterV2Binding)bind(var1, var0, R.layout.dialogfragment_buy_filter_v2);
   }

   public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentBuyFilterV2Binding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_buy_filter_v2, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentBuyFilterV2Binding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_buy_filter_v2, (ViewGroup)null, false, var1);
   }
}
