package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class DialogNoIcpDetectedBinding implements ViewBinding {
   public final TextView body;
   public final TextView button;
   private final ConstraintLayout rootView;
   public final TextView title;

   private DialogNoIcpDetectedBinding(ConstraintLayout var1, TextView var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.body = var2;
      this.button = var3;
      this.title = var4;
   }

   public static DialogNoIcpDetectedBinding bind(View var0) {
      int var1 = R.id.body;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.button;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.title;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new DialogNoIcpDetectedBinding((ConstraintLayout)var0, var2, var3, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogNoIcpDetectedBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogNoIcpDetectedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_no_icp_detected, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
