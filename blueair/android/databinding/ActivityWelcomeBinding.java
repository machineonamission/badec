package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class ActivityWelcomeBinding implements ViewBinding {
   public final AppCompatButton btnLogin;
   public final MaterialButton btnRegister;
   private final ConstraintLayout rootView;
   public final TextView tvVersion;
   public final AppCompatTextView txtWelcomeMsg;

   private ActivityWelcomeBinding(ConstraintLayout var1, AppCompatButton var2, MaterialButton var3, TextView var4, AppCompatTextView var5) {
      this.rootView = var1;
      this.btnLogin = var2;
      this.btnRegister = var3;
      this.tvVersion = var4;
      this.txtWelcomeMsg = var5;
   }

   public static ActivityWelcomeBinding bind(View var0) {
      int var1 = R.id.btnLogin;
      AppCompatButton var4 = (AppCompatButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.btnRegister;
         MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.tv_version;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.txt_welcomeMsg;
               AppCompatTextView var2 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  return new ActivityWelcomeBinding((ConstraintLayout)var0, var4, var3, var5, var2);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityWelcomeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityWelcomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_welcome, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
