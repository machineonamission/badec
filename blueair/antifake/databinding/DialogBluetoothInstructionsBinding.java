package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.google.android.material.button.MaterialButton;

public final class DialogBluetoothInstructionsBinding implements ViewBinding {
   public final ImageButton closeButton;
   public final MaterialButton nextButton;
   private final LinearLayout rootView;
   public final TextView screenTitle;

   private DialogBluetoothInstructionsBinding(LinearLayout var1, ImageButton var2, MaterialButton var3, TextView var4) {
      this.rootView = var1;
      this.closeButton = var2;
      this.nextButton = var3;
      this.screenTitle = var4;
   }

   public static DialogBluetoothInstructionsBinding bind(View var0) {
      int var1 = R.id.close_button;
      ImageButton var3 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.next_button;
         MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.screen_title;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new DialogBluetoothInstructionsBinding((LinearLayout)var0, var3, var4, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogBluetoothInstructionsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogBluetoothInstructionsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_bluetooth_instructions, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
