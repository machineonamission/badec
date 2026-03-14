package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class FragmentDeviceAttributesBinding implements ViewBinding {
   public final ConstraintLayout layoutMain;
   public final RecyclerView recyclerViewAttributes;
   private final ConstraintLayout rootView;

   private FragmentDeviceAttributesBinding(ConstraintLayout var1, ConstraintLayout var2, RecyclerView var3) {
      this.rootView = var1;
      this.layoutMain = var2;
      this.recyclerViewAttributes = var3;
   }

   public static FragmentDeviceAttributesBinding bind(View var0) {
      ConstraintLayout var2 = (ConstraintLayout)var0;
      int var1 = R.id.recyclerViewAttributes;
      RecyclerView var3 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         return new FragmentDeviceAttributesBinding(var2, var2, var3);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static FragmentDeviceAttributesBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceAttributesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_attributes, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
