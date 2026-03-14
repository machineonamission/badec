package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class ActionLayoutScanBinding implements ViewBinding {
   private final ImageButton rootView;

   private ActionLayoutScanBinding(ImageButton var1) {
      this.rootView = var1;
   }

   public static ActionLayoutScanBinding bind(View var0) {
      if (var0 != null) {
         return new ActionLayoutScanBinding((ImageButton)var0);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static ActionLayoutScanBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActionLayoutScanBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.action_layout_scan, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ImageButton getRoot() {
      return this.rootView;
   }
}
