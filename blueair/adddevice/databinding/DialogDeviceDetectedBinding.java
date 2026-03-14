package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class DialogDeviceDetectedBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final AppCompatImageButton closeButton;
   public final MaterialButton connectButton;
   public final ImageView deviceImg;
   public final Guideline endGuideline;
   public final TextView macNumberColon;
   public final TextView macNumberTitle;
   public final TextView macNumberValue;
   public final TextView prompt;
   private final ConstraintLayout rootView;
   public final Guideline startGuideline;
   public final TextView title;
   public final Guideline topGuideline;

   private DialogDeviceDetectedBinding(ConstraintLayout var1, Guideline var2, AppCompatImageButton var3, MaterialButton var4, ImageView var5, Guideline var6, TextView var7, TextView var8, TextView var9, TextView var10, Guideline var11, TextView var12, Guideline var13) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.closeButton = var3;
      this.connectButton = var4;
      this.deviceImg = var5;
      this.endGuideline = var6;
      this.macNumberColon = var7;
      this.macNumberTitle = var8;
      this.macNumberValue = var9;
      this.prompt = var10;
      this.startGuideline = var11;
      this.title = var12;
      this.topGuideline = var13;
   }

   public static DialogDeviceDetectedBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.close_button;
         AppCompatImageButton var11 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.connect_button;
            MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var8 != null) {
               var1 = R.id.device_img;
               ImageView var12 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var12 != null) {
                  var1 = R.id.end_guideline;
                  Guideline var9 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var9 != null) {
                     var1 = R.id.mac_number_colon;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.mac_number_title;
                        TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var10 != null) {
                           var1 = R.id.mac_number_value;
                           TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var13 != null) {
                              var1 = R.id.prompt;
                              TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var3 != null) {
                                 var1 = R.id.start_guideline;
                                 Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                 if (var2 != null) {
                                    var1 = R.id.title;
                                    TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var7 != null) {
                                       var1 = R.id.top_guideline;
                                       Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                       if (var5 != null) {
                                          return new DialogDeviceDetectedBinding((ConstraintLayout)var0, var6, var11, var8, var12, var9, var4, var10, var13, var3, var2, var7, var5);
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
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogDeviceDetectedBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogDeviceDetectedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_device_detected, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
