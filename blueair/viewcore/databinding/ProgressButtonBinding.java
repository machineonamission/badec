package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class ProgressButtonBinding implements ViewBinding {
   public final ImageView image;
   public final ProgressBar progressBar;
   private final View rootView;

   private ProgressButtonBinding(View var1, ImageView var2, ProgressBar var3) {
      this.rootView = var1;
      this.image = var2;
      this.progressBar = var3;
   }

   public static ProgressButtonBinding bind(View var0) {
      int var1 = R.id.image;
      ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.progressBar;
         ProgressBar var2 = (ProgressBar)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new ProgressButtonBinding(var0, var3, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ProgressButtonBinding inflate(LayoutInflater var0, ViewGroup var1) {
      if (var1 != null) {
         var0.inflate(R.layout.progress_button, var1);
         return bind(var1);
      } else {
         throw new NullPointerException("parent");
      }
   }

   public View getRoot() {
      return this.rootView;
   }
}
