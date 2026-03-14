package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceFilterV2Binding implements ViewBinding {
   public final MaterialButton btnBuy;
   public final MaterialButton btnReplace;
   public final ConstraintLayout contentContainer;
   public final Group groupLife;
   public final Group groupProgress;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   public final LinearProgressIndicator progressIndicator;
   public final AppCompatTextView progressText;
   private final ConstraintLayout rootView;
   public final TextView title;

   private HolderDeviceFilterV2Binding(ConstraintLayout var1, MaterialButton var2, MaterialButton var3, ConstraintLayout var4, Group var5, Group var6, ImageView var7, ImageView var8, LinearProgressIndicator var9, AppCompatTextView var10, TextView var11) {
      this.rootView = var1;
      this.btnBuy = var2;
      this.btnReplace = var3;
      this.contentContainer = var4;
      this.groupLife = var5;
      this.groupProgress = var6;
      this.ivInfo = var7;
      this.leadingIcon = var8;
      this.progressIndicator = var9;
      this.progressText = var10;
      this.title = var11;
   }

   public static HolderDeviceFilterV2Binding bind(View var0) {
      int var1 = R.id.btn_buy;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btn_replace;
         MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            ConstraintLayout var8 = (ConstraintLayout)var0;
            var1 = R.id.group_life;
            Group var11 = (Group)ViewBindings.findChildViewById(var0, var1);
            if (var11 != null) {
               var1 = R.id.group_progress;
               Group var5 = (Group)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.iv_info;
                  ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.leading_icon;
                     ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.progress_indicator;
                        LinearProgressIndicator var2 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           var1 = R.id.progress_text;
                           AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.title;
                              TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 return new HolderDeviceFilterV2Binding(var8, var3, var7, var8, var11, var5, var4, var6, var2, var9, var10);
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

   public static HolderDeviceFilterV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFilterV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_filter_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
