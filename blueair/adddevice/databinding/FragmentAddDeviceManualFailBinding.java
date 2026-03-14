package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class FragmentAddDeviceManualFailBinding implements ViewBinding {
   public final Button buttonRestart;
   public final ImageView imgManualFail;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceManualFailBinding(ConstraintLayout var1, Button var2, ImageView var3, TextView var4) {
      this.rootView = var1;
      this.buttonRestart = var2;
      this.imgManualFail = var3;
      this.textAddDeviceTitle = var4;
   }

   public static FragmentAddDeviceManualFailBinding bind(View var0) {
      int var1 = R.id.button_restart;
      Button var2 = (Button)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.img_manual_fail;
         ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.textAddDeviceTitle;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new FragmentAddDeviceManualFailBinding((ConstraintLayout)var0, var2, var4, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceManualFailBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceManualFailBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_manual_fail, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
