package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public final class FragmentBluetoothScanResultBinding implements ViewBinding {
   public final AppCompatTextView btnHelp;
   public final Group groupTitle;
   public final RecyclerView listview;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final FrameLayout scanningFragment;
   public final AppCompatTextView tvTitle;

   private FragmentBluetoothScanResultBinding(ConstraintLayout var1, AppCompatTextView var2, Group var3, RecyclerView var4, ProgressBlockerView var5, ConstraintLayout var6, FrameLayout var7, AppCompatTextView var8) {
      this.rootView = var1;
      this.btnHelp = var2;
      this.groupTitle = var3;
      this.listview = var4;
      this.progressView = var5;
      this.rootLayout = var6;
      this.scanningFragment = var7;
      this.tvTitle = var8;
   }

   public static FragmentBluetoothScanResultBinding bind(View var0) {
      int var1 = R.id.btn_help;
      AppCompatTextView var7 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.group_title;
         Group var5 = (Group)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.listview;
            RecyclerView var2 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.progressView;
               ProgressBlockerView var3 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  ConstraintLayout var4 = (ConstraintLayout)var0;
                  var1 = R.id.scanning_fragment;
                  FrameLayout var6 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.tv_title;
                     AppCompatTextView var8 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        return new FragmentBluetoothScanResultBinding(var4, var7, var5, var2, var3, var4, var6, var8);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentBluetoothScanResultBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentBluetoothScanResultBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_bluetooth_scan_result, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
