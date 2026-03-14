package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.databinding.HolderDeviceNOnOffButtonBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNOnOffButtonHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNOnOffButtonBinding;", "device", "Lcom/blueair/core/model/Device;", "onStandBySetListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNOnOffButtonBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNOnOffButtonBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "update", "isStandByOn", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNOnOffButtonHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNOnOffButtonBinding binding;
   private final Device device;
   private final Function0 onStandBySetListener;

   // $FF: synthetic method
   public static void $r8$lambda$FVcCLQhhRFy_wj4JxMghVmc2C3I/* $FF was: $r8$lambda$FVcCLQhhRFy-wj4JxMghVmc2C3I*/(DeviceNOnOffButtonHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceNOnOffButtonHolder(HolderDeviceNOnOffButtonBinding var1, Device var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onStandBySetListener");
      View var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super(var4);
      this.binding = var1;
      this.device = var2;
      this.onStandBySetListener = var3;
      var1.modeRoot.modeRoot.setOnClickListener(new DeviceNOnOffButtonHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceNOnOffButtonHolder var0, View var1) {
      var0.onStandBySetListener.invoke();
   }

   public final HolderDeviceNOnOffButtonBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasStandBy) {
         this.update(((HasStandBy)var1).isStandByOn());
      }

   }

   public final void update(boolean var1) {
      if (var1) {
         HolderDeviceNOnOffButtonBinding var4 = this.binding;
         var4.modeRoot.modeIcon.setImageResource(ModeIcon.STANDBY.getOnIcon());
         var4.modeRoot.modeText.setText(R.string.turn_on);
         TextView var5 = var4.offHint;
         Intrinsics.checkNotNullExpressionValue(var5, "offHint");
         ViewExtensionsKt.show((View)var5, true);
      } else {
         HolderDeviceNOnOffButtonBinding var2 = this.binding;
         var2.modeRoot.modeIcon.setImageResource(ModeIcon.STANDBY.getOffIcon());
         var2.modeRoot.modeText.setText(R.string.on);
         TextView var3 = var2.offHint;
         Intrinsics.checkNotNullExpressionValue(var3, "offHint");
         ViewExtensionsKt.show((View)var3, false);
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNOnOffButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNOnOffButtonHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onStandBySetListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceNOnOffButtonHolder newInstance(ViewGroup var1, Device var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onStandBySetListener");
         HolderDeviceNOnOffButtonBinding var4 = HolderDeviceNOnOffButtonBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         TextView var5 = var4.modeRoot.modeText;
         Intrinsics.checkNotNullExpressionValue(var5, "modeText");
         com.blueair.viewcore.ViewExtensionsKt.bold(var5);
         return new DeviceNOnOffButtonHolder(var4, var2, var3);
      }
   }
}
