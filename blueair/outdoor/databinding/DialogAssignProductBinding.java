package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class DialogAssignProductBinding implements ViewBinding {
   public final MaterialButton btnAssign;
   public final ImageButton btnClose;
   public final TextView chooseProducts;
   public final TextView description;
   public final RecyclerView deviceList;
   public final TextView locationName;
   public final ProgressBlockerView progressView;
   private final LinearLayout rootView;
   public final TextView title;

   private DialogAssignProductBinding(LinearLayout var1, MaterialButton var2, ImageButton var3, TextView var4, TextView var5, RecyclerView var6, TextView var7, ProgressBlockerView var8, TextView var9) {
      this.rootView = var1;
      this.btnAssign = var2;
      this.btnClose = var3;
      this.chooseProducts = var4;
      this.description = var5;
      this.deviceList = var6;
      this.locationName = var7;
      this.progressView = var8;
      this.title = var9;
   }

   public static DialogAssignProductBinding bind(View var0) {
      int var1 = R.id.btn_assign;
      MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.btn_close;
         ImageButton var5 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.choose_products;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.description;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.device_list;
                  RecyclerView var8 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.location_name;
                     TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var9 != null) {
                        var1 = R.id.progress_view;
                        ProgressBlockerView var4 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.title;
                           TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var6 != null) {
                              return new DialogAssignProductBinding((LinearLayout)var0, var7, var5, var3, var2, var8, var9, var4, var6);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogAssignProductBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogAssignProductBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_assign_product, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
