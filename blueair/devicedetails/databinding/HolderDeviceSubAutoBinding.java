package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceSubAutoBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   private final FrameLayout rootView;
   public final SwitchCompat switchBtn;
   public final TextView title;

   private HolderDeviceSubAutoBinding(FrameLayout var1, ConstraintLayout var2, SwitchCompat var3, TextView var4) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.switchBtn = var3;
      this.title = var4;
   }

   public static HolderDeviceSubAutoBinding bind(View var0) {
      int var1 = R.id.content_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.switch_btn;
         SwitchCompat var4 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.title;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new HolderDeviceSubAutoBinding((FrameLayout)var0, var2, var4, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceSubAutoBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSubAutoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_sub_auto, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
