package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderSettingAutoModeTriggersBinding implements ViewBinding {
   public final RadioButton autoModePmButton;
   public final RadioButton autoModePmTvocButton;
   public final TextView autoTitle;
   public final RadioGroup buttonGroupAutoMode;
   public final RadioGroup buttonGroupNightMode;
   public final Guideline leftGuideline;
   public final RadioButton nightModePmButton;
   public final RadioButton nightModePmTvocButton;
   public final TextView nightTitle;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final TextView settingSummary;
   public final TextView settingTitle;

   private HolderSettingAutoModeTriggersBinding(ConstraintLayout var1, RadioButton var2, RadioButton var3, TextView var4, RadioGroup var5, RadioGroup var6, Guideline var7, RadioButton var8, RadioButton var9, TextView var10, Guideline var11, TextView var12, TextView var13) {
      this.rootView = var1;
      this.autoModePmButton = var2;
      this.autoModePmTvocButton = var3;
      this.autoTitle = var4;
      this.buttonGroupAutoMode = var5;
      this.buttonGroupNightMode = var6;
      this.leftGuideline = var7;
      this.nightModePmButton = var8;
      this.nightModePmTvocButton = var9;
      this.nightTitle = var10;
      this.rightGuideline = var11;
      this.settingSummary = var12;
      this.settingTitle = var13;
   }

   public static HolderSettingAutoModeTriggersBinding bind(View var0) {
      int var1 = R.id.auto_mode_pm_button;
      RadioButton var9 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
      if (var9 != null) {
         var1 = R.id.auto_mode_pm_tvoc_button;
         RadioButton var2 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.auto_title;
            TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var13 != null) {
               var1 = R.id.buttonGroup_auto_mode;
               RadioGroup var11 = (RadioGroup)ViewBindings.findChildViewById(var0, var1);
               if (var11 != null) {
                  var1 = R.id.buttonGroup_night_mode;
                  RadioGroup var3 = (RadioGroup)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.left_guideline;
                     Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.night_mode_pm_button;
                        RadioButton var4 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.night_mode_pm_tvoc_button;
                           RadioButton var7 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              var1 = R.id.night_title;
                              TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.right_guideline;
                                 Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                 if (var8 != null) {
                                    var1 = R.id.setting_summary;
                                    TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       var1 = R.id.setting_title;
                                       TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var10 != null) {
                                          return new HolderSettingAutoModeTriggersBinding((ConstraintLayout)var0, var9, var2, var13, var11, var3, var6, var4, var7, var5, var8, var12, var10);
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

   public static HolderSettingAutoModeTriggersBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderSettingAutoModeTriggersBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_setting_auto_mode_triggers, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
