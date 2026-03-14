package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class HolderVerificationBinding implements ViewBinding {
   private final LinearLayout rootView;
   public final AppCompatImageView verificationImage;
   public final TextView verificationInfo;
   public final TextView verificationTitle;

   private HolderVerificationBinding(LinearLayout var1, AppCompatImageView var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.verificationImage = var2;
      this.verificationInfo = var3;
      this.verificationTitle = var4;
   }

   public static HolderVerificationBinding bind(View var0) {
      int var1 = R.id.verification_image;
      AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.verification_info;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.verification_title;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new HolderVerificationBinding((LinearLayout)var0, var3, var2, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderVerificationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderVerificationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_verification, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
