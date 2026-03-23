package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bin.david.form.core.SmartTable;
import com.blueair.android.R;

public abstract class ActivityInfoDetailBinding extends ViewDataBinding {
    public final View borderBottom;
    public final View borderEnd;
    public final View borderStart;
    public final AppCompatImageButton btnBack;
    public final SmartTable tableView;
    public final TextView tvPeriods;
    public final AppCompatTextView tvTitle;

    protected ActivityInfoDetailBinding(Object obj, View view, int i, View view2, View view3, View view4, AppCompatImageButton appCompatImageButton, SmartTable smartTable, TextView textView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.borderBottom = view2;
        this.borderEnd = view3;
        this.borderStart = view4;
        this.btnBack = appCompatImageButton;
        this.tableView = smartTable;
        this.tvPeriods = textView;
        this.tvTitle = appCompatTextView;
    }

    public static ActivityInfoDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityInfoDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_info_detail, viewGroup, z, obj);
    }

    public static ActivityInfoDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityInfoDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_info_detail, (ViewGroup) null, false, obj);
    }

    public static ActivityInfoDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInfoDetailBinding bind(View view, Object obj) {
        return (ActivityInfoDetailBinding) bind(obj, view, R.layout.activity_info_detail);
    }
}
