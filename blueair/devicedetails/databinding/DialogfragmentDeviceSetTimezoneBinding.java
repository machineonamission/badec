package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class DialogfragmentDeviceSetTimezoneBinding extends ViewDataBinding {
   public final Button closeButton;
   public final ConstraintLayout contentContainer;
   public final TextView currentTimezoneLabel;
   public final TextView localTimezoneLabel;
   public final TextView noResultsView;
   public final ProgressBlockerView progressView;
   public final Button saveButton;
   public final TextView screenTitle;
   public final EditText searchBar;
   public final ImageButton searchClearBtn;
   public final View separator1;
   public final View separator2;
   public final RecyclerView timezoneList;

   protected DialogfragmentDeviceSetTimezoneBinding(Object var1, View var2, int var3, Button var4, ConstraintLayout var5, TextView var6, TextView var7, TextView var8, ProgressBlockerView var9, Button var10, TextView var11, EditText var12, ImageButton var13, View var14, View var15, RecyclerView var16) {
      super(var1, var2, var3);
      this.closeButton = var4;
      this.contentContainer = var5;
      this.currentTimezoneLabel = var6;
      this.localTimezoneLabel = var7;
      this.noResultsView = var8;
      this.progressView = var9;
      this.saveButton = var10;
      this.screenTitle = var11;
      this.searchBar = var12;
      this.searchClearBtn = var13;
      this.separator1 = var14;
      this.separator2 = var15;
      this.timezoneList = var16;
   }

   public static DialogfragmentDeviceSetTimezoneBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceSetTimezoneBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceSetTimezoneBinding)bind(var1, var0, R.layout.dialogfragment_device_set_timezone);
   }

   public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceSetTimezoneBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_set_timezone, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceSetTimezoneBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_set_timezone, (ViewGroup)null, false, var1);
   }
}
