package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class FragmentAddDeviceSelectModelBinding implements ViewBinding {
   private final ConstraintLayout rootView;
   public final RecyclerView rvList;

   private FragmentAddDeviceSelectModelBinding(ConstraintLayout var1, RecyclerView var2) {
      this.rootView = var1;
      this.rvList = var2;
   }

   public static FragmentAddDeviceSelectModelBinding bind(View var0) {
      int var1 = R.id.rv_list;
      RecyclerView var2 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new FragmentAddDeviceSelectModelBinding((ConstraintLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static FragmentAddDeviceSelectModelBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceSelectModelBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_select_model, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
