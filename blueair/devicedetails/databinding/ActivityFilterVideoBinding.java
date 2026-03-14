package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public final class ActivityFilterVideoBinding implements ViewBinding {
   public final AppCompatImageButton closeIcon;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final VideoView videoView;

   private ActivityFilterVideoBinding(ConstraintLayout var1, AppCompatImageButton var2, ProgressBlockerView var3, ConstraintLayout var4, VideoView var5) {
      this.rootView = var1;
      this.closeIcon = var2;
      this.progressView = var3;
      this.rootLayout = var4;
      this.videoView = var5;
   }

   public static ActivityFilterVideoBinding bind(View var0) {
      int var1 = R.id.close_icon;
      AppCompatImageButton var5 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.progress_view;
         ProgressBlockerView var3 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            ConstraintLayout var2 = (ConstraintLayout)var0;
            var1 = R.id.video_view;
            VideoView var4 = (VideoView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new ActivityFilterVideoBinding(var2, var5, var3, var2, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityFilterVideoBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityFilterVideoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_filter_video, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
