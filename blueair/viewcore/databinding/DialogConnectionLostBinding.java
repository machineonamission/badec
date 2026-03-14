package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class DialogConnectionLostBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final MaterialButton buttonTryAgainLater;
   public final TextView dialogMsg;
   public final TextView dialogTitle;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final LinearLayout rootView;
   public final Guideline topGuideline;

   private DialogConnectionLostBinding(LinearLayout var1, Guideline var2, MaterialButton var3, TextView var4, TextView var5, Guideline var6, Guideline var7, Guideline var8) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.buttonTryAgainLater = var3;
      this.dialogMsg = var4;
      this.dialogTitle = var5;
      this.leftGuideline = var6;
      this.rightGuideline = var7;
      this.topGuideline = var8;
   }

   public static DialogConnectionLostBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.buttonTryAgainLater;
         MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.dialog_msg;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.dialog_title;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.left_guideline;
                  Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.right_guideline;
                     Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.top_guideline;
                        Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           return new DialogConnectionLostBinding((LinearLayout)var0, var5, var8, var3, var6, var4, var7, var2);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogConnectionLostBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogConnectionLostBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_connection_lost, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
