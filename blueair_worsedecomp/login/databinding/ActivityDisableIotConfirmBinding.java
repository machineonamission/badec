package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityDisableIotConfirmBinding extends ViewDataBinding {
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnDelete;
    public final TextView description;
    public final ImageView icon;
    public final ProgressBlockerView loading;
    public final ScrollView scrollableRoot;
    public final MaterialToolbar toolbar;

    protected ActivityDisableIotConfirmBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, TextView textView, ImageView imageView, ProgressBlockerView progressBlockerView, ScrollView scrollView, MaterialToolbar materialToolbar) {
        super(obj, view, i);
        this.btnClose = appCompatImageButton;
        this.btnDelete = materialButton;
        this.description = textView;
        this.icon = imageView;
        this.loading = progressBlockerView;
        this.scrollableRoot = scrollView;
        this.toolbar = materialToolbar;
    }

    public static ActivityDisableIotConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDisableIotConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDisableIotConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_disable_iot_confirm, viewGroup, z, obj);
    }

    public static ActivityDisableIotConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDisableIotConfirmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDisableIotConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_disable_iot_confirm, (ViewGroup) null, false, obj);
    }

    public static ActivityDisableIotConfirmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDisableIotConfirmBinding bind(View view, Object obj) {
        return (ActivityDisableIotConfirmBinding) bind(obj, view, R.layout.activity_disable_iot_confirm);
    }
}
