package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceHDryModeBinding implements ViewBinding {
   public final AppCompatImageView backBtn;
   public final LinearLayout contentBack;
   public final ConstraintLayout contentContainer;
   public final ConstraintLayout contentContainerSwitch;
   public final TextView dryModeInfo;
   public final Guideline endGuideline;
   private final FrameLayout rootView;
   public final MaterialButton saveBtn;
   public final Guideline startGuideline;
   public final SwitchCompat switchBtn;
   public final TextView title;

   private DialogfragmentDeviceHDryModeBinding(FrameLayout var1, AppCompatImageView var2, LinearLayout var3, ConstraintLayout var4, ConstraintLayout var5, TextView var6, Guideline var7, MaterialButton var8, Guideline var9, SwitchCompat var10, TextView var11) {
      this.rootView = var1;
      this.backBtn = var2;
      this.contentBack = var3;
      this.contentContainer = var4;
      this.contentContainerSwitch = var5;
      this.dryModeInfo = var6;
      this.endGuideline = var7;
      this.saveBtn = var8;
      this.startGuideline = var9;
      this.switchBtn = var10;
      this.title = var11;
   }

   public static DialogfragmentDeviceHDryModeBinding bind(View var0) {
      int var1 = R.id.back_btn;
      AppCompatImageView var8 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.content_back;
         LinearLayout var3 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.content_container;
            ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.content_container_switch;
               ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.dry_mode_info;
                  TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var9 != null) {
                     var1 = R.id.end_guideline;
                     Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        var1 = R.id.save_btn;
                        MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.start_guideline;
                           Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                           if (var5 != null) {
                              var1 = R.id.switch_btn;
                              SwitchCompat var11 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                              if (var11 != null) {
                                 var1 = R.id.title;
                                 TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var10 != null) {
                                    return new DialogfragmentDeviceHDryModeBinding((FrameLayout)var0, var8, var3, var7, var6, var9, var2, var4, var5, var11, var10);
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

   public static DialogfragmentDeviceHDryModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceHDryModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_h_dry_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
