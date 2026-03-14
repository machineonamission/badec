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

   protected IntegrationItemBinding(Object var1, View var2, int var3, MaterialButton var4, ConstraintLayout var5, View var6, TextView var7, TextView var8) {
      super(var1, var2, var3);
      this.btnLink = var4;
      this.integrationItemRoot = var5;
      this.separator = var6;
      this.summary = var7;
      this.title = var8;
   }

   public static IntegrationItemBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static IntegrationItemBinding bind(View var0, Object var1) {
      return (IntegrationItemBinding)bind(var1, var0, R.layout.integration_item);
   }

   public static IntegrationItemBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static IntegrationItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static IntegrationItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (IntegrationItemBinding)ViewDataBinding.inflateInternal(var0, R.layout.integration_item, var1, var2, var3);
   }

   @Deprecated
   public static IntegrationItemBinding inflate(LayoutInflater var0, Object var1) {
      return (IntegrationItemBinding)ViewDataBinding.inflateInternal(var0, R.layout.integration_item, (ViewGroup)null, false, var1);
   }
}
