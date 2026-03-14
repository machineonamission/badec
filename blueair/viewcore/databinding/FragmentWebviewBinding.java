package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class FragmentWebviewBinding extends ViewDataBinding {
   public final ProgressBlockerView progressView;
   public final ConstraintLayout webContainer;
   public final WebView webView;

   protected FragmentWebviewBinding(Object var1, View var2, int var3, ProgressBlockerView var4, ConstraintLayout var5, WebView var6) {
      super(var1, var2, var3);
      this.progressView = var4;
      this.webContainer = var5;
      this.webView = var6;
   }

   public static FragmentWebviewBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentWebviewBinding bind(View var0, Object var1) {
      return (FragmentWebviewBinding)bind(var1, var0, R.layout.fragment_webview);
   }

   public static FragmentWebviewBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentWebviewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentWebviewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentWebviewBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_webview, var1, var2, var3);
   }

   @Deprecated
   public static FragmentWebviewBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentWebviewBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_webview, (ViewGroup)null, false, var1);
   }
}
