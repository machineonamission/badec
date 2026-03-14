package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderNotificationSettingsBinding implements ViewBinding {
   private final ConstraintLayout rootView;
   public final SwitchCompat typeSwitch;
   public final TextView typeText;

   private HolderNotificationSettingsBinding(ConstraintLayout var1, SwitchCompat var2, TextView var3) {
      this.rootView = var1;
      this.typeSwitch = var2;
      this.typeText = var3;
   }

   public static HolderNotificationSettingsBinding bind(View var0) {
      int var1 = R.id.type_switch;
      SwitchCompat var3 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.type_text;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new HolderNotificationSettingsBinding((ConstraintLayout)var0, var3, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderNotificationSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderNotificationSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_notification_settings, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
