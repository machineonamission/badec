package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceFilterOrWickStatusBinding implements ViewBinding {
   public final MaterialButton buyNew;
   public final TextView expiredText;
   public final FrameLayout holderDeviceHWickStatus;
   public final MaterialButton howToReplace;
   public final ImageView iconLeft;
   public final TextView lifetime;
   public final TextView lifetimeValue;
   public final LinearProgressIndicator progressBar;
   private final FrameLayout rootView;
   public final TextView title;

   private HolderDeviceFilterOrWickStatusBinding(FrameLayout var1, MaterialButton var2, TextView var3, FrameLayout var4, MaterialButton var5, ImageView var6, TextView var7, TextView var8, LinearProgressIndicator var9, TextView var10) {
      this.rootView = var1;
      this.buyNew = var2;
      this.expiredText = var3;
      this.holderDeviceHWickStatus = var4;
      this.howToReplace = var5;
      this.iconLeft = var6;
      this.lifetime = var7;
      this.lifetimeValue = var8;
      this.progressBar = var9;
      this.title = var10;
   }

   public static HolderDeviceFilterOrWickStatusBinding bind(View var0) {
      int var1 = R.id.buy_new;
      MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.expiredText;
         TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            FrameLayout var2 = (FrameLayout)var0;
            var1 = R.id.how_to_replace;
            MaterialButton var9 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var9 != null) {
               var1 = R.id.icon_left;
               ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.lifetime;
                  TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.lifetime_value;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.progress_bar;
                        LinearProgressIndicator var6 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.title;
                           TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              return new HolderDeviceFilterOrWickStatusBinding(var2, var7, var5, var2, var9, var3, var8, var4, var6, var10);
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

   public static HolderDeviceFilterOrWickStatusBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFilterOrWickStatusBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_filter_or_wick_status, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
