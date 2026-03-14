package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;
import com.blueair.viewcore.view.AllQualityStatusView;

public final class HolderSavedLocationBinding implements ViewBinding {
   public final ConstraintLayout addressContainer;
   public final View aqiIcon;
   public final TextView aqiSeverity;
   public final TextView aqiValue;
   public final ConstraintLayout assignContainer;
   public final TextView assignProduct;
   public final TextView assignedProducts;
   public final Barrier barrier;
   public final Guideline bottomGuideline;
   public final TextView coordinateMismatch;
   public final ImageButton delete;
   public final Guideline leftGuideline;
   public final ConstraintLayout noDataContainer;
   public final TextView noDataTextCaption;
   public final TextView noDataTextHeader;
   public final TextView primaryText;
   public final FrameLayout progressBar;
   public final AllQualityStatusView qualityContainers;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final Button saveBtn;
   public final ConstraintLayout saveContainer;
   public final TextView secondaryText;
   public final Guideline topGuideline;

   private HolderSavedLocationBinding(ConstraintLayout var1, ConstraintLayout var2, View var3, TextView var4, TextView var5, ConstraintLayout var6, TextView var7, TextView var8, Barrier var9, Guideline var10, TextView var11, ImageButton var12, Guideline var13, ConstraintLayout var14, TextView var15, TextView var16, TextView var17, FrameLayout var18, AllQualityStatusView var19, Guideline var20, Button var21, ConstraintLayout var22, TextView var23, Guideline var24) {
      this.rootView = var1;
      this.addressContainer = var2;
      this.aqiIcon = var3;
      this.aqiSeverity = var4;
      this.aqiValue = var5;
      this.assignContainer = var6;
      this.assignProduct = var7;
      this.assignedProducts = var8;
      this.barrier = var9;
      this.bottomGuideline = var10;
      this.coordinateMismatch = var11;
      this.delete = var12;
      this.leftGuideline = var13;
      this.noDataContainer = var14;
      this.noDataTextCaption = var15;
      this.noDataTextHeader = var16;
      this.primaryText = var17;
      this.progressBar = var18;
      this.qualityContainers = var19;
      this.rightGuideline = var20;
      this.saveBtn = var21;
      this.saveContainer = var22;
      this.secondaryText = var23;
      this.topGuideline = var24;
   }

   public static HolderSavedLocationBinding bind(View var0) {
      int var1 = R.id.address_container;
      ConstraintLayout var13 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var13 != null) {
         var1 = R.id.aqi_icon;
         View var8 = ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.aqi_severity;
            TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var12 != null) {
               var1 = R.id.aqi_value;
               TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.assign_container;
                  ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.assign_product;
                     TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var16 != null) {
                        var1 = R.id.assigned_products;
                        TextView var24 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var24 != null) {
                           var1 = R.id.barrier;
                           Barrier var9 = (Barrier)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.bottom_guideline;
                              Guideline var14 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                              if (var14 != null) {
                                 var1 = R.id.coordinate_mismatch;
                                 TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var23 != null) {
                                    var1 = R.id.delete;
                                    ImageButton var7 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
                                    if (var7 != null) {
                                       var1 = R.id.left_guideline;
                                       Guideline var21 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                       if (var21 != null) {
                                          var1 = R.id.no_data_container;
                                          ConstraintLayout var11 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                          if (var11 != null) {
                                             var1 = R.id.no_data_text_caption;
                                             TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var19 != null) {
                                                var1 = R.id.no_data_text_header;
                                                TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var20 != null) {
                                                   var1 = R.id.primary_text;
                                                   TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var10 != null) {
                                                      var1 = R.id.progress_bar;
                                                      FrameLayout var18 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                      if (var18 != null) {
                                                         var1 = R.id.quality_containers;
                                                         AllQualityStatusView var17 = (AllQualityStatusView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var17 != null) {
                                                            var1 = R.id.right_guideline;
                                                            Guideline var22 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                            if (var22 != null) {
                                                               var1 = R.id.save_btn;
                                                               Button var2 = (Button)ViewBindings.findChildViewById(var0, var1);
                                                               if (var2 != null) {
                                                                  var1 = R.id.save_container;
                                                                  ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var4 != null) {
                                                                     var1 = R.id.secondary_text;
                                                                     TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var15 != null) {
                                                                        var1 = R.id.top_guideline;
                                                                        Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var6 != null) {
                                                                           return new HolderSavedLocationBinding((ConstraintLayout)var0, var13, var8, var12, var5, var3, var16, var24, var9, var14, var23, var7, var21, var11, var19, var20, var10, var18, var17, var22, var2, var4, var15, var6);
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
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderSavedLocationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderSavedLocationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_saved_location, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
