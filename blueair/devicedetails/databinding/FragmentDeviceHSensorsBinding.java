package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.graph.view.GraphViewH;
import com.google.android.material.tabs.TabLayout;

public final class FragmentDeviceHSensorsBinding implements ViewBinding {
   public final TextView aqiData;
   public final TextView aqiTitle;
   public final ConstraintLayout contentAqi;
   public final ConstraintLayout contentHumidity;
   public final ConstraintLayout contentParticle;
   public final ConstraintLayout contentTemperature;
   public final GraphViewH deviceGraph;
   public final TabLayout graphTabs;
   public final Group groupAqi;
   public final TextView humidityData;
   public final TextView humidityTitle;
   public final TextView particleData;
   public final TextView particleTitle;
   private final ConstraintLayout rootView;
   public final View separator;
   public final TextView temperatureData;
   public final TextView temperatureTitle;

   private FragmentDeviceHSensorsBinding(ConstraintLayout var1, TextView var2, TextView var3, ConstraintLayout var4, ConstraintLayout var5, ConstraintLayout var6, ConstraintLayout var7, GraphViewH var8, TabLayout var9, Group var10, TextView var11, TextView var12, TextView var13, TextView var14, View var15, TextView var16, TextView var17) {
      this.rootView = var1;
      this.aqiData = var2;
      this.aqiTitle = var3;
      this.contentAqi = var4;
      this.contentHumidity = var5;
      this.contentParticle = var6;
      this.contentTemperature = var7;
      this.deviceGraph = var8;
      this.graphTabs = var9;
      this.groupAqi = var10;
      this.humidityData = var11;
      this.humidityTitle = var12;
      this.particleData = var13;
      this.particleTitle = var14;
      this.separator = var15;
      this.temperatureData = var16;
      this.temperatureTitle = var17;
   }

   public static FragmentDeviceHSensorsBinding bind(View var0) {
      int var1 = R.id.aqi_data;
      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.aqi_title;
         TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.content_aqi;
            ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.content_humidity;
               ConstraintLayout var14 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var14 != null) {
                  var1 = R.id.content_particle;
                  ConstraintLayout var12 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var12 != null) {
                     var1 = R.id.content_temperature;
                     ConstraintLayout var17 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var17 != null) {
                        var1 = R.id.device_graph;
                        GraphViewH var11 = (GraphViewH)ViewBindings.findChildViewById(var0, var1);
                        if (var11 != null) {
                           var1 = R.id.graph_tabs;
                           TabLayout var2 = (TabLayout)ViewBindings.findChildViewById(var0, var1);
                           if (var2 != null) {
                              var1 = R.id.group_aqi;
                              Group var15 = (Group)ViewBindings.findChildViewById(var0, var1);
                              if (var15 != null) {
                                 var1 = R.id.humidity_data;
                                 TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var5 != null) {
                                    var1 = R.id.humidity_title;
                                    TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var10 != null) {
                                       var1 = R.id.particle_data;
                                       TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var16 != null) {
                                          var1 = R.id.particle_title;
                                          TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var13 != null) {
                                             var1 = R.id.separator;
                                             View var9 = ViewBindings.findChildViewById(var0, var1);
                                             if (var9 != null) {
                                                var1 = R.id.temperature_data;
                                                TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var7 != null) {
                                                   var1 = R.id.temperature_title;
                                                   TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var3 != null) {
                                                      return new FragmentDeviceHSensorsBinding((ConstraintLayout)var0, var4, var8, var6, var14, var12, var17, var11, var2, var15, var5, var10, var16, var13, var9, var7, var3);
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

   public static FragmentDeviceHSensorsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceHSensorsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_h_sensors, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
