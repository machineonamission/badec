package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class HolderSearchedDeviceBinding implements ViewBinding {
   public final TextView bluetoothStatus;
   public final AppCompatImageView deviceImg;
   public final TextView deviceName;
   public final TextView filterLeftLabel;
   public final TextView filterLeftValue;
   public final TextView macLabel;
   public final TextView macNumber;
   public final TextView modelName;
   public final TextView offlineLabel;
   public final ConstraintLayout root;
   private final ConstraintLayout rootView;
   public final TextView wickLeftLabel;
   public final TextView wickLeftValue;

   private HolderSearchedDeviceBinding(ConstraintLayout var1, TextView var2, AppCompatImageView var3, TextView var4, TextView var5, TextView var6, TextView var7, TextView var8, TextView var9, TextView var10, ConstraintLayout var11, TextView var12, TextView var13) {
      this.rootView = var1;
      this.bluetoothStatus = var2;
      this.deviceImg = var3;
      this.deviceName = var4;
      this.filterLeftLabel = var5;
      this.filterLeftValue = var6;
      this.macLabel = var7;
      this.macNumber = var8;
      this.modelName = var9;
      this.offlineLabel = var10;
      this.root = var11;
      this.wickLeftLabel = var12;
      this.wickLeftValue = var13;
   }

   public static HolderSearchedDeviceBinding bind(View var0) {
      int var1 = R.id.bluetooth_status;
      TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.device_img;
         AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.device_name;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.filter_left_label;
               TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var11 != null) {
                  var1 = R.id.filter_left_value;
                  TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.mac_label;
                     TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var13 != null) {
                        var1 = R.id.mac_number;
                        TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           var1 = R.id.model_name;
                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.offline_label;
                              TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var2 != null) {
                                 ConstraintLayout var6 = (ConstraintLayout)var0;
                                 var1 = R.id.wick_left_label;
                                 TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var12 != null) {
                                    var1 = R.id.wick_left_value;
                                    TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var7 != null) {
                                       return new HolderSearchedDeviceBinding(var6, var10, var4, var3, var11, var8, var13, var5, var9, var2, var6, var12, var7);
                                    }
                                 }
                              }
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

   public static HolderSearchedDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderSearchedDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_searched_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
