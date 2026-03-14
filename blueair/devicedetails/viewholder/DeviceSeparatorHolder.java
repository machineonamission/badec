package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceSeparatorBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSeparatorHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSeparatorBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSeparatorBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSeparatorBinding;", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSeparatorHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceSeparatorBinding binding;

   public DeviceSeparatorHolder(HolderDeviceSeparatorBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      View var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super(var2);
      this.binding = var1;
   }

   public final HolderDeviceSeparatorBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSeparatorHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSeparatorHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceSeparatorHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceSeparatorBinding var2 = HolderDeviceSeparatorBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceSeparatorHolder(var2);
      }
   }
}
