package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/DeviceOnBlueServer;", "", "uuid", "", "name", "deviceType", "wifiFirmware", "mcuFirmware", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getName", "getDeviceType", "getWifiFirmware", "getMcuFirmware", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOnBlueServer {
   private final String deviceType;
   private final String mcuFirmware;
   private final String name;
   private final String uuid;
   private final String wifiFirmware;

   public DeviceOnBlueServer(String var1, String var2, @Json(name = "type") String var3, @Json(name = "wifi-firmware") String var4, @Json(name = "mcu-firmware") String var5) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "deviceType");
      super();
      this.uuid = var1;
      this.name = var2;
      this.deviceType = var3;
      this.wifiFirmware = var4;
      this.mcuFirmware = var5;
   }

   // $FF: synthetic method
   public DeviceOnBlueServer(String var1, String var2, String var3, String var4, String var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = "";
      }

      if ((var6 & 16) != 0) {
         var5 = "";
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static DeviceOnBlueServer copy$default(DeviceOnBlueServer var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.uuid;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.deviceType;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.wifiFirmware;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.mcuFirmware;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.uuid;
   }

   public final String component2() {
      return this.name;
   }

   public final String component3() {
      return this.deviceType;
   }

   public final String component4() {
      return this.wifiFirmware;
   }

   public final String component5() {
      return this.mcuFirmware;
   }

   public final DeviceOnBlueServer copy(String var1, String var2, @Json(name = "type") String var3, @Json(name = "wifi-firmware") String var4, @Json(name = "mcu-firmware") String var5) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "deviceType");
      return new DeviceOnBlueServer(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceOnBlueServer)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceType, var1.deviceType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wifiFirmware, var1.wifiFirmware)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware);
         }
      }
   }

   public final String getDeviceType() {
      return this.deviceType;
   }

   public final String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public final String getName() {
      return this.name;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public final String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var4 = this.uuid.hashCode();
      int var3 = this.name.hashCode();
      int var5 = this.deviceType.hashCode();
      String var6 = this.wifiFirmware;
      int var2 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.mcuFirmware;
      if (var6 != null) {
         var2 = var6.hashCode();
      }

      return (((var4 * 31 + var3) * 31 + var5) * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceOnBlueServer(uuid=");
      var1.append(this.uuid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", deviceType=");
      var1.append(this.deviceType);
      var1.append(", wifiFirmware=");
      var1.append(this.wifiFirmware);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(')');
      return var1.toString();
   }
}
