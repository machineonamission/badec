package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;

public abstract class DialogAqiIndexInfoBinding extends ViewDataBinding {
   public final ImageButton closeButton;
   public final ConstraintLayout contentContainer;
   public final ImageView dotCo;
   public final ImageView dotPm10;
   public final ImageView dotPm25;
   public final ImageView dotSo2;
   public final TextView indexLevelExcellentContent;
   public final TextView indexLevelExcellentLabel;
   public final TextView indexLevelGoodContent;
   public final TextView indexLevelGoodLabel;
   public final TextView indexLevelModerateContent;
   public final TextView indexLevelModerateLabel;
   public final TextView indexLevelPollutedContent;
   public final TextView indexLevelPollutedLabel;
   public final TextView indexLevelVpollutedContent;
   public final TextView indexLevelVpollutedLabel;
   public final TextView introductionCo;
   public final TextView introductionIndex;
   public final TextView introductionPm10;
   public final TextView introductionPm25;
   public final TextView introductionSo2;
   public final TextView subTitleGases;
   public final TextView subTitleParticles;

   protected DialogAqiIndexInfoBinding(Object var1, View var2, int var3, ImageButton var4, ConstraintLayout var5, ImageView var6, ImageView var7, ImageView var8, ImageView var9, TextView var10, TextView var11, TextView var12, TextView var13, TextView var14, TextView var15, TextView var16, TextView var17, TextView var18, TextView var19, TextView var20, TextView var21, TextView var22, TextView var23, TextView var24, TextView var25, TextView var26) {
      super(var1, var2, var3);
      this.closeButton = var4;
      this.contentContainer = var5;
      this.dotCo = var6;
      this.dotPm10 = var7;
      this.dotPm25 = var8;
      this.dotSo2 = var9;
      this.indexLevelExcellentContent = var10;
      this.indexLevelExcellentLabel = var11;
      this.indexLevelGoodContent = var12;
      this.indexLevelGoodLabel = var13;
      this.indexLevelModerateContent = var14;
      this.indexLevelModerateLabel = var15;
      this.indexLevelPollutedContent = var16;
      this.indexLevelPollutedLabel = var17;
      this.indexLevelVpollutedContent = var18;
      this.indexLevelVpollutedLabel = var19;
      this.introductionCo = var20;
      this.introductionIndex = var21;
      this.introductionPm10 = var22;
      this.introductionPm25 = var23;
      this.introductionSo2 = var24;
      this.subTitleGases = var25;
      this.subTitleParticles = var26;
   }

   public static DialogAqiIndexInfoBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogAqiIndexInfoBinding bind(View var0, Object var1) {
      return (DialogAqiIndexInfoBinding)bind(var1, var0, R.layout.dialog_aqi_index_info);
   }

   public static DialogAqiIndexInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogAqiIndexInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogAqiIndexInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogAqiIndexInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialog_aqi_index_info, var1, var2, var3);
   }

   @Deprecated
   public static DialogAqiIndexInfoBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogAqiIndexInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialog_aqi_index_info, (ViewGroup)null, false, var1);
   }
}
