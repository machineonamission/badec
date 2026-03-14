package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class StateLoadingFailedBinding implements ViewBinding {
   public final ImageView ivIcon;
   private final ConstraintLayout rootView;
   public final TextView tvText;

   private StateLoadingFailedBinding(ConstraintLayout var1, ImageView var2, TextView var3) {
      this.rootView = var1;
      this.ivIcon = var2;
      this.tvText = var3;
   }

   public static StateLoadingFailedBinding bind(View var0) {
      int var1 = R.id.iv_icon;
      ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.tv_text;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new StateLoadingFailedBinding((ConstraintLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static StateLoadingFailedBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static StateLoadingFailedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.state_loading_failed, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
