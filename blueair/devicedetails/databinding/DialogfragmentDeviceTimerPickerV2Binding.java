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
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceTimerPickerV2Binding extends ViewDataBinding {
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
   public final WheelView wheelHour;
   public final WheelView wheelMinute;

   protected DialogfragmentDeviceTimerPickerV2Binding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, ConstraintLayout var6, AppCompatImageView var7, AppCompatImageView var8, TextView var9, AppCompatTextView var10, AppCompatTextView var11, AppCompatTextView var12, View var13, WheelView var14, WheelView var15) {
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
      this.wheelHour = var14;
      this.wheelMinute = var15;
   }

   public static DialogfragmentDeviceTimerPickerV2Binding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceTimerPickerV2Binding bind(View var0, Object var1) {
      return (DialogfragmentDeviceTimerPickerV2Binding)bind(var1, var0, R.layout.dialogfragment_device_timer_picker_v2);
   }

   public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceTimerPickerV2Binding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_timer_picker_v2, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceTimerPickerV2Binding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_timer_picker_v2, (ViewGroup)null, false, var1);
   }
}
