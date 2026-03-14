package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.antifake.R;

public final class FragmentScanVerifyingBinding implements ViewBinding {
   private final FrameLayout rootView;

   private FragmentScanVerifyingBinding(FrameLayout var1) {
      this.rootView = var1;
   }

   public static FragmentScanVerifyingBinding bind(View var0) {
      if (var0 != null) {
         return new FragmentScanVerifyingBinding((FrameLayout)var0);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static FragmentScanVerifyingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentScanVerifyingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_scan_verifying, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
