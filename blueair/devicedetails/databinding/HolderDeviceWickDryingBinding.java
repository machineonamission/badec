package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceWickDryingBinding implements ViewBinding {
   public final MaterialButton btnHigh;
   public final MaterialButton btnLow;
   public final ConstraintLayout contentContainer;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   public final LinearProgressIndicator progressIndicator;
   private final ShadowLayout rootView;
   public final ShadowLayout slContainer;
   public final AppCompatTextView title;
   public final AppCompatTextView tvDuration;
   public final AppCompatTextView tvLeft;

   private HolderDeviceWickDryingBinding(ShadowLayout var1, MaterialButton var2, MaterialButton var3, ConstraintLayout var4, SwitchCompat var5, Group var6, ImageView var7, ImageView var8, LinearProgressIndicator var9, ShadowLayout var10, AppCompatTextView var11, AppCompatTextView var12, AppCompatTextView var13) {
      this.rootView = var1;
      this.btnHigh = var2;
      this.btnLow = var3;
      this.contentContainer = var4;
      this.expendSwitch = var5;
      this.expendedContent = var6;
      this.ivInfo = var7;
      this.leadingIcon = var8;
      this.progressIndicator = var9;
      this.slContainer = var10;
      this.title = var11;
      this.tvDuration = var12;
      this.tvLeft = var13;
   }

   public static HolderDeviceWickDryingBinding bind(View var0) {
      int var1 = R.id.btn_high;
      MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var11 != null) {
         var1 = R.id.btn_low;
         MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.content_container;
            ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.expend_switch;
               SwitchCompat var5 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.expended_content;
                  Group var13 = (Group)ViewBindings.findChildViewById(var0, var1);
                  if (var13 != null) {
                     var1 = R.id.iv_info;
                     ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.leading_icon;
                        ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.progress_indicator;
                           LinearProgressIndicator var9 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              ShadowLayout var3 = (ShadowLayout)var0;
                              var1 = R.id.title;
                              AppCompatTextView var10 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 var1 = R.id.tv_duration;
                                 AppCompatTextView var2 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var2 != null) {
                                    var1 = R.id.tv_left;
                                    AppCompatTextView var12 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       return new HolderDeviceWickDryingBinding(var3, var11, var4, var7, var5, var13, var8, var6, var9, var3, var10, var2, var12);
                                    }
                                 }
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

   public static HolderDeviceWickDryingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceWickDryingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_wick_drying, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
