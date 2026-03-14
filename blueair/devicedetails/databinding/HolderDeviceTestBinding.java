package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceTestBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   private final ConstraintLayout rootView;
   public final TextView title;

   private HolderDeviceTestBinding(ConstraintLayout var1, ConstraintLayout var2, TextView var3) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.title = var3;
   }

   public static HolderDeviceTestBinding bind(View var0) {
      ConstraintLayout var3 = (ConstraintLayout)var0;
      int var1 = R.id.title;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new HolderDeviceTestBinding(var3, var3, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderDeviceTestBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceTestBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_test, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
