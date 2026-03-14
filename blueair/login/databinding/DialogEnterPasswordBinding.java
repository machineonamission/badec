package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.login.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class DialogEnterPasswordBinding implements ViewBinding {
   public final MaterialButton cancelView;
   public final TextView dialogMsg;
   public final TextView dialogTitle;
   public final TextInputEditText editText;
   public final TextInputLayout editTextLayout;
   public final MaterialButton okView;
   private final FrameLayout rootView;

   private DialogEnterPasswordBinding(FrameLayout var1, MaterialButton var2, TextView var3, TextView var4, TextInputEditText var5, TextInputLayout var6, MaterialButton var7) {
      this.rootView = var1;
      this.cancelView = var2;
      this.dialogMsg = var3;
      this.dialogTitle = var4;
      this.editText = var5;
      this.editTextLayout = var6;
      this.okView = var7;
   }

   public static DialogEnterPasswordBinding bind(View var0) {
      int var1 = R.id.cancel_view;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.dialog_msg;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.dialog_title;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.editText;
               TextInputEditText var5 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.editTextLayout;
                  TextInputLayout var6 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.ok_view;
                     MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        return new DialogEnterPasswordBinding((FrameLayout)var0, var3, var2, var4, var5, var6, var7);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogEnterPasswordBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogEnterPasswordBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_enter_password, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
