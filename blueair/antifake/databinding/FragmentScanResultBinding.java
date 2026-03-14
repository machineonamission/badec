package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.blueair.viewcore.databinding.StateLoadingFailedBinding;
import com.google.android.material.button.MaterialButton;

public final class FragmentScanResultBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final MaterialButton btnCustomerSupport;
   public final TextView btnManualReset;
   public final MaterialButton btnResetFilter;
   public final View divider1;
   public final View divider2;
   public final Guideline endGuideline;
   public final Group groupCode;
   public final AppCompatImageView imageCodeStatus;
   public final TextView infoCodeStatus;
   private final ConstraintLayout rootView;
   public final TextView securityCode;
   public final Guideline startGuideline;
   public final StateLoadingFailedBinding stateLoadingFailed;
   public final TextView titleCodeStatus;
   public final TextView titleSecurityCode;
   public final Guideline topGuideline;

   private FragmentScanResultBinding(ConstraintLayout var1, Guideline var2, MaterialButton var3, TextView var4, MaterialButton var5, View var6, View var7, Guideline var8, Group var9, AppCompatImageView var10, TextView var11, TextView var12, Guideline var13, StateLoadingFailedBinding var14, TextView var15, TextView var16, Guideline var17) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.btnCustomerSupport = var3;
      this.btnManualReset = var4;
      this.btnResetFilter = var5;
      this.divider1 = var6;
      this.divider2 = var7;
      this.endGuideline = var8;
      this.groupCode = var9;
      this.imageCodeStatus = var10;
      this.infoCodeStatus = var11;
      this.securityCode = var12;
      this.startGuideline = var13;
      this.stateLoadingFailed = var14;
      this.titleCodeStatus = var15;
      this.titleSecurityCode = var16;
      this.topGuideline = var17;
   }

   public static FragmentScanResultBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btn_customer_support;
         MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.btn_manual_reset;
            TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var13 != null) {
               var1 = R.id.btn_reset_filter;
               MaterialButton var9 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.divider1;
                  View var6 = ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.divider2;
                     View var7 = ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.end_guideline;
                        Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.group_code;
                           Group var5 = (Group)ViewBindings.findChildViewById(var0, var1);
                           if (var5 != null) {
                              var1 = R.id.image_code_status;
                              AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var2 != null) {
                                 var1 = R.id.info_code_status;
                                 TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var10 != null) {
                                    var1 = R.id.security_code;
                                    TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       var1 = R.id.start_guideline;
                                       Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                       if (var8 != null) {
                                          var1 = R.id.state_loading_failed;
                                          View var14 = ViewBindings.findChildViewById(var0, var1);
                                          if (var14 != null) {
                                             StateLoadingFailedBinding var18 = StateLoadingFailedBinding.bind(var14);
                                             var1 = R.id.title_code_status;
                                             TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var16 != null) {
                                                var1 = R.id.title_security_code;
                                                TextView var17 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var17 != null) {
                                                   var1 = R.id.top_guideline;
                                                   Guideline var15 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                   if (var15 != null) {
                                                      return new FragmentScanResultBinding((ConstraintLayout)var0, var3, var11, var13, var9, var6, var7, var4, var5, var2, var10, var12, var8, var18, var16, var17, var15);
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
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentScanResultBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentScanResultBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_scan_result, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
