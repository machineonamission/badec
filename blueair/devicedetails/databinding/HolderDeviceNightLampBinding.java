package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderDeviceNightLampBinding implements ViewBinding {
   public final View clickView;
   public final ConstraintLayout contentContainer;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final ImageView leadingIcon;
   public final TextView progressText;
   private final ShadowLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final View separator0;
   public final View separator100;
   public final ShadowLayout slContainer;
   public final AppCompatTextView title;
   public final TextView tvProgress0;
   public final TextView tvProgress100;

   private HolderDeviceNightLampBinding(ShadowLayout var1, View var2, ConstraintLayout var3, SwitchCompat var4, Group var5, ImageView var6, TextView var7, AccessibleSeekBar var8, View var9, View var10, ShadowLayout var11, AppCompatTextView var12, TextView var13, TextView var14) {
      this.rootView = var1;
      this.clickView = var2;
      this.contentContainer = var3;
      this.expendSwitch = var4;
      this.expendedContent = var5;
      this.leadingIcon = var6;
      this.progressText = var7;
      this.seekbar = var8;
      this.separator0 = var9;
      this.separator100 = var10;
      this.slContainer = var11;
      this.title = var12;
      this.tvProgress0 = var13;
      this.tvProgress100 = var14;
   }

   public static HolderDeviceNightLampBinding bind(View var0) {
      int var1 = R.id.click_view;
      View var11 = ViewBindings.findChildViewById(var0, var1);
      if (var11 != null) {
         var1 = R.id.content_container;
         ConstraintLayout var10 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var10 != null) {
            var1 = R.id.expend_switch;
            SwitchCompat var5 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.expended_content;
               Group var6 = (Group)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.leading_icon;
                  ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.progress_text;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.seekbar;
                        AccessibleSeekBar var14 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                        if (var14 != null) {
                           var1 = R.id.separator_0;
                           View var9 = ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.separator_100;
                              View var8 = ViewBindings.findChildViewById(var0, var1);
                              if (var8 != null) {
                                 ShadowLayout var2 = (ShadowLayout)var0;
                                 var1 = R.id.title;
                                 AppCompatTextView var12 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var12 != null) {
                                    var1 = R.id.tv_progress_0;
                                    TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var3 != null) {
                                       var1 = R.id.tv_progress_100;
                                       TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var13 != null) {
                                          return new HolderDeviceNightLampBinding(var2, var11, var10, var5, var6, var7, var4, var14, var9, var8, var2, var12, var3, var13);
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

   public static HolderDeviceNightLampBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceNightLampBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_night_lamp, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
