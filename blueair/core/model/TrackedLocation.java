package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.CoordinateTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dJ\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dJ\r\u0010\u001f\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010.\u001a\u00020/J\u0013\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020/HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006;"},
   d2 = {"Lcom/blueair/core/model/TrackedLocation;", "Landroid/os/Parcelable;", "id", "", "lat", "", "lon", "locationName", "cityName", "stateName", "countryName", "countryCode", "mapType", "<init>", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLat", "()D", "getLon", "getLocationName", "getCityName", "getStateName", "getCountryName", "getCountryCode", "getMapType", "isCurrentLocation", "", "getLatLngInGCJ", "Lkotlin/Pair;", "getLatLngInWGS", "isInMainlandChina", "()Ljava/lang/Boolean;", "isLocalMapType", "useWGS", "useGCJ", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TrackedLocation implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final String CURRENT_LOCATION_ID = "current";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String MAP_TYPE_GCJ = "GCJ";
   public static final String MAP_TYPE_GCJ_LOCAL = "GCJ_LOCAL";
   public static final String MAP_TYPE_WGS = "WGS";
   public static final String MAP_TYPE_WGS_LOCAL = "WGS_LOCAL";
   private final String cityName;
   private final String countryCode;
   private final String countryName;
   private final String id;
   private final double lat;
   private final String locationName;
   private final double lon;
   private final String mapType;
   private final String stateName;

   public TrackedLocation(String var1, double var2, double var4, String var6, String var7, String var8, String var9, String var10, String var11) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super();
      this.id = var1;
      this.lat = var2;
      this.lon = var4;
      this.locationName = var6;
      this.cityName = var7;
      this.stateName = var8;
      this.countryName = var9;
      this.countryCode = var10;
      this.mapType = var11;
   }

   // $FF: synthetic method
   public static TrackedLocation copy$default(TrackedLocation var0, String var1, double var2, double var4, String var6, String var7, String var8, String var9, String var10, String var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.lat;
      }

      if ((var12 & 4) != 0) {
         var4 = var0.lon;
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
      return this.lat;
   }

   public final double component3() {
      return this.lon;
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

   public final TrackedLocation copy(String var1, double var2, double var4, String var6, String var7, String var8, String var9, String var10, String var11) {
      Intrinsics.checkNotNullParameter(var1, "id");
      return new TrackedLocation(var1, var2, var4, var6, var7, var8, var9, var10, var11);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof TrackedLocation)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (Double.compare(this.lat, var1.lat) != 0) {
            return false;
         } else if (Double.compare(this.lon, var1.lon) != 0) {
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

   public final double getLat() {
      return this.lat;
   }

   public final Pair getLatLngInGCJ() {
      if (Intrinsics.areEqual(this.mapType, "WGS")) {
         double[] var1 = CoordinateTransformUtils.INSTANCE.wgs84togcj02(this.lon, this.lat, this.isInMainlandChina());
         return new Pair(var1[1], var1[0]);
      } else {
         return new Pair(this.lat, this.lon);
      }
   }

   public final Pair getLatLngInWGS() {
      if (Intrinsics.areEqual(this.mapType, "GCJ")) {
         double[] var1 = CoordinateTransformUtils.INSTANCE.gcj02towgs84(this.lon, this.lat, this.isInMainlandChina());
         return new Pair(var1[1], var1[0]);
      } else {
         return new Pair(this.lat, this.lon);
      }
   }

   public final String getLocationName() {
      return this.locationName;
   }

   public final double getLon() {
      return this.lon;
   }

   public final String getMapType() {
      return this.mapType;
   }

   public final String getStateName() {
      return this.stateName;
   }

   public int hashCode() {
      int var9 = this.id.hashCode();
      int var7 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lat);
      int var8 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lon);
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

      return (((((((var9 * 31 + var7) * 31 + var8) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6;
   }

   public final boolean isCurrentLocation() {
      return Intrinsics.areEqual(this.id, "current");
   }

   public final Boolean isInMainlandChina() {
      String var1 = this.countryCode;
      return var1 != null ? StringsKt.equals(var1, "CN", true) : null;
   }

   public final boolean isLocalMapType() {
      String var1 = this.mapType;
      return var1 != null ? StringsKt.endsWith$default(var1, "LOCAL", false, 2, (Object)null) : false;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("TrackedLocation(id=");
      var1.append(this.id);
      var1.append(", lat=");
      var1.append(this.lat);
      var1.append(", lon=");
      var1.append(this.lon);
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

   public final boolean useGCJ() {
      String var1 = this.mapType;
      return var1 != null ? StringsKt.startsWith$default(var1, "GCJ", false, 2, (Object)null) : false;
   }

   public final boolean useWGS() {
      String var1 = this.mapType;
      return var1 != null ? StringsKt.startsWith$default(var1, "WGS", false, 2, (Object)null) : false;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.id);
      var1.writeDouble(this.lat);
      var1.writeDouble(this.lon);
      var1.writeString(this.locationName);
      var1.writeString(this.cityName);
      var1.writeString(this.stateName);
      var1.writeString(this.countryName);
      var1.writeString(this.countryCode);
      var1.writeString(this.mapType);
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/TrackedLocation$Companion;", "", "<init>", "()V", "MAP_TYPE_WGS", "", "MAP_TYPE_GCJ", "MAP_TYPE_WGS_LOCAL", "MAP_TYPE_GCJ_LOCAL", "CURRENT_LOCATION_ID", "core_otherRelease"},
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
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final TrackedLocation createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new TrackedLocation(var1.readString(), var1.readDouble(), var1.readDouble(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString());
      }

      public final TrackedLocation[] newArray(int var1) {
         return new TrackedLocation[var1];
      }
   }
}
