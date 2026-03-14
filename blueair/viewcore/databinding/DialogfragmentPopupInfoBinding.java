package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;

public abstract class DialogfragmentPopupInfoBinding extends ViewDataBinding {
   public final ConstraintLayout contentContainer;
   public final TextView contentMessage;
   public final TextView contentTitle;
   public final Button doneBtn;
   public final ScrollView scrollView;
   public final View separator;
   public final TextView title;

   protected DialogfragmentPopupInfoBinding(Object var1, View var2, int var3, ConstraintLayout var4, TextView var5, TextView var6, Button var7, ScrollView var8, View var9, TextView var10) {
      super(var1, var2, var3);
      this.contentContainer = var4;
      this.contentMessage = var5;
      this.contentTitle = var6;
      this.doneBtn = var7;
      this.scrollView = var8;
      this.separator = var9;
      this.title = var10;
   }

   public static DialogfragmentPopupInfoBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentPopupInfoBinding bind(View var0, Object var1) {
      return (DialogfragmentPopupInfoBinding)bind(var1, var0, R.layout.dialogfragment_popup_info);
   }

   public static DialogfragmentPopupInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentPopupInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentPopupInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentPopupInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_popup_info, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentPopupInfoBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentPopupInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_popup_info, (ViewGroup)null, false, var1);
   }
}
