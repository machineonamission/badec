package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class HolderScannedDeviceEmptyStateBinding implements ViewBinding {
   public final TextView emptyMsg;
   private final ConstraintLayout rootView;

   private HolderScannedDeviceEmptyStateBinding(ConstraintLayout var1, TextView var2) {
      this.rootView = var1;
      this.emptyMsg = var2;
   }

   public static HolderScannedDeviceEmptyStateBinding bind(View var0) {
      int var1 = R.id.empty_msg;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new HolderScannedDeviceEmptyStateBinding((ConstraintLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderScannedDeviceEmptyStateBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScannedDeviceEmptyStateBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_scanned_device_empty_state, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
