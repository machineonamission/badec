package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderAlarmCardBinding implements ViewBinding {
   public final ConstraintLayout clLayout;
   public final ImageView ivLight;
   public final ImageView ivSound;
   private final ShadowLayout rootView;
   public final SwitchCompat switchAlarm;
   public final AppCompatTextView tvName;
   public final TextView tvRepeat;
   public final TextView tvTime;

   private HolderAlarmCardBinding(ShadowLayout var1, ConstraintLayout var2, ImageView var3, ImageView var4, SwitchCompat var5, AppCompatTextView var6, TextView var7, TextView var8) {
      this.rootView = var1;
      this.clLayout = var2;
      this.ivLight = var3;
      this.ivSound = var4;
      this.switchAlarm = var5;
      this.tvName = var6;
      this.tvRepeat = var7;
      this.tvTime = var8;
   }

   public static HolderAlarmCardBinding bind(View var0) {
      int var1 = R.id.cl_layout;
      ConstraintLayout var8 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.iv_light;
         ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.iv_sound;
            ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.switch_alarm;
               SwitchCompat var3 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.tv_name;
                  AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.tv_repeat;
                     TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.tv_time;
                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           return new HolderAlarmCardBinding((ShadowLayout)var0, var8, var5, var2, var3, var4, var7, var6);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderAlarmCardBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderAlarmCardBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_alarm_card, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
