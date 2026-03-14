package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class DialogDeleteAlarmBinding implements ViewBinding {
   public final AppCompatEditText etName;
   public final ConstraintLayout rootLayout;
   private final ShadowLayout rootView;
   public final RecyclerView rvList;
   public final ShadowLayout slRoot;

   private DialogDeleteAlarmBinding(ShadowLayout var1, AppCompatEditText var2, ConstraintLayout var3, RecyclerView var4, ShadowLayout var5) {
      this.rootView = var1;
      this.etName = var2;
      this.rootLayout = var3;
      this.rvList = var4;
      this.slRoot = var5;
   }

   public static DialogDeleteAlarmBinding bind(View var0) {
      int var1 = R.id.et_name;
      AppCompatEditText var2 = (AppCompatEditText)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.root_layout;
         ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.rv_list;
            RecyclerView var4 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               ShadowLayout var5 = (ShadowLayout)var0;
               return new DialogDeleteAlarmBinding(var5, var2, var3, var4, var5);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogDeleteAlarmBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogDeleteAlarmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_delete_alarm, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
