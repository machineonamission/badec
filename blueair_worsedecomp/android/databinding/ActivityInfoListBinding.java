package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;

public abstract class ActivityInfoListBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final ShadowedRecyclerViewLayout srvList;
    public final AppCompatTextView tvTitle;

    protected ActivityInfoListBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, ShadowedRecyclerViewLayout shadowedRecyclerViewLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.srvList = shadowedRecyclerViewLayout;
        this.tvTitle = appCompatTextView;
    }

    public static ActivityInfoListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityInfoListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_info_list, viewGroup, z, obj);
    }

    public static ActivityInfoListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityInfoListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_info_list, (ViewGroup) null, false, obj);
    }

    public static ActivityInfoListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoListBinding bind(View view, Object obj) {
        return (ActivityInfoListBinding) bind(obj, view, R.layout.activity_info_list);
    }
}
