package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityScheduleListBinding extends ViewDataBinding {
    public final LinearLayout bottomBar;
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnCreate;
    public final AppCompatImageButton btnMore;
    public final RecyclerView rvList;
    public final View separator;
    public final AppCompatTextView tvSubtitle;
    public final AppCompatTextView tvTitle;

    protected ActivityScheduleListBinding(Object obj, View view, int i, LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, AppCompatImageButton appCompatImageButton2, RecyclerView recyclerView, View view2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.bottomBar = linearLayout;
        this.btnBack = appCompatImageButton;
        this.btnCreate = materialButton;
        this.btnMore = appCompatImageButton2;
        this.rvList = recyclerView;
        this.separator = view2;
        this.tvSubtitle = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public static ActivityScheduleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityScheduleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityScheduleListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_schedule_list, viewGroup, z, obj);
    }

    public static ActivityScheduleListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityScheduleListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityScheduleListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_schedule_list, (ViewGroup) null, false, obj);
    }

    public static ActivityScheduleListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityScheduleListBinding bind(View view, Object obj) {
        return (ActivityScheduleListBinding) bind(obj, view, R.layout.activity_schedule_list);
    }
}
