package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/BlueWelcomeHomeLocation;", "", "lat", "", "lng", "radius", "", "textValue", "", "<init>", "(DDILjava/lang/String;)V", "getLat", "()D", "getLng", "getRadius", "()I", "getTextValue", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueWelcomeHomeLocation {
   private final double lat;
   private final double lng;
   private final int radius;
   private final String textValue;

   public BlueWelcomeHomeLocation(double var1, double var3, int var5, String var6) {
      Intrinsics.checkNotNullParameter(var6, "textValue");
      super();
      this.lat = var1;
      this.lng = var3;
      this.radius = var5;
      this.textValue = var6;
   }

   // $FF: synthetic method
   public static BlueWelcomeHomeLocation copy$default(BlueWelcomeHomeLocation var0, double var1, double var3, int var5, String var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.lat;
      }

      if ((var7 & 2) != 0) {
         var3 = var0.lng;
      }

      if ((var7 & 4) != 0) {
         var5 = var0.radius;
      }

      if ((var7 & 8) != 0) {
         var6 = var0.textValue;
      }

      return var0.copy(var1, var3, var5, var6);
   }

   public final double component1() {
      return this.lat;
   }

   public final double component2() {
      return this.lng;
   }

   public final int component3() {
      return this.radius;
   }

   public final String component4() {
      return this.textValue;
   }

   public final BlueWelcomeHomeLocation copy(double var1, double var3, int var5, String var6) {
      Intrinsics.checkNotNullParameter(var6, "textValue");
      return new BlueWelcomeHomeLocation(var1, var3, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueWelcomeHomeLocation)) {
         return false;
      } else {
         var1 = var1;
         if (Double.compare(this.lat, var1.lat) != 0) {
            return false;
         } else if (Double.compare(this.lng, var1.lng) != 0) {
            return false;
         } else if (this.radius != var1.radius) {
            return false;
         } else {
            return Intrinsics.areEqual(this.textValue, var1.textValue);
         }
      }
   }

   public final double getLat() {
      return this.lat;
   }

   public final double getLng() {
      return this.lng;
   }

   public final int getRadius() {
      return this.radius;
   }

   public final String getTextValue() {
      return this.textValue;
   }

   public int hashCode() {
      return ((AddDeviceState$$ExternalSyntheticBackport0.m(this.lat) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.lng)) * 31 + this.radius) * 31 + this.textValue.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueWelcomeHomeLocation(lat=");
      var1.append(this.lat);
      var1.append(", lng=");
      var1.append(this.lng);
      var1.append(", radius=");
      var1.append(this.radius);
      var1.append(", textValue=");
      var1.append(this.textValue);
      var1.append(')');
      return var1.toString();
   }
}
