package com.blueair.api.model;

import com.blueair.core.model.DeviceDetailsOnAblServer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010+\u001a\u00020,J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"JÚ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"¨\u0006F"},
   d2 = {"Lcom/blueair/api/model/DeviceInfoData;", "", "uuid", "", "name", "timezone", "compatibility", "model", "mac", "firmware", "mcuFirmware", "wlanDriver", "lastSyncDate", "", "installationDate", "lastCalibrationDate", "initUsagePeriod", "rebootPeriod", "refurbDate", "aimSerialNumber", "aimUpdateDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getUuid", "()Ljava/lang/String;", "getName", "getTimezone", "getCompatibility", "getModel", "getMac", "getFirmware", "getMcuFirmware", "getWlanDriver", "getLastSyncDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInstallationDate", "getLastCalibrationDate", "getInitUsagePeriod", "getRebootPeriod", "getRefurbDate", "getAimSerialNumber", "getAimUpdateDate", "toDeviceDetailsOnServer", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/blueair/api/model/DeviceInfoData;", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceInfoData {
   private final String aimSerialNumber;
   private final Long aimUpdateDate;
   private final String compatibility;
   private final String firmware;
   private final Long initUsagePeriod;
   private final Long installationDate;
   private final Long lastCalibrationDate;
   private final Long lastSyncDate;
   private final String mac;
   private final String mcuFirmware;
   private final String model;
   private final String name;
   private final Long rebootPeriod;
   private final Long refurbDate;
   private final String timezone;
   private final String uuid;
   private final String wlanDriver;

   public DeviceInfoData() {
      this((String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (Long)null, (Long)null, (Long)null, (Long)null, (Long)null, (Long)null, (String)null, (Long)null, 131071, (DefaultConstructorMarker)null);
   }

   public DeviceInfoData(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, Long var10, Long var11, Long var12, Long var13, Long var14, Long var15, String var16, Long var17) {
      this.uuid = var1;
      this.name = var2;
      this.timezone = var3;
      this.compatibility = var4;
      this.model = var5;
      this.mac = var6;
      this.firmware = var7;
      this.mcuFirmware = var8;
      this.wlanDriver = var9;
      this.lastSyncDate = var10;
      this.installationDate = var11;
      this.lastCalibrationDate = var12;
      this.initUsagePeriod = var13;
      this.rebootPeriod = var14;
      this.refurbDate = var15;
      this.aimSerialNumber = var16;
      this.aimUpdateDate = var17;
   }

   // $FF: synthetic method
   public DeviceInfoData(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, Long var10, Long var11, Long var12, Long var13, Long var14, Long var15, String var16, Long var17, int var18, DefaultConstructorMarker var19) {
      if ((var18 & 1) != 0) {
         var1 = null;
      }

      if ((var18 & 2) != 0) {
         var2 = null;
      }

      if ((var18 & 4) != 0) {
         var3 = null;
      }

      if ((var18 & 8) != 0) {
         var4 = null;
      }

      if ((var18 & 16) != 0) {
         var5 = null;
      }

      if ((var18 & 32) != 0) {
         var6 = null;
      }

      if ((var18 & 64) != 0) {
         var7 = null;
      }

      if ((var18 & 128) != 0) {
         var8 = null;
      }

      if ((var18 & 256) != 0) {
         var9 = null;
      }

      if ((var18 & 512) != 0) {
         var10 = null;
      }

      if ((var18 & 1024) != 0) {
         var11 = null;
      }

      if ((var18 & 2048) != 0) {
         var12 = null;
      }

      if ((var18 & 4096) != 0) {
         var13 = null;
      }

      if ((var18 & 8192) != 0) {
         var14 = null;
      }

      if ((var18 & 16384) != 0) {
         var15 = null;
      }

      if ((var18 & '耀') != 0) {
         var16 = null;
      }

      if ((var18 & 65536) != 0) {
         var17 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
   }

   // $FF: synthetic method
   public static DeviceInfoData copy$default(DeviceInfoData var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, Long var10, Long var11, Long var12, Long var13, Long var14, Long var15, String var16, Long var17, int var18, Object var19) {
      if ((var18 & 1) != 0) {
         var1 = var0.uuid;
      }

      if ((var18 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var18 & 4) != 0) {
         var3 = var0.timezone;
      }

      if ((var18 & 8) != 0) {
         var4 = var0.compatibility;
      }

      if ((var18 & 16) != 0) {
         var5 = var0.model;
      }

      if ((var18 & 32) != 0) {
         var6 = var0.mac;
      }

      if ((var18 & 64) != 0) {
         var7 = var0.firmware;
      }

      if ((var18 & 128) != 0) {
         var8 = var0.mcuFirmware;
      }

      if ((var18 & 256) != 0) {
         var9 = var0.wlanDriver;
      }

      if ((var18 & 512) != 0) {
         var10 = var0.lastSyncDate;
      }

      if ((var18 & 1024) != 0) {
         var11 = var0.installationDate;
      }

      if ((var18 & 2048) != 0) {
         var12 = var0.lastCalibrationDate;
      }

      if ((var18 & 4096) != 0) {
         var13 = var0.initUsagePeriod;
      }

      if ((var18 & 8192) != 0) {
         var14 = var0.rebootPeriod;
      }

      if ((var18 & 16384) != 0) {
         var15 = var0.refurbDate;
      }

      if ((var18 & '耀') != 0) {
         var16 = var0.aimSerialNumber;
      }

      if ((var18 & 65536) != 0) {
         var17 = var0.aimUpdateDate;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
   }

   public final String component1() {
      return this.uuid;
   }

   public final Long component10() {
      return this.lastSyncDate;
   }

   public final Long component11() {
      return this.installationDate;
   }

   public final Long component12() {
      return this.lastCalibrationDate;
   }

   public final Long component13() {
      return this.initUsagePeriod;
   }

   public final Long component14() {
      return this.rebootPeriod;
   }

   public final Long component15() {
      return this.refurbDate;
   }

   public final String component16() {
      return this.aimSerialNumber;
   }

   public final Long component17() {
      return this.aimUpdateDate;
   }

   public final String component2() {
      return this.name;
   }

   public final String component3() {
      return this.timezone;
   }

   public final String component4() {
      return this.compatibility;
   }

   public final String component5() {
      return this.model;
   }

   public final String component6() {
      return this.mac;
   }

   public final String component7() {
      return this.firmware;
   }

   public final String component8() {
      return this.mcuFirmware;
   }

   public final String component9() {
      return this.wlanDriver;
   }

   public final DeviceInfoData copy(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, Long var10, Long var11, Long var12, Long var13, Long var14, Long var15, String var16, Long var17) {
      return new DeviceInfoData(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceInfoData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timezone, var1.timezone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.compatibility, var1.compatibility)) {
            return false;
         } else if (!Intrinsics.areEqual(this.model, var1.model)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else if (!Intrinsics.areEqual(this.firmware, var1.firmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wlanDriver, var1.wlanDriver)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastSyncDate, var1.lastSyncDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.installationDate, var1.installationDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastCalibrationDate, var1.lastCalibrationDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.initUsagePeriod, var1.initUsagePeriod)) {
            return false;
         } else if (!Intrinsics.areEqual(this.rebootPeriod, var1.rebootPeriod)) {
            return false;
         } else if (!Intrinsics.areEqual(this.refurbDate, var1.refurbDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.aimSerialNumber, var1.aimSerialNumber)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.aimUpdateDate, var1.aimUpdateDate);
         }
      }
   }

   public final String getAimSerialNumber() {
      return this.aimSerialNumber;
   }

   public final Long getAimUpdateDate() {
      return this.aimUpdateDate;
   }

   public final String getCompatibility() {
      return this.compatibility;
   }

   public final String getFirmware() {
      return this.firmware;
   }

   public final Long getInitUsagePeriod() {
      return this.initUsagePeriod;
   }

   public final Long getInstallationDate() {
      return this.installationDate;
   }

   public final Long getLastCalibrationDate() {
      return this.lastCalibrationDate;
   }

   public final Long getLastSyncDate() {
      return this.lastSyncDate;
   }

   public final String getMac() {
      return this.mac;
   }

   public final String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public final String getModel() {
      return this.model;
   }

   public final String getName() {
      return this.name;
   }

   public final Long getRebootPeriod() {
      return this.rebootPeriod;
   }

   public final Long getRefurbDate() {
      return this.refurbDate;
   }

   public final String getTimezone() {
      return this.timezone;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public final String getWlanDriver() {
      return this.wlanDriver;
   }

   public int hashCode() {
      String var18 = this.uuid;
      int var17 = 0;
      int var1;
      if (var18 == null) {
         var1 = 0;
      } else {
         var1 = var18.hashCode();
      }

      var18 = this.name;
      int var2;
      if (var18 == null) {
         var2 = 0;
      } else {
         var2 = var18.hashCode();
      }

      var18 = this.timezone;
      int var3;
      if (var18 == null) {
         var3 = 0;
      } else {
         var3 = var18.hashCode();
      }

      var18 = this.compatibility;
      int var4;
      if (var18 == null) {
         var4 = 0;
      } else {
         var4 = var18.hashCode();
      }

      var18 = this.model;
      int var5;
      if (var18 == null) {
         var5 = 0;
      } else {
         var5 = var18.hashCode();
      }

      var18 = this.mac;
      int var6;
      if (var18 == null) {
         var6 = 0;
      } else {
         var6 = var18.hashCode();
      }

      var18 = this.firmware;
      int var7;
      if (var18 == null) {
         var7 = 0;
      } else {
         var7 = var18.hashCode();
      }

      var18 = this.mcuFirmware;
      int var8;
      if (var18 == null) {
         var8 = 0;
      } else {
         var8 = var18.hashCode();
      }

      var18 = this.wlanDriver;
      int var9;
      if (var18 == null) {
         var9 = 0;
      } else {
         var9 = var18.hashCode();
      }

      Long var27 = this.lastSyncDate;
      int var10;
      if (var27 == null) {
         var10 = 0;
      } else {
         var10 = var27.hashCode();
      }

      var27 = this.installationDate;
      int var11;
      if (var27 == null) {
         var11 = 0;
      } else {
         var11 = var27.hashCode();
      }

      var27 = this.lastCalibrationDate;
      int var12;
      if (var27 == null) {
         var12 = 0;
      } else {
         var12 = var27.hashCode();
      }

      var27 = this.initUsagePeriod;
      int var13;
      if (var27 == null) {
         var13 = 0;
      } else {
         var13 = var27.hashCode();
      }

      var27 = this.rebootPeriod;
      int var14;
      if (var27 == null) {
         var14 = 0;
      } else {
         var14 = var27.hashCode();
      }

      var27 = this.refurbDate;
      int var15;
      if (var27 == null) {
         var15 = 0;
      } else {
         var15 = var27.hashCode();
      }

      String var33 = this.aimSerialNumber;
      int var16;
      if (var33 == null) {
         var16 = 0;
      } else {
         var16 = var33.hashCode();
      }

      Long var34 = this.aimUpdateDate;
      if (var34 != null) {
         var17 = var34.hashCode();
      }

      return (((((((((((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11) * 31 + var12) * 31 + var13) * 31 + var14) * 31 + var15) * 31 + var16) * 31 + var17;
   }

   public final DeviceDetailsOnAblServer toDeviceDetailsOnServer() {
      String var4 = this.compatibility;
      String var1 = this.firmware;
      String var3 = this.name;
      String var2 = this.uuid;
      Intrinsics.checkNotNull(var2);
      return new DeviceDetailsOnAblServer(var4, var1, var3, var2, this.timezone, this.mcuFirmware, this.mac, this.aimSerialNumber, this.aimUpdateDate);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceInfoData(uuid=");
      var1.append(this.uuid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", timezone=");
      var1.append(this.timezone);
      var1.append(", compatibility=");
      var1.append(this.compatibility);
      var1.append(", model=");
      var1.append(this.model);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", firmware=");
      var1.append(this.firmware);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", wlanDriver=");
      var1.append(this.wlanDriver);
      var1.append(", lastSyncDate=");
      var1.append(this.lastSyncDate);
      var1.append(", installationDate=");
      var1.append(this.installationDate);
      var1.append(", lastCalibrationDate=");
      var1.append(this.lastCalibrationDate);
      var1.append(", initUsagePeriod=");
      var1.append(this.initUsagePeriod);
      var1.append(", rebootPeriod=");
      var1.append(this.rebootPeriod);
      var1.append(", refurbDate=");
      var1.append(this.refurbDate);
      var1.append(", aimSerialNumber=");
      var1.append(this.aimSerialNumber);
      var1.append(", aimUpdateDate=");
      var1.append(this.aimUpdateDate);
      var1.append(')');
      return var1.toString();
   }
}
