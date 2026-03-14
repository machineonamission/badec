package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jg\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u00061"},
   d2 = {"Lcom/blueair/devicemanager/IcpDeviceInfo;", "", "device", "Lcom/blueair/devicemanager/IcpDevice;", "firmwareChildMain", "", "firmwareChildPlug", "firmwareRevision", "hardwareRevision", "macAddress", "manufacturerName", "serialNumber", "<init>", "(Lcom/blueair/devicemanager/IcpDevice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDevice", "()Lcom/blueair/devicemanager/IcpDevice;", "setDevice", "(Lcom/blueair/devicemanager/IcpDevice;)V", "getFirmwareChildMain", "()Ljava/lang/String;", "setFirmwareChildMain", "(Ljava/lang/String;)V", "getFirmwareChildPlug", "setFirmwareChildPlug", "getFirmwareRevision", "setFirmwareRevision", "getHardwareRevision", "setHardwareRevision", "getMacAddress", "setMacAddress", "getManufacturerName", "setManufacturerName", "getSerialNumber", "setSerialNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpDeviceInfo {
   private IcpDevice device;
   private String firmwareChildMain;
   private String firmwareChildPlug;
   private String firmwareRevision;
   private String hardwareRevision;
   private String macAddress;
   private String manufacturerName;
   private String serialNumber;

   public IcpDeviceInfo(IcpDevice var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
      Intrinsics.checkNotNullParameter(var1, "device");
      super();
      this.device = var1;
      this.firmwareChildMain = var2;
      this.firmwareChildPlug = var3;
      this.firmwareRevision = var4;
      this.hardwareRevision = var5;
      this.macAddress = var6;
      this.manufacturerName = var7;
      this.serialNumber = var8;
   }

   // $FF: synthetic method
   public static IcpDeviceInfo copy$default(IcpDeviceInfo var0, IcpDevice var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.device;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.firmwareChildMain;
      }

      if ((var9 & 4) != 0) {
         var3 = var0.firmwareChildPlug;
      }

      if ((var9 & 8) != 0) {
         var4 = var0.firmwareRevision;
      }

      if ((var9 & 16) != 0) {
         var5 = var0.hardwareRevision;
      }

      if ((var9 & 32) != 0) {
         var6 = var0.macAddress;
      }

      if ((var9 & 64) != 0) {
         var7 = var0.manufacturerName;
      }

      if ((var9 & 128) != 0) {
         var8 = var0.serialNumber;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final IcpDevice component1() {
      return this.device;
   }

   public final String component2() {
      return this.firmwareChildMain;
   }

   public final String component3() {
      return this.firmwareChildPlug;
   }

   public final String component4() {
      return this.firmwareRevision;
   }

   public final String component5() {
      return this.hardwareRevision;
   }

   public final String component6() {
      return this.macAddress;
   }

   public final String component7() {
      return this.manufacturerName;
   }

   public final String component8() {
      return this.serialNumber;
   }

   public final IcpDeviceInfo copy(IcpDevice var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return new IcpDeviceInfo(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof IcpDeviceInfo)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.device, var1.device)) {
            return false;
         } else if (!Intrinsics.areEqual(this.firmwareChildMain, var1.firmwareChildMain)) {
            return false;
         } else if (!Intrinsics.areEqual(this.firmwareChildPlug, var1.firmwareChildPlug)) {
            return false;
         } else if (!Intrinsics.areEqual(this.firmwareRevision, var1.firmwareRevision)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hardwareRevision, var1.hardwareRevision)) {
            return false;
         } else if (!Intrinsics.areEqual(this.macAddress, var1.macAddress)) {
            return false;
         } else if (!Intrinsics.areEqual(this.manufacturerName, var1.manufacturerName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.serialNumber, var1.serialNumber);
         }
      }
   }

   public final IcpDevice getDevice() {
      return this.device;
   }

   public final String getFirmwareChildMain() {
      return this.firmwareChildMain;
   }

   public final String getFirmwareChildPlug() {
      return this.firmwareChildPlug;
   }

   public final String getFirmwareRevision() {
      return this.firmwareRevision;
   }

   public final String getHardwareRevision() {
      return this.hardwareRevision;
   }

   public final String getMacAddress() {
      return this.macAddress;
   }

   public final String getManufacturerName() {
      return this.manufacturerName;
   }

   public final String getSerialNumber() {
      return this.serialNumber;
   }

   public int hashCode() {
      int var8 = this.device.hashCode();
      String var9 = this.firmwareChildMain;
      int var7 = 0;
      int var1;
      if (var9 == null) {
         var1 = 0;
      } else {
         var1 = var9.hashCode();
      }

      var9 = this.firmwareChildPlug;
      int var2;
      if (var9 == null) {
         var2 = 0;
      } else {
         var2 = var9.hashCode();
      }

      var9 = this.firmwareRevision;
      int var3;
      if (var9 == null) {
         var3 = 0;
      } else {
         var3 = var9.hashCode();
      }

      var9 = this.hardwareRevision;
      int var4;
      if (var9 == null) {
         var4 = 0;
      } else {
         var4 = var9.hashCode();
      }

      var9 = this.macAddress;
      int var5;
      if (var9 == null) {
         var5 = 0;
      } else {
         var5 = var9.hashCode();
      }

      var9 = this.manufacturerName;
      int var6;
      if (var9 == null) {
         var6 = 0;
      } else {
         var6 = var9.hashCode();
      }

      var9 = this.serialNumber;
      if (var9 != null) {
         var7 = var9.hashCode();
      }

      return ((((((var8 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7;
   }

   public final void setDevice(IcpDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final void setFirmwareChildMain(String var1) {
      this.firmwareChildMain = var1;
   }

   public final void setFirmwareChildPlug(String var1) {
      this.firmwareChildPlug = var1;
   }

   public final void setFirmwareRevision(String var1) {
      this.firmwareRevision = var1;
   }

   public final void setHardwareRevision(String var1) {
      this.hardwareRevision = var1;
   }

   public final void setMacAddress(String var1) {
      this.macAddress = var1;
   }

   public final void setManufacturerName(String var1) {
      this.manufacturerName = var1;
   }

   public final void setSerialNumber(String var1) {
      this.serialNumber = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("IcpDeviceInfo(device=");
      var1.append(this.device);
      var1.append(", firmwareChildMain=");
      var1.append(this.firmwareChildMain);
      var1.append(", firmwareChildPlug=");
      var1.append(this.firmwareChildPlug);
      var1.append(", firmwareRevision=");
      var1.append(this.firmwareRevision);
      var1.append(", hardwareRevision=");
      var1.append(this.hardwareRevision);
      var1.append(", macAddress=");
      var1.append(this.macAddress);
      var1.append(", manufacturerName=");
      var1.append(this.manufacturerName);
      var1.append(", serialNumber=");
      var1.append(this.serialNumber);
      var1.append(')');
      return var1.toString();
   }
}
