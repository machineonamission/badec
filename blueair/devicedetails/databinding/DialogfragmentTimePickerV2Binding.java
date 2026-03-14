package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.view.CustomWheelView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentTimePickerV2Binding extends ViewDataBinding {
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnDone;
   public final ConstraintLayout contentContainer;
   public final AppCompatImageView ivScaleMaskLeft;
   public final AppCompatImageView ivScaleMaskRight;
   public final TextView title;
   public final AppCompatTextView tvColon;
   public final AppCompatTextView tvHours;
   public final AppCompatTextView tvMins;
   public final View vTop;
   public final CustomWheelView wheelAmPm;
   public final CustomWheelView wheelHour;
   public final CustomWheelView wheelMinute;

   protected DialogfragmentTimePickerV2Binding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, ConstraintLayout var6, AppCompatImageView var7, AppCompatImageView var8, TextView var9, AppCompatTextView var10, AppCompatTextView var11, AppCompatTextView var12, View var13, CustomWheelView var14, CustomWheelView var15, CustomWheelView var16) {
      super(var1, var2, var3);
      this.btnClose = var4;
      this.btnDone = var5;
      this.contentContainer = var6;
      this.ivScaleMaskLeft = var7;
      this.ivScaleMaskRight = var8;
      this.title = var9;
      this.tvColon = var10;
      this.tvHours = var11;
      this.tvMins = var12;
      this.vTop = var13;
      this.wheelAmPm = var14;
      this.wheelHour = var15;
      this.wheelMinute = var16;
   }

   public static DialogfragmentTimePickerV2Binding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentTimePickerV2Binding bind(View var0, Object var1) {
      return (DialogfragmentTimePickerV2Binding)bind(var1, var0, R.layout.dialogfragment_time_picker_v2);
   }

   public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentTimePickerV2Binding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_time_picker_v2, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentTimePickerV2Binding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_time_picker_v2, (ViewGroup)null, false, var1);
   }
}
