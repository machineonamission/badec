package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 02\u00020\u0001:\u00010Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015Jv\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015¨\u00061"},
   d2 = {"Lcom/blueair/database/entity/AqiDataEntity;", "", "trackedLocationId", "", "datetime", "", "co", "", "no2", "o3", "pm10", "pm25", "so2", "aqi", "<init>", "(Ljava/lang/String;JLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getTrackedLocationId", "()Ljava/lang/String;", "getDatetime", "()J", "getCo", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getNo2", "getO3", "getPm10", "getPm25", "getSo2", "getAqi", "toAqiData", "Lcom/blueair/core/model/AqiData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/blueair/database/entity/AqiDataEntity;", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AqiDataEntity {
   public static final String AQI_DATA_TABLE = "aqi_data_table";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Double aqi;
   private final Double co;
   private final long datetime;
   private final Double no2;
   private final Double o3;
   private final Double pm10;
   private final Double pm25;
   private final Double so2;
   private final String trackedLocationId;

   public AqiDataEntity(String var1, long var2, Double var4, Double var5, Double var6, Double var7, Double var8, Double var9, Double var10) {
      Intrinsics.checkNotNullParameter(var1, "trackedLocationId");
      super();
      this.trackedLocationId = var1;
      this.datetime = var2;
      this.co = var4;
      this.no2 = var5;
      this.o3 = var6;
      this.pm10 = var7;
      this.pm25 = var8;
      this.so2 = var9;
      this.aqi = var10;
   }

   // $FF: synthetic method
   public AqiDataEntity(String var1, long var2, Double var4, Double var5, Double var6, Double var7, Double var8, Double var9, Double var10, int var11, DefaultConstructorMarker var12) {
      if ((var11 & 4) != 0) {
         var4 = null;
      }

      if ((var11 & 8) != 0) {
         var5 = null;
      }

      if ((var11 & 16) != 0) {
         var6 = null;
      }

      if ((var11 & 32) != 0) {
         var7 = null;
      }

      if ((var11 & 64) != 0) {
         var8 = null;
      }

      if ((var11 & 128) != 0) {
         var9 = null;
      }

      if ((var11 & 256) != 0) {
         var10 = null;
      }

      this(var1, var2, var4, var5, var6, var7, var8, var9, var10);
   }

   // $FF: synthetic method
   public static AqiDataEntity copy$default(AqiDataEntity var0, String var1, long var2, Double var4, Double var5, Double var6, Double var7, Double var8, Double var9, Double var10, int var11, Object var12) {
      if ((var11 & 1) != 0) {
         var1 = var0.trackedLocationId;
      }

      if ((var11 & 2) != 0) {
         var2 = var0.datetime;
      }

      if ((var11 & 4) != 0) {
         var4 = var0.co;
      }

      if ((var11 & 8) != 0) {
         var5 = var0.no2;
      }

      if ((var11 & 16) != 0) {
         var6 = var0.o3;
      }

      if ((var11 & 32) != 0) {
         var7 = var0.pm10;
      }

      if ((var11 & 64) != 0) {
         var8 = var0.pm25;
      }

      if ((var11 & 128) != 0) {
         var9 = var0.so2;
      }

      if ((var11 & 256) != 0) {
         var10 = var0.aqi;
      }

      return var0.copy(var1, var2, var4, var5, var6, var7, var8, var9, var10);
   }

   public final String component1() {
      return this.trackedLocationId;
   }

   public final long component2() {
      return this.datetime;
   }

   public final Double component3() {
      return this.co;
   }

   public final Double component4() {
      return this.no2;
   }

   public final Double component5() {
      return this.o3;
   }

   public final Double component6() {
      return this.pm10;
   }

   public final Double component7() {
      return this.pm25;
   }

   public final Double component8() {
      return this.so2;
   }

   public final Double component9() {
      return this.aqi;
   }

   public final AqiDataEntity copy(String var1, long var2, Double var4, Double var5, Double var6, Double var7, Double var8, Double var9, Double var10) {
      Intrinsics.checkNotNullParameter(var1, "trackedLocationId");
      return new AqiDataEntity(var1, var2, var4, var5, var6, var7, var8, var9, var10);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AqiDataEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.trackedLocationId, var1.trackedLocationId)) {
            return false;
         } else if (this.datetime != var1.datetime) {
            return false;
         } else if (!Intrinsics.areEqual(this.co, var1.co)) {
            return false;
         } else if (!Intrinsics.areEqual(this.no2, var1.no2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.o3, var1.o3)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm10, var1.pm10)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm25, var1.pm25)) {
            return false;
         } else if (!Intrinsics.areEqual(this.so2, var1.so2)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.aqi, var1.aqi);
         }
      }
   }

   public final Double getAqi() {
      return this.aqi;
   }

   public final Double getCo() {
      return this.co;
   }

   public final long getDatetime() {
      return this.datetime;
   }

   public final Double getNo2() {
      return this.no2;
   }

   public final Double getO3() {
      return this.o3;
   }

   public final Double getPm10() {
      return this.pm10;
   }

   public final Double getPm25() {
      return this.pm25;
   }

   public final Double getSo2() {
      return this.so2;
   }

   public final String getTrackedLocationId() {
      return this.trackedLocationId;
   }

   public int hashCode() {
      int var9 = this.trackedLocationId.hashCode();
      int var8 = AddDeviceState$$ExternalSyntheticBackport0.m(this.datetime);
      Double var10 = this.co;
      int var7 = 0;
      int var1;
      if (var10 == null) {
         var1 = 0;
      } else {
         var1 = var10.hashCode();
      }

      var10 = this.no2;
      int var2;
      if (var10 == null) {
         var2 = 0;
      } else {
         var2 = var10.hashCode();
      }

      var10 = this.o3;
      int var3;
      if (var10 == null) {
         var3 = 0;
      } else {
         var3 = var10.hashCode();
      }

      var10 = this.pm10;
      int var4;
      if (var10 == null) {
         var4 = 0;
      } else {
         var4 = var10.hashCode();
      }

      var10 = this.pm25;
      int var5;
      if (var10 == null) {
         var5 = 0;
      } else {
         var5 = var10.hashCode();
      }

      var10 = this.so2;
      int var6;
      if (var10 == null) {
         var6 = 0;
      } else {
         var6 = var10.hashCode();
      }

      var10 = this.aqi;
      if (var10 != null) {
         var7 = var10.hashCode();
      }

      return (((((((var9 * 31 + var8) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7;
   }

   public final AqiData toAqiData() {
      return new AqiData(this.trackedLocationId, this.datetime, new OutdoorPollutants(new Pollutant(this.co), new Pollutant(this.no2), new Pollutant(this.o3), new Pollutant(this.pm10), new Pollutant(this.pm25), new Pollutant(this.so2), new Pollutant(this.aqi)));
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AqiDataEntity(trackedLocationId=");
      var1.append(this.trackedLocationId);
      var1.append(", datetime=");
      var1.append(this.datetime);
      var1.append(", co=");
      var1.append(this.co);
      var1.append(", no2=");
      var1.append(this.no2);
      var1.append(", o3=");
      var1.append(this.o3);
      var1.append(", pm10=");
      var1.append(this.pm10);
      var1.append(", pm25=");
      var1.append(this.pm25);
      var1.append(", so2=");
      var1.append(this.so2);
      var1.append(", aqi=");
      var1.append(this.aqi);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/database/entity/AqiDataEntity$Companion;", "", "<init>", "()V", "AQI_DATA_TABLE", "", "fromTrackedLocationData", "Lcom/blueair/database/entity/AqiDataEntity;", "aqiData", "Lcom/blueair/core/model/AqiData;", "database_otherRelease"},
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

      public final AqiDataEntity fromTrackedLocationData(AqiData var1) {
         long var2;
         Object var10;
         String var11;
         Double var15;
         label63: {
            Intrinsics.checkNotNullParameter(var1, "aqiData");
            var11 = var1.getLocationId();
            var2 = var1.getDatetime();
            OutdoorPollutants var4 = var1.getPollutants();
            var10 = null;
            if (var4 != null) {
               Pollutant var14 = var4.getCo();
               if (var14 != null) {
                  var15 = var14.getConcentration();
                  break label63;
               }
            }

            var15 = null;
         }

         Double var17;
         label58: {
            OutdoorPollutants var5 = var1.getPollutants();
            if (var5 != null) {
               Pollutant var16 = var5.getNo2();
               if (var16 != null) {
                  var17 = var16.getConcentration();
                  break label58;
               }
            }

            var17 = null;
         }

         Double var19;
         label53: {
            OutdoorPollutants var6 = var1.getPollutants();
            if (var6 != null) {
               Pollutant var18 = var6.getO3();
               if (var18 != null) {
                  var19 = var18.getConcentration();
                  break label53;
               }
            }

            var19 = null;
         }

         Double var21;
         label48: {
            OutdoorPollutants var7 = var1.getPollutants();
            if (var7 != null) {
               Pollutant var20 = var7.getPm10();
               if (var20 != null) {
                  var21 = var20.getConcentration();
                  break label48;
               }
            }

            var21 = null;
         }

         Double var23;
         label43: {
            OutdoorPollutants var8 = var1.getPollutants();
            if (var8 != null) {
               Pollutant var22 = var8.getPm25();
               if (var22 != null) {
                  var23 = var22.getConcentration();
                  break label43;
               }
            }

            var23 = null;
         }

         Double var25;
         label38: {
            OutdoorPollutants var9 = var1.getPollutants();
            if (var9 != null) {
               Pollutant var24 = var9.getSo2();
               if (var24 != null) {
                  var25 = var24.getConcentration();
                  break label38;
               }
            }

            var25 = null;
         }

         OutdoorPollutants var12 = var1.getPollutants();
         Double var13 = (Double)var10;
         if (var12 != null) {
            Pollutant var26 = var12.getAqi();
            var13 = (Double)var10;
            if (var26 != null) {
               var13 = var26.getConcentration();
            }
         }

         return new AqiDataEntity(var11, var2, var15, var17, var19, var21, var23, var25, var13);
      }
   }
}
