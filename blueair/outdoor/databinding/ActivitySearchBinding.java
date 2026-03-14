package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class ActivitySearchBinding implements ViewBinding {
   public final FrameLayout container;
   private final ConstraintLayout rootView;

   private ActivitySearchBinding(ConstraintLayout var1, FrameLayout var2) {
      this.rootView = var1;
      this.container = var2;
   }

   public static ActivitySearchBinding bind(View var0) {
      int var1 = R.id.container;
      FrameLayout var2 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new ActivitySearchBinding((ConstraintLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static ActivitySearchBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivitySearchBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_search, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
