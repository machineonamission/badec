package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasDisinfection;
import com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding;
import com.blueair.devicedetails.util.DisinfectionUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDisinfectionStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectionStatusBinding;", "onDisinfectionInfoClickListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectionStatusBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectionStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDisinfectionStatusHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceDisinfectionStatusBinding binding;
   private final Function0 onDisinfectionInfoClickListener;

   // $FF: synthetic method
   public static void $r8$lambda$9s90d8EFlffPXTX_l75aGgFbd6w/* $FF was: $r8$lambda$9s90d8EFlffPXTX-l75aGgFbd6w*/(DeviceDisinfectionStatusHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceDisinfectionStatusHolder(HolderDeviceDisinfectionStatusBinding var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onDisinfectionInfoClickListener");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.onDisinfectionInfoClickListener = var2;
      var1.attributeTitle.setOnClickListener(new DeviceDisinfectionStatusHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceDisinfectionStatusHolder var0, View var1) {
      var0.onDisinfectionInfoClickListener.invoke();
   }

   public final HolderDeviceDisinfectionStatusBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasDisinfection) {
         DisinfectionUtils var3 = DisinfectionUtils.INSTANCE;
         var1 = var1;
         Context var4 = this.itemView.getContext();
         Intrinsics.checkNotNullExpressionValue(var4, "getContext(...)");
         Pair var6 = var3.getCountdownStatus(var1, var4);
         int var2 = ((Number)var6.component1()).intValue();
         Spanned var7 = (Spanned)var6.component2();
         this.binding.disinfectionLeftTimeView.setText((CharSequence)var7);
         this.binding.progress.setProgress(100 - var2 * 100 / 7200);
      }

   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDisinfectionStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceDisinfectionStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onDisinfectionInfoClickListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceDisinfectionStatusHolder newInstance(ViewGroup var1, Function0 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onDisinfectionInfoClickListener");
         HolderDeviceDisinfectionStatusBinding var3 = HolderDeviceDisinfectionStatusBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceDisinfectionStatusHolder(var3, var2);
      }
   }
}
