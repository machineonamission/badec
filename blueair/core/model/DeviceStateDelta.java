package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"},
   d2 = {"Lcom/blueair/core/model/DeviceStateDelta;", "", "desired", "Lcom/blueair/core/model/DeviceState;", "reported", "<init>", "(Lcom/blueair/core/model/DeviceState;Lcom/blueair/core/model/DeviceState;)V", "getDesired", "()Lcom/blueair/core/model/DeviceState;", "getReported", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceStateDelta {
   private final DeviceState desired;
   private final DeviceState reported;

   public DeviceStateDelta() {
      this((DeviceState)null, (DeviceState)null, 3, (DefaultConstructorMarker)null);
   }

   public DeviceStateDelta(DeviceState var1, DeviceState var2) {
      Intrinsics.checkNotNullParameter(var1, "desired");
      Intrinsics.checkNotNullParameter(var2, "reported");
      super();
      this.desired = var1;
      this.reported = var2;
   }

   // $FF: synthetic method
   public DeviceStateDelta(DeviceState var1, DeviceState var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 1) != 0) {
         var1 = new DeviceState((String)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (String)null, (Boolean)null, (String)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Integer)null, (Boolean)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Long)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, -1, -1, -1, 15, (DefaultConstructorMarker)null);
      }

      if ((var3 & 2) != 0) {
         var2 = new DeviceState((String)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (String)null, (Boolean)null, (String)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Integer)null, (Boolean)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Long)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, -1, -1, -1, 15, (DefaultConstructorMarker)null);
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static DeviceStateDelta copy$default(DeviceStateDelta var0, DeviceState var1, DeviceState var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.desired;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.reported;
      }

      return var0.copy(var1, var2);
   }

   public final DeviceState component1() {
      return this.desired;
   }

   public final DeviceState component2() {
      return this.reported;
   }

   public final DeviceStateDelta copy(DeviceState var1, DeviceState var2) {
      Intrinsics.checkNotNullParameter(var1, "desired");
      Intrinsics.checkNotNullParameter(var2, "reported");
      return new DeviceStateDelta(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceStateDelta)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.desired, var1.desired)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.reported, var1.reported);
         }
      }
   }

   public final DeviceState getDesired() {
      return this.desired;
   }

   public final DeviceState getReported() {
      return this.reported;
   }

   public int hashCode() {
      return this.desired.hashCode() * 31 + this.reported.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceStateDelta(desired=");
      var1.append(this.desired);
      var1.append(", reported=");
      var1.append(this.reported);
      var1.append(')');
      return var1.toString();
   }
}
