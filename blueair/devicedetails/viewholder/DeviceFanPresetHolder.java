package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceFanPresetBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFanPresetHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFanPresetBinding;", "device", "Lcom/blueair/core/model/Device;", "onOpenFanPresetListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFanPresetBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFanPresetBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFanPresetHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceFanPresetBinding binding;
   private final Device device;
   private final Function0 onOpenFanPresetListener;

   // $FF: synthetic method
   public static void $r8$lambda$0vQtX8Qond8PJVkbo24q1fn1Jgg(DeviceFanPresetHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceFanPresetHolder(HolderDeviceFanPresetBinding var1, Device var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOpenFanPresetListener");
      FrameLayout var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super((View)var4);
      this.binding = var1;
      this.device = var2;
      this.onOpenFanPresetListener = var3;
      var1.contentFanPreset.setOnClickListener(new DeviceFanPresetHolder$$ExternalSyntheticLambda0(this));
      if (var2 != null) {
         this.update(var2);
      }

   }

   private static final void _init_$lambda$0(DeviceFanPresetHolder var0, View var1) {
      var0.onOpenFanPresetListener.invoke();
   }

   public final HolderDeviceFanPresetBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasCombo3in1MainMode) {
         TextView var3 = this.binding.title;
         int var2;
         if (((HasCombo3in1MainMode)var1).isInSubMode(ApSubMode.ECO)) {
            var2 = R.string.eco_fan_preset;
         } else {
            var2 = R.string.auto_fan_preset;
         }

         var3.setText(var2);
      }

   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFanPresetHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFanPresetHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onOpenFanPresetListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceFanPresetHolder newInstance(ViewGroup var1, Device var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOpenFanPresetListener");
         HolderDeviceFanPresetBinding var4 = HolderDeviceFanPresetBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceFanPresetHolder(var4, var2, var3);
      }
   }
}
