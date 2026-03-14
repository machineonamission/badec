package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.shawnlin.numberpicker.NumberPicker;

public abstract class DialogfragmentNotificationEditNumberBinding extends ViewDataBinding {
   public final Button btnCancel;
   public final Button btnSave;
   public final NumberPicker numberPicker;

   protected DialogfragmentNotificationEditNumberBinding(Object var1, View var2, int var3, Button var4, Button var5, NumberPicker var6) {
      super(var1, var2, var3);
      this.btnCancel = var4;
      this.btnSave = var5;
      this.numberPicker = var6;
   }

   public static DialogfragmentNotificationEditNumberBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentNotificationEditNumberBinding bind(View var0, Object var1) {
      return (DialogfragmentNotificationEditNumberBinding)bind(var1, var0, R.layout.dialogfragment_notification_edit_number);
   }

   public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentNotificationEditNumberBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_notification_edit_number, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentNotificationEditNumberBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_notification_edit_number, (ViewGroup)null, false, var1);
   }
}
