package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
   d2 = {"Lcom/blueair/core/model/DeviceStateBundleState;", "", "state", "Lcom/blueair/core/model/DeviceStateDelta;", "<init>", "(Lcom/blueair/core/model/DeviceStateDelta;)V", "getState", "()Lcom/blueair/core/model/DeviceStateDelta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceStateBundleState {
   private final DeviceStateDelta state;

   public DeviceStateBundleState() {
      this((DeviceStateDelta)null, 1, (DefaultConstructorMarker)null);
   }

   public DeviceStateBundleState(DeviceStateDelta var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      super();
      this.state = var1;
   }

   // $FF: synthetic method
   public DeviceStateBundleState(DeviceStateDelta var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = new DeviceStateDelta((DeviceState)null, (DeviceState)null, 3, (DefaultConstructorMarker)null);
      }

      this(var1);
   }

   // $FF: synthetic method
   public static DeviceStateBundleState copy$default(DeviceStateBundleState var0, DeviceStateDelta var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.state;
      }

      return var0.copy(var1);
   }

   public final DeviceStateDelta component1() {
      return this.state;
   }

   public final DeviceStateBundleState copy(DeviceStateDelta var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      return new DeviceStateBundleState(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceStateBundleState)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.state, var1.state);
      }
   }

   public final DeviceStateDelta getState() {
      return this.state;
   }

   public int hashCode() {
      return this.state.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceStateBundleState(state=");
      var1.append(this.state);
      var1.append(')');
      return var1.toString();
   }
}
