package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public final class HolderDeviceHTimerBinding implements ViewBinding {
   public final LinearLayout contentCountdown;
   public final FrameLayout contentProgress;
   public final TextView countdownNumber;
   private final FrameLayout rootView;
   public final AppCompatImageView timerControlIcon;
   public final CircularProgressIndicator timerProgressBar;
   public final AppCompatImageView timerProgressStatusIcon;
   public final TextView timerSelect;
   public final TextView timerTitle;

   private HolderDeviceHTimerBinding(FrameLayout var1, LinearLayout var2, FrameLayout var3, TextView var4, AppCompatImageView var5, CircularProgressIndicator var6, AppCompatImageView var7, TextView var8, TextView var9) {
      this.rootView = var1;
      this.contentCountdown = var2;
      this.contentProgress = var3;
      this.countdownNumber = var4;
      this.timerControlIcon = var5;
      this.timerProgressBar = var6;
      this.timerProgressStatusIcon = var7;
      this.timerSelect = var8;
      this.timerTitle = var9;
   }

   public static HolderDeviceHTimerBinding bind(View var0) {
      int var1 = R.id.content_countdown;
      LinearLayout var7 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.content_progress;
         FrameLayout var4 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.countdown_number;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.timer_control_icon;
               AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.timer_progress_bar;
                  CircularProgressIndicator var8 = (CircularProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.timer_progress_status_icon;
                     AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        var1 = R.id.timer_select;
                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.timer_title;
                           TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var2 != null) {
                              return new HolderDeviceHTimerBinding((FrameLayout)var0, var7, var4, var3, var9, var8, var5, var6, var2);
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

   public static HolderDeviceHTimerBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHTimerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_h_timer, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
