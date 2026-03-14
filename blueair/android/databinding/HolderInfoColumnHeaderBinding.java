package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class HolderInfoColumnHeaderBinding implements ViewBinding {
   public final FrameLayout regularSettingLayout;
   private final FrameLayout rootView;
   public final TextView tvTitle;
   public final View vBg;
   public final View vBottom;
   public final View vTop;

   private HolderInfoColumnHeaderBinding(FrameLayout var1, FrameLayout var2, TextView var3, View var4, View var5, View var6) {
      this.rootView = var1;
      this.regularSettingLayout = var2;
      this.tvTitle = var3;
      this.vBg = var4;
      this.vBottom = var5;
      this.vTop = var6;
   }

   public static HolderInfoColumnHeaderBinding bind(View var0) {
      FrameLayout var2 = (FrameLayout)var0;
      int var1 = R.id.tv_title;
      TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.v_bg;
         View var6 = ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.v_bottom;
            View var4 = ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.v_top;
               View var5 = ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new HolderInfoColumnHeaderBinding(var2, var2, var3, var6, var4, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderInfoColumnHeaderBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderInfoColumnHeaderBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_info_column_header, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
