package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class ActivityCustomInputBinding extends ViewDataBinding {
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnSave;
   public final TextInputEditText editText;
   public final TextInputLayout editTextLayout;
   public final AppCompatTextView tvTitle;

   protected ActivityCustomInputBinding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, TextInputEditText var6, TextInputLayout var7, AppCompatTextView var8) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnSave = var5;
      this.editText = var6;
      this.editTextLayout = var7;
      this.tvTitle = var8;
   }

   public static ActivityCustomInputBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityCustomInputBinding bind(View var0, Object var1) {
      return (ActivityCustomInputBinding)bind(var1, var0, R.layout.activity_custom_input);
   }

   public static ActivityCustomInputBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityCustomInputBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityCustomInputBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityCustomInputBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_custom_input, var1, var2, var3);
   }

   @Deprecated
   public static ActivityCustomInputBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityCustomInputBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_custom_input, (ViewGroup)null, false, var1);
   }
}
