package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SeekProgressBar;

public final class HolderDeviceOtaBinding implements ViewBinding {
   public final ProgressBlockerView otaProgress;
   public final SeekProgressBar progress;
   private final ConstraintLayout rootView;
   public final View separator;
   public final TextView title;

   private HolderDeviceOtaBinding(ConstraintLayout var1, ProgressBlockerView var2, SeekProgressBar var3, View var4, TextView var5) {
      this.rootView = var1;
      this.otaProgress = var2;
      this.progress = var3;
      this.separator = var4;
      this.title = var5;
   }

   public static HolderDeviceOtaBinding bind(View var0) {
      int var1 = R.id.otaProgress;
      ProgressBlockerView var2 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.progress;
         SeekProgressBar var4 = (SeekProgressBar)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.separator;
            View var3 = ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.title;
               TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new HolderDeviceOtaBinding((ConstraintLayout)var0, var2, var4, var3, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceOtaBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceOtaBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_ota, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
