package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class ConfirmationDialogBinding implements ViewBinding {
   public final View divider;
   public final ImageView imageTop;
   public final TextView messageTextView;
   private final ConstraintLayout rootView;
   public final AppCompatTextView titleTextView;

   private ConfirmationDialogBinding(ConstraintLayout var1, View var2, ImageView var3, TextView var4, AppCompatTextView var5) {
      this.rootView = var1;
      this.divider = var2;
      this.imageTop = var3;
      this.messageTextView = var4;
      this.titleTextView = var5;
   }

   public static ConfirmationDialogBinding bind(View var0) {
      int var1 = R.id.divider;
      View var3 = ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.imageTop;
         ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.messageTextView;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.titleTextView;
               AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new ConfirmationDialogBinding((ConstraintLayout)var0, var3, var2, var4, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ConfirmationDialogBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ConfirmationDialogBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.confirmation_dialog, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
