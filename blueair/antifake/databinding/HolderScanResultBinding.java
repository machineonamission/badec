package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class HolderScanResultBinding implements ViewBinding {
   public final AppCompatImageView iconResult;
   public final TextView resultInfo;
   public final TextView resultTitle;
   private final ConstraintLayout rootView;

   private HolderScanResultBinding(ConstraintLayout var1, AppCompatImageView var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.iconResult = var2;
      this.resultInfo = var3;
      this.resultTitle = var4;
   }

   public static HolderScanResultBinding bind(View var0) {
      int var1 = R.id.icon_result;
      AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.result_info;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.result_title;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new HolderScanResultBinding((ConstraintLayout)var0, var3, var2, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderScanResultBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScanResultBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_scan_result, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
