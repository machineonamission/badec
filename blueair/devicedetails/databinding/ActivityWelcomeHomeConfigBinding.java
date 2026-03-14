package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public abstract class ActivityWelcomeHomeConfigBinding extends ViewDataBinding {
   public final AppCompatImageButton btnBack;
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnDeleteHome;
   public final MaterialButton btnSave;
   public final ConstraintLayout clHome;
   public final MaterialCardView cvHome;
   public final AppCompatImageButton gpsBtn;
   public final Group groupLocationInfo;
   public final AppCompatImageView imInfo;
   public final AppCompatImageView ivWelcomeHome;
   public final LinearLayout llTransport;
   @Bindable
   protected CreateUpdateWelcomeHomeViewModel mVm;
   public final FrameLayout mapContainer;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   public final SimpleStatusBar statusBar;
   public final AppCompatTextView tvAddress;
   public final AppCompatTextView tvArriveDesp;
   public final AppCompatCheckBox tvBicycle;
   public final AppCompatCheckBox tvCar;
   public final AppCompatTextView tvCity;
   public final AppCompatCheckBox tvCommute;
   public final AppCompatTextView tvHowArrive;
   public final AppCompatTextView tvName;
   public final AppCompatTextView tvSearchOnMap;
   public final AppCompatCheckBox tvWalk;
   public final TextView tvWelcomeHome;

   protected ActivityWelcomeHomeConfigBinding(Object var1, View var2, int var3, AppCompatImageButton var4, AppCompatImageButton var5, MaterialButton var6, MaterialButton var7, ConstraintLayout var8, MaterialCardView var9, AppCompatImageButton var10, Group var11, AppCompatImageView var12, AppCompatImageView var13, LinearLayout var14, FrameLayout var15, ProgressBlockerView var16, ConstraintLayout var17, SimpleStatusBar var18, AppCompatTextView var19, AppCompatTextView var20, AppCompatCheckBox var21, AppCompatCheckBox var22, AppCompatTextView var23, AppCompatCheckBox var24, AppCompatTextView var25, AppCompatTextView var26, AppCompatTextView var27, AppCompatCheckBox var28, TextView var29) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnClose = var5;
      this.btnDeleteHome = var6;
      this.btnSave = var7;
      this.clHome = var8;
      this.cvHome = var9;
      this.gpsBtn = var10;
      this.groupLocationInfo = var11;
      this.imInfo = var12;
      this.ivWelcomeHome = var13;
      this.llTransport = var14;
      this.mapContainer = var15;
      this.progressView = var16;
      this.rootLayout = var17;
      this.statusBar = var18;
      this.tvAddress = var19;
      this.tvArriveDesp = var20;
      this.tvBicycle = var21;
      this.tvCar = var22;
      this.tvCity = var23;
      this.tvCommute = var24;
      this.tvHowArrive = var25;
      this.tvName = var26;
      this.tvSearchOnMap = var27;
      this.tvWalk = var28;
      this.tvWelcomeHome = var29;
   }

   public static ActivityWelcomeHomeConfigBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityWelcomeHomeConfigBinding bind(View var0, Object var1) {
      return (ActivityWelcomeHomeConfigBinding)bind(var1, var0, R.layout.activity_welcome_home_config);
   }

   public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityWelcomeHomeConfigBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_welcome_home_config, var1, var2, var3);
   }

   @Deprecated
   public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityWelcomeHomeConfigBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_welcome_home_config, (ViewGroup)null, false, var1);
   }

   public CreateUpdateWelcomeHomeViewModel getVm() {
      return this.mVm;
   }

   public abstract void setVm(CreateUpdateWelcomeHomeViewModel var1);
}
