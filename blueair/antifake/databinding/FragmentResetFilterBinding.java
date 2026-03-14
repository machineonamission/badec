package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class FragmentResetFilterBinding implements ViewBinding {
   public final MaterialButton btnCustomerSupport;
   public final MaterialButton btnFinish;
   public final MaterialButton btnHowToReplace;
   public final TextView btnManualReset;
   public final ProgressBlockerView connectingIcPending;
   public final AppCompatImageView connectingIcResult;
   public final ConstraintLayout connectingLine;
   public final TextView connectingText;
   public final ProgressBlockerView resettingIcPending;
   public final AppCompatImageView resettingIcResult;
   public final ConstraintLayout resettingLine;
   public final TextView resettingText;
   private final ConstraintLayout rootView;

   private FragmentResetFilterBinding(ConstraintLayout var1, MaterialButton var2, MaterialButton var3, MaterialButton var4, TextView var5, ProgressBlockerView var6, AppCompatImageView var7, ConstraintLayout var8, TextView var9, ProgressBlockerView var10, AppCompatImageView var11, ConstraintLayout var12, TextView var13) {
      this.rootView = var1;
      this.btnCustomerSupport = var2;
      this.btnFinish = var3;
      this.btnHowToReplace = var4;
      this.btnManualReset = var5;
      this.connectingIcPending = var6;
      this.connectingIcResult = var7;
      this.connectingLine = var8;
      this.connectingText = var9;
      this.resettingIcPending = var10;
      this.resettingIcResult = var11;
      this.resettingLine = var12;
      this.resettingText = var13;
   }

   public static FragmentResetFilterBinding bind(View var0) {
      int var1 = R.id.btn_customer_support;
      MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.btn_finish;
         MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.btn_how_to_replace;
            MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.btn_manual_reset;
               TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var13 != null) {
                  var1 = R.id.connecting_ic_pending;
                  ProgressBlockerView var11 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                  if (var11 != null) {
                     var1 = R.id.connecting_ic_result;
                     AppCompatImageView var7 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.connecting_line;
                        ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           var1 = R.id.connecting_text;
                           TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var8 != null) {
                              var1 = R.id.resetting_ic_pending;
                              ProgressBlockerView var5 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.resetting_ic_result;
                                 AppCompatImageView var12 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var12 != null) {
                                    var1 = R.id.resetting_line;
                                    ConstraintLayout var10 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var10 != null) {
                                       var1 = R.id.resetting_text;
                                       TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var9 != null) {
                                          return new FragmentResetFilterBinding((ConstraintLayout)var0, var6, var3, var4, var13, var11, var7, var2, var8, var5, var12, var10, var9);
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

   public static FragmentResetFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentResetFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_reset_filter, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
