package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.AblWifFirmwareUtils;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\bR\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nBÿ\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\b\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\t\u0010S\u001a\u00020\u000fHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010V\u001a\u00020\u0015HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010X\u001a\u00020\u0015HÆ\u0003J\t\u0010Y\u001a\u00020\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\u001aHÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\fHÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\t\u0010b\u001a\u00020\fHÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\t\u0010e\u001a\u00020\fHÆ\u0003J\t\u0010f\u001a\u00020\u000fHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0090\u0002\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010iJ\u0006\u0010j\u001a\u00020\u000fJ\u0013\u0010k\u001a\u00020\u00152\b\u0010l\u001a\u0004\u0018\u00010mHÖ\u0003J\t\u0010n\u001a\u00020\u000fHÖ\u0001J\t\u0010o\u001a\u00020\fHÖ\u0001J\u0016\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u000fR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\r\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0014\u0010\u0011\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0014\u0010\u0012\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00105R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010+\"\u0004\b7\u00108R\u0014\u0010\u0017\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00105R\u0014\u0010\u0018\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010\u001b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0014\u0010\u001c\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0014\u0010\u001d\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0014\u0010\u001e\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0014\u0010\u001f\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0014\u0010 \u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0014\u0010!\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0014\u0010\"\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0014\u0010#\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0014\u0010$\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0014\u0010%\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0014\u0010&\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0016\u0010'\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010+R\u0014\u0010I\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0014\u0010K\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R\u0014\u0010M\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00105¨\u0006u"},
   d2 = {"Lcom/blueair/core/model/DeviceSense;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasLinkingCapability;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "isChildLockOn", "", "linkedToUid", "isNightmodeOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "updateProgress", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "()Z", "getLinkedToUid", "setLinkedToUid", "(Ljava/lang/String;)V", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getUpdateProgress", "getCompatibility", "modelName", "getModelName", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/blueair/core/model/DeviceSense;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSense implements Device, HasFanSpeed, HasBrightness, HasInfo, HasNightMode, HasAblCloudFunctions, HasChildLock, HasLinkingCapability, HasScheduling, HasCompatibility {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final String autoModeText;
   private final int brightness;
   private final String compatibility;
   private final int connectivityStatusIndex;
   private final String dealerCountry;
   private final String dealerName;
   private final int fanSpeed;
   private final Integer filterLife;
   private final String filterTrigger;
   private final String filterType;
   private final String hardware;
   private final String info;
   private final boolean isChildLockOn;
   private final boolean isNightmodeOn;
   private final long lastConnectivityInMillis;
   private String linkedToUid;
   private final String mac;
   private final String mcuFirmware;
   private final String modelName;
   private final String name;
   private final String purchaseDate;
   private final String serial;
   private final String timeZone;
   private final int typeIndex;
   private final String uid;
   private final int updateProgress;
   private final String wifiFirmware;

   public DeviceSense(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, boolean var8, String var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, String var26) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var14, "mac");
      Intrinsics.checkNotNullParameter(var15, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var16, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var17, "hardware");
      Intrinsics.checkNotNullParameter(var18, "timeZone");
      Intrinsics.checkNotNullParameter(var19, "serial");
      Intrinsics.checkNotNullParameter(var20, "purchaseDate");
      Intrinsics.checkNotNullParameter(var21, "dealerName");
      Intrinsics.checkNotNullParameter(var22, "dealerCountry");
      Intrinsics.checkNotNullParameter(var23, "filterType");
      Intrinsics.checkNotNullParameter(var24, "filterTrigger");
      super();
      this.uid = var1;
      this.name = var2;
      this.fanSpeed = var3;
      this.filterLife = var4;
      this.brightness = var5;
      this.autoModeText = var6;
      this.info = var7;
      this.isChildLockOn = var8;
      this.linkedToUid = var9;
      this.isNightmodeOn = var10;
      this.connectivityStatusIndex = var11;
      this.lastConnectivityInMillis = var12;
      this.mac = var14;
      this.mcuFirmware = var15;
      this.wifiFirmware = var16;
      this.hardware = var17;
      this.timeZone = var18;
      this.serial = var19;
      this.purchaseDate = var20;
      this.dealerName = var21;
      this.dealerCountry = var22;
      this.filterType = var23;
      this.filterTrigger = var24;
      this.updateProgress = var25;
      this.compatibility = var26;
      this.modelName = DeviceType.Sense.INSTANCE.getName();
      this.typeIndex = DeviceType.Sense.INSTANCE.getIndex();
   }

   // $FF: synthetic method
   public DeviceSense(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, boolean var8, String var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, String var26, int var27, DefaultConstructorMarker var28) {
      if ((var27 & 4) != 0) {
         var3 = 0;
      }

      if ((var27 & 8) != 0) {
         var4 = null;
      }

      if ((var27 & 16) != 0) {
         var5 = 0;
      }

      if ((var27 & 32) != 0) {
         var6 = "";
      }

      if ((var27 & 128) != 0) {
         var8 = false;
      }

      if ((var27 & 256) != 0) {
         var9 = null;
      }

      if ((var27 & 1024) != 0) {
         var11 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var27 & 2048) != 0) {
         var12 = 0L;
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
         var20 = "";
      }

      if ((524288 & var27) != 0) {
         var21 = "";
      }

      if ((1048576 & var27) != 0) {
         var22 = "";
      }

      if ((2097152 & var27) != 0) {
         var23 = "";
      }

      if ((4194304 & var27) != 0) {
         var24 = "";
      }

      if ((var27 & 8388608) != 0) {
         var25 = 0;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26);
   }

   // $FF: synthetic method
   public static DeviceSense copy$default(DeviceSense var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, boolean var8, String var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, String var26, int var27, Object var28) {
      if ((var27 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var27 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var27 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var27 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var27 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var27 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var27 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var27 & 128) != 0) {
         var8 = var0.isChildLockOn;
      }

      if ((var27 & 256) != 0) {
         var9 = var0.linkedToUid;
      }

      if ((var27 & 512) != 0) {
         var10 = var0.isNightmodeOn;
      }

      if ((var27 & 1024) != 0) {
         var11 = var0.connectivityStatusIndex;
      }

      if ((var27 & 2048) != 0) {
         var12 = var0.lastConnectivityInMillis;
      }

      if ((var27 & 4096) != 0) {
         var14 = var0.mac;
      }

      if ((var27 & 8192) != 0) {
         var15 = var0.mcuFirmware;
      }

      if ((var27 & 16384) != 0) {
         var16 = var0.wifiFirmware;
      }

      if ((var27 & '耀') != 0) {
         var17 = var0.hardware;
      }

      if ((var27 & 65536) != 0) {
         var18 = var0.timeZone;
      }

      if ((var27 & 131072) != 0) {
         var19 = var0.serial;
      }

      if ((var27 & 262144) != 0) {
         var20 = var0.purchaseDate;
      }

      if ((var27 & 524288) != 0) {
         var21 = var0.dealerName;
      }

      if ((var27 & 1048576) != 0) {
         var22 = var0.dealerCountry;
      }

      if ((var27 & 2097152) != 0) {
         var23 = var0.filterType;
      }

      if ((var27 & 4194304) != 0) {
         var24 = var0.filterTrigger;
      }

      if ((var27 & 8388608) != 0) {
         var25 = var0.updateProgress;
      }

      if ((var27 & 16777216) != 0) {
         var26 = var0.compatibility;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26);
   }

   public final String component1() {
      return this.uid;
   }

   public final boolean component10() {
      return this.isNightmodeOn;
   }

   public final int component11() {
      return this.connectivityStatusIndex;
   }

   public final long component12() {
      return this.lastConnectivityInMillis;
   }

   public final String component13() {
      return this.mac;
   }

   public final String component14() {
      return this.mcuFirmware;
   }

   public final String component15() {
      return this.wifiFirmware;
   }

   public final String component16() {
      return this.hardware;
   }

   public final String component17() {
      return this.timeZone;
   }

   public final String component18() {
      return this.serial;
   }

   public final String component19() {
      return this.purchaseDate;
   }

   public final String component2() {
      return this.name;
   }

   public final String component20() {
      return this.dealerName;
   }

   public final String component21() {
      return this.dealerCountry;
   }

   public final String component22() {
      return this.filterType;
   }

   public final String component23() {
      return this.filterTrigger;
   }

   public final int component24() {
      return this.updateProgress;
   }

   public final String component25() {
      return this.compatibility;
   }

   public final int component3() {
      return this.fanSpeed;
   }

   public final Integer component4() {
      return this.filterLife;
   }

   public final int component5() {
      return this.brightness;
   }

   public final String component6() {
      return this.autoModeText;
   }

   public final String component7() {
      return this.info;
   }

   public final boolean component8() {
      return this.isChildLockOn;
   }

   public final String component9() {
      return this.linkedToUid;
   }

   public final DeviceSense copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, boolean var8, String var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, String var26) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var14, "mac");
      Intrinsics.checkNotNullParameter(var15, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var16, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var17, "hardware");
      Intrinsics.checkNotNullParameter(var18, "timeZone");
      Intrinsics.checkNotNullParameter(var19, "serial");
      Intrinsics.checkNotNullParameter(var20, "purchaseDate");
      Intrinsics.checkNotNullParameter(var21, "dealerName");
      Intrinsics.checkNotNullParameter(var22, "dealerCountry");
      Intrinsics.checkNotNullParameter(var23, "filterType");
      Intrinsics.checkNotNullParameter(var24, "filterTrigger");
      return new DeviceSense(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceSense)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.fanSpeed != var1.fanSpeed) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterLife, var1.filterLife)) {
            return false;
         } else if (this.brightness != var1.brightness) {
            return false;
         } else if (!Intrinsics.areEqual(this.autoModeText, var1.autoModeText)) {
            return false;
         } else if (!Intrinsics.areEqual(this.info, var1.info)) {
            return false;
         } else if (this.isChildLockOn != var1.isChildLockOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkedToUid, var1.linkedToUid)) {
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
         } else if (!Intrinsics.areEqual(this.filterType, var1.filterType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterTrigger, var1.filterTrigger)) {
            return false;
         } else if (this.updateProgress != var1.updateProgress) {
            return false;
         } else {
            return Intrinsics.areEqual(this.compatibility, var1.compatibility);
         }
      }
   }

   public AutoMode getAutoMode() {
      return HasFanSpeed$_CC.$default$getAutoMode(this);
   }

   public String getAutoModeText() {
      return this.autoModeText;
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

   public int getFanSpeed() {
      return this.fanSpeed;
   }

   public FanSpeedEnum getFanSpeedEnum() {
      return HasFanSpeed$_CC.$default$getFanSpeedEnum(this);
   }

   public Filter getFilter() {
      return HasFanSpeed$_CC.$default$getFilter(this);
   }

   public Integer getFilterLife() {
      return this.filterLife;
   }

   public String getFilterTrigger() {
      return this.filterTrigger;
   }

   public String getFilterType() {
      return this.filterType;
   }

   public String getHardware() {
      return this.hardware;
   }

   public boolean getHasAtLeastMinimumFirmwareVersion() {
      return AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(this, "1.4.0");
   }

   public boolean getHasGear0() {
      return HasFanSpeed$_CC.$default$getHasGear0(this);
   }

   public boolean getHasGear4() {
      return HasFanSpeed$_CC.$default$getHasGear4(this);
   }

   public String getInfo() {
      return this.info;
   }

   public long getLastConnectivityInMillis() {
      return this.lastConnectivityInMillis;
   }

   public String getLinkedToUid() {
      return this.linkedToUid;
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

   public String getTimeZone() {
      return this.timeZone;
   }

   public TimeZone getTimezone(Context var1) {
      return Device$_CC.$default$getTimezone(this, var1);
   }

   public FilterTrigger getTrigger() {
      return HasFanSpeed$_CC.$default$getTrigger(this);
   }

   public DeviceType getType() {
      return Device$_CC.$default$getType(this);
   }

   public int getTypeIndex() {
      return this.typeIndex;
   }

   public UiAutoMode getUiAutoMode() {
      return HasFanSpeed$_CC.$default$getUiAutoMode(this);
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
      int var6 = this.uid.hashCode();
      int var5 = this.name.hashCode();
      int var7 = this.fanSpeed;
      Integer var26 = this.filterLife;
      int var4 = 0;
      int var1;
      if (var26 == null) {
         var1 = 0;
      } else {
         var1 = var26.hashCode();
      }

      int var9 = this.brightness;
      int var8 = this.autoModeText.hashCode();
      String var27 = this.info;
      int var2;
      if (var27 == null) {
         var2 = 0;
      } else {
         var2 = var27.hashCode();
      }

      int var10 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      var27 = this.linkedToUid;
      int var3;
      if (var27 == null) {
         var3 = 0;
      } else {
         var3 = var27.hashCode();
      }

      int var13 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn);
      int var19 = this.connectivityStatusIndex;
      int var17 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var11 = this.mac.hashCode();
      int var15 = this.mcuFirmware.hashCode();
      int var20 = this.wifiFirmware.hashCode();
      int var24 = this.hardware.hashCode();
      int var23 = this.timeZone.hashCode();
      int var12 = this.serial.hashCode();
      int var25 = this.purchaseDate.hashCode();
      int var14 = this.dealerName.hashCode();
      int var22 = this.dealerCountry.hashCode();
      int var16 = this.filterType.hashCode();
      int var18 = this.filterTrigger.hashCode();
      int var21 = this.updateProgress;
      var27 = this.compatibility;
      if (var27 != null) {
         var4 = var27.hashCode();
      }

      return (((((((((((((((((((((((var6 * 31 + var5) * 31 + var7) * 31 + var1) * 31 + var9) * 31 + var8) * 31 + var2) * 31 + var10) * 31 + var3) * 31 + var13) * 31 + var19) * 31 + var17) * 31 + var11) * 31 + var15) * 31 + var20) * 31 + var24) * 31 + var23) * 31 + var12) * 31 + var25) * 31 + var14) * 31 + var22) * 31 + var16) * 31 + var18) * 31 + var21) * 31 + var4;
   }

   public boolean isChildLockOn() {
      return this.isChildLockOn;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isLinked() {
      return HasLinkingCapability$_CC.$default$isLinked(this);
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

   public void setLinkedToUid(String var1) {
      this.linkedToUid = var1;
   }

   public boolean supportResetFilterOnline() {
      return Device$_CC.$default$supportResetFilterOnline(this);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceSense(uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", fanSpeed=");
      var1.append(this.fanSpeed);
      var1.append(", filterLife=");
      var1.append(this.filterLife);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(", autoModeText=");
      var1.append(this.autoModeText);
      var1.append(", info=");
      var1.append(this.info);
      var1.append(", isChildLockOn=");
      var1.append(this.isChildLockOn);
      var1.append(", linkedToUid=");
      var1.append(this.linkedToUid);
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
      var1.append(", filterType=");
      var1.append(this.filterType);
      var1.append(", filterTrigger=");
      var1.append(this.filterTrigger);
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
      var1.writeInt(this.fanSpeed);
      Integer var3 = this.filterLife;
      if (var3 == null) {
         var2 = 0;
      } else {
         var1.writeInt(1);
         var2 = var3;
      }

      var1.writeInt(var2);
      var1.writeInt(this.brightness);
      var1.writeString(this.autoModeText);
      var1.writeString(this.info);
      var1.writeInt(this.isChildLockOn);
      var1.writeString(this.linkedToUid);
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
      var1.writeString(this.filterType);
      var1.writeString(this.filterTrigger);
      var1.writeInt(this.updateProgress);
      var1.writeString(this.compatibility);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceSense createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var9 = var1.readString();
         String var8 = var1.readString();
         int var4 = var1.readInt();
         Integer var7;
         if (var1.readInt() == 0) {
            var7 = null;
         } else {
            var7 = var1.readInt();
         }

         int var2 = var1.readInt();
         String var11 = var1.readString();
         String var12 = var1.readString();
         int var3 = var1.readInt();
         boolean var5 = true;
         if (var3 == 0) {
            var5 = false;
         }

         boolean var6 = false;
         String var10 = var1.readString();
         if (var1.readInt() != 0) {
            var6 = true;
         }

         return new DeviceSense(var9, var8, var4, var7, var2, var11, var12, var5, var10, var6, var1.readInt(), var1.readLong(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readInt(), var1.readString());
      }

      public final DeviceSense[] newArray(int var1) {
         return new DeviceSense[var1];
      }
   }
}
