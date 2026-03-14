package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceTargetHumidityBinding implements ViewBinding {
   public final View clickView;
   public final ConstraintLayout contentContainer;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   public final TextView progressText;
   private final ConstraintLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final View separatorEnd;
   public final View separatorStart;
   public final TextView title;
   public final TextView tvProgress0;
   public final TextView tvProgress100;

   private HolderDeviceTargetHumidityBinding(ConstraintLayout var1, View var2, ConstraintLayout var3, SwitchCompat var4, Group var5, ImageView var6, ImageView var7, TextView var8, AccessibleSeekBar var9, View var10, View var11, TextView var12, TextView var13, TextView var14) {
      this.rootView = var1;
      this.clickView = var2;
      this.contentContainer = var3;
      this.expendSwitch = var4;
      this.expendedContent = var5;
      this.ivInfo = var6;
      this.leadingIcon = var7;
      this.progressText = var8;
      this.seekbar = var9;
      this.separatorEnd = var10;
      this.separatorStart = var11;
      this.title = var12;
      this.tvProgress0 = var13;
      this.tvProgress100 = var14;
   }

   public static HolderDeviceTargetHumidityBinding bind(View var0) {
      int var1 = R.id.click_view;
      View var3 = ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         ConstraintLayout var11 = (ConstraintLayout)var0;
         var1 = R.id.expend_switch;
         SwitchCompat var12 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
         if (var12 != null) {
            var1 = R.id.expended_content;
            Group var9 = (Group)ViewBindings.findChildViewById(var0, var1);
            if (var9 != null) {
               var1 = R.id.iv_info;
               ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.leading_icon;
                  ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.progress_text;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.seekbar;
                        AccessibleSeekBar var8 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.separator_end;
                           View var7 = ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              var1 = R.id.separator_start;
                              View var10 = ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 var1 = R.id.title;
                                 TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var5 != null) {
                                    var1 = R.id.tv_progress_0;
                                    TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var14 != null) {
                                       var1 = R.id.tv_progress_100;
                                       TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var13 != null) {
                                          return new HolderDeviceTargetHumidityBinding(var11, var3, var11, var12, var9, var2, var6, var4, var8, var7, var10, var5, var14, var13);
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

   public static HolderDeviceTargetHumidityBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceTargetHumidityBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_target_humidity, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
