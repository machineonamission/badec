package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class HolderAssignDeviceBinding implements ViewBinding {
   public final CheckBox checkBox;
   public final TextView deviceName;
   public final LinearLayout itemContainer;
   private final FrameLayout rootView;

   private HolderAssignDeviceBinding(FrameLayout var1, CheckBox var2, TextView var3, LinearLayout var4) {
      this.rootView = var1;
      this.checkBox = var2;
      this.deviceName = var3;
      this.itemContainer = var4;
   }

   public static HolderAssignDeviceBinding bind(View var0) {
      int var1 = R.id.check_box;
      CheckBox var2 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.device_name;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.item_container;
            LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new HolderAssignDeviceBinding((FrameLayout)var0, var2, var3, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderAssignDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderAssignDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_assign_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
