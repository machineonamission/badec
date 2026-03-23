package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public abstract class DialogfragmentDeviceFilterSelectionBinding extends ViewDataBinding {
    public final ImageButton btnLeft;
    public final ImageButton btnRight;
    public final MaterialButton buttonSave;
    public final ScrollingPagerIndicator dotsIndicator;
    public final ViewPager2 filterPager;
    @Bindable
    protected DeviceDetailsViewModel mDeviceDetailViewModel;
    public final ConstraintLayout pagerRootLayout;
    public final ProgressBlockerView progressView;
    public final CoordinatorLayout rootLayout;
    public final TextView title;
    public final Toolbar toolbar;

    public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel deviceDetailsViewModel);

    protected DialogfragmentDeviceFilterSelectionBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, MaterialButton materialButton, ScrollingPagerIndicator scrollingPagerIndicator, ViewPager2 viewPager2, ConstraintLayout constraintLayout, ProgressBlockerView progressBlockerView, CoordinatorLayout coordinatorLayout, TextView textView, Toolbar toolbar2) {
        super(obj, view, i);
        this.btnLeft = imageButton;
        this.btnRight = imageButton2;
        this.buttonSave = materialButton;
        this.dotsIndicator = scrollingPagerIndicator;
        this.filterPager = viewPager2;
        this.pagerRootLayout = constraintLayout;
        this.progressView = progressBlockerView;
        this.rootLayout = coordinatorLayout;
        this.title = textView;
        this.toolbar = toolbar2;
    }

    public DeviceDetailsViewModel getDeviceDetailViewModel() {
        return this.mDeviceDetailViewModel;
    }

    public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceFilterSelectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_filter_selection, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceFilterSelectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_filter_selection, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceFilterSelectionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceFilterSelectionBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceFilterSelectionBinding) bind(obj, view, R.layout.dialogfragment_device_filter_selection);
    }
}
