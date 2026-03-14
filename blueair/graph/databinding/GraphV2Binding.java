package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;

public final class GraphV2Binding implements ViewBinding {
   public final Barrier barrierLabelYStart;
   public final ConstraintLayout clLegendAqi;
   public final ConstraintLayout clLegendHum;
   public final View dividerH1;
   public final View dividerH2;
   public final View dividerH3;
   public final View dividerH4;
   public final View dividerH5;
   public final View dividerH6;
   public final View dividerH7;
   public final View dividerHBottom;
   public final View dividerHHidden;
   public final View dividerHTop;
   public final View gradientHum;
   public final Group groupAqi;
   public final Group groupHum;
   public final Group groupTmp;
   public final TextView labelYAqi1;
   public final TextView labelYAqi2;
   public final TextView labelYAqi3;
   public final TextView labelYAqi4;
   public final TextView labelYAqi5;
   public final TextView labelYHum1;
   public final TextView labelYHum2;
   public final TextView labelYHum3;
   public final TextView labelYHum4;
   public final TextView labelYTmp1;
   public final TextView labelYTmp2;
   public final TextView labelYTmp3;
   public final TextView labelYTmp4;
   public final TextView labelYTmp5;
   public final TextView labelYTmp6;
   public final TextView legendAqi1;
   public final TextView legendAqi2;
   public final TextView legendAqi3;
   public final TextView legendAqi4;
   public final TextView legendAqi5;
   public final TextView legendHum1;
   public final TextView legendHum2;
   public final TextView legendHum3;
   public final View legendYAqi1;
   public final View legendYAqi2;
   public final View legendYAqi3;
   public final View legendYAqi4;
   public final View legendYAqi5;
   public final View legendYHum1;
   public final View legendYHum2;
   public final View legendYHum3;
   public final LineChart lineChart;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;
   public final View scrollIndicator;
   public final FrameLayout scrollIndicatorTrack;
   public final TextView timeLabel;

   private GraphV2Binding(ConstraintLayout var1, Barrier var2, ConstraintLayout var3, ConstraintLayout var4, View var5, View var6, View var7, View var8, View var9, View var10, View var11, View var12, View var13, View var14, View var15, Group var16, Group var17, Group var18, TextView var19, TextView var20, TextView var21, TextView var22, TextView var23, TextView var24, TextView var25, TextView var26, TextView var27, TextView var28, TextView var29, TextView var30, TextView var31, TextView var32, TextView var33, TextView var34, TextView var35, TextView var36, TextView var37, TextView var38, TextView var39, TextView var40, TextView var41, View var42, View var43, View var44, View var45, View var46, View var47, View var48, View var49, LineChart var50, ProgressBlockerView var51, View var52, FrameLayout var53, TextView var54) {
      this.rootView = var1;
      this.barrierLabelYStart = var2;
      this.clLegendAqi = var3;
      this.clLegendHum = var4;
      this.dividerH1 = var5;
      this.dividerH2 = var6;
      this.dividerH3 = var7;
      this.dividerH4 = var8;
      this.dividerH5 = var9;
      this.dividerH6 = var10;
      this.dividerH7 = var11;
      this.dividerHBottom = var12;
      this.dividerHHidden = var13;
      this.dividerHTop = var14;
      this.gradientHum = var15;
      this.groupAqi = var16;
      this.groupHum = var17;
      this.groupTmp = var18;
      this.labelYAqi1 = var19;
      this.labelYAqi2 = var20;
      this.labelYAqi3 = var21;
      this.labelYAqi4 = var22;
      this.labelYAqi5 = var23;
      this.labelYHum1 = var24;
      this.labelYHum2 = var25;
      this.labelYHum3 = var26;
      this.labelYHum4 = var27;
      this.labelYTmp1 = var28;
      this.labelYTmp2 = var29;
      this.labelYTmp3 = var30;
      this.labelYTmp4 = var31;
      this.labelYTmp5 = var32;
      this.labelYTmp6 = var33;
      this.legendAqi1 = var34;
      this.legendAqi2 = var35;
      this.legendAqi3 = var36;
      this.legendAqi4 = var37;
      this.legendAqi5 = var38;
      this.legendHum1 = var39;
      this.legendHum2 = var40;
      this.legendHum3 = var41;
      this.legendYAqi1 = var42;
      this.legendYAqi2 = var43;
      this.legendYAqi3 = var44;
      this.legendYAqi4 = var45;
      this.legendYAqi5 = var46;
      this.legendYHum1 = var47;
      this.legendYHum2 = var48;
      this.legendYHum3 = var49;
      this.lineChart = var50;
      this.progressView = var51;
      this.scrollIndicator = var52;
      this.scrollIndicatorTrack = var53;
      this.timeLabel = var54;
   }

