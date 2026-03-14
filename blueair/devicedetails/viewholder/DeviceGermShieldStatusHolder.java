package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldStatusBinding;", "onGermShieldInfoClickListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldStatusBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceGermShieldStatusHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceGermShieldStatusBinding binding;
   private final Function0 onGermShieldInfoClickListener;

   // $FF: synthetic method
   public static void $r8$lambda$QDSvjQNpAl2fGKTDnWbC_aPNJQk/* $FF was: $r8$lambda$QDSvjQNpAl2fGKTDnWbC-aPNJQk*/(DeviceGermShieldStatusHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceGermShieldStatusHolder(HolderDeviceGermShieldStatusBinding var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onGermShieldInfoClickListener");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.onGermShieldInfoClickListener = var2;
      var1.attributeTitle.setOnClickListener(new DeviceGermShieldStatusHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceGermShieldStatusHolder var0, View var1) {
      var0.onGermShieldInfoClickListener.invoke();
   }

   public final HolderDeviceGermShieldStatusBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      AppCompatImageView var2 = this.binding.germshieldIcon;
      ColorStateList var3;
      if (DeviceKt.isGermShieldOn(var1)) {
         var3 = null;
      } else {
         var3 = ColorStateList.valueOf(this.itemView.getContext().getColor(R.color.smokegray));
      }

      var2.setImageTintList(var3);
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceGermShieldStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onGermShieldInfoClickListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceGermShieldStatusHolder newInstance(ViewGroup var1, Function0 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onGermShieldInfoClickListener");
         HolderDeviceGermShieldStatusBinding var3 = HolderDeviceGermShieldStatusBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceGermShieldStatusHolder(var3, var2);
      }
   }
}
