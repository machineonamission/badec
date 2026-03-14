package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceFilterTypeBinding implements ViewBinding {
   public final AppCompatImageView filterImage;
   public final TextView filterName;
   public final Guideline leftGuideline;
   public final MaterialButton myFilterBtn;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;

   private HolderDeviceFilterTypeBinding(ConstraintLayout var1, AppCompatImageView var2, TextView var3, Guideline var4, MaterialButton var5, Guideline var6) {
      this.rootView = var1;
      this.filterImage = var2;
      this.filterName = var3;
      this.leftGuideline = var4;
      this.myFilterBtn = var5;
      this.rightGuideline = var6;
   }

   public static HolderDeviceFilterTypeBinding bind(View var0) {
      int var1 = R.id.filter_image;
      AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.filter_name;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.left_guideline;
            Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.my_filter_btn;
               MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.right_guideline;
                  Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     return new HolderDeviceFilterTypeBinding((ConstraintLayout)var0, var4, var2, var6, var3, var5);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceFilterTypeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFilterTypeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_filter_type, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