   public static GraphV2Binding bind(View var0) {
      int var1 = R.id.barrier_label_y_start;
      Barrier var25 = (Barrier)ViewBindings.findChildViewById(var0, var1);
      if (var25 != null) {
         var1 = R.id.cl_legend_aqi;
         ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.cl_legend_hum;
            ConstraintLayout var5 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.divider_h_1;
               View var14 = ViewBindings.findChildViewById(var0, var1);
               if (var14 != null) {
                  var1 = R.id.divider_h_2;
                  View var39 = ViewBindings.findChildViewById(var0, var1);
                  if (var39 != null) {
                     var1 = R.id.divider_h_3;
                     View var12 = ViewBindings.findChildViewById(var0, var1);
                     if (var12 != null) {
                        var1 = R.id.divider_h_4;
                        View var50 = ViewBindings.findChildViewById(var0, var1);
                        if (var50 != null) {
                           var1 = R.id.divider_h_5;
                           View var34 = ViewBindings.findChildViewById(var0, var1);
                           if (var34 != null) {
                              var1 = R.id.divider_h_6;
                              View var20 = ViewBindings.findChildViewById(var0, var1);
                              if (var20 != null) {
                                 var1 = R.id.divider_h_7;
                                 View var10 = ViewBindings.findChildViewById(var0, var1);
                                 if (var10 != null) {
                                    var1 = R.id.divider_h_bottom;
                                    View var48 = ViewBindings.findChildViewById(var0, var1);
                                    if (var48 != null) {
                                       var1 = R.id.divider_h_hidden;
                                       View var38 = ViewBindings.findChildViewById(var0, var1);
                                       if (var38 != null) {
                                          var1 = R.id.divider_h_top;
                                          View var16 = ViewBindings.findChildViewById(var0, var1);
                                          if (var16 != null) {
                                             var1 = R.id.gradient_hum;
                                             View var31 = ViewBindings.findChildViewById(var0, var1);
                                             if (var31 != null) {
                                                var1 = R.id.group_aqi;
                                                Group var42 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                if (var42 != null) {
                                                   var1 = R.id.group_hum;
                                                   Group var13 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                   if (var13 != null) {
                                                      var1 = R.id.group_tmp;
                                                      Group var35 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                      if (var35 != null) {
                                                         var1 = R.id.label_y_aqi_1;
                                                         TextView var28 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var28 != null) {
                                                            var1 = R.id.label_y_aqi_2;
                                                            TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var11 != null) {
                                                               var1 = R.id.label_y_aqi_3;
                                                               TextView var17 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var17 != null) {
                                                                  var1 = R.id.label_y_aqi_4;
                                                                  TextView var29 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var29 != null) {
                                                                     var1 = R.id.label_y_aqi_5;
                                                                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var2 != null) {
                                                                        var1 = R.id.label_y_hum_1;
                                                                        TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var18 != null) {
                                                                           var1 = R.id.label_y_hum_2;
                                                                           TextView var54 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var54 != null) {
                                                                              var1 = R.id.label_y_hum_3;
                                                                              TextView var41 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var41 != null) {
                                                                                 var1 = R.id.label_y_hum_4;
                                                                                 TextView var47 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var47 != null) {
                                                                                    var1 = R.id.label_y_tmp_1;
                                                                                    TextView var32 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var32 != null) {
                                                                                       var1 = R.id.label_y_tmp_2;
                                                                                       TextView var43 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var43 != null) {
                                                                                          var1 = R.id.label_y_tmp_3;
                                                                                          TextView var33 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var33 != null) {
                                                                                             var1 = R.id.label_y_tmp_4;
                                                                                             TextView var27 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var27 != null) {
                                                                                                var1 = R.id.label_y_tmp_5;
                                                                                                TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var7 != null) {
                                                                                                   var1 = R.id.label_y_tmp_6;
                                                                                                   TextView var45 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var45 != null) {
                                                                                                      var1 = R.id.legend_aqi_1;
                                                                                                      TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var21 != null) {
                                                                                                         var1 = R.id.legend_aqi_2;
                                                                                                         TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var22 != null) {
                                                                                                            var1 = R.id.legend_aqi_3;
                                                                                                            TextView var52 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var52 != null) {
                                                                                                               var1 = R.id.legend_aqi_4;
                                                                                                               TextView var49 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var49 != null) {
                                                                                                                  var1 = R.id.legend_aqi_5;
                                                                                                                  TextView var30 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var30 != null) {
                                                                                                                     var1 = R.id.legend_hum_1;
                                                                                                                     TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var23 != null) {
                                                                                                                        var1 = R.id.legend_hum_2;
                                                                                                                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var6 != null) {
                                                                                                                           var1 = R.id.legend_hum_3;
                                                                                                                           TextView var36 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                           if (var36 != null) {
                                                                                                                              var1 = R.id.legend_y_aqi_1;
                                                                                                                              View var8 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                              if (var8 != null) {
                                                                                                                                 var1 = R.id.legend_y_aqi_2;
                                                                                                                                 View var9 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                 if (var9 != null) {
                                                                                                                                    var1 = R.id.legend_y_aqi_3;
                                                                                                                                    View var26 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                    if (var26 != null) {
                                                                                                                                       var1 = R.id.legend_y_aqi_4;
                                                                                                                                       View var37 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                       if (var37 != null) {
                                                                                                                                          var1 = R.id.legend_y_aqi_5;
                                                                                                                                          View var53 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                          if (var53 != null) {
                                                                                                                                             var1 = R.id.legend_y_hum_1;
                                                                                                                                             View var51 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                             if (var51 != null) {
                                                                                                                                                var1 = R.id.legend_y_hum_2;
                                                                                                                                                View var4 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                if (var4 != null) {
                                                                                                                                                   var1 = R.id.legend_y_hum_3;
                                                                                                                                                   View var15 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                   if (var15 != null) {
                                                                                                                                                      var1 = R.id.lineChart;
                                                                                                                                                      LineChart var46 = (LineChart)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                      if (var46 != null) {
                                                                                                                                                         var1 = R.id.progressView;
                                                                                                                                                         ProgressBlockerView var44 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                         if (var44 != null) {
                                                                                                                                                            var1 = R.id.scroll_indicator;
                                                                                                                                                            View var19 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                            if (var19 != null) {
                                                                                                                                                               var1 = R.id.scroll_indicator_track;
                                                                                                                                                               FrameLayout var24 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                               if (var24 != null) {
                                                                                                                                                                  var1 = R.id.time_label;
                                                                                                                                                                  TextView var40 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                  if (var40 != null) {
                                                                                                                                                                     return new GraphV2Binding((ConstraintLayout)var0, var25, var3, var5, var14, var39, var12, var50, var34, var20, var10, var48, var38, var16, var31, var42, var13, var35, var28, var11, var17, var29, var2, var18, var54, var41, var47, var32, var43, var33, var27, var7, var45, var21, var22, var52, var49, var30, var23, var6, var36, var8, var9, var26, var37, var53, var51, var4, var15, var46, var44, var19, var24, var40);
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
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static GraphV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static GraphV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.graph_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
