package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0013\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0092\u0001\u0010,\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00063"},
   d2 = {"Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "", "macAddress", "", "mcuFirmware", "wifiFirmware", "overallFirmware", "name", "type", "serialNumber", "hardware", "sensorRanges", "ywrmEnable", "", "nightPeroids", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;[D)V", "getMacAddress", "()Ljava/lang/String;", "getMcuFirmware", "getWifiFirmware", "getOverallFirmware", "getName", "getType", "getSerialNumber", "getHardware", "getSensorRanges", "getYwrmEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNightPeroids", "()[D", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;[D)Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "equals", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConfigurationDeviceInfo {
   private final String hardware;
   private final String macAddress;
   private final String mcuFirmware;
   private final String name;
   private final double[] nightPeroids;
   private final String overallFirmware;
   private final String sensorRanges;
   private final String serialNumber;
   private final String type;
   private final String wifiFirmware;
   private final Boolean ywrmEnable;

   public ConfigurationDeviceInfo(@Json(name = "cma") String var1, @Json(name = "mfv") String var2, @Json(name = "cfv") String var3, @Json(name = "ofv") String var4, String var5, @Json(name = "sku") String var6, @Json(name = "ds") String var7, @Json(name = "hw") String var8, @Json(name = "aqiranges") String var9, @Json(name = "ywrme") Boolean var10, @Json(name = "nightperiods") double[] var11) {
      this.macAddress = var1;
      this.mcuFirmware = var2;
      this.wifiFirmware = var3;
      this.overallFirmware = var4;
      this.name = var5;
      this.type = var6;
      this.serialNumber = var7;
      this.hardware = var8;
      this.sensorRanges = var9;
      this.ywrmEnable = var10;
      this.nightPeroids = var11;
   }

   // $FF: synthetic method
   public static ConfigurationDeviceInfo copy$default(ConfigurationDeviceInfo var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, Boolean var10, double[] var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.macAddress;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.mcuFirmware;
      }

      if ((var12 & 4) != 0) {
         var3 = var0.wifiFirmware;
      }

      if ((var12 & 8) != 0) {
         var4 = var0.overallFirmware;
      }

      if ((var12 & 16) != 0) {
         var5 = var0.name;
      }

      if ((var12 & 32) != 0) {
         var6 = var0.type;
      }

      if ((var12 & 64) != 0) {
         var7 = var0.serialNumber;
      }

      if ((var12 & 128) != 0) {
         var8 = var0.hardware;
      }

      if ((var12 & 256) != 0) {
         var9 = var0.sensorRanges;
      }

      if ((var12 & 512) != 0) {
         var10 = var0.ywrmEnable;
      }

      if ((var12 & 1024) != 0) {
         var11 = var0.nightPeroids;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final String component1() {
      return this.macAddress;
   }

   public final Boolean component10() {
      return this.ywrmEnable;
   }

   public final double[] component11() {
      return this.nightPeroids;
   }

   public final String component2() {
      return this.mcuFirmware;
   }

   public final String component3() {
      return this.wifiFirmware;
   }

   public final String component4() {
      return this.overallFirmware;
   }

   public final String component5() {
      return this.name;
   }

   public final String component6() {
      return this.type;
   }

   public final String component7() {
      return this.serialNumber;
   }

   public final String component8() {
      return this.hardware;
   }

   public final String component9() {
      return this.sensorRanges;
   }

   public final ConfigurationDeviceInfo copy(@Json(name = "cma") String var1, @Json(name = "mfv") String var2, @Json(name = "cfv") String var3, @Json(name = "ofv") String var4, String var5, @Json(name = "sku") String var6, @Json(name = "ds") String var7, @Json(name = "hw") String var8, @Json(name = "aqiranges") String var9, @Json(name = "ywrme") Boolean var10, @Json(name = "nightperiods") double[] var11) {
      return new ConfigurationDeviceInfo(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ConfigurationDeviceInfo)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.macAddress, var1.macAddress)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wifiFirmware, var1.wifiFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.overallFirmware, var1.overallFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.serialNumber, var1.serialNumber)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hardware, var1.hardware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.sensorRanges, var1.sensorRanges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ywrmEnable, var1.ywrmEnable)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.nightPeroids, var1.nightPeroids);
         }
      }
   }

   public final String getHardware() {
      return this.hardware;
   }

   public final String getMacAddress() {
      return this.macAddress;
   }

   public final String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public final String getName() {
      return this.name;
   }

   public final double[] getNightPeroids() {
      return this.nightPeroids;
   }

   public final String getOverallFirmware() {
      return this.overallFirmware;
   }

   public final String getSensorRanges() {
      return this.sensorRanges;
   }

   public final String getSerialNumber() {
      return this.serialNumber;
   }

   public final String getType() {
      return this.type;
   }

   public final String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public final Boolean getYwrmEnable() {
      return this.ywrmEnable;
   }

   public int hashCode() {
      String var12 = this.macAddress;
      int var11 = 0;
      int var1;
      if (var12 == null) {
         var1 = 0;
      } else {
         var1 = var12.hashCode();
      }

      var12 = this.mcuFirmware;
      int var2;
      if (var12 == null) {
         var2 = 0;
      } else {
         var2 = var12.hashCode();
      }

      var12 = this.wifiFirmware;
      int var3;
      if (var12 == null) {
         var3 = 0;
      } else {
         var3 = var12.hashCode();
      }

      var12 = this.overallFirmware;
      int var4;
      if (var12 == null) {
         var4 = 0;
      } else {
         var4 = var12.hashCode();
      }

      var12 = this.name;
      int var5;
      if (var12 == null) {
         var5 = 0;
      } else {
         var5 = var12.hashCode();
      }

      var12 = this.type;
      int var6;
      if (var12 == null) {
         var6 = 0;
      } else {
         var6 = var12.hashCode();
      }

      var12 = this.serialNumber;
      int var7;
      if (var12 == null) {
         var7 = 0;
      } else {
         var7 = var12.hashCode();
      }

      var12 = this.hardware;
      int var8;
      if (var12 == null) {
         var8 = 0;
      } else {
         var8 = var12.hashCode();
      }

      var12 = this.sensorRanges;
      int var9;
      if (var12 == null) {
         var9 = 0;
      } else {
         var9 = var12.hashCode();
      }

      Boolean var21 = this.ywrmEnable;
      int var10;
      if (var21 == null) {
         var10 = 0;
      } else {
         var10 = var21.hashCode();
      }

      double[] var22 = this.nightPeroids;
      if (var22 != null) {
         var11 = Arrays.hashCode(var22);
      }

      return (((((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConfigurationDeviceInfo(macAddress=");
      var1.append(this.macAddress);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", wifiFirmware=");
      var1.append(this.wifiFirmware);
      var1.append(", overallFirmware=");
      var1.append(this.overallFirmware);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(", serialNumber=");
      var1.append(this.serialNumber);
      var1.append(", hardware=");
      var1.append(this.hardware);
      var1.append(", sensorRanges=");
      var1.append(this.sensorRanges);
      var1.append(", ywrmEnable=");
      var1.append(this.ywrmEnable);
      var1.append(", nightPeroids=");
      var1.append(Arrays.toString(this.nightPeroids));
      var1.append(')');
      return var1.toString();
   }
}
