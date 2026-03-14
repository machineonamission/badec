package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.AblWifFirmwareUtils;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bBÿ\u0001\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010%\u001a\u00020!\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\u0010'\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b(\u0010)J\t\u0010N\u001a\u00020\nHÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\t\u0010T\u001a\u00020\u0013HÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\u0016HÆ\u0003J\t\u0010W\u001a\u00020\nHÆ\u0003J\t\u0010X\u001a\u00020\nHÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\nHÆ\u0003J\t\u0010[\u001a\u00020\nHÆ\u0003J\t\u0010\\\u001a\u00020\nHÆ\u0003J\t\u0010]\u001a\u00020\nHÆ\u0003J\t\u0010^\u001a\u00020\nHÆ\u0003J\t\u0010_\u001a\u00020\nHÆ\u0003J\t\u0010`\u001a\u00020!HÆ\u0003J\t\u0010a\u001a\u00020!HÆ\u0003J\t\u0010b\u001a\u00020!HÆ\u0003J\t\u0010c\u001a\u00020!HÆ\u0003J\t\u0010d\u001a\u00020!HÆ\u0003J\t\u0010e\u001a\u00020\rHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0089\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010h\u001a\u00020\rJ\u0013\u0010i\u001a\u00020\u00132\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\rHÖ\u0001J\t\u0010m\u001a\u00020\nHÖ\u0001J\u0016\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\rR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u0010\u0011\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00103R\u0014\u0010\u0014\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u0010\u0017\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0014\u0010\u0018\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0014\u0010\u0019\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0014\u0010\u001a\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0014\u0010\u001b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0014\u0010\u001c\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0014\u0010\u001d\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0014\u0010\u001e\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0014\u0010\u001f\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010\"\u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010AR\u0014\u0010#\u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010AR\u0014\u0010$\u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0014\u0010%\u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR\u0014\u0010&\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0016\u0010'\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+R\u0014\u0010H\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010+R\u0014\u0010J\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.R\u0014\u0010L\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u00103¨\u0006s"},
   d2 = {"Lcom/blueair/core/model/DeviceAware;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "brightness", "", "info", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isNightmodeOn", "", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getBrightness", "()I", "getInfo", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getCompatibility", "modelName", "getModelName", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAware implements Device, HasBrightness, HasInfo, HasAblCloudFunctions, HasSensorData, HasNightMode, HasScheduling, HasCompatibility {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int brightness;
   private final String compatibility;
   private final int connectivityStatusIndex;
   private final String dealerCountry;
   private final String dealerName;
   private final String hardware;
   private final double[] hchoRanges;
   private final String info;
   private final boolean isNightmodeOn;
   private final long lastConnectivityInMillis;
   private final int lastSelectedSensorTypeIndex;
   private final IndoorDatapoint latestSensorDatapoint;
   private final String mac;
   private final String mcuFirmware;
   private final String modelName;
   private final String name;
   private final double[] pm10Ranges;
   private final double[] pm1Ranges;
   private final double[] pm25Ranges;
   private final String purchaseDate;
   private final String serial;
   private final String timeZone;
   private final int typeIndex;
   private final String uid;
   private final int updateProgress;
   private final double[] vocRanges;
   private final String wifiFirmware;

   public DeviceAware(String var1, String var2, int var3, String var4, IndoorDatapoint var5, int var6, boolean var7, int var8, long var9, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, double[] var20, double[] var21, double[] var22, double[] var23, double[] var24, int var25, String var26) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var11, "mac");
      Intrinsics.checkNotNullParameter(var12, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var13, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var14, "hardware");
      Intrinsics.checkNotNullParameter(var15, "timeZone");
      Intrinsics.checkNotNullParameter(var16, "serial");
      Intrinsics.checkNotNullParameter(var17, "purchaseDate");
      Intrinsics.checkNotNullParameter(var18, "dealerName");
      Intrinsics.checkNotNullParameter(var19, "dealerCountry");
      Intrinsics.checkNotNullParameter(var20, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var21, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var22, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var23, "vocRanges");
      Intrinsics.checkNotNullParameter(var24, "hchoRanges");
      super();
      this.uid = var1;
      this.name = var2;
      this.brightness = var3;
      this.info = var4;
      this.latestSensorDatapoint = var5;
      this.lastSelectedSensorTypeIndex = var6;
      this.isNightmodeOn = var7;
      this.connectivityStatusIndex = var8;
      this.lastConnectivityInMillis = var9;
      this.mac = var11;
      this.mcuFirmware = var12;
      this.wifiFirmware = var13;
      this.hardware = var14;
      this.timeZone = var15;
      this.serial = var16;
      this.purchaseDate = var17;
      this.dealerName = var18;
      this.dealerCountry = var19;
      this.pm1Ranges = var20;
      this.pm10Ranges = var21;
      this.pm25Ranges = var22;
      this.vocRanges = var23;
      this.hchoRanges = var24;
      this.updateProgress = var25;
      this.compatibility = var26;
      this.modelName = DeviceType.Aware.INSTANCE.getName();
      this.typeIndex = DeviceType.Aware.INSTANCE.getIndex();
   }

   // $FF: synthetic method
   public DeviceAware(String var1, String var2, int var3, String var4, IndoorDatapoint var5, int var6, boolean var7, int var8, long var9, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, double[] var20, double[] var21, double[] var22, double[] var23, double[] var24, int var25, String var26, int var27, DefaultConstructorMarker var28) {
      if ((var27 & 4) != 0) {
         var3 = 0;
      }

      if ((var27 & 16) != 0) {
         var5 = null;
      }

      if ((var27 & 32) != 0) {
         var6 = 0;
      }

      if ((var27 & 64) != 0) {
         var7 = false;
      }

      if ((var27 & 128) != 0) {
         var8 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var27 & 256) != 0) {
         var9 = 0L;
      }

      if ((var27 & 512) != 0) {
         var11 = "";
      }

      if ((var27 & 1024) != 0) {
         var12 = "";
      }

      if ((var27 & 2048) != 0) {
         var13 = "";
      }

      if ((var27 & 4096) != 0) {
         var14 = "";
      }

      if ((var27 & 8192) != 0) {
         var15 = "";
      }

      if ((var27 & 16384) != 0) {
         var16 = "";
      }

      if (('耀' & var27) != 0) {
         var17 = "";
      }

      if ((65536 & var27) != 0) {
         var18 = "";
      }

      if ((131072 & var27) != 0) {
         var19 = "";
      }

      if ((262144 & var27) != 0) {
         var20 = new double[0];
      }

      if ((524288 & var27) != 0) {
         var21 = new double[0];
      }

      if ((1048576 & var27) != 0) {
         var22 = new double[0];
      }

      if ((2097152 & var27) != 0) {
         var23 = new double[0];
      }

      if ((4194304 & var27) != 0) {
         var24 = new double[0];
      }

      if ((var27 & 8388608) != 0) {
         var25 = 0;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26);
   }

   // $FF: synthetic method
   public static DeviceAware copy$default(DeviceAware var0, String var1, String var2, int var3, String var4, IndoorDatapoint var5, int var6, boolean var7, int var8, long var9, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, double[] var20, double[] var21, double[] var22, double[] var23, double[] var24, int var25, String var26, int var27, Object var28) {
      if ((var27 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var27 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var27 & 4) != 0) {
         var3 = var0.brightness;
      }

      if ((var27 & 8) != 0) {
         var4 = var0.info;
      }

      if ((var27 & 16) != 0) {
         var5 = var0.latestSensorDatapoint;
      }

      if ((var27 & 32) != 0) {
         var6 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var27 & 64) != 0) {
         var7 = var0.isNightmodeOn;
      }

      if ((var27 & 128) != 0) {
         var8 = var0.connectivityStatusIndex;
      }

      if ((var27 & 256) != 0) {
         var9 = var0.lastConnectivityInMillis;
      }

      if ((var27 & 512) != 0) {
         var11 = var0.mac;
      }

      if ((var27 & 1024) != 0) {
         var12 = var0.mcuFirmware;
      }

      if ((var27 & 2048) != 0) {
         var13 = var0.wifiFirmware;
      }

      if ((var27 & 4096) != 0) {
         var14 = var0.hardware;
      }

      if ((var27 & 8192) != 0) {
         var15 = var0.timeZone;
      }

      if ((var27 & 16384) != 0) {
         var16 = var0.serial;
      }

      if ((var27 & '耀') != 0) {
         var17 = var0.purchaseDate;
      }

      if ((var27 & 65536) != 0) {
         var18 = var0.dealerName;
      }

      if ((var27 & 131072) != 0) {
         var19 = var0.dealerCountry;
      }

      if ((var27 & 262144) != 0) {
         var20 = var0.pm1Ranges;
      }

      if ((var27 & 524288) != 0) {
         var21 = var0.pm10Ranges;
      }

      if ((var27 & 1048576) != 0) {
         var22 = var0.pm25Ranges;
      }

      if ((var27 & 2097152) != 0) {
         var23 = var0.vocRanges;
      }

      if ((var27 & 4194304) != 0) {
         var24 = var0.hchoRanges;
      }

      if ((var27 & 8388608) != 0) {
         var25 = var0.updateProgress;
      }

      if ((var27 & 16777216) != 0) {
         var26 = var0.compatibility;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26);
   }

   public double[] airRatingsFor(SensorType var1) {
      return HasSensorData$_CC.$default$airRatingsFor(this, var1);
   }

   public IndoorAirRatingRanges.IndoorAirRating aqiFor(double var1, SensorType var3) {
      return HasSensorData$_CC.$default$aqiFor(this, var1, var3);
   }

   public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType var1) {
      return HasSensorData$_CC.$default$aqiFor(this, var1);
   }

   public final String component1() {
      return this.uid;
   }

   public final String component10() {
      return this.mac;
   }

   public final String component11() {
      return this.mcuFirmware;
   }

   public final String component12() {
      return this.wifiFirmware;
   }

   public final String component13() {
      return this.hardware;
   }

   public final String component14() {
      return this.timeZone;
   }

   public final String component15() {
      return this.serial;
   }

   public final String component16() {
      return this.purchaseDate;
   }

   public final String component17() {
      return this.dealerName;
   }

   public final String component18() {
      return this.dealerCountry;
   }

   public final double[] component19() {
      return this.pm1Ranges;
   }

   public final String component2() {
      return this.name;
   }

   public final double[] component20() {
      return this.pm10Ranges;
   }

   public final double[] component21() {
      return this.pm25Ranges;
   }

   public final double[] component22() {
      return this.vocRanges;
   }

   public final double[] component23() {
      return this.hchoRanges;
   }

   public final int component24() {
      return this.updateProgress;
   }

   public final String component25() {
      return this.compatibility;
   }

   public final int component3() {
      return this.brightness;
   }

   public final String component4() {
      return this.info;
   }

   public final IndoorDatapoint component5() {
      return this.latestSensorDatapoint;
   }

   public final int component6() {
      return this.lastSelectedSensorTypeIndex;
   }

   public final boolean component7() {
      return this.isNightmodeOn;
   }

   public final int component8() {
      return this.connectivityStatusIndex;
   }

   public final long component9() {
      return this.lastConnectivityInMillis;
   }

   public final DeviceAware copy(String var1, String var2, int var3, String var4, IndoorDatapoint var5, int var6, boolean var7, int var8, long var9, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, double[] var20, double[] var21, double[] var22, double[] var23, double[] var24, int var25, String var26) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var11, "mac");
      Intrinsics.checkNotNullParameter(var12, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var13, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var14, "hardware");
      Intrinsics.checkNotNullParameter(var15, "timeZone");
      Intrinsics.checkNotNullParameter(var16, "serial");
      Intrinsics.checkNotNullParameter(var17, "purchaseDate");
      Intrinsics.checkNotNullParameter(var18, "dealerName");
      Intrinsics.checkNotNullParameter(var19, "dealerCountry");
      Intrinsics.checkNotNullParameter(var20, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var21, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var22, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var23, "vocRanges");
      Intrinsics.checkNotNullParameter(var24, "hchoRanges");
      return new DeviceAware(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceAware)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.brightness != var1.brightness) {
            return false;
         } else if (!Intrinsics.areEqual(this.info, var1.info)) {
            return false;
         } else if (!Intrinsics.areEqual(this.latestSensorDatapoint, var1.latestSensorDatapoint)) {
            return false;
         } else if (this.lastSelectedSensorTypeIndex != var1.lastSelectedSensorTypeIndex) {
            return false;
         } else if (this.isNightmodeOn != var1.isNightmodeOn) {
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
         } else if (!Intrinsics.areEqual(this.pm1Ranges, var1.pm1Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm10Ranges, var1.pm10Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm25Ranges, var1.pm25Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.vocRanges, var1.vocRanges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hchoRanges, var1.hchoRanges)) {
            return false;
         } else if (this.updateProgress != var1.updateProgress) {
            return false;
         } else {
            return Intrinsics.areEqual(this.compatibility, var1.compatibility);
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
   }

   public int getBrightness() {
      return this.brightness;
   }

   public Brightness getBrightnessEnum() {
      return HasBrightness$_CC.$default$getBrightnessEnum(this);
   }

   public String getCompatibility() {
      return this.compatibility;
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

   public boolean getHasAtLeastMinimumFirmwareVersion() {
      return AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(this, "1.4.0");
   }

   public double[] getHchoRanges() {
      return this.hchoRanges;
   }

   public String getInfo() {
      return this.info;
   }

   public long getLastConnectivityInMillis() {
      return this.lastConnectivityInMillis;
   }

   public SensorType getLastSelectedSensorType() {
      return HasSensorData$_CC.$default$getLastSelectedSensorType(this);
   }

   public int getLastSelectedSensorTypeIndex() {
      return this.lastSelectedSensorTypeIndex;
   }

   public IndoorDatapoint getLatestSensorDatapoint() {
      return this.latestSensorDatapoint;
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

   public double[] getPm10Ranges() {
      return this.pm10Ranges;
   }

   public double[] getPm1Ranges() {
      return this.pm1Ranges;
   }

   public double[] getPm25Ranges() {
      return this.pm25Ranges;
   }

   public String getPurchaseDate() {
      return this.purchaseDate;
   }

   public String getSerial() {
      return this.serial;
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

   public double[] getVocRanges() {
      return this.vocRanges;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var5 = this.uid.hashCode();
      int var4 = this.name.hashCode();
      int var6 = this.brightness;
      String var26 = this.info;
      int var3 = 0;
      int var1;
      if (var26 == null) {
         var1 = 0;
      } else {
         var1 = var26.hashCode();
      }

      IndoorDatapoint var27 = this.latestSensorDatapoint;
      int var2;
      if (var27 == null) {
         var2 = 0;
      } else {
         var2 = var27.hashCode();
      }

      int var19 = this.lastSelectedSensorTypeIndex;
      int var16 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn);
      int var21 = this.connectivityStatusIndex;
      int var22 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var20 = this.mac.hashCode();
      int var7 = this.mcuFirmware.hashCode();
      int var18 = this.wifiFirmware.hashCode();
      int var17 = this.hardware.hashCode();
      int var8 = this.timeZone.hashCode();
      int var23 = this.serial.hashCode();
      int var14 = this.purchaseDate.hashCode();
      int var25 = this.dealerName.hashCode();
      int var10 = this.dealerCountry.hashCode();
      int var11 = Arrays.hashCode(this.pm1Ranges);
      int var15 = Arrays.hashCode(this.pm10Ranges);
      int var24 = Arrays.hashCode(this.pm25Ranges);
      int var12 = Arrays.hashCode(this.vocRanges);
      int var13 = Arrays.hashCode(this.hchoRanges);
      int var9 = this.updateProgress;
      String var28 = this.compatibility;
      if (var28 != null) {
         var3 = var28.hashCode();
      }

      return (((((((((((((((((((((((var5 * 31 + var4) * 31 + var6) * 31 + var1) * 31 + var2) * 31 + var19) * 31 + var16) * 31 + var21) * 31 + var22) * 31 + var20) * 31 + var7) * 31 + var18) * 31 + var17) * 31 + var8) * 31 + var23) * 31 + var14) * 31 + var25) * 31 + var10) * 31 + var11) * 31 + var15) * 31 + var24) * 31 + var12) * 31 + var13) * 31 + var9) * 31 + var3;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isNightmodeOn() {
      return this.isNightmodeOn;
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

   public boolean supports(SensorType var1) {
      return HasSensorData$_CC.$default$supports(this, var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceAware(uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(", info=");
      var1.append(this.info);
      var1.append(", latestSensorDatapoint=");
      var1.append(this.latestSensorDatapoint);
      var1.append(", lastSelectedSensorTypeIndex=");
      var1.append(this.lastSelectedSensorTypeIndex);
      var1.append(", isNightmodeOn=");
      var1.append(this.isNightmodeOn);
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
      var1.append(", pm1Ranges=");
      var1.append(Arrays.toString(this.pm1Ranges));
      var1.append(", pm10Ranges=");
      var1.append(Arrays.toString(this.pm10Ranges));
      var1.append(", pm25Ranges=");
      var1.append(Arrays.toString(this.pm25Ranges));
      var1.append(", vocRanges=");
      var1.append(Arrays.toString(this.vocRanges));
      var1.append(", hchoRanges=");
      var1.append(Arrays.toString(this.hchoRanges));
      var1.append(", updateProgress=");
      var1.append(this.updateProgress);
      var1.append(", compatibility=");
      var1.append(this.compatibility);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.uid);
      var1.writeString(this.name);
      var1.writeInt(this.brightness);
      var1.writeString(this.info);
      IndoorDatapoint var3 = this.latestSensorDatapoint;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var3.writeToParcel(var1, var2);
      }

      var1.writeInt(this.lastSelectedSensorTypeIndex);
      var1.writeInt(this.isNightmodeOn);
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
      var1.writeDoubleArray(this.pm1Ranges);
      var1.writeDoubleArray(this.pm10Ranges);
      var1.writeDoubleArray(this.pm25Ranges);
      var1.writeDoubleArray(this.vocRanges);
      var1.writeDoubleArray(this.hchoRanges);
      var1.writeInt(this.updateProgress);
      var1.writeString(this.compatibility);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceAware createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var8 = var1.readString();
         String var6 = var1.readString();
         int var3 = var1.readInt();
         String var7 = var1.readString();
         Object var5;
         if (var1.readInt() == 0) {
            var5 = null;
         } else {
            var5 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var9 = (IndoorDatapoint)var5;
         int var2 = var1.readInt();
         boolean var4;
         if (var1.readInt() != 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         return new DeviceAware(var8, var6, var3, var7, var9, var2, var4, var1.readInt(), var1.readLong(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.createDoubleArray(), var1.createDoubleArray(), var1.createDoubleArray(), var1.createDoubleArray(), var1.createDoubleArray(), var1.readInt(), var1.readString());
      }

      public final DeviceAware[] newArray(int var1) {
         return new DeviceAware[var1];
      }
   }
}
