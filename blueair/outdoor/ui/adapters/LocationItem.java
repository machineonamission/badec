package com.blueair.outdoor.ui.adapters;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationItem;", "", "location", "Lcom/blueair/core/model/TrackedLocation;", "aqiData", "Lcom/blueair/core/model/AqiData;", "assignedDevices", "", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/core/model/TrackedLocation;Lcom/blueair/core/model/AqiData;Ljava/util/List;)V", "getLocation", "()Lcom/blueair/core/model/TrackedLocation;", "getAqiData", "()Lcom/blueair/core/model/AqiData;", "getAssignedDevices", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationItem {
   private final AqiData aqiData;
   private final List assignedDevices;
   private final TrackedLocation location;

   public LocationItem(TrackedLocation var1, AqiData var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var2, "aqiData");
      Intrinsics.checkNotNullParameter(var3, "assignedDevices");
      super();
      this.location = var1;
      this.aqiData = var2;
      this.assignedDevices = var3;
   }

   // $FF: synthetic method
   public static LocationItem copy$default(LocationItem var0, TrackedLocation var1, AqiData var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.location;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.aqiData;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.assignedDevices;
      }

      return var0.copy(var1, var2, var3);
   }

   public final TrackedLocation component1() {
      return this.location;
   }

   public final AqiData component2() {
      return this.aqiData;
   }

   public final List component3() {
      return this.assignedDevices;
   }

   public final LocationItem copy(TrackedLocation var1, AqiData var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var2, "aqiData");
      Intrinsics.checkNotNullParameter(var3, "assignedDevices");
      return new LocationItem(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof LocationItem)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.location, var1.location)) {
            return false;
         } else if (!Intrinsics.areEqual(this.aqiData, var1.aqiData)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.assignedDevices, var1.assignedDevices);
         }
      }
   }

   public final AqiData getAqiData() {
      return this.aqiData;
   }

   public final List getAssignedDevices() {
      return this.assignedDevices;
   }

   public final TrackedLocation getLocation() {
      return this.location;
   }

   public int hashCode() {
      return (this.location.hashCode() * 31 + this.aqiData.hashCode()) * 31 + this.assignedDevices.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LocationItem(location=");
      var1.append(this.location);
      var1.append(", aqiData=");
      var1.append(this.aqiData);
      var1.append(", assignedDevices=");
      var1.append(this.assignedDevices);
      var1.append(')');
      return var1.toString();
   }
}
