package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"},
   d2 = {"Lcom/blueair/core/model/AqiData;", "", "locationId", "", "datetime", "", "pollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "<init>", "(Ljava/lang/String;JLcom/blueair/core/model/OutdoorPollutants;)V", "getLocationId", "()Ljava/lang/String;", "getDatetime", "()J", "getPollutants", "()Lcom/blueair/core/model/OutdoorPollutants;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AqiData {
   private final long datetime;
   private final String locationId;
   private final OutdoorPollutants pollutants;

   public AqiData(String var1, long var2, OutdoorPollutants var4) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      super();
      this.locationId = var1;
      this.datetime = var2;
      this.pollutants = var4;
   }

   // $FF: synthetic method
   public static AqiData copy$default(AqiData var0, String var1, long var2, OutdoorPollutants var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.locationId;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.datetime;
      }

      if ((var5 & 4) != 0) {
         var4 = var0.pollutants;
      }

      return var0.copy(var1, var2, var4);
   }

   public final String component1() {
      return this.locationId;
   }

   public final long component2() {
      return this.datetime;
   }

   public final OutdoorPollutants component3() {
      return this.pollutants;
   }

   public final AqiData copy(String var1, long var2, OutdoorPollutants var4) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      return new AqiData(var1, var2, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AqiData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.locationId, var1.locationId)) {
            return false;
         } else if (this.datetime != var1.datetime) {
            return false;
         } else {
            return Intrinsics.areEqual(this.pollutants, var1.pollutants);
         }
      }
   }

   public final long getDatetime() {
      return this.datetime;
   }

   public final String getLocationId() {
      return this.locationId;
   }

   public final OutdoorPollutants getPollutants() {
      return this.pollutants;
   }

   public int hashCode() {
      int var3 = this.locationId.hashCode();
      int var2 = AddDeviceState$$ExternalSyntheticBackport0.m(this.datetime);
      OutdoorPollutants var4 = this.pollutants;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      return (var3 * 31 + var2) * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AqiData(locationId=");
      var1.append(this.locationId);
      var1.append(", datetime=");
      var1.append(this.datetime);
      var1.append(", pollutants=");
      var1.append(this.pollutants);
      var1.append(')');
      return var1.toString();
   }
}
