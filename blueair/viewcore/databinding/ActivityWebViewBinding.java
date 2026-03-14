package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.appbar.AppBarLayout;

public final class ActivityWebViewBinding implements ViewBinding {
   public final AppBarLayout appbar;
   public final FrameLayout container;
   private final CoordinatorLayout rootView;
   public final Toolbar toolbar;

   private ActivityWebViewBinding(CoordinatorLayout var1, AppBarLayout var2, FrameLayout var3, Toolbar var4) {
      this.rootView = var1;
      this.appbar = var2;
      this.container = var3;
      this.toolbar = var4;
   }

   public static ActivityWebViewBinding bind(View var0) {
      int var1 = R.id.appbar;
      AppBarLayout var3 = (AppBarLayout)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.container;
         FrameLayout var4 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.toolbar;
            Toolbar var2 = (Toolbar)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new ActivityWebViewBinding((CoordinatorLayout)var0, var3, var4, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityWebViewBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityWebViewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_web_view, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public CoordinatorLayout getRoot() {
      return this.rootView;
   }
}
