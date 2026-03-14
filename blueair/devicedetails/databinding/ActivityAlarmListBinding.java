package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;

public final class ActivityAlarmListBinding implements ViewBinding {
   public final LinearLayout bottomBar;
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnCreate;
   public final AppCompatImageButton btnMore;
   public final ConstraintLayout contentContainer;
   public final ConstraintLayout emptyContainer;
   public final AppCompatImageButton epBtnBack;
   public final AppCompatImageButton epBtnClose;
   public final MaterialButton epBtnCreate;
   public final TextView epTvAlarmDesc;
   public final AppCompatTextView epTvTitle;
   private final AbsorbInsetFrameLayout rootView;
   public final RecyclerView rvList;
   public final View separator;
   public final SimpleStatusBar statusBar;
   public final SimpleStatusBar statusBarEmpty;
   public final AppCompatTextView tvSubtitle;
   public final AppCompatTextView tvTitle;

   private ActivityAlarmListBinding(AbsorbInsetFrameLayout var1, LinearLayout var2, AppCompatImageButton var3, MaterialButton var4, AppCompatImageButton var5, ConstraintLayout var6, ConstraintLayout var7, AppCompatImageButton var8, AppCompatImageButton var9, MaterialButton var10, TextView var11, AppCompatTextView var12, RecyclerView var13, View var14, SimpleStatusBar var15, SimpleStatusBar var16, AppCompatTextView var17, AppCompatTextView var18) {
      this.rootView = var1;
      this.bottomBar = var2;
      this.btnBack = var3;
      this.btnCreate = var4;
      this.btnMore = var5;
      this.contentContainer = var6;
      this.emptyContainer = var7;
      this.epBtnBack = var8;
      this.epBtnClose = var9;
      this.epBtnCreate = var10;
      this.epTvAlarmDesc = var11;
      this.epTvTitle = var12;
      this.rvList = var13;
      this.separator = var14;
      this.statusBar = var15;
      this.statusBarEmpty = var16;
      this.tvSubtitle = var17;
      this.tvTitle = var18;
   }

   public static ActivityAlarmListBinding bind(View var0) {
      int var1 = R.id.bottom_bar;
      LinearLayout var13 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var13 != null) {
         var1 = R.id.btnBack;
         AppCompatImageButton var3 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.btn_create;
            MaterialButton var16 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var16 != null) {
               var1 = R.id.btnMore;
               AppCompatImageButton var14 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
               if (var14 != null) {
                  var1 = R.id.content_container;
                  ConstraintLayout var17 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var17 != null) {
                     var1 = R.id.empty_container;
                     ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.ep_btn_back;
                        AppCompatImageButton var2 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           var1 = R.id.ep_btn_close;
                           AppCompatImageButton var11 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
                           if (var11 != null) {
                              var1 = R.id.ep_btn_create;
                              MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                              if (var8 != null) {
                                 var1 = R.id.ep_tv_alarm_desc;
                                 TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var12 != null) {
                                    var1 = R.id.ep_tv_title;
                                    AppCompatTextView var10 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var10 != null) {
                                       var1 = R.id.rv_list;
                                       RecyclerView var18 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                                       if (var18 != null) {
                                          var1 = R.id.separator;
                                          View var5 = ViewBindings.findChildViewById(var0, var1);
                                          if (var5 != null) {
                                             var1 = R.id.status_bar;
                                             SimpleStatusBar var4 = (SimpleStatusBar)ViewBindings.findChildViewById(var0, var1);
                                             if (var4 != null) {
                                                var1 = R.id.status_bar_empty;
                                                SimpleStatusBar var15 = (SimpleStatusBar)ViewBindings.findChildViewById(var0, var1);
                                                if (var15 != null) {
                                                   var1 = R.id.tv_subtitle;
                                                   AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var6 != null) {
                                                      var1 = R.id.tv_title;
                                                      AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var9 != null) {
                                                         return new ActivityAlarmListBinding((AbsorbInsetFrameLayout)var0, var13, var3, var16, var14, var17, var7, var2, var11, var8, var12, var10, var18, var5, var4, var15, var6, var9);
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
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityAlarmListBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityAlarmListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_alarm_list, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public AbsorbInsetFrameLayout getRoot() {
      return this.rootView;
   }
}
