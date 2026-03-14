package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class FragmentAddDeviceAutoConfigProgressBinding implements ViewBinding {
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceAutoConfigProgressBinding(ConstraintLayout var1, ConstraintLayout var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.rootLayout = var2;
      this.textAddDeviceSubtitle = var3;
      this.textAddDeviceTitle = var4;
   }

   public static FragmentAddDeviceAutoConfigProgressBinding bind(View var0) {
      ConstraintLayout var2 = (ConstraintLayout)var0;
      int var1 = R.id.textAddDeviceSubtitle;
      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.textAddDeviceTitle;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new FragmentAddDeviceAutoConfigProgressBinding(var2, var2, var4, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceAutoConfigProgressBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceAutoConfigProgressBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_auto_config_progress, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
