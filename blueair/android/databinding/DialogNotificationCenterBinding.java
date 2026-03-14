package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.viewcore.databinding.StateLoadingFailedBinding;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;

public abstract class DialogNotificationCenterBinding extends ViewDataBinding {
   public final ImageButton closeButton;
   public final ConstraintLayout contentContainer;
   public final LinearLayout groupTypeAll;
   public final LinearLayout groupTypeProductAlerts;
   public final LinearLayout groupTypeProductAlertsLimit;
   public final TextView permissionPromptBar;
   public final ProgressBlockerView progressView;
   public final RecyclerView rvSettings;
   public final TextView screenTitle;
   public final StateLoadingFailedBinding stateLoadingFailed;
   public final SwitchCompat switchTypeAll;
   public final SwitchCompat switchTypeProductAlerts;
   public final TextView tvTypeAll;
   public final TextView tvTypeProductAlerts;
   public final TextView tvTypeProductAlertsLimit;

   protected DialogNotificationCenterBinding(Object var1, View var2, int var3, ImageButton var4, ConstraintLayout var5, LinearLayout var6, LinearLayout var7, LinearLayout var8, TextView var9, ProgressBlockerView var10, RecyclerView var11, TextView var12, StateLoadingFailedBinding var13, SwitchCompat var14, SwitchCompat var15, TextView var16, TextView var17, TextView var18) {
      super(var1, var2, var3);
      this.closeButton = var4;
      this.contentContainer = var5;
      this.groupTypeAll = var6;
      this.groupTypeProductAlerts = var7;
      this.groupTypeProductAlertsLimit = var8;
      this.permissionPromptBar = var9;
      this.progressView = var10;
      this.rvSettings = var11;
      this.screenTitle = var12;
      this.stateLoadingFailed = var13;
      this.switchTypeAll = var14;
      this.switchTypeProductAlerts = var15;
      this.tvTypeAll = var16;
      this.tvTypeProductAlerts = var17;
      this.tvTypeProductAlertsLimit = var18;
   }

   public static DialogNotificationCenterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogNotificationCenterBinding bind(View var0, Object var1) {
      return (DialogNotificationCenterBinding)bind(var1, var0, R.layout.dialog_notification_center);
   }

   public static DialogNotificationCenterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogNotificationCenterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogNotificationCenterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogNotificationCenterBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialog_notification_center, var1, var2, var3);
   }

   @Deprecated
   public static DialogNotificationCenterBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogNotificationCenterBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialog_notification_center, (ViewGroup)null, false, var1);
   }
}
