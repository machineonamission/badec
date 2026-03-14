package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class ConfirmationDialogCenteredBinding implements ViewBinding {
   public final TextView body;
   public final Guideline bottomGuideline;
   public final LinearLayoutCompat buttonsContainer;
   public final MaterialButton confirmButton;
   public final MaterialButton dismissButton;
   public final Guideline endGuideline;
   private final LinearLayout rootView;
   public final Guideline startGuideline;
   public final TextView title;
   public final Guideline topGuideline;

   private ConfirmationDialogCenteredBinding(LinearLayout var1, TextView var2, Guideline var3, LinearLayoutCompat var4, MaterialButton var5, MaterialButton var6, Guideline var7, Guideline var8, TextView var9, Guideline var10) {
      this.rootView = var1;
      this.body = var2;
      this.bottomGuideline = var3;
      this.buttonsContainer = var4;
      this.confirmButton = var5;
      this.dismissButton = var6;
      this.endGuideline = var7;
      this.startGuideline = var8;
      this.title = var9;
      this.topGuideline = var10;
   }

   public static ConfirmationDialogCenteredBinding bind(View var0) {
      int var1 = R.id.body;
      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.bottom_guideline;
         Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.buttons_container;
            LinearLayoutCompat var3 = (LinearLayoutCompat)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.confirm_button;
               MaterialButton var9 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.dismiss_button;
                  MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.end_guideline;
                     Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.start_guideline;
                        Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.title;
                           TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var5 != null) {
                              var1 = R.id.top_guideline;
                              Guideline var10 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 return new ConfirmationDialogCenteredBinding((LinearLayout)var0, var4, var2, var3, var9, var6, var7, var8, var5, var10);
                              }
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

   public static ConfirmationDialogCenteredBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ConfirmationDialogCenteredBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.confirmation_dialog_centered, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
