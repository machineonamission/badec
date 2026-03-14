package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;

public final class MarkerviewDotOutdoorBinding implements ViewBinding {
   public final View dashedLine;
   public final ImageView img;
   private final FrameLayout rootView;

   private MarkerviewDotOutdoorBinding(FrameLayout var1, View var2, ImageView var3) {
      this.rootView = var1;
      this.dashedLine = var2;
      this.img = var3;
   }

   public static MarkerviewDotOutdoorBinding bind(View var0) {
      int var1 = R.id.dashed_line;
      View var3 = ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.img;
         ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new MarkerviewDotOutdoorBinding((FrameLayout)var0, var3, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static MarkerviewDotOutdoorBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static MarkerviewDotOutdoorBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.markerview_dot_outdoor, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
