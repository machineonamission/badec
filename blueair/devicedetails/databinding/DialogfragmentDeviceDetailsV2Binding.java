package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.blueair.viewcore.view.SwitchCompat;
import eightbitlab.com.blurview.BlurView;

public final class DialogfragmentDeviceDetailsV2Binding implements ViewBinding {
   public final AppCompatImageButton btnBack;
   public final SwitchCompat btnStandby;
   public final BlurView bvTitle;
   public final ConstraintLayout contentContainer;
   public final LinearLayout controlsContainer;
   public final ImageView deviceImage;
   public final TextView deviceName;
   public final View deviceNameMaxWidth;
   public final FrameLayout devicesControlsContainer;
   public final FrameLayout graphContainer;
   public final FrameLayout messagesContainer;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final NestedScrollView scrollable;
   public final RecyclerView sensorCardList;
   public final SimpleStatusBar statusBar;
   public final ConstraintLayout titleBar;
   public final View vBottomDivider;

   private DialogfragmentDeviceDetailsV2Binding(ConstraintLayout var1, AppCompatImageButton var2, SwitchCompat var3, BlurView var4, ConstraintLayout var5, LinearLayout var6, ImageView var7, TextView var8, View var9, FrameLayout var10, FrameLayout var11, FrameLayout var12, ConstraintLayout var13, NestedScrollView var14, RecyclerView var15, SimpleStatusBar var16, ConstraintLayout var17, View var18) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnStandby = var3;
      this.bvTitle = var4;
      this.contentContainer = var5;
      this.controlsContainer = var6;
      this.deviceImage = var7;
      this.deviceName = var8;
      this.deviceNameMaxWidth = var9;
      this.devicesControlsContainer = var10;
      this.graphContainer = var11;
      this.messagesContainer = var12;
      this.rootLayout = var13;
      this.scrollable = var14;
      this.sensorCardList = var15;
      this.statusBar = var16;
      this.titleBar = var17;
      this.vBottomDivider = var18;
   }

   public static DialogfragmentDeviceDetailsV2Binding bind(View var0) {
      int var1 = R.id.btn_back;
      AppCompatImageButton var6 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.btn_standby;
         SwitchCompat var17 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
         if (var17 != null) {
            var1 = R.id.bv_title;
            BlurView var2 = (BlurView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.content_container;
               ConstraintLayout var14 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var14 != null) {
                  var1 = R.id.controls_container;
                  LinearLayout var12 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var12 != null) {
                     var1 = R.id.device_image;
                     ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.device_name;
                        TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var15 != null) {
                           var1 = R.id.device_name_max_width;
                           View var13 = ViewBindings.findChildViewById(var0, var1);
                           if (var13 != null) {
                              var1 = R.id.devices_controls_container;
                              FrameLayout var5 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.graph_container;
                                 FrameLayout var18 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                 if (var18 != null) {
                                    var1 = R.id.messages_container;
                                    FrameLayout var4 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var4 != null) {
                                       ConstraintLayout var10 = (ConstraintLayout)var0;
                                       var1 = R.id.scrollable;
                                       NestedScrollView var16 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
                                       if (var16 != null) {
                                          var1 = R.id.sensor_card_list;
                                          RecyclerView var7 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                                          if (var7 != null) {
                                             var1 = R.id.statusBar;
                                             SimpleStatusBar var11 = (SimpleStatusBar)ViewBindings.findChildViewById(var0, var1);
                                             if (var11 != null) {
                                                var1 = R.id.title_bar;
                                                ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                if (var3 != null) {
                                                   var1 = R.id.v_bottomDivider;
                                                   View var9 = ViewBindings.findChildViewById(var0, var1);
                                                   if (var9 != null) {
                                                      return new DialogfragmentDeviceDetailsV2Binding(var10, var6, var17, var2, var14, var12, var8, var15, var13, var5, var18, var4, var10, var16, var7, var11, var3, var9);
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

   public static DialogfragmentDeviceDetailsV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceDetailsV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_details_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
