package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.TrackedLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006-"},
   d2 = {"Lcom/blueair/database/entity/TrackedLocationEntity;", "", "id", "", "latitude", "", "longitude", "locationName", "cityName", "stateName", "countryName", "countryCode", "mapType", "<init>", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getLocationName", "getCityName", "getStateName", "getCountryName", "getCountryCode", "getMapType", "toTrackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TrackedLocationEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String TRACKED_LOCATION_TABLE = "tracked_location_table";
   private final String cityName;
   private final String countryCode;
   private final String countryName;
   private final String id;
   private final double latitude;
   private final String locationName;
   private final double longitude;
   private final String mapType;
   private final String stateName;

   public TrackedLocationEntity(String var1, double var2, double var4, String var6, String var7, String var8, String var9, String var10, String var11) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super();
      this.id = var1;
      this.latitude = var2;
      this.longitude = var4;
      this.locationName = var6;
      this.cityName = var7;
      this.stateName = var8;
      this.countryName = var9;
      this.countryCode = var10;
      this.mapType = var11;
   }

   // $FF: synthetic method
   public static TrackedLocationEntity copy$default(TrackedLocationEntity var0, String var1, double var2, double var4, String var6, String var7, String var8, String var9, String var10, String var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.latitude;
      }

      if ((var12 & 4) != 0) {
         var4 = var0.longitude;
      }

      if ((var12 & 8) != 0) {
         var6 = var0.locationName;
      }

      if ((var12 & 16) != 0) {
         var7 = var0.cityName;
      }

      if ((var12 & 32) != 0) {
         var8 = var0.stateName;
      }

      if ((var12 & 64) != 0) {
         var9 = var0.countryName;
      }

      if ((var12 & 128) != 0) {
         var10 = var0.countryCode;
      }

      if ((var12 & 256) != 0) {
         var11 = var0.mapType;
      }

      return var0.copy(var1, var2, var4, var6, var7, var8, var9, var10, var11);
   }

   public final String component1() {
      return this.id;
   }

   public final double component2() {
      return this.latitude;
   }

   public final double component3() {
      return this.longitude;
   }

   public final String component4() {
      return this.locationName;
   }

   public final String component5() {
      return this.cityName;
   }

   public final String component6() {
      return this.stateName;
   }

   public final String component7() {
      return this.countryName;
   }

   public final String component8() {
      return this.countryCode;
   }

   public final String component9() {
      return this.mapType;
   }

   public final TrackedLocationEntity copy(String var1, double var2, double var4, String var6, String var7, String var8, String var9, String var10, String var11) {
      Intrinsics.checkNotNullParameter(var1, "id");
      return new TrackedLocationEntity(var1, var2, var4, var6, var7, var8, var9, var10, var11);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof TrackedLocationEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (Double.compare(this.latitude, var1.latitude) != 0) {
            return false;
         } else if (Double.compare(this.longitude, var1.longitude) != 0) {
            return false;
         } else if (!Intrinsics.areEqual(this.locationName, var1.locationName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.cityName, var1.cityName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.stateName, var1.stateName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.countryName, var1.countryName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.countryCode, var1.countryCode)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.mapType, var1.mapType);
         }
      }
   }

   public final String getCityName() {
      return this.cityName;
   }

   public final String getCountryCode() {
      return this.countryCode;
   }

   public final String getCountryName() {
      return this.countryName;
   }

   public final String getId() {
      return this.id;
   }

   public final double getLatitude() {
      return this.latitude;
   }

   public final String getLocationName() {
      return this.locationName;
   }

   public final double getLongitude() {
      return this.longitude;
   }

   public final String getMapType() {
      return this.mapType;
   }

   public final String getStateName() {
      return this.stateName;
   }

   public int hashCode() {
      int var9 = this.id.hashCode();
      int var8 = AddDeviceState$$ExternalSyntheticBackport0.m(this.latitude);
      int var7 = AddDeviceState$$ExternalSyntheticBackport0.m(this.longitude);
      String var10 = this.locationName;
      int var6 = 0;
      int var1;
      if (var10 == null) {
         var1 = 0;
      } else {
         var1 = var10.hashCode();
      }

      var10 = this.cityName;
      int var2;
      if (var10 == null) {
         var2 = 0;
      } else {
         var2 = var10.hashCode();
      }

      var10 = this.stateName;
      int var3;
      if (var10 == null) {
         var3 = 0;
      } else {
         var3 = var10.hashCode();
      }

      var10 = this.countryName;
      int var4;
      if (var10 == null) {
         var4 = 0;
      } else {
         var4 = var10.hashCode();
      }

      var10 = this.countryCode;
      int var5;
      if (var10 == null) {
         var5 = 0;
      } else {
         var5 = var10.hashCode();
      }

      var10 = this.mapType;
      if (var10 != null) {
         var6 = var10.hashCode();
      }

      return (((((((var9 * 31 + var8) * 31 + var7) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("TrackedLocationEntity(id=");
      var1.append(this.id);
      var1.append(", latitude=");
      var1.append(this.latitude);
      var1.append(", longitude=");
      var1.append(this.longitude);
      var1.append(", locationName=");
      var1.append(this.locationName);
      var1.append(", cityName=");
      var1.append(this.cityName);
      var1.append(", stateName=");
      var1.append(this.stateName);
      var1.append(", countryName=");
      var1.append(this.countryName);
      var1.append(", countryCode=");
      var1.append(this.countryCode);
      var1.append(", mapType=");
      var1.append(this.mapType);
      var1.append(')');
      return var1.toString();
   }

   public final TrackedLocation toTrackedLocation() {
      return new TrackedLocation(this.id, this.latitude, this.longitude, this.locationName, this.cityName, this.stateName, this.countryName, this.countryCode, this.mapType);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/database/entity/TrackedLocationEntity$Companion;", "", "<init>", "()V", "TRACKED_LOCATION_TABLE", "", "fromTrackedLocations", "", "Lcom/blueair/database/entity/TrackedLocationEntity;", "trackedLocations", "Lcom/blueair/core/model/TrackedLocation;", "fromTrackedLocation", "trackedLocation", "database_otherRelease"},
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

      public final TrackedLocationEntity fromTrackedLocation(TrackedLocation var1) {
         Intrinsics.checkNotNullParameter(var1, "trackedLocation");
         String var8 = var1.getId();
         double var2 = var1.getLat();
         double var4 = var1.getLon();
         String var9 = var1.getLocationName();
         String var7 = var1.getCityName();
         String var6 = var1.getCountryName();
         return new TrackedLocationEntity(var8, var2, var4, var9, var7, var1.getStateName(), var6, var1.getCountryCode(), var1.getMapType());
      }

      public final List fromTrackedLocations(List var1) {
         Intrinsics.checkNotNullParameter(var1, "trackedLocations");
         Iterable var2 = (Iterable)var1;
         Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));

         for(TrackedLocation var3 : var2) {
            var4.add(TrackedLocationEntity.Companion.fromTrackedLocation(var3));
         }

         return (List)var4;
      }
   }
}
