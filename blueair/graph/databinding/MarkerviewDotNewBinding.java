package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;

public final class MarkerviewDotNewBinding implements ViewBinding {
   public final View dashedLine;
   public final View markerDot;
   private final FrameLayout rootView;

   private MarkerviewDotNewBinding(FrameLayout var1, View var2, View var3) {
      this.rootView = var1;
      this.dashedLine = var2;
      this.markerDot = var3;
   }

   public static MarkerviewDotNewBinding bind(View var0) {
      int var1 = R.id.dashed_line;
      View var2 = ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.marker_dot;
         View var3 = ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new MarkerviewDotNewBinding((FrameLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static MarkerviewDotNewBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static MarkerviewDotNewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.markerview_dot_new, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
