package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jx\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006,"},
   d2 = {"Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "", "compatibility", "", "firmware", "name", "uuid", "timezone", "mcuFirmware", "mac", "aimSerialNumber", "aimUpdateDate", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getCompatibility", "()Ljava/lang/String;", "getFirmware", "getName", "getUuid", "getTimezone", "getMcuFirmware", "getMac", "getAimSerialNumber", "getAimUpdateDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetailsOnAblServer {
   private final String aimSerialNumber;
   private final Long aimUpdateDate;
   private final String compatibility;
   private final String firmware;
   private final String mac;
   private final String mcuFirmware;
   private final String name;
   private final String timezone;
   private final String uuid;

   public DeviceDetailsOnAblServer(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Long var9) {
      Intrinsics.checkNotNullParameter(var4, "uuid");
      super();
      this.compatibility = var1;
      this.firmware = var2;
      this.name = var3;
      this.uuid = var4;
      this.timezone = var5;
      this.mcuFirmware = var6;
      this.mac = var7;
      this.aimSerialNumber = var8;
      this.aimUpdateDate = var9;
   }

   // $FF: synthetic method
   public static DeviceDetailsOnAblServer copy$default(DeviceDetailsOnAblServer var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Long var9, int var10, Object var11) {
      if ((var10 & 1) != 0) {
         var1 = var0.compatibility;
      }

      if ((var10 & 2) != 0) {
         var2 = var0.firmware;
      }

      if ((var10 & 4) != 0) {
         var3 = var0.name;
      }

      if ((var10 & 8) != 0) {
         var4 = var0.uuid;
      }

      if ((var10 & 16) != 0) {
         var5 = var0.timezone;
      }

      if ((var10 & 32) != 0) {
         var6 = var0.mcuFirmware;
      }

      if ((var10 & 64) != 0) {
         var7 = var0.mac;
      }

      if ((var10 & 128) != 0) {
         var8 = var0.aimSerialNumber;
      }

      if ((var10 & 256) != 0) {
         var9 = var0.aimUpdateDate;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public final String component1() {
      return this.compatibility;
   }

   public final String component2() {
      return this.firmware;
   }

   public final String component3() {
      return this.name;
   }

   public final String component4() {
      return this.uuid;
   }

   public final String component5() {
      return this.timezone;
   }

   public final String component6() {
      return this.mcuFirmware;
   }

   public final String component7() {
      return this.mac;
   }

   public final String component8() {
      return this.aimSerialNumber;
   }

   public final Long component9() {
      return this.aimUpdateDate;
   }

   public final DeviceDetailsOnAblServer copy(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Long var9) {
      Intrinsics.checkNotNullParameter(var4, "uuid");
      return new DeviceDetailsOnAblServer(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceDetailsOnAblServer)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.compatibility, var1.compatibility)) {
            return false;
         } else if (!Intrinsics.areEqual(this.firmware, var1.firmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timezone, var1.timezone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
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

   public final String getMac() {
      return this.mac;
   }

   public final String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public final String getName() {
      return this.name;
   }

   public final String getTimezone() {
      return this.timezone;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      String var10 = this.compatibility;
      int var8 = 0;
      int var1;
      if (var10 == null) {
         var1 = 0;
      } else {
         var1 = var10.hashCode();
      }

      var10 = this.firmware;
      int var2;
      if (var10 == null) {
         var2 = 0;
      } else {
         var2 = var10.hashCode();
      }

      var10 = this.name;
      int var3;
      if (var10 == null) {
         var3 = 0;
      } else {
         var3 = var10.hashCode();
      }

      int var9 = this.uuid.hashCode();
      var10 = this.timezone;
      int var4;
      if (var10 == null) {
         var4 = 0;
      } else {
         var4 = var10.hashCode();
      }

      var10 = this.mcuFirmware;
      int var5;
      if (var10 == null) {
         var5 = 0;
      } else {
         var5 = var10.hashCode();
      }

      var10 = this.mac;
      int var6;
      if (var10 == null) {
         var6 = 0;
      } else {
         var6 = var10.hashCode();
      }

      var10 = this.aimSerialNumber;
      int var7;
      if (var10 == null) {
         var7 = 0;
      } else {
         var7 = var10.hashCode();
      }

      Long var17 = this.aimUpdateDate;
      if (var17 != null) {
         var8 = var17.hashCode();
      }

      return (((((((var1 * 31 + var2) * 31 + var3) * 31 + var9) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceDetailsOnAblServer(compatibility=");
      var1.append(this.compatibility);
      var1.append(", firmware=");
      var1.append(this.firmware);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", uuid=");
      var1.append(this.uuid);
      var1.append(", timezone=");
      var1.append(this.timezone);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", aimSerialNumber=");
      var1.append(this.aimSerialNumber);
      var1.append(", aimUpdateDate=");
      var1.append(this.aimUpdateDate);
      var1.append(')');
      return var1.toString();
   }
}
