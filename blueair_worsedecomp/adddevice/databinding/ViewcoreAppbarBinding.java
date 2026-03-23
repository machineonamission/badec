package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public abstract class ViewcoreAppbarBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton btnClose;
    public final AppCompatTextView headerMsg;
    public final ConstraintLayout headerRoot;
    public final AppCompatTextView headerTitle;
    public final LinearProgressIndicator progressIndicator;

    protected ViewcoreAppbarBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, LinearProgressIndicator linearProgressIndicator) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.btnClose = appCompatImageButton2;
        this.headerMsg = appCompatTextView;
        this.headerRoot = constraintLayout;
        this.headerTitle = appCompatTextView2;
        this.progressIndicator = linearProgressIndicator;
    }

    public static ViewcoreAppbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewcoreAppbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewcoreAppbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.viewcore_appbar, viewGroup, z, obj);
    }

    public static ViewcoreAppbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewcoreAppbarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewcoreAppbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.viewcore_appbar, (ViewGroup) null, false, obj);
    }

    public static ViewcoreAppbarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewcoreAppbarBinding bind(View view, Object obj) {
        return (ViewcoreAppbarBinding) bind(obj, view, R.layout.viewcore_appbar);
    }
}
