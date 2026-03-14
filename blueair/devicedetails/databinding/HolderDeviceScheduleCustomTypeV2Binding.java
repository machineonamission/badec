package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceScheduleCustomTypeV2Binding implements ViewBinding {
   public final ImageView btnClose;
   public final LinearLayout descriptionContainer;
   public final RadioButton radioButtonCustom;
   public final RadioButton radioButtonPrevious;
   public final RadioGroup radioGroupCustomScheduleSettings;
   private final ConstraintLayout rootView;
   public final TextView textviewCustomScheduleDescription;

   private HolderDeviceScheduleCustomTypeV2Binding(ConstraintLayout var1, ImageView var2, LinearLayout var3, RadioButton var4, RadioButton var5, RadioGroup var6, TextView var7) {
      this.rootView = var1;
      this.btnClose = var2;
      this.descriptionContainer = var3;
      this.radioButtonCustom = var4;
      this.radioButtonPrevious = var5;
      this.radioGroupCustomScheduleSettings = var6;
      this.textviewCustomScheduleDescription = var7;
   }

   public static HolderDeviceScheduleCustomTypeV2Binding bind(View var0) {
      int var1 = R.id.btn_close;
      ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.description_container;
         LinearLayout var5 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.radio_button_custom;
            RadioButton var4 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.radio_button_previous;
               RadioButton var7 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.radio_group_custom_schedule_settings;
                  RadioGroup var6 = (RadioGroup)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.textview_custom_schedule_description;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        return new HolderDeviceScheduleCustomTypeV2Binding((ConstraintLayout)var0, var3, var5, var4, var7, var6, var2);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceScheduleCustomTypeV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceScheduleCustomTypeV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_schedule_custom_type_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
