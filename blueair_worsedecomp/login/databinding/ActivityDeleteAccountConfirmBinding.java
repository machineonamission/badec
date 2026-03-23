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

public abstract class ActivityDeleteAccountConfirmBinding extends ViewDataBinding {
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnDelete;
    public final TextView description;
    public final ImageView icon;
    public final ProgressBlockerView loading;
    public final TextView notice;
    public final ScrollView scrollableRoot;
    public final MaterialToolbar toolbar;

    protected ActivityDeleteAccountConfirmBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, TextView textView, ImageView imageView, ProgressBlockerView progressBlockerView, TextView textView2, ScrollView scrollView, MaterialToolbar materialToolbar) {
        super(obj, view, i);
        this.btnClose = appCompatImageButton;
        this.btnDelete = materialButton;
        this.description = textView;
        this.icon = imageView;
        this.loading = progressBlockerView;
        this.notice = textView2;
        this.scrollableRoot = scrollView;
        this.toolbar = materialToolbar;
    }

    public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDeleteAccountConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_delete_account_confirm, viewGroup, z, obj);
    }

    public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDeleteAccountConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_delete_account_confirm, (ViewGroup) null, false, obj);
    }

    public static ActivityDeleteAccountConfirmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeleteAccountConfirmBinding bind(View view, Object obj) {
        return (ActivityDeleteAccountConfirmBinding) bind(obj, view, R.layout.activity_delete_account_confirm);
    }
}
