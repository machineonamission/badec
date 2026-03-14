package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceFilterVideosBinding implements ViewBinding {
   public final AppCompatImageButton iconPlay;
   public final AppCompatImageView iconPlayBg;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final TextView videoSummary;
   public final AppCompatImageView videoThumbnail;
   public final ConstraintLayout videoThumbnailRoot;
   public final TextView videoTitle;

   private HolderDeviceFilterVideosBinding(ConstraintLayout var1, AppCompatImageButton var2, AppCompatImageView var3, Guideline var4, Guideline var5, TextView var6, AppCompatImageView var7, ConstraintLayout var8, TextView var9) {
      this.rootView = var1;
      this.iconPlay = var2;
      this.iconPlayBg = var3;
      this.leftGuideline = var4;
      this.rightGuideline = var5;
      this.videoSummary = var6;
      this.videoThumbnail = var7;
      this.videoThumbnailRoot = var8;
      this.videoTitle = var9;
   }

   public static HolderDeviceFilterVideosBinding bind(View var0) {
      int var1 = R.id.icon_play;
      AppCompatImageButton var6 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.icon_play_bg;
         AppCompatImageView var8 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.left_guideline;
            Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.right_guideline;
               Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.video_summary;
                  TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.video_thumbnail;
                     AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var9 != null) {
                        var1 = R.id.video_thumbnail_root;
                        ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var3 != null) {
                           var1 = R.id.video_title;
                           TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var4 != null) {
                              return new HolderDeviceFilterVideosBinding((ConstraintLayout)var0, var6, var8, var5, var2, var7, var9, var3, var4);
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

   public static HolderDeviceFilterVideosBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFilterVideosBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_filter_videos, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
