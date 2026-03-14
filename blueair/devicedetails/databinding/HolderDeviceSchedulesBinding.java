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

public final class HolderDeviceSchedulesBinding implements ViewBinding {
   public final ConstraintLayout childLockContainer;
   public final ImageView childLockIcon;
   public final TextView childLockText;
   public final TextView childLockValue;
   private final LinearLayout rootView;
   public final ConstraintLayout schedulesContainer;
   public final ImageView schedulesIcon;
   public final TextView schedulesText;
   public final TextView schedulesValue;

   private HolderDeviceSchedulesBinding(LinearLayout var1, ConstraintLayout var2, ImageView var3, TextView var4, TextView var5, ConstraintLayout var6, ImageView var7, TextView var8, TextView var9) {
      this.rootView = var1;
      this.childLockContainer = var2;
      this.childLockIcon = var3;
      this.childLockText = var4;
      this.childLockValue = var5;
      this.schedulesContainer = var6;
      this.schedulesIcon = var7;
      this.schedulesText = var8;
      this.schedulesValue = var9;
   }

   public static HolderDeviceSchedulesBinding bind(View var0) {
      int var1 = R.id.child_lock_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.child_lock_icon;
         ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.child_lock_text;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.child_lock_value;
               TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.schedules_container;
                  ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.schedules_icon;
                     ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.schedules_text;
                        TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var3 != null) {
                           var1 = R.id.schedules_value;
                           TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var6 != null) {
                              return new HolderDeviceSchedulesBinding((LinearLayout)var0, var2, var8, var5, var9, var7, var4, var3, var6);
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

   public static HolderDeviceSchedulesBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSchedulesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_schedules, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
