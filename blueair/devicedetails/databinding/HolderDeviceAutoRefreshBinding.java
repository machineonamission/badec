package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceAutoRefreshBinding implements ViewBinding {
   public final ConstraintLayout autoRefreshContainer;
   public final MaterialButton btnCancel;
   public final Button btnCloseHint;
   public final LinearLayout contentContainer;
   public final TextView durationText;
   public final Group expendedContent;
   public final ConstraintLayout hintContainer;
   public final TextView hintText;
   public final ImageView infoIcon;
   public final ImageView leadingIcon;
   public final TextView leftTimeText;
   public final LinearProgressIndicator progressIndicator;
   private final LinearLayout rootView;
   public final TextView title;

   private HolderDeviceAutoRefreshBinding(LinearLayout var1, ConstraintLayout var2, MaterialButton var3, Button var4, LinearLayout var5, TextView var6, Group var7, ConstraintLayout var8, TextView var9, ImageView var10, ImageView var11, TextView var12, LinearProgressIndicator var13, TextView var14) {
      this.rootView = var1;
      this.autoRefreshContainer = var2;
      this.btnCancel = var3;
      this.btnCloseHint = var4;
      this.contentContainer = var5;
      this.durationText = var6;
      this.expendedContent = var7;
      this.hintContainer = var8;
      this.hintText = var9;
      this.infoIcon = var10;
      this.leadingIcon = var11;
      this.leftTimeText = var12;
      this.progressIndicator = var13;
      this.title = var14;
   }

   public static HolderDeviceAutoRefreshBinding bind(View var0) {
      int var1 = R.id.auto_refresh_container;
      ConstraintLayout var5 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.btn_cancel;
         MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.btn_close_hint;
            Button var14 = (Button)ViewBindings.findChildViewById(var0, var1);
            if (var14 != null) {
               LinearLayout var9 = (LinearLayout)var0;
               var1 = R.id.duration_text;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.expended_content;
                  Group var12 = (Group)ViewBindings.findChildViewById(var0, var1);
                  if (var12 != null) {
                     var1 = R.id.hint_container;
                     ConstraintLayout var10 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var10 != null) {
                        var1 = R.id.hint_text;
                        TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var13 != null) {
                           var1 = R.id.info_icon;
                           ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var8 != null) {
                              var1 = R.id.leading_icon;
                              ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 var1 = R.id.left_time_text;
                                 TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var3 != null) {
                                    var1 = R.id.progress_indicator;
                                    LinearProgressIndicator var6 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                                    if (var6 != null) {
                                       var1 = R.id.title;
                                       TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var7 != null) {
                                          return new HolderDeviceAutoRefreshBinding(var9, var5, var11, var14, var9, var2, var12, var10, var13, var8, var4, var3, var6, var7);
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

   public static HolderDeviceAutoRefreshBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceAutoRefreshBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_auto_refresh, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
