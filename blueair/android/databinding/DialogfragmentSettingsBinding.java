package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class DialogfragmentSettingsBinding extends ViewDataBinding {
   public final ImageButton closeBtn;
   public final LinearLayout itemLicense;
   public final LinearLayout itemNotification;
   public final LinearLayout itemTempSetting;
   public final AppCompatImageView licenseArrow;
   @Bindable
   protected HomeViewModel mHomeViewModel;
   public final AppCompatImageView notificationArrow;
   public final View notificationSeparator;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   public final AppCompatImageView tempArrow;
   public final View tempSeparator;
   public final TextView title;
   public final ConstraintLayout titleBarContainer;
   public final TextView tvLicense;
   public final TextView tvNotification;
   public final TextView tvTempTitle;
   public final TextView tvTempUnit;

   protected DialogfragmentSettingsBinding(Object var1, View var2, int var3, ImageButton var4, LinearLayout var5, LinearLayout var6, LinearLayout var7, AppCompatImageView var8, AppCompatImageView var9, View var10, ProgressBlockerView var11, ConstraintLayout var12, AppCompatImageView var13, View var14, TextView var15, ConstraintLayout var16, TextView var17, TextView var18, TextView var19, TextView var20) {
      super(var1, var2, var3);
      this.closeBtn = var4;
      this.itemLicense = var5;
      this.itemNotification = var6;
      this.itemTempSetting = var7;
      this.licenseArrow = var8;
      this.notificationArrow = var9;
      this.notificationSeparator = var10;
      this.progressView = var11;
      this.rootLayout = var12;
      this.tempArrow = var13;
      this.tempSeparator = var14;
      this.title = var15;
      this.titleBarContainer = var16;
      this.tvLicense = var17;
      this.tvNotification = var18;
      this.tvTempTitle = var19;
      this.tvTempUnit = var20;
   }

   public static DialogfragmentSettingsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentSettingsBinding bind(View var0, Object var1) {
      return (DialogfragmentSettingsBinding)bind(var1, var0, R.layout.dialogfragment_settings);
   }

   public static DialogfragmentSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_settings, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentSettingsBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_settings, (ViewGroup)null, false, var1);
   }

   public HomeViewModel getHomeViewModel() {
      return this.mHomeViewModel;
   }

   public abstract void setHomeViewModel(HomeViewModel var1);
}
