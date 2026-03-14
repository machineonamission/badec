package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class HolderTroubleshootingStepBinding implements ViewBinding {
   public final AppCompatImageView ivIcon;
   public final ConstraintLayout root;
   private final ConstraintLayout rootView;
   public final AppCompatTextView tvContent;
   public final AppCompatTextView tvTitle;

   private HolderTroubleshootingStepBinding(ConstraintLayout var1, AppCompatImageView var2, ConstraintLayout var3, AppCompatTextView var4, AppCompatTextView var5) {
      this.rootView = var1;
      this.ivIcon = var2;
      this.root = var3;
      this.tvContent = var4;
      this.tvTitle = var5;
   }

   public static HolderTroubleshootingStepBinding bind(View var0) {
      int var1 = R.id.iv_icon;
      AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         ConstraintLayout var2 = (ConstraintLayout)var0;
         var1 = R.id.tv_content;
         AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.tv_title;
            AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new HolderTroubleshootingStepBinding(var2, var4, var2, var5, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderTroubleshootingStepBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderTroubleshootingStepBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_troubleshooting_step, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
