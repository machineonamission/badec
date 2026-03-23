package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.viewmodel.NotificationsViewModel;

public abstract class ActivityNotificationsBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    @Bindable
    protected NotificationsViewModel mViewModel;
    public final RecyclerView rvList;
    public final AppCompatTextView tvDismissAll;
    public final AppCompatTextView tvIndoorDeviceNum;
    public final AppCompatTextView tvLabelNew;
    public final AppCompatTextView tvTitle;

    public abstract void setViewModel(NotificationsViewModel notificationsViewModel);

    protected ActivityNotificationsBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.rvList = recyclerView;
        this.tvDismissAll = appCompatTextView;
        this.tvIndoorDeviceNum = appCompatTextView2;
        this.tvLabelNew = appCompatTextView3;
        this.tvTitle = appCompatTextView4;
    }

    public NotificationsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityNotificationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNotificationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityNotificationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_notifications, viewGroup, z, obj);
    }

    public static ActivityNotificationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNotificationsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityNotificationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_notifications, (ViewGroup) null, false, obj);
    }

    public static ActivityNotificationsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNotificationsBinding bind(View view, Object obj) {
        return (ActivityNotificationsBinding) bind(obj, view, R.layout.activity_notifications);
    }
}
