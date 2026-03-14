package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentStepGuideBinding extends ViewDataBinding {
   public final ImageButton btnBack;
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnNext;
   public final AppCompatTextView txtStepDescription;
   public final AppCompatTextView txtStepTitle;

   protected DialogfragmentStepGuideBinding(Object var1, View var2, int var3, ImageButton var4, AppCompatImageButton var5, MaterialButton var6, AppCompatTextView var7, AppCompatTextView var8) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.btnClose = var5;
      this.btnNext = var6;
      this.txtStepDescription = var7;
      this.txtStepTitle = var8;
   }

   public static DialogfragmentStepGuideBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentStepGuideBinding bind(View var0, Object var1) {
      return (DialogfragmentStepGuideBinding)bind(var1, var0, R.layout.dialogfragment_step_guide);
   }

   public static DialogfragmentStepGuideBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentStepGuideBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentStepGuideBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentStepGuideBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_step_guide, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentStepGuideBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentStepGuideBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_step_guide, (ViewGroup)null, false, var1);
   }
}
