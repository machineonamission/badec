package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceHumidificationBinding implements ViewBinding {
   public final ConstraintLayout clContainer;
   public final LinearLayout contentContainer;
   public final HolderDeviceHintBinding hintContainer;
   public final ImageView leadingIcon;
   private final LinearLayout rootView;
   public final SwitchCompat switchMode;
   public final TextView title;

   private HolderDeviceHumidificationBinding(LinearLayout var1, ConstraintLayout var2, LinearLayout var3, HolderDeviceHintBinding var4, ImageView var5, SwitchCompat var6, TextView var7) {
      this.rootView = var1;
      this.clContainer = var2;
      this.contentContainer = var3;
      this.hintContainer = var4;
      this.leadingIcon = var5;
      this.switchMode = var6;
      this.title = var7;
   }

   public static HolderDeviceHumidificationBinding bind(View var0) {
      int var1 = R.id.cl_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         LinearLayout var3 = (LinearLayout)var0;
         var1 = R.id.hint_container;
         View var4 = ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            HolderDeviceHintBinding var8 = HolderDeviceHintBinding.bind(var4);
            var1 = R.id.leading_icon;
            ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.switch_mode;
               SwitchCompat var5 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.title;
                  TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     return new HolderDeviceHumidificationBinding(var3, var2, var3, var8, var6, var5, var7);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHumidificationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHumidificationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_humidification, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
