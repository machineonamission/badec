package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityManageMyAccountBinding extends ViewDataBinding {
    public final ConstraintLayout deleteAccountCell;
    public final ImageView deleteAccountChevron;
    public final TextView deleteAccountSummary;
    public final TextView deleteAccountTitle;
    public final ScrollView scrollableRoot;
    public final MaterialToolbar toolbar;

    protected ActivityManageMyAccountBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ScrollView scrollView, MaterialToolbar materialToolbar) {
        super(obj, view, i);
        this.deleteAccountCell = constraintLayout;
        this.deleteAccountChevron = imageView;
        this.deleteAccountSummary = textView;
        this.deleteAccountTitle = textView2;
        this.scrollableRoot = scrollView;
        this.toolbar = materialToolbar;
    }

    public static ActivityManageMyAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityManageMyAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityManageMyAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_manage_my_account, viewGroup, z, obj);
    }

    public static ActivityManageMyAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityManageMyAccountBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityManageMyAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_manage_my_account, (ViewGroup) null, false, obj);
    }

    public static ActivityManageMyAccountBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityManageMyAccountBinding bind(View view, Object obj) {
        return (ActivityManageMyAccountBinding) bind(obj, view, R.layout.activity_manage_my_account);
    }
}
