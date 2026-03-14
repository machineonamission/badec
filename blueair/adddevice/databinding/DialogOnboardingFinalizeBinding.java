package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class DialogOnboardingFinalizeBinding implements ViewBinding {
   public final MaterialButton btnAddAnother;
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnContinue;
   public final ConstraintLayout clRoot;
   public final AppCompatImageButton closeButton;
   public final Group groupSuccess;
   public final AppCompatTextView headerMsg;
   public final AppCompatTextView headerTitle;
   public final LottieAnimationView icon;
   public final LinearProgressIndicator progressIndicator;
   private final AbsorbInsetFrameLayout rootView;
   public final SimpleStatusBar statusBar;
   public final TextView text;
   public final TextView title;

   private DialogOnboardingFinalizeBinding(AbsorbInsetFrameLayout var1, MaterialButton var2, AppCompatImageButton var3, MaterialButton var4, ConstraintLayout var5, AppCompatImageButton var6, Group var7, AppCompatTextView var8, AppCompatTextView var9, LottieAnimationView var10, LinearProgressIndicator var11, SimpleStatusBar var12, TextView var13, TextView var14) {
      this.rootView = var1;
      this.btnAddAnother = var2;
      this.btnBack = var3;
      this.btnContinue = var4;
      this.clRoot = var5;
      this.closeButton = var6;
      this.groupSuccess = var7;
      this.headerMsg = var8;
      this.headerTitle = var9;
      this.icon = var10;
      this.progressIndicator = var11;
      this.statusBar = var12;
      this.text = var13;
      this.title = var14;
   }

   public static DialogOnboardingFinalizeBinding bind(View var0) {
      int var1 = R.id.btn_addAnother;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.btnBack;
         AppCompatImageButton var7 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.btn_continue;
            MaterialButton var14 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var14 != null) {
               var1 = R.id.cl_root;
               ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.close_button;
                  AppCompatImageButton var5 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.group_success;
                     Group var6 = (Group)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.header_msg;
                        AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                        if (var3 != null) {
                           var1 = R.id.header_title;
                           AppCompatTextView var13 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var13 != null) {
                              var1 = R.id.icon;
                              LottieAnimationView var10 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 var1 = R.id.progress_indicator;
                                 LinearProgressIndicator var9 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                                 if (var9 != null) {
                                    var1 = R.id.statusBar;
                                    SimpleStatusBar var12 = (SimpleStatusBar)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       var1 = R.id.text;
                                       TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var8 != null) {
                                          var1 = R.id.title;
                                          TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var11 != null) {
                                             return new DialogOnboardingFinalizeBinding((AbsorbInsetFrameLayout)var0, var4, var7, var14, var2, var5, var6, var3, var13, var10, var9, var12, var8, var11);
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

   public static DialogOnboardingFinalizeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogOnboardingFinalizeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_onboarding_finalize, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public AbsorbInsetFrameLayout getRoot() {
      return this.rootView;
   }
}
