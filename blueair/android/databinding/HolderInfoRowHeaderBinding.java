package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class HolderInfoRowHeaderBinding implements ViewBinding {
   public final FrameLayout regularSettingLayout;
   private final FrameLayout rootView;
   public final TextView tvTitle;

   private HolderInfoRowHeaderBinding(FrameLayout var1, FrameLayout var2, TextView var3) {
      this.rootView = var1;
      this.regularSettingLayout = var2;
      this.tvTitle = var3;
   }

   public static HolderInfoRowHeaderBinding bind(View var0) {
      FrameLayout var2 = (FrameLayout)var0;
      int var1 = R.id.tv_title;
      TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         return new HolderInfoRowHeaderBinding(var2, var2, var3);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderInfoRowHeaderBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderInfoRowHeaderBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_info_row_header, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
