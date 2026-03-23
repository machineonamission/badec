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
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityPostDisableIotBinding extends ViewDataBinding {
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnOkay;
    public final TextView description;
    public final ImageView icon;
    public final ScrollView scrollableRoot;
    public final MaterialToolbar toolbar;

    protected ActivityPostDisableIotBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, TextView textView, ImageView imageView, ScrollView scrollView, MaterialToolbar materialToolbar) {
        super(obj, view, i);
        this.btnClose = appCompatImageButton;
        this.btnOkay = materialButton;
        this.description = textView;
        this.icon = imageView;
        this.scrollableRoot = scrollView;
        this.toolbar = materialToolbar;
    }

    public static ActivityPostDisableIotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPostDisableIotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityPostDisableIotBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_post_disable_iot, viewGroup, z, obj);
    }

    public static ActivityPostDisableIotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPostDisableIotBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityPostDisableIotBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_post_disable_iot, (ViewGroup) null, false, obj);
    }

    public static ActivityPostDisableIotBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPostDisableIotBinding bind(View view, Object obj) {
        return (ActivityPostDisableIotBinding) bind(obj, view, R.layout.activity_post_disable_iot);
    }
}
