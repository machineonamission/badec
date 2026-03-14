package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderScheduleCardBinding implements ViewBinding {
   public final ImageView ivLeading;
   public final ImageView ivMainMode;
   public final ImageView ivMode;
   public final LinearLayout llMode;
   public final ConstraintLayout rootLayout;
   private final ShadowLayout rootView;
   public final SwitchCompat switchSchedule;
   public final TextView timeRange;
   public final AppCompatTextView tvMode;
   public final AppCompatTextView tvName;
   public final TextView tvRepeat;

   private HolderScheduleCardBinding(ShadowLayout var1, ImageView var2, ImageView var3, ImageView var4, LinearLayout var5, ConstraintLayout var6, SwitchCompat var7, TextView var8, AppCompatTextView var9, AppCompatTextView var10, TextView var11) {
      this.rootView = var1;
      this.ivLeading = var2;
      this.ivMainMode = var3;
      this.ivMode = var4;
      this.llMode = var5;
      this.rootLayout = var6;
      this.switchSchedule = var7;
      this.timeRange = var8;
      this.tvMode = var9;
      this.tvName = var10;
      this.tvRepeat = var11;
   }

   public static HolderScheduleCardBinding bind(View var0) {
      int var1 = R.id.iv_leading;
      ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.iv_mainMode;
         ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.iv_mode;
            ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var8 != null) {
               var1 = R.id.ll_mode;
               LinearLayout var2 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.root_layout;
                  ConstraintLayout var5 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.switch_schedule;
                     SwitchCompat var6 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.time_range;
                        TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var11 != null) {
                           var1 = R.id.tv_mode;
                           AppCompatTextView var7 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              var1 = R.id.tv_name;
                              AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var3 != null) {
                                 var1 = R.id.tv_repeat;
                                 TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var9 != null) {
                                    return new HolderScheduleCardBinding((ShadowLayout)var0, var10, var4, var8, var2, var5, var6, var11, var7, var3, var9);
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

   public static HolderScheduleCardBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScheduleCardBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_schedule_card, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
