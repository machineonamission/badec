package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class ActivityAccountLinkingBinding implements ViewBinding {
   public final AppCompatTextView body;
   public final MaterialButton btnAllow;
   public final MaterialButton btnNotNow;
   public final AppCompatImageView imgError;
   public final AppCompatImageView imgLogo;
   public final ProgressBlockerView loading;
   private final FrameLayout rootView;
   public final AppCompatTextView subtitle;
   public final AppCompatTextView title;
   public final AppCompatTextView txtAllowDescription;

   private ActivityAccountLinkingBinding(FrameLayout var1, AppCompatTextView var2, MaterialButton var3, MaterialButton var4, AppCompatImageView var5, AppCompatImageView var6, ProgressBlockerView var7, AppCompatTextView var8, AppCompatTextView var9, AppCompatTextView var10) {
      this.rootView = var1;
      this.body = var2;
      this.btnAllow = var3;
      this.btnNotNow = var4;
      this.imgError = var5;
      this.imgLogo = var6;
      this.loading = var7;
      this.subtitle = var8;
      this.title = var9;
      this.txtAllowDescription = var10;
   }

   public static ActivityAccountLinkingBinding bind(View var0) {
      int var1 = R.id.body;
      AppCompatTextView var10 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.btnAllow;
         MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.btnNotNow;
            MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.imgError;
               AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.imgLogo;
                  AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var2 != null) {
                     var1 = R.id.loading;
                     ProgressBlockerView var6 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.subtitle;
                        AppCompatTextView var8 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.title;
                           AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.txtAllowDescription;
                              AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 return new ActivityAccountLinkingBinding((FrameLayout)var0, var10, var7, var5, var3, var2, var6, var8, var9, var4);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityAccountLinkingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityAccountLinkingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_account_linking, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
