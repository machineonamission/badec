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

public final class HolderDeviceMsgBinding implements ViewBinding {
   public final Button closeBtn;
   public final ConstraintLayout contentContainer;
   public final ImageView leadingIcon;
   public final TextView message;
   private final ConstraintLayout rootView;
   public final TextView title;

   private HolderDeviceMsgBinding(ConstraintLayout var1, Button var2, ConstraintLayout var3, ImageView var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.closeBtn = var2;
      this.contentContainer = var3;
      this.leadingIcon = var4;
      this.message = var5;
      this.title = var6;
   }

   public static HolderDeviceMsgBinding bind(View var0) {
      int var1 = R.id.close_btn;
      Button var6 = (Button)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         ConstraintLayout var2 = (ConstraintLayout)var0;
         var1 = R.id.leading_icon;
         ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.message;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.title;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  return new HolderDeviceMsgBinding(var2, var6, var2, var5, var3, var4);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceMsgBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceMsgBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_msg, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
