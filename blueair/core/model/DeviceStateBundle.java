package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"},
   d2 = {"Lcom/blueair/core/model/DeviceStateBundle;", "", "timestamp", "", "previous", "Lcom/blueair/core/model/DeviceStateBundleState;", "current", "<init>", "(JLcom/blueair/core/model/DeviceStateBundleState;Lcom/blueair/core/model/DeviceStateBundleState;)V", "getTimestamp", "()J", "getPrevious", "()Lcom/blueair/core/model/DeviceStateBundleState;", "getCurrent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceStateBundle {
   private final DeviceStateBundleState current;
   private final DeviceStateBundleState previous;
   private final long timestamp;

   public DeviceStateBundle(long var1, DeviceStateBundleState var3, DeviceStateBundleState var4) {
      Intrinsics.checkNotNullParameter(var3, "previous");
      Intrinsics.checkNotNullParameter(var4, "current");
      super();
      this.timestamp = var1;
      this.previous = var3;
      this.current = var4;
   }

   // $FF: synthetic method
   public DeviceStateBundle(long var1, DeviceStateBundleState var3, DeviceStateBundleState var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var3 = new DeviceStateBundleState((DeviceStateDelta)null, 1, (DefaultConstructorMarker)null);
      }

      if ((var5 & 4) != 0) {
         var4 = new DeviceStateBundleState((DeviceStateDelta)null, 1, (DefaultConstructorMarker)null);
      }

      this(var1, var3, var4);
   }

   // $FF: synthetic method
   public static DeviceStateBundle copy$default(DeviceStateBundle var0, long var1, DeviceStateBundleState var3, DeviceStateBundleState var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.timestamp;
      }

      if ((var5 & 2) != 0) {
         var3 = var0.previous;
      }

      if ((var5 & 4) != 0) {
         var4 = var0.current;
      }

      return var0.copy(var1, var3, var4);
   }

   public final long component1() {
      return this.timestamp;
   }

   public final DeviceStateBundleState component2() {
      return this.previous;
   }

   public final DeviceStateBundleState component3() {
      return this.current;
   }

   public final DeviceStateBundle copy(long var1, DeviceStateBundleState var3, DeviceStateBundleState var4) {
      Intrinsics.checkNotNullParameter(var3, "previous");
      Intrinsics.checkNotNullParameter(var4, "current");
      return new DeviceStateBundle(var1, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceStateBundle)) {
         return false;
      } else {
         var1 = var1;
         if (this.timestamp != var1.timestamp) {
            return false;
         } else if (!Intrinsics.areEqual(this.previous, var1.previous)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.current, var1.current);
         }
      }
   }

   public final DeviceStateBundleState getCurrent() {
      return this.current;
   }

   public final DeviceStateBundleState getPrevious() {
      return this.previous;
   }

   public final long getTimestamp() {
      return this.timestamp;
   }

   public int hashCode() {
      return (AddDeviceState$$ExternalSyntheticBackport0.m(this.timestamp) * 31 + this.previous.hashCode()) * 31 + this.current.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceStateBundle(timestamp=");
      var1.append(this.timestamp);
      var1.append(", previous=");
      var1.append(this.previous);
      var1.append(", current=");
      var1.append(this.current);
      var1.append(')');
      return var1.toString();
   }
}
