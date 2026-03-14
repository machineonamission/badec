package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SeekProgressBar;

public final class HolderDeviceEtaBinding implements ViewBinding {
   public final TextView clearAirMinView;
   public final TextView clearAirMsgView;
   public final Guideline leftGuideline;
   public final SeekProgressBar progress;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;

   private HolderDeviceEtaBinding(ConstraintLayout var1, TextView var2, TextView var3, Guideline var4, SeekProgressBar var5, Guideline var6) {
      this.rootView = var1;
      this.clearAirMinView = var2;
      this.clearAirMsgView = var3;
      this.leftGuideline = var4;
      this.progress = var5;
      this.rightGuideline = var6;
   }

   public static HolderDeviceEtaBinding bind(View var0) {
      int var1 = R.id.clear_air_min_view;
      TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.clear_air_msg_view;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.left_guideline;
            Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.progress;
               SeekProgressBar var6 = (SeekProgressBar)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.right_guideline;
                  Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     return new HolderDeviceEtaBinding((ConstraintLayout)var0, var3, var2, var4, var6, var5);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceEtaBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceEtaBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_eta, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
