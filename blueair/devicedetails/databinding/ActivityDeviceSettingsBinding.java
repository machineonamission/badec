package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.google.android.material.button.MaterialButton;

public final class ActivityDeviceSettingsBinding implements ViewBinding {
   public final LinearLayout bottomBar;
   public final AppCompatImageButton btnBack;
   public final MaterialButton buttonDeleteProduct;
   public final NestedScrollView recyclerViewContainer;
   public final ShadowedRecyclerViewLayout recyclerViewSettingsContainer;
   private final ConstraintLayout rootView;
   public final View separator;
   public final AppCompatTextView tvTitle;

   private ActivityDeviceSettingsBinding(ConstraintLayout var1, LinearLayout var2, AppCompatImageButton var3, MaterialButton var4, NestedScrollView var5, ShadowedRecyclerViewLayout var6, View var7, AppCompatTextView var8) {
      this.rootView = var1;
      this.bottomBar = var2;
      this.btnBack = var3;
      this.buttonDeleteProduct = var4;
      this.recyclerViewContainer = var5;
      this.recyclerViewSettingsContainer = var6;
      this.separator = var7;
      this.tvTitle = var8;
   }

   public static ActivityDeviceSettingsBinding bind(View var0) {
      int var1 = R.id.bottom_bar;
      LinearLayout var3 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btnBack;
         AppCompatImageButton var7 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.buttonDeleteProduct;
            MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.recycler_view_container;
               NestedScrollView var2 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.recyclerViewSettingsContainer;
                  ShadowedRecyclerViewLayout var8 = (ShadowedRecyclerViewLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.separator;
                     View var4 = ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.tv_title;
                        AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           return new ActivityDeviceSettingsBinding((ConstraintLayout)var0, var3, var7, var6, var2, var8, var4, var5);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityDeviceSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityDeviceSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_device_settings, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
