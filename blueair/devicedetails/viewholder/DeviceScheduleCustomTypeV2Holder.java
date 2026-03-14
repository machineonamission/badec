package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceScheduleCustomTypeV2Binding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R,\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleCustomTypeV2Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleCustomTypeV2Binding;", "onCloseHintListener", "Lkotlin/Function0;", "", "onTypeSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleCustomTypeV2Binding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleCustomTypeV2Binding;", "getOnCloseHintListener", "()Lkotlin/jvm/functions/Function0;", "getOnTypeSelectedListener", "()Lkotlin/jvm/functions/Function1;", "update", "hintClosedBefore", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleCustomTypeV2Holder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceScheduleCustomTypeV2Binding binding;
   private final Function0 onCloseHintListener;
   private final Function1 onTypeSelectedListener;

   // $FF: synthetic method
   public static void $r8$lambda$w9q6JndyVEHelJ48Wonddkv0uYs(DeviceScheduleCustomTypeV2Holder var0, RadioGroup var1, int var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xaFgPL__vjjZwil9_IbtqAWd6co/* $FF was: $r8$lambda$xaFgPL_-vjjZwil9_IbtqAWd6co*/(DeviceScheduleCustomTypeV2Holder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   public DeviceScheduleCustomTypeV2Holder(HolderDeviceScheduleCustomTypeV2Binding var1, Function0 var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onCloseHintListener");
      Intrinsics.checkNotNullParameter(var3, "onTypeSelectedListener");
      super((View)var1.getRoot());
      this.binding = var1;
      this.onCloseHintListener = var2;
      this.onTypeSelectedListener = var3;
      var1.radioGroupCustomScheduleSettings.setOnCheckedChangeListener(new DeviceScheduleCustomTypeV2Holder$$ExternalSyntheticLambda0(this));
      var1.btnClose.setOnClickListener(new DeviceScheduleCustomTypeV2Holder$$ExternalSyntheticLambda1(this));
   }

   private static final void _init_$lambda$0(DeviceScheduleCustomTypeV2Holder var0, RadioGroup var1, int var2) {
      int var3 = R.id.radio_button_previous;
      String var4 = "previous";
      if (var2 != var3 && var2 == R.id.radio_button_custom) {
         var4 = "custom";
      }

      var0.onTypeSelectedListener.invoke(var4);
   }

   private static final void _init_$lambda$1(DeviceScheduleCustomTypeV2Holder var0, View var1) {
      var0.onCloseHintListener.invoke();
   }

   public final HolderDeviceScheduleCustomTypeV2Binding getBinding() {
      return this.binding;
   }

   public final Function0 getOnCloseHintListener() {
      return this.onCloseHintListener;
   }

   public final Function1 getOnTypeSelectedListener() {
      return this.onTypeSelectedListener;
   }

   public final void update(String var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "type");
      int var3;
      if (Intrinsics.areEqual(var1, "custom")) {
         var3 = R.id.radio_button_custom;
      } else {
         var3 = R.id.radio_button_previous;
      }

      int var4;
      if (Intrinsics.areEqual(var1, "previous")) {
         var4 = com.blueair.viewcore.R.string.schedule_last_used_description;
      } else {
         var4 = com.blueair.viewcore.R.string.schedule_custom_description_v2;
      }

      this.binding.radioGroupCustomScheduleSettings.check(var3);
      this.binding.textviewCustomScheduleDescription.setText(var4);
      LinearLayout var5 = this.binding.descriptionContainer;
      Intrinsics.checkNotNullExpressionValue(var5, "descriptionContainer");
      ViewExtensionsKt.show((View)var5, var2 ^ true);
   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleCustomTypeV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleCustomTypeV2Holder;", "parentView", "Landroid/view/ViewGroup;", "onCloseHintListener", "Lkotlin/Function0;", "", "onTypeSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final DeviceScheduleCustomTypeV2Holder newInstance(ViewGroup var1, Function0 var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onCloseHintListener");
         Intrinsics.checkNotNullParameter(var3, "onTypeSelectedListener");
         HolderDeviceScheduleCustomTypeV2Binding var4 = HolderDeviceScheduleCustomTypeV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceScheduleCustomTypeV2Holder(var4, var2, var3);
      }
   }
}
