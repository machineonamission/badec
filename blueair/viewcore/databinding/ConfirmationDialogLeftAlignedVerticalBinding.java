package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class ConfirmationDialogLeftAlignedVerticalBinding implements ViewBinding {
   public final TextView body;
   public final Guideline bottomGuideline;
   public final MaterialButton confirmButton;
   public final MaterialButton dismissButton;
   public final Guideline endGuideline;
   public final AppCompatImageView ivClose;
   private final LinearLayout rootView;
   public final Guideline startGuideline;
   public final TextView subtitle;
   public final TextView title;
   public final Guideline topGuideline;

   private ConfirmationDialogLeftAlignedVerticalBinding(LinearLayout var1, TextView var2, Guideline var3, MaterialButton var4, MaterialButton var5, Guideline var6, AppCompatImageView var7, Guideline var8, TextView var9, TextView var10, Guideline var11) {
      this.rootView = var1;
      this.body = var2;
      this.bottomGuideline = var3;
      this.confirmButton = var4;
      this.dismissButton = var5;
      this.endGuideline = var6;
      this.ivClose = var7;
      this.startGuideline = var8;
      this.subtitle = var9;
      this.title = var10;
      this.topGuideline = var11;
   }

   public static ConfirmationDialogLeftAlignedVerticalBinding bind(View var0) {
      int var1 = R.id.body;
      TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.bottom_guideline;
         Guideline var9 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.confirm_button;
            MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var11 != null) {
               var1 = R.id.dismiss_button;
               MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.end_guideline;
                  Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.iv_close;
                     AppCompatImageView var7 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.start_guideline;
                        Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.subtitle;
                           TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var2 != null) {
                              var1 = R.id.title;
                              TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.top_guideline;
                                 Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                 if (var8 != null) {
                                    return new ConfirmationDialogLeftAlignedVerticalBinding((LinearLayout)var0, var10, var9, var11, var6, var3, var7, var4, var2, var5, var8);
                                 }
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

   public static ConfirmationDialogLeftAlignedVerticalBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ConfirmationDialogLeftAlignedVerticalBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.confirmation_dialog_left_aligned_vertical, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
