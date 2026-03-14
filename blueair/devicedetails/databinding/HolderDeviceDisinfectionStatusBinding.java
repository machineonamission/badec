package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SeekProgressBar;

public final class HolderDeviceDisinfectionStatusBinding implements ViewBinding {
   public final TextView attributeTitle;
   public final TextView disinfectionLeftTimeView;
   public final SeekProgressBar progress;
   private final ConstraintLayout rootView;
   public final View separator;

   private HolderDeviceDisinfectionStatusBinding(ConstraintLayout var1, TextView var2, TextView var3, SeekProgressBar var4, View var5) {
      this.rootView = var1;
      this.attributeTitle = var2;
      this.disinfectionLeftTimeView = var3;
      this.progress = var4;
      this.separator = var5;
   }

   public static HolderDeviceDisinfectionStatusBinding bind(View var0) {
      int var1 = R.id.attribute_title;
      TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.disinfection_left_time_view;
         TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.progress;
            SeekProgressBar var5 = (SeekProgressBar)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.separator;
               View var2 = ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  return new HolderDeviceDisinfectionStatusBinding((ConstraintLayout)var0, var3, var4, var5, var2);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceDisinfectionStatusBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceDisinfectionStatusBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_disinfection_status, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
