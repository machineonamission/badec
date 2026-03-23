package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class FragmentSmartIntegrationsBinding extends ViewDataBinding {
    public final RecyclerView integrationsRecycler;
    public final ProgressBlockerView loading;
    public final TextView txtNoIntegrations;

    protected FragmentSmartIntegrationsBinding(Object obj, View view, int i, RecyclerView recyclerView, ProgressBlockerView progressBlockerView, TextView textView) {
        super(obj, view, i);
        this.integrationsRecycler = recyclerView;
        this.loading = progressBlockerView;
        this.txtNoIntegrations = textView;
    }

    public static FragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSmartIntegrationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_smart_integrations, viewGroup, z, obj);
    }

    public static FragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSmartIntegrationsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSmartIntegrationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_smart_integrations, (ViewGroup) null, false, obj);
    }

    public static FragmentSmartIntegrationsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSmartIntegrationsBinding bind(View view, Object obj) {
        return (FragmentSmartIntegrationsBinding) bind(obj, view, R.layout.fragment_smart_integrations);
    }
}
