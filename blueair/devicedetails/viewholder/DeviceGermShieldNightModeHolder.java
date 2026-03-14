package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.devicedetails.databinding.HolderDeviceGermShieldNightModeBinding;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldNightModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldNightModeBinding;", "onGsnmSetListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldNightModeBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldNightModeBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceGermShieldNightModeHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceGermShieldNightModeBinding binding;
   private final Function0 onGsnmSetListener;

   // $FF: synthetic method
   public static void $r8$lambda$jLnBhZPm2OSDCp6Hh_1lFjcupVs(DeviceGermShieldNightModeHolder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   public DeviceGermShieldNightModeHolder(HolderDeviceGermShieldNightModeBinding var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onGsnmSetListener");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.onGsnmSetListener = var2;
      var1.gsnmSwitch.setOnCheckedChangeListener(new DeviceGermShieldNightModeHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceGermShieldNightModeHolder var0, CompoundButton var1, boolean var2) {
      var0.onGsnmSetListener.invoke();
   }

   public final HolderDeviceGermShieldNightModeBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      SwitchCompat var4;
      boolean var6;
      label17: {
         Intrinsics.checkNotNullParameter(var1, "device");
         var4 = this.binding.gsnmSwitch;
         if (var1 instanceof HasGermShieldMode) {
            Boolean var5 = ((HasGermShieldMode)var1).isGermShieldNightModeOn();
            boolean var3 = true;
            if (var5 != null) {
               var6 = var5;
            } else {
               var6 = true;
            }

            if (var6) {
               var6 = var3;
               break label17;
            }
         }

         var6 = false;
      }

      var4.setCheckedSilence(var6);
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldNightModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceGermShieldNightModeHolder;", "parentView", "Landroid/view/ViewGroup;", "onGsnmSetListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceGermShieldNightModeHolder newInstance(ViewGroup var1, Function0 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onGsnmSetListener");
         HolderDeviceGermShieldNightModeBinding var3 = HolderDeviceGermShieldNightModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceGermShieldNightModeHolder(var3, var2);
      }
   }
}
