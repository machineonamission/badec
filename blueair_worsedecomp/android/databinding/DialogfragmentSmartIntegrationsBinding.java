package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;

public abstract class DialogfragmentSmartIntegrationsBinding extends ViewDataBinding {
    public final RecyclerView recyclerViewDevices;
    public final LinearLayout rootLayout;
    public final TextView screenTitle;
    public final Toolbar toolbar;

    protected DialogfragmentSmartIntegrationsBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView, Toolbar toolbar2) {
        super(obj, view, i);
        this.recyclerViewDevices = recyclerView;
        this.rootLayout = linearLayout;
        this.screenTitle = textView;
        this.toolbar = toolbar2;
    }

    public static DialogfragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentSmartIntegrationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_smart_integrations, viewGroup, z, obj);
    }

    public static DialogfragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentSmartIntegrationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_smart_integrations, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentSmartIntegrationsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSmartIntegrationsBinding bind(View view, Object obj) {
        return (DialogfragmentSmartIntegrationsBinding) bind(obj, view, R.layout.dialogfragment_smart_integrations);
    }
}
