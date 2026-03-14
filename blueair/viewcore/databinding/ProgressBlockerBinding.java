package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.viewcore.R;

public final class ProgressBlockerBinding implements ViewBinding {
   public final LottieAnimationView progressBar;
   public final FrameLayout progressContainer;
   private final FrameLayout rootView;

   private ProgressBlockerBinding(FrameLayout var1, LottieAnimationView var2, FrameLayout var3) {
      this.rootView = var1;
      this.progressBar = var2;
      this.progressContainer = var3;
   }

   public static ProgressBlockerBinding bind(View var0) {
      int var1 = R.id.progressBar;
      LottieAnimationView var2 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         FrameLayout var3 = (FrameLayout)var0;
         return new ProgressBlockerBinding(var3, var2, var3);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static ProgressBlockerBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ProgressBlockerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.progress_blocker, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
