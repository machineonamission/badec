package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceOfflineV2Binding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceOfflineV2Binding;", "binding", "onClosedListener", "Lkotlin/Function0;", "", "onTroubleShootClickListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceOfflineV2Binding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOfflineV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Function0 onClosedListener;
   private final Function0 onTroubleShootClickListener;

   public DeviceOfflineV2Holder(HolderDeviceOfflineV2Binding var1, Function0 var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onClosedListener");
      Intrinsics.checkNotNullParameter(var3, "onTroubleShootClickListener");
      super(var1);
      this.onClosedListener = var2;
      this.onTroubleShootClickListener = var3;
      var1.closeBtn.setOnClickListener(new DeviceOfflineV2Holder$$ExternalSyntheticLambda0(this));
      var1.troubleshootBtn.setOnClickListener(new DeviceOfflineV2Holder$$ExternalSyntheticLambda1(this));
   }

   static final void lambda$2$lambda$0(DeviceOfflineV2Holder var0, View var1) {
      var0.onClosedListener.invoke();
   }

   static final void lambda$2$lambda$1(DeviceOfflineV2Holder var0, View var1) {
      var0.onTroubleShootClickListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOfflineV2Holder;", "parentView", "Landroid/view/ViewGroup;", "onClosedListener", "Lkotlin/Function0;", "", "onTroubleShootClickListener", "devicedetails_otherRelease"},
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

      public final DeviceOfflineV2Holder newInstance(ViewGroup var1, Function0 var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onClosedListener");
         Intrinsics.checkNotNullParameter(var3, "onTroubleShootClickListener");
         HolderDeviceOfflineV2Binding var4 = HolderDeviceOfflineV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceOfflineV2Holder(var4, var2, var3);
      }
   }
}
