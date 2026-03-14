package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class DialogfragmentDeviceC3TemperatureBinding implements ViewBinding {
   public final AppCompatImageButton btnBack;
   public final ConstraintLayout contentContainer;
   public final View divider;
   public final Guideline endGuideline;
   private final ConstraintLayout rootView;
   public final AppCompatImageView selectC;
   public final AppCompatImageView selectF;
   public final ShadowLayout slRoot;
   public final Guideline startGuideline;
   public final TextView titleTempC;
   public final TextView titleTempF;
   public final AppCompatTextView tvTitle;

   private DialogfragmentDeviceC3TemperatureBinding(ConstraintLayout var1, AppCompatImageButton var2, ConstraintLayout var3, View var4, Guideline var5, AppCompatImageView var6, AppCompatImageView var7, ShadowLayout var8, Guideline var9, TextView var10, TextView var11, AppCompatTextView var12) {
      this.rootView = var1;
      this.btnBack = var2;
      this.contentContainer = var3;
      this.divider = var4;
      this.endGuideline = var5;
      this.selectC = var6;
      this.selectF = var7;
      this.slRoot = var8;
      this.startGuideline = var9;
      this.titleTempC = var10;
      this.titleTempF = var11;
      this.tvTitle = var12;
   }

   public static DialogfragmentDeviceC3TemperatureBinding bind(View var0) {
      int var1 = R.id.btnBack;
      AppCompatImageButton var12 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var12 != null) {
         ConstraintLayout var4 = (ConstraintLayout)var0;
         var1 = R.id.divider;
         View var11 = ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.end_guideline;
            Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var8 != null) {
               var1 = R.id.select_c;
               AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.select_f;
                  AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.sl_root;
                     ShadowLayout var6 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.start_guideline;
                        Guideline var9 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           var1 = R.id.title_temp_c;
                           TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              var1 = R.id.title_temp_f;
                              TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var7 != null) {
                                 var1 = R.id.tv_title;
                                 AppCompatTextView var2 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var2 != null) {
                                    return new DialogfragmentDeviceC3TemperatureBinding(var4, var12, var4, var11, var8, var5, var3, var6, var9, var10, var7, var2);
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

   public static DialogfragmentDeviceC3TemperatureBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceC3TemperatureBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_c3_temperature, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
