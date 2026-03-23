package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.dd.ShadowLayout;

public abstract class HolderFilterTypeBinding extends ViewDataBinding {
    public final FrameLayout flIcon;
    public final AppCompatImageView icon;
    public final ImageView ivInfo;
    public final AppCompatTextView name;
    public final ShadowLayout slIcon;

    protected HolderFilterTypeBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ImageView imageView, AppCompatTextView appCompatTextView, ShadowLayout shadowLayout) {
        super(obj, view, i);
        this.flIcon = frameLayout;
        this.icon = appCompatImageView;
        this.ivInfo = imageView;
        this.name = appCompatTextView;
        this.slIcon = shadowLayout;
    }

    public static HolderFilterTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderFilterTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderFilterTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_filter_type, viewGroup, z, obj);
    }

    public static HolderFilterTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderFilterTypeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderFilterTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_filter_type, (ViewGroup) null, false, obj);
    }

    public static HolderFilterTypeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderFilterTypeBinding bind(View view, Object obj) {
        return (HolderFilterTypeBinding) bind(obj, view, R.layout.holder_filter_type);
    }
}
