package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public abstract class ActivityDeviceReplaceFilterBinding extends ViewDataBinding {
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnResetFilter;
   public final AppCompatImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final Guideline endGuideline;
   public final Group groupUserManual;
   public final AppCompatImageButton iconPlay;
   public final AppCompatImageView ivUserManual;
   public final ProgressBlockerView progressView;
   public final ScrollView scrollView;
   public final ShadowLayout slReplaceFilter;
   public final ShadowLayout slUserManual;
   public final Guideline startGuideline;
   public final AppCompatTextView title;
   public final AppCompatTextView tvManualInfo;
   public final TextView tvReadManual;
   public final AppCompatTextView tvSubtitle;
   public final AppCompatTextView tvUserManual;
   public final TextView tvWatchVideo;
   public final TextView videoSummary;
   public final ShapeableImageView videoThumbnail;
   public final TextView whyIsThisImportant;

   protected ActivityDeviceReplaceFilterBinding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, AppCompatImageButton var6, ConstraintLayout var7, Guideline var8, Group var9, AppCompatImageButton var10, AppCompatImageView var11, ProgressBlockerView var12, ScrollView var13, ShadowLayout var14, ShadowLayout var15, Guideline var16, AppCompatTextView var17, AppCompatTextView var18, TextView var19, AppCompatTextView var20, AppCompatTextView var21, TextView var22, TextView var23, ShapeableImageView var24, TextView var25) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnResetFilter = var5;
      this.closeBtn = var6;
      this.contentContainer = var7;
      this.endGuideline = var8;
      this.groupUserManual = var9;
      this.iconPlay = var10;
      this.ivUserManual = var11;
      this.progressView = var12;
      this.scrollView = var13;
      this.slReplaceFilter = var14;
      this.slUserManual = var15;
      this.startGuideline = var16;
      this.title = var17;
      this.tvManualInfo = var18;
      this.tvReadManual = var19;
      this.tvSubtitle = var20;
      this.tvUserManual = var21;
      this.tvWatchVideo = var22;
      this.videoSummary = var23;
      this.videoThumbnail = var24;
      this.whyIsThisImportant = var25;
   }

   public static ActivityDeviceReplaceFilterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeviceReplaceFilterBinding bind(View var0, Object var1) {
      return (ActivityDeviceReplaceFilterBinding)bind(var1, var0, R.layout.activity_device_replace_filter);
   }

   public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDeviceReplaceFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_device_replace_filter, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDeviceReplaceFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_device_replace_filter, (ViewGroup)null, false, var1);
   }
}
