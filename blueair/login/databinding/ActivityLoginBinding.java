package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.login.R;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.ProgressBlockerView;

public final class ActivityLoginBinding implements ViewBinding {
   public final FrameLayout fragmentContainer;
   public final ProgressBlockerView loading;
   private final AbsorbInsetFrameLayout rootView;

   private ActivityLoginBinding(AbsorbInsetFrameLayout var1, FrameLayout var2, ProgressBlockerView var3) {
      this.rootView = var1;
      this.fragmentContainer = var2;
      this.loading = var3;
   }

   public static ActivityLoginBinding bind(View var0) {
      int var1 = R.id.fragmentContainer;
      FrameLayout var2 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.loading;
         ProgressBlockerView var3 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new ActivityLoginBinding((AbsorbInsetFrameLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityLoginBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityLoginBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_login, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public AbsorbInsetFrameLayout getRoot() {
      return this.rootView;
   }
}
