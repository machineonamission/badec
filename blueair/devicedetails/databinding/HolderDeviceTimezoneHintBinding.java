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

public final class HolderDeviceTimezoneHintBinding implements ViewBinding {
   public final TextView attributeDescription;
   public final TextView attributeTitle;
   public final TextView attributeValue;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;

   private HolderDeviceTimezoneHintBinding(ConstraintLayout var1, TextView var2, TextView var3, TextView var4, Guideline var5, Guideline var6) {
      this.rootView = var1;
      this.attributeDescription = var2;
      this.attributeTitle = var3;
      this.attributeValue = var4;
      this.leftGuideline = var5;
      this.rightGuideline = var6;
   }

   public static HolderDeviceTimezoneHintBinding bind(View var0) {
      int var1 = R.id.attribute_description;
      TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.attribute_title;
         TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.attribute_value;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.left_guideline;
               Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.right_guideline;
                  Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     return new HolderDeviceTimezoneHintBinding((ConstraintLayout)var0, var6, var4, var3, var2, var5);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceTimezoneHintBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceTimezoneHintBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_timezone_hint, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
