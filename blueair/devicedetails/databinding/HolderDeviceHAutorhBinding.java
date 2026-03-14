package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceHAutorhBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   public final ImageView endIcon;
   public final TextView progressText;
   private final FrameLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final Group seekbarGroup;
   public final ImageView startIcon;
   public final TextView title;

   private HolderDeviceHAutorhBinding(FrameLayout var1, ConstraintLayout var2, ImageView var3, TextView var4, AccessibleSeekBar var5, Group var6, ImageView var7, TextView var8) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.endIcon = var3;
      this.progressText = var4;
      this.seekbar = var5;
      this.seekbarGroup = var6;
      this.startIcon = var7;
      this.title = var8;
   }

   public static HolderDeviceHAutorhBinding bind(View var0) {
      int var1 = R.id.content_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.end_icon;
         ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.progressText;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.seekbar;
               AccessibleSeekBar var8 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  var1 = R.id.seekbar_group;
                  Group var4 = (Group)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.start_icon;
                     ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        var1 = R.id.title;
                        TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           return new HolderDeviceHAutorhBinding((FrameLayout)var0, var2, var6, var3, var8, var4, var5, var7);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHAutorhBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHAutorhBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_h_autorh, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
