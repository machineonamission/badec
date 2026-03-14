package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class GraphTabItemBinding implements ViewBinding {
   public final ImageButton infoIcon;
   private final LinearLayout rootView;
   public final TextView text;

   private GraphTabItemBinding(LinearLayout var1, ImageButton var2, TextView var3) {
      this.rootView = var1;
      this.infoIcon = var2;
      this.text = var3;
   }

   public static GraphTabItemBinding bind(View var0) {
      int var1 = R.id.info_icon;
      ImageButton var3 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.text;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new GraphTabItemBinding((LinearLayout)var0, var3, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static GraphTabItemBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static GraphTabItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.graph_tab_item, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
