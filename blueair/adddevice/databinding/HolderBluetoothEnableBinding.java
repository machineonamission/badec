package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class HolderBluetoothEnableBinding implements ViewBinding {
   public final MaterialButton bleEnableBtn;
   public final TextView enableTitle;
   public final AppCompatImageView icBluetooth;
   private final ConstraintLayout rootView;
   public final TextView tvContent;

   private HolderBluetoothEnableBinding(ConstraintLayout var1, MaterialButton var2, TextView var3, AppCompatImageView var4, TextView var5) {
      this.rootView = var1;
      this.bleEnableBtn = var2;
      this.enableTitle = var3;
      this.icBluetooth = var4;
      this.tvContent = var5;
   }

   public static HolderBluetoothEnableBinding bind(View var0) {
      int var1 = R.id.ble_enable_btn;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.enable_title;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.ic_bluetooth;
            AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.tv_content;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  return new HolderBluetoothEnableBinding((ConstraintLayout)var0, var4, var3, var5, var2);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderBluetoothEnableBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderBluetoothEnableBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_bluetooth_enable, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
