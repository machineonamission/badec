package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderAlarmSoundBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   private final ConstraintLayout rootView;
   public final TextView title;

   private HolderAlarmSoundBinding(ConstraintLayout var1, ConstraintLayout var2, TextView var3) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.title = var3;
   }

   public static HolderAlarmSoundBinding bind(View var0) {
      ConstraintLayout var2 = (ConstraintLayout)var0;
      int var1 = R.id.title;
      TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         return new HolderAlarmSoundBinding(var2, var2, var3);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderAlarmSoundBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderAlarmSoundBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_alarm_sound, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
