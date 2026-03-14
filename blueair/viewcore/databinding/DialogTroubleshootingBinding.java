package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class DialogTroubleshootingBinding implements ViewBinding {
   public final MaterialButton btnTryAgain;
   public final AppCompatImageButton closeButton;
   public final LinearLayout llContainer;
   public final NestedScrollView nsvContainer;
   private final LinearLayout rootView;
   public final RecyclerView rvList;
   public final AppCompatTextView screenTitle;
   public final AppCompatTextView tvCantSeeMsg;
   public final AppCompatTextView tvFooter;
   public final AppCompatTextView tvHeader;
   public final View vTop;

   private DialogTroubleshootingBinding(LinearLayout var1, MaterialButton var2, AppCompatImageButton var3, LinearLayout var4, NestedScrollView var5, RecyclerView var6, AppCompatTextView var7, AppCompatTextView var8, AppCompatTextView var9, AppCompatTextView var10, View var11) {
      this.rootView = var1;
      this.btnTryAgain = var2;
      this.closeButton = var3;
      this.llContainer = var4;
      this.nsvContainer = var5;
      this.rvList = var6;
      this.screenTitle = var7;
      this.tvCantSeeMsg = var8;
      this.tvFooter = var9;
      this.tvHeader = var10;
      this.vTop = var11;
   }

   public static DialogTroubleshootingBinding bind(View var0) {
      int var1 = R.id.btn_tryAgain;
      MaterialButton var10 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.close_button;
         AppCompatImageButton var11 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.ll_container;
            LinearLayout var3 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.nsv_container;
               NestedScrollView var9 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.rv_list;
                  RecyclerView var7 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.screen_title;
                     AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.tv_cantSeeMsg;
                        AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           var1 = R.id.tv_footer;
                           AppCompatTextView var8 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var8 != null) {
                              var1 = R.id.tv_header;
                              AppCompatTextView var2 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var2 != null) {
                                 var1 = R.id.v_top;
                                 View var4 = ViewBindings.findChildViewById(var0, var1);
                                 if (var4 != null) {
                                    return new DialogTroubleshootingBinding((LinearLayout)var0, var10, var11, var3, var9, var7, var6, var5, var8, var2, var4);
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

   public static DialogTroubleshootingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogTroubleshootingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_troubleshooting, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
