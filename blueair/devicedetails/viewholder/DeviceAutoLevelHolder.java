package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.AutoLevel;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.devicedetails.databinding.HolderDeviceAutolevelBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019Bk\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoLevelHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAutolevelBinding;", "binding", "isInSchedule", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onAutoLevelSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/AutoLevel;", "Lkotlin/ParameterName;", "name", "speed", "onAutoLevelHintCloseListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAutolevelBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "()Z", "hasCoolMainMode", "Lcom/blueair/core/model/HasCoolMainMode;", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAutoLevelHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private HasCoolMainMode hasCoolMainMode;
   private final boolean isInSchedule;
   private final Function1 onAutoLevelHintCloseListener;
   private final Function1 onAutoLevelSelectedListener;
   private final Function0 onInfoClickListener;

   // $FF: synthetic method
   public static void $r8$lambda$0Iq8duL_UWcWnJ4l75Nqrznhkf0/* $FF was: $r8$lambda$0Iq8duL-UWcWnJ4l75Nqrznhkf0*/(DeviceAutoLevelHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$6j_uxU3hID0vT_KunLhRz9qaNIg/* $FF was: $r8$lambda$6j_uxU3hID0vT-KunLhRz9qaNIg*/(HolderDeviceAutolevelBinding var0, DeviceAutoLevelHolder var1, View var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ycQkfgjhcVH07PRtnbgK26vyijg(DeviceAutoLevelHolder var0, View var1) {
      _init_$lambda$3(var0, var1);
   }

   public DeviceAutoLevelHolder(HolderDeviceAutolevelBinding var1, boolean var2, Function0 var3, Function1 var4, Function1 var5) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
      Intrinsics.checkNotNullParameter(var4, "onAutoLevelSelectedListener");
      Intrinsics.checkNotNullParameter(var5, "onAutoLevelHintCloseListener");
      super(var1);
      this.isInSchedule = var2;
      this.onInfoClickListener = var3;
      this.onAutoLevelSelectedListener = var4;
      this.onAutoLevelHintCloseListener = var5;
      DeviceAutoLevelHolder$$ExternalSyntheticLambda0 var6 = new DeviceAutoLevelHolder$$ExternalSyntheticLambda0(var1, this);
      var1.btnLow.setOnClickListener(var6);
      var1.btnMedium.setOnClickListener(var6);
      var1.btnHigh.setOnClickListener(var6);
      var1.hintLevel.btnCloseHint.setOnClickListener(new DeviceAutoLevelHolder$$ExternalSyntheticLambda1(this));
      var1.ivInfo.setOnClickListener(new DeviceAutoLevelHolder$$ExternalSyntheticLambda2(this));
   }

   private static final void _init_$lambda$0(HolderDeviceAutolevelBinding var0, DeviceAutoLevelHolder var1, View var2) {
      var0.btnLow.setChecked(Intrinsics.areEqual(var2, var0.btnLow));
      var0.btnMedium.setChecked(Intrinsics.areEqual(var2, var0.btnMedium));
      var0.btnHigh.setChecked(Intrinsics.areEqual(var2, var0.btnHigh));
      AutoLevel var3;
      if (Intrinsics.areEqual(var2, var0.btnMedium)) {
         var3 = AutoLevel.MEDIUM;
      } else if (Intrinsics.areEqual(var2, var0.btnHigh)) {
         var3 = AutoLevel.HIGH;
      } else {
         var3 = AutoLevel.LOW;
      }

      var1.onAutoLevelSelectedListener.invoke(var3);
   }

   private static final void _init_$lambda$2(DeviceAutoLevelHolder var0, View var1) {
      HasCoolMainMode var2 = var0.hasCoolMainMode;
      if (var2 != null) {
         var0.onAutoLevelHintCloseListener.invoke(AutoLevel.Companion.fromValue(var2.getCoolAutoLevel()));
      }

   }

   private static final void _init_$lambda$3(DeviceAutoLevelHolder var0, View var1) {
      var0.onInfoClickListener.invoke();
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasCoolMainMode) {
         var1 = var1;
         this.hasCoolMainMode = var1;
         AutoLevel var7 = AutoLevel.Companion.fromValue(var1.getCoolAutoLevel());
         MaterialButton var4 = ((HolderDeviceAutolevelBinding)this.getBinding()).btnLow;
         AutoLevel var5 = AutoLevel.LOW;
         boolean var3 = true;
         if (var7 == var5) {
            var2 = true;
         } else {
            var2 = false;
         }

         var4.setChecked(var2);
         var4 = ((HolderDeviceAutolevelBinding)this.getBinding()).btnMedium;
         if (var7 == AutoLevel.MEDIUM) {
            var2 = true;
         } else {
            var2 = false;
         }

         var4.setChecked(var2);
         var4 = ((HolderDeviceAutolevelBinding)this.getBinding()).btnHigh;
         if (var7 == AutoLevel.HIGH) {
            var2 = var3;
         } else {
            var2 = false;
         }

         var4.setChecked(var2);
         ((HolderDeviceAutolevelBinding)this.getBinding()).tvSpeedValue.setText((CharSequence)var7.obtainFanSpeedRange());
         ((HolderDeviceAutolevelBinding)this.getBinding()).hintLevel.hintText.setText(R.string.auto_level_hint);
      }
   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0014"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoLevelHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoLevelHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onAutoLevelSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/AutoLevel;", "Lkotlin/ParameterName;", "name", "speed", "onAutoLevelHintCloseListener", "devicedetails_otherRelease"},
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

      public final DeviceAutoLevelHolder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function1 var4, Function1 var5) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
         Intrinsics.checkNotNullParameter(var4, "onAutoLevelSelectedListener");
         Intrinsics.checkNotNullParameter(var5, "onAutoLevelHintCloseListener");
         HolderDeviceAutolevelBinding var6 = HolderDeviceAutolevelBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
         return new DeviceAutoLevelHolder(var6, var2, var3, var4, var5);
      }
   }
}
