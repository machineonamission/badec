package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;
import com.google.android.material.button.MaterialButton;

public final class DialogAssignProductNoDeviceBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final MaterialButton btnPrimary;
   public final TextView dialogMsg;
   public final TextView dialogSubTitle;
   public final TextView dialogTitle;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final LinearLayout rootView;
   public final Guideline topGuideline;

   private DialogAssignProductNoDeviceBinding(LinearLayout var1, Guideline var2, MaterialButton var3, TextView var4, TextView var5, TextView var6, Guideline var7, Guideline var8, Guideline var9) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.btnPrimary = var3;
      this.dialogMsg = var4;
      this.dialogSubTitle = var5;
      this.dialogTitle = var6;
      this.leftGuideline = var7;
      this.rightGuideline = var8;
      this.topGuideline = var9;
   }

   public static DialogAssignProductNoDeviceBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.btn_primary;
         MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.dialog_msg;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.dialog_sub_title;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.dialog_title;
                  TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var2 != null) {
                     var1 = R.id.left_guideline;
                     Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        var1 = R.id.right_guideline;
                        Guideline var9 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           var1 = R.id.top_guideline;
                           Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              return new DialogAssignProductNoDeviceBinding((LinearLayout)var0, var8, var3, var6, var4, var2, var5, var9, var7);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogAssignProductNoDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogAssignProductNoDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_assign_product_no_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
