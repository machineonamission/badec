package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.antifake.R;

public final class HolderManualResetBinding implements ViewBinding {
   public final LottieAnimationView animationView;
   public final TextView contentMessage;
   private final ConstraintLayout rootView;

   private HolderManualResetBinding(ConstraintLayout var1, LottieAnimationView var2, TextView var3) {
      this.rootView = var1;
      this.animationView = var2;
      this.contentMessage = var3;
   }

   public static HolderManualResetBinding bind(View var0) {
      int var1 = R.id.animation_view;
      LottieAnimationView var3 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.content_message;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new HolderManualResetBinding((ConstraintLayout)var0, var3, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderManualResetBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderManualResetBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_manual_reset, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
