package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class DialogEnterDeviceNameBinding implements ViewBinding {
   public final MaterialButton cancelView;
   public final TextView dialogMsg;
   public final TextView dialogTitle;
   public final TextInputEditText editText;
   public final TextInputLayout editTextLayout;
   public final MaterialButton okView;
   private final FrameLayout rootView;

   private DialogEnterDeviceNameBinding(FrameLayout var1, MaterialButton var2, TextView var3, TextView var4, TextInputEditText var5, TextInputLayout var6, MaterialButton var7) {
      this.rootView = var1;
      this.cancelView = var2;
      this.dialogMsg = var3;
      this.dialogTitle = var4;
      this.editText = var5;
      this.editTextLayout = var6;
      this.okView = var7;
   }

   public static DialogEnterDeviceNameBinding bind(View var0) {
      int var1 = R.id.cancel_view;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.dialog_msg;
         TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.dialog_title;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.editText;
               TextInputEditText var4 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.editTextLayout;
                  TextInputLayout var3 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.ok_view;
                     MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        return new DialogEnterDeviceNameBinding((FrameLayout)var0, var2, var7, var6, var4, var3, var5);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogEnterDeviceNameBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogEnterDeviceNameBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_enter_device_name, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
