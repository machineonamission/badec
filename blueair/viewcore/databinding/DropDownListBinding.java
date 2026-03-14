package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;

public final class DropDownListBinding implements ViewBinding {
   private final ShadowedRecyclerViewLayout rootView;
   public final ShadowedRecyclerViewLayout srvl;

   private DropDownListBinding(ShadowedRecyclerViewLayout var1, ShadowedRecyclerViewLayout var2) {
      this.rootView = var1;
      this.srvl = var2;
   }

   public static DropDownListBinding bind(View var0) {
      if (var0 != null) {
         ShadowedRecyclerViewLayout var1 = (ShadowedRecyclerViewLayout)var0;
         return new DropDownListBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static DropDownListBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DropDownListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.drop_down_list, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowedRecyclerViewLayout getRoot() {
      return this.rootView;
   }
}
