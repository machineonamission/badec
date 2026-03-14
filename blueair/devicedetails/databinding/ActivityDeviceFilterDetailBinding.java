package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public abstract class ActivityDeviceFilterDetailBinding extends ViewDataBinding {
   public final TextView availableFilters;
   public final View bgFilterInfo;
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnBuy;
   public final MaterialButton btnGetInstructions;
   public final MaterialButton btnResetFilter;
   public final MaterialButton btnVisit;
   public final AppCompatImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final ShadowLayout cvFilterLife;
   public final ShadowLayout cvReplaceFilter;
   public final Guideline endGuideline;
   public final RecyclerView filterList;
   public final Group groupUserManual;
   public final ImageView iconPlay;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   public final LinearProgressIndicator progressIndicator;
   public final ProgressBlockerView progressView;
   public final ScrollView scrollView;
   public final Guideline startGuideline;
   public final AppCompatTextView title;
   public final AppCompatTextView tvChangeFilter;
   public final AppCompatTextView tvFilterInfo;
   public final AppCompatTextView tvFilterLife;
   public final AppCompatTextView tvGuide;
   public final AppCompatTextView tvHowReplace;
   public final TextView tvProgress;
   public final AppCompatTextView tvSubtitle;
   public final ShapeableImageView videoThumbnail;

   protected ActivityDeviceFilterDetailBinding(Object var1, View var2, int var3, TextView var4, View var5, AppCompatImageButton var6, MaterialButton var7, MaterialButton var8, MaterialButton var9, MaterialButton var10, AppCompatImageButton var11, ConstraintLayout var12, ShadowLayout var13, ShadowLayout var14, Guideline var15, RecyclerView var16, Group var17, ImageView var18, ImageView var19, ImageView var20, LinearProgressIndicator var21, ProgressBlockerView var22, ScrollView var23, Guideline var24, AppCompatTextView var25, AppCompatTextView var26, AppCompatTextView var27, AppCompatTextView var28, AppCompatTextView var29, AppCompatTextView var30, TextView var31, AppCompatTextView var32, ShapeableImageView var33) {
      super(var1, var2, var3);
      this.availableFilters = var4;
      this.bgFilterInfo = var5;
      this.btnBack = var6;
      this.btnBuy = var7;
      this.btnGetInstructions = var8;
      this.btnResetFilter = var9;
      this.btnVisit = var10;
      this.closeBtn = var11;
      this.contentContainer = var12;
      this.cvFilterLife = var13;
      this.cvReplaceFilter = var14;
      this.endGuideline = var15;
      this.filterList = var16;
      this.groupUserManual = var17;
      this.iconPlay = var18;
      this.ivInfo = var19;
      this.leadingIcon = var20;
      this.progressIndicator = var21;
      this.progressView = var22;
      this.scrollView = var23;
      this.startGuideline = var24;
      this.title = var25;
      this.tvChangeFilter = var26;
      this.tvFilterInfo = var27;
      this.tvFilterLife = var28;
      this.tvGuide = var29;
      this.tvHowReplace = var30;
      this.tvProgress = var31;
      this.tvSubtitle = var32;
      this.videoThumbnail = var33;
   }

   public static ActivityDeviceFilterDetailBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeviceFilterDetailBinding bind(View var0, Object var1) {
      return (ActivityDeviceFilterDetailBinding)bind(var1, var0, R.layout.activity_device_filter_detail);
   }

   public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDeviceFilterDetailBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_device_filter_detail, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDeviceFilterDetailBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_device_filter_detail, (ViewGroup)null, false, var1);
   }
}
