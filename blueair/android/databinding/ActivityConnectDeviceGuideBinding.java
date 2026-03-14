package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class ActivityConnectDeviceGuideBinding implements ViewBinding {
   public final MaterialButton btnSearchFor;
   public final AppCompatButton btnSkip;
   public final AppCompatImageView icBluetooth;
   public final AppCompatImageView ivBack;
   public final AppCompatImageView ivClose;
   private final ConstraintLayout rootView;
   public final TextView tvContent;
   public final TextView tvLabel;
   public final AppCompatTextView tvTitle;

   private ActivityConnectDeviceGuideBinding(ConstraintLayout var1, MaterialButton var2, AppCompatButton var3, AppCompatImageView var4, AppCompatImageView var5, AppCompatImageView var6, TextView var7, TextView var8, AppCompatTextView var9) {
      this.rootView = var1;
      this.btnSearchFor = var2;
      this.btnSkip = var3;
      this.icBluetooth = var4;
      this.ivBack = var5;
      this.ivClose = var6;
      this.tvContent = var7;
      this.tvLabel = var8;
      this.tvTitle = var9;
   }

   public static ActivityConnectDeviceGuideBinding bind(View var0) {
      int var1 = R.id.btn_searchFor;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btnSkip;
         AppCompatButton var2 = (AppCompatButton)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.ic_bluetooth;
            AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var9 != null) {
               var1 = R.id.iv_back;
               AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.iv_close;
                  AppCompatImageView var6 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.tv_content;
                     TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.tv_label;
                        TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.tv_title;
                           AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var4 != null) {
                              return new ActivityConnectDeviceGuideBinding((ConstraintLayout)var0, var3, var2, var9, var5, var6, var8, var7, var4);
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

   public static ActivityConnectDeviceGuideBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityConnectDeviceGuideBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_connect_device_guide, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
