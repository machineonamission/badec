package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceNFilterBinding extends ViewDataBinding {
   public final TextView availableFilters;
   public final MaterialButton btnAntiFake;
   public final MaterialButton btnPurchase;
   public final MaterialButton btnResetFilter;
   public final MaterialButton btnSubscribe;
   public final TextView buyNewFilter;
   public final ImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final TextView discountHint;
   public final Guideline endGuideline;
   public final RecyclerView filterList;
   public final ImageView filterScrollLeft;
   public final ImageView filterScrollRight;
   public final AppCompatImageButton iconPlay;
   public final ProgressBlockerView progressView;
   public final Group replaceGroup;
   public final ScrollView scrollView;
   public final Guideline startGuideline;
   public final TextView title;
   public final TextView videoSummary;
   public final AppCompatImageView videoThumbnail;
   public final TextView whyIsThisImportant;

   protected DialogfragmentDeviceNFilterBinding(Object var1, View var2, int var3, TextView var4, MaterialButton var5, MaterialButton var6, MaterialButton var7, MaterialButton var8, TextView var9, ImageButton var10, ConstraintLayout var11, TextView var12, Guideline var13, RecyclerView var14, ImageView var15, ImageView var16, AppCompatImageButton var17, ProgressBlockerView var18, Group var19, ScrollView var20, Guideline var21, TextView var22, TextView var23, AppCompatImageView var24, TextView var25) {
      super(var1, var2, var3);
      this.availableFilters = var4;
      this.btnAntiFake = var5;
      this.btnPurchase = var6;
      this.btnResetFilter = var7;
      this.btnSubscribe = var8;
      this.buyNewFilter = var9;
      this.closeBtn = var10;
      this.contentContainer = var11;
      this.discountHint = var12;
      this.endGuideline = var13;
      this.filterList = var14;
      this.filterScrollLeft = var15;
      this.filterScrollRight = var16;
      this.iconPlay = var17;
      this.progressView = var18;
      this.replaceGroup = var19;
      this.scrollView = var20;
      this.startGuideline = var21;
      this.title = var22;
      this.videoSummary = var23;
      this.videoThumbnail = var24;
      this.whyIsThisImportant = var25;
   }

   public static DialogfragmentDeviceNFilterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceNFilterBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceNFilterBinding)bind(var1, var0, R.layout.dialogfragment_device_n_filter);
   }

   public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceNFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_n_filter, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceNFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_n_filter, (ViewGroup)null, false, var1);
   }
}
