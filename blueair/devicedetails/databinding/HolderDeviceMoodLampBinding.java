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

public final class HolderDeviceMoodLampBinding implements ViewBinding {
   public final View clickView;
   public final ConstraintLayout contentContainer;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final ImageView leadingIcon;
   public final TextView progressText;
   private final ShadowLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final View separator0;
   public final View separator1;
   public final View separator2;
   public final View separator3;
   public final ShadowLayout slContainer;
   public final AppCompatTextView title;
   public final TextView tvProgress0;
   public final TextView tvProgress1;
   public final TextView tvProgress2;
   public final TextView tvProgress3;

   private HolderDeviceMoodLampBinding(ShadowLayout var1, View var2, ConstraintLayout var3, SwitchCompat var4, Group var5, ImageView var6, TextView var7, AccessibleSeekBar var8, View var9, View var10, View var11, View var12, ShadowLayout var13, AppCompatTextView var14, TextView var15, TextView var16, TextView var17, TextView var18) {
      this.rootView = var1;
      this.clickView = var2;
      this.contentContainer = var3;
      this.expendSwitch = var4;
      this.expendedContent = var5;
      this.leadingIcon = var6;
      this.progressText = var7;
      this.seekbar = var8;
      this.separator0 = var9;
      this.separator1 = var10;
      this.separator2 = var11;
      this.separator3 = var12;
      this.slContainer = var13;
      this.title = var14;
      this.tvProgress0 = var15;
      this.tvProgress1 = var16;
      this.tvProgress2 = var17;
      this.tvProgress3 = var18;
   }

   public static HolderDeviceMoodLampBinding bind(View var0) {
      int var1 = R.id.click_view;
      View var16 = ViewBindings.findChildViewById(var0, var1);
      if (var16 != null) {
         var1 = R.id.content_container;
         ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.expend_switch;
            SwitchCompat var12 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
            if (var12 != null) {
               var1 = R.id.expended_content;
               Group var3 = (Group)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.leading_icon;
                  ImageView var9 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var9 != null) {
                     var1 = R.id.progress_text;
                     TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var13 != null) {
                        var1 = R.id.seekbar;
                        AccessibleSeekBar var4 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.separator_0;
                           View var15 = ViewBindings.findChildViewById(var0, var1);
                           if (var15 != null) {
                              var1 = R.id.separator_1;
                              View var17 = ViewBindings.findChildViewById(var0, var1);
                              if (var17 != null) {
                                 var1 = R.id.separator_2;
                                 View var8 = ViewBindings.findChildViewById(var0, var1);
                                 if (var8 != null) {
                                    var1 = R.id.separator_3;
                                    View var10 = ViewBindings.findChildViewById(var0, var1);
                                    if (var10 != null) {
                                       ShadowLayout var18 = (ShadowLayout)var0;
                                       var1 = R.id.title;
                                       AppCompatTextView var14 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var14 != null) {
                                          var1 = R.id.tv_progress_0;
                                          TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var11 != null) {
                                             var1 = R.id.tv_progress_1;
                                             TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var6 != null) {
                                                var1 = R.id.tv_progress_2;
                                                TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var5 != null) {
                                                   var1 = R.id.tv_progress_3;
                                                   TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var2 != null) {
                                                      return new HolderDeviceMoodLampBinding(var18, var16, var7, var12, var3, var9, var13, var4, var15, var17, var8, var10, var18, var14, var11, var6, var5, var2);
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
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceMoodLampBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceMoodLampBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_mood_lamp, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
