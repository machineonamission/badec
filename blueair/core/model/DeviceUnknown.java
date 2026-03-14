package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b4\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B¯\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0004HÆ\u0003J\t\u00108\u001a\u00020\u0004HÆ\u0003J\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\t\u0010<\u001a\u00020\u0004HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003Jµ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\tHÆ\u0001J\u0006\u0010?\u001a\u00020\tJ\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\tHÖ\u0001J\t\u0010E\u001a\u00020\u0004HÖ\u0001J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\tR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0014\u0010\u0010\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0014\u0010\u0011\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0014\u0010\u0012\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0014\u0010\u0013\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0014\u0010\u0014\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0014\u0010\u0015\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0014\u0010\u0016\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001f¨\u0006K"},
   d2 = {"Lcom/blueair/core/model/DeviceUnknown;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "sku", "", "uid", "name", "modelName", "typeIndex", "", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "updateProgress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getSku", "()Ljava/lang/String;", "getUid", "getName", "getModelName", "getTypeIndex", "()I", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getUpdateProgress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceUnknown implements HasSKU, HasBlueCloudFunctions {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int connectivityStatusIndex;
   private final String dealerCountry;
   private final String dealerName;
   private final String hardware;
   private final long lastConnectivityInMillis;
   private final String mac;
   private final String mcuFirmware;
   private final String modelName;
   private final String name;
   private final String purchaseDate;
   private final String serial;
   private final String sku;
   private final String timeZone;
   private final int typeIndex;
   private final String uid;
   private final int updateProgress;
   private final String wifiFirmware;

   public DeviceUnknown(String var1, String var2, String var3, String var4, int var5, int var6, long var7, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, int var18) {
      Intrinsics.checkNotNullParameter(var2, "uid");
      Intrinsics.checkNotNullParameter(var3, "name");
      Intrinsics.checkNotNullParameter(var4, "modelName");
      Intrinsics.checkNotNullParameter(var9, "mac");
      Intrinsics.checkNotNullParameter(var10, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var11, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var12, "hardware");
      Intrinsics.checkNotNullParameter(var13, "timeZone");
      Intrinsics.checkNotNullParameter(var14, "serial");
      Intrinsics.checkNotNullParameter(var15, "purchaseDate");
      Intrinsics.checkNotNullParameter(var16, "dealerName");
      Intrinsics.checkNotNullParameter(var17, "dealerCountry");
      super();
      this.sku = var1;
      this.uid = var2;
      this.name = var3;
      this.modelName = var4;
      this.typeIndex = var5;
      this.connectivityStatusIndex = var6;
      this.lastConnectivityInMillis = var7;
      this.mac = var9;
      this.mcuFirmware = var10;
      this.wifiFirmware = var11;
      this.hardware = var12;
      this.timeZone = var13;
      this.serial = var14;
      this.purchaseDate = var15;
      this.dealerName = var16;
      this.dealerCountry = var17;
      this.updateProgress = var18;
   }

   // $FF: synthetic method
   public DeviceUnknown(String var1, String var2, String var3, String var4, int var5, int var6, long var7, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, int var18, int var19, DefaultConstructorMarker var20) {
      if ((var19 & 4) != 0) {
         var3 = DeviceType.Unknown.INSTANCE.getName();
      }

      if ((var19 & 8) != 0) {
         var4 = DeviceType.Unknown.INSTANCE.getName();
      }

      if ((var19 & 16) != 0) {
         var5 = DeviceType.Unknown.INSTANCE.getIndex();
      }

      if ((var19 & 32) != 0) {
         var6 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var19 & 64) != 0) {
         var7 = 0L;
      }

      if ((var19 & 128) != 0) {
         var9 = "";
      }

      if ((var19 & 256) != 0) {
         var10 = "";
      }

      if ((var19 & 512) != 0) {
         var11 = "";
      }

      if ((var19 & 1024) != 0) {
         var12 = "";
      }

      if ((var19 & 2048) != 0) {
         var13 = "";
      }

      if ((var19 & 4096) != 0) {
         var14 = "";
      }

      if ((var19 & 8192) != 0) {
         var15 = "";
      }

      if ((var19 & 16384) != 0) {
         var16 = "";
      }

      if (('耀' & var19) != 0) {
         var17 = "";
      }

      if ((var19 & 65536) != 0) {
         var18 = 0;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
   }

   // $FF: synthetic method
   public static DeviceUnknown copy$default(DeviceUnknown var0, String var1, String var2, String var3, String var4, int var5, int var6, long var7, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, int var18, int var19, Object var20) {
      if ((var19 & 1) != 0) {
         var1 = var0.sku;
      }

      if ((var19 & 2) != 0) {
         var2 = var0.uid;
      }

      if ((var19 & 4) != 0) {
         var3 = var0.name;
      }

      if ((var19 & 8) != 0) {
         var4 = var0.modelName;
      }

      if ((var19 & 16) != 0) {
         var5 = var0.typeIndex;
      }

      if ((var19 & 32) != 0) {
         var6 = var0.connectivityStatusIndex;
      }

      if ((var19 & 64) != 0) {
         var7 = var0.lastConnectivityInMillis;
      }

      if ((var19 & 128) != 0) {
         var9 = var0.mac;
      }

      if ((var19 & 256) != 0) {
         var10 = var0.mcuFirmware;
      }

      if ((var19 & 512) != 0) {
         var11 = var0.wifiFirmware;
      }

      if ((var19 & 1024) != 0) {
         var12 = var0.hardware;
      }

      if ((var19 & 2048) != 0) {
         var13 = var0.timeZone;
      }

      if ((var19 & 4096) != 0) {
         var14 = var0.serial;
      }

      if ((var19 & 8192) != 0) {
         var15 = var0.purchaseDate;
      }

      if ((var19 & 16384) != 0) {
         var16 = var0.dealerName;
      }

      if ((var19 & '耀') != 0) {
         var17 = var0.dealerCountry;
      }

      if ((var19 & 65536) != 0) {
         var18 = var0.updateProgress;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
   }

   public final String component1() {
      return this.sku;
   }

   public final String component10() {
      return this.wifiFirmware;
   }

   public final String component11() {
      return this.hardware;
   }

   public final String component12() {
      return this.timeZone;
   }

   public final String component13() {
      return this.serial;
   }

   public final String component14() {
      return this.purchaseDate;
   }

   public final String component15() {
      return this.dealerName;
   }

   public final String component16() {
      return this.dealerCountry;
   }

   public final int component17() {
      return this.updateProgress;
   }

   public final String component2() {
      return this.uid;
   }

   public final String component3() {
      return this.name;
   }

   public final String component4() {
      return this.modelName;
   }

   public final int component5() {
      return this.typeIndex;
   }

   public final int component6() {
      return this.connectivityStatusIndex;
   }

   public final long component7() {
      return this.lastConnectivityInMillis;
   }

   public final String component8() {
      return this.mac;
   }

   public final String component9() {
      return this.mcuFirmware;
   }

   public final DeviceUnknown copy(String var1, String var2, String var3, String var4, int var5, int var6, long var7, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, int var18) {
      Intrinsics.checkNotNullParameter(var2, "uid");
      Intrinsics.checkNotNullParameter(var3, "name");
      Intrinsics.checkNotNullParameter(var4, "modelName");
      Intrinsics.checkNotNullParameter(var9, "mac");
      Intrinsics.checkNotNullParameter(var10, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var11, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var12, "hardware");
      Intrinsics.checkNotNullParameter(var13, "timeZone");
      Intrinsics.checkNotNullParameter(var14, "serial");
      Intrinsics.checkNotNullParameter(var15, "purchaseDate");
      Intrinsics.checkNotNullParameter(var16, "dealerName");
      Intrinsics.checkNotNullParameter(var17, "dealerCountry");
      return new DeviceUnknown(var1, var2, var3, var4, var5, var6, var7, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceUnknown)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (this.connectivityStatusIndex != var1.connectivityStatusIndex) {
            return false;
         } else if (this.lastConnectivityInMillis != var1.lastConnectivityInMillis) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wifiFirmware, var1.wifiFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hardware, var1.hardware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeZone, var1.timeZone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.serial, var1.serial)) {
            return false;
         } else if (!Intrinsics.areEqual(this.purchaseDate, var1.purchaseDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerName, var1.dealerName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerCountry, var1.dealerCountry)) {
            return false;
         } else {
            return this.updateProgress == var1.updateProgress;
         }
      }
   }

   public ConnectivityStatus getConnectivityStatus() {
      return Device$_CC.$default$getConnectivityStatus(this);
   }

   public int getConnectivityStatusIndex() {
      return this.connectivityStatusIndex;
   }

   public String getDealerCountry() {
      return this.dealerCountry;
   }

   public String getDealerName() {
      return this.dealerName;
   }

   public String getHardware() {
      return this.hardware;
   }

   public long getLastConnectivityInMillis() {
      return this.lastConnectivityInMillis;
   }

   public String getMac() {
      return this.mac;
   }

   public String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public String getModelName() {
      return this.modelName;
   }

   public String getName() {
      return this.name;
   }

   public String getPurchaseDate() {
      return this.purchaseDate;
   }

   public String getSerial() {
      return this.serial;
   }

   public String getSku() {
      return this.sku;
   }

   public String getTimeZone() {
      return this.timeZone;
   }

   public TimeZone getTimezone(Context var1) {
      return Device$_CC.$default$getTimezone(this, var1);
   }

   public DeviceType getType() {
      return Device$_CC.$default$getType(this);
   }

   public int getTypeIndex() {
      return this.typeIndex;
   }

   public String getUid() {
      return this.uid;
   }

   public int getUpdateProgress() {
      return this.updateProgress;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      String var2 = this.sku;
      int var1;
      if (var2 == null) {
         var1 = 0;
      } else {
         var1 = var2.hashCode();
      }

      return (((((((((((((((var1 * 31 + this.uid.hashCode()) * 31 + this.name.hashCode()) * 31 + this.modelName.hashCode()) * 31 + this.typeIndex) * 31 + this.connectivityStatusIndex) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31 + this.mac.hashCode()) * 31 + this.mcuFirmware.hashCode()) * 31 + this.wifiFirmware.hashCode()) * 31 + this.hardware.hashCode()) * 31 + this.timeZone.hashCode()) * 31 + this.serial.hashCode()) * 31 + this.purchaseDate.hashCode()) * 31 + this.dealerName.hashCode()) * 31 + this.dealerCountry.hashCode()) * 31 + this.updateProgress;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isOnline() {
      return Device$_CC.$default$isOnline(this);
   }

   public boolean isUsDevice() {
      return Device$_CC.$default$isUsDevice(this);
   }

   public boolean supportResetFilterOnline() {
      return Device$_CC.$default$supportResetFilterOnline(this);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceUnknown(sku=");
      var1.append(this.sku);
      var1.append(", uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", connectivityStatusIndex=");
      var1.append(this.connectivityStatusIndex);
      var1.append(", lastConnectivityInMillis=");
      var1.append(this.lastConnectivityInMillis);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", wifiFirmware=");
      var1.append(this.wifiFirmware);
      var1.append(", hardware=");
      var1.append(this.hardware);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(", serial=");
      var1.append(this.serial);
      var1.append(", purchaseDate=");
      var1.append(this.purchaseDate);
      var1.append(", dealerName=");
      var1.append(this.dealerName);
      var1.append(", dealerCountry=");
      var1.append(this.dealerCountry);
      var1.append(", updateProgress=");
      var1.append(this.updateProgress);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.sku);
      var1.writeString(this.uid);
      var1.writeString(this.name);
      var1.writeString(this.modelName);
      var1.writeInt(this.typeIndex);
      var1.writeInt(this.connectivityStatusIndex);
      var1.writeLong(this.lastConnectivityInMillis);
      var1.writeString(this.mac);
      var1.writeString(this.mcuFirmware);
      var1.writeString(this.wifiFirmware);
      var1.writeString(this.hardware);
      var1.writeString(this.timeZone);
      var1.writeString(this.serial);
      var1.writeString(this.purchaseDate);
      var1.writeString(this.dealerName);
      var1.writeString(this.dealerCountry);
      var1.writeInt(this.updateProgress);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceUnknown createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new DeviceUnknown(var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readInt(), var1.readInt(), var1.readLong(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readInt());
      }

      public final DeviceUnknown[] newArray(int var1) {
         return new DeviceUnknown[var1];
      }
   }
}
