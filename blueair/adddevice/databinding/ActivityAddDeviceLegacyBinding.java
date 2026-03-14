package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public final class ActivityAddDeviceLegacyBinding implements ViewBinding {
   public final AppBarLayout addDeviceAppbar;
   public final Toolbar addDeviceToolbar;
   public final AppCompatImageButton btnBack;
   public final AppCompatImageButton btnClose;
   public final CollapsingToolbarLayout collapsingToolbar;
   public final FrameLayout contentFragment;
   public final AppCompatTextView headerMsg;
   public final AppCompatTextView headerTitle;
   public final CoordinatorLayout layoutAddDeviceCoordinator;
   public final ConstraintLayout layoutExpandedToolbar;
   private final FrameLayout rootView;
   public final AppCompatTextView tvFirst;
   public final AppCompatTextView tvNext;

   private ActivityAddDeviceLegacyBinding(FrameLayout var1, AppBarLayout var2, Toolbar var3, AppCompatImageButton var4, AppCompatImageButton var5, CollapsingToolbarLayout var6, FrameLayout var7, AppCompatTextView var8, AppCompatTextView var9, CoordinatorLayout var10, ConstraintLayout var11, AppCompatTextView var12, AppCompatTextView var13) {
      this.rootView = var1;
      this.addDeviceAppbar = var2;
      this.addDeviceToolbar = var3;
      this.btnBack = var4;
      this.btnClose = var5;
      this.collapsingToolbar = var6;
      this.contentFragment = var7;
      this.headerMsg = var8;
      this.headerTitle = var9;
      this.layoutAddDeviceCoordinator = var10;
      this.layoutExpandedToolbar = var11;
      this.tvFirst = var12;
      this.tvNext = var13;
   }

   public static ActivityAddDeviceLegacyBinding bind(View var0) {
      int var1 = R.id.add_device_appbar;
      AppBarLayout var2 = (AppBarLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.add_device_toolbar;
         Toolbar var13 = (Toolbar)ViewBindings.findChildViewById(var0, var1);
         if (var13 != null) {
            var1 = R.id.btnBack;
            AppCompatImageButton var5 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.btnClose;
               AppCompatImageButton var9 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.collapsing_toolbar;
                  CollapsingToolbarLayout var10 = (CollapsingToolbarLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var10 != null) {
                     var1 = R.id.content_fragment;
                     FrameLayout var8 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.header_msg;
                        AppCompatTextView var12 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                        if (var12 != null) {
                           var1 = R.id.header_title;
                           AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var4 != null) {
                              var1 = R.id.layout_add_device_coordinator;
                              CoordinatorLayout var11 = (CoordinatorLayout)ViewBindings.findChildViewById(var0, var1);
                              if (var11 != null) {
                                 var1 = R.id.layout_expanded_toolbar;
                                 ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                 if (var3 != null) {
                                    var1 = R.id.tv_first;
                                    AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var6 != null) {
                                       var1 = R.id.tv_next;
                                       AppCompatTextView var7 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var7 != null) {
                                          return new ActivityAddDeviceLegacyBinding((FrameLayout)var0, var2, var13, var5, var9, var10, var8, var12, var4, var11, var3, var6, var7);
                                       }
                                    }
                                 }
                              }
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

   public static ActivityAddDeviceLegacyBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityAddDeviceLegacyBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_add_device_legacy, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
