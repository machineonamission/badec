package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;

public final class GraphHBinding implements ViewBinding {
   public final Barrier barrierLabelYStart;
   public final Barrier barrierLegendBottom;
   public final View dividerH1;
   public final View dividerH2;
   public final View dividerH3;
   public final View dividerH4;
   public final View dividerH5;
   public final View dividerHBottom;
   public final View dividerHTop;
   public final TextView graphTitle;
   public final FrameLayout graphTitleContainer;
   public final Group groupAqi;
   public final Group groupHum;
   public final Group groupTmp;
   public final TextView labelYHum1;
   public final TextView labelYHum2;
   public final TextView labelYHum3;
   public final TextView labelYHum4;
   public final TextView labelYHum5;
   public final TextView labelYHum6;
   public final TextView labelYHum7;
   public final TextView labelYTmp1;
   public final TextView labelYTmp2;
   public final TextView labelYTmp3;
   public final TextView labelYTmp4;
   public final TextView labelYTmp5;
   public final TextView labelYTmp6;
   public final TextView labelYTmp7;
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
   public final RadioGroup radioGroupTimeScale;
   public final RadioButton rbDay;
   public final RadioButton rbMonth;
   public final RadioButton rbWeek;
   public final View rgSeparator1;
   public final View rgSeparator2;
   private final ConstraintLayout rootView;
   public final View scrollIndicator;
   public final FrameLayout scrollIndicatorTrack;
   public final TextView timeLabel;

   private GraphHBinding(ConstraintLayout var1, Barrier var2, Barrier var3, View var4, View var5, View var6, View var7, View var8, View var9, View var10, TextView var11, FrameLayout var12, Group var13, Group var14, Group var15, TextView var16, TextView var17, TextView var18, TextView var19, TextView var20, TextView var21, TextView var22, TextView var23, TextView var24, TextView var25, TextView var26, TextView var27, TextView var28, TextView var29, TextView var30, TextView var31, TextView var32, TextView var33, TextView var34, TextView var35, TextView var36, TextView var37, View var38, View var39, View var40, View var41, View var42, View var43, View var44, View var45, LineChart var46, ProgressBlockerView var47, RadioGroup var48, RadioButton var49, RadioButton var50, RadioButton var51, View var52, View var53, View var54, FrameLayout var55, TextView var56) {
      this.rootView = var1;
      this.barrierLabelYStart = var2;
      this.barrierLegendBottom = var3;
      this.dividerH1 = var4;
      this.dividerH2 = var5;
      this.dividerH3 = var6;
      this.dividerH4 = var7;
      this.dividerH5 = var8;
      this.dividerHBottom = var9;
      this.dividerHTop = var10;
      this.graphTitle = var11;
      this.graphTitleContainer = var12;
      this.groupAqi = var13;
      this.groupHum = var14;
      this.groupTmp = var15;
      this.labelYHum1 = var16;
      this.labelYHum2 = var17;
      this.labelYHum3 = var18;
      this.labelYHum4 = var19;
      this.labelYHum5 = var20;
      this.labelYHum6 = var21;
      this.labelYHum7 = var22;
      this.labelYTmp1 = var23;
      this.labelYTmp2 = var24;
      this.labelYTmp3 = var25;
      this.labelYTmp4 = var26;
      this.labelYTmp5 = var27;
      this.labelYTmp6 = var28;
      this.labelYTmp7 = var29;
      this.legendAqi1 = var30;
      this.legendAqi2 = var31;
      this.legendAqi3 = var32;
      this.legendAqi4 = var33;
      this.legendAqi5 = var34;
      this.legendHum1 = var35;
      this.legendHum2 = var36;
      this.legendHum3 = var37;
      this.legendYAqi1 = var38;
      this.legendYAqi2 = var39;
      this.legendYAqi3 = var40;
      this.legendYAqi4 = var41;
      this.legendYAqi5 = var42;
      this.legendYHum1 = var43;
      this.legendYHum2 = var44;
      this.legendYHum3 = var45;
      this.lineChart = var46;
      this.progressView = var47;
      this.radioGroupTimeScale = var48;
      this.rbDay = var49;
      this.rbMonth = var50;
      this.rbWeek = var51;
      this.rgSeparator1 = var52;
      this.rgSeparator2 = var53;
      this.scrollIndicator = var54;
      this.scrollIndicatorTrack = var55;
      this.timeLabel = var56;
   }

