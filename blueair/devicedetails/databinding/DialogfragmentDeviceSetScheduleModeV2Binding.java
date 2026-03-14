package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceSetScheduleModeV2Binding implements ViewBinding {
   public final LinearLayout bottomBar;
   public final AppCompatImageView btnClose;
   public final MaterialButton btnDone;
   public final ConstraintLayout contentContainer;
   private final FrameLayout rootView;
   public final ShadowedRecyclerViewLayout rvControlGroup;
   public final RecyclerView rvModeButtons;
   public final NestedScrollView scrollable;
   public final View separator;
   public final ShadowLayout standbyContainer;
   public final ImageView standbyIcon;
   public final TextView standbyText;
   public final TextView title;

   private DialogfragmentDeviceSetScheduleModeV2Binding(FrameLayout var1, LinearLayout var2, AppCompatImageView var3, MaterialButton var4, ConstraintLayout var5, ShadowedRecyclerViewLayout var6, RecyclerView var7, NestedScrollView var8, View var9, ShadowLayout var10, ImageView var11, TextView var12, TextView var13) {
      this.rootView = var1;
      this.bottomBar = var2;
      this.btnClose = var3;
      this.btnDone = var4;
      this.contentContainer = var5;
      this.rvControlGroup = var6;
      this.rvModeButtons = var7;
      this.scrollable = var8;
      this.separator = var9;
      this.standbyContainer = var10;
      this.standbyIcon = var11;
      this.standbyText = var12;
      this.title = var13;
   }

   public static DialogfragmentDeviceSetScheduleModeV2Binding bind(View var0) {
      int var1 = R.id.bottom_bar;
      LinearLayout var2 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.btn_close;
         AppCompatImageView var13 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var13 != null) {
            var1 = R.id.btn_done;
            MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.content_container;
               ConstraintLayout var9 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.rv_control_group;
                  ShadowedRecyclerViewLayout var11 = (ShadowedRecyclerViewLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var11 != null) {
                     var1 = R.id.rv_mode_buttons;
                     RecyclerView var3 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        var1 = R.id.scrollable;
                        NestedScrollView var10 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
                        if (var10 != null) {
                           var1 = R.id.separator;
                           View var4 = ViewBindings.findChildViewById(var0, var1);
                           if (var4 != null) {
                              var1 = R.id.standby_container;
                              ShadowLayout var6 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                              if (var6 != null) {
                                 var1 = R.id.standby_icon;
                                 ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var8 != null) {
                                    var1 = R.id.standby_text;
                                    TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var7 != null) {
                                       var1 = R.id.title;
                                       TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var12 != null) {
                                          return new DialogfragmentDeviceSetScheduleModeV2Binding((FrameLayout)var0, var2, var13, var5, var9, var11, var3, var10, var4, var6, var8, var7, var12);
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

   public static DialogfragmentDeviceSetScheduleModeV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceSetScheduleModeV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_set_schedule_mode_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
