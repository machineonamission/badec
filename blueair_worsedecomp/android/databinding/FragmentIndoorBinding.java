package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.viewmodel.IndoorViewModel;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentIndoorBinding extends ViewDataBinding {
    public final MaterialButton btnAddProduct;
    public final ConstraintLayout emptyLayout;
    public final AppCompatImageView ivAddFooter;
    public final ImageView ivAlarm;
    public final ConstraintLayout layoutMain;
    public final RecyclerView listDevices;
    @Bindable
    protected IndoorViewModel mIndoorViewModel;
    public final ShadowLayout slAlarm;
    public final AppCompatTextView textEmptyTitle;
    public final TextView tvAlarmLabel;
    public final TextView tvAlarmValue;

    public abstract void setIndoorViewModel(IndoorViewModel indoorViewModel);

    protected FragmentIndoorBinding(Object obj, View view, int i, MaterialButton materialButton, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ImageView imageView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ShadowLayout shadowLayout, AppCompatTextView appCompatTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnAddProduct = materialButton;
        this.emptyLayout = constraintLayout;
        this.ivAddFooter = appCompatImageView;
        this.ivAlarm = imageView;
        this.layoutMain = constraintLayout2;
        this.listDevices = recyclerView;
        this.slAlarm = shadowLayout;
        this.textEmptyTitle = appCompatTextView;
        this.tvAlarmLabel = textView;
        this.tvAlarmValue = textView2;
    }

    public IndoorViewModel getIndoorViewModel() {
        return this.mIndoorViewModel;
    }

    public static FragmentIndoorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentIndoorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentIndoorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_indoor, viewGroup, z, obj);
    }

    public static FragmentIndoorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentIndoorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentIndoorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_indoor, (ViewGroup) null, false, obj);
    }

    public static FragmentIndoorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentIndoorBinding bind(View view, Object obj) {
        return (FragmentIndoorBinding) bind(obj, view, R.layout.fragment_indoor);
    }
}
