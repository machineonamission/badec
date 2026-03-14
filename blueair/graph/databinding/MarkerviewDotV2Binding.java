package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blueair.graph.R;

public final class MarkerviewDotV2Binding implements ViewBinding {
   public final ImageView markerDot;
   private final ImageView rootView;

   private MarkerviewDotV2Binding(ImageView var1, ImageView var2) {
      this.rootView = var1;
      this.markerDot = var2;
   }

   public static MarkerviewDotV2Binding bind(View var0) {
      if (var0 != null) {
         ImageView var1 = (ImageView)var0;
         return new MarkerviewDotV2Binding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static MarkerviewDotV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static MarkerviewDotV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.markerview_dot_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ImageView getRoot() {
      return this.rootView;
   }
}
