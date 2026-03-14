package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;
import com.blueair.graph.view.GraphRangeSelector;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.button.MaterialButton;

public final class GraphBinding implements ViewBinding {
   public final MaterialButton buttonInfo;
   public final ConstraintLayout graphHeader;
   public final GraphRangeSelector graphRangeSelectorTop;
   public final View legendExcel;
   public final TextView legendExcelLabel;
   public final View legendGood;
   public final TextView legendGoodLabel;
   public final Group legendLabels;
   public final ConstraintLayout legendLayout;
   public final View legendMod;
   public final TextView legendModLabel;
   public final TextView legendOutdoor;
   public final Group legendOutdoorGroup;
   public final View legendOutdoorSpacer;
   public final View legendPoll;
   public final TextView legendPollLabel;
   public final View legendVpoll;
   public final TextView legendVpollLabel;
   public final LineChart lineChart;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;
   public final View scrollIndicator;
   public final FrameLayout scrollIndicatorRoot;
   public final TextView severityLabel;
   public final TextView valueLabel;

   private GraphBinding(ConstraintLayout var1, MaterialButton var2, ConstraintLayout var3, GraphRangeSelector var4, View var5, TextView var6, View var7, TextView var8, Group var9, ConstraintLayout var10, View var11, TextView var12, TextView var13, Group var14, View var15, View var16, TextView var17, View var18, TextView var19, LineChart var20, ProgressBlockerView var21, View var22, FrameLayout var23, TextView var24, TextView var25) {
      this.rootView = var1;
      this.buttonInfo = var2;
      this.graphHeader = var3;
      this.graphRangeSelectorTop = var4;
      this.legendExcel = var5;
      this.legendExcelLabel = var6;
      this.legendGood = var7;
      this.legendGoodLabel = var8;
      this.legendLabels = var9;
      this.legendLayout = var10;
      this.legendMod = var11;
      this.legendModLabel = var12;
      this.legendOutdoor = var13;
      this.legendOutdoorGroup = var14;
      this.legendOutdoorSpacer = var15;
      this.legendPoll = var16;
      this.legendPollLabel = var17;
      this.legendVpoll = var18;
      this.legendVpollLabel = var19;
      this.lineChart = var20;
      this.progressView = var21;
      this.scrollIndicator = var22;
      this.scrollIndicatorRoot = var23;
      this.severityLabel = var24;
      this.valueLabel = var25;
   }

   public static GraphBinding bind(View var0) {
      int var1 = R.id.button_info;
      MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.graph_header;
         ConstraintLayout var17 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var17 != null) {
            var1 = R.id.graph_range_selector_top;
            GraphRangeSelector var6 = (GraphRangeSelector)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.legend_excel;
               View var9 = ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.legend_excel_label;
                  TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var10 != null) {
                     var1 = R.id.legend_good;
                     View var12 = ViewBindings.findChildViewById(var0, var1);
                     if (var12 != null) {
                        var1 = R.id.legend_good_label;
                        TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.legend_labels;
                           Group var3 = (Group)ViewBindings.findChildViewById(var0, var1);
                           if (var3 != null) {
                              var1 = R.id.legend_layout;
                              ConstraintLayout var14 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                              if (var14 != null) {
                                 var1 = R.id.legend_mod;
                                 View var18 = ViewBindings.findChildViewById(var0, var1);
                                 if (var18 != null) {
                                    var1 = R.id.legend_mod_label;
                                    TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var16 != null) {
                                       var1 = R.id.legend_outdoor;
                                       TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var20 != null) {
                                          var1 = R.id.legend_outdoor_group;
                                          Group var7 = (Group)ViewBindings.findChildViewById(var0, var1);
                                          if (var7 != null) {
                                             var1 = R.id.legend_outdoor_spacer;
                                             View var25 = ViewBindings.findChildViewById(var0, var1);
                                             if (var25 != null) {
                                                var1 = R.id.legend_poll;
                                                View var11 = ViewBindings.findChildViewById(var0, var1);
                                                if (var11 != null) {
                                                   var1 = R.id.legend_poll_label;
                                                   TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var19 != null) {
                                                      var1 = R.id.legend_vpoll;
                                                      View var22 = ViewBindings.findChildViewById(var0, var1);
                                                      if (var22 != null) {
                                                         var1 = R.id.legend_vpoll_label;
                                                         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var2 != null) {
                                                            var1 = R.id.lineChart;
                                                            LineChart var23 = (LineChart)ViewBindings.findChildViewById(var0, var1);
                                                            if (var23 != null) {
                                                               var1 = R.id.progressView;
                                                               ProgressBlockerView var4 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var4 != null) {
                                                                  var1 = R.id.scrollIndicator;
                                                                  View var21 = ViewBindings.findChildViewById(var0, var1);
                                                                  if (var21 != null) {
                                                                     var1 = R.id.scrollIndicatorRoot;
                                                                     FrameLayout var15 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var15 != null) {
                                                                        var1 = R.id.severity_label;
                                                                        TextView var24 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var24 != null) {
                                                                           var1 = R.id.value_label;
                                                                           TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var13 != null) {
                                                                              return new GraphBinding((ConstraintLayout)var0, var5, var17, var6, var9, var10, var12, var8, var3, var14, var18, var16, var20, var7, var25, var11, var19, var22, var2, var23, var4, var21, var15, var24, var13);
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
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static GraphBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static GraphBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.graph, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
