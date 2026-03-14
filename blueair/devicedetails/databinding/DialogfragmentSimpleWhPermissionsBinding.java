package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentSimpleWhPermissionsBinding implements ViewBinding {
   public final MaterialButton btnBack;
   public final AppCompatTextView btnGtsAutostart;
   public final AppCompatTextView btnGtsPowerManagement;
   public final MaterialButton btnNext;
   public final LinearLayout containerThirdPage;
   public final AppCompatImageView ivClose;
   public final FrameLayout llTitle;
   private final LinearLayout rootView;
   public final AppCompatTextView tvAutostart;
   public final AppCompatTextView tvPermissionsTitle;
   public final AppCompatTextView tvPowerDesp;

   private DialogfragmentSimpleWhPermissionsBinding(LinearLayout var1, MaterialButton var2, AppCompatTextView var3, AppCompatTextView var4, MaterialButton var5, LinearLayout var6, AppCompatImageView var7, FrameLayout var8, AppCompatTextView var9, AppCompatTextView var10, AppCompatTextView var11) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnGtsAutostart = var3;
      this.btnGtsPowerManagement = var4;
      this.btnNext = var5;
      this.containerThirdPage = var6;
      this.ivClose = var7;
      this.llTitle = var8;
      this.tvAutostart = var9;
      this.tvPermissionsTitle = var10;
      this.tvPowerDesp = var11;
   }

   public static DialogfragmentSimpleWhPermissionsBinding bind(View var0) {
      int var1 = R.id.btn_back;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btn_gts_autostart;
         AppCompatTextView var8 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.btn_gts_power_management;
            AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.btn_next;
               MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var11 != null) {
                  var1 = R.id.container_third_page;
                  LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.iv_close;
                     AppCompatImageView var10 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var10 != null) {
                        var1 = R.id.ll_title;
                        FrameLayout var7 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.tv_autostart;
                           AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.tv_permissions_title;
                              AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.tv_powerDesp;
                                 AppCompatTextView var2 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var2 != null) {
                                    return new DialogfragmentSimpleWhPermissionsBinding((LinearLayout)var0, var3, var8, var6, var11, var4, var10, var7, var9, var5, var2);
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

   public static DialogfragmentSimpleWhPermissionsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentSimpleWhPermissionsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_simple_wh_permissions, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
