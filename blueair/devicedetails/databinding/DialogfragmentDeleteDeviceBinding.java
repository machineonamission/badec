package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeleteDeviceBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final MaterialButton cancelView;
   public final TextView dialogMsg;
   public final TextView dialogTitle;
   public final Guideline leftGuideline;
   public final MaterialButton okView;
   public final ProgressBlockerView progressView;
   public final Guideline rightGuideline;
   public final ConstraintLayout rootLayout;
   private final LinearLayout rootView;
   public final Guideline topGuideline;

   private DialogfragmentDeleteDeviceBinding(LinearLayout var1, Guideline var2, MaterialButton var3, TextView var4, TextView var5, Guideline var6, MaterialButton var7, ProgressBlockerView var8, Guideline var9, ConstraintLayout var10, Guideline var11) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.cancelView = var3;
      this.dialogMsg = var4;
      this.dialogTitle = var5;
      this.leftGuideline = var6;
      this.okView = var7;
      this.progressView = var8;
      this.rightGuideline = var9;
      this.rootLayout = var10;
      this.topGuideline = var11;
   }

   public static DialogfragmentDeleteDeviceBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var10 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.cancel_view;
         MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.dialog_msg;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.dialog_title;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.left_guideline;
                  Guideline var11 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var11 != null) {
                     var1 = R.id.ok_view;
                     MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.progressView;
                        ProgressBlockerView var9 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           var1 = R.id.right_guideline;
                           Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                           if (var2 != null) {
                              var1 = R.id.rootLayout;
                              ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                              if (var3 != null) {
                                 var1 = R.id.top_guideline;
                                 Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                 if (var4 != null) {
                                    return new DialogfragmentDeleteDeviceBinding((LinearLayout)var0, var10, var8, var5, var6, var11, var7, var9, var2, var3, var4);
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

   public static DialogfragmentDeleteDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeleteDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_delete_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
