package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class CardItemNotificationBinding implements ViewBinding {
   public final MaterialButton btnAdjust;
   public final MaterialButton btnBuyFilter;
   public final MaterialButton btnReplaceFilter;
   public final AppCompatImageView ivClose;
   public final AppCompatImageView ivDevice;
   public final View ivIndicator;
   private final ConstraintLayout rootView;
   public final AppCompatTextView tvDeviceName;
   public final AppCompatTextView tvMessage;
   public final AppCompatTextView tvState;

   private CardItemNotificationBinding(ConstraintLayout var1, MaterialButton var2, MaterialButton var3, MaterialButton var4, AppCompatImageView var5, AppCompatImageView var6, View var7, AppCompatTextView var8, AppCompatTextView var9, AppCompatTextView var10) {
      this.rootView = var1;
      this.btnAdjust = var2;
      this.btnBuyFilter = var3;
      this.btnReplaceFilter = var4;
      this.ivClose = var5;
      this.ivDevice = var6;
      this.ivIndicator = var7;
      this.tvDeviceName = var8;
      this.tvMessage = var9;
      this.tvState = var10;
   }

   public static CardItemNotificationBinding bind(View var0) {
      int var1 = R.id.btn_adjust;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.btn_buyFilter;
         MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.btn_replaceFilter;
            MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.iv_close;
               AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.iv_device;
                  AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.iv_indicator;
                     View var7 = ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.tv_deviceName;
                        AppCompatTextView var8 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.tv_message;
                           AppCompatTextView var10 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              var1 = R.id.tv_state;
                              AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 return new CardItemNotificationBinding((ConstraintLayout)var0, var4, var6, var2, var9, var3, var7, var8, var10, var5);
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

   public static CardItemNotificationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static CardItemNotificationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.card_item_notification, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
