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

   protected FragmentSmartIntegrationsBinding(Object var1, View var2, int var3, RecyclerView var4, ProgressBlockerView var5, TextView var6) {
      super(var1, var2, var3);
      this.integrationsRecycler = var4;
      this.loading = var5;
      this.txtNoIntegrations = var6;
   }

   public static FragmentSmartIntegrationsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentSmartIntegrationsBinding bind(View var0, Object var1) {
      return (FragmentSmartIntegrationsBinding)bind(var1, var0, R.layout.fragment_smart_integrations);
   }

   public static FragmentSmartIntegrationsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentSmartIntegrationsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentSmartIntegrationsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentSmartIntegrationsBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_smart_integrations, var1, var2, var3);
   }

   @Deprecated
   public static FragmentSmartIntegrationsBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentSmartIntegrationsBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_smart_integrations, (ViewGroup)null, false, var1);
   }
}
