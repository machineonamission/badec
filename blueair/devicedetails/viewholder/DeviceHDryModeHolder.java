package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceHDryModeBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHDryModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceHDryModeBinding;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onDryModeCancelListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHDryModeBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceHDryModeBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "liveDevice", "update", "getDryModeCountdownText", "", "Lcom/blueair/core/model/HasWick;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHDryModeHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceHDryModeBinding binding;
   private final Device device;
   private Device liveDevice;
   private final Function0 onDryModeCancelListener;
   private final Function0 onOpenInfoListener;

   // $FF: synthetic method
   public static void $r8$lambda$5tsQ8hQp_K5Lcv62zHYy5OP17mw/* $FF was: $r8$lambda$5tsQ8hQp-K5Lcv62zHYy5OP17mw*/(DeviceHDryModeHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$mj8K92MHUwWkTdFDqi_mdtPxG_A/* $FF was: $r8$lambda$mj8K92MHUwWkTdFDqi_mdtPxG-A*/(DeviceHDryModeHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceHDryModeHolder(HolderDeviceHDryModeBinding var1, Device var2, Function0 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var4, "onDryModeCancelListener");
      ConstraintLayout var5 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      super((View)var5);
      this.binding = var1;
      this.device = var2;
      this.onOpenInfoListener = var3;
      this.onDryModeCancelListener = var4;
      this.liveDevice = var2;
      var1.dryModeTitle.setOnClickListener(new DeviceHDryModeHolder$$ExternalSyntheticLambda0(this));
      var1.cancelDryMode.setOnClickListener(new DeviceHDryModeHolder$$ExternalSyntheticLambda1(this));
   }

   private static final void _init_$lambda$0(DeviceHDryModeHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   private static final void _init_$lambda$1(DeviceHDryModeHolder var0, View var1) {
      var0.onDryModeCancelListener.invoke();
   }

   public final HolderDeviceHDryModeBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final String getDryModeCountdownText(HasWick var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      int var3 = var1.getWickDryLeftSeconds();
      int var2 = var3 / 3600;
      var3 -= var2 * 3600;
      int var4 = var3 / 60;
      String var5 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{var2, var4, var3 - var4 * 60}, 3));
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      return var5;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasWick) {
         this.liveDevice = var1;
         HasWick var2 = (HasWick)var1;
         if (var2.getWickdryOn()) {
            TextView var4 = this.binding.cancelDryMode;
            Intrinsics.checkNotNullExpressionValue(var4, "cancelDryMode");
            ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
            this.binding.countdownNumber.setText((CharSequence)this.getDryModeCountdownText(var2));
         } else {
            TextView var3 = this.binding.cancelDryMode;
            Intrinsics.checkNotNullExpressionValue(var3, "cancelDryMode");
            ViewExtensionsKt.hide((View)var3);
            this.binding.countdownNumber.setText((CharSequence)"--:--:--");
         }
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHDryModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHDryModeHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onDryModeCancelListener", "devicedetails_otherRelease"},
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

      public final DeviceHDryModeHolder newInstance(ViewGroup var1, Device var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var4, "onDryModeCancelListener");
         HolderDeviceHDryModeBinding var5 = HolderDeviceHDryModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceHDryModeHolder(var5, var2, var3, var4);
      }
   }
}
