package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ActivityInfoBinding extends ViewDataBinding {
    public final AppBarLayout appbar;
    public final TextView errorText;
    public final FrameLayout infoContainer;
    @Bindable
    protected HomeViewModel mHomeViewModel;
    public final Toolbar toolbar;

    public abstract void setHomeViewModel(HomeViewModel homeViewModel);

    protected ActivityInfoBinding(Object obj, View view, int i, AppBarLayout appBarLayout, TextView textView, FrameLayout frameLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.appbar = appBarLayout;
        this.errorText = textView;
        this.infoContainer = frameLayout;
        this.toolbar = toolbar2;
    }

    public HomeViewModel getHomeViewModel() {
        return this.mHomeViewModel;
    }

    public static ActivityInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_info, viewGroup, z, obj);
    }

    public static ActivityInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_info, (ViewGroup) null, false, obj);
    }

    public static ActivityInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoBinding bind(View view, Object obj) {
        return (ActivityInfoBinding) bind(obj, view, R.layout.activity_info);
    }
}
