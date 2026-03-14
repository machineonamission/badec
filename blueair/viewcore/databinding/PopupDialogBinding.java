package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class PopupDialogBinding implements ViewBinding {
   public final View divider;
   public final TextView messageTextView;
   private final ConstraintLayout rootView;
   public final AppCompatTextView subtitleTextView;
   public final AppCompatTextView titleTextView;

   private PopupDialogBinding(ConstraintLayout var1, View var2, TextView var3, AppCompatTextView var4, AppCompatTextView var5) {
      this.rootView = var1;
      this.divider = var2;
      this.messageTextView = var3;
      this.subtitleTextView = var4;
      this.titleTextView = var5;
   }

   public static PopupDialogBinding bind(View var0) {
      int var1 = R.id.divider;
      View var5 = ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.messageTextView;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.subtitleTextView;
            AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.titleTextView;
               AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  return new PopupDialogBinding((ConstraintLayout)var0, var5, var2, var4, var3);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static PopupDialogBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static PopupDialogBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.popup_dialog, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
