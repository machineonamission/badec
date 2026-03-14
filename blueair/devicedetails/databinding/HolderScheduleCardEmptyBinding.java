package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class HolderScheduleCardEmptyBinding implements ViewBinding {
   public final MaterialButton btnCreate;
   public final ConstraintLayout emptyLayout;
   private final ShadowLayout rootView;
   public final AppCompatTextView textEmptyTitle;

   private HolderScheduleCardEmptyBinding(ShadowLayout var1, MaterialButton var2, ConstraintLayout var3, AppCompatTextView var4) {
      this.rootView = var1;
      this.btnCreate = var2;
      this.emptyLayout = var3;
      this.textEmptyTitle = var4;
   }

   public static HolderScheduleCardEmptyBinding bind(View var0) {
      int var1 = R.id.btn_create;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.emptyLayout;
         ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.textEmptyTitle;
            AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new HolderScheduleCardEmptyBinding((ShadowLayout)var0, var2, var4, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderScheduleCardEmptyBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScheduleCardEmptyBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_schedule_card_empty, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
