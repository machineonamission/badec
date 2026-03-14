package com.blueair.devicedetails.adapter;

import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"},
   d2 = {"Lcom/blueair/devicedetails/adapter/LinkedDeviceSelectionAction;", "", "parentDevice", "Lcom/blueair/core/model/HasLinkingCapability;", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "<init>", "(Lcom/blueair/core/model/HasLinkingCapability;Lcom/blueair/core/model/DeviceAware;)V", "getParentDevice", "()Lcom/blueair/core/model/HasLinkingCapability;", "getLinkedDevice", "()Lcom/blueair/core/model/DeviceAware;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LinkedDeviceSelectionAction {
   private final DeviceAware linkedDevice;
   private final HasLinkingCapability parentDevice;

   public LinkedDeviceSelectionAction(HasLinkingCapability var1, DeviceAware var2) {
      Intrinsics.checkNotNullParameter(var1, "parentDevice");
      super();
      this.parentDevice = var1;
      this.linkedDevice = var2;
   }

   // $FF: synthetic method
   public static LinkedDeviceSelectionAction copy$default(LinkedDeviceSelectionAction var0, HasLinkingCapability var1, DeviceAware var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.parentDevice;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.linkedDevice;
      }

      return var0.copy(var1, var2);
   }

   public final HasLinkingCapability component1() {
      return this.parentDevice;
   }

   public final DeviceAware component2() {
      return this.linkedDevice;
   }

   public final LinkedDeviceSelectionAction copy(HasLinkingCapability var1, DeviceAware var2) {
      Intrinsics.checkNotNullParameter(var1, "parentDevice");
      return new LinkedDeviceSelectionAction(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof LinkedDeviceSelectionAction)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.parentDevice, var1.parentDevice)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.linkedDevice, var1.linkedDevice);
         }
      }
   }

   public final DeviceAware getLinkedDevice() {
      return this.linkedDevice;
   }

   public final HasLinkingCapability getParentDevice() {
      return this.parentDevice;
   }

   public int hashCode() {
      int var2 = this.parentDevice.hashCode();
      DeviceAware var3 = this.linkedDevice;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LinkedDeviceSelectionAction(parentDevice=");
      var1.append(this.parentDevice);
      var1.append(", linkedDevice=");
      var1.append(this.linkedDevice);
      var1.append(')');
      return var1.toString();
   }
}
