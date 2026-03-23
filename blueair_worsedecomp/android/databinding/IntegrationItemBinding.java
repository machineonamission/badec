package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public abstract class IntegrationItemBinding extends ViewDataBinding {
    public final MaterialButton btnLink;
    public final ConstraintLayout integrationItemRoot;
    public final View separator;
    public final TextView summary;
    public final TextView title;

    protected IntegrationItemBinding(Object obj, View view, int i, MaterialButton materialButton, ConstraintLayout constraintLayout, View view2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnLink = materialButton;
        this.integrationItemRoot = constraintLayout;
        this.separator = view2;
        this.summary = textView;
        this.title = textView2;
    }

    public static IntegrationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IntegrationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IntegrationItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.integration_item, viewGroup, z, obj);
    }

    public static IntegrationItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IntegrationItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IntegrationItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.integration_item, (ViewGroup) null, false, obj);
    }

    public static IntegrationItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static IntegrationItemBinding bind(View view, Object obj) {
        return (IntegrationItemBinding) bind(obj, view, R.layout.integration_item);
    }
}
