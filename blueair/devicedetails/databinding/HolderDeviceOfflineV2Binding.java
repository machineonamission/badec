package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceOfflineV2Binding implements ViewBinding {
   public final Button closeBtn;
   public final ConstraintLayout contentContainer;
   public final ImageView leadingIcon;
   public final TextView message;
   private final ConstraintLayout rootView;
   public final TextView title;
   public final Button troubleshootBtn;

   private HolderDeviceOfflineV2Binding(ConstraintLayout var1, Button var2, ConstraintLayout var3, ImageView var4, TextView var5, TextView var6, Button var7) {
      this.rootView = var1;
      this.closeBtn = var2;
      this.contentContainer = var3;
      this.leadingIcon = var4;
      this.message = var5;
      this.title = var6;
      this.troubleshootBtn = var7;
   }

   public static HolderDeviceOfflineV2Binding bind(View var0) {
      int var1 = R.id.close_btn;
      Button var2 = (Button)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         ConstraintLayout var3 = (ConstraintLayout)var0;
         var1 = R.id.leading_icon;
         ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.message;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.title;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.troubleshoot_btn;
                  Button var4 = (Button)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     return new HolderDeviceOfflineV2Binding(var3, var2, var3, var7, var5, var6, var4);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceOfflineV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceOfflineV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_offline_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
