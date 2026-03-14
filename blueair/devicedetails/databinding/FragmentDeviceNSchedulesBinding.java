package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceNSchedulesBinding implements ViewBinding {
   public final MaterialButton addSchedule;
   private final FrameLayout rootView;
   public final RecyclerView scheduleList;
   public final TextView title;

   private FragmentDeviceNSchedulesBinding(FrameLayout var1, MaterialButton var2, RecyclerView var3, TextView var4) {
      this.rootView = var1;
      this.addSchedule = var2;
      this.scheduleList = var3;
      this.title = var4;
   }

   public static FragmentDeviceNSchedulesBinding bind(View var0) {
      int var1 = R.id.add_schedule;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.schedule_list;
         RecyclerView var3 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.title;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new FragmentDeviceNSchedulesBinding((FrameLayout)var0, var4, var3, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentDeviceNSchedulesBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceNSchedulesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_n_schedules, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
