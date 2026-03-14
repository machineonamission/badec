package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceScheduleEmptyBinding implements ViewBinding {
   public final MaterialButton buttonAdd;
   private final ConstraintLayout rootView;

   private HolderDeviceScheduleEmptyBinding(ConstraintLayout var1, MaterialButton var2) {
      this.rootView = var1;
      this.buttonAdd = var2;
   }

   public static HolderDeviceScheduleEmptyBinding bind(View var0) {
      int var1 = R.id.button_add;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new HolderDeviceScheduleEmptyBinding((ConstraintLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderDeviceScheduleEmptyBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceScheduleEmptyBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_schedule_empty, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
