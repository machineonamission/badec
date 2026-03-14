package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceNHinsBinding implements ViewBinding {
   private final FrameLayout rootView;
   public final SwitchCompat switchBtn;
   public final TextView title;

   private HolderDeviceNHinsBinding(FrameLayout var1, SwitchCompat var2, TextView var3) {
      this.rootView = var1;
      this.switchBtn = var2;
      this.title = var3;
   }

   public static HolderDeviceNHinsBinding bind(View var0) {
      int var1 = R.id.switch_btn;
      SwitchCompat var2 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.title;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new HolderDeviceNHinsBinding((FrameLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceNHinsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceNHinsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_n_hins, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
