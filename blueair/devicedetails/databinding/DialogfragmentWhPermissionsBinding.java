package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentWhPermissionsBinding implements ViewBinding {
   public final MaterialButton btnBack;
   public final TextView btnGtsAutostart;
   public final TextView btnGtsLocation;
   public final TextView btnGtsPowerManagement;
   public final MaterialButton btnNext;
   public final LinearLayout containerSecondPage;
   public final LinearLayout containerThirdPage;
   private final LinearLayout rootView;
   public final TextView tvPermissionsTitle;
   public final TextView tvScheduleAffect;

   private DialogfragmentWhPermissionsBinding(LinearLayout var1, MaterialButton var2, TextView var3, TextView var4, TextView var5, MaterialButton var6, LinearLayout var7, LinearLayout var8, TextView var9, TextView var10) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnGtsAutostart = var3;
      this.btnGtsLocation = var4;
      this.btnGtsPowerManagement = var5;
      this.btnNext = var6;
      this.containerSecondPage = var7;
      this.containerThirdPage = var8;
      this.tvPermissionsTitle = var9;
      this.tvScheduleAffect = var10;
   }

   public static DialogfragmentWhPermissionsBinding bind(View var0) {
      int var1 = R.id.btn_back;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btn_gts_autostart;
         TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.btn_gts_location;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.btn_gts_power_management;
               TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.btn_next;
                  MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.container_second_page;
                     LinearLayout var8 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.container_third_page;
                        LinearLayout var7 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.tv_permissions_title;
                           TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              var1 = R.id.tv_schedule_affect;
                              TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var2 != null) {
                                 return new DialogfragmentWhPermissionsBinding((LinearLayout)var0, var3, var9, var6, var5, var4, var8, var7, var10, var2);
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

   public static DialogfragmentWhPermissionsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentWhPermissionsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_wh_permissions, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
