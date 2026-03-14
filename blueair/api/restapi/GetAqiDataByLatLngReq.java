package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"},
   d2 = {"Lcom/blueair/api/restapi/GetAqiDataByLatLngReq;", "", "lat", "", "lon", "range", "type", "", "<init>", "(DDDLjava/lang/String;)V", "getLat", "()D", "getLon", "getRange", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GetAqiDataByLatLngReq {
   private final double lat;
   private final double lon;
   private final double range;
   private final String type;

   public GetAqiDataByLatLngReq(double var1, double var3, double var5, String var7) {
      Intrinsics.checkNotNullParameter(var7, "type");
      super();
      this.lat = var1;
      this.lon = var3;
      this.range = var5;
      this.type = var7;
   }

   // $FF: synthetic method
   public GetAqiDataByLatLngReq(double var1, double var3, double var5, String var7, int var8, DefaultConstructorMarker var9) {
      if ((var8 & 4) != 0) {
         var5 = (double)300.0F;
      }

      if ((var8 & 8) != 0) {
         var7 = "latAndLon";
      }

      this(var1, var3, var5, var7);
   }

   // $FF: synthetic method
   public static GetAqiDataByLatLngReq copy$default(GetAqiDataByLatLngReq var0, double var1, double var3, double var5, String var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.lat;
      }

      if ((var8 & 2) != 0) {
         var3 = var0.lon;
      }

      if ((var8 & 4) != 0) {
         var5 = var0.range;
      }

      if ((var8 & 8) != 0) {
         var7 = var0.type;
      }

      return var0.copy(var1, var3, var5, var7);
   }

   public final double component1() {
      return this.lat;
   }

   public final double component2() {
      return this.lon;
   }

   public final double component3() {
      return this.range;
   }

   public final String component4() {
      return this.type;
   }

   public final GetAqiDataByLatLngReq copy(double var1, double var3, double var5, String var7) {
      Intrinsics.checkNotNullParameter(var7, "type");
      return new GetAqiDataByLatLngReq(var1, var3, var5, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GetAqiDataByLatLngReq)) {
         return false;
      } else {
         var1 = var1;
         if (Double.compare(this.lat, var1.lat) != 0) {
            return false;
         } else if (Double.compare(this.lon, var1.lon) != 0) {
            return false;
         } else if (Double.compare(this.range, var1.range) != 0) {
            return false;
         } else {
            return Intrinsics.areEqual(this.type, var1.type);
         }
      }
   }

   public final double getLat() {
      return this.lat;
   }

   public final double getLon() {
      return this.lon;
   }

   public final double getRange() {
      return this.range;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return ((AddDeviceState$$ExternalSyntheticBackport0.m(this.lat) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.lon)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.range)) * 31 + this.type.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GetAqiDataByLatLngReq(lat=");
      var1.append(this.lat);
      var1.append(", lon=");
      var1.append(this.lon);
      var1.append(", range=");
      var1.append(this.range);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(')');
      return var1.toString();
   }
}