   public static GraphHBinding bind(View var0) {
      int var1 = R.id.barrier_label_y_start;
      Barrier var20 = (Barrier)ViewBindings.findChildViewById(var0, var1);
      if (var20 != null) {
         var1 = R.id.barrier_legend_bottom;
         Barrier var34 = (Barrier)ViewBindings.findChildViewById(var0, var1);
         if (var34 != null) {
            var1 = R.id.divider_h_1;
            View var25 = ViewBindings.findChildViewById(var0, var1);
            if (var25 != null) {
               var1 = R.id.divider_h_2;
               View var19 = ViewBindings.findChildViewById(var0, var1);
               if (var19 != null) {
                  var1 = R.id.divider_h_3;
                  View var12 = ViewBindings.findChildViewById(var0, var1);
                  if (var12 != null) {
                     var1 = R.id.divider_h_4;
                     View var37 = ViewBindings.findChildViewById(var0, var1);
                     if (var37 != null) {
                        var1 = R.id.divider_h_5;
                        View var36 = ViewBindings.findChildViewById(var0, var1);
                        if (var36 != null) {
                           var1 = R.id.divider_h_bottom;
                           View var28 = ViewBindings.findChildViewById(var0, var1);
                           if (var28 != null) {
                              var1 = R.id.divider_h_top;
                              View var4 = ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 var1 = R.id.graph_title;
                                 TextView var33 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var33 != null) {
                                    var1 = R.id.graph_title_container;
                                    FrameLayout var48 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var48 != null) {
                                       var1 = R.id.group_aqi;
                                       Group var5 = (Group)ViewBindings.findChildViewById(var0, var1);
                                       if (var5 != null) {
                                          var1 = R.id.group_hum;
                                          Group var26 = (Group)ViewBindings.findChildViewById(var0, var1);
                                          if (var26 != null) {
                                             var1 = R.id.group_tmp;
                                             Group var11 = (Group)ViewBindings.findChildViewById(var0, var1);
                                             if (var11 != null) {
                                                var1 = R.id.label_y_hum_1;
                                                TextView var50 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var50 != null) {
                                                   var1 = R.id.label_y_hum_2;
                                                   TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var18 != null) {
                                                      var1 = R.id.label_y_hum_3;
                                                      TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var15 != null) {
                                                         var1 = R.id.label_y_hum_4;
                                                         TextView var32 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var32 != null) {
                                                            var1 = R.id.label_y_hum_5;
                                                            TextView var46 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var46 != null) {
                                                               var1 = R.id.label_y_hum_6;
                                                               TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var23 != null) {
                                                                  var1 = R.id.label_y_hum_7;
                                                                  TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var16 != null) {
                                                                     var1 = R.id.label_y_tmp_1;
                                                                     TextView var39 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var39 != null) {
                                                                        var1 = R.id.label_y_tmp_2;
                                                                        TextView var30 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var30 != null) {
                                                                           var1 = R.id.label_y_tmp_3;
                                                                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var9 != null) {
                                                                              var1 = R.id.label_y_tmp_4;
                                                                              TextView var43 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var43 != null) {
                                                                                 var1 = R.id.label_y_tmp_5;
                                                                                 TextView var17 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var17 != null) {
                                                                                    var1 = R.id.label_y_tmp_6;
                                                                                    TextView var53 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var53 != null) {
                                                                                       var1 = R.id.label_y_tmp_7;
                                                                                       TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var22 != null) {
                                                                                          var1 = R.id.legend_aqi_1;
                                                                                          TextView var44 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var44 != null) {
                                                                                             var1 = R.id.legend_aqi_2;
                                                                                             TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var6 != null) {
                                                                                                var1 = R.id.legend_aqi_3;
                                                                                                TextView var47 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var47 != null) {
                                                                                                   var1 = R.id.legend_aqi_4;
                                                                                                   TextView var54 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var54 != null) {
                                                                                                      var1 = R.id.legend_aqi_5;
                                                                                                      TextView var41 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var41 != null) {
                                                                                                         var1 = R.id.legend_hum_1;
                                                                                                         TextView var31 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var31 != null) {
                                                                                                            var1 = R.id.legend_hum_2;
                                                                                                            TextView var38 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var38 != null) {
                                                                                                               var1 = R.id.legend_hum_3;
                                                                                                               TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var13 != null) {
                                                                                                                  var1 = R.id.legend_y_aqi_1;
                                                                                                                  View var10 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var10 != null) {
                                                                                                                     var1 = R.id.legend_y_aqi_2;
                                                                                                                     View var51 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var51 != null) {
                                                                                                                        var1 = R.id.legend_y_aqi_3;
                                                                                                                        View var49 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var49 != null) {
                                                                                                                           var1 = R.id.legend_y_aqi_4;
                                                                                                                           View var2 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                           if (var2 != null) {
                                                                                                                              var1 = R.id.legend_y_aqi_5;
                                                                                                                              View var35 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                              if (var35 != null) {
                                                                                                                                 var1 = R.id.legend_y_hum_1;
                                                                                                                                 View var29 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                 if (var29 != null) {
                                                                                                                                    var1 = R.id.legend_y_hum_2;
                                                                                                                                    View var56 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                    if (var56 != null) {
                                                                                                                                       var1 = R.id.legend_y_hum_3;
                                                                                                                                       View var42 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                       if (var42 != null) {
                                                                                                                                          var1 = R.id.lineChart;
                                                                                                                                          LineChart var45 = (LineChart)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                          if (var45 != null) {
                                                                                                                                             var1 = R.id.progressView;
                                                                                                                                             ProgressBlockerView var14 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                             if (var14 != null) {
                                                                                                                                                var1 = R.id.radio_group_time_scale;
                                                                                                                                                RadioGroup var55 = (RadioGroup)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                if (var55 != null) {
                                                                                                                                                   var1 = R.id.rb_day;
                                                                                                                                                   RadioButton var52 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                   if (var52 != null) {
                                                                                                                                                      var1 = R.id.rb_month;
                                                                                                                                                      RadioButton var24 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                      if (var24 != null) {
                                                                                                                                                         var1 = R.id.rb_week;
                                                                                                                                                         RadioButton var7 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                         if (var7 != null) {
                                                                                                                                                            var1 = R.id.rg_separator_1;
                                                                                                                                                            View var27 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                            if (var27 != null) {
                                                                                                                                                               var1 = R.id.rg_separator_2;
                                                                                                                                                               View var3 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                               if (var3 != null) {
                                                                                                                                                                  var1 = R.id.scroll_indicator;
                                                                                                                                                                  View var8 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                  if (var8 != null) {
                                                                                                                                                                     var1 = R.id.scroll_indicator_track;
                                                                                                                                                                     FrameLayout var21 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                     if (var21 != null) {
                                                                                                                                                                        var1 = R.id.time_label;
                                                                                                                                                                        TextView var40 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                        if (var40 != null) {
                                                                                                                                                                           return new GraphHBinding((ConstraintLayout)var0, var20, var34, var25, var19, var12, var37, var36, var28, var4, var33, var48, var5, var26, var11, var50, var18, var15, var32, var46, var23, var16, var39, var30, var9, var43, var17, var53, var22, var44, var6, var47, var54, var41, var31, var38, var13, var10, var51, var49, var2, var35, var29, var56, var42, var45, var14, var55, var52, var24, var7, var27, var3, var8, var21, var40);
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
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static GraphHBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static GraphHBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.graph_h, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
