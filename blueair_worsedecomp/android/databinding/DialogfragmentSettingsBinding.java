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

    public abstract void setHomeViewModel(HomeViewModel homeViewModel);

    protected DialogfragmentSettingsBinding(Object obj, View view, int i, ImageButton imageButton, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, View view2, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView3, View view3, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.closeBtn = imageButton;
        this.itemLicense = linearLayout;
        this.itemNotification = linearLayout2;
        this.itemTempSetting = linearLayout3;
        this.licenseArrow = appCompatImageView;
        this.notificationArrow = appCompatImageView2;
        this.notificationSeparator = view2;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout;
        this.tempArrow = appCompatImageView3;
        this.tempSeparator = view3;
        this.title = textView;
        this.titleBarContainer = constraintLayout2;
        this.tvLicense = textView2;
        this.tvNotification = textView3;
        this.tvTempTitle = textView4;
        this.tvTempUnit = textView5;
    }

    public HomeViewModel getHomeViewModel() {
        return this.mHomeViewModel;
    }

    public static DialogfragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_settings, viewGroup, z, obj);
    }

    public static DialogfragmentSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_settings, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSettingsBinding bind(View view, Object obj) {
        return (DialogfragmentSettingsBinding) bind(obj, view, R.layout.dialogfragment_settings);
    }
}
