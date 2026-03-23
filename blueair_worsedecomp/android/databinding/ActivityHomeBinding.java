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

    public abstract void setHomeViewModel(HomeViewModel homeViewModel);

    protected ActivityHomeBinding(Object obj, View view, int i, ComposeView composeView, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, TextView textView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, CardStackView cardStackView, AppCompatImageView appCompatImageView, DrawerLayout drawerLayout2, MaterialButton materialButton, FrameLayout frameLayout, AppCompatImageView appCompatImageView2, LinearLayout linearLayout2, NavigationView navigationView, FrameLayout frameLayout2, RecyclerView recyclerView, SimpleStatusBar simpleStatusBar, SwipeRefreshLayout swipeRefreshLayout, ConstraintLayout constraintLayout3, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.aqiAnimationBackground = composeView;
        this.btnAdd = appCompatImageButton;
        this.btnMenu = appCompatImageButton2;
        this.build = textView;
        this.clDrawer = constraintLayout;
        this.clHeader = constraintLayout2;
        this.contentContainer = linearLayout;
        this.csNotification = cardStackView;
        this.drawerCloseView = appCompatImageView;
        this.drawerLayout = drawerLayout2;
        this.drawerSignin = materialButton;
        this.indoorContainer = frameLayout;
        this.ivLeading = appCompatImageView2;
        this.llDrawerHeader = linearLayout2;
        this.nvDrawer = navigationView;
        this.outdoorContainer = frameLayout2;
        this.rvDrawer = recyclerView;
        this.statusBarDrawer = simpleStatusBar;
        this.swipeRefresh = swipeRefreshLayout;
        this.toolbar = constraintLayout3;
        this.tvIndoorAirState = textView2;
        this.tvIndoorDeviceNum = appCompatTextView;
        this.tvIndoorLabel = textView3;
        this.tvMenu = appCompatTextView2;
        this.tvName = appCompatTextView3;
    }

    public HomeViewModel getHomeViewModel() {
        return this.mHomeViewModel;
    }

    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_home, viewGroup, z, obj);
    }

    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_home, (ViewGroup) null, false, obj);
    }

    public static ActivityHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding bind(View view, Object obj) {
        return (ActivityHomeBinding) bind(obj, view, R.layout.activity_home);
    }
}
