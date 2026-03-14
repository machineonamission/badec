package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasDetectCat;
import com.blueair.devicedetails.databinding.HolderDeviceDetectCatBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDetectCatHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceDetectCatBinding;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceDetectCatBinding;Lcom/blueair/core/model/Device;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceDetectCatBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "update", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetectCatHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceDetectCatBinding binding;
   private final Device device;

   public DeviceDetectCatHolder(HolderDeviceDetectCatBinding var1, Device var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      FrameLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.device = var2;
   }

   public final HolderDeviceDetectCatBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasDetectCat) {
         TextView var2 = this.binding.title;
         StringBuilder var3 = new StringBuilder("Detect Cat: ");
         var3.append(((HasDetectCat)var1).getDetectCat());
         var2.setText((CharSequence)var3.toString());
      }

   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDetectCatHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceDetectCatHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceDetectCatHolder newInstance(ViewGroup var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceDetectCatBinding var3 = HolderDeviceDetectCatBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceDetectCatHolder(var3, var2);
      }
   }
}
