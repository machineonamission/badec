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

public final class HolderDeviceBrightnessV2Binding implements ViewBinding {
   public final View clickView;
   public final ConstraintLayout contentContainer;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final ImageView leadingIcon;
   public final TextView progressText;
   private final ConstraintLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final View separatorEnd;
   public final View separatorStart;
   public final TextView title;
   public final TextView tvProgress0;
   public final TextView tvProgress100;

   private HolderDeviceBrightnessV2Binding(ConstraintLayout var1, View var2, ConstraintLayout var3, SwitchCompat var4, Group var5, ImageView var6, TextView var7, AccessibleSeekBar var8, View var9, View var10, TextView var11, TextView var12, TextView var13) {
      this.rootView = var1;
      this.clickView = var2;
      this.contentContainer = var3;
      this.expendSwitch = var4;
      this.expendedContent = var5;
      this.leadingIcon = var6;
      this.progressText = var7;
      this.seekbar = var8;
      this.separatorEnd = var9;
      this.separatorStart = var10;
      this.title = var11;
      this.tvProgress0 = var12;
      this.tvProgress100 = var13;
   }

   public static HolderDeviceBrightnessV2Binding bind(View var0) {
      int var1 = R.id.click_view;
      View var2 = ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         ConstraintLayout var11 = (ConstraintLayout)var0;
         var1 = R.id.expend_switch;
         SwitchCompat var7 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.expended_content;
            Group var3 = (Group)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.leading_icon;
               ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.progress_text;
                  TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var10 != null) {
                     var1 = R.id.seekbar;
                     AccessibleSeekBar var12 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                     if (var12 != null) {
                        var1 = R.id.separator_end;
                        View var13 = ViewBindings.findChildViewById(var0, var1);
                        if (var13 != null) {
                           var1 = R.id.separator_start;
                           View var9 = ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.title;
                              TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 var1 = R.id.tv_progress_0;
                                 TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var8 != null) {
                                    var1 = R.id.tv_progress_100;
                                    TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var6 != null) {
                                       return new HolderDeviceBrightnessV2Binding(var11, var2, var11, var7, var3, var5, var10, var12, var13, var9, var4, var8, var6);
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

   public static HolderDeviceBrightnessV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceBrightnessV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_brightness_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
