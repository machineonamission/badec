package com.blueair.core.model;

import com.blueair.core.util.TimeUtils;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/model/BlueAqiData;", "", "locationId", "", "data", "Lcom/blueair/core/model/BlueAqiDataContent;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/BlueAqiDataContent;)V", "getLocationId", "()Ljava/lang/String;", "getData", "()Lcom/blueair/core/model/BlueAqiDataContent;", "toAqiData", "Lcom/blueair/core/model/AqiData;", "dateFormatterBreezo", "Ljava/text/SimpleDateFormat;", "getCalculatedPollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueAqiData {
   private final BlueAqiDataContent data;
   private final String locationId;

   public BlueAqiData(String var1, BlueAqiDataContent var2) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      Intrinsics.checkNotNullParameter(var2, "data");
      super();
      this.locationId = var1;
      this.data = var2;
   }

   // $FF: synthetic method
   public static BlueAqiData copy$default(BlueAqiData var0, String var1, BlueAqiDataContent var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.locationId;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.data;
      }

      return var0.copy(var1, var2);
   }

   private final OutdoorPollutants getCalculatedPollutants() {
      BreezoMeterOutdoorPollutants var1 = this.data.getPollutants();
      return var1 != null ? new OutdoorPollutants(var1.getCo_ppb(), var1.getNo2(), var1.getO3(), var1.getPm10(), var1.getPm25(), var1.getSo2(), new Pollutant(var1.getCalculatedAQI())) : null;
   }

   // $FF: synthetic method
   public static AqiData toAqiData$default(BlueAqiData var0, SimpleDateFormat var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = TimeUtils.INSTANCE.getDATE_FORMAT_BREEZOMETER();
      }

      return var0.toAqiData(var1);
   }

   public final String component1() {
      return this.locationId;
   }

   public final BlueAqiDataContent component2() {
      return this.data;
   }

   public final BlueAqiData copy(String var1, BlueAqiDataContent var2) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      Intrinsics.checkNotNullParameter(var2, "data");
      return new BlueAqiData(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueAqiData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.locationId, var1.locationId)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.data, var1.data);
         }
      }
   }

   public final BlueAqiDataContent getData() {
      return this.data;
   }

   public final String getLocationId() {
      return this.locationId;
   }

   public int hashCode() {
      return this.locationId.hashCode() * 31 + this.data.hashCode();
   }

   public final AqiData toAqiData(SimpleDateFormat var1) {
      Intrinsics.checkNotNullParameter(var1, "dateFormatterBreezo");
      String var5 = this.locationId;
      String var4 = this.data.getDatetime();
      long var2;
      if (var4 != null) {
         var2 = TimeUtils.INSTANCE.unixTimeFromBreezometerDate(var4, var1);
      } else {
         var2 = 0L;
      }

      return new AqiData(var5, var2, this.getCalculatedPollutants());
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueAqiData(locationId=");
      var1.append(this.locationId);
      var1.append(", data=");
      var1.append(this.data);
      var1.append(')');
      return var1.toString();
   }
}
