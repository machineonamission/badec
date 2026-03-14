package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;

public final class FragmentDeviceControlsBinding implements ViewBinding {
   public final Button btnCloseControlsHint;
   public final ConstraintLayout controlsHintContainer;
   public final TextView controlsHintText;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final ShadowedRecyclerViewLayout rvControlGroup;
   public final ShadowedRecyclerViewLayout rvFilterGroup;
   public final RecyclerView rvLightGroup;
   public final RecyclerView rvModeButtons;
   public final RecyclerView rvScheduleGroup;

   private FragmentDeviceControlsBinding(ConstraintLayout var1, Button var2, ConstraintLayout var3, TextView var4, ConstraintLayout var5, ShadowedRecyclerViewLayout var6, ShadowedRecyclerViewLayout var7, RecyclerView var8, RecyclerView var9, RecyclerView var10) {
      this.rootView = var1;
      this.btnCloseControlsHint = var2;
      this.controlsHintContainer = var3;
      this.controlsHintText = var4;
      this.rootLayout = var5;
      this.rvControlGroup = var6;
      this.rvFilterGroup = var7;
      this.rvLightGroup = var8;
      this.rvModeButtons = var9;
      this.rvScheduleGroup = var10;
   }

   public static FragmentDeviceControlsBinding bind(View var0) {
      int var1 = R.id.btn_close_controls_hint;
      Button var9 = (Button)ViewBindings.findChildViewById(var0, var1);
      if (var9 != null) {
         var1 = R.id.controls_hint_container;
         ConstraintLayout var5 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.controls_hint_text;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               ConstraintLayout var2 = (ConstraintLayout)var0;
               var1 = R.id.rv_control_group;
               ShadowedRecyclerViewLayout var4 = (ShadowedRecyclerViewLayout)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.rv_filter_group;
                  ShadowedRecyclerViewLayout var7 = (ShadowedRecyclerViewLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.rv_light_group;
                     RecyclerView var10 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                     if (var10 != null) {
                        var1 = R.id.rv_mode_buttons;
                        RecyclerView var3 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                        if (var3 != null) {
                           var1 = R.id.rv_schedule_group;
                           RecyclerView var8 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                           if (var8 != null) {
                              return new FragmentDeviceControlsBinding(var2, var9, var5, var6, var2, var4, var7, var10, var3, var8);
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

   public static FragmentDeviceControlsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceControlsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_controls, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
