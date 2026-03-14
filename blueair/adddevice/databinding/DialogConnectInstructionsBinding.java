package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class DialogConnectInstructionsBinding implements ViewBinding {
   public final AppCompatImageButton btnBack;
   public final AppCompatImageButton closeButton;
   public final TextView contentTextview;
   public final AppCompatTextView contentTitleTextview;
   public final AppCompatImageView ivDevice;
   public final AppCompatImageView ivIndicator;
   public final LottieAnimationView lavAnim;
   public final LinearProgressIndicator progressIndicator;
   private final LinearLayout rootView;
   public final AppCompatTextView screenTitle;
   public final AppCompatTextView tvSubtitle;

   private DialogConnectInstructionsBinding(LinearLayout var1, AppCompatImageButton var2, AppCompatImageButton var3, TextView var4, AppCompatTextView var5, AppCompatImageView var6, AppCompatImageView var7, LottieAnimationView var8, LinearProgressIndicator var9, AppCompatTextView var10, AppCompatTextView var11) {
      this.rootView = var1;
      this.btnBack = var2;
      this.closeButton = var3;
      this.contentTextview = var4;
      this.contentTitleTextview = var5;
      this.ivDevice = var6;
      this.ivIndicator = var7;
      this.lavAnim = var8;
      this.progressIndicator = var9;
      this.screenTitle = var10;
      this.tvSubtitle = var11;
   }

   public static DialogConnectInstructionsBinding bind(View var0) {
      int var1 = R.id.btnBack;
      AppCompatImageButton var8 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.close_button;
         AppCompatImageButton var11 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.content_textview;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.content_title_textview;
               AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.iv_device;
                  AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.iv_indicator;
                     AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.lav_anim;
                        LottieAnimationView var7 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.progress_indicator;
                           LinearProgressIndicator var10 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              var1 = R.id.screen_title;
                              AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.tv_subtitle;
                                 AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var9 != null) {
                                    return new DialogConnectInstructionsBinding((LinearLayout)var0, var8, var11, var2, var6, var3, var4, var7, var10, var5, var9);
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

   public static DialogConnectInstructionsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogConnectInstructionsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_connect_instructions, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
