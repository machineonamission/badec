package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderNameForDeleteBinding implements ViewBinding {
   private final AppCompatTextView rootView;

   private HolderNameForDeleteBinding(AppCompatTextView var1) {
      this.rootView = var1;
   }

   public static HolderNameForDeleteBinding bind(View var0) {
      if (var0 != null) {
         return new HolderNameForDeleteBinding((AppCompatTextView)var0);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static HolderNameForDeleteBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderNameForDeleteBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_name_for_delete, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public AppCompatTextView getRoot() {
      return this.rootView;
   }
}
