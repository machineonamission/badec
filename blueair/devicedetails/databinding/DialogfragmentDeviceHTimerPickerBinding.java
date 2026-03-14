package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceHTimerPickerBinding extends ViewDataBinding {
   public final ConstraintLayout contentContainer;
   public final LinearLayout contentContainerButton;
   public final WheelView timerPicker;
   public final MaterialButton timerPickerCancel;
   public final MaterialButton timerPickerDone;
   public final TextView title;

   protected DialogfragmentDeviceHTimerPickerBinding(Object var1, View var2, int var3, ConstraintLayout var4, LinearLayout var5, WheelView var6, MaterialButton var7, MaterialButton var8, TextView var9) {
      super(var1, var2, var3);
      this.contentContainer = var4;
      this.contentContainerButton = var5;
      this.timerPicker = var6;
      this.timerPickerCancel = var7;
      this.timerPickerDone = var8;
      this.title = var9;
   }

   public static DialogfragmentDeviceHTimerPickerBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceHTimerPickerBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceHTimerPickerBinding)bind(var1, var0, R.layout.dialogfragment_device_h_timer_picker);
   }

   public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceHTimerPickerBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_h_timer_picker, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceHTimerPickerBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_h_timer_picker, (ViewGroup)null, false, var1);
   }
}
