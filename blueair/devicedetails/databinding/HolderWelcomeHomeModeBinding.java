package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderWelcomeHomeModeBinding implements ViewBinding {
   public final ConstraintLayout clLocation;
   public final AppCompatImageView ivEdit;
   public final Guideline leftGuideline;
   public final LottieAnimationView progressView;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final TextView settingSummary;
   public final SwitchCompat settingSwitch;
   public final AppCompatTextView settingTitle;
   public final AppCompatTextView tvLocation;
   public final AppCompatTextView tvRadius;

   private HolderWelcomeHomeModeBinding(ConstraintLayout var1, ConstraintLayout var2, AppCompatImageView var3, Guideline var4, LottieAnimationView var5, Guideline var6, TextView var7, SwitchCompat var8, AppCompatTextView var9, AppCompatTextView var10, AppCompatTextView var11) {
      this.rootView = var1;
      this.clLocation = var2;
      this.ivEdit = var3;
      this.leftGuideline = var4;
      this.progressView = var5;
      this.rightGuideline = var6;
      this.settingSummary = var7;
      this.settingSwitch = var8;
      this.settingTitle = var9;
      this.tvLocation = var10;
      this.tvRadius = var11;
   }

   public static HolderWelcomeHomeModeBinding bind(View var0) {
      int var1 = R.id.cl_location;
      ConstraintLayout var9 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var9 != null) {
         var1 = R.id.iv_edit;
         AppCompatImageView var11 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.left_guideline;
            Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.progress_view;
               LottieAnimationView var2 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.right_guideline;
                  Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.setting_summary;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.setting_switch;
                        SwitchCompat var10 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                        if (var10 != null) {
                           var1 = R.id.setting_title;
                           AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var5 != null) {
                              var1 = R.id.tv_location;
                              AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var6 != null) {
                                 var1 = R.id.tv_radius;
                                 AppCompatTextView var7 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var7 != null) {
                                    return new HolderWelcomeHomeModeBinding((ConstraintLayout)var0, var9, var11, var3, var2, var8, var4, var10, var5, var6, var7);
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

   public static HolderWelcomeHomeModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderWelcomeHomeModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_welcome_home_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
