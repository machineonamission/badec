package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class HolderAddLocationBinding implements ViewBinding {
   public final AppCompatImageButton btnAdd;
   private final AppCompatImageButton rootView;

   private HolderAddLocationBinding(AppCompatImageButton var1, AppCompatImageButton var2) {
      this.rootView = var1;
      this.btnAdd = var2;
   }

   public static HolderAddLocationBinding bind(View var0) {
      if (var0 != null) {
         AppCompatImageButton var1 = (AppCompatImageButton)var0;
         return new HolderAddLocationBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static HolderAddLocationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderAddLocationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_add_location, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public AppCompatImageButton getRoot() {
      return this.rootView;
   }
}
