package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class ScanInfoBinding implements ViewBinding {
   public final LinearLayout contentContainer;
   private final LinearLayout rootView;
   public final RecyclerView scanResultList;
   public final RecyclerView verificationList;

   private ScanInfoBinding(LinearLayout var1, LinearLayout var2, RecyclerView var3, RecyclerView var4) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.scanResultList = var3;
      this.verificationList = var4;
   }

   public static ScanInfoBinding bind(View var0) {
      LinearLayout var4 = (LinearLayout)var0;
      int var1 = R.id.scan_result_list;
      RecyclerView var2 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.verification_list;
         RecyclerView var3 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new ScanInfoBinding(var4, var4, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ScanInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ScanInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.scan_info, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
