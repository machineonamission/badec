package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;

public final class HolderDropDownItemBinding implements ViewBinding {
   private final TextView rootView;
   public final TextView text;

   private HolderDropDownItemBinding(TextView var1, TextView var2) {
      this.rootView = var1;
      this.text = var2;
   }

   public static HolderDropDownItemBinding bind(View var0) {
      if (var0 != null) {
         TextView var1 = (TextView)var0;
         return new HolderDropDownItemBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static HolderDropDownItemBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDropDownItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_drop_down_item, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public TextView getRoot() {
      return this.rootView;
   }
}
