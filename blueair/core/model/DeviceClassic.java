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
   d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b[\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nBÓ\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\f\u0012\b\b\u0002\u0010'\u001a\u00020\f\u0012\b\b\u0002\u0010(\u001a\u00020)\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010+\u001a\u00020)\u0012\b\b\u0002\u0010,\u001a\u00020)\u0012\b\b\u0002\u0010-\u001a\u00020)\u0012\b\b\u0002\u0010.\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020\f\u0012\b\b\u0002\u00100\u001a\u00020\u0018\u0012\b\u00101\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b2\u00103J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\u000fHÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010:J\t\u0010c\u001a\u00020\u000fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010g\u001a\u00020\u000fHÆ\u0003J\t\u0010h\u001a\u00020\u0018HÆ\u0003J\t\u0010i\u001a\u00020\u0018HÆ\u0003J\t\u0010j\u001a\u00020\u000fHÆ\u0003J\t\u0010k\u001a\u00020\u001cHÆ\u0003J\t\u0010l\u001a\u00020\fHÆ\u0003J\t\u0010m\u001a\u00020\fHÆ\u0003J\t\u0010n\u001a\u00020\fHÆ\u0003J\t\u0010o\u001a\u00020\fHÆ\u0003J\t\u0010p\u001a\u00020\fHÆ\u0003J\t\u0010q\u001a\u00020\fHÆ\u0003J\t\u0010r\u001a\u00020\fHÆ\u0003J\t\u0010s\u001a\u00020\fHÆ\u0003J\t\u0010t\u001a\u00020\fHÆ\u0003J\t\u0010u\u001a\u00020\fHÆ\u0003J\t\u0010v\u001a\u00020\fHÆ\u0003J\t\u0010w\u001a\u00020)HÆ\u0003J\t\u0010x\u001a\u00020)HÆ\u0003J\t\u0010y\u001a\u00020)HÆ\u0003J\t\u0010z\u001a\u00020)HÆ\u0003J\t\u0010{\u001a\u00020)HÆ\u0003J\t\u0010|\u001a\u00020\u000fHÆ\u0003J\t\u0010}\u001a\u00020\fHÆ\u0003J\t\u0010~\u001a\u00020\u0018HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\fHÆ\u0003Jâ\u0002\u0010\u0080\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)2\b\b\u0002\u0010,\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020)2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\u00182\n\b\u0002\u00101\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0003\u0010\u0081\u0001J\u0007\u0010\u0082\u0001\u001a\u00020\u000fJ\u0016\u0010\u0083\u0001\u001a\u00020\u00182\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001HÖ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u000fHÖ\u0001J\n\u0010\u0087\u0001\u001a\u00020\fHÖ\u0001J\u001b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u000fR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u0010\r\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0014\u0010\u0011\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u0014\u0010\u0012\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010\u0016\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00108R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010BR\u0014\u0010\u0019\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010BR\u0014\u0010\u001a\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00108R\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010\u001d\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0014\u0010\u001e\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00105R\u0014\u0010\u001f\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00105R\u0014\u0010 \u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00105R\u0014\u0010!\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0014\u0010\"\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0014\u0010#\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00105R\u0014\u0010$\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00105R\u0014\u0010%\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00105R\u0014\u0010&\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00105R\u0014\u0010'\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00105R\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010*\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010RR\u0014\u0010+\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010RR\u0014\u0010,\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010RR\u0014\u0010-\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010RR\u0014\u0010.\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u00108R\u0014\u0010/\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u00105R\u0011\u00100\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bY\u0010BR\u0016\u00101\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u00105R\u0014\u0010[\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u00108R\u0014\u0010]\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010B¨\u0006\u008d\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceClassic;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isNightmodeOn", "", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "modelName", "hasNewSensors", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;ZLjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getModelName", "getHasNewSensors", "getCompatibility", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;ZLjava/lang/String;)Lcom/blueair/core/model/DeviceClassic;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceClassic implements Device, HasFanSpeed, HasBrightness, HasInfo, HasAblCloudFunctions, HasSensorData, HasNightMode, HasChildLock, HasScheduling, HasCompatibility {
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
   private final boolean hasNewSensors;
   private final double[] hchoRanges;
   private final String info;
   private final boolean isChildLockOn;
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

   public DeviceClassic(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, IndoorDatapoint var8, int var9, boolean var10, boolean var11, int var12, long var13, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, double[] var26, double[] var27, double[] var28, double[] var29, double[] var30, int var31, String var32, boolean var33, String var34) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var15, "mac");
      Intrinsics.checkNotNullParameter(var16, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var17, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var18, "hardware");
      Intrinsics.checkNotNullParameter(var19, "timeZone");
      Intrinsics.checkNotNullParameter(var20, "serial");
      Intrinsics.checkNotNullParameter(var21, "purchaseDate");
      Intrinsics.checkNotNullParameter(var22, "dealerName");
      Intrinsics.checkNotNullParameter(var23, "dealerCountry");
      Intrinsics.checkNotNullParameter(var24, "filterType");
      Intrinsics.checkNotNullParameter(var25, "filterTrigger");
      Intrinsics.checkNotNullParameter(var26, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var27, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var28, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var29, "vocRanges");
      Intrinsics.checkNotNullParameter(var30, "hchoRanges");
      Intrinsics.checkNotNullParameter(var32, "modelName");
      super();
      this.uid = var1;
      this.name = var2;
      this.fanSpeed = var3;
      this.filterLife = var4;
      this.brightness = var5;
      this.autoModeText = var6;
      this.info = var7;
      this.latestSensorDatapoint = var8;
      this.lastSelectedSensorTypeIndex = var9;
      this.isNightmodeOn = var10;
      this.isChildLockOn = var11;
      this.connectivityStatusIndex = var12;
      this.lastConnectivityInMillis = var13;
      this.mac = var15;
      this.mcuFirmware = var16;
      this.wifiFirmware = var17;
      this.hardware = var18;
      this.timeZone = var19;
      this.serial = var20;
      this.purchaseDate = var21;
      this.dealerName = var22;
      this.dealerCountry = var23;
      this.filterType = var24;
      this.filterTrigger = var25;
      this.pm1Ranges = var26;
      this.pm10Ranges = var27;
      this.pm25Ranges = var28;
      this.vocRanges = var29;
      this.hchoRanges = var30;
      this.updateProgress = var31;
      this.modelName = var32;
      this.hasNewSensors = var33;
      this.compatibility = var34;
      this.typeIndex = DeviceType.Classic.INSTANCE.getIndex();
   }

   // $FF: synthetic method
   public DeviceClassic(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, IndoorDatapoint var8, int var9, boolean var10, boolean var11, int var12, long var13, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, double[] var26, double[] var27, double[] var28, double[] var29, double[] var30, int var31, String var32, boolean var33, String var34, int var35, int var36, DefaultConstructorMarker var37) {
      if ((var35 & 2) != 0) {
         var2 = "todo";
      }

      if ((var35 & 4) != 0) {
         var3 = 0;
      }

      if ((var35 & 8) != 0) {
         var4 = null;
      }

      if ((var35 & 16) != 0) {
         var5 = 0;
      }

      if ((var35 & 32) != 0) {
         var6 = "";
      }

      if ((var35 & 64) != 0) {
         var7 = null;
      }

      if ((var35 & 128) != 0) {
         var8 = null;
      }

      if ((var35 & 256) != 0) {
         var9 = 0;
      }

      if ((var35 & 512) != 0) {
         var10 = false;
      }

      if ((var35 & 1024) != 0) {
         var11 = false;
      }

      if ((var35 & 2048) != 0) {
         var12 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var35 & 4096) != 0) {
         var13 = 0L;
      }

      if ((var35 & 8192) != 0) {
         var15 = "";
      }

      if ((var35 & 16384) != 0) {
         var16 = "";
      }

      if (('耀' & var35) != 0) {
         var17 = "";
      }

      if ((65536 & var35) != 0) {
         var18 = "";
      }

      if ((131072 & var35) != 0) {
         var19 = "";
      }

      if ((262144 & var35) != 0) {
         var20 = "";
      }

      if ((524288 & var35) != 0) {
         var21 = "";
      }

      if ((1048576 & var35) != 0) {
         var22 = "";
      }

      if ((2097152 & var35) != 0) {
         var23 = "";
      }

      if ((4194304 & var35) != 0) {
         var24 = "";
      }

      if ((8388608 & var35) != 0) {
         var25 = "";
      }

      if ((16777216 & var35) != 0) {
         var26 = new double[0];
      }

      if ((33554432 & var35) != 0) {
         var27 = new double[0];
      }

      if ((67108864 & var35) != 0) {
         var28 = new double[0];
      }

      if ((134217728 & var35) != 0) {
         var29 = new double[0];
      }

      if ((268435456 & var35) != 0) {
         var30 = new double[0];
      }

      if ((536870912 & var35) != 0) {
         var31 = 0;
      }

      if ((var35 & Integer.MIN_VALUE) != 0) {
         var33 = false;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34);
   }

   // $FF: synthetic method
   public static DeviceClassic copy$default(DeviceClassic var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, IndoorDatapoint var8, int var9, boolean var10, boolean var11, int var12, long var13, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, double[] var26, double[] var27, double[] var28, double[] var29, double[] var30, int var31, String var32, boolean var33, String var34, int var35, int var36, Object var37) {
      if ((var35 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var35 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var35 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var35 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var35 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var35 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var35 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var35 & 128) != 0) {
         var8 = var0.latestSensorDatapoint;
      }

      if ((var35 & 256) != 0) {
         var9 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var35 & 512) != 0) {
         var10 = var0.isNightmodeOn;
      }

      if ((var35 & 1024) != 0) {
         var11 = var0.isChildLockOn;
      }

      if ((var35 & 2048) != 0) {
         var12 = var0.connectivityStatusIndex;
      }

      if ((var35 & 4096) != 0) {
         var13 = var0.lastConnectivityInMillis;
      }

      if ((var35 & 8192) != 0) {
         var15 = var0.mac;
      }

      if ((var35 & 16384) != 0) {
         var16 = var0.mcuFirmware;
      }

      if ((var35 & '耀') != 0) {
         var17 = var0.wifiFirmware;
      }

      if ((var35 & 65536) != 0) {
         var18 = var0.hardware;
      }

      if ((var35 & 131072) != 0) {
         var19 = var0.timeZone;
      }

      if ((var35 & 262144) != 0) {
         var20 = var0.serial;
      }

      if ((var35 & 524288) != 0) {
         var21 = var0.purchaseDate;
      }

      if ((var35 & 1048576) != 0) {
         var22 = var0.dealerName;
      }

      if ((var35 & 2097152) != 0) {
         var23 = var0.dealerCountry;
      }

      if ((var35 & 4194304) != 0) {
         var24 = var0.filterType;
      }

      if ((var35 & 8388608) != 0) {
         var25 = var0.filterTrigger;
      }

      if ((var35 & 16777216) != 0) {
         var26 = var0.pm1Ranges;
      }

      if ((var35 & 33554432) != 0) {
         var27 = var0.pm10Ranges;
      }

      if ((var35 & 67108864) != 0) {
         var28 = var0.pm25Ranges;
      }

      if ((var35 & 134217728) != 0) {
         var29 = var0.vocRanges;
      }

      if ((var35 & 268435456) != 0) {
         var30 = var0.hchoRanges;
      }

      if ((var35 & 536870912) != 0) {
         var31 = var0.updateProgress;
      }

      if ((var35 & 1073741824) != 0) {
         var32 = var0.modelName;
      }

      if ((var35 & Integer.MIN_VALUE) != 0) {
         var33 = var0.hasNewSensors;
      }

      if ((var36 & 1) != 0) {
         var34 = var0.compatibility;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34);
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

   public final boolean component10() {
      return this.isNightmodeOn;
   }

   public final boolean component11() {
      return this.isChildLockOn;
   }

   public final int component12() {
      return this.connectivityStatusIndex;
   }

   public final long component13() {
      return this.lastConnectivityInMillis;
   }

   public final String component14() {
      return this.mac;
   }

   public final String component15() {
      return this.mcuFirmware;
   }

   public final String component16() {
      return this.wifiFirmware;
   }

   public final String component17() {
      return this.hardware;
   }

   public final String component18() {
      return this.timeZone;
   }

   public final String component19() {
      return this.serial;
   }

   public final String component2() {
      return this.name;
   }

   public final String component20() {
      return this.purchaseDate;
   }

   public final String component21() {
      return this.dealerName;
   }

   public final String component22() {
      return this.dealerCountry;
   }

   public final String component23() {
      return this.filterType;
   }

   public final String component24() {
      return this.filterTrigger;
   }

   public final double[] component25() {
      return this.pm1Ranges;
   }

   public final double[] component26() {
      return this.pm10Ranges;
   }

   public final double[] component27() {
      return this.pm25Ranges;
   }

   public final double[] component28() {
      return this.vocRanges;
   }

   public final double[] component29() {
      return this.hchoRanges;
   }

   public final int component3() {
      return this.fanSpeed;
   }

   public final int component30() {
      return this.updateProgress;
   }

   public final String component31() {
      return this.modelName;
   }

   public final boolean component32() {
      return this.hasNewSensors;
   }

   public final String component33() {
      return this.compatibility;
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

   public final IndoorDatapoint component8() {
      return this.latestSensorDatapoint;
   }

   public final int component9() {
      return this.lastSelectedSensorTypeIndex;
   }

   public final DeviceClassic copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, IndoorDatapoint var8, int var9, boolean var10, boolean var11, int var12, long var13, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, double[] var26, double[] var27, double[] var28, double[] var29, double[] var30, int var31, String var32, boolean var33, String var34) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var15, "mac");
      Intrinsics.checkNotNullParameter(var16, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var17, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var18, "hardware");
      Intrinsics.checkNotNullParameter(var19, "timeZone");
      Intrinsics.checkNotNullParameter(var20, "serial");
      Intrinsics.checkNotNullParameter(var21, "purchaseDate");
      Intrinsics.checkNotNullParameter(var22, "dealerName");
      Intrinsics.checkNotNullParameter(var23, "dealerCountry");
      Intrinsics.checkNotNullParameter(var24, "filterType");
      Intrinsics.checkNotNullParameter(var25, "filterTrigger");
      Intrinsics.checkNotNullParameter(var26, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var27, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var28, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var29, "vocRanges");
      Intrinsics.checkNotNullParameter(var30, "hchoRanges");
      Intrinsics.checkNotNullParameter(var32, "modelName");
      return new DeviceClassic(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceClassic)) {
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
         } else if (!Intrinsics.areEqual(this.latestSensorDatapoint, var1.latestSensorDatapoint)) {
            return false;
         } else if (this.lastSelectedSensorTypeIndex != var1.lastSelectedSensorTypeIndex) {
            return false;
         } else if (this.isNightmodeOn != var1.isNightmodeOn) {
            return false;
         } else if (this.isChildLockOn != var1.isChildLockOn) {
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
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.hasNewSensors != var1.hasNewSensors) {
            return false;
         } else {
            return Intrinsics.areEqual(this.compatibility, var1.compatibility);
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
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
      return AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(this, "1.1.38");
   }

   public boolean getHasGear0() {
      return HasFanSpeed$_CC.$default$getHasGear0(this);
   }

   public boolean getHasGear4() {
      return HasFanSpeed$_CC.$default$getHasGear4(this);
   }

   public final boolean getHasNewSensors() {
      return this.hasNewSensors;
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

   public double[] getVocRanges() {
      return this.vocRanges;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var7 = this.uid.hashCode();
      int var5 = this.name.hashCode();
      int var6 = this.fanSpeed;
      Integer var34 = this.filterLife;
      int var4 = 0;
      int var1;
      if (var34 == null) {
         var1 = 0;
      } else {
         var1 = var34.hashCode();
      }

      int var8 = this.brightness;
      int var9 = this.autoModeText.hashCode();
      String var35 = this.info;
      int var2;
      if (var35 == null) {
         var2 = 0;
      } else {
         var2 = var35.hashCode();
      }

      IndoorDatapoint var36 = this.latestSensorDatapoint;
      int var3;
      if (var36 == null) {
         var3 = 0;
      } else {
         var3 = var36.hashCode();
      }

      int var15 = this.lastSelectedSensorTypeIndex;
      int var17 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn);
      int var20 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var29 = this.connectivityStatusIndex;
      int var22 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var30 = this.mac.hashCode();
      int var28 = this.mcuFirmware.hashCode();
      int var19 = this.wifiFirmware.hashCode();
      int var16 = this.hardware.hashCode();
      int var11 = this.timeZone.hashCode();
      int var27 = this.serial.hashCode();
      int var25 = this.purchaseDate.hashCode();
      int var24 = this.dealerName.hashCode();
      int var33 = this.dealerCountry.hashCode();
      int var21 = this.filterType.hashCode();
      int var23 = this.filterTrigger.hashCode();
      int var10 = Arrays.hashCode(this.pm1Ranges);
      int var18 = Arrays.hashCode(this.pm10Ranges);
      int var31 = Arrays.hashCode(this.pm25Ranges);
      int var14 = Arrays.hashCode(this.vocRanges);
      int var12 = Arrays.hashCode(this.hchoRanges);
      int var13 = this.updateProgress;
      int var32 = this.modelName.hashCode();
      int var26 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasNewSensors);
      String var37 = this.compatibility;
      if (var37 != null) {
         var4 = var37.hashCode();
      }

      return (((((((((((((((((((((((((((((((var7 * 31 + var5) * 31 + var6) * 31 + var1) * 31 + var8) * 31 + var9) * 31 + var2) * 31 + var3) * 31 + var15) * 31 + var17) * 31 + var20) * 31 + var29) * 31 + var22) * 31 + var30) * 31 + var28) * 31 + var19) * 31 + var16) * 31 + var11) * 31 + var27) * 31 + var25) * 31 + var24) * 31 + var33) * 31 + var21) * 31 + var23) * 31 + var10) * 31 + var18) * 31 + var31) * 31 + var14) * 31 + var12) * 31 + var13) * 31 + var32) * 31 + var26) * 31 + var4;
   }

   public boolean isChildLockOn() {
      return this.isChildLockOn;
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
      StringBuilder var1 = new StringBuilder("DeviceClassic(uid=");
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
      var1.append(", latestSensorDatapoint=");
      var1.append(this.latestSensorDatapoint);
      var1.append(", lastSelectedSensorTypeIndex=");
      var1.append(this.lastSelectedSensorTypeIndex);
      var1.append(", isNightmodeOn=");
      var1.append(this.isNightmodeOn);
      var1.append(", isChildLockOn=");
      var1.append(this.isChildLockOn);
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
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", hasNewSensors=");
      var1.append(this.hasNewSensors);
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
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3);
      }

      var1.writeInt(this.brightness);
      var1.writeString(this.autoModeText);
      var1.writeString(this.info);
      IndoorDatapoint var4 = this.latestSensorDatapoint;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
      }

      var1.writeInt(this.lastSelectedSensorTypeIndex);
      var1.writeInt(this.isNightmodeOn);
      var1.writeInt(this.isChildLockOn);
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
      var1.writeDoubleArray(this.pm1Ranges);
      var1.writeDoubleArray(this.pm10Ranges);
      var1.writeDoubleArray(this.pm25Ranges);
      var1.writeDoubleArray(this.vocRanges);
      var1.writeDoubleArray(this.hchoRanges);
      var1.writeInt(this.updateProgress);
      var1.writeString(this.modelName);
      var1.writeInt(this.hasNewSensors);
      var1.writeString(this.compatibility);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceClassic createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var15 = var1.readString();
         String var14 = var1.readString();
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         Object var13 = null;
         Integer var12;
         if (var3 == 0) {
            var12 = null;
         } else {
            var12 = var1.readInt();
         }

         var3 = var1.readInt();
         String var16 = var1.readString();
         String var17 = var1.readString();
         if (var1.readInt() != 0) {
            var13 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var18 = (IndoorDatapoint)var13;
         int var4 = var1.readInt();
         int var5 = var1.readInt();
         boolean var7 = true;
         boolean var8 = false;
         if (var5 == 0) {
            var7 = false;
         }

         if (var1.readInt() != 0) {
            var8 = true;
         }

         var5 = var1.readInt();
         long var10 = var1.readLong();
         String var24 = var1.readString();
         String var32 = var1.readString();
         String var26 = var1.readString();
         String var21 = var1.readString();
         String var37 = var1.readString();
         String var34 = var1.readString();
         String var20 = var1.readString();
         String var25 = var1.readString();
         String var27 = var1.readString();
         String var22 = var1.readString();
         String var23 = var1.readString();
         double[] var19 = var1.createDoubleArray();
         double[] var33 = var1.createDoubleArray();
         double[] var29 = var1.createDoubleArray();
         double[] var30 = var1.createDoubleArray();
         double[] var28 = var1.createDoubleArray();
         int var6 = var1.readInt();
         boolean var9 = false;
         String var31 = var1.readString();
         if (var1.readInt() != 0) {
            var9 = true;
         }

         return new DeviceClassic(var15, var14, var2, var12, var3, var16, var17, var18, var4, var7, var8, var5, var10, var24, var32, var26, var21, var37, var34, var20, var25, var27, var22, var23, var19, var33, var29, var30, var28, var6, var31, var9, var1.readString());
      }

      public final DeviceClassic[] newArray(int var1) {
         return new DeviceClassic[var1];
      }
   }
}
