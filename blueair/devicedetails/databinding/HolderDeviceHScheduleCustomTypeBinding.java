package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceHScheduleCustomTypeBinding implements ViewBinding {
   public final RadioButton radioButtonCustom;
   public final RadioButton radioButtonPrevious;
   public final RadioGroup radioGroupCustomScheduleSettings;
   private final ConstraintLayout rootView;
   public final TextView textviewCustomSchedule;
   public final TextView textviewCustomScheduleDescription;

   private HolderDeviceHScheduleCustomTypeBinding(ConstraintLayout var1, RadioButton var2, RadioButton var3, RadioGroup var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.radioButtonCustom = var2;
      this.radioButtonPrevious = var3;
      this.radioGroupCustomScheduleSettings = var4;
      this.textviewCustomSchedule = var5;
      this.textviewCustomScheduleDescription = var6;
   }

   public static HolderDeviceHScheduleCustomTypeBinding bind(View var0) {
      int var1 = R.id.radio_button_custom;
      RadioButton var5 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.radio_button_previous;
         RadioButton var3 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.radio_group_custom_schedule_settings;
            RadioGroup var4 = (RadioGroup)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.textview_custom_schedule;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.textview_custom_schedule_description;
                  TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new HolderDeviceHScheduleCustomTypeBinding((ConstraintLayout)var0, var5, var3, var4, var2, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHScheduleCustomTypeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHScheduleCustomTypeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_h_schedule_custom_type, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
