package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.graph.view.GraphViewV2;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceSensorsGraphBinding implements ViewBinding {
   public final ImageView aqiIcon;
   public final TextView aqiValue;
   public final MaterialButton btnAbout;
   public final View clickView;
   public final TextView descriptionText;
   public final TextView dropdownMenuScale;
   public final TextView dropdownMenuSensors;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final GraphViewV2 graph;
   public final ImageView leadingIcon;
   private final ShadowLayout rootView;
   public final TextView title;

   private FragmentDeviceSensorsGraphBinding(ShadowLayout var1, ImageView var2, TextView var3, MaterialButton var4, View var5, TextView var6, TextView var7, TextView var8, SwitchCompat var9, Group var10, GraphViewV2 var11, ImageView var12, TextView var13) {
      this.rootView = var1;
      this.aqiIcon = var2;
      this.aqiValue = var3;
      this.btnAbout = var4;
      this.clickView = var5;
      this.descriptionText = var6;
      this.dropdownMenuScale = var7;
      this.dropdownMenuSensors = var8;
      this.expendSwitch = var9;
      this.expendedContent = var10;
      this.graph = var11;
      this.leadingIcon = var12;
      this.title = var13;
   }

   public static FragmentDeviceSensorsGraphBinding bind(View var0) {
      int var1 = R.id.aqi_icon;
      ImageView var9 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var9 != null) {
         var1 = R.id.aqi_value;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.btn_about;
            MaterialButton var12 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var12 != null) {
               var1 = R.id.click_view;
               View var4 = ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.description_text;
                  TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var10 != null) {
                     var1 = R.id.dropdown_menu_scale;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        var1 = R.id.dropdown_menu_sensors;
                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.expend_switch;
                           SwitchCompat var7 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              var1 = R.id.expended_content;
                              Group var11 = (Group)ViewBindings.findChildViewById(var0, var1);
                              if (var11 != null) {
                                 var1 = R.id.graph;
                                 GraphViewV2 var13 = (GraphViewV2)ViewBindings.findChildViewById(var0, var1);
                                 if (var13 != null) {
                                    var1 = R.id.leading_icon;
                                    ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                    if (var5 != null) {
                                       var1 = R.id.title;
                                       TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var8 != null) {
                                          return new FragmentDeviceSensorsGraphBinding((ShadowLayout)var0, var9, var3, var12, var4, var10, var2, var6, var7, var11, var13, var5, var8);
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

   public static FragmentDeviceSensorsGraphBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceSensorsGraphBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_sensors_graph, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
