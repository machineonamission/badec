package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006&"},
   d2 = {"Lcom/blueair/core/model/OutdoorPollutants;", "Lcom/blueair/core/model/IOutdoorPollutants;", "co", "Lcom/blueair/core/model/Pollutant;", "no2", "o3", "pm10", "pm25", "so2", "aqi", "<init>", "(Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;)V", "getCo", "()Lcom/blueair/core/model/Pollutant;", "getNo2", "getO3", "getPm10", "getPm25", "getSo2", "getAqi", "co_ppb", "getCo_ppb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorPollutants implements IOutdoorPollutants {
   private final Pollutant aqi;
   private final Pollutant co;
   private final Pollutant no2;
   private final Pollutant o3;
   private final Pollutant pm10;
   private final Pollutant pm25;
   private final Pollutant so2;

   public OutdoorPollutants(Pollutant var1, Pollutant var2, Pollutant var3, Pollutant var4, Pollutant var5, Pollutant var6, Pollutant var7) {
      this.co = var1;
      this.no2 = var2;
      this.o3 = var3;
      this.pm10 = var4;
      this.pm25 = var5;
      this.so2 = var6;
      this.aqi = var7;
   }

   // $FF: synthetic method
   public static OutdoorPollutants copy$default(OutdoorPollutants var0, Pollutant var1, Pollutant var2, Pollutant var3, Pollutant var4, Pollutant var5, Pollutant var6, Pollutant var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.co;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.no2;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.o3;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.pm10;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.pm25;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.so2;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.aqi;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final Pollutant component1() {
      return this.co;
   }

   public final Pollutant component2() {
      return this.no2;
   }

   public final Pollutant component3() {
      return this.o3;
   }

   public final Pollutant component4() {
      return this.pm10;
   }

   public final Pollutant component5() {
      return this.pm25;
   }

   public final Pollutant component6() {
      return this.so2;
   }

   public final Pollutant component7() {
      return this.aqi;
   }

   public final OutdoorPollutants copy(Pollutant var1, Pollutant var2, Pollutant var3, Pollutant var4, Pollutant var5, Pollutant var6, Pollutant var7) {
      return new OutdoorPollutants(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof OutdoorPollutants)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.co, var1.co)) {
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

   public final Pollutant getAqi() {
      return this.aqi;
   }

   public Double getCalculatedAQI() {
      return IOutdoorPollutants$_CC.$default$getCalculatedAQI(this);
   }

   public final Pollutant getCo() {
      return this.co;
   }

   public int getCoAQI() {
      return IOutdoorPollutants$_CC.$default$getCoAQI(this);
   }

   public Pollutant getCo_ppb() {
      return this.co;
   }

   public Pollutant getNo2() {
      return this.no2;
   }

   public int getNo2AQI() {
      return IOutdoorPollutants$_CC.$default$getNo2AQI(this);
   }

   public Pollutant getO3() {
      return this.o3;
   }

   public int getO3AQI() {
      return IOutdoorPollutants$_CC.$default$getO3AQI(this);
   }

   public Pollutant getPm10() {
      return this.pm10;
   }

   public int getPm10AQI() {
      return IOutdoorPollutants$_CC.$default$getPm10AQI(this);
   }

   public Pollutant getPm25() {
      return this.pm25;
   }

   public int getPm25AQI() {
      return IOutdoorPollutants$_CC.$default$getPm25AQI(this);
   }

   public Pollutant getSo2() {
      return this.so2;
   }

   public int getSo2AQI() {
      return IOutdoorPollutants$_CC.$default$getSo2AQI(this);
   }

   public int hashCode() {
      Pollutant var8 = this.co;
      int var7 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      var8 = this.no2;
      int var2;
      if (var8 == null) {
         var2 = 0;
      } else {
         var2 = var8.hashCode();
      }

      var8 = this.o3;
      int var3;
      if (var8 == null) {
         var3 = 0;
      } else {
         var3 = var8.hashCode();
      }

      var8 = this.pm10;
      int var4;
      if (var8 == null) {
         var4 = 0;
      } else {
         var4 = var8.hashCode();
      }

      var8 = this.pm25;
      int var5;
      if (var8 == null) {
         var5 = 0;
      } else {
         var5 = var8.hashCode();
      }

      var8 = this.so2;
      int var6;
      if (var8 == null) {
         var6 = 0;
      } else {
         var6 = var8.hashCode();
      }

      var8 = this.aqi;
      if (var8 != null) {
         var7 = var8.hashCode();
      }

      return (((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("OutdoorPollutants(co=");
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
}
