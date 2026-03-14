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

   protected ViewcoreAppbarBinding(Object var1, View var2, int var3, AppCompatImageButton var4, AppCompatImageButton var5, AppCompatTextView var6, ConstraintLayout var7, AppCompatTextView var8, LinearProgressIndicator var9) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnClose = var5;
      this.headerMsg = var6;
      this.headerRoot = var7;
      this.headerTitle = var8;
      this.progressIndicator = var9;
   }

   public static ViewcoreAppbarBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ViewcoreAppbarBinding bind(View var0, Object var1) {
      return (ViewcoreAppbarBinding)bind(var1, var0, R.layout.viewcore_appbar);
   }

   public static ViewcoreAppbarBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ViewcoreAppbarBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ViewcoreAppbarBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ViewcoreAppbarBinding)ViewDataBinding.inflateInternal(var0, R.layout.viewcore_appbar, var1, var2, var3);
   }

   @Deprecated
   public static ViewcoreAppbarBinding inflate(LayoutInflater var0, Object var1) {
      return (ViewcoreAppbarBinding)ViewDataBinding.inflateInternal(var0, R.layout.viewcore_appbar, (ViewGroup)null, false, var1);
   }
}
