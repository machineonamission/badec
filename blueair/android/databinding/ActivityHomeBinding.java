package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.yuyakaido.android.cardstackview.CardStackView;

public abstract class ActivityHomeBinding extends ViewDataBinding {
   public final ComposeView aqiAnimationBackground;
   public final AppCompatImageButton btnAdd;
   public final AppCompatImageButton btnMenu;
   public final TextView build;
   public final ConstraintLayout clDrawer;
   public final ConstraintLayout clHeader;
   public final LinearLayout contentContainer;
   public final CardStackView csNotification;
   public final AppCompatImageView drawerCloseView;
   public final DrawerLayout drawerLayout;
   public final MaterialButton drawerSignin;
   public final FrameLayout indoorContainer;
   public final AppCompatImageView ivLeading;
   public final LinearLayout llDrawerHeader;
   @Bindable
   protected HomeViewModel mHomeViewModel;
   public final NavigationView nvDrawer;
   public final FrameLayout outdoorContainer;
   public final RecyclerView rvDrawer;
   public final SimpleStatusBar statusBarDrawer;
   public final SwipeRefreshLayout swipeRefresh;
   public final ConstraintLayout toolbar;
   public final TextView tvIndoorAirState;
   public final AppCompatTextView tvIndoorDeviceNum;
   public final TextView tvIndoorLabel;
   public final AppCompatTextView tvMenu;
   public final AppCompatTextView tvName;

   protected ActivityHomeBinding(Object var1, View var2, int var3, ComposeView var4, AppCompatImageButton var5, AppCompatImageButton var6, TextView var7, ConstraintLayout var8, ConstraintLayout var9, LinearLayout var10, CardStackView var11, AppCompatImageView var12, DrawerLayout var13, MaterialButton var14, FrameLayout var15, AppCompatImageView var16, LinearLayout var17, NavigationView var18, FrameLayout var19, RecyclerView var20, SimpleStatusBar var21, SwipeRefreshLayout var22, ConstraintLayout var23, TextView var24, AppCompatTextView var25, TextView var26, AppCompatTextView var27, AppCompatTextView var28) {
      super(var1, var2, var3);
      this.aqiAnimationBackground = var4;
      this.btnAdd = var5;
      this.btnMenu = var6;
      this.build = var7;
      this.clDrawer = var8;
      this.clHeader = var9;
      this.contentContainer = var10;
      this.csNotification = var11;
      this.drawerCloseView = var12;
      this.drawerLayout = var13;
      this.drawerSignin = var14;
      this.indoorContainer = var15;
      this.ivLeading = var16;
      this.llDrawerHeader = var17;
      this.nvDrawer = var18;
      this.outdoorContainer = var19;
      this.rvDrawer = var20;
      this.statusBarDrawer = var21;
      this.swipeRefresh = var22;
      this.toolbar = var23;
      this.tvIndoorAirState = var24;
      this.tvIndoorDeviceNum = var25;
      this.tvIndoorLabel = var26;
      this.tvMenu = var27;
      this.tvName = var28;
   }

   public static ActivityHomeBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityHomeBinding bind(View var0, Object var1) {
      return (ActivityHomeBinding)bind(var1, var0, R.layout.activity_home);
   }

   public static ActivityHomeBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityHomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityHomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityHomeBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_home, var1, var2, var3);
   }

   @Deprecated
   public static ActivityHomeBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityHomeBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_home, (ViewGroup)null, false, var1);
   }

   public HomeViewModel getHomeViewModel() {
      return this.mHomeViewModel;
   }

   public abstract void setHomeViewModel(HomeViewModel var1);
}
