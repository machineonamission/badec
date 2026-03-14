package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/BlueAqiDataContent;", "", "aqi", "", "datetime", "", "pollutants", "Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;", "<init>", "(Ljava/lang/Double;Ljava/lang/String;Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;)V", "getAqi", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDatetime", "()Ljava/lang/String;", "getPollutants", "()Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/String;Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;)Lcom/blueair/core/model/BlueAqiDataContent;", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueAqiDataContent {
   private final Double aqi;
   private final String datetime;
   private final BreezoMeterOutdoorPollutants pollutants;

   public BlueAqiDataContent(Double var1, String var2, BreezoMeterOutdoorPollutants var3) {
      this.aqi = var1;
      this.datetime = var2;
      this.pollutants = var3;
   }

   // $FF: synthetic method
   public static BlueAqiDataContent copy$default(BlueAqiDataContent var0, Double var1, String var2, BreezoMeterOutdoorPollutants var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.aqi;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.datetime;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.pollutants;
      }

      return var0.copy(var1, var2, var3);
   }

   public final Double component1() {
      return this.aqi;
   }

   public final String component2() {
      return this.datetime;
   }

   public final BreezoMeterOutdoorPollutants component3() {
      return this.pollutants;
   }

   public final BlueAqiDataContent copy(Double var1, String var2, BreezoMeterOutdoorPollutants var3) {
      return new BlueAqiDataContent(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueAqiDataContent)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.aqi, var1.aqi)) {
            return false;
         } else if (!Intrinsics.areEqual(this.datetime, var1.datetime)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.pollutants, var1.pollutants);
         }
      }
   }

   public final Double getAqi() {
      return this.aqi;
   }

   public final String getDatetime() {
      return this.datetime;
   }

   public final BreezoMeterOutdoorPollutants getPollutants() {
      return this.pollutants;
   }

   public int hashCode() {
      Double var4 = this.aqi;
      int var3 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      String var5 = this.datetime;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      BreezoMeterOutdoorPollutants var6 = this.pollutants;
      if (var6 != null) {
         var3 = var6.hashCode();
      }

      return (var1 * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueAqiDataContent(aqi=");
      var1.append(this.aqi);
      var1.append(", datetime=");
      var1.append(this.datetime);
      var1.append(", pollutants=");
      var1.append(this.pollutants);
      var1.append(')');
      return var1.toString();
   }
}
