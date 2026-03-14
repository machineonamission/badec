package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;
import com.blueair.outdoor.ui.adapters.LocationView;

public final class ActivityMapsBinding implements ViewBinding {
   public final ImageButton addLocationBtn;
   public final Barrier bottomBarrier;
   public final ImageButton closeBtn;
   public final ConstraintLayout constraintLayout;
   public final LocationView currentLocation;
   public final ImageButton gpsBtn;
   public final FrameLayout mapContainer;
   public final Guideline minimizedBottomGuideline;
   public final ImageView pin;
   public final Guideline rootBottomGuideline;
   public final Guideline rootLeftGuideline;
   public final Guideline rootRightGuideline;
   public final Guideline rootTopGuideline;
   private final ConstraintLayout rootView;
   public final Button savedLocationMaximizeButton;
   public final RecyclerView savedLocationRecyclerView;
   public final TextView searchBar;

   private ActivityMapsBinding(ConstraintLayout var1, ImageButton var2, Barrier var3, ImageButton var4, ConstraintLayout var5, LocationView var6, ImageButton var7, FrameLayout var8, Guideline var9, ImageView var10, Guideline var11, Guideline var12, Guideline var13, Guideline var14, Button var15, RecyclerView var16, TextView var17) {
      this.rootView = var1;
      this.addLocationBtn = var2;
      this.bottomBarrier = var3;
      this.closeBtn = var4;
      this.constraintLayout = var5;
      this.currentLocation = var6;
      this.gpsBtn = var7;
      this.mapContainer = var8;
      this.minimizedBottomGuideline = var9;
      this.pin = var10;
      this.rootBottomGuideline = var11;
      this.rootLeftGuideline = var12;
      this.rootRightGuideline = var13;
      this.rootTopGuideline = var14;
      this.savedLocationMaximizeButton = var15;
      this.savedLocationRecyclerView = var16;
      this.searchBar = var17;
   }

   public static ActivityMapsBinding bind(View var0) {
      int var1 = R.id.add_location_btn;
      ImageButton var6 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.bottom_barrier;
         Barrier var13 = (Barrier)ViewBindings.findChildViewById(var0, var1);
         if (var13 != null) {
            var1 = R.id.close_btn;
            ImageButton var8 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
            if (var8 != null) {
               ConstraintLayout var11 = (ConstraintLayout)var0;
               var1 = R.id.current_location;
               LocationView var15 = (LocationView)ViewBindings.findChildViewById(var0, var1);
               if (var15 != null) {
                  var1 = R.id.gps_btn;
                  ImageButton var10 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
                  if (var10 != null) {
                     var1 = R.id.map_container;
                     FrameLayout var9 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var9 != null) {
                        var1 = R.id.minimized_bottom_guideline;
                        Guideline var12 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var12 != null) {
                           var1 = R.id.pin;
                           ImageView var14 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var14 != null) {
                              var1 = R.id.root_bottom_guideline;
                              Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.root_left_guideline;
                                 Guideline var17 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                 if (var17 != null) {
                                    var1 = R.id.root_right_guideline;
                                    Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                    if (var4 != null) {
                                       var1 = R.id.root_top_guideline;
                                       Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                       if (var7 != null) {
                                          var1 = R.id.saved_location_maximize_button;
                                          Button var2 = (Button)ViewBindings.findChildViewById(var0, var1);
                                          if (var2 != null) {
                                             var1 = R.id.saved_location_recycler_view;
                                             RecyclerView var16 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                                             if (var16 != null) {
                                                var1 = R.id.search_bar;
                                                TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var3 != null) {
                                                   return new ActivityMapsBinding(var11, var6, var13, var8, var11, var15, var10, var9, var12, var14, var5, var17, var4, var7, var2, var16, var3);
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

   public static ActivityMapsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityMapsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_maps, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
