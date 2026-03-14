package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceAlarmSoundPickerBinding extends ViewDataBinding {
   public final LinearLayout bottomBar;
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnDone;
   public final ConstraintLayout contentContainer;
   public final RecyclerView rvList;
   public final View separator;
   public final TextView title;
   public final View vTop;

   protected DialogfragmentDeviceAlarmSoundPickerBinding(Object var1, View var2, int var3, LinearLayout var4, AppCompatImageButton var5, MaterialButton var6, ConstraintLayout var7, RecyclerView var8, View var9, TextView var10, View var11) {
      super(var1, var2, var3);
      this.bottomBar = var4;
      this.btnClose = var5;
      this.btnDone = var6;
      this.contentContainer = var7;
      this.rvList = var8;
      this.separator = var9;
      this.title = var10;
      this.vTop = var11;
   }

   public static DialogfragmentDeviceAlarmSoundPickerBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceAlarmSoundPickerBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceAlarmSoundPickerBinding)bind(var1, var0, R.layout.dialogfragment_device_alarm_sound_picker);
   }

   public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceAlarmSoundPickerBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_alarm_sound_picker, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceAlarmSoundPickerBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_alarm_sound_picker, (ViewGroup)null, false, var1);
   }
}
