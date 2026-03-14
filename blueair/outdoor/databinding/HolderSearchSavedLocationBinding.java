package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class HolderSearchSavedLocationBinding implements ViewBinding {
   public final TextView primaryText;
   private final LinearLayout rootView;

   private HolderSearchSavedLocationBinding(LinearLayout var1, TextView var2) {
      this.rootView = var1;
      this.primaryText = var2;
   }

   public static HolderSearchSavedLocationBinding bind(View var0) {
      int var1 = R.id.primary_text;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new HolderSearchSavedLocationBinding((LinearLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderSearchSavedLocationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderSearchSavedLocationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_search_saved_location, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
