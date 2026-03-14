package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class FragmentDeviceBannersBinding implements ViewBinding {
   public final RecyclerView bannerList;
   private final FrameLayout rootView;

   private FragmentDeviceBannersBinding(FrameLayout var1, RecyclerView var2) {
      this.rootView = var1;
      this.bannerList = var2;
   }

   public static FragmentDeviceBannersBinding bind(View var0) {
      int var1 = R.id.banner_list;
      RecyclerView var2 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new FragmentDeviceBannersBinding((FrameLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static FragmentDeviceBannersBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceBannersBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_banners, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
